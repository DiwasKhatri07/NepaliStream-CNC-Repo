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
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\b_`abcdefB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010-\u001a\u00020\u0007*\u00020.H\u0002J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u00102J\f\u00103\u001a\u000204*\u000205H\u0002J,\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020408\u0012\u0004\u0012\u00020\u001d07*\u0002092\u0006\u0010:\u001a\u00020'H\u0082@¢\u0006\u0002\u0010;J\u001e\u0010A\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001082\u0006\u00101\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102J\u001e\u0010?\u001a\u00020B2\u0006\u0010:\u001a\u00020'2\u0006\u0010C\u001a\u000209H\u0096@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102JF\u0010H\u001a\u00020\u001d2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u001d2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020N0L2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020N0LH\u0096@¢\u0006\u0002\u0010QJ*\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u00072\b\u0010U\u001a\u0004\u0018\u00010'2\u0006\u0010V\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010WJ\u0018\u0010X\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001e\u0010Y\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010[J\u0010\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020>08X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006g"}, d2 = {"Lcom/phisher98/TorraStreamAnime;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "repo", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "apiUrl", "anilistAPI", "mediaLimit", "", "isAdult", "headerJSON", "", "torrentioDebian", "TorrentsDB", "toStringData", "", "anilistAPICall", "Lcom/phisher98/TorraStreamAnime$AnilistAPIResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/TorraStreamAnime$Media;", "toSearchResponseList", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/MainPageRequest;", "page", "(Lcom/lagradost/cloudstream3/MainPageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentYear", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "search", "Lcom/lagradost/cloudstream3/HomePageResponse;", "request", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmdbToAnimeId", "Lcom/phisher98/TorraStreamAnime$AniIds;", "title", "year", "type", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildApiUrl", "buildMeteorUrl", "baseUrl", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "AnilistAPIResponse", "LinkData", "Media", "AniIds", "AniMedia", "AniPage", "AniData", "AniSearch", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,598:1\n73#2,5:599\n73#2,5:650\n1739#3:604\n1814#3,3:605\n1739#3:608\n1814#3,3:609\n1795#3,10:612\n2068#3:622\n2069#3:624\n1805#3:625\n1739#3:627\n1814#3,3:628\n1#4:623\n1#4:626\n1#4:632\n1#4:655\n63#5:631\n64#5,15:633\n50#6:648\n43#6:649\n*S KotlinDebug\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime\n*L\n78#1:599,5\n464#1:650,5\n99#1:604\n99#1:605,3\n124#1:608\n124#1:609,3\n137#1:612,10\n137#1:622\n137#1:624\n137#1:625\n216#1:627\n216#1:628,3\n137#1:623\n273#1:632\n273#1:631\n273#1:633,15\n273#1:648\n273#1:649\n*E\n"})
public class TorraStreamAnime extends MainAPI {
    private final boolean hasQuickSearch;

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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$anilistAPICall$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0}, l = {76}, m = "anilistAPICall", n = {"query", "data"}, nl = {78}, s = {"L$0", "L$1"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {527}, m = "buildMeteorUrl", n = {"sharedPref", "baseUrl", "debridProvider", "debridKey", "languagesPref", "limit", "sizeFilter", "$this$buildMeteorUrl_u24lambda_u240"}, nl = {529}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8"}, v = 2)
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 1, 1, 1}, l = {137, 147}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page", "$this", "request", "page"}, nl = {137, 148}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {154, 161, 166, 219, 233}, m = "load$suspendImpl", n = {"$this", "url", "id", "$this", "url", "id", "data", "anititle", "anitype", "aniyear", "$this", "url", "id", "data", "anititle", "anitype", "ids", "posterurl", "backgroundUrl", "jpTitle", "aniyear", "$this", "url", "id", "data", "anititle", "anitype", "ids", "posterurl", "backgroundUrl", "jpTitle", "syncMetaData", "animeMetaData", "logoposter", "href", "episodes", "aniyear", "$this", "url", "id", "data", "anititle", "anitype", "ids", "posterurl", "backgroundUrl", "jpTitle", "syncMetaData", "animeMetaData", "logoposter", "href", "episodes", "aniyear"}, nl = {156, 162, 167, 233, 218}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0"}, v = 2)
    static final class C00231 extends ContinuationImpl {
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$1 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {281, 297, 303, 309}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "isCasting", "$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "debianapiUrl", "isCasting", "$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "debianapiUrl", "meteorUrl", "filtered", "isCasting", "$this", "data", "subtitleCallback", "callback", "provider", "key", "mediaData", "episode", "aniid", "kitsuId", "type", "anidbEid", "debianapiUrl", "meteorUrl", "filtered", "isCasting"}, nl = {282, 299, 309, 318}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0"}, v = 2)
    static final class C00261 extends ContinuationImpl {
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

        C00261(Continuation<? super C00261> continuation) {
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0}, l = {121}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {120}, s = {"L$0", "L$1"}, v = 2)
    static final class C00321 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00321(Continuation<? super C00321> continuation) {
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0, 0, 0, 0, 0}, l = {463}, m = "tmdbToAnimeId", n = {"title", "year", "type", "query", "variables", "data"}, nl = {464}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00331(Continuation<? super C00331> continuation) {
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime", f = "TorraStreamAnime.kt", i = {0, 0}, l = {97}, m = "toSearchResponseList", n = {"$this$toSearchResponseList", "page"}, nl = {99}, s = {"L$0", "I$0"}, v = 2)
    static final class C00341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00341(Continuation<? super C00341> continuation) {
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
        C00341 c00341;
        Object obj;
        Iterable media;
        if (continuation instanceof C00341) {
            c00341 = (C00341) continuation;
            if ((c00341.label & Integer.MIN_VALUE) != 0) {
                c00341.label -= Integer.MIN_VALUE;
            } else {
                c00341 = new C00341(continuation);
            }
        } else {
            c00341 = new C00341(continuation);
        }
        Object $result = c00341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00341.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String strReplace$default = StringsKt.replace$default($this$toSearchResponseList.getData(), "###", String.valueOf(page), false, 4, (Object) null);
                c00341.L$0 = SpillingKt.nullOutSpilledVariable($this$toSearchResponseList);
                c00341.I$0 = page;
                c00341.label = 1;
                Object objAnilistAPICall = anilistAPICall(strReplace$default, c00341);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAnilistAPICall;
                break;
                break;
            case 1:
                int i = c00341.I$0;
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object search$suspendImpl(TorraStreamAnime $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) throws Exception {
        C00321 c00321;
        Object objAnilistAPICall;
        Iterable media;
        if (continuation instanceof C00321) {
            c00321 = (C00321) continuation;
            if ((c00321.label & Integer.MIN_VALUE) != 0) {
                c00321.label -= Integer.MIN_VALUE;
            } else {
                c00321 = $this.new C00321(continuation);
            }
        } else {
            c00321 = $this.new C00321(continuation);
        }
        Object $result = c00321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00321.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = "query ($search: String = \"" + query + "\") { Page(page: 1, perPage: " + $this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(search: $search, isAdult: " + $this.isAdult + ", type: ANIME) { id idMal season seasonYear format episodes chapters title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }";
                c00321.L$0 = $this;
                c00321.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00321.label = 1;
                objAnilistAPICall = $this.anilistAPICall(str, c00321);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                $this = (TorraStreamAnime) c00321.L$0;
                ResultKt.throwOnFailure($result);
                objAnilistAPICall = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnilistAPIResponse res = (AnilistAPIResponse) objAnilistAPICall;
        AnilistAPIResponse.AnilistData.AnilistPage page = res.getData().getPage();
        if (page == null || (media = page.getMedia()) == null) {
            return null;
        }
        Iterable $this$map$iv = media;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Media it = (Media) item$iv$iv;
            destination$iv$iv.add($this.toSearchResponse(it));
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00de  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:35:0x0131  */
    /* JADX WARN: Code duplicated, block: B:46:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    static /* synthetic */ Object getMainPage$suspendImpl(TorraStreamAnime $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) throws Exception {
        C00221 c00221;
        Object searchResponseList;
        Object obj;
        Collection destination$iv$iv;
        SyncAPI.LibraryList it;
        UiText name;
        Activity activity;
        HomePageList homePageList;
        TorraStreamAnime $this2 = $this;
        MainPageRequest request2 = request;
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
        Object $result = c00221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        HomePageList homePageList2 = null;
        switch (c00221.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(request2.getName(), "Personal", false, 2, (Object) null)) {
                    c00221.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    c00221.L$1 = request2;
                    c00221.I$0 = page;
                    c00221.label = 2;
                    searchResponseList = $this2.toSearchResponseList(request2, page, c00221);
                    if (searchResponseList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Pair data = (Pair) searchResponseList;
                    return MainAPIKt.newHomePageResponse(request2.getName(), (List) data.getFirst(), (Boolean) data.getSecond());
                }
                if ($this2.repo.authUser() == null) {
                    return MainAPIKt.newHomePageResponse("Login required for personal content.", CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                }
                SyncRepo syncRepo = $this2.repo;
                c00221.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00221.L$1 = request2;
                c00221.I$0 = page;
                c00221.label = 1;
                Object obj2 = syncRepo.library-IoAF18A(c00221);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj2;
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
                    $this2 = $this2;
                }
                List homePageList3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(homePageList3, Boxing.boxBoolean(false));
            case 1:
                int page2 = c00221.I$0;
                request2 = (MainPageRequest) c00221.L$1;
                $this2 = (TorraStreamAnime) c00221.L$0;
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
                    $this2 = $this2;
                }
                List homePageList4 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(homePageList4, Boxing.boxBoolean(false));
            case 2:
                int i = c00221.I$0;
                request2 = (MainPageRequest) c00221.L$1;
                ResultKt.throwOnFailure($result);
                searchResponseList = $result;
                Pair data2 = (Pair) searchResponseList;
                return MainAPIKt.newHomePageResponse(request2.getName(), (List) data2.getFirst(), (Boolean) data2.getSecond());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:24:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:25:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:28:0x01f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:32:0x0290 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0291  */
    /* JADX WARN: Code duplicated, block: B:36:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:48:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:49:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:53:0x0369 A[LOOP:1: B:51:0x0363->B:53:0x0369, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x0435 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0436  */
    /* JADX WARN: Code duplicated, block: B:61:0x044c  */
    /* JADX WARN: Code duplicated, block: B:63:0x04e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:67:0x0509  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object load$suspendImpl(TorraStreamAnime $this, String url, Continuation<? super LoadResponse> continuation) throws Exception {
        C00231 c00231;
        String id;
        Object objAnilistAPICall;
        AnilistAPIResponse.anilistMedia data;
        String anititle;
        int aniyear;
        String format;
        TvType anitype;
        Object objTmdbToAnimeId;
        String anititle2;
        TvType anitype2;
        String id2;
        int aniyear2;
        AniIds ids;
        String posterurl;
        String backgroundUrl;
        String jpTitle;
        String id3;
        AnilistAPIResponse.anilistMedia data2;
        String str;
        TorraStreamAnime $this2;
        Object obj;
        String url2;
        Object obj2;
        int aniyear3;
        String anititle3;
        TorraStreamAnime $this3;
        String backgroundUrl2;
        String jpTitle2;
        String backgroundUrl3;
        AniIds ids2;
        String id4;
        String posterurl2;
        AnilistAPIResponse.anilistMedia data3;
        TvType anitype3;
        String syncMetaData;
        MetaAnimeData animeMetaData;
        String logoposter;
        String href;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        IntIterator it;
        MetaAnimeData animeMetaData2;
        List episodes;
        int aniyear4;
        AnilistAPIResponse.anilistMedia data4;
        String backgroundUrl4;
        String posterurl3;
        String backgroundUrl5;
        AniIds ids3;
        List episodes2;
        Object objNewAnimeLoadResponse$default;
        int aniyear5;
        MetaAnimeData animeMetaData3;
        String logoposter2;
        String url3;
        String syncMetaData2;
        String backgroundUrl6;
        String jpTitle3;
        AnilistAPIResponse.anilistMedia data5;
        TvType anitype4;
        Object objNewMovieLoadResponse;
        List<ImageData> images;
        Object next;
        ImageData imageData;
        ImageData it2;
        TorraStreamAnime $this4 = $this;
        String url4 = url;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = $this4.new C00231(continuation);
            }
        } else {
            c00231 = $this4.new C00231(continuation);
        }
        C00231 c00232 = c00231;
        Object $result = c00232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00232.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                id = StringsKt.substringAfterLast$default(StringsKt.removeSuffix(url4, "/"), "/", (String) null, 2, (Object) null);
                c00232.L$0 = $this4;
                c00232.L$1 = url4;
                c00232.L$2 = id;
                c00232.label = 1;
                objAnilistAPICall = $this4.anilistAPICall("query ($id: Int = " + id + ") { Media(id: $id, type: ANIME) { id title { romaji english } startDate { year } genres description averageScore status bannerImage coverImage { extraLarge large medium } bannerImage episodes format nextAiringEpisode { episode } airingSchedule { nodes { episode } } recommendations { edges { node { id mediaRecommendation { id title { romaji english } coverImage { extraLarge large medium } } } } } } }", c00232);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data = ((AnilistAPIResponse) objAnilistAPICall).getData().getMedia();
                if (data != null) {
                    throw new Exception("Unable to fetch media details");
                }
                anititle = data.m14getTitle();
                aniyear = data.getStartDate().getYear();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt = Boxing.boxInt(aniyear);
                c00232.L$0 = $this4;
                c00232.L$1 = url4;
                c00232.L$2 = id;
                c00232.L$3 = data;
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype);
                c00232.I$0 = aniyear;
                c00232.label = 2;
                objTmdbToAnimeId = $this4.tmdbToAnimeId(anititle, numBoxInt, anitype, c00232);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anititle2 = anititle;
                anitype2 = anitype;
                id2 = id;
                aniyear2 = aniyear;
                ids = (AniIds) objTmdbToAnimeId;
                posterurl = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                jpTitle = data.getTitle().getRomaji();
                Requests app = MainActivityKt.getApp();
                String str2 = "https://api.ani.zip/mappings?anilist_id=" + ids.getId();
                c00232.L$0 = $this4;
                c00232.L$1 = url4;
                c00232.L$2 = id2;
                c00232.L$3 = data;
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype2);
                c00232.L$6 = ids;
                c00232.L$7 = posterurl;
                c00232.L$8 = backgroundUrl;
                c00232.L$9 = jpTitle;
                c00232.I$0 = aniyear2;
                c00232.label = 3;
                id3 = id2;
                data2 = data;
                str = null;
                $this2 = $this4;
                obj = coroutine_suspended;
                url2 = url4;
                obj2 = Requests.get$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00232, 4094, (Object) null);
                c00232 = c00232;
                if (obj2 == obj) {
                    return obj;
                }
                aniyear3 = aniyear2;
                anititle3 = anititle2;
                $this3 = $this2;
                backgroundUrl2 = backgroundUrl;
                jpTitle2 = jpTitle;
                backgroundUrl3 = url2;
                ids2 = ids;
                id4 = id3;
                posterurl2 = posterurl;
                data3 = data2;
                anitype3 = anitype2;
                syncMetaData = ((NiceResponse) obj2).toString();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null || (images = animeMetaData.getImages()) == null) {
                    logoposter = str;
                } else {
                    Iterator<T> it3 = images.iterator();
                    do {
                        if (it3.hasNext()) {
                            next = it3.next();
                            it2 = (ImageData) next;
                        } else {
                            next = str;
                        }
                        imageData = (ImageData) next;
                        if (imageData != null) {
                            logoposter = imageData.getUrl();
                        } else {
                            logoposter = str;
                        }
                    } while (!Intrinsics.areEqual(it2.getCoverType(), "Clearlogo"));
                    imageData = (ImageData) next;
                    if (imageData != null) {
                        logoposter = imageData.getUrl();
                    } else {
                        logoposter = str;
                    }
                }
                href = $this3.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m14getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, 16634111, null));
                $this$map$iv = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it = $this$map$iv.iterator();
                while (it.hasNext()) {
                    int item$iv$iv = it.nextInt();
                    MetaAnimeData animeMetaData4 = animeMetaData;
                    destination$iv$iv.add(load$createEpisode(animeMetaData4, $this3, ids2, data3, jpTitle2, item$iv$iv));
                    $this$map$iv = $this$map$iv;
                    animeMetaData = animeMetaData4;
                }
                animeMetaData2 = animeMetaData;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM14getTitle = data3.m14getTitle();
                    AnilistAPIResponse.anilistMedia data6 = data3;
                    String id5 = id4;
                    TvType tvType = TvType.AnimeMovie;
                    AniIds ids4 = ids2;
                    C00242 c00242 = new C00242(id5, ids4, data6, backgroundUrl2, animeMetaData2, posterurl2, logoposter, null);
                    c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                    c00232.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                    c00232.L$3 = SpillingKt.nullOutSpilledVariable(data6);
                    c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                    c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                    c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids4);
                    c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    c00232.L$12 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                    c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00232.I$0 = aniyear3;
                    c00232.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse($this3, strM14getTitle, backgroundUrl3, tvType, href, c00242, c00232);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                aniyear4 = aniyear3;
                data4 = data3;
                backgroundUrl4 = backgroundUrl2;
                posterurl3 = posterurl2;
                backgroundUrl5 = logoposter;
                String id6 = id4;
                String strM14getTitle2 = data4.m14getTitle();
                TvType tvType2 = TvType.Anime;
                TorraStreamAnime $this5 = $this3;
                C00253 c00253 = new C00253(id6, ids2, episodes, data4, animeMetaData2, backgroundUrl5, $this5, null);
                ids3 = ids2;
                episodes2 = episodes;
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(id6);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids3);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00232.L$12 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00232.I$0 = aniyear4;
                c00232.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default($this3, strM14getTitle2, backgroundUrl3, tvType2, false, c00253, c00232, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                aniyear5 = aniyear4;
                animeMetaData3 = animeMetaData2;
                logoposter2 = backgroundUrl5;
                url3 = href;
                syncMetaData2 = syncMetaData;
                backgroundUrl6 = backgroundUrl4;
                jpTitle3 = jpTitle2;
                data5 = data4;
                anitype4 = anitype3;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 1:
                id = (String) c00232.L$2;
                url4 = (String) c00232.L$1;
                $this4 = (TorraStreamAnime) c00232.L$0;
                ResultKt.throwOnFailure($result);
                objAnilistAPICall = $result;
                data = ((AnilistAPIResponse) objAnilistAPICall).getData().getMedia();
                if (data != null) {
                    throw new Exception("Unable to fetch media details");
                }
                anititle = data.m14getTitle();
                aniyear = data.getStartDate().getYear();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt2 = Boxing.boxInt(aniyear);
                c00232.L$0 = $this4;
                c00232.L$1 = url4;
                c00232.L$2 = id;
                c00232.L$3 = data;
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype);
                c00232.I$0 = aniyear;
                c00232.label = 2;
                objTmdbToAnimeId = $this4.tmdbToAnimeId(anititle, numBoxInt2, anitype, c00232);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anititle2 = anititle;
                anitype2 = anitype;
                id2 = id;
                aniyear2 = aniyear;
                ids = (AniIds) objTmdbToAnimeId;
                posterurl = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                jpTitle = data.getTitle().getRomaji();
                Requests app2 = MainActivityKt.getApp();
                String str3 = "https://api.ani.zip/mappings?anilist_id=" + ids.getId();
                c00232.L$0 = $this4;
                c00232.L$1 = url4;
                c00232.L$2 = id2;
                c00232.L$3 = data;
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype2);
                c00232.L$6 = ids;
                c00232.L$7 = posterurl;
                c00232.L$8 = backgroundUrl;
                c00232.L$9 = jpTitle;
                c00232.I$0 = aniyear2;
                c00232.label = 3;
                id3 = id2;
                data2 = data;
                str = null;
                $this2 = $this4;
                obj = coroutine_suspended;
                url2 = url4;
                obj2 = Requests.get$default(app2, str3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00232, 4094, (Object) null);
                c00232 = c00232;
                if (obj2 == obj) {
                    return obj;
                }
                aniyear3 = aniyear2;
                anititle3 = anititle2;
                $this3 = $this2;
                backgroundUrl2 = backgroundUrl;
                jpTitle2 = jpTitle;
                backgroundUrl3 = url2;
                ids2 = ids;
                id4 = id3;
                posterurl2 = posterurl;
                data3 = data2;
                anitype3 = anitype2;
                syncMetaData = ((NiceResponse) obj2).toString();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    logoposter = str;
                } else {
                    logoposter = str;
                }
                href = $this3.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m14getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, 16634111, null));
                $this$map$iv = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it = $this$map$iv.iterator();
                while (it.hasNext()) {
                    int item$iv$iv2 = it.nextInt();
                    MetaAnimeData animeMetaData5 = animeMetaData;
                    destination$iv$iv.add(load$createEpisode(animeMetaData5, $this3, ids2, data3, jpTitle2, item$iv$iv2));
                    $this$map$iv = $this$map$iv;
                    animeMetaData = animeMetaData5;
                }
                animeMetaData2 = animeMetaData;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM14getTitle3 = data3.m14getTitle();
                    AnilistAPIResponse.anilistMedia data7 = data3;
                    String id7 = id4;
                    TvType tvType3 = TvType.AnimeMovie;
                    AniIds ids5 = ids2;
                    C00242 c00243 = new C00242(id7, ids5, data7, backgroundUrl2, animeMetaData2, posterurl2, logoposter, null);
                    c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                    c00232.L$2 = SpillingKt.nullOutSpilledVariable(id7);
                    c00232.L$3 = SpillingKt.nullOutSpilledVariable(data7);
                    c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                    c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                    c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids5);
                    c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    c00232.L$12 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                    c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00232.I$0 = aniyear3;
                    c00232.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse($this3, strM14getTitle3, backgroundUrl3, tvType3, href, c00243, c00232);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                aniyear4 = aniyear3;
                data4 = data3;
                backgroundUrl4 = backgroundUrl2;
                posterurl3 = posterurl2;
                backgroundUrl5 = logoposter;
                String id8 = id4;
                String strM14getTitle4 = data4.m14getTitle();
                TvType tvType4 = TvType.Anime;
                TorraStreamAnime $this6 = $this3;
                C00253 c00254 = new C00253(id8, ids2, episodes, data4, animeMetaData2, backgroundUrl5, $this6, null);
                ids3 = ids2;
                episodes2 = episodes;
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(id8);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids3);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00232.L$12 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00232.I$0 = aniyear4;
                c00232.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default($this3, strM14getTitle4, backgroundUrl3, tvType4, false, c00254, c00232, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                aniyear5 = aniyear4;
                animeMetaData3 = animeMetaData2;
                logoposter2 = backgroundUrl5;
                url3 = href;
                syncMetaData2 = syncMetaData;
                backgroundUrl6 = backgroundUrl4;
                jpTitle3 = jpTitle2;
                data5 = data4;
                anitype4 = anitype3;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 2:
                aniyear2 = c00232.I$0;
                TvType anitype5 = (TvType) c00232.L$5;
                String anititle4 = (String) c00232.L$4;
                AnilistAPIResponse.anilistMedia data8 = (AnilistAPIResponse.anilistMedia) c00232.L$3;
                String id9 = (String) c00232.L$2;
                url4 = (String) c00232.L$1;
                $this4 = (TorraStreamAnime) c00232.L$0;
                ResultKt.throwOnFailure($result);
                anitype2 = anitype5;
                anititle2 = anititle4;
                data = data8;
                id2 = id9;
                objTmdbToAnimeId = $result;
                ids = (AniIds) objTmdbToAnimeId;
                posterurl = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                jpTitle = data.getTitle().getRomaji();
                Requests app3 = MainActivityKt.getApp();
                String str4 = "https://api.ani.zip/mappings?anilist_id=" + ids.getId();
                c00232.L$0 = $this4;
                c00232.L$1 = url4;
                c00232.L$2 = id2;
                c00232.L$3 = data;
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle2);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype2);
                c00232.L$6 = ids;
                c00232.L$7 = posterurl;
                c00232.L$8 = backgroundUrl;
                c00232.L$9 = jpTitle;
                c00232.I$0 = aniyear2;
                c00232.label = 3;
                id3 = id2;
                data2 = data;
                str = null;
                $this2 = $this4;
                obj = coroutine_suspended;
                url2 = url4;
                obj2 = Requests.get$default(app3, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00232, 4094, (Object) null);
                c00232 = c00232;
                if (obj2 == obj) {
                    return obj;
                }
                aniyear3 = aniyear2;
                anititle3 = anititle2;
                $this3 = $this2;
                backgroundUrl2 = backgroundUrl;
                jpTitle2 = jpTitle;
                backgroundUrl3 = url2;
                ids2 = ids;
                id4 = id3;
                posterurl2 = posterurl;
                data3 = data2;
                anitype3 = anitype2;
                syncMetaData = ((NiceResponse) obj2).toString();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    logoposter = str;
                } else {
                    logoposter = str;
                }
                href = $this3.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m14getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, 16634111, null));
                $this$map$iv = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it = $this$map$iv.iterator();
                while (it.hasNext()) {
                    int item$iv$iv3 = it.nextInt();
                    MetaAnimeData animeMetaData6 = animeMetaData;
                    destination$iv$iv.add(load$createEpisode(animeMetaData6, $this3, ids2, data3, jpTitle2, item$iv$iv3));
                    $this$map$iv = $this$map$iv;
                    animeMetaData = animeMetaData6;
                }
                animeMetaData2 = animeMetaData;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM14getTitle5 = data3.m14getTitle();
                    AnilistAPIResponse.anilistMedia data9 = data3;
                    String id10 = id4;
                    TvType tvType5 = TvType.AnimeMovie;
                    AniIds ids6 = ids2;
                    C00242 c00244 = new C00242(id10, ids6, data9, backgroundUrl2, animeMetaData2, posterurl2, logoposter, null);
                    c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                    c00232.L$2 = SpillingKt.nullOutSpilledVariable(id10);
                    c00232.L$3 = SpillingKt.nullOutSpilledVariable(data9);
                    c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                    c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                    c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids6);
                    c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    c00232.L$12 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                    c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00232.I$0 = aniyear3;
                    c00232.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse($this3, strM14getTitle5, backgroundUrl3, tvType5, href, c00244, c00232);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                aniyear4 = aniyear3;
                data4 = data3;
                backgroundUrl4 = backgroundUrl2;
                posterurl3 = posterurl2;
                backgroundUrl5 = logoposter;
                String id11 = id4;
                String strM14getTitle6 = data4.m14getTitle();
                TvType tvType6 = TvType.Anime;
                TorraStreamAnime $this7 = $this3;
                C00253 c00255 = new C00253(id11, ids2, episodes, data4, animeMetaData2, backgroundUrl5, $this7, null);
                ids3 = ids2;
                episodes2 = episodes;
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(id11);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids3);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00232.L$12 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00232.I$0 = aniyear4;
                c00232.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default($this3, strM14getTitle6, backgroundUrl3, tvType6, false, c00255, c00232, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                aniyear5 = aniyear4;
                animeMetaData3 = animeMetaData2;
                logoposter2 = backgroundUrl5;
                url3 = href;
                syncMetaData2 = syncMetaData;
                backgroundUrl6 = backgroundUrl4;
                jpTitle3 = jpTitle2;
                data5 = data4;
                anitype4 = anitype3;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 3:
                int aniyear6 = c00232.I$0;
                String jpTitle4 = (String) c00232.L$9;
                String backgroundUrl7 = (String) c00232.L$8;
                String posterurl4 = (String) c00232.L$7;
                AniIds ids7 = (AniIds) c00232.L$6;
                TvType anitype6 = (TvType) c00232.L$5;
                String anititle5 = (String) c00232.L$4;
                data3 = (AnilistAPIResponse.anilistMedia) c00232.L$3;
                String id12 = (String) c00232.L$2;
                String url5 = (String) c00232.L$1;
                TorraStreamAnime $this8 = (TorraStreamAnime) c00232.L$0;
                ResultKt.throwOnFailure($result);
                jpTitle2 = jpTitle4;
                backgroundUrl2 = backgroundUrl7;
                str = null;
                posterurl2 = posterurl4;
                anitype3 = anitype6;
                id4 = id12;
                $this3 = $this8;
                backgroundUrl3 = url5;
                aniyear3 = aniyear6;
                obj = coroutine_suspended;
                anititle3 = anititle5;
                obj2 = $result;
                ids2 = ids7;
                syncMetaData = ((NiceResponse) obj2).toString();
                animeMetaData = TorraStreamUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    logoposter = str;
                } else {
                    logoposter = str;
                }
                href = $this3.toStringData(new LinkData(null, null, null, null, null, null, null, null, ids2.getId(), ids2.getIdMal(), data3.m14getTitle(), Boxing.boxInt(data3.getStartDate().getYear()), null, true, null, null, null, jpTitle2, null, null, false, false, false, false, 16634111, null));
                $this$map$iv = new IntRange(1, data3.totalEpisodes());
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                it = $this$map$iv.iterator();
                while (it.hasNext()) {
                    int item$iv$iv4 = it.nextInt();
                    MetaAnimeData animeMetaData7 = animeMetaData;
                    destination$iv$iv.add(load$createEpisode(animeMetaData7, $this3, ids2, data3, jpTitle2, item$iv$iv4));
                    $this$map$iv = $this$map$iv;
                    animeMetaData = animeMetaData7;
                }
                animeMetaData2 = animeMetaData;
                episodes = (List) destination$iv$iv;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    String strM14getTitle7 = data3.m14getTitle();
                    AnilistAPIResponse.anilistMedia data10 = data3;
                    String id13 = id4;
                    TvType tvType7 = TvType.AnimeMovie;
                    AniIds ids8 = ids2;
                    C00242 c00245 = new C00242(id13, ids8, data10, backgroundUrl2, animeMetaData2, posterurl2, logoposter, null);
                    c00232.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                    c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                    c00232.L$2 = SpillingKt.nullOutSpilledVariable(id13);
                    c00232.L$3 = SpillingKt.nullOutSpilledVariable(data10);
                    c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                    c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                    c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids8);
                    c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl2);
                    c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl2);
                    c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                    c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                    c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    c00232.L$12 = SpillingKt.nullOutSpilledVariable(logoposter);
                    c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                    c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00232.I$0 = aniyear3;
                    c00232.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse($this3, strM14getTitle7, backgroundUrl3, tvType7, href, c00245, c00232);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                aniyear4 = aniyear3;
                data4 = data3;
                backgroundUrl4 = backgroundUrl2;
                posterurl3 = posterurl2;
                backgroundUrl5 = logoposter;
                String id14 = id4;
                String strM14getTitle8 = data4.m14getTitle();
                TvType tvType8 = TvType.Anime;
                TorraStreamAnime $this9 = $this3;
                C00253 c00256 = new C00253(id14, ids2, episodes, data4, animeMetaData2, backgroundUrl5, $this9, null);
                ids3 = ids2;
                episodes2 = episodes;
                c00232.L$0 = SpillingKt.nullOutSpilledVariable($this9);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(backgroundUrl3);
                c00232.L$2 = SpillingKt.nullOutSpilledVariable(id14);
                c00232.L$3 = SpillingKt.nullOutSpilledVariable(data4);
                c00232.L$4 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00232.L$5 = SpillingKt.nullOutSpilledVariable(anitype3);
                c00232.L$6 = SpillingKt.nullOutSpilledVariable(ids3);
                c00232.L$7 = SpillingKt.nullOutSpilledVariable(posterurl3);
                c00232.L$8 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                c00232.L$9 = SpillingKt.nullOutSpilledVariable(jpTitle2);
                c00232.L$10 = SpillingKt.nullOutSpilledVariable(syncMetaData);
                c00232.L$11 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                c00232.L$12 = SpillingKt.nullOutSpilledVariable(backgroundUrl5);
                c00232.L$13 = SpillingKt.nullOutSpilledVariable(href);
                c00232.L$14 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00232.I$0 = aniyear4;
                c00232.label = 5;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default($this3, strM14getTitle8, backgroundUrl3, tvType8, false, c00256, c00232, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                aniyear5 = aniyear4;
                animeMetaData3 = animeMetaData2;
                logoposter2 = backgroundUrl5;
                url3 = href;
                syncMetaData2 = syncMetaData;
                backgroundUrl6 = backgroundUrl4;
                jpTitle3 = jpTitle2;
                data5 = data4;
                anitype4 = anitype3;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 4:
                int i = c00232.I$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            case 5:
                int aniyear7 = c00232.I$0;
                List episodes3 = (List) c00232.L$14;
                url3 = (String) c00232.L$13;
                logoposter2 = (String) c00232.L$12;
                animeMetaData3 = (MetaAnimeData) c00232.L$11;
                syncMetaData2 = (String) c00232.L$10;
                jpTitle3 = (String) c00232.L$9;
                backgroundUrl6 = (String) c00232.L$8;
                String posterurl5 = (String) c00232.L$7;
                AniIds ids9 = (AniIds) c00232.L$6;
                anitype4 = (TvType) c00232.L$5;
                AnilistAPIResponse.anilistMedia data11 = (AnilistAPIResponse.anilistMedia) c00232.L$3;
                ResultKt.throwOnFailure($result);
                posterurl3 = posterurl5;
                ids3 = ids9;
                data5 = data11;
                episodes2 = episodes3;
                aniyear5 = aniyear7;
                objNewAnimeLoadResponse$default = $result;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String load$resolveTitle(MetaAnimeData animeMetaData, MetaEpisode epData) {
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

    private static final Episode load$createEpisode(final MetaAnimeData animeMetaData, TorraStreamAnime this$0, AniIds ids, AnilistAPIResponse.anilistMedia data, String jpTitle, final int i) {
        Map<String, MetaEpisode> episodes;
        final MetaEpisode epData = (animeMetaData == null || (episodes = animeMetaData.getEpisodes()) == null) ? null : episodes.get(String.valueOf(i));
        String linkData = this$0.toStringData(new LinkData(null, null, null, null, null, null, 1, Integer.valueOf(i), ids.getId(), ids.getIdMal(), data.m14getTitle(), Integer.valueOf(data.getStartDate().getYear()), null, true, null, null, null, jpTitle, null, null, false, false, false, false, 16633919, null));
        return MainAPIKt.newEpisode(this$0, linkData, new Function1() { // from class: com.phisher98.TorraStreamAnime$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TorraStreamAnime.load$createEpisode$lambda$2(i, epData, animeMetaData, (Episode) obj);
            }
        });
    }

    static final Unit load$createEpisode$lambda$2(int $i, MetaEpisode $epData, MetaAnimeData $animeMetaData, Episode $this$newEpisode) {
        String url;
        List<ImageData> images;
        ImageData imageData;
        String overview;
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($i));
        $this$newEpisode.setName(load$resolveTitle($animeMetaData, $epData));
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$load$2 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$load$2", f = "TorraStreamAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,598:1\n296#2,2:599\n296#2,2:601\n*S KotlinDebug\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$load$2\n*L\n224#1:599,2\n226#1:601,2\n*E\n"})
    static final class C00242 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
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
        C00242(String str, AniIds aniIds, AnilistAPIResponse.anilistMedia anilistmedia, String str2, MetaAnimeData metaAnimeData, String str3, String str4, Continuation<? super C00242> continuation) {
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
            Continuation<Unit> c00242 = new C00242(this.$id, this.$ids, this.$data, this.$backgroundUrl, this.$animeMetaData, this.$posterurl, this.$logoposter, continuation);
            c00242.L$0 = obj;
            return c00242;
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
                    String strM13getCoverImage = this.$posterurl;
                    if (strM13getCoverImage == null) {
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
                        strM13getCoverImage = url == null ? this.$data.m13getCoverImage() : url;
                    }
                    loadResponse.setPosterUrl(strM13getCoverImage);
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

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$load$3 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$load$3", f = "TorraStreamAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTorraStreamAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$load$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,598:1\n296#2,2:599\n296#2,2:601\n1795#2,10:603\n2068#2:613\n2069#2:615\n1805#2:616\n1#3:614\n*S KotlinDebug\n*F\n+ 1 TorraStreamAnime.kt\ncom/phisher98/TorraStreamAnime$load$3\n*L\n240#1:599,2\n243#1:601,2\n250#1:603,10\n250#1:613\n250#1:615\n250#1:616\n250#1:614\n*E\n"})
    static final class C00253 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
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
        C00253(String str, AniIds aniIds, List<Episode> list, AnilistAPIResponse.anilistMedia anilistmedia, MetaAnimeData metaAnimeData, String str2, TorraStreamAnime torraStreamAnime, Continuation<? super C00253> continuation) {
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
            Continuation<Unit> c00253 = new C00253(this.$id, this.$ids, this.$episodes, this.$data, this.$animeMetaData, this.$logoposter, this.this$0, continuation);
            c00253.L$0 = obj;
            return c00253;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0093  */
        /* JADX WARN: Code duplicated, block: B:38:0x00da  */
        public final Object invokeSuspend(Object $result) {
            String bannerImage;
            String strM13getCoverImage;
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
                        strM13getCoverImage = this.$data.m13getCoverImage();
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
                            if (imageData != null || (strM13getCoverImage = imageData.getUrl()) == null) {
                                strM13getCoverImage = this.$data.m13getCoverImage();
                            }
                        } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                        imageData = (ImageData) element$iv;
                        if (imageData != null) {
                            strM13getCoverImage = this.$data.m13getCoverImage();
                        } else {
                            strM13getCoverImage = this.$data.m13getCoverImage();
                        }
                    }
                    loadResponse.setPosterUrl(strM13getCoverImage);
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

    /* JADX WARN: Code duplicated, block: B:100:0x0444  */
    /* JADX WARN: Code duplicated, block: B:104:0x044d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0450  */
    /* JADX WARN: Code duplicated, block: B:108:0x0458  */
    /* JADX WARN: Code duplicated, block: B:110:0x04ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:111:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:113:0x050c  */
    /* JADX WARN: Code duplicated, block: B:117:0x05cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:118:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x031f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0346 A[Catch: Exception -> 0x0351, TRY_LEAVE, TryCatch #10 {Exception -> 0x0351, blocks: (B:63:0x0324, B:65:0x0346, B:74:0x0367), top: B:137:0x0324 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0358  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:87:0x0415 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x0416  */
    /* JADX WARN: Code duplicated, block: B:91:0x0432  */
    /* JADX WARN: Code duplicated, block: B:95:0x043b  */
    /* JADX WARN: Code duplicated, block: B:98:0x043f  */
    static /* synthetic */ Object loadLinks$suspendImpl(TorraStreamAnime $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) throws JSONException {
        C00261 c00261;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Object obj3;
        TorraStreamAnime $this2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LinkData mediaData;
        String key;
        Ref.ObjectRef episode;
        Integer aniid;
        Ref.IntRef kitsuId;
        Ref.ObjectRef type;
        Ref.ObjectRef episode2;
        String provider;
        String data2;
        Function1<? super SubtitleFile, Unit> function5;
        Object obj4;
        TorraStreamAnime $this3;
        TorraStreamAnime $this4;
        Function1<? super SubtitleFile, Unit> function6;
        Ref.ObjectRef episode3;
        Ref.ObjectRef episode4;
        String debianapiUrl;
        Function1<? super SubtitleFile, Unit> function7;
        Object objBuildMeteorUrl;
        Ref.ObjectRef episode5;
        String debianapiUrl2;
        TorraStreamAnime $this5;
        Ref.ObjectRef anidbEid;
        Ref.IntRef kitsuId2;
        String debianapiUrl3;
        Function1<? super SubtitleFile, Unit> function8;
        LinkData mediaData2;
        Integer aniid2;
        Ref.ObjectRef type2;
        TorraStreamAnime $this6;
        JSONObject mappings;
        Function1<? super SubtitleFile, Unit> function9;
        Integer anidbEid2;
        String rawtype;
        String meteorUrl;
        Function1<ExtractorLink, Unit> function1FilteredCallback;
        String str;
        boolean z;
        Function1[] function1Arr;
        String str2;
        boolean z2;
        Function1[] function1Arr2;
        Ref.IntRef kitsuId3;
        Ref.ObjectRef episode6;
        Ref.ObjectRef type3;
        String key2;
        LinkData mediaData3;
        String provider2;
        Integer aniid3;
        Ref.IntRef kitsuId4;
        Ref.ObjectRef type4;
        Ref.ObjectRef episode7;
        if (continuation instanceof C00261) {
            c00261 = (C00261) continuation;
            if ((c00261.label & Integer.MIN_VALUE) != 0) {
                c00261.label -= Integer.MIN_VALUE;
            } else {
                c00261 = $this.new C00261(continuation);
            }
        } else {
            c00261 = $this.new C00261(continuation);
        }
        C00261 c00262 = c00261;
        Object $result = c00262.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00262.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String provider3 = $this.sharedPref.getString("debrid_provider", null);
                String key3 = $this.sharedPref.getString("debrid_key", null);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LinkData.class);
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
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.TorraStreamAnime$loadLinks$suspendImpl$$inlined$parseJson$1
                    });
                }
                LinkData mediaData4 = (LinkData) objDecodeFromString;
                Ref.ObjectRef episode8 = new Ref.ObjectRef();
                episode8.element = mediaData4.getEpisode();
                Integer aniid4 = mediaData4.getAniId();
                Ref.IntRef kitsuId5 = new Ref.IntRef();
                kitsuId5.element = -1;
                Ref.ObjectRef type5 = new Ref.ObjectRef();
                type5.element = TvType.TvSeries;
                Ref.ObjectRef anidbEid3 = new Ref.ObjectRef();
                try {
                    Requests app = MainActivityKt.getApp();
                    String str3 = "https://api.ani.zip/mappings?anilist_id=" + aniid4;
                    c00262.L$0 = $this;
                    c00262.L$1 = SpillingKt.nullOutSpilledVariable(data);
                    c00262.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                    c00262.L$3 = function2;
                    c00262.L$4 = provider3;
                    c00262.L$5 = key3;
                    c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData4);
                    c00262.L$7 = episode8;
                    c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid4);
                    c00262.L$9 = kitsuId5;
                    c00262.L$10 = type5;
                    c00262.L$11 = anidbEid3;
                    c00262.Z$0 = isCasting;
                    c00262.label = 1;
                    obj3 = coroutine_suspended;
                    try {
                        Object obj5 = Requests.get$default(app, str3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00262, 4094, (Object) null);
                        c00262 = c00262;
                        if (obj5 == obj3) {
                            return obj3;
                        }
                        isCasting2 = isCasting;
                        function5 = function1;
                        function4 = function2;
                        obj4 = obj5;
                        mediaData = mediaData4;
                        key = key3;
                        episode = episode8;
                        aniid = aniid4;
                        kitsuId = kitsuId5;
                        type = type5;
                        episode2 = anidbEid3;
                        provider = provider3;
                        $this3 = $this;
                        data2 = data;
                        try {
                            String anijson = ((NiceResponse) obj4).toString();
                            $this6 = $this3;
                            try {
                                mappings = new JSONObject(anijson).optJSONObject("mappings");
                                if (mappings != null) {
                                    function9 = function5;
                                    try {
                                        kitsuId.element = mappings.optInt("kitsu_id", -1);
                                        rawtype = mappings.optString("type", "");
                                        if (StringsKt.contains(rawtype, "MOVIE", true)) {
                                            type.element = TvType.Movie;
                                            episode.element = Boxing.boxInt(1);
                                        }
                                    } catch (Exception e2) {
                                        $this2 = $this6;
                                        function3 = function9;
                                        $this4 = $this2;
                                        function6 = function3;
                                        episode3 = episode;
                                        episode4 = type;
                                    }
                                } else {
                                    function9 = function5;
                                }
                                try {
                                    anidbEid2 = TorraStreamUtilsKt.getAnidbEid(anijson, (Integer) episode.element);
                                } catch (Exception e3) {
                                    anidbEid2 = null;
                                }
                                episode2.element = anidbEid2;
                                $this4 = $this6;
                                function6 = function9;
                                episode3 = episode;
                                episode4 = type;
                            } catch (Exception e4) {
                                $this2 = $this6;
                                function3 = function5;
                            }
                            break;
                        } catch (Exception e5) {
                            $this2 = $this3;
                            function3 = function5;
                        }
                        debianapiUrl = $this4.buildApiUrl($this4.sharedPref, $this4.torrentioDebian);
                        SharedPreferences sharedPreferences = $this4.sharedPref;
                        c00262.L$0 = $this4;
                        function7 = function6;
                        c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00262.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                        c00262.L$3 = function4;
                        c00262.L$4 = provider;
                        c00262.L$5 = key;
                        c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData);
                        c00262.L$7 = episode3;
                        c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                        c00262.L$9 = kitsuId;
                        c00262.L$10 = episode4;
                        c00262.L$11 = episode2;
                        c00262.L$12 = debianapiUrl;
                        c00262.Z$0 = isCasting2;
                        c00262.label = 2;
                        objBuildMeteorUrl = $this4.buildMeteorUrl(sharedPreferences, TorraStream.Meteorfortheweebs, c00262);
                        if (objBuildMeteorUrl == obj3) {
                            return obj3;
                        }
                        episode5 = episode3;
                        debianapiUrl2 = debianapiUrl;
                        $this5 = $this4;
                        $result = objBuildMeteorUrl;
                        anidbEid = episode2;
                        kitsuId2 = kitsuId;
                        debianapiUrl3 = provider;
                        function8 = function7;
                        mediaData2 = mediaData;
                        aniid2 = aniid;
                        type2 = episode4;
                        meteorUrl = (String) $result;
                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this5.sharedPref, function4);
                        str = debianapiUrl3;
                        if (str != null || str.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            str2 = key;
                            if (str2 != null || str2.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                if (kitsuId2.element != -1) {
                                    kitsuId3 = kitsuId2;
                                    C00274 c00274 = new C00274(debianapiUrl2, type2, kitsuId3, episode5, function1FilteredCallback, null);
                                    episode6 = episode5;
                                    type3 = type2;
                                    function1Arr2 = new Function1[]{c00274, new C00285(meteorUrl, type3, kitsuId3, episode6, function1FilteredCallback, null)};
                                    c00262.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                                    c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00262.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                    c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                                    c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                                    c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                                    c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode6);
                                    c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                                    c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId3);
                                    c00262.L$10 = SpillingKt.nullOutSpilledVariable(type3);
                                    c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                                    c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                                    c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                    c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                                    c00262.Z$0 = isCasting2;
                                    c00262.label = 3;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00262) == obj3) {
                                        return obj3;
                                    }
                                    LinkData linkData = mediaData2;
                                    key2 = key;
                                    mediaData3 = linkData;
                                    provider2 = debianapiUrl3;
                                    aniid3 = aniid2;
                                    kitsuId4 = kitsuId3;
                                    type4 = type3;
                                    episode7 = episode6;
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        String debianapiUrl4 = debianapiUrl2;
                        Ref.IntRef kitsuId6 = kitsuId2;
                        Ref.ObjectRef episode9 = episode5;
                        Function1<? super ExtractorLink, Unit> function10 = function4;
                        Ref.ObjectRef episode10 = type2;
                        TorraStreamAnime $this7 = $this5;
                        function1Arr = new Function1[]{new C00296(anidbEid, function4, null), new C00307(kitsuId6, $this7, episode10, episode9, function10, null), new C00318(kitsuId6, $this7, episode9, function1FilteredCallback, null)};
                        c00262.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                        c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00262.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                        c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                        c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                        c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                        c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode9);
                        c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                        c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId6);
                        c00262.L$10 = SpillingKt.nullOutSpilledVariable(episode10);
                        c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                        c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl4);
                        c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                        c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                        c00262.Z$0 = isCasting2;
                        c00262.label = 4;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00262) == obj3) {
                            return obj3;
                        }
                        return Boxing.boxBoolean(true);
                    } catch (Exception e6) {
                        c00262 = c00262;
                        $this2 = $this;
                        isCasting2 = isCasting;
                        function3 = function1;
                        function4 = function2;
                        mediaData = mediaData4;
                        key = key3;
                        episode = episode8;
                        aniid = aniid4;
                        kitsuId = kitsuId5;
                        type = type5;
                        episode2 = anidbEid3;
                        provider = provider3;
                        data2 = data;
                        $this4 = $this2;
                        function6 = function3;
                        episode3 = episode;
                        episode4 = type;
                        debianapiUrl = $this4.buildApiUrl($this4.sharedPref, $this4.torrentioDebian);
                        SharedPreferences sharedPreferences2 = $this4.sharedPref;
                        c00262.L$0 = $this4;
                        function7 = function6;
                        c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00262.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                        c00262.L$3 = function4;
                        c00262.L$4 = provider;
                        c00262.L$5 = key;
                        c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData);
                        c00262.L$7 = episode3;
                        c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                        c00262.L$9 = kitsuId;
                        c00262.L$10 = episode4;
                        c00262.L$11 = episode2;
                        c00262.L$12 = debianapiUrl;
                        c00262.Z$0 = isCasting2;
                        c00262.label = 2;
                        objBuildMeteorUrl = $this4.buildMeteorUrl(sharedPreferences2, TorraStream.Meteorfortheweebs, c00262);
                        if (objBuildMeteorUrl == obj3) {
                            return obj3;
                        }
                        episode5 = episode3;
                        debianapiUrl2 = debianapiUrl;
                        $this5 = $this4;
                        $result = objBuildMeteorUrl;
                        anidbEid = episode2;
                        kitsuId2 = kitsuId;
                        debianapiUrl3 = provider;
                        function8 = function7;
                        mediaData2 = mediaData;
                        aniid2 = aniid;
                        type2 = episode4;
                        meteorUrl = (String) $result;
                        function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this5.sharedPref, function4);
                        str = debianapiUrl3;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            str2 = key;
                            if (str2 != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (!z2) {
                                if (kitsuId2.element != -1) {
                                    kitsuId3 = kitsuId2;
                                    C00274 c00275 = new C00274(debianapiUrl2, type2, kitsuId3, episode5, function1FilteredCallback, null);
                                    episode6 = episode5;
                                    type3 = type2;
                                    function1Arr2 = new Function1[]{c00275, new C00285(meteorUrl, type3, kitsuId3, episode6, function1FilteredCallback, null)};
                                    c00262.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                                    c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                                    c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                    c00262.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                    c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                                    c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                                    c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                                    c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode6);
                                    c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                                    c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId3);
                                    c00262.L$10 = SpillingKt.nullOutSpilledVariable(type3);
                                    c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                                    c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                                    c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                    c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                                    c00262.Z$0 = isCasting2;
                                    c00262.label = 3;
                                    if (ParCollectionsKt.runAllAsync(function1Arr2, c00262) == obj3) {
                                        return obj3;
                                    }
                                    LinkData linkData2 = mediaData2;
                                    key2 = key;
                                    mediaData3 = linkData2;
                                    provider2 = debianapiUrl3;
                                    aniid3 = aniid2;
                                    kitsuId4 = kitsuId3;
                                    type4 = type3;
                                    episode7 = episode6;
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                            return Boxing.boxBoolean(true);
                        }
                        String debianapiUrl5 = debianapiUrl2;
                        Ref.IntRef kitsuId7 = kitsuId2;
                        Ref.ObjectRef episode11 = episode5;
                        Function1<? super ExtractorLink, Unit> function11 = function4;
                        Ref.ObjectRef episode12 = type2;
                        TorraStreamAnime $this8 = $this5;
                        function1Arr = new Function1[]{new C00296(anidbEid, function4, null), new C00307(kitsuId7, $this8, episode12, episode11, function11, null), new C00318(kitsuId7, $this8, episode11, function1FilteredCallback, null)};
                        c00262.L$0 = SpillingKt.nullOutSpilledVariable($this8);
                        c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                        c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                        c00262.L$3 = SpillingKt.nullOutSpilledVariable(function11);
                        c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                        c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                        c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                        c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode11);
                        c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                        c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId7);
                        c00262.L$10 = SpillingKt.nullOutSpilledVariable(episode12);
                        c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                        c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl5);
                        c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                        c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                        c00262.Z$0 = isCasting2;
                        c00262.label = 4;
                        if (ParCollectionsKt.runAllAsync(function1Arr, c00262) == obj3) {
                            return obj3;
                        }
                        return Boxing.boxBoolean(true);
                    }
                } catch (Exception e7) {
                    obj3 = coroutine_suspended;
                    $this2 = $this;
                    isCasting2 = isCasting;
                    function3 = function1;
                    function4 = function2;
                    mediaData = mediaData4;
                    key = key3;
                    episode = episode8;
                    aniid = aniid4;
                    kitsuId = kitsuId5;
                    type = type5;
                    episode2 = anidbEid3;
                    provider = provider3;
                    data2 = data;
                }
                break;
            case 1:
                isCasting2 = c00262.Z$0;
                episode2 = (Ref.ObjectRef) c00262.L$11;
                type = (Ref.ObjectRef) c00262.L$10;
                kitsuId = (Ref.IntRef) c00262.L$9;
                aniid = (Integer) c00262.L$8;
                episode = (Ref.ObjectRef) c00262.L$7;
                mediaData = (LinkData) c00262.L$6;
                key = (String) c00262.L$5;
                provider = (String) c00262.L$4;
                function4 = (Function1) c00262.L$3;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00262.L$2;
                data2 = (String) c00262.L$1;
                TorraStreamAnime $this9 = (TorraStreamAnime) c00262.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    $this3 = $this9;
                    obj3 = coroutine_suspended;
                    function5 = function12;
                    String anijson2 = ((NiceResponse) obj4).toString();
                    $this6 = $this3;
                    mappings = new JSONObject(anijson2).optJSONObject("mappings");
                    if (mappings != null) {
                        function9 = function5;
                        kitsuId.element = mappings.optInt("kitsu_id", -1);
                        rawtype = mappings.optString("type", "");
                        if (StringsKt.contains(rawtype, "MOVIE", true)) {
                            type.element = TvType.Movie;
                            episode.element = Boxing.boxInt(1);
                        }
                    } else {
                        function9 = function5;
                    }
                    anidbEid2 = TorraStreamUtilsKt.getAnidbEid(anijson2, (Integer) episode.element);
                    episode2.element = anidbEid2;
                    $this4 = $this6;
                    function6 = function9;
                    episode3 = episode;
                    episode4 = type;
                } catch (Exception e8) {
                    $this2 = $this9;
                    obj3 = coroutine_suspended;
                    function3 = function12;
                    $this4 = $this2;
                    function6 = function3;
                    episode3 = episode;
                    episode4 = type;
                    debianapiUrl = $this4.buildApiUrl($this4.sharedPref, $this4.torrentioDebian);
                    SharedPreferences sharedPreferences3 = $this4.sharedPref;
                    c00262.L$0 = $this4;
                    function7 = function6;
                    c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                    c00262.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                    c00262.L$3 = function4;
                    c00262.L$4 = provider;
                    c00262.L$5 = key;
                    c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData);
                    c00262.L$7 = episode3;
                    c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                    c00262.L$9 = kitsuId;
                    c00262.L$10 = episode4;
                    c00262.L$11 = episode2;
                    c00262.L$12 = debianapiUrl;
                    c00262.Z$0 = isCasting2;
                    c00262.label = 2;
                    objBuildMeteorUrl = $this4.buildMeteorUrl(sharedPreferences3, TorraStream.Meteorfortheweebs, c00262);
                    if (objBuildMeteorUrl == obj3) {
                        return obj3;
                    }
                    episode5 = episode3;
                    debianapiUrl2 = debianapiUrl;
                    $this5 = $this4;
                    $result = objBuildMeteorUrl;
                    anidbEid = episode2;
                    kitsuId2 = kitsuId;
                    debianapiUrl3 = provider;
                    function8 = function7;
                    mediaData2 = mediaData;
                    aniid2 = aniid;
                    type2 = episode4;
                    meteorUrl = (String) $result;
                    function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this5.sharedPref, function4);
                    str = debianapiUrl3;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        str2 = key;
                        if (str2 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            if (kitsuId2.element != -1) {
                                kitsuId3 = kitsuId2;
                                C00274 c00276 = new C00274(debianapiUrl2, type2, kitsuId3, episode5, function1FilteredCallback, null);
                                episode6 = episode5;
                                type3 = type2;
                                function1Arr2 = new Function1[]{c00276, new C00285(meteorUrl, type3, kitsuId3, episode6, function1FilteredCallback, null)};
                                c00262.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                                c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                                c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                c00262.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                                c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                                c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                                c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                                c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode6);
                                c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                                c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId3);
                                c00262.L$10 = SpillingKt.nullOutSpilledVariable(type3);
                                c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                                c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                                c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                                c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                                c00262.Z$0 = isCasting2;
                                c00262.label = 3;
                                if (ParCollectionsKt.runAllAsync(function1Arr2, c00262) == obj3) {
                                    return obj3;
                                }
                                LinkData linkData3 = mediaData2;
                                key2 = key;
                                mediaData3 = linkData3;
                                provider2 = debianapiUrl3;
                                aniid3 = aniid2;
                                kitsuId4 = kitsuId3;
                                type4 = type3;
                                episode7 = episode6;
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                        return Boxing.boxBoolean(true);
                    }
                    String debianapiUrl6 = debianapiUrl2;
                    Ref.IntRef kitsuId8 = kitsuId2;
                    Ref.ObjectRef episode13 = episode5;
                    Function1<? super ExtractorLink, Unit> function13 = function4;
                    Ref.ObjectRef episode14 = type2;
                    TorraStreamAnime $this10 = $this5;
                    function1Arr = new Function1[]{new C00296(anidbEid, function4, null), new C00307(kitsuId8, $this10, episode14, episode13, function13, null), new C00318(kitsuId8, $this10, episode13, function1FilteredCallback, null)};
                    c00262.L$0 = SpillingKt.nullOutSpilledVariable($this10);
                    c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                    c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00262.L$3 = SpillingKt.nullOutSpilledVariable(function13);
                    c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                    c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                    c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                    c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode13);
                    c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                    c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId8);
                    c00262.L$10 = SpillingKt.nullOutSpilledVariable(episode14);
                    c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                    c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl6);
                    c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                    c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                    c00262.Z$0 = isCasting2;
                    c00262.label = 4;
                    if (ParCollectionsKt.runAllAsync(function1Arr, c00262) == obj3) {
                        return obj3;
                    }
                    return Boxing.boxBoolean(true);
                }
                debianapiUrl = $this4.buildApiUrl($this4.sharedPref, $this4.torrentioDebian);
                SharedPreferences sharedPreferences4 = $this4.sharedPref;
                c00262.L$0 = $this4;
                function7 = function6;
                c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00262.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00262.L$3 = function4;
                c00262.L$4 = provider;
                c00262.L$5 = key;
                c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData);
                c00262.L$7 = episode3;
                c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid);
                c00262.L$9 = kitsuId;
                c00262.L$10 = episode4;
                c00262.L$11 = episode2;
                c00262.L$12 = debianapiUrl;
                c00262.Z$0 = isCasting2;
                c00262.label = 2;
                objBuildMeteorUrl = $this4.buildMeteorUrl(sharedPreferences4, TorraStream.Meteorfortheweebs, c00262);
                if (objBuildMeteorUrl == obj3) {
                    return obj3;
                }
                episode5 = episode3;
                debianapiUrl2 = debianapiUrl;
                $this5 = $this4;
                $result = objBuildMeteorUrl;
                anidbEid = episode2;
                kitsuId2 = kitsuId;
                debianapiUrl3 = provider;
                function8 = function7;
                mediaData2 = mediaData;
                aniid2 = aniid;
                type2 = episode4;
                meteorUrl = (String) $result;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this5.sharedPref, function4);
                str = debianapiUrl3;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    str2 = key;
                    if (str2 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        if (kitsuId2.element != -1) {
                            kitsuId3 = kitsuId2;
                            C00274 c00277 = new C00274(debianapiUrl2, type2, kitsuId3, episode5, function1FilteredCallback, null);
                            episode6 = episode5;
                            type3 = type2;
                            function1Arr2 = new Function1[]{c00277, new C00285(meteorUrl, type3, kitsuId3, episode6, function1FilteredCallback, null)};
                            c00262.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                            c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00262.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                            c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                            c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                            c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode6);
                            c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                            c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId3);
                            c00262.L$10 = SpillingKt.nullOutSpilledVariable(type3);
                            c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                            c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                            c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00262.Z$0 = isCasting2;
                            c00262.label = 3;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00262) == obj3) {
                                return obj3;
                            }
                            LinkData linkData4 = mediaData2;
                            key2 = key;
                            mediaData3 = linkData4;
                            provider2 = debianapiUrl3;
                            aniid3 = aniid2;
                            kitsuId4 = kitsuId3;
                            type4 = type3;
                            episode7 = episode6;
                        }
                        Unit unit4 = Unit.INSTANCE;
                    }
                    return Boxing.boxBoolean(true);
                }
                String debianapiUrl7 = debianapiUrl2;
                Ref.IntRef kitsuId9 = kitsuId2;
                Ref.ObjectRef episode15 = episode5;
                Function1<? super ExtractorLink, Unit> function14 = function4;
                Ref.ObjectRef episode16 = type2;
                TorraStreamAnime $this11 = $this5;
                function1Arr = new Function1[]{new C00296(anidbEid, function4, null), new C00307(kitsuId9, $this11, episode16, episode15, function14, null), new C00318(kitsuId9, $this11, episode15, function1FilteredCallback, null)};
                c00262.L$0 = SpillingKt.nullOutSpilledVariable($this11);
                c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00262.L$3 = SpillingKt.nullOutSpilledVariable(function14);
                c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode15);
                c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId9);
                c00262.L$10 = SpillingKt.nullOutSpilledVariable(episode16);
                c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl7);
                c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                c00262.Z$0 = isCasting2;
                c00262.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00262) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting3 = c00262.Z$0;
                String debianapiUrl8 = (String) c00262.L$12;
                Ref.ObjectRef anidbEid4 = (Ref.ObjectRef) c00262.L$11;
                Ref.ObjectRef type6 = (Ref.ObjectRef) c00262.L$10;
                Ref.IntRef kitsuId10 = (Ref.IntRef) c00262.L$9;
                Integer aniid5 = (Integer) c00262.L$8;
                Ref.ObjectRef episode17 = (Ref.ObjectRef) c00262.L$7;
                LinkData mediaData5 = (LinkData) c00262.L$6;
                String key4 = (String) c00262.L$5;
                String provider4 = (String) c00262.L$4;
                Function1<? super ExtractorLink, Unit> function15 = (Function1) c00262.L$3;
                Function1<? super SubtitleFile, Unit> function16 = (Function1) c00262.L$2;
                String data3 = (String) c00262.L$1;
                $this5 = (TorraStreamAnime) c00262.L$0;
                ResultKt.throwOnFailure($result);
                data2 = data3;
                function8 = function16;
                obj3 = coroutine_suspended;
                debianapiUrl2 = debianapiUrl8;
                kitsuId2 = kitsuId10;
                aniid2 = aniid5;
                episode5 = episode17;
                mediaData2 = mediaData5;
                key = key4;
                debianapiUrl3 = provider4;
                function4 = function15;
                anidbEid = anidbEid4;
                isCasting2 = isCasting3;
                type2 = type6;
                meteorUrl = (String) $result;
                function1FilteredCallback = TorraStreamUtilsKt.filteredCallback($this5.sharedPref, function4);
                str = debianapiUrl3;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    str2 = key;
                    if (str2 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        if (kitsuId2.element != -1) {
                            kitsuId3 = kitsuId2;
                            C00274 c00278 = new C00274(debianapiUrl2, type2, kitsuId3, episode5, function1FilteredCallback, null);
                            episode6 = episode5;
                            type3 = type2;
                            function1Arr2 = new Function1[]{c00278, new C00285(meteorUrl, type3, kitsuId3, episode6, function1FilteredCallback, null)};
                            c00262.L$0 = SpillingKt.nullOutSpilledVariable($this5);
                            c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                            c00262.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                            c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                            c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                            c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                            c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode6);
                            c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                            c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId3);
                            c00262.L$10 = SpillingKt.nullOutSpilledVariable(type3);
                            c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                            c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl2);
                            c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                            c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                            c00262.Z$0 = isCasting2;
                            c00262.label = 3;
                            if (ParCollectionsKt.runAllAsync(function1Arr2, c00262) == obj3) {
                                return obj3;
                            }
                            LinkData linkData5 = mediaData2;
                            key2 = key;
                            mediaData3 = linkData5;
                            provider2 = debianapiUrl3;
                            aniid3 = aniid2;
                            kitsuId4 = kitsuId3;
                            type4 = type3;
                            episode7 = episode6;
                        }
                        Unit unit5 = Unit.INSTANCE;
                    }
                    return Boxing.boxBoolean(true);
                }
                String debianapiUrl9 = debianapiUrl2;
                Ref.IntRef kitsuId11 = kitsuId2;
                Ref.ObjectRef episode18 = episode5;
                Function1<? super ExtractorLink, Unit> function17 = function4;
                Ref.ObjectRef episode19 = type2;
                TorraStreamAnime $this12 = $this5;
                function1Arr = new Function1[]{new C00296(anidbEid, function4, null), new C00307(kitsuId11, $this12, episode19, episode18, function17, null), new C00318(kitsuId11, $this12, episode18, function1FilteredCallback, null)};
                c00262.L$0 = SpillingKt.nullOutSpilledVariable($this12);
                c00262.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00262.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00262.L$3 = SpillingKt.nullOutSpilledVariable(function17);
                c00262.L$4 = SpillingKt.nullOutSpilledVariable(debianapiUrl3);
                c00262.L$5 = SpillingKt.nullOutSpilledVariable(key);
                c00262.L$6 = SpillingKt.nullOutSpilledVariable(mediaData2);
                c00262.L$7 = SpillingKt.nullOutSpilledVariable(episode18);
                c00262.L$8 = SpillingKt.nullOutSpilledVariable(aniid2);
                c00262.L$9 = SpillingKt.nullOutSpilledVariable(kitsuId11);
                c00262.L$10 = SpillingKt.nullOutSpilledVariable(episode19);
                c00262.L$11 = SpillingKt.nullOutSpilledVariable(anidbEid);
                c00262.L$12 = SpillingKt.nullOutSpilledVariable(debianapiUrl9);
                c00262.L$13 = SpillingKt.nullOutSpilledVariable(meteorUrl);
                c00262.L$14 = SpillingKt.nullOutSpilledVariable(function1FilteredCallback);
                c00262.Z$0 = isCasting2;
                c00262.label = 4;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00262) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(true);
            case 3:
                boolean z3 = c00262.Z$0;
                type4 = (Ref.ObjectRef) c00262.L$10;
                kitsuId4 = (Ref.IntRef) c00262.L$9;
                aniid3 = (Integer) c00262.L$8;
                episode7 = (Ref.ObjectRef) c00262.L$7;
                mediaData3 = (LinkData) c00262.L$6;
                key2 = (String) c00262.L$5;
                String provider5 = (String) c00262.L$4;
                ResultKt.throwOnFailure($result);
                provider2 = provider5;
                Unit unit6 = Unit.INSTANCE;
                return Boxing.boxBoolean(true);
            case 4:
                boolean z4 = c00262.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.TorraStreamAnime$loadLinks$4 */
    /* JADX INFO: compiled from: TorraStreamAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$4", f = "TorraStreamAnime.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00274 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $debianapiUrl;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Ref.IntRef $kitsuId;
        final /* synthetic */ Ref.ObjectRef<TvType> $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00274(String str, Ref.ObjectRef<TvType> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Integer> objectRef2, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00274> continuation) {
            super(1, continuation);
            this.$debianapiUrl = str;
            this.$type = objectRef;
            this.$kitsuId = intRef;
            this.$episode = objectRef2;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00274(this.$debianapiUrl, this.$type, this.$kitsuId, this.$episode, this.$filtered, continuation);
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$5", f = "TorraStreamAnime.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00285 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Ref.IntRef $kitsuId;
        final /* synthetic */ String $meteorUrl;
        final /* synthetic */ Ref.ObjectRef<TvType> $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00285(String str, Ref.ObjectRef<TvType> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Integer> objectRef2, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00285> continuation) {
            super(1, continuation);
            this.$meteorUrl = str;
            this.$type = objectRef;
            this.$kitsuId = intRef;
            this.$episode = objectRef2;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00285(this.$meteorUrl, this.$type, this.$kitsuId, this.$episode, this.$filtered, continuation);
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$6", f = "TorraStreamAnime.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00296 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $anidbEid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00296(Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00296> continuation) {
            super(1, continuation);
            this.$anidbEid = objectRef;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00296(this.$anidbEid, this.$callback, continuation);
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$7", f = "TorraStreamAnime.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00307 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Ref.IntRef $kitsuId;
        final /* synthetic */ Ref.ObjectRef<TvType> $type;
        int label;
        final /* synthetic */ TorraStreamAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00307(Ref.IntRef intRef, TorraStreamAnime torraStreamAnime, Ref.ObjectRef<TvType> objectRef, Ref.ObjectRef<Integer> objectRef2, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00307> continuation) {
            super(1, continuation);
            this.$kitsuId = intRef;
            this.this$0 = torraStreamAnime;
            this.$type = objectRef;
            this.$episode = objectRef2;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00307(this.$kitsuId, this.this$0, this.$type, this.$episode, this.$callback, continuation);
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
    @DebugMetadata(c = "com.phisher98.TorraStreamAnime$loadLinks$8", f = "TorraStreamAnime.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, nl = {313}, s = {}, v = 2)
    static final class C00318 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Integer> $episode;
        final /* synthetic */ Function1<ExtractorLink, Unit> $filtered;
        final /* synthetic */ Ref.IntRef $kitsuId;
        int label;
        final /* synthetic */ TorraStreamAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00318(Ref.IntRef intRef, TorraStreamAnime torraStreamAnime, Ref.ObjectRef<Integer> objectRef, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00318> continuation) {
            super(1, continuation);
            this.$kitsuId = intRef;
            this.this$0 = torraStreamAnime;
            this.$episode = objectRef;
            this.$filtered = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00318(this.$kitsuId, this.this$0, this.$episode, this.$filtered, continuation);
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
            public final String m14getTitle() throws Exception {
                String english = this.title.getEnglish();
                if (english != null || (english = this.title.getRomaji()) != null) {
                    return english;
                }
                throw new Exception("Unable to calculate total episodes");
            }

            @Nullable
            /* JADX INFO: renamed from: getCoverImage, reason: collision with other method in class */
            public final String m13getCoverImage() {
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0004\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e¢\u0006\u0004\b\u001f\u0010 J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010E\u001a\u00020\u0014HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010L\u001a\u00020\u0014HÆ\u0003J\t\u0010M\u001a\u00020\u0014HÆ\u0003J\t\u0010N\u001a\u00020\u0014HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003Jô\u0004\u0010P\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001eHÆ\u0001¢\u0006\u0002\u0010QJ\u0014\u0010R\u001a\u00020\u00142\b\u0010S\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010T\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010U\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b+\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b,\u0010\"R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b-\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b/\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00101R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b2\u0010\"R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b3\u0010\"R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00101R\u0011\u0010\u001c\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00101R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00101R\u0011\u0010\u001e\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u00101¨\u0006V"}, d2 = {"Lcom/phisher98/TorraStreamAnime$LinkData;", "", "simklId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "traktId", "imdbId", "", "tmdbId", "tvdbId", "type", "season", "episode", "aniId", "malId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "isDub", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getSimklId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTraktId", "getImdbId", "()Ljava/lang/String;", "getTmdbId", "getTvdbId", "getType", "getSeason", "getEpisode", "getAniId", "getMalId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)Lcom/phisher98/TorraStreamAnime$LinkData;", "equals", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, false, 16777215, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, Integer num7, Integer num8, String str3, Integer num9, String str4, boolean z, Integer num10, Integer num11, String str5, String str6, String str7, String str8, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            boolean z6;
            boolean z7;
            Integer num12 = (i & 1) != 0 ? linkData.simklId : num;
            Integer num13 = (i & 2) != 0 ? linkData.traktId : num2;
            String str9 = (i & 4) != 0 ? linkData.imdbId : str;
            Integer num14 = (i & 8) != 0 ? linkData.tmdbId : num3;
            Integer num15 = (i & 16) != 0 ? linkData.tvdbId : num4;
            String str10 = (i & 32) != 0 ? linkData.type : str2;
            Integer num16 = (i & 64) != 0 ? linkData.season : num5;
            Integer num17 = (i & 128) != 0 ? linkData.episode : num6;
            Integer num18 = (i & 256) != 0 ? linkData.aniId : num7;
            Integer num19 = (i & 512) != 0 ? linkData.malId : num8;
            String str11 = (i & 1024) != 0 ? linkData.title : str3;
            Integer num20 = (i & 2048) != 0 ? linkData.year : num9;
            String str12 = (i & 4096) != 0 ? linkData.orgTitle : str4;
            boolean z8 = (i & 8192) != 0 ? linkData.isAnime : z;
            Integer num21 = num12;
            Integer num22 = (i & 16384) != 0 ? linkData.airedYear : num10;
            Integer num23 = (i & 32768) != 0 ? linkData.lastSeason : num11;
            String str13 = (i & 65536) != 0 ? linkData.epsTitle : str5;
            String str14 = (i & 131072) != 0 ? linkData.jpTitle : str6;
            String str15 = (i & 262144) != 0 ? linkData.date : str7;
            String str16 = (i & 524288) != 0 ? linkData.airedDate : str8;
            boolean z9 = (i & 1048576) != 0 ? linkData.isAsian : z2;
            boolean z10 = (i & 2097152) != 0 ? linkData.isBollywood : z3;
            boolean z11 = (i & 4194304) != 0 ? linkData.isCartoon : z4;
            if ((i & 8388608) != 0) {
                z7 = z11;
                z6 = linkData.isDub;
            } else {
                z6 = z5;
                z7 = z11;
            }
            return linkData.copy(num21, num13, str9, num14, num15, str10, num16, num17, num18, num19, str11, num20, str12, z8, num22, num23, str13, str14, str15, str16, z9, z10, z7, z6);
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
        public final LinkData copy(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub) {
            return new LinkData(simklId, traktId, imdbId, tmdbId, tvdbId, type, season, episode, aniId, malId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, isDub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.simklId, linkData.simklId) && Intrinsics.areEqual(this.traktId, linkData.traktId) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tmdbId, linkData.tmdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.malId, linkData.malId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && this.isDub == linkData.isDub;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((this.simklId == null ? 0 : this.simklId.hashCode()) * 31) + (this.traktId == null ? 0 : this.traktId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate != null ? this.airedDate.hashCode() : 0)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isAsian)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isBollywood)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isCartoon)) * 31) + TorraStreamAnime$LinkData$$ExternalSyntheticBackport0.m9m(this.isDub);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(simklId=").append(this.simklId).append(", traktId=").append(this.traktId).append(", imdbId=").append(this.imdbId).append(", tmdbId=").append(this.tmdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", aniId=").append(this.aniId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", year=");
            sb.append(this.year).append(", orgTitle=").append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon);
            sb.append(", isDub=").append(this.isDub).append(')');
            return sb.toString();
        }

        public LinkData(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub) {
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
        }

        public /* synthetic */ LinkData(Integer num, Integer num2, String str, Integer num3, Integer num4, String str2, Integer num5, Integer num6, Integer num7, Integer num8, String str3, Integer num9, String str4, boolean z, Integer num10, Integer num11, String str5, String str6, String str7, String str8, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : num5, (i & 128) != 0 ? null : num6, (i & 256) != 0 ? null : num7, (i & 512) != 0 ? null : num8, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : num9, (i & 4096) != 0 ? null : str4, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? null : num10, (i & 32768) != 0 ? null : num11, (i & 65536) != 0 ? null : str5, (i & 131072) != 0 ? null : str6, (i & 262144) != 0 ? null : str7, (i & 524288) != 0 ? null : str8, (i & 1048576) != 0 ? false : z2, (i & 2097152) != 0 ? false : z3, (i & 4194304) != 0 ? false : z4, (i & 8388608) == 0 ? z5 : false);
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
        C00331 c00331;
        AniMedia aniMedia;
        Object obj;
        Object safe;
        AniMedia res;
        AniData it;
        ArrayList<AniMedia> media;
        if (continuation instanceof C00331) {
            c00331 = (C00331) continuation;
            if ((c00331.label & Integer.MIN_VALUE) != 0) {
                c00331.label -= Integer.MIN_VALUE;
            } else {
                c00331 = new C00331(continuation);
            }
        } else {
            c00331 = new C00331(continuation);
        }
        Object $result = c00331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00331.label) {
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
                c00331.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00331.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00331.L$2 = SpillingKt.nullOutSpilledVariable(type);
                c00331.L$3 = SpillingKt.nullOutSpilledVariable("query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $season: MediaSeason\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      season: $season\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}");
                c00331.L$4 = SpillingKt.nullOutSpilledVariable(variables);
                c00331.L$5 = SpillingKt.nullOutSpilledVariable(data);
                c00331.label = 1;
                aniMedia = null;
                Object objPost$default = Requests.post$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, data, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00331, 65278, (Object) null);
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
            z = true;
        }
        return z ? ShowStatus.Ongoing : ShowStatus.Completed;
    }
}
