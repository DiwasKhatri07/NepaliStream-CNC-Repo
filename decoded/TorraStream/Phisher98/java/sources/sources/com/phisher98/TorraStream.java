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
@SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,549:1\n73#2,5:550\n73#2,5:569\n73#2,5:607\n73#2,5:690\n1795#3,10:555\n2068#3:565\n2069#3:567\n1805#3:568\n1795#3,10:574\n2068#3:584\n2069#3:586\n1805#3:587\n1795#3,10:612\n2068#3:622\n2069#3:624\n1805#3:625\n1960#3,3:626\n1795#3,10:629\n2068#3:639\n2069#3:641\n1805#3:642\n1795#3,10:644\n2068#3:654\n2069#3:656\n1805#3:657\n1795#3,10:658\n2068#3:668\n2069#3:670\n1805#3:671\n1795#3,10:672\n2068#3:682\n2069#3:684\n1805#3:685\n1739#3:686\n1814#3,3:687\n777#3:695\n873#3,2:696\n1739#3:719\n1814#3,3:720\n1#4:566\n1#4:585\n1#4:589\n1#4:623\n1#4:640\n1#4:643\n1#4:655\n1#4:669\n1#4:683\n1#4:698\n1#4:700\n1#4:718\n63#5:588\n64#5,15:590\n63#5:699\n64#5,15:701\n50#6:605\n43#6:606\n50#6:716\n43#6:717\n*S KotlinDebug\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream\n*L\n121#1:550,5\n143#1:569,5\n157#1:607,5\n203#1:690,5\n121#1:555,10\n121#1:565\n121#1:567\n121#1:568\n143#1:574,10\n143#1:584\n143#1:586\n143#1:587\n165#1:612,10\n165#1:622\n165#1:624\n165#1:625\n169#1:626,3\n172#1:629,10\n172#1:639\n172#1:641\n172#1:642\n173#1:644,10\n173#1:654\n173#1:656\n173#1:657\n175#1:658,10\n175#1:668\n175#1:670\n175#1:671\n184#1:672,10\n184#1:682\n184#1:684\n184#1:685\n186#1:686\n186#1:687,3\n231#1:695\n231#1:696,2\n237#1:719\n237#1:720,3\n121#1:566\n143#1:585\n150#1:589\n165#1:623\n172#1:640\n173#1:655\n175#1:669\n184#1:683\n347#1:700\n150#1:588\n150#1:590,15\n347#1:699\n347#1:701,15\n150#1:605\n150#1:606\n347#1:716\n347#1:717\n*E\n"})
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
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {484}, m = "buildMeteorUrl", n = {"sharedPref", "baseUrl", "debridProvider", "debridKey", "languagesPref", "limit", "sizeFilter", "$this$buildMeteorUrl_u24lambda_u240"}, nl = {486}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0}, l = {120}, m = "getMainPage", n = {"request", "adultQuery", "type", "page"}, nl = {121}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {157, 194, 203, 206, 234, 275, 295, 314}, m = "load", n = {"url", "data", "type", "resUrl", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "animeVideos", "jpTitle", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "animeVideos", "jpTitle", "syncMetaData", "animeMetaData", "kitsuid", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "isCartoon", "isAnime", "isAsian", "isBollywood", "comingSoonFlag"}, nl = {569, 201, 652, 228, 235, 295, 314, 205}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {355, 369, 373, 382, 388, 425}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "$this$loadLinks_u24lambda_u240", "isCasting", "isAnime", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid", "data", "subtitleCallback", "callback", "provider", "key", "dataObj", "title", "season", "episode", "id", "year", "aniResponse", "anijson", "aniJson", "mappings", "kitsuId", "torrentioapiUrl", "meteorUrl", "filtered", "isCasting", "isAnime", "isMovie", "anidbEid"}, nl = {355, 370, 379, 388, 425, 426}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "Z$1", "I$0", "I$1"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0}, l = {138}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream", f = "TorraStream.kt", i = {0, 0}, l = {141}, m = "search", n = {"query", "page"}, nl = {143}, s = {"L$0", "I$0"}, v = 2)
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
    /* JADX WARN: Code duplicated, block: B:101:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:104:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:109:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:112:0x06e4  */
    /* JADX WARN: Code duplicated, block: B:114:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:117:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:120:0x0703  */
    /* JADX WARN: Code duplicated, block: B:123:0x071f A[LOOP:8: B:118:0x06fd->B:123:0x071f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:126:0x0728  */
    /* JADX WARN: Code duplicated, block: B:129:0x0732  */
    /* JADX WARN: Code duplicated, block: B:140:0x0785  */
    /* JADX WARN: Code duplicated, block: B:142:0x078a  */
    /* JADX WARN: Code duplicated, block: B:145:0x0796  */
    /* JADX WARN: Code duplicated, block: B:147:0x079d  */
    /* JADX WARN: Code duplicated, block: B:158:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:161:0x07fc  */
    /* JADX WARN: Code duplicated, block: B:215:0x0996  */
    /* JADX WARN: Code duplicated, block: B:220:0x09a3  */
    /* JADX WARN: Code duplicated, block: B:227:0x0a45  */
    /* JADX WARN: Code duplicated, block: B:229:0x0a5a  */
    /* JADX WARN: Code duplicated, block: B:230:0x0a5c  */
    /* JADX WARN: Code duplicated, block: B:233:0x0a64  */
    /* JADX WARN: Code duplicated, block: B:234:0x0a67  */
    /* JADX WARN: Code duplicated, block: B:237:0x0a6f  */
    /* JADX WARN: Code duplicated, block: B:238:0x0a74  */
    /* JADX WARN: Code duplicated, block: B:240:0x0a78  */
    /* JADX WARN: Code duplicated, block: B:243:0x0b44 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:244:0x0b45  */
    /* JADX WARN: Code duplicated, block: B:261:0x0ba8  */
    /* JADX WARN: Code duplicated, block: B:263:0x0bae  */
    /* JADX WARN: Code duplicated, block: B:265:0x0bb7  */
    /* JADX WARN: Code duplicated, block: B:266:0x0bb9  */
    /* JADX WARN: Code duplicated, block: B:269:0x0c42 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:270:0x0c43  */
    /* JADX WARN: Code duplicated, block: B:273:0x0c66  */
    /* JADX WARN: Code duplicated, block: B:277:0x0cbb  */
    /* JADX WARN: Code duplicated, block: B:281:0x0d09  */
    /* JADX WARN: Code duplicated, block: B:282:0x0d0b  */
    /* JADX WARN: Code duplicated, block: B:301:0x0d6d  */
    /* JADX WARN: Code duplicated, block: B:304:0x0d7b  */
    /* JADX WARN: Code duplicated, block: B:319:0x0dbc  */
    /* JADX WARN: Code duplicated, block: B:321:0x0dc0  */
    /* JADX WARN: Code duplicated, block: B:324:0x0dcb  */
    /* JADX WARN: Code duplicated, block: B:327:0x0e9d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:328:0x0e9e  */
    /* JADX WARN: Code duplicated, block: B:331:0x0ec3  */
    /* JADX WARN: Code duplicated, block: B:334:0x0ece  */
    /* JADX WARN: Code duplicated, block: B:337:0x0edc  */
    /* JADX WARN: Code duplicated, block: B:338:0x0edf  */
    /* JADX WARN: Code duplicated, block: B:340:0x0ee3  */
    /* JADX WARN: Code duplicated, block: B:341:0x0ee6  */
    /* JADX WARN: Code duplicated, block: B:343:0x0eea  */
    /* JADX WARN: Code duplicated, block: B:344:0x0eed  */
    /* JADX WARN: Code duplicated, block: B:347:0x0fde A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:348:0x0fdf  */
    /* JADX WARN: Code duplicated, block: B:350:0x0ff9  */
    /* JADX WARN: Code duplicated, block: B:352:0x10f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:353:0x10f3  */
    /* JADX WARN: Code duplicated, block: B:355:0x110d  */
    /* JADX WARN: Code duplicated, block: B:357:0x1138  */
    /* JADX WARN: Code duplicated, block: B:358:0x113b  */
    /* JADX WARN: Code duplicated, block: B:361:0x1143  */
    /* JADX WARN: Code duplicated, block: B:362:0x114a  */
    /* JADX WARN: Code duplicated, block: B:366:0x1166  */
    /* JADX WARN: Code duplicated, block: B:369:0x1210 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:370:0x1211  */
    /* JADX WARN: Code duplicated, block: B:375:0x1273  */
    /* JADX WARN: Code duplicated, block: B:412:0x0724 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x071d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x05df  */
    /* JADX WARN: Code duplicated, block: B:67:0x0605  */
    /* JADX WARN: Code duplicated, block: B:75:0x0631  */
    /* JADX WARN: Code duplicated, block: B:78:0x0638  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x0657  */
    /* JADX WARN: Code duplicated, block: B:83:0x066b  */
    /* JADX WARN: Code duplicated, block: B:84:0x067a  */
    /* JADX WARN: Code duplicated, block: B:87:0x068e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0694  */
    /* JADX WARN: Code duplicated, block: B:91:0x069b  */
    /* JADX WARN: Code duplicated, block: B:94:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:96:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:99:0x06bb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v37 */
    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00021 c00021;
        Object obj;
        Object objDecodeFromString;
        TvType type;
        String str2;
        Object obj2;
        String str3;
        Data data;
        Object safe;
        MediaDetail mediaDetail;
        String title;
        String releaseDate;
        String str4;
        Integer intOrNull;
        ArrayList<Genres> genres;
        ArrayList arrayList;
        boolean zContains;
        String str5;
        int i;
        int i2;
        int i3;
        ArrayList<ProductionCountries> production_countries;
        int i4;
        int i5;
        int i6;
        KeywordResults keywords;
        int i7;
        Collection collectionEmptyList;
        boolean zIsEmpty;
        Collection collection;
        Credits credits;
        ArrayList<Cast> cast;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str6;
        String lowerCase;
        ?? IsUpcoming;
        TvType tvType;
        String str7;
        String str8;
        Object obj3;
        String str9;
        String str10;
        List list;
        Object obj4;
        String str11;
        String str12;
        String str13;
        int i8;
        MediaDetail mediaDetail2;
        List list2;
        int i9;
        Integer num;
        List list3;
        int i10;
        int i11;
        List list4;
        String str14;
        int i12;
        Data data2;
        ArrayList<Trailers> results;
        ArrayList<Media> results2;
        KeywordResults keywords2;
        ArrayList<Keywords> keywords3;
        ArrayList<Keywords> results3;
        ArrayList<ProductionCountries> arrayList4;
        Iterator it;
        ArrayList<ProductionCountries> arrayList5;
        Iterator it2;
        ArrayList arrayList6;
        Iterator it3;
        String name;
        ArrayList arrayList7;
        List listSplit$default;
        String str15;
        String str16;
        String type2;
        String str17;
        int i13;
        boolean z;
        String str18;
        ExternalIds external_ids;
        String imdb_id;
        int i14;
        List list5;
        List list6;
        List list7;
        List list8;
        String str19;
        Data data3;
        int i15;
        int i16;
        int i17;
        String str20;
        boolean z2;
        Integer num2;
        Object obj5;
        int i18;
        Object obj6;
        C00021 c00022;
        String str21;
        String str22;
        MediaDetail mediaDetail3;
        String str23;
        String str24;
        Object obj7;
        Data data4;
        List list9;
        List list10;
        String str25;
        String str26;
        Integer num3;
        List list11;
        List list12;
        String str27;
        TvType tvType2;
        String str28;
        String str29;
        int i19;
        int i20;
        int i21;
        int i22;
        Data data5;
        int i23;
        Object safe2;
        CinemetaRes cinemetaRes;
        Integer num4;
        int i24;
        String str30;
        List list13;
        String str31;
        int i25;
        Object obj8;
        String str32;
        boolean z3;
        ExternalIds external_ids2;
        String imdb_id2;
        List list14;
        List list15;
        List list16;
        int i26;
        Data data6;
        String str33;
        int i27;
        String str34;
        int i28;
        MediaDetail mediaDetail4;
        List list17;
        List list18;
        List list19;
        CinemetaRes cinemetaRes2;
        String str35;
        String str36;
        String str37;
        Integer num5;
        int i29;
        Data data7;
        String str38;
        String str39;
        List list20;
        String str40;
        ArrayList<Seasons> seasons;
        TvType tvType3;
        int i30;
        int i31;
        Object obj9;
        int i32;
        String str41;
        int i33;
        int i34;
        Data data8;
        int i35;
        boolean z4;
        int i36;
        int i37;
        Integer num6;
        int i38;
        int i39;
        List list21;
        String str42;
        String str43;
        String str44;
        String str45;
        Object objAmap;
        String str46;
        int i40;
        Data data9;
        int i41;
        List list22;
        String str47;
        List list23;
        String str48;
        String str49;
        String str50;
        Integer num7;
        int i42;
        String str51;
        int i43;
        String str52;
        int i44;
        Object obj10;
        int i45;
        int i46;
        List list24;
        String str53;
        Integer num8;
        String str54;
        String str55;
        String str56;
        List listEmptyList;
        Data data10;
        String str57;
        List list25;
        MediaDetail mediaDetail5;
        int i47;
        List list26;
        int i48;
        String str58;
        List list27;
        CinemetaRes cinemetaRes3;
        List list28;
        Object obj11;
        Object objNewTvSeriesLoadResponse;
        C00021 c00023;
        Object obj12;
        String str59;
        CinemetaRes cinemetaRes4;
        ArrayList arrayListEmptyList;
        ResultsAltTitles alternative_titles;
        List list29;
        String name2;
        CinemetaRes.Meta meta;
        String str60;
        String str61;
        String str62;
        List list30;
        List list31;
        String str63;
        Data data11;
        int i49;
        int i50;
        int i51;
        String str64;
        Integer num9;
        MediaDetail mediaDetail6;
        List list32;
        int i52;
        List list33;
        int i53;
        Object obj13;
        C00021 c00024;
        Object obj14;
        int i54;
        String str65;
        String str66;
        String str67;
        String str68;
        List list34;
        String str69;
        List list35;
        Data data12;
        String str70;
        String str71;
        String str72;
        List list36;
        int i55;
        ArrayList<AltTitles> results4;
        Object next;
        CinemetaRes.Meta meta2;
        List<CinemetaRes.Meta.Video> videos;
        List list37;
        List listFlatten;
        MetaAnimeData animeData;
        String kitsuid;
        boolean z5;
        boolean z6;
        boolean z7;
        Object obj15;
        Object objNewAnimeLoadResponse$default;
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
        C00021 c00025 = c00021;
        Object objNewMovieLoadResponse = c00025.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00025.label) {
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Data.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Data>() { // from class: com.phisher98.TorraStream$load$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Data>() { // from class: com.phisher98.TorraStream$load$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<Data>() { // from class: com.phisher98.TorraStream$load$$inlined$parseJson$1
                    });
                }
                Data data13 = (Data) objDecodeFromString;
                type = INSTANCE.getType(data13.getType());
                str2 = type == TvType.Movie ? "https://api.themoviedb.org/3/movie/" + data13.getId() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=keywords,credits,external_ids,videos,recommendations" : "https://api.themoviedb.org/3/tv/" + data13.getId() + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=keywords,credits,external_ids,videos,recommendations";
                Requests app = MainActivityKt.getApp();
                c00025.L$0 = str;
                c00025.L$1 = data13;
                c00025.L$2 = type;
                c00025.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                c00025.label = 1;
                obj2 = Requests.get$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str3 = str;
                data = data13;
                NiceResponse niceResponse = (NiceResponse) obj2;
                try {
                    ResponseParser parser = niceResponse.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(niceResponse.getText(), Reflection.getOrCreateKotlinClass(MediaDetail.class));
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    safe = null;
                }
                mediaDetail = (MediaDetail) safe;
                if (mediaDetail != null) {
                    throw new ErrorLoadingException("Invalid Json Response");
                }
                title = mediaDetail.getTitle();
                if (title != null && (title = mediaDetail.getName()) == null) {
                    return null;
                }
                String str73 = title;
                String oriImageUrl = getOriImageUrl(mediaDetail.getPosterPath());
                String oriImageUrl2 = getOriImageUrl(mediaDetail.getBackdropPath());
                releaseDate = mediaDetail.getReleaseDate();
                if (releaseDate == null) {
                    releaseDate = mediaDetail.getFirstAirDate();
                }
                str4 = releaseDate;
                if (str4 != null || (listSplit$default = StringsKt.split$default(str4, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str15 = (String) CollectionsKt.first(listSplit$default)) == null) {
                    intOrNull = null;
                } else {
                    intOrNull = StringsKt.toIntOrNull(str15);
                }
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
                        objNewMovieLoadResponse = objNewMovieLoadResponse;
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
                        str5 = str2;
                        if (Intrinsics.areEqual(mediaDetail.getOriginal_language(), "ja")) {
                        }
                        if (i == 0 || !(Intrinsics.areEqual(mediaDetail.getOriginal_language(), "zh") || Intrinsics.areEqual(mediaDetail.getOriginal_language(), "ko"))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        i3 = i2;
                        production_countries = mediaDetail.getProduction_countries();
                        if (production_countries != null) {
                            arrayList4 = production_countries;
                            i4 = i3;
                            if ((arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                                it = arrayList4.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        arrayList5 = arrayList4;
                                        it2 = it;
                                        if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                            i5 = 1;
                                        } else {
                                            arrayList4 = arrayList5;
                                            it = it2;
                                        }
                                    } else {
                                        i5 = 0;
                                    }
                                }
                            } else {
                                i5 = 0;
                            }
                        } else {
                            i4 = i3;
                            i5 = 0;
                        }
                        i6 = i5;
                        keywords = mediaDetail.getKeywords();
                        if (keywords != null || (results3 = keywords.getResults()) == null) {
                            i7 = i6;
                            collectionEmptyList = null;
                        } else {
                            ArrayList<Keywords> arrayList8 = results3;
                            ArrayList arrayList9 = new ArrayList();
                            Iterator it4 = arrayList8.iterator();
                            while (it4.hasNext()) {
                                String name3 = ((Keywords) it4.next()).getName();
                                if (name3 != null) {
                                    arrayList9.add(name3);
                                }
                                i6 = i6;
                            }
                            i7 = i6;
                            collectionEmptyList = arrayList9;
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
                                ArrayList<Keywords> arrayList10 = keywords3;
                                ArrayList arrayList11 = new ArrayList();
                                Iterator it5 = arrayList10.iterator();
                                while (it5.hasNext()) {
                                    String name4 = ((Keywords) it5.next()).getName();
                                    if (name4 != null) {
                                        arrayList11.add(name4);
                                    }
                                    arrayList10 = arrayList10;
                                }
                                collection = arrayList11;
                            }
                        }
                        List list38 = (List) collection;
                        credits = mediaDetail.getCredits();
                        if (credits != null || (cast = credits.getCast()) == null) {
                            return null;
                        }
                        ArrayList<Cast> arrayList12 = cast;
                        ArrayList arrayList13 = new ArrayList();
                        for (Cast cast2 : arrayList12) {
                            String name5 = cast2.getName();
                            ActorData actorData = (name5 == null && (name5 = cast2.getOriginalName()) == null) ? null : new ActorData(new Actor(name5, getImageUrl(cast2.getProfilePath())), (ActorRole) null, cast2.getCharacter(), (Actor) null, 10, (DefaultConstructorMarker) null);
                            if (actorData != null) {
                                arrayList13.add(actorData);
                            }
                            zContains = zContains;
                            i = i;
                            list38 = list38;
                        }
                        boolean z8 = zContains;
                        int i56 = i;
                        List list39 = list38;
                        ArrayList arrayList14 = arrayList13;
                        ResultsRecommendations recommendations = mediaDetail.getRecommendations();
                        if (recommendations == null || (results2 = recommendations.getResults()) == null) {
                            arrayList2 = arrayList14;
                            arrayList3 = null;
                        } else {
                            ArrayList<Media> arrayList15 = results2;
                            int i57 = 0;
                            ArrayList arrayList16 = new ArrayList();
                            Iterator it6 = arrayList15.iterator();
                            while (it6.hasNext()) {
                                ArrayList<Media> arrayList17 = arrayList15;
                                int i58 = i57;
                                ArrayList arrayList18 = arrayList14;
                                SearchResponse searchResponse$default = toSearchResponse$default(this, (Media) it6.next(), null, 1, null);
                                if (searchResponse$default != null) {
                                    arrayList16.add(searchResponse$default);
                                }
                                arrayList14 = arrayList18;
                                arrayList15 = arrayList17;
                                i57 = i58;
                            }
                            arrayList2 = arrayList14;
                            arrayList3 = arrayList16;
                        }
                        ArrayList arrayList19 = arrayList3;
                        ResultsTrailer videos2 = mediaDetail.getVideos();
                        if (videos2 == null || (results = videos2.getResults()) == null) {
                            str6 = null;
                        } else {
                            ArrayList<Trailers> arrayList20 = results;
                            ArrayList arrayList21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList20, 10));
                            ArrayList<Trailers> arrayList22 = arrayList20;
                            Iterator it7 = arrayList22.iterator();
                            while (it7.hasNext()) {
                                arrayList21.add("https://www.youtube.com/watch?v=" + ((Trailers) it7.next()).getKey());
                                arrayList20 = arrayList20;
                                arrayList22 = arrayList22;
                            }
                            str6 = (String) CollectionsKt.randomOrNull(arrayList21, Random.Default);
                        }
                        String str74 = str6;
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
                                    IsUpcoming = isUpcoming(str4);
                                    break;
                            }
                        } else {
                            IsUpcoming = isUpcoming(str4);
                        }
                        Integer id = mediaDetail.getId();
                        c00025.L$0 = str3;
                        c00025.L$1 = data;
                        c00025.L$2 = type;
                        c00025.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                        c00025.L$4 = mediaDetail;
                        c00025.L$5 = str73;
                        c00025.L$6 = oriImageUrl;
                        c00025.L$7 = oriImageUrl2;
                        c00025.L$8 = SpillingKt.nullOutSpilledVariable(str4);
                        c00025.L$9 = intOrNull;
                        c00025.L$10 = arrayList;
                        c00025.L$11 = list39;
                        c00025.L$12 = arrayList2;
                        c00025.L$13 = arrayList19;
                        c00025.L$14 = str74;
                        c00025.I$0 = z8 ? 1 : 0;
                        c00025.I$1 = i56;
                        c00025.I$2 = i4;
                        int i59 = i7;
                        c00025.I$3 = i59;
                        c00025.I$4 = IsUpcoming;
                        List list40 = arrayList;
                        c00025.label = 2;
                        ?? r22 = IsUpcoming;
                        Integer num10 = intOrNull;
                        tvType = type;
                        Data data14 = data;
                        str7 = null;
                        Object objFetchTmdbLogoUrl = TorraStreamUtilsKt.fetchTmdbLogoUrl(tmdbAPI, apiKey, tvType, id, "en", c00025);
                        if (objFetchTmdbLogoUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str8 = str5;
                        obj3 = objFetchTmdbLogoUrl;
                        str9 = str74;
                        str10 = str3;
                        list = arrayList19;
                        obj4 = coroutine_suspended;
                        str11 = oriImageUrl;
                        str12 = oriImageUrl2;
                        str13 = str73;
                        i8 = i4;
                        mediaDetail2 = mediaDetail;
                        list2 = list40;
                        i9 = r22 == true ? 1 : 0;
                        num = num10;
                        list3 = arrayList2;
                        i10 = z8 ? 1 : 0;
                        i11 = i56;
                        list4 = list39;
                        str14 = str4;
                        i12 = i59;
                        data2 = data14;
                        str16 = (String) obj3;
                        type2 = data2.getType();
                        if (type2 != null) {
                            str17 = str8;
                            i13 = i9;
                            z = StringsKt.contains(type2, "tv", true);
                            if (z) {
                                str18 = "series";
                            } else {
                                str18 = "movie";
                            }
                            external_ids = mediaDetail2.getExternal_ids();
                            if (external_ids != null) {
                                imdb_id = external_ids.getImdb_id();
                            } else {
                                imdb_id = str7;
                            }
                            if (imdb_id == null) {
                                imdb_id = "";
                            }
                            i14 = i12;
                            c00025.L$0 = str10;
                            c00025.L$1 = data2;
                            c00025.L$2 = tvType;
                            c00025.L$3 = SpillingKt.nullOutSpilledVariable(str17);
                            c00025.L$4 = mediaDetail2;
                            c00025.L$5 = str13;
                            c00025.L$6 = str11;
                            c00025.L$7 = str12;
                            c00025.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                            c00025.L$9 = num;
                            list5 = list2;
                            c00025.L$10 = list5;
                            list6 = list4;
                            c00025.L$11 = list6;
                            list7 = list3;
                            c00025.L$12 = list7;
                            list8 = list;
                            c00025.L$13 = list8;
                            str19 = str9;
                            c00025.L$14 = str19;
                            c00025.L$15 = str16;
                            data3 = data2;
                            c00025.L$16 = SpillingKt.nullOutSpilledVariable(str18);
                            c00025.L$17 = imdb_id;
                            i15 = i10;
                            c00025.I$0 = i15 == true ? 1 : 0;
                            c00025.I$1 = i11;
                            c00025.I$2 = i8;
                            c00025.I$3 = i14;
                            c00025.I$4 = i13 == true ? 1 : 0;
                            c00025.label = 3;
                            i16 = i8;
                            i17 = i11;
                            str20 = str12;
                            z2 = true;
                            num2 = num;
                            obj5 = obj4;
                            i18 = i13 == true ? 1 : 0;
                            obj6 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str18 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                            c00022 = c00025;
                            if (obj6 == obj5) {
                                return obj5;
                            }
                            str21 = str17;
                            str22 = str16;
                            mediaDetail3 = mediaDetail2;
                            str23 = str11;
                            str24 = imdb_id;
                            obj7 = obj6;
                            data4 = data3;
                            list9 = list7;
                            list10 = list5;
                            str25 = str19;
                            str26 = str20;
                            num3 = num2;
                            list11 = list8;
                            list12 = list6;
                            str27 = str10;
                            tvType2 = tvType;
                            str28 = str18;
                            str29 = str13;
                            i19 = i15 == true ? 1 : 0;
                            i20 = i17;
                            i21 = i14;
                            i22 = i16;
                            NiceResponse niceResponse2 = (NiceResponse) obj7;
                            try {
                                ResponseParser parser2 = niceResponse2.getParser();
                                Intrinsics.checkNotNull(parser2);
                                data5 = data4;
                                try {
                                    i23 = i21;
                                    try {
                                        safe2 = parser2.parseSafe(niceResponse2.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        safe2 = str7;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    i23 = i21;
                                }
                                break;
                            } catch (Exception e5) {
                                e = e5;
                                data5 = data4;
                                i23 = i21;
                            }
                            cinemetaRes = (CinemetaRes) safe2;
                            if (tvType2 != TvType.TvSeries) {
                                int i60 = i22;
                                TvType tvType4 = tvType2;
                                num4 = num3;
                                int i61 = i23;
                                i24 = i18;
                                str30 = str24;
                                list13 = list11;
                                int i62 = i19;
                                String str75 = str29;
                                str31 = str25;
                                i25 = i20;
                                C00021 c00026 = c00022;
                                obj8 = obj5;
                                str32 = str22;
                                MainAPI mainAPI = (MainAPI) this;
                                TvType tvType5 = TvType.Movie;
                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                String title2 = mediaDetail3.getTitle();
                                if (i25 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                external_ids2 = mediaDetail3.getExternal_ids();
                                if (external_ids2 != null) {
                                    imdb_id2 = external_ids2.getImdb_id();
                                } else {
                                    imdb_id2 = str7;
                                }
                                String json = appUtils2.toJson(new LoadData(title2, num4, z3, imdb_id2, null, null, 48, null));
                                list14 = list10;
                                if (i24 == 0) {
                                    z2 = false;
                                }
                                list15 = list12;
                                list16 = list9;
                                C00054 c00054 = new C00054(str23, z2, str26, str32, num4, mediaDetail3, list15, list14, list13, list16, cinemetaRes, str31, null);
                                c00026.L$0 = SpillingKt.nullOutSpilledVariable(str27);
                                c00026.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                                c00026.L$2 = SpillingKt.nullOutSpilledVariable(tvType4);
                                c00026.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                c00026.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail3);
                                c00026.L$5 = SpillingKt.nullOutSpilledVariable(str75);
                                c00026.L$6 = SpillingKt.nullOutSpilledVariable(str23);
                                c00026.L$7 = SpillingKt.nullOutSpilledVariable(str26);
                                c00026.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                c00026.L$9 = SpillingKt.nullOutSpilledVariable(num4);
                                c00026.L$10 = SpillingKt.nullOutSpilledVariable(list14);
                                c00026.L$11 = SpillingKt.nullOutSpilledVariable(list15);
                                c00026.L$12 = SpillingKt.nullOutSpilledVariable(list16);
                                c00026.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                                c00026.L$14 = SpillingKt.nullOutSpilledVariable(str31);
                                c00026.L$15 = SpillingKt.nullOutSpilledVariable(str32);
                                c00026.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                                c00026.L$17 = SpillingKt.nullOutSpilledVariable(str30);
                                c00026.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                                c00026.I$0 = i62 == true ? 1 : 0;
                                c00026.I$1 = i25;
                                c00026.I$2 = i60;
                                c00026.I$3 = i61;
                                c00026.I$4 = i24 == true ? 1 : 0;
                                c00026.label = 8;
                                i26 = i60;
                                data6 = data5;
                                str33 = str27;
                                i27 = i61;
                                str34 = str75;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI, str34, str33, tvType5, json, c00054, c00026);
                                if (objNewMovieLoadResponse == obj8) {
                                    return obj8;
                                }
                                i28 = i25;
                                mediaDetail4 = mediaDetail3;
                                list17 = list15;
                                list18 = list14;
                                list19 = list13;
                                cinemetaRes2 = cinemetaRes;
                                str35 = str31;
                                str36 = str14;
                                str37 = str30;
                                num5 = num4;
                                i29 = i24 == true ? 1 : 0;
                                data7 = data6;
                                str38 = str23;
                                str39 = str32;
                                list20 = list16;
                                str40 = str28;
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            seasons = mediaDetail3.getSeasons();
                            if (seasons != null) {
                                ArrayList<Seasons> arrayList23 = seasons;
                                i35 = i19;
                                if (i20 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                Object obj16 = obj5;
                                i36 = i22;
                                i37 = i20;
                                tvType3 = tvType2;
                                num6 = num3;
                                MediaDetail mediaDetail7 = mediaDetail3;
                                i38 = i18;
                                Data data15 = data5;
                                i39 = i23;
                                TorraStream$load$episodes$1 torraStream$load$episodes$1 = new TorraStream$load$episodes$1(data15, this, mediaDetail7, num6, z4, null);
                                c00022.L$0 = str27;
                                c00022.L$1 = data15;
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                                c00022.L$4 = mediaDetail7;
                                c00022.L$5 = str29;
                                c00022.L$6 = str23;
                                c00022.L$7 = str26;
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                c00022.L$9 = num6;
                                c00022.L$10 = list10;
                                c00022.L$11 = list12;
                                c00022.L$12 = list9;
                                list21 = list11;
                                c00022.L$13 = list21;
                                str42 = str25;
                                c00022.L$14 = str42;
                                str43 = str22;
                                c00022.L$15 = str43;
                                c00022.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                                str44 = str24;
                                c00022.L$17 = str44;
                                c00022.L$18 = cinemetaRes;
                                c00022.I$0 = i35 == true ? 1 : 0;
                                str45 = str29;
                                c00022.I$1 = i37;
                                c00022.I$2 = i36;
                                c00022.I$3 = i39;
                                c00022.I$4 = i38 == true ? 1 : 0;
                                c00022.label = 4;
                                objAmap = ParCollectionsKt.amap(arrayList23, torraStream$load$episodes$1, c00022);
                                obj9 = obj16;
                                if (objAmap == obj9) {
                                    return obj9;
                                }
                                str46 = str42;
                                i32 = i37;
                                i40 = i35 == true ? 1 : 0;
                                data9 = data5;
                                i41 = i38 == true ? 1 : 0;
                                list22 = list10;
                                str47 = str23;
                                list23 = list21;
                                str48 = str14;
                                str49 = str28;
                                str50 = str44;
                                num7 = num6;
                                i42 = i39;
                                str51 = str21;
                                i43 = i36;
                                objNewMovieLoadResponse = objAmap;
                                str52 = str45;
                                list37 = (List) objNewMovieLoadResponse;
                                if (list37 != null || (listFlatten = CollectionsKt.flatten(list37)) == null) {
                                    int i63 = i42;
                                    i34 = i43;
                                    i30 = i63;
                                    str25 = str46;
                                    i31 = i40;
                                    str24 = str50;
                                    i33 = i41;
                                    list11 = list23;
                                    list10 = list22;
                                    num3 = num7;
                                    str14 = str48;
                                    str21 = str51;
                                    data8 = data9;
                                    str41 = str52;
                                    str28 = str49;
                                    str23 = str47;
                                    str22 = str43;
                                } else {
                                    int i64 = i41;
                                    listEmptyList = listFlatten;
                                    str57 = str27;
                                    mediaDetail5 = mediaDetail3;
                                    i47 = i64 == true ? 1 : 0;
                                    List list41 = list12;
                                    str56 = str46;
                                    list24 = list41;
                                    List list42 = list22;
                                    i46 = i40;
                                    list25 = list42;
                                    i48 = i42;
                                    obj10 = obj9;
                                    i45 = i32;
                                    str55 = str50;
                                    str53 = str26;
                                    list26 = list23;
                                    num8 = num7;
                                    str14 = str48;
                                    data10 = data9;
                                    i44 = i43;
                                    str54 = str49;
                                    str58 = str47;
                                    list27 = list9;
                                    cinemetaRes3 = cinemetaRes;
                                }
                                list28 = listEmptyList;
                                if (i45 == 0) {
                                    String str76 = str52;
                                    String str77 = str55;
                                    Integer num11 = num8;
                                    String str78 = str43;
                                    MediaDetail mediaDetail8 = mediaDetail5;
                                    List list43 = list24;
                                    List list44 = list25;
                                    C00021 c00027 = c00022;
                                    List list45 = list26;
                                    List list46 = list27;
                                    CinemetaRes cinemetaRes5 = cinemetaRes3;
                                    int i65 = i47;
                                    obj11 = obj10;
                                    TvType tvType6 = TvType.TvSeries;
                                    String str79 = str57;
                                    String str80 = str58;
                                    String str81 = str53;
                                    C00043 c00043 = new C00043(str80, str81, str78, num11, mediaDetail8, list43, list44, this, list45, list46, list28, cinemetaRes5, str56, null);
                                    c00027.L$0 = SpillingKt.nullOutSpilledVariable(str79);
                                    c00027.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                                    c00027.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                    c00027.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                                    c00027.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail8);
                                    c00027.L$5 = SpillingKt.nullOutSpilledVariable(str76);
                                    c00027.L$6 = SpillingKt.nullOutSpilledVariable(str80);
                                    c00027.L$7 = SpillingKt.nullOutSpilledVariable(str81);
                                    c00027.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                    c00027.L$9 = SpillingKt.nullOutSpilledVariable(num11);
                                    c00027.L$10 = SpillingKt.nullOutSpilledVariable(list44);
                                    c00027.L$11 = SpillingKt.nullOutSpilledVariable(list43);
                                    c00027.L$12 = SpillingKt.nullOutSpilledVariable(list46);
                                    c00027.L$13 = SpillingKt.nullOutSpilledVariable(list45);
                                    c00027.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                                    c00027.L$15 = SpillingKt.nullOutSpilledVariable(str78);
                                    c00027.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00027.L$17 = SpillingKt.nullOutSpilledVariable(str77);
                                    c00027.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes5);
                                    c00027.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                                    c00027.I$0 = i46 == true ? 1 : 0;
                                    c00027.I$1 = i45;
                                    c00027.I$2 = i44;
                                    c00027.I$3 = i48;
                                    c00027.I$4 = i65 == true ? 1 : 0;
                                    c00027.label = 7;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str76, str79, tvType6, list28, c00043, c00027);
                                    c00023 = c00027;
                                    if (objNewTvSeriesLoadResponse == obj11) {
                                        return obj11;
                                    }
                                    obj12 = objNewTvSeriesLoadResponse;
                                    return (LoadResponse) obj12;
                                }
                                if (cinemetaRes3 != null || (meta2 = cinemetaRes3.getMeta()) == null || (videos = meta2.getVideos()) == null) {
                                    str59 = str43;
                                    cinemetaRes4 = cinemetaRes3;
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                } else {
                                    ArrayList arrayList24 = new ArrayList();
                                    for (Object obj17 : videos) {
                                        CinemetaRes cinemetaRes6 = cinemetaRes3;
                                        Integer season = ((CinemetaRes.Meta.Video) obj17).getSeason();
                                        if (season == null || season.intValue() != 0) {
                                            arrayList24.add(obj17);
                                        }
                                        cinemetaRes3 = cinemetaRes6;
                                        str43 = str43;
                                    }
                                    str59 = str43;
                                    cinemetaRes4 = cinemetaRes3;
                                    arrayListEmptyList = arrayList24;
                                }
                                alternative_titles = mediaDetail5.getAlternative_titles();
                                if (alternative_titles == null && (results4 = alternative_titles.getResults()) != null) {
                                    Iterator it8 = results4.iterator();
                                    while (true) {
                                        if (it8.hasNext()) {
                                            next = it8.next();
                                            Iterator it9 = it8;
                                            list29 = arrayListEmptyList;
                                            if (!Intrinsics.areEqual(((AltTitles) next).getIso_3166_1(), "JP")) {
                                                it8 = it9;
                                                arrayListEmptyList = list29;
                                            }
                                        } else {
                                            list29 = arrayListEmptyList;
                                            next = str7;
                                        }
                                    }
                                    AltTitles altTitles = (AltTitles) next;
                                    if (altTitles == null || (name2 = altTitles.getTitle()) == null) {
                                    }
                                    Requests app2 = MainActivityKt.getApp();
                                    str60 = name2;
                                    String str82 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                                    c00022.L$0 = str57;
                                    c00022.L$1 = data10;
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                                    c00022.L$4 = mediaDetail5;
                                    c00022.L$5 = str52;
                                    c00022.L$6 = str58;
                                    c00022.L$7 = str53;
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                    c00022.L$9 = num8;
                                    c00022.L$10 = list25;
                                    c00022.L$11 = list24;
                                    c00022.L$12 = list27;
                                    c00022.L$13 = list26;
                                    c00022.L$14 = str56;
                                    str61 = str59;
                                    c00022.L$15 = str61;
                                    str62 = str52;
                                    c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00022.L$17 = str55;
                                    c00022.L$18 = cinemetaRes4;
                                    c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                                    c00022.L$20 = list29;
                                    list30 = list26;
                                    c00022.L$21 = str60;
                                    c00022.I$0 = i46 == true ? 1 : 0;
                                    int i66 = i45;
                                    c00022.I$1 = i66;
                                    int i67 = i44;
                                    c00022.I$2 = i67;
                                    int i68 = i48;
                                    c00022.I$3 = i68;
                                    c00022.I$4 = i47 == true ? 1 : 0;
                                    c00022.label = 5;
                                    C00021 c00028 = c00022;
                                    list31 = list27;
                                    str63 = str56;
                                    data11 = data10;
                                    i49 = i47;
                                    i50 = i66;
                                    i51 = i46;
                                    str64 = str55;
                                    num9 = num8;
                                    mediaDetail6 = mediaDetail5;
                                    list32 = list25;
                                    i52 = i67;
                                    list33 = list24;
                                    i53 = i68;
                                    obj13 = Requests.get$default(app2, str82, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00028, 4094, (Object) null);
                                    c00024 = c00028;
                                    obj14 = obj10;
                                    if (obj13 == obj14) {
                                        return obj14;
                                    }
                                    i54 = i51 == true ? 1 : 0;
                                    str65 = str57;
                                    str66 = str58;
                                    str67 = str53;
                                    str68 = str62;
                                    list34 = list29;
                                    str69 = str60;
                                    list35 = list31;
                                    data12 = data11;
                                    str70 = str64;
                                    str71 = str61;
                                    str72 = str63;
                                    list36 = list30;
                                    i55 = i49 == true ? 1 : 0;
                                    String string = ((NiceResponse) obj13).toString();
                                    animeData = TorraStreamUtilsKt.parseAnimeData(string);
                                    if (animeData != null || (mappings = animeData.getMappings()) == null) {
                                        kitsuid = str7;
                                    } else {
                                        kitsuid = mappings.getKitsuid();
                                    }
                                    MainAPI mainAPI2 = (MainAPI) this;
                                    TvType tvType7 = TvType.Anime;
                                    int i69 = i55;
                                    if (i52 != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (i53 != 0) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (i54 != 0) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    obj15 = obj14;
                                    int i70 = i54;
                                    C00021 c00029 = c00024;
                                    int i71 = i53;
                                    CinemetaRes cinemetaRes7 = cinemetaRes4;
                                    String str83 = kitsuid;
                                    C00032 c00032 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str83, cinemetaRes7, str70, list34, data12, str68, str69, z5, z6, z7, null);
                                    String str84 = str67;
                                    String str85 = str68;
                                    c00029.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                                    c00029.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                                    c00029.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                    c00029.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                                    c00029.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                                    c00029.L$5 = SpillingKt.nullOutSpilledVariable(str85);
                                    c00029.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                                    c00029.L$7 = SpillingKt.nullOutSpilledVariable(str84);
                                    c00029.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                    c00029.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                                    c00029.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                                    c00029.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                                    c00029.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                                    c00029.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                                    c00029.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                                    c00029.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                                    c00029.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00029.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                                    c00029.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes7);
                                    c00029.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                                    c00029.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                                    c00029.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                                    c00029.L$22 = SpillingKt.nullOutSpilledVariable(string);
                                    c00029.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                                    c00029.L$24 = SpillingKt.nullOutSpilledVariable(str83);
                                    c00029.I$0 = i70 == true ? 1 : 0;
                                    c00029.I$1 = i50;
                                    c00029.I$2 = i52;
                                    c00029.I$3 = i71;
                                    c00029.I$4 = i69 == true ? 1 : 0;
                                    c00029.label = 6;
                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI2, str85, str65, tvType7, false, c00032, c00029, 8, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj15) {
                                        return obj15;
                                    }
                                    return objNewAnimeLoadResponse$default;
                                }
                                list29 = arrayListEmptyList;
                                if (cinemetaRes4 != null || (meta = cinemetaRes4.getMeta()) == null) {
                                    name2 = str7;
                                } else {
                                    name2 = meta.getName();
                                }
                                Requests app3 = MainActivityKt.getApp();
                                str60 = name2;
                                String str86 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                                c00022.L$0 = str57;
                                c00022.L$1 = data10;
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                                c00022.L$4 = mediaDetail5;
                                c00022.L$5 = str52;
                                c00022.L$6 = str58;
                                c00022.L$7 = str53;
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                c00022.L$9 = num8;
                                c00022.L$10 = list25;
                                c00022.L$11 = list24;
                                c00022.L$12 = list27;
                                c00022.L$13 = list26;
                                c00022.L$14 = str56;
                                str61 = str59;
                                c00022.L$15 = str61;
                                str62 = str52;
                                c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                                c00022.L$17 = str55;
                                c00022.L$18 = cinemetaRes4;
                                c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                                c00022.L$20 = list29;
                                list30 = list26;
                                c00022.L$21 = str60;
                                c00022.I$0 = i46 == true ? 1 : 0;
                                int i610 = i45;
                                c00022.I$1 = i610;
                                int i611 = i44;
                                c00022.I$2 = i611;
                                int i612 = i48;
                                c00022.I$3 = i612;
                                c00022.I$4 = i47 == true ? 1 : 0;
                                c00022.label = 5;
                                C00021 c000210 = c00022;
                                list31 = list27;
                                str63 = str56;
                                data11 = data10;
                                i49 = i47;
                                i50 = i610;
                                i51 = i46;
                                str64 = str55;
                                num9 = num8;
                                mediaDetail6 = mediaDetail5;
                                list32 = list25;
                                i52 = i611;
                                list33 = list24;
                                i53 = i612;
                                obj13 = Requests.get$default(app3, str86, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000210, 4094, (Object) null);
                                c00024 = c000210;
                                obj14 = obj10;
                                if (obj13 == obj14) {
                                    return obj14;
                                }
                                i54 = i51 == true ? 1 : 0;
                                str65 = str57;
                                str66 = str58;
                                str67 = str53;
                                str68 = str62;
                                list34 = list29;
                                str69 = str60;
                                list35 = list31;
                                data12 = data11;
                                str70 = str64;
                                str71 = str61;
                                str72 = str63;
                                list36 = list30;
                                i55 = i49 == true ? 1 : 0;
                                String string2 = ((NiceResponse) obj13).toString();
                                animeData = TorraStreamUtilsKt.parseAnimeData(string2);
                                if (animeData != null) {
                                    kitsuid = str7;
                                } else {
                                    kitsuid = str7;
                                }
                                MainAPI mainAPI3 = (MainAPI) this;
                                TvType tvType8 = TvType.Anime;
                                int i613 = i55;
                                if (i52 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (i53 != 0) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (i54 != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                obj15 = obj14;
                                int i72 = i54;
                                C00021 c000211 = c00024;
                                int i73 = i53;
                                CinemetaRes cinemetaRes8 = cinemetaRes4;
                                String str87 = kitsuid;
                                C00032 c00033 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str87, cinemetaRes8, str70, list34, data12, str68, str69, z5, z6, z7, null);
                                String str88 = str67;
                                String str89 = str68;
                                c000211.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                                c000211.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                                c000211.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                c000211.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                                c000211.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                                c000211.L$5 = SpillingKt.nullOutSpilledVariable(str89);
                                c000211.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                                c000211.L$7 = SpillingKt.nullOutSpilledVariable(str88);
                                c000211.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                c000211.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                                c000211.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                                c000211.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                                c000211.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                                c000211.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                                c000211.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                                c000211.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                                c000211.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                                c000211.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                                c000211.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes8);
                                c000211.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                                c000211.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                                c000211.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                                c000211.L$22 = SpillingKt.nullOutSpilledVariable(string2);
                                c000211.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                                c000211.L$24 = SpillingKt.nullOutSpilledVariable(str87);
                                c000211.I$0 = i72 == true ? 1 : 0;
                                c000211.I$1 = i50;
                                c000211.I$2 = i52;
                                c000211.I$3 = i73;
                                c000211.I$4 = i613 == true ? 1 : 0;
                                c000211.label = 6;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI3, str89, str65, tvType8, false, c00033, c000211, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj15) {
                                    return obj15;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            int i74 = i22;
                            tvType3 = tvType2;
                            i30 = i23;
                            int i75 = i18;
                            i31 = i19;
                            String str90 = str29;
                            int i76 = i20;
                            obj9 = obj5;
                            i32 = i76;
                            str41 = str90;
                            i33 = i75 == true ? 1 : 0;
                            i34 = i74;
                            data8 = data5;
                            i44 = i34;
                            obj10 = obj9;
                            i45 = i32;
                            i46 = i31;
                            list24 = list12;
                            str53 = str26;
                            num8 = num3;
                            str54 = str28;
                            str55 = str24;
                            str43 = str22;
                            str56 = str25;
                            listEmptyList = CollectionsKt.emptyList();
                            data10 = data8;
                            str57 = str27;
                            str52 = str41;
                            list25 = list10;
                            mediaDetail5 = mediaDetail3;
                            str51 = str21;
                            i47 = i33;
                            list26 = list11;
                            i48 = i30;
                            str58 = str23;
                            list27 = list9;
                            cinemetaRes3 = cinemetaRes;
                            list28 = listEmptyList;
                            if (i45 == 0) {
                                String str710 = str52;
                                String str711 = str55;
                                Integer num12 = num8;
                                String str712 = str43;
                                MediaDetail mediaDetail9 = mediaDetail5;
                                List list47 = list24;
                                List list48 = list25;
                                C00021 c000212 = c00022;
                                List list49 = list26;
                                List list410 = list27;
                                CinemetaRes cinemetaRes9 = cinemetaRes3;
                                int i614 = i47;
                                obj11 = obj10;
                                TvType tvType9 = TvType.TvSeries;
                                String str713 = str57;
                                String str810 = str58;
                                String str811 = str53;
                                C00043 c00044 = new C00043(str810, str811, str712, num12, mediaDetail9, list47, list48, this, list49, list410, list28, cinemetaRes9, str56, null);
                                c000212.L$0 = SpillingKt.nullOutSpilledVariable(str713);
                                c000212.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                                c000212.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                                c000212.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                                c000212.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail9);
                                c000212.L$5 = SpillingKt.nullOutSpilledVariable(str710);
                                c000212.L$6 = SpillingKt.nullOutSpilledVariable(str810);
                                c000212.L$7 = SpillingKt.nullOutSpilledVariable(str811);
                                c000212.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                                c000212.L$9 = SpillingKt.nullOutSpilledVariable(num12);
                                c000212.L$10 = SpillingKt.nullOutSpilledVariable(list48);
                                c000212.L$11 = SpillingKt.nullOutSpilledVariable(list47);
                                c000212.L$12 = SpillingKt.nullOutSpilledVariable(list410);
                                c000212.L$13 = SpillingKt.nullOutSpilledVariable(list49);
                                c000212.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                                c000212.L$15 = SpillingKt.nullOutSpilledVariable(str712);
                                c000212.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                                c000212.L$17 = SpillingKt.nullOutSpilledVariable(str711);
                                c000212.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes9);
                                c000212.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                                c000212.I$0 = i46 == true ? 1 : 0;
                                c000212.I$1 = i45;
                                c000212.I$2 = i44;
                                c000212.I$3 = i48;
                                c000212.I$4 = i614 == true ? 1 : 0;
                                c000212.label = 7;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str710, str713, tvType9, list28, c00044, c000212);
                                c00023 = c000212;
                                if (objNewTvSeriesLoadResponse == obj11) {
                                    return obj11;
                                }
                                obj12 = objNewTvSeriesLoadResponse;
                                return (LoadResponse) obj12;
                            }
                            if (cinemetaRes3 != null) {
                                str59 = str43;
                                cinemetaRes4 = cinemetaRes3;
                                arrayListEmptyList = CollectionsKt.emptyList();
                            } else {
                                str59 = str43;
                                cinemetaRes4 = cinemetaRes3;
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            alternative_titles = mediaDetail5.getAlternative_titles();
                            if (alternative_titles == null) {
                                list29 = arrayListEmptyList;
                                if (cinemetaRes4 != null) {
                                    name2 = str7;
                                } else {
                                    name2 = str7;
                                }
                            } else {
                                list29 = arrayListEmptyList;
                                if (cinemetaRes4 != null) {
                                    name2 = str7;
                                } else {
                                    name2 = str7;
                                }
                            }
                            Requests app4 = MainActivityKt.getApp();
                            str60 = name2;
                            String str812 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                            c00022.L$0 = str57;
                            c00022.L$1 = data10;
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                            c00022.L$4 = mediaDetail5;
                            c00022.L$5 = str52;
                            c00022.L$6 = str58;
                            c00022.L$7 = str53;
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                            c00022.L$9 = num8;
                            c00022.L$10 = list25;
                            c00022.L$11 = list24;
                            c00022.L$12 = list27;
                            c00022.L$13 = list26;
                            c00022.L$14 = str56;
                            str61 = str59;
                            c00022.L$15 = str61;
                            str62 = str52;
                            c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                            c00022.L$17 = str55;
                            c00022.L$18 = cinemetaRes4;
                            c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                            c00022.L$20 = list29;
                            list30 = list26;
                            c00022.L$21 = str60;
                            c00022.I$0 = i46 == true ? 1 : 0;
                            int i615 = i45;
                            c00022.I$1 = i615;
                            int i616 = i44;
                            c00022.I$2 = i616;
                            int i617 = i48;
                            c00022.I$3 = i617;
                            c00022.I$4 = i47 == true ? 1 : 0;
                            c00022.label = 5;
                            C00021 c000213 = c00022;
                            list31 = list27;
                            str63 = str56;
                            data11 = data10;
                            i49 = i47;
                            i50 = i615;
                            i51 = i46;
                            str64 = str55;
                            num9 = num8;
                            mediaDetail6 = mediaDetail5;
                            list32 = list25;
                            i52 = i616;
                            list33 = list24;
                            i53 = i617;
                            obj13 = Requests.get$default(app4, str812, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000213, 4094, (Object) null);
                            c00024 = c000213;
                            obj14 = obj10;
                            if (obj13 == obj14) {
                                return obj14;
                            }
                            i54 = i51 == true ? 1 : 0;
                            str65 = str57;
                            str66 = str58;
                            str67 = str53;
                            str68 = str62;
                            list34 = list29;
                            str69 = str60;
                            list35 = list31;
                            data12 = data11;
                            str70 = str64;
                            str71 = str61;
                            str72 = str63;
                            list36 = list30;
                            i55 = i49 == true ? 1 : 0;
                            String string3 = ((NiceResponse) obj13).toString();
                            animeData = TorraStreamUtilsKt.parseAnimeData(string3);
                            if (animeData != null) {
                                kitsuid = str7;
                            } else {
                                kitsuid = str7;
                            }
                            MainAPI mainAPI4 = (MainAPI) this;
                            TvType tvType10 = TvType.Anime;
                            int i618 = i55;
                            if (i52 != 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (i53 != 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (i54 != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            obj15 = obj14;
                            int i77 = i54;
                            C00021 c000214 = c00024;
                            int i78 = i53;
                            CinemetaRes cinemetaRes10 = cinemetaRes4;
                            String str813 = kitsuid;
                            C00032 c00034 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str813, cinemetaRes10, str70, list34, data12, str68, str69, z5, z6, z7, null);
                            String str814 = str67;
                            String str815 = str68;
                            c000214.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                            c000214.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                            c000214.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                            c000214.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                            c000214.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                            c000214.L$5 = SpillingKt.nullOutSpilledVariable(str815);
                            c000214.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                            c000214.L$7 = SpillingKt.nullOutSpilledVariable(str814);
                            c000214.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                            c000214.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                            c000214.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                            c000214.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                            c000214.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                            c000214.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                            c000214.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                            c000214.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                            c000214.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                            c000214.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                            c000214.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes10);
                            c000214.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                            c000214.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                            c000214.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                            c000214.L$22 = SpillingKt.nullOutSpilledVariable(string3);
                            c000214.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                            c000214.L$24 = SpillingKt.nullOutSpilledVariable(str813);
                            c000214.I$0 = i77 == true ? 1 : 0;
                            c000214.I$1 = i50;
                            c000214.I$2 = i52;
                            c000214.I$3 = i78;
                            c000214.I$4 = i618 == true ? 1 : 0;
                            c000214.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI4, str815, str65, tvType10, false, c00034, c000214, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj15) {
                                return obj15;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        str17 = str8;
                        i13 = i9;
                        if (z) {
                            str18 = "series";
                        } else {
                            str18 = "movie";
                        }
                        external_ids = mediaDetail2.getExternal_ids();
                        if (external_ids != null) {
                            imdb_id = external_ids.getImdb_id();
                        } else {
                            imdb_id = str7;
                        }
                        if (imdb_id == null) {
                            imdb_id = "";
                        }
                        i14 = i12;
                        c00025.L$0 = str10;
                        c00025.L$1 = data2;
                        c00025.L$2 = tvType;
                        c00025.L$3 = SpillingKt.nullOutSpilledVariable(str17);
                        c00025.L$4 = mediaDetail2;
                        c00025.L$5 = str13;
                        c00025.L$6 = str11;
                        c00025.L$7 = str12;
                        c00025.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                        c00025.L$9 = num;
                        list5 = list2;
                        c00025.L$10 = list5;
                        list6 = list4;
                        c00025.L$11 = list6;
                        list7 = list3;
                        c00025.L$12 = list7;
                        list8 = list;
                        c00025.L$13 = list8;
                        str19 = str9;
                        c00025.L$14 = str19;
                        c00025.L$15 = str16;
                        data3 = data2;
                        c00025.L$16 = SpillingKt.nullOutSpilledVariable(str18);
                        c00025.L$17 = imdb_id;
                        i15 = i10;
                        c00025.I$0 = i15 == true ? 1 : 0;
                        c00025.I$1 = i11;
                        c00025.I$2 = i8;
                        c00025.I$3 = i14;
                        c00025.I$4 = i13 == true ? 1 : 0;
                        c00025.label = 3;
                        i16 = i8;
                        i17 = i11;
                        str20 = str12;
                        z2 = true;
                        num2 = num;
                        obj5 = obj4;
                        i18 = i13 == true ? 1 : 0;
                        obj6 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str18 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                        c00022 = c00025;
                        if (obj6 == obj5) {
                            return obj5;
                        }
                        str21 = str17;
                        str22 = str16;
                        mediaDetail3 = mediaDetail2;
                        str23 = str11;
                        str24 = imdb_id;
                        obj7 = obj6;
                        data4 = data3;
                        list9 = list7;
                        list10 = list5;
                        str25 = str19;
                        str26 = str20;
                        num3 = num2;
                        list11 = list8;
                        list12 = list6;
                        str27 = str10;
                        tvType2 = tvType;
                        str28 = str18;
                        str29 = str13;
                        i19 = i15 == true ? 1 : 0;
                        i20 = i17;
                        i21 = i14;
                        i22 = i16;
                        NiceResponse niceResponse3 = (NiceResponse) obj7;
                        ResponseParser parser3 = niceResponse3.getParser();
                        Intrinsics.checkNotNull(parser3);
                        data5 = data4;
                        i23 = i21;
                        safe2 = parser3.parseSafe(niceResponse3.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                        cinemetaRes = (CinemetaRes) safe2;
                        if (tvType2 != TvType.TvSeries) {
                            int i619 = i22;
                            TvType tvType11 = tvType2;
                            num4 = num3;
                            int i620 = i23;
                            i24 = i18;
                            str30 = str24;
                            list13 = list11;
                            int i621 = i19;
                            String str714 = str29;
                            str31 = str25;
                            i25 = i20;
                            C00021 c000215 = c00022;
                            obj8 = obj5;
                            str32 = str22;
                            MainAPI mainAPI5 = (MainAPI) this;
                            TvType tvType12 = TvType.Movie;
                            AppUtils appUtils3 = AppUtils.INSTANCE;
                            String title3 = mediaDetail3.getTitle();
                            if (i25 != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            external_ids2 = mediaDetail3.getExternal_ids();
                            if (external_ids2 != null) {
                                imdb_id2 = external_ids2.getImdb_id();
                            } else {
                                imdb_id2 = str7;
                            }
                            String json2 = appUtils3.toJson(new LoadData(title3, num4, z3, imdb_id2, null, null, 48, null));
                            list14 = list10;
                            if (i24 == 0) {
                                z2 = false;
                            }
                            list15 = list12;
                            list16 = list9;
                            C00054 c00055 = new C00054(str23, z2, str26, str32, num4, mediaDetail3, list15, list14, list13, list16, cinemetaRes, str31, null);
                            c000215.L$0 = SpillingKt.nullOutSpilledVariable(str27);
                            c000215.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                            c000215.L$2 = SpillingKt.nullOutSpilledVariable(tvType11);
                            c000215.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                            c000215.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail3);
                            c000215.L$5 = SpillingKt.nullOutSpilledVariable(str714);
                            c000215.L$6 = SpillingKt.nullOutSpilledVariable(str23);
                            c000215.L$7 = SpillingKt.nullOutSpilledVariable(str26);
                            c000215.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                            c000215.L$9 = SpillingKt.nullOutSpilledVariable(num4);
                            c000215.L$10 = SpillingKt.nullOutSpilledVariable(list14);
                            c000215.L$11 = SpillingKt.nullOutSpilledVariable(list15);
                            c000215.L$12 = SpillingKt.nullOutSpilledVariable(list16);
                            c000215.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                            c000215.L$14 = SpillingKt.nullOutSpilledVariable(str31);
                            c000215.L$15 = SpillingKt.nullOutSpilledVariable(str32);
                            c000215.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                            c000215.L$17 = SpillingKt.nullOutSpilledVariable(str30);
                            c000215.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                            c000215.I$0 = i621 == true ? 1 : 0;
                            c000215.I$1 = i25;
                            c000215.I$2 = i619;
                            c000215.I$3 = i620;
                            c000215.I$4 = i24 == true ? 1 : 0;
                            c000215.label = 8;
                            i26 = i619;
                            data6 = data5;
                            str33 = str27;
                            i27 = i620;
                            str34 = str714;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI5, str34, str33, tvType12, json2, c00055, c000215);
                            if (objNewMovieLoadResponse == obj8) {
                                return obj8;
                            }
                            i28 = i25;
                            mediaDetail4 = mediaDetail3;
                            list17 = list15;
                            list18 = list14;
                            list19 = list13;
                            cinemetaRes2 = cinemetaRes;
                            str35 = str31;
                            str36 = str14;
                            str37 = str30;
                            num5 = num4;
                            i29 = i24 == true ? 1 : 0;
                            data7 = data6;
                            str38 = str23;
                            str39 = str32;
                            list20 = list16;
                            str40 = str28;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        seasons = mediaDetail3.getSeasons();
                        if (seasons != null) {
                            ArrayList<Seasons> arrayList25 = seasons;
                            i35 = i19;
                            if (i20 != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            Object obj18 = obj5;
                            i36 = i22;
                            i37 = i20;
                            tvType3 = tvType2;
                            num6 = num3;
                            MediaDetail mediaDetail10 = mediaDetail3;
                            i38 = i18;
                            Data data16 = data5;
                            i39 = i23;
                            TorraStream$load$episodes$1 torraStream$load$episodes$2 = new TorraStream$load$episodes$1(data16, this, mediaDetail10, num6, z4, null);
                            c00022.L$0 = str27;
                            c00022.L$1 = data16;
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                            c00022.L$4 = mediaDetail10;
                            c00022.L$5 = str29;
                            c00022.L$6 = str23;
                            c00022.L$7 = str26;
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                            c00022.L$9 = num6;
                            c00022.L$10 = list10;
                            c00022.L$11 = list12;
                            c00022.L$12 = list9;
                            list21 = list11;
                            c00022.L$13 = list21;
                            str42 = str25;
                            c00022.L$14 = str42;
                            str43 = str22;
                            c00022.L$15 = str43;
                            c00022.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                            str44 = str24;
                            c00022.L$17 = str44;
                            c00022.L$18 = cinemetaRes;
                            c00022.I$0 = i35 == true ? 1 : 0;
                            str45 = str29;
                            c00022.I$1 = i37;
                            c00022.I$2 = i36;
                            c00022.I$3 = i39;
                            c00022.I$4 = i38 == true ? 1 : 0;
                            c00022.label = 4;
                            objAmap = ParCollectionsKt.amap(arrayList25, torraStream$load$episodes$2, c00022);
                            obj9 = obj18;
                            if (objAmap == obj9) {
                                return obj9;
                            }
                            str46 = str42;
                            i32 = i37;
                            i40 = i35 == true ? 1 : 0;
                            data9 = data5;
                            i41 = i38 == true ? 1 : 0;
                            list22 = list10;
                            str47 = str23;
                            list23 = list21;
                            str48 = str14;
                            str49 = str28;
                            str50 = str44;
                            num7 = num6;
                            i42 = i39;
                            str51 = str21;
                            i43 = i36;
                            objNewMovieLoadResponse = objAmap;
                            str52 = str45;
                            list37 = (List) objNewMovieLoadResponse;
                            if (list37 != null) {
                            }
                            int i622 = i42;
                            i34 = i43;
                            i30 = i622;
                            str25 = str46;
                            i31 = i40;
                            str24 = str50;
                            i33 = i41;
                            list11 = list23;
                            list10 = list22;
                            num3 = num7;
                            str14 = str48;
                            str21 = str51;
                            data8 = data9;
                            str41 = str52;
                            str28 = str49;
                            str23 = str47;
                            str22 = str43;
                        } else {
                            int i79 = i22;
                            tvType3 = tvType2;
                            i30 = i23;
                            int i710 = i18;
                            i31 = i19;
                            String str91 = str29;
                            int i711 = i20;
                            obj9 = obj5;
                            i32 = i711;
                            str41 = str91;
                            i33 = i710 == true ? 1 : 0;
                            i34 = i79;
                            data8 = data5;
                        }
                        i44 = i34;
                        obj10 = obj9;
                        i45 = i32;
                        i46 = i31;
                        list24 = list12;
                        str53 = str26;
                        num8 = num3;
                        str54 = str28;
                        str55 = str24;
                        str43 = str22;
                        str56 = str25;
                        listEmptyList = CollectionsKt.emptyList();
                        data10 = data8;
                        str57 = str27;
                        str52 = str41;
                        list25 = list10;
                        mediaDetail5 = mediaDetail3;
                        str51 = str21;
                        i47 = i33;
                        list26 = list11;
                        i48 = i30;
                        str58 = str23;
                        list27 = list9;
                        cinemetaRes3 = cinemetaRes;
                        list28 = listEmptyList;
                        if (i45 == 0) {
                            String str715 = str52;
                            String str716 = str55;
                            Integer num13 = num8;
                            String str717 = str43;
                            MediaDetail mediaDetail11 = mediaDetail5;
                            List list411 = list24;
                            List list412 = list25;
                            C00021 c000216 = c00022;
                            List list413 = list26;
                            List list414 = list27;
                            CinemetaRes cinemetaRes11 = cinemetaRes3;
                            int i6110 = i47;
                            obj11 = obj10;
                            TvType tvType13 = TvType.TvSeries;
                            String str718 = str57;
                            String str816 = str58;
                            String str817 = str53;
                            C00043 c00045 = new C00043(str816, str817, str717, num13, mediaDetail11, list411, list412, this, list413, list414, list28, cinemetaRes11, str56, null);
                            c000216.L$0 = SpillingKt.nullOutSpilledVariable(str718);
                            c000216.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                            c000216.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                            c000216.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                            c000216.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail11);
                            c000216.L$5 = SpillingKt.nullOutSpilledVariable(str715);
                            c000216.L$6 = SpillingKt.nullOutSpilledVariable(str816);
                            c000216.L$7 = SpillingKt.nullOutSpilledVariable(str817);
                            c000216.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                            c000216.L$9 = SpillingKt.nullOutSpilledVariable(num13);
                            c000216.L$10 = SpillingKt.nullOutSpilledVariable(list412);
                            c000216.L$11 = SpillingKt.nullOutSpilledVariable(list411);
                            c000216.L$12 = SpillingKt.nullOutSpilledVariable(list414);
                            c000216.L$13 = SpillingKt.nullOutSpilledVariable(list413);
                            c000216.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                            c000216.L$15 = SpillingKt.nullOutSpilledVariable(str717);
                            c000216.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                            c000216.L$17 = SpillingKt.nullOutSpilledVariable(str716);
                            c000216.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes11);
                            c000216.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                            c000216.I$0 = i46 == true ? 1 : 0;
                            c000216.I$1 = i45;
                            c000216.I$2 = i44;
                            c000216.I$3 = i48;
                            c000216.I$4 = i6110 == true ? 1 : 0;
                            c000216.label = 7;
                            objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str715, str718, tvType13, list28, c00045, c000216);
                            c00023 = c000216;
                            if (objNewTvSeriesLoadResponse == obj11) {
                                return obj11;
                            }
                            obj12 = objNewTvSeriesLoadResponse;
                            return (LoadResponse) obj12;
                        }
                        if (cinemetaRes3 != null) {
                            str59 = str43;
                            cinemetaRes4 = cinemetaRes3;
                            arrayListEmptyList = CollectionsKt.emptyList();
                        } else {
                            str59 = str43;
                            cinemetaRes4 = cinemetaRes3;
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        alternative_titles = mediaDetail5.getAlternative_titles();
                        if (alternative_titles == null) {
                            list29 = arrayListEmptyList;
                            if (cinemetaRes4 != null) {
                                name2 = str7;
                            } else {
                                name2 = str7;
                            }
                        } else {
                            list29 = arrayListEmptyList;
                            if (cinemetaRes4 != null) {
                                name2 = str7;
                            } else {
                                name2 = str7;
                            }
                        }
                        Requests app5 = MainActivityKt.getApp();
                        str60 = name2;
                        String str818 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                        c00022.L$0 = str57;
                        c00022.L$1 = data10;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                        c00022.L$4 = mediaDetail5;
                        c00022.L$5 = str52;
                        c00022.L$6 = str58;
                        c00022.L$7 = str53;
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                        c00022.L$9 = num8;
                        c00022.L$10 = list25;
                        c00022.L$11 = list24;
                        c00022.L$12 = list27;
                        c00022.L$13 = list26;
                        c00022.L$14 = str56;
                        str61 = str59;
                        c00022.L$15 = str61;
                        str62 = str52;
                        c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$17 = str55;
                        c00022.L$18 = cinemetaRes4;
                        c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                        c00022.L$20 = list29;
                        list30 = list26;
                        c00022.L$21 = str60;
                        c00022.I$0 = i46 == true ? 1 : 0;
                        int i6111 = i45;
                        c00022.I$1 = i6111;
                        int i6112 = i44;
                        c00022.I$2 = i6112;
                        int i6113 = i48;
                        c00022.I$3 = i6113;
                        c00022.I$4 = i47 == true ? 1 : 0;
                        c00022.label = 5;
                        C00021 c000217 = c00022;
                        list31 = list27;
                        str63 = str56;
                        data11 = data10;
                        i49 = i47;
                        i50 = i6111;
                        i51 = i46;
                        str64 = str55;
                        num9 = num8;
                        mediaDetail6 = mediaDetail5;
                        list32 = list25;
                        i52 = i6112;
                        list33 = list24;
                        i53 = i6113;
                        obj13 = Requests.get$default(app5, str818, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000217, 4094, (Object) null);
                        c00024 = c000217;
                        obj14 = obj10;
                        if (obj13 == obj14) {
                            return obj14;
                        }
                        i54 = i51 == true ? 1 : 0;
                        str65 = str57;
                        str66 = str58;
                        str67 = str53;
                        str68 = str62;
                        list34 = list29;
                        str69 = str60;
                        list35 = list31;
                        data12 = data11;
                        str70 = str64;
                        str71 = str61;
                        str72 = str63;
                        list36 = list30;
                        i55 = i49 == true ? 1 : 0;
                        String string4 = ((NiceResponse) obj13).toString();
                        animeData = TorraStreamUtilsKt.parseAnimeData(string4);
                        if (animeData != null) {
                            kitsuid = str7;
                        } else {
                            kitsuid = str7;
                        }
                        MainAPI mainAPI6 = (MainAPI) this;
                        TvType tvType14 = TvType.Anime;
                        int i6114 = i55;
                        if (i52 != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (i53 != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (i54 != 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        obj15 = obj14;
                        int i712 = i54;
                        C00021 c000218 = c00024;
                        int i713 = i53;
                        CinemetaRes cinemetaRes12 = cinemetaRes4;
                        String str819 = kitsuid;
                        C00032 c00035 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str819, cinemetaRes12, str70, list34, data12, str68, str69, z5, z6, z7, null);
                        String str8110 = str67;
                        String str8111 = str68;
                        c000218.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                        c000218.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                        c000218.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c000218.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                        c000218.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                        c000218.L$5 = SpillingKt.nullOutSpilledVariable(str8111);
                        c000218.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                        c000218.L$7 = SpillingKt.nullOutSpilledVariable(str8110);
                        c000218.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                        c000218.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                        c000218.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                        c000218.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                        c000218.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                        c000218.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                        c000218.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                        c000218.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                        c000218.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                        c000218.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                        c000218.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes12);
                        c000218.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                        c000218.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                        c000218.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                        c000218.L$22 = SpillingKt.nullOutSpilledVariable(string4);
                        c000218.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                        c000218.L$24 = SpillingKt.nullOutSpilledVariable(str819);
                        c000218.I$0 = i712 == true ? 1 : 0;
                        c000218.I$1 = i50;
                        c000218.I$2 = i52;
                        c000218.I$3 = i713;
                        c000218.I$4 = i6114 == true ? 1 : 0;
                        c000218.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI6, str8111, str65, tvType14, false, c00035, c000218, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj15) {
                            return obj15;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    str5 = str2;
                    i = 1;
                    if (i == 0) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                    }
                    i3 = i2;
                    production_countries = mediaDetail.getProduction_countries();
                    if (production_countries != null) {
                        arrayList4 = production_countries;
                        i4 = i3;
                        if (arrayList4 instanceof Collection) {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    arrayList5 = arrayList4;
                                    it2 = it;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i5 = 1;
                                    } else {
                                        arrayList4 = arrayList5;
                                        it = it2;
                                    }
                                } else {
                                    i5 = 0;
                                }
                            }
                        } else {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    arrayList5 = arrayList4;
                                    it2 = it;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i5 = 1;
                                    } else {
                                        arrayList4 = arrayList5;
                                        it = it2;
                                    }
                                } else {
                                    i5 = 0;
                                }
                            }
                        }
                    } else {
                        i4 = i3;
                        i5 = 0;
                    }
                    i6 = i5;
                    keywords = mediaDetail.getKeywords();
                    if (keywords != null) {
                        i7 = i6;
                        collectionEmptyList = null;
                    } else {
                        i7 = i6;
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
                    List list310 = (List) collection;
                    credits = mediaDetail.getCredits();
                    if (credits != null) {
                    }
                    return null;
                }
                str5 = str2;
                i = 0;
                if (i == 0) {
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                i3 = i2;
                production_countries = mediaDetail.getProduction_countries();
                if (production_countries != null) {
                    arrayList4 = production_countries;
                    i4 = i3;
                    if (arrayList4 instanceof Collection) {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                arrayList5 = arrayList4;
                                it2 = it;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i5 = 1;
                                } else {
                                    arrayList4 = arrayList5;
                                    it = it2;
                                }
                            } else {
                                i5 = 0;
                            }
                        }
                    } else {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                arrayList5 = arrayList4;
                                it2 = it;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i5 = 1;
                                } else {
                                    arrayList4 = arrayList5;
                                    it = it2;
                                }
                            } else {
                                i5 = 0;
                            }
                        }
                    }
                } else {
                    i4 = i3;
                    i5 = 0;
                }
                i6 = i5;
                keywords = mediaDetail.getKeywords();
                if (keywords != null) {
                    i7 = i6;
                    collectionEmptyList = null;
                } else {
                    i7 = i6;
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
                List list311 = (List) collection;
                credits = mediaDetail.getCredits();
                if (credits != null) {
                }
                return null;
            case 1:
                String str92 = (String) c00025.L$3;
                type = (TvType) c00025.L$2;
                Data data17 = (Data) c00025.L$1;
                str3 = (String) c00025.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                str2 = str92;
                obj2 = objNewMovieLoadResponse;
                data = data17;
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
                String str719 = title;
                String oriImageUrl3 = getOriImageUrl(mediaDetail.getPosterPath());
                String oriImageUrl4 = getOriImageUrl(mediaDetail.getBackdropPath());
                releaseDate = mediaDetail.getReleaseDate();
                if (releaseDate == null) {
                    releaseDate = mediaDetail.getFirstAirDate();
                }
                str4 = releaseDate;
                if (str4 != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
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
                        objNewMovieLoadResponse = objNewMovieLoadResponse;
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
                        str5 = str2;
                        if (Intrinsics.areEqual(mediaDetail.getOriginal_language(), "ja")) {
                        }
                        if (i == 0) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                        i3 = i2;
                        production_countries = mediaDetail.getProduction_countries();
                        if (production_countries != null) {
                            arrayList4 = production_countries;
                            i4 = i3;
                            if (arrayList4 instanceof Collection) {
                                it = arrayList4.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        arrayList5 = arrayList4;
                                        it2 = it;
                                        if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                            i5 = 1;
                                        } else {
                                            arrayList4 = arrayList5;
                                            it = it2;
                                        }
                                    } else {
                                        i5 = 0;
                                    }
                                }
                            } else {
                                it = arrayList4.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        arrayList5 = arrayList4;
                                        it2 = it;
                                        if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                            i5 = 1;
                                        } else {
                                            arrayList4 = arrayList5;
                                            it = it2;
                                        }
                                    } else {
                                        i5 = 0;
                                    }
                                }
                            }
                        } else {
                            i4 = i3;
                            i5 = 0;
                        }
                        i6 = i5;
                        keywords = mediaDetail.getKeywords();
                        if (keywords != null) {
                            i7 = i6;
                            collectionEmptyList = null;
                        } else {
                            i7 = i6;
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
                        List list312 = (List) collection;
                        credits = mediaDetail.getCredits();
                        if (credits != null) {
                            break;
                        }
                        return null;
                    }
                    str5 = str2;
                    i = 1;
                    if (i == 0) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                    }
                    i3 = i2;
                    production_countries = mediaDetail.getProduction_countries();
                    if (production_countries != null) {
                        arrayList4 = production_countries;
                        i4 = i3;
                        if (arrayList4 instanceof Collection) {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    arrayList5 = arrayList4;
                                    it2 = it;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i5 = 1;
                                    } else {
                                        arrayList4 = arrayList5;
                                        it = it2;
                                    }
                                } else {
                                    i5 = 0;
                                }
                            }
                        } else {
                            it = arrayList4.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    arrayList5 = arrayList4;
                                    it2 = it;
                                    if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                        i5 = 1;
                                    } else {
                                        arrayList4 = arrayList5;
                                        it = it2;
                                    }
                                } else {
                                    i5 = 0;
                                }
                            }
                        }
                    } else {
                        i4 = i3;
                        i5 = 0;
                    }
                    i6 = i5;
                    keywords = mediaDetail.getKeywords();
                    if (keywords != null) {
                        i7 = i6;
                        collectionEmptyList = null;
                    } else {
                        i7 = i6;
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
                    List list313 = (List) collection;
                    credits = mediaDetail.getCredits();
                    if (credits != null) {
                        break;
                    }
                    return null;
                }
                str5 = str2;
                i = 0;
                if (i == 0) {
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                i3 = i2;
                production_countries = mediaDetail.getProduction_countries();
                if (production_countries != null) {
                    arrayList4 = production_countries;
                    i4 = i3;
                    if (arrayList4 instanceof Collection) {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                arrayList5 = arrayList4;
                                it2 = it;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i5 = 1;
                                } else {
                                    arrayList4 = arrayList5;
                                    it = it2;
                                }
                            } else {
                                i5 = 0;
                            }
                        }
                    } else {
                        it = arrayList4.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                arrayList5 = arrayList4;
                                it2 = it;
                                if (Intrinsics.areEqual(((ProductionCountries) it.next()).getName(), "India")) {
                                    i5 = 1;
                                } else {
                                    arrayList4 = arrayList5;
                                    it = it2;
                                }
                            } else {
                                i5 = 0;
                            }
                        }
                    }
                } else {
                    i4 = i3;
                    i5 = 0;
                }
                i6 = i5;
                keywords = mediaDetail.getKeywords();
                if (keywords != null) {
                    i7 = i6;
                    collectionEmptyList = null;
                } else {
                    i7 = i6;
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
                List list314 = (List) collection;
                credits = mediaDetail.getCredits();
                if (credits != null) {
                    break;
                }
                return null;
            case 2:
                int i80 = c00025.I$4;
                int i81 = c00025.I$3;
                int i82 = c00025.I$2;
                int i83 = c00025.I$1;
                int i84 = c00025.I$0;
                String str93 = (String) c00025.L$14;
                List list50 = (List) c00025.L$13;
                List list51 = (List) c00025.L$12;
                List list52 = (List) c00025.L$11;
                List list53 = (List) c00025.L$10;
                Integer num14 = (Integer) c00025.L$9;
                String str94 = (String) c00025.L$8;
                String str95 = (String) c00025.L$7;
                String str96 = (String) c00025.L$6;
                String str97 = (String) c00025.L$5;
                MediaDetail mediaDetail12 = (MediaDetail) c00025.L$4;
                String str98 = (String) c00025.L$3;
                TvType tvType15 = (TvType) c00025.L$2;
                Data data18 = (Data) c00025.L$1;
                String str99 = (String) c00025.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                obj3 = objNewMovieLoadResponse;
                i10 = i84;
                str9 = str93;
                list = list50;
                list3 = list51;
                list4 = list52;
                list2 = list53;
                num = num14;
                i9 = i80;
                str14 = str94;
                str12 = str95;
                str11 = str96;
                mediaDetail2 = mediaDetail12;
                str7 = null;
                obj4 = coroutine_suspended;
                i12 = i81;
                i8 = i82;
                i11 = i83;
                str13 = str97;
                str8 = str98;
                tvType = tvType15;
                str10 = str99;
                data2 = data18;
                str16 = (String) obj3;
                type2 = data2.getType();
                if (type2 != null) {
                    str17 = str8;
                    i13 = i9;
                    if (StringsKt.contains(type2, "tv", true)) {
                    }
                    if (z) {
                        str18 = "series";
                    } else {
                        str18 = "movie";
                    }
                    external_ids = mediaDetail2.getExternal_ids();
                    if (external_ids != null) {
                        imdb_id = external_ids.getImdb_id();
                    } else {
                        imdb_id = str7;
                    }
                    if (imdb_id == null) {
                        imdb_id = "";
                    }
                    i14 = i12;
                    c00025.L$0 = str10;
                    c00025.L$1 = data2;
                    c00025.L$2 = tvType;
                    c00025.L$3 = SpillingKt.nullOutSpilledVariable(str17);
                    c00025.L$4 = mediaDetail2;
                    c00025.L$5 = str13;
                    c00025.L$6 = str11;
                    c00025.L$7 = str12;
                    c00025.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c00025.L$9 = num;
                    list5 = list2;
                    c00025.L$10 = list5;
                    list6 = list4;
                    c00025.L$11 = list6;
                    list7 = list3;
                    c00025.L$12 = list7;
                    list8 = list;
                    c00025.L$13 = list8;
                    str19 = str9;
                    c00025.L$14 = str19;
                    c00025.L$15 = str16;
                    data3 = data2;
                    c00025.L$16 = SpillingKt.nullOutSpilledVariable(str18);
                    c00025.L$17 = imdb_id;
                    i15 = i10;
                    c00025.I$0 = i15 == true ? 1 : 0;
                    c00025.I$1 = i11;
                    c00025.I$2 = i8;
                    c00025.I$3 = i14;
                    c00025.I$4 = i13 == true ? 1 : 0;
                    c00025.label = 3;
                    i16 = i8;
                    i17 = i11;
                    str20 = str12;
                    z2 = true;
                    num2 = num;
                    obj5 = obj4;
                    i18 = i13 == true ? 1 : 0;
                    obj6 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str18 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                    c00022 = c00025;
                    if (obj6 == obj5) {
                        return obj5;
                    }
                    str21 = str17;
                    str22 = str16;
                    mediaDetail3 = mediaDetail2;
                    str23 = str11;
                    str24 = imdb_id;
                    obj7 = obj6;
                    data4 = data3;
                    list9 = list7;
                    list10 = list5;
                    str25 = str19;
                    str26 = str20;
                    num3 = num2;
                    list11 = list8;
                    list12 = list6;
                    str27 = str10;
                    tvType2 = tvType;
                    str28 = str18;
                    str29 = str13;
                    i19 = i15 == true ? 1 : 0;
                    i20 = i17;
                    i21 = i14;
                    i22 = i16;
                    NiceResponse niceResponse5 = (NiceResponse) obj7;
                    ResponseParser parser5 = niceResponse5.getParser();
                    Intrinsics.checkNotNull(parser5);
                    data5 = data4;
                    i23 = i21;
                    safe2 = parser5.parseSafe(niceResponse5.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                    cinemetaRes = (CinemetaRes) safe2;
                    if (tvType2 != TvType.TvSeries) {
                        int i6115 = i22;
                        TvType tvType16 = tvType2;
                        num4 = num3;
                        int i623 = i23;
                        i24 = i18;
                        str30 = str24;
                        list13 = list11;
                        int i624 = i19;
                        String str7110 = str29;
                        str31 = str25;
                        i25 = i20;
                        C00021 c000219 = c00022;
                        obj8 = obj5;
                        str32 = str22;
                        MainAPI mainAPI7 = (MainAPI) this;
                        TvType tvType17 = TvType.Movie;
                        AppUtils appUtils4 = AppUtils.INSTANCE;
                        String title4 = mediaDetail3.getTitle();
                        if (i25 != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        external_ids2 = mediaDetail3.getExternal_ids();
                        if (external_ids2 != null) {
                            imdb_id2 = external_ids2.getImdb_id();
                        } else {
                            imdb_id2 = str7;
                        }
                        String json3 = appUtils4.toJson(new LoadData(title4, num4, z3, imdb_id2, null, null, 48, null));
                        list14 = list10;
                        if (i24 == 0) {
                            z2 = false;
                        }
                        list15 = list12;
                        list16 = list9;
                        C00054 c00056 = new C00054(str23, z2, str26, str32, num4, mediaDetail3, list15, list14, list13, list16, cinemetaRes, str31, null);
                        c000219.L$0 = SpillingKt.nullOutSpilledVariable(str27);
                        c000219.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                        c000219.L$2 = SpillingKt.nullOutSpilledVariable(tvType16);
                        c000219.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                        c000219.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail3);
                        c000219.L$5 = SpillingKt.nullOutSpilledVariable(str7110);
                        c000219.L$6 = SpillingKt.nullOutSpilledVariable(str23);
                        c000219.L$7 = SpillingKt.nullOutSpilledVariable(str26);
                        c000219.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                        c000219.L$9 = SpillingKt.nullOutSpilledVariable(num4);
                        c000219.L$10 = SpillingKt.nullOutSpilledVariable(list14);
                        c000219.L$11 = SpillingKt.nullOutSpilledVariable(list15);
                        c000219.L$12 = SpillingKt.nullOutSpilledVariable(list16);
                        c000219.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                        c000219.L$14 = SpillingKt.nullOutSpilledVariable(str31);
                        c000219.L$15 = SpillingKt.nullOutSpilledVariable(str32);
                        c000219.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                        c000219.L$17 = SpillingKt.nullOutSpilledVariable(str30);
                        c000219.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                        c000219.I$0 = i624 == true ? 1 : 0;
                        c000219.I$1 = i25;
                        c000219.I$2 = i6115;
                        c000219.I$3 = i623;
                        c000219.I$4 = i24 == true ? 1 : 0;
                        c000219.label = 8;
                        i26 = i6115;
                        data6 = data5;
                        str33 = str27;
                        i27 = i623;
                        str34 = str7110;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI7, str34, str33, tvType17, json3, c00056, c000219);
                        if (objNewMovieLoadResponse == obj8) {
                            return obj8;
                        }
                        i28 = i25;
                        mediaDetail4 = mediaDetail3;
                        list17 = list15;
                        list18 = list14;
                        list19 = list13;
                        cinemetaRes2 = cinemetaRes;
                        str35 = str31;
                        str36 = str14;
                        str37 = str30;
                        num5 = num4;
                        i29 = i24 == true ? 1 : 0;
                        data7 = data6;
                        str38 = str23;
                        str39 = str32;
                        list20 = list16;
                        str40 = str28;
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    seasons = mediaDetail3.getSeasons();
                    if (seasons != null) {
                        ArrayList<Seasons> arrayList26 = seasons;
                        i35 = i19;
                        if (i20 != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        Object obj19 = obj5;
                        i36 = i22;
                        i37 = i20;
                        tvType3 = tvType2;
                        num6 = num3;
                        MediaDetail mediaDetail13 = mediaDetail3;
                        i38 = i18;
                        Data data19 = data5;
                        i39 = i23;
                        TorraStream$load$episodes$1 torraStream$load$episodes$3 = new TorraStream$load$episodes$1(data19, this, mediaDetail13, num6, z4, null);
                        c00022.L$0 = str27;
                        c00022.L$1 = data19;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                        c00022.L$4 = mediaDetail13;
                        c00022.L$5 = str29;
                        c00022.L$6 = str23;
                        c00022.L$7 = str26;
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                        c00022.L$9 = num6;
                        c00022.L$10 = list10;
                        c00022.L$11 = list12;
                        c00022.L$12 = list9;
                        list21 = list11;
                        c00022.L$13 = list21;
                        str42 = str25;
                        c00022.L$14 = str42;
                        str43 = str22;
                        c00022.L$15 = str43;
                        c00022.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                        str44 = str24;
                        c00022.L$17 = str44;
                        c00022.L$18 = cinemetaRes;
                        c00022.I$0 = i35 == true ? 1 : 0;
                        str45 = str29;
                        c00022.I$1 = i37;
                        c00022.I$2 = i36;
                        c00022.I$3 = i39;
                        c00022.I$4 = i38 == true ? 1 : 0;
                        c00022.label = 4;
                        objAmap = ParCollectionsKt.amap(arrayList26, torraStream$load$episodes$3, c00022);
                        obj9 = obj19;
                        if (objAmap == obj9) {
                            return obj9;
                        }
                        str46 = str42;
                        i32 = i37;
                        i40 = i35 == true ? 1 : 0;
                        data9 = data5;
                        i41 = i38 == true ? 1 : 0;
                        list22 = list10;
                        str47 = str23;
                        list23 = list21;
                        str48 = str14;
                        str49 = str28;
                        str50 = str44;
                        num7 = num6;
                        i42 = i39;
                        str51 = str21;
                        i43 = i36;
                        objNewMovieLoadResponse = objAmap;
                        str52 = str45;
                        list37 = (List) objNewMovieLoadResponse;
                        if (list37 != null) {
                        }
                        int i625 = i42;
                        i34 = i43;
                        i30 = i625;
                        str25 = str46;
                        i31 = i40;
                        str24 = str50;
                        i33 = i41;
                        list11 = list23;
                        list10 = list22;
                        num3 = num7;
                        str14 = str48;
                        str21 = str51;
                        data8 = data9;
                        str41 = str52;
                        str28 = str49;
                        str23 = str47;
                        str22 = str43;
                        break;
                    } else {
                        int i714 = i22;
                        tvType3 = tvType2;
                        i30 = i23;
                        int i715 = i18;
                        i31 = i19;
                        String str910 = str29;
                        int i716 = i20;
                        obj9 = obj5;
                        i32 = i716;
                        str41 = str910;
                        i33 = i715 == true ? 1 : 0;
                        i34 = i714;
                        data8 = data5;
                    }
                    i44 = i34;
                    obj10 = obj9;
                    i45 = i32;
                    i46 = i31;
                    list24 = list12;
                    str53 = str26;
                    num8 = num3;
                    str54 = str28;
                    str55 = str24;
                    str43 = str22;
                    str56 = str25;
                    listEmptyList = CollectionsKt.emptyList();
                    data10 = data8;
                    str57 = str27;
                    str52 = str41;
                    list25 = list10;
                    mediaDetail5 = mediaDetail3;
                    str51 = str21;
                    i47 = i33;
                    list26 = list11;
                    i48 = i30;
                    str58 = str23;
                    list27 = list9;
                    cinemetaRes3 = cinemetaRes;
                    list28 = listEmptyList;
                    if (i45 == 0) {
                        String str7111 = str52;
                        String str7112 = str55;
                        Integer num15 = num8;
                        String str7113 = str43;
                        MediaDetail mediaDetail14 = mediaDetail5;
                        List list415 = list24;
                        List list416 = list25;
                        C00021 c0002110 = c00022;
                        List list417 = list26;
                        List list418 = list27;
                        CinemetaRes cinemetaRes13 = cinemetaRes3;
                        int i6116 = i47;
                        obj11 = obj10;
                        TvType tvType18 = TvType.TvSeries;
                        String str7114 = str57;
                        String str8112 = str58;
                        String str8113 = str53;
                        C00043 c00046 = new C00043(str8112, str8113, str7113, num15, mediaDetail14, list415, list416, this, list417, list418, list28, cinemetaRes13, str56, null);
                        c0002110.L$0 = SpillingKt.nullOutSpilledVariable(str7114);
                        c0002110.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                        c0002110.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c0002110.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                        c0002110.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail14);
                        c0002110.L$5 = SpillingKt.nullOutSpilledVariable(str7111);
                        c0002110.L$6 = SpillingKt.nullOutSpilledVariable(str8112);
                        c0002110.L$7 = SpillingKt.nullOutSpilledVariable(str8113);
                        c0002110.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                        c0002110.L$9 = SpillingKt.nullOutSpilledVariable(num15);
                        c0002110.L$10 = SpillingKt.nullOutSpilledVariable(list416);
                        c0002110.L$11 = SpillingKt.nullOutSpilledVariable(list415);
                        c0002110.L$12 = SpillingKt.nullOutSpilledVariable(list418);
                        c0002110.L$13 = SpillingKt.nullOutSpilledVariable(list417);
                        c0002110.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                        c0002110.L$15 = SpillingKt.nullOutSpilledVariable(str7113);
                        c0002110.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                        c0002110.L$17 = SpillingKt.nullOutSpilledVariable(str7112);
                        c0002110.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes13);
                        c0002110.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                        c0002110.I$0 = i46 == true ? 1 : 0;
                        c0002110.I$1 = i45;
                        c0002110.I$2 = i44;
                        c0002110.I$3 = i48;
                        c0002110.I$4 = i6116 == true ? 1 : 0;
                        c0002110.label = 7;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str7111, str7114, tvType18, list28, c00046, c0002110);
                        c00023 = c0002110;
                        if (objNewTvSeriesLoadResponse == obj11) {
                            return obj11;
                        }
                        obj12 = objNewTvSeriesLoadResponse;
                        return (LoadResponse) obj12;
                    }
                    if (cinemetaRes3 != null) {
                        str59 = str43;
                        cinemetaRes4 = cinemetaRes3;
                        arrayListEmptyList = CollectionsKt.emptyList();
                    } else {
                        str59 = str43;
                        cinemetaRes4 = cinemetaRes3;
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    alternative_titles = mediaDetail5.getAlternative_titles();
                    if (alternative_titles == null) {
                        list29 = arrayListEmptyList;
                        if (cinemetaRes4 != null) {
                            name2 = str7;
                        } else {
                            name2 = str7;
                        }
                    } else {
                        list29 = arrayListEmptyList;
                        if (cinemetaRes4 != null) {
                            name2 = str7;
                        } else {
                            name2 = str7;
                        }
                    }
                    Requests app6 = MainActivityKt.getApp();
                    str60 = name2;
                    String str8114 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                    c00022.L$0 = str57;
                    c00022.L$1 = data10;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                    c00022.L$4 = mediaDetail5;
                    c00022.L$5 = str52;
                    c00022.L$6 = str58;
                    c00022.L$7 = str53;
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c00022.L$9 = num8;
                    c00022.L$10 = list25;
                    c00022.L$11 = list24;
                    c00022.L$12 = list27;
                    c00022.L$13 = list26;
                    c00022.L$14 = str56;
                    str61 = str59;
                    c00022.L$15 = str61;
                    str62 = str52;
                    c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$17 = str55;
                    c00022.L$18 = cinemetaRes4;
                    c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                    c00022.L$20 = list29;
                    list30 = list26;
                    c00022.L$21 = str60;
                    c00022.I$0 = i46 == true ? 1 : 0;
                    int i6117 = i45;
                    c00022.I$1 = i6117;
                    int i6118 = i44;
                    c00022.I$2 = i6118;
                    int i6119 = i48;
                    c00022.I$3 = i6119;
                    c00022.I$4 = i47 == true ? 1 : 0;
                    c00022.label = 5;
                    C00021 c0002111 = c00022;
                    list31 = list27;
                    str63 = str56;
                    data11 = data10;
                    i49 = i47;
                    i50 = i6117;
                    i51 = i46;
                    str64 = str55;
                    num9 = num8;
                    mediaDetail6 = mediaDetail5;
                    list32 = list25;
                    i52 = i6118;
                    list33 = list24;
                    i53 = i6119;
                    obj13 = Requests.get$default(app6, str8114, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002111, 4094, (Object) null);
                    c00024 = c0002111;
                    obj14 = obj10;
                    if (obj13 == obj14) {
                        return obj14;
                    }
                    i54 = i51 == true ? 1 : 0;
                    str65 = str57;
                    str66 = str58;
                    str67 = str53;
                    str68 = str62;
                    list34 = list29;
                    str69 = str60;
                    list35 = list31;
                    data12 = data11;
                    str70 = str64;
                    str71 = str61;
                    str72 = str63;
                    list36 = list30;
                    i55 = i49 == true ? 1 : 0;
                    String string5 = ((NiceResponse) obj13).toString();
                    animeData = TorraStreamUtilsKt.parseAnimeData(string5);
                    if (animeData != null) {
                        kitsuid = str7;
                    } else {
                        kitsuid = str7;
                    }
                    MainAPI mainAPI8 = (MainAPI) this;
                    TvType tvType19 = TvType.Anime;
                    int i61110 = i55;
                    if (i52 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i53 != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (i54 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    obj15 = obj14;
                    int i717 = i54;
                    C00021 c0002112 = c00024;
                    int i718 = i53;
                    CinemetaRes cinemetaRes14 = cinemetaRes4;
                    String str8115 = kitsuid;
                    C00032 c00036 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str8115, cinemetaRes14, str70, list34, data12, str68, str69, z5, z6, z7, null);
                    String str8116 = str67;
                    String str8117 = str68;
                    c0002112.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                    c0002112.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                    c0002112.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c0002112.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                    c0002112.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                    c0002112.L$5 = SpillingKt.nullOutSpilledVariable(str8117);
                    c0002112.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                    c0002112.L$7 = SpillingKt.nullOutSpilledVariable(str8116);
                    c0002112.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c0002112.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                    c0002112.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                    c0002112.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                    c0002112.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                    c0002112.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                    c0002112.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                    c0002112.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                    c0002112.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                    c0002112.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                    c0002112.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes14);
                    c0002112.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                    c0002112.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                    c0002112.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                    c0002112.L$22 = SpillingKt.nullOutSpilledVariable(string5);
                    c0002112.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                    c0002112.L$24 = SpillingKt.nullOutSpilledVariable(str8115);
                    c0002112.I$0 = i717 == true ? 1 : 0;
                    c0002112.I$1 = i50;
                    c0002112.I$2 = i52;
                    c0002112.I$3 = i718;
                    c0002112.I$4 = i61110 == true ? 1 : 0;
                    c0002112.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI8, str8117, str65, tvType19, false, c00036, c0002112, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj15) {
                        return obj15;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                str17 = str8;
                i13 = i9;
                if (z) {
                    str18 = "series";
                } else {
                    str18 = "movie";
                }
                external_ids = mediaDetail2.getExternal_ids();
                if (external_ids != null) {
                    imdb_id = external_ids.getImdb_id();
                } else {
                    imdb_id = str7;
                }
                if (imdb_id == null) {
                    imdb_id = "";
                }
                i14 = i12;
                c00025.L$0 = str10;
                c00025.L$1 = data2;
                c00025.L$2 = tvType;
                c00025.L$3 = SpillingKt.nullOutSpilledVariable(str17);
                c00025.L$4 = mediaDetail2;
                c00025.L$5 = str13;
                c00025.L$6 = str11;
                c00025.L$7 = str12;
                c00025.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00025.L$9 = num;
                list5 = list2;
                c00025.L$10 = list5;
                list6 = list4;
                c00025.L$11 = list6;
                list7 = list3;
                c00025.L$12 = list7;
                list8 = list;
                c00025.L$13 = list8;
                str19 = str9;
                c00025.L$14 = str19;
                c00025.L$15 = str16;
                data3 = data2;
                c00025.L$16 = SpillingKt.nullOutSpilledVariable(str18);
                c00025.L$17 = imdb_id;
                i15 = i10;
                c00025.I$0 = i15 == true ? 1 : 0;
                c00025.I$1 = i11;
                c00025.I$2 = i8;
                c00025.I$3 = i14;
                c00025.I$4 = i13 == true ? 1 : 0;
                c00025.label = 3;
                i16 = i8;
                i17 = i11;
                str20 = str12;
                z2 = true;
                num2 = num;
                obj5 = obj4;
                i18 = i13 == true ? 1 : 0;
                obj6 = Requests.get$default(MainActivityKt.getApp(), "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + str18 + '/' + imdb_id + ".json", (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                c00022 = c00025;
                if (obj6 == obj5) {
                    return obj5;
                }
                str21 = str17;
                str22 = str16;
                mediaDetail3 = mediaDetail2;
                str23 = str11;
                str24 = imdb_id;
                obj7 = obj6;
                data4 = data3;
                list9 = list7;
                list10 = list5;
                str25 = str19;
                str26 = str20;
                num3 = num2;
                list11 = list8;
                list12 = list6;
                str27 = str10;
                tvType2 = tvType;
                str28 = str18;
                str29 = str13;
                i19 = i15 == true ? 1 : 0;
                i20 = i17;
                i21 = i14;
                i22 = i16;
                NiceResponse niceResponse6 = (NiceResponse) obj7;
                ResponseParser parser6 = niceResponse6.getParser();
                Intrinsics.checkNotNull(parser6);
                data5 = data4;
                i23 = i21;
                safe2 = parser6.parseSafe(niceResponse6.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                cinemetaRes = (CinemetaRes) safe2;
                if (tvType2 != TvType.TvSeries) {
                    int i61111 = i22;
                    TvType tvType110 = tvType2;
                    num4 = num3;
                    int i626 = i23;
                    i24 = i18;
                    str30 = str24;
                    list13 = list11;
                    int i627 = i19;
                    String str7115 = str29;
                    str31 = str25;
                    i25 = i20;
                    C00021 c0002113 = c00022;
                    obj8 = obj5;
                    str32 = str22;
                    MainAPI mainAPI9 = (MainAPI) this;
                    TvType tvType111 = TvType.Movie;
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    String title5 = mediaDetail3.getTitle();
                    if (i25 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    external_ids2 = mediaDetail3.getExternal_ids();
                    if (external_ids2 != null) {
                        imdb_id2 = external_ids2.getImdb_id();
                    } else {
                        imdb_id2 = str7;
                    }
                    String json4 = appUtils5.toJson(new LoadData(title5, num4, z3, imdb_id2, null, null, 48, null));
                    list14 = list10;
                    if (i24 == 0) {
                        z2 = false;
                    }
                    list15 = list12;
                    list16 = list9;
                    C00054 c00057 = new C00054(str23, z2, str26, str32, num4, mediaDetail3, list15, list14, list13, list16, cinemetaRes, str31, null);
                    c0002113.L$0 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002113.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c0002113.L$2 = SpillingKt.nullOutSpilledVariable(tvType110);
                    c0002113.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                    c0002113.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail3);
                    c0002113.L$5 = SpillingKt.nullOutSpilledVariable(str7115);
                    c0002113.L$6 = SpillingKt.nullOutSpilledVariable(str23);
                    c0002113.L$7 = SpillingKt.nullOutSpilledVariable(str26);
                    c0002113.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c0002113.L$9 = SpillingKt.nullOutSpilledVariable(num4);
                    c0002113.L$10 = SpillingKt.nullOutSpilledVariable(list14);
                    c0002113.L$11 = SpillingKt.nullOutSpilledVariable(list15);
                    c0002113.L$12 = SpillingKt.nullOutSpilledVariable(list16);
                    c0002113.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                    c0002113.L$14 = SpillingKt.nullOutSpilledVariable(str31);
                    c0002113.L$15 = SpillingKt.nullOutSpilledVariable(str32);
                    c0002113.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                    c0002113.L$17 = SpillingKt.nullOutSpilledVariable(str30);
                    c0002113.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                    c0002113.I$0 = i627 == true ? 1 : 0;
                    c0002113.I$1 = i25;
                    c0002113.I$2 = i61111;
                    c0002113.I$3 = i626;
                    c0002113.I$4 = i24 == true ? 1 : 0;
                    c0002113.label = 8;
                    i26 = i61111;
                    data6 = data5;
                    str33 = str27;
                    i27 = i626;
                    str34 = str7115;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI9, str34, str33, tvType111, json4, c00057, c0002113);
                    if (objNewMovieLoadResponse == obj8) {
                        return obj8;
                    }
                    i28 = i25;
                    mediaDetail4 = mediaDetail3;
                    list17 = list15;
                    list18 = list14;
                    list19 = list13;
                    cinemetaRes2 = cinemetaRes;
                    str35 = str31;
                    str36 = str14;
                    str37 = str30;
                    num5 = num4;
                    i29 = i24 == true ? 1 : 0;
                    data7 = data6;
                    str38 = str23;
                    str39 = str32;
                    list20 = list16;
                    str40 = str28;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                seasons = mediaDetail3.getSeasons();
                if (seasons != null) {
                    ArrayList<Seasons> arrayList27 = seasons;
                    i35 = i19;
                    if (i20 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Object obj110 = obj5;
                    i36 = i22;
                    i37 = i20;
                    tvType3 = tvType2;
                    num6 = num3;
                    MediaDetail mediaDetail15 = mediaDetail3;
                    i38 = i18;
                    Data data110 = data5;
                    i39 = i23;
                    TorraStream$load$episodes$1 torraStream$load$episodes$4 = new TorraStream$load$episodes$1(data110, this, mediaDetail15, num6, z4, null);
                    c00022.L$0 = str27;
                    c00022.L$1 = data110;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$4 = mediaDetail15;
                    c00022.L$5 = str29;
                    c00022.L$6 = str23;
                    c00022.L$7 = str26;
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c00022.L$9 = num6;
                    c00022.L$10 = list10;
                    c00022.L$11 = list12;
                    c00022.L$12 = list9;
                    list21 = list11;
                    c00022.L$13 = list21;
                    str42 = str25;
                    c00022.L$14 = str42;
                    str43 = str22;
                    c00022.L$15 = str43;
                    c00022.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                    str44 = str24;
                    c00022.L$17 = str44;
                    c00022.L$18 = cinemetaRes;
                    c00022.I$0 = i35 == true ? 1 : 0;
                    str45 = str29;
                    c00022.I$1 = i37;
                    c00022.I$2 = i36;
                    c00022.I$3 = i39;
                    c00022.I$4 = i38 == true ? 1 : 0;
                    c00022.label = 4;
                    objAmap = ParCollectionsKt.amap(arrayList27, torraStream$load$episodes$4, c00022);
                    obj9 = obj110;
                    if (objAmap == obj9) {
                        return obj9;
                    }
                    str46 = str42;
                    i32 = i37;
                    i40 = i35 == true ? 1 : 0;
                    data9 = data5;
                    i41 = i38 == true ? 1 : 0;
                    list22 = list10;
                    str47 = str23;
                    list23 = list21;
                    str48 = str14;
                    str49 = str28;
                    str50 = str44;
                    num7 = num6;
                    i42 = i39;
                    str51 = str21;
                    i43 = i36;
                    objNewMovieLoadResponse = objAmap;
                    str52 = str45;
                    list37 = (List) objNewMovieLoadResponse;
                    if (list37 != null) {
                    }
                    int i628 = i42;
                    i34 = i43;
                    i30 = i628;
                    str25 = str46;
                    i31 = i40;
                    str24 = str50;
                    i33 = i41;
                    list11 = list23;
                    list10 = list22;
                    num3 = num7;
                    str14 = str48;
                    str21 = str51;
                    data8 = data9;
                    str41 = str52;
                    str28 = str49;
                    str23 = str47;
                    str22 = str43;
                    break;
                } else {
                    int i719 = i22;
                    tvType3 = tvType2;
                    i30 = i23;
                    int i7110 = i18;
                    i31 = i19;
                    String str911 = str29;
                    int i7111 = i20;
                    obj9 = obj5;
                    i32 = i7111;
                    str41 = str911;
                    i33 = i7110 == true ? 1 : 0;
                    i34 = i719;
                    data8 = data5;
                }
                i44 = i34;
                obj10 = obj9;
                i45 = i32;
                i46 = i31;
                list24 = list12;
                str53 = str26;
                num8 = num3;
                str54 = str28;
                str55 = str24;
                str43 = str22;
                str56 = str25;
                listEmptyList = CollectionsKt.emptyList();
                data10 = data8;
                str57 = str27;
                str52 = str41;
                list25 = list10;
                mediaDetail5 = mediaDetail3;
                str51 = str21;
                i47 = i33;
                list26 = list11;
                i48 = i30;
                str58 = str23;
                list27 = list9;
                cinemetaRes3 = cinemetaRes;
                list28 = listEmptyList;
                if (i45 == 0) {
                    String str7116 = str52;
                    String str7117 = str55;
                    Integer num16 = num8;
                    String str7118 = str43;
                    MediaDetail mediaDetail16 = mediaDetail5;
                    List list419 = list24;
                    List list4110 = list25;
                    C00021 c0002114 = c00022;
                    List list4111 = list26;
                    List list4112 = list27;
                    CinemetaRes cinemetaRes15 = cinemetaRes3;
                    int i61112 = i47;
                    obj11 = obj10;
                    TvType tvType112 = TvType.TvSeries;
                    String str7119 = str57;
                    String str8118 = str58;
                    String str8119 = str53;
                    C00043 c00047 = new C00043(str8118, str8119, str7118, num16, mediaDetail16, list419, list4110, this, list4111, list4112, list28, cinemetaRes15, str56, null);
                    c0002114.L$0 = SpillingKt.nullOutSpilledVariable(str7119);
                    c0002114.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                    c0002114.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c0002114.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                    c0002114.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail16);
                    c0002114.L$5 = SpillingKt.nullOutSpilledVariable(str7116);
                    c0002114.L$6 = SpillingKt.nullOutSpilledVariable(str8118);
                    c0002114.L$7 = SpillingKt.nullOutSpilledVariable(str8119);
                    c0002114.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c0002114.L$9 = SpillingKt.nullOutSpilledVariable(num16);
                    c0002114.L$10 = SpillingKt.nullOutSpilledVariable(list4110);
                    c0002114.L$11 = SpillingKt.nullOutSpilledVariable(list419);
                    c0002114.L$12 = SpillingKt.nullOutSpilledVariable(list4112);
                    c0002114.L$13 = SpillingKt.nullOutSpilledVariable(list4111);
                    c0002114.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                    c0002114.L$15 = SpillingKt.nullOutSpilledVariable(str7118);
                    c0002114.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                    c0002114.L$17 = SpillingKt.nullOutSpilledVariable(str7117);
                    c0002114.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes15);
                    c0002114.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                    c0002114.I$0 = i46 == true ? 1 : 0;
                    c0002114.I$1 = i45;
                    c0002114.I$2 = i44;
                    c0002114.I$3 = i48;
                    c0002114.I$4 = i61112 == true ? 1 : 0;
                    c0002114.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str7116, str7119, tvType112, list28, c00047, c0002114);
                    c00023 = c0002114;
                    if (objNewTvSeriesLoadResponse == obj11) {
                        return obj11;
                    }
                    obj12 = objNewTvSeriesLoadResponse;
                    return (LoadResponse) obj12;
                }
                if (cinemetaRes3 != null) {
                    str59 = str43;
                    cinemetaRes4 = cinemetaRes3;
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    str59 = str43;
                    cinemetaRes4 = cinemetaRes3;
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                alternative_titles = mediaDetail5.getAlternative_titles();
                if (alternative_titles == null) {
                    list29 = arrayListEmptyList;
                    if (cinemetaRes4 != null) {
                        name2 = str7;
                    } else {
                        name2 = str7;
                    }
                } else {
                    list29 = arrayListEmptyList;
                    if (cinemetaRes4 != null) {
                        name2 = str7;
                    } else {
                        name2 = str7;
                    }
                }
                Requests app7 = MainActivityKt.getApp();
                str60 = name2;
                String str81110 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                c00022.L$0 = str57;
                c00022.L$1 = data10;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c00022.L$4 = mediaDetail5;
                c00022.L$5 = str52;
                c00022.L$6 = str58;
                c00022.L$7 = str53;
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00022.L$9 = num8;
                c00022.L$10 = list25;
                c00022.L$11 = list24;
                c00022.L$12 = list27;
                c00022.L$13 = list26;
                c00022.L$14 = str56;
                str61 = str59;
                c00022.L$15 = str61;
                str62 = str52;
                c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$17 = str55;
                c00022.L$18 = cinemetaRes4;
                c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c00022.L$20 = list29;
                list30 = list26;
                c00022.L$21 = str60;
                c00022.I$0 = i46 == true ? 1 : 0;
                int i61113 = i45;
                c00022.I$1 = i61113;
                int i61114 = i44;
                c00022.I$2 = i61114;
                int i61115 = i48;
                c00022.I$3 = i61115;
                c00022.I$4 = i47 == true ? 1 : 0;
                c00022.label = 5;
                C00021 c0002115 = c00022;
                list31 = list27;
                str63 = str56;
                data11 = data10;
                i49 = i47;
                i50 = i61113;
                i51 = i46;
                str64 = str55;
                num9 = num8;
                mediaDetail6 = mediaDetail5;
                list32 = list25;
                i52 = i61114;
                list33 = list24;
                i53 = i61115;
                obj13 = Requests.get$default(app7, str81110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002115, 4094, (Object) null);
                c00024 = c0002115;
                obj14 = obj10;
                if (obj13 == obj14) {
                    return obj14;
                }
                i54 = i51 == true ? 1 : 0;
                str65 = str57;
                str66 = str58;
                str67 = str53;
                str68 = str62;
                list34 = list29;
                str69 = str60;
                list35 = list31;
                data12 = data11;
                str70 = str64;
                str71 = str61;
                str72 = str63;
                list36 = list30;
                i55 = i49 == true ? 1 : 0;
                String string6 = ((NiceResponse) obj13).toString();
                animeData = TorraStreamUtilsKt.parseAnimeData(string6);
                if (animeData != null) {
                    kitsuid = str7;
                } else {
                    kitsuid = str7;
                }
                MainAPI mainAPI10 = (MainAPI) this;
                TvType tvType113 = TvType.Anime;
                int i61116 = i55;
                if (i52 != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i53 != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (i54 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                obj15 = obj14;
                int i7112 = i54;
                C00021 c0002116 = c00024;
                int i7113 = i53;
                CinemetaRes cinemetaRes16 = cinemetaRes4;
                String str81111 = kitsuid;
                C00032 c00037 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str81111, cinemetaRes16, str70, list34, data12, str68, str69, z5, z6, z7, null);
                String str81112 = str67;
                String str81113 = str68;
                c0002116.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                c0002116.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                c0002116.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c0002116.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c0002116.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                c0002116.L$5 = SpillingKt.nullOutSpilledVariable(str81113);
                c0002116.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                c0002116.L$7 = SpillingKt.nullOutSpilledVariable(str81112);
                c0002116.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c0002116.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c0002116.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                c0002116.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                c0002116.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                c0002116.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                c0002116.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                c0002116.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                c0002116.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c0002116.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                c0002116.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes16);
                c0002116.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c0002116.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                c0002116.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                c0002116.L$22 = SpillingKt.nullOutSpilledVariable(string6);
                c0002116.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c0002116.L$24 = SpillingKt.nullOutSpilledVariable(str81111);
                c0002116.I$0 = i7112 == true ? 1 : 0;
                c0002116.I$1 = i50;
                c0002116.I$2 = i52;
                c0002116.I$3 = i7113;
                c0002116.I$4 = i61116 == true ? 1 : 0;
                c0002116.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI10, str81113, str65, tvType113, false, c00037, c0002116, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj15) {
                    return obj15;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                int i85 = c00025.I$4;
                int i86 = c00025.I$3;
                int i87 = c00025.I$2;
                int i88 = c00025.I$1;
                int i89 = c00025.I$0;
                String str100 = (String) c00025.L$17;
                String str101 = (String) c00025.L$16;
                String str102 = (String) c00025.L$15;
                String str103 = (String) c00025.L$14;
                List list54 = (List) c00025.L$13;
                list9 = (List) c00025.L$12;
                List list55 = (List) c00025.L$11;
                List list56 = (List) c00025.L$10;
                Integer num17 = (Integer) c00025.L$9;
                String str104 = (String) c00025.L$8;
                String str105 = (String) c00025.L$7;
                String str106 = (String) c00025.L$6;
                String str107 = (String) c00025.L$5;
                MediaDetail mediaDetail17 = (MediaDetail) c00025.L$4;
                str21 = (String) c00025.L$3;
                TvType tvType20 = (TvType) c00025.L$2;
                Data data20 = (Data) c00025.L$1;
                String str108 = (String) c00025.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                str27 = str108;
                obj7 = objNewMovieLoadResponse;
                str24 = str100;
                str22 = str102;
                str25 = str103;
                list11 = list54;
                i18 = i85;
                list12 = list55;
                num3 = num17;
                str14 = str104;
                str26 = str105;
                str23 = str106;
                mediaDetail3 = mediaDetail17;
                tvType2 = tvType20;
                str7 = null;
                z2 = true;
                c00022 = c00025;
                str28 = str101;
                list10 = list56;
                data4 = data20;
                obj5 = coroutine_suspended;
                i21 = i86;
                i22 = i87;
                i20 = i88;
                i19 = i89;
                str29 = str107;
                NiceResponse niceResponse7 = (NiceResponse) obj7;
                ResponseParser parser7 = niceResponse7.getParser();
                Intrinsics.checkNotNull(parser7);
                data5 = data4;
                i23 = i21;
                safe2 = parser7.parseSafe(niceResponse7.getText(), Reflection.getOrCreateKotlinClass(CinemetaRes.class));
                cinemetaRes = (CinemetaRes) safe2;
                if (tvType2 != TvType.TvSeries) {
                    int i61117 = i22;
                    TvType tvType114 = tvType2;
                    num4 = num3;
                    int i629 = i23;
                    i24 = i18;
                    str30 = str24;
                    list13 = list11;
                    int i6210 = i19;
                    String str71110 = str29;
                    str31 = str25;
                    i25 = i20;
                    C00021 c0002117 = c00022;
                    obj8 = obj5;
                    str32 = str22;
                    MainAPI mainAPI11 = (MainAPI) this;
                    TvType tvType115 = TvType.Movie;
                    AppUtils appUtils6 = AppUtils.INSTANCE;
                    String title6 = mediaDetail3.getTitle();
                    if (i25 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    external_ids2 = mediaDetail3.getExternal_ids();
                    if (external_ids2 != null) {
                        imdb_id2 = external_ids2.getImdb_id();
                    } else {
                        imdb_id2 = str7;
                    }
                    String json5 = appUtils6.toJson(new LoadData(title6, num4, z3, imdb_id2, null, null, 48, null));
                    list14 = list10;
                    if (i24 == 0) {
                        z2 = false;
                    }
                    list15 = list12;
                    list16 = list9;
                    C00054 c00058 = new C00054(str23, z2, str26, str32, num4, mediaDetail3, list15, list14, list13, list16, cinemetaRes, str31, null);
                    c0002117.L$0 = SpillingKt.nullOutSpilledVariable(str27);
                    c0002117.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c0002117.L$2 = SpillingKt.nullOutSpilledVariable(tvType114);
                    c0002117.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                    c0002117.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail3);
                    c0002117.L$5 = SpillingKt.nullOutSpilledVariable(str71110);
                    c0002117.L$6 = SpillingKt.nullOutSpilledVariable(str23);
                    c0002117.L$7 = SpillingKt.nullOutSpilledVariable(str26);
                    c0002117.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c0002117.L$9 = SpillingKt.nullOutSpilledVariable(num4);
                    c0002117.L$10 = SpillingKt.nullOutSpilledVariable(list14);
                    c0002117.L$11 = SpillingKt.nullOutSpilledVariable(list15);
                    c0002117.L$12 = SpillingKt.nullOutSpilledVariable(list16);
                    c0002117.L$13 = SpillingKt.nullOutSpilledVariable(list13);
                    c0002117.L$14 = SpillingKt.nullOutSpilledVariable(str31);
                    c0002117.L$15 = SpillingKt.nullOutSpilledVariable(str32);
                    c0002117.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                    c0002117.L$17 = SpillingKt.nullOutSpilledVariable(str30);
                    c0002117.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes);
                    c0002117.I$0 = i6210 == true ? 1 : 0;
                    c0002117.I$1 = i25;
                    c0002117.I$2 = i61117;
                    c0002117.I$3 = i629;
                    c0002117.I$4 = i24 == true ? 1 : 0;
                    c0002117.label = 8;
                    i26 = i61117;
                    data6 = data5;
                    str33 = str27;
                    i27 = i629;
                    str34 = str71110;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(mainAPI11, str34, str33, tvType115, json5, c00058, c0002117);
                    if (objNewMovieLoadResponse == obj8) {
                        return obj8;
                    }
                    i28 = i25;
                    mediaDetail4 = mediaDetail3;
                    list17 = list15;
                    list18 = list14;
                    list19 = list13;
                    cinemetaRes2 = cinemetaRes;
                    str35 = str31;
                    str36 = str14;
                    str37 = str30;
                    num5 = num4;
                    i29 = i24 == true ? 1 : 0;
                    data7 = data6;
                    str38 = str23;
                    str39 = str32;
                    list20 = list16;
                    str40 = str28;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                seasons = mediaDetail3.getSeasons();
                if (seasons != null) {
                    ArrayList<Seasons> arrayList28 = seasons;
                    i35 = i19;
                    if (i20 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Object obj111 = obj5;
                    i36 = i22;
                    i37 = i20;
                    tvType3 = tvType2;
                    num6 = num3;
                    MediaDetail mediaDetail18 = mediaDetail3;
                    i38 = i18;
                    Data data111 = data5;
                    i39 = i23;
                    TorraStream$load$episodes$1 torraStream$load$episodes$5 = new TorraStream$load$episodes$1(data111, this, mediaDetail18, num6, z4, null);
                    c00022.L$0 = str27;
                    c00022.L$1 = data111;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$4 = mediaDetail18;
                    c00022.L$5 = str29;
                    c00022.L$6 = str23;
                    c00022.L$7 = str26;
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c00022.L$9 = num6;
                    c00022.L$10 = list10;
                    c00022.L$11 = list12;
                    c00022.L$12 = list9;
                    list21 = list11;
                    c00022.L$13 = list21;
                    str42 = str25;
                    c00022.L$14 = str42;
                    str43 = str22;
                    c00022.L$15 = str43;
                    c00022.L$16 = SpillingKt.nullOutSpilledVariable(str28);
                    str44 = str24;
                    c00022.L$17 = str44;
                    c00022.L$18 = cinemetaRes;
                    c00022.I$0 = i35 == true ? 1 : 0;
                    str45 = str29;
                    c00022.I$1 = i37;
                    c00022.I$2 = i36;
                    c00022.I$3 = i39;
                    c00022.I$4 = i38 == true ? 1 : 0;
                    c00022.label = 4;
                    objAmap = ParCollectionsKt.amap(arrayList28, torraStream$load$episodes$5, c00022);
                    obj9 = obj111;
                    if (objAmap == obj9) {
                        return obj9;
                    }
                    str46 = str42;
                    i32 = i37;
                    i40 = i35 == true ? 1 : 0;
                    data9 = data5;
                    i41 = i38 == true ? 1 : 0;
                    list22 = list10;
                    str47 = str23;
                    list23 = list21;
                    str48 = str14;
                    str49 = str28;
                    str50 = str44;
                    num7 = num6;
                    i42 = i39;
                    str51 = str21;
                    i43 = i36;
                    objNewMovieLoadResponse = objAmap;
                    str52 = str45;
                    list37 = (List) objNewMovieLoadResponse;
                    if (list37 != null) {
                    }
                    int i6211 = i42;
                    i34 = i43;
                    i30 = i6211;
                    str25 = str46;
                    i31 = i40;
                    str24 = str50;
                    i33 = i41;
                    list11 = list23;
                    list10 = list22;
                    num3 = num7;
                    str14 = str48;
                    str21 = str51;
                    data8 = data9;
                    str41 = str52;
                    str28 = str49;
                    str23 = str47;
                    str22 = str43;
                    break;
                } else {
                    int i7114 = i22;
                    tvType3 = tvType2;
                    i30 = i23;
                    int i7115 = i18;
                    i31 = i19;
                    String str912 = str29;
                    int i7116 = i20;
                    obj9 = obj5;
                    i32 = i7116;
                    str41 = str912;
                    i33 = i7115 == true ? 1 : 0;
                    i34 = i7114;
                    data8 = data5;
                }
                i44 = i34;
                obj10 = obj9;
                i45 = i32;
                i46 = i31;
                list24 = list12;
                str53 = str26;
                num8 = num3;
                str54 = str28;
                str55 = str24;
                str43 = str22;
                str56 = str25;
                listEmptyList = CollectionsKt.emptyList();
                data10 = data8;
                str57 = str27;
                str52 = str41;
                list25 = list10;
                mediaDetail5 = mediaDetail3;
                str51 = str21;
                i47 = i33;
                list26 = list11;
                i48 = i30;
                str58 = str23;
                list27 = list9;
                cinemetaRes3 = cinemetaRes;
                list28 = listEmptyList;
                if (i45 == 0) {
                    String str71111 = str52;
                    String str71112 = str55;
                    Integer num18 = num8;
                    String str71113 = str43;
                    MediaDetail mediaDetail19 = mediaDetail5;
                    List list4113 = list24;
                    List list4114 = list25;
                    C00021 c0002118 = c00022;
                    List list4115 = list26;
                    List list4116 = list27;
                    CinemetaRes cinemetaRes17 = cinemetaRes3;
                    int i61118 = i47;
                    obj11 = obj10;
                    TvType tvType116 = TvType.TvSeries;
                    String str71114 = str57;
                    String str81114 = str58;
                    String str81115 = str53;
                    C00043 c00048 = new C00043(str81114, str81115, str71113, num18, mediaDetail19, list4113, list4114, this, list4115, list4116, list28, cinemetaRes17, str56, null);
                    c0002118.L$0 = SpillingKt.nullOutSpilledVariable(str71114);
                    c0002118.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                    c0002118.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c0002118.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                    c0002118.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail19);
                    c0002118.L$5 = SpillingKt.nullOutSpilledVariable(str71111);
                    c0002118.L$6 = SpillingKt.nullOutSpilledVariable(str81114);
                    c0002118.L$7 = SpillingKt.nullOutSpilledVariable(str81115);
                    c0002118.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c0002118.L$9 = SpillingKt.nullOutSpilledVariable(num18);
                    c0002118.L$10 = SpillingKt.nullOutSpilledVariable(list4114);
                    c0002118.L$11 = SpillingKt.nullOutSpilledVariable(list4113);
                    c0002118.L$12 = SpillingKt.nullOutSpilledVariable(list4116);
                    c0002118.L$13 = SpillingKt.nullOutSpilledVariable(list4115);
                    c0002118.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                    c0002118.L$15 = SpillingKt.nullOutSpilledVariable(str71113);
                    c0002118.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                    c0002118.L$17 = SpillingKt.nullOutSpilledVariable(str71112);
                    c0002118.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes17);
                    c0002118.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                    c0002118.I$0 = i46 == true ? 1 : 0;
                    c0002118.I$1 = i45;
                    c0002118.I$2 = i44;
                    c0002118.I$3 = i48;
                    c0002118.I$4 = i61118 == true ? 1 : 0;
                    c0002118.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str71111, str71114, tvType116, list28, c00048, c0002118);
                    c00023 = c0002118;
                    if (objNewTvSeriesLoadResponse == obj11) {
                        return obj11;
                    }
                    obj12 = objNewTvSeriesLoadResponse;
                    return (LoadResponse) obj12;
                }
                if (cinemetaRes3 != null) {
                    str59 = str43;
                    cinemetaRes4 = cinemetaRes3;
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    str59 = str43;
                    cinemetaRes4 = cinemetaRes3;
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                alternative_titles = mediaDetail5.getAlternative_titles();
                if (alternative_titles == null) {
                    list29 = arrayListEmptyList;
                    if (cinemetaRes4 != null) {
                        name2 = str7;
                    } else {
                        name2 = str7;
                    }
                } else {
                    list29 = arrayListEmptyList;
                    if (cinemetaRes4 != null) {
                        name2 = str7;
                    } else {
                        name2 = str7;
                    }
                }
                Requests app8 = MainActivityKt.getApp();
                str60 = name2;
                String str81116 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                c00022.L$0 = str57;
                c00022.L$1 = data10;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c00022.L$4 = mediaDetail5;
                c00022.L$5 = str52;
                c00022.L$6 = str58;
                c00022.L$7 = str53;
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00022.L$9 = num8;
                c00022.L$10 = list25;
                c00022.L$11 = list24;
                c00022.L$12 = list27;
                c00022.L$13 = list26;
                c00022.L$14 = str56;
                str61 = str59;
                c00022.L$15 = str61;
                str62 = str52;
                c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$17 = str55;
                c00022.L$18 = cinemetaRes4;
                c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c00022.L$20 = list29;
                list30 = list26;
                c00022.L$21 = str60;
                c00022.I$0 = i46 == true ? 1 : 0;
                int i61119 = i45;
                c00022.I$1 = i61119;
                int i611110 = i44;
                c00022.I$2 = i611110;
                int i611111 = i48;
                c00022.I$3 = i611111;
                c00022.I$4 = i47 == true ? 1 : 0;
                c00022.label = 5;
                C00021 c0002119 = c00022;
                list31 = list27;
                str63 = str56;
                data11 = data10;
                i49 = i47;
                i50 = i61119;
                i51 = i46;
                str64 = str55;
                num9 = num8;
                mediaDetail6 = mediaDetail5;
                list32 = list25;
                i52 = i611110;
                list33 = list24;
                i53 = i611111;
                obj13 = Requests.get$default(app8, str81116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0002119, 4094, (Object) null);
                c00024 = c0002119;
                obj14 = obj10;
                if (obj13 == obj14) {
                    return obj14;
                }
                i54 = i51 == true ? 1 : 0;
                str65 = str57;
                str66 = str58;
                str67 = str53;
                str68 = str62;
                list34 = list29;
                str69 = str60;
                list35 = list31;
                data12 = data11;
                str70 = str64;
                str71 = str61;
                str72 = str63;
                list36 = list30;
                i55 = i49 == true ? 1 : 0;
                String string7 = ((NiceResponse) obj13).toString();
                animeData = TorraStreamUtilsKt.parseAnimeData(string7);
                if (animeData != null) {
                    kitsuid = str7;
                } else {
                    kitsuid = str7;
                }
                MainAPI mainAPI12 = (MainAPI) this;
                TvType tvType117 = TvType.Anime;
                int i611112 = i55;
                if (i52 != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i53 != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (i54 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                obj15 = obj14;
                int i7117 = i54;
                C00021 c00021110 = c00024;
                int i7118 = i53;
                CinemetaRes cinemetaRes18 = cinemetaRes4;
                String str81117 = kitsuid;
                C00032 c00038 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str81117, cinemetaRes18, str70, list34, data12, str68, str69, z5, z6, z7, null);
                String str81118 = str67;
                String str81119 = str68;
                c00021110.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                c00021110.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                c00021110.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00021110.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c00021110.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                c00021110.L$5 = SpillingKt.nullOutSpilledVariable(str81119);
                c00021110.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                c00021110.L$7 = SpillingKt.nullOutSpilledVariable(str81118);
                c00021110.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00021110.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c00021110.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                c00021110.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                c00021110.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                c00021110.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                c00021110.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                c00021110.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                c00021110.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c00021110.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                c00021110.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes18);
                c00021110.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c00021110.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                c00021110.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                c00021110.L$22 = SpillingKt.nullOutSpilledVariable(string7);
                c00021110.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c00021110.L$24 = SpillingKt.nullOutSpilledVariable(str81117);
                c00021110.I$0 = i7117 == true ? 1 : 0;
                c00021110.I$1 = i50;
                c00021110.I$2 = i52;
                c00021110.I$3 = i7118;
                c00021110.I$4 = i611112 == true ? 1 : 0;
                c00021110.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI12, str81119, str65, tvType117, false, c00038, c00021110, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj15) {
                    return obj15;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                int i90 = c00025.I$4;
                i42 = c00025.I$3;
                int i91 = c00025.I$2;
                i32 = c00025.I$1;
                i40 = c00025.I$0;
                CinemetaRes cinemetaRes19 = (CinemetaRes) c00025.L$18;
                str50 = (String) c00025.L$17;
                str49 = (String) c00025.L$16;
                String str109 = (String) c00025.L$15;
                String str110 = (String) c00025.L$14;
                List list57 = (List) c00025.L$13;
                i41 = i90;
                List list58 = (List) c00025.L$12;
                List list59 = (List) c00025.L$11;
                list22 = (List) c00025.L$10;
                num7 = (Integer) c00025.L$9;
                str48 = (String) c00025.L$8;
                String str111 = (String) c00025.L$7;
                str47 = (String) c00025.L$6;
                String str112 = (String) c00025.L$5;
                MediaDetail mediaDetail20 = (MediaDetail) c00025.L$4;
                str51 = (String) c00025.L$3;
                TvType tvType21 = (TvType) c00025.L$2;
                data9 = (Data) c00025.L$1;
                String str113 = (String) c00025.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                obj9 = coroutine_suspended;
                i43 = i91;
                str27 = str113;
                str46 = str110;
                str26 = str111;
                str52 = str112;
                tvType3 = tvType21;
                str7 = null;
                cinemetaRes = cinemetaRes19;
                c00022 = c00025;
                str43 = str109;
                list12 = list59;
                list23 = list57;
                list9 = list58;
                mediaDetail3 = mediaDetail20;
                list37 = (List) objNewMovieLoadResponse;
                if (list37 != null) {
                    break;
                }
                int i6212 = i42;
                i34 = i43;
                i30 = i6212;
                str25 = str46;
                i31 = i40;
                str24 = str50;
                i33 = i41;
                list11 = list23;
                list10 = list22;
                num3 = num7;
                str14 = str48;
                str21 = str51;
                data8 = data9;
                str41 = str52;
                str28 = str49;
                str23 = str47;
                str22 = str43;
                i44 = i34;
                obj10 = obj9;
                i45 = i32;
                i46 = i31;
                list24 = list12;
                str53 = str26;
                num8 = num3;
                str54 = str28;
                str55 = str24;
                str43 = str22;
                str56 = str25;
                listEmptyList = CollectionsKt.emptyList();
                data10 = data8;
                str57 = str27;
                str52 = str41;
                list25 = list10;
                mediaDetail5 = mediaDetail3;
                str51 = str21;
                i47 = i33;
                list26 = list11;
                i48 = i30;
                str58 = str23;
                list27 = list9;
                cinemetaRes3 = cinemetaRes;
                list28 = listEmptyList;
                if (i45 == 0) {
                    String str71115 = str52;
                    String str71116 = str55;
                    Integer num19 = num8;
                    String str71117 = str43;
                    MediaDetail mediaDetail110 = mediaDetail5;
                    List list4117 = list24;
                    List list4118 = list25;
                    C00021 c00021111 = c00022;
                    List list4119 = list26;
                    List list41110 = list27;
                    CinemetaRes cinemetaRes110 = cinemetaRes3;
                    int i611113 = i47;
                    obj11 = obj10;
                    TvType tvType118 = TvType.TvSeries;
                    String str71118 = str57;
                    String str811110 = str58;
                    String str811111 = str53;
                    C00043 c00049 = new C00043(str811110, str811111, str71117, num19, mediaDetail110, list4117, list4118, this, list4119, list41110, list28, cinemetaRes110, str56, null);
                    c00021111.L$0 = SpillingKt.nullOutSpilledVariable(str71118);
                    c00021111.L$1 = SpillingKt.nullOutSpilledVariable(data10);
                    c00021111.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00021111.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                    c00021111.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail110);
                    c00021111.L$5 = SpillingKt.nullOutSpilledVariable(str71115);
                    c00021111.L$6 = SpillingKt.nullOutSpilledVariable(str811110);
                    c00021111.L$7 = SpillingKt.nullOutSpilledVariable(str811111);
                    c00021111.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                    c00021111.L$9 = SpillingKt.nullOutSpilledVariable(num19);
                    c00021111.L$10 = SpillingKt.nullOutSpilledVariable(list4118);
                    c00021111.L$11 = SpillingKt.nullOutSpilledVariable(list4117);
                    c00021111.L$12 = SpillingKt.nullOutSpilledVariable(list41110);
                    c00021111.L$13 = SpillingKt.nullOutSpilledVariable(list4119);
                    c00021111.L$14 = SpillingKt.nullOutSpilledVariable(str56);
                    c00021111.L$15 = SpillingKt.nullOutSpilledVariable(str71117);
                    c00021111.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                    c00021111.L$17 = SpillingKt.nullOutSpilledVariable(str71116);
                    c00021111.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes110);
                    c00021111.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                    c00021111.I$0 = i46 == true ? 1 : 0;
                    c00021111.I$1 = i45;
                    c00021111.I$2 = i44;
                    c00021111.I$3 = i48;
                    c00021111.I$4 = i611113 == true ? 1 : 0;
                    c00021111.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse((MainAPI) this, str71115, str71118, tvType118, list28, c00049, c00021111);
                    c00023 = c00021111;
                    if (objNewTvSeriesLoadResponse == obj11) {
                        return obj11;
                    }
                    obj12 = objNewTvSeriesLoadResponse;
                    return (LoadResponse) obj12;
                }
                if (cinemetaRes3 != null) {
                    str59 = str43;
                    cinemetaRes4 = cinemetaRes3;
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    str59 = str43;
                    cinemetaRes4 = cinemetaRes3;
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                alternative_titles = mediaDetail5.getAlternative_titles();
                if (alternative_titles == null) {
                    list29 = arrayListEmptyList;
                    if (cinemetaRes4 != null) {
                        name2 = str7;
                    } else {
                        name2 = str7;
                    }
                } else {
                    list29 = arrayListEmptyList;
                    if (cinemetaRes4 != null) {
                        name2 = str7;
                    } else {
                        name2 = str7;
                    }
                }
                Requests app9 = MainActivityKt.getApp();
                str60 = name2;
                String str811112 = "https://api.ani.zip/mappings?imdb_id=" + str55;
                c00022.L$0 = str57;
                c00022.L$1 = data10;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c00022.L$4 = mediaDetail5;
                c00022.L$5 = str52;
                c00022.L$6 = str58;
                c00022.L$7 = str53;
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00022.L$9 = num8;
                c00022.L$10 = list25;
                c00022.L$11 = list24;
                c00022.L$12 = list27;
                c00022.L$13 = list26;
                c00022.L$14 = str56;
                str61 = str59;
                c00022.L$15 = str61;
                str62 = str52;
                c00022.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$17 = str55;
                c00022.L$18 = cinemetaRes4;
                c00022.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c00022.L$20 = list29;
                list30 = list26;
                c00022.L$21 = str60;
                c00022.I$0 = i46 == true ? 1 : 0;
                int i611114 = i45;
                c00022.I$1 = i611114;
                int i611115 = i44;
                c00022.I$2 = i611115;
                int i611116 = i48;
                c00022.I$3 = i611116;
                c00022.I$4 = i47 == true ? 1 : 0;
                c00022.label = 5;
                C00021 c00021112 = c00022;
                list31 = list27;
                str63 = str56;
                data11 = data10;
                i49 = i47;
                i50 = i611114;
                i51 = i46;
                str64 = str55;
                num9 = num8;
                mediaDetail6 = mediaDetail5;
                list32 = list25;
                i52 = i611115;
                list33 = list24;
                i53 = i611116;
                obj13 = Requests.get$default(app9, str811112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021112, 4094, (Object) null);
                c00024 = c00021112;
                obj14 = obj10;
                if (obj13 == obj14) {
                    return obj14;
                }
                i54 = i51 == true ? 1 : 0;
                str65 = str57;
                str66 = str58;
                str67 = str53;
                str68 = str62;
                list34 = list29;
                str69 = str60;
                list35 = list31;
                data12 = data11;
                str70 = str64;
                str71 = str61;
                str72 = str63;
                list36 = list30;
                i55 = i49 == true ? 1 : 0;
                String string8 = ((NiceResponse) obj13).toString();
                animeData = TorraStreamUtilsKt.parseAnimeData(string8);
                if (animeData != null) {
                    kitsuid = str7;
                } else {
                    kitsuid = str7;
                }
                MainAPI mainAPI13 = (MainAPI) this;
                TvType tvType119 = TvType.Anime;
                int i611117 = i55;
                if (i52 != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i53 != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (i54 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                obj15 = obj14;
                int i7119 = i54;
                C00021 c00021113 = c00024;
                int i71110 = i53;
                CinemetaRes cinemetaRes111 = cinemetaRes4;
                String str811113 = kitsuid;
                C00032 c00039 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str811113, cinemetaRes111, str70, list34, data12, str68, str69, z5, z6, z7, null);
                String str811114 = str67;
                String str811115 = str68;
                c00021113.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                c00021113.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                c00021113.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00021113.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c00021113.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                c00021113.L$5 = SpillingKt.nullOutSpilledVariable(str811115);
                c00021113.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                c00021113.L$7 = SpillingKt.nullOutSpilledVariable(str811114);
                c00021113.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00021113.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c00021113.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                c00021113.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                c00021113.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                c00021113.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                c00021113.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                c00021113.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                c00021113.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c00021113.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                c00021113.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes111);
                c00021113.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c00021113.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                c00021113.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                c00021113.L$22 = SpillingKt.nullOutSpilledVariable(string8);
                c00021113.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c00021113.L$24 = SpillingKt.nullOutSpilledVariable(str811113);
                c00021113.I$0 = i7119 == true ? 1 : 0;
                c00021113.I$1 = i50;
                c00021113.I$2 = i52;
                c00021113.I$3 = i71110;
                c00021113.I$4 = i611117 == true ? 1 : 0;
                c00021113.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI13, str811115, str65, tvType119, false, c00039, c00021113, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj15) {
                    return obj15;
                }
                return objNewAnimeLoadResponse$default;
            case 5:
                int i92 = c00025.I$4;
                int i93 = c00025.I$3;
                int i94 = c00025.I$2;
                int i95 = c00025.I$1;
                int i96 = c00025.I$0;
                String str114 = (String) c00025.L$21;
                List list60 = (List) c00025.L$20;
                List list61 = (List) c00025.L$19;
                CinemetaRes cinemetaRes20 = (CinemetaRes) c00025.L$18;
                String str115 = (String) c00025.L$17;
                String str116 = (String) c00025.L$16;
                String str117 = (String) c00025.L$15;
                String str118 = (String) c00025.L$14;
                List list62 = (List) c00025.L$13;
                List list63 = (List) c00025.L$12;
                List list64 = (List) c00025.L$11;
                List list65 = (List) c00025.L$10;
                Integer num20 = (Integer) c00025.L$9;
                String str119 = (String) c00025.L$8;
                String str120 = (String) c00025.L$7;
                String str121 = (String) c00025.L$6;
                String str122 = (String) c00025.L$5;
                MediaDetail mediaDetail21 = (MediaDetail) c00025.L$4;
                String str123 = (String) c00025.L$3;
                TvType tvType22 = (TvType) c00025.L$2;
                Data data21 = (Data) c00025.L$1;
                String str124 = (String) c00025.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                str54 = str116;
                mediaDetail6 = mediaDetail21;
                obj13 = objNewMovieLoadResponse;
                i52 = i94;
                i50 = i95;
                list36 = list62;
                list35 = list63;
                list32 = list65;
                str14 = str119;
                str7 = null;
                str65 = str124;
                i55 = i92;
                str66 = str121;
                str51 = str123;
                tvType3 = tvType22;
                data12 = data21;
                list28 = list61;
                cinemetaRes4 = cinemetaRes20;
                str70 = str115;
                list34 = list60;
                num9 = num20;
                c00024 = c00025;
                i54 = i96;
                str72 = str118;
                list33 = list64;
                str69 = str114;
                obj14 = coroutine_suspended;
                str67 = str120;
                i53 = i93;
                str71 = str117;
                str68 = str122;
                String string9 = ((NiceResponse) obj13).toString();
                animeData = TorraStreamUtilsKt.parseAnimeData(string9);
                if (animeData != null) {
                    kitsuid = str7;
                } else {
                    kitsuid = str7;
                }
                MainAPI mainAPI14 = (MainAPI) this;
                TvType tvType1110 = TvType.Anime;
                int i611118 = i55;
                if (i52 != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (i53 != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (i54 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                obj15 = obj14;
                int i71111 = i54;
                C00021 c00021114 = c00024;
                int i71112 = i53;
                CinemetaRes cinemetaRes112 = cinemetaRes4;
                String str811116 = kitsuid;
                C00032 c000310 = new C00032(str66, str67, str71, num9, mediaDetail6, list33, list32, this, list36, list35, str72, str811116, cinemetaRes112, str70, list34, data12, str68, str69, z5, z6, z7, null);
                String str811117 = str67;
                String str811118 = str68;
                c00021114.L$0 = SpillingKt.nullOutSpilledVariable(str65);
                c00021114.L$1 = SpillingKt.nullOutSpilledVariable(data12);
                c00021114.L$2 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00021114.L$3 = SpillingKt.nullOutSpilledVariable(str51);
                c00021114.L$4 = SpillingKt.nullOutSpilledVariable(mediaDetail6);
                c00021114.L$5 = SpillingKt.nullOutSpilledVariable(str811118);
                c00021114.L$6 = SpillingKt.nullOutSpilledVariable(str66);
                c00021114.L$7 = SpillingKt.nullOutSpilledVariable(str811117);
                c00021114.L$8 = SpillingKt.nullOutSpilledVariable(str14);
                c00021114.L$9 = SpillingKt.nullOutSpilledVariable(num9);
                c00021114.L$10 = SpillingKt.nullOutSpilledVariable(list32);
                c00021114.L$11 = SpillingKt.nullOutSpilledVariable(list33);
                c00021114.L$12 = SpillingKt.nullOutSpilledVariable(list35);
                c00021114.L$13 = SpillingKt.nullOutSpilledVariable(list36);
                c00021114.L$14 = SpillingKt.nullOutSpilledVariable(str72);
                c00021114.L$15 = SpillingKt.nullOutSpilledVariable(str71);
                c00021114.L$16 = SpillingKt.nullOutSpilledVariable(str54);
                c00021114.L$17 = SpillingKt.nullOutSpilledVariable(str70);
                c00021114.L$18 = SpillingKt.nullOutSpilledVariable(cinemetaRes112);
                c00021114.L$19 = SpillingKt.nullOutSpilledVariable(list28);
                c00021114.L$20 = SpillingKt.nullOutSpilledVariable(list34);
                c00021114.L$21 = SpillingKt.nullOutSpilledVariable(str69);
                c00021114.L$22 = SpillingKt.nullOutSpilledVariable(string9);
                c00021114.L$23 = SpillingKt.nullOutSpilledVariable(animeData);
                c00021114.L$24 = SpillingKt.nullOutSpilledVariable(str811116);
                c00021114.I$0 = i71111 == true ? 1 : 0;
                c00021114.I$1 = i50;
                c00021114.I$2 = i52;
                c00021114.I$3 = i71112;
                c00021114.I$4 = i611118 == true ? 1 : 0;
                c00021114.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(mainAPI14, str811118, str65, tvType1110, false, c000310, c00021114, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj15) {
                    return obj15;
                }
                return objNewAnimeLoadResponse$default;
            case 6:
                int i97 = c00025.I$4;
                int i98 = c00025.I$3;
                int i99 = c00025.I$2;
                int i100 = c00025.I$1;
                int i101 = c00025.I$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                return objNewMovieLoadResponse;
            case 7:
                int i102 = c00025.I$4;
                int i103 = c00025.I$3;
                int i104 = c00025.I$2;
                int i105 = c00025.I$1;
                int i106 = c00025.I$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                c00023 = c00025;
                obj12 = objNewMovieLoadResponse;
                return (LoadResponse) obj12;
            case 8:
                int i107 = c00025.I$4;
                int i108 = c00025.I$3;
                int i109 = c00025.I$2;
                i28 = c00025.I$1;
                int i110 = c00025.I$0;
                cinemetaRes2 = (CinemetaRes) c00025.L$18;
                str37 = (String) c00025.L$17;
                str40 = (String) c00025.L$16;
                str39 = (String) c00025.L$15;
                str35 = (String) c00025.L$14;
                List list66 = (List) c00025.L$13;
                list20 = (List) c00025.L$12;
                i29 = i107;
                list17 = (List) c00025.L$11;
                list18 = (List) c00025.L$10;
                num5 = (Integer) c00025.L$9;
                str36 = (String) c00025.L$8;
                str38 = (String) c00025.L$6;
                String str125 = (String) c00025.L$5;
                mediaDetail4 = (MediaDetail) c00025.L$4;
                str21 = (String) c00025.L$3;
                data7 = (Data) c00025.L$1;
                String str126 = (String) c00025.L$0;
                ResultKt.throwOnFailure(objNewMovieLoadResponse);
                i27 = i108;
                i26 = i109;
                list19 = list66;
                str34 = str125;
                str33 = str126;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0069 A[PHI: r10
      0x0069: PHI (r10v8 java.lang.Integer) = (r10v2 java.lang.Integer), (r10v14 java.lang.Integer) binds: [B:21:0x0067, B:12:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    public static final List<Episode> load$buildEpisodeList(List<CinemetaRes.Meta.Video> list, CinemetaRes cineRes, final TorraStream this$0, Data data, String imdbId, MediaDetail res, String title, Integer year, String jpTitle, boolean isAsian, boolean isBollywood, boolean isCartoon, boolean isDub) {
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
            destination$iv$iv.add(MainAPIKt.newEpisode(mainAPI, appUtils.toJson(new LinkData(id, imdbId, tvdb_id, type, season, episode, null, null, null, title, numValueOf, "", true, year, null, title2, jpTitle, released2, releaseDate, isAsian, isBollywood, isCartoon, res.getTitle(), res.getName(), isDub, null, 33571264, null)), new Function1() { // from class: com.phisher98.TorraStream$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return TorraStream.load$buildEpisodeList$lambda$9$0(video, this$0, (Episode) obj);
                }
            }));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$buildEpisodeList$lambda$9$0(CinemetaRes.Meta.Video $video, TorraStream this$0, Episode $this$newEpisode) {
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
    @DebugMetadata(c = "com.phisher98.TorraStream$load$2", f = "TorraStream.kt", i = {0}, l = {288}, m = "invokeSuspend", n = {"$this$newAnimeLoadResponse"}, nl = {289}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,549:1\n1739#2:550\n1814#2,2:551\n1816#2:554\n1#3:553\n*S KotlinDebug\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$2\n*L\n282#1:550\n282#1:551,2\n282#1:554\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
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
        final /* synthetic */ TorraStream this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, TorraStream torraStream, List<? extends SearchResponse> list3, List<ActorData> list4, String str4, String str5, CinemetaRes cinemetaRes, String str6, List<CinemetaRes.Meta.Video> list5, Data data, String str7, String str8, boolean z, boolean z2, boolean z3, Continuation<? super C00032> continuation) {
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
            this.$trailer = str4;
            this.$kitsuid = str5;
            this.$cineRes = cinemetaRes;
            this.$imdbId = str6;
            this.$animeVideos = list5;
            this.$data = data;
            this.$title = str7;
            this.$jpTitle = str8;
            this.$isAsian = z;
            this.$isBollywood = z2;
            this.$isCartoon = z3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$poster, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.this$0, this.$recommendations, this.$actors, this.$trailer, this.$kitsuid, this.$cineRes, this.$imdbId, this.$animeVideos, this.$data, this.$title, this.$jpTitle, this.$isAsian, this.$isBollywood, this.$isCartoon, continuation);
            c00032.L$0 = obj;
            return c00032;
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
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, TorraStream.load$buildEpisodeList(this.$animeVideos, this.$cineRes, this.this$0, this.$data, this.$imdbId, this.$res, this.$title, this.$year, this.$jpTitle, this.$isAsian, this.$isBollywood, this.$isCartoon, false));
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
    @DebugMetadata(c = "com.phisher98.TorraStream$load$3", f = "TorraStream.kt", i = {0}, l = {310}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {311}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,549:1\n1#2:550\n*E\n"})
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
    @DebugMetadata(c = "com.phisher98.TorraStream$load$4", f = "TorraStream.kt", i = {0}, l = {332}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {333}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStream.kt\ncom/phisher98/TorraStream$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,549:1\n1#2:550\n*E\n"})
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$2", f = "TorraStream.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$3", f = "TorraStream.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$4", f = "TorraStream.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$5", f = "TorraStream.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$6", f = "TorraStream.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, nl = {398}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$7", f = "TorraStream.kt", i = {}, l = {399}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$8", f = "TorraStream.kt", i = {}, l = {400}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$9", f = "TorraStream.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, nl = {410}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$10", f = "TorraStream.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$11", f = "TorraStream.kt", i = {}, l = {413}, m = "invokeSuspend", n = {}, nl = {420}, s = {}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStream$loadLinks$12", f = "TorraStream.kt", i = {}, l = {421}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
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
