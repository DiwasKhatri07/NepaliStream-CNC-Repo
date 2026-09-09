package com.phisher98;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
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
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TorraStream.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 P2\u00020\u0001:\u0001PB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010%\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u0004\u0018\u000101*\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u00104\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010#2\u0006\u00105\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00106J \u00107\u001a\u0004\u0018\u0001082\u0006\u00105\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00106JF\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u001d2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0AH\u0096@¢\u0006\u0002\u0010FJ\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010J\u001a\u00020\u001d2\b\u0010K\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010L\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001e\u0010M\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010OR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006Q"}, d2 = {"Lcom/phisher98/TorraStream;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "getImageUrl", "link", "getOriImageUrl", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/Media;", "type", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "isUpcoming", "dateString", "buildTorrentioApiUrl", "buildMeteorUrl", "baseUrl", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,550:1\n73#2,5:551\n73#2,5:570\n73#2,5:608\n73#2,5:691\n1795#3,10:556\n2068#3:566\n2069#3:568\n1805#3:569\n1795#3,10:575\n2068#3:585\n2069#3:587\n1805#3:588\n1795#3,10:613\n2068#3:623\n2069#3:625\n1805#3:626\n1960#3,3:627\n1795#3,10:630\n2068#3:640\n2069#3:642\n1805#3:643\n1795#3,10:645\n2068#3:655\n2069#3:657\n1805#3:658\n1795#3,10:659\n2068#3:669\n2069#3:671\n1805#3:672\n1795#3,10:673\n2068#3:683\n2069#3:685\n1805#3:686\n1739#3:687\n1814#3,3:688\n777#3:696\n873#3,2:697\n1739#3:700\n1814#3,3:701\n1#4:567\n1#4:586\n1#4:590\n1#4:624\n1#4:641\n1#4:644\n1#4:656\n1#4:670\n1#4:684\n1#4:699\n1#4:705\n1#4:723\n63#5:589\n64#5,15:591\n63#5:704\n64#5,15:706\n50#6:606\n43#6:607\n50#6:721\n43#6:722\n*S KotlinDebug\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream\n*L\n122#1:551,5\n144#1:570,5\n158#1:608,5\n204#1:691,5\n122#1:556,10\n122#1:566\n122#1:568\n122#1:569\n144#1:575,10\n144#1:585\n144#1:587\n144#1:588\n166#1:613,10\n166#1:623\n166#1:625\n166#1:626\n170#1:627,3\n173#1:630,10\n173#1:640\n173#1:642\n173#1:643\n174#1:645,10\n174#1:655\n174#1:657\n174#1:658\n176#1:659,10\n176#1:669\n176#1:671\n176#1:672\n185#1:673,10\n185#1:683\n185#1:685\n185#1:686\n187#1:687\n187#1:688,3\n232#1:696\n232#1:697,2\n238#1:700\n238#1:701,3\n122#1:567\n144#1:586\n151#1:590\n166#1:624\n173#1:641\n174#1:656\n176#1:670\n185#1:684\n348#1:705\n151#1:589\n151#1:591,15\n348#1:704\n348#1:706,15\n151#1:606\n151#1:607\n348#1:721\n348#1:722\n*E\n"})
public final class TorraStream extends TmdbProvider {

    @NotNull
    public static final String AnimetoshoAPI = "https://feed.animetosho.xyz";

    @NotNull
    private static final String Cinemeta = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb";

    @NotNull
    public static final String Knaben = "https://knaben.org";

    @NotNull
    public static final String Meteorfortheweebs = "https://meteorfortheweebs.midnightignite.me";

    @NotNull
    public static final String SubtitlesAPI = "https://opensubtitles-v3.strem.io";

    @NotNull
    public static final String ThePirateBayApi = "https://thepiratebay-plus.strem.fun";

    @NotNull
    public static final String TorrentioAnimeAPI = "https://torrentio.strem.fun/providers=nyaasi,tokyotosho,anidex%7Csort=seeders";

    @NotNull
    public static final String TorrentsDB = "https://torrentsdb.com";

    @NotNull
    public static final String Uindex = "https://uindex.org";

    @NotNull
    private static final String apiKey = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    private static final String tmdbAPI = "https://api.themoviedb.org/3";

    @NotNull
    private final SharedPreferences sharedPref;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> TRACKER_LIST_URL = CollectionsKt.listOf(new String[]{"https://raw.githubusercontent.com/ngosang/trackerslist/refs/heads/master/trackers_best.txt", "https://raw.githubusercontent.com/ngosang/trackerslist/refs/heads/master/trackers_best_ip.txt"});

    @NotNull
    private String name = "TorraStream";

    @NotNull
    private String mainUrl = "https://torrentio.strem.fun";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama, TvType.Torrent});

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(SyncIdName.Trakt);
    private final boolean hasMainPage = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("https://api.themoviedb.org/3/trending/all/day?api_key=1865f43a0549ca50d341dd9ab8b29f49&region=US", "Trending"), TuplesKt.to("https://api.themoviedb.org/3/trending/movie/week?api_key=1865f43a0549ca50d341dd9ab8b29f49&region=US&with_original_language=en", "Popular Movies"), TuplesKt.to("https://api.themoviedb.org/3/trending/tv/week?api_key=1865f43a0549ca50d341dd9ab8b29f49&region=US&with_original_language=en", "Popular TV Shows"), TuplesKt.to("https://api.themoviedb.org/3/tv/airing_today?api_key=1865f43a0549ca50d341dd9ab8b29f49&region=US&with_original_language=en", "Airing Today TV Shows"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=213", "Netflix"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=1024", "Amazon"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=2739", "Disney+"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=453", "Hulu"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=2552", "Apple TV+"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=49", "HBO"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=4330", "Paramount+"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_networks=3353", "Peacock"), TuplesKt.to("https://api.themoviedb.org/3/discover/movie?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US&page=1&sort_by=popularity.desc&with_origin_country=IN&release_date.gte=" + TorraStreamUtilsKt.getDate().getLastWeekStart() + "&release_date.lte=" + TorraStreamUtilsKt.getDate().getToday(), "Trending Indian Movies"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_keywords=210024|222243&sort_by=popularity.desc&air_date.lte=" + TorraStreamUtilsKt.getDate().getToday() + "&air_date.gte=" + TorraStreamUtilsKt.getDate().getToday(), "Airing Today Anime"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_keywords=210024|222243&sort_by=popularity.desc&air_date.lte=" + TorraStreamUtilsKt.getDate().getNextWeek() + "&air_date.gte=" + TorraStreamUtilsKt.getDate().getToday(), "On The Air Anime"), TuplesKt.to("https://api.themoviedb.org/3/discover/movie?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_keywords=210024|222243", "Anime Movies"), TuplesKt.to("https://api.themoviedb.org/3/movie/top_rated?api_key=1865f43a0549ca50d341dd9ab8b29f49&region=US", "Top Rated Movies"), TuplesKt.to("https://api.themoviedb.org/3/tv/top_rated?api_key=1865f43a0549ca50d341dd9ab8b29f49&region=US", "Top Rated TV Shows"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_original_language=ko", "Korean Shows"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=1865f43a0549ca50d341dd9ab8b29f49&with_genres=99", "Documentary")});

    /* JADX INFO: renamed from: com.phisher98.TorraStream$buildMeteorUrl$1 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {485}, m = "buildMeteorUrl", n = {"sharedPref", "baseUrl", "debridProvider", "debridKey", "languagesPref", "limit", "sizeFilter", "$this$buildMeteorUrl_u24lambda_u240"}, nl = {487}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8"}, v = 2)
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
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStream.this.buildMeteorUrl(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$getMainPage$1 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0}, l = {121}, m = "getMainPage", n = {"request", "adultQuery", "type", "page"}, nl = {122}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStream.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$load$1 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {158, 195, 204, 207, 235, 276, 296, 315}, m = "load", n = {"url", "data", "type", "resUrl", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "animeVideos", "jpTitle", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "animeVideos", "jpTitle", "syncMetaData", "animeMetaData", "kitsuid", "subbedList", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag"}, nl = {570, 202, 653, 229, 236, 296, 315, 206}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
            return TorraStream.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$1 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {356, 370, 374, 383, 389, 426}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "$this$loadLinks_u24lambda_u240", "isCasting", "isAnime", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid"}, nl = {356, 371, 380, 389, 426, 427}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
        Object L$2;
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStream.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$quickSearch$1 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0}, l = {139}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStream.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$search$1 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0}, l = {142}, m = "search", n = {"query", "page"}, nl = {144}, s = {"L$0", "I$0"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStream.this.search(null, 0, (Continuation) this);
        }
    }

    public TorraStream(@NotNull SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public void setSupportedTypes(@NotNull Set<? extends TvType> set) {
        this.supportedTypes = set;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public Set<SyncIdName> getSupportedSyncNames() {
        return this.supportedSyncNames;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/phisher98/TorraStream$Companion;", "", "<init>", "()V", "Cinemeta", "", "ThePirateBayApi", "SubtitlesAPI", "AnimetoshoAPI", "TorrentioAnimeAPI", "TRACKER_LIST_URL", "", "getTRACKER_LIST_URL", "()Ljava/util/List;", "Uindex", "Knaben", "TorrentsDB", "Meteorfortheweebs", "tmdbAPI", "apiKey", "getType", "Lcom/lagradost/cloudstream3/TvType;", "t", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<String> getTRACKER_LIST_URL() {
            return TorraStream.TRACKER_LIST_URL;
        }

        @NotNull
        public final TvType getType(@Nullable String t) {
            return Intrinsics.areEqual(t, "movie") ? TvType.Movie : TvType.TvSeries;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getImageUrl(String link) {
        if (link == null) {
            return null;
        }
        return StringsKt.startsWith$default(link, "/", false, 2, (Object) null) ? "https://image.tmdb.org/t/p/original" + link : link;
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
        C00011 c00011;
        MainPageRequest request2;
        String type;
        Object safe;
        Iterable results;
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
                DonationManager.INSTANCE.checkAndShow(getName());
                String adultQuery = MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? "" : "&without_keywords=190370|13059|226161|195669|190370";
                String type2 = StringsKt.contains$default(request.getData(), "/movie", false, 2, (Object) null) ? "movie" : "tv";
                Requests app = MainActivityKt.getApp();
                String str = request.getData() + adultQuery + "&page=" + page;
                c00011.L$0 = request;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(adultQuery);
                c00011.L$2 = type2;
                c00011.I$0 = page;
                c00011.label = 1;
                String type3 = type2;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                type = type3;
                break;
                break;
            case 1:
                int i = c00011.I$0;
                type = (String) c00011.L$2;
                request2 = (MainPageRequest) c00011.L$0;
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

    static /* synthetic */ SearchResponse toSearchResponse$default(TorraStream torraStream, Media media, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return torraStream.toSearchResponse(media, str);
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
        return MainAPIKt.newMovieSearchResponse$default(mainAPI, title, appUtils.toJson(new Data(id, mediaType, null, null, 12, null)), TvType.Movie, false, new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TorraStream.toSearchResponse$lambda$0(this.f$0, $this$toSearchResponse, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(TorraStream this$0, Media $this_toSearchResponse, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.getImageUrl($this_toSearchResponse.getPosterPath()));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($this_toSearchResponse.getVoteAverage()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00181 c00181;
        Object objSearch;
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
                c00181.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00181.label = 1;
                objSearch = search(query, 1, c00181);
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
        C00191 c00191;
        int page2;
        Object safe;
        Iterable results;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuation);
            }
        } else {
            c00191 = new C00191(continuation);
        }
        Object $result = c00191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00191.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = "https://api.themoviedb.org/3/search/multi?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US&query=" + query + "&page=" + page + "&include_adult=" + MainAPI.Companion.getSettingsForProvider().getEnableAdult();
                c00191.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00191.I$0 = page;
                c00191.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00191, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                break;
                break;
            case 1:
                int page3 = c00191.I$0;
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

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x06c0  */
    /* JADX WARN: Code duplicated, block: B:104:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:107:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:112:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:115:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:117:0x06f2  */
    /* JADX WARN: Code duplicated, block: B:120:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:123:0x0707  */
    /* JADX WARN: Code duplicated, block: B:126:0x0723 A[LOOP:9: B:121:0x0701->B:126:0x0723, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:129:0x072c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0735  */
    /* JADX WARN: Code duplicated, block: B:143:0x0789  */
    /* JADX WARN: Code duplicated, block: B:145:0x078e  */
    /* JADX WARN: Code duplicated, block: B:148:0x079a  */
    /* JADX WARN: Code duplicated, block: B:150:0x07a1  */
    /* JADX WARN: Code duplicated, block: B:161:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:164:0x0800  */
    /* JADX WARN: Code duplicated, block: B:218:0x0997  */
    /* JADX WARN: Code duplicated, block: B:223:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:230:0x0a3f  */
    /* JADX WARN: Code duplicated, block: B:232:0x0a56  */
    /* JADX WARN: Code duplicated, block: B:233:0x0a58  */
    /* JADX WARN: Code duplicated, block: B:236:0x0a62  */
    /* JADX WARN: Code duplicated, block: B:237:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:240:0x0a6d  */
    /* JADX WARN: Code duplicated, block: B:241:0x0a72  */
    /* JADX WARN: Code duplicated, block: B:243:0x0a75  */
    /* JADX WARN: Code duplicated, block: B:246:0x0b38 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:247:0x0b39  */
    /* JADX WARN: Code duplicated, block: B:264:0x0b9a  */
    /* JADX WARN: Code duplicated, block: B:266:0x0ba0  */
    /* JADX WARN: Code duplicated, block: B:268:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:269:0x0bab  */
    /* JADX WARN: Code duplicated, block: B:272:0x0c41 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:273:0x0c42  */
    /* JADX WARN: Code duplicated, block: B:276:0x0c65  */
    /* JADX WARN: Code duplicated, block: B:280:0x0cbf  */
    /* JADX WARN: Code duplicated, block: B:284:0x0d2a  */
    /* JADX WARN: Code duplicated, block: B:285:0x0d2c  */
    /* JADX WARN: Code duplicated, block: B:304:0x0d8e  */
    /* JADX WARN: Code duplicated, block: B:307:0x0d9c  */
    /* JADX WARN: Code duplicated, block: B:322:0x0ddd  */
    /* JADX WARN: Code duplicated, block: B:324:0x0de1  */
    /* JADX WARN: Code duplicated, block: B:327:0x0dec  */
    /* JADX WARN: Code duplicated, block: B:330:0x0eba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:331:0x0ebb  */
    /* JADX WARN: Code duplicated, block: B:334:0x0ee5  */
    /* JADX WARN: Code duplicated, block: B:337:0x0ef0  */
    /* JADX WARN: Code duplicated, block: B:341:0x0f18  */
    /* JADX WARN: Code duplicated, block: B:343:0x0f2a  */
    /* JADX WARN: Code duplicated, block: B:350:0x0f4f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:351:0x0f51  */
    /* JADX WARN: Code duplicated, block: B:356:0x0f62  */
    /* JADX WARN: Code duplicated, block: B:358:0x0f66 A[PHI: r39
      0x0f66: PHI (r39v19 java.lang.Integer) = (r39v13 java.lang.Integer), (r39v24 java.lang.Integer) binds: [B:357:0x0f64, B:348:0x0f4c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:359:0x0f6b  */
    /* JADX WARN: Code duplicated, block: B:362:0x0f85  */
    /* JADX WARN: Code duplicated, block: B:363:0x0f8c  */
    /* JADX WARN: Code duplicated, block: B:366:0x0fb3  */
    /* JADX WARN: Code duplicated, block: B:369:0x0fbb  */
    /* JADX WARN: Code duplicated, block: B:370:0x0fbe  */
    /* JADX WARN: Code duplicated, block: B:372:0x0fc2  */
    /* JADX WARN: Code duplicated, block: B:373:0x0fc5  */
    /* JADX WARN: Code duplicated, block: B:375:0x0fc9  */
    /* JADX WARN: Code duplicated, block: B:376:0x0fcc  */
    /* JADX WARN: Code duplicated, block: B:380:0x102c  */
    /* JADX WARN: Code duplicated, block: B:383:0x1133 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:384:0x1134  */
    /* JADX WARN: Code duplicated, block: B:386:0x115a  */
    /* JADX WARN: Code duplicated, block: B:388:0x125d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:389:0x125e  */
    /* JADX WARN: Code duplicated, block: B:391:0x1286  */
    /* JADX WARN: Code duplicated, block: B:393:0x12c0  */
    /* JADX WARN: Code duplicated, block: B:394:0x12c3  */
    /* JADX WARN: Code duplicated, block: B:397:0x12cb  */
    /* JADX WARN: Code duplicated, block: B:398:0x12d2  */
    /* JADX WARN: Code duplicated, block: B:401:0x12eb  */
    /* JADX WARN: Code duplicated, block: B:402:0x12ee  */
    /* JADX WARN: Code duplicated, block: B:405:0x139a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:406:0x139b  */
    /* JADX WARN: Code duplicated, block: B:411:0x13ea  */
    /* JADX WARN: Code duplicated, block: B:453:0x0728 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:454:0x0721 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x0615  */
    /* JADX WARN: Code duplicated, block: B:78:0x063e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0648  */
    /* JADX WARN: Code duplicated, block: B:84:0x0667  */
    /* JADX WARN: Code duplicated, block: B:86:0x067b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0687  */
    /* JADX WARN: Code duplicated, block: B:90:0x0695  */
    /* JADX WARN: Code duplicated, block: B:93:0x0699  */
    /* JADX WARN: Code duplicated, block: B:94:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:97:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:99:0x06b1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r12v42 */
    /* JADX WARN: Type inference failed for: r13v20, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r40v3 */
    /* JADX WARN: Type inference failed for: r6v15, types: [int] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v89 */
    /* JADX WARN: Type inference failed for: r78v0 */
    /* JADX WARN: Type inference failed for: r78v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r78v2 */
    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00021 c00021;
        Object obj;
        Integer num;
        Object objDecodeFromString;
        Integer num2;
        Object obj2;
        Data data;
        TvType tvType;
        String str2;
        String str3;
        Object safe;
        MediaDetail mediaDetail;
        String title;
        String releaseDate;
        Integer intOrNull;
        ArrayList<Genres> genres;
        ArrayList arrayList;
        boolean zContains;
        String str4;
        int i;
        int i2;
        ArrayList<ProductionCountries> production_countries;
        Object obj3;
        int i3;
        KeywordResults keywords;
        int i4;
        Collection collectionEmptyList;
        boolean zIsEmpty;
        Collection collection;
        Credits credits;
        ArrayList<Cast> cast;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str5;
        String lowerCase;
        ?? IsUpcoming;
        List list;
        TvType tvType2;
        Integer num3;
        String str6;
        List list2;
        int i5;
        int i6;
        List list3;
        String str7;
        Object obj4;
        List list4;
        ?? r18;
        String str8;
        MediaDetail mediaDetail2;
        String str9;
        Object obj5;
        String str10;
        String str11;
        int i7;
        Data data2;
        int i8;
        ArrayList<Trailers> results;
        ArrayList<Media> results2;
        KeywordResults keywords2;
        ArrayList<Keywords> keywords3;
        ArrayList<Keywords> results3;
        ArrayList<ProductionCountries> arrayList4;
        Iterator it;
        Iterator it2;
        ArrayList<ProductionCountries> arrayList5;
        ArrayList arrayList6;
        Iterator it3;
        String name;
        ArrayList arrayList7;
        List listSplit$default;
        String str12;
        int i9;
        String str13;
        String type;
        int i10;
        String str14;
        String str15;
        boolean z;
        String str16;
        ExternalIds external_ids;
        String imdb_id;
        List list5;
        Integer num4;
        String str17;
        Data data3;
        List list6;
        List list7;
        String str18;
        List list8;
        String str19;
        String str20;
        ?? r40;
        int i11;
        int i12;
        Object obj6;
        Object obj7;
        MediaDetail mediaDetail3;
        String str21;
        String str22;
        String str23;
        List list9;
        String str24;
        Data data4;
        List list10;
        String str25;
        List list11;
        String str26;
        int i13;
        int i14;
        List list12;
        String str27;
        String str28;
        int i15;
        Integer num5;
        String str29;
        Object obj8;
        TvType tvType3;
        int i16;
        Data data5;
        Object safe2;
        CinemetaRes cinemetaRes;
        int i17;
        String str30;
        String str31;
        String str32;
        List list13;
        String str33;
        int i18;
        Object obj9;
        int i19;
        boolean z2;
        ExternalIds external_ids2;
        String imdb_id2;
        boolean z3;
        String str34;
        List list14;
        List list15;
        List list16;
        Data data6;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        List list17;
        List list18;
        CinemetaRes cinemetaRes2;
        int i20;
        String str41;
        ArrayList<Seasons> seasons;
        Integer num6;
        Object obj10;
        int i21;
        List list19;
        Data data7;
        int i22;
        int i23;
        TvType tvType4;
        int i24;
        String str42;
        String str43;
        String str44;
        int i25;
        boolean z4;
        int i26;
        TvType tvType5;
        String str45;
        Integer num7;
        List list20;
        String str46;
        MediaDetail mediaDetail4;
        String str47;
        int i27;
        String str48;
        String str49;
        String str50;
        int i28;
        List list21;
        int i29;
        Object objAmap;
        Object obj11;
        String str51;
        MediaDetail mediaDetail5;
        Data data8;
        String str52;
        TvType tvType6;
        String str53;
        List list22;
        String str54;
        String str55;
        String str56;
        String str57;
        CinemetaRes cinemetaRes3;
        int i30;
        int i31;
        int i32;
        Object obj12;
        String str58;
        String str59;
        int i33;
        String str60;
        String str61;
        Integer num8;
        List list23;
        CinemetaRes cinemetaRes4;
        List listEmptyList;
        List list24;
        List list25;
        List list26;
        String str62;
        Data data9;
        String str63;
        MediaDetail mediaDetail6;
        String str64;
        String str65;
        List list27;
        Object obj13;
        String str66;
        Object objNewTvSeriesLoadResponse;
        C00021 c00022;
        Object obj14;
        String str67;
        String str68;
        CinemetaRes cinemetaRes5;
        ArrayList arrayListEmptyList;
        ResultsAltTitles alternative_titles;
        List list28;
        Object name2;
        CinemetaRes.Meta meta;
        Object obj15;
        String str69;
        String str70;
        int i34;
        List list29;
        List list30;
        C00021 c00023;
        String str71;
        Data data10;
        List list31;
        int i35;
        int i36;
        List list32;
        int i37;
        CinemetaRes cinemetaRes6;
        int i38;
        MediaDetail mediaDetail7;
        List list33;
        Object obj16;
        Object obj17;
        List list34;
        String str72;
        String str73;
        String str74;
        String str75;
        Integer num9;
        Object obj18;
        String str76;
        ?? r78;
        String str77;
        MediaDetail mediaDetail8;
        List list35;
        CinemetaRes cinemetaRes7;
        String str78;
        int i39;
        int i40;
        List list36;
        List list37;
        ArrayList<AltTitles> results4;
        Object next;
        CinemetaRes.Meta meta2;
        List<CinemetaRes.Meta.Video> videos;
        List list38;
        List listFlatten;
        MetaAnimeData animeData;
        Object kitsuid;
        List list39;
        String str79;
        ArrayList arrayList8;
        List<CinemetaRes.Meta.Video> list40;
        ArrayList arrayList9;
        Object obj19;
        Object objNewAnimeLoadResponse$default;
        String released;
        Integer intOrNull2;
        int iIntValue;
        CinemetaRes.Meta meta3;
        String year;
        ExternalIds external_ids3;
        Integer tvdb_id;
        String releaseDate2;
        boolean z5;
        boolean z6;
        boolean z7;
        List listSplit$default2;
        String str80;
        MetaMappings mappings;
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
        C00021 c00024 = c00021;
        Object objNewMovieLoadResponse = c00024.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00024.label) {
            case 0:
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(Data.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        num = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Data.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        num = null;
                    }
                    break;
                } else {
                    num = null;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = num;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Data>() { // from class: com.phisher98.TorraStream$load$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Data>() { // from class: com.phisher98.TorraStream$load$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Data>() { // from class: com.phisher98.TorraStream$load$$inlined$parseJson$1
                    });
                }
                Data data11 = (Data) objDecodeFromString;
                TvType type2 = INSTANCE.getType(data11.getType());
                String str81 = type2 == TvType.Movie ? "https://api.themoviedb.org/3/movie/" + data11.getId() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=keywords,credits,external_ids,videos,recommendations" : "https://api.themoviedb.org/3/tv/" + data11.getId() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=keywords,credits,external_ids,videos,recommendations";
                Requests app = MainActivityKt.getApp();
                c00024.L$0 = str;
                c00024.L$1 = data11;
                c00024.L$2 = type2;
                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str81);
                c00024.label = 1;
                num2 = num;
                obj2 = Requests.get$default(app, str81, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00024, 4094, (Object) null);
                c00024 = c00024;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data = data11;
                tvType = type2;
                str2 = str81;
                str3 = str;
                NiceResponse niceResponse = (NiceResponse) obj2;
                try {
                    ResponseParser parser = niceResponse.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(niceResponse.getText(), Reflection.getOrCreateKotlinClass(MediaDetail.class));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    safe = num2;
                }
                mediaDetail = (MediaDetail) safe;
                if (mediaDetail != null) {
                    throw new ErrorLoadingException("Invalid Json Response");
                }
                title = mediaDetail.getTitle();
                if (title != null && (title = mediaDetail.getName()) == null) {
                    return num2;
                }
                String oriImageUrl = getOriImageUrl(mediaDetail.getPosterPath());
                String oriImageUrl2 = getOriImageUrl(mediaDetail.getBackdropPath());
                releaseDate = mediaDetail.getReleaseDate();
                if (releaseDate == null) {
                    releaseDate = mediaDetail.getFirstAirDate();
                }
                if (releaseDate != null || (listSplit$default = StringsKt.split$default(releaseDate, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str12 = (String) CollectionsKt.first(listSplit$default)) == null) {
                    intOrNull = num2;
                } else {
                    intOrNull = StringsKt.toIntOrNull(str12);
                }
                Integer num10 = intOrNull;
                genres = mediaDetail.getGenres();
                if (genres != null) {
                    arrayList6 = new ArrayList();
                    it3 = genres.iterator();
                    while (it3.hasNext()) {
                        name = ((Genres) it3.next()).getName();
                        if (name != null) {
                            arrayList7 = arrayList6;
                            arrayList7.add(name);
                        } else {
                            arrayList7 = arrayList6;
                        }
                        arrayList6 = arrayList7;
                    }
                    arrayList = arrayList6;
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    zContains = arrayList.contains("Animation");
                } else {
                    zContains = false;
                }
                if (zContains) {
                    if (!Intrinsics.areEqual(mediaDetail.getOriginal_language(), "zh")) {
                        str4 = str2;
                        if (Intrinsics.areEqual(mediaDetail.getOriginal_language(), "ja")) {
                        }
                        if (i == 0 || !(Intrinsics.areEqual(mediaDetail.getOriginal_language(), "zh") || Intrinsics.areEqual(mediaDetail.getOriginal_language(), "ko"))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        production_countries = mediaDetail.getProduction_countries();
                        if (production_countries != null) {
                            arrayList4 = production_countries;
                            obj3 = coroutine_suspended;
                            if ((arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                                it = arrayList4.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        it2 = it;
                                        arrayList5 = arrayList4;
                                        if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                            i3 = 1;
                                        } else {
                                            it = it2;
                                            arrayList4 = arrayList5;
                                        }
                                    } else {
                                        i3 = 0;
                                    }
                                }
                            } else {
                                i3 = 0;
                            }
                        } else {
                            obj3 = coroutine_suspended;
                            i3 = 0;
                        }
                        keywords = mediaDetail.getKeywords();
                        if (keywords != null || (results3 = keywords.getResults()) == null) {
                            i4 = i3;
                            collectionEmptyList = null;
                        } else {
                            ArrayList<Keywords> arrayList10 = results3;
                            ArrayList arrayList11 = new ArrayList();
                            Iterator it4 = arrayList10.iterator();
                            while (it4.hasNext()) {
                                String name3 = ((Keywords) it4.next()).getName();
                                if (name3 != null) {
                                    arrayList11.add(name3);
                                }
                                i3 = i3;
                            }
                            i4 = i3;
                            collectionEmptyList = arrayList11;
                        }
                        if (collectionEmptyList == null) {
                            collectionEmptyList = CollectionsKt.emptyList();
                        }
                        Collection collection2 = collectionEmptyList;
                        zIsEmpty = collection2.isEmpty();
                        collection = collection2;
                        if (zIsEmpty) {
                            keywords2 = mediaDetail.getKeywords();
                            if (keywords2 != null || (keywords3 = keywords2.getKeywords()) == null) {
                                collection = null;
                            } else {
                                ArrayList<Keywords> arrayList12 = keywords3;
                                ArrayList arrayList13 = new ArrayList();
                                Iterator it5 = arrayList12.iterator();
                                while (it5.hasNext()) {
                                    String name4 = ((Keywords) it5.next()).getName();
                                    if (name4 != null) {
                                        arrayList13.add(name4);
                                    }
                                    arrayList12 = arrayList12;
                                }
                                collection = arrayList13;
                            }
                        }
                        List list41 = (List) collection;
                        credits = mediaDetail.getCredits();
                        if (credits != null || (cast = credits.getCast()) == null) {
                            return null;
                        }
                        ArrayList<Cast> arrayList14 = cast;
                        ArrayList arrayList15 = new ArrayList();
                        for (Cast cast2 : arrayList14) {
                            String name5 = cast2.getName();
                            ActorData actorData = (name5 == null && (name5 = cast2.getOriginalName()) == null) ? null : new ActorData(new Actor(name5, getImageUrl(cast2.getProfilePath())), (ActorRole) null, cast2.getCharacter(), (Actor) null, 10, (DefaultConstructorMarker) null);
                            if (actorData != null) {
                                arrayList15.add(actorData);
                            }
                            i = i;
                            i2 = i2;
                            zContains = zContains;
                        }
                        int i41 = i2;
                        boolean z8 = zContains;
                        int i42 = i;
                        ArrayList arrayList16 = arrayList15;
                        ResultsRecommendations recommendations = mediaDetail.getRecommendations();
                        if (recommendations == null || (results2 = recommendations.getResults()) == null) {
                            arrayList2 = arrayList16;
                            arrayList3 = null;
                        } else {
                            ArrayList<Media> arrayList17 = results2;
                            int i43 = 0;
                            ArrayList arrayList18 = new ArrayList();
                            Iterator it6 = arrayList17.iterator();
                            while (it6.hasNext()) {
                                ArrayList<Media> arrayList19 = arrayList17;
                                ArrayList arrayList20 = arrayList16;
                                int i44 = i43;
                                SearchResponse searchResponse$default = toSearchResponse$default(this, (Media) it6.next(), null, 1, null);
                                if (searchResponse$default != null) {
                                    arrayList18.add(searchResponse$default);
                                }
                                arrayList17 = arrayList19;
                                arrayList16 = arrayList20;
                                i43 = i44;
                            }
                            arrayList2 = arrayList16;
                            arrayList3 = arrayList18;
                        }
                        ResultsTrailer videos2 = mediaDetail.getVideos();
                        if (videos2 == null || (results = videos2.getResults()) == null) {
                            str5 = null;
                        } else {
                            ArrayList<Trailers> arrayList21 = results;
                            ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList21, 10));
                            ArrayList<Trailers> arrayList23 = arrayList21;
                            Iterator it7 = arrayList23.iterator();
                            while (it7.hasNext()) {
                                arrayList22.add("https://www.youtube.com/watch?v=" + ((Trailers) it7.next()).getKey());
                                arrayList23 = arrayList23;
                            }
                            str5 = (String) CollectionsKt.randomOrNull(arrayList22, Random.Default);
                        }
                        String status = mediaDetail.getStatus();
                        if (status != null) {
                            lowerCase = status.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        } else {
                            lowerCase = null;
                        }
                        if (lowerCase != null) {
                            switch (lowerCase) {
                                case "released":
                                    IsUpcoming = 0;
                                    break;
                                case "planned":
                                case "post production":
                                case "in production":
                                    IsUpcoming = 1;
                                    break;
                                default:
                                    IsUpcoming = isUpcoming(releaseDate);
                                    break;
                            }
                        } else {
                            IsUpcoming = isUpcoming(releaseDate);
                        }
                        Integer id = mediaDetail.getId();
                        c00024.L$0 = str3;
                        c00024.L$1 = data;
                        c00024.L$2 = tvType;
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                        c00024.L$4 = mediaDetail;
                        c00024.L$5 = title;
                        c00024.L$6 = oriImageUrl;
                        c00024.L$7 = oriImageUrl2;
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(releaseDate);
                        c00024.L$9 = num10;
                        c00024.L$10 = arrayList;
                        c00024.L$11 = list41;
                        c00024.L$12 = arrayList2;
                        c00024.L$13 = arrayList3;
                        c00024.L$14 = str5;
                        c00024.I$0 = z8 ? 1 : 0;
                        c00024.I$1 = i42;
                        c00024.I$2 = i41;
                        int i45 = i4;
                        c00024.I$3 = i45;
                        c00024.I$4 = IsUpcoming;
                        String str82 = str5;
                        c00024.label = 2;
                        String str83 = title;
                        String str84 = releaseDate;
                        Object objFetchTmdbLogoUrl = TorraStreamUtilsKt.fetchTmdbLogoUrl(tmdbAPI, apiKey, tvType, id, "en", c00024);
                        Object obj20 = obj3;
                        if (objFetchTmdbLogoUrl == obj20) {
                            return obj20;
                        }
                        list = list41;
                        tvType2 = tvType;
                        num3 = num10;
                        str6 = str84;
                        list2 = arrayList2;
                        i5 = i41;
                        i6 = z8 ? 1 : 0;
                        list3 = arrayList;
                        str7 = str82;
                        obj4 = obj20;
                        list4 = arrayList3;
                        r18 = IsUpcoming;
                        str8 = str83;
                        mediaDetail2 = mediaDetail;
                        str9 = str4;
                        obj5 = objFetchTmdbLogoUrl;
                        str10 = oriImageUrl2;
                        str11 = oriImageUrl;
                        i7 = i45;
                        data2 = data;
                        i8 = i42;
                        i9 = i8;
                        str13 = (String) obj5;
                        type = data2.getType();
                        if (type != null) {
                            i10 = i6;
                            str15 = str13;
                            str14 = str7;
                            z = StringsKt.contains(type, "tv", true);
                            if (z) {
                                str16 = "series";
                            } else {
                                str16 = "movie";
                            }
                            external_ids = mediaDetail2.getExternal_ids();
                            if (external_ids != null) {
                                imdb_id = external_ids.getImdb_id();
                            } else {
                                imdb_id = null;
                            }
                            if (imdb_id == null) {
                                imdb_id = "";
                            }
                            list5 = list4;
                            c00024.L$0 = str3;
                            c00024.L$1 = data2;
                            c00024.L$2 = tvType2;
                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                            c00024.L$4 = mediaDetail2;
                            c00024.L$5 = str8;
                            c00024.L$6 = str11;
                            c00024.L$7 = str10;
                            c00024.L$8 = SpillingKt.nullOutSpilledVariable(str6);
                            c00024.L$9 = num3;
                            c00024.L$10 = list3;
                            c00024.L$11 = list;
                            c00024.L$12 = list2;
                            c00024.L$13 = list5;
                            num4 = num3;
                            str17 = str14;
                            c00024.L$14 = str17;
                            data3 = data2;
                            c00024.L$15 = str15;
                            c00024.L$16 = SpillingKt.nullOutSpilledVariable(str16);
                            c00024.L$17 = imdb_id;
                            c00024.I$0 = i10 == true ? 1 : 0 ? 1 : 0;
                            c00024.I$1 = i9;
                            c00024.I$2 = i5;
                            c00024.I$3 = i7;
                            c00024.I$4 = r18 == true ? 1 : 0;
                            c00024.label = 3;
                            list6 = list2;
                            list7 = list;
                            str18 = str15;
                            C00021 c00025 = c00024;
                            list8 = list3;
                            str19 = imdb_id;
                            str20 = str10;
                            r40 = r18;
                            i11 = i7;
                            i12 = i5;
                            obj6 = obj4;
                            obj7 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str16 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4030, (Object) null);
                            c00024 = c00025;
                            if (obj7 == obj6) {
                                return obj6;
                            }
                            mediaDetail3 = mediaDetail2;
                            str21 = str16;
                            str22 = str8;
                            str23 = str11;
                            list9 = list5;
                            str24 = str6;
                            data4 = data3;
                            list10 = list7;
                            str25 = str17;
                            list11 = list8;
                            str26 = str20;
                            i13 = r40 == true ? 1 : 0;
                            i14 = i9;
                            list12 = list6;
                            str27 = str9;
                            str28 = str3;
                            i15 = i12;
                            num5 = num4;
                            str29 = str18;
                            obj8 = obj7;
                            tvType3 = tvType2;
                            i16 = i11;
                            NiceResponse niceResponse2 = (NiceResponse) obj8;
                            try {
                                ResponseParser parser2 = niceResponse2.getParser();
                                Intrinsics.checkNotNull(parser2);
                                data5 = data4;
                                try {
                                    try {
                                        safe2 = parser2.parseSafe(niceResponse2.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        safe2 = null;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                                break;
                            } catch (Exception e5) {
                                e = e5;
                                data5 = data4;
                            }
                            cinemetaRes = (CinemetaRes) safe2;
                            if (tvType3 != TvType.TvSeries) {
                                i17 = i13;
                                List list42 = list11;
                                int i46 = i15;
                                TvType tvType7 = tvType3;
                                String str85 = str22;
                                str30 = str23;
                                str31 = str26;
                                C00021 c00026 = c00024;
                                boolean z9 = i10 == true ? 1 : 0;
                                str32 = str19;
                                list13 = list9;
                                str33 = str25;
                                i18 = i16;
                                obj9 = obj6;
                                i19 = i14;
                                String str86 = str29;
                                MediaDetail mediaDetail9 = mediaDetail3;
                                MainAPI mainAPI = (MainAPI) this;
                                TvType tvType8 = TvType.Movie;
                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                String title2 = mediaDetail9.getTitle();
                                if (i19 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                external_ids2 = mediaDetail9.getExternal_ids();
                                if (external_ids2 != null) {
                                    imdb_id2 = external_ids2.getImdb_id();
                                } else {
                                    imdb_id2 = null;
                                }
                                String json = appUtils2.toJson(new LoadData(title2, num5, z2, imdb_id2, null, null, 48, null));
                                if (i17 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                str34 = str86;
                                list14 = list10;
                                list15 = list12;
                                list16 = list42;
                                C00054 c00054 = new C00054(str30, z3, str31, str34, num5, mediaDetail9, list14, list16, list13, list15, cinemetaRes, str33, null);
                                c00026.L$0 = SpillingKt.nullOutSpilledVariable(str28);
                                c00026.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                                c00026.L$2 = SpillingKt.nullOutSpilledVariable(tvType7);
                                c00026.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                c00026.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail9);
                                c00026.L$5 = SpillingKt.nullOutSpilledVariable(str85);
                                c00026.L$6 = SpillingKt.nullOutSpilledVariable(str30);
                                c00026.L$7 = SpillingKt.nullOutSpilledVariable(str31);
                                c00026.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                                c00026.L$9 = SpillingKt.nullOutSpilledVariable(num5);
                                c00026.L$10 = SpillingKt.nullOutSpilledVariable(list16);
                                c00026.L$11 = SpillingKt.nullOutSpilledVariable(list14);
                                c00026.L$12 = SpillingKt.nullOutSpilledVariable(list15);
                                c00026.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                                c00026.L$14 = SpillingKt.nullOutSpilledVariable(str33);
                                c00026.L$15 = SpillingKt.nullOutSpilledVariable(str34);
                                c00026.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                                c00026.L$17 = SpillingKt.nullOutSpilledVariable(str32);
                                c00026.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                                c00026.I$0 = z9 ? 1 : 0;
                                c00026.I$1 = i19;
                                c00026.I$2 = i46;
                                c00026.I$3 = i18;
                                c00026.I$4 = i17 == true ? 1 : 0;
                                c00026.label = 8;
                                data6 = data5;
                                str35 = str28;
                                str36 = str85;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI, str36, str35, tvType8, json, c00054, c00026);
                                if (objNewMovieLoadResponse == obj9) {
                                    return obj9;
                                }
                                str37 = str21;
                                str38 = str24;
                                str39 = str32;
                                str40 = str31;
                                list17 = list13;
                                list18 = list15;
                                cinemetaRes2 = cinemetaRes;
                                i20 = i17 == true ? 1 : 0;
                                str41 = str33;
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            seasons = mediaDetail3.getSeasons();
                            if (seasons != null) {
                                ArrayList<Seasons> arrayList24 = seasons;
                                i25 = i15;
                                if (i14 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                i26 = i14;
                                num6 = null;
                                Object obj21 = obj6;
                                tvType5 = tvType3;
                                int i47 = i13;
                                boolean z10 = i10 == true ? 1 : 0;
                                str45 = str19;
                                num7 = num5;
                                list20 = list9;
                                str46 = str25;
                                Data data12 = data5;
                                int i48 = i16;
                                mediaDetail4 = mediaDetail3;
                                TorraStream$load$episodes$1 torraStream$load$episodes$1 = new TorraStream$load$episodes$1(data12, this, mediaDetail4, num7, z4, null);
                                c00024.L$0 = str28;
                                c00024.L$1 = data12;
                                c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType5);
                                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                c00024.L$4 = mediaDetail4;
                                c00024.L$5 = str22;
                                c00024.L$6 = str23;
                                c00024.L$7 = str26;
                                c00024.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                                c00024.L$9 = num7;
                                c00024.L$10 = list11;
                                c00024.L$11 = list10;
                                c00024.L$12 = list12;
                                c00024.L$13 = list20;
                                c00024.L$14 = str46;
                                str47 = str29;
                                c00024.L$15 = str47;
                                c00024.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                                c00024.L$17 = str45;
                                c00024.L$18 = cinemetaRes;
                                i27 = z10 ? 1 : 0;
                                c00024.I$0 = i27;
                                str48 = str22;
                                c00024.I$1 = i26;
                                str49 = str23;
                                c00024.I$2 = i25;
                                str50 = str26;
                                i28 = i48;
                                c00024.I$3 = i28;
                                list21 = list11;
                                i29 = i47 == true ? 1 : 0;
                                c00024.I$4 = i29 == true ? 1 : 0;
                                c00024.label = 4;
                                objAmap = ParCollectionsKt.amap(arrayList24, torraStream$load$episodes$1, c00024);
                                obj10 = obj21;
                                if (objAmap == obj10) {
                                    return obj10;
                                }
                                obj11 = objAmap;
                                str51 = str27;
                                mediaDetail5 = mediaDetail4;
                                data8 = data5;
                                str52 = str46;
                                tvType6 = tvType5;
                                i24 = i25;
                                str53 = str48;
                                list22 = list20;
                                str43 = str49;
                                str54 = str47;
                                i22 = i26;
                                str55 = str21;
                                str56 = str45;
                                str57 = str50;
                                cinemetaRes3 = cinemetaRes;
                                list38 = (List) obj11;
                                if (list38 != null || (listFlatten = CollectionsKt.flatten(list38)) == null) {
                                    TvType tvType9 = tvType6;
                                    i10 = i27;
                                    tvType4 = tvType9;
                                    List list43 = list21;
                                    i21 = i29;
                                    list19 = list43;
                                    cinemetaRes = cinemetaRes3;
                                    i23 = i28;
                                    str19 = str56;
                                    str21 = str55;
                                    str29 = str54;
                                    str25 = str52;
                                    list9 = list22;
                                    str44 = str57;
                                    mediaDetail3 = mediaDetail5;
                                    str42 = str53;
                                    str27 = str51;
                                    data7 = data8;
                                    num5 = num7;
                                } else {
                                    MediaDetail mediaDetail10 = mediaDetail5;
                                    str27 = str51;
                                    str63 = str28;
                                    mediaDetail6 = mediaDetail10;
                                    i32 = i22;
                                    i33 = i27;
                                    obj12 = obj10;
                                    list25 = list10;
                                    str60 = str56;
                                    str59 = str55;
                                    str62 = str52;
                                    listEmptyList = listFlatten;
                                    num8 = num7;
                                    i31 = i24;
                                    cinemetaRes4 = cinemetaRes3;
                                    list24 = list21;
                                    str61 = str54;
                                    str58 = str57;
                                    i21 = i29;
                                    list26 = list12;
                                    data9 = data8;
                                    i30 = i28;
                                    list23 = list22;
                                    str64 = str24;
                                    str65 = str43;
                                }
                                list27 = listEmptyList;
                                if (i32 == 0) {
                                    String str87 = str53;
                                    String str88 = str61;
                                    MediaDetail mediaDetail11 = mediaDetail6;
                                    List list44 = list24;
                                    CinemetaRes cinemetaRes8 = cinemetaRes4;
                                    List list45 = list23;
                                    List list46 = list26;
                                    C00021 c00027 = c00024;
                                    String str89 = str62;
                                    int i49 = i21;
                                    int i50 = i31;
                                    obj13 = obj12;
                                    List list47 = list25;
                                    TvType tvType10 = TvType.TvSeries;
                                    String str90 = str63;
                                    String str91 = str60;
                                    String str92 = str65;
                                    str66 = str58;
                                    Integer num11 = num8;
                                    C00043 c00043 = new C00043(str92, str66, str88, num11, mediaDetail11, list47, list44, this, list45, list46, list27, cinemetaRes8, str89, null);
                                    c00027.L$0 = SpillingKt.nullOutSpilledVariable(str90);
                                    c00027.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                                    c00027.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                                    c00027.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                    c00027.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail11);
                                    c00027.L$5 = SpillingKt.nullOutSpilledVariable(str87);
                                    c00027.L$6 = SpillingKt.nullOutSpilledVariable(str92);
                                    c00027.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                                    c00027.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                                    c00027.L$9 = SpillingKt.nullOutSpilledVariable(num11);
                                    c00027.L$10 = SpillingKt.nullOutSpilledVariable(list44);
                                    c00027.L$11 = SpillingKt.nullOutSpilledVariable(list47);
                                    c00027.L$12 = SpillingKt.nullOutSpilledVariable(list46);
                                    c00027.L$13 = SpillingKt.nullOutSpilledVariable(list45);
                                    c00027.L$14 = SpillingKt.nullOutSpilledVariable(str89);
                                    c00027.L$15 = SpillingKt.nullOutSpilledVariable(str88);
                                    c00027.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00027.L$17 = SpillingKt.nullOutSpilledVariable(str91);
                                    c00027.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes8);
                                    c00027.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                                    c00027.I$0 = i33 == true ? 1 : 0;
                                    c00027.I$1 = i32;
                                    c00027.I$2 = i50;
                                    c00027.I$3 = i30;
                                    c00027.I$4 = i49 == true ? 1 : 0;
                                    c00027.label = 7;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str87, str90, tvType10, list27, c00043, c00027);
                                    c00022 = c00027;
                                    if (objNewTvSeriesLoadResponse == obj13) {
                                        return obj13;
                                    }
                                    obj14 = objNewTvSeriesLoadResponse;
                                    str67 = str66;
                                    return (LoadResponse) obj14;
                                }
                                if (cinemetaRes4 != null || (meta2 = cinemetaRes4.getMeta()) == null || (videos = meta2.getVideos()) == null) {
                                    str68 = str61;
                                    cinemetaRes5 = cinemetaRes4;
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                } else {
                                    ArrayList arrayList25 = new ArrayList();
                                    for (Object obj22 : videos) {
                                        CinemetaRes cinemetaRes9 = cinemetaRes4;
                                        Integer season = ((CinemetaRes.Meta.Video) obj22).getSeason();
                                        if (season == null || season.intValue() != 0) {
                                            arrayList25.add(obj22);
                                        }
                                        cinemetaRes4 = cinemetaRes9;
                                        str61 = str61;
                                    }
                                    str68 = str61;
                                    cinemetaRes5 = cinemetaRes4;
                                    arrayListEmptyList = arrayList25;
                                }
                                alternative_titles = mediaDetail6.getAlternative_titles();
                                if (alternative_titles == null && (results4 = alternative_titles.getResults()) != null) {
                                    Iterator it8 = results4.iterator();
                                    while (true) {
                                        if (it8.hasNext()) {
                                            next = it8.next();
                                            Iterator it9 = it8;
                                            list28 = arrayListEmptyList;
                                            if (!Intrinsics.areEqual(((AltTitles) next).getIso_3166_1(), "JP")) {
                                                it8 = it9;
                                                arrayListEmptyList = list28;
                                            }
                                        } else {
                                            list28 = arrayListEmptyList;
                                            next = num6;
                                        }
                                    }
                                    AltTitles altTitles = (AltTitles) next;
                                    if (altTitles == null || (name2 = altTitles.getTitle()) == null) {
                                    }
                                    obj15 = name2;
                                    c00024.L$0 = str63;
                                    c00024.L$1 = data9;
                                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                    c00024.L$4 = mediaDetail6;
                                    c00024.L$5 = str53;
                                    c00024.L$6 = str65;
                                    c00024.L$7 = str58;
                                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                                    c00024.L$9 = num8;
                                    c00024.L$10 = list24;
                                    c00024.L$11 = list25;
                                    c00024.L$12 = list26;
                                    c00024.L$13 = list23;
                                    c00024.L$14 = str62;
                                    str69 = str68;
                                    c00024.L$15 = str69;
                                    str70 = str53;
                                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00024.L$17 = str60;
                                    c00024.L$18 = cinemetaRes5;
                                    c00024.L$19 = list27;
                                    c00024.L$20 = list28;
                                    c00024.L$21 = obj15;
                                    int i51 = i33;
                                    c00024.I$0 = i51 == true ? 1 : 0;
                                    int i52 = i32;
                                    c00024.I$1 = i52;
                                    i34 = i31;
                                    c00024.I$2 = i34;
                                    int i53 = i30;
                                    c00024.I$3 = i53;
                                    c00024.I$4 = i21 == true ? 1 : 0;
                                    c00024.label = 5;
                                    list29 = list23;
                                    list30 = list26;
                                    c00023 = c00024;
                                    str71 = str62;
                                    data10 = data9;
                                    list31 = list25;
                                    i35 = i21;
                                    i36 = i52;
                                    list32 = list27;
                                    i37 = i51 == true ? 1 : 0;
                                    cinemetaRes6 = cinemetaRes5;
                                    i38 = i53;
                                    mediaDetail7 = mediaDetail6;
                                    list33 = list24;
                                    obj16 = obj12;
                                    obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                                    if (obj17 == obj16) {
                                        return obj16;
                                    }
                                    list34 = list30;
                                    str72 = str63;
                                    str73 = str60;
                                    str74 = str65;
                                    str75 = str58;
                                    num9 = num8;
                                    obj18 = obj17;
                                    str76 = str70;
                                    r78 = obj15;
                                    str77 = str69;
                                    mediaDetail8 = mediaDetail7;
                                    list35 = list29;
                                    cinemetaRes7 = cinemetaRes6;
                                    str78 = str71;
                                    i39 = i34;
                                    i40 = i35 == true ? 1 : 0;
                                    list36 = list33;
                                    list37 = list31;
                                    String text = ((NiceResponse) obj18).getText();
                                    animeData = TorraStreamUtilsKt.parseAnimeData(text);
                                    if (animeData != null || (mappings = animeData.getMappings()) == null) {
                                        kitsuid = num6;
                                    } else {
                                        kitsuid = mappings.getKitsuid();
                                    }
                                    String str93 = str74;
                                    list39 = list28;
                                    int i54 = i40;
                                    str79 = str76;
                                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                                    list40 = list39;
                                    for (final CinemetaRes.Meta.Video video : list40) {
                                        List list48 = list39;
                                        released = video.getReleased();
                                        if (released != null || (listSplit$default2 = StringsKt.split$default(released, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str80 = (String) CollectionsKt.firstOrNull(listSplit$default2)) == null || (intOrNull2 = StringsKt.toIntOrNull(str80)) == null) {
                                            if (cinemetaRes7 != null || (meta3 = cinemetaRes7.getMeta()) == null || (year = meta3.getYear()) == null) {
                                                intOrNull2 = num6;
                                            } else {
                                                intOrNull2 = StringsKt.toIntOrNull(year);
                                            }
                                            if (intOrNull2 != null) {
                                                iIntValue = intOrNull2.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                        } else {
                                            iIntValue = intOrNull2.intValue();
                                        }
                                        List list49 = list40;
                                        MainAPI mainAPI2 = (MainAPI) this;
                                        String str94 = str75;
                                        AppUtils appUtils3 = AppUtils.INSTANCE;
                                        Integer id2 = data10.getId();
                                        external_ids3 = mediaDetail8.getExternal_ids();
                                        if (external_ids3 != null) {
                                            tvdb_id = external_ids3.getTvdb_id();
                                        } else {
                                            tvdb_id = num6;
                                        }
                                        String type3 = data10.getType();
                                        Integer season2 = video.getSeason();
                                        Integer episode = video.getEpisode();
                                        Integer numBoxInt = Boxing.boxInt(iIntValue);
                                        String title3 = video.getTitle();
                                        String released2 = video.getReleased();
                                        releaseDate2 = mediaDetail8.getReleaseDate();
                                        if (releaseDate2 == null) {
                                            releaseDate2 = mediaDetail8.getFirstAirDate();
                                        }
                                        String str95 = releaseDate2;
                                        if (i39 != 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        if (i38 != 0) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (i37 != 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        String str96 = str73;
                                        arrayList8.add(MainAPIKt.newEpisode(mainAPI2, appUtils3.toJson(new LinkData(id2, str96, tvdb_id, type3, season2, episode, null, null, null, str79, numBoxInt, "", true, num9, null, title3, r78, released2, str95, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj23) {
                                                return TorraStream.load$lambda$9$0(video, this, (Episode) obj23);
                                            }
                                        }));
                                        list39 = list48;
                                        list40 = list49;
                                        str75 = str94;
                                        str77 = str77;
                                        str73 = str96;
                                    }
                                    String str97 = str75;
                                    String str98 = str77;
                                    String str99 = str73;
                                    arrayList9 = arrayList8;
                                    if (arrayList9.isEmpty()) {
                                        arrayList9 = list32;
                                    }
                                    List list50 = arrayList9;
                                    TvType tvType11 = TvType.Anime;
                                    obj19 = obj16;
                                    int i55 = i39;
                                    C00021 c00028 = c00023;
                                    ?? r13 = kitsuid;
                                    C00032 c00032 = new C00032(list50, str93, str97, str98, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r13, cinemetaRes7, str99, null);
                                    c00028.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                                    c00028.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                                    c00028.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                                    c00028.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                    c00028.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                                    c00028.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                                    c00028.L$6 = SpillingKt.nullOutSpilledVariable(str93);
                                    c00028.L$7 = SpillingKt.nullOutSpilledVariable(str97);
                                    c00028.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                                    c00028.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                                    c00028.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                                    c00028.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                                    c00028.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                                    c00028.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                                    c00028.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                                    c00028.L$15 = SpillingKt.nullOutSpilledVariable(str98);
                                    c00028.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00028.L$17 = SpillingKt.nullOutSpilledVariable(str99);
                                    c00028.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                                    c00028.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                                    c00028.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                                    c00028.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                                    c00028.L$22 = SpillingKt.nullOutSpilledVariable(text);
                                    c00028.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                                    c00028.L$24 = SpillingKt.nullOutSpilledVariable((Object) r13);
                                    c00028.L$25 = SpillingKt.nullOutSpilledVariable(list50);
                                    c00028.I$0 = i37 == true ? 1 : 0;
                                    c00028.I$1 = i36;
                                    c00028.I$2 = i55;
                                    c00028.I$3 = i38;
                                    c00028.I$4 = i54 == true ? 1 : 0;
                                    c00028.label = 6;
                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType11, false, c00032, c00028, 8, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj19) {
                                        return obj19;
                                    }
                                    return objNewAnimeLoadResponse$default;
                                }
                                list28 = arrayListEmptyList;
                                if (cinemetaRes5 != null || (meta = cinemetaRes5.getMeta()) == null) {
                                    name2 = num6;
                                } else {
                                    name2 = meta.getName();
                                }
                                obj15 = name2;
                                c00024.L$0 = str63;
                                c00024.L$1 = data9;
                                c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                c00024.L$4 = mediaDetail6;
                                c00024.L$5 = str53;
                                c00024.L$6 = str65;
                                c00024.L$7 = str58;
                                c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                                c00024.L$9 = num8;
                                c00024.L$10 = list24;
                                c00024.L$11 = list25;
                                c00024.L$12 = list26;
                                c00024.L$13 = list23;
                                c00024.L$14 = str62;
                                str69 = str68;
                                c00024.L$15 = str69;
                                str70 = str53;
                                c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                                c00024.L$17 = str60;
                                c00024.L$18 = cinemetaRes5;
                                c00024.L$19 = list27;
                                c00024.L$20 = list28;
                                c00024.L$21 = obj15;
                                int i56 = i33;
                                c00024.I$0 = i56 == true ? 1 : 0;
                                int i57 = i32;
                                c00024.I$1 = i57;
                                i34 = i31;
                                c00024.I$2 = i34;
                                int i58 = i30;
                                c00024.I$3 = i58;
                                c00024.I$4 = i21 == true ? 1 : 0;
                                c00024.label = 5;
                                list29 = list23;
                                list30 = list26;
                                c00023 = c00024;
                                str71 = str62;
                                data10 = data9;
                                list31 = list25;
                                i35 = i21;
                                i36 = i57;
                                list32 = list27;
                                i37 = i56 == true ? 1 : 0;
                                cinemetaRes6 = cinemetaRes5;
                                i38 = i58;
                                mediaDetail7 = mediaDetail6;
                                list33 = list24;
                                obj16 = obj12;
                                obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                                if (obj17 == obj16) {
                                    return obj16;
                                }
                                list34 = list30;
                                str72 = str63;
                                str73 = str60;
                                str74 = str65;
                                str75 = str58;
                                num9 = num8;
                                obj18 = obj17;
                                str76 = str70;
                                r78 = obj15;
                                str77 = str69;
                                mediaDetail8 = mediaDetail7;
                                list35 = list29;
                                cinemetaRes7 = cinemetaRes6;
                                str78 = str71;
                                i39 = i34;
                                i40 = i35 == true ? 1 : 0;
                                list36 = list33;
                                list37 = list31;
                                String text2 = ((NiceResponse) obj18).getText();
                                animeData = TorraStreamUtilsKt.parseAnimeData(text2);
                                if (animeData != null) {
                                    kitsuid = num6;
                                } else {
                                    kitsuid = num6;
                                }
                                String str910 = str74;
                                list39 = list28;
                                int i59 = i40;
                                str79 = str76;
                                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                                list40 = list39;
                                while (r23.hasNext()) {
                                    List list410 = list39;
                                    released = video.getReleased();
                                    if (released != null) {
                                        if (cinemetaRes7 != null) {
                                            intOrNull2 = num6;
                                        } else {
                                            intOrNull2 = num6;
                                        }
                                        if (intOrNull2 != null) {
                                            iIntValue = intOrNull2.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                    } else {
                                        if (cinemetaRes7 != null) {
                                            intOrNull2 = num6;
                                        } else {
                                            intOrNull2 = num6;
                                        }
                                        if (intOrNull2 != null) {
                                            iIntValue = intOrNull2.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                    }
                                    List list411 = list40;
                                    MainAPI mainAPI3 = (MainAPI) this;
                                    String str911 = str75;
                                    AppUtils appUtils4 = AppUtils.INSTANCE;
                                    Integer id3 = data10.getId();
                                    external_ids3 = mediaDetail8.getExternal_ids();
                                    if (external_ids3 != null) {
                                        tvdb_id = external_ids3.getTvdb_id();
                                    } else {
                                        tvdb_id = num6;
                                    }
                                    String type4 = data10.getType();
                                    Integer season3 = video.getSeason();
                                    Integer episode2 = video.getEpisode();
                                    Integer numBoxInt2 = Boxing.boxInt(iIntValue);
                                    String title4 = video.getTitle();
                                    String released3 = video.getReleased();
                                    releaseDate2 = mediaDetail8.getReleaseDate();
                                    if (releaseDate2 == null) {
                                        releaseDate2 = mediaDetail8.getFirstAirDate();
                                    }
                                    String str912 = releaseDate2;
                                    if (i39 != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (i38 != 0) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (i37 != 0) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    String str913 = str73;
                                    arrayList8.add(MainAPIKt.newEpisode(mainAPI3, appUtils4.toJson(new LinkData(id3, str913, tvdb_id, type4, season3, episode2, null, null, null, str79, numBoxInt2, "", true, num9, null, title4, r78, released3, str912, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj23) {
                                            return TorraStream.load$lambda$9$0(video, this, (Episode) obj23);
                                        }
                                    }));
                                    list39 = list410;
                                    list40 = list411;
                                    str75 = str911;
                                    str77 = str77;
                                    str73 = str913;
                                }
                                String str914 = str75;
                                String str915 = str77;
                                String str916 = str73;
                                arrayList9 = arrayList8;
                                if (arrayList9.isEmpty()) {
                                    arrayList9 = list32;
                                }
                                List list51 = arrayList9;
                                TvType tvType12 = TvType.Anime;
                                obj19 = obj16;
                                int i510 = i39;
                                C00021 c00029 = c00023;
                                ?? r14 = kitsuid;
                                C00032 c00033 = new C00032(list51, str910, str914, str915, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r14, cinemetaRes7, str916, null);
                                c00029.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                                c00029.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                                c00029.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                                c00029.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                c00029.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                                c00029.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                                c00029.L$6 = SpillingKt.nullOutSpilledVariable(str910);
                                c00029.L$7 = SpillingKt.nullOutSpilledVariable(str914);
                                c00029.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                                c00029.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                                c00029.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                                c00029.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                                c00029.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                                c00029.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                                c00029.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                                c00029.L$15 = SpillingKt.nullOutSpilledVariable(str915);
                                c00029.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                                c00029.L$17 = SpillingKt.nullOutSpilledVariable(str916);
                                c00029.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                                c00029.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                                c00029.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                                c00029.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                                c00029.L$22 = SpillingKt.nullOutSpilledVariable(text2);
                                c00029.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                                c00029.L$24 = SpillingKt.nullOutSpilledVariable((Object) r14);
                                c00029.L$25 = SpillingKt.nullOutSpilledVariable(list51);
                                c00029.I$0 = i37 == true ? 1 : 0;
                                c00029.I$1 = i36;
                                c00029.I$2 = i510;
                                c00029.I$3 = i38;
                                c00029.I$4 = i59 == true ? 1 : 0;
                                c00029.label = 6;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType12, false, c00033, c00029, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj19) {
                                    return obj19;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            String str100 = str23;
                            boolean z11 = i10 == true ? 1 : 0;
                            num6 = null;
                            obj10 = obj6;
                            i21 = i13 == true ? 1 : 0;
                            list19 = list11;
                            data7 = data5;
                            i22 = i14;
                            i23 = i16;
                            tvType4 = tvType3;
                            i24 = i15;
                            str42 = str22;
                            str43 = str100;
                            str44 = str26;
                            i30 = i23;
                            i31 = i24;
                            i32 = i22;
                            obj12 = obj10;
                            str58 = str44;
                            str59 = str21;
                            i33 = i10;
                            str60 = str19;
                            str61 = str29;
                            num8 = num5;
                            list23 = list9;
                            cinemetaRes4 = cinemetaRes;
                            listEmptyList = CollectionsKt.emptyList();
                            tvType6 = tvType4;
                            str53 = str42;
                            list24 = list19;
                            list25 = list10;
                            list26 = list12;
                            str62 = str25;
                            data9 = data7;
                            str63 = str28;
                            mediaDetail6 = mediaDetail3;
                            str64 = str24;
                            str65 = str43;
                            list27 = listEmptyList;
                            if (i32 == 0) {
                                String str810 = str53;
                                String str811 = str61;
                                MediaDetail mediaDetail12 = mediaDetail6;
                                List list412 = list24;
                                CinemetaRes cinemetaRes10 = cinemetaRes4;
                                List list413 = list23;
                                List list414 = list26;
                                C00021 c000210 = c00024;
                                String str812 = str62;
                                int i410 = i21;
                                int i511 = i31;
                                obj13 = obj12;
                                List list415 = list25;
                                TvType tvType13 = TvType.TvSeries;
                                String str917 = str63;
                                String str918 = str60;
                                String str919 = str65;
                                str66 = str58;
                                Integer num12 = num8;
                                C00043 c00044 = new C00043(str919, str66, str811, num12, mediaDetail12, list415, list412, this, list413, list414, list27, cinemetaRes10, str812, null);
                                c000210.L$0 = SpillingKt.nullOutSpilledVariable(str917);
                                c000210.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                                c000210.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                                c000210.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                                c000210.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail12);
                                c000210.L$5 = SpillingKt.nullOutSpilledVariable(str810);
                                c000210.L$6 = SpillingKt.nullOutSpilledVariable(str919);
                                c000210.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                                c000210.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                                c000210.L$9 = SpillingKt.nullOutSpilledVariable(num12);
                                c000210.L$10 = SpillingKt.nullOutSpilledVariable(list412);
                                c000210.L$11 = SpillingKt.nullOutSpilledVariable(list415);
                                c000210.L$12 = SpillingKt.nullOutSpilledVariable(list414);
                                c000210.L$13 = SpillingKt.nullOutSpilledVariable(list413);
                                c000210.L$14 = SpillingKt.nullOutSpilledVariable(str812);
                                c000210.L$15 = SpillingKt.nullOutSpilledVariable(str811);
                                c000210.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                                c000210.L$17 = SpillingKt.nullOutSpilledVariable(str918);
                                c000210.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes10);
                                c000210.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                                c000210.I$0 = i33 == true ? 1 : 0;
                                c000210.I$1 = i32;
                                c000210.I$2 = i511;
                                c000210.I$3 = i30;
                                c000210.I$4 = i410 == true ? 1 : 0;
                                c000210.label = 7;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str810, str917, tvType13, list27, c00044, c000210);
                                c00022 = c000210;
                                if (objNewTvSeriesLoadResponse == obj13) {
                                    return obj13;
                                }
                                obj14 = objNewTvSeriesLoadResponse;
                                str67 = str66;
                                return (LoadResponse) obj14;
                            }
                            if (cinemetaRes4 != null) {
                                str68 = str61;
                                cinemetaRes5 = cinemetaRes4;
                                arrayListEmptyList = CollectionsKt.emptyList();
                            } else {
                                str68 = str61;
                                cinemetaRes5 = cinemetaRes4;
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            alternative_titles = mediaDetail6.getAlternative_titles();
                            if (alternative_titles == null) {
                                list28 = arrayListEmptyList;
                                if (cinemetaRes5 != null) {
                                    name2 = num6;
                                } else {
                                    name2 = num6;
                                }
                            } else {
                                list28 = arrayListEmptyList;
                                if (cinemetaRes5 != null) {
                                    name2 = num6;
                                } else {
                                    name2 = num6;
                                }
                            }
                            obj15 = name2;
                            c00024.L$0 = str63;
                            c00024.L$1 = data9;
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                            c00024.L$4 = mediaDetail6;
                            c00024.L$5 = str53;
                            c00024.L$6 = str65;
                            c00024.L$7 = str58;
                            c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                            c00024.L$9 = num8;
                            c00024.L$10 = list24;
                            c00024.L$11 = list25;
                            c00024.L$12 = list26;
                            c00024.L$13 = list23;
                            c00024.L$14 = str62;
                            str69 = str68;
                            c00024.L$15 = str69;
                            str70 = str53;
                            c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                            c00024.L$17 = str60;
                            c00024.L$18 = cinemetaRes5;
                            c00024.L$19 = list27;
                            c00024.L$20 = list28;
                            c00024.L$21 = obj15;
                            int i512 = i33;
                            c00024.I$0 = i512 == true ? 1 : 0;
                            int i513 = i32;
                            c00024.I$1 = i513;
                            i34 = i31;
                            c00024.I$2 = i34;
                            int i514 = i30;
                            c00024.I$3 = i514;
                            c00024.I$4 = i21 == true ? 1 : 0;
                            c00024.label = 5;
                            list29 = list23;
                            list30 = list26;
                            c00023 = c00024;
                            str71 = str62;
                            data10 = data9;
                            list31 = list25;
                            i35 = i21;
                            i36 = i513;
                            list32 = list27;
                            i37 = i512 == true ? 1 : 0;
                            cinemetaRes6 = cinemetaRes5;
                            i38 = i514;
                            mediaDetail7 = mediaDetail6;
                            list33 = list24;
                            obj16 = obj12;
                            obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                            if (obj17 == obj16) {
                                return obj16;
                            }
                            list34 = list30;
                            str72 = str63;
                            str73 = str60;
                            str74 = str65;
                            str75 = str58;
                            num9 = num8;
                            obj18 = obj17;
                            str76 = str70;
                            r78 = obj15;
                            str77 = str69;
                            mediaDetail8 = mediaDetail7;
                            list35 = list29;
                            cinemetaRes7 = cinemetaRes6;
                            str78 = str71;
                            i39 = i34;
                            i40 = i35 == true ? 1 : 0;
                            list36 = list33;
                            list37 = list31;
                            String text3 = ((NiceResponse) obj18).getText();
                            animeData = TorraStreamUtilsKt.parseAnimeData(text3);
                            if (animeData != null) {
                                kitsuid = num6;
                            } else {
                                kitsuid = num6;
                            }
                            String str9110 = str74;
                            list39 = list28;
                            int i515 = i40;
                            str79 = str76;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                            list40 = list39;
                            while (r23.hasNext()) {
                                List list416 = list39;
                                released = video.getReleased();
                                if (released != null) {
                                    if (cinemetaRes7 != null) {
                                        intOrNull2 = num6;
                                    } else {
                                        intOrNull2 = num6;
                                    }
                                    if (intOrNull2 != null) {
                                        iIntValue = intOrNull2.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                } else {
                                    if (cinemetaRes7 != null) {
                                        intOrNull2 = num6;
                                    } else {
                                        intOrNull2 = num6;
                                    }
                                    if (intOrNull2 != null) {
                                        iIntValue = intOrNull2.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                }
                                List list417 = list40;
                                MainAPI mainAPI4 = (MainAPI) this;
                                String str9111 = str75;
                                AppUtils appUtils5 = AppUtils.INSTANCE;
                                Integer id4 = data10.getId();
                                external_ids3 = mediaDetail8.getExternal_ids();
                                if (external_ids3 != null) {
                                    tvdb_id = external_ids3.getTvdb_id();
                                } else {
                                    tvdb_id = num6;
                                }
                                String type5 = data10.getType();
                                Integer season4 = video.getSeason();
                                Integer episode3 = video.getEpisode();
                                Integer numBoxInt3 = Boxing.boxInt(iIntValue);
                                String title5 = video.getTitle();
                                String released4 = video.getReleased();
                                releaseDate2 = mediaDetail8.getReleaseDate();
                                if (releaseDate2 == null) {
                                    releaseDate2 = mediaDetail8.getFirstAirDate();
                                }
                                String str9112 = releaseDate2;
                                if (i39 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (i38 != 0) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (i37 != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                String str9113 = str73;
                                arrayList8.add(MainAPIKt.newEpisode(mainAPI4, appUtils5.toJson(new LinkData(id4, str9113, tvdb_id, type5, season4, episode3, null, null, null, str79, numBoxInt3, "", true, num9, null, title5, r78, released4, str9112, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj23) {
                                        return TorraStream.load$lambda$9$0(video, this, (Episode) obj23);
                                    }
                                }));
                                list39 = list416;
                                list40 = list417;
                                str75 = str9111;
                                str77 = str77;
                                str73 = str9113;
                            }
                            String str9114 = str75;
                            String str9115 = str77;
                            String str9116 = str73;
                            arrayList9 = arrayList8;
                            if (arrayList9.isEmpty()) {
                                arrayList9 = list32;
                            }
                            List list52 = arrayList9;
                            TvType tvType14 = TvType.Anime;
                            obj19 = obj16;
                            int i516 = i39;
                            C00021 c000211 = c00023;
                            ?? r15 = kitsuid;
                            C00032 c00034 = new C00032(list52, str9110, str9114, str9115, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r15, cinemetaRes7, str9116, null);
                            c000211.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                            c000211.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                            c000211.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c000211.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                            c000211.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                            c000211.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                            c000211.L$6 = SpillingKt.nullOutSpilledVariable(str9110);
                            c000211.L$7 = SpillingKt.nullOutSpilledVariable(str9114);
                            c000211.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                            c000211.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                            c000211.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                            c000211.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                            c000211.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                            c000211.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                            c000211.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                            c000211.L$15 = SpillingKt.nullOutSpilledVariable(str9115);
                            c000211.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                            c000211.L$17 = SpillingKt.nullOutSpilledVariable(str9116);
                            c000211.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                            c000211.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                            c000211.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                            c000211.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                            c000211.L$22 = SpillingKt.nullOutSpilledVariable(text3);
                            c000211.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                            c000211.L$24 = SpillingKt.nullOutSpilledVariable((Object) r15);
                            c000211.L$25 = SpillingKt.nullOutSpilledVariable(list52);
                            c000211.I$0 = i37 == true ? 1 : 0;
                            c000211.I$1 = i36;
                            c000211.I$2 = i516;
                            c000211.I$3 = i38;
                            c000211.I$4 = i515 == true ? 1 : 0;
                            c000211.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType14, false, c00034, c000211, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj19) {
                                return obj19;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        i10 = i6;
                        str14 = str7;
                        str15 = str13;
                        if (z) {
                            str16 = "series";
                        } else {
                            str16 = "movie";
                        }
                        external_ids = mediaDetail2.getExternal_ids();
                        if (external_ids != null) {
                            imdb_id = external_ids.getImdb_id();
                        } else {
                            imdb_id = null;
                        }
                        if (imdb_id == null) {
                            imdb_id = "";
                        }
                        list5 = list4;
                        c00024.L$0 = str3;
                        c00024.L$1 = data2;
                        c00024.L$2 = tvType2;
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                        c00024.L$4 = mediaDetail2;
                        c00024.L$5 = str8;
                        c00024.L$6 = str11;
                        c00024.L$7 = str10;
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(str6);
                        c00024.L$9 = num3;
                        c00024.L$10 = list3;
                        c00024.L$11 = list;
                        c00024.L$12 = list2;
                        c00024.L$13 = list5;
                        num4 = num3;
                        str17 = str14;
                        c00024.L$14 = str17;
                        data3 = data2;
                        c00024.L$15 = str15;
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(str16);
                        c00024.L$17 = imdb_id;
                        c00024.I$0 = i10 == true ? 1 : 0 ? 1 : 0;
                        c00024.I$1 = i9;
                        c00024.I$2 = i5;
                        c00024.I$3 = i7;
                        c00024.I$4 = r18 == true ? 1 : 0;
                        c00024.label = 3;
                        list6 = list2;
                        list7 = list;
                        str18 = str15;
                        C00021 c000212 = c00024;
                        list8 = list3;
                        str19 = imdb_id;
                        str20 = str10;
                        r40 = r18;
                        i11 = i7;
                        i12 = i5;
                        obj6 = obj4;
                        obj7 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str16 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000212, 4030, (Object) null);
                        c00024 = c000212;
                        if (obj7 == obj6) {
                            return obj6;
                        }
                        mediaDetail3 = mediaDetail2;
                        str21 = str16;
                        str22 = str8;
                        str23 = str11;
                        list9 = list5;
                        str24 = str6;
                        data4 = data3;
                        list10 = list7;
                        str25 = str17;
                        list11 = list8;
                        str26 = str20;
                        i13 = r40 == true ? 1 : 0;
                        i14 = i9;
                        list12 = list6;
                        str27 = str9;
                        str28 = str3;
                        i15 = i12;
                        num5 = num4;
                        str29 = str18;
                        obj8 = obj7;
                        tvType3 = tvType2;
                        i16 = i11;
                        NiceResponse niceResponse3 = (NiceResponse) obj8;
                        ResponseParser parser3 = niceResponse3.getParser();
                        Intrinsics.checkNotNull(parser3);
                        data5 = data4;
                        safe2 = parser3.parseSafe(niceResponse3.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                        cinemetaRes = (CinemetaRes) safe2;
                        if (tvType3 != TvType.TvSeries) {
                            i17 = i13;
                            List list418 = list11;
                            int i411 = i15;
                            TvType tvType15 = tvType3;
                            String str813 = str22;
                            str30 = str23;
                            str31 = str26;
                            C00021 c000213 = c00024;
                            boolean z12 = i10 == true ? 1 : 0;
                            str32 = str19;
                            list13 = list9;
                            str33 = str25;
                            i18 = i16;
                            obj9 = obj6;
                            i19 = i14;
                            String str814 = str29;
                            MediaDetail mediaDetail13 = mediaDetail3;
                            MainAPI mainAPI5 = (MainAPI) this;
                            TvType tvType16 = TvType.Movie;
                            AppUtils appUtils6 = AppUtils.INSTANCE;
                            String title6 = mediaDetail13.getTitle();
                            if (i19 != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            external_ids2 = mediaDetail13.getExternal_ids();
                            if (external_ids2 != null) {
                                imdb_id2 = external_ids2.getImdb_id();
                            } else {
                                imdb_id2 = null;
                            }
                            String json2 = appUtils6.toJson(new LoadData(title6, num5, z2, imdb_id2, null, null, 48, null));
                            if (i17 != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            str34 = str814;
                            list14 = list10;
                            list15 = list12;
                            list16 = list418;
                            C00054 c00055 = new C00054(str30, z3, str31, str34, num5, mediaDetail13, list14, list16, list13, list15, cinemetaRes, str33, null);
                            c000213.L$0 = SpillingKt.nullOutSpilledVariable(str28);
                            c000213.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                            c000213.L$2 = SpillingKt.nullOutSpilledVariable(tvType15);
                            c000213.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                            c000213.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail13);
                            c000213.L$5 = SpillingKt.nullOutSpilledVariable(str813);
                            c000213.L$6 = SpillingKt.nullOutSpilledVariable(str30);
                            c000213.L$7 = SpillingKt.nullOutSpilledVariable(str31);
                            c000213.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                            c000213.L$9 = SpillingKt.nullOutSpilledVariable(num5);
                            c000213.L$10 = SpillingKt.nullOutSpilledVariable(list16);
                            c000213.L$11 = SpillingKt.nullOutSpilledVariable(list14);
                            c000213.L$12 = SpillingKt.nullOutSpilledVariable(list15);
                            c000213.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                            c000213.L$14 = SpillingKt.nullOutSpilledVariable(str33);
                            c000213.L$15 = SpillingKt.nullOutSpilledVariable(str34);
                            c000213.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                            c000213.L$17 = SpillingKt.nullOutSpilledVariable(str32);
                            c000213.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                            c000213.I$0 = z12 ? 1 : 0;
                            c000213.I$1 = i19;
                            c000213.I$2 = i411;
                            c000213.I$3 = i18;
                            c000213.I$4 = i17 == true ? 1 : 0;
                            c000213.label = 8;
                            data6 = data5;
                            str35 = str28;
                            str36 = str813;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI5, str36, str35, tvType16, json2, c00055, c000213);
                            if (objNewMovieLoadResponse == obj9) {
                                return obj9;
                            }
                            str37 = str21;
                            str38 = str24;
                            str39 = str32;
                            str40 = str31;
                            list17 = list13;
                            list18 = list15;
                            cinemetaRes2 = cinemetaRes;
                            i20 = i17 == true ? 1 : 0;
                            str41 = str33;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        seasons = mediaDetail3.getSeasons();
                        if (seasons != null) {
                            ArrayList<Seasons> arrayList26 = seasons;
                            i25 = i15;
                            if (i14 != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            i26 = i14;
                            num6 = null;
                            Object obj23 = obj6;
                            tvType5 = tvType3;
                            int i412 = i13;
                            boolean z13 = i10 == true ? 1 : 0;
                            str45 = str19;
                            num7 = num5;
                            list20 = list9;
                            str46 = str25;
                            Data data13 = data5;
                            int i413 = i16;
                            mediaDetail4 = mediaDetail3;
                            TorraStream$load$episodes$1 torraStream$load$episodes$2 = new TorraStream$load$episodes$1(data13, this, mediaDetail4, num7, z4, null);
                            c00024.L$0 = str28;
                            c00024.L$1 = data13;
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType5);
                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                            c00024.L$4 = mediaDetail4;
                            c00024.L$5 = str22;
                            c00024.L$6 = str23;
                            c00024.L$7 = str26;
                            c00024.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                            c00024.L$9 = num7;
                            c00024.L$10 = list11;
                            c00024.L$11 = list10;
                            c00024.L$12 = list12;
                            c00024.L$13 = list20;
                            c00024.L$14 = str46;
                            str47 = str29;
                            c00024.L$15 = str47;
                            c00024.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                            c00024.L$17 = str45;
                            c00024.L$18 = cinemetaRes;
                            i27 = z13 ? 1 : 0;
                            c00024.I$0 = i27;
                            str48 = str22;
                            c00024.I$1 = i26;
                            str49 = str23;
                            c00024.I$2 = i25;
                            str50 = str26;
                            i28 = i413;
                            c00024.I$3 = i28;
                            list21 = list11;
                            i29 = i412 == true ? 1 : 0;
                            c00024.I$4 = i29 == true ? 1 : 0;
                            c00024.label = 4;
                            objAmap = ParCollectionsKt.amap(arrayList26, torraStream$load$episodes$2, c00024);
                            obj10 = obj23;
                            if (objAmap == obj10) {
                                return obj10;
                            }
                            obj11 = objAmap;
                            str51 = str27;
                            mediaDetail5 = mediaDetail4;
                            data8 = data5;
                            str52 = str46;
                            tvType6 = tvType5;
                            i24 = i25;
                            str53 = str48;
                            list22 = list20;
                            str43 = str49;
                            str54 = str47;
                            i22 = i26;
                            str55 = str21;
                            str56 = str45;
                            str57 = str50;
                            cinemetaRes3 = cinemetaRes;
                            list38 = (List) obj11;
                            if (list38 != null) {
                            }
                            TvType tvType17 = tvType6;
                            i10 = i27;
                            tvType4 = tvType17;
                            List list419 = list21;
                            i21 = i29;
                            list19 = list419;
                            cinemetaRes = cinemetaRes3;
                            i23 = i28;
                            str19 = str56;
                            str21 = str55;
                            str29 = str54;
                            str25 = str52;
                            list9 = list22;
                            str44 = str57;
                            mediaDetail3 = mediaDetail5;
                            str42 = str53;
                            str27 = str51;
                            data7 = data8;
                            num5 = num7;
                        } else {
                            String str101 = str23;
                            boolean z14 = i10 == true ? 1 : 0;
                            num6 = null;
                            obj10 = obj6;
                            i21 = i13 == true ? 1 : 0;
                            list19 = list11;
                            data7 = data5;
                            i22 = i14;
                            i23 = i16;
                            tvType4 = tvType3;
                            i24 = i15;
                            str42 = str22;
                            str43 = str101;
                            str44 = str26;
                        }
                        i30 = i23;
                        i31 = i24;
                        i32 = i22;
                        obj12 = obj10;
                        str58 = str44;
                        str59 = str21;
                        i33 = i10;
                        str60 = str19;
                        str61 = str29;
                        num8 = num5;
                        list23 = list9;
                        cinemetaRes4 = cinemetaRes;
                        listEmptyList = CollectionsKt.emptyList();
                        tvType6 = tvType4;
                        str53 = str42;
                        list24 = list19;
                        list25 = list10;
                        list26 = list12;
                        str62 = str25;
                        data9 = data7;
                        str63 = str28;
                        mediaDetail6 = mediaDetail3;
                        str64 = str24;
                        str65 = str43;
                        list27 = listEmptyList;
                        if (i32 == 0) {
                            String str815 = str53;
                            String str816 = str61;
                            MediaDetail mediaDetail14 = mediaDetail6;
                            List list4110 = list24;
                            CinemetaRes cinemetaRes11 = cinemetaRes4;
                            List list4111 = list23;
                            List list4112 = list26;
                            C00021 c000214 = c00024;
                            String str817 = str62;
                            int i414 = i21;
                            int i517 = i31;
                            obj13 = obj12;
                            List list4113 = list25;
                            TvType tvType18 = TvType.TvSeries;
                            String str9117 = str63;
                            String str9118 = str60;
                            String str9119 = str65;
                            str66 = str58;
                            Integer num13 = num8;
                            C00043 c00045 = new C00043(str9119, str66, str816, num13, mediaDetail14, list4113, list4110, this, list4111, list4112, list27, cinemetaRes11, str817, null);
                            c000214.L$0 = SpillingKt.nullOutSpilledVariable(str9117);
                            c000214.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                            c000214.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c000214.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                            c000214.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail14);
                            c000214.L$5 = SpillingKt.nullOutSpilledVariable(str815);
                            c000214.L$6 = SpillingKt.nullOutSpilledVariable(str9119);
                            c000214.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                            c000214.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                            c000214.L$9 = SpillingKt.nullOutSpilledVariable(num13);
                            c000214.L$10 = SpillingKt.nullOutSpilledVariable(list4110);
                            c000214.L$11 = SpillingKt.nullOutSpilledVariable(list4113);
                            c000214.L$12 = SpillingKt.nullOutSpilledVariable(list4112);
                            c000214.L$13 = SpillingKt.nullOutSpilledVariable(list4111);
                            c000214.L$14 = SpillingKt.nullOutSpilledVariable(str817);
                            c000214.L$15 = SpillingKt.nullOutSpilledVariable(str816);
                            c000214.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                            c000214.L$17 = SpillingKt.nullOutSpilledVariable(str9118);
                            c000214.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes11);
                            c000214.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                            c000214.I$0 = i33 == true ? 1 : 0;
                            c000214.I$1 = i32;
                            c000214.I$2 = i517;
                            c000214.I$3 = i30;
                            c000214.I$4 = i414 == true ? 1 : 0;
                            c000214.label = 7;
                            objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str815, str9117, tvType18, list27, c00045, c000214);
                            c00022 = c000214;
                            if (objNewTvSeriesLoadResponse == obj13) {
                                return obj13;
                            }
                            obj14 = objNewTvSeriesLoadResponse;
                            str67 = str66;
                            return (LoadResponse) obj14;
                        }
                        if (cinemetaRes4 != null) {
                            str68 = str61;
                            cinemetaRes5 = cinemetaRes4;
                            arrayListEmptyList = CollectionsKt.emptyList();
                        } else {
                            str68 = str61;
                            cinemetaRes5 = cinemetaRes4;
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        alternative_titles = mediaDetail6.getAlternative_titles();
                        if (alternative_titles == null) {
                            list28 = arrayListEmptyList;
                            if (cinemetaRes5 != null) {
                                name2 = num6;
                            } else {
                                name2 = num6;
                            }
                        } else {
                            list28 = arrayListEmptyList;
                            if (cinemetaRes5 != null) {
                                name2 = num6;
                            } else {
                                name2 = num6;
                            }
                        }
                        obj15 = name2;
                        c00024.L$0 = str63;
                        c00024.L$1 = data9;
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                        c00024.L$4 = mediaDetail6;
                        c00024.L$5 = str53;
                        c00024.L$6 = str65;
                        c00024.L$7 = str58;
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                        c00024.L$9 = num8;
                        c00024.L$10 = list24;
                        c00024.L$11 = list25;
                        c00024.L$12 = list26;
                        c00024.L$13 = list23;
                        c00024.L$14 = str62;
                        str69 = str68;
                        c00024.L$15 = str69;
                        str70 = str53;
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                        c00024.L$17 = str60;
                        c00024.L$18 = cinemetaRes5;
                        c00024.L$19 = list27;
                        c00024.L$20 = list28;
                        c00024.L$21 = obj15;
                        int i518 = i33;
                        c00024.I$0 = i518 == true ? 1 : 0;
                        int i519 = i32;
                        c00024.I$1 = i519;
                        i34 = i31;
                        c00024.I$2 = i34;
                        int i5110 = i30;
                        c00024.I$3 = i5110;
                        c00024.I$4 = i21 == true ? 1 : 0;
                        c00024.label = 5;
                        list29 = list23;
                        list30 = list26;
                        c00023 = c00024;
                        str71 = str62;
                        data10 = data9;
                        list31 = list25;
                        i35 = i21;
                        i36 = i519;
                        list32 = list27;
                        i37 = i518 == true ? 1 : 0;
                        cinemetaRes6 = cinemetaRes5;
                        i38 = i5110;
                        mediaDetail7 = mediaDetail6;
                        list33 = list24;
                        obj16 = obj12;
                        obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                        if (obj17 == obj16) {
                            return obj16;
                        }
                        list34 = list30;
                        str72 = str63;
                        str73 = str60;
                        str74 = str65;
                        str75 = str58;
                        num9 = num8;
                        obj18 = obj17;
                        str76 = str70;
                        r78 = obj15;
                        str77 = str69;
                        mediaDetail8 = mediaDetail7;
                        list35 = list29;
                        cinemetaRes7 = cinemetaRes6;
                        str78 = str71;
                        i39 = i34;
                        i40 = i35 == true ? 1 : 0;
                        list36 = list33;
                        list37 = list31;
                        String text4 = ((NiceResponse) obj18).getText();
                        animeData = TorraStreamUtilsKt.parseAnimeData(text4);
                        if (animeData != null) {
                            kitsuid = num6;
                        } else {
                            kitsuid = num6;
                        }
                        String str91110 = str74;
                        list39 = list28;
                        int i5111 = i40;
                        str79 = str76;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                        list40 = list39;
                        while (r23.hasNext()) {
                            List list4114 = list39;
                            released = video.getReleased();
                            if (released != null) {
                                if (cinemetaRes7 != null) {
                                    intOrNull2 = num6;
                                } else {
                                    intOrNull2 = num6;
                                }
                                if (intOrNull2 != null) {
                                    iIntValue = intOrNull2.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                            } else {
                                if (cinemetaRes7 != null) {
                                    intOrNull2 = num6;
                                } else {
                                    intOrNull2 = num6;
                                }
                                if (intOrNull2 != null) {
                                    iIntValue = intOrNull2.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                            }
                            List list4115 = list40;
                            MainAPI mainAPI6 = (MainAPI) this;
                            String str91111 = str75;
                            AppUtils appUtils7 = AppUtils.INSTANCE;
                            Integer id5 = data10.getId();
                            external_ids3 = mediaDetail8.getExternal_ids();
                            if (external_ids3 != null) {
                                tvdb_id = external_ids3.getTvdb_id();
                            } else {
                                tvdb_id = num6;
                            }
                            String type6 = data10.getType();
                            Integer season5 = video.getSeason();
                            Integer episode4 = video.getEpisode();
                            Integer numBoxInt4 = Boxing.boxInt(iIntValue);
                            String title7 = video.getTitle();
                            String released5 = video.getReleased();
                            releaseDate2 = mediaDetail8.getReleaseDate();
                            if (releaseDate2 == null) {
                                releaseDate2 = mediaDetail8.getFirstAirDate();
                            }
                            String str91112 = releaseDate2;
                            if (i39 != 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (i38 != 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (i37 != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            String str91113 = str73;
                            arrayList8.add(MainAPIKt.newEpisode(mainAPI6, appUtils7.toJson(new LinkData(id5, str91113, tvdb_id, type6, season5, episode4, null, null, null, str79, numBoxInt4, "", true, num9, null, title7, r78, released5, str91112, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj24) {
                                    return TorraStream.load$lambda$9$0(video, this, (Episode) obj24);
                                }
                            }));
                            list39 = list4114;
                            list40 = list4115;
                            str75 = str91111;
                            str77 = str77;
                            str73 = str91113;
                        }
                        String str91114 = str75;
                        String str91115 = str77;
                        String str91116 = str73;
                        arrayList9 = arrayList8;
                        if (arrayList9.isEmpty()) {
                            arrayList9 = list32;
                        }
                        List list53 = arrayList9;
                        TvType tvType19 = TvType.Anime;
                        obj19 = obj16;
                        int i5112 = i39;
                        C00021 c000215 = c00023;
                        ?? r16 = kitsuid;
                        C00032 c00035 = new C00032(list53, str91110, str91114, str91115, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r16, cinemetaRes7, str91116, null);
                        c000215.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                        c000215.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                        c000215.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c000215.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                        c000215.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                        c000215.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                        c000215.L$6 = SpillingKt.nullOutSpilledVariable(str91110);
                        c000215.L$7 = SpillingKt.nullOutSpilledVariable(str91114);
                        c000215.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                        c000215.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                        c000215.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                        c000215.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                        c000215.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                        c000215.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                        c000215.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                        c000215.L$15 = SpillingKt.nullOutSpilledVariable(str91115);
                        c000215.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                        c000215.L$17 = SpillingKt.nullOutSpilledVariable(str91116);
                        c000215.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                        c000215.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                        c000215.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                        c000215.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                        c000215.L$22 = SpillingKt.nullOutSpilledVariable(text4);
                        c000215.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                        c000215.L$24 = SpillingKt.nullOutSpilledVariable((Object) r16);
                        c000215.L$25 = SpillingKt.nullOutSpilledVariable(list53);
                        c000215.I$0 = i37 == true ? 1 : 0;
                        c000215.I$1 = i36;
                        c000215.I$2 = i5112;
                        c000215.I$3 = i38;
                        c000215.I$4 = i5111 == true ? 1 : 0;
                        c000215.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType19, false, c00035, c000215, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj19) {
                            return obj19;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    str4 = str2;
                    i = 1;
                    if (i == 0) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                    }
                    production_countries = mediaDetail.getProduction_countries();
                    if (production_countries != null) {
                        arrayList4 = production_countries;
                        obj3 = coroutine_suspended;
                        if (arrayList4 instanceof Collection) {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    it2 = it;
                                    arrayList5 = arrayList4;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i3 = 1;
                                    } else {
                                        it = it2;
                                        arrayList4 = arrayList5;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            }
                        } else {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    it2 = it;
                                    arrayList5 = arrayList4;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i3 = 1;
                                    } else {
                                        it = it2;
                                        arrayList4 = arrayList5;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            }
                        }
                    } else {
                        obj3 = coroutine_suspended;
                        i3 = 0;
                    }
                    keywords = mediaDetail.getKeywords();
                    if (keywords != null) {
                        i4 = i3;
                        collectionEmptyList = null;
                    } else {
                        i4 = i3;
                        collectionEmptyList = null;
                    }
                    if (collectionEmptyList == null) {
                        collectionEmptyList = CollectionsKt.emptyList();
                    }
                    Collection collection3 = collectionEmptyList;
                    zIsEmpty = collection3.isEmpty();
                    collection = collection3;
                    if (zIsEmpty) {
                        keywords2 = mediaDetail.getKeywords();
                        if (keywords2 != null) {
                            collection = null;
                        } else {
                            collection = null;
                        }
                    }
                    List list420 = (List) collection;
                    credits = mediaDetail.getCredits();
                    if (credits != null) {
                    }
                    return null;
                }
                str4 = str2;
                i = 0;
                if (i == 0) {
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                production_countries = mediaDetail.getProduction_countries();
                if (production_countries != null) {
                    arrayList4 = production_countries;
                    obj3 = coroutine_suspended;
                    if (arrayList4 instanceof Collection) {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                it2 = it;
                                arrayList5 = arrayList4;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i3 = 1;
                                } else {
                                    it = it2;
                                    arrayList4 = arrayList5;
                                }
                            } else {
                                i3 = 0;
                            }
                        }
                    } else {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                it2 = it;
                                arrayList5 = arrayList4;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i3 = 1;
                                } else {
                                    it = it2;
                                    arrayList4 = arrayList5;
                                }
                            } else {
                                i3 = 0;
                            }
                        }
                    }
                } else {
                    obj3 = coroutine_suspended;
                    i3 = 0;
                }
                keywords = mediaDetail.getKeywords();
                if (keywords != null) {
                    i4 = i3;
                    collectionEmptyList = null;
                } else {
                    i4 = i3;
                    collectionEmptyList = null;
                }
                if (collectionEmptyList == null) {
                    collectionEmptyList = CollectionsKt.emptyList();
                }
                Collection collection4 = collectionEmptyList;
                zIsEmpty = collection4.isEmpty();
                collection = collection4;
                if (zIsEmpty) {
                    keywords2 = mediaDetail.getKeywords();
                    if (keywords2 != null) {
                        collection = null;
                    } else {
                        collection = null;
                    }
                }
                List list421 = (List) collection;
                credits = mediaDetail.getCredits();
                if (credits != null) {
                }
                return null;
            case 1:
                String str102 = (String) c00024.L$3;
                TvType tvType20 = (TvType) c00024.L$2;
                Data data14 = (Data) c00024.L$1;
                String str103 = (String) c00024.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                str2 = str102;
                tvType = tvType20;
                data = data14;
                str3 = str103;
                num2 = null;
                obj2 = objNewMovieLoadResponse;
                NiceResponse niceResponse4 = (NiceResponse) obj2;
                ResponseParser parser4 = niceResponse4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe = parser4.parseSafe(niceResponse4.getText(), Reflection.getOrCreateKotlinClass(MediaDetail.class));
                mediaDetail = (MediaDetail) safe;
                if (mediaDetail != null) {
                    throw new ErrorLoadingException("Invalid Json Response");
                }
                title = mediaDetail.getTitle();
                if (title != null) {
                    break;
                }
                String oriImageUrl3 = getOriImageUrl(mediaDetail.getPosterPath());
                String oriImageUrl4 = getOriImageUrl(mediaDetail.getBackdropPath());
                releaseDate = mediaDetail.getReleaseDate();
                if (releaseDate == null) {
                    releaseDate = mediaDetail.getFirstAirDate();
                }
                if (releaseDate != null) {
                    intOrNull = num2;
                } else {
                    intOrNull = num2;
                }
                Integer num14 = intOrNull;
                genres = mediaDetail.getGenres();
                if (genres != null) {
                    arrayList6 = new ArrayList();
                    it3 = genres.iterator();
                    while (it3.hasNext()) {
                        name = ((Genres) it3.next()).getName();
                        if (name != null) {
                            arrayList7 = arrayList6;
                            arrayList7.add(name);
                        } else {
                            arrayList7 = arrayList6;
                        }
                        arrayList6 = arrayList7;
                    }
                    arrayList = arrayList6;
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    zContains = arrayList.contains("Animation");
                } else {
                    zContains = false;
                }
                if (zContains) {
                    if (!Intrinsics.areEqual(mediaDetail.getOriginal_language(), "zh")) {
                        str4 = str2;
                        if (Intrinsics.areEqual(mediaDetail.getOriginal_language(), "ja")) {
                        }
                        if (i == 0) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                        production_countries = mediaDetail.getProduction_countries();
                        if (production_countries != null) {
                            arrayList4 = production_countries;
                            obj3 = coroutine_suspended;
                            if (arrayList4 instanceof Collection) {
                                it = arrayList4.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        it2 = it;
                                        arrayList5 = arrayList4;
                                        if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                            i3 = 1;
                                        } else {
                                            it = it2;
                                            arrayList4 = arrayList5;
                                        }
                                    } else {
                                        i3 = 0;
                                    }
                                }
                            } else {
                                it = arrayList4.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        it2 = it;
                                        arrayList5 = arrayList4;
                                        if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                            i3 = 1;
                                        } else {
                                            it = it2;
                                            arrayList4 = arrayList5;
                                        }
                                    } else {
                                        i3 = 0;
                                    }
                                }
                            }
                        } else {
                            obj3 = coroutine_suspended;
                            i3 = 0;
                        }
                        keywords = mediaDetail.getKeywords();
                        if (keywords != null) {
                            i4 = i3;
                            collectionEmptyList = null;
                        } else {
                            i4 = i3;
                            collectionEmptyList = null;
                        }
                        if (collectionEmptyList == null) {
                            collectionEmptyList = CollectionsKt.emptyList();
                        }
                        Collection collection5 = collectionEmptyList;
                        zIsEmpty = collection5.isEmpty();
                        collection = collection5;
                        if (zIsEmpty) {
                            keywords2 = mediaDetail.getKeywords();
                            if (keywords2 != null) {
                                collection = null;
                            } else {
                                collection = null;
                            }
                        }
                        List list422 = (List) collection;
                        credits = mediaDetail.getCredits();
                        if (credits != null) {
                            break;
                        }
                        return null;
                    }
                    str4 = str2;
                    i = 1;
                    if (i == 0) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                    }
                    production_countries = mediaDetail.getProduction_countries();
                    if (production_countries != null) {
                        arrayList4 = production_countries;
                        obj3 = coroutine_suspended;
                        if (arrayList4 instanceof Collection) {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    it2 = it;
                                    arrayList5 = arrayList4;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i3 = 1;
                                    } else {
                                        it = it2;
                                        arrayList4 = arrayList5;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            }
                        } else {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    it2 = it;
                                    arrayList5 = arrayList4;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i3 = 1;
                                    } else {
                                        it = it2;
                                        arrayList4 = arrayList5;
                                    }
                                } else {
                                    i3 = 0;
                                }
                            }
                        }
                    } else {
                        obj3 = coroutine_suspended;
                        i3 = 0;
                    }
                    keywords = mediaDetail.getKeywords();
                    if (keywords != null) {
                        i4 = i3;
                        collectionEmptyList = null;
                    } else {
                        i4 = i3;
                        collectionEmptyList = null;
                    }
                    if (collectionEmptyList == null) {
                        collectionEmptyList = CollectionsKt.emptyList();
                    }
                    Collection collection6 = collectionEmptyList;
                    zIsEmpty = collection6.isEmpty();
                    collection = collection6;
                    if (zIsEmpty) {
                        keywords2 = mediaDetail.getKeywords();
                        if (keywords2 != null) {
                            collection = null;
                        } else {
                            collection = null;
                        }
                    }
                    List list423 = (List) collection;
                    credits = mediaDetail.getCredits();
                    if (credits != null) {
                        break;
                    }
                    return null;
                }
                str4 = str2;
                i = 0;
                if (i == 0) {
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                production_countries = mediaDetail.getProduction_countries();
                if (production_countries != null) {
                    arrayList4 = production_countries;
                    obj3 = coroutine_suspended;
                    if (arrayList4 instanceof Collection) {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                it2 = it;
                                arrayList5 = arrayList4;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i3 = 1;
                                } else {
                                    it = it2;
                                    arrayList4 = arrayList5;
                                }
                            } else {
                                i3 = 0;
                            }
                        }
                    } else {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                it2 = it;
                                arrayList5 = arrayList4;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i3 = 1;
                                } else {
                                    it = it2;
                                    arrayList4 = arrayList5;
                                }
                            } else {
                                i3 = 0;
                            }
                        }
                    }
                } else {
                    obj3 = coroutine_suspended;
                    i3 = 0;
                }
                keywords = mediaDetail.getKeywords();
                if (keywords != null) {
                    i4 = i3;
                    collectionEmptyList = null;
                } else {
                    i4 = i3;
                    collectionEmptyList = null;
                }
                if (collectionEmptyList == null) {
                    collectionEmptyList = CollectionsKt.emptyList();
                }
                Collection collection7 = collectionEmptyList;
                zIsEmpty = collection7.isEmpty();
                collection = collection7;
                if (zIsEmpty) {
                    keywords2 = mediaDetail.getKeywords();
                    if (keywords2 != null) {
                        collection = null;
                    } else {
                        collection = null;
                    }
                }
                List list424 = (List) collection;
                credits = mediaDetail.getCredits();
                if (credits != null) {
                    break;
                }
                return null;
            case 2:
                int i60 = c00024.I$4;
                int i61 = c00024.I$3;
                int i62 = c00024.I$2;
                int i63 = c00024.I$1;
                int i64 = c00024.I$0;
                String str104 = (String) c00024.L$14;
                List list54 = (List) c00024.L$13;
                list2 = (List) c00024.L$12;
                list = (List) c00024.L$11;
                list3 = (List) c00024.L$10;
                Integer num15 = (Integer) c00024.L$9;
                String str105 = (String) c00024.L$8;
                String str106 = (String) c00024.L$7;
                String str107 = (String) c00024.L$6;
                String str108 = (String) c00024.L$5;
                MediaDetail mediaDetail15 = (MediaDetail) c00024.L$4;
                String str109 = (String) c00024.L$3;
                TvType tvType21 = (TvType) c00024.L$2;
                Data data15 = (Data) c00024.L$1;
                String str110 = (String) c00024.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                obj5 = objNewMovieLoadResponse;
                i6 = i64;
                str6 = str105;
                str10 = str106;
                str11 = str107;
                str9 = str109;
                i7 = i61;
                i5 = i62;
                str7 = str104;
                list4 = list54;
                num3 = num15;
                r18 = i60;
                mediaDetail2 = mediaDetail15;
                str3 = str110;
                obj4 = coroutine_suspended;
                i8 = i63;
                str8 = str108;
                tvType2 = tvType21;
                data2 = data15;
                i9 = i8;
                str13 = (String) obj5;
                type = data2.getType();
                if (type != null) {
                    i10 = i6;
                    str15 = str13;
                    str14 = str7;
                    if (StringsKt.contains(type, "tv", true)) {
                    }
                    if (z) {
                        str16 = "series";
                    } else {
                        str16 = "movie";
                    }
                    external_ids = mediaDetail2.getExternal_ids();
                    if (external_ids != null) {
                        imdb_id = external_ids.getImdb_id();
                    } else {
                        imdb_id = null;
                    }
                    if (imdb_id == null) {
                        imdb_id = "";
                    }
                    list5 = list4;
                    c00024.L$0 = str3;
                    c00024.L$1 = data2;
                    c00024.L$2 = tvType2;
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                    c00024.L$4 = mediaDetail2;
                    c00024.L$5 = str8;
                    c00024.L$6 = str11;
                    c00024.L$7 = str10;
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(str6);
                    c00024.L$9 = num3;
                    c00024.L$10 = list3;
                    c00024.L$11 = list;
                    c00024.L$12 = list2;
                    c00024.L$13 = list5;
                    num4 = num3;
                    str17 = str14;
                    c00024.L$14 = str17;
                    data3 = data2;
                    c00024.L$15 = str15;
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(str16);
                    c00024.L$17 = imdb_id;
                    c00024.I$0 = i10 == true ? 1 : 0 ? 1 : 0;
                    c00024.I$1 = i9;
                    c00024.I$2 = i5;
                    c00024.I$3 = i7;
                    c00024.I$4 = r18 == true ? 1 : 0;
                    c00024.label = 3;
                    list6 = list2;
                    list7 = list;
                    str18 = str15;
                    C00021 c000216 = c00024;
                    list8 = list3;
                    str19 = imdb_id;
                    str20 = str10;
                    r40 = r18;
                    i11 = i7;
                    i12 = i5;
                    obj6 = obj4;
                    obj7 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str16 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000216, 4030, (Object) null);
                    c00024 = c000216;
                    if (obj7 == obj6) {
                        return obj6;
                    }
                    mediaDetail3 = mediaDetail2;
                    str21 = str16;
                    str22 = str8;
                    str23 = str11;
                    list9 = list5;
                    str24 = str6;
                    data4 = data3;
                    list10 = list7;
                    str25 = str17;
                    list11 = list8;
                    str26 = str20;
                    i13 = r40 == true ? 1 : 0;
                    i14 = i9;
                    list12 = list6;
                    str27 = str9;
                    str28 = str3;
                    i15 = i12;
                    num5 = num4;
                    str29 = str18;
                    obj8 = obj7;
                    tvType3 = tvType2;
                    i16 = i11;
                    NiceResponse niceResponse5 = (NiceResponse) obj8;
                    ResponseParser parser5 = niceResponse5.getParser();
                    Intrinsics.checkNotNull(parser5);
                    data5 = data4;
                    safe2 = parser5.parseSafe(niceResponse5.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                    cinemetaRes = (CinemetaRes) safe2;
                    if (tvType3 != TvType.TvSeries) {
                        i17 = i13;
                        List list4116 = list11;
                        int i415 = i15;
                        TvType tvType110 = tvType3;
                        String str818 = str22;
                        str30 = str23;
                        str31 = str26;
                        C00021 c000217 = c00024;
                        boolean z15 = i10 == true ? 1 : 0;
                        str32 = str19;
                        list13 = list9;
                        str33 = str25;
                        i18 = i16;
                        obj9 = obj6;
                        i19 = i14;
                        String str819 = str29;
                        MediaDetail mediaDetail16 = mediaDetail3;
                        MainAPI mainAPI7 = (MainAPI) this;
                        TvType tvType111 = TvType.Movie;
                        AppUtils appUtils8 = AppUtils.INSTANCE;
                        String title8 = mediaDetail16.getTitle();
                        if (i19 != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        external_ids2 = mediaDetail16.getExternal_ids();
                        if (external_ids2 != null) {
                            imdb_id2 = external_ids2.getImdb_id();
                        } else {
                            imdb_id2 = null;
                        }
                        String json3 = appUtils8.toJson(new LoadData(title8, num5, z2, imdb_id2, null, null, 48, null));
                        if (i17 != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        str34 = str819;
                        list14 = list10;
                        list15 = list12;
                        list16 = list4116;
                        C00054 c00056 = new C00054(str30, z3, str31, str34, num5, mediaDetail16, list14, list16, list13, list15, cinemetaRes, str33, null);
                        c000217.L$0 = SpillingKt.nullOutSpilledVariable(str28);
                        c000217.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                        c000217.L$2 = SpillingKt.nullOutSpilledVariable(tvType110);
                        c000217.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                        c000217.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail16);
                        c000217.L$5 = SpillingKt.nullOutSpilledVariable(str818);
                        c000217.L$6 = SpillingKt.nullOutSpilledVariable(str30);
                        c000217.L$7 = SpillingKt.nullOutSpilledVariable(str31);
                        c000217.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                        c000217.L$9 = SpillingKt.nullOutSpilledVariable(num5);
                        c000217.L$10 = SpillingKt.nullOutSpilledVariable(list16);
                        c000217.L$11 = SpillingKt.nullOutSpilledVariable(list14);
                        c000217.L$12 = SpillingKt.nullOutSpilledVariable(list15);
                        c000217.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                        c000217.L$14 = SpillingKt.nullOutSpilledVariable(str33);
                        c000217.L$15 = SpillingKt.nullOutSpilledVariable(str34);
                        c000217.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                        c000217.L$17 = SpillingKt.nullOutSpilledVariable(str32);
                        c000217.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                        c000217.I$0 = z15 ? 1 : 0;
                        c000217.I$1 = i19;
                        c000217.I$2 = i415;
                        c000217.I$3 = i18;
                        c000217.I$4 = i17 == true ? 1 : 0;
                        c000217.label = 8;
                        data6 = data5;
                        str35 = str28;
                        str36 = str818;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI7, str36, str35, tvType111, json3, c00056, c000217);
                        if (objNewMovieLoadResponse == obj9) {
                            return obj9;
                        }
                        str37 = str21;
                        str38 = str24;
                        str39 = str32;
                        str40 = str31;
                        list17 = list13;
                        list18 = list15;
                        cinemetaRes2 = cinemetaRes;
                        i20 = i17 == true ? 1 : 0;
                        str41 = str33;
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    seasons = mediaDetail3.getSeasons();
                    if (seasons != null) {
                        ArrayList<Seasons> arrayList27 = seasons;
                        i25 = i15;
                        if (i14 != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i26 = i14;
                        num6 = null;
                        Object obj24 = obj6;
                        tvType5 = tvType3;
                        int i416 = i13;
                        boolean z16 = i10 == true ? 1 : 0;
                        str45 = str19;
                        num7 = num5;
                        list20 = list9;
                        str46 = str25;
                        Data data16 = data5;
                        int i417 = i16;
                        mediaDetail4 = mediaDetail3;
                        TorraStream$load$episodes$1 torraStream$load$episodes$3 = new TorraStream$load$episodes$1(data16, this, mediaDetail4, num7, z4, null);
                        c00024.L$0 = str28;
                        c00024.L$1 = data16;
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType5);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                        c00024.L$4 = mediaDetail4;
                        c00024.L$5 = str22;
                        c00024.L$6 = str23;
                        c00024.L$7 = str26;
                        c00024.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                        c00024.L$9 = num7;
                        c00024.L$10 = list11;
                        c00024.L$11 = list10;
                        c00024.L$12 = list12;
                        c00024.L$13 = list20;
                        c00024.L$14 = str46;
                        str47 = str29;
                        c00024.L$15 = str47;
                        c00024.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                        c00024.L$17 = str45;
                        c00024.L$18 = cinemetaRes;
                        i27 = z16 ? 1 : 0;
                        c00024.I$0 = i27;
                        str48 = str22;
                        c00024.I$1 = i26;
                        str49 = str23;
                        c00024.I$2 = i25;
                        str50 = str26;
                        i28 = i417;
                        c00024.I$3 = i28;
                        list21 = list11;
                        i29 = i416 == true ? 1 : 0;
                        c00024.I$4 = i29 == true ? 1 : 0;
                        c00024.label = 4;
                        objAmap = ParCollectionsKt.amap(arrayList27, torraStream$load$episodes$3, c00024);
                        obj10 = obj24;
                        if (objAmap == obj10) {
                            return obj10;
                        }
                        obj11 = objAmap;
                        str51 = str27;
                        mediaDetail5 = mediaDetail4;
                        data8 = data5;
                        str52 = str46;
                        tvType6 = tvType5;
                        i24 = i25;
                        str53 = str48;
                        list22 = list20;
                        str43 = str49;
                        str54 = str47;
                        i22 = i26;
                        str55 = str21;
                        str56 = str45;
                        str57 = str50;
                        cinemetaRes3 = cinemetaRes;
                        list38 = (List) obj11;
                        if (list38 != null) {
                        }
                        TvType tvType112 = tvType6;
                        i10 = i27;
                        tvType4 = tvType112;
                        List list4117 = list21;
                        i21 = i29;
                        list19 = list4117;
                        cinemetaRes = cinemetaRes3;
                        i23 = i28;
                        str19 = str56;
                        str21 = str55;
                        str29 = str54;
                        str25 = str52;
                        list9 = list22;
                        str44 = str57;
                        mediaDetail3 = mediaDetail5;
                        str42 = str53;
                        str27 = str51;
                        data7 = data8;
                        num5 = num7;
                        break;
                    } else {
                        String str1010 = str23;
                        boolean z17 = i10 == true ? 1 : 0;
                        num6 = null;
                        obj10 = obj6;
                        i21 = i13 == true ? 1 : 0;
                        list19 = list11;
                        data7 = data5;
                        i22 = i14;
                        i23 = i16;
                        tvType4 = tvType3;
                        i24 = i15;
                        str42 = str22;
                        str43 = str1010;
                        str44 = str26;
                    }
                    i30 = i23;
                    i31 = i24;
                    i32 = i22;
                    obj12 = obj10;
                    str58 = str44;
                    str59 = str21;
                    i33 = i10;
                    str60 = str19;
                    str61 = str29;
                    num8 = num5;
                    list23 = list9;
                    cinemetaRes4 = cinemetaRes;
                    listEmptyList = CollectionsKt.emptyList();
                    tvType6 = tvType4;
                    str53 = str42;
                    list24 = list19;
                    list25 = list10;
                    list26 = list12;
                    str62 = str25;
                    data9 = data7;
                    str63 = str28;
                    mediaDetail6 = mediaDetail3;
                    str64 = str24;
                    str65 = str43;
                    list27 = listEmptyList;
                    if (i32 == 0) {
                        String str8110 = str53;
                        String str8111 = str61;
                        MediaDetail mediaDetail17 = mediaDetail6;
                        List list4118 = list24;
                        CinemetaRes cinemetaRes12 = cinemetaRes4;
                        List list4119 = list23;
                        List list41110 = list26;
                        C00021 c000218 = c00024;
                        String str8112 = str62;
                        int i418 = i21;
                        int i5113 = i31;
                        obj13 = obj12;
                        List list41111 = list25;
                        TvType tvType113 = TvType.TvSeries;
                        String str91117 = str63;
                        String str91118 = str60;
                        String str91119 = str65;
                        str66 = str58;
                        Integer num16 = num8;
                        C00043 c00046 = new C00043(str91119, str66, str8111, num16, mediaDetail17, list41111, list4118, this, list4119, list41110, list27, cinemetaRes12, str8112, null);
                        c000218.L$0 = SpillingKt.nullOutSpilledVariable(str91117);
                        c000218.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                        c000218.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                        c000218.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                        c000218.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail17);
                        c000218.L$5 = SpillingKt.nullOutSpilledVariable(str8110);
                        c000218.L$6 = SpillingKt.nullOutSpilledVariable(str91119);
                        c000218.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                        c000218.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                        c000218.L$9 = SpillingKt.nullOutSpilledVariable(num16);
                        c000218.L$10 = SpillingKt.nullOutSpilledVariable(list4118);
                        c000218.L$11 = SpillingKt.nullOutSpilledVariable(list41111);
                        c000218.L$12 = SpillingKt.nullOutSpilledVariable(list41110);
                        c000218.L$13 = SpillingKt.nullOutSpilledVariable(list4119);
                        c000218.L$14 = SpillingKt.nullOutSpilledVariable(str8112);
                        c000218.L$15 = SpillingKt.nullOutSpilledVariable(str8111);
                        c000218.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                        c000218.L$17 = SpillingKt.nullOutSpilledVariable(str91118);
                        c000218.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes12);
                        c000218.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                        c000218.I$0 = i33 == true ? 1 : 0;
                        c000218.I$1 = i32;
                        c000218.I$2 = i5113;
                        c000218.I$3 = i30;
                        c000218.I$4 = i418 == true ? 1 : 0;
                        c000218.label = 7;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str8110, str91117, tvType113, list27, c00046, c000218);
                        c00022 = c000218;
                        if (objNewTvSeriesLoadResponse == obj13) {
                            return obj13;
                        }
                        obj14 = objNewTvSeriesLoadResponse;
                        str67 = str66;
                        return (LoadResponse) obj14;
                    }
                    if (cinemetaRes4 != null) {
                        str68 = str61;
                        cinemetaRes5 = cinemetaRes4;
                        arrayListEmptyList = CollectionsKt.emptyList();
                    } else {
                        str68 = str61;
                        cinemetaRes5 = cinemetaRes4;
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    alternative_titles = mediaDetail6.getAlternative_titles();
                    if (alternative_titles == null) {
                        list28 = arrayListEmptyList;
                        if (cinemetaRes5 != null) {
                            name2 = num6;
                        } else {
                            name2 = num6;
                        }
                    } else {
                        list28 = arrayListEmptyList;
                        if (cinemetaRes5 != null) {
                            name2 = num6;
                        } else {
                            name2 = num6;
                        }
                    }
                    obj15 = name2;
                    c00024.L$0 = str63;
                    c00024.L$1 = data9;
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$4 = mediaDetail6;
                    c00024.L$5 = str53;
                    c00024.L$6 = str65;
                    c00024.L$7 = str58;
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                    c00024.L$9 = num8;
                    c00024.L$10 = list24;
                    c00024.L$11 = list25;
                    c00024.L$12 = list26;
                    c00024.L$13 = list23;
                    c00024.L$14 = str62;
                    str69 = str68;
                    c00024.L$15 = str69;
                    str70 = str53;
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                    c00024.L$17 = str60;
                    c00024.L$18 = cinemetaRes5;
                    c00024.L$19 = list27;
                    c00024.L$20 = list28;
                    c00024.L$21 = obj15;
                    int i5114 = i33;
                    c00024.I$0 = i5114 == true ? 1 : 0;
                    int i5115 = i32;
                    c00024.I$1 = i5115;
                    i34 = i31;
                    c00024.I$2 = i34;
                    int i5116 = i30;
                    c00024.I$3 = i5116;
                    c00024.I$4 = i21 == true ? 1 : 0;
                    c00024.label = 5;
                    list29 = list23;
                    list30 = list26;
                    c00023 = c00024;
                    str71 = str62;
                    data10 = data9;
                    list31 = list25;
                    i35 = i21;
                    i36 = i5115;
                    list32 = list27;
                    i37 = i5114 == true ? 1 : 0;
                    cinemetaRes6 = cinemetaRes5;
                    i38 = i5116;
                    mediaDetail7 = mediaDetail6;
                    list33 = list24;
                    obj16 = obj12;
                    obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                    if (obj17 == obj16) {
                        return obj16;
                    }
                    list34 = list30;
                    str72 = str63;
                    str73 = str60;
                    str74 = str65;
                    str75 = str58;
                    num9 = num8;
                    obj18 = obj17;
                    str76 = str70;
                    r78 = obj15;
                    str77 = str69;
                    mediaDetail8 = mediaDetail7;
                    list35 = list29;
                    cinemetaRes7 = cinemetaRes6;
                    str78 = str71;
                    i39 = i34;
                    i40 = i35 == true ? 1 : 0;
                    list36 = list33;
                    list37 = list31;
                    String text5 = ((NiceResponse) obj18).getText();
                    animeData = TorraStreamUtilsKt.parseAnimeData(text5);
                    if (animeData != null) {
                        kitsuid = num6;
                    } else {
                        kitsuid = num6;
                    }
                    String str911110 = str74;
                    list39 = list28;
                    int i5117 = i40;
                    str79 = str76;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                    list40 = list39;
                    while (r23.hasNext()) {
                        List list41112 = list39;
                        released = video.getReleased();
                        if (released != null) {
                            if (cinemetaRes7 != null) {
                                intOrNull2 = num6;
                            } else {
                                intOrNull2 = num6;
                            }
                            if (intOrNull2 != null) {
                                iIntValue = intOrNull2.intValue();
                            } else {
                                iIntValue = 0;
                            }
                        } else {
                            if (cinemetaRes7 != null) {
                                intOrNull2 = num6;
                            } else {
                                intOrNull2 = num6;
                            }
                            if (intOrNull2 != null) {
                                iIntValue = intOrNull2.intValue();
                            } else {
                                iIntValue = 0;
                            }
                        }
                        List list41113 = list40;
                        MainAPI mainAPI8 = (MainAPI) this;
                        String str911111 = str75;
                        AppUtils appUtils9 = AppUtils.INSTANCE;
                        Integer id6 = data10.getId();
                        external_ids3 = mediaDetail8.getExternal_ids();
                        if (external_ids3 != null) {
                            tvdb_id = external_ids3.getTvdb_id();
                        } else {
                            tvdb_id = num6;
                        }
                        String type7 = data10.getType();
                        Integer season6 = video.getSeason();
                        Integer episode5 = video.getEpisode();
                        Integer numBoxInt5 = Boxing.boxInt(iIntValue);
                        String title9 = video.getTitle();
                        String released6 = video.getReleased();
                        releaseDate2 = mediaDetail8.getReleaseDate();
                        if (releaseDate2 == null) {
                            releaseDate2 = mediaDetail8.getFirstAirDate();
                        }
                        String str911112 = releaseDate2;
                        if (i39 != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (i38 != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (i37 != 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        String str911113 = str73;
                        arrayList8.add(MainAPIKt.newEpisode(mainAPI8, appUtils9.toJson(new LinkData(id6, str911113, tvdb_id, type7, season6, episode5, null, null, null, str79, numBoxInt5, "", true, num9, null, title9, r78, released6, str911112, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj25) {
                                return TorraStream.load$lambda$9$0(video, this, (Episode) obj25);
                            }
                        }));
                        list39 = list41112;
                        list40 = list41113;
                        str75 = str911111;
                        str77 = str77;
                        str73 = str911113;
                    }
                    String str911114 = str75;
                    String str911115 = str77;
                    String str911116 = str73;
                    arrayList9 = arrayList8;
                    if (arrayList9.isEmpty()) {
                        arrayList9 = list32;
                    }
                    List list55 = arrayList9;
                    TvType tvType114 = TvType.Anime;
                    obj19 = obj16;
                    int i5118 = i39;
                    C00021 c000219 = c00023;
                    ?? r17 = kitsuid;
                    C00032 c00036 = new C00032(list55, str911110, str911114, str911115, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r17, cinemetaRes7, str911116, null);
                    c000219.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                    c000219.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                    c000219.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c000219.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c000219.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                    c000219.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                    c000219.L$6 = SpillingKt.nullOutSpilledVariable(str911110);
                    c000219.L$7 = SpillingKt.nullOutSpilledVariable(str911114);
                    c000219.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                    c000219.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                    c000219.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                    c000219.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                    c000219.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                    c000219.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                    c000219.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                    c000219.L$15 = SpillingKt.nullOutSpilledVariable(str911115);
                    c000219.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                    c000219.L$17 = SpillingKt.nullOutSpilledVariable(str911116);
                    c000219.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                    c000219.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                    c000219.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                    c000219.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                    c000219.L$22 = SpillingKt.nullOutSpilledVariable(text5);
                    c000219.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                    c000219.L$24 = SpillingKt.nullOutSpilledVariable((Object) r17);
                    c000219.L$25 = SpillingKt.nullOutSpilledVariable(list55);
                    c000219.I$0 = i37 == true ? 1 : 0;
                    c000219.I$1 = i36;
                    c000219.I$2 = i5118;
                    c000219.I$3 = i38;
                    c000219.I$4 = i5117 == true ? 1 : 0;
                    c000219.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType114, false, c00036, c000219, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj19) {
                        return obj19;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                i10 = i6;
                str14 = str7;
                str15 = str13;
                if (z) {
                    str16 = "series";
                } else {
                    str16 = "movie";
                }
                external_ids = mediaDetail2.getExternal_ids();
                if (external_ids != null) {
                    imdb_id = external_ids.getImdb_id();
                } else {
                    imdb_id = null;
                }
                if (imdb_id == null) {
                    imdb_id = "";
                }
                list5 = list4;
                c00024.L$0 = str3;
                c00024.L$1 = data2;
                c00024.L$2 = tvType2;
                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str9);
                c00024.L$4 = mediaDetail2;
                c00024.L$5 = str8;
                c00024.L$6 = str11;
                c00024.L$7 = str10;
                c00024.L$8 = SpillingKt.nullOutSpilledVariable(str6);
                c00024.L$9 = num3;
                c00024.L$10 = list3;
                c00024.L$11 = list;
                c00024.L$12 = list2;
                c00024.L$13 = list5;
                num4 = num3;
                str17 = str14;
                c00024.L$14 = str17;
                data3 = data2;
                c00024.L$15 = str15;
                c00024.L$16 = SpillingKt.nullOutSpilledVariable(str16);
                c00024.L$17 = imdb_id;
                c00024.I$0 = i10 == true ? 1 : 0 ? 1 : 0;
                c00024.I$1 = i9;
                c00024.I$2 = i5;
                c00024.I$3 = i7;
                c00024.I$4 = r18 == true ? 1 : 0;
                c00024.label = 3;
                list6 = list2;
                list7 = list;
                str18 = str15;
                C00021 c0002110 = c00024;
                list8 = list3;
                str19 = imdb_id;
                str20 = str10;
                r40 = r18;
                i11 = i7;
                i12 = i5;
                obj6 = obj4;
                obj7 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str16 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002110, 4030, (Object) null);
                c00024 = c0002110;
                if (obj7 == obj6) {
                    return obj6;
                }
                mediaDetail3 = mediaDetail2;
                str21 = str16;
                str22 = str8;
                str23 = str11;
                list9 = list5;
                str24 = str6;
                data4 = data3;
                list10 = list7;
                str25 = str17;
                list11 = list8;
                str26 = str20;
                i13 = r40 == true ? 1 : 0;
                i14 = i9;
                list12 = list6;
                str27 = str9;
                str28 = str3;
                i15 = i12;
                num5 = num4;
                str29 = str18;
                obj8 = obj7;
                tvType3 = tvType2;
                i16 = i11;
                NiceResponse niceResponse6 = (NiceResponse) obj8;
                ResponseParser parser6 = niceResponse6.getParser();
                Intrinsics.checkNotNull(parser6);
                data5 = data4;
                safe2 = parser6.parseSafe(niceResponse6.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                cinemetaRes = (CinemetaRes) safe2;
                if (tvType3 != TvType.TvSeries) {
                    i17 = i13;
                    List list41114 = list11;
                    int i419 = i15;
                    TvType tvType115 = tvType3;
                    String str8113 = str22;
                    str30 = str23;
                    str31 = str26;
                    C00021 c0002111 = c00024;
                    boolean z18 = i10 == true ? 1 : 0;
                    str32 = str19;
                    list13 = list9;
                    str33 = str25;
                    i18 = i16;
                    obj9 = obj6;
                    i19 = i14;
                    String str8114 = str29;
                    MediaDetail mediaDetail18 = mediaDetail3;
                    MainAPI mainAPI9 = (MainAPI) this;
                    TvType tvType116 = TvType.Movie;
                    AppUtils appUtils10 = AppUtils.INSTANCE;
                    String title10 = mediaDetail18.getTitle();
                    if (i19 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    external_ids2 = mediaDetail18.getExternal_ids();
                    if (external_ids2 != null) {
                        imdb_id2 = external_ids2.getImdb_id();
                    } else {
                        imdb_id2 = null;
                    }
                    String json4 = appUtils10.toJson(new LoadData(title10, num5, z2, imdb_id2, null, null, 48, null));
                    if (i17 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    str34 = str8114;
                    list14 = list10;
                    list15 = list12;
                    list16 = list41114;
                    C00054 c00057 = new C00054(str30, z3, str31, str34, num5, mediaDetail18, list14, list16, list13, list15, cinemetaRes, str33, null);
                    c0002111.L$0 = SpillingKt.nullOutSpilledVariable(str28);
                    c0002111.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c0002111.L$2 = SpillingKt.nullOutSpilledVariable(tvType115);
                    c0002111.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002111.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail18);
                    c0002111.L$5 = SpillingKt.nullOutSpilledVariable(str8113);
                    c0002111.L$6 = SpillingKt.nullOutSpilledVariable(str30);
                    c0002111.L$7 = SpillingKt.nullOutSpilledVariable(str31);
                    c0002111.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                    c0002111.L$9 = SpillingKt.nullOutSpilledVariable(num5);
                    c0002111.L$10 = SpillingKt.nullOutSpilledVariable(list16);
                    c0002111.L$11 = SpillingKt.nullOutSpilledVariable(list14);
                    c0002111.L$12 = SpillingKt.nullOutSpilledVariable(list15);
                    c0002111.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                    c0002111.L$14 = SpillingKt.nullOutSpilledVariable(str33);
                    c0002111.L$15 = SpillingKt.nullOutSpilledVariable(str34);
                    c0002111.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                    c0002111.L$17 = SpillingKt.nullOutSpilledVariable(str32);
                    c0002111.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                    c0002111.I$0 = z18 ? 1 : 0;
                    c0002111.I$1 = i19;
                    c0002111.I$2 = i419;
                    c0002111.I$3 = i18;
                    c0002111.I$4 = i17 == true ? 1 : 0;
                    c0002111.label = 8;
                    data6 = data5;
                    str35 = str28;
                    str36 = str8113;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI9, str36, str35, tvType116, json4, c00057, c0002111);
                    if (objNewMovieLoadResponse == obj9) {
                        return obj9;
                    }
                    str37 = str21;
                    str38 = str24;
                    str39 = str32;
                    str40 = str31;
                    list17 = list13;
                    list18 = list15;
                    cinemetaRes2 = cinemetaRes;
                    i20 = i17 == true ? 1 : 0;
                    str41 = str33;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                seasons = mediaDetail3.getSeasons();
                if (seasons != null) {
                    ArrayList<Seasons> arrayList28 = seasons;
                    i25 = i15;
                    if (i14 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i26 = i14;
                    num6 = null;
                    Object obj25 = obj6;
                    tvType5 = tvType3;
                    int i4110 = i13;
                    boolean z19 = i10 == true ? 1 : 0;
                    str45 = str19;
                    num7 = num5;
                    list20 = list9;
                    str46 = str25;
                    Data data17 = data5;
                    int i4111 = i16;
                    mediaDetail4 = mediaDetail3;
                    TorraStream$load$episodes$1 torraStream$load$episodes$4 = new TorraStream$load$episodes$1(data17, this, mediaDetail4, num7, z4, null);
                    c00024.L$0 = str28;
                    c00024.L$1 = data17;
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType5);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$4 = mediaDetail4;
                    c00024.L$5 = str22;
                    c00024.L$6 = str23;
                    c00024.L$7 = str26;
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                    c00024.L$9 = num7;
                    c00024.L$10 = list11;
                    c00024.L$11 = list10;
                    c00024.L$12 = list12;
                    c00024.L$13 = list20;
                    c00024.L$14 = str46;
                    str47 = str29;
                    c00024.L$15 = str47;
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                    c00024.L$17 = str45;
                    c00024.L$18 = cinemetaRes;
                    i27 = z19 ? 1 : 0;
                    c00024.I$0 = i27;
                    str48 = str22;
                    c00024.I$1 = i26;
                    str49 = str23;
                    c00024.I$2 = i25;
                    str50 = str26;
                    i28 = i4111;
                    c00024.I$3 = i28;
                    list21 = list11;
                    i29 = i4110 == true ? 1 : 0;
                    c00024.I$4 = i29 == true ? 1 : 0;
                    c00024.label = 4;
                    objAmap = ParCollectionsKt.amap(arrayList28, torraStream$load$episodes$4, c00024);
                    obj10 = obj25;
                    if (objAmap == obj10) {
                        return obj10;
                    }
                    obj11 = objAmap;
                    str51 = str27;
                    mediaDetail5 = mediaDetail4;
                    data8 = data5;
                    str52 = str46;
                    tvType6 = tvType5;
                    i24 = i25;
                    str53 = str48;
                    list22 = list20;
                    str43 = str49;
                    str54 = str47;
                    i22 = i26;
                    str55 = str21;
                    str56 = str45;
                    str57 = str50;
                    cinemetaRes3 = cinemetaRes;
                    list38 = (List) obj11;
                    if (list38 != null) {
                    }
                    TvType tvType117 = tvType6;
                    i10 = i27;
                    tvType4 = tvType117;
                    List list41115 = list21;
                    i21 = i29;
                    list19 = list41115;
                    cinemetaRes = cinemetaRes3;
                    i23 = i28;
                    str19 = str56;
                    str21 = str55;
                    str29 = str54;
                    str25 = str52;
                    list9 = list22;
                    str44 = str57;
                    mediaDetail3 = mediaDetail5;
                    str42 = str53;
                    str27 = str51;
                    data7 = data8;
                    num5 = num7;
                    break;
                } else {
                    String str1011 = str23;
                    boolean z110 = i10 == true ? 1 : 0;
                    num6 = null;
                    obj10 = obj6;
                    i21 = i13 == true ? 1 : 0;
                    list19 = list11;
                    data7 = data5;
                    i22 = i14;
                    i23 = i16;
                    tvType4 = tvType3;
                    i24 = i15;
                    str42 = str22;
                    str43 = str1011;
                    str44 = str26;
                }
                i30 = i23;
                i31 = i24;
                i32 = i22;
                obj12 = obj10;
                str58 = str44;
                str59 = str21;
                i33 = i10;
                str60 = str19;
                str61 = str29;
                num8 = num5;
                list23 = list9;
                cinemetaRes4 = cinemetaRes;
                listEmptyList = CollectionsKt.emptyList();
                tvType6 = tvType4;
                str53 = str42;
                list24 = list19;
                list25 = list10;
                list26 = list12;
                str62 = str25;
                data9 = data7;
                str63 = str28;
                mediaDetail6 = mediaDetail3;
                str64 = str24;
                str65 = str43;
                list27 = listEmptyList;
                if (i32 == 0) {
                    String str8115 = str53;
                    String str8116 = str61;
                    MediaDetail mediaDetail19 = mediaDetail6;
                    List list41116 = list24;
                    CinemetaRes cinemetaRes13 = cinemetaRes4;
                    List list41117 = list23;
                    List list41118 = list26;
                    C00021 c0002112 = c00024;
                    String str8117 = str62;
                    int i4112 = i21;
                    int i5119 = i31;
                    obj13 = obj12;
                    List list41119 = list25;
                    TvType tvType118 = TvType.TvSeries;
                    String str911117 = str63;
                    String str911118 = str60;
                    String str911119 = str65;
                    str66 = str58;
                    Integer num17 = num8;
                    C00043 c00047 = new C00043(str911119, str66, str8116, num17, mediaDetail19, list41119, list41116, this, list41117, list41118, list27, cinemetaRes13, str8117, null);
                    c0002112.L$0 = SpillingKt.nullOutSpilledVariable(str911117);
                    c0002112.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                    c0002112.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c0002112.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002112.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail19);
                    c0002112.L$5 = SpillingKt.nullOutSpilledVariable(str8115);
                    c0002112.L$6 = SpillingKt.nullOutSpilledVariable(str911119);
                    c0002112.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                    c0002112.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                    c0002112.L$9 = SpillingKt.nullOutSpilledVariable(num17);
                    c0002112.L$10 = SpillingKt.nullOutSpilledVariable(list41116);
                    c0002112.L$11 = SpillingKt.nullOutSpilledVariable(list41119);
                    c0002112.L$12 = SpillingKt.nullOutSpilledVariable(list41118);
                    c0002112.L$13 = SpillingKt.nullOutSpilledVariable(list41117);
                    c0002112.L$14 = SpillingKt.nullOutSpilledVariable(str8117);
                    c0002112.L$15 = SpillingKt.nullOutSpilledVariable(str8116);
                    c0002112.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                    c0002112.L$17 = SpillingKt.nullOutSpilledVariable(str911118);
                    c0002112.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes13);
                    c0002112.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                    c0002112.I$0 = i33 == true ? 1 : 0;
                    c0002112.I$1 = i32;
                    c0002112.I$2 = i5119;
                    c0002112.I$3 = i30;
                    c0002112.I$4 = i4112 == true ? 1 : 0;
                    c0002112.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str8115, str911117, tvType118, list27, c00047, c0002112);
                    c00022 = c0002112;
                    if (objNewTvSeriesLoadResponse == obj13) {
                        return obj13;
                    }
                    obj14 = objNewTvSeriesLoadResponse;
                    str67 = str66;
                    return (LoadResponse) obj14;
                }
                if (cinemetaRes4 != null) {
                    str68 = str61;
                    cinemetaRes5 = cinemetaRes4;
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    str68 = str61;
                    cinemetaRes5 = cinemetaRes4;
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                alternative_titles = mediaDetail6.getAlternative_titles();
                if (alternative_titles == null) {
                    list28 = arrayListEmptyList;
                    if (cinemetaRes5 != null) {
                        name2 = num6;
                    } else {
                        name2 = num6;
                    }
                } else {
                    list28 = arrayListEmptyList;
                    if (cinemetaRes5 != null) {
                        name2 = num6;
                    } else {
                        name2 = num6;
                    }
                }
                obj15 = name2;
                c00024.L$0 = str63;
                c00024.L$1 = data9;
                c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c00024.L$4 = mediaDetail6;
                c00024.L$5 = str53;
                c00024.L$6 = str65;
                c00024.L$7 = str58;
                c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c00024.L$9 = num8;
                c00024.L$10 = list24;
                c00024.L$11 = list25;
                c00024.L$12 = list26;
                c00024.L$13 = list23;
                c00024.L$14 = str62;
                str69 = str68;
                c00024.L$15 = str69;
                str70 = str53;
                c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c00024.L$17 = str60;
                c00024.L$18 = cinemetaRes5;
                c00024.L$19 = list27;
                c00024.L$20 = list28;
                c00024.L$21 = obj15;
                int i51110 = i33;
                c00024.I$0 = i51110 == true ? 1 : 0;
                int i51111 = i32;
                c00024.I$1 = i51111;
                i34 = i31;
                c00024.I$2 = i34;
                int i51112 = i30;
                c00024.I$3 = i51112;
                c00024.I$4 = i21 == true ? 1 : 0;
                c00024.label = 5;
                list29 = list23;
                list30 = list26;
                c00023 = c00024;
                str71 = str62;
                data10 = data9;
                list31 = list25;
                i35 = i21;
                i36 = i51111;
                list32 = list27;
                i37 = i51110 == true ? 1 : 0;
                cinemetaRes6 = cinemetaRes5;
                i38 = i51112;
                mediaDetail7 = mediaDetail6;
                list33 = list24;
                obj16 = obj12;
                obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                if (obj17 == obj16) {
                    return obj16;
                }
                list34 = list30;
                str72 = str63;
                str73 = str60;
                str74 = str65;
                str75 = str58;
                num9 = num8;
                obj18 = obj17;
                str76 = str70;
                r78 = obj15;
                str77 = str69;
                mediaDetail8 = mediaDetail7;
                list35 = list29;
                cinemetaRes7 = cinemetaRes6;
                str78 = str71;
                i39 = i34;
                i40 = i35 == true ? 1 : 0;
                list36 = list33;
                list37 = list31;
                String text6 = ((NiceResponse) obj18).getText();
                animeData = TorraStreamUtilsKt.parseAnimeData(text6);
                if (animeData != null) {
                    kitsuid = num6;
                } else {
                    kitsuid = num6;
                }
                String str9111110 = str74;
                list39 = list28;
                int i51113 = i40;
                str79 = str76;
                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                list40 = list39;
                while (r23.hasNext()) {
                    List list411110 = list39;
                    released = video.getReleased();
                    if (released != null) {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    } else {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    List list411111 = list40;
                    MainAPI mainAPI10 = (MainAPI) this;
                    String str9111111 = str75;
                    AppUtils appUtils11 = AppUtils.INSTANCE;
                    Integer id7 = data10.getId();
                    external_ids3 = mediaDetail8.getExternal_ids();
                    if (external_ids3 != null) {
                        tvdb_id = external_ids3.getTvdb_id();
                    } else {
                        tvdb_id = num6;
                    }
                    String type8 = data10.getType();
                    Integer season7 = video.getSeason();
                    Integer episode6 = video.getEpisode();
                    Integer numBoxInt6 = Boxing.boxInt(iIntValue);
                    String title11 = video.getTitle();
                    String released7 = video.getReleased();
                    releaseDate2 = mediaDetail8.getReleaseDate();
                    if (releaseDate2 == null) {
                        releaseDate2 = mediaDetail8.getFirstAirDate();
                    }
                    String str9111112 = releaseDate2;
                    if (i39 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i38 != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i37 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    String str9111113 = str73;
                    arrayList8.add(MainAPIKt.newEpisode(mainAPI10, appUtils11.toJson(new LinkData(id7, str9111113, tvdb_id, type8, season7, episode6, null, null, null, str79, numBoxInt6, "", true, num9, null, title11, r78, released7, str9111112, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj26) {
                            return TorraStream.load$lambda$9$0(video, this, (Episode) obj26);
                        }
                    }));
                    list39 = list411110;
                    list40 = list411111;
                    str75 = str9111111;
                    str77 = str77;
                    str73 = str9111113;
                }
                String str9111114 = str75;
                String str9111115 = str77;
                String str9111116 = str73;
                arrayList9 = arrayList8;
                if (arrayList9.isEmpty()) {
                    arrayList9 = list32;
                }
                List list56 = arrayList9;
                TvType tvType119 = TvType.Anime;
                obj19 = obj16;
                int i51114 = i39;
                C00021 c0002113 = c00023;
                ?? r19 = kitsuid;
                C00032 c00037 = new C00032(list56, str9111110, str9111114, str9111115, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r19, cinemetaRes7, str9111116, null);
                c0002113.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                c0002113.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                c0002113.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c0002113.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c0002113.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                c0002113.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                c0002113.L$6 = SpillingKt.nullOutSpilledVariable(str9111110);
                c0002113.L$7 = SpillingKt.nullOutSpilledVariable(str9111114);
                c0002113.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c0002113.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c0002113.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                c0002113.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                c0002113.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                c0002113.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                c0002113.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                c0002113.L$15 = SpillingKt.nullOutSpilledVariable(str9111115);
                c0002113.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c0002113.L$17 = SpillingKt.nullOutSpilledVariable(str9111116);
                c0002113.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                c0002113.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                c0002113.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                c0002113.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                c0002113.L$22 = SpillingKt.nullOutSpilledVariable(text6);
                c0002113.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c0002113.L$24 = SpillingKt.nullOutSpilledVariable((Object) r19);
                c0002113.L$25 = SpillingKt.nullOutSpilledVariable(list56);
                c0002113.I$0 = i37 == true ? 1 : 0;
                c0002113.I$1 = i36;
                c0002113.I$2 = i51114;
                c0002113.I$3 = i38;
                c0002113.I$4 = i51113 == true ? 1 : 0;
                c0002113.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType119, false, c00037, c0002113, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj19) {
                    return obj19;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                int i65 = c00024.I$4;
                int i66 = c00024.I$3;
                i15 = c00024.I$2;
                i14 = c00024.I$1;
                int i67 = c00024.I$0;
                String str111 = (String) c00024.L$17;
                String str112 = (String) c00024.L$16;
                String str113 = (String) c00024.L$15;
                String str114 = (String) c00024.L$14;
                List list57 = (List) c00024.L$13;
                list12 = (List) c00024.L$12;
                i13 = i65;
                List list58 = (List) c00024.L$11;
                List list59 = (List) c00024.L$10;
                Integer num18 = (Integer) c00024.L$9;
                str24 = (String) c00024.L$8;
                String str115 = (String) c00024.L$7;
                String str116 = (String) c00024.L$6;
                String str117 = (String) c00024.L$5;
                MediaDetail mediaDetail20 = (MediaDetail) c00024.L$4;
                str27 = (String) c00024.L$3;
                TvType tvType22 = (TvType) c00024.L$2;
                Data data18 = (Data) c00024.L$1;
                String str118 = (String) c00024.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                obj6 = coroutine_suspended;
                i16 = i66;
                str28 = str118;
                obj8 = objNewMovieLoadResponse;
                str19 = str111;
                str21 = str112;
                str29 = str113;
                str25 = str114;
                list9 = list57;
                list10 = list58;
                list11 = list59;
                num5 = num18;
                str26 = str115;
                str23 = str116;
                str22 = str117;
                mediaDetail3 = mediaDetail20;
                data4 = data18;
                i10 = i67;
                tvType3 = tvType22;
                NiceResponse niceResponse7 = (NiceResponse) obj8;
                ResponseParser parser7 = niceResponse7.getParser();
                Intrinsics.checkNotNull(parser7);
                data5 = data4;
                safe2 = parser7.parseSafe(niceResponse7.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                cinemetaRes = (CinemetaRes) safe2;
                if (tvType3 != TvType.TvSeries) {
                    i17 = i13;
                    List list411112 = list11;
                    int i4113 = i15;
                    TvType tvType1110 = tvType3;
                    String str8118 = str22;
                    str30 = str23;
                    str31 = str26;
                    C00021 c0002114 = c00024;
                    boolean z111 = i10 == true ? 1 : 0;
                    str32 = str19;
                    list13 = list9;
                    str33 = str25;
                    i18 = i16;
                    obj9 = obj6;
                    i19 = i14;
                    String str8119 = str29;
                    MediaDetail mediaDetail110 = mediaDetail3;
                    MainAPI mainAPI11 = (MainAPI) this;
                    TvType tvType1111 = TvType.Movie;
                    AppUtils appUtils12 = AppUtils.INSTANCE;
                    String title12 = mediaDetail110.getTitle();
                    if (i19 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    external_ids2 = mediaDetail110.getExternal_ids();
                    if (external_ids2 != null) {
                        imdb_id2 = external_ids2.getImdb_id();
                    } else {
                        imdb_id2 = null;
                    }
                    String json5 = appUtils12.toJson(new LoadData(title12, num5, z2, imdb_id2, null, null, 48, null));
                    if (i17 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    str34 = str8119;
                    list14 = list10;
                    list15 = list12;
                    list16 = list411112;
                    C00054 c00058 = new C00054(str30, z3, str31, str34, num5, mediaDetail110, list14, list16, list13, list15, cinemetaRes, str33, null);
                    c0002114.L$0 = SpillingKt.nullOutSpilledVariable(str28);
                    c0002114.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c0002114.L$2 = SpillingKt.nullOutSpilledVariable(tvType1110);
                    c0002114.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002114.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail110);
                    c0002114.L$5 = SpillingKt.nullOutSpilledVariable(str8118);
                    c0002114.L$6 = SpillingKt.nullOutSpilledVariable(str30);
                    c0002114.L$7 = SpillingKt.nullOutSpilledVariable(str31);
                    c0002114.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                    c0002114.L$9 = SpillingKt.nullOutSpilledVariable(num5);
                    c0002114.L$10 = SpillingKt.nullOutSpilledVariable(list16);
                    c0002114.L$11 = SpillingKt.nullOutSpilledVariable(list14);
                    c0002114.L$12 = SpillingKt.nullOutSpilledVariable(list15);
                    c0002114.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                    c0002114.L$14 = SpillingKt.nullOutSpilledVariable(str33);
                    c0002114.L$15 = SpillingKt.nullOutSpilledVariable(str34);
                    c0002114.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                    c0002114.L$17 = SpillingKt.nullOutSpilledVariable(str32);
                    c0002114.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                    c0002114.I$0 = z111 ? 1 : 0;
                    c0002114.I$1 = i19;
                    c0002114.I$2 = i4113;
                    c0002114.I$3 = i18;
                    c0002114.I$4 = i17 == true ? 1 : 0;
                    c0002114.label = 8;
                    data6 = data5;
                    str35 = str28;
                    str36 = str8118;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI11, str36, str35, tvType1111, json5, c00058, c0002114);
                    if (objNewMovieLoadResponse == obj9) {
                        return obj9;
                    }
                    str37 = str21;
                    str38 = str24;
                    str39 = str32;
                    str40 = str31;
                    list17 = list13;
                    list18 = list15;
                    cinemetaRes2 = cinemetaRes;
                    i20 = i17 == true ? 1 : 0;
                    str41 = str33;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                seasons = mediaDetail3.getSeasons();
                if (seasons != null) {
                    ArrayList<Seasons> arrayList29 = seasons;
                    i25 = i15;
                    if (i14 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i26 = i14;
                    num6 = null;
                    Object obj26 = obj6;
                    tvType5 = tvType3;
                    int i4114 = i13;
                    boolean z112 = i10 == true ? 1 : 0;
                    str45 = str19;
                    num7 = num5;
                    list20 = list9;
                    str46 = str25;
                    Data data19 = data5;
                    int i4115 = i16;
                    mediaDetail4 = mediaDetail3;
                    TorraStream$load$episodes$1 torraStream$load$episodes$5 = new TorraStream$load$episodes$1(data19, this, mediaDetail4, num7, z4, null);
                    c00024.L$0 = str28;
                    c00024.L$1 = data19;
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType5);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c00024.L$4 = mediaDetail4;
                    c00024.L$5 = str22;
                    c00024.L$6 = str23;
                    c00024.L$7 = str26;
                    c00024.L$8 = SpillingKt.nullOutSpilledVariable(str24);
                    c00024.L$9 = num7;
                    c00024.L$10 = list11;
                    c00024.L$11 = list10;
                    c00024.L$12 = list12;
                    c00024.L$13 = list20;
                    c00024.L$14 = str46;
                    str47 = str29;
                    c00024.L$15 = str47;
                    c00024.L$16 = SpillingKt.nullOutSpilledVariable(str21);
                    c00024.L$17 = str45;
                    c00024.L$18 = cinemetaRes;
                    i27 = z112 ? 1 : 0;
                    c00024.I$0 = i27;
                    str48 = str22;
                    c00024.I$1 = i26;
                    str49 = str23;
                    c00024.I$2 = i25;
                    str50 = str26;
                    i28 = i4115;
                    c00024.I$3 = i28;
                    list21 = list11;
                    i29 = i4114 == true ? 1 : 0;
                    c00024.I$4 = i29 == true ? 1 : 0;
                    c00024.label = 4;
                    objAmap = ParCollectionsKt.amap(arrayList29, torraStream$load$episodes$5, c00024);
                    obj10 = obj26;
                    if (objAmap == obj10) {
                        return obj10;
                    }
                    obj11 = objAmap;
                    str51 = str27;
                    mediaDetail5 = mediaDetail4;
                    data8 = data5;
                    str52 = str46;
                    tvType6 = tvType5;
                    i24 = i25;
                    str53 = str48;
                    list22 = list20;
                    str43 = str49;
                    str54 = str47;
                    i22 = i26;
                    str55 = str21;
                    str56 = str45;
                    str57 = str50;
                    cinemetaRes3 = cinemetaRes;
                    list38 = (List) obj11;
                    if (list38 != null) {
                    }
                    TvType tvType1112 = tvType6;
                    i10 = i27;
                    tvType4 = tvType1112;
                    List list411113 = list21;
                    i21 = i29;
                    list19 = list411113;
                    cinemetaRes = cinemetaRes3;
                    i23 = i28;
                    str19 = str56;
                    str21 = str55;
                    str29 = str54;
                    str25 = str52;
                    list9 = list22;
                    str44 = str57;
                    mediaDetail3 = mediaDetail5;
                    str42 = str53;
                    str27 = str51;
                    data7 = data8;
                    num5 = num7;
                    break;
                } else {
                    String str1012 = str23;
                    boolean z113 = i10 == true ? 1 : 0;
                    num6 = null;
                    obj10 = obj6;
                    i21 = i13 == true ? 1 : 0;
                    list19 = list11;
                    data7 = data5;
                    i22 = i14;
                    i23 = i16;
                    tvType4 = tvType3;
                    i24 = i15;
                    str42 = str22;
                    str43 = str1012;
                    str44 = str26;
                }
                i30 = i23;
                i31 = i24;
                i32 = i22;
                obj12 = obj10;
                str58 = str44;
                str59 = str21;
                i33 = i10;
                str60 = str19;
                str61 = str29;
                num8 = num5;
                list23 = list9;
                cinemetaRes4 = cinemetaRes;
                listEmptyList = CollectionsKt.emptyList();
                tvType6 = tvType4;
                str53 = str42;
                list24 = list19;
                list25 = list10;
                list26 = list12;
                str62 = str25;
                data9 = data7;
                str63 = str28;
                mediaDetail6 = mediaDetail3;
                str64 = str24;
                str65 = str43;
                list27 = listEmptyList;
                if (i32 == 0) {
                    String str81110 = str53;
                    String str81111 = str61;
                    MediaDetail mediaDetail111 = mediaDetail6;
                    List list411114 = list24;
                    CinemetaRes cinemetaRes14 = cinemetaRes4;
                    List list411115 = list23;
                    List list411116 = list26;
                    C00021 c0002115 = c00024;
                    String str81112 = str62;
                    int i4116 = i21;
                    int i51115 = i31;
                    obj13 = obj12;
                    List list411117 = list25;
                    TvType tvType1113 = TvType.TvSeries;
                    String str9111117 = str63;
                    String str9111118 = str60;
                    String str9111119 = str65;
                    str66 = str58;
                    Integer num19 = num8;
                    C00043 c00048 = new C00043(str9111119, str66, str81111, num19, mediaDetail111, list411117, list411114, this, list411115, list411116, list27, cinemetaRes14, str81112, null);
                    c0002115.L$0 = SpillingKt.nullOutSpilledVariable(str9111117);
                    c0002115.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                    c0002115.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c0002115.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002115.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail111);
                    c0002115.L$5 = SpillingKt.nullOutSpilledVariable(str81110);
                    c0002115.L$6 = SpillingKt.nullOutSpilledVariable(str9111119);
                    c0002115.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                    c0002115.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                    c0002115.L$9 = SpillingKt.nullOutSpilledVariable(num19);
                    c0002115.L$10 = SpillingKt.nullOutSpilledVariable(list411114);
                    c0002115.L$11 = SpillingKt.nullOutSpilledVariable(list411117);
                    c0002115.L$12 = SpillingKt.nullOutSpilledVariable(list411116);
                    c0002115.L$13 = SpillingKt.nullOutSpilledVariable(list411115);
                    c0002115.L$14 = SpillingKt.nullOutSpilledVariable(str81112);
                    c0002115.L$15 = SpillingKt.nullOutSpilledVariable(str81111);
                    c0002115.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                    c0002115.L$17 = SpillingKt.nullOutSpilledVariable(str9111118);
                    c0002115.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes14);
                    c0002115.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                    c0002115.I$0 = i33 == true ? 1 : 0;
                    c0002115.I$1 = i32;
                    c0002115.I$2 = i51115;
                    c0002115.I$3 = i30;
                    c0002115.I$4 = i4116 == true ? 1 : 0;
                    c0002115.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str81110, str9111117, tvType1113, list27, c00048, c0002115);
                    c00022 = c0002115;
                    if (objNewTvSeriesLoadResponse == obj13) {
                        return obj13;
                    }
                    obj14 = objNewTvSeriesLoadResponse;
                    str67 = str66;
                    return (LoadResponse) obj14;
                }
                if (cinemetaRes4 != null) {
                    str68 = str61;
                    cinemetaRes5 = cinemetaRes4;
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    str68 = str61;
                    cinemetaRes5 = cinemetaRes4;
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                alternative_titles = mediaDetail6.getAlternative_titles();
                if (alternative_titles == null) {
                    list28 = arrayListEmptyList;
                    if (cinemetaRes5 != null) {
                        name2 = num6;
                    } else {
                        name2 = num6;
                    }
                } else {
                    list28 = arrayListEmptyList;
                    if (cinemetaRes5 != null) {
                        name2 = num6;
                    } else {
                        name2 = num6;
                    }
                }
                obj15 = name2;
                c00024.L$0 = str63;
                c00024.L$1 = data9;
                c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c00024.L$4 = mediaDetail6;
                c00024.L$5 = str53;
                c00024.L$6 = str65;
                c00024.L$7 = str58;
                c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c00024.L$9 = num8;
                c00024.L$10 = list24;
                c00024.L$11 = list25;
                c00024.L$12 = list26;
                c00024.L$13 = list23;
                c00024.L$14 = str62;
                str69 = str68;
                c00024.L$15 = str69;
                str70 = str53;
                c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c00024.L$17 = str60;
                c00024.L$18 = cinemetaRes5;
                c00024.L$19 = list27;
                c00024.L$20 = list28;
                c00024.L$21 = obj15;
                int i51116 = i33;
                c00024.I$0 = i51116 == true ? 1 : 0;
                int i51117 = i32;
                c00024.I$1 = i51117;
                i34 = i31;
                c00024.I$2 = i34;
                int i51118 = i30;
                c00024.I$3 = i51118;
                c00024.I$4 = i21 == true ? 1 : 0;
                c00024.label = 5;
                list29 = list23;
                list30 = list26;
                c00023 = c00024;
                str71 = str62;
                data10 = data9;
                list31 = list25;
                i35 = i21;
                i36 = i51117;
                list32 = list27;
                i37 = i51116 == true ? 1 : 0;
                cinemetaRes6 = cinemetaRes5;
                i38 = i51118;
                mediaDetail7 = mediaDetail6;
                list33 = list24;
                obj16 = obj12;
                obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                if (obj17 == obj16) {
                    return obj16;
                }
                list34 = list30;
                str72 = str63;
                str73 = str60;
                str74 = str65;
                str75 = str58;
                num9 = num8;
                obj18 = obj17;
                str76 = str70;
                r78 = obj15;
                str77 = str69;
                mediaDetail8 = mediaDetail7;
                list35 = list29;
                cinemetaRes7 = cinemetaRes6;
                str78 = str71;
                i39 = i34;
                i40 = i35 == true ? 1 : 0;
                list36 = list33;
                list37 = list31;
                String text7 = ((NiceResponse) obj18).getText();
                animeData = TorraStreamUtilsKt.parseAnimeData(text7);
                if (animeData != null) {
                    kitsuid = num6;
                } else {
                    kitsuid = num6;
                }
                String str91111110 = str74;
                list39 = list28;
                int i51119 = i40;
                str79 = str76;
                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                list40 = list39;
                while (r23.hasNext()) {
                    List list411118 = list39;
                    released = video.getReleased();
                    if (released != null) {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    } else {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    List list411119 = list40;
                    MainAPI mainAPI12 = (MainAPI) this;
                    String str91111111 = str75;
                    AppUtils appUtils13 = AppUtils.INSTANCE;
                    Integer id8 = data10.getId();
                    external_ids3 = mediaDetail8.getExternal_ids();
                    if (external_ids3 != null) {
                        tvdb_id = external_ids3.getTvdb_id();
                    } else {
                        tvdb_id = num6;
                    }
                    String type9 = data10.getType();
                    Integer season8 = video.getSeason();
                    Integer episode7 = video.getEpisode();
                    Integer numBoxInt7 = Boxing.boxInt(iIntValue);
                    String title13 = video.getTitle();
                    String released8 = video.getReleased();
                    releaseDate2 = mediaDetail8.getReleaseDate();
                    if (releaseDate2 == null) {
                        releaseDate2 = mediaDetail8.getFirstAirDate();
                    }
                    String str91111112 = releaseDate2;
                    if (i39 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i38 != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i37 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    String str91111113 = str73;
                    arrayList8.add(MainAPIKt.newEpisode(mainAPI12, appUtils13.toJson(new LinkData(id8, str91111113, tvdb_id, type9, season8, episode7, null, null, null, str79, numBoxInt7, "", true, num9, null, title13, r78, released8, str91111112, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj27) {
                            return TorraStream.load$lambda$9$0(video, this, (Episode) obj27);
                        }
                    }));
                    list39 = list411118;
                    list40 = list411119;
                    str75 = str91111111;
                    str77 = str77;
                    str73 = str91111113;
                }
                String str91111114 = str75;
                String str91111115 = str77;
                String str91111116 = str73;
                arrayList9 = arrayList8;
                if (arrayList9.isEmpty()) {
                    arrayList9 = list32;
                }
                List list510 = arrayList9;
                TvType tvType1114 = TvType.Anime;
                obj19 = obj16;
                int i511110 = i39;
                C00021 c0002116 = c00023;
                ?? r110 = kitsuid;
                C00032 c00038 = new C00032(list510, str91111110, str91111114, str91111115, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r110, cinemetaRes7, str91111116, null);
                c0002116.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                c0002116.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                c0002116.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c0002116.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c0002116.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                c0002116.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                c0002116.L$6 = SpillingKt.nullOutSpilledVariable(str91111110);
                c0002116.L$7 = SpillingKt.nullOutSpilledVariable(str91111114);
                c0002116.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c0002116.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c0002116.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                c0002116.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                c0002116.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                c0002116.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                c0002116.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                c0002116.L$15 = SpillingKt.nullOutSpilledVariable(str91111115);
                c0002116.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c0002116.L$17 = SpillingKt.nullOutSpilledVariable(str91111116);
                c0002116.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                c0002116.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                c0002116.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                c0002116.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                c0002116.L$22 = SpillingKt.nullOutSpilledVariable(text7);
                c0002116.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c0002116.L$24 = SpillingKt.nullOutSpilledVariable((Object) r110);
                c0002116.L$25 = SpillingKt.nullOutSpilledVariable(list510);
                c0002116.I$0 = i37 == true ? 1 : 0;
                c0002116.I$1 = i36;
                c0002116.I$2 = i511110;
                c0002116.I$3 = i38;
                c0002116.I$4 = i51119 == true ? 1 : 0;
                c0002116.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType1114, false, c00038, c0002116, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj19) {
                    return obj19;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                int i68 = c00024.I$4;
                int i69 = c00024.I$3;
                i24 = c00024.I$2;
                i22 = c00024.I$1;
                i27 = c00024.I$0;
                cinemetaRes3 = (CinemetaRes) c00024.L$18;
                String str119 = (String) c00024.L$17;
                String str120 = (String) c00024.L$16;
                String str121 = (String) c00024.L$15;
                String str122 = (String) c00024.L$14;
                List list60 = (List) c00024.L$13;
                List list61 = (List) c00024.L$12;
                List list62 = (List) c00024.L$11;
                List list63 = (List) c00024.L$10;
                Integer num20 = (Integer) c00024.L$9;
                String str123 = (String) c00024.L$8;
                str57 = (String) c00024.L$7;
                str43 = (String) c00024.L$6;
                String str124 = (String) c00024.L$5;
                mediaDetail5 = (MediaDetail) c00024.L$4;
                String str125 = (String) c00024.L$3;
                tvType6 = (TvType) c00024.L$2;
                data8 = (Data) c00024.L$1;
                String str126 = (String) c00024.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                i28 = i69;
                num7 = num20;
                str24 = str123;
                list22 = list60;
                list12 = list61;
                str55 = str120;
                str54 = str121;
                i29 = i68;
                list21 = list63;
                str52 = str122;
                list10 = list62;
                str28 = str126;
                str56 = str119;
                str53 = str124;
                obj10 = coroutine_suspended;
                obj11 = objNewMovieLoadResponse;
                str51 = str125;
                num6 = null;
                list38 = (List) obj11;
                if (list38 != null) {
                    break;
                }
                TvType tvType1115 = tvType6;
                i10 = i27;
                tvType4 = tvType1115;
                List list4111110 = list21;
                i21 = i29;
                list19 = list4111110;
                cinemetaRes = cinemetaRes3;
                i23 = i28;
                str19 = str56;
                str21 = str55;
                str29 = str54;
                str25 = str52;
                list9 = list22;
                str44 = str57;
                mediaDetail3 = mediaDetail5;
                str42 = str53;
                str27 = str51;
                data7 = data8;
                num5 = num7;
                i30 = i23;
                i31 = i24;
                i32 = i22;
                obj12 = obj10;
                str58 = str44;
                str59 = str21;
                i33 = i10;
                str60 = str19;
                str61 = str29;
                num8 = num5;
                list23 = list9;
                cinemetaRes4 = cinemetaRes;
                listEmptyList = CollectionsKt.emptyList();
                tvType6 = tvType4;
                str53 = str42;
                list24 = list19;
                list25 = list10;
                list26 = list12;
                str62 = str25;
                data9 = data7;
                str63 = str28;
                mediaDetail6 = mediaDetail3;
                str64 = str24;
                str65 = str43;
                list27 = listEmptyList;
                if (i32 == 0) {
                    String str81113 = str53;
                    String str81114 = str61;
                    MediaDetail mediaDetail112 = mediaDetail6;
                    List list4111111 = list24;
                    CinemetaRes cinemetaRes15 = cinemetaRes4;
                    List list4111112 = list23;
                    List list4111113 = list26;
                    C00021 c0002117 = c00024;
                    String str81115 = str62;
                    int i4117 = i21;
                    int i511111 = i31;
                    obj13 = obj12;
                    List list4111114 = list25;
                    TvType tvType1116 = TvType.TvSeries;
                    String str91111117 = str63;
                    String str91111118 = str60;
                    String str91111119 = str65;
                    str66 = str58;
                    Integer num110 = num8;
                    C00043 c00049 = new C00043(str91111119, str66, str81114, num110, mediaDetail112, list4111114, list4111111, this, list4111112, list4111113, list27, cinemetaRes15, str81115, null);
                    c0002117.L$0 = SpillingKt.nullOutSpilledVariable(str91111117);
                    c0002117.L$1 = SpillingKt.nullOutSpilledVariable(data9);
                    c0002117.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                    c0002117.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002117.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail112);
                    c0002117.L$5 = SpillingKt.nullOutSpilledVariable(str81113);
                    c0002117.L$6 = SpillingKt.nullOutSpilledVariable(str91111119);
                    c0002117.L$7 = SpillingKt.nullOutSpilledVariable(str66);
                    c0002117.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                    c0002117.L$9 = SpillingKt.nullOutSpilledVariable(num110);
                    c0002117.L$10 = SpillingKt.nullOutSpilledVariable(list4111111);
                    c0002117.L$11 = SpillingKt.nullOutSpilledVariable(list4111114);
                    c0002117.L$12 = SpillingKt.nullOutSpilledVariable(list4111113);
                    c0002117.L$13 = SpillingKt.nullOutSpilledVariable(list4111112);
                    c0002117.L$14 = SpillingKt.nullOutSpilledVariable(str81115);
                    c0002117.L$15 = SpillingKt.nullOutSpilledVariable(str81114);
                    c0002117.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                    c0002117.L$17 = SpillingKt.nullOutSpilledVariable(str91111118);
                    c0002117.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes15);
                    c0002117.L$19 = SpillingKt.nullOutSpilledVariable(list27);
                    c0002117.I$0 = i33 == true ? 1 : 0;
                    c0002117.I$1 = i32;
                    c0002117.I$2 = i511111;
                    c0002117.I$3 = i30;
                    c0002117.I$4 = i4117 == true ? 1 : 0;
                    c0002117.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str81113, str91111117, tvType1116, list27, c00049, c0002117);
                    c00022 = c0002117;
                    if (objNewTvSeriesLoadResponse == obj13) {
                        return obj13;
                    }
                    obj14 = objNewTvSeriesLoadResponse;
                    str67 = str66;
                    return (LoadResponse) obj14;
                }
                if (cinemetaRes4 != null) {
                    str68 = str61;
                    cinemetaRes5 = cinemetaRes4;
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    str68 = str61;
                    cinemetaRes5 = cinemetaRes4;
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                alternative_titles = mediaDetail6.getAlternative_titles();
                if (alternative_titles == null) {
                    list28 = arrayListEmptyList;
                    if (cinemetaRes5 != null) {
                        name2 = num6;
                    } else {
                        name2 = num6;
                    }
                } else {
                    list28 = arrayListEmptyList;
                    if (cinemetaRes5 != null) {
                        name2 = num6;
                    } else {
                        name2 = num6;
                    }
                }
                obj15 = name2;
                c00024.L$0 = str63;
                c00024.L$1 = data9;
                c00024.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c00024.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c00024.L$4 = mediaDetail6;
                c00024.L$5 = str53;
                c00024.L$6 = str65;
                c00024.L$7 = str58;
                c00024.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c00024.L$9 = num8;
                c00024.L$10 = list24;
                c00024.L$11 = list25;
                c00024.L$12 = list26;
                c00024.L$13 = list23;
                c00024.L$14 = str62;
                str69 = str68;
                c00024.L$15 = str69;
                str70 = str53;
                c00024.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c00024.L$17 = str60;
                c00024.L$18 = cinemetaRes5;
                c00024.L$19 = list27;
                c00024.L$20 = list28;
                c00024.L$21 = obj15;
                int i511112 = i33;
                c00024.I$0 = i511112 == true ? 1 : 0;
                int i511113 = i32;
                c00024.I$1 = i511113;
                i34 = i31;
                c00024.I$2 = i34;
                int i511114 = i30;
                c00024.I$3 = i511114;
                c00024.I$4 = i21 == true ? 1 : 0;
                c00024.label = 5;
                list29 = list23;
                list30 = list26;
                c00023 = c00024;
                str71 = str62;
                data10 = data9;
                list31 = list25;
                i35 = i21;
                i36 = i511113;
                list32 = list27;
                i37 = i511112 == true ? 1 : 0;
                cinemetaRes6 = cinemetaRes5;
                i38 = i511114;
                mediaDetail7 = mediaDetail6;
                list33 = list24;
                obj16 = obj12;
                obj17 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?imdb_id=" + str60, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                if (obj17 == obj16) {
                    return obj16;
                }
                list34 = list30;
                str72 = str63;
                str73 = str60;
                str74 = str65;
                str75 = str58;
                num9 = num8;
                obj18 = obj17;
                str76 = str70;
                r78 = obj15;
                str77 = str69;
                mediaDetail8 = mediaDetail7;
                list35 = list29;
                cinemetaRes7 = cinemetaRes6;
                str78 = str71;
                i39 = i34;
                i40 = i35 == true ? 1 : 0;
                list36 = list33;
                list37 = list31;
                String text8 = ((NiceResponse) obj18).getText();
                animeData = TorraStreamUtilsKt.parseAnimeData(text8);
                if (animeData != null) {
                    kitsuid = num6;
                } else {
                    kitsuid = num6;
                }
                String str911111110 = str74;
                list39 = list28;
                int i511115 = i40;
                str79 = str76;
                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                list40 = list39;
                while (r23.hasNext()) {
                    List list4111115 = list39;
                    released = video.getReleased();
                    if (released != null) {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    } else {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    List list4111116 = list40;
                    MainAPI mainAPI13 = (MainAPI) this;
                    String str911111111 = str75;
                    AppUtils appUtils14 = AppUtils.INSTANCE;
                    Integer id9 = data10.getId();
                    external_ids3 = mediaDetail8.getExternal_ids();
                    if (external_ids3 != null) {
                        tvdb_id = external_ids3.getTvdb_id();
                    } else {
                        tvdb_id = num6;
                    }
                    String type10 = data10.getType();
                    Integer season9 = video.getSeason();
                    Integer episode8 = video.getEpisode();
                    Integer numBoxInt8 = Boxing.boxInt(iIntValue);
                    String title14 = video.getTitle();
                    String released9 = video.getReleased();
                    releaseDate2 = mediaDetail8.getReleaseDate();
                    if (releaseDate2 == null) {
                        releaseDate2 = mediaDetail8.getFirstAirDate();
                    }
                    String str911111112 = releaseDate2;
                    if (i39 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i38 != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i37 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    String str911111113 = str73;
                    arrayList8.add(MainAPIKt.newEpisode(mainAPI13, appUtils14.toJson(new LinkData(id9, str911111113, tvdb_id, type10, season9, episode8, null, null, null, str79, numBoxInt8, "", true, num9, null, title14, r78, released9, str911111112, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj27) {
                            return TorraStream.load$lambda$9$0(video, this, (Episode) obj27);
                        }
                    }));
                    list39 = list4111115;
                    list40 = list4111116;
                    str75 = str911111111;
                    str77 = str77;
                    str73 = str911111113;
                }
                String str911111114 = str75;
                String str911111115 = str77;
                String str911111116 = str73;
                arrayList9 = arrayList8;
                if (arrayList9.isEmpty()) {
                    arrayList9 = list32;
                }
                List list511 = arrayList9;
                TvType tvType1117 = TvType.Anime;
                obj19 = obj16;
                int i511116 = i39;
                C00021 c0002118 = c00023;
                ?? r111 = kitsuid;
                C00032 c00039 = new C00032(list511, str911111110, str911111114, str911111115, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r111, cinemetaRes7, str911111116, null);
                c0002118.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                c0002118.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                c0002118.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c0002118.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c0002118.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                c0002118.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                c0002118.L$6 = SpillingKt.nullOutSpilledVariable(str911111110);
                c0002118.L$7 = SpillingKt.nullOutSpilledVariable(str911111114);
                c0002118.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c0002118.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c0002118.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                c0002118.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                c0002118.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                c0002118.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                c0002118.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                c0002118.L$15 = SpillingKt.nullOutSpilledVariable(str911111115);
                c0002118.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c0002118.L$17 = SpillingKt.nullOutSpilledVariable(str911111116);
                c0002118.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                c0002118.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                c0002118.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                c0002118.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                c0002118.L$22 = SpillingKt.nullOutSpilledVariable(text8);
                c0002118.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c0002118.L$24 = SpillingKt.nullOutSpilledVariable((Object) r111);
                c0002118.L$25 = SpillingKt.nullOutSpilledVariable(list511);
                c0002118.I$0 = i37 == true ? 1 : 0;
                c0002118.I$1 = i36;
                c0002118.I$2 = i511116;
                c0002118.I$3 = i38;
                c0002118.I$4 = i511115 == true ? 1 : 0;
                c0002118.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType1117, false, c00039, c0002118, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj19) {
                    return obj19;
                }
                return objNewAnimeLoadResponse$default;
            case 5:
                int i70 = c00024.I$4;
                int i71 = c00024.I$3;
                int i72 = c00024.I$2;
                int i73 = c00024.I$1;
                int i74 = c00024.I$0;
                String str127 = (String) c00024.L$21;
                List list64 = (List) c00024.L$20;
                List list65 = (List) c00024.L$19;
                CinemetaRes cinemetaRes16 = (CinemetaRes) c00024.L$18;
                String str128 = (String) c00024.L$17;
                String str129 = (String) c00024.L$16;
                String str130 = (String) c00024.L$15;
                String str131 = (String) c00024.L$14;
                List list66 = (List) c00024.L$13;
                List list67 = (List) c00024.L$12;
                List list68 = (List) c00024.L$11;
                List list69 = (List) c00024.L$10;
                Integer num21 = (Integer) c00024.L$9;
                String str132 = (String) c00024.L$8;
                String str133 = (String) c00024.L$7;
                String str134 = (String) c00024.L$6;
                String str135 = (String) c00024.L$5;
                MediaDetail mediaDetail21 = (MediaDetail) c00024.L$4;
                String str136 = (String) c00024.L$3;
                TvType tvType23 = (TvType) c00024.L$2;
                Data data20 = (Data) c00024.L$1;
                String str137 = (String) c00024.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                i36 = i73;
                i37 = i74;
                r78 = str127;
                list28 = list64;
                list32 = list65;
                str78 = str131;
                list35 = list66;
                list34 = list67;
                list37 = list68;
                num9 = num21;
                str64 = str132;
                str76 = str135;
                tvType6 = tvType23;
                cinemetaRes7 = cinemetaRes16;
                str73 = str128;
                str59 = str129;
                c00023 = c00024;
                list36 = list69;
                mediaDetail8 = mediaDetail21;
                obj16 = coroutine_suspended;
                i38 = i71;
                i39 = i72;
                i40 = i70;
                str77 = str130;
                str75 = str133;
                str27 = str136;
                data10 = data20;
                str72 = str137;
                obj18 = objNewMovieLoadResponse;
                str74 = str134;
                num6 = null;
                String text9 = ((NiceResponse) obj18).getText();
                animeData = TorraStreamUtilsKt.parseAnimeData(text9);
                if (animeData != null) {
                    kitsuid = num6;
                } else {
                    kitsuid = num6;
                }
                String str911111117 = str74;
                list39 = list28;
                int i511117 = i40;
                str79 = str76;
                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                list40 = list39;
                while (r23.hasNext()) {
                    List list4111117 = list39;
                    released = video.getReleased();
                    if (released != null) {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    } else {
                        if (cinemetaRes7 != null) {
                            intOrNull2 = num6;
                        } else {
                            intOrNull2 = num6;
                        }
                        if (intOrNull2 != null) {
                            iIntValue = intOrNull2.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    List list4111118 = list40;
                    MainAPI mainAPI14 = (MainAPI) this;
                    String str911111118 = str75;
                    AppUtils appUtils15 = AppUtils.INSTANCE;
                    Integer id10 = data10.getId();
                    external_ids3 = mediaDetail8.getExternal_ids();
                    if (external_ids3 != null) {
                        tvdb_id = external_ids3.getTvdb_id();
                    } else {
                        tvdb_id = num6;
                    }
                    String type11 = data10.getType();
                    Integer season10 = video.getSeason();
                    Integer episode9 = video.getEpisode();
                    Integer numBoxInt9 = Boxing.boxInt(iIntValue);
                    String title15 = video.getTitle();
                    String released10 = video.getReleased();
                    releaseDate2 = mediaDetail8.getReleaseDate();
                    if (releaseDate2 == null) {
                        releaseDate2 = mediaDetail8.getFirstAirDate();
                    }
                    String str911111119 = releaseDate2;
                    if (i39 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i38 != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i37 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    String str9111111110 = str73;
                    arrayList8.add(MainAPIKt.newEpisode(mainAPI14, appUtils15.toJson(new LinkData(id10, str9111111110, tvdb_id, type11, season10, episode9, null, null, null, str79, numBoxInt9, "", true, num9, null, title15, r78, released10, str911111119, z5, z6, z7, mediaDetail8.getTitle(), mediaDetail8.getName(), false, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj27) {
                            return TorraStream.load$lambda$9$0(video, this, (Episode) obj27);
                        }
                    }));
                    list39 = list4111117;
                    list40 = list4111118;
                    str75 = str911111118;
                    str77 = str77;
                    str73 = str9111111110;
                }
                String str9111111111 = str75;
                String str9111111112 = str77;
                String str9111111113 = str73;
                arrayList9 = arrayList8;
                if (arrayList9.isEmpty()) {
                    arrayList9 = list32;
                }
                List list512 = arrayList9;
                TvType tvType1118 = TvType.Anime;
                obj19 = obj16;
                int i511118 = i39;
                C00021 c0002119 = c00023;
                ?? r112 = kitsuid;
                C00032 c000310 = new C00032(list512, str911111117, str9111111111, str9111111112, num9, mediaDetail8, list37, list36, this, list35, list34, str78, r112, cinemetaRes7, str9111111113, null);
                c0002119.L$0 = SpillingKt.nullOutSpilledVariable(str72);
                c0002119.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                c0002119.L$2 = SpillingKt.nullOutSpilledVariable(tvType6);
                c0002119.L$3 = SpillingKt.nullOutSpilledVariable(str27);
                c0002119.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                c0002119.L$5 = SpillingKt.nullOutSpilledVariable(str79);
                c0002119.L$6 = SpillingKt.nullOutSpilledVariable(str911111117);
                c0002119.L$7 = SpillingKt.nullOutSpilledVariable(str9111111111);
                c0002119.L$8 = SpillingKt.nullOutSpilledVariable(str64);
                c0002119.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c0002119.L$10 = SpillingKt.nullOutSpilledVariable(list36);
                c0002119.L$11 = SpillingKt.nullOutSpilledVariable(list37);
                c0002119.L$12 = SpillingKt.nullOutSpilledVariable(list34);
                c0002119.L$13 = SpillingKt.nullOutSpilledVariable(list35);
                c0002119.L$14 = SpillingKt.nullOutSpilledVariable(str78);
                c0002119.L$15 = SpillingKt.nullOutSpilledVariable(str9111111112);
                c0002119.L$16 = SpillingKt.nullOutSpilledVariable(str59);
                c0002119.L$17 = SpillingKt.nullOutSpilledVariable(str9111111113);
                c0002119.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                c0002119.L$19 = SpillingKt.nullOutSpilledVariable(list32);
                c0002119.L$20 = SpillingKt.nullOutSpilledVariable(list28);
                c0002119.L$21 = SpillingKt.nullOutSpilledVariable((Object) r78);
                c0002119.L$22 = SpillingKt.nullOutSpilledVariable(text9);
                c0002119.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c0002119.L$24 = SpillingKt.nullOutSpilledVariable((Object) r112);
                c0002119.L$25 = SpillingKt.nullOutSpilledVariable(list512);
                c0002119.I$0 = i37 == true ? 1 : 0;
                c0002119.I$1 = i36;
                c0002119.I$2 = i511118;
                c0002119.I$3 = i38;
                c0002119.I$4 = i511117 == true ? 1 : 0;
                c0002119.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default((MainAPI) this, str79, str72, tvType1118, false, c000310, c0002119, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj19) {
                    return obj19;
                }
                return objNewAnimeLoadResponse$default;
            case 6:
                int i75 = c00024.I$4;
                int i76 = c00024.I$3;
                int i77 = c00024.I$2;
                int i78 = c00024.I$1;
                int i79 = c00024.I$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                return objNewMovieLoadResponse;
            case 7:
                int i80 = c00024.I$4;
                int i81 = c00024.I$3;
                int i82 = c00024.I$2;
                int i83 = c00024.I$1;
                int i84 = c00024.I$0;
                str67 = (String) c00024.L$7;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                c00022 = c00024;
                obj14 = objNewMovieLoadResponse;
                return (LoadResponse) obj14;
            case 8:
                int i85 = c00024.I$4;
                int i86 = c00024.I$3;
                int i87 = c00024.I$2;
                int i88 = c00024.I$1;
                int i89 = c00024.I$0;
                cinemetaRes2 = (CinemetaRes) c00024.L$18;
                str39 = (String) c00024.L$17;
                str37 = (String) c00024.L$16;
                String str138 = (String) c00024.L$15;
                str41 = (String) c00024.L$14;
                list17 = (List) c00024.L$13;
                list18 = (List) c00024.L$12;
                i20 = i85;
                List list70 = (List) c00024.L$11;
                List list71 = (List) c00024.L$10;
                str38 = (String) c00024.L$8;
                str40 = (String) c00024.L$7;
                String str139 = (String) c00024.L$6;
                String str140 = (String) c00024.L$5;
                Data data21 = (Data) c00024.L$1;
                String str141 = (String) c00024.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                str34 = str138;
                list14 = list70;
                list16 = list71;
                str30 = str139;
                str36 = str140;
                data6 = data21;
                i18 = i86;
                str35 = str141;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$9$0(CinemetaRes.Meta.Video $video, TorraStream this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($video.getTitle() + (this$0.isUpcoming($video.getReleased()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($video.getSeason());
        $this$newEpisode.setEpisode($video.getEpisode());
        $this$newEpisode.setPosterUrl($video.getThumbnail());
        $this$newEpisode.setDescription($video.getOverview());
        MainAPIKt.addDate$default($this$newEpisode, $video.getReleased(), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$load$2 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$load$2", f = "TorraStream.kt", i = {0}, l = {289}, m = "invokeSuspend", n = {"$this$newAnimeLoadResponse"}, nl = {290}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,550:1\n1739#2:551\n1814#2,2:552\n1816#2:555\n1#3:554\n*S KotlinDebug\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$2\n*L\n283#1:551\n283#1:552,2\n283#1:555\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ CinemetaRes $cineRes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ List<Episode> $subbedList;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TorraStream this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(List<Episode> list, String str, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list2, List<String> list3, TorraStream torraStream, List<? extends SearchResponse> list4, List<ActorData> list5, String str4, String str5, CinemetaRes cinemetaRes, String str6, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$subbedList = list;
            this.$poster = str;
            this.$bgPoster = str2;
            this.$logoUrl = str3;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list2;
            this.$genres = list3;
            this.this$0 = torraStream;
            this.$recommendations = list4;
            this.$actors = list5;
            this.$trailer = str4;
            this.$kitsuid = str5;
            this.$cineRes = cinemetaRes;
            this.$imdbId = str6;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$subbedList, this.$poster, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.this$0, this.$recommendations, this.$actors, this.$trailer, this.$kitsuid, this.$cineRes, this.$imdbId, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
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
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subbedList);
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
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$res.getStatus()));
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$load$3 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$load$3", f = "TorraStream.kt", i = {0}, l = {311}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {312}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,550:1\n1#2:551\n*E\n"})
    static final class C00043 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ CinemetaRes $cineRes;
        final /* synthetic */ List<Episode> $episodes;
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
        final /* synthetic */ TorraStream this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, TorraStream torraStream, List<? extends SearchResponse> list3, List<ActorData> list4, List<Episode> list5, CinemetaRes cinemetaRes, String str4, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgPoster = str2;
            this.$logoUrl = str3;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.this$0 = torraStream;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$episodes = list5;
            this.$cineRes = cinemetaRes;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$poster, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.this$0, this.$recommendations, this.$actors, this.$episodes, this.$cineRes, this.$trailer, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CinemetaRes.Meta meta;
            CinemetaRes.Meta.AppExtras appExtras;
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
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$res.getStatus()));
                    loadResponse.setRecommendations(this.$recommendations);
                    loadResponse.setActors(this.$actors);
                    loadResponse.setEpisodes(this.$episodes);
                    CinemetaRes cinemetaRes = this.$cineRes;
                    loadResponse.setContentRating((cinemetaRes == null || (meta = cinemetaRes.getMeta()) == null || (appExtras = meta.getAppExtras()) == null) ? null : appExtras.getCertification());
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$load$4 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$load$4", f = "TorraStream.kt", i = {0}, l = {333}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {334}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,550:1\n1#2:551\n*E\n"})
    static final class C00054 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ CinemetaRes $cineRes;
        final /* synthetic */ boolean $comingSoonFlag;
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
        C00054(String str, boolean z, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, CinemetaRes cinemetaRes, String str4, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$comingSoonFlag = z;
            this.$bgPoster = str2;
            this.$logoUrl = str3;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$cineRes = cinemetaRes;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(this.$poster, this.$comingSoonFlag, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.$recommendations, this.$actors, this.$cineRes, this.$trailer, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CinemetaRes.Meta meta;
            CinemetaRes.Meta.AppExtras appExtras;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setComingSoon(this.$comingSoonFlag);
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
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
                    CinemetaRes cinemetaRes = this.$cineRes;
                    loadResponse.setContentRating((cinemetaRes == null || (meta = cinemetaRes.getMeta()) == null || (appExtras = meta.getAppExtras()) == null) ? null : appExtras.getCertification());
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

    /* JADX WARN: Code duplicated, block: B:100:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:103:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:104:0x0608  */
    /* JADX WARN: Code duplicated, block: B:106:0x060d  */
    /* JADX WARN: Code duplicated, block: B:107:0x061a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0622  */
    /* JADX WARN: Code duplicated, block: B:112:0x062c  */
    /* JADX WARN: Code duplicated, block: B:114:0x063b  */
    /* JADX WARN: Code duplicated, block: B:115:0x063d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0640  */
    /* JADX WARN: Code duplicated, block: B:121:0x064b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0652  */
    /* JADX WARN: Code duplicated, block: B:125:0x0662  */
    /* JADX WARN: Code duplicated, block: B:126:0x0667  */
    /* JADX WARN: Code duplicated, block: B:129:0x06cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x06cc  */
    /* JADX WARN: Code duplicated, block: B:133:0x06fc  */
    /* JADX WARN: Code duplicated, block: B:137:0x0706  */
    /* JADX WARN: Code duplicated, block: B:139:0x070a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0713  */
    /* JADX WARN: Code duplicated, block: B:143:0x07a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:144:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:146:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:147:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x080d  */
    /* JADX WARN: Code duplicated, block: B:155:0x0816  */
    /* JADX WARN: Code duplicated, block: B:157:0x0819  */
    /* JADX WARN: Code duplicated, block: B:159:0x081f  */
    /* JADX WARN: Code duplicated, block: B:163:0x0828  */
    /* JADX WARN: Code duplicated, block: B:165:0x082c  */
    /* JADX WARN: Code duplicated, block: B:167:0x0835  */
    /* JADX WARN: Code duplicated, block: B:169:0x08c1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:170:0x08c2  */
    /* JADX WARN: Code duplicated, block: B:172:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:176:0x09fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:177:0x09ff  */
    /* JADX WARN: Code duplicated, block: B:180:0x0a94 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:181:0x0a95  */
    /* JADX WARN: Code duplicated, block: B:79:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:83:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:84:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:87:0x05c9  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws JSONException {
        C00061 c00061;
        String key;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Ref.ObjectRef episode;
        Object obj3;
        boolean isAnime;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LoadData dataObj;
        boolean isAnime2;
        String title;
        Integer season;
        String id;
        Integer year;
        String provider;
        String data2;
        Object obj4;
        Object obj5;
        Object obj6;
        Integer year2;
        String provider2;
        Function1<? super SubtitleFile, Unit> function5;
        String key2;
        Object obj7;
        NiceResponse aniResponse;
        String text;
        Object obj8;
        String anijson;
        boolean isAnime3;
        String anijson2;
        Object obj9;
        JSONObject aniJson;
        JSONObject mappings;
        Integer kitsuId;
        Integer kitsuId2;
        JSONObject mappings2;
        int i;
        Integer numBoxInt;
        Integer anidbEid;
        int anidbEid2;
        String anijson3;
        String torrentioapiUrl;
        int anidbEid3;
        TorraStream torraStream;
        Object objBuildMeteorUrl;
        Object obj10;
        LoadData dataObj2;
        Ref.ObjectRef episode2;
        Object obj11;
        boolean isCasting2;
        JSONObject aniJson2;
        int i2;
        Function1<? super ExtractorLink, Unit> function6;
        String title2;
        NiceResponse aniResponse2;
        boolean isAnime4;
        JSONObject mappings3;
        String torrentioapiUrl2;
        Integer season2;
        Integer kitsuId3;
        String id2;
        int anidbEid4;
        String strOptString;
        String meteorUrl;
        Function1<ExtractorLink, Unit> function1FilteredCallback;
        String str;
        boolean z;
        String torrentioapiUrl3;
        Object obj12;
        char c;
        NiceResponse aniResponse3;
        String title3;
        Integer year3;
        Integer kitsuId4;
        Function1<ExtractorLink, Unit> function7;
        int i3;
        String torrentioapiUrl4;
        String meteorUrl2;
        int anidbEid5;
        String data3;
        boolean isAnime5;
        String key3;
        String torrentioapiUrl5;
        Ref.ObjectRef episode3;
        LoadData dataObj3;
        Integer season3;
        Function1<? super ExtractorLink, Unit> function8;
        String str2;
        int anidbEid6;
        String torrentioapiUrl6;
        boolean isAnime6;
        Function1<? super ExtractorLink, Unit> function9;
        int i4;
        LoadData dataObj4;
        Object objRunAllAsync;
        String torrentioapiUrl7;
        String torrentioapiUrl8;
        Function1<ExtractorLink, Unit> function10;
        boolean isAnime7;
        boolean isAnime8;
        int i5;
        String str3;
        boolean z2;
        String key4;
        Function1[] function1Arr;
        String torrentioapiUrl9;
        String provider3;
        Ref.ObjectRef episode4;
        Integer season4;
        String id3;
        NiceResponse aniResponse4;
        Integer kitsuId5;
        boolean isAnime9;
        String data4;
        String anijson4;
        String torrentioapiUrl10;
        String torrentioapiUrl11;
        NiceResponse aniResponse5;
        String str4;
        boolean z3;
        Function1[] function1Arr2;
        String key5;
        String provider4;
        String meteorUrl3;
        String anijson5;
        String provider5;
        Integer num;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str5 = "AIO Streams";
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String provider6 = this.sharedPref.getString("debrid_provider", null);
                key = this.sharedPref.getString("debrid_key", null);
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
                if (Result.exceptionOrNull-impl(obj) == null) {
                    obj2 = null;
                } else {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = null;
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = obj2;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.TorraStream$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.TorraStream$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.TorraStream$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData dataObj5 = (LoadData) objDecodeFromString;
                boolean isAnime10 = dataObj5.isAnime();
                String title4 = dataObj5.getTitle();
                Integer season5 = dataObj5.getSeason();
                episode = new Ref.ObjectRef();
                episode.element = dataObj5.getEpisode();
                String id4 = dataObj5.getImdbId();
                Integer year4 = dataObj5.getYear();
                try {
                    Result.Companion companion5 = Result.Companion;
                    TorraStream $this$loadLinks_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    String str6 = "https://api.ani.zip/mappings?imdb_id=" + id4;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00062.L$1 = function1;
                    try {
                        c00062.L$2 = function2;
                        c00062.L$3 = provider6;
                        c00062.L$4 = key;
                        c00062.L$5 = dataObj5;
                        c00062.L$6 = title4;
                        c00062.L$7 = season5;
                        c00062.L$8 = episode;
                        c00062.L$9 = id4;
                        c00062.L$10 = year4;
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$loadLinks_u24lambda_u240);
                        c00062.Z$0 = isCasting;
                        c00062.Z$1 = isAnime10;
                        try {
                            c00062.label = 1;
                            key = key;
                            obj3 = coroutine_suspended;
                            str5 = "AIO Streams";
                            try {
                                Object $result2 = Requests.get$default(app, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4094, (Object) null);
                                c00062 = c00062;
                                if ($result2 == obj3) {
                                    return obj3;
                                }
                                isAnime = isCasting;
                                function3 = function1;
                                obj4 = $result2;
                                dataObj = dataObj5;
                                isAnime2 = isAnime10;
                                title = title4;
                                season = season5;
                                episode = episode;
                                id = id4;
                                year = year4;
                                provider = provider6;
                                data2 = data;
                                function4 = function2;
                                try {
                                    obj5 = Result.constructor-impl((NiceResponse) obj4);
                                    break;
                                } catch (Throwable th5) {
                                    th = th5;
                                    Result.Companion companion6 = Result.Companion;
                                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                obj6 = obj5;
                                year2 = year;
                                provider2 = provider;
                                function5 = function3;
                                key2 = key;
                                if (Result.isFailure-impl(obj6)) {
                                    obj7 = null;
                                } else {
                                    obj7 = obj6;
                                }
                                aniResponse = (NiceResponse) obj7;
                                if (aniResponse != null) {
                                    text = aniResponse.getText();
                                } else {
                                    text = null;
                                }
                                obj8 = obj3;
                                if (text == null) {
                                    text = "";
                                }
                                anijson = text;
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    TorraStream torraStream2 = this;
                                    isAnime3 = isAnime2;
                                    anijson2 = anijson;
                                    try {
                                        obj9 = Result.constructor-impl(new JSONObject(anijson2));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Result.Companion companion8 = Result.Companion;
                                        obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    break;
                                } catch (Throwable th7) {
                                    th = th7;
                                    isAnime3 = isAnime2;
                                    anijson2 = anijson;
                                }
                                if (Result.isFailure-impl(obj9)) {
                                    obj9 = null;
                                }
                                aniJson = (JSONObject) obj9;
                                if (aniJson != null) {
                                    mappings = aniJson.optJSONObject("mappings");
                                } else {
                                    mappings = null;
                                }
                                if (mappings != null) {
                                    kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                                } else {
                                    kitsuId = null;
                                }
                                if (mappings != null) {
                                    kitsuId2 = kitsuId;
                                    strOptString = mappings.optString("type", "");
                                    if (strOptString != null) {
                                        mappings2 = mappings;
                                        i = StringsKt.contains(strOptString, "MOVIE", true) ? 1 : 0;
                                        if (i != 0) {
                                            numBoxInt = Boxing.boxInt(1);
                                        } else {
                                            numBoxInt = (Integer) episode.element;
                                        }
                                        episode.element = numBoxInt;
                                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                        if (anidbEid != null) {
                                            anidbEid2 = anidbEid.intValue();
                                        } else {
                                            anidbEid2 = 0;
                                        }
                                        anijson3 = anijson2;
                                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                        SharedPreferences sharedPreferences = this.sharedPref;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = function4;
                                        c00062.L$3 = provider2;
                                        c00062.L$4 = key2;
                                        c00062.L$5 = dataObj;
                                        c00062.L$6 = title;
                                        c00062.L$7 = season;
                                        c00062.L$8 = episode;
                                        c00062.L$9 = id;
                                        c00062.L$10 = year2;
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                        c00062.L$15 = kitsuId2;
                                        c00062.L$16 = torrentioapiUrl;
                                        c00062.Z$0 = isAnime;
                                        c00062.Z$1 = isAnime3;
                                        c00062.I$0 = i;
                                        c00062.I$1 = anidbEid2;
                                        c00062.label = 2;
                                        anidbEid3 = anidbEid2;
                                        torraStream = this;
                                        objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences, Meteorfortheweebs, c00062);
                                        if (objBuildMeteorUrl == obj8) {
                                            return obj8;
                                        }
                                        Ref.ObjectRef objectRef = episode;
                                        obj10 = objBuildMeteorUrl;
                                        dataObj2 = dataObj;
                                        episode2 = objectRef;
                                        obj11 = obj8;
                                        isCasting2 = isAnime;
                                        aniJson2 = aniJson;
                                        i2 = i;
                                        function6 = function4;
                                        title2 = title;
                                        aniResponse2 = aniResponse;
                                        isAnime4 = isAnime3;
                                        mappings3 = mappings2;
                                        torrentioapiUrl2 = torrentioapiUrl;
                                        season2 = season;
                                        kitsuId3 = kitsuId2;
                                        id2 = id;
                                        anidbEid4 = anidbEid3;
                                        meteorUrl = (String) obj10;
                                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                                        str = key2;
                                        if (str != null || str.length() == 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                        } else {
                                            str2 = str5;
                                            if (!Intrinsics.areEqual(provider2, str2)) {
                                                str5 = str2;
                                                anidbEid6 = anidbEid4;
                                                torrentioapiUrl6 = torrentioapiUrl2;
                                                Function1 filtered = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                                Function1[] function1Arr3 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered};
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = function5;
                                                c00062.L$2 = function6;
                                                c00062.L$3 = provider2;
                                                c00062.L$4 = key2;
                                                c00062.L$5 = dataObj2;
                                                c00062.L$6 = title2;
                                                c00062.L$7 = season2;
                                                c00062.L$8 = episode2;
                                                c00062.L$9 = id2;
                                                c00062.L$10 = year2;
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = kitsuId3;
                                                c00062.L$16 = torrentioapiUrl6;
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                                c00062.L$18 = function1FilteredCallback;
                                                c00062.Z$0 = isCasting2;
                                                isAnime6 = isAnime4;
                                                c00062.Z$1 = isAnime6;
                                                function9 = function6;
                                                i4 = i2;
                                                c00062.I$0 = i4;
                                                c00062.I$1 = anidbEid6;
                                                dataObj4 = dataObj2;
                                                c00062.label = 3;
                                                c = 3;
                                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr3, c00062);
                                                obj12 = obj11;
                                                if (objRunAllAsync == obj12) {
                                                    return obj12;
                                                }
                                                aniResponse3 = aniResponse2;
                                                torrentioapiUrl7 = torrentioapiUrl6;
                                                torrentioapiUrl8 = title2;
                                                anidbEid5 = anidbEid6;
                                                data3 = provider2;
                                                function10 = function1FilteredCallback;
                                                isAnime7 = isAnime6;
                                                isAnime8 = isCasting2;
                                                i5 = i4;
                                                meteorUrl2 = meteorUrl;
                                                year3 = year2;
                                                kitsuId4 = kitsuId3;
                                                function7 = function10;
                                                i3 = i5;
                                                isAnime5 = isAnime7;
                                                isCasting2 = isAnime8;
                                                torrentioapiUrl4 = torrentioapiUrl7;
                                                title3 = torrentioapiUrl8;
                                                key3 = key2;
                                                torrentioapiUrl5 = id2;
                                                season3 = season2;
                                                episode3 = episode2;
                                                function8 = function9;
                                                dataObj3 = dataObj4;
                                                str3 = data3;
                                                if (str3 != null || str3.length() == 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (!z2) {
                                                    str4 = key3;
                                                    if (str4 != null || str4.length() == 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (!z3) {
                                                        if (Intrinsics.areEqual(data3, str5)) {
                                                            Function1<ExtractorLink, Unit> function11 = function7;
                                                            key5 = key3;
                                                            function7 = function11;
                                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11, null)};
                                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                            c00062.L$1 = function5;
                                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                            c00062.L$7 = season3;
                                                            c00062.L$8 = episode3;
                                                            c00062.L$9 = torrentioapiUrl5;
                                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                            c00062.Z$0 = isCasting2;
                                                            c00062.Z$1 = isAnime5;
                                                            c00062.I$0 = i3;
                                                            c00062.I$1 = anidbEid5;
                                                            c00062.label = 4;
                                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                                return obj12;
                                                            }
                                                            provider4 = data3;
                                                            meteorUrl3 = meteorUrl2;
                                                            anijson5 = anijson3;
                                                            provider5 = data2;
                                                            data2 = provider5;
                                                            meteorUrl2 = meteorUrl3;
                                                            anijson3 = anijson5;
                                                            data3 = provider4;
                                                            key3 = key5;
                                                        }
                                                        Unit unit = Unit.INSTANCE;
                                                        torrentioapiUrl11 = data3;
                                                        kitsuId5 = kitsuId4;
                                                        data4 = torrentioapiUrl5;
                                                        anijson4 = anijson3;
                                                        torrentioapiUrl10 = torrentioapiUrl4;
                                                        aniResponse5 = aniResponse3;
                                                    }
                                                    num = (Integer) episode3.element;
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 6;
                                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    return Boxing.boxBoolean(true);
                                                }
                                                key4 = key3;
                                                function1Arr = new Function1[8];
                                                torrentioapiUrl9 = torrentioapiUrl4;
                                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                                provider3 = data3;
                                                Function1<? super ExtractorLink, Unit> function12 = function8;
                                                episode4 = episode3;
                                                season4 = season3;
                                                id3 = torrentioapiUrl5;
                                                LoadData dataObj6 = dataObj3;
                                                C00146 c00146 = new C00146(dataObj6, id3, season4, episode4, function12, null);
                                                function8 = function12;
                                                function1Arr[1] = c00146;
                                                aniResponse4 = aniResponse3;
                                                function1Arr[2] = new C00157(dataObj6, anidbEid5, function8, null);
                                                Integer kitsuId6 = kitsuId4;
                                                function1Arr[c] = new C00168(kitsuId6, season4, episode4, function7, null);
                                                Function1<ExtractorLink, Unit> function13 = function7;
                                                function7 = function13;
                                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function13, null);
                                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                                kitsuId5 = kitsuId6;
                                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                                isAnime9 = isAnime5;
                                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = function5;
                                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00062.L$7 = season4;
                                                c00062.L$8 = episode4;
                                                c00062.L$9 = id3;
                                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00062.Z$0 = isCasting2;
                                                c00062.Z$1 = isAnime9;
                                                c00062.I$0 = i3;
                                                c00062.I$1 = anidbEid5;
                                                c00062.label = 5;
                                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                                    return obj12;
                                                }
                                                data4 = id3;
                                                isAnime5 = isAnime9;
                                                season3 = season4;
                                                episode3 = episode4;
                                                key3 = key4;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl9;
                                                torrentioapiUrl11 = provider3;
                                                aniResponse5 = aniResponse4;
                                                num = (Integer) episode3.element;
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00062.Z$0 = isCasting2;
                                                c00062.Z$1 = isAnime5;
                                                c00062.I$0 = i3;
                                                c00062.I$1 = anidbEid5;
                                                c00062.label = 6;
                                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                    return obj12;
                                                }
                                                return Boxing.boxBoolean(true);
                                            }
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                            str5 = str2;
                                        }
                                        obj12 = obj11;
                                        int i6 = i2;
                                        c = 3;
                                        LoadData dataObj7 = dataObj2;
                                        aniResponse3 = aniResponse2;
                                        title3 = title2;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function1FilteredCallback;
                                        i3 = i6;
                                        torrentioapiUrl4 = torrentioapiUrl3;
                                        meteorUrl2 = meteorUrl;
                                        anidbEid5 = anidbEid4;
                                        data3 = provider2;
                                        isAnime5 = isAnime4;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        episode3 = episode2;
                                        dataObj3 = dataObj7;
                                        season3 = season2;
                                        function8 = function6;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function14 = function7;
                                                    key5 = key3;
                                                    function7 = function14;
                                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function14, null)};
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = function5;
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = season3;
                                                    c00062.L$8 = episode3;
                                                    c00062.L$9 = torrentioapiUrl5;
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit2 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function15 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadData dataObj8 = dataObj3;
                                        C00146 c00147 = new C00146(dataObj8, id3, season4, episode4, function15, null);
                                        function8 = function15;
                                        function1Arr[1] = c00147;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00157(dataObj8, anidbEid5, function8, null);
                                        Integer kitsuId7 = kitsuId4;
                                        function1Arr[c] = new C00168(kitsuId7, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function16 = function7;
                                        function7 = function16;
                                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function16, null);
                                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId7;
                                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season4;
                                        c00062.L$8 = episode4;
                                        c00062.L$9 = id3;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime9;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    mappings2 = mappings;
                                } else {
                                    kitsuId2 = kitsuId;
                                    mappings2 = mappings;
                                }
                                if (i != 0) {
                                    numBoxInt = Boxing.boxInt(1);
                                } else {
                                    numBoxInt = (Integer) episode.element;
                                }
                                episode.element = numBoxInt;
                                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                if (anidbEid != null) {
                                    anidbEid2 = anidbEid.intValue();
                                } else {
                                    anidbEid2 = 0;
                                }
                                anijson3 = anijson2;
                                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                SharedPreferences sharedPreferences2 = this.sharedPref;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = function4;
                                c00062.L$3 = provider2;
                                c00062.L$4 = key2;
                                c00062.L$5 = dataObj;
                                c00062.L$6 = title;
                                c00062.L$7 = season;
                                c00062.L$8 = episode;
                                c00062.L$9 = id;
                                c00062.L$10 = year2;
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                c00062.L$15 = kitsuId2;
                                c00062.L$16 = torrentioapiUrl;
                                c00062.Z$0 = isAnime;
                                c00062.Z$1 = isAnime3;
                                c00062.I$0 = i;
                                c00062.I$1 = anidbEid2;
                                c00062.label = 2;
                                anidbEid3 = anidbEid2;
                                torraStream = this;
                                objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences2, Meteorfortheweebs, c00062);
                                if (objBuildMeteorUrl == obj8) {
                                    return obj8;
                                }
                                Ref.ObjectRef objectRef2 = episode;
                                obj10 = objBuildMeteorUrl;
                                dataObj2 = dataObj;
                                episode2 = objectRef2;
                                obj11 = obj8;
                                isCasting2 = isAnime;
                                aniJson2 = aniJson;
                                i2 = i;
                                function6 = function4;
                                title2 = title;
                                aniResponse2 = aniResponse;
                                isAnime4 = isAnime3;
                                mappings3 = mappings2;
                                torrentioapiUrl2 = torrentioapiUrl;
                                season2 = season;
                                kitsuId3 = kitsuId2;
                                id2 = id;
                                anidbEid4 = anidbEid3;
                                meteorUrl = (String) obj10;
                                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                                str = key2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    str2 = str5;
                                    if (!Intrinsics.areEqual(provider2, str2)) {
                                        str5 = str2;
                                        anidbEid6 = anidbEid4;
                                        torrentioapiUrl6 = torrentioapiUrl2;
                                        Function1 filtered2 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                        Function1[] function1Arr4 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered2};
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = function6;
                                        c00062.L$3 = provider2;
                                        c00062.L$4 = key2;
                                        c00062.L$5 = dataObj2;
                                        c00062.L$6 = title2;
                                        c00062.L$7 = season2;
                                        c00062.L$8 = episode2;
                                        c00062.L$9 = id2;
                                        c00062.L$10 = year2;
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = kitsuId3;
                                        c00062.L$16 = torrentioapiUrl6;
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00062.L$18 = function1FilteredCallback;
                                        c00062.Z$0 = isCasting2;
                                        isAnime6 = isAnime4;
                                        c00062.Z$1 = isAnime6;
                                        function9 = function6;
                                        i4 = i2;
                                        c00062.I$0 = i4;
                                        c00062.I$1 = anidbEid6;
                                        dataObj4 = dataObj2;
                                        c00062.label = 3;
                                        c = 3;
                                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr4, c00062);
                                        obj12 = obj11;
                                        if (objRunAllAsync == obj12) {
                                            return obj12;
                                        }
                                        aniResponse3 = aniResponse2;
                                        torrentioapiUrl7 = torrentioapiUrl6;
                                        torrentioapiUrl8 = title2;
                                        anidbEid5 = anidbEid6;
                                        data3 = provider2;
                                        function10 = function1FilteredCallback;
                                        isAnime7 = isAnime6;
                                        isAnime8 = isCasting2;
                                        i5 = i4;
                                        meteorUrl2 = meteorUrl;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function10;
                                        i3 = i5;
                                        isAnime5 = isAnime7;
                                        isCasting2 = isAnime8;
                                        torrentioapiUrl4 = torrentioapiUrl7;
                                        title3 = torrentioapiUrl8;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        season3 = season2;
                                        episode3 = episode2;
                                        function8 = function9;
                                        dataObj3 = dataObj4;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function17 = function7;
                                                    key5 = key3;
                                                    function7 = function17;
                                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function17, null)};
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = function5;
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = season3;
                                                    c00062.L$8 = episode3;
                                                    c00062.L$9 = torrentioapiUrl5;
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit3 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function18 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadData dataObj9 = dataObj3;
                                        C00146 c00148 = new C00146(dataObj9, id3, season4, episode4, function18, null);
                                        function8 = function18;
                                        function1Arr[1] = c00148;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00157(dataObj9, anidbEid5, function8, null);
                                        Integer kitsuId8 = kitsuId4;
                                        function1Arr[c] = new C00168(kitsuId8, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function19 = function7;
                                        function7 = function19;
                                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function19, null);
                                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId8;
                                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season4;
                                        c00062.L$8 = episode4;
                                        c00062.L$9 = id3;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime9;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                    str5 = str2;
                                } else {
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                }
                                obj12 = obj11;
                                int i7 = i2;
                                c = 3;
                                LoadData dataObj10 = dataObj2;
                                aniResponse3 = aniResponse2;
                                title3 = title2;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function1FilteredCallback;
                                i3 = i7;
                                torrentioapiUrl4 = torrentioapiUrl3;
                                meteorUrl2 = meteorUrl;
                                anidbEid5 = anidbEid4;
                                data3 = provider2;
                                isAnime5 = isAnime4;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                episode3 = episode2;
                                dataObj3 = dataObj10;
                                season3 = season2;
                                function8 = function6;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function110 = function7;
                                            key5 = key3;
                                            function7 = function110;
                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function110, null)};
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = function5;
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = season3;
                                            c00062.L$8 = episode3;
                                            c00062.L$9 = torrentioapiUrl5;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit4 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function111 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadData dataObj11 = dataObj3;
                                C00146 c00149 = new C00146(dataObj11, id3, season4, episode4, function111, null);
                                function8 = function111;
                                function1Arr[1] = c00149;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00157(dataObj11, anidbEid5, function8, null);
                                Integer kitsuId9 = kitsuId4;
                                function1Arr[c] = new C00168(kitsuId9, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function112 = function7;
                                function7 = function112;
                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function112, null);
                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId9;
                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = season4;
                                c00062.L$8 = episode4;
                                c00062.L$9 = id3;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime9;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            } catch (Throwable th8) {
                                th = th8;
                                c00062 = c00062;
                                isAnime = isCasting;
                                function3 = function1;
                                function4 = function2;
                                dataObj = dataObj5;
                                isAnime2 = isAnime10;
                                title = title4;
                                season = season5;
                                episode = episode;
                                id = id4;
                                year = year4;
                                provider = provider6;
                                data2 = data;
                                Result.Companion companion9 = Result.Companion;
                                obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                obj6 = obj5;
                                year2 = year;
                                provider2 = provider;
                                function5 = function3;
                                key2 = key;
                                if (Result.isFailure-impl(obj6)) {
                                    obj7 = null;
                                } else {
                                    obj7 = obj6;
                                }
                                aniResponse = (NiceResponse) obj7;
                                if (aniResponse != null) {
                                    text = aniResponse.getText();
                                } else {
                                    text = null;
                                }
                                obj8 = obj3;
                                if (text == null) {
                                    text = "";
                                }
                                anijson = text;
                                Result.Companion companion10 = Result.Companion;
                                TorraStream torraStream3 = this;
                                isAnime3 = isAnime2;
                                anijson2 = anijson;
                                obj9 = Result.constructor-impl(new JSONObject(anijson2));
                                if (Result.isFailure-impl(obj9)) {
                                    obj9 = null;
                                }
                                aniJson = (JSONObject) obj9;
                                if (aniJson != null) {
                                    mappings = aniJson.optJSONObject("mappings");
                                } else {
                                    mappings = null;
                                }
                                if (mappings != null) {
                                    kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                                } else {
                                    kitsuId = null;
                                }
                                if (mappings != null) {
                                    kitsuId2 = kitsuId;
                                    strOptString = mappings.optString("type", "");
                                    if (strOptString != null) {
                                        mappings2 = mappings;
                                        if (StringsKt.contains(strOptString, "MOVIE", true)) {
                                        }
                                        if (i != 0) {
                                            numBoxInt = Boxing.boxInt(1);
                                        } else {
                                            numBoxInt = (Integer) episode.element;
                                        }
                                        episode.element = numBoxInt;
                                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                        if (anidbEid != null) {
                                            anidbEid2 = anidbEid.intValue();
                                        } else {
                                            anidbEid2 = 0;
                                        }
                                        anijson3 = anijson2;
                                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                        SharedPreferences sharedPreferences3 = this.sharedPref;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = function4;
                                        c00062.L$3 = provider2;
                                        c00062.L$4 = key2;
                                        c00062.L$5 = dataObj;
                                        c00062.L$6 = title;
                                        c00062.L$7 = season;
                                        c00062.L$8 = episode;
                                        c00062.L$9 = id;
                                        c00062.L$10 = year2;
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                        c00062.L$15 = kitsuId2;
                                        c00062.L$16 = torrentioapiUrl;
                                        c00062.Z$0 = isAnime;
                                        c00062.Z$1 = isAnime3;
                                        c00062.I$0 = i;
                                        c00062.I$1 = anidbEid2;
                                        c00062.label = 2;
                                        anidbEid3 = anidbEid2;
                                        torraStream = this;
                                        objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences3, Meteorfortheweebs, c00062);
                                        if (objBuildMeteorUrl == obj8) {
                                            return obj8;
                                        }
                                        Ref.ObjectRef objectRef3 = episode;
                                        obj10 = objBuildMeteorUrl;
                                        dataObj2 = dataObj;
                                        episode2 = objectRef3;
                                        obj11 = obj8;
                                        isCasting2 = isAnime;
                                        aniJson2 = aniJson;
                                        i2 = i;
                                        function6 = function4;
                                        title2 = title;
                                        aniResponse2 = aniResponse;
                                        isAnime4 = isAnime3;
                                        mappings3 = mappings2;
                                        torrentioapiUrl2 = torrentioapiUrl;
                                        season2 = season;
                                        kitsuId3 = kitsuId2;
                                        id2 = id;
                                        anidbEid4 = anidbEid3;
                                        meteorUrl = (String) obj10;
                                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                                        str = key2;
                                        if (str != null) {
                                            z = true;
                                        } else {
                                            z = true;
                                        }
                                        if (z) {
                                            str2 = str5;
                                            if (!Intrinsics.areEqual(provider2, str2)) {
                                                str5 = str2;
                                                anidbEid6 = anidbEid4;
                                                torrentioapiUrl6 = torrentioapiUrl2;
                                                Function1 filtered3 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                                Function1[] function1Arr5 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered3};
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = function5;
                                                c00062.L$2 = function6;
                                                c00062.L$3 = provider2;
                                                c00062.L$4 = key2;
                                                c00062.L$5 = dataObj2;
                                                c00062.L$6 = title2;
                                                c00062.L$7 = season2;
                                                c00062.L$8 = episode2;
                                                c00062.L$9 = id2;
                                                c00062.L$10 = year2;
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = kitsuId3;
                                                c00062.L$16 = torrentioapiUrl6;
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                                c00062.L$18 = function1FilteredCallback;
                                                c00062.Z$0 = isCasting2;
                                                isAnime6 = isAnime4;
                                                c00062.Z$1 = isAnime6;
                                                function9 = function6;
                                                i4 = i2;
                                                c00062.I$0 = i4;
                                                c00062.I$1 = anidbEid6;
                                                dataObj4 = dataObj2;
                                                c00062.label = 3;
                                                c = 3;
                                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr5, c00062);
                                                obj12 = obj11;
                                                if (objRunAllAsync == obj12) {
                                                    return obj12;
                                                }
                                                aniResponse3 = aniResponse2;
                                                torrentioapiUrl7 = torrentioapiUrl6;
                                                torrentioapiUrl8 = title2;
                                                anidbEid5 = anidbEid6;
                                                data3 = provider2;
                                                function10 = function1FilteredCallback;
                                                isAnime7 = isAnime6;
                                                isAnime8 = isCasting2;
                                                i5 = i4;
                                                meteorUrl2 = meteorUrl;
                                                year3 = year2;
                                                kitsuId4 = kitsuId3;
                                                function7 = function10;
                                                i3 = i5;
                                                isAnime5 = isAnime7;
                                                isCasting2 = isAnime8;
                                                torrentioapiUrl4 = torrentioapiUrl7;
                                                title3 = torrentioapiUrl8;
                                                key3 = key2;
                                                torrentioapiUrl5 = id2;
                                                season3 = season2;
                                                episode3 = episode2;
                                                function8 = function9;
                                                dataObj3 = dataObj4;
                                                str3 = data3;
                                                if (str3 != null) {
                                                    z2 = true;
                                                } else {
                                                    z2 = true;
                                                }
                                                if (!z2) {
                                                    str4 = key3;
                                                    if (str4 != null) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    if (!z3) {
                                                        if (Intrinsics.areEqual(data3, str5)) {
                                                            Function1<ExtractorLink, Unit> function113 = function7;
                                                            key5 = key3;
                                                            function7 = function113;
                                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function113, null)};
                                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                            c00062.L$1 = function5;
                                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                            c00062.L$7 = season3;
                                                            c00062.L$8 = episode3;
                                                            c00062.L$9 = torrentioapiUrl5;
                                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                            c00062.Z$0 = isCasting2;
                                                            c00062.Z$1 = isAnime5;
                                                            c00062.I$0 = i3;
                                                            c00062.I$1 = anidbEid5;
                                                            c00062.label = 4;
                                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                                return obj12;
                                                            }
                                                            provider4 = data3;
                                                            meteorUrl3 = meteorUrl2;
                                                            anijson5 = anijson3;
                                                            provider5 = data2;
                                                            data2 = provider5;
                                                            meteorUrl2 = meteorUrl3;
                                                            anijson3 = anijson5;
                                                            data3 = provider4;
                                                            key3 = key5;
                                                        }
                                                        Unit unit5 = Unit.INSTANCE;
                                                        torrentioapiUrl11 = data3;
                                                        kitsuId5 = kitsuId4;
                                                        data4 = torrentioapiUrl5;
                                                        anijson4 = anijson3;
                                                        torrentioapiUrl10 = torrentioapiUrl4;
                                                        aniResponse5 = aniResponse3;
                                                    }
                                                    num = (Integer) episode3.element;
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 6;
                                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    return Boxing.boxBoolean(true);
                                                }
                                                key4 = key3;
                                                function1Arr = new Function1[8];
                                                torrentioapiUrl9 = torrentioapiUrl4;
                                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                                provider3 = data3;
                                                Function1<? super ExtractorLink, Unit> function114 = function8;
                                                episode4 = episode3;
                                                season4 = season3;
                                                id3 = torrentioapiUrl5;
                                                LoadData dataObj12 = dataObj3;
                                                C00146 c001410 = new C00146(dataObj12, id3, season4, episode4, function114, null);
                                                function8 = function114;
                                                function1Arr[1] = c001410;
                                                aniResponse4 = aniResponse3;
                                                function1Arr[2] = new C00157(dataObj12, anidbEid5, function8, null);
                                                Integer kitsuId10 = kitsuId4;
                                                function1Arr[c] = new C00168(kitsuId10, season4, episode4, function7, null);
                                                Function1<ExtractorLink, Unit> function115 = function7;
                                                function7 = function115;
                                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function115, null);
                                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                                kitsuId5 = kitsuId10;
                                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                                isAnime9 = isAnime5;
                                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = function5;
                                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00062.L$7 = season4;
                                                c00062.L$8 = episode4;
                                                c00062.L$9 = id3;
                                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00062.Z$0 = isCasting2;
                                                c00062.Z$1 = isAnime9;
                                                c00062.I$0 = i3;
                                                c00062.I$1 = anidbEid5;
                                                c00062.label = 5;
                                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                                    return obj12;
                                                }
                                                data4 = id3;
                                                isAnime5 = isAnime9;
                                                season3 = season4;
                                                episode3 = episode4;
                                                key3 = key4;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl9;
                                                torrentioapiUrl11 = provider3;
                                                aniResponse5 = aniResponse4;
                                                num = (Integer) episode3.element;
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00062.Z$0 = isCasting2;
                                                c00062.Z$1 = isAnime5;
                                                c00062.I$0 = i3;
                                                c00062.I$1 = anidbEid5;
                                                c00062.label = 6;
                                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                    return obj12;
                                                }
                                                return Boxing.boxBoolean(true);
                                            }
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                            str5 = str2;
                                        } else {
                                            torrentioapiUrl3 = torrentioapiUrl2;
                                        }
                                        obj12 = obj11;
                                        int i8 = i2;
                                        c = 3;
                                        LoadData dataObj13 = dataObj2;
                                        aniResponse3 = aniResponse2;
                                        title3 = title2;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function1FilteredCallback;
                                        i3 = i8;
                                        torrentioapiUrl4 = torrentioapiUrl3;
                                        meteorUrl2 = meteorUrl;
                                        anidbEid5 = anidbEid4;
                                        data3 = provider2;
                                        isAnime5 = isAnime4;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        episode3 = episode2;
                                        dataObj3 = dataObj13;
                                        season3 = season2;
                                        function8 = function6;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function116 = function7;
                                                    key5 = key3;
                                                    function7 = function116;
                                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function116, null)};
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = function5;
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = season3;
                                                    c00062.L$8 = episode3;
                                                    c00062.L$9 = torrentioapiUrl5;
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit6 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function117 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadData dataObj14 = dataObj3;
                                        C00146 c001411 = new C00146(dataObj14, id3, season4, episode4, function117, null);
                                        function8 = function117;
                                        function1Arr[1] = c001411;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00157(dataObj14, anidbEid5, function8, null);
                                        Integer kitsuId11 = kitsuId4;
                                        function1Arr[c] = new C00168(kitsuId11, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function118 = function7;
                                        function7 = function118;
                                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function118, null);
                                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId11;
                                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season4;
                                        c00062.L$8 = episode4;
                                        c00062.L$9 = id3;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime9;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    mappings2 = mappings;
                                } else {
                                    kitsuId2 = kitsuId;
                                    mappings2 = mappings;
                                }
                                if (i != 0) {
                                    numBoxInt = Boxing.boxInt(1);
                                } else {
                                    numBoxInt = (Integer) episode.element;
                                }
                                episode.element = numBoxInt;
                                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                if (anidbEid != null) {
                                    anidbEid2 = anidbEid.intValue();
                                } else {
                                    anidbEid2 = 0;
                                }
                                anijson3 = anijson2;
                                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                SharedPreferences sharedPreferences4 = this.sharedPref;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = function4;
                                c00062.L$3 = provider2;
                                c00062.L$4 = key2;
                                c00062.L$5 = dataObj;
                                c00062.L$6 = title;
                                c00062.L$7 = season;
                                c00062.L$8 = episode;
                                c00062.L$9 = id;
                                c00062.L$10 = year2;
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                c00062.L$15 = kitsuId2;
                                c00062.L$16 = torrentioapiUrl;
                                c00062.Z$0 = isAnime;
                                c00062.Z$1 = isAnime3;
                                c00062.I$0 = i;
                                c00062.I$1 = anidbEid2;
                                c00062.label = 2;
                                anidbEid3 = anidbEid2;
                                torraStream = this;
                                objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences4, Meteorfortheweebs, c00062);
                                if (objBuildMeteorUrl == obj8) {
                                    return obj8;
                                }
                                Ref.ObjectRef objectRef4 = episode;
                                obj10 = objBuildMeteorUrl;
                                dataObj2 = dataObj;
                                episode2 = objectRef4;
                                obj11 = obj8;
                                isCasting2 = isAnime;
                                aniJson2 = aniJson;
                                i2 = i;
                                function6 = function4;
                                title2 = title;
                                aniResponse2 = aniResponse;
                                isAnime4 = isAnime3;
                                mappings3 = mappings2;
                                torrentioapiUrl2 = torrentioapiUrl;
                                season2 = season;
                                kitsuId3 = kitsuId2;
                                id2 = id;
                                anidbEid4 = anidbEid3;
                                meteorUrl = (String) obj10;
                                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                                str = key2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    str2 = str5;
                                    if (!Intrinsics.areEqual(provider2, str2)) {
                                        str5 = str2;
                                        anidbEid6 = anidbEid4;
                                        torrentioapiUrl6 = torrentioapiUrl2;
                                        Function1 filtered4 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                        Function1[] function1Arr6 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered4};
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = function6;
                                        c00062.L$3 = provider2;
                                        c00062.L$4 = key2;
                                        c00062.L$5 = dataObj2;
                                        c00062.L$6 = title2;
                                        c00062.L$7 = season2;
                                        c00062.L$8 = episode2;
                                        c00062.L$9 = id2;
                                        c00062.L$10 = year2;
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = kitsuId3;
                                        c00062.L$16 = torrentioapiUrl6;
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00062.L$18 = function1FilteredCallback;
                                        c00062.Z$0 = isCasting2;
                                        isAnime6 = isAnime4;
                                        c00062.Z$1 = isAnime6;
                                        function9 = function6;
                                        i4 = i2;
                                        c00062.I$0 = i4;
                                        c00062.I$1 = anidbEid6;
                                        dataObj4 = dataObj2;
                                        c00062.label = 3;
                                        c = 3;
                                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr6, c00062);
                                        obj12 = obj11;
                                        if (objRunAllAsync == obj12) {
                                            return obj12;
                                        }
                                        aniResponse3 = aniResponse2;
                                        torrentioapiUrl7 = torrentioapiUrl6;
                                        torrentioapiUrl8 = title2;
                                        anidbEid5 = anidbEid6;
                                        data3 = provider2;
                                        function10 = function1FilteredCallback;
                                        isAnime7 = isAnime6;
                                        isAnime8 = isCasting2;
                                        i5 = i4;
                                        meteorUrl2 = meteorUrl;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function10;
                                        i3 = i5;
                                        isAnime5 = isAnime7;
                                        isCasting2 = isAnime8;
                                        torrentioapiUrl4 = torrentioapiUrl7;
                                        title3 = torrentioapiUrl8;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        season3 = season2;
                                        episode3 = episode2;
                                        function8 = function9;
                                        dataObj3 = dataObj4;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function119 = function7;
                                                    key5 = key3;
                                                    function7 = function119;
                                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function119, null)};
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = function5;
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = season3;
                                                    c00062.L$8 = episode3;
                                                    c00062.L$9 = torrentioapiUrl5;
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit7 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function1110 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadData dataObj15 = dataObj3;
                                        C00146 c001412 = new C00146(dataObj15, id3, season4, episode4, function1110, null);
                                        function8 = function1110;
                                        function1Arr[1] = c001412;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00157(dataObj15, anidbEid5, function8, null);
                                        Integer kitsuId12 = kitsuId4;
                                        function1Arr[c] = new C00168(kitsuId12, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function1111 = function7;
                                        function7 = function1111;
                                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function1111, null);
                                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId12;
                                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season4;
                                        c00062.L$8 = episode4;
                                        c00062.L$9 = id3;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime9;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                    str5 = str2;
                                } else {
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                }
                                obj12 = obj11;
                                int i9 = i2;
                                c = 3;
                                LoadData dataObj16 = dataObj2;
                                aniResponse3 = aniResponse2;
                                title3 = title2;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function1FilteredCallback;
                                i3 = i9;
                                torrentioapiUrl4 = torrentioapiUrl3;
                                meteorUrl2 = meteorUrl;
                                anidbEid5 = anidbEid4;
                                data3 = provider2;
                                isAnime5 = isAnime4;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                episode3 = episode2;
                                dataObj3 = dataObj16;
                                season3 = season2;
                                function8 = function6;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function1112 = function7;
                                            key5 = key3;
                                            function7 = function1112;
                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function1112, null)};
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = function5;
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = season3;
                                            c00062.L$8 = episode3;
                                            c00062.L$9 = torrentioapiUrl5;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit8 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function1113 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadData dataObj17 = dataObj3;
                                C00146 c001413 = new C00146(dataObj17, id3, season4, episode4, function1113, null);
                                function8 = function1113;
                                function1Arr[1] = c001413;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00157(dataObj17, anidbEid5, function8, null);
                                Integer kitsuId13 = kitsuId4;
                                function1Arr[c] = new C00168(kitsuId13, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function1114 = function7;
                                function7 = function1114;
                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function1114, null);
                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId13;
                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = season4;
                                c00062.L$8 = episode4;
                                c00062.L$9 = id3;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime9;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            str5 = "AIO Streams";
                            key = key;
                            obj3 = coroutine_suspended;
                            isAnime = isCasting;
                            function3 = function1;
                            function4 = function2;
                            dataObj = dataObj5;
                            isAnime2 = isAnime10;
                            title = title4;
                            season = season5;
                            id = id4;
                            year = year4;
                            provider = provider6;
                            data2 = data;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        obj3 = coroutine_suspended;
                        isAnime = isCasting;
                        function3 = function1;
                        function4 = function2;
                        dataObj = dataObj5;
                        isAnime2 = isAnime10;
                        title = title4;
                        season = season5;
                        id = id4;
                        year = year4;
                        provider = provider6;
                        data2 = data;
                        Result.Companion companion11 = Result.Companion;
                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj6 = obj5;
                        year2 = year;
                        provider2 = provider;
                        function5 = function3;
                        key2 = key;
                        if (Result.isFailure-impl(obj6)) {
                            obj7 = null;
                        } else {
                            obj7 = obj6;
                        }
                        aniResponse = (NiceResponse) obj7;
                        if (aniResponse != null) {
                            text = aniResponse.getText();
                        } else {
                            text = null;
                        }
                        obj8 = obj3;
                        if (text == null) {
                            text = "";
                        }
                        anijson = text;
                        Result.Companion companion12 = Result.Companion;
                        TorraStream torraStream4 = this;
                        isAnime3 = isAnime2;
                        anijson2 = anijson;
                        obj9 = Result.constructor-impl(new JSONObject(anijson2));
                        if (Result.isFailure-impl(obj9)) {
                            obj9 = null;
                        }
                        aniJson = (JSONObject) obj9;
                        if (aniJson != null) {
                            mappings = aniJson.optJSONObject("mappings");
                        } else {
                            mappings = null;
                        }
                        if (mappings != null) {
                            kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                        } else {
                            kitsuId = null;
                        }
                        if (mappings != null) {
                            kitsuId2 = kitsuId;
                            strOptString = mappings.optString("type", "");
                            if (strOptString != null) {
                                mappings2 = mappings;
                                if (StringsKt.contains(strOptString, "MOVIE", true)) {
                                }
                                if (i != 0) {
                                    numBoxInt = Boxing.boxInt(1);
                                } else {
                                    numBoxInt = (Integer) episode.element;
                                }
                                episode.element = numBoxInt;
                                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                                if (anidbEid != null) {
                                    anidbEid2 = anidbEid.intValue();
                                } else {
                                    anidbEid2 = 0;
                                }
                                anijson3 = anijson2;
                                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                                SharedPreferences sharedPreferences5 = this.sharedPref;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = function4;
                                c00062.L$3 = provider2;
                                c00062.L$4 = key2;
                                c00062.L$5 = dataObj;
                                c00062.L$6 = title;
                                c00062.L$7 = season;
                                c00062.L$8 = episode;
                                c00062.L$9 = id;
                                c00062.L$10 = year2;
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                                c00062.L$15 = kitsuId2;
                                c00062.L$16 = torrentioapiUrl;
                                c00062.Z$0 = isAnime;
                                c00062.Z$1 = isAnime3;
                                c00062.I$0 = i;
                                c00062.I$1 = anidbEid2;
                                c00062.label = 2;
                                anidbEid3 = anidbEid2;
                                torraStream = this;
                                objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences5, Meteorfortheweebs, c00062);
                                if (objBuildMeteorUrl == obj8) {
                                    return obj8;
                                }
                                Ref.ObjectRef objectRef5 = episode;
                                obj10 = objBuildMeteorUrl;
                                dataObj2 = dataObj;
                                episode2 = objectRef5;
                                obj11 = obj8;
                                isCasting2 = isAnime;
                                aniJson2 = aniJson;
                                i2 = i;
                                function6 = function4;
                                title2 = title;
                                aniResponse2 = aniResponse;
                                isAnime4 = isAnime3;
                                mappings3 = mappings2;
                                torrentioapiUrl2 = torrentioapiUrl;
                                season2 = season;
                                kitsuId3 = kitsuId2;
                                id2 = id;
                                anidbEid4 = anidbEid3;
                                meteorUrl = (String) obj10;
                                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                                str = key2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    str2 = str5;
                                    if (!Intrinsics.areEqual(provider2, str2)) {
                                        str5 = str2;
                                        anidbEid6 = anidbEid4;
                                        torrentioapiUrl6 = torrentioapiUrl2;
                                        Function1 filtered5 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                        Function1[] function1Arr7 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered5};
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = function6;
                                        c00062.L$3 = provider2;
                                        c00062.L$4 = key2;
                                        c00062.L$5 = dataObj2;
                                        c00062.L$6 = title2;
                                        c00062.L$7 = season2;
                                        c00062.L$8 = episode2;
                                        c00062.L$9 = id2;
                                        c00062.L$10 = year2;
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = kitsuId3;
                                        c00062.L$16 = torrentioapiUrl6;
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00062.L$18 = function1FilteredCallback;
                                        c00062.Z$0 = isCasting2;
                                        isAnime6 = isAnime4;
                                        c00062.Z$1 = isAnime6;
                                        function9 = function6;
                                        i4 = i2;
                                        c00062.I$0 = i4;
                                        c00062.I$1 = anidbEid6;
                                        dataObj4 = dataObj2;
                                        c00062.label = 3;
                                        c = 3;
                                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr7, c00062);
                                        obj12 = obj11;
                                        if (objRunAllAsync == obj12) {
                                            return obj12;
                                        }
                                        aniResponse3 = aniResponse2;
                                        torrentioapiUrl7 = torrentioapiUrl6;
                                        torrentioapiUrl8 = title2;
                                        anidbEid5 = anidbEid6;
                                        data3 = provider2;
                                        function10 = function1FilteredCallback;
                                        isAnime7 = isAnime6;
                                        isAnime8 = isCasting2;
                                        i5 = i4;
                                        meteorUrl2 = meteorUrl;
                                        year3 = year2;
                                        kitsuId4 = kitsuId3;
                                        function7 = function10;
                                        i3 = i5;
                                        isAnime5 = isAnime7;
                                        isCasting2 = isAnime8;
                                        torrentioapiUrl4 = torrentioapiUrl7;
                                        title3 = torrentioapiUrl8;
                                        key3 = key2;
                                        torrentioapiUrl5 = id2;
                                        season3 = season2;
                                        episode3 = episode2;
                                        function8 = function9;
                                        dataObj3 = dataObj4;
                                        str3 = data3;
                                        if (str3 != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            str4 = key3;
                                            if (str4 != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                if (Intrinsics.areEqual(data3, str5)) {
                                                    Function1<ExtractorLink, Unit> function1115 = function7;
                                                    key5 = key3;
                                                    function7 = function1115;
                                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function1115, null)};
                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00062.L$1 = function5;
                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                    c00062.L$7 = season3;
                                                    c00062.L$8 = episode3;
                                                    c00062.L$9 = torrentioapiUrl5;
                                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00062.Z$0 = isCasting2;
                                                    c00062.Z$1 = isAnime5;
                                                    c00062.I$0 = i3;
                                                    c00062.I$1 = anidbEid5;
                                                    c00062.label = 4;
                                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                        return obj12;
                                                    }
                                                    provider4 = data3;
                                                    meteorUrl3 = meteorUrl2;
                                                    anijson5 = anijson3;
                                                    provider5 = data2;
                                                    data2 = provider5;
                                                    meteorUrl2 = meteorUrl3;
                                                    anijson3 = anijson5;
                                                    data3 = provider4;
                                                    key3 = key5;
                                                }
                                                Unit unit9 = Unit.INSTANCE;
                                                torrentioapiUrl11 = data3;
                                                kitsuId5 = kitsuId4;
                                                data4 = torrentioapiUrl5;
                                                anijson4 = anijson3;
                                                torrentioapiUrl10 = torrentioapiUrl4;
                                                aniResponse5 = aniResponse3;
                                            }
                                            num = (Integer) episode3.element;
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 6;
                                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                                return obj12;
                                            }
                                            return Boxing.boxBoolean(true);
                                        }
                                        key4 = key3;
                                        function1Arr = new Function1[8];
                                        torrentioapiUrl9 = torrentioapiUrl4;
                                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                        provider3 = data3;
                                        Function1<? super ExtractorLink, Unit> function1116 = function8;
                                        episode4 = episode3;
                                        season4 = season3;
                                        id3 = torrentioapiUrl5;
                                        LoadData dataObj18 = dataObj3;
                                        C00146 c001414 = new C00146(dataObj18, id3, season4, episode4, function1116, null);
                                        function8 = function1116;
                                        function1Arr[1] = c001414;
                                        aniResponse4 = aniResponse3;
                                        function1Arr[2] = new C00157(dataObj18, anidbEid5, function8, null);
                                        Integer kitsuId14 = kitsuId4;
                                        function1Arr[c] = new C00168(kitsuId14, season4, episode4, function7, null);
                                        Function1<ExtractorLink, Unit> function1117 = function7;
                                        function7 = function1117;
                                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function1117, null);
                                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                        kitsuId5 = kitsuId14;
                                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                        isAnime9 = isAnime5;
                                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season4;
                                        c00062.L$8 = episode4;
                                        c00062.L$9 = id3;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime9;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 5;
                                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                            return obj12;
                                        }
                                        data4 = id3;
                                        isAnime5 = isAnime9;
                                        season3 = season4;
                                        episode3 = episode4;
                                        key3 = key4;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl9;
                                        torrentioapiUrl11 = provider3;
                                        aniResponse5 = aniResponse4;
                                        num = (Integer) episode3.element;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                    str5 = str2;
                                } else {
                                    torrentioapiUrl3 = torrentioapiUrl2;
                                }
                                obj12 = obj11;
                                int i10 = i2;
                                c = 3;
                                LoadData dataObj19 = dataObj2;
                                aniResponse3 = aniResponse2;
                                title3 = title2;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function1FilteredCallback;
                                i3 = i10;
                                torrentioapiUrl4 = torrentioapiUrl3;
                                meteorUrl2 = meteorUrl;
                                anidbEid5 = anidbEid4;
                                data3 = provider2;
                                isAnime5 = isAnime4;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                episode3 = episode2;
                                dataObj3 = dataObj19;
                                season3 = season2;
                                function8 = function6;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function1118 = function7;
                                            key5 = key3;
                                            function7 = function1118;
                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function1118, null)};
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = function5;
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = season3;
                                            c00062.L$8 = episode3;
                                            c00062.L$9 = torrentioapiUrl5;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit10 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function1119 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadData dataObj110 = dataObj3;
                                C00146 c001415 = new C00146(dataObj110, id3, season4, episode4, function1119, null);
                                function8 = function1119;
                                function1Arr[1] = c001415;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00157(dataObj110, anidbEid5, function8, null);
                                Integer kitsuId15 = kitsuId4;
                                function1Arr[c] = new C00168(kitsuId15, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function11110 = function7;
                                function7 = function11110;
                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11110, null);
                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId15;
                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = season4;
                                c00062.L$8 = episode4;
                                c00062.L$9 = id3;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime9;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            mappings2 = mappings;
                        } else {
                            kitsuId2 = kitsuId;
                            mappings2 = mappings;
                        }
                        if (i != 0) {
                            numBoxInt = Boxing.boxInt(1);
                        } else {
                            numBoxInt = (Integer) episode.element;
                        }
                        episode.element = numBoxInt;
                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                        if (anidbEid != null) {
                            anidbEid2 = anidbEid.intValue();
                        } else {
                            anidbEid2 = 0;
                        }
                        anijson3 = anijson2;
                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                        SharedPreferences sharedPreferences6 = this.sharedPref;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = function4;
                        c00062.L$3 = provider2;
                        c00062.L$4 = key2;
                        c00062.L$5 = dataObj;
                        c00062.L$6 = title;
                        c00062.L$7 = season;
                        c00062.L$8 = episode;
                        c00062.L$9 = id;
                        c00062.L$10 = year2;
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                        c00062.L$15 = kitsuId2;
                        c00062.L$16 = torrentioapiUrl;
                        c00062.Z$0 = isAnime;
                        c00062.Z$1 = isAnime3;
                        c00062.I$0 = i;
                        c00062.I$1 = anidbEid2;
                        c00062.label = 2;
                        anidbEid3 = anidbEid2;
                        torraStream = this;
                        objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences6, Meteorfortheweebs, c00062);
                        if (objBuildMeteorUrl == obj8) {
                            return obj8;
                        }
                        Ref.ObjectRef objectRef6 = episode;
                        obj10 = objBuildMeteorUrl;
                        dataObj2 = dataObj;
                        episode2 = objectRef6;
                        obj11 = obj8;
                        isCasting2 = isAnime;
                        aniJson2 = aniJson;
                        i2 = i;
                        function6 = function4;
                        title2 = title;
                        aniResponse2 = aniResponse;
                        isAnime4 = isAnime3;
                        mappings3 = mappings2;
                        torrentioapiUrl2 = torrentioapiUrl;
                        season2 = season;
                        kitsuId3 = kitsuId2;
                        id2 = id;
                        anidbEid4 = anidbEid3;
                        meteorUrl = (String) obj10;
                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                        str = key2;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            str2 = str5;
                            if (!Intrinsics.areEqual(provider2, str2)) {
                                str5 = str2;
                                anidbEid6 = anidbEid4;
                                torrentioapiUrl6 = torrentioapiUrl2;
                                Function1 filtered6 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                Function1[] function1Arr8 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered6};
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = function6;
                                c00062.L$3 = provider2;
                                c00062.L$4 = key2;
                                c00062.L$5 = dataObj2;
                                c00062.L$6 = title2;
                                c00062.L$7 = season2;
                                c00062.L$8 = episode2;
                                c00062.L$9 = id2;
                                c00062.L$10 = year2;
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = kitsuId3;
                                c00062.L$16 = torrentioapiUrl6;
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                c00062.L$18 = function1FilteredCallback;
                                c00062.Z$0 = isCasting2;
                                isAnime6 = isAnime4;
                                c00062.Z$1 = isAnime6;
                                function9 = function6;
                                i4 = i2;
                                c00062.I$0 = i4;
                                c00062.I$1 = anidbEid6;
                                dataObj4 = dataObj2;
                                c00062.label = 3;
                                c = 3;
                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr8, c00062);
                                obj12 = obj11;
                                if (objRunAllAsync == obj12) {
                                    return obj12;
                                }
                                aniResponse3 = aniResponse2;
                                torrentioapiUrl7 = torrentioapiUrl6;
                                torrentioapiUrl8 = title2;
                                anidbEid5 = anidbEid6;
                                data3 = provider2;
                                function10 = function1FilteredCallback;
                                isAnime7 = isAnime6;
                                isAnime8 = isCasting2;
                                i5 = i4;
                                meteorUrl2 = meteorUrl;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function10;
                                i3 = i5;
                                isAnime5 = isAnime7;
                                isCasting2 = isAnime8;
                                torrentioapiUrl4 = torrentioapiUrl7;
                                title3 = torrentioapiUrl8;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                season3 = season2;
                                episode3 = episode2;
                                function8 = function9;
                                dataObj3 = dataObj4;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function11111 = function7;
                                            key5 = key3;
                                            function7 = function11111;
                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11111, null)};
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = function5;
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = season3;
                                            c00062.L$8 = episode3;
                                            c00062.L$9 = torrentioapiUrl5;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function11112 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadData dataObj111 = dataObj3;
                                C00146 c001416 = new C00146(dataObj111, id3, season4, episode4, function11112, null);
                                function8 = function11112;
                                function1Arr[1] = c001416;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00157(dataObj111, anidbEid5, function8, null);
                                Integer kitsuId16 = kitsuId4;
                                function1Arr[c] = new C00168(kitsuId16, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function11113 = function7;
                                function7 = function11113;
                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11113, null);
                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId16;
                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = season4;
                                c00062.L$8 = episode4;
                                c00062.L$9 = id3;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime9;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            torrentioapiUrl3 = torrentioapiUrl2;
                            str5 = str2;
                        } else {
                            torrentioapiUrl3 = torrentioapiUrl2;
                        }
                        obj12 = obj11;
                        int i11 = i2;
                        c = 3;
                        LoadData dataObj112 = dataObj2;
                        aniResponse3 = aniResponse2;
                        title3 = title2;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function1FilteredCallback;
                        i3 = i11;
                        torrentioapiUrl4 = torrentioapiUrl3;
                        meteorUrl2 = meteorUrl;
                        anidbEid5 = anidbEid4;
                        data3 = provider2;
                        isAnime5 = isAnime4;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        episode3 = episode2;
                        dataObj3 = dataObj112;
                        season3 = season2;
                        function8 = function6;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function11114 = function7;
                                    key5 = key3;
                                    function7 = function11114;
                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11114, null)};
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = function5;
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = season3;
                                    c00062.L$8 = episode3;
                                    c00062.L$9 = torrentioapiUrl5;
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit12 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function11115 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadData dataObj113 = dataObj3;
                        C00146 c001417 = new C00146(dataObj113, id3, season4, episode4, function11115, null);
                        function8 = function11115;
                        function1Arr[1] = c001417;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00157(dataObj113, anidbEid5, function8, null);
                        Integer kitsuId17 = kitsuId4;
                        function1Arr[c] = new C00168(kitsuId17, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function11116 = function7;
                        function7 = function11116;
                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11116, null);
                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId17;
                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = season4;
                        c00062.L$8 = episode4;
                        c00062.L$9 = id3;
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime9;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime5;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                } catch (Throwable th11) {
                    th = th11;
                    obj3 = coroutine_suspended;
                }
                break;
            case 1:
                isAnime2 = c00062.Z$1;
                isAnime = c00062.Z$0;
                year = (Integer) c00062.L$10;
                id = (String) c00062.L$9;
                episode = (Ref.ObjectRef) c00062.L$8;
                season = (Integer) c00062.L$7;
                title = (String) c00062.L$6;
                dataObj = (LoadData) c00062.L$5;
                String key6 = (String) c00062.L$4;
                provider = (String) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function20 = (Function1) c00062.L$2;
                function3 = (Function1) c00062.L$1;
                data2 = (String) c00062.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj3 = coroutine_suspended;
                    str5 = "AIO Streams";
                    key = key6;
                    obj4 = $result;
                    function4 = function20;
                    obj5 = Result.constructor-impl((NiceResponse) obj4);
                    break;
                } catch (Throwable th12) {
                    th = th12;
                    obj3 = coroutine_suspended;
                    str5 = "AIO Streams";
                    key = key6;
                    function4 = function20;
                    Result.Companion companion13 = Result.Companion;
                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj6 = obj5;
                    year2 = year;
                    provider2 = provider;
                    function5 = function3;
                    key2 = key;
                    if (Result.isFailure-impl(obj6)) {
                        obj7 = null;
                    } else {
                        obj7 = obj6;
                    }
                    aniResponse = (NiceResponse) obj7;
                    if (aniResponse != null) {
                        text = aniResponse.getText();
                    } else {
                        text = null;
                    }
                    obj8 = obj3;
                    if (text == null) {
                        text = "";
                    }
                    anijson = text;
                    Result.Companion companion14 = Result.Companion;
                    TorraStream torraStream5 = this;
                    isAnime3 = isAnime2;
                    anijson2 = anijson;
                    obj9 = Result.constructor-impl(new JSONObject(anijson2));
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = null;
                    }
                    aniJson = (JSONObject) obj9;
                    if (aniJson != null) {
                        mappings = aniJson.optJSONObject("mappings");
                    } else {
                        mappings = null;
                    }
                    if (mappings != null) {
                        kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                    } else {
                        kitsuId = null;
                    }
                    if (mappings != null) {
                        kitsuId2 = kitsuId;
                        strOptString = mappings.optString("type", "");
                        if (strOptString != null) {
                            mappings2 = mappings;
                            if (StringsKt.contains(strOptString, "MOVIE", true)) {
                            }
                            if (i != 0) {
                                numBoxInt = Boxing.boxInt(1);
                            } else {
                                numBoxInt = (Integer) episode.element;
                            }
                            episode.element = numBoxInt;
                            anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                            if (anidbEid != null) {
                                anidbEid2 = anidbEid.intValue();
                            } else {
                                anidbEid2 = 0;
                            }
                            anijson3 = anijson2;
                            torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                            SharedPreferences sharedPreferences7 = this.sharedPref;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = function4;
                            c00062.L$3 = provider2;
                            c00062.L$4 = key2;
                            c00062.L$5 = dataObj;
                            c00062.L$6 = title;
                            c00062.L$7 = season;
                            c00062.L$8 = episode;
                            c00062.L$9 = id;
                            c00062.L$10 = year2;
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                            c00062.L$15 = kitsuId2;
                            c00062.L$16 = torrentioapiUrl;
                            c00062.Z$0 = isAnime;
                            c00062.Z$1 = isAnime3;
                            c00062.I$0 = i;
                            c00062.I$1 = anidbEid2;
                            c00062.label = 2;
                            anidbEid3 = anidbEid2;
                            torraStream = this;
                            objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences7, Meteorfortheweebs, c00062);
                            if (objBuildMeteorUrl == obj8) {
                                return obj8;
                            }
                            Ref.ObjectRef objectRef7 = episode;
                            obj10 = objBuildMeteorUrl;
                            dataObj2 = dataObj;
                            episode2 = objectRef7;
                            obj11 = obj8;
                            isCasting2 = isAnime;
                            aniJson2 = aniJson;
                            i2 = i;
                            function6 = function4;
                            title2 = title;
                            aniResponse2 = aniResponse;
                            isAnime4 = isAnime3;
                            mappings3 = mappings2;
                            torrentioapiUrl2 = torrentioapiUrl;
                            season2 = season;
                            kitsuId3 = kitsuId2;
                            id2 = id;
                            anidbEid4 = anidbEid3;
                            meteorUrl = (String) obj10;
                            function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                            str = key2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                str2 = str5;
                                if (!Intrinsics.areEqual(provider2, str2)) {
                                    str5 = str2;
                                    anidbEid6 = anidbEid4;
                                    torrentioapiUrl6 = torrentioapiUrl2;
                                    Function1 filtered7 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                    Function1[] function1Arr9 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered7};
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = function5;
                                    c00062.L$2 = function6;
                                    c00062.L$3 = provider2;
                                    c00062.L$4 = key2;
                                    c00062.L$5 = dataObj2;
                                    c00062.L$6 = title2;
                                    c00062.L$7 = season2;
                                    c00062.L$8 = episode2;
                                    c00062.L$9 = id2;
                                    c00062.L$10 = year2;
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = kitsuId3;
                                    c00062.L$16 = torrentioapiUrl6;
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                    c00062.L$18 = function1FilteredCallback;
                                    c00062.Z$0 = isCasting2;
                                    isAnime6 = isAnime4;
                                    c00062.Z$1 = isAnime6;
                                    function9 = function6;
                                    i4 = i2;
                                    c00062.I$0 = i4;
                                    c00062.I$1 = anidbEid6;
                                    dataObj4 = dataObj2;
                                    c00062.label = 3;
                                    c = 3;
                                    objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr9, c00062);
                                    obj12 = obj11;
                                    if (objRunAllAsync == obj12) {
                                        return obj12;
                                    }
                                    aniResponse3 = aniResponse2;
                                    torrentioapiUrl7 = torrentioapiUrl6;
                                    torrentioapiUrl8 = title2;
                                    anidbEid5 = anidbEid6;
                                    data3 = provider2;
                                    function10 = function1FilteredCallback;
                                    isAnime7 = isAnime6;
                                    isAnime8 = isCasting2;
                                    i5 = i4;
                                    meteorUrl2 = meteorUrl;
                                    year3 = year2;
                                    kitsuId4 = kitsuId3;
                                    function7 = function10;
                                    i3 = i5;
                                    isAnime5 = isAnime7;
                                    isCasting2 = isAnime8;
                                    torrentioapiUrl4 = torrentioapiUrl7;
                                    title3 = torrentioapiUrl8;
                                    key3 = key2;
                                    torrentioapiUrl5 = id2;
                                    season3 = season2;
                                    episode3 = episode2;
                                    function8 = function9;
                                    dataObj3 = dataObj4;
                                    str3 = data3;
                                    if (str3 != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        str4 = key3;
                                        if (str4 != null) {
                                            z3 = true;
                                        } else {
                                            z3 = true;
                                        }
                                        if (!z3) {
                                            if (Intrinsics.areEqual(data3, str5)) {
                                                Function1<ExtractorLink, Unit> function11117 = function7;
                                                key5 = key3;
                                                function7 = function11117;
                                                function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11117, null)};
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                c00062.L$1 = function5;
                                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                                c00062.L$7 = season3;
                                                c00062.L$8 = episode3;
                                                c00062.L$9 = torrentioapiUrl5;
                                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                                c00062.Z$0 = isCasting2;
                                                c00062.Z$1 = isAnime5;
                                                c00062.I$0 = i3;
                                                c00062.I$1 = anidbEid5;
                                                c00062.label = 4;
                                                if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                    return obj12;
                                                }
                                                provider4 = data3;
                                                meteorUrl3 = meteorUrl2;
                                                anijson5 = anijson3;
                                                provider5 = data2;
                                                data2 = provider5;
                                                meteorUrl2 = meteorUrl3;
                                                anijson3 = anijson5;
                                                data3 = provider4;
                                                key3 = key5;
                                            }
                                            Unit unit13 = Unit.INSTANCE;
                                            torrentioapiUrl11 = data3;
                                            kitsuId5 = kitsuId4;
                                            data4 = torrentioapiUrl5;
                                            anijson4 = anijson3;
                                            torrentioapiUrl10 = torrentioapiUrl4;
                                            aniResponse5 = aniResponse3;
                                        }
                                        num = (Integer) episode3.element;
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 6;
                                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                            return obj12;
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    key4 = key3;
                                    function1Arr = new Function1[8];
                                    torrentioapiUrl9 = torrentioapiUrl4;
                                    function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                    provider3 = data3;
                                    Function1<? super ExtractorLink, Unit> function11118 = function8;
                                    episode4 = episode3;
                                    season4 = season3;
                                    id3 = torrentioapiUrl5;
                                    LoadData dataObj114 = dataObj3;
                                    C00146 c001418 = new C00146(dataObj114, id3, season4, episode4, function11118, null);
                                    function8 = function11118;
                                    function1Arr[1] = c001418;
                                    aniResponse4 = aniResponse3;
                                    function1Arr[2] = new C00157(dataObj114, anidbEid5, function8, null);
                                    Integer kitsuId18 = kitsuId4;
                                    function1Arr[c] = new C00168(kitsuId18, season4, episode4, function7, null);
                                    Function1<ExtractorLink, Unit> function11119 = function7;
                                    function7 = function11119;
                                    function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11119, null);
                                    function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                    kitsuId5 = kitsuId18;
                                    function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                    isAnime9 = isAnime5;
                                    function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = function5;
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = season4;
                                    c00062.L$8 = episode4;
                                    c00062.L$9 = id3;
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime9;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 5;
                                    if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                        return obj12;
                                    }
                                    data4 = id3;
                                    isAnime5 = isAnime9;
                                    season3 = season4;
                                    episode3 = episode4;
                                    key3 = key4;
                                    anijson4 = anijson3;
                                    torrentioapiUrl10 = torrentioapiUrl9;
                                    torrentioapiUrl11 = provider3;
                                    aniResponse5 = aniResponse4;
                                    num = (Integer) episode3.element;
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                torrentioapiUrl3 = torrentioapiUrl2;
                                str5 = str2;
                            } else {
                                torrentioapiUrl3 = torrentioapiUrl2;
                            }
                            obj12 = obj11;
                            int i12 = i2;
                            c = 3;
                            LoadData dataObj115 = dataObj2;
                            aniResponse3 = aniResponse2;
                            title3 = title2;
                            year3 = year2;
                            kitsuId4 = kitsuId3;
                            function7 = function1FilteredCallback;
                            i3 = i12;
                            torrentioapiUrl4 = torrentioapiUrl3;
                            meteorUrl2 = meteorUrl;
                            anidbEid5 = anidbEid4;
                            data3 = provider2;
                            isAnime5 = isAnime4;
                            key3 = key2;
                            torrentioapiUrl5 = id2;
                            episode3 = episode2;
                            dataObj3 = dataObj115;
                            season3 = season2;
                            function8 = function6;
                            str3 = data3;
                            if (str3 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                str4 = key3;
                                if (str4 != null) {
                                    z3 = true;
                                } else {
                                    z3 = true;
                                }
                                if (!z3) {
                                    if (Intrinsics.areEqual(data3, str5)) {
                                        Function1<ExtractorLink, Unit> function111110 = function7;
                                        key5 = key3;
                                        function7 = function111110;
                                        function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function111110, null)};
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season3;
                                        c00062.L$8 = episode3;
                                        c00062.L$9 = torrentioapiUrl5;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 4;
                                        if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                            return obj12;
                                        }
                                        provider4 = data3;
                                        meteorUrl3 = meteorUrl2;
                                        anijson5 = anijson3;
                                        provider5 = data2;
                                        data2 = provider5;
                                        meteorUrl2 = meteorUrl3;
                                        anijson3 = anijson5;
                                        data3 = provider4;
                                        key3 = key5;
                                    }
                                    Unit unit14 = Unit.INSTANCE;
                                    torrentioapiUrl11 = data3;
                                    kitsuId5 = kitsuId4;
                                    data4 = torrentioapiUrl5;
                                    anijson4 = anijson3;
                                    torrentioapiUrl10 = torrentioapiUrl4;
                                    aniResponse5 = aniResponse3;
                                }
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            key4 = key3;
                            function1Arr = new Function1[8];
                            torrentioapiUrl9 = torrentioapiUrl4;
                            function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                            provider3 = data3;
                            Function1<? super ExtractorLink, Unit> function111111 = function8;
                            episode4 = episode3;
                            season4 = season3;
                            id3 = torrentioapiUrl5;
                            LoadData dataObj116 = dataObj3;
                            C00146 c001419 = new C00146(dataObj116, id3, season4, episode4, function111111, null);
                            function8 = function111111;
                            function1Arr[1] = c001419;
                            aniResponse4 = aniResponse3;
                            function1Arr[2] = new C00157(dataObj116, anidbEid5, function8, null);
                            Integer kitsuId19 = kitsuId4;
                            function1Arr[c] = new C00168(kitsuId19, season4, episode4, function7, null);
                            Function1<ExtractorLink, Unit> function111112 = function7;
                            function7 = function111112;
                            function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function111112, null);
                            function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                            kitsuId5 = kitsuId19;
                            function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                            isAnime9 = isAnime5;
                            function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = season4;
                            c00062.L$8 = episode4;
                            c00062.L$9 = id3;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime9;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 5;
                            if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                return obj12;
                            }
                            data4 = id3;
                            isAnime5 = isAnime9;
                            season3 = season4;
                            episode3 = episode4;
                            key3 = key4;
                            anijson4 = anijson3;
                            torrentioapiUrl10 = torrentioapiUrl9;
                            torrentioapiUrl11 = provider3;
                            aniResponse5 = aniResponse4;
                            num = (Integer) episode3.element;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        mappings2 = mappings;
                    } else {
                        kitsuId2 = kitsuId;
                        mappings2 = mappings;
                    }
                    if (i != 0) {
                        numBoxInt = Boxing.boxInt(1);
                    } else {
                        numBoxInt = (Integer) episode.element;
                    }
                    episode.element = numBoxInt;
                    anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                    if (anidbEid != null) {
                        anidbEid2 = anidbEid.intValue();
                    } else {
                        anidbEid2 = 0;
                    }
                    anijson3 = anijson2;
                    torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                    SharedPreferences sharedPreferences8 = this.sharedPref;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = function5;
                    c00062.L$2 = function4;
                    c00062.L$3 = provider2;
                    c00062.L$4 = key2;
                    c00062.L$5 = dataObj;
                    c00062.L$6 = title;
                    c00062.L$7 = season;
                    c00062.L$8 = episode;
                    c00062.L$9 = id;
                    c00062.L$10 = year2;
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                    c00062.L$15 = kitsuId2;
                    c00062.L$16 = torrentioapiUrl;
                    c00062.Z$0 = isAnime;
                    c00062.Z$1 = isAnime3;
                    c00062.I$0 = i;
                    c00062.I$1 = anidbEid2;
                    c00062.label = 2;
                    anidbEid3 = anidbEid2;
                    torraStream = this;
                    objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences8, Meteorfortheweebs, c00062);
                    if (objBuildMeteorUrl == obj8) {
                        return obj8;
                    }
                    Ref.ObjectRef objectRef8 = episode;
                    obj10 = objBuildMeteorUrl;
                    dataObj2 = dataObj;
                    episode2 = objectRef8;
                    obj11 = obj8;
                    isCasting2 = isAnime;
                    aniJson2 = aniJson;
                    i2 = i;
                    function6 = function4;
                    title2 = title;
                    aniResponse2 = aniResponse;
                    isAnime4 = isAnime3;
                    mappings3 = mappings2;
                    torrentioapiUrl2 = torrentioapiUrl;
                    season2 = season;
                    kitsuId3 = kitsuId2;
                    id2 = id;
                    anidbEid4 = anidbEid3;
                    meteorUrl = (String) obj10;
                    function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                    str = key2;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        str2 = str5;
                        if (!Intrinsics.areEqual(provider2, str2)) {
                            str5 = str2;
                            anidbEid6 = anidbEid4;
                            torrentioapiUrl6 = torrentioapiUrl2;
                            Function1 filtered8 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                            Function1[] function1Arr10 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered8};
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = function6;
                            c00062.L$3 = provider2;
                            c00062.L$4 = key2;
                            c00062.L$5 = dataObj2;
                            c00062.L$6 = title2;
                            c00062.L$7 = season2;
                            c00062.L$8 = episode2;
                            c00062.L$9 = id2;
                            c00062.L$10 = year2;
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = kitsuId3;
                            c00062.L$16 = torrentioapiUrl6;
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00062.L$18 = function1FilteredCallback;
                            c00062.Z$0 = isCasting2;
                            isAnime6 = isAnime4;
                            c00062.Z$1 = isAnime6;
                            function9 = function6;
                            i4 = i2;
                            c00062.I$0 = i4;
                            c00062.I$1 = anidbEid6;
                            dataObj4 = dataObj2;
                            c00062.label = 3;
                            c = 3;
                            objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr10, c00062);
                            obj12 = obj11;
                            if (objRunAllAsync == obj12) {
                                return obj12;
                            }
                            aniResponse3 = aniResponse2;
                            torrentioapiUrl7 = torrentioapiUrl6;
                            torrentioapiUrl8 = title2;
                            anidbEid5 = anidbEid6;
                            data3 = provider2;
                            function10 = function1FilteredCallback;
                            isAnime7 = isAnime6;
                            isAnime8 = isCasting2;
                            i5 = i4;
                            meteorUrl2 = meteorUrl;
                            year3 = year2;
                            kitsuId4 = kitsuId3;
                            function7 = function10;
                            i3 = i5;
                            isAnime5 = isAnime7;
                            isCasting2 = isAnime8;
                            torrentioapiUrl4 = torrentioapiUrl7;
                            title3 = torrentioapiUrl8;
                            key3 = key2;
                            torrentioapiUrl5 = id2;
                            season3 = season2;
                            episode3 = episode2;
                            function8 = function9;
                            dataObj3 = dataObj4;
                            str3 = data3;
                            if (str3 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                str4 = key3;
                                if (str4 != null) {
                                    z3 = true;
                                } else {
                                    z3 = true;
                                }
                                if (!z3) {
                                    if (Intrinsics.areEqual(data3, str5)) {
                                        Function1<ExtractorLink, Unit> function111113 = function7;
                                        key5 = key3;
                                        function7 = function111113;
                                        function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function111113, null)};
                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00062.L$1 = function5;
                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                        c00062.L$7 = season3;
                                        c00062.L$8 = episode3;
                                        c00062.L$9 = torrentioapiUrl5;
                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                        c00062.Z$0 = isCasting2;
                                        c00062.Z$1 = isAnime5;
                                        c00062.I$0 = i3;
                                        c00062.I$1 = anidbEid5;
                                        c00062.label = 4;
                                        if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                            return obj12;
                                        }
                                        provider4 = data3;
                                        meteorUrl3 = meteorUrl2;
                                        anijson5 = anijson3;
                                        provider5 = data2;
                                        data2 = provider5;
                                        meteorUrl2 = meteorUrl3;
                                        anijson3 = anijson5;
                                        data3 = provider4;
                                        key3 = key5;
                                    }
                                    Unit unit15 = Unit.INSTANCE;
                                    torrentioapiUrl11 = data3;
                                    kitsuId5 = kitsuId4;
                                    data4 = torrentioapiUrl5;
                                    anijson4 = anijson3;
                                    torrentioapiUrl10 = torrentioapiUrl4;
                                    aniResponse5 = aniResponse3;
                                }
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            key4 = key3;
                            function1Arr = new Function1[8];
                            torrentioapiUrl9 = torrentioapiUrl4;
                            function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                            provider3 = data3;
                            Function1<? super ExtractorLink, Unit> function111114 = function8;
                            episode4 = episode3;
                            season4 = season3;
                            id3 = torrentioapiUrl5;
                            LoadData dataObj117 = dataObj3;
                            C00146 c0014110 = new C00146(dataObj117, id3, season4, episode4, function111114, null);
                            function8 = function111114;
                            function1Arr[1] = c0014110;
                            aniResponse4 = aniResponse3;
                            function1Arr[2] = new C00157(dataObj117, anidbEid5, function8, null);
                            Integer kitsuId110 = kitsuId4;
                            function1Arr[c] = new C00168(kitsuId110, season4, episode4, function7, null);
                            Function1<ExtractorLink, Unit> function111115 = function7;
                            function7 = function111115;
                            function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function111115, null);
                            function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                            kitsuId5 = kitsuId110;
                            function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                            isAnime9 = isAnime5;
                            function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = season4;
                            c00062.L$8 = episode4;
                            c00062.L$9 = id3;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime9;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 5;
                            if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                return obj12;
                            }
                            data4 = id3;
                            isAnime5 = isAnime9;
                            season3 = season4;
                            episode3 = episode4;
                            key3 = key4;
                            anijson4 = anijson3;
                            torrentioapiUrl10 = torrentioapiUrl9;
                            torrentioapiUrl11 = provider3;
                            aniResponse5 = aniResponse4;
                            num = (Integer) episode3.element;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        torrentioapiUrl3 = torrentioapiUrl2;
                        str5 = str2;
                    } else {
                        torrentioapiUrl3 = torrentioapiUrl2;
                    }
                    obj12 = obj11;
                    int i13 = i2;
                    c = 3;
                    LoadData dataObj118 = dataObj2;
                    aniResponse3 = aniResponse2;
                    title3 = title2;
                    year3 = year2;
                    kitsuId4 = kitsuId3;
                    function7 = function1FilteredCallback;
                    i3 = i13;
                    torrentioapiUrl4 = torrentioapiUrl3;
                    meteorUrl2 = meteorUrl;
                    anidbEid5 = anidbEid4;
                    data3 = provider2;
                    isAnime5 = isAnime4;
                    key3 = key2;
                    torrentioapiUrl5 = id2;
                    episode3 = episode2;
                    dataObj3 = dataObj118;
                    season3 = season2;
                    function8 = function6;
                    str3 = data3;
                    if (str3 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        str4 = key3;
                        if (str4 != null) {
                            z3 = true;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            if (Intrinsics.areEqual(data3, str5)) {
                                Function1<ExtractorLink, Unit> function111116 = function7;
                                key5 = key3;
                                function7 = function111116;
                                function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function111116, null)};
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = season3;
                                c00062.L$8 = episode3;
                                c00062.L$9 = torrentioapiUrl5;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 4;
                                if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                    return obj12;
                                }
                                provider4 = data3;
                                meteorUrl3 = meteorUrl2;
                                anijson5 = anijson3;
                                provider5 = data2;
                                data2 = provider5;
                                meteorUrl2 = meteorUrl3;
                                anijson3 = anijson5;
                                data3 = provider4;
                                key3 = key5;
                            }
                            Unit unit16 = Unit.INSTANCE;
                            torrentioapiUrl11 = data3;
                            kitsuId5 = kitsuId4;
                            data4 = torrentioapiUrl5;
                            anijson4 = anijson3;
                            torrentioapiUrl10 = torrentioapiUrl4;
                            aniResponse5 = aniResponse3;
                        }
                        num = (Integer) episode3.element;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime5;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    key4 = key3;
                    function1Arr = new Function1[8];
                    torrentioapiUrl9 = torrentioapiUrl4;
                    function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                    provider3 = data3;
                    Function1<? super ExtractorLink, Unit> function111117 = function8;
                    episode4 = episode3;
                    season4 = season3;
                    id3 = torrentioapiUrl5;
                    LoadData dataObj119 = dataObj3;
                    C00146 c0014111 = new C00146(dataObj119, id3, season4, episode4, function111117, null);
                    function8 = function111117;
                    function1Arr[1] = c0014111;
                    aniResponse4 = aniResponse3;
                    function1Arr[2] = new C00157(dataObj119, anidbEid5, function8, null);
                    Integer kitsuId111 = kitsuId4;
                    function1Arr[c] = new C00168(kitsuId111, season4, episode4, function7, null);
                    Function1<ExtractorLink, Unit> function111118 = function7;
                    function7 = function111118;
                    function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function111118, null);
                    function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                    kitsuId5 = kitsuId111;
                    function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                    isAnime9 = isAnime5;
                    function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = function5;
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00062.L$7 = season4;
                    c00062.L$8 = episode4;
                    c00062.L$9 = id3;
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00062.Z$0 = isCasting2;
                    c00062.Z$1 = isAnime9;
                    c00062.I$0 = i3;
                    c00062.I$1 = anidbEid5;
                    c00062.label = 5;
                    if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                        return obj12;
                    }
                    data4 = id3;
                    isAnime5 = isAnime9;
                    season3 = season4;
                    episode3 = episode4;
                    key3 = key4;
                    anijson4 = anijson3;
                    torrentioapiUrl10 = torrentioapiUrl9;
                    torrentioapiUrl11 = provider3;
                    aniResponse5 = aniResponse4;
                    num = (Integer) episode3.element;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00062.Z$0 = isCasting2;
                    c00062.Z$1 = isAnime5;
                    c00062.I$0 = i3;
                    c00062.I$1 = anidbEid5;
                    c00062.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                obj6 = obj5;
                year2 = year;
                provider2 = provider;
                function5 = function3;
                key2 = key;
                if (Result.isFailure-impl(obj6)) {
                    obj7 = null;
                } else {
                    obj7 = obj6;
                }
                aniResponse = (NiceResponse) obj7;
                if (aniResponse != null) {
                    text = aniResponse.getText();
                } else {
                    text = null;
                }
                obj8 = obj3;
                if (text == null) {
                    text = "";
                }
                anijson = text;
                Result.Companion companion15 = Result.Companion;
                TorraStream torraStream6 = this;
                isAnime3 = isAnime2;
                anijson2 = anijson;
                obj9 = Result.constructor-impl(new JSONObject(anijson2));
                if (Result.isFailure-impl(obj9)) {
                    obj9 = null;
                }
                aniJson = (JSONObject) obj9;
                if (aniJson != null) {
                    mappings = aniJson.optJSONObject("mappings");
                } else {
                    mappings = null;
                }
                if (mappings != null) {
                    kitsuId = Boxing.boxInt(mappings.optInt("kitsu_id"));
                } else {
                    kitsuId = null;
                }
                if (mappings != null) {
                    kitsuId2 = kitsuId;
                    strOptString = mappings.optString("type", "");
                    if (strOptString != null) {
                        mappings2 = mappings;
                        if (StringsKt.contains(strOptString, "MOVIE", true)) {
                        }
                        if (i != 0) {
                            numBoxInt = Boxing.boxInt(1);
                        } else {
                            numBoxInt = (Integer) episode.element;
                        }
                        episode.element = numBoxInt;
                        anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                        if (anidbEid != null) {
                            anidbEid2 = anidbEid.intValue();
                        } else {
                            anidbEid2 = 0;
                        }
                        anijson3 = anijson2;
                        torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                        SharedPreferences sharedPreferences9 = this.sharedPref;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = function4;
                        c00062.L$3 = provider2;
                        c00062.L$4 = key2;
                        c00062.L$5 = dataObj;
                        c00062.L$6 = title;
                        c00062.L$7 = season;
                        c00062.L$8 = episode;
                        c00062.L$9 = id;
                        c00062.L$10 = year2;
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                        c00062.L$15 = kitsuId2;
                        c00062.L$16 = torrentioapiUrl;
                        c00062.Z$0 = isAnime;
                        c00062.Z$1 = isAnime3;
                        c00062.I$0 = i;
                        c00062.I$1 = anidbEid2;
                        c00062.label = 2;
                        anidbEid3 = anidbEid2;
                        torraStream = this;
                        objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences9, Meteorfortheweebs, c00062);
                        if (objBuildMeteorUrl == obj8) {
                            return obj8;
                        }
                        Ref.ObjectRef objectRef9 = episode;
                        obj10 = objBuildMeteorUrl;
                        dataObj2 = dataObj;
                        episode2 = objectRef9;
                        obj11 = obj8;
                        isCasting2 = isAnime;
                        aniJson2 = aniJson;
                        i2 = i;
                        function6 = function4;
                        title2 = title;
                        aniResponse2 = aniResponse;
                        isAnime4 = isAnime3;
                        mappings3 = mappings2;
                        torrentioapiUrl2 = torrentioapiUrl;
                        season2 = season;
                        kitsuId3 = kitsuId2;
                        id2 = id;
                        anidbEid4 = anidbEid3;
                        meteorUrl = (String) obj10;
                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                        str = key2;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            str2 = str5;
                            if (!Intrinsics.areEqual(provider2, str2)) {
                                str5 = str2;
                                anidbEid6 = anidbEid4;
                                torrentioapiUrl6 = torrentioapiUrl2;
                                Function1 filtered9 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                                Function1[] function1Arr11 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered9};
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = function6;
                                c00062.L$3 = provider2;
                                c00062.L$4 = key2;
                                c00062.L$5 = dataObj2;
                                c00062.L$6 = title2;
                                c00062.L$7 = season2;
                                c00062.L$8 = episode2;
                                c00062.L$9 = id2;
                                c00062.L$10 = year2;
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = kitsuId3;
                                c00062.L$16 = torrentioapiUrl6;
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                c00062.L$18 = function1FilteredCallback;
                                c00062.Z$0 = isCasting2;
                                isAnime6 = isAnime4;
                                c00062.Z$1 = isAnime6;
                                function9 = function6;
                                i4 = i2;
                                c00062.I$0 = i4;
                                c00062.I$1 = anidbEid6;
                                dataObj4 = dataObj2;
                                c00062.label = 3;
                                c = 3;
                                objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr11, c00062);
                                obj12 = obj11;
                                if (objRunAllAsync == obj12) {
                                    return obj12;
                                }
                                aniResponse3 = aniResponse2;
                                torrentioapiUrl7 = torrentioapiUrl6;
                                torrentioapiUrl8 = title2;
                                anidbEid5 = anidbEid6;
                                data3 = provider2;
                                function10 = function1FilteredCallback;
                                isAnime7 = isAnime6;
                                isAnime8 = isCasting2;
                                i5 = i4;
                                meteorUrl2 = meteorUrl;
                                year3 = year2;
                                kitsuId4 = kitsuId3;
                                function7 = function10;
                                i3 = i5;
                                isAnime5 = isAnime7;
                                isCasting2 = isAnime8;
                                torrentioapiUrl4 = torrentioapiUrl7;
                                title3 = torrentioapiUrl8;
                                key3 = key2;
                                torrentioapiUrl5 = id2;
                                season3 = season2;
                                episode3 = episode2;
                                function8 = function9;
                                dataObj3 = dataObj4;
                                str3 = data3;
                                if (str3 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    str4 = key3;
                                    if (str4 != null) {
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        if (Intrinsics.areEqual(data3, str5)) {
                                            Function1<ExtractorLink, Unit> function111119 = function7;
                                            key5 = key3;
                                            function7 = function111119;
                                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function111119, null)};
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                            c00062.L$1 = function5;
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                            c00062.L$7 = season3;
                                            c00062.L$8 = episode3;
                                            c00062.L$9 = torrentioapiUrl5;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00062.Z$0 = isCasting2;
                                            c00062.Z$1 = isAnime5;
                                            c00062.I$0 = i3;
                                            c00062.I$1 = anidbEid5;
                                            c00062.label = 4;
                                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                                return obj12;
                                            }
                                            provider4 = data3;
                                            meteorUrl3 = meteorUrl2;
                                            anijson5 = anijson3;
                                            provider5 = data2;
                                            data2 = provider5;
                                            meteorUrl2 = meteorUrl3;
                                            anijson3 = anijson5;
                                            data3 = provider4;
                                            key3 = key5;
                                        }
                                        Unit unit17 = Unit.INSTANCE;
                                        torrentioapiUrl11 = data3;
                                        kitsuId5 = kitsuId4;
                                        data4 = torrentioapiUrl5;
                                        anijson4 = anijson3;
                                        torrentioapiUrl10 = torrentioapiUrl4;
                                        aniResponse5 = aniResponse3;
                                    }
                                    num = (Integer) episode3.element;
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 6;
                                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                        return obj12;
                                    }
                                    return Boxing.boxBoolean(true);
                                }
                                key4 = key3;
                                function1Arr = new Function1[8];
                                torrentioapiUrl9 = torrentioapiUrl4;
                                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                                provider3 = data3;
                                Function1<? super ExtractorLink, Unit> function1111110 = function8;
                                episode4 = episode3;
                                season4 = season3;
                                id3 = torrentioapiUrl5;
                                LoadData dataObj1110 = dataObj3;
                                C00146 c0014112 = new C00146(dataObj1110, id3, season4, episode4, function1111110, null);
                                function8 = function1111110;
                                function1Arr[1] = c0014112;
                                aniResponse4 = aniResponse3;
                                function1Arr[2] = new C00157(dataObj1110, anidbEid5, function8, null);
                                Integer kitsuId112 = kitsuId4;
                                function1Arr[c] = new C00168(kitsuId112, season4, episode4, function7, null);
                                Function1<ExtractorLink, Unit> function1111111 = function7;
                                function7 = function1111111;
                                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function1111111, null);
                                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                                kitsuId5 = kitsuId112;
                                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                                isAnime9 = isAnime5;
                                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = function5;
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = season4;
                                c00062.L$8 = episode4;
                                c00062.L$9 = id3;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime9;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 5;
                                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                                    return obj12;
                                }
                                data4 = id3;
                                isAnime5 = isAnime9;
                                season3 = season4;
                                episode3 = episode4;
                                key3 = key4;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl9;
                                torrentioapiUrl11 = provider3;
                                aniResponse5 = aniResponse4;
                                num = (Integer) episode3.element;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                c00062.Z$0 = isCasting2;
                                c00062.Z$1 = isAnime5;
                                c00062.I$0 = i3;
                                c00062.I$1 = anidbEid5;
                                c00062.label = 6;
                                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                    return obj12;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            torrentioapiUrl3 = torrentioapiUrl2;
                            str5 = str2;
                        } else {
                            torrentioapiUrl3 = torrentioapiUrl2;
                        }
                        obj12 = obj11;
                        int i14 = i2;
                        c = 3;
                        LoadData dataObj1111 = dataObj2;
                        aniResponse3 = aniResponse2;
                        title3 = title2;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function1FilteredCallback;
                        i3 = i14;
                        torrentioapiUrl4 = torrentioapiUrl3;
                        meteorUrl2 = meteorUrl;
                        anidbEid5 = anidbEid4;
                        data3 = provider2;
                        isAnime5 = isAnime4;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        episode3 = episode2;
                        dataObj3 = dataObj1111;
                        season3 = season2;
                        function8 = function6;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function1111112 = function7;
                                    key5 = key3;
                                    function7 = function1111112;
                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function1111112, null)};
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = function5;
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = season3;
                                    c00062.L$8 = episode3;
                                    c00062.L$9 = torrentioapiUrl5;
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit18 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function1111113 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadData dataObj1112 = dataObj3;
                        C00146 c0014113 = new C00146(dataObj1112, id3, season4, episode4, function1111113, null);
                        function8 = function1111113;
                        function1Arr[1] = c0014113;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00157(dataObj1112, anidbEid5, function8, null);
                        Integer kitsuId113 = kitsuId4;
                        function1Arr[c] = new C00168(kitsuId113, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function1111114 = function7;
                        function7 = function1111114;
                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function1111114, null);
                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId113;
                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = season4;
                        c00062.L$8 = episode4;
                        c00062.L$9 = id3;
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime9;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime5;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    mappings2 = mappings;
                } else {
                    kitsuId2 = kitsuId;
                    mappings2 = mappings;
                }
                if (i != 0) {
                    numBoxInt = Boxing.boxInt(1);
                } else {
                    numBoxInt = (Integer) episode.element;
                }
                episode.element = numBoxInt;
                anidbEid = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                if (anidbEid != null) {
                    anidbEid2 = anidbEid.intValue();
                } else {
                    anidbEid2 = 0;
                }
                anijson3 = anijson2;
                torrentioapiUrl = buildTorrentioApiUrl(this.sharedPref, getMainUrl());
                SharedPreferences sharedPreferences10 = this.sharedPref;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = function5;
                c00062.L$2 = function4;
                c00062.L$3 = provider2;
                c00062.L$4 = key2;
                c00062.L$5 = dataObj;
                c00062.L$6 = title;
                c00062.L$7 = season;
                c00062.L$8 = episode;
                c00062.L$9 = id;
                c00062.L$10 = year2;
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings2);
                c00062.L$15 = kitsuId2;
                c00062.L$16 = torrentioapiUrl;
                c00062.Z$0 = isAnime;
                c00062.Z$1 = isAnime3;
                c00062.I$0 = i;
                c00062.I$1 = anidbEid2;
                c00062.label = 2;
                anidbEid3 = anidbEid2;
                torraStream = this;
                objBuildMeteorUrl = torraStream.buildMeteorUrl(sharedPreferences10, Meteorfortheweebs, c00062);
                if (objBuildMeteorUrl == obj8) {
                    return obj8;
                }
                Ref.ObjectRef objectRef10 = episode;
                obj10 = objBuildMeteorUrl;
                dataObj2 = dataObj;
                episode2 = objectRef10;
                obj11 = obj8;
                isCasting2 = isAnime;
                aniJson2 = aniJson;
                i2 = i;
                function6 = function4;
                title2 = title;
                aniResponse2 = aniResponse;
                isAnime4 = isAnime3;
                mappings3 = mappings2;
                torrentioapiUrl2 = torrentioapiUrl;
                season2 = season;
                kitsuId3 = kitsuId2;
                id2 = id;
                anidbEid4 = anidbEid3;
                meteorUrl = (String) obj10;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                str = key2;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    str2 = str5;
                    if (!Intrinsics.areEqual(provider2, str2)) {
                        str5 = str2;
                        anidbEid6 = anidbEid4;
                        torrentioapiUrl6 = torrentioapiUrl2;
                        Function1 filtered10 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                        Function1[] function1Arr12 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered10};
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = function6;
                        c00062.L$3 = provider2;
                        c00062.L$4 = key2;
                        c00062.L$5 = dataObj2;
                        c00062.L$6 = title2;
                        c00062.L$7 = season2;
                        c00062.L$8 = episode2;
                        c00062.L$9 = id2;
                        c00062.L$10 = year2;
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = kitsuId3;
                        c00062.L$16 = torrentioapiUrl6;
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                        c00062.L$18 = function1FilteredCallback;
                        c00062.Z$0 = isCasting2;
                        isAnime6 = isAnime4;
                        c00062.Z$1 = isAnime6;
                        function9 = function6;
                        i4 = i2;
                        c00062.I$0 = i4;
                        c00062.I$1 = anidbEid6;
                        dataObj4 = dataObj2;
                        c00062.label = 3;
                        c = 3;
                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr12, c00062);
                        obj12 = obj11;
                        if (objRunAllAsync == obj12) {
                            return obj12;
                        }
                        aniResponse3 = aniResponse2;
                        torrentioapiUrl7 = torrentioapiUrl6;
                        torrentioapiUrl8 = title2;
                        anidbEid5 = anidbEid6;
                        data3 = provider2;
                        function10 = function1FilteredCallback;
                        isAnime7 = isAnime6;
                        isAnime8 = isCasting2;
                        i5 = i4;
                        meteorUrl2 = meteorUrl;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function10;
                        i3 = i5;
                        isAnime5 = isAnime7;
                        isCasting2 = isAnime8;
                        torrentioapiUrl4 = torrentioapiUrl7;
                        title3 = torrentioapiUrl8;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        season3 = season2;
                        episode3 = episode2;
                        function8 = function9;
                        dataObj3 = dataObj4;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function1111115 = function7;
                                    key5 = key3;
                                    function7 = function1111115;
                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function1111115, null)};
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = function5;
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = season3;
                                    c00062.L$8 = episode3;
                                    c00062.L$9 = torrentioapiUrl5;
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit19 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function1111116 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadData dataObj1113 = dataObj3;
                        C00146 c0014114 = new C00146(dataObj1113, id3, season4, episode4, function1111116, null);
                        function8 = function1111116;
                        function1Arr[1] = c0014114;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00157(dataObj1113, anidbEid5, function8, null);
                        Integer kitsuId114 = kitsuId4;
                        function1Arr[c] = new C00168(kitsuId114, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function1111117 = function7;
                        function7 = function1111117;
                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function1111117, null);
                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId114;
                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = season4;
                        c00062.L$8 = episode4;
                        c00062.L$9 = id3;
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime9;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime5;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    torrentioapiUrl3 = torrentioapiUrl2;
                    str5 = str2;
                } else {
                    torrentioapiUrl3 = torrentioapiUrl2;
                }
                obj12 = obj11;
                int i15 = i2;
                c = 3;
                LoadData dataObj1114 = dataObj2;
                aniResponse3 = aniResponse2;
                title3 = title2;
                year3 = year2;
                kitsuId4 = kitsuId3;
                function7 = function1FilteredCallback;
                i3 = i15;
                torrentioapiUrl4 = torrentioapiUrl3;
                meteorUrl2 = meteorUrl;
                anidbEid5 = anidbEid4;
                data3 = provider2;
                isAnime5 = isAnime4;
                key3 = key2;
                torrentioapiUrl5 = id2;
                episode3 = episode2;
                dataObj3 = dataObj1114;
                season3 = season2;
                function8 = function6;
                str3 = data3;
                if (str3 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str4 = key3;
                    if (str4 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        if (Intrinsics.areEqual(data3, str5)) {
                            Function1<ExtractorLink, Unit> function1111118 = function7;
                            key5 = key3;
                            function7 = function1111118;
                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function1111118, null)};
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = season3;
                            c00062.L$8 = episode3;
                            c00062.L$9 = torrentioapiUrl5;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                return obj12;
                            }
                            provider4 = data3;
                            meteorUrl3 = meteorUrl2;
                            anijson5 = anijson3;
                            provider5 = data2;
                            data2 = provider5;
                            meteorUrl2 = meteorUrl3;
                            anijson3 = anijson5;
                            data3 = provider4;
                            key3 = key5;
                        }
                        Unit unit110 = Unit.INSTANCE;
                        torrentioapiUrl11 = data3;
                        kitsuId5 = kitsuId4;
                        data4 = torrentioapiUrl5;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl4;
                        aniResponse5 = aniResponse3;
                    }
                    num = (Integer) episode3.element;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00062.Z$0 = isCasting2;
                    c00062.Z$1 = isAnime5;
                    c00062.I$0 = i3;
                    c00062.I$1 = anidbEid5;
                    c00062.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                key4 = key3;
                function1Arr = new Function1[8];
                torrentioapiUrl9 = torrentioapiUrl4;
                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                provider3 = data3;
                Function1<? super ExtractorLink, Unit> function1111119 = function8;
                episode4 = episode3;
                season4 = season3;
                id3 = torrentioapiUrl5;
                LoadData dataObj1115 = dataObj3;
                C00146 c0014115 = new C00146(dataObj1115, id3, season4, episode4, function1111119, null);
                function8 = function1111119;
                function1Arr[1] = c0014115;
                aniResponse4 = aniResponse3;
                function1Arr[2] = new C00157(dataObj1115, anidbEid5, function8, null);
                Integer kitsuId115 = kitsuId4;
                function1Arr[c] = new C00168(kitsuId115, season4, episode4, function7, null);
                Function1<ExtractorLink, Unit> function11111110 = function7;
                function7 = function11111110;
                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11111110, null);
                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                kitsuId5 = kitsuId115;
                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                isAnime9 = isAnime5;
                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = function5;
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = season4;
                c00062.L$8 = episode4;
                c00062.L$9 = id3;
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime9;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 5;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                    return obj12;
                }
                data4 = id3;
                isAnime5 = isAnime9;
                season3 = season4;
                episode3 = episode4;
                key3 = key4;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl9;
                torrentioapiUrl11 = provider3;
                aniResponse5 = aniResponse4;
                num = (Integer) episode3.element;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime5;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 2:
                int anidbEid7 = c00062.I$1;
                int i16 = c00062.I$0;
                boolean isAnime11 = c00062.Z$1;
                boolean isCasting3 = c00062.Z$0;
                String torrentioapiUrl12 = (String) c00062.L$16;
                Integer kitsuId20 = (Integer) c00062.L$15;
                JSONObject mappings4 = (JSONObject) c00062.L$14;
                JSONObject aniJson3 = (JSONObject) c00062.L$13;
                String anijson6 = (String) c00062.L$12;
                NiceResponse aniResponse6 = (NiceResponse) c00062.L$11;
                Integer year5 = (Integer) c00062.L$10;
                String id5 = (String) c00062.L$9;
                Ref.ObjectRef episode5 = (Ref.ObjectRef) c00062.L$8;
                Integer season6 = (Integer) c00062.L$7;
                String title5 = (String) c00062.L$6;
                LoadData dataObj20 = (LoadData) c00062.L$5;
                String key7 = (String) c00062.L$4;
                String provider7 = (String) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function21 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function22 = (Function1) c00062.L$1;
                String data5 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                torraStream = this;
                obj11 = coroutine_suspended;
                str5 = "AIO Streams";
                torrentioapiUrl2 = torrentioapiUrl12;
                mappings3 = mappings4;
                anijson3 = anijson6;
                aniResponse2 = aniResponse6;
                episode2 = episode5;
                season2 = season6;
                dataObj2 = dataObj20;
                key2 = key7;
                provider2 = provider7;
                year2 = year5;
                data2 = data5;
                obj10 = $result;
                isAnime4 = isAnime11;
                isCasting2 = isCasting3;
                aniJson2 = aniJson3;
                id2 = id5;
                function5 = function22;
                function6 = function21;
                title2 = title5;
                i2 = i16;
                kitsuId3 = kitsuId20;
                anidbEid4 = anidbEid7;
                meteorUrl = (String) obj10;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback(torraStream.sharedPref, function6);
                str = key2;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    str2 = str5;
                    if (!Intrinsics.areEqual(provider2, str2)) {
                        str5 = str2;
                        anidbEid6 = anidbEid4;
                        torrentioapiUrl6 = torrentioapiUrl2;
                        Function1 filtered11 = new C00113(meteorUrl, id2, season2, episode2, function1FilteredCallback, null);
                        Function1[] function1Arr13 = {new C00102(torrentioapiUrl6, id2, season2, episode2, function1FilteredCallback, null), filtered11};
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = function6;
                        c00062.L$3 = provider2;
                        c00062.L$4 = key2;
                        c00062.L$5 = dataObj2;
                        c00062.L$6 = title2;
                        c00062.L$7 = season2;
                        c00062.L$8 = episode2;
                        c00062.L$9 = id2;
                        c00062.L$10 = year2;
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse2);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = kitsuId3;
                        c00062.L$16 = torrentioapiUrl6;
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                        c00062.L$18 = function1FilteredCallback;
                        c00062.Z$0 = isCasting2;
                        isAnime6 = isAnime4;
                        c00062.Z$1 = isAnime6;
                        function9 = function6;
                        i4 = i2;
                        c00062.I$0 = i4;
                        c00062.I$1 = anidbEid6;
                        dataObj4 = dataObj2;
                        c00062.label = 3;
                        c = 3;
                        objRunAllAsync = ParCollectionsKt.runAllAsync(function1Arr13, c00062);
                        obj12 = obj11;
                        if (objRunAllAsync == obj12) {
                            return obj12;
                        }
                        aniResponse3 = aniResponse2;
                        torrentioapiUrl7 = torrentioapiUrl6;
                        torrentioapiUrl8 = title2;
                        anidbEid5 = anidbEid6;
                        data3 = provider2;
                        function10 = function1FilteredCallback;
                        isAnime7 = isAnime6;
                        isAnime8 = isCasting2;
                        i5 = i4;
                        meteorUrl2 = meteorUrl;
                        year3 = year2;
                        kitsuId4 = kitsuId3;
                        function7 = function10;
                        i3 = i5;
                        isAnime5 = isAnime7;
                        isCasting2 = isAnime8;
                        torrentioapiUrl4 = torrentioapiUrl7;
                        title3 = torrentioapiUrl8;
                        key3 = key2;
                        torrentioapiUrl5 = id2;
                        season3 = season2;
                        episode3 = episode2;
                        function8 = function9;
                        dataObj3 = dataObj4;
                        str3 = data3;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            str4 = key3;
                            if (str4 != null) {
                                z3 = true;
                            } else {
                                z3 = true;
                            }
                            if (!z3) {
                                if (Intrinsics.areEqual(data3, str5)) {
                                    Function1<ExtractorLink, Unit> function11111111 = function7;
                                    key5 = key3;
                                    function7 = function11111111;
                                    function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11111111, null)};
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00062.L$1 = function5;
                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00062.L$7 = season3;
                                    c00062.L$8 = episode3;
                                    c00062.L$9 = torrentioapiUrl5;
                                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                                    c00062.Z$0 = isCasting2;
                                    c00062.Z$1 = isAnime5;
                                    c00062.I$0 = i3;
                                    c00062.I$1 = anidbEid5;
                                    c00062.label = 4;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                        return obj12;
                                    }
                                    provider4 = data3;
                                    meteorUrl3 = meteorUrl2;
                                    anijson5 = anijson3;
                                    provider5 = data2;
                                    data2 = provider5;
                                    meteorUrl2 = meteorUrl3;
                                    anijson3 = anijson5;
                                    data3 = provider4;
                                    key3 = key5;
                                }
                                Unit unit111 = Unit.INSTANCE;
                                torrentioapiUrl11 = data3;
                                kitsuId5 = kitsuId4;
                                data4 = torrentioapiUrl5;
                                anijson4 = anijson3;
                                torrentioapiUrl10 = torrentioapiUrl4;
                                aniResponse5 = aniResponse3;
                            }
                            num = (Integer) episode3.element;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 6;
                            if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                                return obj12;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        key4 = key3;
                        function1Arr = new Function1[8];
                        torrentioapiUrl9 = torrentioapiUrl4;
                        function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                        provider3 = data3;
                        Function1<? super ExtractorLink, Unit> function11111112 = function8;
                        episode4 = episode3;
                        season4 = season3;
                        id3 = torrentioapiUrl5;
                        LoadData dataObj1116 = dataObj3;
                        C00146 c0014116 = new C00146(dataObj1116, id3, season4, episode4, function11111112, null);
                        function8 = function11111112;
                        function1Arr[1] = c0014116;
                        aniResponse4 = aniResponse3;
                        function1Arr[2] = new C00157(dataObj1116, anidbEid5, function8, null);
                        Integer kitsuId116 = kitsuId4;
                        function1Arr[c] = new C00168(kitsuId116, season4, episode4, function7, null);
                        Function1<ExtractorLink, Unit> function11111113 = function7;
                        function7 = function11111113;
                        function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11111113, null);
                        function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                        kitsuId5 = kitsuId116;
                        function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                        isAnime9 = isAnime5;
                        function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = function5;
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = season4;
                        c00062.L$8 = episode4;
                        c00062.L$9 = id3;
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime9;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 5;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                            return obj12;
                        }
                        data4 = id3;
                        isAnime5 = isAnime9;
                        season3 = season4;
                        episode3 = episode4;
                        key3 = key4;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl9;
                        torrentioapiUrl11 = provider3;
                        aniResponse5 = aniResponse4;
                        num = (Integer) episode3.element;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                        c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                        c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                        c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                        c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                        c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                        c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                        c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                        c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                        c00062.Z$0 = isCasting2;
                        c00062.Z$1 = isAnime5;
                        c00062.I$0 = i3;
                        c00062.I$1 = anidbEid5;
                        c00062.label = 6;
                        if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                            return obj12;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    torrentioapiUrl3 = torrentioapiUrl2;
                    str5 = str2;
                } else {
                    torrentioapiUrl3 = torrentioapiUrl2;
                }
                obj12 = obj11;
                int i17 = i2;
                c = 3;
                LoadData dataObj1117 = dataObj2;
                aniResponse3 = aniResponse2;
                title3 = title2;
                year3 = year2;
                kitsuId4 = kitsuId3;
                function7 = function1FilteredCallback;
                i3 = i17;
                torrentioapiUrl4 = torrentioapiUrl3;
                meteorUrl2 = meteorUrl;
                anidbEid5 = anidbEid4;
                data3 = provider2;
                isAnime5 = isAnime4;
                key3 = key2;
                torrentioapiUrl5 = id2;
                episode3 = episode2;
                dataObj3 = dataObj1117;
                season3 = season2;
                function8 = function6;
                str3 = data3;
                if (str3 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str4 = key3;
                    if (str4 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        if (Intrinsics.areEqual(data3, str5)) {
                            Function1<ExtractorLink, Unit> function11111114 = function7;
                            key5 = key3;
                            function7 = function11111114;
                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11111114, null)};
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = season3;
                            c00062.L$8 = episode3;
                            c00062.L$9 = torrentioapiUrl5;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                return obj12;
                            }
                            provider4 = data3;
                            meteorUrl3 = meteorUrl2;
                            anijson5 = anijson3;
                            provider5 = data2;
                            data2 = provider5;
                            meteorUrl2 = meteorUrl3;
                            anijson3 = anijson5;
                            data3 = provider4;
                            key3 = key5;
                        }
                        Unit unit112 = Unit.INSTANCE;
                        torrentioapiUrl11 = data3;
                        kitsuId5 = kitsuId4;
                        data4 = torrentioapiUrl5;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl4;
                        aniResponse5 = aniResponse3;
                    }
                    num = (Integer) episode3.element;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00062.Z$0 = isCasting2;
                    c00062.Z$1 = isAnime5;
                    c00062.I$0 = i3;
                    c00062.I$1 = anidbEid5;
                    c00062.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                key4 = key3;
                function1Arr = new Function1[8];
                torrentioapiUrl9 = torrentioapiUrl4;
                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                provider3 = data3;
                Function1<? super ExtractorLink, Unit> function11111115 = function8;
                episode4 = episode3;
                season4 = season3;
                id3 = torrentioapiUrl5;
                LoadData dataObj1118 = dataObj3;
                C00146 c0014117 = new C00146(dataObj1118, id3, season4, episode4, function11111115, null);
                function8 = function11111115;
                function1Arr[1] = c0014117;
                aniResponse4 = aniResponse3;
                function1Arr[2] = new C00157(dataObj1118, anidbEid5, function8, null);
                Integer kitsuId117 = kitsuId4;
                function1Arr[c] = new C00168(kitsuId117, season4, episode4, function7, null);
                Function1<ExtractorLink, Unit> function11111116 = function7;
                function7 = function11111116;
                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11111116, null);
                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                kitsuId5 = kitsuId117;
                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                isAnime9 = isAnime5;
                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = function5;
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = season4;
                c00062.L$8 = episode4;
                c00062.L$9 = id3;
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime9;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 5;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                    return obj12;
                }
                data4 = id3;
                isAnime5 = isAnime9;
                season3 = season4;
                episode3 = episode4;
                key3 = key4;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl9;
                torrentioapiUrl11 = provider3;
                aniResponse5 = aniResponse4;
                num = (Integer) episode3.element;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime5;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 3:
                int anidbEid8 = c00062.I$1;
                i5 = c00062.I$0;
                isAnime7 = c00062.Z$1;
                isAnime8 = c00062.Z$0;
                Function1<ExtractorLink, Unit> function23 = (Function1) c00062.L$18;
                String meteorUrl4 = (String) c00062.L$17;
                String torrentioapiUrl13 = (String) c00062.L$16;
                kitsuId3 = (Integer) c00062.L$15;
                JSONObject mappings5 = (JSONObject) c00062.L$14;
                JSONObject aniJson4 = (JSONObject) c00062.L$13;
                String anijson7 = (String) c00062.L$12;
                NiceResponse aniResponse7 = (NiceResponse) c00062.L$11;
                Integer year6 = (Integer) c00062.L$10;
                String id6 = (String) c00062.L$9;
                Ref.ObjectRef episode6 = (Ref.ObjectRef) c00062.L$8;
                Integer season7 = (Integer) c00062.L$7;
                torrentioapiUrl8 = (String) c00062.L$6;
                LoadData dataObj21 = (LoadData) c00062.L$5;
                String key8 = (String) c00062.L$4;
                String provider8 = (String) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function24 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function25 = (Function1) c00062.L$1;
                String data6 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                anidbEid5 = anidbEid8;
                anijson3 = anijson7;
                function9 = function24;
                obj12 = coroutine_suspended;
                str5 = "AIO Streams";
                mappings3 = mappings5;
                function10 = function23;
                meteorUrl2 = meteorUrl4;
                torrentioapiUrl7 = torrentioapiUrl13;
                aniResponse3 = aniResponse7;
                year2 = year6;
                id2 = id6;
                episode2 = episode6;
                season2 = season7;
                dataObj4 = dataObj21;
                c = 3;
                function5 = function25;
                data2 = data6;
                aniJson2 = aniJson4;
                key2 = key8;
                data3 = provider8;
                year3 = year2;
                kitsuId4 = kitsuId3;
                function7 = function10;
                i3 = i5;
                isAnime5 = isAnime7;
                isCasting2 = isAnime8;
                torrentioapiUrl4 = torrentioapiUrl7;
                title3 = torrentioapiUrl8;
                key3 = key2;
                torrentioapiUrl5 = id2;
                season3 = season2;
                episode3 = episode2;
                function8 = function9;
                dataObj3 = dataObj4;
                str3 = data3;
                if (str3 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str4 = key3;
                    if (str4 != null) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        if (Intrinsics.areEqual(data3, str5)) {
                            Function1<ExtractorLink, Unit> function11111117 = function7;
                            key5 = key3;
                            function7 = function11111117;
                            function1Arr2 = new Function1[]{new C00124(key3, torrentioapiUrl5, season3, episode3, function11111117, null)};
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                            c00062.L$1 = function5;
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(key5);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                            c00062.L$7 = season3;
                            c00062.L$8 = episode3;
                            c00062.L$9 = torrentioapiUrl5;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse3);
                            c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                            c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                            c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                            c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId4);
                            c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl4);
                            c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                            c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                            c00062.Z$0 = isCasting2;
                            c00062.Z$1 = isAnime5;
                            c00062.I$0 = i3;
                            c00062.I$1 = anidbEid5;
                            c00062.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00062) == obj12) {
                                return obj12;
                            }
                            provider4 = data3;
                            meteorUrl3 = meteorUrl2;
                            anijson5 = anijson3;
                            provider5 = data2;
                            data2 = provider5;
                            meteorUrl2 = meteorUrl3;
                            anijson3 = anijson5;
                            data3 = provider4;
                            key3 = key5;
                        }
                        Unit unit113 = Unit.INSTANCE;
                        torrentioapiUrl11 = data3;
                        kitsuId5 = kitsuId4;
                        data4 = torrentioapiUrl5;
                        anijson4 = anijson3;
                        torrentioapiUrl10 = torrentioapiUrl4;
                        aniResponse5 = aniResponse3;
                    }
                    num = (Integer) episode3.element;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                    c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                    c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                    c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                    c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                    c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                    c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                    c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                    c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                    c00062.Z$0 = isCasting2;
                    c00062.Z$1 = isAnime5;
                    c00062.I$0 = i3;
                    c00062.I$1 = anidbEid5;
                    c00062.label = 6;
                    if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                        return obj12;
                    }
                    return Boxing.boxBoolean(true);
                }
                key4 = key3;
                function1Arr = new Function1[8];
                torrentioapiUrl9 = torrentioapiUrl4;
                function1Arr[0] = new C00135(torrentioapiUrl4, torrentioapiUrl5, season3, episode3, function7, null);
                provider3 = data3;
                Function1<? super ExtractorLink, Unit> function11111118 = function8;
                episode4 = episode3;
                season4 = season3;
                id3 = torrentioapiUrl5;
                LoadData dataObj1119 = dataObj3;
                C00146 c0014118 = new C00146(dataObj1119, id3, season4, episode4, function11111118, null);
                function8 = function11111118;
                function1Arr[1] = c0014118;
                aniResponse4 = aniResponse3;
                function1Arr[2] = new C00157(dataObj1119, anidbEid5, function8, null);
                Integer kitsuId118 = kitsuId4;
                function1Arr[c] = new C00168(kitsuId118, season4, episode4, function7, null);
                Function1<ExtractorLink, Unit> function11111119 = function7;
                function7 = function11111119;
                function1Arr[4] = new C00179(dataObj3, title3, year3, season4, episode4, function11111119, null);
                function1Arr[5] = new C000710(id3, season4, episode4, function8, null);
                kitsuId5 = kitsuId118;
                function1Arr[6] = new C000811(dataObj3, kitsuId5, season4, episode4, function7, null);
                isAnime9 = isAnime5;
                function1Arr[7] = new C000912(isAnime9, title3, year3, season4, episode4, function7, null);
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = function5;
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(provider3);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key4);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = season4;
                c00062.L$8 = episode4;
                c00062.L$9 = id3;
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse4);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson3);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl9);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime9;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 5;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00062) == obj12) {
                    return obj12;
                }
                data4 = id3;
                isAnime5 = isAnime9;
                season3 = season4;
                episode3 = episode4;
                key3 = key4;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl9;
                torrentioapiUrl11 = provider3;
                aniResponse5 = aniResponse4;
                num = (Integer) episode3.element;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime5;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 4:
                int anidbEid9 = c00062.I$1;
                i3 = c00062.I$0;
                isAnime5 = c00062.Z$1;
                isCasting2 = c00062.Z$0;
                Function1<ExtractorLink, Unit> function26 = (Function1) c00062.L$18;
                meteorUrl3 = (String) c00062.L$17;
                String torrentioapiUrl14 = (String) c00062.L$16;
                Integer kitsuId21 = (Integer) c00062.L$15;
                JSONObject mappings6 = (JSONObject) c00062.L$14;
                JSONObject aniJson5 = (JSONObject) c00062.L$13;
                anijson5 = (String) c00062.L$12;
                NiceResponse aniResponse8 = (NiceResponse) c00062.L$11;
                Integer year7 = (Integer) c00062.L$10;
                String id7 = (String) c00062.L$9;
                Ref.ObjectRef episode7 = (Ref.ObjectRef) c00062.L$8;
                Integer season8 = (Integer) c00062.L$7;
                String title6 = (String) c00062.L$6;
                LoadData dataObj22 = (LoadData) c00062.L$5;
                String key9 = (String) c00062.L$4;
                provider4 = (String) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function27 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function28 = (Function1) c00062.L$1;
                provider5 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                aniResponse3 = aniResponse8;
                obj12 = coroutine_suspended;
                function7 = function26;
                torrentioapiUrl4 = torrentioapiUrl14;
                kitsuId4 = kitsuId21;
                year3 = year7;
                torrentioapiUrl5 = id7;
                season3 = season8;
                title3 = title6;
                dataObj3 = dataObj22;
                function5 = function28;
                mappings3 = mappings6;
                aniJson2 = aniJson5;
                anidbEid5 = anidbEid9;
                episode3 = episode7;
                key5 = key9;
                function8 = function27;
                data2 = provider5;
                meteorUrl2 = meteorUrl3;
                anijson3 = anijson5;
                data3 = provider4;
                key3 = key5;
                Unit unit114 = Unit.INSTANCE;
                torrentioapiUrl11 = data3;
                kitsuId5 = kitsuId4;
                data4 = torrentioapiUrl5;
                anijson4 = anijson3;
                torrentioapiUrl10 = torrentioapiUrl4;
                aniResponse5 = aniResponse3;
                num = (Integer) episode3.element;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime5;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 5:
                int anidbEid10 = c00062.I$1;
                i3 = c00062.I$0;
                isAnime5 = c00062.Z$1;
                boolean isCasting4 = c00062.Z$0;
                Function1<ExtractorLink, Unit> function29 = (Function1) c00062.L$18;
                String meteorUrl5 = (String) c00062.L$17;
                String torrentioapiUrl15 = (String) c00062.L$16;
                Integer kitsuId22 = (Integer) c00062.L$15;
                JSONObject mappings7 = (JSONObject) c00062.L$14;
                JSONObject aniJson6 = (JSONObject) c00062.L$13;
                String anijson8 = (String) c00062.L$12;
                NiceResponse aniResponse9 = (NiceResponse) c00062.L$11;
                Integer year8 = (Integer) c00062.L$10;
                String id8 = (String) c00062.L$9;
                Ref.ObjectRef episode8 = (Ref.ObjectRef) c00062.L$8;
                Integer season9 = (Integer) c00062.L$7;
                String title7 = (String) c00062.L$6;
                LoadData dataObj23 = (LoadData) c00062.L$5;
                String key10 = (String) c00062.L$4;
                torrentioapiUrl11 = (String) c00062.L$3;
                Function1<? super ExtractorLink, Unit> function30 = (Function1) c00062.L$2;
                Function1<? super SubtitleFile, Unit> function31 = (Function1) c00062.L$1;
                String data7 = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                data2 = data7;
                obj12 = coroutine_suspended;
                function7 = function29;
                meteorUrl2 = meteorUrl5;
                torrentioapiUrl10 = torrentioapiUrl15;
                kitsuId5 = kitsuId22;
                year3 = year8;
                data4 = id8;
                episode3 = episode8;
                season3 = season9;
                title3 = title7;
                dataObj3 = dataObj23;
                key3 = key10;
                aniResponse5 = aniResponse9;
                mappings3 = mappings7;
                aniJson2 = aniJson6;
                anidbEid5 = anidbEid10;
                function8 = function30;
                anijson4 = anijson8;
                isCasting2 = isCasting4;
                function5 = function31;
                num = (Integer) episode3.element;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl11);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable(key3);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(dataObj3);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(season3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(episode3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(data4);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(year3);
                c00062.L$11 = SpillingKt.nullOutSpilledVariable(aniResponse5);
                c00062.L$12 = SpillingKt.nullOutSpilledVariable(anijson4);
                c00062.L$13 = SpillingKt.nullOutSpilledVariable(aniJson2);
                c00062.L$14 = SpillingKt.nullOutSpilledVariable(mappings3);
                c00062.L$15 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                c00062.L$16 = SpillingKt.nullOutSpilledVariable(torrentioapiUrl10);
                c00062.L$17 = SpillingKt.nullOutSpilledVariable(meteorUrl2);
                c00062.L$18 = SpillingKt.nullOutSpilledVariable(function7);
                c00062.Z$0 = isCasting2;
                c00062.Z$1 = isAnime5;
                c00062.I$0 = i3;
                c00062.I$1 = anidbEid5;
                c00062.label = 6;
                if (TorraStreamExtractorKt.invokeSubtitleAPI(data4, season3, num, function5, c00062) == obj12) {
                    return obj12;
                }
                return Boxing.boxBoolean(true);
            case 6:
                int i18 = c00062.I$1;
                int i19 = c00062.I$0;
                boolean z4 = c00062.Z$1;
                boolean z5 = c00062.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$2 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$2", f = "TorraStream.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00102 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $torrentioapiUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00102> continuation) {
            super(1, continuation);
            this.$torrentioapiUrl = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00102(this.$torrentioapiUrl, this.$id, this.$season, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeTorrentioDebian(this.$torrentioapiUrl, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$3 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$3", f = "TorraStream.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00113 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ String $meteorUrl;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00113(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00113> continuation) {
            super(1, continuation);
            this.$meteorUrl = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00113(this.$meteorUrl, this.$id, this.$season, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeMeteorDebian(this.$meteorUrl, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$4 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$4", f = "TorraStream.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00124 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ String $key;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00124(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00124> continuation) {
            super(1, continuation);
            this.$key = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00124(this.$key, this.$id, this.$season, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeAIOStreamsDebian(this.$key, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$5 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$5", f = "TorraStream.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00135 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $torrentioapiUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00135(String str, String str2, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00135> continuation) {
            super(1, continuation);
            this.$torrentioapiUrl = str;
            this.$id = str2;
            this.$season = num;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00135(this.$torrentioapiUrl, this.$id, this.$season, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeTorrentio(this.$torrentioapiUrl, this.$id, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$6 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$6", f = "TorraStream.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, nl = {399}, s = {}, v = 2)
    static final class C00146 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $dataObj;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00146(LoadData loadData, String str, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00146> continuation) {
            super(1, continuation);
            this.$dataObj = loadData;
            this.$id = str;
            this.$season = num;
            this.$episode = objectRef;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00146(this.$dataObj, this.$id, this.$season, this.$episode, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!this.$dataObj.isAnime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeThepiratebay(TorraStream.ThePirateBayApi, this.$id, this.$season, (Integer) this.$episode.element, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$7 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$7", f = "TorraStream.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00157 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ int $anidbEid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $dataObj;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00157(LoadData loadData, int i, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00157> continuation) {
            super(1, continuation);
            this.$dataObj = loadData;
            this.$anidbEid = i;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00157(this.$dataObj, this.$anidbEid, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$dataObj.isAnime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeAnimetosho(Boxing.boxInt(this.$anidbEid), this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$8 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$8", f = "TorraStream.kt", i = {}, l = {401}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00168 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Integer $kitsuId;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00168(Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00168> continuation) {
            super(1, continuation);
            this.$kitsuId = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00168(this.$kitsuId, this.$season, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeTorrentioAnime(TorraStream.TorrentioAnimeAPI, this.$kitsuId, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$9 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$9", f = "TorraStream.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, nl = {411}, s = {}, v = 2)
    static final class C00179 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $dataObj;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $title;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00179(LoadData loadData, String str, Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00179> continuation) {
            super(1, continuation);
            this.$dataObj = loadData;
            this.$title = str;
            this.$year = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00179(this.$dataObj, this.$title, this.$year, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!this.$dataObj.isAnime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeUindex(TorraStream.Uindex, this.$title, this.$year, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$10 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$10", f = "TorraStream.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C000710 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ String $id;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000710(String str, Integer num, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C000710> continuation) {
            super(1, continuation);
            this.$id = str;
            this.$season = num;
            this.$episode = objectRef;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C000710(this.$id, this.$season, this.$episode, this.$callback, continuation);
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
                    if (TorraStreamExtractorKt.invokeTorrentsDB(TorraStream.TorrentsDB, this.$id, this.$season, (Integer) this.$episode.element, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$11 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$11", f = "TorraStream.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, nl = {421}, s = {}, v = 2)
    static final class C000811 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $dataObj;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Integer $kitsuId;
        final /* synthetic */ Integer $season;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000811(LoadData loadData, Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C000811> continuation) {
            super(1, continuation);
            this.$dataObj = loadData;
            this.$kitsuId = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C000811(this.$dataObj, this.$kitsuId, this.$season, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$dataObj.isAnime()) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeTorrentsDBAnime(TorraStream.TorrentsDB, this.$kitsuId, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStream$loadLinks$12 */
    /* JADX INFO: compiled from: TorraStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$12", f = "TorraStream.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C000912 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ boolean $isAnime;
        final /* synthetic */ Integer $season;
        final /* synthetic */ String $title;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000912(boolean z, String str, Integer num, Integer num2, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C000912> continuation) {
            super(1, continuation);
            this.$isAnime = z;
            this.$title = str;
            this.$year = num;
            this.$season = num2;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C000912(this.$isAnime, this.$title, this.$year, this.$season, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeKnaben(TorraStream.Knaben, this.$isAnime, this.$title, this.$year, this.$season, (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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
    public final ShowStatus getStatus(String t) {
        String lowerCase;
        if (t != null) {
            lowerCase = t.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (Intrinsics.areEqual(lowerCase, "returning series") || Intrinsics.areEqual(lowerCase, "continuing")) {
            return ShowStatus.Ongoing;
        }
        return ShowStatus.Completed;
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

    private final String buildTorrentioApiUrl(SharedPreferences sharedPref, String mainUrl) {
        String sort = sharedPref.getString("sort", "qualitysize");
        String languageOption = sharedPref.getString("language", "");
        String qualityFilter = sharedPref.getString("qualityfilter", "");
        String limit = sharedPref.getString("limit", "");
        String sizeFilter = sharedPref.getString("sizefilter", "");
        String debridProvider = sharedPref.getString("debrid_provider", "");
        String debridKey = sharedPref.getString("debrid_key", "");
        List params = new ArrayList();
        String str = sort;
        if (!(str == null || str.length() == 0)) {
            params.add("sort=" + sort);
        }
        String str2 = languageOption;
        if (!(str2 == null || str2.length() == 0)) {
            StringBuilder sbAppend = new StringBuilder().append("language=");
            String lowerCase = languageOption.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            params.add(sbAppend.append(lowerCase).toString());
        }
        String str3 = qualityFilter;
        if (!(str3 == null || str3.length() == 0)) {
            params.add("qualityfilter=" + qualityFilter);
        }
        String str4 = limit;
        if (!(str4 == null || str4.length() == 0)) {
            params.add("limit=" + limit);
        }
        String str5 = sizeFilter;
        if (!(str5 == null || str5.length() == 0)) {
            params.add("sizefilter=" + sizeFilter);
        }
        String str6 = debridProvider;
        if (!(str6 == null || str6.length() == 0)) {
            String str7 = debridKey;
            if (!(str7 == null || str7.length() == 0)) {
                params.add(debridProvider + '=' + debridKey);
            }
        }
        String query = CollectionsKt.joinToString$default(params, "%7C", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return mainUrl + '/' + query;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x017c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0181  */
    /* JADX WARN: Code duplicated, block: B:47:0x0193  */
    /* JADX WARN: Code duplicated, block: B:48:0x0198  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public final Object buildMeteorUrl(@NotNull SharedPreferences sharedPref, @NotNull String baseUrl, @NotNull Continuation<? super String> continuation) throws JSONException {
        C00001 c00001;
        String debridProvider;
        String debridKey;
        String limit;
        String sizeFilter;
        JSONArray preferredLanguages;
        SharedPreferences sharedPref2;
        String baseUrl2;
        int i;
        Integer intOrNull;
        int iIntValue;
        Integer intOrNull2;
        int iIntValue2;
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
                String string = sharedPref.getString("debrid_provider", "");
                if (string == null) {
                    string = "";
                }
                debridProvider = string;
                String string2 = sharedPref.getString("debrid_key", "");
                if (string2 == null) {
                    string2 = "";
                }
                debridKey = string2;
                String string3 = sharedPref.getString("language", "");
                String languagesPref = string3 != null ? string3 : "";
                String string4 = sharedPref.getString("limit", "0");
                if (string4 == null) {
                    string4 = "0";
                }
                limit = string4;
                String string5 = sharedPref.getString("sizefilter", "0");
                sizeFilter = string5 != null ? string5 : "0";
                preferredLanguages = new JSONArray();
                if (languagesPref.length() > 0) {
                    List listSplit$default = StringsKt.split$default(languagesPref, new String[]{","}, false, 0, 6, (Object) null);
                    TorraStream$buildMeteorUrl$preferredLanguages$1$1 torraStream$buildMeteorUrl$preferredLanguages$1$1 = new TorraStream$buildMeteorUrl$preferredLanguages$1$1(preferredLanguages, null);
                    c00001.L$0 = SpillingKt.nullOutSpilledVariable(sharedPref);
                    c00001.L$1 = baseUrl;
                    c00001.L$2 = debridProvider;
                    c00001.L$3 = debridKey;
                    c00001.L$4 = SpillingKt.nullOutSpilledVariable(languagesPref);
                    c00001.L$5 = limit;
                    c00001.L$6 = sizeFilter;
                    c00001.L$7 = preferredLanguages;
                    c00001.L$8 = SpillingKt.nullOutSpilledVariable(preferredLanguages);
                    c00001.label = 1;
                    if (ParCollectionsKt.amap(listSplit$default, torraStream$buildMeteorUrl$preferredLanguages$1$1, c00001) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sharedPref2 = sharedPref;
                    baseUrl2 = baseUrl;
                    i = 0;
                } else {
                    preferredLanguages.put("en");
                    preferredLanguages.put("multi");
                    sharedPref2 = sharedPref;
                    baseUrl2 = baseUrl;
                }
                JSONObject languages = new JSONObject();
                languages.put("preferred", preferredLanguages);
                languages.put("required", new JSONArray());
                languages.put("exclude", new JSONArray());
                JSONObject $this$buildMeteorUrl_u24lambda_u242 = new JSONObject();
                Object lowerCase = debridProvider.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                $this$buildMeteorUrl_u24lambda_u242.put("debridService", lowerCase);
                $this$buildMeteorUrl_u24lambda_u242.put("debridApiKey", debridKey);
                $this$buildMeteorUrl_u24lambda_u242.put("cachedOnly", false);
                $this$buildMeteorUrl_u24lambda_u242.put("removeTrash", true);
                $this$buildMeteorUrl_u24lambda_u242.put("removeSamples", true);
                $this$buildMeteorUrl_u24lambda_u242.put("removeAdult", false);
                $this$buildMeteorUrl_u24lambda_u242.put("exclude3D", false);
                $this$buildMeteorUrl_u24lambda_u242.put("enableSeaDex", false);
                $this$buildMeteorUrl_u24lambda_u242.put("minSeeders", 0);
                intOrNull = StringsKt.toIntOrNull(limit);
                if (intOrNull != null) {
                    iIntValue = intOrNull.intValue();
                } else {
                    iIntValue = 0;
                }
                $this$buildMeteorUrl_u24lambda_u242.put("maxResults", iIntValue);
                $this$buildMeteorUrl_u24lambda_u242.put("maxResultsPerRes", 0);
                intOrNull2 = StringsKt.toIntOrNull(sizeFilter);
                if (intOrNull2 != null) {
                    iIntValue2 = intOrNull2.intValue();
                } else {
                    iIntValue2 = 0;
                }
                $this$buildMeteorUrl_u24lambda_u242.put("maxSize", iIntValue2);
                $this$buildMeteorUrl_u24lambda_u242.put("resolutions", new JSONArray());
                $this$buildMeteorUrl_u24lambda_u242.put("languages", languages);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u240 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u240.put("title");
                $this$buildMeteorUrl_u24lambda_u242_u240.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u240.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u240.put("audio");
                Unit unit = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u242.put("resultFormat", $this$buildMeteorUrl_u24lambda_u242_u240);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u241 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u241.put("cached");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("resolution");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("seeders");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("pack");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("language");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("seadex");
                Unit unit2 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u242.put("sortOrder", $this$buildMeteorUrl_u24lambda_u242_u241);
                byte[] bytes = $this$buildMeteorUrl_u24lambda_u242.toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                String encoded = Base64.encodeToString(bytes, 10);
                return baseUrl2 + '/' + encoded;
            case 1:
                i = 0;
                preferredLanguages = (JSONArray) c00001.L$7;
                sizeFilter = (String) c00001.L$6;
                limit = (String) c00001.L$5;
                debridKey = (String) c00001.L$3;
                debridProvider = (String) c00001.L$2;
                baseUrl2 = (String) c00001.L$1;
                sharedPref2 = (SharedPreferences) c00001.L$0;
                ResultKt.throwOnFailure($result);
                JSONObject languages2 = new JSONObject();
                languages2.put("preferred", preferredLanguages);
                languages2.put("required", new JSONArray());
                languages2.put("exclude", new JSONArray());
                JSONObject $this$buildMeteorUrl_u24lambda_u243 = new JSONObject();
                Object lowerCase2 = debridProvider.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                $this$buildMeteorUrl_u24lambda_u243.put("debridService", lowerCase2);
                $this$buildMeteorUrl_u24lambda_u243.put("debridApiKey", debridKey);
                $this$buildMeteorUrl_u24lambda_u243.put("cachedOnly", false);
                $this$buildMeteorUrl_u24lambda_u243.put("removeTrash", true);
                $this$buildMeteorUrl_u24lambda_u243.put("removeSamples", true);
                $this$buildMeteorUrl_u24lambda_u243.put("removeAdult", false);
                $this$buildMeteorUrl_u24lambda_u243.put("exclude3D", false);
                $this$buildMeteorUrl_u24lambda_u243.put("enableSeaDex", false);
                $this$buildMeteorUrl_u24lambda_u243.put("minSeeders", 0);
                intOrNull = StringsKt.toIntOrNull(limit);
                if (intOrNull != null) {
                    iIntValue = intOrNull.intValue();
                } else {
                    iIntValue = 0;
                }
                $this$buildMeteorUrl_u24lambda_u243.put("maxResults", iIntValue);
                $this$buildMeteorUrl_u24lambda_u243.put("maxResultsPerRes", 0);
                intOrNull2 = StringsKt.toIntOrNull(sizeFilter);
                if (intOrNull2 != null) {
                    iIntValue2 = intOrNull2.intValue();
                } else {
                    iIntValue2 = 0;
                }
                $this$buildMeteorUrl_u24lambda_u243.put("maxSize", iIntValue2);
                $this$buildMeteorUrl_u24lambda_u243.put("resolutions", new JSONArray());
                $this$buildMeteorUrl_u24lambda_u243.put("languages", languages2);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u242 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u242.put("title");
                $this$buildMeteorUrl_u24lambda_u242_u242.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u242.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u242.put("audio");
                Unit unit3 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u243.put("resultFormat", $this$buildMeteorUrl_u24lambda_u242_u242);
                JSONArray $this$buildMeteorUrl_u24lambda_u242_u243 = new JSONArray();
                $this$buildMeteorUrl_u24lambda_u242_u243.put("cached");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("resolution");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("seeders");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("pack");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("language");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("seadex");
                Unit unit4 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u243.put("sortOrder", $this$buildMeteorUrl_u24lambda_u242_u243);
                byte[] bytes2 = $this$buildMeteorUrl_u24lambda_u243.toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                String encoded2 = Base64.encodeToString(bytes2, 10);
                return baseUrl2 + '/' + encoded2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
