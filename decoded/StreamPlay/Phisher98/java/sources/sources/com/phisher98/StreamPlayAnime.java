package com.phisher98;

import android.app.Activity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
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

/* JADX INFO: compiled from: StreamPlayAnime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003Z[\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010(\u001a\u00020\u0005*\u00020)H\u0004J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010-J\f\u0010.\u001a\u00020/*\u000200H\u0002J,\u00101\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020/03\u0012\u0004\u0012\u00020\u001b02*\u0002042\u0006\u00105\u001a\u00020$H\u0082@¢\u0006\u0002\u00106J \u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010,\u001a\u00020\u00052\u0006\u00105\u001a\u00020$H\u0096@¢\u0006\u0002\u0010>J\u001e\u0010:\u001a\u00020?2\u0006\u00105\u001a\u00020$2\u0006\u0010@\u001a\u000204H\u0096@¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u001b2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0I2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020K0IH\u0096@¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0005J*\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u00052\b\u0010U\u001a\u0004\u0018\u00010$2\u0006\u0010V\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010WJ\u0017\u0010X\u001a\u0004\u0018\u00010$2\u0006\u0010T\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010YR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020903X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006]"}, d2 = {"Lcom/phisher98/StreamPlayAnime;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "supportedSyncNames", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "repo", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "apiUrl", "mediaLimit", "", "isAdult", "headerJSON", "", "toStringData", "", "anilistAPICall", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/StreamPlayAnime$Media;", "toSearchResponseList", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/MainPageRequest;", "page", "(Lcom/lagradost/cloudstream3/MainPageRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentYear", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "request", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "tmdbToAnimeId", "Lcom/phisher98/AniIds;", "title", "year", "type", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractSeason", "(Ljava/lang/String;)Ljava/lang/Integer;", "AnilistAPIResponse", "LinkData", "Media", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,530:1\n73#2,5:531\n73#2,5:598\n73#2,5:604\n1739#3:536\n1814#3,3:537\n1739#3:540\n1814#3,3:541\n1795#3,10:544\n2068#3:554\n2069#3:556\n1805#3:557\n1453#3,2:558\n1468#3,4:560\n1453#3,2:564\n1468#3,4:566\n1739#3:570\n1814#3,3:571\n1749#3:574\n1782#3,4:575\n1#4:555\n1#4:580\n1#4:603\n63#5:579\n64#5,15:581\n50#6:596\n43#6:597\n*S KotlinDebug\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime\n*L\n84#1:531,5\n321#1:598,5\n516#1:604,5\n105#1:536\n105#1:537,3\n131#1:540\n131#1:541,3\n144#1:544,10\n144#1:554\n144#1:556\n144#1:557\n191#1:558,2\n191#1:560,4\n192#1:564,2\n192#1:566,4\n220#1:570\n220#1:571,3\n247#1:574\n247#1:575,4\n144#1:555\n312#1:580\n312#1:579\n312#1:581,15\n312#1:596\n312#1:597\n*E\n"})
public final class StreamPlayAnime extends MainAPI {
    private final boolean hasQuickSearch;

    @NotNull
    private String name = "StreamPlay-Anime";

    @NotNull
    private String mainUrl = "https://anilist.co";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(new SyncIdName[]{SyncIdName.Anilist, SyncIdName.MyAnimeList});
    private final boolean hasMainPage = true;

    @NotNull
    private final SyncRepo repo = new SyncRepo(AccountManager.Companion.getAniListApi());

    @NotNull
    private final String apiUrl = StreamPlay.anilistAPI;
    private final int mediaLimit = 20;

    @NotNull
    private final Map<String, String> headerJSON = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "application/json"), TuplesKt.to("Content-Type", "application/json")});
    private final int currentYear = Calendar.getInstance().get(1);
    private final boolean isAdult;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [TRENDING_DESC, POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Trending Now"), TuplesKt.to("query ($page: Int = ###, $seasonYear: Int = " + this.currentYear + ", $sort: [MediaSort] = [TRENDING_DESC, POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, seasonYear: $seasonYear, season: SPRING, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Popular This Season"), TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [POPULARITY_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "All Time Popular"), TuplesKt.to("query ($page: Int = ###, $sort: [MediaSort] = [SCORE_DESC], $isAdult: Boolean = " + this.isAdult + ") { Page(page: $page, perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(sort: $sort, isAdult: $isAdult, type: ANIME) { id idMal season seasonYear format episodes chapters averageScore title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }", "Top 100 Anime"), TuplesKt.to("Personal", "Personal")});

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$anilistAPICall$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0}, l = {82}, m = "anilistAPICall", n = {"query", "data"}, nl = {84}, s = {"L$0", "L$1"}, v = 2)
    static final class C00791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00791(Continuation<? super C00791> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.anilistAPICall(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$getMainPage$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 1, 1}, l = {144, 154}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {144, 155}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00801 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00801(Continuation<? super C00801> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$load$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {161, 171, 175, 182, 265, 279}, m = "load", n = {"url", "id", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "aniyear", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "aniyear", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "aniyear", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "logoUrl", "anidbEidMap", "epMetaMap", "fallbackPoster", "fallbackTitle", "href", "episodes", "episodesDub", "aniyear", "totalEps", "anidbEid", "url", "id", "data", "anititle", "posterurl", "backgroundUrl", "anitype", "ids", "jpTitle", "syncMetaData", "animeMetaData", "tmdbid", "kitsuid", "type", "logoUrl", "anidbEidMap", "epMetaMap", "fallbackPoster", "fallbackTitle", "href", "episodes", "episodesDub", "aniyear", "totalEps", "anidbEid"}, nl = {163, 173, 176, 190, 279, 264}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00811 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00811(Continuation<? super C00811> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {321, 331}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "mediaData", "malId", "episode", "jpTitle", "anititle", "anidbEid", "aniid", "year", "isCasting", "data", "subtitleCallback", "callback", "mediaData", "malId", "episode", "jpTitle", "anititle", "anidbEid", "aniid", "year", "malsync", "kaasSlug", "dubStatus", "isCasting"}, nl = {550, 362}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0"}, v = 2)
    static final class C00841 extends ContinuationImpl {
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00841(Continuation<? super C00841> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$search$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0}, l = {128}, m = "search", n = {"query", "page"}, nl = {127}, s = {"L$0", "I$0"}, v = 2)
    static final class C00961 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00961(Continuation<? super C00961> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.search(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$tmdbToAnimeId$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0, 0, 0, 0, 0}, l = {515}, m = "tmdbToAnimeId", n = {"title", "year", "type", "query", "variables", "data"}, nl = {516}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00971(Continuation<? super C00971> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.tmdbToAnimeId(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$toSearchResponseList$1 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime", f = "StreamPlayAnime.kt", i = {0, 0}, l = {103}, m = "toSearchResponseList", n = {"$this$toSearchResponseList", "page"}, nl = {105}, s = {"L$0", "I$0"}, v = 2)
    static final class C00981 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00981(Continuation<? super C00981> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayAnime.this.toSearchResponseList(null, 0, (Continuation) this);
        }
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

    @NotNull
    protected final String toStringData(@NotNull Object $this$toStringData) {
        return MainAPIKt.getMapper().writeValueAsString($this$toStringData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object anilistAPICall(String query, Continuation<? super AnilistAPIResponse> continuation) throws Exception {
        C00791 c00791;
        Object safe;
        if (continuation instanceof C00791) {
            c00791 = (C00791) continuation;
            if ((c00791.label & Integer.MIN_VALUE) != 0) {
                c00791.label -= Integer.MIN_VALUE;
            } else {
                c00791 = new C00791(continuation);
            }
        } else {
            c00791 = new C00791(continuation);
        }
        C00791 c00792 = c00791;
        Object $result = c00792.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00792.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map data = MapsKt.mapOf(TuplesKt.to("query", query));
                Requests app = MainActivityKt.getApp();
                String str = this.apiUrl;
                Map<String, String> map = this.headerJSON;
                c00792.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00792.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00792.label = 1;
                $result = Requests.post$default(app, str, map, (String) null, (Map) null, (Map) null, data, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00792, 65500, (Object) null);
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
        return MainAPIKt.newAnimeSearchResponse$default(this, title, url, TvType.Anime, false, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return StreamPlayAnime.toSearchResponse$lambda$0(posterUrl, rating, (AnimeSearchResponse) obj);
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
        C00981 c00981;
        Object obj;
        Iterable media;
        if (continuation instanceof C00981) {
            c00981 = (C00981) continuation;
            if ((c00981.label & Integer.MIN_VALUE) != 0) {
                c00981.label -= Integer.MIN_VALUE;
            } else {
                c00981 = new C00981(continuation);
            }
        } else {
            c00981 = new C00981(continuation);
        }
        Object $result = c00981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00981.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String strReplace$default = StringsKt.replace$default($this$toSearchResponseList.getData(), "###", String.valueOf(page), false, 4, (Object) null);
                c00981.L$0 = SpillingKt.nullOutSpilledVariable($this$toSearchResponseList);
                c00981.I$0 = page;
                c00981.label = 1;
                Object objAnilistAPICall = anilistAPICall(strReplace$default, c00981);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAnilistAPICall;
                break;
                break;
            case 1:
                int i = c00981.I$0;
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

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) throws Exception {
        C00961 c00961;
        Object objAnilistAPICall;
        Iterable media;
        if (continuation instanceof C00961) {
            c00961 = (C00961) continuation;
            if ((c00961.label & Integer.MIN_VALUE) != 0) {
                c00961.label -= Integer.MIN_VALUE;
            } else {
                c00961 = new C00961(continuation);
            }
        } else {
            c00961 = new C00961(continuation);
        }
        Object $result = c00961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00961.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = "query ($search: String = \"" + query + "\") { Page(page: " + page + ", perPage: " + this.mediaLimit + ") { pageInfo { total perPage currentPage lastPage hasNextPage } media(search: $search, isAdult: " + this.isAdult + ", type: ANIME) { id idMal season seasonYear format episodes chapters title { english romaji } coverImage { extraLarge large medium } synonyms nextAiringEpisode { timeUntilAiring episode } } } }";
                c00961.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00961.I$0 = page;
                c00961.label = 1;
                objAnilistAPICall = anilistAPICall(str, c00961);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00961.I$0;
                ResultKt.throwOnFailure($result);
                objAnilistAPICall = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnilistAPIResponse res = (AnilistAPIResponse) objAnilistAPICall;
        AnilistAPIResponse.AnilistData.AnilistPage page2 = res.getData().getPage();
        if (page2 == null || (media = page2.getMedia()) == null) {
            return null;
        }
        Iterable $this$map$iv = media;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Media it = (Media) item$iv$iv;
            destination$iv$iv.add(toSearchResponse(it));
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:35:0x0121  */
    /* JADX WARN: Code duplicated, block: B:46:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00801 c00801;
        Object searchResponseList;
        Object obj;
        Collection destination$iv$iv;
        SyncAPI.LibraryList it;
        UiText name;
        Activity activity;
        HomePageList homePageList;
        int page2 = page;
        MainPageRequest request2 = request;
        if (continuation instanceof C00801) {
            c00801 = (C00801) continuation;
            if ((c00801.label & Integer.MIN_VALUE) != 0) {
                c00801.label -= Integer.MIN_VALUE;
            } else {
                c00801 = new C00801(continuation);
            }
        } else {
            c00801 = new C00801(continuation);
        }
        Object $result = c00801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        HomePageList homePageList2 = null;
        switch (c00801.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!StringsKt.contains$default(request2.getName(), "Personal", false, 2, (Object) null)) {
                    c00801.L$0 = request2;
                    c00801.I$0 = page2;
                    c00801.label = 2;
                    searchResponseList = toSearchResponseList(request2, page2, c00801);
                    if (searchResponseList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Pair data = (Pair) searchResponseList;
                    return MainAPIKt.newHomePageResponse(request2.getName(), (List) data.getFirst(), (Boolean) data.getSecond());
                }
                if (this.repo.authUser() == null) {
                    return MainAPIKt.newHomePageResponse("Login required for personal content.", CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                }
                SyncRepo syncRepo = this.repo;
                c00801.L$0 = request2;
                c00801.I$0 = page2;
                c00801.label = 1;
                Object obj2 = syncRepo.library-IoAF18A(c00801);
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
                    page2 = page2;
                    homePageList2 = null;
                }
                List homePageList3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(homePageList3, Boxing.boxBoolean(false));
            case 1:
                page2 = c00801.I$0;
                request2 = (MainPageRequest) c00801.L$0;
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
                    page2 = page2;
                    homePageList2 = null;
                }
                List homePageList4 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(homePageList4, Boxing.boxBoolean(false));
            case 2:
                int i = c00801.I$0;
                request2 = (MainPageRequest) c00801.L$0;
                ResultKt.throwOnFailure($result);
                searchResponseList = $result;
                Pair data2 = (Pair) searchResponseList;
                return MainAPIKt.newHomePageResponse(request2.getName(), (List) data2.getFirst(), (Boolean) data2.getSecond());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0564  */
    /* JADX WARN: Code duplicated, block: B:107:0x0575  */
    /* JADX WARN: Code duplicated, block: B:108:0x057a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0606  */
    /* JADX WARN: Code duplicated, block: B:114:0x0641  */
    /* JADX WARN: Code duplicated, block: B:115:0x0646  */
    /* JADX WARN: Code duplicated, block: B:120:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:122:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:125:0x071f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0724  */
    /* JADX WARN: Code duplicated, block: B:130:0x07a6  */
    /* JADX WARN: Code duplicated, block: B:132:0x0863 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:133:0x0864  */
    /* JADX WARN: Code duplicated, block: B:135:0x0887  */
    /* JADX WARN: Code duplicated, block: B:137:0x0961 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x0962  */
    /* JADX WARN: Code duplicated, block: B:141:0x099a  */
    /* JADX WARN: Code duplicated, block: B:143:0x0498 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x048c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0296  */
    /* JADX WARN: Code duplicated, block: B:26:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:27:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:30:0x02ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:34:0x0375 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0376  */
    /* JADX WARN: Code duplicated, block: B:38:0x0388  */
    /* JADX WARN: Code duplicated, block: B:43:0x0399  */
    /* JADX WARN: Code duplicated, block: B:45:0x039c  */
    /* JADX WARN: Code duplicated, block: B:48:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:52:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:55:0x041f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0420  */
    /* JADX WARN: Code duplicated, block: B:60:0x046e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0488  */
    /* JADX WARN: Code duplicated, block: B:67:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:69:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:71:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:73:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:78:0x0510  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0524  */
    /* JADX WARN: Code duplicated, block: B:86:0x0527  */
    /* JADX WARN: Code duplicated, block: B:91:0x0538 A[PHI: r6
      0x0538: PHI (r6v31 java.lang.String) = (r6v13 java.lang.String), (r6v34 java.lang.String) binds: [B:97:0x054d, B:89:0x0535] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:92:0x053a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x053c  */
    /* JADX WARN: Code duplicated, block: B:96:0x054b  */
    /* JADX WARN: Code duplicated, block: B:98:0x054f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0551  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00811 c00811;
        Object objAnilistAPICall;
        String id;
        AnilistAPIResponse.anilistMedia data;
        String anititle;
        int aniyear;
        String anititle2;
        String backgroundUrl;
        String format;
        TvType anitype;
        Object objTmdbToAnimeId;
        String anititle3;
        int aniyear2;
        String jpTitle;
        String backgroundUrl2;
        AnilistAPIResponse.anilistMedia data2;
        TvType anitype2;
        AniIds ids;
        String jpTitle2;
        String id2;
        Object obj;
        C00811 c00812;
        String posterurl;
        TvType anitype3;
        AniIds ids2;
        Object obj2;
        int aniyear3;
        AnilistAPIResponse.anilistMedia data3;
        String syncMetaData;
        MetaAnimeData animeMetaData;
        Integer tmdbid;
        String kitsuid;
        String kitsuid2;
        Integer tmdbid2;
        TvType anitype4;
        TvType type;
        String backgroundUrl3;
        String jpTitle3;
        TvType type2;
        C00811 c00813;
        AniIds ids3;
        String url2;
        int i;
        String str;
        Object objFetchTmdbLogoUrl;
        TvType anitype5;
        Integer tmdbid3;
        int aniyear4;
        TvType anitype6;
        String jpTitle4;
        MetaAnimeData animeMetaData2;
        String posterurl2;
        String syncMetaData2;
        String backgroundUrl4;
        AnilistAPIResponse.anilistMedia data4;
        String syncMetaData3;
        String posterurl3;
        String kitsuid3;
        MetaMappings mappings;
        MetaMappings mappings2;
        String themoviedbId;
        String logoUrl;
        int totalEps;
        Map destination$iv$iv;
        Iterator it;
        int iIntValue;
        String url3;
        Iterable $this$associateWith$iv;
        int $i$f$associateWith;
        Map destination$iv$iv2;
        String syncMetaData4;
        Map epMetaMap;
        final String fallbackTitle;
        final String fallbackPoster;
        String str2;
        Map<String, String> titles;
        Map<String, String> titles2;
        Integer num;
        int anidbEid;
        String href;
        Iterable $this$map$iv;
        String id3;
        AniIds ids4;
        Collection destination$iv$iv3;
        Iterable $this$mapTo$iv$iv;
        int $i$f$mapTo;
        IntIterator it2;
        Map epMetaMap2;
        String kitsuid4;
        List episodes;
        Collection destination$iv$iv4;
        int index$iv$iv;
        List episodes2;
        List episodesDub;
        int aniyear5;
        int anidbEid2;
        AnilistAPIResponse.anilistMedia data5;
        MetaAnimeData animeMetaData3;
        Object objNewAnimeLoadResponse$default;
        List episodesDub2;
        AnilistAPIResponse.anilistMedia data6;
        Object obj3;
        int totalEps2;
        int anidbEid3;
        int aniyear6;
        Map anidbEidMap;
        String href2;
        List episodes3;
        String logoUrl2;
        Map epMetaMap3;
        String kitsuid5;
        String fallbackPoster2;
        String fallbackTitle2;
        int anidbEid4;
        Object objNewMovieLoadResponse;
        C00811 c00814;
        String fallbackTitle3;
        String fallbackPoster3;
        Integer num2;
        int iIntValue2;
        Integer num3;
        int iIntValue3;
        Map<String, String> titles3;
        List<ImageData> images;
        ImageData imageData;
        int it3;
        Iterable $this$associateWith$iv2;
        Object obj4;
        Map<String, MetaEpisode> episodes4;
        Integer anidbEid5;
        String url4 = url;
        if (continuation instanceof C00811) {
            c00811 = (C00811) continuation;
            if ((c00811.label & Integer.MIN_VALUE) != 0) {
                c00811.label -= Integer.MIN_VALUE;
            } else {
                c00811 = new C00811(continuation);
            }
        } else {
            c00811 = new C00811(continuation);
        }
        C00811 c00815 = c00811;
        Object $result = c00815.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00815.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id4 = StringsKt.substringAfterLast$default(StringsKt.removeSuffix(url4, "/"), "/", (String) null, 2, (Object) null);
                c00815.L$0 = url4;
                c00815.L$1 = id4;
                c00815.label = 1;
                objAnilistAPICall = anilistAPICall("query ($id: Int = " + id4 + ") { Media(id: $id, type: ANIME) { id title { romaji english } startDate { year } genres description averageScore status bannerImage coverImage { extraLarge large medium } bannerImage episodes format nextAiringEpisode { episode } airingSchedule { nodes { episode } } recommendations { edges { node { id mediaRecommendation { id title { romaji english } coverImage { extraLarge large medium } } } } } } }", c00815);
                if (objAnilistAPICall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                id = id4;
                data = ((AnilistAPIResponse) objAnilistAPICall).getData().getMedia();
                if (data != null) {
                    throw new Exception("Unable to fetch media details");
                }
                anititle = data.m44getTitle();
                aniyear = data.getStartDate().getYear();
                anititle2 = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt = Boxing.boxInt(aniyear);
                c00815.L$0 = url4;
                c00815.L$1 = id;
                c00815.L$2 = data;
                c00815.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00815.L$4 = anititle2;
                c00815.L$5 = backgroundUrl;
                c00815.L$6 = SpillingKt.nullOutSpilledVariable(anitype);
                c00815.I$0 = aniyear;
                c00815.label = 2;
                objTmdbToAnimeId = tmdbToAnimeId(anititle, numBoxInt, anitype, c00815);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anititle3 = anititle;
                aniyear2 = aniyear;
                jpTitle = backgroundUrl;
                backgroundUrl2 = id;
                data2 = data;
                anitype2 = anitype;
                ids = (AniIds) objTmdbToAnimeId;
                String jpTitle5 = data2.getTitle().getRomaji();
                Requests app = MainActivityKt.getApp();
                String jpTitle6 = "https://api.ani.zip/mappings?anilist_id=" + backgroundUrl2;
                c00815.L$0 = url4;
                c00815.L$1 = backgroundUrl2;
                c00815.L$2 = data2;
                c00815.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00815.L$4 = anititle2;
                c00815.L$5 = jpTitle;
                c00815.L$6 = SpillingKt.nullOutSpilledVariable(anitype2);
                c00815.L$7 = ids;
                c00815.L$8 = jpTitle5;
                c00815.I$0 = aniyear2;
                c00815.label = 3;
                jpTitle2 = jpTitle5;
                id2 = backgroundUrl2;
                obj = Requests.get$default(app, jpTitle6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00815, 4094, (Object) null);
                c00812 = c00815;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                posterurl = anititle2;
                anitype3 = anitype2;
                ids2 = ids;
                obj2 = obj;
                aniyear3 = aniyear2;
                data3 = data2;
                syncMetaData = ((NiceResponse) obj2).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null || (mappings2 = animeMetaData.getMappings()) == null || (themoviedbId = mappings2.getThemoviedbId()) == null) {
                    tmdbid = null;
                } else {
                    tmdbid = StringsKt.toIntOrNull(themoviedbId);
                }
                if (animeMetaData != null || (mappings = animeMetaData.getMappings()) == null) {
                    kitsuid = null;
                } else {
                    kitsuid = mappings.getKitsuid();
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype4 = anitype3;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00812.L$0 = url4;
                c00812.L$1 = id2;
                c00812.L$2 = data3;
                c00812.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00812.L$4 = posterurl;
                c00812.L$5 = jpTitle;
                c00812.L$6 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00812.L$7 = ids2;
                c00812.L$8 = jpTitle2;
                c00812.L$9 = syncMetaData;
                c00812.L$10 = animeMetaData;
                c00812.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00812.L$12 = kitsuid2;
                c00812.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00812.I$0 = aniyear3;
                c00812.label = 4;
                backgroundUrl3 = jpTitle;
                jpTitle3 = jpTitle2;
                type2 = type;
                c00813 = c00812;
                ids3 = ids2;
                url2 = url4;
                i = 1;
                str = null;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00813);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype5 = type2;
                tmdbid3 = tmdbid2;
                aniyear4 = aniyear3;
                anitype6 = anitype4;
                jpTitle4 = jpTitle3;
                animeMetaData2 = animeMetaData;
                posterurl2 = url2;
                syncMetaData2 = id2;
                backgroundUrl4 = backgroundUrl3;
                data4 = data3;
                syncMetaData3 = syncMetaData;
                posterurl3 = posterurl;
                kitsuid3 = kitsuid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data4.totalEpisodes();
                Iterable $this$associateWith$iv3 = new IntRange(i, totalEps);
                Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv3, 10)), 16));
                destination$iv$iv = result$iv;
                it = $this$associateWith$iv3.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        url3 = posterurl2;
                        $this$associateWith$iv = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        Map result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        destination$iv$iv2 = result$iv2;
                        for (Object element$iv$iv : $this$associateWith$iv) {
                            String syncMetaData5 = syncMetaData3;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    $i$f$associateWith = $i$f$associateWith;
                                    obj4 = (MetaEpisode) episodes4.get(String.valueOf(it3));
                                }
                                destination$iv$iv2.put(element$iv$iv, obj4);
                                syncMetaData3 = syncMetaData5;
                                $this$associateWith$iv = $this$associateWith$iv2;
                                $i$f$associateWith = $i$f$associateWith;
                            } else {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                            }
                            obj4 = str;
                            destination$iv$iv2.put(element$iv$iv, obj4);
                            syncMetaData3 = syncMetaData5;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            $i$f$associateWith = $i$f$associateWith;
                        }
                        syncMetaData4 = syncMetaData3;
                        epMetaMap = destination$iv$iv2;
                        fallbackTitle = "";
                        if (animeMetaData2 != null || (images = animeMetaData2.getImages()) == null || (imageData = (ImageData) CollectionsKt.firstOrNull(images)) == null || (fallbackPoster = imageData.getUrl()) == null) {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null || (titles3 = animeMetaData2.getTitles()) == null || (str2 = titles3.get("en")) == null) {
                            if (animeMetaData2 != null || (titles2 = animeMetaData2.getTitles()) == null) {
                                str2 = str;
                            } else {
                                str2 = titles2.get("ja");
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null && (titles = animeMetaData2.getTitles()) != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        } else {
                            fallbackTitle = str2;
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), ids3.getId(), ids3.getIdMal(), data4.m44getTitle(), Boxing.boxInt(data4.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        id3 = syncMetaData2;
                        ids4 = ids3;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv = it2.nextInt();
                            Iterable $this$map$iv2 = $this$map$iv;
                            final MetaEpisode epData = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv));
                            Integer idMal = ids4.getIdMal();
                            Integer id5 = ids4.getId();
                            String strM44getTitle = data4.m44getTitle();
                            int year = data4.getStartDate().getYear();
                            Map epMetaMap4 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv), id5, idMal, strM44getTitle, Boxing.boxInt(year), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), 8245311, null));
                            destination$iv$iv3.add(MainAPIKt.newEpisode(this, linkData, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.load$lambda$3$0(item$iv$iv, epData, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            $this$map$iv = $this$map$iv2;
                            epMetaMap = epMetaMap4;
                            kitsuid3 = kitsuid3;
                        }
                        epMetaMap2 = epMetaMap;
                        kitsuid4 = kitsuid3;
                        episodes = (List) destination$iv$iv3;
                        List $this$mapIndexed$iv = episodes;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                        index$iv$iv = 0;
                        for (Object item$iv$iv2 : $this$mapIndexed$iv) {
                            int index$iv$iv2 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep = (Episode) item$iv$iv2;
                            int i2 = index$iv$iv + 1;
                            Integer idMal2 = ids4.getIdMal();
                            Integer id6 = ids4.getId();
                            String strM44getTitle2 = data4.m44getTitle();
                            int year2 = data4.getStartDate().getYear();
                            List episodes5 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i2));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i2), id6, idMal2, strM44getTitle2, Boxing.boxInt(year2), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), 8245311, null));
                            destination$iv$iv4.add(Episode.copy$default(ep, dubLinkData, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes5;
                            index$iv$iv = index$iv$iv2;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv4;
                        if (StringsKt.contains(data4.getFormat(), "Movie", true)) {
                            String strM44getTitle3 = data4.m44getTitle();
                            fallbackPoster2 = fallbackPoster;
                            TvType tvType = TvType.AnimeMovie;
                            C00822 c00822 = new C00822(id3, ids4, kitsuid4, data4, backgroundUrl4, animeMetaData2, posterurl3, logoUrl, null);
                            c00813.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00813.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00813.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00813.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                            c00813.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                            c00813.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00813.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                            c00813.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00813.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00813.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                            c00813.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00813.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                            c00813.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00813.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                            c00813.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00813.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00813.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00813.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster2);
                            c00813.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle);
                            c00813.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00813.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00813.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00813.I$0 = aniyear4;
                            c00813.I$1 = totalEps;
                            c00813.I$2 = anidbEid;
                            c00813.label = 5;
                            C00811 c00816 = c00813;
                            fallbackTitle2 = fallbackTitle;
                            anidbEid4 = anidbEid;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM44getTitle3, url3, tvType, href, c00822, c00816);
                            c00814 = c00816;
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fallbackTitle3 = fallbackTitle2;
                            fallbackPoster3 = fallbackPoster2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        aniyear5 = aniyear4;
                        String fallbackTitle4 = fallbackTitle;
                        anidbEid2 = anidbEid;
                        String strM44getTitle4 = data4.m44getTitle();
                        TvType tvType2 = TvType.Anime;
                        data5 = data4;
                        C00811 c00817 = c00813;
                        MetaAnimeData animeMetaData4 = animeMetaData2;
                        C00833 c00833 = new C00833(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data5, animeMetaData4, this, null);
                        animeMetaData3 = animeMetaData4;
                        c00817.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00817.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00817.L$2 = SpillingKt.nullOutSpilledVariable(data5);
                        c00817.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                        c00817.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                        c00817.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                        c00817.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                        c00817.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00817.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00817.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                        c00817.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData3);
                        c00817.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                        c00817.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00817.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                        c00817.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00817.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00817.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00817.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                        c00817.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle4);
                        c00817.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00817.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00817.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00817.I$0 = aniyear5;
                        c00817.I$1 = totalEps;
                        c00817.I$2 = anidbEid2;
                        c00817.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM44getTitle4, url3, tvType2, false, c00833, c00817, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesDub2 = episodesDub;
                        data6 = data5;
                        obj3 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        aniyear6 = aniyear5;
                        anidbEidMap = destination$iv$iv;
                        href2 = href;
                        episodes3 = episodes2;
                        logoUrl2 = logoUrl;
                        epMetaMap3 = epMetaMap2;
                        kitsuid5 = kitsuid4;
                        return (LoadResponse) obj3;
                    }
                    Object element$iv$iv2 = it.next();
                    int it4 = ((Number) element$iv$iv2).intValue();
                    String url5 = posterurl2;
                    anidbEid5 = StreamPlayUtilsKt.getAnidbEid(syncMetaData3, Boxing.boxInt(it4));
                    if (anidbEid5 != null) {
                        iIntValue = anidbEid5.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv2, Boxing.boxInt(iIntValue));
                    posterurl2 = url5;
                }
                break;
            case 1:
                String id7 = (String) c00815.L$1;
                url4 = (String) c00815.L$0;
                ResultKt.throwOnFailure($result);
                objAnilistAPICall = $result;
                id = id7;
                data = ((AnilistAPIResponse) objAnilistAPICall).getData().getMedia();
                if (data != null) {
                    throw new Exception("Unable to fetch media details");
                }
                anititle = data.m44getTitle();
                aniyear = data.getStartDate().getYear();
                anititle2 = data.getCoverImage().getExtraLarge();
                backgroundUrl = data.getBannerImage();
                format = data.getFormat();
                Intrinsics.checkNotNull(format);
                if (StringsKt.contains(format, "MOVIE", true)) {
                    anitype = TvType.AnimeMovie;
                } else {
                    anitype = TvType.TvSeries;
                }
                Integer numBoxInt2 = Boxing.boxInt(aniyear);
                c00815.L$0 = url4;
                c00815.L$1 = id;
                c00815.L$2 = data;
                c00815.L$3 = SpillingKt.nullOutSpilledVariable(anititle);
                c00815.L$4 = anititle2;
                c00815.L$5 = backgroundUrl;
                c00815.L$6 = SpillingKt.nullOutSpilledVariable(anitype);
                c00815.I$0 = aniyear;
                c00815.label = 2;
                objTmdbToAnimeId = tmdbToAnimeId(anititle, numBoxInt2, anitype, c00815);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anititle3 = anititle;
                aniyear2 = aniyear;
                jpTitle = backgroundUrl;
                backgroundUrl2 = id;
                data2 = data;
                anitype2 = anitype;
                ids = (AniIds) objTmdbToAnimeId;
                String jpTitle7 = data2.getTitle().getRomaji();
                Requests app2 = MainActivityKt.getApp();
                String jpTitle8 = "https://api.ani.zip/mappings?anilist_id=" + backgroundUrl2;
                c00815.L$0 = url4;
                c00815.L$1 = backgroundUrl2;
                c00815.L$2 = data2;
                c00815.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00815.L$4 = anititle2;
                c00815.L$5 = jpTitle;
                c00815.L$6 = SpillingKt.nullOutSpilledVariable(anitype2);
                c00815.L$7 = ids;
                c00815.L$8 = jpTitle7;
                c00815.I$0 = aniyear2;
                c00815.label = 3;
                jpTitle2 = jpTitle7;
                id2 = backgroundUrl2;
                obj = Requests.get$default(app2, jpTitle8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00815, 4094, (Object) null);
                c00812 = c00815;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                posterurl = anititle2;
                anitype3 = anitype2;
                ids2 = ids;
                obj2 = obj;
                aniyear3 = aniyear2;
                data3 = data2;
                syncMetaData = ((NiceResponse) obj2).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                if (animeMetaData != null) {
                    kitsuid = null;
                } else {
                    kitsuid = null;
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype4 = anitype3;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00812.L$0 = url4;
                c00812.L$1 = id2;
                c00812.L$2 = data3;
                c00812.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00812.L$4 = posterurl;
                c00812.L$5 = jpTitle;
                c00812.L$6 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00812.L$7 = ids2;
                c00812.L$8 = jpTitle2;
                c00812.L$9 = syncMetaData;
                c00812.L$10 = animeMetaData;
                c00812.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00812.L$12 = kitsuid2;
                c00812.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00812.I$0 = aniyear3;
                c00812.label = 4;
                backgroundUrl3 = jpTitle;
                jpTitle3 = jpTitle2;
                type2 = type;
                c00813 = c00812;
                ids3 = ids2;
                url2 = url4;
                i = 1;
                str = null;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00813);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype5 = type2;
                tmdbid3 = tmdbid2;
                aniyear4 = aniyear3;
                anitype6 = anitype4;
                jpTitle4 = jpTitle3;
                animeMetaData2 = animeMetaData;
                posterurl2 = url2;
                syncMetaData2 = id2;
                backgroundUrl4 = backgroundUrl3;
                data4 = data3;
                syncMetaData3 = syncMetaData;
                posterurl3 = posterurl;
                kitsuid3 = kitsuid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data4.totalEpisodes();
                Iterable $this$associateWith$iv4 = new IntRange(i, totalEps);
                Map result$iv3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv4, 10)), 16));
                destination$iv$iv = result$iv3;
                it = $this$associateWith$iv4.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        url3 = posterurl2;
                        $this$associateWith$iv = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        Map result$iv4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        destination$iv$iv2 = result$iv4;
                        while (r24.hasNext()) {
                            String syncMetaData6 = syncMetaData3;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    $i$f$associateWith = $i$f$associateWith;
                                    obj4 = (MetaEpisode) episodes4.get(String.valueOf(it3));
                                }
                                destination$iv$iv2.put(element$iv$iv, obj4);
                                syncMetaData3 = syncMetaData6;
                                $this$associateWith$iv = $this$associateWith$iv2;
                                $i$f$associateWith = $i$f$associateWith;
                            } else {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                            }
                            obj4 = str;
                            destination$iv$iv2.put(element$iv$iv, obj4);
                            syncMetaData3 = syncMetaData6;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            $i$f$associateWith = $i$f$associateWith;
                        }
                        syncMetaData4 = syncMetaData3;
                        epMetaMap = destination$iv$iv2;
                        fallbackTitle = "";
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), ids3.getId(), ids3.getIdMal(), data4.m44getTitle(), Boxing.boxInt(data4.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        id3 = syncMetaData2;
                        ids4 = ids3;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv3 = it2.nextInt();
                            Iterable $this$map$iv3 = $this$map$iv;
                            final MetaEpisode epData2 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv3));
                            Integer idMal3 = ids4.getIdMal();
                            Integer id8 = ids4.getId();
                            String strM44getTitle5 = data4.m44getTitle();
                            int year3 = data4.getStartDate().getYear();
                            Map epMetaMap5 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv3));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData2 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv3), id8, idMal3, strM44getTitle5, Boxing.boxInt(year3), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), 8245311, null));
                            destination$iv$iv3.add(MainAPIKt.newEpisode(this, linkData2, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.load$lambda$3$0(item$iv$iv3, epData2, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            $this$map$iv = $this$map$iv3;
                            epMetaMap = epMetaMap5;
                            kitsuid3 = kitsuid3;
                        }
                        epMetaMap2 = epMetaMap;
                        kitsuid4 = kitsuid3;
                        episodes = (List) destination$iv$iv3;
                        List $this$mapIndexed$iv2 = episodes;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
                        index$iv$iv = 0;
                        while (r33.hasNext()) {
                            int index$iv$iv3 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep2 = (Episode) item$iv$iv2;
                            int i3 = index$iv$iv + 1;
                            Integer idMal4 = ids4.getIdMal();
                            Integer id9 = ids4.getId();
                            String strM44getTitle6 = data4.m44getTitle();
                            int year4 = data4.getStartDate().getYear();
                            List episodes6 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i3));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData2 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i3), id9, idMal4, strM44getTitle6, Boxing.boxInt(year4), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), 8245311, null));
                            destination$iv$iv4.add(Episode.copy$default(ep2, dubLinkData2, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes6;
                            index$iv$iv = index$iv$iv3;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv4;
                        if (StringsKt.contains(data4.getFormat(), "Movie", true)) {
                            String strM44getTitle7 = data4.m44getTitle();
                            fallbackPoster2 = fallbackPoster;
                            TvType tvType3 = TvType.AnimeMovie;
                            C00822 c00823 = new C00822(id3, ids4, kitsuid4, data4, backgroundUrl4, animeMetaData2, posterurl3, logoUrl, null);
                            c00813.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00813.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00813.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00813.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                            c00813.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                            c00813.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00813.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                            c00813.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00813.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00813.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                            c00813.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00813.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                            c00813.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00813.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                            c00813.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00813.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00813.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00813.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster2);
                            c00813.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle);
                            c00813.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00813.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00813.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00813.I$0 = aniyear4;
                            c00813.I$1 = totalEps;
                            c00813.I$2 = anidbEid;
                            c00813.label = 5;
                            C00811 c00818 = c00813;
                            fallbackTitle2 = fallbackTitle;
                            anidbEid4 = anidbEid;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM44getTitle7, url3, tvType3, href, c00823, c00818);
                            c00814 = c00818;
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fallbackTitle3 = fallbackTitle2;
                            fallbackPoster3 = fallbackPoster2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        aniyear5 = aniyear4;
                        String fallbackTitle5 = fallbackTitle;
                        anidbEid2 = anidbEid;
                        String strM44getTitle8 = data4.m44getTitle();
                        TvType tvType4 = TvType.Anime;
                        data5 = data4;
                        C00811 c00819 = c00813;
                        MetaAnimeData animeMetaData5 = animeMetaData2;
                        C00833 c00834 = new C00833(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data5, animeMetaData5, this, null);
                        animeMetaData3 = animeMetaData5;
                        c00819.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00819.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c00819.L$2 = SpillingKt.nullOutSpilledVariable(data5);
                        c00819.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                        c00819.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                        c00819.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                        c00819.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                        c00819.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c00819.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c00819.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                        c00819.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData3);
                        c00819.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                        c00819.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c00819.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                        c00819.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c00819.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c00819.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c00819.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                        c00819.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle5);
                        c00819.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c00819.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00819.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c00819.I$0 = aniyear5;
                        c00819.I$1 = totalEps;
                        c00819.I$2 = anidbEid2;
                        c00819.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM44getTitle8, url3, tvType4, false, c00834, c00819, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesDub2 = episodesDub;
                        data6 = data5;
                        obj3 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        aniyear6 = aniyear5;
                        anidbEidMap = destination$iv$iv;
                        href2 = href;
                        episodes3 = episodes2;
                        logoUrl2 = logoUrl;
                        epMetaMap3 = epMetaMap2;
                        kitsuid5 = kitsuid4;
                        return (LoadResponse) obj3;
                    }
                    Object element$iv$iv3 = it.next();
                    int it5 = ((Number) element$iv$iv3).intValue();
                    String url6 = posterurl2;
                    anidbEid5 = StreamPlayUtilsKt.getAnidbEid(syncMetaData3, Boxing.boxInt(it5));
                    if (anidbEid5 != null) {
                        iIntValue = anidbEid5.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv3, Boxing.boxInt(iIntValue));
                    posterurl2 = url6;
                }
                break;
            case 2:
                aniyear2 = c00815.I$0;
                TvType anitype7 = (TvType) c00815.L$6;
                String backgroundUrl5 = (String) c00815.L$5;
                String posterurl4 = (String) c00815.L$4;
                String anititle4 = (String) c00815.L$3;
                AnilistAPIResponse.anilistMedia data7 = (AnilistAPIResponse.anilistMedia) c00815.L$2;
                String id10 = (String) c00815.L$1;
                url4 = (String) c00815.L$0;
                ResultKt.throwOnFailure($result);
                anititle3 = anititle4;
                backgroundUrl2 = id10;
                anititle2 = posterurl4;
                data2 = data7;
                anitype2 = anitype7;
                jpTitle = backgroundUrl5;
                objTmdbToAnimeId = $result;
                ids = (AniIds) objTmdbToAnimeId;
                String jpTitle9 = data2.getTitle().getRomaji();
                Requests app3 = MainActivityKt.getApp();
                String jpTitle10 = "https://api.ani.zip/mappings?anilist_id=" + backgroundUrl2;
                c00815.L$0 = url4;
                c00815.L$1 = backgroundUrl2;
                c00815.L$2 = data2;
                c00815.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00815.L$4 = anititle2;
                c00815.L$5 = jpTitle;
                c00815.L$6 = SpillingKt.nullOutSpilledVariable(anitype2);
                c00815.L$7 = ids;
                c00815.L$8 = jpTitle9;
                c00815.I$0 = aniyear2;
                c00815.label = 3;
                jpTitle2 = jpTitle9;
                id2 = backgroundUrl2;
                obj = Requests.get$default(app3, jpTitle10, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00815, 4094, (Object) null);
                c00812 = c00815;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                posterurl = anititle2;
                anitype3 = anitype2;
                ids2 = ids;
                obj2 = obj;
                aniyear3 = aniyear2;
                data3 = data2;
                syncMetaData = ((NiceResponse) obj2).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                if (animeMetaData != null) {
                    kitsuid = null;
                } else {
                    kitsuid = null;
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype4 = anitype3;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00812.L$0 = url4;
                c00812.L$1 = id2;
                c00812.L$2 = data3;
                c00812.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00812.L$4 = posterurl;
                c00812.L$5 = jpTitle;
                c00812.L$6 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00812.L$7 = ids2;
                c00812.L$8 = jpTitle2;
                c00812.L$9 = syncMetaData;
                c00812.L$10 = animeMetaData;
                c00812.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00812.L$12 = kitsuid2;
                c00812.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00812.I$0 = aniyear3;
                c00812.label = 4;
                backgroundUrl3 = jpTitle;
                jpTitle3 = jpTitle2;
                type2 = type;
                c00813 = c00812;
                ids3 = ids2;
                url2 = url4;
                i = 1;
                str = null;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00813);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype5 = type2;
                tmdbid3 = tmdbid2;
                aniyear4 = aniyear3;
                anitype6 = anitype4;
                jpTitle4 = jpTitle3;
                animeMetaData2 = animeMetaData;
                posterurl2 = url2;
                syncMetaData2 = id2;
                backgroundUrl4 = backgroundUrl3;
                data4 = data3;
                syncMetaData3 = syncMetaData;
                posterurl3 = posterurl;
                kitsuid3 = kitsuid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data4.totalEpisodes();
                Iterable $this$associateWith$iv5 = new IntRange(i, totalEps);
                Map result$iv5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv5, 10)), 16));
                destination$iv$iv = result$iv5;
                it = $this$associateWith$iv5.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        url3 = posterurl2;
                        $this$associateWith$iv = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        Map result$iv6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        destination$iv$iv2 = result$iv6;
                        while (r24.hasNext()) {
                            String syncMetaData7 = syncMetaData3;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    $i$f$associateWith = $i$f$associateWith;
                                    obj4 = (MetaEpisode) episodes4.get(String.valueOf(it3));
                                }
                                destination$iv$iv2.put(element$iv$iv, obj4);
                                syncMetaData3 = syncMetaData7;
                                $this$associateWith$iv = $this$associateWith$iv2;
                                $i$f$associateWith = $i$f$associateWith;
                            } else {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                            }
                            obj4 = str;
                            destination$iv$iv2.put(element$iv$iv, obj4);
                            syncMetaData3 = syncMetaData7;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            $i$f$associateWith = $i$f$associateWith;
                        }
                        syncMetaData4 = syncMetaData3;
                        epMetaMap = destination$iv$iv2;
                        fallbackTitle = "";
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), ids3.getId(), ids3.getIdMal(), data4.m44getTitle(), Boxing.boxInt(data4.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        id3 = syncMetaData2;
                        ids4 = ids3;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv4 = it2.nextInt();
                            Iterable $this$map$iv4 = $this$map$iv;
                            final MetaEpisode epData3 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv4));
                            Integer idMal5 = ids4.getIdMal();
                            Integer id11 = ids4.getId();
                            String strM44getTitle9 = data4.m44getTitle();
                            int year5 = data4.getStartDate().getYear();
                            Map epMetaMap6 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv4));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData3 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv4), id11, idMal5, strM44getTitle9, Boxing.boxInt(year5), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), 8245311, null));
                            destination$iv$iv3.add(MainAPIKt.newEpisode(this, linkData3, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.load$lambda$3$0(item$iv$iv4, epData3, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            $this$map$iv = $this$map$iv4;
                            epMetaMap = epMetaMap6;
                            kitsuid3 = kitsuid3;
                        }
                        epMetaMap2 = epMetaMap;
                        kitsuid4 = kitsuid3;
                        episodes = (List) destination$iv$iv3;
                        List $this$mapIndexed$iv3 = episodes;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv3, 10));
                        index$iv$iv = 0;
                        while (r33.hasNext()) {
                            int index$iv$iv4 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep3 = (Episode) item$iv$iv2;
                            int i4 = index$iv$iv + 1;
                            Integer idMal6 = ids4.getIdMal();
                            Integer id12 = ids4.getId();
                            String strM44getTitle10 = data4.m44getTitle();
                            int year6 = data4.getStartDate().getYear();
                            List episodes7 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i4));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData3 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i4), id12, idMal6, strM44getTitle10, Boxing.boxInt(year6), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), 8245311, null));
                            destination$iv$iv4.add(Episode.copy$default(ep3, dubLinkData3, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes7;
                            index$iv$iv = index$iv$iv4;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv4;
                        if (StringsKt.contains(data4.getFormat(), "Movie", true)) {
                            String strM44getTitle11 = data4.m44getTitle();
                            fallbackPoster2 = fallbackPoster;
                            TvType tvType5 = TvType.AnimeMovie;
                            C00822 c00824 = new C00822(id3, ids4, kitsuid4, data4, backgroundUrl4, animeMetaData2, posterurl3, logoUrl, null);
                            c00813.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00813.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00813.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00813.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                            c00813.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                            c00813.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00813.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                            c00813.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00813.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00813.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                            c00813.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00813.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                            c00813.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00813.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                            c00813.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00813.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00813.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00813.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster2);
                            c00813.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle);
                            c00813.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00813.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00813.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00813.I$0 = aniyear4;
                            c00813.I$1 = totalEps;
                            c00813.I$2 = anidbEid;
                            c00813.label = 5;
                            C00811 c008110 = c00813;
                            fallbackTitle2 = fallbackTitle;
                            anidbEid4 = anidbEid;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM44getTitle11, url3, tvType5, href, c00824, c008110);
                            c00814 = c008110;
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fallbackTitle3 = fallbackTitle2;
                            fallbackPoster3 = fallbackPoster2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        aniyear5 = aniyear4;
                        String fallbackTitle6 = fallbackTitle;
                        anidbEid2 = anidbEid;
                        String strM44getTitle12 = data4.m44getTitle();
                        TvType tvType6 = TvType.Anime;
                        data5 = data4;
                        C00811 c008111 = c00813;
                        MetaAnimeData animeMetaData6 = animeMetaData2;
                        C00833 c00835 = new C00833(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data5, animeMetaData6, this, null);
                        animeMetaData3 = animeMetaData6;
                        c008111.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c008111.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c008111.L$2 = SpillingKt.nullOutSpilledVariable(data5);
                        c008111.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                        c008111.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                        c008111.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                        c008111.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                        c008111.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c008111.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c008111.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                        c008111.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData3);
                        c008111.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                        c008111.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c008111.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                        c008111.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c008111.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c008111.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c008111.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                        c008111.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle6);
                        c008111.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c008111.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c008111.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c008111.I$0 = aniyear5;
                        c008111.I$1 = totalEps;
                        c008111.I$2 = anidbEid2;
                        c008111.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM44getTitle12, url3, tvType6, false, c00835, c008111, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesDub2 = episodesDub;
                        data6 = data5;
                        obj3 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        aniyear6 = aniyear5;
                        anidbEidMap = destination$iv$iv;
                        href2 = href;
                        episodes3 = episodes2;
                        logoUrl2 = logoUrl;
                        epMetaMap3 = epMetaMap2;
                        kitsuid5 = kitsuid4;
                        return (LoadResponse) obj3;
                    }
                    Object element$iv$iv4 = it.next();
                    int it6 = ((Number) element$iv$iv4).intValue();
                    String url7 = posterurl2;
                    anidbEid5 = StreamPlayUtilsKt.getAnidbEid(syncMetaData3, Boxing.boxInt(it6));
                    if (anidbEid5 != null) {
                        iIntValue = anidbEid5.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv4, Boxing.boxInt(iIntValue));
                    posterurl2 = url7;
                }
                break;
            case 3:
                int aniyear7 = c00815.I$0;
                String jpTitle11 = (String) c00815.L$8;
                AniIds ids5 = (AniIds) c00815.L$7;
                TvType anitype8 = (TvType) c00815.L$6;
                String backgroundUrl6 = (String) c00815.L$5;
                String posterurl5 = (String) c00815.L$4;
                String anititle5 = (String) c00815.L$3;
                AnilistAPIResponse.anilistMedia data8 = (AnilistAPIResponse.anilistMedia) c00815.L$2;
                String id13 = (String) c00815.L$1;
                url4 = (String) c00815.L$0;
                ResultKt.throwOnFailure($result);
                aniyear3 = aniyear7;
                data3 = data8;
                c00812 = c00815;
                id2 = id13;
                anitype3 = anitype8;
                posterurl = posterurl5;
                anititle3 = anititle5;
                jpTitle2 = jpTitle11;
                jpTitle = backgroundUrl6;
                ids2 = ids5;
                obj2 = $result;
                syncMetaData = ((NiceResponse) obj2).getText();
                animeMetaData = StreamPlayUtilsKt.parseAnimeData(syncMetaData);
                if (animeMetaData != null) {
                    tmdbid = null;
                } else {
                    tmdbid = null;
                }
                if (animeMetaData != null) {
                    kitsuid = null;
                } else {
                    kitsuid = null;
                }
                kitsuid2 = kitsuid;
                tmdbid2 = tmdbid;
                anitype4 = anitype3;
                if (StringsKt.contains(data3.getFormat(), "Movie", true)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                c00812.L$0 = url4;
                c00812.L$1 = id2;
                c00812.L$2 = data3;
                c00812.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                c00812.L$4 = posterurl;
                c00812.L$5 = jpTitle;
                c00812.L$6 = SpillingKt.nullOutSpilledVariable(anitype4);
                c00812.L$7 = ids2;
                c00812.L$8 = jpTitle2;
                c00812.L$9 = syncMetaData;
                c00812.L$10 = animeMetaData;
                c00812.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid2);
                c00812.L$12 = kitsuid2;
                c00812.L$13 = SpillingKt.nullOutSpilledVariable(type);
                c00812.I$0 = aniyear3;
                c00812.label = 4;
                backgroundUrl3 = jpTitle;
                jpTitle3 = jpTitle2;
                type2 = type;
                c00813 = c00812;
                ids3 = ids2;
                url2 = url4;
                i = 1;
                str = null;
                objFetchTmdbLogoUrl = StreamPlayUtilsKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "98ae14df2b8d8f8f8136499daf79f0e0", type2, tmdbid2, "en", c00813);
                if (objFetchTmdbLogoUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anitype5 = type2;
                tmdbid3 = tmdbid2;
                aniyear4 = aniyear3;
                anitype6 = anitype4;
                jpTitle4 = jpTitle3;
                animeMetaData2 = animeMetaData;
                posterurl2 = url2;
                syncMetaData2 = id2;
                backgroundUrl4 = backgroundUrl3;
                data4 = data3;
                syncMetaData3 = syncMetaData;
                posterurl3 = posterurl;
                kitsuid3 = kitsuid2;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data4.totalEpisodes();
                Iterable $this$associateWith$iv6 = new IntRange(i, totalEps);
                Map result$iv7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv6, 10)), 16));
                destination$iv$iv = result$iv7;
                it = $this$associateWith$iv6.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        url3 = posterurl2;
                        $this$associateWith$iv = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        Map result$iv8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        destination$iv$iv2 = result$iv8;
                        while (r24.hasNext()) {
                            String syncMetaData8 = syncMetaData3;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    $i$f$associateWith = $i$f$associateWith;
                                    obj4 = (MetaEpisode) episodes4.get(String.valueOf(it3));
                                }
                                destination$iv$iv2.put(element$iv$iv, obj4);
                                syncMetaData3 = syncMetaData8;
                                $this$associateWith$iv = $this$associateWith$iv2;
                                $i$f$associateWith = $i$f$associateWith;
                            } else {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                            }
                            obj4 = str;
                            destination$iv$iv2.put(element$iv$iv, obj4);
                            syncMetaData3 = syncMetaData8;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            $i$f$associateWith = $i$f$associateWith;
                        }
                        syncMetaData4 = syncMetaData3;
                        epMetaMap = destination$iv$iv2;
                        fallbackTitle = "";
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), ids3.getId(), ids3.getIdMal(), data4.m44getTitle(), Boxing.boxInt(data4.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        id3 = syncMetaData2;
                        ids4 = ids3;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv5 = it2.nextInt();
                            Iterable $this$map$iv5 = $this$map$iv;
                            final MetaEpisode epData4 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv5));
                            Integer idMal7 = ids4.getIdMal();
                            Integer id14 = ids4.getId();
                            String strM44getTitle13 = data4.m44getTitle();
                            int year7 = data4.getStartDate().getYear();
                            Map epMetaMap7 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv5));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData4 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv5), id14, idMal7, strM44getTitle13, Boxing.boxInt(year7), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), 8245311, null));
                            destination$iv$iv3.add(MainAPIKt.newEpisode(this, linkData4, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.load$lambda$3$0(item$iv$iv5, epData4, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            $this$map$iv = $this$map$iv5;
                            epMetaMap = epMetaMap7;
                            kitsuid3 = kitsuid3;
                        }
                        epMetaMap2 = epMetaMap;
                        kitsuid4 = kitsuid3;
                        episodes = (List) destination$iv$iv3;
                        List $this$mapIndexed$iv4 = episodes;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv4, 10));
                        index$iv$iv = 0;
                        while (r33.hasNext()) {
                            int index$iv$iv5 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep4 = (Episode) item$iv$iv2;
                            int i5 = index$iv$iv + 1;
                            Integer idMal8 = ids4.getIdMal();
                            Integer id15 = ids4.getId();
                            String strM44getTitle14 = data4.m44getTitle();
                            int year8 = data4.getStartDate().getYear();
                            List episodes8 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i5));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData4 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i5), id15, idMal8, strM44getTitle14, Boxing.boxInt(year8), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), 8245311, null));
                            destination$iv$iv4.add(Episode.copy$default(ep4, dubLinkData4, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes8;
                            index$iv$iv = index$iv$iv5;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv4;
                        if (StringsKt.contains(data4.getFormat(), "Movie", true)) {
                            String strM44getTitle15 = data4.m44getTitle();
                            fallbackPoster2 = fallbackPoster;
                            TvType tvType7 = TvType.AnimeMovie;
                            C00822 c00825 = new C00822(id3, ids4, kitsuid4, data4, backgroundUrl4, animeMetaData2, posterurl3, logoUrl, null);
                            c00813.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00813.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00813.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00813.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                            c00813.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                            c00813.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00813.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                            c00813.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00813.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00813.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                            c00813.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00813.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                            c00813.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00813.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                            c00813.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00813.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00813.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00813.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster2);
                            c00813.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle);
                            c00813.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00813.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00813.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00813.I$0 = aniyear4;
                            c00813.I$1 = totalEps;
                            c00813.I$2 = anidbEid;
                            c00813.label = 5;
                            C00811 c008112 = c00813;
                            fallbackTitle2 = fallbackTitle;
                            anidbEid4 = anidbEid;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM44getTitle15, url3, tvType7, href, c00825, c008112);
                            c00814 = c008112;
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fallbackTitle3 = fallbackTitle2;
                            fallbackPoster3 = fallbackPoster2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        aniyear5 = aniyear4;
                        String fallbackTitle7 = fallbackTitle;
                        anidbEid2 = anidbEid;
                        String strM44getTitle16 = data4.m44getTitle();
                        TvType tvType8 = TvType.Anime;
                        data5 = data4;
                        C00811 c008113 = c00813;
                        MetaAnimeData animeMetaData7 = animeMetaData2;
                        C00833 c00836 = new C00833(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data5, animeMetaData7, this, null);
                        animeMetaData3 = animeMetaData7;
                        c008113.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c008113.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c008113.L$2 = SpillingKt.nullOutSpilledVariable(data5);
                        c008113.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                        c008113.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                        c008113.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                        c008113.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                        c008113.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c008113.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c008113.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                        c008113.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData3);
                        c008113.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                        c008113.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c008113.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                        c008113.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c008113.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c008113.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c008113.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                        c008113.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle7);
                        c008113.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c008113.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c008113.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c008113.I$0 = aniyear5;
                        c008113.I$1 = totalEps;
                        c008113.I$2 = anidbEid2;
                        c008113.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM44getTitle16, url3, tvType8, false, c00836, c008113, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesDub2 = episodesDub;
                        data6 = data5;
                        obj3 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        aniyear6 = aniyear5;
                        anidbEidMap = destination$iv$iv;
                        href2 = href;
                        episodes3 = episodes2;
                        logoUrl2 = logoUrl;
                        epMetaMap3 = epMetaMap2;
                        kitsuid5 = kitsuid4;
                        return (LoadResponse) obj3;
                    }
                    Object element$iv$iv5 = it.next();
                    int it7 = ((Number) element$iv$iv5).intValue();
                    String url8 = posterurl2;
                    anidbEid5 = StreamPlayUtilsKt.getAnidbEid(syncMetaData3, Boxing.boxInt(it7));
                    if (anidbEid5 != null) {
                        iIntValue = anidbEid5.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv5, Boxing.boxInt(iIntValue));
                    posterurl2 = url8;
                }
                break;
            case 4:
                int aniyear8 = c00815.I$0;
                TvType type3 = (TvType) c00815.L$13;
                String kitsuid6 = (String) c00815.L$12;
                Integer tmdbid4 = (Integer) c00815.L$11;
                MetaAnimeData animeMetaData8 = (MetaAnimeData) c00815.L$10;
                String syncMetaData9 = (String) c00815.L$9;
                String jpTitle12 = (String) c00815.L$8;
                AniIds ids6 = (AniIds) c00815.L$7;
                TvType anitype9 = (TvType) c00815.L$6;
                String backgroundUrl7 = (String) c00815.L$5;
                String posterurl6 = (String) c00815.L$4;
                String anititle6 = (String) c00815.L$3;
                AnilistAPIResponse.anilistMedia data9 = (AnilistAPIResponse.anilistMedia) c00815.L$2;
                String id16 = (String) c00815.L$1;
                String url9 = (String) c00815.L$0;
                ResultKt.throwOnFailure($result);
                anitype5 = type3;
                tmdbid3 = tmdbid4;
                syncMetaData3 = syncMetaData9;
                jpTitle4 = jpTitle12;
                ids3 = ids6;
                anitype6 = anitype9;
                anititle3 = anititle6;
                data4 = data9;
                syncMetaData2 = id16;
                objFetchTmdbLogoUrl = $result;
                str = null;
                kitsuid3 = kitsuid6;
                posterurl3 = posterurl6;
                animeMetaData2 = animeMetaData8;
                c00813 = c00815;
                aniyear4 = aniyear8;
                posterurl2 = url9;
                backgroundUrl4 = backgroundUrl7;
                i = 1;
                logoUrl = (String) objFetchTmdbLogoUrl;
                totalEps = data4.totalEpisodes();
                Iterable $this$associateWith$iv7 = new IntRange(i, totalEps);
                Map result$iv9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv7, 10)), 16));
                destination$iv$iv = result$iv9;
                it = $this$associateWith$iv7.iterator();
                while (true) {
                    iIntValue = 0;
                    if (!it.hasNext()) {
                        url3 = posterurl2;
                        $this$associateWith$iv = new IntRange(1, totalEps);
                        $i$f$associateWith = 0;
                        Map result$iv10 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
                        destination$iv$iv2 = result$iv10;
                        while (r24.hasNext()) {
                            String syncMetaData10 = syncMetaData3;
                            it3 = ((Number) element$iv$iv).intValue();
                            if (animeMetaData2 != null) {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                                episodes4 = animeMetaData2.getEpisodes();
                                if (episodes4 != null) {
                                    $i$f$associateWith = $i$f$associateWith;
                                    obj4 = (MetaEpisode) episodes4.get(String.valueOf(it3));
                                }
                                destination$iv$iv2.put(element$iv$iv, obj4);
                                syncMetaData3 = syncMetaData10;
                                $this$associateWith$iv = $this$associateWith$iv2;
                                $i$f$associateWith = $i$f$associateWith;
                            } else {
                                $this$associateWith$iv2 = $this$associateWith$iv;
                            }
                            obj4 = str;
                            destination$iv$iv2.put(element$iv$iv, obj4);
                            syncMetaData3 = syncMetaData10;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            $i$f$associateWith = $i$f$associateWith;
                        }
                        syncMetaData4 = syncMetaData3;
                        epMetaMap = destination$iv$iv2;
                        fallbackTitle = "";
                        if (animeMetaData2 != null) {
                            fallbackPoster = "";
                        } else {
                            fallbackPoster = "";
                        }
                        if (animeMetaData2 != null) {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        } else {
                            if (animeMetaData2 != null) {
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 == null) {
                                if (animeMetaData2 != null) {
                                    str = titles.get("x-jat");
                                }
                                if (str != null) {
                                    fallbackTitle = str;
                                }
                            } else {
                                fallbackTitle = str2;
                            }
                        }
                        num = (Integer) destination$iv$iv.get(Boxing.boxInt(1));
                        if (num != null) {
                            anidbEid = num.intValue();
                        } else {
                            anidbEid = 0;
                        }
                        href = toStringData(new LinkData(null, null, null, null, null, null, null, Boxing.boxInt(1), ids3.getId(), ids3.getIdMal(), data4.m44getTitle(), Boxing.boxInt(data4.getStartDate().getYear()), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(anidbEid), 16633983, null));
                        $this$map$iv = new IntRange(1, totalEps);
                        id3 = syncMetaData2;
                        ids4 = ids3;
                        destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        $this$mapTo$iv$iv = $this$map$iv;
                        $i$f$mapTo = 0;
                        it2 = $this$mapTo$iv$iv.iterator();
                        while (it2.hasNext()) {
                            final int item$iv$iv6 = it2.nextInt();
                            Iterable $this$map$iv6 = $this$map$iv;
                            final MetaEpisode epData5 = (MetaEpisode) epMetaMap.get(Boxing.boxInt(item$iv$iv6));
                            Integer idMal9 = ids4.getIdMal();
                            Integer id17 = ids4.getId();
                            String strM44getTitle17 = data4.m44getTitle();
                            int year9 = data4.getStartDate().getYear();
                            Map epMetaMap8 = epMetaMap;
                            num3 = (Integer) destination$iv$iv.get(Boxing.boxInt(item$iv$iv6));
                            if (num3 != null) {
                                iIntValue3 = num3.intValue();
                            } else {
                                iIntValue3 = 0;
                            }
                            String linkData5 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(item$iv$iv6), id17, idMal9, strM44getTitle17, Boxing.boxInt(year9), null, true, null, null, null, jpTitle4, null, null, false, false, false, false, Boxing.boxInt(iIntValue3), 8245311, null));
                            destination$iv$iv3.add(MainAPIKt.newEpisode(this, linkData5, new Function1() { // from class: com.phisher98.StreamPlayAnime$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj5) {
                                    return StreamPlayAnime.load$lambda$3$0(item$iv$iv6, epData5, fallbackPoster, fallbackTitle, (Episode) obj5);
                                }
                            }));
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            $i$f$mapTo = $i$f$mapTo;
                            $this$map$iv = $this$map$iv6;
                            epMetaMap = epMetaMap8;
                            kitsuid3 = kitsuid3;
                        }
                        epMetaMap2 = epMetaMap;
                        kitsuid4 = kitsuid3;
                        episodes = (List) destination$iv$iv3;
                        List $this$mapIndexed$iv5 = episodes;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv5, 10));
                        index$iv$iv = 0;
                        while (r33.hasNext()) {
                            int index$iv$iv6 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Episode ep5 = (Episode) item$iv$iv2;
                            int i6 = index$iv$iv + 1;
                            Integer idMal10 = ids4.getIdMal();
                            Integer id18 = ids4.getId();
                            String strM44getTitle18 = data4.m44getTitle();
                            int year10 = data4.getStartDate().getYear();
                            List episodes9 = episodes;
                            num2 = (Integer) destination$iv$iv.get(Boxing.boxInt(i6));
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                            String dubLinkData5 = toStringData(new LinkData(null, null, null, null, null, null, Boxing.boxInt(1), Boxing.boxInt(i6), id18, idMal10, strM44getTitle18, Boxing.boxInt(year10), null, true, null, null, null, jpTitle4, null, null, false, false, false, true, Boxing.boxInt(iIntValue2), 8245311, null));
                            destination$iv$iv4.add(Episode.copy$default(ep5, dubLinkData5, (String) null, (Integer) null, (Integer) null, (String) null, (Score) null, (String) null, (Long) null, (Integer) null, 510, (Object) null));
                            episodes = episodes9;
                            index$iv$iv = index$iv$iv6;
                        }
                        episodes2 = episodes;
                        episodesDub = (List) destination$iv$iv4;
                        if (StringsKt.contains(data4.getFormat(), "Movie", true)) {
                            String strM44getTitle19 = data4.m44getTitle();
                            fallbackPoster2 = fallbackPoster;
                            TvType tvType9 = TvType.AnimeMovie;
                            C00822 c00826 = new C00822(id3, ids4, kitsuid4, data4, backgroundUrl4, animeMetaData2, posterurl3, logoUrl, null);
                            c00813.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00813.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                            c00813.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00813.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                            c00813.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                            c00813.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                            c00813.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                            c00813.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                            c00813.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                            c00813.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                            c00813.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            c00813.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                            c00813.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                            c00813.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                            c00813.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                            c00813.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                            c00813.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                            c00813.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster2);
                            c00813.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle);
                            c00813.L$19 = SpillingKt.nullOutSpilledVariable(href);
                            c00813.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                            c00813.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                            c00813.I$0 = aniyear4;
                            c00813.I$1 = totalEps;
                            c00813.I$2 = anidbEid;
                            c00813.label = 5;
                            C00811 c008114 = c00813;
                            fallbackTitle2 = fallbackTitle;
                            anidbEid4 = anidbEid;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strM44getTitle19, url3, tvType9, href, c00826, c008114);
                            c00814 = c008114;
                            if (objNewMovieLoadResponse == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fallbackTitle3 = fallbackTitle2;
                            fallbackPoster3 = fallbackPoster2;
                            return (LoadResponse) objNewMovieLoadResponse;
                        }
                        aniyear5 = aniyear4;
                        String fallbackTitle8 = fallbackTitle;
                        anidbEid2 = anidbEid;
                        String strM44getTitle110 = data4.m44getTitle();
                        TvType tvType10 = TvType.Anime;
                        data5 = data4;
                        C00811 c008115 = c00813;
                        MetaAnimeData animeMetaData9 = animeMetaData2;
                        C00833 c00837 = new C00833(id3, ids4, kitsuid4, episodes2, episodesDub, logoUrl, data5, animeMetaData9, this, null);
                        animeMetaData3 = animeMetaData9;
                        c008115.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c008115.L$1 = SpillingKt.nullOutSpilledVariable(id3);
                        c008115.L$2 = SpillingKt.nullOutSpilledVariable(data5);
                        c008115.L$3 = SpillingKt.nullOutSpilledVariable(anititle3);
                        c008115.L$4 = SpillingKt.nullOutSpilledVariable(posterurl3);
                        c008115.L$5 = SpillingKt.nullOutSpilledVariable(backgroundUrl4);
                        c008115.L$6 = SpillingKt.nullOutSpilledVariable(anitype6);
                        c008115.L$7 = SpillingKt.nullOutSpilledVariable(ids4);
                        c008115.L$8 = SpillingKt.nullOutSpilledVariable(jpTitle4);
                        c008115.L$9 = SpillingKt.nullOutSpilledVariable(syncMetaData4);
                        c008115.L$10 = SpillingKt.nullOutSpilledVariable(animeMetaData3);
                        c008115.L$11 = SpillingKt.nullOutSpilledVariable(tmdbid3);
                        c008115.L$12 = SpillingKt.nullOutSpilledVariable(kitsuid4);
                        c008115.L$13 = SpillingKt.nullOutSpilledVariable(anitype5);
                        c008115.L$14 = SpillingKt.nullOutSpilledVariable(logoUrl);
                        c008115.L$15 = SpillingKt.nullOutSpilledVariable(destination$iv$iv);
                        c008115.L$16 = SpillingKt.nullOutSpilledVariable(epMetaMap2);
                        c008115.L$17 = SpillingKt.nullOutSpilledVariable(fallbackPoster);
                        c008115.L$18 = SpillingKt.nullOutSpilledVariable(fallbackTitle8);
                        c008115.L$19 = SpillingKt.nullOutSpilledVariable(href);
                        c008115.L$20 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c008115.L$21 = SpillingKt.nullOutSpilledVariable(episodesDub);
                        c008115.I$0 = aniyear5;
                        c008115.I$1 = totalEps;
                        c008115.I$2 = anidbEid2;
                        c008115.label = 6;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, strM44getTitle110, url3, tvType10, false, c00837, c008115, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesDub2 = episodesDub;
                        data6 = data5;
                        obj3 = objNewAnimeLoadResponse$default;
                        totalEps2 = totalEps;
                        anidbEid3 = anidbEid2;
                        aniyear6 = aniyear5;
                        anidbEidMap = destination$iv$iv;
                        href2 = href;
                        episodes3 = episodes2;
                        logoUrl2 = logoUrl;
                        epMetaMap3 = epMetaMap2;
                        kitsuid5 = kitsuid4;
                        return (LoadResponse) obj3;
                    }
                    Object element$iv$iv6 = it.next();
                    int it8 = ((Number) element$iv$iv6).intValue();
                    String url10 = posterurl2;
                    anidbEid5 = StreamPlayUtilsKt.getAnidbEid(syncMetaData3, Boxing.boxInt(it8));
                    if (anidbEid5 != null) {
                        iIntValue = anidbEid5.intValue();
                    }
                    destination$iv$iv.put(element$iv$iv6, Boxing.boxInt(iIntValue));
                    posterurl2 = url10;
                }
                break;
            case 5:
                int anidbEid6 = c00815.I$2;
                int i7 = c00815.I$1;
                int i8 = c00815.I$0;
                String fallbackTitle9 = (String) c00815.L$18;
                fallbackPoster3 = (String) c00815.L$17;
                ResultKt.throwOnFailure($result);
                fallbackTitle3 = fallbackTitle9;
                c00814 = c00815;
                anidbEid4 = anidbEid6;
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            case 6:
                anidbEid3 = c00815.I$2;
                totalEps2 = c00815.I$1;
                aniyear6 = c00815.I$0;
                episodesDub2 = (List) c00815.L$21;
                episodes3 = (List) c00815.L$20;
                href2 = (String) c00815.L$19;
                epMetaMap3 = (Map) c00815.L$16;
                anidbEidMap = (Map) c00815.L$15;
                logoUrl2 = (String) c00815.L$14;
                TvType type4 = (TvType) c00815.L$13;
                kitsuid5 = (String) c00815.L$12;
                animeMetaData3 = (MetaAnimeData) c00815.L$10;
                data6 = (AnilistAPIResponse.anilistMedia) c00815.L$2;
                ResultKt.throwOnFailure($result);
                obj3 = $result;
                anitype5 = type4;
                return (LoadResponse) obj3;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String load$resolveTitle(String fallbackTitle, MetaEpisode epData) {
        String jsonTitle;
        Map<String, String> title;
        Map<String, String> title2;
        String episode;
        Map<String, String> title3;
        if (epData == null || (title3 = epData.getTitle()) == null || (jsonTitle = title3.get("en")) == null) {
            jsonTitle = null;
            String str = (epData == null || (title2 = epData.getTitle()) == null) ? null : title2.get("ja");
            if (str == null) {
                if (epData != null && (title = epData.getTitle()) != null) {
                    jsonTitle = title.get("x-jat");
                }
                if (jsonTitle == null) {
                    jsonTitle = fallbackTitle;
                }
            } else {
                jsonTitle = str;
            }
        }
        String string = jsonTitle;
        if (StringsKt.isBlank(string)) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            if (epData == null || (episode = epData.getEpisode()) == null) {
                episode = "";
            }
            string = sbAppend.append(episode).toString();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0(int $i, MetaEpisode $epData, String $fallbackPoster, String $fallbackTitle, Episode $this$newEpisode) {
        String image;
        String overview;
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($i));
        $this$newEpisode.setName(load$resolveTitle($fallbackTitle, $epData));
        if ($epData == null || (image = $epData.getImage()) == null) {
            image = $fallbackPoster;
        }
        $this$newEpisode.setPosterUrl(image);
        if ($epData == null || (overview = $epData.getOverview()) == null) {
            overview = "No summary available";
        }
        $this$newEpisode.setDescription(overview);
        $this$newEpisode.setScore(Score.Companion.from10($epData != null ? $epData.getRating() : null));
        $this$newEpisode.setRunTime($epData != null ? $epData.getRuntime() : null);
        MainAPIKt.addDate$default($this$newEpisode, $epData != null ? $epData.getAirdate() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$load$2 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$load$2", f = "StreamPlayAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,530:1\n296#2,2:531\n296#2,2:533\n*S KotlinDebug\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$load$2\n*L\n271#1:531,2\n273#1:533,2\n*E\n"})
    static final class C00822 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ AnilistAPIResponse.anilistMedia $data;
        final /* synthetic */ String $id;
        final /* synthetic */ AniIds $ids;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $posterurl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00822(String str, AniIds aniIds, String str2, AnilistAPIResponse.anilistMedia anilistmedia, String str3, MetaAnimeData metaAnimeData, String str4, String str5, Continuation<? super C00822> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$ids = aniIds;
            this.$kitsuid = str2;
            this.$data = anilistmedia;
            this.$backgroundUrl = str3;
            this.$animeMetaData = metaAnimeData;
            this.$posterurl = str4;
            this.$logoUrl = str5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00822 = new C00822(this.$id, this.$ids, this.$kitsuid, this.$data, this.$backgroundUrl, this.$animeMetaData, this.$posterurl, this.$logoUrl, continuation);
            c00822.L$0 = obj;
            return c00822;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0093  */
        /* JADX WARN: Code duplicated, block: B:26:0x0098  */
        /* JADX WARN: Code duplicated, block: B:46:0x00e5  */
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
                    try {
                        LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
                        break;
                    } catch (Throwable th) {
                    }
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
                    String strM43getCoverImage = this.$posterurl;
                    if (strM43getCoverImage == null && (strM43getCoverImage = this.$data.m43getCoverImage()) == null) {
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
                    } else {
                        url = strM43getCoverImage;
                    }
                    loadResponse.setPosterUrl(url);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th2) {
                    }
                    loadResponse.setTags(this.$data.getGenres());
                    loadResponse.setScore(Score.Companion.from100(Boxing.boxInt(this.$data.getAverageScore())));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$load$3 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$load$3", f = "StreamPlayAnime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$load$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,530:1\n296#2,2:531\n296#2,2:533\n1795#2,10:535\n2068#2:545\n2069#2:547\n1805#2:548\n1#3:546\n*S KotlinDebug\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$load$3\n*L\n288#1:531,2\n290#1:533,2\n295#1:535,10\n295#1:545\n295#1:547\n295#1:548\n295#1:546\n*E\n"})
    static final class C00833 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MetaAnimeData $animeMetaData;
        final /* synthetic */ AnilistAPIResponse.anilistMedia $data;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ List<Episode> $episodesDub;
        final /* synthetic */ String $id;
        final /* synthetic */ AniIds $ids;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StreamPlayAnime this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00833(String str, AniIds aniIds, String str2, List<Episode> list, List<Episode> list2, String str3, AnilistAPIResponse.anilistMedia anilistmedia, MetaAnimeData metaAnimeData, StreamPlayAnime streamPlayAnime, Continuation<? super C00833> continuation) {
            super(2, continuation);
            this.$id = str;
            this.$ids = aniIds;
            this.$kitsuid = str2;
            this.$episodes = list;
            this.$episodesDub = list2;
            this.$logoUrl = str3;
            this.$data = anilistmedia;
            this.$animeMetaData = metaAnimeData;
            this.this$0 = streamPlayAnime;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00833 = new C00833(this.$id, this.$ids, this.$kitsuid, this.$episodes, this.$episodesDub, this.$logoUrl, this.$data, this.$animeMetaData, this.this$0, continuation);
            c00833.L$0 = obj;
            return c00833;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00ac  */
        /* JADX WARN: Code duplicated, block: B:45:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f7  */
        public final Object invokeSuspend(Object $result) {
            String bannerImage;
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
                    try {
                        LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
                        break;
                    } catch (Throwable th) {
                    }
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$episodesDub);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th2) {
                    }
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
                    String strM43getCoverImage = this.$data.m43getCoverImage();
                    if (strM43getCoverImage == null) {
                        MetaAnimeData metaAnimeData2 = this.$animeMetaData;
                        if (metaAnimeData2 == null || (images = metaAnimeData2.getImages()) == null) {
                            strM43getCoverImage = null;
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
                                if (imageData != null) {
                                    strM43getCoverImage = imageData.getUrl();
                                } else {
                                    strM43getCoverImage = null;
                                }
                            } while (!StringsKt.equals(it.getCoverType(), "Poster", true));
                            imageData = (ImageData) element$iv;
                            if (imageData != null) {
                                strM43getCoverImage = imageData.getUrl();
                            } else {
                                strM43getCoverImage = null;
                            }
                        }
                    }
                    loadResponse.setPosterUrl(strM43getCoverImage);
                    loadResponse.setTags(this.$data.getGenres());
                    loadResponse.setScore(Score.Companion.from100(Boxing.boxInt(this.$data.getAverageScore())));
                    loadResponse.setShowStatus(this.this$0.getStatus(this.$data.getStatus()));
                    AniListApi.RecommendationConnection recommendations = this.$data.getRecommendations();
                    if (recommendations == null || (edges = recommendations.getEdges()) == null) {
                        arrayList = null;
                    } else {
                        Iterable $this$mapNotNull$iv = edges;
                        StreamPlayAnime streamPlayAnime = this.this$0;
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
                                AnimeSearchResponse $this$invokeSuspend_u24lambda_u242_u240 = MainAPIKt.newAnimeSearchResponse$default(streamPlayAnime, title3, streamPlayAnime.getMainUrl() + "/anime/" + recommendation.getId(), TvType.Anime, false, (Function1) null, 24, (Object) null);
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

    /* JADX WARN: Code duplicated, block: B:54:0x0238  */
    /* JADX WARN: Code duplicated, block: B:55:0x023d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0259  */
    /* JADX WARN: Code duplicated, block: B:69:0x0273  */
    /* JADX WARN: Code duplicated, block: B:70:0x0277  */
    /* JADX WARN: Code duplicated, block: B:72:0x027d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0281  */
    /* JADX WARN: Code duplicated, block: B:76:0x03b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:90:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:? A[LOOP:0: B:62:0x0253->B:92:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00841 c00841;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        String str2;
        String str3;
        Integer num;
        Integer num2;
        Integer num3;
        String str4;
        Object obj3;
        char c;
        boolean z2;
        boolean z3;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        LinkData linkData;
        Object obj4;
        Integer num4;
        Integer num5;
        String str5;
        Object safe;
        MALSyncResponses mALSyncResponses;
        MALSyncSites mALSyncSites;
        String str6;
        Function1[] function1Arr;
        HashMap<String, HashMap<String, String>> kickAssAnime;
        Collection<HashMap<String, String>> collectionValues;
        Iterator<T> it;
        String str7;
        MALSyncSites sites;
        if (continuation instanceof C00841) {
            c00841 = (C00841) continuation;
            if ((c00841.label & Integer.MIN_VALUE) != 0) {
                c00841.label -= Integer.MIN_VALUE;
            } else {
                c00841 = new C00841(continuation);
            }
        } else {
            c00841 = new C00841(continuation);
        }
        C00841 c00842 = c00841;
        Object obj5 = c00842.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00842.label) {
            case 0:
                ResultKt.throwOnFailure(obj5);
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
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LinkData>() { // from class: com.phisher98.StreamPlayAnime$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LinkData>() { // from class: com.phisher98.StreamPlayAnime$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LinkData>() { // from class: com.phisher98.StreamPlayAnime$loadLinks$$inlined$parseJson$1
                    });
                }
                LinkData linkData2 = (LinkData) objDecodeFromString;
                Integer malId = linkData2.getMalId();
                Integer episode = linkData2.getEpisode();
                String jpTitle = linkData2.getJpTitle();
                String title = linkData2.getTitle();
                Integer anidbEid = linkData2.getAnidbEid();
                Integer aniId = linkData2.getAniId();
                Integer year = linkData2.getYear();
                c00842.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c00842.L$1 = function1;
                c00842.L$2 = function2;
                c00842.L$3 = linkData2;
                c00842.L$4 = malId;
                c00842.L$5 = episode;
                c00842.L$6 = jpTitle;
                c00842.L$7 = title;
                c00842.L$8 = anidbEid;
                c00842.L$9 = aniId;
                c00842.L$10 = year;
                c00842.Z$0 = z;
                c00842.label = 1;
                str2 = jpTitle;
                str3 = title;
                num = anidbEid;
                num2 = aniId;
                num3 = year;
                str4 = null;
                obj3 = coroutine_suspended;
                c = 2;
                z2 = true;
                Object obj6 = Requests.get$default(MainActivityKt.getApp(), "https://api.malsync.moe/mal/anime/" + malId, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00842, 4094, (Object) null);
                c00842 = c00842;
                if (obj6 == obj3) {
                    return obj3;
                }
                z3 = z;
                function3 = function1;
                function4 = function2;
                linkData = linkData2;
                obj4 = obj6;
                num4 = episode;
                num5 = malId;
                str5 = str;
                NiceResponse niceResponse = (NiceResponse) obj4;
                try {
                    ResponseParser parser = niceResponse.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(niceResponse.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    safe = str4;
                }
                mALSyncResponses = (MALSyncResponses) safe;
                if (mALSyncResponses != null) {
                    sites = mALSyncResponses.getSites();
                } else {
                    mALSyncSites = str4;
                }
                if (mALSyncSites != 0 && (kickAssAnime = mALSyncSites.getKickAssAnime()) != null && (collectionValues = kickAssAnime.values()) != null) {
                    mALSyncSites = sites;
                    it = collectionValues.iterator();
                    while (it.hasNext()) {
                        str7 = (String) ((HashMap) it.next()).get("identifier");
                        if (str7 != null) {
                            str4 = str7;
                        }
                    }
                }
                mALSyncSites = sites;
                mALSyncSites = sites;
                mALSyncSites = sites;
                if (linkData.getSeason() == null) {
                    str6 = "Movie";
                } else if (linkData.isDub()) {
                    str6 = "DUB";
                } else {
                    str6 = "SUB";
                }
                function1Arr = new Function1[11];
                Function1<? super SubtitleFile, Unit> function5 = function3;
                String str8 = str6;
                Integer num6 = num5;
                function1Arr[0] = new C00882(num5, num4, function5, function4, str8, null);
                function1Arr[z2 ? 1 : 0] = new C00893(mALSyncSites, num4, function5, function4, str8, null);
                String str9 = str2;
                function1Arr[c] = new C00904(str9, num4, function5, function4, str8, null);
                Function1<? super ExtractorLink, Unit> function6 = function4;
                Integer num7 = num4;
                function1Arr[3] = new C00915(num2, str3, str9, num7, function5, function6, str6, null);
                function1Arr[4] = new C00926(num2, str3, str9, num7, function5, function6, str6, null);
                String str10 = str6;
                function1Arr[5] = new C00937(str9, str3, num3, num7, function5, function6, str6, null);
                function1Arr[6] = new C00948(str9, str4, num7, function5, function6, str10, null);
                function1Arr[7] = new C00959(num6, num2, str9, num7, function5, function6, str10, null);
                function1Arr[8] = new C008510(num6, function5, function6, str10, num, null);
                function1Arr[9] = new C008611(num2, num7, function5, function6, str10, null);
                function1Arr[10] = new C008712(str3, str9, num7, function5, function6, str10, null);
                c00842.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                c00842.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                c00842.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                c00842.L$3 = SpillingKt.nullOutSpilledVariable(linkData);
                c00842.L$4 = SpillingKt.nullOutSpilledVariable(num6);
                c00842.L$5 = SpillingKt.nullOutSpilledVariable(num7);
                c00842.L$6 = SpillingKt.nullOutSpilledVariable(str9);
                c00842.L$7 = SpillingKt.nullOutSpilledVariable(str3);
                c00842.L$8 = SpillingKt.nullOutSpilledVariable(num);
                c00842.L$9 = SpillingKt.nullOutSpilledVariable(num2);
                c00842.L$10 = SpillingKt.nullOutSpilledVariable(num3);
                c00842.L$11 = SpillingKt.nullOutSpilledVariable(mALSyncSites);
                c00842.L$12 = SpillingKt.nullOutSpilledVariable(str4);
                c00842.L$13 = SpillingKt.nullOutSpilledVariable(str10);
                c00842.Z$0 = z3;
                c00842.label = 2;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00842) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(z2);
            case 1:
                boolean z4 = c00842.Z$0;
                Integer num8 = (Integer) c00842.L$10;
                Integer num9 = (Integer) c00842.L$9;
                Integer num10 = (Integer) c00842.L$8;
                String str11 = (String) c00842.L$7;
                String str12 = (String) c00842.L$6;
                Integer num11 = (Integer) c00842.L$5;
                Integer num12 = (Integer) c00842.L$4;
                linkData = (LinkData) c00842.L$3;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00842.L$2;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00842.L$1;
                String str13 = (String) c00842.L$0;
                ResultKt.throwOnFailure(obj5);
                obj3 = coroutine_suspended;
                num3 = num8;
                num2 = num9;
                num = num10;
                str3 = str11;
                str2 = str12;
                num5 = num12;
                z3 = z4;
                c = 2;
                z2 = true;
                str4 = null;
                str5 = str13;
                obj4 = obj5;
                function4 = function7;
                function3 = function8;
                num4 = num11;
                NiceResponse niceResponse2 = (NiceResponse) obj4;
                ResponseParser parser2 = niceResponse2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(niceResponse2.getText(), Reflection.getOrCreateKotlinClass(MALSyncResponses.class));
                mALSyncResponses = (MALSyncResponses) safe;
                if (mALSyncResponses != null) {
                    sites = mALSyncResponses.getSites();
                } else {
                    mALSyncSites = str4;
                }
                if (mALSyncSites != 0) {
                    mALSyncSites = sites;
                    it = collectionValues.iterator();
                    while (it.hasNext()) {
                        str7 = (String) ((HashMap) it.next()).get("identifier");
                        if (str7 != null) {
                            str4 = str7;
                        }
                    }
                }
                mALSyncSites = sites;
                mALSyncSites = sites;
                mALSyncSites = sites;
                if (linkData.getSeason() == null) {
                    str6 = "Movie";
                } else if (linkData.isDub()) {
                    str6 = "DUB";
                } else {
                    str6 = "SUB";
                }
                function1Arr = new Function1[11];
                Function1<? super SubtitleFile, Unit> function9 = function3;
                String str14 = str6;
                Integer num13 = num5;
                function1Arr[0] = new C00882(num5, num4, function9, function4, str14, null);
                function1Arr[z2 ? 1 : 0] = new C00893(mALSyncSites, num4, function9, function4, str14, null);
                String str15 = str2;
                function1Arr[c] = new C00904(str15, num4, function9, function4, str14, null);
                Function1<? super ExtractorLink, Unit> function10 = function4;
                Integer num14 = num4;
                function1Arr[3] = new C00915(num2, str3, str15, num14, function9, function10, str6, null);
                function1Arr[4] = new C00926(num2, str3, str15, num14, function9, function10, str6, null);
                String str16 = str6;
                function1Arr[5] = new C00937(str15, str3, num3, num14, function9, function10, str6, null);
                function1Arr[6] = new C00948(str15, str4, num14, function9, function10, str16, null);
                function1Arr[7] = new C00959(num13, num2, str15, num14, function9, function10, str16, null);
                function1Arr[8] = new C008510(num13, function9, function10, str16, num, null);
                function1Arr[9] = new C008611(num2, num14, function9, function10, str16, null);
                function1Arr[10] = new C008712(str3, str15, num14, function9, function10, str16, null);
                c00842.L$0 = SpillingKt.nullOutSpilledVariable(str5);
                c00842.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                c00842.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                c00842.L$3 = SpillingKt.nullOutSpilledVariable(linkData);
                c00842.L$4 = SpillingKt.nullOutSpilledVariable(num13);
                c00842.L$5 = SpillingKt.nullOutSpilledVariable(num14);
                c00842.L$6 = SpillingKt.nullOutSpilledVariable(str15);
                c00842.L$7 = SpillingKt.nullOutSpilledVariable(str3);
                c00842.L$8 = SpillingKt.nullOutSpilledVariable(num);
                c00842.L$9 = SpillingKt.nullOutSpilledVariable(num2);
                c00842.L$10 = SpillingKt.nullOutSpilledVariable(num3);
                c00842.L$11 = SpillingKt.nullOutSpilledVariable(mALSyncSites);
                c00842.L$12 = SpillingKt.nullOutSpilledVariable(str4);
                c00842.L$13 = SpillingKt.nullOutSpilledVariable(str16);
                c00842.Z$0 = z3;
                c00842.label = 2;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00842) == obj3) {
                    return obj3;
                }
                return Boxing.boxBoolean(z2);
            case 2:
                boolean z5 = c00842.Z$0;
                ResultKt.throwOnFailure(obj5);
                z2 = true;
                return Boxing.boxBoolean(z2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$2 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$2", f = "StreamPlayAnime.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00882 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00882(Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C00882> continuation) {
            super(1, continuation);
            this.$malId = num;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00882(this.$malId, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeHianime(this.$malId, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$3 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$3", f = "StreamPlayAnime.kt", i = {0}, l = {335}, m = "invokeSuspend", n = {"it"}, nl = {336}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayAnime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayAnime.kt\ncom/phisher98/StreamPlayAnime$loadLinks$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,530:1\n1#2:531\n*E\n"})
    static final class C00893 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ MALSyncSites $malsync;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00893(MALSyncSites mALSyncSites, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C00893> continuation) {
            super(1, continuation);
            this.$malsync = mALSyncSites;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00893(this.$malsync, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x004f  */
        /* JADX WARN: Code duplicated, block: B:23:0x006b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x006c  */
        /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
        /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r5v4 java.lang.String, still in use, count: 2, list:
              (r5v4 java.lang.String) from 0x0049: IF  (r5v4 java.lang.String) == (null java.lang.String)  -> B:29:? A[HIDDEN]
              (r5v4 java.lang.String) from 0x004d: PHI (r5 I:??) = (r5v0 java.lang.String), (r5v4 java.lang.String) binds: [B:19:0x004c, B:27:0x004d] A[DONT_GENERATE, DONT_INLINE]
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
            	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
            	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
            	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                switch(r1) {
                    case 0: goto L1a;
                    case 1: goto L11;
                    default: goto L9;
                }
            L9:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L11:
                r0 = 0
                java.lang.Object r1 = r13.L$0
                java.lang.String r1 = (java.lang.String) r1
                kotlin.ResultKt.throwOnFailure(r14)
                goto L6e
            L1a:
                kotlin.ResultKt.throwOnFailure(r14)
                com.phisher98.MALSyncSites r1 = r13.$malsync
                r2 = 0
                if (r1 == 0) goto L71
                java.util.HashMap r1 = r1.getAnimepahe()
                if (r1 == 0) goto L71
                java.util.Collection r1 = r1.values()
                if (r1 == 0) goto L71
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r1 = r1.iterator()
            L34:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L4c
                java.lang.Object r3 = r1.next()
                java.util.HashMap r3 = (java.util.HashMap) r3
                r4 = 0
                java.lang.String r5 = "url"
                java.lang.Object r5 = r3.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L34
                goto L4d
            L4c:
                r5 = r2
            L4d:
                if (r5 == 0) goto L71
                java.lang.Integer r8 = r13.$episode
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r9 = r13.$subtitleCallback
                kotlin.jvm.functions.Function1<com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r10 = r13.$callback
                java.lang.String r11 = r13.$dubStatus
                r7 = r5
                r1 = 0
                com.phisher98.StreamPlayExtractor r6 = com.phisher98.StreamPlayExtractor.INSTANCE
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r13.L$0 = r2
                r2 = 1
                r13.label = r2
                r12 = r13
                java.lang.Object r2 = r6.invokeAnimepahe(r7, r8, r9, r10, r11, r12)
                if (r2 != r0) goto L6c
                return r0
            L6c:
                r0 = r1
                r1 = r7
            L6e:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
            L71:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayAnime.C00893.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$4 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$4", f = "StreamPlayAnime.kt", i = {}, l = {339}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00904 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00904(String str, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str2, Continuation<? super C00904> continuation) {
            super(1, continuation);
            this.$jpTitle = str;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00904(this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeAnizone(this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$5 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$5", f = "StreamPlayAnime.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00915 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00915(Integer num, String str, String str2, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00915> continuation) {
            super(1, continuation);
            this.$aniid = num;
            this.$anititle = str;
            this.$jpTitle = str2;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00915(this.$aniid, this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    Integer num = this.$aniid;
                    String str = this.$anititle;
                    if (str == null) {
                        str = this.$jpTitle;
                    }
                    this.label = 1;
                    if (streamPlayExtractor.invokeAnikage(num, str, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$6 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$6", f = "StreamPlayAnime.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00926 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00926(Integer num, String str, String str2, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00926> continuation) {
            super(1, continuation);
            this.$aniid = num;
            this.$anititle = str;
            this.$jpTitle = str2;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00926(this.$aniid, this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    Integer num = this.$aniid;
                    String str = this.$anititle;
                    if (str == null) {
                        str = this.$jpTitle;
                    }
                    this.label = 1;
                    if (streamPlayExtractor.invokeAnikoto(num, str, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$7 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$7", f = "StreamPlayAnime.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00937 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ Integer $year;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00937(String str, String str2, Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00937> continuation) {
            super(1, continuation);
            this.$jpTitle = str;
            this.$anititle = str2;
            this.$year = num;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00937(this.$jpTitle, this.$anititle, this.$year, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeAnichi(this.$jpTitle, this.$anititle, this.$year, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$8 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$8", f = "StreamPlayAnime.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00948 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ String $kaasSlug;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00948(String str, String str2, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C00948> continuation) {
            super(1, continuation);
            this.$jpTitle = str;
            this.$kaasSlug = str2;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00948(this.$jpTitle, this.$kaasSlug, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeKickAssAnime(this.$jpTitle, this.$kaasSlug, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$9 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$9", f = "StreamPlayAnime.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00959 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00959(Integer num, Integer num2, String str, Integer num3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str2, Continuation<? super C00959> continuation) {
            super(1, continuation);
            this.$malId = num;
            this.$aniid = num2;
            this.$jpTitle = str;
            this.$episode = num3;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00959(this.$malId, this.$aniid, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeAnimex(this.$malId, this.$aniid, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$10 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$10", f = "StreamPlayAnime.kt", i = {0}, l = {347}, m = "invokeSuspend", n = {"it"}, nl = {353}, s = {"I$0"}, v = 2)
    static final class C008510 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $anidbEid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C008510(Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Integer num2, Continuation<? super C008510> continuation) {
            super(1, continuation);
            this.$malId = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
            this.$anidbEid = num2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C008510(this.$malId, this.$subtitleCallback, this.$callback, this.$dubStatus, this.$anidbEid, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Integer num = this.$malId;
                    if (num == null) {
                        return null;
                    }
                    Function1<? super SubtitleFile, Unit> function1 = this.$subtitleCallback;
                    Function1<? super ExtractorLink, Unit> function2 = this.$callback;
                    String str = this.$dubStatus;
                    Integer num2 = this.$anidbEid;
                    int it = num.intValue();
                    StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                    this.I$0 = it;
                    this.label = 1;
                    if (streamPlayExtractor.invokeAnimetosho(function1, function2, str, num2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    int i = this.I$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$11 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$11", f = "StreamPlayAnime.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, nl = {357}, s = {}, v = 2)
    static final class C008611 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $aniid;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C008611(Integer num, Integer num2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str, Continuation<? super C008611> continuation) {
            super(1, continuation);
            this.$aniid = num;
            this.$episode = num2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C008611(this.$aniid, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeReAnime(this.$aniid, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StreamPlayAnime$loadLinks$12 */
    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayAnime$loadLinks$12", f = "StreamPlayAnime.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, nl = {360}, s = {}, v = 2)
    static final class C008712 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $anititle;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $dubStatus;
        final /* synthetic */ Integer $episode;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C008712(String str, String str2, Integer num, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, Continuation<? super C008712> continuation) {
            super(1, continuation);
            this.$anititle = str;
            this.$jpTitle = str2;
            this.$episode = num;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$dubStatus = str3;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C008712(this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, continuation);
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
                    if (StreamPlayExtractor.INSTANCE.invokeAnineko(this.$anititle, this.$jpTitle, this.$episode, this.$subtitleCallback, this.$callback, this.$dubStatus, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse;", "", "data", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;)V", "getData", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistData", "anilistMedia", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        /* JADX INFO: compiled from: StreamPlayAnime.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aB;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData;", "", "page", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Page", "media", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "Media", "<init>", "(Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;)V", "getPage", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "getMedia", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AnilistPage", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

            /* JADX INFO: compiled from: StreamPlayAnime.kt */
            @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u001c\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u001c\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$AnilistData$AnilistPage;", "", "pageInfo", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "media", "", "Lcom/phisher98/StreamPlayAnime$Media;", "<init>", "(Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;Ljava/util/List;)V", "getPageInfo", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$LikePageInfo;", "getMedia", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        /* JADX INFO: compiled from: StreamPlayAnime.kt */
        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002OPB\u0085\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001c\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0016\b\u0001\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0016\b\u0001\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u00108\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\fJ\b\u0010.\u001a\u0004\u0018\u00010\fJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010<\u001a\u00020\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010B\u001a\u00020\u0013HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003J\u008c\u0003\u0010H\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001c\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0016\b\u0003\u0010\u0012\u001a\u00020\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0016:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0018:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001bHÆ\u0001¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010M\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010N\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(¨\u0006Q"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "startDate", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "season", "", "genres", "", "averageScore", "status", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "bannerImage", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "airingSchedule", "Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "recommendations", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "format", "<init>", "(ILcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)V", "getId", "()I", "getStartDate", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;", "getEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getSeason", "()Ljava/lang/String;", "getGenres", "()Ljava/util/List;", "getAverageScore", "getStatus", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getBannerImage", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "getAiringSchedule", "()Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "getRecommendations", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;", "getFormat", "totalEpisodes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;Ljava/lang/Integer;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$RecommendationConnection;Ljava/lang/String;)Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia;", "equals", "", "other", "hashCode", "toString", "StartDate", "AiringScheduleNodes", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

            /* JADX INFO: compiled from: StreamPlayAnime.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$StartDate;", "", "year", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(I)V", "getYear", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

            /* JADX INFO: compiled from: StreamPlayAnime.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u001e\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u001e\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/phisher98/StreamPlayAnime$AnilistAPIResponse$anilistMedia$AiringScheduleNodes;", "", "nodes", "", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getNodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
            public final String m44getTitle() throws Exception {
                String english = this.title.getEnglish();
                if (english != null || (english = this.title.getRomaji()) != null) {
                    return english;
                }
                throw new Exception("Unable to calculate total episodes");
            }

            @Nullable
            /* JADX INFO: renamed from: getCoverImage, reason: collision with other method in class */
            public final String m43getCoverImage() {
                String extraLarge = this.coverImage.getExtraLarge();
                if (extraLarge != null) {
                    return extraLarge;
                }
                String large = this.coverImage.getLarge();
                return large == null ? this.coverImage.getMedium() : large;
            }
        }
    }

    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0005\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e\u0012\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f¢\u0006\u0004\b \u0010!J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010F\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010G\u001a\u00020\u0014HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010N\u001a\u00020\u0014HÆ\u0003J\t\u0010O\u001a\u00020\u0014HÆ\u0003J\t\u0010P\u001a\u00020\u0014HÆ\u0003J\t\u0010Q\u001a\u00020\u0014HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u008e\u0005\u0010S\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0016\b\u0003\u0010\u0013\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00132\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0016\b\u0003\u0010\u001b\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u0016\b\u0003\u0010\u001c\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0016\b\u0003\u0010\u001d\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0016\b\u0003\u0010\u001e\u001a\u00020\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001e2\u0018\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001fHÆ\u0001¢\u0006\u0002\u0010TJ\u0014\u0010U\u001a\u00020\u00142\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010W\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010X\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b+\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b,\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u00102R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b3\u0010#R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b4\u0010#R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\u001b\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u00102R\u0011\u0010\u001c\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00102R\u0011\u0010\u001d\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00102R\u0011\u0010\u001e\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u00102R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b9\u0010#¨\u0006Y"}, d2 = {"Lcom/phisher98/StreamPlayAnime$LinkData;", "", "simklId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "traktId", "imdbId", "", "tmdbId", "tvdbId", "type", "season", "episode", "aniId", "malId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "isDub", "anidbEid", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/Integer;)V", "getSimklId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTraktId", "getImdbId", "()Ljava/lang/String;", "getTmdbId", "getTvdbId", "getType", "getSeason", "getEpisode", "getAniId", "getMalId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "getAnidbEid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/Integer;)Lcom/phisher98/StreamPlayAnime$LinkData;", "equals", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final String airedDate;

        @Nullable
        private final Integer airedYear;

        @Nullable
        private final Integer aniId;

        @Nullable
        private final Integer anidbEid;

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
                num13 = linkData.anidbEid;
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
        public final Integer getAnidbEid() {
            return this.anidbEid;
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
        public final LinkData copy(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub, @JsonProperty("anidbEid") @Nullable Integer anidbEid) {
            return new LinkData(simklId, traktId, imdbId, tmdbId, tvdbId, type, season, episode, aniId, malId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, isDub, anidbEid);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.simklId, linkData.simklId) && Intrinsics.areEqual(this.traktId, linkData.traktId) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tmdbId, linkData.tmdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.malId, linkData.malId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && this.isDub == linkData.isDub && Intrinsics.areEqual(this.anidbEid, linkData.anidbEid);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((this.simklId == null ? 0 : this.simklId.hashCode()) * 31) + (this.traktId == null ? 0 : this.traktId.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate == null ? 0 : this.airedDate.hashCode())) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isAsian)) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isBollywood)) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isCartoon)) * 31) + StreamPlayAnime$LinkData$$ExternalSyntheticBackport0.m22m(this.isDub)) * 31) + (this.anidbEid != null ? this.anidbEid.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(simklId=").append(this.simklId).append(", traktId=").append(this.traktId).append(", imdbId=").append(this.imdbId).append(", tmdbId=").append(this.tmdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", aniId=").append(this.aniId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", year=");
            sb.append(this.year).append(", orgTitle=").append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon);
            sb.append(", isDub=").append(this.isDub).append(", anidbEid=").append(this.anidbEid).append(')');
            return sb.toString();
        }

        public LinkData(@JsonProperty("simklId") @Nullable Integer simklId, @JsonProperty("traktId") @Nullable Integer traktId, @JsonProperty("imdbId") @Nullable String imdbId, @JsonProperty("tmdbId") @Nullable Integer tmdbId, @JsonProperty("tvdbId") @Nullable Integer tvdbId, @JsonProperty("type") @Nullable String type, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("aniId") @Nullable Integer aniId, @JsonProperty("malId") @Nullable Integer malId, @JsonProperty("title") @Nullable String title, @JsonProperty("year") @Nullable Integer year, @JsonProperty("orgTitle") @Nullable String orgTitle, @JsonProperty("isAnime") boolean isAnime, @JsonProperty("airedYear") @Nullable Integer airedYear, @JsonProperty("lastSeason") @Nullable Integer lastSeason, @JsonProperty("epsTitle") @Nullable String epsTitle, @JsonProperty("jpTitle") @Nullable String jpTitle, @JsonProperty("date") @Nullable String date, @JsonProperty("airedDate") @Nullable String airedDate, @JsonProperty("isAsian") boolean isAsian, @JsonProperty("isBollywood") boolean isBollywood, @JsonProperty("isCartoon") boolean isCartoon, @JsonProperty("isDub") boolean isDub, @JsonProperty("anidbEid") @Nullable Integer anidbEid) {
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
            this.anidbEid = anidbEid;
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
        public final Integer getAnidbEid() {
            return this.anidbEid;
        }
    }

    /* JADX INFO: compiled from: StreamPlayAnime.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B·\u0002\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0016\b\u0001\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u001c\b\u0001\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0013HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003J¾\u0002\u00108\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0016\b\u0003\u0010\f\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0016\b\u0003\u0010\u0010\u001a\u00020\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010>\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lcom/phisher98/StreamPlayAnime$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "idMal", "season", "", "seasonYear", "format", "averageScore", "episodes", "title", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "description", "coverImage", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "synonyms", "", "nextAiringEpisode", "Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)V", "getId", "()I", "getIdMal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason", "()Ljava/lang/String;", "getSeasonYear", "getFormat", "getAverageScore", "getEpisodes", "getTitle", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;", "getDescription", "getCoverImage", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;", "getSynonyms", "()Ljava/util/List;", "getNextAiringEpisode", "()Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/Integer;Ljava/lang/String;ILjava/lang/String;IILcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$Title;Ljava/lang/String;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$CoverImage;Ljava/util/List;Lcom/lagradost/cloudstream3/syncproviders/providers/AniListApi$SeasonNextAiringEpisode;)Lcom/phisher98/StreamPlayAnime$Media;", "equals", "", "other", "hashCode", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    /* JADX WARN: Code duplicated, block: B:47:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object tmdbToAnimeId(String title, Integer year, TvType type, Continuation<? super AniIds> continuation) {
        C00971 c00971;
        AniMedia aniMedia;
        Object obj;
        Object safe;
        AniMedia res;
        AniData it;
        ArrayList<AniMedia> media;
        if (continuation instanceof C00971) {
            c00971 = (C00971) continuation;
            if ((c00971.label & Integer.MIN_VALUE) != 0) {
                c00971.label -= Integer.MIN_VALUE;
            } else {
                c00971 = new C00971(continuation);
            }
        } else {
            c00971 = new C00971(continuation);
        }
        Object $result = c00971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00971.label) {
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
                c00971.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c00971.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c00971.L$2 = SpillingKt.nullOutSpilledVariable(type);
                c00971.L$3 = SpillingKt.nullOutSpilledVariable("query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $season: MediaSeason\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      season: $season\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}");
                c00971.L$4 = SpillingKt.nullOutSpilledVariable(variables);
                c00971.L$5 = SpillingKt.nullOutSpilledVariable(data);
                c00971.label = 1;
                aniMedia = null;
                Object objPost$default = Requests.post$default(app, StreamPlay.anilistAPI, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, data, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00971, 65278, (Object) null);
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

    private final Integer extractSeason(String title) {
        String seasonStr;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        MatchGroupCollection groups2;
        MatchGroup matchGroup2;
        Regex regex = new Regex("(?i)(?:season\\s*(\\d+)|(\\d+)(?:st|nd|rd|th)?\\s*season)");
        MatchResult match = Regex.find$default(regex, title, 0, 2, (Object) null);
        if (match == null || (groups2 = match.getGroups()) == null || (matchGroup2 = groups2.get(1)) == null || (seasonStr = matchGroup2.getValue()) == null) {
            seasonStr = (match == null || (groups = match.getGroups()) == null || (matchGroup = groups.get(2)) == null) ? "1" : matchGroup.getValue();
        }
        return StringsKt.toIntOrNull(seasonStr);
    }
}
