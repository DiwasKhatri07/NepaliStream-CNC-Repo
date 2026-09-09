package com.phisher98;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Base64;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.DubStatus;
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
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.syncproviders.SyncRepo;
import com.lagradost.cloudstream3.syncproviders.providers.AniListApi;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.UiText;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
import kotlin.collections.IntIterator;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TorraStreamAnime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\bijklmnopB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010-\u001a\u00020\u0007*\u00020.H\u0002J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u00102J\f\u00103\u001a\u000204*\u000205H\u0002J,\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020408\u0012\u0004\u0012\u00020\u001d07*\u0002092\u0006\u0010:\u001a\u00020'H\u0082@¢\u0006\u0002\u0010;J\b\u0010B\u001a\u00020\u001dH\u0002J\u001e\u0010C\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001082\u0006\u00101\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102J \u0010D\u001a\u0004\u0018\u00010E2\u0006\u00101\u001a\u00020\u00072\u0006\u0010:\u001a\u00020'H\u0096@¢\u0006\u0002\u0010FJ\u001e\u0010D\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001082\u0006\u00101\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102J\u001e\u0010?\u001a\u00020G2\u0006\u0010:\u001a\u00020'2\u0006\u0010H\u001a\u000209H\u0096@¢\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102J\u001e\u0010M\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010OJ\u001e\u0010P\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010OJF\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u001d2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X0V2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020X0VH\u0096@¢\u0006\u0002\u0010[J*\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u00072\b\u0010_\u001a\u0004\u0018\u00010'2\u0006\u0010`\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010aJ\u0018\u0010b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001e\u0010c\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020>08X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/phisher98/TorraStreamAnime;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "repo", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "apiUrl", "anilistAPI", "mediaLimit", "", "isAdult", "headerJSON", "", "torrentioDebian", "TorrentsDB", "toStringData", "", "anilistAPICall", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/TorraStreamAnime$Media;", "toSearchResponseList", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/MainPageRequest;", "page", "(Lcom/lagradost/cloudstream3/MainPageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentYear", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "isAnilistDown", "shouldUseKitsu", "quickSearch", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "request", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadFromAnilist", "id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFromKitsu", "rawId", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmdbToAnimeId", "Lcom/phisher98/TorraStreamAnime$AniIds;", "title", "year", "type", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildApiUrl", "buildMeteorUrl", "baseUrl", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "AnilistAPIResponse", "LinkData", "Media", "AniIds", "AniMedia", "AniPage", "AniData", "AniSearch", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,815:1\n73#2,5:816\n73#2,5:897\n1739#3:821\n1814#3,3:822\n1739#3:825\n1814#3,3:826\n1795#3,10:829\n2068#3:839\n2069#3:841\n1805#3:842\n1739#3:844\n1814#3,3:845\n296#3,2:848\n296#3,2:850\n1749#3:852\n1782#3,4:853\n1739#3:857\n1814#3,3:858\n777#3:861\n873#3,2:862\n1795#3,10:864\n2068#3:874\n2069#3:876\n1805#3:877\n1#4:840\n1#4:843\n1#4:875\n1#4:879\n1#4:902\n63#5:878\n64#5,15:880\n50#6:895\n43#6:896\n*S KotlinDebug\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime\n*L\n80#1:816,5\n680#1:897,5\n101#1:821\n101#1:822,3\n141#1:825\n141#1:826,3\n163#1:829,10\n163#1:839\n163#1:841\n163#1:842\n294#1:844\n294#1:845,3\n374#1:848,2\n375#1:850,2\n435#1:852\n435#1:853,4\n437#1:857\n437#1:858,3\n440#1:861\n440#1:862,2\n440#1:864,10\n440#1:874\n440#1:876\n440#1:877\n163#1:840\n440#1:875\n486#1:879\n486#1:878\n486#1:880,15\n486#1:895\n486#1:896\n*E\n"})
public class TorraStreamAnime extends MainAPI {

    @NotNull
    private final SharedPreferences sharedPref;

    @NotNull
    private String name = "TorraStream-Anime";

    @NotNull
    private String mainUrl = "https://anilist.co";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(SyncIdName.Anilist);
    private final boolean hasMainPage = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final SyncRepo repo = new SyncRepo(AccountManager.Companion.getAniListApi());

    @NotNull
    private final String apiUrl = "https://graphql.anilist.co";

    @NotNull
    private final String anilistAPI = "https://graphql.anilist.co";
    private final int mediaLimit = 20;

    @NotNull
    private final Map<String, String> headerJSON = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "application/json"), TuplesKt.to("Content-Type", "application/json")});

    @NotNull
    private final String torrentioDebian = "https://torrentio.strem.fun";

    @NotNull
    private final String TorrentsDB = TorraStream.TorrentsDB;
    private final int currentYear = Calendar.getInstance().get(1);
    private final boolean isAdult;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [TRENDING_DESC, POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Trending Now"), TuplesKt.to("query ($page: Int = ###, $seasonYear: Int = " + this.currentYear + ", $sort: [MediaSort] = [TRENDING_DESC, POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, seasonYear: $seasonYear, season: SPRING, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Popular This Season"), TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "All Time Popular"), TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [SCORE_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Top 100 Anime"), TuplesKt.to("Personal", "Personal")});
    private boolean isAnilistDown = true;

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$anilistAPICall$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0}, l = {78}, m = "anilistAPICall", n = {"query", "data"}, nl = {80}, s = {"L$0", "L$1"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.this.anilistAPICall(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$buildMeteorUrl$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {743}, m = "buildMeteorUrl", n = {"sharedPref", "baseUrl", "debridProvider", "debridKey", "languagesPref", "limit", "sizeFilter", "$this$buildMeteorUrl_u24lambda_u240"}, nl = {745}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8"}, v = 2)
    static final class C00211 extends ContinuationImpl {
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

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.this.buildMeteorUrl(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$getMainPage$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4}, l = {163, 173, 177, 185, 191}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page", "$this", "request", "catalogId", "page", "$this", "request", "<unused var>", "page", "$this", "request", "page", "$this", "request", "e", "catalogId", "page"}, nl = {163, 174, 178, 186, 192}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00221(Continuation<? super C00221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.getMainPage$suspendImpl(TorraStreamAnime.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$load$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {205, 210, 214, 218}, m = "load$suspendImpl", n = {"$this", "url", "id", "isKitsu", "$this", "url", "id", "e", "isKitsu", "$this", "url", "id", "isKitsu", "$this", "url", "id", "e", "isKitsu"}, nl = {206, 204, 215, 220}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.load$suspendImpl(TorraStreamAnime.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadFromAnilist$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {226, 233, 238, 297, 311}, m = "loadFromAnilist", n = {"url", "id", "url", "id", "data", "anititle", "anitype", "aniyear", "url", "id", "data", "anititle", "anitype", "ids", "posterurl", "backgroundUrl", "jpTitle", "aniyear", "url", "id", "data", "anititle", "anitype", "ids", "posterurl", "backgroundUrl", "jpTitle", "syncMetaData", "animeMetaData", "logoposter", "kitsuId", "href", "episodes", "aniyear", "url", "id", "data", "anititle", "anitype", "ids", "posterurl", "backgroundUrl", "jpTitle", "syncMetaData", "animeMetaData", "logoposter", "kitsuId", "href", "episodes", "aniyear"}, nl = {228, 234, 239, 311, 296}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0"}, v = 2)
    static final class C00241 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.this.loadFromAnilist(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadFromKitsu$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {344, 346, 348, 348, 354, 366, 448, 459}, m = "loadFromKitsu", n = {"url", "rawId", "url", "rawId", "url", "rawId", "url", "rawId", "url", "rawId", "kitsuMeta", "numericKitsuId", "queryParam", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "anititle", "aniyear", "anitype", "aniListId", "malId", "isMovie", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "anititle", "aniyear", "anitype", "aniListId", "malId", "ids", "finalAniId", "finalMalId", "jpTitle", "posterUrl", "backgroundUrl", "logoposter", "href", "videos", "episodes", "recs", "isMovie", "totalEpisodes", "url", "rawId", "kitsuMeta", "numericKitsuId", "syncMetaData", "animeMetaData", "anititle", "aniyear", "anitype", "aniListId", "malId", "ids", "finalAniId", "finalMalId", "jpTitle", "posterUrl", "backgroundUrl", "logoposter", "href", "videos", "episodes", "recs", "isMovie", "totalEpisodes"}, nl = {345, 348, 348, 343, 355, 368, 459, 447}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1"}, v = 2)
    static final class C00271 extends ContinuationImpl {
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
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00271(Continuation<? super C00271> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.this.loadFromKitsu(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {496, 512, 518, 524}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "queryParam", "isCasting", "$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "debianapiUrl", "isCasting", "$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "debianapiUrl", "meteorUrl", "filtered", "isCasting", "$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "debianapiUrl", "meteorUrl", "filtered", "isCasting"}, nl = {497, 514, 524, 533}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0"}, v = 2)
    static final class C00301 extends ContinuationImpl {
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

        C00301(Continuation<? super C00301> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.loadLinks$suspendImpl(TorraStreamAnime.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$search$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0}, l = {130}, m = "search$suspendImpl", n = {"$this", "query", "page"}, nl = {-1}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00361 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00361(Continuation<? super C00361> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.search$suspendImpl(TorraStreamAnime.this, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$search$2 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {134, 138, 145}, m = "search$suspendImpl", n = {"$this", "query", "$this", "query", "$this", "query", "<unused var>"}, nl = {136, 137, 147}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00372 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00372(Continuation<? super C00372> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.search$suspendImpl(TorraStreamAnime.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$tmdbToAnimeId$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 0, 0}, l = {679}, m = "tmdbToAnimeId", n = {"title", "year", "type", "query", "variables", "data"}, nl = {680}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00381(Continuation<? super C00381> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.this.tmdbToAnimeId(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$toSearchResponseList$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0}, l = {99}, m = "toSearchResponseList", n = {"$this$toSearchResponseList", "page"}, nl = {101}, s = {"L$0", "I$0"}, v = 2)
    static final class C00391 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00391(Continuation<? super C00391> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TorraStreamAnime.this.toSearchResponseList(null, 0, (Continuation) this);
        }
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object quickSearch(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(str, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, int i, @NotNull Continuation<? super SearchResponseList> continuation) {
        return search$suspendImpl(this, str, i, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
    }

    public TorraStreamAnime(@NotNull SharedPreferences sharedPref) {
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

    private final String toStringData(Object $this$toStringData) {
        return MainAPIKt.getMapper().writeValueAsString($this$toStringData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object anilistAPICall(String query, Continuation<? super AnilistAPIResponse> continuation) throws Exception {
        C00201 c00201;
        Object safe;
        if (continuation instanceof C00201) {
            c00201 = (C00201) continuation;
            if ((c00201.label & Integer.MIN_VALUE) != 0) {
                c00201.label -= Integer.MIN_VALUE;
            } else {
                c00201 = new C00201(continuation);
            }
        } else {
            c00201 = new C00201(continuation);
        }
        C00201 c00202 = c00201;
        Object $result = c00202.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00202.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map data = MapsKt.mapOf(TuplesKt.to("query", query));
                Requests app = MainActivityKt.getApp();
                String str = this.apiUrl;
                Map<String, String> map = this.headerJSON;
                c00202.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00202.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00202.label = 1;
                $result = Requests.post$default(app, str, map, (String) null, (Map) null, (Map) null, data, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00202, 65500, (Object) null);
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
        NiceResponse test = (NiceResponse) $result;
        try {
            ResponseParser parser = test.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(test.getText(), Reflection.getOrCreateKotlinClass(AnilistAPIResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AnilistAPIResponse res = (AnilistAPIResponse) safe;
        if (res == null) {
            throw new Exception("Unable to fetch or parse Anilist api response");
        }
        return res;
    }

    private final SearchResponse toSearchResponse(Media $this$toSearchResponse) {
        String english = $this$toSearchResponse.getTitle().getEnglish();
        if (english == null && (english = $this$toSearchResponse.getTitle().getRomaji()) == null) {
            english = "";
        }
        String title = english;
        String url = getMainUrl() + "/anime/" + $this$toSearchResponse.getId();
        final String posterUrl = $this$toSearchResponse.getCoverImage().getLarge();
        final int rating = $this$toSearchResponse.getAverageScore();
        return MainAPIKt.newAnimeSearchResponse$default(this, title, url, TvType.Anime, false, new Function1() { // from class: com.phisher98.TorraStreamAnime$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return TorraStreamAnime.toSearchResponse$lambda$0(posterUrl, rating, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(String $posterUrl, int $rating, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        $this$newAnimeSearchResponse.setScore(Score.Companion.from100(Integer.valueOf($rating)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object toSearchResponseList(MainPageRequest $this$toSearchResponseList, int page, Continuation<? super Pair<? extends List<? extends SearchResponse>, Boolean>> continuation) throws Exception {
        C00391 c00391;
        Object obj;
        Iterable media;
        if (continuation instanceof C00391) {
            c00391 = (C00391) continuation;
            if ((c00391.label & Integer.MIN_VALUE) != 0) {
                c00391.label -= Integer.MIN_VALUE;
            } else {
                c00391 = new C00391(continuation);
            }
        } else {
            c00391 = new C00391(continuation);
        }
        Object $result = c00391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00391.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String strReplace$default = StringsKt.replace$default($this$toSearchResponseList.getData(), "###", String.valueOf(page), false, 4, (Object) null);
                c00391.L$0 = SpillingKt.nullOutSpilledVariable($this$toSearchResponseList);
                c00391.I$0 = page;
                c00391.label = 1;
                Object objAnilistAPICall = anilistAPICall(strReplace$default, c00391);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAnilistAPICall;
                break;
                break;
            case 1:
                int i = c00391.I$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnilistAPIResponse res = (AnilistAPIResponse) obj;
        AnilistAPIResponse.AnilistData.AnilistPage page2 = res.getData().getPage();
        if (page2 == null || (media = page2.getMedia()) == null) {
            throw new Exception("Unable to read media data");
        }
        Iterable $this$map$iv = media;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Media it = (Media) item$iv$iv;
            destination$iv$iv.add(toSearchResponse(it));
        }
        List data = (List) destination$iv$iv;
        Boolean hasNextPage = res.getData().getPage().getPageInfo().getHasNextPage();
        boolean hasNextPage2 = hasNextPage != null ? hasNextPage.booleanValue() : false;
        return TuplesKt.to(data, Boxing.boxBoolean(hasNextPage2));
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final boolean shouldUseKitsu() {
        String pref = this.sharedPref.getString("anime_metadata_source", "kitsu");
        return Intrinsics.areEqual(pref, "kitsu") || (!Intrinsics.areEqual(pref, "anilist") && this.isAnilistDown);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object search$suspendImpl(TorraStreamAnime $this, String query, int page, Continuation<? super SearchResponseList> continuation) {
        C00361 c00361;
        Object objSearch;
        if (continuation instanceof C00361) {
            c00361 = (C00361) continuation;
            if ((c00361.label & Integer.MIN_VALUE) != 0) {
                c00361.label -= Integer.MIN_VALUE;
            } else {
                c00361 = $this.new C00361(continuation);
            }
        } else {
            c00361 = $this.new C00361(continuation);
        }
        Object $result = c00361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00361.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00361.L$0 = SpillingKt.nullOutSpilledVariable($this);
                c00361.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00361.I$0 = page;
                c00361.label = 1;
                objSearch = $this.search(query, c00361);
                if (objSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int page2 = c00361.I$0;
                ResultKt.throwOnFailure($result);
                objSearch = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = (List) objSearch;
        if (list != null) {
            return MainAPIKt.toNewSearchResponseList$default(list, (Boolean) null, 1, (Object) null);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x014c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0174 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0175  */
    /* JADX WARN: Code duplicated, block: B:53:0x017f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object search$suspendImpl(TorraStreamAnime $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        C00372 c00372;
        String query2;
        C00372 c00373;
        Throwable th;
        TorraStreamAnime $this2;
        String query3;
        Object objAnilistAPICall;
        Throwable th2;
        Object objSearch$default;
        TorraStreamAnime $this3;
        Throwable th3;
        AnilistAPIResponse.AnilistData.AnilistPage page;
        Iterable media;
        TorraStreamAnime $this4 = $this;
        if (continuation instanceof C00372) {
            c00372 = (C00372) continuation;
            if ((c00372.label & Integer.MIN_VALUE) != 0) {
                c00372.label -= Integer.MIN_VALUE;
            } else {
                c00372 = $this4.new C00372(continuation);
            }
        } else {
            c00372 = $this4.new C00372(continuation);
        }
        C00372 c00374 = c00372;
        Object $result = c00374.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00374.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if ($this4.shouldUseKitsu()) {
                    c00374.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                    c00374.L$1 = SpillingKt.nullOutSpilledVariable(query);
                    c00374.label = 1;
                    Object objSearch$default2 = TorraStreamKitsuHelper.search$default(TorraStreamKitsuHelper.INSTANCE, $this4, query, 0, c00374, 4, null);
                    return objSearch$default2 == coroutine_suspended ? coroutine_suspended : objSearch$default2;
                }
                query2 = query;
                c00373 = c00374;
                try {
                    String str = "query ($search: String = \"" + query2 + "\") { Page(page: 1, perPage: " + $this4.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(search: $search, isAdult: " + $this4.isAdult + ", type: ANIME) { id idMal season seasonYear format episodes chapters title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }";
                    c00373.L$0 = $this4;
                    c00373.L$1 = query2;
                    c00373.label = 2;
                    objAnilistAPICall = $this4.anilistAPICall(str, c00373);
                    if (objAnilistAPICall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        AnilistAPIResponse res = (AnilistAPIResponse) objAnilistAPICall;
                        page = res.getData().getPage();
                        if (page != null || (media = page.getMedia()) == null) {
                            return null;
                        }
                        Iterable $this$map$iv = media;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            Media it = (Media) item$iv$iv;
                            destination$iv$iv.add($this4.toSearchResponse(it));
                        }
                        return (List) destination$iv$iv;
                    } catch (Throwable th4) {
                        TorraStreamAnime torraStreamAnime = $this4;
                        th = th4;
                        $this2 = torraStreamAnime;
                        query3 = query2;
                        th2 = th;
                        if (Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                            return null;
                        }
                        $this2.isAnilistDown = true;
                        c00373.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00373.L$1 = SpillingKt.nullOutSpilledVariable(query3);
                        c00373.L$2 = SpillingKt.nullOutSpilledVariable(th2);
                        c00373.label = 3;
                        objSearch$default = TorraStreamKitsuHelper.search$default(TorraStreamKitsuHelper.INSTANCE, $this2, query3, 0, c00373, 4, null);
                        if (objSearch$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this3 = $this2;
                        th3 = th2;
                        return (List) objSearch$default;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    $this2 = $this4;
                    query3 = query2;
                    th2 = th;
                    if (Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                        return null;
                    }
                    $this2.isAnilistDown = true;
                    c00373.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00373.L$1 = SpillingKt.nullOutSpilledVariable(query3);
                    c00373.L$2 = SpillingKt.nullOutSpilledVariable(th2);
                    c00373.label = 3;
                    objSearch$default = TorraStreamKitsuHelper.search$default(TorraStreamKitsuHelper.INSTANCE, $this2, query3, 0, c00373, 4, null);
                    if (objSearch$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this3 = $this2;
                    th3 = th2;
                    return (List) objSearch$default;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                query2 = (String) c00374.L$1;
                $this4 = (TorraStreamAnime) c00374.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    c00373 = c00374;
                    objAnilistAPICall = $result;
                    AnilistAPIResponse res2 = (AnilistAPIResponse) objAnilistAPICall;
                    page = res2.getData().getPage();
                    if (page != null) {
                        break;
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    $this2 = $this4;
                    query3 = query2;
                    c00373 = c00374;
                    th2 = th;
                    if (Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                        return null;
                    }
                    $this2.isAnilistDown = true;
                    c00373.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00373.L$1 = SpillingKt.nullOutSpilledVariable(query3);
                    c00373.L$2 = SpillingKt.nullOutSpilledVariable(th2);
                    c00373.label = 3;
                    objSearch$default = TorraStreamKitsuHelper.search$default(TorraStreamKitsuHelper.INSTANCE, $this2, query3, 0, c00373, 4, null);
                    if (objSearch$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this3 = $this2;
                    th3 = th2;
                    return (List) objSearch$default;
                }
            case 3:
                th3 = (Throwable) c00374.L$2;
                String query4 = (String) c00374.L$1;
                TorraStreamAnime $this5 = (TorraStreamAnime) c00374.L$0;
                ResultKt.throwOnFailure($result);
                query3 = query4;
                $this3 = $this5;
                objSearch$default = $result;
                return (List) objSearch$default;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0128  */
    /* JADX WARN: Code duplicated, block: B:40:0x0140  */
    /* JADX WARN: Code duplicated, block: B:41:0x0147  */
    /* JADX WARN: Code duplicated, block: B:43:0x0153  */
    /* JADX WARN: Code duplicated, block: B:44:0x015a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0193  */
    /* JADX WARN: Code duplicated, block: B:57:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:58:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:66:0x0211  */
    /* JADX WARN: Code duplicated, block: B:68:0x022a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x022b  */
    /* JADX WARN: Code duplicated, block: B:71:0x024d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0296  */
    /* JADX WARN: Code duplicated, block: B:85:0x02c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:89:0x02eb  */
    static /* synthetic */ Object getMainPage$suspendImpl(TorraStreamAnime $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) throws Exception {
        C00221 c00221;
        boolean z;
        Object searchResponseList;
        Object catalog;
        Object obj;
        int page2;
        MainPageRequest request2;
        Collection destination$iv$iv;
        SyncAPI.LibraryList it;
        UiText name;
        Activity activity;
        HomePageList homePageList;
        Object searchResponseList2;
        Throwable th;
        int page3;
        boolean hasNext;
        Object catalog2;
        int page4;
        TorraStreamAnime $this2 = $this;
        int page5 = page;
        MainPageRequest request3 = request;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = $this2.new C00221(continuation);
            }
        } else {
            c00221 = $this2.new C00221(continuation);
        }
        C00221 c00222 = c00221;
        Object $result = c00222.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        HomePageList homePageList2 = null;
        switch (c00222.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow($this2.getName());
                if (StringsKt.contains$default(request3.getName(), "Personal", false, 2, (Object) null)) {
                    if ($this2.repo.authUser() == null) {
                        return MainAPIKt.newHomePageResponse("Login required for personal content.", CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                    }
                    SyncRepo syncRepo = $this2.repo;
                    c00222.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00222.L$1 = request3;
                    c00222.I$0 = page5;
                    c00222.label = 1;
                    Object obj2 = syncRepo.library-IoAF18A(c00222);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = obj2;
                    page2 = page5;
                    request2 = request3;
                    ResultKt.throwOnFailure(obj);
                    Intrinsics.checkNotNull(obj);
                    Iterable $this$mapNotNull$iv = ((SyncAPI.LibraryMetadata) obj).getAllLibraryLists();
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        it = (SyncAPI.LibraryList) element$iv$iv$iv;
                        if (it.getItems().isEmpty()) {
                            homePageList = homePageList2;
                        } else {
                            name = it.getName();
                            activity = CommonActivity.INSTANCE.getActivity();
                            if (activity == null) {
                                homePageList = null;
                            } else {
                                String libraryName = name.asString(activity);
                                homePageList = new HomePageList(request2.getName() + ": " + libraryName, it.getItems(), false, 4, (DefaultConstructorMarker) null);
                            }
                        }
                        if (homePageList != null) {
                            destination$iv$iv.add(homePageList);
                        }
                        homePageList2 = null;
                        page2 = page2;
                    }
                    List homePageList3 = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(homePageList3, Boxing.boxBoolean(false));
                }
                z = false;
                if (!$this2.shouldUseKitsu()) {
                    try {
                        c00222.L$0 = $this2;
                        c00222.L$1 = request3;
                        c00222.I$0 = page5;
                        c00222.label = 4;
                        searchResponseList = $this2.toSearchResponseList(request3, page5, c00222);
                        if (searchResponseList == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Pair data = (Pair) searchResponseList;
                        return MainAPIKt.newHomePageResponse(request3.getName(), (List) data.getFirst(), (Boolean) data.getSecond());
                    } catch (Throwable th2) {
                        e = th2;
                        if (!Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                            throw e;
                        }
                        $this2.isAnilistDown = true;
                        String catalogId = TorraStreamKitsuHelper.INSTANCE.mapSectionToKitsuCatalog(request3.getName());
                        c00222.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00222.L$1 = request3;
                        c00222.L$2 = SpillingKt.nullOutSpilledVariable(e);
                        c00222.L$3 = SpillingKt.nullOutSpilledVariable(catalogId);
                        c00222.I$0 = page5;
                        c00222.label = 5;
                        catalog2 = TorraStreamKitsuHelper.INSTANCE.getCatalog($this2, catalogId, page5, c00222);
                        if (catalog2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        page4 = page5;
                        Pair pair = (Pair) catalog2;
                        List items = (List) pair.component1();
                        boolean hasNext2 = ((Boolean) pair.component2()).booleanValue();
                        return MainAPIKt.newHomePageResponse(request3.getName(), items, Boxing.boxBoolean(hasNext2));
                    }
                }
                try {
                    String catalogId2 = TorraStreamKitsuHelper.INSTANCE.mapSectionToKitsuCatalog(request3.getName());
                    c00222.L$0 = $this2;
                    c00222.L$1 = request3;
                    c00222.L$2 = SpillingKt.nullOutSpilledVariable(catalogId2);
                    c00222.I$0 = page5;
                    c00222.label = 2;
                    catalog = TorraStreamKitsuHelper.INSTANCE.getCatalog($this2, catalogId2, page5, c00222);
                    if (catalog == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        Pair pair2 = (Pair) catalog;
                        List items2 = (List) pair2.component1();
                        hasNext = ((Boolean) pair2.component2()).booleanValue();
                        String name2 = request3.getName();
                        if (hasNext) {
                            z2 = false;
                        }
                        return MainAPIKt.newHomePageResponse(name2, items2, Boxing.boxBoolean(z2));
                    } catch (Throwable th3) {
                        th = th3;
                        if (Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "kitsu")) {
                            return MainAPIKt.newHomePageResponse(request3.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                        }
                        c00222.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                        c00222.L$1 = request3;
                        c00222.L$2 = SpillingKt.nullOutSpilledVariable(th);
                        c00222.I$0 = page5;
                        c00222.label = 3;
                        searchResponseList2 = $this2.toSearchResponseList(request3, page5, c00222);
                        if (searchResponseList2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i = page5;
                        th = th;
                        page3 = i;
                        Pair data2 = (Pair) searchResponseList2;
                        return MainAPIKt.newHomePageResponse(request3.getName(), (List) data2.getFirst(), (Boolean) data2.getSecond());
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "kitsu")) {
                        return MainAPIKt.newHomePageResponse(request3.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                    }
                    c00222.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00222.L$1 = request3;
                    c00222.L$2 = SpillingKt.nullOutSpilledVariable(th);
                    c00222.I$0 = page5;
                    c00222.label = 3;
                    searchResponseList2 = $this2.toSearchResponseList(request3, page5, c00222);
                    if (searchResponseList2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i2 = page5;
                    th = th;
                    page3 = i2;
                    Pair data3 = (Pair) searchResponseList2;
                    return MainAPIKt.newHomePageResponse(request3.getName(), (List) data3.getFirst(), (Boolean) data3.getSecond());
                }
            case 1:
                page2 = c00222.I$0;
                request2 = (MainPageRequest) c00222.L$1;
                ResultKt.throwOnFailure($result);
                obj = ((Result) $result).unbox-impl();
                ResultKt.throwOnFailure(obj);
                Intrinsics.checkNotNull(obj);
                Iterable $this$mapNotNull$iv2 = ((SyncAPI.LibraryMetadata) obj).getAllLibraryLists();
                destination$iv$iv = new ArrayList();
                while (r15.hasNext()) {
                    it = (SyncAPI.LibraryList) element$iv$iv$iv;
                    if (it.getItems().isEmpty()) {
                        homePageList = homePageList2;
                    } else {
                        name = it.getName();
                        activity = CommonActivity.INSTANCE.getActivity();
                        if (activity == null) {
                            homePageList = null;
                        } else {
                            String libraryName2 = name.asString(activity);
                            homePageList = new HomePageList(request2.getName() + ": " + libraryName2, it.getItems(), false, 4, (DefaultConstructorMarker) null);
                        }
                    }
                    if (homePageList != null) {
                        destination$iv$iv.add(homePageList);
                    }
                    homePageList2 = null;
                    page2 = page2;
                }
                List homePageList4 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(homePageList4, Boxing.boxBoolean(false));
            case 2:
                page5 = c00222.I$0;
                request3 = (MainPageRequest) c00222.L$1;
                $this2 = (TorraStreamAnime) c00222.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    catalog = $result;
                    z = false;
                    Pair pair3 = (Pair) catalog;
                    List items3 = (List) pair3.component1();
                    hasNext = ((Boolean) pair3.component2()).booleanValue();
                    String name3 = request3.getName();
                    if (hasNext) {
                        z2 = false;
                    }
                    return MainAPIKt.newHomePageResponse(name3, items3, Boxing.boxBoolean(z2));
                } catch (Throwable th5) {
                    th = th5;
                    z = false;
                    if (Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "kitsu")) {
                        return MainAPIKt.newHomePageResponse(request3.getName(), CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                    }
                    c00222.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00222.L$1 = request3;
                    c00222.L$2 = SpillingKt.nullOutSpilledVariable(th);
                    c00222.I$0 = page5;
                    c00222.label = 3;
                    searchResponseList2 = $this2.toSearchResponseList(request3, page5, c00222);
                    if (searchResponseList2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i3 = page5;
                    th = th;
                    page3 = i3;
                    Pair data4 = (Pair) searchResponseList2;
                    return MainAPIKt.newHomePageResponse(request3.getName(), (List) data4.getFirst(), (Boolean) data4.getSecond());
                }
            case 3:
                page3 = c00222.I$0;
                th = (Throwable) c00222.L$2;
                request3 = (MainPageRequest) c00222.L$1;
                ResultKt.throwOnFailure($result);
                searchResponseList2 = $result;
                Pair data5 = (Pair) searchResponseList2;
                return MainAPIKt.newHomePageResponse(request3.getName(), (List) data5.getFirst(), (Boolean) data5.getSecond());
            case 4:
                page5 = c00222.I$0;
                request3 = (MainPageRequest) c00222.L$1;
                $this2 = (TorraStreamAnime) c00222.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    searchResponseList = $result;
                    Pair data6 = (Pair) searchResponseList;
                    return MainAPIKt.newHomePageResponse(request3.getName(), (List) data6.getFirst(), (Boolean) data6.getSecond());
                } catch (Throwable th6) {
                    e = th6;
                    if (!Intrinsics.areEqual($this2.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                        throw e;
                    }
                    $this2.isAnilistDown = true;
                    String catalogId3 = TorraStreamKitsuHelper.INSTANCE.mapSectionToKitsuCatalog(request3.getName());
                    c00222.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00222.L$1 = request3;
                    c00222.L$2 = SpillingKt.nullOutSpilledVariable(e);
                    c00222.L$3 = SpillingKt.nullOutSpilledVariable(catalogId3);
                    c00222.I$0 = page5;
                    c00222.label = 5;
                    catalog2 = TorraStreamKitsuHelper.INSTANCE.getCatalog($this2, catalogId3, page5, c00222);
                    if (catalog2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    page4 = page5;
                    Pair pair4 = (Pair) catalog2;
                    List items4 = (List) pair4.component1();
                    boolean hasNext3 = ((Boolean) pair4.component2()).booleanValue();
                    return MainAPIKt.newHomePageResponse(request3.getName(), items4, Boxing.boxBoolean(hasNext3));
                }
            case 5:
                page4 = c00222.I$0;
                request3 = (MainPageRequest) c00222.L$1;
                ResultKt.throwOnFailure($result);
                catalog2 = $result;
                Pair pair5 = (Pair) catalog2;
                List items5 = (List) pair5.component1();
                boolean hasNext4 = ((Boolean) pair5.component2()).booleanValue();
                return MainAPIKt.newHomePageResponse(request3.getName(), items5, Boxing.boxBoolean(hasNext4));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:45:0x0118 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0119  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:62:0x014f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0174 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0175  */
    /* JADX WARN: Code duplicated, block: B:68:0x017e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object load$suspendImpl(TorraStreamAnime $this, String url, Continuation<? super LoadResponse> continuation) throws Exception {
        C00231 c00231;
        String id;
        int i;
        Object objLoadFromKitsu;
        String id2;
        int i2;
        Object objLoadFromAnilist;
        String id3;
        int i3;
        Object objLoadFromAnilist2;
        String id4;
        int i4;
        Object objLoadFromKitsu2;
        String id5;
        int i5;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = $this.new C00231(continuation);
            }
        } else {
            c00231 = $this.new C00231(continuation);
        }
        Object $result = c00231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00231.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = StringsKt.substringAfterLast$default(StringsKt.removeSuffix(url, "/"), "/", (String) null, 2, (Object) null);
                i = (StringsKt.contains$default(url, "kitsu", false, 2, (Object) null) || StringsKt.startsWith$default(id, "kitsu:", false, 2, (Object) null) || $this.shouldUseKitsu()) ? 1 : 0;
                if (i != 0) {
                    try {
                        c00231.L$0 = $this;
                        c00231.L$1 = url;
                        c00231.L$2 = id;
                        c00231.I$0 = i;
                        c00231.label = 1;
                        objLoadFromKitsu = $this.loadFromKitsu(url, id, c00231);
                        if (objLoadFromKitsu == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        id2 = id;
                        i2 = i;
                        try {
                            return (LoadResponse) objLoadFromKitsu;
                        } catch (Throwable th) {
                            i = i2;
                            id = id2;
                            e = th;
                            if (Intrinsics.areEqual($this.sharedPref.getString("anime_metadata_source", "kitsu"), "kitsu")) {
                                throw e;
                            }
                            c00231.L$0 = SpillingKt.nullOutSpilledVariable($this);
                            c00231.L$1 = SpillingKt.nullOutSpilledVariable(url);
                            c00231.L$2 = SpillingKt.nullOutSpilledVariable(id);
                            c00231.L$3 = SpillingKt.nullOutSpilledVariable(e);
                            c00231.I$0 = i;
                            c00231.label = 2;
                            objLoadFromAnilist2 = $this.loadFromAnilist(url, id, c00231);
                            if (objLoadFromAnilist2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            id4 = id;
                            i4 = i;
                            return (LoadResponse) objLoadFromAnilist2;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (Intrinsics.areEqual($this.sharedPref.getString("anime_metadata_source", "kitsu"), "kitsu")) {
                            throw e;
                        }
                        c00231.L$0 = SpillingKt.nullOutSpilledVariable($this);
                        c00231.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        c00231.L$2 = SpillingKt.nullOutSpilledVariable(id);
                        c00231.L$3 = SpillingKt.nullOutSpilledVariable(e);
                        c00231.I$0 = i;
                        c00231.label = 2;
                        objLoadFromAnilist2 = $this.loadFromAnilist(url, id, c00231);
                        if (objLoadFromAnilist2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        id4 = id;
                        i4 = i;
                        return (LoadResponse) objLoadFromAnilist2;
                    }
                }
                try {
                    c00231.L$0 = $this;
                    c00231.L$1 = url;
                    c00231.L$2 = id;
                    c00231.I$0 = i;
                    c00231.label = 3;
                    objLoadFromAnilist = $this.loadFromAnilist(url, id, c00231);
                    if (objLoadFromAnilist == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id3 = id;
                    i3 = i;
                    try {
                        return (LoadResponse) objLoadFromAnilist;
                    } catch (Throwable th3) {
                        i = i3;
                        id = id3;
                        e = th3;
                        if (Intrinsics.areEqual($this.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                            throw e;
                        }
                        $this.isAnilistDown = true;
                        c00231.L$0 = SpillingKt.nullOutSpilledVariable($this);
                        c00231.L$1 = SpillingKt.nullOutSpilledVariable(url);
                        c00231.L$2 = SpillingKt.nullOutSpilledVariable(id);
                        c00231.L$3 = SpillingKt.nullOutSpilledVariable(e);
                        c00231.I$0 = i;
                        c00231.label = 4;
                        objLoadFromKitsu2 = $this.loadFromKitsu(url, id, c00231);
                        if (objLoadFromKitsu2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        id5 = id;
                        i5 = i;
                        return (LoadResponse) objLoadFromKitsu2;
                    }
                } catch (Throwable th4) {
                    e = th4;
                    if (Intrinsics.areEqual($this.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                        throw e;
                    }
                    $this.isAnilistDown = true;
                    c00231.L$0 = SpillingKt.nullOutSpilledVariable($this);
                    c00231.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00231.L$2 = SpillingKt.nullOutSpilledVariable(id);
                    c00231.L$3 = SpillingKt.nullOutSpilledVariable(e);
                    c00231.I$0 = i;
                    c00231.label = 4;
                    objLoadFromKitsu2 = $this.loadFromKitsu(url, id, c00231);
                    if (objLoadFromKitsu2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id5 = id;
                    i5 = i;
                    return (LoadResponse) objLoadFromKitsu2;
                }
            case 1:
                i2 = c00231.I$0;
                String id6 = (String) c00231.L$2;
                url = (String) c00231.L$1;
                $this = (TorraStreamAnime) c00231.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    id2 = id6;
                    objLoadFromKitsu = $result;
                    return (LoadResponse) objLoadFromKitsu;
                } catch (Throwable th5) {
                    e = th5;
                    i = i2;
                    id = id6;
                    if (Intrinsics.areEqual($this.sharedPref.getString("anime_metadata_source", "kitsu"), "kitsu")) {
                        throw e;
                    }
                    c00231.L$0 = SpillingKt.nullOutSpilledVariable($this);
                    c00231.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00231.L$2 = SpillingKt.nullOutSpilledVariable(id);
                    c00231.L$3 = SpillingKt.nullOutSpilledVariable(e);
                    c00231.I$0 = i;
                    c00231.label = 2;
                    objLoadFromAnilist2 = $this.loadFromAnilist(url, id, c00231);
                    if (objLoadFromAnilist2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id4 = id;
                    i4 = i;
                    return (LoadResponse) objLoadFromAnilist2;
                }
            case 2:
                i4 = c00231.I$0;
                String id7 = (String) c00231.L$2;
                ResultKt.throwOnFailure($result);
                id4 = id7;
                objLoadFromAnilist2 = $result;
                return (LoadResponse) objLoadFromAnilist2;
            case 3:
                i3 = c00231.I$0;
                String id8 = (String) c00231.L$2;
                url = (String) c00231.L$1;
                $this = (TorraStreamAnime) c00231.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    id3 = id8;
                    objLoadFromAnilist = $result;
                    return (LoadResponse) objLoadFromAnilist;
                } catch (Throwable th6) {
                    e = th6;
                    i = i3;
                    id = id8;
                    if (Intrinsics.areEqual($this.sharedPref.getString("anime_metadata_source", "kitsu"), "anilist")) {
                        throw e;
                    }
                    $this.isAnilistDown = true;
                    c00231.L$0 = SpillingKt.nullOutSpilledVariable($this);
                    c00231.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00231.L$2 = SpillingKt.nullOutSpilledVariable(id);
                    c00231.L$3 = SpillingKt.nullOutSpilledVariable(e);
                    c00231.I$0 = i;
                    c00231.label = 4;
                    objLoadFromKitsu2 = $this.loadFromKitsu(url, id, c00231);
                    if (objLoadFromKitsu2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    id5 = id;
                    i5 = i;
                    return (LoadResponse) objLoadFromKitsu2;
                }
            case 4:
                i5 = c00231.I$0;
                String id9 = (String) c00231.L$2;
                ResultKt.throwOnFailure($result);
                id5 = id9;
                objLoadFromKitsu2 = $result;
                return (LoadResponse) objLoadFromKitsu2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x018f  */
    /* JADX WARN: Code duplicated, block: B:25:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:26:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:29:0x01d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:33:0x026f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0270  */
    /* JADX WARN: Code duplicated, block: B:37:0x028b  */
    /* JADX WARN: Code duplicated, block: B:50:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:54:0x02d3 A[Catch: all -> 0x02f2, TRY_LEAVE, TryCatch #0 {all -> 0x02f2, blocks: (B:52:0x02c6, B:54:0x02d3), top: B:84:0x02c6 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:58:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:68:0x0379 A[LOOP:1: B:66:0x0373->B:68:0x0379, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x0456 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x0457  */
    /* JADX WARN: Code duplicated, block: B:76:0x046f  */
    /* JADX WARN: Code duplicated, block: B:78:0x050e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x050f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x053b  */
    public final Object loadFromAnilist(String url, String id, Continuation<? super LoadResponse> continuation) throws Exception {
        C00241 c00241;
        Object obj;
        String url2;
        AnilistAPIResponse.anilistMedia data;
        String anititle;
        int aniyear;
        String format;
        TvType anitype;
        Object objTmdbToAnimeId;
        String url3;
        int aniyear2;
        AnilistAPIResponse.anilistMedia data2;
        TvType anitype2;
        AniIds ids;
        String posterurl;
        String backgroundUrl;
        String jpTitle;
        TvType anitype3;
        String url4;
        Object obj2;
        C00241 c00242;
        TvType anitype4;
        String id2;
        AniIds ids2;
        String posterurl2;
        String anititle2;
        AnilistAPIResponse.anilistMedia data3;
        Object obj3;
        String backgroundUrl2;
        String jpTitle2;
        int aniyear3;
        String syncMetaData;
        MetaAnimeData animeMetaData;
        String logoposter;
        Integer kitsuId;
        String href;
        Collection destination$iv$iv;
        IntIterator it;
        String href2;
        String url5;
        AniIds ids3;
        Object obj4;
        List episodes;
        String backgroundUrl3;
        String posterurl3;
        int aniyear4;
        Object objNewAnimeLoadResponse$default;
        Object obj5;
        AniIds ids4;
        AnilistAPIResponse.anilistMedia data4;
        MetaAnimeData animeMetaData2;
        String posterurl4;
        TvType anitype5;
        String syncMetaData2;
        String href3;
        String backgroundUrl4;
        Integer kitsuId2;
        List episodes2;
        int aniyear5;
        String logoposter2;
        Object objNewMovieLoadResponse;
        Object obj6;
        JSONObject mappings;
        Integer numBoxInt;
        int it2;
        boolean z;
        List<ImageData> images;
        Object next;
        TorraStreamAnime torraStreamAnime = this;
        String id3 = id;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & Integer.MIN_VALUE) != 0) {
                c00241.label -= Integer.MIN_VALUE;
            } else {
                c00241 = torraStreamAnime.new C00241(continuation);
            }
        } else {
            c00241 = torraStreamAnime.new C00241(continuation);
        }
        C00241 c00243 = c00241;
        Object $result = c00243.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00243.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00243.L$0 = url;
                c00243.L$1 = id3;
                c00243.label = 1;
                Object objAnilistAPICall = torraStreamAnime.anilistAPICall("query ($id: Int = " + id3 + ") { Media(id: $id, type: ANIME) { id title { romaji english } startDate { year } genres description averageScore status bannerImage coverImage { extraLarge large medium } bannerImage episodes format nextAiringEpisode { episode } airingSchedule { nodes { episode } } recommendations { edges { node { id mediaRecommendation { id title { romaji english } coverImage { extraLarge large medium } } } } } } }", c00243);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAnilistAPICall;
                url2 = url;
                data = ((AnilistAPIResponse) obj).getData().getMedia();
                if (data != null) {
                    throw new Exception("Unable to fetch media details");
                }
                anititle = data.m16getTitle();
                aniyear = data.getStartDate().getYear();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt2 = Boxing.boxInt(aniyear);
                c00243.L$0 = url2;
                c00243.L$1 = id3;
                c00243.L$2 = data;
                c00243.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00243.L$4 = SpillingKt.nullOutSpilledVariable(anitype);
                c00243.I$0 = aniyear;
                c00243.label = 2;
                objTmdbToAnimeId = torraStreamAnime.tmdbToAnimeId(anititle, numBoxInt2, anitype, c00243);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TvType tvType = anitype;
                url3 = url2;
                aniyear2 = aniyear;
                data2 = data;
                anitype2 = tvType;
                ids = (AniIds) objTmdbToAnimeId;
                posterurl = data2.getCoverImage().getExtraLarge();
                backgroundUrl = data2.getBannerImage();
                jpTitle = data2.getTitle().getRomaji();
                anitype3 = anitype2;
                c00243.L$0 = url3;
                c00243.L$1 = id3;
                c00243.L$2 = data2;
                c00243.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00243.L$4 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00243.L$5 = ids;
                c00243.L$6 = posterurl;
                c00243.L$7 = backgroundUrl;
                c00243.L$8 = jpTitle;
                c00243.I$0 = aniyear2;
                c00243.label = 3;
                url4 = url3;
                obj2 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + id3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00243, 4094, (Object) null);
                c00242 = c00243;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype4 = anitype3;
                id2 = id3;
                ids2 = ids;
                posterurl2 = posterurl;
                anititle2 = anititle;
                data3 = data2;
                obj3 = obj2;
                backgroundUrl2 = backgroundUrl;
                jpTitle2 = jpTitle;
                aniyear3 = aniyear2;
                syncMetaData = ((NiceResponse) obj3).getText();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null || (images = animeMetaData.getImages()) == null) {
                    logoposter = null;
                } else {
                    Iterator it3 = images.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next = it3.next();
                            ImageData it4 = (ImageData) next;
                            Iterator it5 = it3;
                            if (!Intrinsics.areEqual(it4.getCoverType(), "Clearlogo")) {
                                it3 = it5;
                            }
                        } else {
                            next = null;
                        }
                    }
                    ImageData imageData = (ImageData) next;
                    if (imageData != null) {
                        logoposter = imageData.getUrl();
                    } else {
                        logoposter = null;
                    }
                }
                try {
                    mappings = new JSONObject(syncMetaData).optJSONObject("mappings");
                    if (mappings != null) {
                        numBoxInt = Boxing.boxInt(mappings.optInt("kitsu_id", -1));
                        it2 = numBoxInt.intValue();
                        if (it2 != -1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            numBoxInt = null;
                        }
                    } else {
                        numBoxInt = null;
                    }
                    kitsuId = numBoxInt;
                } catch (Throwable th) {
                    kitsuId = null;
                }
                href = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m16getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, kitsuId, 16634111, null));
                Iterable $this$map$iv = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it = $this$map$iv.iterator();
                while (it.hasNext()) {
                    int item$iv$iv = it.nextInt();
                    AniIds ids5 = ids2;
                    String href4 = href;
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(loadFromAnilist$createEpisode(animeMetaData, torraStreamAnime, ids5, data3, jpTitle2, kitsuId, item$iv$iv));
                    url4 = url4;
                    destination$iv$iv = destination$iv$iv2;
                    coroutine_suspended = coroutine_suspended;
                    href = href4;
                    ids2 = ids5;
                    torraStreamAnime = this;
                }
                href2 = href;
                url5 = url4;
                ids3 = ids2;
                obj4 = coroutine_suspended;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM16getTitle = data3.m16getTitle();
                    TvType tvType2 = TvType.AnimeMovie;
                    AnilistAPIResponse.anilistMedia data5 = data3;
                    C00252 c00252 = new C00252(id2, ids3, data5, backgroundUrl2, animeMetaData, posterurl2, logoposter, null);
                    c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00242.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                    c00242.L$2 = SpillingKt.nullOutSpilledVariable(data5);
                    c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                    c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                    c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                    c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                    c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                    c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00242.I$0 = aniyear3;
                    c00242.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM16getTitle, url5, tvType2, href2, c00252, c00242);
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    obj6 = objNewMovieLoadResponse;
                    return (LoadResponse) obj6;
                }
                backgroundUrl3 = backgroundUrl2;
                posterurl3 = posterurl2;
                String strM16getTitle2 = data3.m16getTitle();
                String id4 = id2;
                TvType tvType3 = TvType.Anime;
                C00263 c00263 = new C00263(id4, ids3, episodes, data3, animeMetaData, logoposter, this, null);
                c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00242.L$1 = SpillingKt.nullOutSpilledVariable(id4);
                c00242.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                c00242.I$0 = aniyear3;
                c00242.label = 5;
                aniyear4 = aniyear3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM16getTitle2, url5, tvType3, false, c00263, c00242, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                obj5 = objNewAnimeLoadResponse$default;
                ids4 = ids3;
                data4 = data3;
                animeMetaData2 = animeMetaData;
                posterurl4 = posterurl3;
                anitype5 = anitype4;
                syncMetaData2 = syncMetaData;
                href3 = href2;
                backgroundUrl4 = backgroundUrl3;
                kitsuId2 = kitsuId;
                episodes2 = episodes;
                aniyear5 = aniyear4;
                logoposter2 = logoposter;
                return (LoadResponse) obj5;
            case 1:
                id3 = (String) c00243.L$1;
                url2 = (String) c00243.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                data = ((AnilistAPIResponse) obj).getData().getMedia();
                if (data != null) {
                    throw new Exception("Unable to fetch media details");
                }
                anititle = data.m16getTitle();
                aniyear = data.getStartDate().getYear();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt3 = Boxing.boxInt(aniyear);
                c00243.L$0 = url2;
                c00243.L$1 = id3;
                c00243.L$2 = data;
                c00243.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00243.L$4 = SpillingKt.nullOutSpilledVariable(anitype);
                c00243.I$0 = aniyear;
                c00243.label = 2;
                objTmdbToAnimeId = torraStreamAnime.tmdbToAnimeId(anititle, numBoxInt3, anitype, c00243);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TvType tvType4 = anitype;
                url3 = url2;
                aniyear2 = aniyear;
                data2 = data;
                anitype2 = tvType4;
                ids = (AniIds) objTmdbToAnimeId;
                posterurl = data2.getCoverImage().getExtraLarge();
                backgroundUrl = data2.getBannerImage();
                jpTitle = data2.getTitle().getRomaji();
                anitype3 = anitype2;
                c00243.L$0 = url3;
                c00243.L$1 = id3;
                c00243.L$2 = data2;
                c00243.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00243.L$4 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00243.L$5 = ids;
                c00243.L$6 = posterurl;
                c00243.L$7 = backgroundUrl;
                c00243.L$8 = jpTitle;
                c00243.I$0 = aniyear2;
                c00243.label = 3;
                url4 = url3;
                obj2 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + id3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00243, 4094, (Object) null);
                c00242 = c00243;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype4 = anitype3;
                id2 = id3;
                ids2 = ids;
                posterurl2 = posterurl;
                anititle2 = anititle;
                data3 = data2;
                obj3 = obj2;
                backgroundUrl2 = backgroundUrl;
                jpTitle2 = jpTitle;
                aniyear3 = aniyear2;
                syncMetaData = ((NiceResponse) obj3).getText();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    logoposter = null;
                } else {
                    logoposter = null;
                }
                mappings = new JSONObject(syncMetaData).optJSONObject("mappings");
                if (mappings != null) {
                    numBoxInt = Boxing.boxInt(mappings.optInt("kitsu_id", -1));
                    it2 = numBoxInt.intValue();
                    if (it2 != -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        numBoxInt = null;
                    }
                } else {
                    numBoxInt = null;
                }
                kitsuId = numBoxInt;
                href = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m16getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, kitsuId, 16634111, null));
                Iterable $this$map$iv2 = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                it = $this$map$iv2.iterator();
                while (it.hasNext()) {
                    int item$iv$iv2 = it.nextInt();
                    AniIds ids6 = ids2;
                    String href5 = href;
                    Collection destination$iv$iv3 = destination$iv$iv;
                    destination$iv$iv3.add(loadFromAnilist$createEpisode(animeMetaData, torraStreamAnime, ids6, data3, jpTitle2, kitsuId, item$iv$iv2));
                    url4 = url4;
                    destination$iv$iv = destination$iv$iv3;
                    coroutine_suspended = coroutine_suspended;
                    href = href5;
                    ids2 = ids6;
                    torraStreamAnime = this;
                }
                href2 = href;
                url5 = url4;
                ids3 = ids2;
                obj4 = coroutine_suspended;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM16getTitle3 = data3.m16getTitle();
                    TvType tvType5 = TvType.AnimeMovie;
                    AnilistAPIResponse.anilistMedia data6 = data3;
                    C00252 c00253 = new C00252(id2, ids3, data6, backgroundUrl2, animeMetaData, posterurl2, logoposter, null);
                    c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00242.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                    c00242.L$2 = SpillingKt.nullOutSpilledVariable(data6);
                    c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                    c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                    c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                    c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                    c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                    c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00242.I$0 = aniyear3;
                    c00242.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM16getTitle3, url5, tvType5, href2, c00253, c00242);
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    obj6 = objNewMovieLoadResponse;
                    return (LoadResponse) obj6;
                }
                backgroundUrl3 = backgroundUrl2;
                posterurl3 = posterurl2;
                String strM16getTitle4 = data3.m16getTitle();
                String id5 = id2;
                TvType tvType6 = TvType.Anime;
                C00263 c00264 = new C00263(id5, ids3, episodes, data3, animeMetaData, logoposter, this, null);
                c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00242.L$1 = SpillingKt.nullOutSpilledVariable(id5);
                c00242.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                c00242.I$0 = aniyear3;
                c00242.label = 5;
                aniyear4 = aniyear3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM16getTitle4, url5, tvType6, false, c00264, c00242, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                obj5 = objNewAnimeLoadResponse$default;
                ids4 = ids3;
                data4 = data3;
                animeMetaData2 = animeMetaData;
                posterurl4 = posterurl3;
                anitype5 = anitype4;
                syncMetaData2 = syncMetaData;
                href3 = href2;
                backgroundUrl4 = backgroundUrl3;
                kitsuId2 = kitsuId;
                episodes2 = episodes;
                aniyear5 = aniyear4;
                logoposter2 = logoposter;
                return (LoadResponse) obj5;
            case 2:
                aniyear2 = c00243.I$0;
                anitype2 = (TvType) c00243.L$4;
                anititle = (String) c00243.L$3;
                data2 = (AnilistAPIResponse.anilistMedia) c00243.L$2;
                id3 = (String) c00243.L$1;
                url3 = (String) c00243.L$0;
                ResultKt.throwOnFailure($result);
                objTmdbToAnimeId = $result;
                ids = (AniIds) objTmdbToAnimeId;
                posterurl = data2.getCoverImage().getExtraLarge();
                backgroundUrl = data2.getBannerImage();
                jpTitle = data2.getTitle().getRomaji();
                anitype3 = anitype2;
                c00243.L$0 = url3;
                c00243.L$1 = id3;
                c00243.L$2 = data2;
                c00243.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00243.L$4 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00243.L$5 = ids;
                c00243.L$6 = posterurl;
                c00243.L$7 = backgroundUrl;
                c00243.L$8 = jpTitle;
                c00243.I$0 = aniyear2;
                c00243.label = 3;
                url4 = url3;
                obj2 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + id3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00243, 4094, (Object) null);
                c00242 = c00243;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype4 = anitype3;
                id2 = id3;
                ids2 = ids;
                posterurl2 = posterurl;
                anititle2 = anititle;
                data3 = data2;
                obj3 = obj2;
                backgroundUrl2 = backgroundUrl;
                jpTitle2 = jpTitle;
                aniyear3 = aniyear2;
                syncMetaData = ((NiceResponse) obj3).getText();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    logoposter = null;
                } else {
                    logoposter = null;
                }
                mappings = new JSONObject(syncMetaData).optJSONObject("mappings");
                if (mappings != null) {
                    numBoxInt = Boxing.boxInt(mappings.optInt("kitsu_id", -1));
                    it2 = numBoxInt.intValue();
                    if (it2 != -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        numBoxInt = null;
                    }
                } else {
                    numBoxInt = null;
                }
                kitsuId = numBoxInt;
                href = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m16getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, kitsuId, 16634111, null));
                Iterable $this$map$iv3 = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                it = $this$map$iv3.iterator();
                while (it.hasNext()) {
                    int item$iv$iv3 = it.nextInt();
                    AniIds ids7 = ids2;
                    String href6 = href;
                    Collection destination$iv$iv4 = destination$iv$iv;
                    destination$iv$iv4.add(loadFromAnilist$createEpisode(animeMetaData, torraStreamAnime, ids7, data3, jpTitle2, kitsuId, item$iv$iv3));
                    url4 = url4;
                    destination$iv$iv = destination$iv$iv4;
                    coroutine_suspended = coroutine_suspended;
                    href = href6;
                    ids2 = ids7;
                    torraStreamAnime = this;
                }
                href2 = href;
                url5 = url4;
                ids3 = ids2;
                obj4 = coroutine_suspended;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM16getTitle5 = data3.m16getTitle();
                    TvType tvType7 = TvType.AnimeMovie;
                    AnilistAPIResponse.anilistMedia data7 = data3;
                    C00252 c00254 = new C00252(id2, ids3, data7, backgroundUrl2, animeMetaData, posterurl2, logoposter, null);
                    c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00242.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                    c00242.L$2 = SpillingKt.nullOutSpilledVariable(data7);
                    c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                    c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                    c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                    c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                    c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                    c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00242.I$0 = aniyear3;
                    c00242.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM16getTitle5, url5, tvType7, href2, c00254, c00242);
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    obj6 = objNewMovieLoadResponse;
                    return (LoadResponse) obj6;
                }
                backgroundUrl3 = backgroundUrl2;
                posterurl3 = posterurl2;
                String strM16getTitle6 = data3.m16getTitle();
                String id6 = id2;
                TvType tvType8 = TvType.Anime;
                C00263 c00265 = new C00263(id6, ids3, episodes, data3, animeMetaData, logoposter, this, null);
                c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00242.L$1 = SpillingKt.nullOutSpilledVariable(id6);
                c00242.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                c00242.I$0 = aniyear3;
                c00242.label = 5;
                aniyear4 = aniyear3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM16getTitle6, url5, tvType8, false, c00265, c00242, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                obj5 = objNewAnimeLoadResponse$default;
                ids4 = ids3;
                data4 = data3;
                animeMetaData2 = animeMetaData;
                posterurl4 = posterurl3;
                anitype5 = anitype4;
                syncMetaData2 = syncMetaData;
                href3 = href2;
                backgroundUrl4 = backgroundUrl3;
                kitsuId2 = kitsuId;
                episodes2 = episodes;
                aniyear5 = aniyear4;
                logoposter2 = logoposter;
                return (LoadResponse) obj5;
            case 3:
                int aniyear6 = c00243.I$0;
                String jpTitle3 = (String) c00243.L$8;
                String backgroundUrl5 = (String) c00243.L$7;
                String posterurl5 = (String) c00243.L$6;
                AniIds ids8 = (AniIds) c00243.L$5;
                TvType anitype6 = (TvType) c00243.L$4;
                String anititle3 = (String) c00243.L$3;
                AnilistAPIResponse.anilistMedia data8 = (AnilistAPIResponse.anilistMedia) c00243.L$2;
                String id7 = (String) c00243.L$1;
                String url6 = (String) c00243.L$0;
                ResultKt.throwOnFailure($result);
                jpTitle2 = jpTitle3;
                backgroundUrl2 = backgroundUrl5;
                posterurl2 = posterurl5;
                anitype4 = anitype6;
                anititle2 = anititle3;
                data3 = data8;
                id2 = id7;
                c00242 = c00243;
                url4 = url6;
                obj3 = $result;
                ids2 = ids8;
                aniyear3 = aniyear6;
                syncMetaData = ((NiceResponse) obj3).getText();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    logoposter = null;
                } else {
                    logoposter = null;
                }
                mappings = new JSONObject(syncMetaData).optJSONObject("mappings");
                if (mappings != null) {
                    numBoxInt = Boxing.boxInt(mappings.optInt("kitsu_id", -1));
                    it2 = numBoxInt.intValue();
                    if (it2 != -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        numBoxInt = null;
                    }
                } else {
                    numBoxInt = null;
                }
                kitsuId = numBoxInt;
                href = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m16getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, kitsuId, 16634111, null));
                Iterable $this$map$iv4 = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                it = $this$map$iv4.iterator();
                while (it.hasNext()) {
                    int item$iv$iv4 = it.nextInt();
                    AniIds ids9 = ids2;
                    String href7 = href;
                    Collection destination$iv$iv5 = destination$iv$iv;
                    destination$iv$iv5.add(loadFromAnilist$createEpisode(animeMetaData, torraStreamAnime, ids9, data3, jpTitle2, kitsuId, item$iv$iv4));
                    url4 = url4;
                    destination$iv$iv = destination$iv$iv5;
                    coroutine_suspended = coroutine_suspended;
                    href = href7;
                    ids2 = ids9;
                    torraStreamAnime = this;
                }
                href2 = href;
                url5 = url4;
                ids3 = ids2;
                obj4 = coroutine_suspended;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM16getTitle7 = data3.m16getTitle();
                    TvType tvType9 = TvType.AnimeMovie;
                    AnilistAPIResponse.anilistMedia data9 = data3;
                    C00252 c00255 = new C00252(id2, ids3, data9, backgroundUrl2, animeMetaData, posterurl2, logoposter, null);
                    c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00242.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                    c00242.L$2 = SpillingKt.nullOutSpilledVariable(data9);
                    c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                    c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                    c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                    c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                    c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                    c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00242.I$0 = aniyear3;
                    c00242.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM16getTitle7, url5, tvType9, href2, c00255, c00242);
                    if (objNewMovieLoadResponse == obj4) {
                        return obj4;
                    }
                    obj6 = objNewMovieLoadResponse;
                    return (LoadResponse) obj6;
                }
                backgroundUrl3 = backgroundUrl2;
                posterurl3 = posterurl2;
                String strM16getTitle8 = data3.m16getTitle();
                String id8 = id2;
                TvType tvType10 = TvType.Anime;
                C00263 c00266 = new C00263(id8, ids3, episodes, data3, animeMetaData, logoposter, this, null);
                c00242.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00242.L$1 = SpillingKt.nullOutSpilledVariable(id8);
                c00242.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00242.L$3 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00242.L$4 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00242.L$5 = SpillingKt.nullOutSpilledVariable(ids3);
                c00242.L$6 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00242.L$7 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00242.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00242.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00242.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                c00242.L$11 = SpillingKt.nullOutSpilledVariable(logoposter);
                c00242.L$12 = SpillingKt.nullOutSpilledVariable(kitsuId);
                c00242.L$13 = SpillingKt.nullOutSpilledVariable(href2);
                c00242.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                c00242.I$0 = aniyear3;
                c00242.label = 5;
                aniyear4 = aniyear3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM16getTitle8, url5, tvType10, false, c00266, c00242, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                obj5 = objNewAnimeLoadResponse$default;
                ids4 = ids3;
                data4 = data3;
                animeMetaData2 = animeMetaData;
                posterurl4 = posterurl3;
                anitype5 = anitype4;
                syncMetaData2 = syncMetaData;
                href3 = href2;
                backgroundUrl4 = backgroundUrl3;
                kitsuId2 = kitsuId;
                episodes2 = episodes;
                aniyear5 = aniyear4;
                logoposter2 = logoposter;
                return (LoadResponse) obj5;
            case 4:
                int i = c00243.I$0;
                ResultKt.throwOnFailure($result);
                c00242 = c00243;
                obj6 = $result;
                return (LoadResponse) obj6;
            case 5:
                aniyear5 = c00243.I$0;
                episodes2 = (List) c00243.L$14;
                href3 = (String) c00243.L$13;
                kitsuId2 = (Integer) c00243.L$12;
                logoposter2 = (String) c00243.L$11;
                animeMetaData2 = (MetaAnimeData) c00243.L$10;
                syncMetaData2 = (String) c00243.L$9;
                backgroundUrl4 = (String) c00243.L$7;
                posterurl4 = (String) c00243.L$6;
                ids4 = (AniIds) c00243.L$5;
                anitype5 = (TvType) c00243.L$4;
                data4 = (AnilistAPIResponse.anilistMedia) c00243.L$2;
                ResultKt.throwOnFailure($result);
                obj5 = $result;
                return (LoadResponse) obj5;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String loadFromAnilist$resolveTitle(MetaAnimeData animeMetaData, MetaEpisode epData) {
        String jsonTitle;
        Map<String, String> titles;
        Map<String, String> titles2;
        Map<String, String> titles3;
        Map<String, String> title;
        Map<String, String> title2;
        String episode;
        Map<String, String> title3;
        String str = "";
        if (epData == null || (title3 = epData.getTitle()) == null || (jsonTitle = title3.get("en")) == null) {
            String str2 = (epData == null || (title2 = epData.getTitle()) == null) ? null : title2.get("ja");
            if (str2 == null) {
                String str3 = (epData == null || (title = epData.getTitle()) == null) ? null : title.get("x-jat");
                if (str3 == null) {
                    String str4 = (animeMetaData == null || (titles3 = animeMetaData.getTitles()) == null) ? null : titles3.get("en");
                    if (str4 == null) {
                        jsonTitle = (animeMetaData == null || (titles2 = animeMetaData.getTitles()) == null) ? null : titles2.get("ja");
                        if (jsonTitle == null) {
                            jsonTitle = (animeMetaData == null || (titles = animeMetaData.getTitles()) == null) ? null : titles.get("x-jat");
                            if (jsonTitle == null) {
                                jsonTitle = "";
                            }
                        }
                    } else {
                        jsonTitle = str4;
                    }
                } else {
                    jsonTitle = str3;
                }
            } else {
                jsonTitle = str2;
            }
        }
        String string = jsonTitle;
        if (StringsKt.isBlank(string)) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            if (epData != null && (episode = epData.getEpisode()) != null) {
                str = episode;
            }
            string = sbAppend.append(str).toString();
        }
        return string;
    }

    private static final Episode loadFromAnilist$createEpisode(final MetaAnimeData animeMetaData, TorraStreamAnime this$0, AniIds ids, AnilistAPIResponse.anilistMedia data, String jpTitle, Integer kitsuId, final int i) {
        Map<String, MetaEpisode> episodes;
        final MetaEpisode epData = (animeMetaData == null || (episodes = animeMetaData.getEpisodes()) == null) ? null : episodes.get(String.valueOf(i));
        String linkData = this$0.toStringData(new LinkData(null, null, null, null, null, null, 1, Integer.valueOf(i), ids.getId(), ids.getIdMal(), data.m16getTitle(), Integer.valueOf(data.getStartDate().getYear()), null, true, null, null, null, jpTitle, null, null, false, false, false, false, kitsuId, 16633919, null));
        return MainAPIKt.newEpisode(this$0, linkData, new Function1() { // from class: com.phisher98.TorraStreamAnime$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TorraStreamAnime.loadFromAnilist$createEpisode$lambda$3(i, epData, animeMetaData, (Episode) obj);
            }
        });
    }

    static final Unit loadFromAnilist$createEpisode$lambda$3(int $i, MetaEpisode $epData, MetaAnimeData $animeMetaData, Episode $this$newEpisode) {
        String url;
        List<ImageData> images;
        ImageData imageData;
        String overview;
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($i));
        $this$newEpisode.setName(loadFromAnilist$resolveTitle($animeMetaData, $epData));
        if ($epData == null || (url = $epData.getImage()) == null) {
            url = ($animeMetaData == null || (images = $animeMetaData.getImages()) == null || (imageData = (ImageData) CollectionsKt.firstOrNull(images)) == null) ? null : imageData.getUrl();
            if (url == null) {
                url = "";
            }
        }
        $this$newEpisode.setPosterUrl(url);
        if ($epData == null || (overview = $epData.getOverview()) == null) {
            overview = "No summary available";
        }
        $this$newEpisode.setDescription(overview);
        $this$newEpisode.setScore(Score.Companion.from10($epData != null ? $epData.getRating() : null));
        $this$newEpisode.setRunTime($epData != null ? $epData.getRuntime() : null);
        MainAPIKt.addDate$default($this$newEpisode, $epData != null ? $epData.getAirDateUtc() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadFromAnilist$2 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadFromAnilist$2", f = "TorraStreamAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$loadFromAnilist$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,815:1\n296#2,2:816\n296#2,2:818\n*S KotlinDebug\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$loadFromAnilist$2\n*L\n302#1:816,2\n304#1:818,2\n*E\n"})
    static final class C00252 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ AnilistAPIResponse.anilistMedia $data;
        final /* synthetic */ String $id;
        final /* synthetic */ AniIds $ids;
        final /* synthetic */ String $logoposter;
        final /* synthetic */ String $posterurl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00252(String str, AniIds aniIds, AnilistAPIResponse.anilistMedia anilistmedia, String str2, MetaAnimeData metaAnimeData, String str3, String str4, Continuation<? super C00252> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$ids = aniIds;
            this.$data = anilistmedia;
            this.$backgroundUrl = str2;
            this.$animeMetaData = metaAnimeData;
            this.$posterurl = str3;
            this.$logoposter = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00252 = new C00252(this.$id, this.$ids, this.$data, this.$backgroundUrl, this.$animeMetaData, this.$posterurl, this.$logoposter, continuation);
            c00252.L$0 = obj;
            return c00252;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0087  */
        /* JADX WARN: Code duplicated, block: B:22:0x008c  */
        /* JADX WARN: Code duplicated, block: B:40:0x00d2  */
        public final Object invokeSuspend(Object $result) {
            Iterable images;
            Object element$iv;
            ImageData imageData;
            ImageData it;
            Iterable images2;
            Object element$iv2;
            ImageData imageData2;
            ImageData it2;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(Integer.parseInt(this.$id)));
                    LoadResponse.Companion.addMalId(loadResponse, this.$ids.getIdMal());
                    loadResponse.setYear(Boxing.boxInt(this.$data.getStartDate().getYear()));
                    loadResponse.setPlot(this.$data.getDescription());
                    String bannerImage = this.$backgroundUrl;
                    String url = null;
                    if (bannerImage == null) {
                        MetaAnimeData metaAnimeData = this.$animeMetaData;
                        if (metaAnimeData == null || (images2 = metaAnimeData.getImages()) == null) {
                            bannerImage = null;
                        } else {
                            Iterable $this$firstOrNull$iv = images2;
                            Iterator it3 = $this$firstOrNull$iv.iterator();
                            do {
                                if (it3.hasNext()) {
                                    element$iv2 = it3.next();
                                    it2 = (ImageData) element$iv2;
                                } else {
                                    element$iv2 = null;
                                }
                                imageData2 = (ImageData) element$iv2;
                                if (imageData2 != null) {
                                    bannerImage = imageData2.getUrl();
                                } else {
                                    bannerImage = null;
                                }
                            } while (!Intrinsics.areEqual(it2.getCoverType(), "Fanart"));
                            imageData2 = (ImageData) element$iv2;
                            if (imageData2 != null) {
                                bannerImage = imageData2.getUrl();
                            } else {
                                bannerImage = null;
                            }
                        }
                        if (bannerImage == null) {
                            bannerImage = this.$data.getBannerImage();
                        }
                    }
                    loadResponse.setBackgroundPosterUrl(bannerImage);
                    String strM15getCoverImage = this.$posterurl;
                    if (strM15getCoverImage == null) {
                        MetaAnimeData metaAnimeData2 = this.$animeMetaData;
                        if (metaAnimeData2 != null && (images = metaAnimeData2.getImages()) != null) {
                            Iterable $this$firstOrNull$iv2 = images;
                            Iterator it4 = $this$firstOrNull$iv2.iterator();
                            do {
                                if (it4.hasNext()) {
                                    element$iv = it4.next();
                                    it = (ImageData) element$iv;
                                } else {
                                    element$iv = null;
                                }
                                imageData = (ImageData) element$iv;
                                if (imageData != null) {
                                    url = imageData.getUrl();
                                }
                            } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                            imageData = (ImageData) element$iv;
                            if (imageData != null) {
                                url = imageData.getUrl();
                            }
                        }
                        strM15getCoverImage = url == null ? this.$data.m15getCoverImage() : url;
                    }
                    loadResponse.setPosterUrl(strM15getCoverImage);
                    try {
                        loadResponse.setLogoUrl(this.$logoposter);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setTags(this.$data.getGenres());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadFromAnilist$3 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadFromAnilist$3", f = "TorraStreamAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$loadFromAnilist$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,815:1\n296#2,2:816\n296#2,2:818\n1795#2,10:820\n2068#2:830\n2069#2:832\n1805#2:833\n1#3:831\n*S KotlinDebug\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$loadFromAnilist$3\n*L\n318#1:816,2\n321#1:818,2\n328#1:820,10\n328#1:830\n328#1:832\n328#1:833\n328#1:831\n*E\n"})
    static final class C00263 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ AnilistAPIResponse.anilistMedia $data;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ String $id;
        final /* synthetic */ AniIds $ids;
        final /* synthetic */ String $logoposter;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TorraStreamAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00263(String str, AniIds aniIds, List<Episode> list, AnilistAPIResponse.anilistMedia anilistmedia, MetaAnimeData metaAnimeData, String str2, TorraStreamAnime torraStreamAnime, Continuation<? super C00263> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$ids = aniIds;
            this.$episodes = list;
            this.$data = anilistmedia;
            this.$animeMetaData = metaAnimeData;
            this.$logoposter = str2;
            this.this$0 = torraStreamAnime;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00263 = new C00263(this.$id, this.$ids, this.$episodes, this.$data, this.$animeMetaData, this.$logoposter, this.this$0, continuation);
            c00263.L$0 = obj;
            return c00263;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0093  */
        /* JADX WARN: Code duplicated, block: B:38:0x00da  */
        public final Object invokeSuspend(Object $result) {
            String bannerImage;
            String strM15getCoverImage;
            ArrayList arrayList;
            Iterable edges;
            String romaji;
            AnimeSearchResponse animeSearchResponse;
            Iterable images;
            Object element$iv;
            ImageData imageData;
            ImageData it;
            Iterable images2;
            Object element$iv2;
            ImageData imageData2;
            ImageData it2;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(Integer.parseInt(this.$id)));
                    LoadResponse.Companion.addMalId(loadResponse, this.$ids.getIdMal());
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    loadResponse.setYear(Boxing.boxInt(this.$data.getStartDate().getYear()));
                    loadResponse.setPlot(this.$data.getDescription());
                    MetaAnimeData metaAnimeData = this.$animeMetaData;
                    if (metaAnimeData == null || (images2 = metaAnimeData.getImages()) == null) {
                        bannerImage = this.$data.getBannerImage();
                    } else {
                        Iterable $this$firstOrNull$iv = images2;
                        Iterator it3 = $this$firstOrNull$iv.iterator();
                        do {
                            if (it3.hasNext()) {
                                element$iv2 = it3.next();
                                it2 = (ImageData) element$iv2;
                            } else {
                                element$iv2 = null;
                            }
                            imageData2 = (ImageData) element$iv2;
                            if (imageData2 != null || (bannerImage = imageData2.getUrl()) == null) {
                                bannerImage = this.$data.getBannerImage();
                            }
                        } while (!Intrinsics.areEqual(it2.getCoverType(), "Fanart"));
                        imageData2 = (ImageData) element$iv2;
                        if (imageData2 != null) {
                            bannerImage = this.$data.getBannerImage();
                        } else {
                            bannerImage = this.$data.getBannerImage();
                        }
                    }
                    loadResponse.setBackgroundPosterUrl(bannerImage);
                    MetaAnimeData metaAnimeData2 = this.$animeMetaData;
                    if (metaAnimeData2 == null || (images = metaAnimeData2.getImages()) == null) {
                        strM15getCoverImage = this.$data.m15getCoverImage();
                    } else {
                        Iterable $this$firstOrNull$iv2 = images;
                        Iterator it4 = $this$firstOrNull$iv2.iterator();
                        do {
                            if (it4.hasNext()) {
                                element$iv = it4.next();
                                it = (ImageData) element$iv;
                            } else {
                                element$iv = null;
                            }
                            imageData = (ImageData) element$iv;
                            if (imageData != null || (strM15getCoverImage = imageData.getUrl()) == null) {
                                strM15getCoverImage = this.$data.m15getCoverImage();
                            }
                        } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                        imageData = (ImageData) element$iv;
                        if (imageData != null) {
                            strM15getCoverImage = this.$data.m15getCoverImage();
                        } else {
                            strM15getCoverImage = this.$data.m15getCoverImage();
                        }
                    }
                    loadResponse.setPosterUrl(strM15getCoverImage);
                    try {
                        loadResponse.setLogoUrl(this.$logoposter);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setTags(this.$data.getGenres());
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$data.getStatus()));
                    AniListApi.RecommendationConnection recommendations = this.$data.getRecommendations();
                    if (recommendations == null || (edges = recommendations.getEdges()) == null) {
                        arrayList = null;
                    } else {
                        Iterable $this$mapNotNull$iv = edges;
                        TorraStreamAnime torraStreamAnime = this.this$0;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            AniListApi.RecommendationEdge edge = (AniListApi.RecommendationEdge) element$iv$iv$iv;
                            AniListApi.RecommendedMedia recommendation = edge.getNode().getMediaRecommendation();
                            if (recommendation == null) {
                                animeSearchResponse = null;
                            } else {
                                AniListApi.MediaTitle title = recommendation.getTitle();
                                if (title == null || (romaji = title.getEnglish()) == null) {
                                    AniListApi.MediaTitle title2 = recommendation.getTitle();
                                    romaji = title2 != null ? title2.getRomaji() : null;
                                    if (romaji == null) {
                                        romaji = "Unknown";
                                    }
                                }
                                String title3 = romaji;
                                String recommendationUrl = torraStreamAnime.getMainUrl() + "/anime/" + recommendation.getId();
                                AnimeSearchResponse $this$invokeSuspend_u24lambda_u242_u240 = MainAPIKt.newAnimeSearchResponse$default(torraStreamAnime, title3, recommendationUrl, TvType.Anime, false, (Function1) null, 24, (Object) null);
                                AniListApi.MediaCoverImage coverImage = recommendation.getCoverImage();
                                $this$invokeSuspend_u24lambda_u242_u240.setPosterUrl(coverImage != null ? coverImage.getLarge() : null);
                                animeSearchResponse = $this$invokeSuspend_u24lambda_u242_u240;
                            }
                            if (animeSearchResponse != null) {
                                destination$iv$iv.add(animeSearchResponse);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv;
                        }
                        arrayList = (List) destination$iv$iv;
                    }
                    loadResponse.setRecommendations(arrayList);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:106:0x0408  */
    /* JADX WARN: Code duplicated, block: B:108:0x040b  */
    /* JADX WARN: Code duplicated, block: B:109:0x040e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0412  */
    /* JADX WARN: Code duplicated, block: B:117:0x0427  */
    /* JADX WARN: Code duplicated, block: B:119:0x042d  */
    /* JADX WARN: Code duplicated, block: B:121:0x043f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0444  */
    /* JADX WARN: Code duplicated, block: B:125:0x044d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0453  */
    /* JADX WARN: Code duplicated, block: B:128:0x0458  */
    /* JADX WARN: Code duplicated, block: B:130:0x045b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:139:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:142:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:143:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:145:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:149:0x04f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:153:0x0505  */
    /* JADX WARN: Code duplicated, block: B:155:0x0508  */
    /* JADX WARN: Code duplicated, block: B:157:0x050e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0515  */
    /* JADX WARN: Code duplicated, block: B:160:0x0518  */
    /* JADX WARN: Code duplicated, block: B:163:0x051f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0521  */
    /* JADX WARN: Code duplicated, block: B:177:0x0567  */
    /* JADX WARN: Code duplicated, block: B:179:0x056e  */
    /* JADX WARN: Code duplicated, block: B:182:0x057c  */
    /* JADX WARN: Code duplicated, block: B:183:0x057e  */
    /* JADX WARN: Code duplicated, block: B:196:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:198:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:202:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:216:0x0609  */
    /* JADX WARN: Code duplicated, block: B:219:0x0667  */
    /* JADX WARN: Code duplicated, block: B:222:0x0677  */
    /* JADX WARN: Code duplicated, block: B:223:0x067c  */
    /* JADX WARN: Code duplicated, block: B:224:0x067e  */
    /* JADX WARN: Code duplicated, block: B:227:0x0689  */
    /* JADX WARN: Code duplicated, block: B:230:0x0697  */
    /* JADX WARN: Code duplicated, block: B:233:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:235:0x06c1  */
    /* JADX WARN: Code duplicated, block: B:238:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:239:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:242:0x0738  */
    /* JADX WARN: Code duplicated, block: B:245:0x0770 A[LOOP:6: B:243:0x076a->B:245:0x0770, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:249:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:252:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:254:0x07d3  */
    /* JADX WARN: Code duplicated, block: B:259:0x07fc  */
    /* JADX WARN: Code duplicated, block: B:261:0x0810  */
    /* JADX WARN: Code duplicated, block: B:262:0x081a  */
    /* JADX WARN: Code duplicated, block: B:264:0x0824  */
    /* JADX WARN: Code duplicated, block: B:267:0x0835  */
    /* JADX WARN: Code duplicated, block: B:268:0x0863  */
    /* JADX WARN: Code duplicated, block: B:271:0x086c  */
    /* JADX WARN: Code duplicated, block: B:274:0x0888  */
    /* JADX WARN: Code duplicated, block: B:277:0x0892  */
    /* JADX WARN: Code duplicated, block: B:279:0x0952 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:280:0x0953  */
    /* JADX WARN: Code duplicated, block: B:282:0x0975  */
    /* JADX WARN: Code duplicated, block: B:284:0x0a59 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:285:0x0a5a  */
    /* JADX WARN: Code duplicated, block: B:288:0x0a88  */
    /* JADX WARN: Code duplicated, block: B:294:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x02f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x07d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x0870 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x028d  */
    /* JADX WARN: Code duplicated, block: B:44:0x02ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:64:0x0374 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0375  */
    /* JADX WARN: Code duplicated, block: B:77:0x0399  */
    /* JADX WARN: Code duplicated, block: B:78:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:81:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:83:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:84:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:86:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:89:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:90:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:99:0x03e8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v107 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.phisher98.MetaAnimeData] */
    /* JADX WARN: Type inference failed for: r0v47, types: [com.phisher98.MetaAnimeData] */
    /* JADX WARN: Type inference failed for: r0v73 */
    /* JADX WARN: Type inference failed for: r0v74, types: [com.phisher98.MetaAnimeData] */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [com.phisher98.MetaAnimeData, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v14 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r32v10 */
    /* JADX WARN: Type inference failed for: r32v11 */
    /* JADX WARN: Type inference failed for: r32v12, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r32v13 */
    /* JADX WARN: Type inference failed for: r32v14 */
    /* JADX WARN: Type inference failed for: r32v15 */
    /* JADX WARN: Type inference failed for: r32v16 */
    /* JADX WARN: Type inference failed for: r32v17 */
    /* JADX WARN: Type inference failed for: r32v18 */
    /* JADX WARN: Type inference failed for: r32v19 */
    /* JADX WARN: Type inference failed for: r32v20 */
    /* JADX WARN: Type inference failed for: r32v21 */
    /* JADX WARN: Type inference failed for: r33v0 */
    /* JADX WARN: Type inference failed for: r33v1 */
    /* JADX WARN: Type inference failed for: r33v4, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r33v9 */
    /* JADX WARN: Type inference failed for: r37v10 */
    /* JADX WARN: Type inference failed for: r37v11 */
    /* JADX WARN: Type inference failed for: r37v12 */
    /* JADX WARN: Type inference failed for: r37v17 */
    /* JADX WARN: Type inference failed for: r37v18 */
    /* JADX WARN: Type inference failed for: r37v19 */
    /* JADX WARN: Type inference failed for: r37v3 */
    /* JADX WARN: Type inference failed for: r37v4 */
    /* JADX WARN: Type inference failed for: r37v7 */
    /* JADX WARN: Type inference failed for: r37v8 */
    /* JADX WARN: Type inference failed for: r37v9 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v80 */
    /* JADX WARN: Type inference failed for: r40v0 */
    /* JADX WARN: Type inference failed for: r40v1, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r40v10 */
    /* JADX WARN: Type inference failed for: r40v11 */
    /* JADX WARN: Type inference failed for: r40v12 */
    /* JADX WARN: Type inference failed for: r40v13 */
    /* JADX WARN: Type inference failed for: r40v6 */
    /* JADX WARN: Type inference failed for: r40v7 */
    /* JADX WARN: Type inference failed for: r40v8 */
    /* JADX WARN: Type inference failed for: r40v9 */
    /* JADX WARN: Type inference failed for: r41v1 */
    /* JADX WARN: Type inference failed for: r41v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r41v4 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r67v10 */
    /* JADX WARN: Type inference failed for: r67v11 */
    /* JADX WARN: Type inference failed for: r67v12 */
    /* JADX WARN: Type inference failed for: r67v13 */
    /* JADX WARN: Type inference failed for: r67v14 */
    /* JADX WARN: Type inference failed for: r67v15 */
    /* JADX WARN: Type inference failed for: r67v16 */
    /* JADX WARN: Type inference failed for: r67v17 */
    /* JADX WARN: Type inference failed for: r67v18 */
    /* JADX WARN: Type inference failed for: r67v2 */
    /* JADX WARN: Type inference failed for: r67v3, types: [com.phisher98.MetaAnimeData] */
    /* JADX WARN: Type inference failed for: r67v6 */
    /* JADX WARN: Type inference failed for: r67v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v49 */
    public final Object loadFromKitsu(String str, String str2, Continuation<? super LoadResponse> continuation) throws Exception {
        C00271 c00271;
        Object meta;
        Object meta2;
        Object meta3;
        TorraStreamKitsuHelper.KitsuMeta kitsuMeta;
        String str3;
        Object meta4;
        Integer numericKitsuId;
        String str4;
        String str5;
        Integer num;
        String str6;
        C00271 c00272;
        TorraStreamKitsuHelper.KitsuMeta kitsuMeta2;
        Object obj;
        TorraStreamKitsuHelper.KitsuMeta kitsuMeta3;
        TorraStreamKitsuHelper.KitsuMeta kitsuMeta4;
        String text;
        String str7;
        ?? animeData;
        String name;
        String str8;
        Integer yearInt;
        Integer num2;
        String str9;
        int i;
        TvType tvType;
        CharSequence charSequence;
        Object obj2;
        String str10;
        ?? r5;
        Integer intOrNull;
        ?? r7;
        AniIds aniIds;
        String str11;
        ?? r0;
        TorraStreamKitsuHelper.KitsuMeta kitsuMeta5;
        String str12;
        String str13;
        ?? r23;
        Integer num3;
        ?? r24;
        Integer num4;
        String str14;
        int i2;
        TvType tvType2;
        String str15;
        String str16;
        Integer num5;
        ?? r9;
        Integer num6;
        ?? r6;
        int i3;
        String str17;
        MetaMappings mappings;
        Integer malId;
        MetaMappings mappings2;
        Integer anilistId;
        Map<String, MetaEpisode> episodes;
        MetaEpisode metaEpisode;
        String airDateUtc;
        String strTake;
        List<String> aliases;
        AniIds aniIds2;
        Integer id;
        ?? r2;
        Integer idMal;
        ?? r33;
        String str18;
        List<String> aliases2;
        Map<String, String> titles;
        String poster;
        ?? r67;
        ?? r40;
        String url;
        String str19;
        String background;
        Object obj3;
        String str20;
        String str21;
        String logo;
        String str22;
        ?? r3;
        ?? r4;
        String stringData;
        List<TorraStreamKitsuHelper.KitsuVideo> videos;
        List<TorraStreamKitsuHelper.KitsuVideo> list;
        int size;
        Map<String, MetaEpisode> episodes2;
        ?? r1;
        String str23;
        int i4;
        TorraStreamKitsuHelper.KitsuMeta kitsuMeta6;
        String str24;
        String str25;
        Object obj4;
        CharSequence charSequence2;
        ArrayList arrayList;
        IntIterator it;
        ?? r41;
        ArrayList arrayList2;
        List<TorraStreamKitsuHelper.KitsuLink> links;
        ArrayList arrayList3;
        ?? r37;
        ?? r32;
        List list2;
        List list3;
        String str26;
        ?? r8;
        Object obj5;
        List list4;
        Integer num7;
        int i5;
        String str27;
        int i6;
        ?? r17;
        String str28;
        String str29;
        Object objNewMovieLoadResponse;
        String str30;
        C00271 c00273;
        Object obj6;
        List<TorraStreamKitsuHelper.KitsuLink> list5;
        ArrayList arrayList4;
        ArrayList<TorraStreamKitsuHelper.KitsuLink> arrayList5;
        int i7;
        ArrayList arrayList6;
        ?? r10;
        ?? r11;
        String name2;
        ArrayList arrayList7;
        String url2;
        int i8;
        ?? r38;
        ?? r34;
        AnimeSearchResponse animeSearchResponseNewAnimeSearchResponse$default;
        ?? r39;
        ?? r35;
        String strSubstringAfterLast$default;
        ?? r310;
        ?? r36;
        List<TorraStreamKitsuHelper.KitsuVideo> list6;
        int i9;
        ArrayList arrayList8;
        int i10;
        ?? r68;
        int i11;
        Integer episode;
        int iIntValue;
        List<ImageData> images;
        Object next;
        List<ImageData> images2;
        Object next2;
        ?? r69;
        ?? r42;
        List<ImageData> images3;
        ?? r610;
        ?? r43;
        Object next3;
        Map<String, String> titles2;
        ?? r12;
        TorraStreamAnime torraStreamAnime = this;
        String str31 = str;
        String str32 = str2;
        if (continuation instanceof C00271) {
            c00271 = (C00271) continuation;
            if ((c00271.label & Integer.MIN_VALUE) != 0) {
                c00271.label -= Integer.MIN_VALUE;
            } else {
                c00271 = torraStreamAnime.new C00271(continuation);
            }
        } else {
            c00271 = torraStreamAnime.new C00271(continuation);
        }
        C00271 c00274 = c00271;
        Object objTmdbToAnimeId = c00274.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00274.label) {
            case 0:
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                if (!StringsKt.startsWith$default(str32, "kitsu:", false, 2, (Object) null) && !StringsKt.startsWith$default(str32, "anilist:", false, 2, (Object) null) && !StringsKt.startsWith$default(str32, "mal:", false, 2, (Object) null)) {
                    if (StringsKt.contains$default(str31, "kitsu", false, 2, (Object) null)) {
                        c00274.L$0 = str31;
                        c00274.L$1 = str32;
                        c00274.label = 2;
                        meta3 = TorraStreamKitsuHelper.INSTANCE.getMeta("kitsu:" + str32, c00274);
                        if (meta3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta3;
                        str3 = str31;
                        if (kitsuMeta == null) {
                            throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                        }
                        numericKitsuId = kitsuMeta.getNumericKitsuId();
                        if (numericKitsuId != null) {
                            str4 = "kitsu_id=" + numericKitsuId.intValue();
                            break;
                        } else {
                            str4 = "anilist_id=" + str32;
                        }
                        Requests app = MainActivityKt.getApp();
                        String str33 = "https://api.ani.zip/mappings?" + str4;
                        c00274.L$0 = str3;
                        c00274.L$1 = str32;
                        c00274.L$2 = kitsuMeta;
                        c00274.L$3 = numericKitsuId;
                        c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                        c00274.label = 5;
                        num = numericKitsuId;
                        str5 = str3;
                        str6 = null;
                        obj = Requests.get$default(app, str33, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                        c00272 = c00274;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kitsuMeta3 = kitsuMeta;
                        text = ((NiceResponse) obj).getText();
                        kitsuMeta4 = kitsuMeta3;
                        str7 = str5;
                        if (text != null) {
                            animeData = TorraStreamUtilsKt.parseAnimeData(text);
                        } else {
                            animeData = str6;
                        }
                        name = kitsuMeta4.getName();
                        if (name == null) {
                            aliases = kitsuMeta4.getAliases();
                            if (aliases != null) {
                                name = (String) CollectionsKt.firstOrNull(aliases);
                            } else {
                                name = str6;
                            }
                            if (name == null) {
                                name = "Unknown";
                            }
                        }
                        str8 = name;
                        yearInt = kitsuMeta4.getYearInt();
                        if (yearInt == null) {
                            if (animeData != 0) {
                                yearInt = null;
                            } else {
                                yearInt = null;
                            }
                        }
                        num2 = yearInt;
                        str9 = str32;
                        if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            tvType = TvType.AnimeMovie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        if (animeData != 0) {
                            if (StringsKt.toIntOrNull(str9) != null) {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                                if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                    intOrNull = StringsKt.toIntOrNull(str9);
                                }
                            } else {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                            }
                            r5 = str10;
                        } else {
                            if (StringsKt.toIntOrNull(str9) != null) {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                                if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                    intOrNull = StringsKt.toIntOrNull(str9);
                                }
                            } else {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                            }
                            r5 = str10;
                        }
                        if (animeData != 0) {
                            r5 = intOrNull;
                            mappings = animeData.getMappings();
                            if (mappings != null) {
                                malId = mappings.getMalId();
                            } else {
                                r5 = intOrNull;
                                r7 = str10;
                            }
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                        if (r7 == 0) {
                        }
                        r7 = malId;
                        aniIds = new AniIds(r5, r7);
                        ?? r22 = animeData;
                        str11 = str7;
                        r0 = r22;
                        kitsuMeta5 = kitsuMeta4;
                        str12 = str8;
                        str13 = str9;
                        r23 = r5;
                        num3 = num2;
                        r24 = r7;
                        num4 = num;
                        str14 = text;
                        i2 = i;
                        tvType2 = tvType;
                        aniIds2 = aniIds;
                        id = aniIds2.getId();
                        r2 = id;
                        if (id == null) {
                            r2 = r23;
                        }
                        idMal = aniIds2.getIdMal();
                        if (idMal == null) {
                            r33 = r24;
                        } else {
                            r33 = idMal;
                        }
                        if (r0 != 0) {
                            if (r0 != 0) {
                                str18 = str10;
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                aliases2 = kitsuMeta5.getAliases();
                                if (aliases2 != null) {
                                    str18 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str18 = str10;
                                }
                                if (str18 == null) {
                                    str18 = str12;
                                }
                            }
                        } else {
                            if (r0 != 0) {
                                str18 = str10;
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                aliases2 = kitsuMeta5.getAliases();
                                if (aliases2 != null) {
                                    str18 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str18 = str10;
                                }
                                if (str18 == null) {
                                    str18 = str12;
                                }
                            }
                        }
                        poster = kitsuMeta5.getPoster();
                        if (poster == null) {
                            r67 = r0;
                            r40 = r2;
                            url = poster;
                        } else if (r0 != 0) {
                            r69 = r0;
                            r42 = r2;
                            url = null;
                            r40 = r42;
                            r67 = r69;
                        } else {
                            r69 = r0;
                            r42 = r2;
                            url = null;
                            r40 = r42;
                            r67 = r69;
                        }
                        str19 = url;
                        background = kitsuMeta5.getBackground();
                        if (background == null) {
                            if (r67 == 0) {
                                obj3 = coroutine_suspended;
                            } else {
                                obj3 = coroutine_suspended;
                            }
                            str20 = null;
                            str21 = str20;
                            if (r67 != 0) {
                                logo = kitsuMeta5.getLogo();
                            } else {
                                logo = kitsuMeta5.getLogo();
                            }
                            str22 = logo;
                            r3 = r33;
                            r4 = r40;
                            stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                            videos = kitsuMeta5.getVideos();
                            if (videos == null) {
                                videos = CollectionsKt.emptyList();
                            }
                            list = videos;
                            if (!list.isEmpty()) {
                                size = list.size();
                            } else if (r67 != 0) {
                                size = 1;
                            } else {
                                size = 1;
                            }
                            if (list.isEmpty()) {
                                int i12 = size;
                                r1 = r67;
                                str23 = str21;
                                i4 = i12;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                Iterable intRange = new IntRange(1, i4);
                                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
                                it = intRange.iterator();
                                while (it.hasNext()) {
                                    ArrayList arrayList9 = arrayList;
                                    arrayList9.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                    arrayList = arrayList9;
                                }
                                r41 = r1;
                                arrayList2 = arrayList;
                            } else {
                                list6 = list;
                                i9 = size;
                                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                                i10 = 0;
                                r68 = r67;
                                for (Object obj7 : list6) {
                                    int i13 = i10 + 1;
                                    if (i10 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    i11 = i10;
                                    TorraStreamKitsuHelper.KitsuVideo kitsuVideo = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                    episode = kitsuVideo.getEpisode();
                                    if (episode != null) {
                                        iIntValue = episode.intValue();
                                    } else {
                                        iIntValue = i11 + 1;
                                    }
                                    ArrayList arrayList10 = arrayList8;
                                    ?? r13 = r68;
                                    arrayList10.add(loadFromKitsu$createEpisode(r13, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo));
                                    str21 = str21;
                                    r68 = r13;
                                    arrayList8 = arrayList10;
                                    kitsuMeta5 = kitsuMeta5;
                                    i9 = i9;
                                    torraStreamAnime = this;
                                    list6 = list6;
                                    charSequence = charSequence;
                                    str11 = str11;
                                    obj3 = obj3;
                                    i10 = i13;
                                    str19 = str19;
                                }
                                ArrayList arrayList11 = arrayList8;
                                ?? r14 = r68;
                                str23 = str21;
                                i4 = i9;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                arrayList2 = arrayList11;
                                r41 = r14;
                            }
                            links = kitsuMeta6.getLinks();
                            if (links != null) {
                                list5 = links;
                                arrayList4 = new ArrayList();
                                for (Object obj8 : list5) {
                                    List<TorraStreamKitsuHelper.KitsuLink> list7 = list5;
                                    ArrayList arrayList12 = arrayList2;
                                    if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                        arrayList4.add(obj8);
                                    }
                                    list5 = list7;
                                    arrayList2 = arrayList12;
                                }
                                arrayList3 = arrayList2;
                                arrayList5 = arrayList4;
                                i7 = 0;
                                arrayList6 = new ArrayList();
                                r11 = r4;
                                r10 = r3;
                                for (TorraStreamKitsuHelper.KitsuLink kitsuLink : arrayList5) {
                                    name2 = kitsuLink.getName();
                                    if (name2 == null) {
                                        arrayList7 = arrayList5;
                                        i8 = i7;
                                        r310 = r11;
                                        r36 = r10;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                    } else {
                                        arrayList7 = arrayList5;
                                        url2 = kitsuLink.getUrl();
                                        if (url2 != null) {
                                            i8 = i7;
                                            r39 = r11;
                                            r35 = r10;
                                            strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                            if (strSubstringAfterLast$default != null) {
                                                animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                            }
                                        } else {
                                            i8 = i7;
                                            r38 = r11;
                                            r34 = r10;
                                        }
                                        r34 = r35;
                                        r38 = r39;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                        r36 = r34;
                                        r310 = r38;
                                    }
                                    if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                        arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                    } else {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                    }
                                    r10 = r36;
                                    arrayList5 = arrayList7;
                                    i7 = i8;
                                    r11 = r310;
                                }
                                r37 = r11;
                                r32 = r10;
                                list2 = arrayList6;
                            } else {
                                arrayList3 = arrayList2;
                                r37 = r4;
                                r32 = r3;
                                list2 = null;
                            }
                            list3 = list2;
                            if (i2 != 0) {
                                Integer num8 = num3;
                                String str34 = str12;
                                TvType tvType3 = TvType.AnimeMovie;
                                String str35 = str23;
                                TorraStreamKitsuHelper.KitsuMeta kitsuMeta7 = kitsuMeta6;
                                ?? r311 = r32;
                                ?? r312 = r37;
                                String str36 = str24;
                                C00282 c00282 = new C00282(r312, r311, num8, kitsuMeta7, str35, str36, str22, null);
                                c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                                c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                                c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta7);
                                c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                                c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                                c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                                c00272.L$6 = SpillingKt.nullOutSpilledVariable(str34);
                                c00272.L$7 = SpillingKt.nullOutSpilledVariable(num8);
                                c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                                c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                                c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                                c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r312);
                                c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r311);
                                c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                                c00272.L$15 = SpillingKt.nullOutSpilledVariable(str36);
                                c00272.L$16 = SpillingKt.nullOutSpilledVariable(str35);
                                c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                                c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                                c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                                c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                                c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                                c00272.I$0 = i2;
                                c00272.I$1 = i4;
                                c00272.label = 7;
                                C00271 c00275 = c00272;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str34, str25, tvType3, stringData, c00282, c00275);
                                str30 = str34;
                                c00273 = c00275;
                                obj6 = obj4;
                                if (objNewMovieLoadResponse == obj6) {
                                    return obj6;
                                }
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            str26 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta8 = kitsuMeta6;
                            Integer num9 = num3;
                            C00271 c00276 = c00272;
                            r8 = r32;
                            ?? r15 = r37;
                            String str37 = str24;
                            String str38 = str12;
                            obj5 = obj4;
                            TvType tvType4 = TvType.Anime;
                            list4 = list3;
                            num7 = num9;
                            C00293 c00293 = new C00293(r15, r8, arrayList3, num9, kitsuMeta8, str26, str37, str22, this, list4, null);
                            c00276.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00276.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00276.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta8);
                            c00276.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00276.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00276.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00276.L$6 = SpillingKt.nullOutSpilledVariable(str38);
                            c00276.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                            c00276.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00276.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00276.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00276.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00276.L$12 = SpillingKt.nullOutSpilledVariable((Object) r15);
                            c00276.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                            c00276.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00276.L$15 = SpillingKt.nullOutSpilledVariable(str37);
                            c00276.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                            c00276.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00276.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00276.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00276.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00276.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                            c00276.I$0 = i2;
                            c00276.I$1 = i4;
                            c00276.label = 8;
                            i5 = i2;
                            objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str38, str25, tvType4, false, c00293, c00276, 8, (Object) null);
                            str27 = str38;
                            if (objTmdbToAnimeId == obj5) {
                                return obj5;
                            }
                            i6 = i5;
                            r17 = r8;
                            str28 = str26;
                            str29 = str18;
                            return (LoadResponse) objTmdbToAnimeId;
                        }
                        obj3 = coroutine_suspended;
                        str20 = background;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i14 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo2 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo2.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList13 = arrayList8;
                                ?? r16 = r68;
                                arrayList13.add(loadFromKitsu$createEpisode(r16, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo2));
                                str21 = str21;
                                r68 = r16;
                                arrayList8 = arrayList13;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i14;
                                str19 = str19;
                            }
                            ArrayList arrayList14 = arrayList8;
                            ?? r18 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList14;
                            r41 = r18;
                        } else {
                            int i15 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i15;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange2 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                            it = intRange2.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList15 = arrayList;
                                arrayList15.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList15;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list8 = list5;
                                ArrayList arrayList16 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list8;
                                arrayList2 = arrayList16;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num10 = num3;
                            String str39 = str12;
                            TvType tvType5 = TvType.AnimeMovie;
                            String str310 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta9 = kitsuMeta6;
                            ?? r313 = r32;
                            ?? r314 = r37;
                            String str311 = str24;
                            C00282 c00283 = new C00282(r314, r313, num10, kitsuMeta9, str310, str311, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta9);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str39);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num10);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r314);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r313);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str310);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c00277 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str39, str25, tvType5, stringData, c00283, c00277);
                            str30 = str39;
                            c00273 = c00277;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta10 = kitsuMeta6;
                        Integer num11 = num3;
                        C00271 c00278 = c00272;
                        r8 = r32;
                        ?? r19 = r37;
                        String str312 = str24;
                        String str313 = str12;
                        obj5 = obj4;
                        TvType tvType6 = TvType.Anime;
                        list4 = list3;
                        num7 = num11;
                        C00293 c00294 = new C00293(r19, r8, arrayList3, num11, kitsuMeta10, str26, str312, str22, this, list4, null);
                        c00278.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00278.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00278.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta10);
                        c00278.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00278.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00278.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00278.L$6 = SpillingKt.nullOutSpilledVariable(str313);
                        c00278.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c00278.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00278.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00278.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00278.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00278.L$12 = SpillingKt.nullOutSpilledVariable((Object) r19);
                        c00278.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c00278.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00278.L$15 = SpillingKt.nullOutSpilledVariable(str312);
                        c00278.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c00278.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00278.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00278.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00278.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00278.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c00278.I$0 = i2;
                        c00278.I$1 = i4;
                        c00278.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str313, str25, tvType6, false, c00294, c00278, 8, (Object) null);
                        str27 = str313;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                    c00274.L$0 = str31;
                    c00274.L$1 = str32;
                    c00274.label = 3;
                    meta2 = TorraStreamKitsuHelper.INSTANCE.getMeta("anilist:" + str32, c00274);
                    if (meta2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta2;
                    if (kitsuMeta == null) {
                        c00274.L$0 = str31;
                        c00274.L$1 = str32;
                        c00274.label = 4;
                        meta4 = TorraStreamKitsuHelper.INSTANCE.getMeta("kitsu:" + str32, c00274);
                        if (meta4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta4;
                        str3 = str31;
                    } else {
                        str3 = str31;
                    }
                    if (kitsuMeta == null) {
                        throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                    }
                    numericKitsuId = kitsuMeta.getNumericKitsuId();
                    if (numericKitsuId != null) {
                        str4 = "kitsu_id=" + numericKitsuId.intValue();
                        break;
                    } else {
                        str4 = "anilist_id=" + str32;
                    }
                    Requests app2 = MainActivityKt.getApp();
                    String str314 = "https://api.ani.zip/mappings?" + str4;
                    c00274.L$0 = str3;
                    c00274.L$1 = str32;
                    c00274.L$2 = kitsuMeta;
                    c00274.L$3 = numericKitsuId;
                    c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                    c00274.label = 5;
                    num = numericKitsuId;
                    str5 = str3;
                    str6 = null;
                    obj = Requests.get$default(app2, str314, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                    c00272 = c00274;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kitsuMeta3 = kitsuMeta;
                    text = ((NiceResponse) obj).getText();
                    kitsuMeta4 = kitsuMeta3;
                    str7 = str5;
                    if (text != null) {
                        animeData = TorraStreamUtilsKt.parseAnimeData(text);
                    } else {
                        animeData = str6;
                    }
                    name = kitsuMeta4.getName();
                    if (name == null) {
                        aliases = kitsuMeta4.getAliases();
                        if (aliases != null) {
                            name = (String) CollectionsKt.firstOrNull(aliases);
                        } else {
                            name = str6;
                        }
                        if (name == null) {
                            name = "Unknown";
                        }
                    }
                    str8 = name;
                    yearInt = kitsuMeta4.getYearInt();
                    if (yearInt == null) {
                        if (animeData != 0) {
                            yearInt = null;
                        } else {
                            yearInt = null;
                        }
                    }
                    num2 = yearInt;
                    str9 = str32;
                    if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    if (animeData != 0) {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    } else {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    }
                    if (animeData != 0) {
                        r5 = intOrNull;
                        mappings = animeData.getMappings();
                        if (mappings != null) {
                            malId = mappings.getMalId();
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                    if (r7 == 0) {
                    }
                    r7 = malId;
                    aniIds = new AniIds(r5, r7);
                    ?? r25 = animeData;
                    str11 = str7;
                    r0 = r25;
                    kitsuMeta5 = kitsuMeta4;
                    str12 = str8;
                    str13 = str9;
                    r23 = r5;
                    num3 = num2;
                    r24 = r7;
                    num4 = num;
                    str14 = text;
                    i2 = i;
                    tvType2 = tvType;
                    aniIds2 = aniIds;
                    id = aniIds2.getId();
                    r2 = id;
                    if (id == null) {
                        r2 = r23;
                    }
                    idMal = aniIds2.getIdMal();
                    if (idMal == null) {
                        r33 = r24;
                    } else {
                        r33 = idMal;
                    }
                    if (r0 != 0) {
                        if (r0 != 0) {
                            str18 = str10;
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    } else {
                        if (r0 != 0) {
                            str18 = str10;
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    }
                    poster = kitsuMeta5.getPoster();
                    if (poster == null) {
                        r67 = r0;
                        r40 = r2;
                        url = poster;
                    } else if (r0 != 0) {
                        r69 = r0;
                        r42 = r2;
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    } else {
                        r69 = r0;
                        r42 = r2;
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    }
                    str19 = url;
                    background = kitsuMeta5.getBackground();
                    if (background == null) {
                        if (r67 == 0) {
                            obj3 = coroutine_suspended;
                        } else {
                            obj3 = coroutine_suspended;
                        }
                        str20 = null;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i16 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo3 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo3.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList17 = arrayList8;
                                ?? r110 = r68;
                                arrayList17.add(loadFromKitsu$createEpisode(r110, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo3));
                                str21 = str21;
                                r68 = r110;
                                arrayList8 = arrayList17;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i16;
                                str19 = str19;
                            }
                            ArrayList arrayList18 = arrayList8;
                            ?? r111 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList18;
                            r41 = r111;
                        } else {
                            int i17 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i17;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange3 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange3, 10));
                            it = intRange3.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList19 = arrayList;
                                arrayList19.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList19;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list9 = list5;
                                ArrayList arrayList110 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list9;
                                arrayList2 = arrayList110;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num12 = num3;
                            String str315 = str12;
                            TvType tvType7 = TvType.AnimeMovie;
                            String str316 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta11 = kitsuMeta6;
                            ?? r315 = r32;
                            ?? r316 = r37;
                            String str317 = str24;
                            C00282 c00284 = new C00282(r316, r315, num12, kitsuMeta11, str316, str317, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str315);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num12);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r316);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r315);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str317);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str316);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c00279 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str315, str25, tvType7, stringData, c00284, c00279);
                            str30 = str315;
                            c00273 = c00279;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta12 = kitsuMeta6;
                        Integer num13 = num3;
                        C00271 c002710 = c00272;
                        r8 = r32;
                        ?? r112 = r37;
                        String str318 = str24;
                        String str319 = str12;
                        obj5 = obj4;
                        TvType tvType8 = TvType.Anime;
                        list4 = list3;
                        num7 = num13;
                        C00293 c00295 = new C00293(r112, r8, arrayList3, num13, kitsuMeta12, str26, str318, str22, this, list4, null);
                        c002710.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c002710.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c002710.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta12);
                        c002710.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c002710.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c002710.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c002710.L$6 = SpillingKt.nullOutSpilledVariable(str319);
                        c002710.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c002710.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c002710.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c002710.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c002710.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c002710.L$12 = SpillingKt.nullOutSpilledVariable((Object) r112);
                        c002710.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c002710.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c002710.L$15 = SpillingKt.nullOutSpilledVariable(str318);
                        c002710.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c002710.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c002710.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c002710.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c002710.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c002710.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c002710.I$0 = i2;
                        c002710.I$1 = i4;
                        c002710.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str319, str25, tvType8, false, c00295, c002710, 8, (Object) null);
                        str27 = str319;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                    obj3 = coroutine_suspended;
                    str20 = background;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i18 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo4 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo4.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList111 = arrayList8;
                            ?? r113 = r68;
                            arrayList111.add(loadFromKitsu$createEpisode(r113, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo4));
                            str21 = str21;
                            r68 = r113;
                            arrayList8 = arrayList111;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i18;
                            str19 = str19;
                        }
                        ArrayList arrayList112 = arrayList8;
                        ?? r114 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList112;
                        r41 = r114;
                    } else {
                        int i19 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i19;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange4 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange4, 10));
                        it = intRange4.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList113 = arrayList;
                            arrayList113.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList113;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list10 = list5;
                            ArrayList arrayList114 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list10;
                            arrayList2 = arrayList114;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num14 = num3;
                        String str3110 = str12;
                        TvType tvType9 = TvType.AnimeMovie;
                        String str3111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta13 = kitsuMeta6;
                        ?? r317 = r32;
                        ?? r318 = r37;
                        String str3112 = str24;
                        C00282 c00285 = new C00282(r318, r317, num14, kitsuMeta13, str3111, str3112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta13);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num14);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r318);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r317);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c002711 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3110, str25, tvType9, stringData, c00285, c002711);
                        str30 = str3110;
                        c00273 = c002711;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta14 = kitsuMeta6;
                    Integer num15 = num3;
                    C00271 c002712 = c00272;
                    r8 = r32;
                    ?? r115 = r37;
                    String str3113 = str24;
                    String str3114 = str12;
                    obj5 = obj4;
                    TvType tvType10 = TvType.Anime;
                    list4 = list3;
                    num7 = num15;
                    C00293 c00296 = new C00293(r115, r8, arrayList3, num15, kitsuMeta14, str26, str3113, str22, this, list4, null);
                    c002712.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c002712.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c002712.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta14);
                    c002712.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c002712.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c002712.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c002712.L$6 = SpillingKt.nullOutSpilledVariable(str3114);
                    c002712.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c002712.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c002712.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c002712.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c002712.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c002712.L$12 = SpillingKt.nullOutSpilledVariable((Object) r115);
                    c002712.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c002712.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c002712.L$15 = SpillingKt.nullOutSpilledVariable(str3113);
                    c002712.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c002712.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c002712.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c002712.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c002712.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c002712.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c002712.I$0 = i2;
                    c002712.I$1 = i4;
                    c002712.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3114, str25, tvType10, false, c00296, c002712, 8, (Object) null);
                    str27 = str3114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                TorraStreamKitsuHelper torraStreamKitsuHelper = TorraStreamKitsuHelper.INSTANCE;
                c00274.L$0 = str31;
                c00274.L$1 = str32;
                c00274.label = 1;
                meta = torraStreamKitsuHelper.getMeta(str32, c00274);
                if (meta == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta;
                str3 = str31;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    try {
                        str4 = "kitsu_id=" + numericKitsuId.intValue();
                    } catch (Throwable th) {
                        kitsuMeta2 = kitsuMeta;
                        str5 = str3;
                        num = numericKitsuId;
                        str6 = null;
                        c00272 = c00274;
                        kitsuMeta4 = kitsuMeta2;
                        text = str6;
                        str7 = str5;
                        if (text != null) {
                            animeData = TorraStreamUtilsKt.parseAnimeData(text);
                        } else {
                            animeData = str6;
                        }
                        name = kitsuMeta4.getName();
                        if (name == null) {
                            aliases = kitsuMeta4.getAliases();
                            if (aliases != null) {
                                name = (String) CollectionsKt.firstOrNull(aliases);
                            } else {
                                name = str6;
                            }
                            if (name == null) {
                                name = "Unknown";
                            }
                        }
                        str8 = name;
                        yearInt = kitsuMeta4.getYearInt();
                        if (yearInt == null) {
                            if (animeData != 0) {
                                yearInt = null;
                            } else {
                                yearInt = null;
                            }
                        }
                        num2 = yearInt;
                        str9 = str32;
                        if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            tvType = TvType.AnimeMovie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        if (animeData != 0) {
                            if (StringsKt.toIntOrNull(str9) != null) {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                                if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                    intOrNull = StringsKt.toIntOrNull(str9);
                                }
                            } else {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                            }
                            r5 = str10;
                        } else {
                            if (StringsKt.toIntOrNull(str9) != null) {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                                if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                    intOrNull = StringsKt.toIntOrNull(str9);
                                }
                            } else {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                            }
                            r5 = str10;
                        }
                        if (animeData != 0) {
                            r5 = intOrNull;
                            mappings = animeData.getMappings();
                            if (mappings != null) {
                                malId = mappings.getMalId();
                            } else {
                                r5 = intOrNull;
                                r7 = str10;
                            }
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                        if (r7 == 0) {
                        }
                        r7 = malId;
                        aniIds = new AniIds(r5, r7);
                        ?? r26 = animeData;
                        str11 = str7;
                        r0 = r26;
                        kitsuMeta5 = kitsuMeta4;
                        str12 = str8;
                        str13 = str9;
                        r23 = r5;
                        num3 = num2;
                        r24 = r7;
                        num4 = num;
                        str14 = text;
                        i2 = i;
                        tvType2 = tvType;
                        aniIds2 = aniIds;
                        id = aniIds2.getId();
                        r2 = id;
                        if (id == null) {
                            r2 = r23;
                        }
                        idMal = aniIds2.getIdMal();
                        if (idMal == null) {
                            r33 = r24;
                        } else {
                            r33 = idMal;
                        }
                        if (r0 != 0) {
                            if (r0 != 0) {
                                str18 = str10;
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                aliases2 = kitsuMeta5.getAliases();
                                if (aliases2 != null) {
                                    str18 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str18 = str10;
                                }
                                if (str18 == null) {
                                    str18 = str12;
                                }
                            }
                        } else {
                            if (r0 != 0) {
                                str18 = str10;
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                aliases2 = kitsuMeta5.getAliases();
                                if (aliases2 != null) {
                                    str18 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str18 = str10;
                                }
                                if (str18 == null) {
                                    str18 = str12;
                                }
                            }
                        }
                        poster = kitsuMeta5.getPoster();
                        if (poster == null) {
                            r67 = r0;
                            r40 = r2;
                            url = poster;
                        } else if (r0 != 0) {
                            r69 = r0;
                            r42 = r2;
                            url = null;
                            r40 = r42;
                            r67 = r69;
                        } else {
                            r69 = r0;
                            r42 = r2;
                            url = null;
                            r40 = r42;
                            r67 = r69;
                        }
                        str19 = url;
                        background = kitsuMeta5.getBackground();
                        if (background == null) {
                            if (r67 == 0) {
                                obj3 = coroutine_suspended;
                            } else {
                                obj3 = coroutine_suspended;
                            }
                            str20 = null;
                            str21 = str20;
                            if (r67 != 0) {
                                logo = kitsuMeta5.getLogo();
                            } else {
                                logo = kitsuMeta5.getLogo();
                            }
                            str22 = logo;
                            r3 = r33;
                            r4 = r40;
                            stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                            videos = kitsuMeta5.getVideos();
                            if (videos == null) {
                                videos = CollectionsKt.emptyList();
                            }
                            list = videos;
                            if (!list.isEmpty()) {
                                size = list.size();
                            } else if (r67 != 0) {
                                size = 1;
                            } else {
                                size = 1;
                            }
                            if (list.isEmpty()) {
                                list6 = list;
                                i9 = size;
                                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                                i10 = 0;
                                r68 = r67;
                                while (r34.hasNext()) {
                                    int i110 = i10 + 1;
                                    if (i10 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    i11 = i10;
                                    TorraStreamKitsuHelper.KitsuVideo kitsuVideo5 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                    episode = kitsuVideo5.getEpisode();
                                    if (episode != null) {
                                        iIntValue = episode.intValue();
                                    } else {
                                        iIntValue = i11 + 1;
                                    }
                                    ArrayList arrayList115 = arrayList8;
                                    ?? r116 = r68;
                                    arrayList115.add(loadFromKitsu$createEpisode(r116, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo5));
                                    str21 = str21;
                                    r68 = r116;
                                    arrayList8 = arrayList115;
                                    kitsuMeta5 = kitsuMeta5;
                                    i9 = i9;
                                    torraStreamAnime = this;
                                    list6 = list6;
                                    charSequence = charSequence;
                                    str11 = str11;
                                    obj3 = obj3;
                                    i10 = i110;
                                    str19 = str19;
                                }
                                ArrayList arrayList116 = arrayList8;
                                ?? r117 = r68;
                                str23 = str21;
                                i4 = i9;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                arrayList2 = arrayList116;
                                r41 = r117;
                            } else {
                                int i111 = size;
                                r1 = r67;
                                str23 = str21;
                                i4 = i111;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                Iterable intRange5 = new IntRange(1, i4);
                                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange5, 10));
                                it = intRange5.iterator();
                                while (it.hasNext()) {
                                    ArrayList arrayList117 = arrayList;
                                    arrayList117.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                    arrayList = arrayList117;
                                }
                                r41 = r1;
                                arrayList2 = arrayList;
                            }
                            links = kitsuMeta6.getLinks();
                            if (links != null) {
                                list5 = links;
                                arrayList4 = new ArrayList();
                                while (r10.hasNext()) {
                                    List<TorraStreamKitsuHelper.KitsuLink> list11 = list5;
                                    ArrayList arrayList118 = arrayList2;
                                    if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                        arrayList4.add(obj8);
                                    }
                                    list5 = list11;
                                    arrayList2 = arrayList118;
                                }
                                arrayList3 = arrayList2;
                                arrayList5 = arrayList4;
                                i7 = 0;
                                arrayList6 = new ArrayList();
                                r11 = r4;
                                r10 = r3;
                                while (r11.hasNext()) {
                                    name2 = kitsuLink.getName();
                                    if (name2 == null) {
                                        arrayList7 = arrayList5;
                                        i8 = i7;
                                        r310 = r11;
                                        r36 = r10;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                    } else {
                                        arrayList7 = arrayList5;
                                        url2 = kitsuLink.getUrl();
                                        if (url2 != null) {
                                            i8 = i7;
                                            r39 = r11;
                                            r35 = r10;
                                            strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                            if (strSubstringAfterLast$default != null) {
                                                animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                            }
                                        } else {
                                            i8 = i7;
                                            r38 = r11;
                                            r34 = r10;
                                        }
                                        r34 = r35;
                                        r38 = r39;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                        r36 = r34;
                                        r310 = r38;
                                    }
                                    if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                        arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                    } else {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                    }
                                    r10 = r36;
                                    arrayList5 = arrayList7;
                                    i7 = i8;
                                    r11 = r310;
                                }
                                r37 = r11;
                                r32 = r10;
                                list2 = arrayList6;
                            } else {
                                arrayList3 = arrayList2;
                                r37 = r4;
                                r32 = r3;
                                list2 = null;
                            }
                            list3 = list2;
                            if (i2 != 0) {
                                Integer num16 = num3;
                                String str3115 = str12;
                                TvType tvType11 = TvType.AnimeMovie;
                                String str3116 = str23;
                                TorraStreamKitsuHelper.KitsuMeta kitsuMeta15 = kitsuMeta6;
                                ?? r319 = r32;
                                ?? r3110 = r37;
                                String str3117 = str24;
                                C00282 c00286 = new C00282(r3110, r319, num16, kitsuMeta15, str3116, str3117, str22, null);
                                c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                                c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                                c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta15);
                                c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                                c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                                c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                                c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3115);
                                c00272.L$7 = SpillingKt.nullOutSpilledVariable(num16);
                                c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                                c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                                c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                                c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3110);
                                c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r319);
                                c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                                c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3117);
                                c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3116);
                                c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                                c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                                c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                                c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                                c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                                c00272.I$0 = i2;
                                c00272.I$1 = i4;
                                c00272.label = 7;
                                C00271 c002713 = c00272;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3115, str25, tvType11, stringData, c00286, c002713);
                                str30 = str3115;
                                c00273 = c002713;
                                obj6 = obj4;
                                if (objNewMovieLoadResponse == obj6) {
                                    return obj6;
                                }
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            str26 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta16 = kitsuMeta6;
                            Integer num17 = num3;
                            C00271 c002714 = c00272;
                            r8 = r32;
                            ?? r118 = r37;
                            String str3118 = str24;
                            String str3119 = str12;
                            obj5 = obj4;
                            TvType tvType12 = TvType.Anime;
                            list4 = list3;
                            num7 = num17;
                            C00293 c00297 = new C00293(r118, r8, arrayList3, num17, kitsuMeta16, str26, str3118, str22, this, list4, null);
                            c002714.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c002714.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c002714.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta16);
                            c002714.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c002714.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c002714.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c002714.L$6 = SpillingKt.nullOutSpilledVariable(str3119);
                            c002714.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                            c002714.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c002714.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c002714.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c002714.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c002714.L$12 = SpillingKt.nullOutSpilledVariable((Object) r118);
                            c002714.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                            c002714.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c002714.L$15 = SpillingKt.nullOutSpilledVariable(str3118);
                            c002714.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                            c002714.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c002714.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c002714.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c002714.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c002714.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                            c002714.I$0 = i2;
                            c002714.I$1 = i4;
                            c002714.label = 8;
                            i5 = i2;
                            objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3119, str25, tvType12, false, c00297, c002714, 8, (Object) null);
                            str27 = str3119;
                            if (objTmdbToAnimeId == obj5) {
                                return obj5;
                            }
                            i6 = i5;
                            r17 = r8;
                            str28 = str26;
                            str29 = str18;
                            return (LoadResponse) objTmdbToAnimeId;
                        }
                        obj3 = coroutine_suspended;
                        str20 = background;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i112 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo6 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo6.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList119 = arrayList8;
                                ?? r119 = r68;
                                arrayList119.add(loadFromKitsu$createEpisode(r119, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo6));
                                str21 = str21;
                                r68 = r119;
                                arrayList8 = arrayList119;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i112;
                                str19 = str19;
                            }
                            ArrayList arrayList1110 = arrayList8;
                            ?? r1110 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList1110;
                            r41 = r1110;
                        } else {
                            int i113 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i113;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange6 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange6, 10));
                            it = intRange6.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList1111 = arrayList;
                                arrayList1111.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList1111;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list12 = list5;
                                ArrayList arrayList1112 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list12;
                                arrayList2 = arrayList1112;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num18 = num3;
                            String str31110 = str12;
                            TvType tvType13 = TvType.AnimeMovie;
                            String str31111 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta17 = kitsuMeta6;
                            ?? r3111 = r32;
                            ?? r3112 = r37;
                            String str31112 = str24;
                            C00282 c00287 = new C00282(r3112, r3111, num18, kitsuMeta17, str31111, str31112, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta17);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31110);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num18);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3112);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3111);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31112);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c002715 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31110, str25, tvType13, stringData, c00287, c002715);
                            str30 = str31110;
                            c00273 = c002715;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta18 = kitsuMeta6;
                        Integer num19 = num3;
                        C00271 c002716 = c00272;
                        r8 = r32;
                        ?? r1111 = r37;
                        String str31113 = str24;
                        String str31114 = str12;
                        obj5 = obj4;
                        TvType tvType14 = TvType.Anime;
                        list4 = list3;
                        num7 = num19;
                        C00293 c00298 = new C00293(r1111, r8, arrayList3, num19, kitsuMeta18, str26, str31113, str22, this, list4, null);
                        c002716.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c002716.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c002716.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta18);
                        c002716.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c002716.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c002716.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c002716.L$6 = SpillingKt.nullOutSpilledVariable(str31114);
                        c002716.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c002716.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c002716.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c002716.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c002716.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c002716.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1111);
                        c002716.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c002716.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c002716.L$15 = SpillingKt.nullOutSpilledVariable(str31113);
                        c002716.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c002716.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c002716.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c002716.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c002716.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c002716.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c002716.I$0 = i2;
                        c002716.I$1 = i4;
                        c002716.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31114, str25, tvType14, false, c00298, c002716, 8, (Object) null);
                        str27 = str31114;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                    break;
                } else {
                    try {
                        str4 = "anilist_id=" + str32;
                    } catch (Throwable th2) {
                        str5 = str3;
                        num = numericKitsuId;
                        str6 = null;
                        c00272 = c00274;
                        kitsuMeta2 = kitsuMeta;
                        kitsuMeta4 = kitsuMeta2;
                        text = str6;
                        str7 = str5;
                        if (text != null) {
                            animeData = TorraStreamUtilsKt.parseAnimeData(text);
                        } else {
                            animeData = str6;
                        }
                        name = kitsuMeta4.getName();
                        if (name == null) {
                            aliases = kitsuMeta4.getAliases();
                            if (aliases != null) {
                                name = (String) CollectionsKt.firstOrNull(aliases);
                            } else {
                                name = str6;
                            }
                            if (name == null) {
                                name = "Unknown";
                            }
                        }
                        str8 = name;
                        yearInt = kitsuMeta4.getYearInt();
                        if (yearInt == null) {
                            if (animeData != 0) {
                                yearInt = null;
                            } else {
                                yearInt = null;
                            }
                        }
                        num2 = yearInt;
                        str9 = str32;
                        if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                            i = 1;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            tvType = TvType.AnimeMovie;
                        } else {
                            tvType = TvType.TvSeries;
                        }
                        if (animeData != 0) {
                            if (StringsKt.toIntOrNull(str9) != null) {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                                if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                    intOrNull = StringsKt.toIntOrNull(str9);
                                }
                            } else {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                            }
                            r5 = str10;
                        } else {
                            if (StringsKt.toIntOrNull(str9) != null) {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                                if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                    intOrNull = StringsKt.toIntOrNull(str9);
                                }
                            } else {
                                charSequence = "kitsu:";
                                obj2 = objTmdbToAnimeId;
                                str10 = null;
                            }
                            r5 = str10;
                        }
                        if (animeData != 0) {
                            r5 = intOrNull;
                            mappings = animeData.getMappings();
                            if (mappings != null) {
                                malId = mappings.getMalId();
                            } else {
                                r5 = intOrNull;
                                r7 = str10;
                            }
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                        if (r7 == 0) {
                        }
                        r7 = malId;
                        aniIds = new AniIds(r5, r7);
                        ?? r27 = animeData;
                        str11 = str7;
                        r0 = r27;
                        kitsuMeta5 = kitsuMeta4;
                        str12 = str8;
                        str13 = str9;
                        r23 = r5;
                        num3 = num2;
                        r24 = r7;
                        num4 = num;
                        str14 = text;
                        i2 = i;
                        tvType2 = tvType;
                        aniIds2 = aniIds;
                        id = aniIds2.getId();
                        r2 = id;
                        if (id == null) {
                            r2 = r23;
                        }
                        idMal = aniIds2.getIdMal();
                        if (idMal == null) {
                            r33 = r24;
                        } else {
                            r33 = idMal;
                        }
                        if (r0 != 0) {
                            if (r0 != 0) {
                                str18 = str10;
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                aliases2 = kitsuMeta5.getAliases();
                                if (aliases2 != null) {
                                    str18 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str18 = str10;
                                }
                                if (str18 == null) {
                                    str18 = str12;
                                }
                            }
                        } else {
                            if (r0 != 0) {
                                str18 = str10;
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                aliases2 = kitsuMeta5.getAliases();
                                if (aliases2 != null) {
                                    str18 = (String) CollectionsKt.firstOrNull(aliases2);
                                } else {
                                    str18 = str10;
                                }
                                if (str18 == null) {
                                    str18 = str12;
                                }
                            }
                        }
                        poster = kitsuMeta5.getPoster();
                        if (poster == null) {
                            r67 = r0;
                            r40 = r2;
                            url = poster;
                        } else if (r0 != 0) {
                            r69 = r0;
                            r42 = r2;
                            url = null;
                            r40 = r42;
                            r67 = r69;
                        } else {
                            r69 = r0;
                            r42 = r2;
                            url = null;
                            r40 = r42;
                            r67 = r69;
                        }
                        str19 = url;
                        background = kitsuMeta5.getBackground();
                        if (background == null) {
                            if (r67 == 0) {
                                obj3 = coroutine_suspended;
                            } else {
                                obj3 = coroutine_suspended;
                            }
                            str20 = null;
                            str21 = str20;
                            if (r67 != 0) {
                                logo = kitsuMeta5.getLogo();
                            } else {
                                logo = kitsuMeta5.getLogo();
                            }
                            str22 = logo;
                            r3 = r33;
                            r4 = r40;
                            stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                            videos = kitsuMeta5.getVideos();
                            if (videos == null) {
                                videos = CollectionsKt.emptyList();
                            }
                            list = videos;
                            if (!list.isEmpty()) {
                                size = list.size();
                            } else if (r67 != 0) {
                                size = 1;
                            } else {
                                size = 1;
                            }
                            if (list.isEmpty()) {
                                list6 = list;
                                i9 = size;
                                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                                i10 = 0;
                                r68 = r67;
                                while (r34.hasNext()) {
                                    int i114 = i10 + 1;
                                    if (i10 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    i11 = i10;
                                    TorraStreamKitsuHelper.KitsuVideo kitsuVideo7 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                    episode = kitsuVideo7.getEpisode();
                                    if (episode != null) {
                                        iIntValue = episode.intValue();
                                    } else {
                                        iIntValue = i11 + 1;
                                    }
                                    ArrayList arrayList1113 = arrayList8;
                                    ?? r1112 = r68;
                                    arrayList1113.add(loadFromKitsu$createEpisode(r1112, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo7));
                                    str21 = str21;
                                    r68 = r1112;
                                    arrayList8 = arrayList1113;
                                    kitsuMeta5 = kitsuMeta5;
                                    i9 = i9;
                                    torraStreamAnime = this;
                                    list6 = list6;
                                    charSequence = charSequence;
                                    str11 = str11;
                                    obj3 = obj3;
                                    i10 = i114;
                                    str19 = str19;
                                }
                                ArrayList arrayList1114 = arrayList8;
                                ?? r1113 = r68;
                                str23 = str21;
                                i4 = i9;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                arrayList2 = arrayList1114;
                                r41 = r1113;
                            } else {
                                int i115 = size;
                                r1 = r67;
                                str23 = str21;
                                i4 = i115;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                Iterable intRange7 = new IntRange(1, i4);
                                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange7, 10));
                                it = intRange7.iterator();
                                while (it.hasNext()) {
                                    ArrayList arrayList1115 = arrayList;
                                    arrayList1115.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                    arrayList = arrayList1115;
                                }
                                r41 = r1;
                                arrayList2 = arrayList;
                            }
                            links = kitsuMeta6.getLinks();
                            if (links != null) {
                                list5 = links;
                                arrayList4 = new ArrayList();
                                while (r10.hasNext()) {
                                    List<TorraStreamKitsuHelper.KitsuLink> list13 = list5;
                                    ArrayList arrayList1116 = arrayList2;
                                    if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                        arrayList4.add(obj8);
                                    }
                                    list5 = list13;
                                    arrayList2 = arrayList1116;
                                }
                                arrayList3 = arrayList2;
                                arrayList5 = arrayList4;
                                i7 = 0;
                                arrayList6 = new ArrayList();
                                r11 = r4;
                                r10 = r3;
                                while (r11.hasNext()) {
                                    name2 = kitsuLink.getName();
                                    if (name2 == null) {
                                        arrayList7 = arrayList5;
                                        i8 = i7;
                                        r310 = r11;
                                        r36 = r10;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                    } else {
                                        arrayList7 = arrayList5;
                                        url2 = kitsuLink.getUrl();
                                        if (url2 != null) {
                                            i8 = i7;
                                            r39 = r11;
                                            r35 = r10;
                                            strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                            if (strSubstringAfterLast$default != null) {
                                                animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                            }
                                        } else {
                                            i8 = i7;
                                            r38 = r11;
                                            r34 = r10;
                                        }
                                        r34 = r35;
                                        r38 = r39;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                        r36 = r34;
                                        r310 = r38;
                                    }
                                    if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                        arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                    } else {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                    }
                                    r10 = r36;
                                    arrayList5 = arrayList7;
                                    i7 = i8;
                                    r11 = r310;
                                }
                                r37 = r11;
                                r32 = r10;
                                list2 = arrayList6;
                            } else {
                                arrayList3 = arrayList2;
                                r37 = r4;
                                r32 = r3;
                                list2 = null;
                            }
                            list3 = list2;
                            if (i2 != 0) {
                                Integer num110 = num3;
                                String str31115 = str12;
                                TvType tvType15 = TvType.AnimeMovie;
                                String str31116 = str23;
                                TorraStreamKitsuHelper.KitsuMeta kitsuMeta19 = kitsuMeta6;
                                ?? r3113 = r32;
                                ?? r3114 = r37;
                                String str31117 = str24;
                                C00282 c00288 = new C00282(r3114, r3113, num110, kitsuMeta19, str31116, str31117, str22, null);
                                c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                                c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                                c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta19);
                                c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                                c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                                c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                                c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31115);
                                c00272.L$7 = SpillingKt.nullOutSpilledVariable(num110);
                                c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                                c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                                c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                                c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3114);
                                c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3113);
                                c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                                c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31117);
                                c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31116);
                                c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                                c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                                c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                                c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                                c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                                c00272.I$0 = i2;
                                c00272.I$1 = i4;
                                c00272.label = 7;
                                C00271 c002717 = c00272;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31115, str25, tvType15, stringData, c00288, c002717);
                                str30 = str31115;
                                c00273 = c002717;
                                obj6 = obj4;
                                if (objNewMovieLoadResponse == obj6) {
                                    return obj6;
                                }
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            str26 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta110 = kitsuMeta6;
                            Integer num111 = num3;
                            C00271 c002718 = c00272;
                            r8 = r32;
                            ?? r1114 = r37;
                            String str31118 = str24;
                            String str31119 = str12;
                            obj5 = obj4;
                            TvType tvType16 = TvType.Anime;
                            list4 = list3;
                            num7 = num111;
                            C00293 c00299 = new C00293(r1114, r8, arrayList3, num111, kitsuMeta110, str26, str31118, str22, this, list4, null);
                            c002718.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c002718.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c002718.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta110);
                            c002718.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c002718.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c002718.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c002718.L$6 = SpillingKt.nullOutSpilledVariable(str31119);
                            c002718.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                            c002718.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c002718.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c002718.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c002718.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c002718.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1114);
                            c002718.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                            c002718.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c002718.L$15 = SpillingKt.nullOutSpilledVariable(str31118);
                            c002718.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                            c002718.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c002718.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c002718.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c002718.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c002718.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                            c002718.I$0 = i2;
                            c002718.I$1 = i4;
                            c002718.label = 8;
                            i5 = i2;
                            objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31119, str25, tvType16, false, c00299, c002718, 8, (Object) null);
                            str27 = str31119;
                            if (objTmdbToAnimeId == obj5) {
                                return obj5;
                            }
                            i6 = i5;
                            r17 = r8;
                            str28 = str26;
                            str29 = str18;
                            return (LoadResponse) objTmdbToAnimeId;
                        }
                        obj3 = coroutine_suspended;
                        str20 = background;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i116 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo8 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo8.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList1117 = arrayList8;
                                ?? r1115 = r68;
                                arrayList1117.add(loadFromKitsu$createEpisode(r1115, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo8));
                                str21 = str21;
                                r68 = r1115;
                                arrayList8 = arrayList1117;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i116;
                                str19 = str19;
                            }
                            ArrayList arrayList1118 = arrayList8;
                            ?? r1116 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList1118;
                            r41 = r1116;
                        } else {
                            int i117 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i117;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange8 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange8, 10));
                            it = intRange8.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList1119 = arrayList;
                                arrayList1119.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList1119;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list14 = list5;
                                ArrayList arrayList11110 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list14;
                                arrayList2 = arrayList11110;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num112 = num3;
                            String str311110 = str12;
                            TvType tvType17 = TvType.AnimeMovie;
                            String str311111 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta111 = kitsuMeta6;
                            ?? r3115 = r32;
                            ?? r3116 = r37;
                            String str311112 = str24;
                            C00282 c00289 = new C00282(r3116, r3115, num112, kitsuMeta111, str311111, str311112, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311110);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num112);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3116);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3115);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311112);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c002719 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311110, str25, tvType17, stringData, c00289, c002719);
                            str30 = str311110;
                            c00273 = c002719;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta112 = kitsuMeta6;
                        Integer num113 = num3;
                        C00271 c0027110 = c00272;
                        r8 = r32;
                        ?? r1117 = r37;
                        String str311113 = str24;
                        String str311114 = str12;
                        obj5 = obj4;
                        TvType tvType18 = TvType.Anime;
                        list4 = list3;
                        num7 = num113;
                        C00293 c002910 = new C00293(r1117, r8, arrayList3, num113, kitsuMeta112, str26, str311113, str22, this, list4, null);
                        c0027110.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c0027110.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c0027110.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta112);
                        c0027110.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c0027110.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c0027110.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c0027110.L$6 = SpillingKt.nullOutSpilledVariable(str311114);
                        c0027110.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c0027110.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c0027110.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c0027110.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c0027110.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c0027110.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1117);
                        c0027110.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c0027110.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c0027110.L$15 = SpillingKt.nullOutSpilledVariable(str311113);
                        c0027110.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c0027110.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c0027110.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c0027110.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c0027110.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c0027110.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c0027110.I$0 = i2;
                        c0027110.I$1 = i4;
                        c0027110.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311114, str25, tvType18, false, c002910, c0027110, 8, (Object) null);
                        str27 = str311114;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                }
                Requests app3 = MainActivityKt.getApp();
                String str3120 = "https://api.ani.zip/mappings?" + str4;
                c00274.L$0 = str3;
                c00274.L$1 = str32;
                c00274.L$2 = kitsuMeta;
                c00274.L$3 = numericKitsuId;
                c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                c00274.label = 5;
                num = numericKitsuId;
                str5 = str3;
                str6 = null;
                try {
                    obj = Requests.get$default(app3, str3120, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                    c00272 = c00274;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kitsuMeta3 = kitsuMeta;
                    try {
                        text = ((NiceResponse) obj).getText();
                        kitsuMeta4 = kitsuMeta3;
                        str7 = str5;
                    } catch (Throwable th3) {
                        kitsuMeta2 = kitsuMeta3;
                        kitsuMeta4 = kitsuMeta2;
                        text = str6;
                        str7 = str5;
                    }
                    if (text != null) {
                        animeData = TorraStreamUtilsKt.parseAnimeData(text);
                    } else {
                        animeData = str6;
                    }
                    name = kitsuMeta4.getName();
                    if (name == null) {
                        aliases = kitsuMeta4.getAliases();
                        if (aliases != null) {
                            name = (String) CollectionsKt.firstOrNull(aliases);
                        } else {
                            name = str6;
                        }
                        if (name == null) {
                            name = "Unknown";
                        }
                    }
                    str8 = name;
                    yearInt = kitsuMeta4.getYearInt();
                    if (yearInt == null) {
                        if (animeData != 0 || (episodes = animeData.getEpisodes()) == null || (metaEpisode = episodes.get("1")) == null || (airDateUtc = metaEpisode.getAirDateUtc()) == null || (strTake = StringsKt.take(airDateUtc, 4)) == null) {
                            yearInt = null;
                        } else {
                            yearInt = StringsKt.toIntOrNull(strTake);
                        }
                    }
                    num2 = yearInt;
                    str9 = str32;
                    if (StringsKt.equals(kitsuMeta4.getType(), "movie", true) || StringsKt.equals(kitsuMeta4.getAnimeType(), "movie", true)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    if (animeData != 0 || (mappings2 = animeData.getMappings()) == null || (anilistId = mappings2.getAnilistId()) == null) {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    } else {
                        charSequence = "kitsu:";
                        r5 = anilistId;
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    if (animeData != 0) {
                        r5 = intOrNull;
                        mappings = animeData.getMappings();
                        if (mappings != null) {
                            malId = mappings.getMalId();
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                    if (r7 == 0 || r5 != 0) {
                        r7 = malId;
                        aniIds = new AniIds(r5, r7);
                        ?? r28 = animeData;
                        str11 = str7;
                        r0 = r28;
                        kitsuMeta5 = kitsuMeta4;
                        str12 = str8;
                        str13 = str9;
                        r23 = r5;
                        num3 = num2;
                        r24 = r7;
                        num4 = num;
                        str14 = text;
                        i2 = i;
                        tvType2 = tvType;
                    } else {
                        c00272.L$0 = str7;
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str9);
                        c00272.L$2 = kitsuMeta4;
                        c00272.L$3 = num;
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(text);
                        c00272.L$5 = animeData;
                        c00272.L$6 = str8;
                        c00272.L$7 = num2;
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType);
                        c00272.L$9 = r5;
                        c00272.L$10 = r7;
                        c00272.I$0 = i;
                        c00272.label = 6;
                        objTmdbToAnimeId = torraStreamAnime.tmdbToAnimeId(str8, num2, tvType, c00272);
                        if (objTmdbToAnimeId == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str40 = text;
                        str15 = str8;
                        str16 = str40;
                        num5 = num;
                        r9 = animeData;
                        num6 = num2;
                        r6 = r5;
                        i3 = i;
                        str17 = str9;
                        r12 = r7;
                        aniIds = (AniIds) objTmdbToAnimeId;
                        str13 = str17;
                        r23 = r6;
                        r24 = r12;
                        str14 = str16;
                        num4 = num5;
                        kitsuMeta5 = kitsuMeta4;
                        str12 = str15;
                        i2 = i3;
                        num3 = num6;
                        str11 = str7;
                        r0 = r9;
                        tvType2 = tvType;
                    }
                    aniIds2 = aniIds;
                    id = aniIds2.getId();
                    r2 = id;
                    if (id == null) {
                        r2 = r23;
                    }
                    idMal = aniIds2.getIdMal();
                    if (idMal == null) {
                        r33 = r24;
                    } else {
                        r33 = idMal;
                    }
                    if (r0 != 0 || (titles2 = r0.getTitles()) == null || (str18 = titles2.get("ja")) == null) {
                        if (r0 != 0 || (titles = r0.getTitles()) == null) {
                            str18 = str10;
                        } else {
                            str18 = titles.get("x-jat");
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    }
                    poster = kitsuMeta5.getPoster();
                    if (poster == null) {
                        if (r0 != 0 || (images3 = r0.getImages()) == null) {
                            r69 = r0;
                            r42 = r2;
                        } else {
                            Iterator it2 = images3.iterator();
                            ?? r20 = r0;
                            ?? r21 = r2;
                            while (true) {
                                if (it2.hasNext()) {
                                    next3 = it2.next();
                                    r610 = r20;
                                    r43 = r21;
                                    if (!StringsKt.equals(((ImageData) next3).getCoverType(), "Poster", true)) {
                                        r20 = r610;
                                        r21 = r43;
                                    }
                                } else {
                                    r610 = r20;
                                    r43 = r21;
                                    next3 = null;
                                }
                            }
                            ImageData imageData = (ImageData) next3;
                            r42 = r43;
                            r69 = r610;
                            if (imageData != null) {
                                url = imageData.getUrl();
                                r40 = r43;
                                r67 = r610;
                            }
                        }
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    } else {
                        r67 = r0;
                        r40 = r2;
                        url = poster;
                    }
                    str19 = url;
                    background = kitsuMeta5.getBackground();
                    if (background == null) {
                        if (r67 == 0 && (images2 = r67.getImages()) != null) {
                            List<ImageData> list15 = images2;
                            int i20 = 0;
                            Iterator it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    next2 = it3.next();
                                    List<ImageData> list16 = list15;
                                    int i21 = i20;
                                    obj3 = coroutine_suspended;
                                    if (!StringsKt.equals(((ImageData) next2).getCoverType(), "Fanart", true)) {
                                        list15 = list16;
                                        i20 = i21;
                                        coroutine_suspended = obj3;
                                    }
                                } else {
                                    obj3 = coroutine_suspended;
                                    next2 = null;
                                }
                            }
                            ImageData imageData2 = (ImageData) next2;
                            if (imageData2 != null) {
                                background = imageData2.getUrl();
                            }
                            str21 = str20;
                            if (r67 != 0 || (images = r67.getImages()) == null) {
                                logo = kitsuMeta5.getLogo();
                            } else {
                                Iterator it4 = images.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        next = it4.next();
                                        Iterator it5 = it4;
                                        if (!Intrinsics.areEqual(((ImageData) next).getCoverType(), "Clearlogo")) {
                                            it4 = it5;
                                        }
                                    } else {
                                        next = null;
                                    }
                                }
                                ImageData imageData3 = (ImageData) next;
                                if (imageData3 == null || (logo = imageData3.getUrl()) == null) {
                                    logo = kitsuMeta5.getLogo();
                                }
                            }
                            str22 = logo;
                            r3 = r33;
                            r4 = r40;
                            stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                            videos = kitsuMeta5.getVideos();
                            if (videos == null) {
                                videos = CollectionsKt.emptyList();
                            }
                            list = videos;
                            if (!list.isEmpty()) {
                                size = list.size();
                            } else if (r67 != 0 || (episodes2 = r67.getEpisodes()) == null) {
                                size = 1;
                            } else {
                                size = episodes2.size();
                            }
                            if (list.isEmpty()) {
                                list6 = list;
                                i9 = size;
                                arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                                i10 = 0;
                                r68 = r67;
                                while (r34.hasNext()) {
                                    int i118 = i10 + 1;
                                    if (i10 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    i11 = i10;
                                    TorraStreamKitsuHelper.KitsuVideo kitsuVideo9 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                    episode = kitsuVideo9.getEpisode();
                                    if (episode != null) {
                                        iIntValue = episode.intValue();
                                    } else {
                                        iIntValue = i11 + 1;
                                    }
                                    ArrayList arrayList11111 = arrayList8;
                                    ?? r1118 = r68;
                                    arrayList11111.add(loadFromKitsu$createEpisode(r1118, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo9));
                                    str21 = str21;
                                    r68 = r1118;
                                    arrayList8 = arrayList11111;
                                    kitsuMeta5 = kitsuMeta5;
                                    i9 = i9;
                                    torraStreamAnime = this;
                                    list6 = list6;
                                    charSequence = charSequence;
                                    str11 = str11;
                                    obj3 = obj3;
                                    i10 = i118;
                                    str19 = str19;
                                }
                                ArrayList arrayList11112 = arrayList8;
                                ?? r1119 = r68;
                                str23 = str21;
                                i4 = i9;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                arrayList2 = arrayList11112;
                                r41 = r1119;
                            } else {
                                int i119 = size;
                                r1 = r67;
                                str23 = str21;
                                i4 = i119;
                                kitsuMeta6 = kitsuMeta5;
                                str24 = str19;
                                str25 = str11;
                                obj4 = obj3;
                                charSequence2 = charSequence;
                                Iterable intRange9 = new IntRange(1, i4);
                                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange9, 10));
                                it = intRange9.iterator();
                                while (it.hasNext()) {
                                    ArrayList arrayList11113 = arrayList;
                                    arrayList11113.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                    arrayList = arrayList11113;
                                }
                                r41 = r1;
                                arrayList2 = arrayList;
                            }
                            links = kitsuMeta6.getLinks();
                            if (links != null) {
                                list5 = links;
                                arrayList4 = new ArrayList();
                                while (r10.hasNext()) {
                                    List<TorraStreamKitsuHelper.KitsuLink> list17 = list5;
                                    ArrayList arrayList11114 = arrayList2;
                                    if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                        arrayList4.add(obj8);
                                    }
                                    list5 = list17;
                                    arrayList2 = arrayList11114;
                                }
                                arrayList3 = arrayList2;
                                arrayList5 = arrayList4;
                                i7 = 0;
                                arrayList6 = new ArrayList();
                                r11 = r4;
                                r10 = r3;
                                while (r11.hasNext()) {
                                    name2 = kitsuLink.getName();
                                    if (name2 == null) {
                                        arrayList7 = arrayList5;
                                        i8 = i7;
                                        r310 = r11;
                                        r36 = r10;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                    } else {
                                        arrayList7 = arrayList5;
                                        url2 = kitsuLink.getUrl();
                                        if (url2 != null) {
                                            i8 = i7;
                                            r39 = r11;
                                            r35 = r10;
                                            strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                            if (strSubstringAfterLast$default != null) {
                                                animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                            }
                                        } else {
                                            i8 = i7;
                                            r38 = r11;
                                            r34 = r10;
                                        }
                                        r34 = r35;
                                        r38 = r39;
                                        animeSearchResponseNewAnimeSearchResponse$default = null;
                                        r36 = r34;
                                        r310 = r38;
                                    }
                                    if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                        arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                    } else {
                                        r34 = r35;
                                        r38 = r39;
                                        r36 = r35;
                                        r310 = r39;
                                    }
                                    r10 = r36;
                                    arrayList5 = arrayList7;
                                    i7 = i8;
                                    r11 = r310;
                                }
                                r37 = r11;
                                r32 = r10;
                                list2 = arrayList6;
                            } else {
                                arrayList3 = arrayList2;
                                r37 = r4;
                                r32 = r3;
                                list2 = null;
                            }
                            list3 = list2;
                            if (i2 != 0) {
                                Integer num114 = num3;
                                String str311115 = str12;
                                TvType tvType19 = TvType.AnimeMovie;
                                String str311116 = str23;
                                TorraStreamKitsuHelper.KitsuMeta kitsuMeta113 = kitsuMeta6;
                                ?? r3117 = r32;
                                ?? r3118 = r37;
                                String str311117 = str24;
                                C00282 c002810 = new C00282(r3118, r3117, num114, kitsuMeta113, str311116, str311117, str22, null);
                                c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                                c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                                c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta113);
                                c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                                c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                                c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                                c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311115);
                                c00272.L$7 = SpillingKt.nullOutSpilledVariable(num114);
                                c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                                c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                                c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                                c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                                c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3118);
                                c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3117);
                                c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                                c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311117);
                                c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311116);
                                c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                                c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                                c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                                c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                                c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                                c00272.I$0 = i2;
                                c00272.I$1 = i4;
                                c00272.label = 7;
                                C00271 c0027111 = c00272;
                                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311115, str25, tvType19, stringData, c002810, c0027111);
                                str30 = str311115;
                                c00273 = c0027111;
                                obj6 = obj4;
                                if (objNewMovieLoadResponse == obj6) {
                                    return obj6;
                                }
                                return (LoadResponse) objNewMovieLoadResponse;
                            }
                            str26 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta114 = kitsuMeta6;
                            Integer num115 = num3;
                            C00271 c0027112 = c00272;
                            r8 = r32;
                            ?? r11110 = r37;
                            String str311118 = str24;
                            String str311119 = str12;
                            obj5 = obj4;
                            TvType tvType110 = TvType.Anime;
                            list4 = list3;
                            num7 = num115;
                            C00293 c002911 = new C00293(r11110, r8, arrayList3, num115, kitsuMeta114, str26, str311118, str22, this, list4, null);
                            c0027112.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c0027112.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c0027112.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta114);
                            c0027112.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c0027112.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c0027112.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c0027112.L$6 = SpillingKt.nullOutSpilledVariable(str311119);
                            c0027112.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                            c0027112.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c0027112.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c0027112.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c0027112.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c0027112.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11110);
                            c0027112.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                            c0027112.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c0027112.L$15 = SpillingKt.nullOutSpilledVariable(str311118);
                            c0027112.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                            c0027112.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c0027112.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c0027112.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c0027112.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c0027112.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                            c0027112.I$0 = i2;
                            c0027112.I$1 = i4;
                            c0027112.label = 8;
                            i5 = i2;
                            objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311119, str25, tvType110, false, c002911, c0027112, 8, (Object) null);
                            str27 = str311119;
                            if (objTmdbToAnimeId == obj5) {
                                return obj5;
                            }
                            i6 = i5;
                            r17 = r8;
                            str28 = str26;
                            str29 = str18;
                            return (LoadResponse) objTmdbToAnimeId;
                        }
                        obj3 = coroutine_suspended;
                        str20 = null;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i1110 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo10 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo10.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList11115 = arrayList8;
                                ?? r11111 = r68;
                                arrayList11115.add(loadFromKitsu$createEpisode(r11111, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo10));
                                str21 = str21;
                                r68 = r11111;
                                arrayList8 = arrayList11115;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i1110;
                                str19 = str19;
                            }
                            ArrayList arrayList11116 = arrayList8;
                            ?? r11112 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList11116;
                            r41 = r11112;
                        } else {
                            int i1111 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i1111;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange10 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange10, 10));
                            it = intRange10.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList11117 = arrayList;
                                arrayList11117.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList11117;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list18 = list5;
                                ArrayList arrayList11118 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list18;
                                arrayList2 = arrayList11118;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num116 = num3;
                            String str3111110 = str12;
                            TvType tvType111 = TvType.AnimeMovie;
                            String str3111111 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta115 = kitsuMeta6;
                            ?? r3119 = r32;
                            ?? r31110 = r37;
                            String str3111112 = str24;
                            C00282 c002811 = new C00282(r31110, r3119, num116, kitsuMeta115, str3111111, str3111112, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta115);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3111110);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num116);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31110);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3119);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3111112);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111111);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c0027113 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3111110, str25, tvType111, stringData, c002811, c0027113);
                            str30 = str3111110;
                            c00273 = c0027113;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta116 = kitsuMeta6;
                        Integer num117 = num3;
                        C00271 c0027114 = c00272;
                        r8 = r32;
                        ?? r11113 = r37;
                        String str3111113 = str24;
                        String str3111114 = str12;
                        obj5 = obj4;
                        TvType tvType112 = TvType.Anime;
                        list4 = list3;
                        num7 = num117;
                        C00293 c002912 = new C00293(r11113, r8, arrayList3, num117, kitsuMeta116, str26, str3111113, str22, this, list4, null);
                        c0027114.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c0027114.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c0027114.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta116);
                        c0027114.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c0027114.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c0027114.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c0027114.L$6 = SpillingKt.nullOutSpilledVariable(str3111114);
                        c0027114.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c0027114.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c0027114.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c0027114.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c0027114.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c0027114.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11113);
                        c0027114.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c0027114.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c0027114.L$15 = SpillingKt.nullOutSpilledVariable(str3111113);
                        c0027114.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c0027114.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c0027114.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c0027114.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c0027114.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c0027114.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c0027114.I$0 = i2;
                        c0027114.I$1 = i4;
                        c0027114.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3111114, str25, tvType112, false, c002912, c0027114, 8, (Object) null);
                        str27 = str3111114;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                    obj3 = coroutine_suspended;
                    str20 = background;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i1112 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo11 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo11.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList11119 = arrayList8;
                            ?? r11114 = r68;
                            arrayList11119.add(loadFromKitsu$createEpisode(r11114, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo11));
                            str21 = str21;
                            r68 = r11114;
                            arrayList8 = arrayList11119;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i1112;
                            str19 = str19;
                        }
                        ArrayList arrayList111110 = arrayList8;
                        ?? r11115 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList111110;
                        r41 = r11115;
                    } else {
                        int i1113 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i1113;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange11 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange11, 10));
                        it = intRange11.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList111111 = arrayList;
                            arrayList111111.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList111111;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list19 = list5;
                            ArrayList arrayList111112 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list19;
                            arrayList2 = arrayList111112;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num118 = num3;
                        String str3111115 = str12;
                        TvType tvType113 = TvType.AnimeMovie;
                        String str3111116 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta117 = kitsuMeta6;
                        ?? r31111 = r32;
                        ?? r31112 = r37;
                        String str3111117 = str24;
                        C00282 c002812 = new C00282(r31112, r31111, num118, kitsuMeta117, str3111116, str3111117, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta117);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3111115);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num118);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31112);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31111);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3111117);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111116);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c0027115 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3111115, str25, tvType113, stringData, c002812, c0027115);
                        str30 = str3111115;
                        c00273 = c0027115;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta118 = kitsuMeta6;
                    Integer num119 = num3;
                    C00271 c0027116 = c00272;
                    r8 = r32;
                    ?? r11116 = r37;
                    String str3111118 = str24;
                    String str3111119 = str12;
                    obj5 = obj4;
                    TvType tvType114 = TvType.Anime;
                    list4 = list3;
                    num7 = num119;
                    C00293 c002913 = new C00293(r11116, r8, arrayList3, num119, kitsuMeta118, str26, str3111118, str22, this, list4, null);
                    c0027116.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c0027116.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c0027116.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta118);
                    c0027116.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c0027116.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c0027116.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c0027116.L$6 = SpillingKt.nullOutSpilledVariable(str3111119);
                    c0027116.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c0027116.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c0027116.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0027116.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c0027116.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0027116.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11116);
                    c0027116.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c0027116.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c0027116.L$15 = SpillingKt.nullOutSpilledVariable(str3111118);
                    c0027116.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c0027116.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c0027116.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0027116.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c0027116.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0027116.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c0027116.I$0 = i2;
                    c0027116.I$1 = i4;
                    c0027116.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3111119, str25, tvType114, false, c002913, c0027116, 8, (Object) null);
                    str27 = str3111119;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                } catch (Throwable th4) {
                    c00272 = c00274;
                    kitsuMeta2 = kitsuMeta;
                    kitsuMeta4 = kitsuMeta2;
                    text = str6;
                    str7 = str5;
                    if (text != null) {
                        animeData = TorraStreamUtilsKt.parseAnimeData(text);
                    } else {
                        animeData = str6;
                    }
                    name = kitsuMeta4.getName();
                    if (name == null) {
                        aliases = kitsuMeta4.getAliases();
                        if (aliases != null) {
                            name = (String) CollectionsKt.firstOrNull(aliases);
                        } else {
                            name = str6;
                        }
                        if (name == null) {
                            name = "Unknown";
                        }
                    }
                    str8 = name;
                    yearInt = kitsuMeta4.getYearInt();
                    if (yearInt == null) {
                        if (animeData != 0) {
                            yearInt = null;
                        } else {
                            yearInt = null;
                        }
                    }
                    num2 = yearInt;
                    str9 = str32;
                    if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    if (animeData != 0) {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    } else {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    }
                    if (animeData != 0) {
                        r5 = intOrNull;
                        mappings = animeData.getMappings();
                        if (mappings != null) {
                            malId = mappings.getMalId();
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                    if (r7 == 0) {
                    }
                    r7 = malId;
                    aniIds = new AniIds(r5, r7);
                    ?? r29 = animeData;
                    str11 = str7;
                    r0 = r29;
                    kitsuMeta5 = kitsuMeta4;
                    str12 = str8;
                    str13 = str9;
                    r23 = r5;
                    num3 = num2;
                    r24 = r7;
                    num4 = num;
                    str14 = text;
                    i2 = i;
                    tvType2 = tvType;
                    aniIds2 = aniIds;
                    id = aniIds2.getId();
                    r2 = id;
                    if (id == null) {
                        r2 = r23;
                    }
                    idMal = aniIds2.getIdMal();
                    if (idMal == null) {
                        r33 = r24;
                    } else {
                        r33 = idMal;
                    }
                    if (r0 != 0) {
                        if (r0 != 0) {
                            str18 = str10;
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    } else {
                        if (r0 != 0) {
                            str18 = str10;
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    }
                    poster = kitsuMeta5.getPoster();
                    if (poster == null) {
                        r67 = r0;
                        r40 = r2;
                        url = poster;
                    } else if (r0 != 0) {
                        r69 = r0;
                        r42 = r2;
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    } else {
                        r69 = r0;
                        r42 = r2;
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    }
                    str19 = url;
                    background = kitsuMeta5.getBackground();
                    if (background == null) {
                        if (r67 == 0) {
                            obj3 = coroutine_suspended;
                        } else {
                            obj3 = coroutine_suspended;
                        }
                        str20 = null;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i1114 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo12 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo12.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList111113 = arrayList8;
                                ?? r11117 = r68;
                                arrayList111113.add(loadFromKitsu$createEpisode(r11117, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo12));
                                str21 = str21;
                                r68 = r11117;
                                arrayList8 = arrayList111113;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i1114;
                                str19 = str19;
                            }
                            ArrayList arrayList111114 = arrayList8;
                            ?? r11118 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList111114;
                            r41 = r11118;
                        } else {
                            int i1115 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i1115;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange12 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange12, 10));
                            it = intRange12.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList111115 = arrayList;
                                arrayList111115.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList111115;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list110 = list5;
                                ArrayList arrayList111116 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list110;
                                arrayList2 = arrayList111116;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num1110 = num3;
                            String str31111110 = str12;
                            TvType tvType115 = TvType.AnimeMovie;
                            String str31111111 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta119 = kitsuMeta6;
                            ?? r31113 = r32;
                            ?? r31114 = r37;
                            String str31111112 = str24;
                            C00282 c002813 = new C00282(r31114, r31113, num1110, kitsuMeta119, str31111111, str31111112, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta119);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31111110);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num1110);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31114);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31113);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31111112);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111111);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c0027117 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31111110, str25, tvType115, stringData, c002813, c0027117);
                            str30 = str31111110;
                            c00273 = c0027117;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta1110 = kitsuMeta6;
                        Integer num1111 = num3;
                        C00271 c0027118 = c00272;
                        r8 = r32;
                        ?? r11119 = r37;
                        String str31111113 = str24;
                        String str31111114 = str12;
                        obj5 = obj4;
                        TvType tvType116 = TvType.Anime;
                        list4 = list3;
                        num7 = num1111;
                        C00293 c002914 = new C00293(r11119, r8, arrayList3, num1111, kitsuMeta1110, str26, str31111113, str22, this, list4, null);
                        c0027118.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c0027118.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c0027118.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1110);
                        c0027118.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c0027118.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c0027118.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c0027118.L$6 = SpillingKt.nullOutSpilledVariable(str31111114);
                        c0027118.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c0027118.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c0027118.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c0027118.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c0027118.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c0027118.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11119);
                        c0027118.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c0027118.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c0027118.L$15 = SpillingKt.nullOutSpilledVariable(str31111113);
                        c0027118.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c0027118.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c0027118.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c0027118.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c0027118.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c0027118.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c0027118.I$0 = i2;
                        c0027118.I$1 = i4;
                        c0027118.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31111114, str25, tvType116, false, c002914, c0027118, 8, (Object) null);
                        str27 = str31111114;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                    obj3 = coroutine_suspended;
                    str20 = background;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i1116 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo13 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo13.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList111117 = arrayList8;
                            ?? r111110 = r68;
                            arrayList111117.add(loadFromKitsu$createEpisode(r111110, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo13));
                            str21 = str21;
                            r68 = r111110;
                            arrayList8 = arrayList111117;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i1116;
                            str19 = str19;
                        }
                        ArrayList arrayList111118 = arrayList8;
                        ?? r111111 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList111118;
                        r41 = r111111;
                    } else {
                        int i1117 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i1117;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange13 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange13, 10));
                        it = intRange13.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList111119 = arrayList;
                            arrayList111119.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList111119;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list111 = list5;
                            ArrayList arrayList1111110 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list111;
                            arrayList2 = arrayList1111110;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num1112 = num3;
                        String str31111115 = str12;
                        TvType tvType117 = TvType.AnimeMovie;
                        String str31111116 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta1111 = kitsuMeta6;
                        ?? r31115 = r32;
                        ?? r31116 = r37;
                        String str31111117 = str24;
                        C00282 c002814 = new C00282(r31116, r31115, num1112, kitsuMeta1111, str31111116, str31111117, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1111);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31111115);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num1112);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31116);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31115);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31111117);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111116);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c0027119 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31111115, str25, tvType117, stringData, c002814, c0027119);
                        str30 = str31111115;
                        c00273 = c0027119;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta1112 = kitsuMeta6;
                    Integer num1113 = num3;
                    C00271 c00271110 = c00272;
                    r8 = r32;
                    ?? r111112 = r37;
                    String str31111118 = str24;
                    String str31111119 = str12;
                    obj5 = obj4;
                    TvType tvType118 = TvType.Anime;
                    list4 = list3;
                    num7 = num1113;
                    C00293 c002915 = new C00293(r111112, r8, arrayList3, num1113, kitsuMeta1112, str26, str31111118, str22, this, list4, null);
                    c00271110.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00271110.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00271110.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1112);
                    c00271110.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00271110.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00271110.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00271110.L$6 = SpillingKt.nullOutSpilledVariable(str31111119);
                    c00271110.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c00271110.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00271110.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00271110.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00271110.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00271110.L$12 = SpillingKt.nullOutSpilledVariable((Object) r111112);
                    c00271110.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c00271110.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00271110.L$15 = SpillingKt.nullOutSpilledVariable(str31111118);
                    c00271110.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c00271110.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00271110.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00271110.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00271110.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00271110.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c00271110.I$0 = i2;
                    c00271110.I$1 = i4;
                    c00271110.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31111119, str25, tvType118, false, c002915, c00271110, 8, (Object) null);
                    str27 = str31111119;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
            case 1:
                str32 = (String) c00274.L$1;
                str31 = (String) c00274.L$0;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                meta = objTmdbToAnimeId;
                kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta;
                str3 = str31;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    str4 = "kitsu_id=" + numericKitsuId.intValue();
                    break;
                } else {
                    str4 = "anilist_id=" + str32;
                }
                Requests app4 = MainActivityKt.getApp();
                String str3121 = "https://api.ani.zip/mappings?" + str4;
                c00274.L$0 = str3;
                c00274.L$1 = str32;
                c00274.L$2 = kitsuMeta;
                c00274.L$3 = numericKitsuId;
                c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                c00274.label = 5;
                num = numericKitsuId;
                str5 = str3;
                str6 = null;
                obj = Requests.get$default(app4, str3121, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                c00272 = c00274;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kitsuMeta3 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                kitsuMeta4 = kitsuMeta3;
                str7 = str5;
                if (text != null) {
                    animeData = TorraStreamUtilsKt.parseAnimeData(text);
                } else {
                    animeData = str6;
                }
                name = kitsuMeta4.getName();
                if (name == null) {
                    aliases = kitsuMeta4.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = str6;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta4.getYearInt();
                if (yearInt == null) {
                    if (animeData != 0) {
                        yearInt = null;
                    } else {
                        yearInt = null;
                    }
                }
                num2 = yearInt;
                str9 = str32;
                if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (animeData != 0) {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                } else {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                }
                if (animeData != 0) {
                    r5 = intOrNull;
                    mappings = animeData.getMappings();
                    if (mappings != null) {
                        malId = mappings.getMalId();
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                } else {
                    r5 = intOrNull;
                    r7 = str10;
                }
                if (r7 == 0) {
                }
                r7 = malId;
                aniIds = new AniIds(r5, r7);
                ?? r210 = animeData;
                str11 = str7;
                r0 = r210;
                kitsuMeta5 = kitsuMeta4;
                str12 = str8;
                str13 = str9;
                r23 = r5;
                num3 = num2;
                r24 = r7;
                num4 = num;
                str14 = text;
                i2 = i;
                tvType2 = tvType;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                r2 = id;
                if (id == null) {
                    r2 = r23;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    r33 = r24;
                } else {
                    r33 = idMal;
                }
                if (r0 != 0) {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                } else {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                }
                poster = kitsuMeta5.getPoster();
                if (poster == null) {
                    r67 = r0;
                    r40 = r2;
                    url = poster;
                } else if (r0 != 0) {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                } else {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                }
                str19 = url;
                background = kitsuMeta5.getBackground();
                if (background == null) {
                    if (r67 == 0) {
                        obj3 = coroutine_suspended;
                    } else {
                        obj3 = coroutine_suspended;
                    }
                    str20 = null;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i1118 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo14 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo14.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList1111111 = arrayList8;
                            ?? r111113 = r68;
                            arrayList1111111.add(loadFromKitsu$createEpisode(r111113, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo14));
                            str21 = str21;
                            r68 = r111113;
                            arrayList8 = arrayList1111111;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i1118;
                            str19 = str19;
                        }
                        ArrayList arrayList1111112 = arrayList8;
                        ?? r111114 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList1111112;
                        r41 = r111114;
                    } else {
                        int i1119 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i1119;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange14 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange14, 10));
                        it = intRange14.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList1111113 = arrayList;
                            arrayList1111113.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList1111113;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list112 = list5;
                            ArrayList arrayList1111114 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list112;
                            arrayList2 = arrayList1111114;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num1114 = num3;
                        String str311111110 = str12;
                        TvType tvType119 = TvType.AnimeMovie;
                        String str311111111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta1113 = kitsuMeta6;
                        ?? r31117 = r32;
                        ?? r31118 = r37;
                        String str311111112 = str24;
                        C00282 c002815 = new C00282(r31118, r31117, num1114, kitsuMeta1113, str311111111, str311111112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1113);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311111110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num1114);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31118);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31117);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311111112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c00271111 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311111110, str25, tvType119, stringData, c002815, c00271111);
                        str30 = str311111110;
                        c00273 = c00271111;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta1114 = kitsuMeta6;
                    Integer num1115 = num3;
                    C00271 c00271112 = c00272;
                    r8 = r32;
                    ?? r111115 = r37;
                    String str311111113 = str24;
                    String str311111114 = str12;
                    obj5 = obj4;
                    TvType tvType1110 = TvType.Anime;
                    list4 = list3;
                    num7 = num1115;
                    C00293 c002916 = new C00293(r111115, r8, arrayList3, num1115, kitsuMeta1114, str26, str311111113, str22, this, list4, null);
                    c00271112.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00271112.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00271112.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1114);
                    c00271112.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00271112.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00271112.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00271112.L$6 = SpillingKt.nullOutSpilledVariable(str311111114);
                    c00271112.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c00271112.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00271112.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00271112.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00271112.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00271112.L$12 = SpillingKt.nullOutSpilledVariable((Object) r111115);
                    c00271112.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c00271112.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00271112.L$15 = SpillingKt.nullOutSpilledVariable(str311111113);
                    c00271112.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c00271112.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00271112.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00271112.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00271112.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00271112.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c00271112.I$0 = i2;
                    c00271112.I$1 = i4;
                    c00271112.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311111114, str25, tvType1110, false, c002916, c00271112, 8, (Object) null);
                    str27 = str311111114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                obj3 = coroutine_suspended;
                str20 = background;
                str21 = str20;
                if (r67 != 0) {
                    logo = kitsuMeta5.getLogo();
                } else {
                    logo = kitsuMeta5.getLogo();
                }
                str22 = logo;
                r3 = r33;
                r4 = r40;
                stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                videos = kitsuMeta5.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                list = videos;
                if (!list.isEmpty()) {
                    size = list.size();
                } else if (r67 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                if (list.isEmpty()) {
                    list6 = list;
                    i9 = size;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    i10 = 0;
                    r68 = r67;
                    while (r34.hasNext()) {
                        int i11110 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i11 = i10;
                        TorraStreamKitsuHelper.KitsuVideo kitsuVideo15 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                        episode = kitsuVideo15.getEpisode();
                        if (episode != null) {
                            iIntValue = episode.intValue();
                        } else {
                            iIntValue = i11 + 1;
                        }
                        ArrayList arrayList1111115 = arrayList8;
                        ?? r111116 = r68;
                        arrayList1111115.add(loadFromKitsu$createEpisode(r111116, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo15));
                        str21 = str21;
                        r68 = r111116;
                        arrayList8 = arrayList1111115;
                        kitsuMeta5 = kitsuMeta5;
                        i9 = i9;
                        torraStreamAnime = this;
                        list6 = list6;
                        charSequence = charSequence;
                        str11 = str11;
                        obj3 = obj3;
                        i10 = i11110;
                        str19 = str19;
                    }
                    ArrayList arrayList1111116 = arrayList8;
                    ?? r111117 = r68;
                    str23 = str21;
                    i4 = i9;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    arrayList2 = arrayList1111116;
                    r41 = r111117;
                } else {
                    int i11111 = size;
                    r1 = r67;
                    str23 = str21;
                    i4 = i11111;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    Iterable intRange15 = new IntRange(1, i4);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange15, 10));
                    it = intRange15.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList1111117 = arrayList;
                        arrayList1111117.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                        arrayList = arrayList1111117;
                    }
                    r41 = r1;
                    arrayList2 = arrayList;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list5 = links;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        List<TorraStreamKitsuHelper.KitsuLink> list113 = list5;
                        ArrayList arrayList1111118 = arrayList2;
                        if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                            arrayList4.add(obj8);
                        }
                        list5 = list113;
                        arrayList2 = arrayList1111118;
                    }
                    arrayList3 = arrayList2;
                    arrayList5 = arrayList4;
                    i7 = 0;
                    arrayList6 = new ArrayList();
                    r11 = r4;
                    r10 = r3;
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList7 = arrayList5;
                            i8 = i7;
                            r310 = r11;
                            r36 = r10;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList7 = arrayList5;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i8 = i7;
                                r39 = r11;
                                r35 = r10;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default != null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i8 = i7;
                                r38 = r11;
                                r34 = r10;
                            }
                            r34 = r35;
                            r38 = r39;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                            r36 = r34;
                            r310 = r38;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                            arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                        } else {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                        }
                        r10 = r36;
                        arrayList5 = arrayList7;
                        i7 = i8;
                        r11 = r310;
                    }
                    r37 = r11;
                    r32 = r10;
                    list2 = arrayList6;
                } else {
                    arrayList3 = arrayList2;
                    r37 = r4;
                    r32 = r3;
                    list2 = null;
                }
                list3 = list2;
                if (i2 != 0) {
                    Integer num1116 = num3;
                    String str311111115 = str12;
                    TvType tvType1111 = TvType.AnimeMovie;
                    String str311111116 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta1115 = kitsuMeta6;
                    ?? r31119 = r32;
                    ?? r311110 = r37;
                    String str311111117 = str24;
                    C00282 c002816 = new C00282(r311110, r31119, num1116, kitsuMeta1115, str311111116, str311111117, str22, null);
                    c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1115);
                    c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311111115);
                    c00272.L$7 = SpillingKt.nullOutSpilledVariable(num1116);
                    c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r311110);
                    c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31119);
                    c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311111117);
                    c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111116);
                    c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                    c00272.I$0 = i2;
                    c00272.I$1 = i4;
                    c00272.label = 7;
                    C00271 c00271113 = c00272;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311111115, str25, tvType1111, stringData, c002816, c00271113);
                    str30 = str311111115;
                    c00273 = c00271113;
                    obj6 = obj4;
                    if (objNewMovieLoadResponse == obj6) {
                        return obj6;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                str26 = str23;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta1116 = kitsuMeta6;
                Integer num1117 = num3;
                C00271 c00271114 = c00272;
                r8 = r32;
                ?? r111118 = r37;
                String str311111118 = str24;
                String str311111119 = str12;
                obj5 = obj4;
                TvType tvType1112 = TvType.Anime;
                list4 = list3;
                num7 = num1117;
                C00293 c002917 = new C00293(r111118, r8, arrayList3, num1117, kitsuMeta1116, str26, str311111118, str22, this, list4, null);
                c00271114.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                c00271114.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                c00271114.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1116);
                c00271114.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                c00271114.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c00271114.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                c00271114.L$6 = SpillingKt.nullOutSpilledVariable(str311111119);
                c00271114.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                c00271114.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00271114.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c00271114.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                c00271114.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c00271114.L$12 = SpillingKt.nullOutSpilledVariable((Object) r111118);
                c00271114.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                c00271114.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                c00271114.L$15 = SpillingKt.nullOutSpilledVariable(str311111118);
                c00271114.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                c00271114.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                c00271114.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                c00271114.L$19 = SpillingKt.nullOutSpilledVariable(list);
                c00271114.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00271114.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                c00271114.I$0 = i2;
                c00271114.I$1 = i4;
                c00271114.label = 8;
                i5 = i2;
                objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311111119, str25, tvType1112, false, c002917, c00271114, 8, (Object) null);
                str27 = str311111119;
                if (objTmdbToAnimeId == obj5) {
                    return obj5;
                }
                i6 = i5;
                r17 = r8;
                str28 = str26;
                str29 = str18;
                return (LoadResponse) objTmdbToAnimeId;
            case 2:
                str32 = (String) c00274.L$1;
                str31 = (String) c00274.L$0;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                meta3 = objTmdbToAnimeId;
                kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta3;
                str3 = str31;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    str4 = "kitsu_id=" + numericKitsuId.intValue();
                    break;
                } else {
                    str4 = "anilist_id=" + str32;
                }
                Requests app5 = MainActivityKt.getApp();
                String str3122 = "https://api.ani.zip/mappings?" + str4;
                c00274.L$0 = str3;
                c00274.L$1 = str32;
                c00274.L$2 = kitsuMeta;
                c00274.L$3 = numericKitsuId;
                c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                c00274.label = 5;
                num = numericKitsuId;
                str5 = str3;
                str6 = null;
                obj = Requests.get$default(app5, str3122, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                c00272 = c00274;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kitsuMeta3 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                kitsuMeta4 = kitsuMeta3;
                str7 = str5;
                if (text != null) {
                    animeData = TorraStreamUtilsKt.parseAnimeData(text);
                } else {
                    animeData = str6;
                }
                name = kitsuMeta4.getName();
                if (name == null) {
                    aliases = kitsuMeta4.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = str6;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta4.getYearInt();
                if (yearInt == null) {
                    if (animeData != 0) {
                        yearInt = null;
                    } else {
                        yearInt = null;
                    }
                }
                num2 = yearInt;
                str9 = str32;
                if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (animeData != 0) {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                } else {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                }
                if (animeData != 0) {
                    r5 = intOrNull;
                    mappings = animeData.getMappings();
                    if (mappings != null) {
                        malId = mappings.getMalId();
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                } else {
                    r5 = intOrNull;
                    r7 = str10;
                }
                if (r7 == 0) {
                }
                r7 = malId;
                aniIds = new AniIds(r5, r7);
                ?? r211 = animeData;
                str11 = str7;
                r0 = r211;
                kitsuMeta5 = kitsuMeta4;
                str12 = str8;
                str13 = str9;
                r23 = r5;
                num3 = num2;
                r24 = r7;
                num4 = num;
                str14 = text;
                i2 = i;
                tvType2 = tvType;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                r2 = id;
                if (id == null) {
                    r2 = r23;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    r33 = r24;
                } else {
                    r33 = idMal;
                }
                if (r0 != 0) {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                } else {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                }
                poster = kitsuMeta5.getPoster();
                if (poster == null) {
                    r67 = r0;
                    r40 = r2;
                    url = poster;
                } else if (r0 != 0) {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                } else {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                }
                str19 = url;
                background = kitsuMeta5.getBackground();
                if (background == null) {
                    if (r67 == 0) {
                        obj3 = coroutine_suspended;
                    } else {
                        obj3 = coroutine_suspended;
                    }
                    str20 = null;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i11112 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo16 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo16.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList1111119 = arrayList8;
                            ?? r111119 = r68;
                            arrayList1111119.add(loadFromKitsu$createEpisode(r111119, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo16));
                            str21 = str21;
                            r68 = r111119;
                            arrayList8 = arrayList1111119;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i11112;
                            str19 = str19;
                        }
                        ArrayList arrayList11111110 = arrayList8;
                        ?? r1111110 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList11111110;
                        r41 = r1111110;
                    } else {
                        int i11113 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i11113;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange16 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange16, 10));
                        it = intRange16.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList11111111 = arrayList;
                            arrayList11111111.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList11111111;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list114 = list5;
                            ArrayList arrayList11111112 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list114;
                            arrayList2 = arrayList11111112;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num1118 = num3;
                        String str3111111110 = str12;
                        TvType tvType1113 = TvType.AnimeMovie;
                        String str3111111111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta1117 = kitsuMeta6;
                        ?? r311111 = r32;
                        ?? r311112 = r37;
                        String str3111111112 = str24;
                        C00282 c002817 = new C00282(r311112, r311111, num1118, kitsuMeta1117, str3111111111, str3111111112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1117);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3111111110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num1118);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r311112);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r311111);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3111111112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111111111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c00271115 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3111111110, str25, tvType1113, stringData, c002817, c00271115);
                        str30 = str3111111110;
                        c00273 = c00271115;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta1118 = kitsuMeta6;
                    Integer num1119 = num3;
                    C00271 c00271116 = c00272;
                    r8 = r32;
                    ?? r1111111 = r37;
                    String str3111111113 = str24;
                    String str3111111114 = str12;
                    obj5 = obj4;
                    TvType tvType1114 = TvType.Anime;
                    list4 = list3;
                    num7 = num1119;
                    C00293 c002918 = new C00293(r1111111, r8, arrayList3, num1119, kitsuMeta1118, str26, str3111111113, str22, this, list4, null);
                    c00271116.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00271116.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00271116.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1118);
                    c00271116.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00271116.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00271116.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00271116.L$6 = SpillingKt.nullOutSpilledVariable(str3111111114);
                    c00271116.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c00271116.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00271116.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00271116.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00271116.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00271116.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1111111);
                    c00271116.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c00271116.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00271116.L$15 = SpillingKt.nullOutSpilledVariable(str3111111113);
                    c00271116.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c00271116.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00271116.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00271116.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00271116.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00271116.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c00271116.I$0 = i2;
                    c00271116.I$1 = i4;
                    c00271116.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3111111114, str25, tvType1114, false, c002918, c00271116, 8, (Object) null);
                    str27 = str3111111114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                obj3 = coroutine_suspended;
                str20 = background;
                str21 = str20;
                if (r67 != 0) {
                    logo = kitsuMeta5.getLogo();
                } else {
                    logo = kitsuMeta5.getLogo();
                }
                str22 = logo;
                r3 = r33;
                r4 = r40;
                stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                videos = kitsuMeta5.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                list = videos;
                if (!list.isEmpty()) {
                    size = list.size();
                } else if (r67 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                if (list.isEmpty()) {
                    list6 = list;
                    i9 = size;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    i10 = 0;
                    r68 = r67;
                    while (r34.hasNext()) {
                        int i11114 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i11 = i10;
                        TorraStreamKitsuHelper.KitsuVideo kitsuVideo17 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                        episode = kitsuVideo17.getEpisode();
                        if (episode != null) {
                            iIntValue = episode.intValue();
                        } else {
                            iIntValue = i11 + 1;
                        }
                        ArrayList arrayList11111113 = arrayList8;
                        ?? r1111112 = r68;
                        arrayList11111113.add(loadFromKitsu$createEpisode(r1111112, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo17));
                        str21 = str21;
                        r68 = r1111112;
                        arrayList8 = arrayList11111113;
                        kitsuMeta5 = kitsuMeta5;
                        i9 = i9;
                        torraStreamAnime = this;
                        list6 = list6;
                        charSequence = charSequence;
                        str11 = str11;
                        obj3 = obj3;
                        i10 = i11114;
                        str19 = str19;
                    }
                    ArrayList arrayList11111114 = arrayList8;
                    ?? r1111113 = r68;
                    str23 = str21;
                    i4 = i9;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    arrayList2 = arrayList11111114;
                    r41 = r1111113;
                } else {
                    int i11115 = size;
                    r1 = r67;
                    str23 = str21;
                    i4 = i11115;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    Iterable intRange17 = new IntRange(1, i4);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange17, 10));
                    it = intRange17.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList11111115 = arrayList;
                        arrayList11111115.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                        arrayList = arrayList11111115;
                    }
                    r41 = r1;
                    arrayList2 = arrayList;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list5 = links;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        List<TorraStreamKitsuHelper.KitsuLink> list115 = list5;
                        ArrayList arrayList11111116 = arrayList2;
                        if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                            arrayList4.add(obj8);
                        }
                        list5 = list115;
                        arrayList2 = arrayList11111116;
                    }
                    arrayList3 = arrayList2;
                    arrayList5 = arrayList4;
                    i7 = 0;
                    arrayList6 = new ArrayList();
                    r11 = r4;
                    r10 = r3;
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList7 = arrayList5;
                            i8 = i7;
                            r310 = r11;
                            r36 = r10;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList7 = arrayList5;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i8 = i7;
                                r39 = r11;
                                r35 = r10;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default != null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i8 = i7;
                                r38 = r11;
                                r34 = r10;
                            }
                            r34 = r35;
                            r38 = r39;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                            r36 = r34;
                            r310 = r38;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                            arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                        } else {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                        }
                        r10 = r36;
                        arrayList5 = arrayList7;
                        i7 = i8;
                        r11 = r310;
                    }
                    r37 = r11;
                    r32 = r10;
                    list2 = arrayList6;
                } else {
                    arrayList3 = arrayList2;
                    r37 = r4;
                    r32 = r3;
                    list2 = null;
                }
                list3 = list2;
                if (i2 != 0) {
                    Integer num11110 = num3;
                    String str3111111115 = str12;
                    TvType tvType1115 = TvType.AnimeMovie;
                    String str3111111116 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta1119 = kitsuMeta6;
                    ?? r311113 = r32;
                    ?? r311114 = r37;
                    String str3111111117 = str24;
                    C00282 c002818 = new C00282(r311114, r311113, num11110, kitsuMeta1119, str3111111116, str3111111117, str22, null);
                    c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1119);
                    c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3111111115);
                    c00272.L$7 = SpillingKt.nullOutSpilledVariable(num11110);
                    c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r311114);
                    c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r311113);
                    c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3111111117);
                    c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111111116);
                    c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                    c00272.I$0 = i2;
                    c00272.I$1 = i4;
                    c00272.label = 7;
                    C00271 c00271117 = c00272;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3111111115, str25, tvType1115, stringData, c002818, c00271117);
                    str30 = str3111111115;
                    c00273 = c00271117;
                    obj6 = obj4;
                    if (objNewMovieLoadResponse == obj6) {
                        return obj6;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                str26 = str23;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta11110 = kitsuMeta6;
                Integer num11111 = num3;
                C00271 c00271118 = c00272;
                r8 = r32;
                ?? r1111114 = r37;
                String str3111111118 = str24;
                String str3111111119 = str12;
                obj5 = obj4;
                TvType tvType1116 = TvType.Anime;
                list4 = list3;
                num7 = num11111;
                C00293 c002919 = new C00293(r1111114, r8, arrayList3, num11111, kitsuMeta11110, str26, str3111111118, str22, this, list4, null);
                c00271118.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                c00271118.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                c00271118.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11110);
                c00271118.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                c00271118.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c00271118.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                c00271118.L$6 = SpillingKt.nullOutSpilledVariable(str3111111119);
                c00271118.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                c00271118.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00271118.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c00271118.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                c00271118.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c00271118.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1111114);
                c00271118.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                c00271118.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                c00271118.L$15 = SpillingKt.nullOutSpilledVariable(str3111111118);
                c00271118.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                c00271118.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                c00271118.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                c00271118.L$19 = SpillingKt.nullOutSpilledVariable(list);
                c00271118.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c00271118.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                c00271118.I$0 = i2;
                c00271118.I$1 = i4;
                c00271118.label = 8;
                i5 = i2;
                objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3111111119, str25, tvType1116, false, c002919, c00271118, 8, (Object) null);
                str27 = str3111111119;
                if (objTmdbToAnimeId == obj5) {
                    return obj5;
                }
                i6 = i5;
                r17 = r8;
                str28 = str26;
                str29 = str18;
                return (LoadResponse) objTmdbToAnimeId;
            case 3:
                str32 = (String) c00274.L$1;
                str31 = (String) c00274.L$0;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                meta2 = objTmdbToAnimeId;
                kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta2;
                if (kitsuMeta == null) {
                    c00274.L$0 = str31;
                    c00274.L$1 = str32;
                    c00274.label = 4;
                    meta4 = TorraStreamKitsuHelper.INSTANCE.getMeta("kitsu:" + str32, c00274);
                    if (meta4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta4;
                    str3 = str31;
                } else {
                    str3 = str31;
                }
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    str4 = "kitsu_id=" + numericKitsuId.intValue();
                    break;
                } else {
                    str4 = "anilist_id=" + str32;
                }
                Requests app6 = MainActivityKt.getApp();
                String str3123 = "https://api.ani.zip/mappings?" + str4;
                c00274.L$0 = str3;
                c00274.L$1 = str32;
                c00274.L$2 = kitsuMeta;
                c00274.L$3 = numericKitsuId;
                c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                c00274.label = 5;
                num = numericKitsuId;
                str5 = str3;
                str6 = null;
                obj = Requests.get$default(app6, str3123, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                c00272 = c00274;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kitsuMeta3 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                kitsuMeta4 = kitsuMeta3;
                str7 = str5;
                if (text != null) {
                    animeData = TorraStreamUtilsKt.parseAnimeData(text);
                } else {
                    animeData = str6;
                }
                name = kitsuMeta4.getName();
                if (name == null) {
                    aliases = kitsuMeta4.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = str6;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta4.getYearInt();
                if (yearInt == null) {
                    if (animeData != 0) {
                        yearInt = null;
                    } else {
                        yearInt = null;
                    }
                }
                num2 = yearInt;
                str9 = str32;
                if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (animeData != 0) {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                } else {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                }
                if (animeData != 0) {
                    r5 = intOrNull;
                    mappings = animeData.getMappings();
                    if (mappings != null) {
                        malId = mappings.getMalId();
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                } else {
                    r5 = intOrNull;
                    r7 = str10;
                }
                if (r7 == 0) {
                }
                r7 = malId;
                aniIds = new AniIds(r5, r7);
                ?? r212 = animeData;
                str11 = str7;
                r0 = r212;
                kitsuMeta5 = kitsuMeta4;
                str12 = str8;
                str13 = str9;
                r23 = r5;
                num3 = num2;
                r24 = r7;
                num4 = num;
                str14 = text;
                i2 = i;
                tvType2 = tvType;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                r2 = id;
                if (id == null) {
                    r2 = r23;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    r33 = r24;
                } else {
                    r33 = idMal;
                }
                if (r0 != 0) {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                } else {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                }
                poster = kitsuMeta5.getPoster();
                if (poster == null) {
                    r67 = r0;
                    r40 = r2;
                    url = poster;
                } else if (r0 != 0) {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                } else {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                }
                str19 = url;
                background = kitsuMeta5.getBackground();
                if (background == null) {
                    if (r67 == 0) {
                        obj3 = coroutine_suspended;
                    } else {
                        obj3 = coroutine_suspended;
                    }
                    str20 = null;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i11116 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo18 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo18.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList11111117 = arrayList8;
                            ?? r1111115 = r68;
                            arrayList11111117.add(loadFromKitsu$createEpisode(r1111115, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo18));
                            str21 = str21;
                            r68 = r1111115;
                            arrayList8 = arrayList11111117;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i11116;
                            str19 = str19;
                        }
                        ArrayList arrayList11111118 = arrayList8;
                        ?? r1111116 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList11111118;
                        r41 = r1111116;
                    } else {
                        int i11117 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i11117;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange18 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange18, 10));
                        it = intRange18.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList11111119 = arrayList;
                            arrayList11111119.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList11111119;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list116 = list5;
                            ArrayList arrayList111111110 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list116;
                            arrayList2 = arrayList111111110;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num11112 = num3;
                        String str31111111110 = str12;
                        TvType tvType1117 = TvType.AnimeMovie;
                        String str31111111111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta11111 = kitsuMeta6;
                        ?? r311115 = r32;
                        ?? r311116 = r37;
                        String str31111111112 = str24;
                        C00282 c002819 = new C00282(r311116, r311115, num11112, kitsuMeta11111, str31111111111, str31111111112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11111);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31111111110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num11112);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r311116);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r311115);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31111111112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111111111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c00271119 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31111111110, str25, tvType1117, stringData, c002819, c00271119);
                        str30 = str31111111110;
                        c00273 = c00271119;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta11112 = kitsuMeta6;
                    Integer num11113 = num3;
                    C00271 c002711110 = c00272;
                    r8 = r32;
                    ?? r1111117 = r37;
                    String str31111111113 = str24;
                    String str31111111114 = str12;
                    obj5 = obj4;
                    TvType tvType1118 = TvType.Anime;
                    list4 = list3;
                    num7 = num11113;
                    C00293 c0029110 = new C00293(r1111117, r8, arrayList3, num11113, kitsuMeta11112, str26, str31111111113, str22, this, list4, null);
                    c002711110.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c002711110.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c002711110.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11112);
                    c002711110.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c002711110.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c002711110.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c002711110.L$6 = SpillingKt.nullOutSpilledVariable(str31111111114);
                    c002711110.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c002711110.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c002711110.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c002711110.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c002711110.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c002711110.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1111117);
                    c002711110.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c002711110.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c002711110.L$15 = SpillingKt.nullOutSpilledVariable(str31111111113);
                    c002711110.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c002711110.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c002711110.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c002711110.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c002711110.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c002711110.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c002711110.I$0 = i2;
                    c002711110.I$1 = i4;
                    c002711110.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31111111114, str25, tvType1118, false, c0029110, c002711110, 8, (Object) null);
                    str27 = str31111111114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                obj3 = coroutine_suspended;
                str20 = background;
                str21 = str20;
                if (r67 != 0) {
                    logo = kitsuMeta5.getLogo();
                } else {
                    logo = kitsuMeta5.getLogo();
                }
                str22 = logo;
                r3 = r33;
                r4 = r40;
                stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                videos = kitsuMeta5.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                list = videos;
                if (!list.isEmpty()) {
                    size = list.size();
                } else if (r67 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                if (list.isEmpty()) {
                    list6 = list;
                    i9 = size;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    i10 = 0;
                    r68 = r67;
                    while (r34.hasNext()) {
                        int i11118 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i11 = i10;
                        TorraStreamKitsuHelper.KitsuVideo kitsuVideo19 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                        episode = kitsuVideo19.getEpisode();
                        if (episode != null) {
                            iIntValue = episode.intValue();
                        } else {
                            iIntValue = i11 + 1;
                        }
                        ArrayList arrayList111111111 = arrayList8;
                        ?? r1111118 = r68;
                        arrayList111111111.add(loadFromKitsu$createEpisode(r1111118, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo19));
                        str21 = str21;
                        r68 = r1111118;
                        arrayList8 = arrayList111111111;
                        kitsuMeta5 = kitsuMeta5;
                        i9 = i9;
                        torraStreamAnime = this;
                        list6 = list6;
                        charSequence = charSequence;
                        str11 = str11;
                        obj3 = obj3;
                        i10 = i11118;
                        str19 = str19;
                    }
                    ArrayList arrayList111111112 = arrayList8;
                    ?? r1111119 = r68;
                    str23 = str21;
                    i4 = i9;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    arrayList2 = arrayList111111112;
                    r41 = r1111119;
                } else {
                    int i11119 = size;
                    r1 = r67;
                    str23 = str21;
                    i4 = i11119;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    Iterable intRange19 = new IntRange(1, i4);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange19, 10));
                    it = intRange19.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList111111113 = arrayList;
                        arrayList111111113.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                        arrayList = arrayList111111113;
                    }
                    r41 = r1;
                    arrayList2 = arrayList;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list5 = links;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        List<TorraStreamKitsuHelper.KitsuLink> list117 = list5;
                        ArrayList arrayList111111114 = arrayList2;
                        if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                            arrayList4.add(obj8);
                        }
                        list5 = list117;
                        arrayList2 = arrayList111111114;
                    }
                    arrayList3 = arrayList2;
                    arrayList5 = arrayList4;
                    i7 = 0;
                    arrayList6 = new ArrayList();
                    r11 = r4;
                    r10 = r3;
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList7 = arrayList5;
                            i8 = i7;
                            r310 = r11;
                            r36 = r10;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList7 = arrayList5;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i8 = i7;
                                r39 = r11;
                                r35 = r10;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default != null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i8 = i7;
                                r38 = r11;
                                r34 = r10;
                            }
                            r34 = r35;
                            r38 = r39;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                            r36 = r34;
                            r310 = r38;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                            arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                        } else {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                        }
                        r10 = r36;
                        arrayList5 = arrayList7;
                        i7 = i8;
                        r11 = r310;
                    }
                    r37 = r11;
                    r32 = r10;
                    list2 = arrayList6;
                } else {
                    arrayList3 = arrayList2;
                    r37 = r4;
                    r32 = r3;
                    list2 = null;
                }
                list3 = list2;
                if (i2 != 0) {
                    Integer num11114 = num3;
                    String str31111111115 = str12;
                    TvType tvType1119 = TvType.AnimeMovie;
                    String str31111111116 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta11113 = kitsuMeta6;
                    ?? r311117 = r32;
                    ?? r311118 = r37;
                    String str31111111117 = str24;
                    C00282 c0028110 = new C00282(r311118, r311117, num11114, kitsuMeta11113, str31111111116, str31111111117, str22, null);
                    c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11113);
                    c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31111111115);
                    c00272.L$7 = SpillingKt.nullOutSpilledVariable(num11114);
                    c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r311118);
                    c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r311117);
                    c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31111111117);
                    c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111111116);
                    c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                    c00272.I$0 = i2;
                    c00272.I$1 = i4;
                    c00272.label = 7;
                    C00271 c002711111 = c00272;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31111111115, str25, tvType1119, stringData, c0028110, c002711111);
                    str30 = str31111111115;
                    c00273 = c002711111;
                    obj6 = obj4;
                    if (objNewMovieLoadResponse == obj6) {
                        return obj6;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                str26 = str23;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta11114 = kitsuMeta6;
                Integer num11115 = num3;
                C00271 c002711112 = c00272;
                r8 = r32;
                ?? r11111110 = r37;
                String str31111111118 = str24;
                String str31111111119 = str12;
                obj5 = obj4;
                TvType tvType11110 = TvType.Anime;
                list4 = list3;
                num7 = num11115;
                C00293 c0029111 = new C00293(r11111110, r8, arrayList3, num11115, kitsuMeta11114, str26, str31111111118, str22, this, list4, null);
                c002711112.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                c002711112.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                c002711112.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11114);
                c002711112.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                c002711112.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c002711112.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                c002711112.L$6 = SpillingKt.nullOutSpilledVariable(str31111111119);
                c002711112.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                c002711112.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                c002711112.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c002711112.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                c002711112.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c002711112.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11111110);
                c002711112.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                c002711112.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                c002711112.L$15 = SpillingKt.nullOutSpilledVariable(str31111111118);
                c002711112.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                c002711112.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                c002711112.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                c002711112.L$19 = SpillingKt.nullOutSpilledVariable(list);
                c002711112.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c002711112.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                c002711112.I$0 = i2;
                c002711112.I$1 = i4;
                c002711112.label = 8;
                i5 = i2;
                objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31111111119, str25, tvType11110, false, c0029111, c002711112, 8, (Object) null);
                str27 = str31111111119;
                if (objTmdbToAnimeId == obj5) {
                    return obj5;
                }
                i6 = i5;
                r17 = r8;
                str28 = str26;
                str29 = str18;
                return (LoadResponse) objTmdbToAnimeId;
            case 4:
                str32 = (String) c00274.L$1;
                str31 = (String) c00274.L$0;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                meta4 = objTmdbToAnimeId;
                kitsuMeta = (TorraStreamKitsuHelper.KitsuMeta) meta4;
                str3 = str31;
                if (kitsuMeta == null) {
                    throw new Exception("Unable to fetch Kitsu anime metadata for " + str32);
                }
                numericKitsuId = kitsuMeta.getNumericKitsuId();
                if (numericKitsuId != null) {
                    str4 = "kitsu_id=" + numericKitsuId.intValue();
                    break;
                } else {
                    str4 = "anilist_id=" + str32;
                }
                Requests app7 = MainActivityKt.getApp();
                String str3124 = "https://api.ani.zip/mappings?" + str4;
                c00274.L$0 = str3;
                c00274.L$1 = str32;
                c00274.L$2 = kitsuMeta;
                c00274.L$3 = numericKitsuId;
                c00274.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                c00274.label = 5;
                num = numericKitsuId;
                str5 = str3;
                str6 = null;
                obj = Requests.get$default(app7, str3124, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00274, 4094, (Object) null);
                c00272 = c00274;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kitsuMeta3 = kitsuMeta;
                text = ((NiceResponse) obj).getText();
                kitsuMeta4 = kitsuMeta3;
                str7 = str5;
                if (text != null) {
                    animeData = TorraStreamUtilsKt.parseAnimeData(text);
                } else {
                    animeData = str6;
                }
                name = kitsuMeta4.getName();
                if (name == null) {
                    aliases = kitsuMeta4.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = str6;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta4.getYearInt();
                if (yearInt == null) {
                    if (animeData != 0) {
                        yearInt = null;
                    } else {
                        yearInt = null;
                    }
                }
                num2 = yearInt;
                str9 = str32;
                if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (animeData != 0) {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                } else {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                }
                if (animeData != 0) {
                    r5 = intOrNull;
                    mappings = animeData.getMappings();
                    if (mappings != null) {
                        malId = mappings.getMalId();
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                } else {
                    r5 = intOrNull;
                    r7 = str10;
                }
                if (r7 == 0) {
                }
                r7 = malId;
                aniIds = new AniIds(r5, r7);
                ?? r213 = animeData;
                str11 = str7;
                r0 = r213;
                kitsuMeta5 = kitsuMeta4;
                str12 = str8;
                str13 = str9;
                r23 = r5;
                num3 = num2;
                r24 = r7;
                num4 = num;
                str14 = text;
                i2 = i;
                tvType2 = tvType;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                r2 = id;
                if (id == null) {
                    r2 = r23;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    r33 = r24;
                } else {
                    r33 = idMal;
                }
                if (r0 != 0) {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                } else {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                }
                poster = kitsuMeta5.getPoster();
                if (poster == null) {
                    r67 = r0;
                    r40 = r2;
                    url = poster;
                } else if (r0 != 0) {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                } else {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                }
                str19 = url;
                background = kitsuMeta5.getBackground();
                if (background == null) {
                    if (r67 == 0) {
                        obj3 = coroutine_suspended;
                    } else {
                        obj3 = coroutine_suspended;
                    }
                    str20 = null;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i111110 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo110 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo110.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList111111115 = arrayList8;
                            ?? r11111111 = r68;
                            arrayList111111115.add(loadFromKitsu$createEpisode(r11111111, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo110));
                            str21 = str21;
                            r68 = r11111111;
                            arrayList8 = arrayList111111115;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i111110;
                            str19 = str19;
                        }
                        ArrayList arrayList111111116 = arrayList8;
                        ?? r11111112 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList111111116;
                        r41 = r11111112;
                    } else {
                        int i111111 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i111111;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange110 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange110, 10));
                        it = intRange110.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList111111117 = arrayList;
                            arrayList111111117.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList111111117;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list118 = list5;
                            ArrayList arrayList111111118 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list118;
                            arrayList2 = arrayList111111118;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num11116 = num3;
                        String str311111111110 = str12;
                        TvType tvType11111 = TvType.AnimeMovie;
                        String str311111111111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta11115 = kitsuMeta6;
                        ?? r311119 = r32;
                        ?? r3111110 = r37;
                        String str311111111112 = str24;
                        C00282 c0028111 = new C00282(r3111110, r311119, num11116, kitsuMeta11115, str311111111111, str311111111112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11115);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311111111110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num11116);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3111110);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r311119);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311111111112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111111111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c002711113 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311111111110, str25, tvType11111, stringData, c0028111, c002711113);
                        str30 = str311111111110;
                        c00273 = c002711113;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta11116 = kitsuMeta6;
                    Integer num11117 = num3;
                    C00271 c002711114 = c00272;
                    r8 = r32;
                    ?? r11111113 = r37;
                    String str311111111113 = str24;
                    String str311111111114 = str12;
                    obj5 = obj4;
                    TvType tvType11112 = TvType.Anime;
                    list4 = list3;
                    num7 = num11117;
                    C00293 c0029112 = new C00293(r11111113, r8, arrayList3, num11117, kitsuMeta11116, str26, str311111111113, str22, this, list4, null);
                    c002711114.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c002711114.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c002711114.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11116);
                    c002711114.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c002711114.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c002711114.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c002711114.L$6 = SpillingKt.nullOutSpilledVariable(str311111111114);
                    c002711114.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c002711114.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c002711114.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c002711114.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c002711114.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c002711114.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11111113);
                    c002711114.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c002711114.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c002711114.L$15 = SpillingKt.nullOutSpilledVariable(str311111111113);
                    c002711114.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c002711114.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c002711114.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c002711114.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c002711114.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c002711114.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c002711114.I$0 = i2;
                    c002711114.I$1 = i4;
                    c002711114.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311111111114, str25, tvType11112, false, c0029112, c002711114, 8, (Object) null);
                    str27 = str311111111114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                obj3 = coroutine_suspended;
                str20 = background;
                str21 = str20;
                if (r67 != 0) {
                    logo = kitsuMeta5.getLogo();
                } else {
                    logo = kitsuMeta5.getLogo();
                }
                str22 = logo;
                r3 = r33;
                r4 = r40;
                stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                videos = kitsuMeta5.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                list = videos;
                if (!list.isEmpty()) {
                    size = list.size();
                } else if (r67 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                if (list.isEmpty()) {
                    list6 = list;
                    i9 = size;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    i10 = 0;
                    r68 = r67;
                    while (r34.hasNext()) {
                        int i111112 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i11 = i10;
                        TorraStreamKitsuHelper.KitsuVideo kitsuVideo111 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                        episode = kitsuVideo111.getEpisode();
                        if (episode != null) {
                            iIntValue = episode.intValue();
                        } else {
                            iIntValue = i11 + 1;
                        }
                        ArrayList arrayList111111119 = arrayList8;
                        ?? r11111114 = r68;
                        arrayList111111119.add(loadFromKitsu$createEpisode(r11111114, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo111));
                        str21 = str21;
                        r68 = r11111114;
                        arrayList8 = arrayList111111119;
                        kitsuMeta5 = kitsuMeta5;
                        i9 = i9;
                        torraStreamAnime = this;
                        list6 = list6;
                        charSequence = charSequence;
                        str11 = str11;
                        obj3 = obj3;
                        i10 = i111112;
                        str19 = str19;
                    }
                    ArrayList arrayList1111111110 = arrayList8;
                    ?? r11111115 = r68;
                    str23 = str21;
                    i4 = i9;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    arrayList2 = arrayList1111111110;
                    r41 = r11111115;
                } else {
                    int i111113 = size;
                    r1 = r67;
                    str23 = str21;
                    i4 = i111113;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    Iterable intRange111 = new IntRange(1, i4);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange111, 10));
                    it = intRange111.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList1111111111 = arrayList;
                        arrayList1111111111.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                        arrayList = arrayList1111111111;
                    }
                    r41 = r1;
                    arrayList2 = arrayList;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list5 = links;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        List<TorraStreamKitsuHelper.KitsuLink> list119 = list5;
                        ArrayList arrayList1111111112 = arrayList2;
                        if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                            arrayList4.add(obj8);
                        }
                        list5 = list119;
                        arrayList2 = arrayList1111111112;
                    }
                    arrayList3 = arrayList2;
                    arrayList5 = arrayList4;
                    i7 = 0;
                    arrayList6 = new ArrayList();
                    r11 = r4;
                    r10 = r3;
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList7 = arrayList5;
                            i8 = i7;
                            r310 = r11;
                            r36 = r10;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList7 = arrayList5;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i8 = i7;
                                r39 = r11;
                                r35 = r10;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default != null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i8 = i7;
                                r38 = r11;
                                r34 = r10;
                            }
                            r34 = r35;
                            r38 = r39;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                            r36 = r34;
                            r310 = r38;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                            arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                        } else {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                        }
                        r10 = r36;
                        arrayList5 = arrayList7;
                        i7 = i8;
                        r11 = r310;
                    }
                    r37 = r11;
                    r32 = r10;
                    list2 = arrayList6;
                } else {
                    arrayList3 = arrayList2;
                    r37 = r4;
                    r32 = r3;
                    list2 = null;
                }
                list3 = list2;
                if (i2 != 0) {
                    Integer num11118 = num3;
                    String str311111111115 = str12;
                    TvType tvType11113 = TvType.AnimeMovie;
                    String str311111111116 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta11117 = kitsuMeta6;
                    ?? r3111111 = r32;
                    ?? r3111112 = r37;
                    String str311111111117 = str24;
                    C00282 c0028112 = new C00282(r3111112, r3111111, num11118, kitsuMeta11117, str311111111116, str311111111117, str22, null);
                    c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11117);
                    c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311111111115);
                    c00272.L$7 = SpillingKt.nullOutSpilledVariable(num11118);
                    c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3111112);
                    c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3111111);
                    c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311111111117);
                    c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111111116);
                    c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                    c00272.I$0 = i2;
                    c00272.I$1 = i4;
                    c00272.label = 7;
                    C00271 c002711115 = c00272;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311111111115, str25, tvType11113, stringData, c0028112, c002711115);
                    str30 = str311111111115;
                    c00273 = c002711115;
                    obj6 = obj4;
                    if (objNewMovieLoadResponse == obj6) {
                        return obj6;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                str26 = str23;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta11118 = kitsuMeta6;
                Integer num11119 = num3;
                C00271 c002711116 = c00272;
                r8 = r32;
                ?? r11111116 = r37;
                String str311111111118 = str24;
                String str311111111119 = str12;
                obj5 = obj4;
                TvType tvType11114 = TvType.Anime;
                list4 = list3;
                num7 = num11119;
                C00293 c0029113 = new C00293(r11111116, r8, arrayList3, num11119, kitsuMeta11118, str26, str311111111118, str22, this, list4, null);
                c002711116.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                c002711116.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                c002711116.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11118);
                c002711116.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                c002711116.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c002711116.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                c002711116.L$6 = SpillingKt.nullOutSpilledVariable(str311111111119);
                c002711116.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                c002711116.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                c002711116.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c002711116.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                c002711116.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c002711116.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11111116);
                c002711116.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                c002711116.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                c002711116.L$15 = SpillingKt.nullOutSpilledVariable(str311111111118);
                c002711116.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                c002711116.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                c002711116.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                c002711116.L$19 = SpillingKt.nullOutSpilledVariable(list);
                c002711116.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c002711116.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                c002711116.I$0 = i2;
                c002711116.I$1 = i4;
                c002711116.label = 8;
                i5 = i2;
                objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311111111119, str25, tvType11114, false, c0029113, c002711116, 8, (Object) null);
                str27 = str311111111119;
                if (objTmdbToAnimeId == obj5) {
                    return obj5;
                }
                i6 = i5;
                r17 = r8;
                str28 = str26;
                str29 = str18;
                return (LoadResponse) objTmdbToAnimeId;
            case 5:
                num = (Integer) c00274.L$3;
                kitsuMeta2 = (TorraStreamKitsuHelper.KitsuMeta) c00274.L$2;
                str32 = (String) c00274.L$1;
                String str41 = (String) c00274.L$0;
                try {
                    ResultKt.throwOnFailure(objTmdbToAnimeId);
                    kitsuMeta3 = kitsuMeta2;
                    str5 = str41;
                    str6 = null;
                    c00272 = c00274;
                    obj = objTmdbToAnimeId;
                    text = ((NiceResponse) obj).getText();
                    kitsuMeta4 = kitsuMeta3;
                    str7 = str5;
                } catch (Throwable th5) {
                    str5 = str41;
                    str6 = null;
                    c00272 = c00274;
                    kitsuMeta4 = kitsuMeta2;
                    text = str6;
                    str7 = str5;
                    if (text != null) {
                        animeData = TorraStreamUtilsKt.parseAnimeData(text);
                    } else {
                        animeData = str6;
                    }
                    name = kitsuMeta4.getName();
                    if (name == null) {
                        aliases = kitsuMeta4.getAliases();
                        if (aliases != null) {
                            name = (String) CollectionsKt.firstOrNull(aliases);
                        } else {
                            name = str6;
                        }
                        if (name == null) {
                            name = "Unknown";
                        }
                    }
                    str8 = name;
                    yearInt = kitsuMeta4.getYearInt();
                    if (yearInt == null) {
                        if (animeData != 0) {
                            yearInt = null;
                        } else {
                            yearInt = null;
                        }
                    }
                    num2 = yearInt;
                    str9 = str32;
                    if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                        i = 1;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.TvSeries;
                    }
                    if (animeData != 0) {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    } else {
                        if (StringsKt.toIntOrNull(str9) != null) {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                            if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                                intOrNull = StringsKt.toIntOrNull(str9);
                            }
                        } else {
                            charSequence = "kitsu:";
                            obj2 = objTmdbToAnimeId;
                            str10 = null;
                        }
                        r5 = str10;
                    }
                    if (animeData != 0) {
                        r5 = intOrNull;
                        mappings = animeData.getMappings();
                        if (mappings != null) {
                            malId = mappings.getMalId();
                        } else {
                            r5 = intOrNull;
                            r7 = str10;
                        }
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                    if (r7 == 0) {
                    }
                    r7 = malId;
                    aniIds = new AniIds(r5, r7);
                    ?? r214 = animeData;
                    str11 = str7;
                    r0 = r214;
                    kitsuMeta5 = kitsuMeta4;
                    str12 = str8;
                    str13 = str9;
                    r23 = r5;
                    num3 = num2;
                    r24 = r7;
                    num4 = num;
                    str14 = text;
                    i2 = i;
                    tvType2 = tvType;
                    aniIds2 = aniIds;
                    id = aniIds2.getId();
                    r2 = id;
                    if (id == null) {
                        r2 = r23;
                    }
                    idMal = aniIds2.getIdMal();
                    if (idMal == null) {
                        r33 = r24;
                    } else {
                        r33 = idMal;
                    }
                    if (r0 != 0) {
                        if (r0 != 0) {
                            str18 = str10;
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    } else {
                        if (r0 != 0) {
                            str18 = str10;
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            aliases2 = kitsuMeta5.getAliases();
                            if (aliases2 != null) {
                                str18 = (String) CollectionsKt.firstOrNull(aliases2);
                            } else {
                                str18 = str10;
                            }
                            if (str18 == null) {
                                str18 = str12;
                            }
                        }
                    }
                    poster = kitsuMeta5.getPoster();
                    if (poster == null) {
                        r67 = r0;
                        r40 = r2;
                        url = poster;
                    } else if (r0 != 0) {
                        r69 = r0;
                        r42 = r2;
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    } else {
                        r69 = r0;
                        r42 = r2;
                        url = null;
                        r40 = r42;
                        r67 = r69;
                    }
                    str19 = url;
                    background = kitsuMeta5.getBackground();
                    if (background == null) {
                        if (r67 == 0) {
                            obj3 = coroutine_suspended;
                        } else {
                            obj3 = coroutine_suspended;
                        }
                        str20 = null;
                        str21 = str20;
                        if (r67 != 0) {
                            logo = kitsuMeta5.getLogo();
                        } else {
                            logo = kitsuMeta5.getLogo();
                        }
                        str22 = logo;
                        r3 = r33;
                        r4 = r40;
                        stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                        videos = kitsuMeta5.getVideos();
                        if (videos == null) {
                            videos = CollectionsKt.emptyList();
                        }
                        list = videos;
                        if (!list.isEmpty()) {
                            size = list.size();
                        } else if (r67 != 0) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (list.isEmpty()) {
                            list6 = list;
                            i9 = size;
                            arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                            i10 = 0;
                            r68 = r67;
                            while (r34.hasNext()) {
                                int i111114 = i10 + 1;
                                if (i10 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                i11 = i10;
                                TorraStreamKitsuHelper.KitsuVideo kitsuVideo112 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                                episode = kitsuVideo112.getEpisode();
                                if (episode != null) {
                                    iIntValue = episode.intValue();
                                } else {
                                    iIntValue = i11 + 1;
                                }
                                ArrayList arrayList1111111113 = arrayList8;
                                ?? r11111117 = r68;
                                arrayList1111111113.add(loadFromKitsu$createEpisode(r11111117, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo112));
                                str21 = str21;
                                r68 = r11111117;
                                arrayList8 = arrayList1111111113;
                                kitsuMeta5 = kitsuMeta5;
                                i9 = i9;
                                torraStreamAnime = this;
                                list6 = list6;
                                charSequence = charSequence;
                                str11 = str11;
                                obj3 = obj3;
                                i10 = i111114;
                                str19 = str19;
                            }
                            ArrayList arrayList1111111114 = arrayList8;
                            ?? r11111118 = r68;
                            str23 = str21;
                            i4 = i9;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            arrayList2 = arrayList1111111114;
                            r41 = r11111118;
                        } else {
                            int i111115 = size;
                            r1 = r67;
                            str23 = str21;
                            i4 = i111115;
                            kitsuMeta6 = kitsuMeta5;
                            str24 = str19;
                            str25 = str11;
                            obj4 = obj3;
                            charSequence2 = charSequence;
                            Iterable intRange112 = new IntRange(1, i4);
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange112, 10));
                            it = intRange112.iterator();
                            while (it.hasNext()) {
                                ArrayList arrayList1111111115 = arrayList;
                                arrayList1111111115.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                                arrayList = arrayList1111111115;
                            }
                            r41 = r1;
                            arrayList2 = arrayList;
                        }
                        links = kitsuMeta6.getLinks();
                        if (links != null) {
                            list5 = links;
                            arrayList4 = new ArrayList();
                            while (r10.hasNext()) {
                                List<TorraStreamKitsuHelper.KitsuLink> list1110 = list5;
                                ArrayList arrayList1111111116 = arrayList2;
                                if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                    arrayList4.add(obj8);
                                }
                                list5 = list1110;
                                arrayList2 = arrayList1111111116;
                            }
                            arrayList3 = arrayList2;
                            arrayList5 = arrayList4;
                            i7 = 0;
                            arrayList6 = new ArrayList();
                            r11 = r4;
                            r10 = r3;
                            while (r11.hasNext()) {
                                name2 = kitsuLink.getName();
                                if (name2 == null) {
                                    arrayList7 = arrayList5;
                                    i8 = i7;
                                    r310 = r11;
                                    r36 = r10;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                } else {
                                    arrayList7 = arrayList5;
                                    url2 = kitsuLink.getUrl();
                                    if (url2 != null) {
                                        i8 = i7;
                                        r39 = r11;
                                        r35 = r10;
                                        strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                        if (strSubstringAfterLast$default != null) {
                                            animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                        }
                                    } else {
                                        i8 = i7;
                                        r38 = r11;
                                        r34 = r10;
                                    }
                                    r34 = r35;
                                    r38 = r39;
                                    animeSearchResponseNewAnimeSearchResponse$default = null;
                                    r36 = r34;
                                    r310 = r38;
                                }
                                if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                    arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                                } else {
                                    r34 = r35;
                                    r38 = r39;
                                    r36 = r35;
                                    r310 = r39;
                                }
                                r10 = r36;
                                arrayList5 = arrayList7;
                                i7 = i8;
                                r11 = r310;
                            }
                            r37 = r11;
                            r32 = r10;
                            list2 = arrayList6;
                        } else {
                            arrayList3 = arrayList2;
                            r37 = r4;
                            r32 = r3;
                            list2 = null;
                        }
                        list3 = list2;
                        if (i2 != 0) {
                            Integer num111110 = num3;
                            String str3111111111110 = str12;
                            TvType tvType11115 = TvType.AnimeMovie;
                            String str3111111111111 = str23;
                            TorraStreamKitsuHelper.KitsuMeta kitsuMeta11119 = kitsuMeta6;
                            ?? r3111113 = r32;
                            ?? r3111114 = r37;
                            String str3111111111112 = str24;
                            C00282 c0028113 = new C00282(r3111114, r3111113, num111110, kitsuMeta11119, str3111111111111, str3111111111112, str22, null);
                            c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                            c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                            c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta11119);
                            c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                            c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                            c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3111111111110);
                            c00272.L$7 = SpillingKt.nullOutSpilledVariable(num111110);
                            c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                            c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                            c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                            c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                            c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3111114);
                            c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3111113);
                            c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                            c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3111111111112);
                            c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111111111111);
                            c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                            c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                            c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                            c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                            c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                            c00272.I$0 = i2;
                            c00272.I$1 = i4;
                            c00272.label = 7;
                            C00271 c002711117 = c00272;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3111111111110, str25, tvType11115, stringData, c0028113, c002711117);
                            str30 = str3111111111110;
                            c00273 = c002711117;
                            obj6 = obj4;
                            if (objNewMovieLoadResponse == obj6) {
                                return obj6;
                            }
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        str26 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta111110 = kitsuMeta6;
                        Integer num111111 = num3;
                        C00271 c002711118 = c00272;
                        r8 = r32;
                        ?? r11111119 = r37;
                        String str3111111111113 = str24;
                        String str3111111111114 = str12;
                        obj5 = obj4;
                        TvType tvType11116 = TvType.Anime;
                        list4 = list3;
                        num7 = num111111;
                        C00293 c0029114 = new C00293(r11111119, r8, arrayList3, num111111, kitsuMeta111110, str26, str3111111111113, str22, this, list4, null);
                        c002711118.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c002711118.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c002711118.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111110);
                        c002711118.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c002711118.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c002711118.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c002711118.L$6 = SpillingKt.nullOutSpilledVariable(str3111111111114);
                        c002711118.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                        c002711118.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c002711118.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c002711118.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c002711118.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c002711118.L$12 = SpillingKt.nullOutSpilledVariable((Object) r11111119);
                        c002711118.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                        c002711118.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c002711118.L$15 = SpillingKt.nullOutSpilledVariable(str3111111111113);
                        c002711118.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                        c002711118.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c002711118.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c002711118.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c002711118.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c002711118.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                        c002711118.I$0 = i2;
                        c002711118.I$1 = i4;
                        c002711118.label = 8;
                        i5 = i2;
                        objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3111111111114, str25, tvType11116, false, c0029114, c002711118, 8, (Object) null);
                        str27 = str3111111111114;
                        if (objTmdbToAnimeId == obj5) {
                            return obj5;
                        }
                        i6 = i5;
                        r17 = r8;
                        str28 = str26;
                        str29 = str18;
                        return (LoadResponse) objTmdbToAnimeId;
                    }
                    obj3 = coroutine_suspended;
                    str20 = background;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i111116 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo113 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo113.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList1111111117 = arrayList8;
                            ?? r111111110 = r68;
                            arrayList1111111117.add(loadFromKitsu$createEpisode(r111111110, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo113));
                            str21 = str21;
                            r68 = r111111110;
                            arrayList8 = arrayList1111111117;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i111116;
                            str19 = str19;
                        }
                        ArrayList arrayList1111111118 = arrayList8;
                        ?? r111111111 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList1111111118;
                        r41 = r111111111;
                    } else {
                        int i111117 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i111117;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange113 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange113, 10));
                        it = intRange113.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList1111111119 = arrayList;
                            arrayList1111111119.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList1111111119;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list1111 = list5;
                            ArrayList arrayList11111111110 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list1111;
                            arrayList2 = arrayList11111111110;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num111112 = num3;
                        String str3111111111115 = str12;
                        TvType tvType11117 = TvType.AnimeMovie;
                        String str3111111111116 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta111111 = kitsuMeta6;
                        ?? r3111115 = r32;
                        ?? r3111116 = r37;
                        String str3111111111117 = str24;
                        C00282 c0028114 = new C00282(r3111116, r3111115, num111112, kitsuMeta111111, str3111111111116, str3111111111117, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111111);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str3111111111115);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num111112);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3111116);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3111115);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str3111111111117);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str3111111111116);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c002711119 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str3111111111115, str25, tvType11117, stringData, c0028114, c002711119);
                        str30 = str3111111111115;
                        c00273 = c002711119;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta111112 = kitsuMeta6;
                    Integer num111113 = num3;
                    C00271 c0027111110 = c00272;
                    r8 = r32;
                    ?? r111111112 = r37;
                    String str3111111111118 = str24;
                    String str3111111111119 = str12;
                    obj5 = obj4;
                    TvType tvType11118 = TvType.Anime;
                    list4 = list3;
                    num7 = num111113;
                    C00293 c0029115 = new C00293(r111111112, r8, arrayList3, num111113, kitsuMeta111112, str26, str3111111111118, str22, this, list4, null);
                    c0027111110.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c0027111110.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c0027111110.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111112);
                    c0027111110.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c0027111110.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c0027111110.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c0027111110.L$6 = SpillingKt.nullOutSpilledVariable(str3111111111119);
                    c0027111110.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c0027111110.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c0027111110.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0027111110.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c0027111110.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0027111110.L$12 = SpillingKt.nullOutSpilledVariable((Object) r111111112);
                    c0027111110.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c0027111110.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c0027111110.L$15 = SpillingKt.nullOutSpilledVariable(str3111111111118);
                    c0027111110.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c0027111110.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c0027111110.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0027111110.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c0027111110.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0027111110.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c0027111110.I$0 = i2;
                    c0027111110.I$1 = i4;
                    c0027111110.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str3111111111119, str25, tvType11118, false, c0029115, c0027111110, 8, (Object) null);
                    str27 = str3111111111119;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                if (text != null) {
                    animeData = TorraStreamUtilsKt.parseAnimeData(text);
                } else {
                    animeData = str6;
                }
                name = kitsuMeta4.getName();
                if (name == null) {
                    aliases = kitsuMeta4.getAliases();
                    if (aliases != null) {
                        name = (String) CollectionsKt.firstOrNull(aliases);
                    } else {
                        name = str6;
                    }
                    if (name == null) {
                        name = "Unknown";
                    }
                }
                str8 = name;
                yearInt = kitsuMeta4.getYearInt();
                if (yearInt == null) {
                    if (animeData != 0) {
                        yearInt = null;
                    } else {
                        yearInt = null;
                    }
                }
                num2 = yearInt;
                str9 = str32;
                if (StringsKt.equals(kitsuMeta4.getType(), "movie", true)) {
                    i = 1;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.TvSeries;
                }
                if (animeData != 0) {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                } else {
                    if (StringsKt.toIntOrNull(str9) != null) {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                        if (!StringsKt.contains$default(str7, "kitsu", false, 2, (Object) null)) {
                            intOrNull = StringsKt.toIntOrNull(str9);
                        }
                    } else {
                        charSequence = "kitsu:";
                        obj2 = objTmdbToAnimeId;
                        str10 = null;
                    }
                    r5 = str10;
                }
                if (animeData != 0) {
                    r5 = intOrNull;
                    mappings = animeData.getMappings();
                    if (mappings != null) {
                        malId = mappings.getMalId();
                    } else {
                        r5 = intOrNull;
                        r7 = str10;
                    }
                } else {
                    r5 = intOrNull;
                    r7 = str10;
                }
                if (r7 == 0) {
                }
                r7 = malId;
                aniIds = new AniIds(r5, r7);
                ?? r215 = animeData;
                str11 = str7;
                r0 = r215;
                kitsuMeta5 = kitsuMeta4;
                str12 = str8;
                str13 = str9;
                r23 = r5;
                num3 = num2;
                r24 = r7;
                num4 = num;
                str14 = text;
                i2 = i;
                tvType2 = tvType;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                r2 = id;
                if (id == null) {
                    r2 = r23;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    r33 = r24;
                } else {
                    r33 = idMal;
                }
                if (r0 != 0) {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                } else {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                }
                poster = kitsuMeta5.getPoster();
                if (poster == null) {
                    r67 = r0;
                    r40 = r2;
                    url = poster;
                } else if (r0 != 0) {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                } else {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                }
                str19 = url;
                background = kitsuMeta5.getBackground();
                if (background == null) {
                    if (r67 == 0) {
                        obj3 = coroutine_suspended;
                    } else {
                        obj3 = coroutine_suspended;
                    }
                    str20 = null;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i111118 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo114 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo114.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList11111111111 = arrayList8;
                            ?? r111111113 = r68;
                            arrayList11111111111.add(loadFromKitsu$createEpisode(r111111113, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo114));
                            str21 = str21;
                            r68 = r111111113;
                            arrayList8 = arrayList11111111111;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i111118;
                            str19 = str19;
                        }
                        ArrayList arrayList11111111112 = arrayList8;
                        ?? r111111114 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList11111111112;
                        r41 = r111111114;
                    } else {
                        int i111119 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i111119;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange114 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange114, 10));
                        it = intRange114.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList11111111113 = arrayList;
                            arrayList11111111113.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList11111111113;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list1112 = list5;
                            ArrayList arrayList11111111114 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list1112;
                            arrayList2 = arrayList11111111114;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num111114 = num3;
                        String str31111111111110 = str12;
                        TvType tvType11119 = TvType.AnimeMovie;
                        String str31111111111111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta111113 = kitsuMeta6;
                        ?? r3111117 = r32;
                        ?? r3111118 = r37;
                        String str31111111111112 = str24;
                        C00282 c0028115 = new C00282(r3111118, r3111117, num111114, kitsuMeta111113, str31111111111111, str31111111111112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111113);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31111111111110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num111114);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r3111118);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3111117);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31111111111112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111111111111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c0027111111 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31111111111110, str25, tvType11119, stringData, c0028115, c0027111111);
                        str30 = str31111111111110;
                        c00273 = c0027111111;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta111114 = kitsuMeta6;
                    Integer num111115 = num3;
                    C00271 c0027111112 = c00272;
                    r8 = r32;
                    ?? r111111115 = r37;
                    String str31111111111113 = str24;
                    String str31111111111114 = str12;
                    obj5 = obj4;
                    TvType tvType111110 = TvType.Anime;
                    list4 = list3;
                    num7 = num111115;
                    C00293 c0029116 = new C00293(r111111115, r8, arrayList3, num111115, kitsuMeta111114, str26, str31111111111113, str22, this, list4, null);
                    c0027111112.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c0027111112.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c0027111112.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111114);
                    c0027111112.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c0027111112.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c0027111112.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c0027111112.L$6 = SpillingKt.nullOutSpilledVariable(str31111111111114);
                    c0027111112.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c0027111112.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c0027111112.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0027111112.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c0027111112.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0027111112.L$12 = SpillingKt.nullOutSpilledVariable((Object) r111111115);
                    c0027111112.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c0027111112.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c0027111112.L$15 = SpillingKt.nullOutSpilledVariable(str31111111111113);
                    c0027111112.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c0027111112.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c0027111112.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0027111112.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c0027111112.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0027111112.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c0027111112.I$0 = i2;
                    c0027111112.I$1 = i4;
                    c0027111112.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31111111111114, str25, tvType111110, false, c0029116, c0027111112, 8, (Object) null);
                    str27 = str31111111111114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                obj3 = coroutine_suspended;
                str20 = background;
                str21 = str20;
                if (r67 != 0) {
                    logo = kitsuMeta5.getLogo();
                } else {
                    logo = kitsuMeta5.getLogo();
                }
                str22 = logo;
                r3 = r33;
                r4 = r40;
                stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                videos = kitsuMeta5.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                list = videos;
                if (!list.isEmpty()) {
                    size = list.size();
                } else if (r67 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                if (list.isEmpty()) {
                    list6 = list;
                    i9 = size;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    i10 = 0;
                    r68 = r67;
                    while (r34.hasNext()) {
                        int i1111110 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i11 = i10;
                        TorraStreamKitsuHelper.KitsuVideo kitsuVideo115 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                        episode = kitsuVideo115.getEpisode();
                        if (episode != null) {
                            iIntValue = episode.intValue();
                        } else {
                            iIntValue = i11 + 1;
                        }
                        ArrayList arrayList11111111115 = arrayList8;
                        ?? r111111116 = r68;
                        arrayList11111111115.add(loadFromKitsu$createEpisode(r111111116, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo115));
                        str21 = str21;
                        r68 = r111111116;
                        arrayList8 = arrayList11111111115;
                        kitsuMeta5 = kitsuMeta5;
                        i9 = i9;
                        torraStreamAnime = this;
                        list6 = list6;
                        charSequence = charSequence;
                        str11 = str11;
                        obj3 = obj3;
                        i10 = i1111110;
                        str19 = str19;
                    }
                    ArrayList arrayList11111111116 = arrayList8;
                    ?? r111111117 = r68;
                    str23 = str21;
                    i4 = i9;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    arrayList2 = arrayList11111111116;
                    r41 = r111111117;
                } else {
                    int i1111111 = size;
                    r1 = r67;
                    str23 = str21;
                    i4 = i1111111;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    Iterable intRange115 = new IntRange(1, i4);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange115, 10));
                    it = intRange115.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList11111111117 = arrayList;
                        arrayList11111111117.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                        arrayList = arrayList11111111117;
                    }
                    r41 = r1;
                    arrayList2 = arrayList;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list5 = links;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        List<TorraStreamKitsuHelper.KitsuLink> list1113 = list5;
                        ArrayList arrayList11111111118 = arrayList2;
                        if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                            arrayList4.add(obj8);
                        }
                        list5 = list1113;
                        arrayList2 = arrayList11111111118;
                    }
                    arrayList3 = arrayList2;
                    arrayList5 = arrayList4;
                    i7 = 0;
                    arrayList6 = new ArrayList();
                    r11 = r4;
                    r10 = r3;
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList7 = arrayList5;
                            i8 = i7;
                            r310 = r11;
                            r36 = r10;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList7 = arrayList5;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i8 = i7;
                                r39 = r11;
                                r35 = r10;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default != null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i8 = i7;
                                r38 = r11;
                                r34 = r10;
                            }
                            r34 = r35;
                            r38 = r39;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                            r36 = r34;
                            r310 = r38;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                            arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                        } else {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                        }
                        r10 = r36;
                        arrayList5 = arrayList7;
                        i7 = i8;
                        r11 = r310;
                    }
                    r37 = r11;
                    r32 = r10;
                    list2 = arrayList6;
                } else {
                    arrayList3 = arrayList2;
                    r37 = r4;
                    r32 = r3;
                    list2 = null;
                }
                list3 = list2;
                if (i2 != 0) {
                    Integer num111116 = num3;
                    String str31111111111115 = str12;
                    TvType tvType111111 = TvType.AnimeMovie;
                    String str31111111111116 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta111115 = kitsuMeta6;
                    ?? r3111119 = r32;
                    ?? r31111110 = r37;
                    String str31111111111117 = str24;
                    C00282 c0028116 = new C00282(r31111110, r3111119, num111116, kitsuMeta111115, str31111111111116, str31111111111117, str22, null);
                    c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111115);
                    c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00272.L$6 = SpillingKt.nullOutSpilledVariable(str31111111111115);
                    c00272.L$7 = SpillingKt.nullOutSpilledVariable(num111116);
                    c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31111110);
                    c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r3111119);
                    c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00272.L$15 = SpillingKt.nullOutSpilledVariable(str31111111111117);
                    c00272.L$16 = SpillingKt.nullOutSpilledVariable(str31111111111116);
                    c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                    c00272.I$0 = i2;
                    c00272.I$1 = i4;
                    c00272.label = 7;
                    C00271 c0027111113 = c00272;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str31111111111115, str25, tvType111111, stringData, c0028116, c0027111113);
                    str30 = str31111111111115;
                    c00273 = c0027111113;
                    obj6 = obj4;
                    if (objNewMovieLoadResponse == obj6) {
                        return obj6;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                str26 = str23;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta111116 = kitsuMeta6;
                Integer num111117 = num3;
                C00271 c0027111114 = c00272;
                r8 = r32;
                ?? r111111118 = r37;
                String str31111111111118 = str24;
                String str31111111111119 = str12;
                obj5 = obj4;
                TvType tvType111112 = TvType.Anime;
                list4 = list3;
                num7 = num111117;
                C00293 c0029117 = new C00293(r111111118, r8, arrayList3, num111117, kitsuMeta111116, str26, str31111111111118, str22, this, list4, null);
                c0027111114.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                c0027111114.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                c0027111114.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111116);
                c0027111114.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                c0027111114.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c0027111114.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                c0027111114.L$6 = SpillingKt.nullOutSpilledVariable(str31111111111119);
                c0027111114.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                c0027111114.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                c0027111114.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c0027111114.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                c0027111114.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c0027111114.L$12 = SpillingKt.nullOutSpilledVariable((Object) r111111118);
                c0027111114.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                c0027111114.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                c0027111114.L$15 = SpillingKt.nullOutSpilledVariable(str31111111111118);
                c0027111114.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                c0027111114.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                c0027111114.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                c0027111114.L$19 = SpillingKt.nullOutSpilledVariable(list);
                c0027111114.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c0027111114.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                c0027111114.I$0 = i2;
                c0027111114.I$1 = i4;
                c0027111114.label = 8;
                i5 = i2;
                objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str31111111111119, str25, tvType111112, false, c0029117, c0027111114, 8, (Object) null);
                str27 = str31111111111119;
                if (objTmdbToAnimeId == obj5) {
                    return obj5;
                }
                i6 = i5;
                r17 = r8;
                str28 = str26;
                str29 = str18;
                return (LoadResponse) objTmdbToAnimeId;
            case 6:
                int i22 = c00274.I$0;
                Integer num20 = (Integer) c00274.L$10;
                Integer num21 = (Integer) c00274.L$9;
                tvType = (TvType) c00274.L$8;
                num6 = (Integer) c00274.L$7;
                str15 = (String) c00274.L$6;
                MetaAnimeData metaAnimeData = (MetaAnimeData) c00274.L$5;
                String str42 = (String) c00274.L$4;
                num5 = (Integer) c00274.L$3;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta20 = (TorraStreamKitsuHelper.KitsuMeta) c00274.L$2;
                str17 = (String) c00274.L$1;
                str7 = (String) c00274.L$0;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                c00272 = c00274;
                str16 = str42;
                charSequence = "kitsu:";
                obj2 = objTmdbToAnimeId;
                kitsuMeta4 = kitsuMeta20;
                str10 = null;
                r12 = num20;
                i3 = i22;
                r6 = num21;
                r9 = metaAnimeData;
                aniIds = (AniIds) objTmdbToAnimeId;
                str13 = str17;
                r23 = r6;
                r24 = r12;
                str14 = str16;
                num4 = num5;
                kitsuMeta5 = kitsuMeta4;
                str12 = str15;
                i2 = i3;
                num3 = num6;
                str11 = str7;
                r0 = r9;
                tvType2 = tvType;
                aniIds2 = aniIds;
                id = aniIds2.getId();
                r2 = id;
                if (id == null) {
                    r2 = r23;
                }
                idMal = aniIds2.getIdMal();
                if (idMal == null) {
                    r33 = r24;
                } else {
                    r33 = idMal;
                }
                if (r0 != 0) {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                } else {
                    if (r0 != 0) {
                        str18 = str10;
                    } else {
                        str18 = str10;
                    }
                    if (str18 == null) {
                        aliases2 = kitsuMeta5.getAliases();
                        if (aliases2 != null) {
                            str18 = (String) CollectionsKt.firstOrNull(aliases2);
                        } else {
                            str18 = str10;
                        }
                        if (str18 == null) {
                            str18 = str12;
                        }
                    }
                }
                poster = kitsuMeta5.getPoster();
                if (poster == null) {
                    r67 = r0;
                    r40 = r2;
                    url = poster;
                } else if (r0 != 0) {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                } else {
                    r69 = r0;
                    r42 = r2;
                    url = null;
                    r40 = r42;
                    r67 = r69;
                }
                str19 = url;
                background = kitsuMeta5.getBackground();
                if (background == null) {
                    if (r67 == 0) {
                        obj3 = coroutine_suspended;
                    } else {
                        obj3 = coroutine_suspended;
                    }
                    str20 = null;
                    str21 = str20;
                    if (r67 != 0) {
                        logo = kitsuMeta5.getLogo();
                    } else {
                        logo = kitsuMeta5.getLogo();
                    }
                    str22 = logo;
                    r3 = r33;
                    r4 = r40;
                    stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                    videos = kitsuMeta5.getVideos();
                    if (videos == null) {
                        videos = CollectionsKt.emptyList();
                    }
                    list = videos;
                    if (!list.isEmpty()) {
                        size = list.size();
                    } else if (r67 != 0) {
                        size = 1;
                    } else {
                        size = 1;
                    }
                    if (list.isEmpty()) {
                        list6 = list;
                        i9 = size;
                        arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                        i10 = 0;
                        r68 = r67;
                        while (r34.hasNext()) {
                            int i1111112 = i10 + 1;
                            if (i10 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i11 = i10;
                            TorraStreamKitsuHelper.KitsuVideo kitsuVideo116 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                            episode = kitsuVideo116.getEpisode();
                            if (episode != null) {
                                iIntValue = episode.intValue();
                            } else {
                                iIntValue = i11 + 1;
                            }
                            ArrayList arrayList11111111119 = arrayList8;
                            ?? r111111119 = r68;
                            arrayList11111111119.add(loadFromKitsu$createEpisode(r111111119, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo116));
                            str21 = str21;
                            r68 = r111111119;
                            arrayList8 = arrayList11111111119;
                            kitsuMeta5 = kitsuMeta5;
                            i9 = i9;
                            torraStreamAnime = this;
                            list6 = list6;
                            charSequence = charSequence;
                            str11 = str11;
                            obj3 = obj3;
                            i10 = i1111112;
                            str19 = str19;
                        }
                        ArrayList arrayList111111111110 = arrayList8;
                        ?? r1111111110 = r68;
                        str23 = str21;
                        i4 = i9;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        arrayList2 = arrayList111111111110;
                        r41 = r1111111110;
                    } else {
                        int i1111113 = size;
                        r1 = r67;
                        str23 = str21;
                        i4 = i1111113;
                        kitsuMeta6 = kitsuMeta5;
                        str24 = str19;
                        str25 = str11;
                        obj4 = obj3;
                        charSequence2 = charSequence;
                        Iterable intRange116 = new IntRange(1, i4);
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange116, 10));
                        it = intRange116.iterator();
                        while (it.hasNext()) {
                            ArrayList arrayList111111111111 = arrayList;
                            arrayList111111111111.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                            arrayList = arrayList111111111111;
                        }
                        r41 = r1;
                        arrayList2 = arrayList;
                    }
                    links = kitsuMeta6.getLinks();
                    if (links != null) {
                        list5 = links;
                        arrayList4 = new ArrayList();
                        while (r10.hasNext()) {
                            List<TorraStreamKitsuHelper.KitsuLink> list1114 = list5;
                            ArrayList arrayList111111111112 = arrayList2;
                            if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                                arrayList4.add(obj8);
                            }
                            list5 = list1114;
                            arrayList2 = arrayList111111111112;
                        }
                        arrayList3 = arrayList2;
                        arrayList5 = arrayList4;
                        i7 = 0;
                        arrayList6 = new ArrayList();
                        r11 = r4;
                        r10 = r3;
                        while (r11.hasNext()) {
                            name2 = kitsuLink.getName();
                            if (name2 == null) {
                                arrayList7 = arrayList5;
                                i8 = i7;
                                r310 = r11;
                                r36 = r10;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                            } else {
                                arrayList7 = arrayList5;
                                url2 = kitsuLink.getUrl();
                                if (url2 != null) {
                                    i8 = i7;
                                    r39 = r11;
                                    r35 = r10;
                                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                    if (strSubstringAfterLast$default != null) {
                                        animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                    }
                                } else {
                                    i8 = i7;
                                    r38 = r11;
                                    r34 = r10;
                                }
                                r34 = r35;
                                r38 = r39;
                                animeSearchResponseNewAnimeSearchResponse$default = null;
                                r36 = r34;
                                r310 = r38;
                            }
                            if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                                arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                            } else {
                                r34 = r35;
                                r38 = r39;
                                r36 = r35;
                                r310 = r39;
                            }
                            r10 = r36;
                            arrayList5 = arrayList7;
                            i7 = i8;
                            r11 = r310;
                        }
                        r37 = r11;
                        r32 = r10;
                        list2 = arrayList6;
                    } else {
                        arrayList3 = arrayList2;
                        r37 = r4;
                        r32 = r3;
                        list2 = null;
                    }
                    list3 = list2;
                    if (i2 != 0) {
                        Integer num111118 = num3;
                        String str311111111111110 = str12;
                        TvType tvType111113 = TvType.AnimeMovie;
                        String str311111111111111 = str23;
                        TorraStreamKitsuHelper.KitsuMeta kitsuMeta111117 = kitsuMeta6;
                        ?? r31111111 = r32;
                        ?? r31111112 = r37;
                        String str311111111111112 = str24;
                        C00282 c0028117 = new C00282(r31111112, r31111111, num111118, kitsuMeta111117, str311111111111111, str311111111111112, str22, null);
                        c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                        c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                        c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111117);
                        c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                        c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                        c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311111111111110);
                        c00272.L$7 = SpillingKt.nullOutSpilledVariable(num111118);
                        c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                        c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                        c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                        c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                        c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31111112);
                        c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31111111);
                        c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                        c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311111111111112);
                        c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111111111111);
                        c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                        c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                        c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                        c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                        c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                        c00272.I$0 = i2;
                        c00272.I$1 = i4;
                        c00272.label = 7;
                        C00271 c0027111115 = c00272;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311111111111110, str25, tvType111113, stringData, c0028117, c0027111115);
                        str30 = str311111111111110;
                        c00273 = c0027111115;
                        obj6 = obj4;
                        if (objNewMovieLoadResponse == obj6) {
                            return obj6;
                        }
                        return (LoadResponse) objNewMovieLoadResponse;
                    }
                    str26 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta111118 = kitsuMeta6;
                    Integer num111119 = num3;
                    C00271 c0027111116 = c00272;
                    r8 = r32;
                    ?? r1111111111 = r37;
                    String str311111111111113 = str24;
                    String str311111111111114 = str12;
                    obj5 = obj4;
                    TvType tvType111114 = TvType.Anime;
                    list4 = list3;
                    num7 = num111119;
                    C00293 c0029118 = new C00293(r1111111111, r8, arrayList3, num111119, kitsuMeta111118, str26, str311111111111113, str22, this, list4, null);
                    c0027111116.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c0027111116.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c0027111116.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111118);
                    c0027111116.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c0027111116.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c0027111116.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c0027111116.L$6 = SpillingKt.nullOutSpilledVariable(str311111111111114);
                    c0027111116.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                    c0027111116.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c0027111116.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c0027111116.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c0027111116.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c0027111116.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1111111111);
                    c0027111116.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                    c0027111116.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c0027111116.L$15 = SpillingKt.nullOutSpilledVariable(str311111111111113);
                    c0027111116.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                    c0027111116.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c0027111116.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c0027111116.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c0027111116.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c0027111116.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                    c0027111116.I$0 = i2;
                    c0027111116.I$1 = i4;
                    c0027111116.label = 8;
                    i5 = i2;
                    objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311111111111114, str25, tvType111114, false, c0029118, c0027111116, 8, (Object) null);
                    str27 = str311111111111114;
                    if (objTmdbToAnimeId == obj5) {
                        return obj5;
                    }
                    i6 = i5;
                    r17 = r8;
                    str28 = str26;
                    str29 = str18;
                    return (LoadResponse) objTmdbToAnimeId;
                }
                obj3 = coroutine_suspended;
                str20 = background;
                str21 = str20;
                if (r67 != 0) {
                    logo = kitsuMeta5.getLogo();
                } else {
                    logo = kitsuMeta5.getLogo();
                }
                str22 = logo;
                r3 = r33;
                r4 = r40;
                stringData = torraStreamAnime.toStringData(new LinkData(null, null, null, null, null, null, null, null, r40, r3, str12, num3, null, true, null, null, null, str18, null, null, false, false, false, false, num4, 16634111, null));
                videos = kitsuMeta5.getVideos();
                if (videos == null) {
                    videos = CollectionsKt.emptyList();
                }
                list = videos;
                if (!list.isEmpty()) {
                    size = list.size();
                } else if (r67 != 0) {
                    size = 1;
                } else {
                    size = 1;
                }
                if (list.isEmpty()) {
                    list6 = list;
                    i9 = size;
                    arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
                    i10 = 0;
                    r68 = r67;
                    while (r34.hasNext()) {
                        int i1111114 = i10 + 1;
                        if (i10 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i11 = i10;
                        TorraStreamKitsuHelper.KitsuVideo kitsuVideo117 = (TorraStreamKitsuHelper.KitsuVideo) obj7;
                        episode = kitsuVideo117.getEpisode();
                        if (episode != null) {
                            iIntValue = episode.intValue();
                        } else {
                            iIntValue = i11 + 1;
                        }
                        ArrayList arrayList111111111113 = arrayList8;
                        ?? r1111111112 = r68;
                        arrayList111111111113.add(loadFromKitsu$createEpisode(r1111111112, torraStreamAnime, r4, r3, str12, num3, str18, num4, iIntValue, kitsuVideo117));
                        str21 = str21;
                        r68 = r1111111112;
                        arrayList8 = arrayList111111111113;
                        kitsuMeta5 = kitsuMeta5;
                        i9 = i9;
                        torraStreamAnime = this;
                        list6 = list6;
                        charSequence = charSequence;
                        str11 = str11;
                        obj3 = obj3;
                        i10 = i1111114;
                        str19 = str19;
                    }
                    ArrayList arrayList111111111114 = arrayList8;
                    ?? r1111111113 = r68;
                    str23 = str21;
                    i4 = i9;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    arrayList2 = arrayList111111111114;
                    r41 = r1111111113;
                } else {
                    int i1111115 = size;
                    r1 = r67;
                    str23 = str21;
                    i4 = i1111115;
                    kitsuMeta6 = kitsuMeta5;
                    str24 = str19;
                    str25 = str11;
                    obj4 = obj3;
                    charSequence2 = charSequence;
                    Iterable intRange117 = new IntRange(1, i4);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange117, 10));
                    it = intRange117.iterator();
                    while (it.hasNext()) {
                        ArrayList arrayList111111111115 = arrayList;
                        arrayList111111111115.add(loadFromKitsu$createEpisode(r1, this, r4, r3, str12, num3, str18, num4, it.nextInt(), null));
                        arrayList = arrayList111111111115;
                    }
                    r41 = r1;
                    arrayList2 = arrayList;
                }
                links = kitsuMeta6.getLinks();
                if (links != null) {
                    list5 = links;
                    arrayList4 = new ArrayList();
                    while (r10.hasNext()) {
                        List<TorraStreamKitsuHelper.KitsuLink> list1115 = list5;
                        ArrayList arrayList111111111116 = arrayList2;
                        if (StringsKt.equals(((TorraStreamKitsuHelper.KitsuLink) obj8).getCategory(), "Franchise", true)) {
                            arrayList4.add(obj8);
                        }
                        list5 = list1115;
                        arrayList2 = arrayList111111111116;
                    }
                    arrayList3 = arrayList2;
                    arrayList5 = arrayList4;
                    i7 = 0;
                    arrayList6 = new ArrayList();
                    r11 = r4;
                    r10 = r3;
                    while (r11.hasNext()) {
                        name2 = kitsuLink.getName();
                        if (name2 == null) {
                            arrayList7 = arrayList5;
                            i8 = i7;
                            r310 = r11;
                            r36 = r10;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                        } else {
                            arrayList7 = arrayList5;
                            url2 = kitsuLink.getUrl();
                            if (url2 != null) {
                                i8 = i7;
                                r39 = r11;
                                r35 = r10;
                                strSubstringAfterLast$default = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                                if (strSubstringAfterLast$default != null) {
                                    animeSearchResponseNewAnimeSearchResponse$default = MainAPIKt.newAnimeSearchResponse$default(this, name2, "https://kitsu.io/anime/" + StringsKt.removePrefix(strSubstringAfterLast$default, charSequence2), TvType.Anime, false, (Function1) null, 24, (Object) null);
                                }
                            } else {
                                i8 = i7;
                                r38 = r11;
                                r34 = r10;
                            }
                            r34 = r35;
                            r38 = r39;
                            animeSearchResponseNewAnimeSearchResponse$default = null;
                            r36 = r34;
                            r310 = r38;
                        }
                        if (animeSearchResponseNewAnimeSearchResponse$default != null) {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                            arrayList6.add(animeSearchResponseNewAnimeSearchResponse$default);
                        } else {
                            r34 = r35;
                            r38 = r39;
                            r36 = r35;
                            r310 = r39;
                        }
                        r10 = r36;
                        arrayList5 = arrayList7;
                        i7 = i8;
                        r11 = r310;
                    }
                    r37 = r11;
                    r32 = r10;
                    list2 = arrayList6;
                } else {
                    arrayList3 = arrayList2;
                    r37 = r4;
                    r32 = r3;
                    list2 = null;
                }
                list3 = list2;
                if (i2 != 0) {
                    Integer num1111110 = num3;
                    String str311111111111115 = str12;
                    TvType tvType111115 = TvType.AnimeMovie;
                    String str311111111111116 = str23;
                    TorraStreamKitsuHelper.KitsuMeta kitsuMeta111119 = kitsuMeta6;
                    ?? r31111113 = r32;
                    ?? r31111114 = r37;
                    String str311111111111117 = str24;
                    C00282 c0028118 = new C00282(r31111114, r31111113, num1111110, kitsuMeta111119, str311111111111116, str311111111111117, str22, null);
                    c00272.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                    c00272.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                    c00272.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta111119);
                    c00272.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                    c00272.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    c00272.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                    c00272.L$6 = SpillingKt.nullOutSpilledVariable(str311111111111115);
                    c00272.L$7 = SpillingKt.nullOutSpilledVariable(num1111110);
                    c00272.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                    c00272.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                    c00272.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                    c00272.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                    c00272.L$12 = SpillingKt.nullOutSpilledVariable((Object) r31111114);
                    c00272.L$13 = SpillingKt.nullOutSpilledVariable((Object) r31111113);
                    c00272.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                    c00272.L$15 = SpillingKt.nullOutSpilledVariable(str311111111111117);
                    c00272.L$16 = SpillingKt.nullOutSpilledVariable(str311111111111116);
                    c00272.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                    c00272.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                    c00272.L$19 = SpillingKt.nullOutSpilledVariable(list);
                    c00272.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c00272.L$21 = SpillingKt.nullOutSpilledVariable(list3);
                    c00272.I$0 = i2;
                    c00272.I$1 = i4;
                    c00272.label = 7;
                    C00271 c0027111117 = c00272;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, str311111111111115, str25, tvType111115, stringData, c0028118, c0027111117);
                    str30 = str311111111111115;
                    c00273 = c0027111117;
                    obj6 = obj4;
                    if (objNewMovieLoadResponse == obj6) {
                        return obj6;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                str26 = str23;
                TorraStreamKitsuHelper.KitsuMeta kitsuMeta1111110 = kitsuMeta6;
                Integer num1111111 = num3;
                C00271 c0027111118 = c00272;
                r8 = r32;
                ?? r1111111114 = r37;
                String str311111111111118 = str24;
                String str311111111111119 = str12;
                obj5 = obj4;
                TvType tvType111116 = TvType.Anime;
                list4 = list3;
                num7 = num1111111;
                C00293 c0029119 = new C00293(r1111111114, r8, arrayList3, num1111111, kitsuMeta1111110, str26, str311111111111118, str22, this, list4, null);
                c0027111118.L$0 = SpillingKt.nullOutSpilledVariable(str25);
                c0027111118.L$1 = SpillingKt.nullOutSpilledVariable(str13);
                c0027111118.L$2 = SpillingKt.nullOutSpilledVariable(kitsuMeta1111110);
                c0027111118.L$3 = SpillingKt.nullOutSpilledVariable(num4);
                c0027111118.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                c0027111118.L$5 = SpillingKt.nullOutSpilledVariable((Object) r41);
                c0027111118.L$6 = SpillingKt.nullOutSpilledVariable(str311111111111119);
                c0027111118.L$7 = SpillingKt.nullOutSpilledVariable(num7);
                c0027111118.L$8 = SpillingKt.nullOutSpilledVariable(tvType2);
                c0027111118.L$9 = SpillingKt.nullOutSpilledVariable((Object) r23);
                c0027111118.L$10 = SpillingKt.nullOutSpilledVariable((Object) r24);
                c0027111118.L$11 = SpillingKt.nullOutSpilledVariable(aniIds2);
                c0027111118.L$12 = SpillingKt.nullOutSpilledVariable((Object) r1111111114);
                c0027111118.L$13 = SpillingKt.nullOutSpilledVariable((Object) r8);
                c0027111118.L$14 = SpillingKt.nullOutSpilledVariable(str18);
                c0027111118.L$15 = SpillingKt.nullOutSpilledVariable(str311111111111118);
                c0027111118.L$16 = SpillingKt.nullOutSpilledVariable(str26);
                c0027111118.L$17 = SpillingKt.nullOutSpilledVariable(str22);
                c0027111118.L$18 = SpillingKt.nullOutSpilledVariable(stringData);
                c0027111118.L$19 = SpillingKt.nullOutSpilledVariable(list);
                c0027111118.L$20 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c0027111118.L$21 = SpillingKt.nullOutSpilledVariable(list4);
                c0027111118.I$0 = i2;
                c0027111118.I$1 = i4;
                c0027111118.label = 8;
                i5 = i2;
                objTmdbToAnimeId = MainAPIKt.newAnimeLoadResponse$default(this, str311111111111119, str25, tvType111116, false, c0029119, c0027111118, 8, (Object) null);
                str27 = str311111111111119;
                if (objTmdbToAnimeId == obj5) {
                    return obj5;
                }
                i6 = i5;
                r17 = r8;
                str28 = str26;
                str29 = str18;
                return (LoadResponse) objTmdbToAnimeId;
            case 7:
                int i23 = c00274.I$1;
                int i24 = c00274.I$0;
                String str43 = (String) c00274.L$6;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                objNewMovieLoadResponse = objTmdbToAnimeId;
                str30 = str43;
                c00273 = c00274;
                obj2 = objNewMovieLoadResponse;
                return (LoadResponse) objNewMovieLoadResponse;
            case 8:
                int i25 = c00274.I$1;
                int i26 = c00274.I$0;
                List list20 = (List) c00274.L$21;
                str28 = (String) c00274.L$16;
                str29 = (String) c00274.L$14;
                r17 = (Integer) c00274.L$13;
                Integer num22 = (Integer) c00274.L$7;
                String str44 = (String) c00274.L$6;
                ResultKt.throwOnFailure(objTmdbToAnimeId);
                i6 = i26;
                str27 = str44;
                list4 = list20;
                num7 = num22;
                return (LoadResponse) objTmdbToAnimeId;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0070 A[PHI: r4
      0x0070: PHI (r4v2 java.lang.String) = (r4v1 java.lang.String), (r4v4 java.lang.String), (r4v6 java.lang.String) binds: [B:14:0x0027, B:20:0x003b, B:24:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    private static final String loadFromKitsu$resolveTitle(MetaAnimeData animeMetaData, MetaEpisode epData, TorraStreamKitsuHelper.KitsuVideo video) {
        String jsonTitle;
        Map<String, String> titles;
        Map<String, String> titles2;
        Map<String, String> title;
        Map<String, String> title2;
        Integer episode;
        Map<String, String> title3;
        Object obj = "";
        if (epData == null || (title3 = epData.getTitle()) == null || (jsonTitle = title3.get("en")) == null) {
            String title4 = (epData == null || (title2 = epData.getTitle()) == null) ? null : title2.get("ja");
            if (title4 != null) {
                jsonTitle = title4;
            } else {
                title4 = (epData == null || (title = epData.getTitle()) == null) ? null : title.get("x-jat");
                if (title4 != null) {
                    jsonTitle = title4;
                } else {
                    title4 = video != null ? video.getTitle() : null;
                    if (title4 == null) {
                        String str = (animeMetaData == null || (titles2 = animeMetaData.getTitles()) == null) ? null : titles2.get("en");
                        if (str == null) {
                            jsonTitle = (animeMetaData == null || (titles = animeMetaData.getTitles()) == null) ? null : titles.get("ja");
                            if (jsonTitle == null) {
                                jsonTitle = "";
                            }
                        } else {
                            jsonTitle = str;
                        }
                    } else {
                        jsonTitle = title4;
                    }
                }
            }
        }
        String string = jsonTitle;
        if (StringsKt.isBlank(string)) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            if (video == null || (episode = video.getEpisode()) == null) {
                String episode2 = epData != null ? epData.getEpisode() : null;
                if (episode2 != null) {
                    obj = episode2;
                }
            } else {
                obj = episode;
            }
            string = sbAppend.append(obj).toString();
        }
        return string;
    }

    private static final Episode loadFromKitsu$createEpisode(final MetaAnimeData animeMetaData, TorraStreamAnime this$0, Integer finalAniId, Integer finalMalId, String anititle, Integer aniyear, String jpTitle, Integer numericKitsuId, int i, final TorraStreamKitsuHelper.KitsuVideo video) {
        Integer season;
        Integer episode;
        Map<String, MetaEpisode> episodes;
        final MetaEpisode epData = (animeMetaData == null || (episodes = animeMetaData.getEpisodes()) == null) ? null : episodes.get(String.valueOf(i));
        final int epNum = (video == null || (episode = video.getEpisode()) == null) ? i : episode.intValue();
        final int seasonNum = (video == null || (season = video.getSeason()) == null) ? 1 : season.intValue();
        String linkData = this$0.toStringData(new LinkData(null, null, null, null, null, null, Integer.valueOf(seasonNum), Integer.valueOf(epNum), finalAniId, finalMalId, anititle, aniyear, null, true, null, null, null, jpTitle, null, null, false, false, false, false, numericKitsuId, 16633919, null));
        return MainAPIKt.newEpisode(this$0, linkData, new Function1() { // from class: com.phisher98.TorraStreamAnime$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return TorraStreamAnime.loadFromKitsu$createEpisode$lambda$5(seasonNum, epNum, epData, video, animeMetaData, (Episode) obj);
            }
        });
    }

    static final Unit loadFromKitsu$createEpisode$lambda$5(int $seasonNum, int $epNum, MetaEpisode $epData, TorraStreamKitsuHelper.KitsuVideo $video, MetaAnimeData $animeMetaData, Episode $this$newEpisode) {
        String image;
        List<ImageData> images;
        ImageData imageData;
        String overview;
        String airDateUtc;
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setName(loadFromKitsu$resolveTitle($animeMetaData, $epData, $video));
        if ($video == null || (image = $video.getThumbnail()) == null) {
            image = $epData != null ? $epData.getImage() : null;
            if (image == null) {
                image = ($animeMetaData == null || (images = $animeMetaData.getImages()) == null || (imageData = (ImageData) CollectionsKt.firstOrNull(images)) == null) ? null : imageData.getUrl();
                if (image == null) {
                    image = "";
                }
            }
        }
        $this$newEpisode.setPosterUrl(image);
        if ($video == null || (overview = $video.getOverview()) == null) {
            overview = $epData != null ? $epData.getOverview() : null;
            if (overview == null) {
                overview = "No summary available";
            }
        }
        $this$newEpisode.setDescription(overview);
        $this$newEpisode.setScore(Score.Companion.from10($epData != null ? $epData.getRating() : null));
        $this$newEpisode.setRunTime($epData != null ? $epData.getRuntime() : null);
        if ($video == null || (airDateUtc = $video.getReleased()) == null) {
            airDateUtc = $epData != null ? $epData.getAirDateUtc() : null;
        }
        MainAPIKt.addDate$default($this$newEpisode, airDateUtc, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadFromKitsu$2 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadFromKitsu$2", f = "TorraStreamAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$loadFromKitsu$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,815:1\n1#2:816\n*E\n"})
    static final class C00282 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniyear;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ Integer $finalAniId;
        final /* synthetic */ Integer $finalMalId;
        final /* synthetic */ TorraStreamKitsuHelper.KitsuMeta $kitsuMeta;
        final /* synthetic */ String $logoposter;
        final /* synthetic */ String $posterUrl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00282(Integer num, Integer num2, Integer num3, TorraStreamKitsuHelper.KitsuMeta kitsuMeta, String str, String str2, String str3, Continuation<? super C00282> continuation) {
            super(2, continuation);
            this.$finalAniId = num;
            this.$finalMalId = num2;
            this.$aniyear = num3;
            this.$kitsuMeta = kitsuMeta;
            this.$backgroundUrl = str;
            this.$posterUrl = str2;
            this.$logoposter = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00282 = new C00282(this.$finalAniId, this.$finalMalId, this.$aniyear, this.$kitsuMeta, this.$backgroundUrl, this.$posterUrl, this.$logoposter, continuation);
            c00282.L$0 = obj;
            return c00282;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Integer num = this.$finalAniId;
                    if (num != null) {
                        int it = num.intValue();
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(it));
                    }
                    Integer num2 = this.$finalMalId;
                    if (num2 != null) {
                        int it2 = num2.intValue();
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(it2));
                    }
                    loadResponse.setYear(this.$aniyear);
                    loadResponse.setPlot(this.$kitsuMeta.getDescription());
                    loadResponse.setBackgroundPosterUrl(this.$backgroundUrl);
                    loadResponse.setPosterUrl(this.$posterUrl);
                    try {
                        loadResponse.setLogoUrl(this.$logoposter);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setTags(this.$kitsuMeta.getGenres());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadFromKitsu$3 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadFromKitsu$3", f = "TorraStreamAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$loadFromKitsu$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,815:1\n1#2:816\n*E\n"})
    static final class C00293 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniyear;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ Integer $finalAniId;
        final /* synthetic */ Integer $finalMalId;
        final /* synthetic */ TorraStreamKitsuHelper.KitsuMeta $kitsuMeta;
        final /* synthetic */ String $logoposter;
        final /* synthetic */ String $posterUrl;
        final /* synthetic */ List<AnimeSearchResponse> $recs;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TorraStreamAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00293(Integer num, Integer num2, List<Episode> list, Integer num3, TorraStreamKitsuHelper.KitsuMeta kitsuMeta, String str, String str2, String str3, TorraStreamAnime torraStreamAnime, List<AnimeSearchResponse> list2, Continuation<? super C00293> continuation) {
            super(2, continuation);
            this.$finalAniId = num;
            this.$finalMalId = num2;
            this.$episodes = list;
            this.$aniyear = num3;
            this.$kitsuMeta = kitsuMeta;
            this.$backgroundUrl = str;
            this.$posterUrl = str2;
            this.$logoposter = str3;
            this.this$0 = torraStreamAnime;
            this.$recs = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00293 = new C00293(this.$finalAniId, this.$finalMalId, this.$episodes, this.$aniyear, this.$kitsuMeta, this.$backgroundUrl, this.$posterUrl, this.$logoposter, this.this$0, this.$recs, continuation);
            c00293.L$0 = obj;
            return c00293;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Integer num = this.$finalAniId;
                    if (num != null) {
                        int it = num.intValue();
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt(it));
                    }
                    Integer num2 = this.$finalMalId;
                    if (num2 != null) {
                        int it2 = num2.intValue();
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt(it2));
                    }
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    loadResponse.setYear(this.$aniyear);
                    loadResponse.setPlot(this.$kitsuMeta.getDescription());
                    loadResponse.setBackgroundPosterUrl(this.$backgroundUrl);
                    loadResponse.setPosterUrl(this.$posterUrl);
                    try {
                        loadResponse.setLogoUrl(this.$logoposter);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setTags(this.$kitsuMeta.getGenres());
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$kitsuMeta.getStatus()));
                    List<AnimeSearchResponse> list = this.$recs;
                    if (!(list == null || list.isEmpty())) {
                        loadResponse.setRecommendations(this.$recs);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x04c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:115:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:119:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:122:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:124:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:128:0x0500  */
    /* JADX WARN: Code duplicated, block: B:130:0x0503  */
    /* JADX WARN: Code duplicated, block: B:132:0x050b  */
    /* JADX WARN: Code duplicated, block: B:134:0x05a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:137:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:141:0x0680 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:142:0x0681  */
    /* JADX WARN: Code duplicated, block: B:147:0x039f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x0398 A[Catch: Exception -> 0x03f7, TRY_LEAVE, TryCatch #6 {Exception -> 0x03f7, blocks: (B:80:0x038f, B:82:0x0398), top: B:154:0x038f }] */
    /* JADX WARN: Code duplicated, block: B:88:0x03c3 A[Catch: Exception -> 0x03ce, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ce, blocks: (B:85:0x039f, B:86:0x03a7, B:88:0x03c3, B:97:0x03e9), top: B:147:0x039f }] */
    /* JADX WARN: Code duplicated, block: B:92:0x03da  */
    static /* synthetic */ Object loadLinks$suspendImpl(TorraStreamAnime $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) throws JSONException {
        C00301 c00301;
        String key;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Integer aniid;
        Ref.IntRef kitsuId;
        Ref.ObjectRef anidbEid;
        Ref.ObjectRef anidbEid2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        TorraStreamAnime $this2;
        Object obj3;
        String provider;
        String key2;
        Ref.ObjectRef type;
        LinkData mediaData;
        Integer aniid2;
        String data2;
        boolean isCasting2;
        String queryParam;
        StringBuilder sbAppend;
        LinkData mediaData2;
        Ref.ObjectRef episode;
        Ref.IntRef kitsuId2;
        Ref.ObjectRef episode2;
        Function1<? super SubtitleFile, Unit> function5;
        Object obj4;
        Ref.IntRef kitsuId3;
        Ref.ObjectRef type2;
        Ref.ObjectRef type3;
        TorraStreamAnime $this3;
        String debianapiUrl;
        Object objBuildMeteorUrl;
        Ref.ObjectRef episode3;
        String debianapiUrl2;
        Ref.ObjectRef anidbEid3;
        String key3;
        String debianapiUrl3;
        LinkData mediaData3;
        Ref.IntRef kitsuId4;
        Integer aniid3;
        Ref.ObjectRef type4;
        TorraStreamAnime $this4;
        JSONObject mappings;
        Function1<? super SubtitleFile, Unit> function6;
        Integer anidbEid4;
        String rawtype;
        String meteorUrl;
        Function1<ExtractorLink, Unit> function1FilteredCallback;
        String str;
        boolean z;
        Function1[] function1Arr;
        String str2;
        boolean z2;
        Function1[] function1Arr2;
        Ref.IntRef kitsuId5;
        Ref.ObjectRef episode4;
        Ref.ObjectRef type5;
        String provider2;
        Ref.ObjectRef anidbEid5;
        Integer aniid4;
        LinkData mediaData4;
        Ref.IntRef kitsuId6;
        Ref.ObjectRef anidbEid6;
        Ref.ObjectRef episode5;
        String key4;
        if (continuation instanceof C00301) {
            c00301 = (C00301) continuation;
            if ((c00301.label & Integer.MIN_VALUE) != 0) {
                c00301.label -= Integer.MIN_VALUE;
            } else {
                c00301 = $this.new C00301(continuation);
            }
        } else {
            c00301 = $this.new C00301(continuation);
        }
        C00301 c00302 = c00301;
        Object $result = c00302.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00302.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String provider3 = $this.sharedPref.getString("debrid_provider", null);
                key = $this.sharedPref.getString("debrid_key", null);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LinkData.class);
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
                        obj2 = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkData.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = null;
                    }
                    break;
                } else {
                    obj2 = null;
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.TorraStreamAnime$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.TorraStreamAnime$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.TorraStreamAnime$loadLinks$suspendImpl$$inlined$parseJson$1
                    });
                }
                LinkData mediaData5 = (LinkData) objDecodeFromString;
                Ref.ObjectRef episode6 = new Ref.ObjectRef();
                episode6.element = mediaData5.getEpisode();
                aniid = mediaData5.getAniId();
                kitsuId = new Ref.IntRef();
                Integer kitsuId7 = mediaData5.getKitsuId();
                kitsuId.element = kitsuId7 != null ? kitsuId7.intValue() : -1;
                Ref.ObjectRef type6 = new Ref.ObjectRef();
                type6.element = TvType.TvSeries;
                Ref.ObjectRef anidbEid7 = new Ref.ObjectRef();
                try {
                    if (aniid != null) {
                        queryParam = "anilist_id=" + aniid.intValue();
                    } else {
                        try {
                            if (kitsuId.element != -1) {
                                sbAppend = new StringBuilder().append("kitsu_id=").append(kitsuId.element);
                            } else if (mediaData5.getMalId() != null) {
                                sbAppend = new StringBuilder().append("mal_id=").append(mediaData5.getMalId().intValue());
                            } else {
                                queryParam = null;
                            }
                            queryParam = sbAppend.toString();
                        } catch (Exception e2) {
                            obj3 = coroutine_suspended;
                            $this2 = $this;
                            isCasting2 = isCasting;
                            function3 = function1;
                            function4 = function2;
                            mediaData = mediaData5;
                            aniid2 = aniid;
                            anidbEid = episode6;
                            key2 = key;
                            type = type6;
                            anidbEid2 = anidbEid7;
                            provider = provider3;
                            data2 = data;
                            aniid = aniid2;
                            episode = anidbEid;
                            mediaData2 = mediaData;
                            episode2 = type;
                            kitsuId2 = kitsuId;
                            key = key2;
                            debianapiUrl = $this2.buildApiUrl($this2.sharedPref, $this2.torrentioDebian);
                            SharedPreferences sharedPreferences = $this2.sharedPref;
                            c00302.L$0 = $this2;
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = function4;
                            c00302.L$4 = provider;
                            c00302.L$5 = key;
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                            c00302.L$7 = episode;
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                            c00302.L$9 = kitsuId2;
                            c00302.L$10 = episode2;
                            c00302.L$11 = anidbEid2;
                            c00302.L$12 = debianapiUrl;
                            c00302.Z$0 = isCasting2;
                            c00302.label = 2;
                            objBuildMeteorUrl = $this2.buildMeteorUrl(sharedPreferences, TorraStream.Meteorfortheweebs, c00302);
                            if (objBuildMeteorUrl == obj3) {
                                return obj3;
                            }
                            episode3 = episode;
                            debianapiUrl2 = debianapiUrl;
                            $result = objBuildMeteorUrl;
                            anidbEid3 = anidbEid2;
                            key3 = key;
                            debianapiUrl3 = provider;
                            mediaData3 = mediaData2;
                            kitsuId4 = kitsuId2;
                            aniid3 = aniid;
                            type4 = episode2;
                            meteorUrl = (String) $result;
                            function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this2.sharedPref, function4);
                            str = debianapiUrl3;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                str2 = key3;
                                if (str2 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    if (kitsuId4.element != -1) {
                                        kitsuId5 = kitsuId4;
                                        C00314 c00314 = new C00314(debianapiUrl2, type4, kitsuId5, episode3, function1FilteredCallback, null);
                                        episode4 = episode3;
                                        type5 = type4;
                                        function1Arr2 = new Function1[]{c00314, new C00325(meteorUrl, type5, kitsuId5, episode4, function1FilteredCallback, null)};
                                        c00302.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                                        c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                        c00302.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                        c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                                        c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                                        c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode4);
                                        c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                                        c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00302.L$10 = SpillingKt.nullOutSpilledVariable(type5);
                                        c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                                        c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                                        c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                                        c00302.Z$0 = isCasting2;
                                        c00302.label = 3;
                                        if (ParCollectionsKt.runAllAsync(function1Arr2, c00302) == obj3) {
                                            return obj3;
                                        }
                                        provider2 = debianapiUrl3;
                                        anidbEid5 = anidbEid3;
                                        aniid4 = aniid3;
                                        mediaData4 = mediaData3;
                                        kitsuId6 = kitsuId5;
                                        anidbEid6 = type5;
                                        episode5 = episode4;
                                        key4 = key3;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            String debianapiUrl4 = debianapiUrl2;
                            Ref.IntRef kitsuId8 = kitsuId4;
                            Ref.ObjectRef episode7 = episode3;
                            Function1<? super ExtractorLink, Unit> function7 = function4;
                            Ref.ObjectRef episode8 = type4;
                            TorraStreamAnime $this5 = $this2;
                            function1Arr = new Function1[]{new C00336(anidbEid3, function4, null), new C00347(kitsuId8, $this5, episode8, episode7, function7, null), new C00358(kitsuId8, $this5, episode7, function1FilteredCallback, null)};
                            c00302.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                            c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                            c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode7);
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                            c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId8);
                            c00302.L$10 = SpillingKt.nullOutSpilledVariable(episode8);
                            c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                            c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl4);
                            c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00302.Z$0 = isCasting2;
                            c00302.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr, c00302) == obj3) {
                                return obj3;
                            }
                            return Boxing.boxBoolean(true);
                        }
                    }
                    if (queryParam != null) {
                        Requests app = MainActivityKt.getApp();
                        String str3 = "https://api.ani.zip/mappings?" + queryParam;
                        c00302.L$0 = $this;
                        c00302.L$1 = SpillingKt.nullOutSpilledVariable(data);
                        c00302.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        c00302.L$3 = function2;
                        c00302.L$4 = provider3;
                        c00302.L$5 = key;
                        c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData5);
                        c00302.L$7 = episode6;
                        c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                        c00302.L$9 = kitsuId;
                        c00302.L$10 = type6;
                        c00302.L$11 = anidbEid7;
                        c00302.L$12 = SpillingKt.nullOutSpilledVariable(queryParam);
                        c00302.Z$0 = isCasting;
                        c00302.label = 1;
                        obj3 = coroutine_suspended;
                        try {
                            Object obj5 = Requests.get$default(app, str3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00302, 4094, (Object) null);
                            c00302 = c00302;
                            if (obj5 == obj3) {
                                return obj3;
                            }
                            isCasting2 = isCasting;
                            function5 = function1;
                            function4 = function2;
                            obj4 = obj5;
                            mediaData = mediaData5;
                            anidbEid = episode6;
                            key2 = key;
                            kitsuId3 = kitsuId;
                            type2 = type6;
                            type3 = anidbEid7;
                            provider = provider3;
                            $this3 = $this;
                            data2 = data;
                            try {
                                String anijson = ((NiceResponse) obj4).getText();
                                $this4 = $this3;
                                try {
                                    mappings = new JSONObject(anijson).optJSONObject("mappings");
                                    if (mappings != null) {
                                        function6 = function5;
                                        if (kitsuId3.element == -1) {
                                            try {
                                                kitsuId3.element = mappings.optInt("kitsu_id", -1);
                                            } catch (Exception e3) {
                                                $this2 = $this4;
                                                function3 = function6;
                                                anidbEid2 = type3;
                                                type = type2;
                                                kitsuId = kitsuId3;
                                                aniid2 = aniid;
                                                aniid = aniid2;
                                                episode = anidbEid;
                                                mediaData2 = mediaData;
                                                episode2 = type;
                                                kitsuId2 = kitsuId;
                                                key = key2;
                                            }
                                        }
                                        rawtype = mappings.optString("type", "");
                                        if (StringsKt.contains(rawtype, "MOVIE", true)) {
                                            type2.element = TvType.Movie;
                                            anidbEid.element = Boxing.boxInt(1);
                                        }
                                    } else {
                                        function6 = function5;
                                    }
                                    try {
                                        anidbEid4 = TorraStreamUtilsKt.getAnidbEid(anijson, (Integer) anidbEid.element);
                                    } catch (Exception e4) {
                                        anidbEid4 = null;
                                    }
                                    type3.element = anidbEid4;
                                    $this2 = $this4;
                                    function3 = function6;
                                    anidbEid2 = type3;
                                    episode = anidbEid;
                                    mediaData2 = mediaData;
                                    key = key2;
                                    episode2 = type2;
                                    kitsuId2 = kitsuId3;
                                } catch (Exception e5) {
                                    $this2 = $this4;
                                    function3 = function5;
                                    anidbEid2 = type3;
                                    type = type2;
                                    kitsuId = kitsuId3;
                                    aniid2 = aniid;
                                }
                            } catch (Exception e6) {
                                $this2 = $this3;
                                function3 = function5;
                                anidbEid2 = type3;
                                type = type2;
                                kitsuId = kitsuId3;
                                aniid2 = aniid;
                            }
                        } catch (Exception e7) {
                            c00302 = c00302;
                            $this2 = $this;
                            isCasting2 = isCasting;
                            function3 = function1;
                            function4 = function2;
                            mediaData = mediaData5;
                            aniid2 = aniid;
                            anidbEid = episode6;
                            key2 = key;
                            kitsuId = kitsuId;
                            type = type6;
                            anidbEid2 = anidbEid7;
                            provider = provider3;
                            data2 = data;
                            aniid = aniid2;
                            episode = anidbEid;
                            mediaData2 = mediaData;
                            episode2 = type;
                            kitsuId2 = kitsuId;
                            key = key2;
                            debianapiUrl = $this2.buildApiUrl($this2.sharedPref, $this2.torrentioDebian);
                            SharedPreferences sharedPreferences2 = $this2.sharedPref;
                            c00302.L$0 = $this2;
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = function4;
                            c00302.L$4 = provider;
                            c00302.L$5 = key;
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                            c00302.L$7 = episode;
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                            c00302.L$9 = kitsuId2;
                            c00302.L$10 = episode2;
                            c00302.L$11 = anidbEid2;
                            c00302.L$12 = debianapiUrl;
                            c00302.Z$0 = isCasting2;
                            c00302.label = 2;
                            objBuildMeteorUrl = $this2.buildMeteorUrl(sharedPreferences2, TorraStream.Meteorfortheweebs, c00302);
                            if (objBuildMeteorUrl == obj3) {
                                return obj3;
                            }
                            episode3 = episode;
                            debianapiUrl2 = debianapiUrl;
                            $result = objBuildMeteorUrl;
                            anidbEid3 = anidbEid2;
                            key3 = key;
                            debianapiUrl3 = provider;
                            mediaData3 = mediaData2;
                            kitsuId4 = kitsuId2;
                            aniid3 = aniid;
                            type4 = episode2;
                            meteorUrl = (String) $result;
                            function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this2.sharedPref, function4);
                            str = debianapiUrl3;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                str2 = key3;
                                if (str2 != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    if (kitsuId4.element != -1) {
                                        kitsuId5 = kitsuId4;
                                        C00314 c00315 = new C00314(debianapiUrl2, type4, kitsuId5, episode3, function1FilteredCallback, null);
                                        episode4 = episode3;
                                        type5 = type4;
                                        function1Arr2 = new Function1[]{c00315, new C00325(meteorUrl, type5, kitsuId5, episode4, function1FilteredCallback, null)};
                                        c00302.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                                        c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                                        c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                        c00302.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                        c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                                        c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                                        c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                                        c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode4);
                                        c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                                        c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                        c00302.L$10 = SpillingKt.nullOutSpilledVariable(type5);
                                        c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                                        c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                                        c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                        c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                                        c00302.Z$0 = isCasting2;
                                        c00302.label = 3;
                                        if (ParCollectionsKt.runAllAsync(function1Arr2, c00302) == obj3) {
                                            return obj3;
                                        }
                                        provider2 = debianapiUrl3;
                                        anidbEid5 = anidbEid3;
                                        aniid4 = aniid3;
                                        mediaData4 = mediaData3;
                                        kitsuId6 = kitsuId5;
                                        anidbEid6 = type5;
                                        episode5 = episode4;
                                        key4 = key3;
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                return Boxing.boxBoolean(true);
                            }
                            String debianapiUrl5 = debianapiUrl2;
                            Ref.IntRef kitsuId9 = kitsuId4;
                            Ref.ObjectRef episode9 = episode3;
                            Function1<? super ExtractorLink, Unit> function8 = function4;
                            Ref.ObjectRef episode10 = type4;
                            TorraStreamAnime $this6 = $this2;
                            function1Arr = new Function1[]{new C00336(anidbEid3, function4, null), new C00347(kitsuId9, $this6, episode10, episode9, function8, null), new C00358(kitsuId9, $this6, episode9, function1FilteredCallback, null)};
                            c00302.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                            c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                            c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode9);
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                            c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId9);
                            c00302.L$10 = SpillingKt.nullOutSpilledVariable(episode10);
                            c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                            c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl5);
                            c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00302.Z$0 = isCasting2;
                            c00302.label = 4;
                            if (ParCollectionsKt.runAllAsync(function1Arr, c00302) == obj3) {
                                return obj3;
                            }
                            return Boxing.boxBoolean(true);
                        }
                    } else {
                        obj3 = coroutine_suspended;
                        $this2 = $this;
                        isCasting2 = isCasting;
                        function3 = function1;
                        function4 = function2;
                        mediaData2 = mediaData5;
                        episode = episode6;
                        kitsuId2 = kitsuId;
                        episode2 = type6;
                        anidbEid2 = anidbEid7;
                        provider = provider3;
                        data2 = data;
                    }
                    break;
                } catch (Exception e8) {
                    anidbEid = episode6;
                    anidbEid2 = anidbEid7;
                    function3 = function1;
                    function4 = function2;
                    $this2 = $this;
                    obj3 = coroutine_suspended;
                    provider = provider3;
                    key2 = key;
                    type = type6;
                    mediaData = mediaData5;
                    aniid2 = aniid;
                    data2 = data;
                    isCasting2 = isCasting;
                }
                debianapiUrl = $this2.buildApiUrl($this2.sharedPref, $this2.torrentioDebian);
                SharedPreferences sharedPreferences3 = $this2.sharedPref;
                c00302.L$0 = $this2;
                c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00302.L$3 = function4;
                c00302.L$4 = provider;
                c00302.L$5 = key;
                c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                c00302.L$7 = episode;
                c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                c00302.L$9 = kitsuId2;
                c00302.L$10 = episode2;
                c00302.L$11 = anidbEid2;
                c00302.L$12 = debianapiUrl;
                c00302.Z$0 = isCasting2;
                c00302.label = 2;
                objBuildMeteorUrl = $this2.buildMeteorUrl(sharedPreferences3, TorraStream.Meteorfortheweebs, c00302);
                if (objBuildMeteorUrl == obj3) {
                    return obj3;
                }
                episode3 = episode;
                debianapiUrl2 = debianapiUrl;
                $result = objBuildMeteorUrl;
                anidbEid3 = anidbEid2;
                key3 = key;
                debianapiUrl3 = provider;
                mediaData3 = mediaData2;
                kitsuId4 = kitsuId2;
                aniid3 = aniid;
                type4 = episode2;
                meteorUrl = (String) $result;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this2.sharedPref, function4);
                str = debianapiUrl3;
                if (str != null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    str2 = key3;
                    if (str2 != null || str2.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if (kitsuId4.element != -1) {
                            kitsuId5 = kitsuId4;
                            C00314 c00316 = new C00314(debianapiUrl2, type4, kitsuId5, episode3, function1FilteredCallback, null);
                            episode4 = episode3;
                            type5 = type4;
                            function1Arr2 = new Function1[]{c00316, new C00325(meteorUrl, type5, kitsuId5, episode4, function1FilteredCallback, null)};
                            c00302.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                            c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                            c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode4);
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                            c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00302.L$10 = SpillingKt.nullOutSpilledVariable(type5);
                            c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                            c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                            c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00302.Z$0 = isCasting2;
                            c00302.label = 3;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00302) == obj3) {
                                return obj3;
                            }
                            provider2 = debianapiUrl3;
                            anidbEid5 = anidbEid3;
                            aniid4 = aniid3;
                            mediaData4 = mediaData3;
                            kitsuId6 = kitsuId5;
                            anidbEid6 = type5;
                            episode5 = episode4;
                            key4 = key3;
                        }
                        Unit unit3 = Unit.INSTANCE;
                    }
                    return Boxing.boxBoolean(true);
                }
                String debianapiUrl6 = debianapiUrl2;
                Ref.IntRef kitsuId10 = kitsuId4;
                Ref.ObjectRef episode11 = episode3;
                Function1<? super ExtractorLink, Unit> function9 = function4;
                Ref.ObjectRef episode12 = type4;
                TorraStreamAnime $this7 = $this2;
                function1Arr = new Function1[]{new C00336(anidbEid3, function4, null), new C00347(kitsuId10, $this7, episode12, episode11, function9, null), new C00358(kitsuId10, $this7, episode11, function1FilteredCallback, null)};
                c00302.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00302.L$3 = SpillingKt.nullOutSpilledVariable(function9);
                c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode11);
                c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId10);
                c00302.L$10 = SpillingKt.nullOutSpilledVariable(episode12);
                c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl6);
                c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                c00302.Z$0 = isCasting2;
                c00302.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00302) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(true);
            case 1:
                isCasting2 = c00302.Z$0;
                anidbEid2 = (Ref.ObjectRef) c00302.L$11;
                type = (Ref.ObjectRef) c00302.L$10;
                kitsuId = (Ref.IntRef) c00302.L$9;
                aniid2 = (Integer) c00302.L$8;
                anidbEid = (Ref.ObjectRef) c00302.L$7;
                mediaData = (LinkData) c00302.L$6;
                key2 = (String) c00302.L$5;
                provider = (String) c00302.L$4;
                function4 = (Function1) c00302.L$3;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00302.L$2;
                data2 = (String) c00302.L$1;
                TorraStreamAnime $this8 = (TorraStreamAnime) c00302.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    aniid = aniid2;
                    $this3 = $this8;
                    obj3 = coroutine_suspended;
                    kitsuId3 = kitsuId;
                    function5 = function10;
                    type2 = type;
                    type3 = anidbEid2;
                    String anijson2 = ((NiceResponse) obj4).getText();
                    $this4 = $this3;
                    mappings = new JSONObject(anijson2).optJSONObject("mappings");
                    if (mappings != null) {
                        function6 = function5;
                        if (kitsuId3.element == -1) {
                            kitsuId3.element = mappings.optInt("kitsu_id", -1);
                        }
                        rawtype = mappings.optString("type", "");
                        if (StringsKt.contains(rawtype, "MOVIE", true)) {
                            type2.element = TvType.Movie;
                            anidbEid.element = Boxing.boxInt(1);
                        }
                    } else {
                        function6 = function5;
                    }
                    anidbEid4 = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) anidbEid.element);
                    type3.element = anidbEid4;
                    $this2 = $this4;
                    function3 = function6;
                    anidbEid2 = type3;
                    episode = anidbEid;
                    mediaData2 = mediaData;
                    key = key2;
                    episode2 = type2;
                    kitsuId2 = kitsuId3;
                } catch (Exception e9) {
                    $this2 = $this8;
                    obj3 = coroutine_suspended;
                    function3 = function10;
                    aniid = aniid2;
                    episode = anidbEid;
                    mediaData2 = mediaData;
                    episode2 = type;
                    kitsuId2 = kitsuId;
                    key = key2;
                    debianapiUrl = $this2.buildApiUrl($this2.sharedPref, $this2.torrentioDebian);
                    SharedPreferences sharedPreferences4 = $this2.sharedPref;
                    c00302.L$0 = $this2;
                    c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                    c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00302.L$3 = function4;
                    c00302.L$4 = provider;
                    c00302.L$5 = key;
                    c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                    c00302.L$7 = episode;
                    c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                    c00302.L$9 = kitsuId2;
                    c00302.L$10 = episode2;
                    c00302.L$11 = anidbEid2;
                    c00302.L$12 = debianapiUrl;
                    c00302.Z$0 = isCasting2;
                    c00302.label = 2;
                    objBuildMeteorUrl = $this2.buildMeteorUrl(sharedPreferences4, TorraStream.Meteorfortheweebs, c00302);
                    if (objBuildMeteorUrl == obj3) {
                        return obj3;
                    }
                    episode3 = episode;
                    debianapiUrl2 = debianapiUrl;
                    $result = objBuildMeteorUrl;
                    anidbEid3 = anidbEid2;
                    key3 = key;
                    debianapiUrl3 = provider;
                    mediaData3 = mediaData2;
                    kitsuId4 = kitsuId2;
                    aniid3 = aniid;
                    type4 = episode2;
                    meteorUrl = (String) $result;
                    function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this2.sharedPref, function4);
                    str = debianapiUrl3;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        str2 = key3;
                        if (str2 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            if (kitsuId4.element != -1) {
                                kitsuId5 = kitsuId4;
                                C00314 c00317 = new C00314(debianapiUrl2, type4, kitsuId5, episode3, function1FilteredCallback, null);
                                episode4 = episode3;
                                type5 = type4;
                                function1Arr2 = new Function1[]{c00317, new C00325(meteorUrl, type5, kitsuId5, episode4, function1FilteredCallback, null)};
                                c00302.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                                c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                                c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                c00302.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                                c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                                c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                                c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode4);
                                c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                                c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                                c00302.L$10 = SpillingKt.nullOutSpilledVariable(type5);
                                c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                                c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                                c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                                c00302.Z$0 = isCasting2;
                                c00302.label = 3;
                                if (ParCollectionsKt.runAllAsync(function1Arr2, c00302) == obj3) {
                                    return obj3;
                                }
                                provider2 = debianapiUrl3;
                                anidbEid5 = anidbEid3;
                                aniid4 = aniid3;
                                mediaData4 = mediaData3;
                                kitsuId6 = kitsuId5;
                                anidbEid6 = type5;
                                episode5 = episode4;
                                key4 = key3;
                            }
                            Unit unit4 = Unit.INSTANCE;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    String debianapiUrl7 = debianapiUrl2;
                    Ref.IntRef kitsuId11 = kitsuId4;
                    Ref.ObjectRef episode13 = episode3;
                    Function1<? super ExtractorLink, Unit> function11 = function4;
                    Ref.ObjectRef episode14 = type4;
                    TorraStreamAnime $this9 = $this2;
                    function1Arr = new Function1[]{new C00336(anidbEid3, function4, null), new C00347(kitsuId11, $this9, episode14, episode13, function11, null), new C00358(kitsuId11, $this9, episode13, function1FilteredCallback, null)};
                    c00302.L$0 = SpillingKt.nullOutSpilledVariable($this9);
                    c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                    c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00302.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                    c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                    c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                    c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                    c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode13);
                    c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                    c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId11);
                    c00302.L$10 = SpillingKt.nullOutSpilledVariable(episode14);
                    c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                    c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl7);
                    c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                    c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                    c00302.Z$0 = isCasting2;
                    c00302.label = 4;
                    if (ParCollectionsKt.runAllAsync(function1Arr, c00302) == obj3) {
                        return obj3;
                    }
                    return Boxing.boxBoolean(true);
                }
                debianapiUrl = $this2.buildApiUrl($this2.sharedPref, $this2.torrentioDebian);
                SharedPreferences sharedPreferences5 = $this2.sharedPref;
                c00302.L$0 = $this2;
                c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00302.L$3 = function4;
                c00302.L$4 = provider;
                c00302.L$5 = key;
                c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                c00302.L$7 = episode;
                c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                c00302.L$9 = kitsuId2;
                c00302.L$10 = episode2;
                c00302.L$11 = anidbEid2;
                c00302.L$12 = debianapiUrl;
                c00302.Z$0 = isCasting2;
                c00302.label = 2;
                objBuildMeteorUrl = $this2.buildMeteorUrl(sharedPreferences5, TorraStream.Meteorfortheweebs, c00302);
                if (objBuildMeteorUrl == obj3) {
                    return obj3;
                }
                episode3 = episode;
                debianapiUrl2 = debianapiUrl;
                $result = objBuildMeteorUrl;
                anidbEid3 = anidbEid2;
                key3 = key;
                debianapiUrl3 = provider;
                mediaData3 = mediaData2;
                kitsuId4 = kitsuId2;
                aniid3 = aniid;
                type4 = episode2;
                meteorUrl = (String) $result;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this2.sharedPref, function4);
                str = debianapiUrl3;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    str2 = key3;
                    if (str2 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        if (kitsuId4.element != -1) {
                            kitsuId5 = kitsuId4;
                            C00314 c00318 = new C00314(debianapiUrl2, type4, kitsuId5, episode3, function1FilteredCallback, null);
                            episode4 = episode3;
                            type5 = type4;
                            function1Arr2 = new Function1[]{c00318, new C00325(meteorUrl, type5, kitsuId5, episode4, function1FilteredCallback, null)};
                            c00302.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                            c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                            c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode4);
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                            c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00302.L$10 = SpillingKt.nullOutSpilledVariable(type5);
                            c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                            c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                            c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00302.Z$0 = isCasting2;
                            c00302.label = 3;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00302) == obj3) {
                                return obj3;
                            }
                            provider2 = debianapiUrl3;
                            anidbEid5 = anidbEid3;
                            aniid4 = aniid3;
                            mediaData4 = mediaData3;
                            kitsuId6 = kitsuId5;
                            anidbEid6 = type5;
                            episode5 = episode4;
                            key4 = key3;
                        }
                        Unit unit5 = Unit.INSTANCE;
                    }
                    return Boxing.boxBoolean(true);
                }
                String debianapiUrl8 = debianapiUrl2;
                Ref.IntRef kitsuId12 = kitsuId4;
                Ref.ObjectRef episode15 = episode3;
                Function1<? super ExtractorLink, Unit> function12 = function4;
                Ref.ObjectRef episode16 = type4;
                TorraStreamAnime $this10 = $this2;
                function1Arr = new Function1[]{new C00336(anidbEid3, function4, null), new C00347(kitsuId12, $this10, episode16, episode15, function12, null), new C00358(kitsuId12, $this10, episode15, function1FilteredCallback, null)};
                c00302.L$0 = SpillingKt.nullOutSpilledVariable($this10);
                c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00302.L$3 = SpillingKt.nullOutSpilledVariable(function12);
                c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode15);
                c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId12);
                c00302.L$10 = SpillingKt.nullOutSpilledVariable(episode16);
                c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl8);
                c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                c00302.Z$0 = isCasting2;
                c00302.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00302) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting3 = c00302.Z$0;
                String debianapiUrl9 = (String) c00302.L$12;
                Ref.ObjectRef anidbEid8 = (Ref.ObjectRef) c00302.L$11;
                Ref.ObjectRef type7 = (Ref.ObjectRef) c00302.L$10;
                Ref.IntRef kitsuId13 = (Ref.IntRef) c00302.L$9;
                Integer aniid5 = (Integer) c00302.L$8;
                Ref.ObjectRef episode17 = (Ref.ObjectRef) c00302.L$7;
                LinkData mediaData6 = (LinkData) c00302.L$6;
                key3 = (String) c00302.L$5;
                String provider4 = (String) c00302.L$4;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00302.L$3;
                Function1<? super SubtitleFile, Unit> function14 = (Function1) c00302.L$2;
                String data3 = (String) c00302.L$1;
                $this2 = (TorraStreamAnime) c00302.L$0;
                ResultKt.throwOnFailure($result);
                data2 = data3;
                function3 = function14;
                obj3 = coroutine_suspended;
                debianapiUrl2 = debianapiUrl9;
                kitsuId4 = kitsuId13;
                aniid3 = aniid5;
                episode3 = episode17;
                mediaData3 = mediaData6;
                debianapiUrl3 = provider4;
                function4 = function13;
                anidbEid3 = anidbEid8;
                isCasting2 = isCasting3;
                type4 = type7;
                meteorUrl = (String) $result;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this2.sharedPref, function4);
                str = debianapiUrl3;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    str2 = key3;
                    if (str2 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        if (kitsuId4.element != -1) {
                            kitsuId5 = kitsuId4;
                            C00314 c00319 = new C00314(debianapiUrl2, type4, kitsuId5, episode3, function1FilteredCallback, null);
                            episode4 = episode3;
                            type5 = type4;
                            function1Arr2 = new Function1[]{c00319, new C00325(meteorUrl, type5, kitsuId5, episode4, function1FilteredCallback, null)};
                            c00302.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                            c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                            c00302.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                            c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                            c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                            c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode4);
                            c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                            c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId5);
                            c00302.L$10 = SpillingKt.nullOutSpilledVariable(type5);
                            c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                            c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                            c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00302.Z$0 = isCasting2;
                            c00302.label = 3;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00302) == obj3) {
                                return obj3;
                            }
                            provider2 = debianapiUrl3;
                            anidbEid5 = anidbEid3;
                            aniid4 = aniid3;
                            mediaData4 = mediaData3;
                            kitsuId6 = kitsuId5;
                            anidbEid6 = type5;
                            episode5 = episode4;
                            key4 = key3;
                        }
                        Unit unit6 = Unit.INSTANCE;
                    }
                    return Boxing.boxBoolean(true);
                }
                String debianapiUrl10 = debianapiUrl2;
                Ref.IntRef kitsuId14 = kitsuId4;
                Ref.ObjectRef episode18 = episode3;
                Function1<? super ExtractorLink, Unit> function15 = function4;
                Ref.ObjectRef episode19 = type4;
                TorraStreamAnime $this11 = $this2;
                function1Arr = new Function1[]{new C00336(anidbEid3, function4, null), new C00347(kitsuId14, $this11, episode19, episode18, function15, null), new C00358(kitsuId14, $this11, episode18, function1FilteredCallback, null)};
                c00302.L$0 = SpillingKt.nullOutSpilledVariable($this11);
                c00302.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00302.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00302.L$3 = SpillingKt.nullOutSpilledVariable(function15);
                c00302.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                c00302.L$5 = SpillingKt.nullOutSpilledVariable(key3);
                c00302.L$6 = SpillingKt.nullOutSpilledVariable(mediaData3);
                c00302.L$7 = SpillingKt.nullOutSpilledVariable(episode18);
                c00302.L$8 = SpillingKt.nullOutSpilledVariable(aniid3);
                c00302.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId14);
                c00302.L$10 = SpillingKt.nullOutSpilledVariable(episode19);
                c00302.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid3);
                c00302.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl10);
                c00302.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                c00302.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                c00302.Z$0 = isCasting2;
                c00302.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00302) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(true);
            case 3:
                boolean z3 = c00302.Z$0;
                anidbEid5 = (Ref.ObjectRef) c00302.L$11;
                anidbEid6 = (Ref.ObjectRef) c00302.L$10;
                kitsuId6 = (Ref.IntRef) c00302.L$9;
                aniid4 = (Integer) c00302.L$8;
                episode5 = (Ref.ObjectRef) c00302.L$7;
                mediaData4 = (LinkData) c00302.L$6;
                key4 = (String) c00302.L$5;
                String provider5 = (String) c00302.L$4;
                ResultKt.throwOnFailure($result);
                provider2 = provider5;
                Unit unit7 = Unit.INSTANCE;
                return Boxing.boxBoolean(true);
            case 4:
                boolean z4 = c00302.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$4 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$4", f = "TorraStreamAnime.kt", i = {}, l = {519}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00314 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $debianapiUrl;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Ref.IntRef $kitsuId;
        final /* synthetic */ Ref.ObjectRef<TvType> $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00314(String str, Ref.ObjectRef<TvType> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Integer> objectRef2, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00314> continuation) {
            super(1, continuation);
            this.$debianapiUrl = str;
            this.$type = objectRef;
            this.$kitsuId = intRef;
            this.$episode = objectRef2;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00314(this.$debianapiUrl, this.$type, this.$kitsuId, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeTorrentioAnimeDebian(this.$debianapiUrl, (TvType) this.$type.element, Boxing.boxInt(this.$kitsuId.element), (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$5 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$5", f = "TorraStreamAnime.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00325 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Ref.IntRef $kitsuId;
        final /* synthetic */ String $meteorUrl;
        final /* synthetic */ Ref.ObjectRef<TvType> $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00325(String str, Ref.ObjectRef<TvType> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Integer> objectRef2, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00325> continuation) {
            super(1, continuation);
            this.$meteorUrl = str;
            this.$type = objectRef;
            this.$kitsuId = intRef;
            this.$episode = objectRef2;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00325(this.$meteorUrl, this.$type, this.$kitsuId, this.$episode, this.$filtered, continuation);
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
                    if (TorraStreamExtractorKt.invokeMeteorAnimeDebian(this.$meteorUrl, (TvType) this.$type.element, Boxing.boxInt(this.$kitsuId.element), (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$6 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$6", f = "TorraStreamAnime.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00336 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $anidbEid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00336(Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00336> continuation) {
            super(1, continuation);
            this.$anidbEid = objectRef;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00336(this.$anidbEid, this.$callback, continuation);
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
                    if (TorraStreamExtractorKt.invokeAnimetosho((Integer) this.$anidbEid.element, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$7 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$7", f = "TorraStreamAnime.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00347 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Ref.IntRef $kitsuId;
        final /* synthetic */ Ref.ObjectRef<TvType> $type;
        int label;
        final /* synthetic */ TorraStreamAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00347(Ref.IntRef intRef, TorraStreamAnime torraStreamAnime, Ref.ObjectRef<TvType> objectRef, Ref.ObjectRef<Integer> objectRef2, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00347> continuation) {
            super(1, continuation);
            this.$kitsuId = intRef;
            this.this$0 = torraStreamAnime;
            this.$type = objectRef;
            this.$episode = objectRef2;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00347(this.$kitsuId, this.this$0, this.$type, this.$episode, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$kitsuId.element != -1) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeTorrentioAnimeType(this.this$0.torrentioDebian, (TvType) this.$type.element, Boxing.boxInt(this.$kitsuId.element), (Integer) this.$episode.element, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$8 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$8", f = "TorraStreamAnime.kt", i = {}, l = {527}, m = "invokeSuspend", n = {}, nl = {528}, s = {}, v = 2)
    static final class C00358 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Ref.IntRef $kitsuId;
        int label;
        final /* synthetic */ TorraStreamAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00358(Ref.IntRef intRef, TorraStreamAnime torraStreamAnime, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00358> continuation) {
            super(1, continuation);
            this.$kitsuId = intRef;
            this.this$0 = torraStreamAnime;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00358(this.$kitsuId, this.this$0, this.$episode, this.$filtered, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$kitsuId.element != -1) {
                        this.label = 1;
                        if (TorraStreamExtractorKt.invokeTorrentsDBAnime(this.this$0.TorrentsDB, Boxing.boxInt(this.$kitsuId.element), Boxing.boxInt(this.$kitsuId.element), (Integer) this.$episode.element, this.$filtered, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse;", "", "data", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData;)V", "getData", "()Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistData", "anilistMedia", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnilistAPIResponse {

        @NotNull
        private final AnilistData data;

        public static /* synthetic */ AnilistAPIResponse copy$default(AnilistAPIResponse anilistAPIResponse, AnilistData anilistData, int i, Object obj) {
            if ((i & 1) != 0) {
                anilistData = anilistAPIResponse.data;
            }
            return anilistAPIResponse.copy(anilistData);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnilistData getData() {
            return this.data;
        }

        @NotNull
        public final AnilistAPIResponse copy(@JsonProperty("data") @NotNull AnilistData data) {
            return new AnilistAPIResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnilistAPIResponse) && Intrinsics.areEqual(this.data, ((AnilistAPIResponse) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnilistAPIResponse(data=" + this.data + ')';
        }

        public AnilistAPIResponse(@JsonProperty("data") @NotNull AnilistData data) {
            this.data = data;
        }

        @NotNull
        public final AnilistData getData() {
            return this.data;
        }

        /* JADX INFO: compiled from: TorraStreamAnime.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData;", "", "page", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Page", "media", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia;", "Media", "<init>", "(Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData$AnilistPage;Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia;)V", "getPage", "()Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "getMedia", "()Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistPage", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class AnilistData {

            @Nullable
            private final anilistMedia media;

            @Nullable
            private final AnilistPage page;

            public static /* synthetic */ AnilistData copy$default(AnilistData anilistData, AnilistPage anilistPage, anilistMedia anilistmedia, int i, Object obj) {
                if ((i & 1) != 0) {
                    anilistPage = anilistData.page;
                }
                if ((i & 2) != 0) {
                    anilistmedia = anilistData.media;
                }
                return anilistData.copy(anilistPage, anilistmedia);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AnilistPage getPage() {
                return this.page;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final anilistMedia getMedia() {
                return this.media;
            }

            @NotNull
            public final AnilistData copy(@JsonProperty("Page") @Nullable AnilistPage page, @JsonProperty("Media") @Nullable anilistMedia media) {
                return new AnilistData(page, media);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AnilistData)) {
                    return false;
                }
                AnilistData anilistData = (AnilistData) other;
                return Intrinsics.areEqual(this.page, anilistData.page) && Intrinsics.areEqual(this.media, anilistData.media);
            }

            public int hashCode() {
                return ((this.page == null ? 0 : this.page.hashCode()) * 31) + (this.media != null ? this.media.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "AnilistData(page=" + this.page + ", media=" + this.media + ')';
            }

            public AnilistData(@JsonProperty("Page") @Nullable AnilistPage page, @JsonProperty("Media") @Nullable anilistMedia media) {
                this.page = page;
                this.media = media;
            }

            @Nullable
            public final AnilistPage getPage() {
                return this.page;
            }

            @Nullable
            public final anilistMedia getMedia() {
                return this.media;
            }

            /* JADX INFO: compiled from: TorraStreamAnime.kt */
            @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001c\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001c\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "", "pageInfo", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media", "", "Lcom/phisher98/TorraStreamAnime$Media;", "<init>", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;Ljava/util/List;)V", "getPageInfo", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "getMedia", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class AnilistPage {

                @NotNull
                private final List<Media> media;

                @NotNull
                private final AniListApi.LikePageInfo pageInfo;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AnilistPage copy$default(AnilistPage anilistPage, AniListApi.LikePageInfo likePageInfo, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        likePageInfo = anilistPage.pageInfo;
                    }
                    if ((i & 2) != 0) {
                        list = anilistPage.media;
                    }
                    return anilistPage.copy(likePageInfo, list);
                }

                @NotNull
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final AniListApi.LikePageInfo getPageInfo() {
                    return this.pageInfo;
                }

                @NotNull
                public final List<Media> component2() {
                    return this.media;
                }

                @NotNull
                public final AnilistPage copy(@JsonProperty("pageInfo") @NotNull AniListApi.LikePageInfo pageInfo, @JsonProperty("media") @NotNull List<Media> media) {
                    return new AnilistPage(pageInfo, media);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AnilistPage)) {
                        return false;
                    }
                    AnilistPage anilistPage = (AnilistPage) other;
                    return Intrinsics.areEqual(this.pageInfo, anilistPage.pageInfo) && Intrinsics.areEqual(this.media, anilistPage.media);
                }

                public int hashCode() {
                    return (this.pageInfo.hashCode() * 31) + this.media.hashCode();
                }

                @NotNull
                public String toString() {
                    return "AnilistPage(pageInfo=" + this.pageInfo + ", media=" + this.media + ')';
                }

                public AnilistPage(@JsonProperty("pageInfo") @NotNull AniListApi.LikePageInfo pageInfo, @JsonProperty("media") @NotNull List<Media> list) {
                    this.pageInfo = pageInfo;
                    this.media = list;
                }

                @NotNull
                public final AniListApi.LikePageInfo getPageInfo() {
                    return this.pageInfo;
                }

                @NotNull
                public final List<Media> getMedia() {
                    return this.media;
                }
            }
        }

        /* JADX INFO: compiled from: TorraStreamAnime.kt */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002OPB\u0085\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001c\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0016\b\u0001\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u00108\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\fJ\b\u0010.\u001a\u0004\u0018\u00010\fJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010<\u001a\u00020\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010B\u001a\u00020\u0013HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003J\u008c\u0003\u0010H\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001c\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0016\b\u0003\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001bHÆ\u0001¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010M\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010N\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(¨\u0006Q"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "startDate", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$StartDate;", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "season", "", "genres", "", "averageScore", "status", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "bannerImage", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "airingSchedule", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "format", "<init>", "(ILcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)V", "getId", "()I", "getStartDate", "()Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$StartDate;", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getSeason", "()Ljava/lang/String;", "getGenres", "()Ljava/util/List;", "getAverageScore", "getStatus", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getBannerImage", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getAiringSchedule", "()Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "getRecommendations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "getFormat", "totalEpisodes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia;", "equals", "", "other", "hashCode", "toString", "StartDate", "AiringScheduleNodes", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class anilistMedia {

            @Nullable
            private final AiringScheduleNodes airingSchedule;
            private final int averageScore;

            @Nullable
            private final String bannerImage;

            @NotNull
            private final AniListApi.CoverImage coverImage;

            @Nullable
            private final String description;

            @Nullable
            private final Integer episodes;

            @Nullable
            private final String format;

            @NotNull
            private final List<String> genres;
            private final int id;

            @Nullable
            private final AniListApi.SeasonNextAiringEpisode nextAiringEpisode;

            @Nullable
            private final AniListApi.RecommendationConnection recommendations;

            @Nullable
            private final String season;

            @NotNull
            private final StartDate startDate;

            @NotNull
            private final String status;

            @NotNull
            private final AniListApi.Title title;

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            @NotNull
            /* JADX INFO: renamed from: component10, reason: from getter */
            public final AniListApi.CoverImage getCoverImage() {
                return this.coverImage;
            }

            @Nullable
            /* JADX INFO: renamed from: component11, reason: from getter */
            public final String getBannerImage() {
                return this.bannerImage;
            }

            @Nullable
            /* JADX INFO: renamed from: component12, reason: from getter */
            public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
                return this.nextAiringEpisode;
            }

            @Nullable
            /* JADX INFO: renamed from: component13, reason: from getter */
            public final AiringScheduleNodes getAiringSchedule() {
                return this.airingSchedule;
            }

            @Nullable
            /* JADX INFO: renamed from: component14, reason: from getter */
            public final AniListApi.RecommendationConnection getRecommendations() {
                return this.recommendations;
            }

            @Nullable
            /* JADX INFO: renamed from: component15, reason: from getter */
            public final String getFormat() {
                return this.format;
            }

            @NotNull
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final StartDate getStartDate() {
                return this.startDate;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getEpisodes() {
                return this.episodes;
            }

            @NotNull
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final AniListApi.Title getTitle() {
                return this.title;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getSeason() {
                return this.season;
            }

            @NotNull
            public final List<String> component6() {
                return this.genres;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final int getAverageScore() {
                return this.averageScore;
            }

            @NotNull
            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getStatus() {
                return this.status;
            }

            @Nullable
            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            public final anilistMedia copy(@JsonProperty("id") int id, @JsonProperty("startDate") @NotNull StartDate startDate, @JsonProperty("episodes") @Nullable Integer episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("season") @Nullable String season, @JsonProperty("genres") @NotNull List<String> genres, @JsonProperty("averageScore") int averageScore, @JsonProperty("status") @NotNull String status, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode, @JsonProperty("airingSchedule") @Nullable AiringScheduleNodes airingSchedule, @JsonProperty("recommendations") @Nullable AniListApi.RecommendationConnection recommendations, @JsonProperty("format") @Nullable String format) {
                return new anilistMedia(id, startDate, episodes, title, season, genres, averageScore, status, description, coverImage, bannerImage, nextAiringEpisode, airingSchedule, recommendations, format);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof anilistMedia)) {
                    return false;
                }
                anilistMedia anilistmedia = (anilistMedia) other;
                return this.id == anilistmedia.id && Intrinsics.areEqual(this.startDate, anilistmedia.startDate) && Intrinsics.areEqual(this.episodes, anilistmedia.episodes) && Intrinsics.areEqual(this.title, anilistmedia.title) && Intrinsics.areEqual(this.season, anilistmedia.season) && Intrinsics.areEqual(this.genres, anilistmedia.genres) && this.averageScore == anilistmedia.averageScore && Intrinsics.areEqual(this.status, anilistmedia.status) && Intrinsics.areEqual(this.description, anilistmedia.description) && Intrinsics.areEqual(this.coverImage, anilistmedia.coverImage) && Intrinsics.areEqual(this.bannerImage, anilistmedia.bannerImage) && Intrinsics.areEqual(this.nextAiringEpisode, anilistmedia.nextAiringEpisode) && Intrinsics.areEqual(this.airingSchedule, anilistmedia.airingSchedule) && Intrinsics.areEqual(this.recommendations, anilistmedia.recommendations) && Intrinsics.areEqual(this.format, anilistmedia.format);
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((this.id * 31) + this.startDate.hashCode()) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + this.title.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.genres.hashCode()) * 31) + this.averageScore) * 31) + this.status.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.nextAiringEpisode == null ? 0 : this.nextAiringEpisode.hashCode())) * 31) + (this.airingSchedule == null ? 0 : this.airingSchedule.hashCode())) * 31) + (this.recommendations == null ? 0 : this.recommendations.hashCode())) * 31) + (this.format != null ? this.format.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("anilistMedia(id=").append(this.id).append(", startDate=").append(this.startDate).append(", episodes=").append(this.episodes).append(", title=").append(this.title).append(", season=").append(this.season).append(", genres=").append(this.genres).append(", averageScore=").append(this.averageScore).append(", status=").append(this.status).append(", description=").append(this.description).append(", coverImage=").append(this.coverImage).append(", bannerImage=").append(this.bannerImage).append(", nextAiringEpisode=");
                sb.append(this.nextAiringEpisode).append(", airingSchedule=").append(this.airingSchedule).append(", recommendations=").append(this.recommendations).append(", format=").append(this.format).append(')');
                return sb.toString();
            }

            public anilistMedia(@JsonProperty("id") int id, @JsonProperty("startDate") @NotNull StartDate startDate, @JsonProperty("episodes") @Nullable Integer episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("season") @Nullable String season, @JsonProperty("genres") @NotNull List<String> list, @JsonProperty("averageScore") int averageScore, @JsonProperty("status") @NotNull String status, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("bannerImage") @Nullable String bannerImage, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode, @JsonProperty("airingSchedule") @Nullable AiringScheduleNodes airingSchedule, @JsonProperty("recommendations") @Nullable AniListApi.RecommendationConnection recommendations, @JsonProperty("format") @Nullable String format) {
                this.id = id;
                this.startDate = startDate;
                this.episodes = episodes;
                this.title = title;
                this.season = season;
                this.genres = list;
                this.averageScore = averageScore;
                this.status = status;
                this.description = description;
                this.coverImage = coverImage;
                this.bannerImage = bannerImage;
                this.nextAiringEpisode = nextAiringEpisode;
                this.airingSchedule = airingSchedule;
                this.recommendations = recommendations;
                this.format = format;
            }

            public final int getId() {
                return this.id;
            }

            @NotNull
            public final StartDate getStartDate() {
                return this.startDate;
            }

            @Nullable
            public final Integer getEpisodes() {
                return this.episodes;
            }

            @NotNull
            public final AniListApi.Title getTitle() {
                return this.title;
            }

            @Nullable
            public final String getSeason() {
                return this.season;
            }

            @NotNull
            public final List<String> getGenres() {
                return this.genres;
            }

            public final int getAverageScore() {
                return this.averageScore;
            }

            @NotNull
            public final String getStatus() {
                return this.status;
            }

            @Nullable
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            public final AniListApi.CoverImage getCoverImage() {
                return this.coverImage;
            }

            @Nullable
            public final String getBannerImage() {
                return this.bannerImage;
            }

            @Nullable
            public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
                return this.nextAiringEpisode;
            }

            @Nullable
            public final AiringScheduleNodes getAiringSchedule() {
                return this.airingSchedule;
            }

            @Nullable
            public final AniListApi.RecommendationConnection getRecommendations() {
                return this.recommendations;
            }

            @Nullable
            public final String getFormat() {
                return this.format;
            }

            /* JADX INFO: compiled from: TorraStreamAnime.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$StartDate;", "", "year", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(I)V", "getYear", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class StartDate {
                private final int year;

                public static /* synthetic */ StartDate copy$default(StartDate startDate, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        i = startDate.year;
                    }
                    return startDate.copy(i);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final int getYear() {
                    return this.year;
                }

                @NotNull
                public final StartDate copy(@JsonProperty("year") int year) {
                    return new StartDate(year);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof StartDate) && this.year == ((StartDate) other).year;
                }

                public int hashCode() {
                    return this.year;
                }

                @NotNull
                public String toString() {
                    return "StartDate(year=" + this.year + ')';
                }

                public StartDate(@JsonProperty("year") int year) {
                    this.year = year;
                }

                public final int getYear() {
                    return this.year;
                }
            }

            /* JADX INFO: compiled from: TorraStreamAnime.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class AiringScheduleNodes {

                @Nullable
                private final List<AniListApi.SeasonNextAiringEpisode> nodes;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AiringScheduleNodes copy$default(AiringScheduleNodes airingScheduleNodes, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = airingScheduleNodes.nodes;
                    }
                    return airingScheduleNodes.copy(list);
                }

                @Nullable
                public final List<AniListApi.SeasonNextAiringEpisode> component1() {
                    return this.nodes;
                }

                @NotNull
                public final AiringScheduleNodes copy(@JsonProperty("nodes") @Nullable List<AniListApi.SeasonNextAiringEpisode> nodes) {
                    return new AiringScheduleNodes(nodes);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof AiringScheduleNodes) && Intrinsics.areEqual(this.nodes, ((AiringScheduleNodes) other).nodes);
                }

                public int hashCode() {
                    if (this.nodes == null) {
                        return 0;
                    }
                    return this.nodes.hashCode();
                }

                @NotNull
                public String toString() {
                    return "AiringScheduleNodes(nodes=" + this.nodes + ')';
                }

                public AiringScheduleNodes(@JsonProperty("nodes") @Nullable List<AniListApi.SeasonNextAiringEpisode> list) {
                    this.nodes = list;
                }

                @Nullable
                public final List<AniListApi.SeasonNextAiringEpisode> getNodes() {
                    return this.nodes;
                }
            }

            public final int totalEpisodes() {
                List<AniListApi.SeasonNextAiringEpisode> nodes;
                AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode;
                Integer episode;
                AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode2 = this.nextAiringEpisode;
                if (seasonNextAiringEpisode2 != null && (episode = seasonNextAiringEpisode2.getEpisode()) != null) {
                    return episode.intValue() - 1;
                }
                Integer episode2 = this.episodes;
                if (episode2 == null) {
                    AiringScheduleNodes airingScheduleNodes = this.airingSchedule;
                    episode2 = (airingScheduleNodes == null || (nodes = airingScheduleNodes.getNodes()) == null || (seasonNextAiringEpisode = (AniListApi.SeasonNextAiringEpisode) CollectionsKt.getOrNull(nodes, 0)) == null) ? null : seasonNextAiringEpisode.getEpisode();
                    if (episode2 == null) {
                        return 0;
                    }
                }
                return episode2.intValue();
            }

            @NotNull
            /* JADX INFO: renamed from: getTitle, reason: collision with other method in class */
            public final String m16getTitle() throws Exception {
                String english = this.title.getEnglish();
                if (english != null || (english = this.title.getRomaji()) != null) {
                    return english;
                }
                throw new Exception("Unable to calculate total episodes");
            }

            @Nullable
            /* JADX INFO: renamed from: getCoverImage, reason: collision with other method in class */
            public final String m15getCoverImage() {
                String extraLarge = this.coverImage.getExtraLarge();
                if (extraLarge != null) {
                    return extraLarge;
                }
                String large = this.coverImage.getLarge();
                return large == null ? this.coverImage.getMedium() : large;
            }
        }
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0005\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e\u0012\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f¢\u0006\u0004\b \u0010!J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010F\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010G\u001a\u00020\u0014HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010N\u001a\u00020\u0014HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003J\t\u0010P\u001a\u00020\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u008e\u0005\u0010S\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e2\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001fHÆ\u0001¢\u0006\u0002\u0010TJ\u0014\u0010U\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010W\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010X\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b+\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b,\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00102R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b3\u0010#R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b4\u0010#R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00102R\u0011\u0010\u001c\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00102R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00102R\u0011\u0010\u001e\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u00102R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b9\u0010#¨\u0006Y"}, d2 = {"Lcom/phisher98/TorraStreamAnime$LinkData;", "", "simklId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "traktId", "imdbId", "", "tmdbId", "tvdbId", "type", "season", "episode", "aniId", "malId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "isDub", "kitsuId", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/Integer;)V", "getSimklId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTraktId", "getImdbId", "()Ljava/lang/String;", "getTmdbId", "getTvdbId", "getType", "getSeason", "getEpisode", "getAniId", "getMalId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "getKitsuId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/Integer;)Lcom/phisher98/TorraStreamAnime$LinkData;", "equals", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final String airedDate;

        @Nullable
        private final Integer airedYear;

        @Nullable
        private final Integer aniId;

        @Nullable
        private final String date;

        @Nullable
        private final Integer episode;

        @Nullable
        private final String epsTitle;

        @Nullable
        private final String imdbId;
        private final boolean isAnime;
        private final boolean isAsian;
        private final boolean isBollywood;
        private final boolean isCartoon;
        private final boolean isDub;

        @Nullable
        private final String jpTitle;

        @Nullable
        private final Integer kitsuId;

        @Nullable
        private final Integer lastSeason;

        @Nullable
        private final Integer malId;

        @Nullable
        private final String orgTitle;

        @Nullable
        private final Integer season;

        @Nullable
        private final Integer simklId;

        @Nullable
        private final String title;

        @Nullable
        private final Integer tmdbId;

        @Nullable
        private final Integer traktId;

        @Nullable
        private final Integer tvdbId;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public LinkData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, false, null, 33554431, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, Integer num7, Integer num8, String str3, Integer num9, String str4, boolean z, Integer num10, Integer num11, String str5, String str6, String str7, String str8, boolean z2, boolean z3, boolean z4, boolean z5, Integer num12, int i, Object obj) {
            Integer num13;
            boolean z6;
            Integer num14 = (i & 1) != 0 ? linkData.simklId : num;
            Integer num15 = (i & 2) != 0 ? linkData.traktId : num2;
            String str9 = (i & 4) != 0 ? linkData.imdbId : str;
            Integer num16 = (i & 8) != 0 ? linkData.tmdbId : num3;
            Integer num17 = (i & 16) != 0 ? linkData.tvdbId : num4;
            String str10 = (i & 32) != 0 ? linkData.type : str2;
            Integer num18 = (i & 64) != 0 ? linkData.season : num5;
            Integer num19 = (i & 128) != 0 ? linkData.episode : num6;
            Integer num20 = (i & 256) != 0 ? linkData.aniId : num7;
            Integer num21 = (i & 512) != 0 ? linkData.malId : num8;
            String str11 = (i & 1024) != 0 ? linkData.title : str3;
            Integer num22 = (i & 2048) != 0 ? linkData.year : num9;
            String str12 = (i & 4096) != 0 ? linkData.orgTitle : str4;
            boolean z7 = (i & 8192) != 0 ? linkData.isAnime : z;
            Integer num23 = num14;
            Integer num24 = (i & 16384) != 0 ? linkData.airedYear : num10;
            Integer num25 = (i & 32768) != 0 ? linkData.lastSeason : num11;
            String str13 = (i & 65536) != 0 ? linkData.epsTitle : str5;
            String str14 = (i & 131072) != 0 ? linkData.jpTitle : str6;
            String str15 = (i & 262144) != 0 ? linkData.date : str7;
            String str16 = (i & 524288) != 0 ? linkData.airedDate : str8;
            boolean z8 = (i & 1048576) != 0 ? linkData.isAsian : z2;
            boolean z9 = (i & 2097152) != 0 ? linkData.isBollywood : z3;
            boolean z10 = (i & 4194304) != 0 ? linkData.isCartoon : z4;
            boolean z11 = (i & 8388608) != 0 ? linkData.isDub : z5;
            if ((i & 16777216) != 0) {
                z6 = z11;
                num13 = linkData.kitsuId;
            } else {
                num13 = num12;
                z6 = z11;
            }
            return linkData.copy(num23, num15, str9, num16, num17, str10, num18, num19, num20, num21, str11, num22, str12, z7, num24, num25, str13, str14, str15, str16, z8, z9, z10, z6, num13);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getSimklId() {
            return this.simklId;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getIsAnime() {
            return this.isAnime;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTraktId() {
            return this.traktId;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getAiredDate() {
            return this.airedDate;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final boolean getIsAsian() {
            return this.isAsian;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final boolean getIsBollywood() {
            return this.isBollywood;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final boolean getIsCartoon() {
            return this.isCartoon;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final boolean getIsDub() {
            return this.isDub;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Integer getKitsuId() {
            return this.kitsuId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getAniId() {
            return this.aniId;
        }

        @NotNull
        public final LinkData copy(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub, @JsonProperty("kitsuId") @Nullable Integer kitsuId) {
            return new LinkData(simklId, traktId, imdbId, tmdbId, tvdbId, type, season, episode, aniId, malId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, isDub, kitsuId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.simklId, linkData.simklId) && Intrinsics.areEqual(this.traktId, linkData.traktId) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tmdbId, linkData.tmdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.malId, linkData.malId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && this.isDub == linkData.isDub && Intrinsics.areEqual(this.kitsuId, linkData.kitsuId);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((this.simklId == null ? 0 : this.simklId.hashCode()) * 31) + (this.traktId == null ? 0 : this.traktId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate == null ? 0 : this.airedDate.hashCode())) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isAsian)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isBollywood)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isCartoon)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isDub)) * 31) + (this.kitsuId != null ? this.kitsuId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(simklId=").append(this.simklId).append(", traktId=").append(this.traktId).append(", imdbId=").append(this.imdbId).append(", tmdbId=").append(this.tmdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", aniId=").append(this.aniId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", year=");
            sb.append(this.year).append(", orgTitle=").append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon);
            sb.append(", isDub=").append(this.isDub).append(", kitsuId=").append(this.kitsuId).append(')');
            return sb.toString();
        }

        public LinkData(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub, @JsonProperty("kitsuId") @Nullable Integer kitsuId) {
            this.simklId = simklId;
            this.traktId = traktId;
            this.imdbId = imdbId;
            this.tmdbId = tmdbId;
            this.tvdbId = tvdbId;
            this.type = type;
            this.season = season;
            this.episode = episode;
            this.aniId = aniId;
            this.malId = malId;
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
            this.isDub = isDub;
            this.kitsuId = kitsuId;
        }

        public /* synthetic */ LinkData(Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, Integer num7, Integer num8, String str3, Integer num9, String str4, boolean z, Integer num10, Integer num11, String str5, String str6, String str7, String str8, boolean z2, boolean z3, boolean z4, boolean z5, Integer num12, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num5, (i & 128) != 0 ? null : num6, (i & 256) != 0 ? null : num7, (i & 512) != 0 ? null : num8, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : num9, (i & 4096) != 0 ? null : str4, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? null : num10, (i & 32768) != 0 ? null : num11, (i & 65536) != 0 ? null : str5, (i & 131072) != 0 ? null : str6, (i & 262144) != 0 ? null : str7, (i & 524288) != 0 ? null : str8, (i & 1048576) != 0 ? false : z2, (i & 2097152) != 0 ? false : z3, (i & 4194304) != 0 ? false : z4, (i & 8388608) == 0 ? z5 : false, (i & 16777216) != 0 ? null : num12);
        }

        @Nullable
        public final Integer getSimklId() {
            return this.simklId;
        }

        @Nullable
        public final Integer getTraktId() {
            return this.traktId;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
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
        public final Integer getAniId() {
            return this.aniId;
        }

        @Nullable
        public final Integer getMalId() {
            return this.malId;
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

        public final boolean isDub() {
            return this.isDub;
        }

        @Nullable
        public final Integer getKitsuId() {
            return this.kitsuId;
        }
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B·\u0002\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u001c\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0013HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003J¾\u0002\u00108\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010>\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lcom/phisher98/TorraStreamAnime$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "season", "", "seasonYear", "format", "averageScore", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "synonyms", "", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)V", "getId", "()I", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "()Ljava/lang/String;", "getSeasonYear", "getFormat", "getAverageScore", "getEpisodes", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getSynonyms", "()Ljava/util/List;", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)Lcom/phisher98/TorraStreamAnime$Media;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {
        private final int averageScore;

        @NotNull
        private final AniListApi.CoverImage coverImage;

        @Nullable
        private final String description;
        private final int episodes;

        @Nullable
        private final String format;
        private final int id;

        @Nullable
        private final Integer idMal;

        @Nullable
        private final AniListApi.SeasonNextAiringEpisode nextAiringEpisode;

        @Nullable
        private final String season;
        private final int seasonYear;

        @NotNull
        private final List<String> synonyms;

        @NotNull
        private final AniListApi.Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Media copy$default(Media media, int i, Integer num, String str, int i2, String str2, int i3, int i4, AniListApi.Title title, String str3, AniListApi.CoverImage coverImage, List list, AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = media.id;
            }
            if ((i5 & 2) != 0) {
                num = media.idMal;
            }
            if ((i5 & 4) != 0) {
                str = media.season;
            }
            if ((i5 & 8) != 0) {
                i2 = media.seasonYear;
            }
            if ((i5 & 16) != 0) {
                str2 = media.format;
            }
            if ((i5 & 32) != 0) {
                i3 = media.averageScore;
            }
            if ((i5 & 64) != 0) {
                i4 = media.episodes;
            }
            if ((i5 & 128) != 0) {
                title = media.title;
            }
            if ((i5 & 256) != 0) {
                str3 = media.description;
            }
            if ((i5 & 512) != 0) {
                coverImage = media.coverImage;
            }
            if ((i5 & 1024) != 0) {
                list = media.synonyms;
            }
            if ((i5 & 2048) != 0) {
                seasonNextAiringEpisode = media.nextAiringEpisode;
            }
            List list2 = list;
            AniListApi.SeasonNextAiringEpisode seasonNextAiringEpisode2 = seasonNextAiringEpisode;
            String str4 = str3;
            AniListApi.CoverImage coverImage2 = coverImage;
            int i6 = i4;
            AniListApi.Title title2 = title;
            String str5 = str2;
            int i7 = i3;
            return media.copy(i, num, str, i2, str5, i7, i6, title2, str4, coverImage2, list2, seasonNextAiringEpisode2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final List<String> component11() {
            return this.synonyms;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getAverageScore() {
            return this.averageScore;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getEpisodes() {
            return this.episodes;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Media copy(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("season") @Nullable String season, @JsonProperty("seasonYear") int seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("averageScore") int averageScore, @JsonProperty("episodes") int episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("synonyms") @NotNull List<String> synonyms, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode) {
            return new Media(id, idMal, season, seasonYear, format, averageScore, episodes, title, description, coverImage, synonyms, nextAiringEpisode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return this.id == media.id && Intrinsics.areEqual(this.idMal, media.idMal) && Intrinsics.areEqual(this.season, media.season) && this.seasonYear == media.seasonYear && Intrinsics.areEqual(this.format, media.format) && this.averageScore == media.averageScore && this.episodes == media.episodes && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.description, media.description) && Intrinsics.areEqual(this.coverImage, media.coverImage) && Intrinsics.areEqual(this.synonyms, media.synonyms) && Intrinsics.areEqual(this.nextAiringEpisode, media.nextAiringEpisode);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.id * 31) + (this.idMal == null ? 0 : this.idMal.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + this.seasonYear) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + this.averageScore) * 31) + this.episodes) * 31) + this.title.hashCode()) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + this.synonyms.hashCode()) * 31) + (this.nextAiringEpisode != null ? this.nextAiringEpisode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Media(id=").append(this.id).append(", idMal=").append(this.idMal).append(", season=").append(this.season).append(", seasonYear=").append(this.seasonYear).append(", format=").append(this.format).append(", averageScore=").append(this.averageScore).append(", episodes=").append(this.episodes).append(", title=").append(this.title).append(", description=").append(this.description).append(", coverImage=").append(this.coverImage).append(", synonyms=").append(this.synonyms).append(", nextAiringEpisode=");
            sb.append(this.nextAiringEpisode).append(')');
            return sb.toString();
        }

        public Media(@JsonProperty("id") int id, @JsonProperty("idMal") @Nullable Integer idMal, @JsonProperty("season") @Nullable String season, @JsonProperty("seasonYear") int seasonYear, @JsonProperty("format") @Nullable String format, @JsonProperty("averageScore") int averageScore, @JsonProperty("episodes") int episodes, @JsonProperty("title") @NotNull AniListApi.Title title, @JsonProperty("description") @Nullable String description, @JsonProperty("coverImage") @NotNull AniListApi.CoverImage coverImage, @JsonProperty("synonyms") @NotNull List<String> list, @JsonProperty("nextAiringEpisode") @Nullable AniListApi.SeasonNextAiringEpisode nextAiringEpisode) {
            this.id = id;
            this.idMal = idMal;
            this.season = season;
            this.seasonYear = seasonYear;
            this.format = format;
            this.averageScore = averageScore;
            this.episodes = episodes;
            this.title = title;
            this.description = description;
            this.coverImage = coverImage;
            this.synonyms = list;
            this.nextAiringEpisode = nextAiringEpisode;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        public final int getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        public final int getAverageScore() {
            return this.averageScore;
        }

        public final int getEpisodes() {
            return this.episodes;
        }

        @NotNull
        public final AniListApi.Title getTitle() {
            return this.title;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final AniListApi.CoverImage getCoverImage() {
            return this.coverImage;
        }

        @NotNull
        public final List<String> getSynonyms() {
            return this.synonyms;
        }

        @Nullable
        public final AniListApi.SeasonNextAiringEpisode getNextAiringEpisode() {
            return this.nextAiringEpisode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object tmdbToAnimeId(String title, Integer year, TvType type, Continuation<? super AniIds> continuation) {
        C00381 c00381;
        AniMedia aniMedia;
        Object obj;
        Object safe;
        AniMedia res;
        AniData it;
        ArrayList<AniMedia> media;
        if (continuation instanceof C00381) {
            c00381 = (C00381) continuation;
            if ((c00381.label & Integer.MIN_VALUE) != 0) {
                c00381.label -= Integer.MIN_VALUE;
            } else {
                c00381 = new C00381(continuation);
            }
        } else {
            c00381 = new C00381(continuation);
        }
        Object $result = c00381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00381.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = title;
                if (str == null || StringsKt.isBlank(str)) {
                    return new AniIds(null, null);
                }
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("search", title);
                pairArr[1] = TuplesKt.to("sort", CollectionsKt.listOf("SEARCH_MATCH"));
                pairArr[2] = TuplesKt.to("type", "ANIME");
                pairArr[3] = TuplesKt.to("format", CollectionsKt.listOf(new String[]{type == TvType.AnimeMovie ? "MOVIE" : "TV", "ONA", "OVA"}));
                Map variables = MapsKt.mutableMapOf(pairArr);
                RequestBody data = RequestBody.Companion.create(AppUtils.INSTANCE.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("query", "query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $season: MediaSeason\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      season: $season\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}"), TuplesKt.to("variables", variables)})), MediaType.Companion.parse("application/json;charset=utf-8"));
                Requests app = MainActivityKt.getApp();
                String str2 = this.anilistAPI;
                c00381.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00381.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00381.L$2 = SpillingKt.nullOutSpilledVariable(type);
                c00381.L$3 = SpillingKt.nullOutSpilledVariable("query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $season: MediaSeason\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      season: $season\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}");
                c00381.L$4 = SpillingKt.nullOutSpilledVariable(variables);
                c00381.L$5 = SpillingKt.nullOutSpilledVariable(data);
                c00381.label = 1;
                aniMedia = null;
                Object objPost$default = Requests.post$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, data, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00381, 65278, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objPost$default;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                aniMedia = null;
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniSearch.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = aniMedia;
        }
        AniSearch aniSearch = (AniSearch) safe;
        if (aniSearch == null || (it = aniSearch.getData()) == null) {
            res = aniMedia;
        } else {
            AniPage page = it.getPage();
            if (page == null || (media = page.getMedia()) == null) {
                media = it.getMedia();
            }
            if (media != null) {
                res = (AniMedia) CollectionsKt.firstOrNull(media);
            } else {
                res = aniMedia;
            }
        }
        return new AniIds(res != null ? res.getId() : aniMedia, res != null ? res.getIdMal() : aniMedia);
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AniIds;", "", "id", "", "idMal", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIdMal", "setIdMal", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/TorraStreamAnime$AniIds;", "equals", "", "other", "hashCode", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniIds {

        @Nullable
        private Integer id;

        @Nullable
        private Integer idMal;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniIds() {
            Integer num = null;
            this(num, num, 3, num);
        }

        public static /* synthetic */ AniIds copy$default(AniIds aniIds, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aniIds.id;
            }
            if ((i & 2) != 0) {
                num2 = aniIds.idMal;
            }
            return aniIds.copy(num, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @NotNull
        public final AniIds copy(@Nullable Integer id, @Nullable Integer idMal) {
            return new AniIds(id, idMal);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniIds)) {
                return false;
            }
            AniIds aniIds = (AniIds) other;
            return Intrinsics.areEqual(this.id, aniIds.id) && Intrinsics.areEqual(this.idMal, aniIds.idMal);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.idMal != null ? this.idMal.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniIds(id=" + this.id + ", idMal=" + this.idMal + ')';
        }

        public AniIds(@Nullable Integer id, @Nullable Integer idMal) {
            this.id = id;
            this.idMal = idMal;
        }

        public /* synthetic */ AniIds(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        public final void setId(@Nullable Integer num) {
            this.id = num;
        }

        public final void setIdMal(@Nullable Integer num) {
            this.idMal = num;
        }
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJB\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AniMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIdMal", "setIdMal", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/TorraStreamAnime$AniMedia;", "equals", "", "other", "hashCode", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniMedia {

        @Nullable
        private Integer id;

        @Nullable
        private Integer idMal;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniMedia() {
            Integer num = null;
            this(num, num, 3, num);
        }

        public static /* synthetic */ AniMedia copy$default(AniMedia aniMedia, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aniMedia.id;
            }
            if ((i & 2) != 0) {
                num2 = aniMedia.idMal;
            }
            return aniMedia.copy(num, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getIdMal() {
            return this.idMal;
        }

        @NotNull
        public final AniMedia copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("idMal") @Nullable Integer idMal) {
            return new AniMedia(id, idMal);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniMedia)) {
                return false;
            }
            AniMedia aniMedia = (AniMedia) other;
            return Intrinsics.areEqual(this.id, aniMedia.id) && Intrinsics.areEqual(this.idMal, aniMedia.idMal);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.idMal != null ? this.idMal.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniMedia(id=" + this.id + ", idMal=" + this.idMal + ')';
        }

        public AniMedia(@JsonProperty("id") @Nullable Integer id, @JsonProperty("idMal") @Nullable Integer idMal) {
            this.id = id;
            this.idMal = idMal;
        }

        public /* synthetic */ AniMedia(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        public final void setId(@Nullable Integer num) {
            this.id = num;
        }

        @Nullable
        public final Integer getIdMal() {
            return this.idMal;
        }

        public final void setIdMal(@Nullable Integer num) {
            this.idMal = num;
        }
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AniPage;", "", "media", "Ljava/util/ArrayList;", "Lcom/phisher98/TorraStreamAnime$AniMedia;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getMedia", "()Ljava/util/ArrayList;", "setMedia", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniPage {

        @NotNull
        private ArrayList<AniMedia> media;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniPage() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniPage copy$default(AniPage aniPage, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = aniPage.media;
            }
            return aniPage.copy(arrayList);
        }

        @NotNull
        public final ArrayList<AniMedia> component1() {
            return this.media;
        }

        @NotNull
        public final AniPage copy(@JsonProperty("media") @NotNull ArrayList<AniMedia> media) {
            return new AniPage(media);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniPage) && Intrinsics.areEqual(this.media, ((AniPage) other).media);
        }

        public int hashCode() {
            return this.media.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniPage(media=" + this.media + ')';
        }

        public AniPage(@JsonProperty("media") @NotNull ArrayList<AniMedia> arrayList) {
            this.media = arrayList;
        }

        public /* synthetic */ AniPage(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @NotNull
        public final ArrayList<AniMedia> getMedia() {
            return this.media;
        }

        public final void setMedia(@NotNull ArrayList<AniMedia> arrayList) {
            this.media = arrayList;
        }
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012*\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JO\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022*\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AniData;", "", "Page", "Lcom/phisher98/TorraStreamAnime$AniPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media", "Ljava/util/ArrayList;", "Lcom/phisher98/TorraStreamAnime$AniMedia;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/phisher98/TorraStreamAnime$AniPage;Ljava/util/ArrayList;)V", "getPage", "()Lcom/phisher98/TorraStreamAnime$AniPage;", "setPage", "(Lcom/phisher98/TorraStreamAnime$AniPage;)V", "getMedia", "()Ljava/util/ArrayList;", "setMedia", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniData {

        @Nullable
        private AniPage Page;

        @Nullable
        private ArrayList<AniMedia> media;

        /* JADX WARN: Multi-variable type inference failed */
        public AniData() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniData copy$default(AniData aniData, AniPage aniPage, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                aniPage = aniData.Page;
            }
            if ((i & 2) != 0) {
                arrayList = aniData.media;
            }
            return aniData.copy(aniPage, arrayList);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AniPage getPage() {
            return this.Page;
        }

        @Nullable
        public final ArrayList<AniMedia> component2() {
            return this.media;
        }

        @NotNull
        public final AniData copy(@JsonProperty("Page") @Nullable AniPage Page, @JsonProperty("media") @Nullable ArrayList<AniMedia> media) {
            return new AniData(Page, media);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniData)) {
                return false;
            }
            AniData aniData = (AniData) other;
            return Intrinsics.areEqual(this.Page, aniData.Page) && Intrinsics.areEqual(this.media, aniData.media);
        }

        public int hashCode() {
            return ((this.Page == null ? 0 : this.Page.hashCode()) * 31) + (this.media != null ? this.media.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniData(Page=" + this.Page + ", media=" + this.media + ')';
        }

        public AniData(@JsonProperty("Page") @Nullable AniPage Page, @JsonProperty("media") @Nullable ArrayList<AniMedia> arrayList) {
            this.Page = Page;
            this.media = arrayList;
        }

        public /* synthetic */ AniData(AniPage aniPage, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : aniPage, (i & 2) != 0 ? null : arrayList);
        }

        @Nullable
        public final AniPage getPage() {
            return this.Page;
        }

        public final void setPage(@Nullable AniPage aniPage) {
            this.Page = aniPage;
        }

        @Nullable
        public final ArrayList<AniMedia> getMedia() {
            return this.media;
        }

        public final void setMedia(@Nullable ArrayList<AniMedia> arrayList) {
            this.media = arrayList;
        }
    }

    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/phisher98/TorraStreamAnime$AniSearch;", "", "data", "Lcom/phisher98/TorraStreamAnime$AniData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/TorraStreamAnime$AniData;)V", "getData", "()Lcom/phisher98/TorraStreamAnime$AniData;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniSearch {

        @Nullable
        private AniData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniSearch() {
            AniData aniData = null;
            this(aniData, 1, aniData);
        }

        public static /* synthetic */ AniSearch copy$default(AniSearch aniSearch, AniData aniData, int i, Object obj) {
            if ((i & 1) != 0) {
                aniData = aniSearch.data;
            }
            return aniSearch.copy(aniData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AniData getData() {
            return this.data;
        }

        @NotNull
        public final AniSearch copy(@JsonProperty("data") @Nullable AniData data) {
            return new AniSearch(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AniSearch) && Intrinsics.areEqual(this.data, ((AniSearch) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AniSearch(data=" + this.data + ')';
        }

        public AniSearch(@JsonProperty("data") @Nullable AniData data) {
            this.data = data;
        }

        public /* synthetic */ AniSearch(AniData aniData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : aniData);
        }

        @Nullable
        public final AniData getData() {
            return this.data;
        }

        public final void setData(@Nullable AniData aniData) {
            this.data = aniData;
        }
    }

    private final String buildApiUrl(SharedPreferences sharedPref, String mainUrl) {
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

    /* JADX WARN: Code duplicated, block: B:43:0x017b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0180  */
    /* JADX WARN: Code duplicated, block: B:47:0x0192  */
    /* JADX WARN: Code duplicated, block: B:48:0x0197  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public final Object buildMeteorUrl(@NotNull SharedPreferences sharedPref, @NotNull String baseUrl, @NotNull Continuation<? super String> continuation) throws JSONException {
        C00211 c00211;
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
        if (continuation instanceof C00211) {
            c00211 = (C00211) continuation;
            if ((c00211.label & Integer.MIN_VALUE) != 0) {
                c00211.label -= Integer.MIN_VALUE;
            } else {
                c00211 = new C00211(continuation);
            }
        } else {
            c00211 = new C00211(continuation);
        }
        Object $result = c00211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00211.label) {
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
                    TorraStreamAnime$buildMeteorUrl$preferredLanguages$1$1 torraStreamAnime$buildMeteorUrl$preferredLanguages$1$1 = new TorraStreamAnime$buildMeteorUrl$preferredLanguages$1$1(preferredLanguages, null);
                    c00211.L$0 = SpillingKt.nullOutSpilledVariable(sharedPref);
                    c00211.L$1 = baseUrl;
                    c00211.L$2 = debridProvider;
                    c00211.L$3 = debridKey;
                    c00211.L$4 = SpillingKt.nullOutSpilledVariable(languagesPref);
                    c00211.L$5 = limit;
                    c00211.L$6 = sizeFilter;
                    c00211.L$7 = preferredLanguages;
                    c00211.L$8 = SpillingKt.nullOutSpilledVariable(preferredLanguages);
                    c00211.label = 1;
                    if (ParCollectionsKt.amap(listSplit$default, torraStreamAnime$buildMeteorUrl$preferredLanguages$1$1, c00211) == coroutine_suspended) {
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
                $this$buildMeteorUrl_u24lambda_u242.put("cachedOnly", true);
                $this$buildMeteorUrl_u24lambda_u242.put("removeTrash", false);
                $this$buildMeteorUrl_u24lambda_u242.put("removeSamples", false);
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
                $this$buildMeteorUrl_u24lambda_u242_u241.put("pack");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("cached");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("seadex");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("resolution");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("seeders");
                $this$buildMeteorUrl_u24lambda_u242_u241.put("language");
                Unit unit2 = Unit.INSTANCE;
                $this$buildMeteorUrl_u24lambda_u242.put("sortOrder", $this$buildMeteorUrl_u24lambda_u242_u241);
                byte[] bytes = $this$buildMeteorUrl_u24lambda_u242.toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                String encoded = Base64.encodeToString(bytes, 10);
                return baseUrl2 + '/' + encoded;
            case 1:
                i = 0;
                preferredLanguages = (JSONArray) c00211.L$7;
                sizeFilter = (String) c00211.L$6;
                limit = (String) c00211.L$5;
                debridKey = (String) c00211.L$3;
                debridProvider = (String) c00211.L$2;
                baseUrl2 = (String) c00211.L$1;
                sharedPref2 = (SharedPreferences) c00211.L$0;
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
                $this$buildMeteorUrl_u24lambda_u243.put("cachedOnly", true);
                $this$buildMeteorUrl_u24lambda_u243.put("removeTrash", false);
                $this$buildMeteorUrl_u24lambda_u243.put("removeSamples", false);
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
                $this$buildMeteorUrl_u24lambda_u242_u243.put("pack");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("cached");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("seadex");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("resolution");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("size");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("quality");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("seeders");
                $this$buildMeteorUrl_u24lambda_u242_u243.put("language");
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

    @NotNull
    public final ShowStatus getStatus(@Nullable String t) {
        boolean z = false;
        if (t != null && StringsKt.contains(t, "Returning", true)) {
            return ShowStatus.Ongoing;
        }
        if (t != null && StringsKt.contains(t, "RELEASING", true)) {
            return ShowStatus.Ongoing;
        }
        if (t != null && StringsKt.contains(t, "current", true)) {
            z = true;
        }
        return z ? ShowStatus.Ongoing : ShowStatus.Completed;
    }
}
