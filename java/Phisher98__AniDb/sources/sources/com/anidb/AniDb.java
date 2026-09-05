package com.anidb;

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
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: AniDb.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AniDb/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0005<=>?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001c2\u0006\u0010\"\u001a\u00020#H\u0002J\u001e\u0010\u001e\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101JF\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00182\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020806H\u0096@¢\u0006\u0002\u0010;R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006A"}, d2 = {"Lcom/anidb/AniDb;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "searchResponseBuilder", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "res", "Lorg/jsoup/nodes/Document;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "EpisodeItem", "EpisodesResponse", "Language", "LanguagesResponse", "AniDb"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniDb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniDb.kt\ncom/anidb/AniDb\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,437:1\n2068#2,2:438\n1739#2:440\n1814#2,3:441\n296#2,2:444\n1960#2,3:456\n1960#2,3:459\n2077#2,3:463\n296#2,2:466\n73#3,5:446\n73#3,5:451\n73#3,5:468\n1#4:462\n*S KotlinDebug\n*F\n+ 1 AniDb.kt\ncom/anidb/AniDb\n*L\n160#1:438,2\n199#1:440\n199#1:441,3\n201#1:444,2\n222#1:456,3\n226#1:459,3\n251#1:463,3\n310#1:466,2\n208#1:446,5\n220#1:451,5\n365#1:468,5\n*E\n"})
public final class AniDb extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> CF_BLOCKER_PHRASES = CollectionsKt.listOf(new String[]{"just a moment", "checking your browser", "ddos-guard", "verify you are human", "cf-browser-verification", "cf-chl-widget"});

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private String mainUrl = "https://anidb.app";

    @NotNull
    private String name = "AniDB";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private String lang = "en";
    private final boolean hasMainPage = true;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/browse?q=&type=&status=&season=&year=&genres=&sort=order_top_airing&page=", "Top Airing"), TuplesKt.to(getMainUrl() + "/browse?q=&type=&status=&season=&year=&genres=&sort=order_popular&page=", "Popular"), TuplesKt.to(getMainUrl() + "/browse?q=&type=&status=&season=&year=&genres=&sort=order_updated&page=", "Recently Updated"), TuplesKt.to(getMainUrl() + "/browse?q=&type=&status=&season=&year=&genres=&sort=aired_start&page=", "Recently Aired"), TuplesKt.to(getMainUrl() + "/browse?q=&type=&status=Currently+Airing&season=&year=&genres=&sort=order_favorite&page=", "Currently Airing"), TuplesKt.to(getMainUrl() + "/browse?type=TV&page=", "TV Series"), TuplesKt.to(getMainUrl() + "/browse?type=Movie&page=", "Movies"), TuplesKt.to(getMainUrl() + "/browse?type=ONA&page=", "ONA"), TuplesKt.to(getMainUrl() + "/browse?type=OVA&page=", "OVA"), TuplesKt.to(getMainUrl() + "/browse?type=Special&page=", "Specials"), TuplesKt.to(getMainUrl() + "/browse?q=&type=&status=Finished+Airing&season=&year=&genres=&sort=order_favorite&page=", "Finished Airing")});

    /* JADX INFO: renamed from: com.anidb.AniDb$getMainPage$1 */
    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anidb.AniDb", f = "AniDb.kt", i = {0, 0, 0}, l = {178}, m = "getMainPage", n = {"request", "url", "page"}, nl = {179}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniDb.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anidb.AniDb$load$1 */
    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anidb.AniDb", f = "AniDb.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {192, 205, 217, 241, 243, 323}, m = "load", n = {"url", "slug", "siteId", "url", "slug", "doc", "title", "poster", "description", "tags", "year", "ratingText", "rating", "episodesUrl", "siteId", "url", "slug", "doc", "title", "poster", "description", "tags", "year", "ratingText", "rating", "episodesUrl", "epResponse", "episodesList", "firstEpId", "hasSub", "hasDub", "langUrl", "siteId", "url", "slug", "doc", "title", "poster", "description", "tags", "year", "ratingText", "rating", "episodesUrl", "epResponse", "episodesList", "firstEpId", "hasSub", "hasDub", "subEpisodes", "dubEpisodes", "malId", "anilistId", "siteId", "url", "slug", "doc", "title", "poster", "description", "tags", "year", "ratingText", "rating", "episodesUrl", "epResponse", "episodesList", "firstEpId", "hasSub", "hasDub", "subEpisodes", "dubEpisodes", "malId", "anilistId", "siteId", "url", "slug", "doc", "title", "poster", "description", "tags", "year", "ratingText", "rating", "episodesUrl", "epResponse", "episodesList", "firstEpId", "hasSub", "hasDub", "subEpisodes", "dubEpisodes", "malId", "anilistId", "syncMetaData", "animeMetaData", "backgroundposter", "tvType", "trailerUrl", "statusText", "showStatus", "durationText", "duration", "siteId", "isMovie"}, nl = {193, 208, 220, 242, 244, -1}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "I$0", "I$1"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniDb.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anidb.AniDb$loadLinks$1 */
    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anidb.AniDb", f = "AniDb.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {359, 388}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "episodeIdRaw", "episodeId", "slug", "audio", "langUrl", "isCasting", "data", "subtitleCallback", "callback", "parts", "episodeIdRaw", "episodeId", "slug", "audio", "langUrl", "langResponse", "langs", "langsToExtract", "hlsRegex", "isCasting"}, nl = {365, 413}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniDb.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anidb.AniDb$search$1 */
    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anidb.AniDb", f = "AniDb.kt", i = {0, 0}, l = {184}, m = "search", n = {"query", "page"}, nl = {185}, s = {"L$0", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniDb.this.search(null, 0, (Continuation) this);
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

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ,\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/anidb/AniDb$Companion;", "", "<init>", "()V", "CF_BLOCKER_PHRASES", "", "", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "appGet", "url", "headers", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AniDb"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAniDb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniDb.kt\ncom/anidb/AniDb$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,437:1\n1960#2,3:438\n117#3,10:441\n1#4:451\n*S KotlinDebug\n*F\n+ 1 AniDb.kt\ncom/anidb/AniDb$Companion\n*L\n119#1:438,3\n130#1:441,10\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCloudflareBlocked(@NotNull NiceResponse response) {
            if (response.getCode() != 403 && response.getCode() != 503) {
                return false;
            }
            String body = response.getText().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(body, "toLowerCase(...)");
            Iterable $this$any$iv = AniDb.CF_BLOCKER_PHRASES;
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                String it = (String) element$iv;
                if (StringsKt.contains$default(body, it, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object appGet$default(Companion companion, String str, Map map, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            return companion.appGet(str, map, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x011a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x011b  */
        /* JADX WARN: Code duplicated, block: B:32:0x013d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x013e  */
        /* JADX WARN: Code duplicated, block: B:40:0x018f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x0190  */
        /* JADX WARN: Code duplicated, block: B:44:0x01a8 A[Catch: all -> 0x01ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ab, blocks: (B:44:0x01a8, B:50:0x01b8), top: B:84:0x01a6 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x01b0 A[Catch: all -> 0x0250, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0250, blocks: (B:42:0x019d, B:48:0x01b0), top: B:75:0x019d }] */
        /* JADX WARN: Code duplicated, block: B:50:0x01b8 A[Catch: all -> 0x01ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ab, blocks: (B:44:0x01a8, B:50:0x01b8), top: B:84:0x01a6 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01d5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:60:0x01ef  */
        /* JADX WARN: Code duplicated, block: B:62:0x023c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x023d  */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        @Nullable
        public final Object appGet(@NotNull String url, @NotNull Map<String, String> map, @NotNull Continuation<? super NiceResponse> continuation) throws Throwable {
            AniDb$Companion$appGet$1 aniDb$Companion$appGet$1;
            Mutex $this$withLock_u24default$iv;
            Object owner$iv;
            Object obj;
            AniDb$Companion$appGet$1 aniDb$Companion$appGet$2;
            String url2;
            Map<String, String> map2;
            NiceResponse rawResponse;
            Ref.ObjectRef recheckPassed;
            Mutex $this$withLock_u24default$iv2;
            NiceResponse rawResponse2;
            String url3;
            Ref.ObjectRef recheckPassed2;
            Mutex $this$withLock_u24default$iv3;
            Object owner$iv2;
            int $i$f$withLock;
            Ref.ObjectRef recheckPassed3;
            Mutex $this$withLock_u24default$iv4;
            String url4;
            Object obj2;
            AniDb$Companion$appGet$1 aniDb$Companion$appGet$3;
            String url5;
            Map<String, String> map3;
            NiceResponse rawResponse3;
            Ref.ObjectRef recheckPassed4;
            NiceResponse recheck;
            Ref.ObjectRef recheckPassed5;
            NiceResponse rawResponse4;
            String url6;
            NiceResponse it;
            Object obj3;
            if (continuation instanceof AniDb$Companion$appGet$1) {
                aniDb$Companion$appGet$1 = (AniDb$Companion$appGet$1) continuation;
                if ((aniDb$Companion$appGet$1.label & Integer.MIN_VALUE) != 0) {
                    aniDb$Companion$appGet$1.label -= Integer.MIN_VALUE;
                } else {
                    aniDb$Companion$appGet$1 = new AniDb$Companion$appGet$1(this, continuation);
                }
            } else {
                aniDb$Companion$appGet$1 = new AniDb$Companion$appGet$1(this, continuation);
            }
            AniDb$Companion$appGet$1 aniDb$Companion$appGet$4 = aniDb$Companion$appGet$1;
            Object $result = aniDb$Companion$appGet$4.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (aniDb$Companion$appGet$4.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Requests app = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$4.L$0 = url;
                        aniDb$Companion$appGet$4.L$1 = map;
                        aniDb$Companion$appGet$4.label = 1;
                        obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor, false, (ResponseParser) null, aniDb$Companion$appGet$4, 3580, (Object) null);
                        aniDb$Companion$appGet$2 = aniDb$Companion$appGet$4;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        map2 = map;
                        rawResponse = (NiceResponse) obj;
                        if (!isCloudflareBlocked(rawResponse)) {
                            return rawResponse;
                        }
                        recheckPassed = new Ref.ObjectRef();
                        $this$withLock_u24default$iv2 = AniDb.cfBypassMutex;
                        aniDb$Companion$appGet$2.L$0 = url2;
                        aniDb$Companion$appGet$2.L$1 = map2;
                        aniDb$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        aniDb$Companion$appGet$2.L$3 = recheckPassed;
                        aniDb$Companion$appGet$2.L$4 = $this$withLock_u24default$iv2;
                        aniDb$Companion$appGet$2.label = 2;
                        if ($this$withLock_u24default$iv2.lock((Object) null, aniDb$Companion$appGet$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawResponse2 = rawResponse;
                        url3 = url2;
                        recheckPassed2 = recheckPassed;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        owner$iv2 = null;
                        $i$f$withLock = 0;
                        try {
                            Requests app2 = MainActivityKt.getApp();
                            AniDbCFBypassInterceptor aniDbCFBypassInterceptor2 = AniDbCFBypassInterceptor.INSTANCE;
                            aniDb$Companion$appGet$2.L$0 = url3;
                            aniDb$Companion$appGet$2.L$1 = map2;
                            aniDb$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                            aniDb$Companion$appGet$2.L$3 = recheckPassed2;
                            aniDb$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                            aniDb$Companion$appGet$2.label = 3;
                            recheckPassed3 = recheckPassed2;
                            $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                            AniDb$Companion$appGet$1 aniDb$Companion$appGet$5 = aniDb$Companion$appGet$2;
                            url4 = url3;
                            try {
                                obj2 = Requests.get$default(app2, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor2, false, (ResponseParser) null, aniDb$Companion$appGet$5, 3580, (Object) null);
                                aniDb$Companion$appGet$3 = aniDb$Companion$appGet$5;
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                url5 = url4;
                                map3 = map2;
                                owner$iv = owner$iv2;
                                rawResponse3 = rawResponse2;
                                recheckPassed4 = recheckPassed3;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                                $result = obj2;
                                try {
                                    recheck = (NiceResponse) $result;
                                    try {
                                        try {
                                            if (!AniDb.INSTANCE.isCloudflareBlocked(recheck)) {
                                                if (AniDbPlugin.INSTANCE.getCfWebviewEnabled()) {
                                                    aniDb$Companion$appGet$3.L$0 = url5;
                                                    aniDb$Companion$appGet$3.L$1 = map3;
                                                    aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                    aniDb$Companion$appGet$3.L$3 = recheckPassed4;
                                                    aniDb$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                                    aniDb$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                                    aniDb$Companion$appGet$3.label = 4;
                                                    if (AniDbKt.showAniDbCFBypassDialogAndWait(url5, aniDb$Companion$appGet$3) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    recheckPassed5 = recheckPassed4;
                                                    rawResponse4 = rawResponse3;
                                                    url6 = url5;
                                                }
                                                Unit unit = Unit.INSTANCE;
                                                $this$withLock_u24default$iv.unlock(owner$iv);
                                                it = (NiceResponse) recheckPassed5.element;
                                                if (it != null) {
                                                    return it;
                                                }
                                                Ref.ObjectRef recheckPassed6 = recheckPassed5;
                                                Requests app3 = MainActivityKt.getApp();
                                                AniDbCFBypassInterceptor aniDbCFBypassInterceptor3 = AniDbCFBypassInterceptor.INSTANCE;
                                                aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                                aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                                aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                                aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed6);
                                                aniDb$Companion$appGet$3.L$4 = null;
                                                aniDb$Companion$appGet$3.L$5 = null;
                                                aniDb$Companion$appGet$3.label = 5;
                                                obj3 = Requests.get$default(app3, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor3, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                                                if (obj3 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                return obj3;
                                            }
                                            recheckPassed4.element = recheck;
                                            Unit unit2 = Unit.INSTANCE;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            it = (NiceResponse) recheckPassed5.element;
                                            if (it != null) {
                                                return it;
                                            }
                                            Ref.ObjectRef recheckPassed7 = recheckPassed5;
                                            Requests app4 = MainActivityKt.getApp();
                                            AniDbCFBypassInterceptor aniDbCFBypassInterceptor4 = AniDbCFBypassInterceptor.INSTANCE;
                                            aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                            aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                            aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                            aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed7);
                                            aniDb$Companion$appGet$3.L$4 = null;
                                            aniDb$Companion$appGet$3.L$5 = null;
                                            aniDb$Companion$appGet$3.label = 5;
                                            obj3 = Requests.get$default(app4, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor4, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return obj3;
                                        } catch (Throwable th) {
                                            th = th;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            throw th;
                                        }
                                        recheckPassed5 = recheckPassed4;
                                        rawResponse4 = rawResponse3;
                                        url6 = url5;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                owner$iv = owner$iv2;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                                $this$withLock_u24default$iv.unlock(owner$iv);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            owner$iv = owner$iv2;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                        }
                        break;
                    case 1:
                        map2 = (Map) aniDb$Companion$appGet$4.L$1;
                        url2 = (String) aniDb$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        aniDb$Companion$appGet$2 = aniDb$Companion$appGet$4;
                        obj = $result;
                        rawResponse = (NiceResponse) obj;
                        if (!isCloudflareBlocked(rawResponse)) {
                            return rawResponse;
                        }
                        recheckPassed = new Ref.ObjectRef();
                        $this$withLock_u24default$iv2 = AniDb.cfBypassMutex;
                        aniDb$Companion$appGet$2.L$0 = url2;
                        aniDb$Companion$appGet$2.L$1 = map2;
                        aniDb$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        aniDb$Companion$appGet$2.L$3 = recheckPassed;
                        aniDb$Companion$appGet$2.L$4 = $this$withLock_u24default$iv2;
                        aniDb$Companion$appGet$2.label = 2;
                        if ($this$withLock_u24default$iv2.lock((Object) null, aniDb$Companion$appGet$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawResponse2 = rawResponse;
                        url3 = url2;
                        recheckPassed2 = recheckPassed;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        owner$iv2 = null;
                        $i$f$withLock = 0;
                        Requests app5 = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor5 = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$2.L$0 = url3;
                        aniDb$Companion$appGet$2.L$1 = map2;
                        aniDb$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        aniDb$Companion$appGet$2.L$3 = recheckPassed2;
                        aniDb$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                        aniDb$Companion$appGet$2.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        AniDb$Companion$appGet$1 aniDb$Companion$appGet$6 = aniDb$Companion$appGet$2;
                        url4 = url3;
                        obj2 = Requests.get$default(app5, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor5, false, (ResponseParser) null, aniDb$Companion$appGet$6, 3580, (Object) null);
                        aniDb$Companion$appGet$3 = aniDb$Companion$appGet$6;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url4;
                        map3 = map2;
                        owner$iv = owner$iv2;
                        rawResponse3 = rawResponse2;
                        recheckPassed4 = recheckPassed3;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                        $result = obj2;
                        recheck = (NiceResponse) $result;
                        if (!AniDb.INSTANCE.isCloudflareBlocked(recheck)) {
                            if (AniDbPlugin.INSTANCE.getCfWebviewEnabled()) {
                                aniDb$Companion$appGet$3.L$0 = url5;
                                aniDb$Companion$appGet$3.L$1 = map3;
                                aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                aniDb$Companion$appGet$3.L$3 = recheckPassed4;
                                aniDb$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                aniDb$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                aniDb$Companion$appGet$3.label = 4;
                                if (AniDbKt.showAniDbCFBypassDialogAndWait(url5, aniDb$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                recheckPassed5 = recheckPassed4;
                                rawResponse4 = rawResponse3;
                                url6 = url5;
                            }
                            Unit unit3 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            it = (NiceResponse) recheckPassed5.element;
                            if (it != null) {
                                return it;
                            }
                            Ref.ObjectRef recheckPassed8 = recheckPassed5;
                            Requests app6 = MainActivityKt.getApp();
                            AniDbCFBypassInterceptor aniDbCFBypassInterceptor6 = AniDbCFBypassInterceptor.INSTANCE;
                            aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed8);
                            aniDb$Companion$appGet$3.L$4 = null;
                            aniDb$Companion$appGet$3.L$5 = null;
                            aniDb$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app6, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor6, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj3;
                        }
                        recheckPassed4.element = recheck;
                        recheckPassed5 = recheckPassed4;
                        rawResponse4 = rawResponse3;
                        url6 = url5;
                        Unit unit4 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed9 = recheckPassed5;
                        Requests app7 = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor7 = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed9);
                        aniDb$Companion$appGet$3.L$4 = null;
                        aniDb$Companion$appGet$3.L$5 = null;
                        aniDb$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app7, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor7, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 2:
                        Mutex $this$withLock_u24default$iv5 = (Mutex) aniDb$Companion$appGet$4.L$4;
                        Ref.ObjectRef recheckPassed10 = (Ref.ObjectRef) aniDb$Companion$appGet$4.L$3;
                        NiceResponse rawResponse5 = (NiceResponse) aniDb$Companion$appGet$4.L$2;
                        Map<String, String> map4 = (Map) aniDb$Companion$appGet$4.L$1;
                        url3 = (String) aniDb$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withLock = 0;
                        owner$iv2 = null;
                        recheckPassed2 = recheckPassed10;
                        rawResponse2 = rawResponse5;
                        map2 = map4;
                        aniDb$Companion$appGet$2 = aniDb$Companion$appGet$4;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                        Requests app8 = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor8 = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$2.L$0 = url3;
                        aniDb$Companion$appGet$2.L$1 = map2;
                        aniDb$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        aniDb$Companion$appGet$2.L$3 = recheckPassed2;
                        aniDb$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                        aniDb$Companion$appGet$2.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        AniDb$Companion$appGet$1 aniDb$Companion$appGet$7 = aniDb$Companion$appGet$2;
                        url4 = url3;
                        obj2 = Requests.get$default(app8, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor8, false, (ResponseParser) null, aniDb$Companion$appGet$7, 3580, (Object) null);
                        aniDb$Companion$appGet$3 = aniDb$Companion$appGet$7;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url4;
                        map3 = map2;
                        owner$iv = owner$iv2;
                        rawResponse3 = rawResponse2;
                        recheckPassed4 = recheckPassed3;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                        $result = obj2;
                        recheck = (NiceResponse) $result;
                        if (!AniDb.INSTANCE.isCloudflareBlocked(recheck)) {
                            if (AniDbPlugin.INSTANCE.getCfWebviewEnabled()) {
                                aniDb$Companion$appGet$3.L$0 = url5;
                                aniDb$Companion$appGet$3.L$1 = map3;
                                aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                aniDb$Companion$appGet$3.L$3 = recheckPassed4;
                                aniDb$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                aniDb$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                aniDb$Companion$appGet$3.label = 4;
                                if (AniDbKt.showAniDbCFBypassDialogAndWait(url5, aniDb$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                recheckPassed5 = recheckPassed4;
                                rawResponse4 = rawResponse3;
                                url6 = url5;
                            }
                            Unit unit5 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            it = (NiceResponse) recheckPassed5.element;
                            if (it != null) {
                                return it;
                            }
                            Ref.ObjectRef recheckPassed11 = recheckPassed5;
                            Requests app9 = MainActivityKt.getApp();
                            AniDbCFBypassInterceptor aniDbCFBypassInterceptor9 = AniDbCFBypassInterceptor.INSTANCE;
                            aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed11);
                            aniDb$Companion$appGet$3.L$4 = null;
                            aniDb$Companion$appGet$3.L$5 = null;
                            aniDb$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app9, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor9, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj3;
                        }
                        recheckPassed4.element = recheck;
                        recheckPassed5 = recheckPassed4;
                        rawResponse4 = rawResponse3;
                        url6 = url5;
                        Unit unit6 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed12 = recheckPassed5;
                        Requests app10 = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor10 = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed12);
                        aniDb$Companion$appGet$3.L$4 = null;
                        aniDb$Companion$appGet$3.L$5 = null;
                        aniDb$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app10, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor10, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 3:
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) aniDb$Companion$appGet$4.L$4;
                        recheckPassed4 = (Ref.ObjectRef) aniDb$Companion$appGet$4.L$3;
                        rawResponse3 = (NiceResponse) aniDb$Companion$appGet$4.L$2;
                        map3 = (Map) aniDb$Companion$appGet$4.L$1;
                        url5 = (String) aniDb$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        aniDb$Companion$appGet$3 = aniDb$Companion$appGet$4;
                        recheck = (NiceResponse) $result;
                        if (!AniDb.INSTANCE.isCloudflareBlocked(recheck)) {
                            if (AniDbPlugin.INSTANCE.getCfWebviewEnabled()) {
                                aniDb$Companion$appGet$3.L$0 = url5;
                                aniDb$Companion$appGet$3.L$1 = map3;
                                aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                aniDb$Companion$appGet$3.L$3 = recheckPassed4;
                                aniDb$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                aniDb$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                aniDb$Companion$appGet$3.label = 4;
                                if (AniDbKt.showAniDbCFBypassDialogAndWait(url5, aniDb$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                recheckPassed5 = recheckPassed4;
                                rawResponse4 = rawResponse3;
                                url6 = url5;
                            }
                            Unit unit7 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            it = (NiceResponse) recheckPassed5.element;
                            if (it != null) {
                                return it;
                            }
                            Ref.ObjectRef recheckPassed13 = recheckPassed5;
                            Requests app11 = MainActivityKt.getApp();
                            AniDbCFBypassInterceptor aniDbCFBypassInterceptor11 = AniDbCFBypassInterceptor.INSTANCE;
                            aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed13);
                            aniDb$Companion$appGet$3.L$4 = null;
                            aniDb$Companion$appGet$3.L$5 = null;
                            aniDb$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app11, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor11, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj3;
                        }
                        recheckPassed4.element = recheck;
                        recheckPassed5 = recheckPassed4;
                        rawResponse4 = rawResponse3;
                        url6 = url5;
                        Unit unit8 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed14 = recheckPassed5;
                        Requests app12 = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor12 = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed14);
                        aniDb$Companion$appGet$3.L$4 = null;
                        aniDb$Companion$appGet$3.L$5 = null;
                        aniDb$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app12, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor12, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 4:
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) aniDb$Companion$appGet$4.L$4;
                        recheckPassed4 = (Ref.ObjectRef) aniDb$Companion$appGet$4.L$3;
                        rawResponse3 = (NiceResponse) aniDb$Companion$appGet$4.L$2;
                        map3 = (Map) aniDb$Companion$appGet$4.L$1;
                        url5 = (String) aniDb$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        aniDb$Companion$appGet$3 = aniDb$Companion$appGet$4;
                        recheckPassed5 = recheckPassed4;
                        rawResponse4 = rawResponse3;
                        url6 = url5;
                        Unit unit9 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed15 = recheckPassed5;
                        Requests app13 = MainActivityKt.getApp();
                        AniDbCFBypassInterceptor aniDbCFBypassInterceptor13 = AniDbCFBypassInterceptor.INSTANCE;
                        aniDb$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        aniDb$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        aniDb$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        aniDb$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed15);
                        aniDb$Companion$appGet$3.L$4 = null;
                        aniDb$Companion$appGet$3.L$5 = null;
                        aniDb$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app13, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, aniDbCFBypassInterceptor13, false, (ResponseParser) null, aniDb$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 5:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final List<AnimeSearchResponse> searchResponseBuilder(Document res) {
        String strOwnText;
        List results = new ArrayList();
        Iterable $this$forEach$iv = res.select("a.anime-card");
        for (Object element$iv : $this$forEach$iv) {
            Element item = (Element) element$iv;
            String title = item.attr("title");
            String url = item.attr("href");
            Element elementSelectFirst = item.selectFirst("img");
            final Double rating = null;
            final String posterUrl = elementSelectFirst != null ? elementSelectFirst.attr("src") : null;
            Element elementSelectFirst2 = item.selectFirst("span.badge-gray");
            String ratingText = (elementSelectFirst2 == null || (strOwnText = elementSelectFirst2.ownText()) == null) ? null : StringsKt.trim(strOwnText).toString();
            if (ratingText != null) {
                String strReplace = new Regex("[^0-9.]").replace(ratingText, "");
                if (strReplace != null) {
                    rating = StringsKt.toDoubleOrNull(strReplace);
                }
            }
            results.add(MainAPIKt.newAnimeSearchResponse$default(this, title, url, (TvType) null, false, new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return AniDb.searchResponseBuilder$lambda$0$0(posterUrl, rating, (AnimeSearchResponse) obj);
                }
            }, 12, (Object) null));
            results = results;
        }
        return results;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchResponseBuilder$lambda$0$0(String $posterUrl, Double $rating, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        if ($rating != null) {
            $this$newAnimeSearchResponse.setScore(Score.Companion.from10(String.valueOf($rating.doubleValue())));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        Object objAppGet$default;
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
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = request.getData() + page;
                Companion companion = INSTANCE;
                c00002.L$0 = request;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.I$0 = page;
                c00002.label = 1;
                objAppGet$default = Companion.appGet$default(companion, url, null, c00002, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int page2 = c00002.I$0;
                request = (MainPageRequest) c00002.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document res = ((NiceResponse) objAppGet$default).getDocument();
        return MainAPIKt.newHomePageResponse$default(request.getName(), searchResponseBuilder(res), (Boolean) null, 4, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00051 c00051;
        Object objAppGet$default;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Companion companion = INSTANCE;
                String str = getMainUrl() + "/browse?q=" + query;
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00052.I$0 = page;
                c00052.label = 1;
                objAppGet$default = Companion.appGet$default(companion, str, null, c00052, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int page2 = c00052.I$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document browseRes = ((NiceResponse) objAppGet$default).getDocument();
        return MainAPIKt.toNewSearchResponseList$default(searchResponseBuilder(browseRes), (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x053b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0547  */
    /* JADX WARN: Code duplicated, block: B:105:0x054c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0566  */
    /* JADX WARN: Code duplicated, block: B:110:0x05e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:111:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:119:0x0618  */
    /* JADX WARN: Code duplicated, block: B:121:0x061e  */
    /* JADX WARN: Code duplicated, block: B:124:0x062a  */
    /* JADX WARN: Code duplicated, block: B:126:0x0634  */
    /* JADX WARN: Code duplicated, block: B:129:0x064c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0656  */
    /* JADX WARN: Code duplicated, block: B:134:0x0682  */
    /* JADX WARN: Code duplicated, block: B:135:0x068e  */
    /* JADX WARN: Code duplicated, block: B:138:0x0697  */
    /* JADX WARN: Code duplicated, block: B:140:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:141:0x06b1  */
    /* JADX WARN: Code duplicated, block: B:145:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:146:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:149:0x06c0 A[LOOP:4: B:130:0x0650->B:149:0x06c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:153:0x06df  */
    /* JADX WARN: Code duplicated, block: B:154:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:158:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:161:0x070d  */
    /* JADX WARN: Code duplicated, block: B:164:0x0717  */
    /* JADX WARN: Code duplicated, block: B:166:0x073f  */
    /* JADX WARN: Code duplicated, block: B:167:0x074b  */
    /* JADX WARN: Code duplicated, block: B:170:0x0754  */
    /* JADX WARN: Code duplicated, block: B:172:0x0764  */
    /* JADX WARN: Code duplicated, block: B:173:0x076e  */
    /* JADX WARN: Code duplicated, block: B:177:0x0776  */
    /* JADX WARN: Code duplicated, block: B:178:0x0778  */
    /* JADX WARN: Code duplicated, block: B:181:0x077d A[LOOP:3: B:162:0x0711->B:181:0x077d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x07b6  */
    /* JADX WARN: Code duplicated, block: B:187:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:189:0x0809  */
    /* JADX WARN: Code duplicated, block: B:191:0x0816  */
    /* JADX WARN: Code duplicated, block: B:193:0x0821  */
    /* JADX WARN: Code duplicated, block: B:194:0x0826  */
    /* JADX WARN: Code duplicated, block: B:195:0x082b  */
    /* JADX WARN: Code duplicated, block: B:196:0x0835  */
    /* JADX WARN: Code duplicated, block: B:200:0x084e  */
    /* JADX WARN: Code duplicated, block: B:208:0x086f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:212:0x0876  */
    /* JADX WARN: Code duplicated, block: B:214:0x0935 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:215:0x0936  */
    /* JADX WARN: Code duplicated, block: B:217:0x0972  */
    /* JADX WARN: Code duplicated, block: B:219:0x0995  */
    /* JADX WARN: Code duplicated, block: B:221:0x0a2c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:222:0x0a2d  */
    /* JADX WARN: Code duplicated, block: B:224:0x0a67  */
    /* JADX WARN: Code duplicated, block: B:227:0x0a93  */
    /* JADX WARN: Code duplicated, block: B:228:0x0a9a  */
    /* JADX WARN: Code duplicated, block: B:231:0x0a9f  */
    /* JADX WARN: Code duplicated, block: B:244:0x0add  */
    /* JADX WARN: Code duplicated, block: B:248:0x0ae9  */
    /* JADX WARN: Code duplicated, block: B:249:0x0aeb  */
    /* JADX WARN: Code duplicated, block: B:253:0x0afc  */
    /* JADX WARN: Code duplicated, block: B:255:0x0b04  */
    /* JADX WARN: Code duplicated, block: B:258:0x0b13  */
    /* JADX WARN: Code duplicated, block: B:260:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:261:0x0b28  */
    /* JADX WARN: Code duplicated, block: B:262:0x0b2b  */
    /* JADX WARN: Code duplicated, block: B:265:0x0b32  */
    /* JADX WARN: Code duplicated, block: B:271:0x0b4c  */
    /* JADX WARN: Code duplicated, block: B:273:0x0b52  */
    /* JADX WARN: Code duplicated, block: B:276:0x0b63  */
    /* JADX WARN: Code duplicated, block: B:278:0x0b68  */
    /* JADX WARN: Code duplicated, block: B:279:0x0b6a  */
    /* JADX WARN: Code duplicated, block: B:282:0x0b79  */
    /* JADX WARN: Code duplicated, block: B:284:0x0b7e  */
    /* JADX WARN: Code duplicated, block: B:285:0x0b96  */
    /* JADX WARN: Code duplicated, block: B:286:0x0b99  */
    /* JADX WARN: Code duplicated, block: B:289:0x0b9f  */
    /* JADX WARN: Code duplicated, block: B:28:0x036d  */
    /* JADX WARN: Code duplicated, block: B:290:0x0ba6  */
    /* JADX WARN: Code duplicated, block: B:292:0x0baa  */
    /* JADX WARN: Code duplicated, block: B:293:0x0bb1  */
    /* JADX WARN: Code duplicated, block: B:295:0x0bb5  */
    /* JADX WARN: Code duplicated, block: B:298:0x0bc7  */
    /* JADX WARN: Code duplicated, block: B:300:0x0bcd  */
    /* JADX WARN: Code duplicated, block: B:301:0x0bd4  */
    /* JADX WARN: Code duplicated, block: B:303:0x0bd8  */
    /* JADX WARN: Code duplicated, block: B:304:0x0bdf  */
    /* JADX WARN: Code duplicated, block: B:307:0x0be5  */
    /* JADX WARN: Code duplicated, block: B:308:0x0c1d  */
    /* JADX WARN: Code duplicated, block: B:310:0x0c23  */
    /* JADX WARN: Code duplicated, block: B:313:0x0c58  */
    /* JADX WARN: Code duplicated, block: B:318:0x0ca6  */
    /* JADX WARN: Code duplicated, block: B:319:0x0ca9  */
    /* JADX WARN: Code duplicated, block: B:322:0x0cb4  */
    /* JADX WARN: Code duplicated, block: B:323:0x0cbd  */
    /* JADX WARN: Code duplicated, block: B:326:0x0cc7  */
    /* JADX WARN: Code duplicated, block: B:327:0x0ccc  */
    /* JADX WARN: Code duplicated, block: B:330:0x0cd6  */
    /* JADX WARN: Code duplicated, block: B:331:0x0cdb  */
    /* JADX WARN: Code duplicated, block: B:333:0x0ce3  */
    /* JADX WARN: Code duplicated, block: B:334:0x0ce8  */
    /* JADX WARN: Code duplicated, block: B:338:0x0d08  */
    /* JADX WARN: Code duplicated, block: B:33:0x0380  */
    /* JADX WARN: Code duplicated, block: B:340:0x0d30  */
    /* JADX WARN: Code duplicated, block: B:344:0x0d42  */
    /* JADX WARN: Code duplicated, block: B:347:0x0d46 A[LOOP:2: B:336:0x0cfa->B:347:0x0d46, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:351:0x0d68  */
    /* JADX WARN: Code duplicated, block: B:352:0x0d6d  */
    /* JADX WARN: Code duplicated, block: B:355:0x0d71  */
    /* JADX WARN: Code duplicated, block: B:357:0x0d7f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0388  */
    /* JADX WARN: Code duplicated, block: B:368:0x0dc1  */
    /* JADX WARN: Code duplicated, block: B:36:0x038d  */
    /* JADX WARN: Code duplicated, block: B:370:0x0dcd  */
    /* JADX WARN: Code duplicated, block: B:372:0x0dd7  */
    /* JADX WARN: Code duplicated, block: B:373:0x0ddc  */
    /* JADX WARN: Code duplicated, block: B:375:0x0de4  */
    /* JADX WARN: Code duplicated, block: B:377:0x0dfa  */
    /* JADX WARN: Code duplicated, block: B:380:0x0e04  */
    /* JADX WARN: Code duplicated, block: B:381:0x0e07  */
    /* JADX WARN: Code duplicated, block: B:384:0x0ed6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:385:0x0ed7  */
    /* JADX WARN: Code duplicated, block: B:402:0x0d55 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:403:0x0d63 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:404:0x078a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x077b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:406:0x06cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:407:0x06be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:0x0465 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:410:0x046d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x039d  */
    /* JADX WARN: Code duplicated, block: B:43:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:44:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x03d4 A[LOOP:5: B:46:0x03ce->B:48:0x03d4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x0423  */
    /* JADX WARN: Code duplicated, block: B:62:0x0438  */
    /* JADX WARN: Code duplicated, block: B:65:0x045e A[LOOP:6: B:60:0x0432->B:65:0x045e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x0482  */
    /* JADX WARN: Code duplicated, block: B:74:0x0485  */
    /* JADX WARN: Code duplicated, block: B:76:0x0497  */
    /* JADX WARN: Code duplicated, block: B:77:0x049c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x04f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:99:0x0535  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v89 */
    /* JADX WARN: Type inference failed for: r11v95 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r30v2, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r60v0 */
    /* JADX WARN: Type inference failed for: r60v1, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r60v2 */
    /* JADX WARN: Type inference failed for: r62v0 */
    /* JADX WARN: Type inference failed for: r62v1 */
    /* JADX WARN: Type inference failed for: r62v2, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r62v3 */
    /* JADX WARN: Type inference failed for: r63v0 */
    /* JADX WARN: Type inference failed for: r63v1 */
    /* JADX WARN: Type inference failed for: r63v2, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r63v3 */
    /* JADX WARN: Type inference failed for: r70v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r70v15 */
    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) throws Throwable {
        C00011 c00011;
        C00011 c00012;
        String str2;
        String str3;
        Object objAppGet$default;
        String str4;
        String str5;
        int i;
        Document document;
        Element elementSelectFirst;
        String strText;
        Element elementSelectFirst2;
        Element elementSelectFirst3;
        String strAttr;
        Element elementSelectFirst4;
        Element elementSelectFirst5;
        String strText2;
        Object obj;
        ArrayList arrayList;
        Iterable iterable;
        Iterator it;
        ArrayList arrayList2;
        Element elementSelectFirst6;
        Integer intOrNull;
        Iterable iterableSelect;
        Iterator it2;
        Object obj2;
        String str6;
        Object next;
        Element element;
        String string;
        String str7;
        Double doubleOrNull;
        String str8;
        String str9;
        Object objAppGet;
        Object obj3;
        String str10;
        Double d;
        int i2;
        Object obj4;
        String str11;
        String strOwnText;
        Iterable iterable2;
        String strText3;
        List listSplit$default;
        String str12;
        Object obj5;
        String str13;
        Object safe;
        EpisodesResponse episodesResponse;
        List<EpisodeItem> listEmptyList;
        EpisodeItem episodeItem;
        Integer id;
        Ref.BooleanRef booleanRef;
        EpisodesResponse episodesResponse2;
        Integer num;
        Ref.BooleanRef booleanRef2;
        String str14;
        String str15;
        Object obj6;
        Double d2;
        Integer num2;
        List<EpisodeItem> list;
        Ref.BooleanRef booleanRef3;
        String str16;
        Document document2;
        Ref.BooleanRef booleanRef4;
        int i3;
        EpisodesResponse episodesResponse3;
        Integer num3;
        String str17;
        String str18;
        String str19;
        String str20;
        int i4;
        Object objAppGet2;
        String str21;
        Document document3;
        String str22;
        String str23;
        Ref.BooleanRef booleanRef5;
        List<EpisodeItem> list2;
        Ref.BooleanRef booleanRef6;
        Double d3;
        Object obj7;
        ArrayList arrayList3;
        String str24;
        ArrayList arrayList4;
        int i5;
        Element elementSelectFirst7;
        ArrayList arrayList5;
        List<EpisodeItem> list3;
        Ref.BooleanRef booleanRef7;
        Ref.BooleanRef booleanRef8;
        String str25;
        String str26;
        String str27;
        Object intOrNull2;
        Element elementSelectFirst8;
        String str28;
        ?? r1;
        ?? r70;
        List list4;
        Integer num4;
        Double d4;
        ArrayList arrayList6;
        String str29;
        String str30;
        Ref.BooleanRef booleanRef9;
        Ref.BooleanRef booleanRef10;
        List<EpisodeItem> list5;
        int i6;
        String str31;
        ?? r30;
        Object obj8;
        ?? r63;
        Integer num5;
        String str32;
        List list6;
        String str33;
        String str34;
        String str35;
        String str36;
        EpisodesResponse episodesResponse4;
        Integer num6;
        ?? r62;
        Double d5;
        Ref.BooleanRef booleanRef11;
        List list7;
        List list8;
        int i7;
        Ref.BooleanRef booleanRef12;
        String text;
        Document document4;
        List list9;
        ?? r11;
        Double d6;
        List list10;
        String str37;
        String str38;
        String str39;
        String str40;
        ?? r4;
        Ref.BooleanRef booleanRef13;
        ArrayList arrayList7;
        Double d7;
        List list11;
        ?? r71;
        Ref.BooleanRef booleanRef14;
        int i8;
        Integer num7;
        Object obj9;
        List list12;
        String str41;
        Double d8;
        Ref.BooleanRef booleanRef15;
        Ref.BooleanRef booleanRef16;
        ?? r5;
        String str42;
        String str43;
        Object obj10;
        List list13;
        String str44;
        String strAttr2;
        String strSubstringBefore$default;
        Integer intOrNull3;
        String strAttr3;
        String strSubstringAfter$default;
        String strSubstringBefore$default2;
        Object safe2;
        LanguagesResponse languagesResponse;
        List<Language> listEmptyList2;
        int i9;
        String str45;
        List<Language> list14;
        String str46;
        boolean z;
        List<Language> list15;
        int i10;
        Iterator it3;
        Ref.BooleanRef booleanRef17;
        boolean z2;
        Language language;
        List<Language> list16;
        int i11;
        List listListOf;
        String code;
        String lowerCase;
        boolean z3;
        List listListOf2;
        String name;
        String lowerCase2;
        List<Language> list17;
        Iterator it4;
        boolean z4;
        Language language2;
        Iterator it5;
        List listListOf3;
        String str47;
        String code2;
        String lowerCase3;
        boolean z5;
        List listListOf4;
        String name2;
        String lowerCase4;
        MetaAnimeData animeData;
        MetaAnimeData metaAnimeData;
        String str48;
        int i12;
        List<EpisodeItem> list18;
        int i13;
        int i14;
        TvType tvType;
        Element elementSelectFirst9;
        String strAttr4;
        Element elementSelectFirst10;
        String strText4;
        ShowStatus showStatus;
        Iterator it6;
        Document document5;
        List list19;
        String str49;
        List list20;
        Ref.BooleanRef booleanRef18;
        Ref.BooleanRef booleanRef19;
        String str50;
        int i15;
        boolean z6;
        String str51;
        Object next2;
        Element element2;
        String strText5;
        String str52;
        ?? r60;
        boolean z7;
        Integer intOrNull4;
        Integer intOrNull5;
        int iIntValue;
        Element element3;
        boolean z8;
        EpisodeItem episodeItem2;
        final int i16;
        String str53;
        MetaEpisode metaEpisode;
        MetaEpisode metaEpisode2;
        String str54;
        String str55;
        String str56;
        final String str57;
        String str58;
        Map<String, String> title;
        Map<String, String> title2;
        final String overview;
        final String image;
        final Score scoreFrom10;
        final Integer runtime;
        final String airDateUtc;
        String rating;
        Map<String, String> title3;
        Map<String, MetaEpisode> episodes;
        List<ImageData> images;
        Object next3;
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
        Object objNewAnimeLoadResponse$default = c00013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str59 = "en";
        String str60 = "ja";
        switch (c00013.label) {
            case 0:
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(str, "/", (String) null, 2, (Object) null);
                Integer intOrNull6 = StringsKt.toIntOrNull(StringsKt.substringAfterLast$default(strSubstringAfterLast$default, "-", (String) null, 2, (Object) null));
                if (intOrNull6 == null) {
                    return null;
                }
                int iIntValue2 = intOrNull6.intValue();
                Companion companion = INSTANCE;
                c00013.L$0 = str;
                c00013.L$1 = strSubstringAfterLast$default;
                c00013.I$0 = iIntValue2;
                c00013.label = 1;
                c00012 = c00013;
                str2 = "/";
                str3 = "href";
                objAppGet$default = Companion.appGet$default(companion, str, null, c00012, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str4 = str;
                str5 = strSubstringAfterLast$default;
                i = iIntValue2;
                document = ((NiceResponse) objAppGet$default).getDocument();
                elementSelectFirst = document.selectFirst("h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = "";
                }
                elementSelectFirst2 = document.selectFirst("div.flex-shrink-0 img");
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("src")) == null) {
                    elementSelectFirst3 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                elementSelectFirst4 = document.selectFirst("meta[name=description]");
                if (elementSelectFirst4 != null || (strText2 = elementSelectFirst4.attr("content")) == null) {
                    elementSelectFirst5 = document.selectFirst(".description");
                    if (elementSelectFirst5 != null) {
                        strText2 = elementSelectFirst5.text();
                    } else {
                        strText2 = null;
                    }
                }
                Iterable iterableSelect2 = document.select("a.filter-chip");
                obj = objNewAnimeLoadResponse$default;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableSelect2, 10));
                iterable = iterableSelect2;
                it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Element) it.next()).text());
                    iterable = iterable;
                }
                arrayList2 = arrayList;
                elementSelectFirst6 = document.selectFirst("a[href*=&year=]");
                if (elementSelectFirst6 != null || (strText3 = elementSelectFirst6.text()) == null || (listSplit$default = StringsKt.split$default(strText3, new String[]{" "}, false, 0, 6, (Object) null)) == null || (str12 = (String) CollectionsKt.lastOrNull(listSplit$default)) == null) {
                    intOrNull = null;
                } else {
                    intOrNull = StringsKt.toIntOrNull(str12);
                }
                iterableSelect = document.select("span.badge-gray");
                it2 = iterableSelect.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        iterable2 = iterableSelect;
                        str6 = str60;
                        obj2 = coroutine_suspended;
                        if (new Regex("[0-9]").containsMatchIn(((Element) next).text())) {
                            iterableSelect = iterable2;
                            str60 = str6;
                            coroutine_suspended = obj2;
                        }
                    } else {
                        obj2 = coroutine_suspended;
                        str6 = str60;
                        next = null;
                    }
                }
                element = (Element) next;
                if (element != null || (strOwnText = element.ownText()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strOwnText).toString();
                }
                if (string != null) {
                    str7 = string;
                    String strReplace = new Regex("[^0-9.]").replace(string, "");
                    doubleOrNull = strReplace != null ? StringsKt.toDoubleOrNull(strReplace) : null;
                    str8 = getMainUrl() + "/api/frontend/anime/" + i + "/episodes";
                    Companion companion2 = INSTANCE;
                    Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = strText2;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = intOrNull;
                    str9 = strText2;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                    c00012.L$9 = doubleOrNull;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str8);
                    c00012.I$0 = i;
                    c00012.label = 2;
                    objAppGet = companion2.appGet(str8, mapMapOf, c00012);
                    obj3 = obj2;
                    if (objAppGet == obj3) {
                        return obj3;
                    }
                    str10 = str8;
                    d = doubleOrNull;
                    i2 = i;
                    obj4 = objAppGet;
                    str11 = str9;
                    NiceResponse niceResponse = (NiceResponse) obj4;
                    try {
                        ResponseParser parser = niceResponse.getParser();
                        Intrinsics.checkNotNull(parser);
                        str13 = str10;
                        try {
                            obj5 = obj3;
                            try {
                                safe = parser.parseSafe(niceResponse.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                                while (true) {
                                    document5 = document2;
                                    list19 = list8;
                                    if (it6.hasNext()) {
                                        next2 = it6.next();
                                        element3 = (Element) next2;
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                            z8 = true;
                                        } else {
                                            z8 = true;
                                        }
                                        if (z8) {
                                            document2 = document5;
                                            booleanRef12 = booleanRef18;
                                            str5 = str49;
                                            booleanRef11 = booleanRef19;
                                            strText4 = str50;
                                            list7 = list20;
                                            list8 = list19;
                                        }
                                    } else {
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        next2 = null;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                safe = null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            obj5 = obj3;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obj5 = obj3;
                        str13 = str10;
                    }
                    episodesResponse = (EpisodesResponse) safe;
                    if (episodesResponse != null || (listEmptyList = episodesResponse.getEpisodes()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    episodeItem = (EpisodeItem) CollectionsKt.firstOrNull(listEmptyList);
                    if (episodeItem != null) {
                        id = episodeItem.getId();
                    } else {
                        id = null;
                    }
                    booleanRef = new Ref.BooleanRef();
                    episodesResponse2 = episodesResponse;
                    num = id;
                    booleanRef.element = true;
                    booleanRef2 = new Ref.BooleanRef();
                    if (num != null) {
                        int i17 = i2;
                        str19 = getMainUrl() + "/api/frontend/episode/" + num.intValue() + "/languages";
                        Companion companion3 = INSTANCE;
                        Map<String, String> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                        c00012.L$0 = str4;
                        c00012.L$1 = str5;
                        c00012.L$2 = document;
                        c00012.L$3 = strText;
                        c00012.L$4 = strAttr;
                        c00012.L$5 = str11;
                        c00012.L$6 = arrayList2;
                        c00012.L$7 = intOrNull;
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                        c00012.L$9 = d;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(str13);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse2);
                        c00012.L$12 = listEmptyList;
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(num);
                        c00012.L$14 = booleanRef;
                        c00012.L$15 = booleanRef2;
                        c00012.L$16 = SpillingKt.nullOutSpilledVariable(str19);
                        str20 = str11;
                        i4 = i17;
                        c00012.I$0 = i4;
                        c00012.label = 3;
                        objAppGet2 = companion3.appGet(str19, mapMapOf2, c00012);
                        obj6 = obj5;
                        if (objAppGet2 == obj6) {
                            return obj6;
                        }
                        str21 = str7;
                        document3 = document;
                        str22 = str5;
                        str23 = strText;
                        booleanRef5 = booleanRef2;
                        list2 = listEmptyList;
                        booleanRef6 = booleanRef;
                        d3 = d;
                        NiceResponse niceResponse2 = (NiceResponse) objAppGet2;
                        try {
                            ResponseParser parser2 = niceResponse2.getParser();
                            Intrinsics.checkNotNull(parser2);
                            safe2 = parser2.parseSafe(niceResponse2.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            safe2 = null;
                        }
                        languagesResponse = (LanguagesResponse) safe2;
                        if (languagesResponse != null || (listEmptyList2 = languagesResponse.getLanguages()) == null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        if (listEmptyList2.isEmpty()) {
                            i9 = i4;
                            str45 = str4;
                            list14 = listEmptyList2;
                            strAttr = strAttr;
                            str46 = str6;
                        } else {
                            list17 = listEmptyList2;
                            if ((list17 instanceof Collection) || !list17.isEmpty()) {
                                it4 = list17.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        language2 = (Language) it4.next();
                                        it5 = it4;
                                        i9 = i4;
                                        str45 = str4;
                                        str46 = str6;
                                        list14 = listEmptyList2;
                                        listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        str47 = str19;
                                        code2 = language2.getCode();
                                        if (code2 != null) {
                                            lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                        } else {
                                            lowerCase3 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                            z5 = true;
                                        } else {
                                            listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                            name2 = language2.getName();
                                            if (name2 != null) {
                                                lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                            } else {
                                                lowerCase4 = null;
                                            }
                                            if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                        }
                                        if (z5) {
                                            z4 = true;
                                        } else {
                                            str19 = str47;
                                            it4 = it5;
                                            i4 = i9;
                                            listEmptyList2 = list14;
                                            strAttr = strAttr;
                                            str6 = str46;
                                            str4 = str45;
                                        }
                                    } else {
                                        i9 = i4;
                                        str45 = str4;
                                        list14 = listEmptyList2;
                                        strAttr = strAttr;
                                        str46 = str6;
                                        z4 = false;
                                    }
                                }
                            } else {
                                i9 = i4;
                                str45 = str4;
                                list14 = listEmptyList2;
                                strAttr = strAttr;
                                str46 = str6;
                                z4 = false;
                            }
                            if (z4) {
                                z = false;
                            }
                            booleanRef6.element = z;
                            list15 = list14;
                            i10 = 0;
                            if ((list15 instanceof Collection) || !list15.isEmpty()) {
                                it3 = list15.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        language = (Language) it3.next();
                                        list16 = list15;
                                        i11 = i10;
                                        str14 = str59;
                                        booleanRef17 = booleanRef6;
                                        listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        str15 = str46;
                                        code = language.getCode();
                                        if (code != null) {
                                            lowerCase = code.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        } else {
                                            lowerCase = null;
                                        }
                                        if (CollectionsKt.contains(listListOf, lowerCase)) {
                                            z3 = true;
                                        } else {
                                            listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                            name = language.getName();
                                            if (name != null) {
                                                lowerCase2 = name.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                            } else {
                                                lowerCase2 = null;
                                            }
                                            if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        if (z3) {
                                            z2 = true;
                                        } else {
                                            str46 = str15;
                                            list15 = list16;
                                            booleanRef6 = booleanRef17;
                                            it3 = it3;
                                            str59 = str14;
                                            i10 = i11;
                                        }
                                    } else {
                                        booleanRef17 = booleanRef6;
                                        str14 = str59;
                                        str15 = str46;
                                        z2 = false;
                                    }
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                z2 = false;
                                str15 = str46;
                            }
                            booleanRef5.element = z2;
                            booleanRef3 = booleanRef5;
                            num2 = intOrNull;
                            str16 = str21;
                            strText = str23;
                            document2 = document3;
                            str5 = str22;
                            booleanRef4 = booleanRef17;
                            i3 = i9;
                            str4 = str45;
                            strAttr = strAttr;
                            list = list2;
                            d2 = d3;
                            episodesResponse3 = episodesResponse2;
                            str17 = str20;
                            num3 = num;
                            str18 = str13;
                        }
                        z = true;
                        booleanRef6.element = z;
                        list15 = list14;
                        i10 = 0;
                        if (list15 instanceof Collection) {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        } else {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        }
                        booleanRef5.element = z2;
                        booleanRef3 = booleanRef5;
                        num2 = intOrNull;
                        str16 = str21;
                        strText = str23;
                        document2 = document3;
                        str5 = str22;
                        booleanRef4 = booleanRef17;
                        i3 = i9;
                        str4 = str45;
                        strAttr = strAttr;
                        list = list2;
                        d2 = d3;
                        episodesResponse3 = episodesResponse2;
                        str17 = str20;
                        num3 = num;
                        str18 = str13;
                        break;
                    } else {
                        String str61 = str11;
                        str14 = str59;
                        str15 = str6;
                        obj6 = obj5;
                        d2 = d;
                        num2 = intOrNull;
                        list = listEmptyList;
                        booleanRef3 = booleanRef2;
                        str16 = str7;
                        document2 = document;
                        booleanRef4 = booleanRef;
                        i3 = i2;
                        episodesResponse3 = episodesResponse2;
                        num3 = num;
                        str17 = str61;
                        str18 = str13;
                    }
                    obj7 = obj6;
                    arrayList3 = new ArrayList();
                    str24 = str14;
                    arrayList4 = new ArrayList();
                    i5 = i3;
                    elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                    if (elementSelectFirst7 != null) {
                        arrayList5 = arrayList3;
                        str25 = str3;
                        strAttr3 = elementSelectFirst7.attr(str25);
                        if (strAttr3 != null) {
                            booleanRef7 = booleanRef3;
                            booleanRef8 = booleanRef4;
                            str27 = null;
                            strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                            if (strSubstringAfter$default != null) {
                                list3 = list;
                                str26 = str2;
                                strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                                if (strSubstringBefore$default2 != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                                }
                                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                                if (elementSelectFirst8 == null && (strAttr2 = elementSelectFirst8.attr(str25)) != null) {
                                    str28 = str25;
                                    String strSubstringAfter$default2 = StringsKt.substringAfter$default(strAttr2, "anime/", str27, 2, str27);
                                    if (strSubstringAfter$default2 != null && (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringAfter$default2, str26, str27, 2, str27)) != null) {
                                        intOrNull3 = StringsKt.toIntOrNull(strSubstringBefore$default);
                                    }
                                    if (r1 != 0) {
                                        Requests app = MainActivityKt.getApp();
                                        String str62 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                        c00012.L$0 = str4;
                                        c00012.L$1 = str5;
                                        c00012.L$2 = document2;
                                        c00012.L$3 = strText;
                                        c00012.L$4 = strAttr;
                                        c00012.L$5 = str17;
                                        c00012.L$6 = arrayList2;
                                        c00012.L$7 = num2;
                                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                        c00012.L$9 = d2;
                                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                        List<EpisodeItem> list21 = list3;
                                        c00012.L$12 = list21;
                                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                        booleanRef13 = booleanRef8;
                                        c00012.L$14 = booleanRef13;
                                        List list22 = arrayList2;
                                        c00012.L$15 = booleanRef7;
                                        arrayList7 = arrayList5;
                                        c00012.L$16 = arrayList7;
                                        c00012.L$17 = arrayList4;
                                        c00012.L$18 = intOrNull2;
                                        c00012.L$19 = r1;
                                        c00012.I$0 = i5;
                                        c00012.label = 4;
                                        d7 = d2;
                                        list11 = arrayList4;
                                        r71 = r1;
                                        booleanRef14 = booleanRef7;
                                        i8 = i5;
                                        list5 = list21;
                                        num7 = num2;
                                        str31 = str28;
                                        str29 = str15;
                                        str30 = str24;
                                        obj9 = intOrNull2;
                                        C00011 c00014 = c00012;
                                        obj8 = obj7;
                                        list12 = list22;
                                        objNewAnimeLoadResponse$default = Requests.get$default(app, str62, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                                        c00013 = c00014;
                                        if (objNewAnimeLoadResponse$default == obj8) {
                                            r1 = intOrNull3;
                                            return obj8;
                                        }
                                        r1 = intOrNull3;
                                        str41 = str5;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        d8 = d7;
                                        booleanRef15 = booleanRef13;
                                        booleanRef16 = booleanRef14;
                                        r5 = r71;
                                        str42 = strText;
                                        str43 = str17;
                                        obj10 = obj9;
                                        list13 = arrayList7;
                                        str44 = strAttr;
                                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                        num5 = num7;
                                        r63 = r5;
                                        list6 = list12;
                                        r62 = obj10;
                                        list7 = list13;
                                        booleanRef12 = booleanRef16;
                                        booleanRef11 = booleanRef15;
                                        d5 = d8;
                                        str34 = str43;
                                        str35 = str44;
                                        str33 = str42;
                                        str5 = str41;
                                        list8 = list11;
                                        str32 = str4;
                                        i7 = i8;
                                    } else {
                                        r70 = r1;
                                        c00013 = c00012;
                                        list4 = arrayList2;
                                        num4 = num2;
                                        d4 = d2;
                                        arrayList6 = arrayList5;
                                        str29 = str15;
                                        str30 = str24;
                                        booleanRef9 = booleanRef7;
                                        booleanRef10 = booleanRef8;
                                        list5 = list3;
                                        i6 = i5;
                                        str31 = str28;
                                        r30 = intOrNull2;
                                        obj8 = obj7;
                                        if (r30 != 0) {
                                            Requests app2 = MainActivityKt.getApp();
                                            String str63 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                            c00013.L$0 = str4;
                                            c00013.L$1 = str5;
                                            c00013.L$2 = document2;
                                            c00013.L$3 = strText;
                                            c00013.L$4 = strAttr;
                                            c00013.L$5 = str17;
                                            c00013.L$6 = list4;
                                            c00013.L$7 = num4;
                                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                            c00013.L$9 = d4;
                                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                            c00013.L$12 = list5;
                                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                            c00013.L$14 = booleanRef10;
                                            c00013.L$15 = booleanRef9;
                                            c00013.L$16 = arrayList6;
                                            c00013.L$17 = arrayList4;
                                            c00013.L$18 = r30;
                                            c00013.L$19 = r70;
                                            c00013.I$0 = i6;
                                            document4 = document2;
                                            c00013.label = 5;
                                            objNewAnimeLoadResponse$default = Requests.get$default(app2, str63, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                            if (objNewAnimeLoadResponse$default == obj8) {
                                                r1 = intOrNull3;
                                                list9 = arrayList6;
                                                c00013 = c00013;
                                                return obj8;
                                            }
                                            r1 = intOrNull3;
                                            list9 = arrayList6;
                                            c00013 = c00013;
                                            str36 = str18;
                                            episodesResponse4 = episodesResponse3;
                                            num6 = num3;
                                            r11 = r30;
                                            d6 = d4;
                                            list10 = arrayList4;
                                            str37 = strText;
                                            str38 = str17;
                                            str39 = strAttr;
                                            booleanRef11 = booleanRef10;
                                            booleanRef12 = booleanRef9;
                                            str40 = str5;
                                            r4 = r70;
                                            document2 = document4;
                                            text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                            num5 = num4;
                                            r63 = r4;
                                            list6 = list4;
                                            r62 = r11;
                                            list8 = list10;
                                            d5 = d6;
                                            str34 = str38;
                                            str35 = str39;
                                            str33 = str37;
                                            str5 = str40;
                                            list7 = list9;
                                            str32 = str4;
                                            i7 = i6;
                                        } else {
                                            r63 = r70;
                                            num5 = num4;
                                            str32 = str4;
                                            list6 = list4;
                                            str33 = strText;
                                            str34 = str17;
                                            str35 = strAttr;
                                            str36 = str18;
                                            episodesResponse4 = episodesResponse3;
                                            num6 = num3;
                                            r62 = r30;
                                            d5 = d4;
                                            document2 = document2;
                                            booleanRef11 = booleanRef10;
                                            list7 = arrayList6;
                                            i7 = i6;
                                            booleanRef12 = booleanRef9;
                                            text = null;
                                        }
                                    }
                                    if (text != null) {
                                        r1 = intOrNull3;
                                        list8 = arrayList4;
                                        animeData = AniDbUtilsKt.parseAnimeData(text);
                                    } else {
                                        r1 = intOrNull3;
                                        list8 = arrayList4;
                                        animeData = null;
                                    }
                                    metaAnimeData = animeData;
                                    if (metaAnimeData == null && (images = metaAnimeData.getImages()) != null) {
                                        Iterator it7 = images.iterator();
                                        while (true) {
                                            if (it7.hasNext()) {
                                                next3 = it7.next();
                                                str48 = text;
                                                Iterator it8 = it7;
                                                if (!Intrinsics.areEqual(((ImageData) next3).getCoverType(), "Fanart")) {
                                                    text = str48;
                                                    it7 = it8;
                                                }
                                            } else {
                                                str48 = text;
                                                next3 = null;
                                            }
                                        }
                                        ImageData imageData = (ImageData) next3;
                                        String url = imageData != null ? imageData.getUrl() : null;
                                        if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                            i12 = 1;
                                        } else {
                                            i12 = 0;
                                        }
                                        list18 = list5;
                                        i13 = 0;
                                        i14 = 0;
                                        for (Object obj11 : list18) {
                                            int i18 = i14 + 1;
                                            if (i14 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            episodeItem2 = (EpisodeItem) obj11;
                                            List<EpisodeItem> list23 = list18;
                                            i16 = i14 + 1;
                                            if (metaAnimeData != null) {
                                                str53 = str33;
                                                episodes = metaAnimeData.getEpisodes();
                                                if (episodes != null) {
                                                    str32 = str32;
                                                    metaEpisode = episodes.get(String.valueOf(i16));
                                                }
                                                if (metaEpisode != null || (title3 = metaEpisode.getTitle()) == null) {
                                                    metaEpisode2 = metaEpisode;
                                                    str54 = str30;
                                                } else {
                                                    metaEpisode2 = metaEpisode;
                                                    str54 = str30;
                                                    String str64 = title3.get(str54);
                                                    if (str64 != null) {
                                                        str54 = str54;
                                                        str57 = str64;
                                                        str56 = str29;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        overview = metaEpisode2.getOverview();
                                                    } else {
                                                        overview = null;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        image = metaEpisode2.getImage();
                                                    } else {
                                                        image = null;
                                                    }
                                                    if (metaEpisode2 != null || (rating = metaEpisode2.getRating()) == null) {
                                                        scoreFrom10 = null;
                                                    } else {
                                                        scoreFrom10 = Score.Companion.from10(rating);
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        runtime = metaEpisode2.getRuntime();
                                                    } else {
                                                        runtime = null;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                                    } else {
                                                        airDateUtc = null;
                                                    }
                                                    if (i12 != 0) {
                                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                            public final Object invoke(Object obj12) {
                                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                            }
                                                        })));
                                                    } else {
                                                        if (booleanRef11.element) {
                                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                                public final Object invoke(Object obj12) {
                                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                                }
                                                            }));
                                                        }
                                                        if (booleanRef12.element) {
                                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                                public final Object invoke(Object obj12) {
                                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                                }
                                                            }));
                                                        }
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    i14 = i18;
                                                    list18 = list23;
                                                    str33 = str53;
                                                    str32 = str32;
                                                    i13 = i13;
                                                    str29 = str56;
                                                    str30 = str54;
                                                }
                                                if (metaEpisode2 != null || (title2 = metaEpisode2.getTitle()) == null) {
                                                    str55 = null;
                                                } else {
                                                    str55 = title2.get("x-jat");
                                                }
                                                if (str55 == null) {
                                                    if (metaEpisode2 != null || (title = metaEpisode2.getTitle()) == null) {
                                                        str58 = str29;
                                                        str55 = null;
                                                    } else {
                                                        str58 = str29;
                                                        str55 = title.get(str58);
                                                    }
                                                    if (str55 == null) {
                                                        str56 = str58;
                                                        str57 = "Episode " + i16;
                                                    } else {
                                                        str56 = str58;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        overview = metaEpisode2.getOverview();
                                                    } else {
                                                        overview = null;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        image = metaEpisode2.getImage();
                                                    } else {
                                                        image = null;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        scoreFrom10 = null;
                                                    } else {
                                                        scoreFrom10 = null;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        runtime = metaEpisode2.getRuntime();
                                                    } else {
                                                        runtime = null;
                                                    }
                                                    if (metaEpisode2 != null) {
                                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                                    } else {
                                                        airDateUtc = null;
                                                    }
                                                    if (i12 != 0) {
                                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                            public final Object invoke(Object obj12) {
                                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                            }
                                                        })));
                                                    } else {
                                                        if (booleanRef11.element) {
                                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                                public final Object invoke(Object obj12) {
                                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                                }
                                                            }));
                                                        }
                                                        if (booleanRef12.element) {
                                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                                public final Object invoke(Object obj12) {
                                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                                }
                                                            }));
                                                        }
                                                        Unit unit2 = Unit.INSTANCE;
                                                    }
                                                    i14 = i18;
                                                    list18 = list23;
                                                    str33 = str53;
                                                    str32 = str32;
                                                    i13 = i13;
                                                    str29 = str56;
                                                    str30 = str54;
                                                } else {
                                                    str56 = str29;
                                                }
                                                str57 = str55;
                                                if (metaEpisode2 != null) {
                                                    overview = metaEpisode2.getOverview();
                                                } else {
                                                    overview = null;
                                                }
                                                if (metaEpisode2 != null) {
                                                    image = metaEpisode2.getImage();
                                                } else {
                                                    image = null;
                                                }
                                                if (metaEpisode2 != null) {
                                                    scoreFrom10 = null;
                                                } else {
                                                    scoreFrom10 = null;
                                                }
                                                if (metaEpisode2 != null) {
                                                    runtime = metaEpisode2.getRuntime();
                                                } else {
                                                    runtime = null;
                                                }
                                                if (metaEpisode2 != null) {
                                                    airDateUtc = metaEpisode2.getAirDateUtc();
                                                } else {
                                                    airDateUtc = null;
                                                }
                                                if (i12 != 0) {
                                                    Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                        public final Object invoke(Object obj12) {
                                                            return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                        }
                                                    })));
                                                } else {
                                                    if (booleanRef11.element) {
                                                        list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                            public final Object invoke(Object obj12) {
                                                                return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                            }
                                                        }));
                                                    }
                                                    if (booleanRef12.element) {
                                                        list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                            public final Object invoke(Object obj12) {
                                                                return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                            }
                                                        }));
                                                    }
                                                    Unit unit3 = Unit.INSTANCE;
                                                }
                                                i14 = i18;
                                                list18 = list23;
                                                str33 = str53;
                                                str32 = str32;
                                                i13 = i13;
                                                str29 = str56;
                                                str30 = str54;
                                            } else {
                                                str53 = str33;
                                            }
                                            metaEpisode = null;
                                            if (metaEpisode != null) {
                                                metaEpisode2 = metaEpisode;
                                                str54 = str30;
                                                if (metaEpisode2 != null) {
                                                    str55 = null;
                                                } else {
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    if (metaEpisode2 != null) {
                                                        str58 = str29;
                                                        str55 = null;
                                                    } else {
                                                        str58 = str29;
                                                        str55 = null;
                                                    }
                                                    if (str55 == null) {
                                                        str56 = str58;
                                                        str57 = "Episode " + i16;
                                                    } else {
                                                        str56 = str58;
                                                    }
                                                } else {
                                                    str56 = str29;
                                                }
                                                str57 = str55;
                                            } else {
                                                metaEpisode2 = metaEpisode;
                                                str54 = str30;
                                                if (metaEpisode2 != null) {
                                                    str55 = null;
                                                } else {
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    if (metaEpisode2 != null) {
                                                        str58 = str29;
                                                        str55 = null;
                                                    } else {
                                                        str58 = str29;
                                                        str55 = null;
                                                    }
                                                    if (str55 == null) {
                                                        str56 = str58;
                                                        str57 = "Episode " + i16;
                                                    } else {
                                                        str56 = str58;
                                                    }
                                                } else {
                                                    str56 = str29;
                                                }
                                                str57 = str55;
                                            }
                                            if (metaEpisode2 != null) {
                                                overview = metaEpisode2.getOverview();
                                            } else {
                                                overview = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                image = metaEpisode2.getImage();
                                            } else {
                                                image = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                scoreFrom10 = null;
                                            } else {
                                                scoreFrom10 = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                runtime = metaEpisode2.getRuntime();
                                            } else {
                                                runtime = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                airDateUtc = metaEpisode2.getAirDateUtc();
                                            } else {
                                                airDateUtc = null;
                                            }
                                            if (i12 != 0) {
                                                Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                })));
                                            } else {
                                                if (booleanRef11.element) {
                                                    list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                        public final Object invoke(Object obj12) {
                                                            return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                        }
                                                    }));
                                                }
                                                if (booleanRef12.element) {
                                                    list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                        public final Object invoke(Object obj12) {
                                                            return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                        }
                                                    }));
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                            }
                                            i14 = i18;
                                            list18 = list23;
                                            str33 = str53;
                                            str32 = str32;
                                            i13 = i13;
                                            str29 = str56;
                                            str30 = str54;
                                        }
                                        String str65 = str33;
                                        String str66 = str32;
                                        if (i12 != 0) {
                                            tvType = TvType.AnimeMovie;
                                        } else {
                                            tvType = TvType.Anime;
                                        }
                                        TvType tvType2 = tvType;
                                        elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                                        if (elementSelectFirst9 != null) {
                                            strAttr4 = elementSelectFirst9.attr(str31);
                                        } else {
                                            strAttr4 = null;
                                        }
                                        elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                                        if (elementSelectFirst10 != null) {
                                            strText4 = elementSelectFirst10.text();
                                        } else {
                                            strText4 = null;
                                        }
                                        if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                            showStatus = ShowStatus.Completed;
                                        } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                            showStatus = ShowStatus.Ongoing;
                                        } else {
                                            showStatus = null;
                                        }
                                        it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                                        while (true) {
                                            document5 = document2;
                                            list19 = list8;
                                            if (it6.hasNext()) {
                                                next2 = it6.next();
                                                element3 = (Element) next2;
                                                str49 = str5;
                                                list20 = list7;
                                                booleanRef18 = booleanRef12;
                                                booleanRef19 = booleanRef11;
                                                str50 = strText4;
                                                i15 = 2;
                                                z6 = false;
                                                str51 = null;
                                                if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null) || StringsKt.contains$default(element3.text(), "h", false, 2, (Object) null)) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (z8) {
                                                    document2 = document5;
                                                    booleanRef12 = booleanRef18;
                                                    str5 = str49;
                                                    booleanRef11 = booleanRef19;
                                                    strText4 = str50;
                                                    list7 = list20;
                                                    list8 = list19;
                                                }
                                            } else {
                                                str49 = str5;
                                                list20 = list7;
                                                booleanRef18 = booleanRef12;
                                                booleanRef19 = booleanRef11;
                                                str50 = strText4;
                                                i15 = 2;
                                                z6 = false;
                                                str51 = null;
                                                next2 = null;
                                            }
                                        }
                                        element2 = (Element) next2;
                                        if (element2 != null) {
                                            strText5 = element2.text();
                                        } else {
                                            strText5 = str51;
                                        }
                                        str52 = strText5;
                                        if (str52 != null) {
                                            if (!StringsKt.contains$default(str52, "h", z6, i15, str51) && StringsKt.contains$default(str52, "m", z6, i15, str51)) {
                                                Integer intOrNull7 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                                int iIntValue3 = intOrNull7 != null ? intOrNull7.intValue() : 0;
                                                Integer intOrNull8 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(str52, "h", str51, i15, str51), "m", str51, i15, str51)).toString());
                                                intOrNull4 = Boxing.boxInt((iIntValue3 * 60) + (intOrNull8 != null ? intOrNull8.intValue() : 0));
                                            } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                                intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                                if (intOrNull5 != null) {
                                                    iIntValue = intOrNull5.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                            } else {
                                                intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                            }
                                            r60 = intOrNull4;
                                        } else {
                                            r60 = str51;
                                        }
                                        AniDb aniDb = this;
                                        if (i12 != 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        C00025 c00025 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                                        c00013.L$0 = SpillingKt.nullOutSpilledVariable(str66);
                                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(str65);
                                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                                        c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                                        c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                                        c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                                        c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                                        c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                                        c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                                        c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                                        c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                                        c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType2);
                                        c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                                        c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                                        c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                                        c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                                        c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                                        c00013.I$0 = i7;
                                        c00013.I$1 = i12;
                                        c00013.label = 6;
                                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb, str65, str66, tvType2, false, c00025, c00013, 8, (Object) null);
                                        if (objNewAnimeLoadResponse$default == obj8) {
                                            return obj8;
                                        }
                                        return objNewAnimeLoadResponse$default;
                                    }
                                    str48 = text;
                                    if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                        i12 = 1;
                                    } else {
                                        i12 = 0;
                                    }
                                    list18 = list5;
                                    i13 = 0;
                                    i14 = 0;
                                    while (r14.hasNext()) {
                                        int i19 = i14 + 1;
                                        if (i14 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        episodeItem2 = (EpisodeItem) obj11;
                                        List<EpisodeItem> list24 = list18;
                                        i16 = i14 + 1;
                                        if (metaAnimeData != null) {
                                            str53 = str33;
                                            episodes = metaAnimeData.getEpisodes();
                                            if (episodes != null) {
                                                str32 = str32;
                                                metaEpisode = episodes.get(String.valueOf(i16));
                                            }
                                            if (metaEpisode != null) {
                                                metaEpisode2 = metaEpisode;
                                                str54 = str30;
                                                if (metaEpisode2 != null) {
                                                    str55 = null;
                                                } else {
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    if (metaEpisode2 != null) {
                                                        str58 = str29;
                                                        str55 = null;
                                                    } else {
                                                        str58 = str29;
                                                        str55 = null;
                                                    }
                                                    if (str55 == null) {
                                                        str56 = str58;
                                                        str57 = "Episode " + i16;
                                                    } else {
                                                        str56 = str58;
                                                    }
                                                } else {
                                                    str56 = str29;
                                                }
                                                str57 = str55;
                                            } else {
                                                metaEpisode2 = metaEpisode;
                                                str54 = str30;
                                                if (metaEpisode2 != null) {
                                                    str55 = null;
                                                } else {
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    if (metaEpisode2 != null) {
                                                        str58 = str29;
                                                        str55 = null;
                                                    } else {
                                                        str58 = str29;
                                                        str55 = null;
                                                    }
                                                    if (str55 == null) {
                                                        str56 = str58;
                                                        str57 = "Episode " + i16;
                                                    } else {
                                                        str56 = str58;
                                                    }
                                                } else {
                                                    str56 = str29;
                                                }
                                                str57 = str55;
                                            }
                                            if (metaEpisode2 != null) {
                                                overview = metaEpisode2.getOverview();
                                            } else {
                                                overview = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                image = metaEpisode2.getImage();
                                            } else {
                                                image = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                scoreFrom10 = null;
                                            } else {
                                                scoreFrom10 = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                runtime = metaEpisode2.getRuntime();
                                            } else {
                                                runtime = null;
                                            }
                                            if (metaEpisode2 != null) {
                                                airDateUtc = metaEpisode2.getAirDateUtc();
                                            } else {
                                                airDateUtc = null;
                                            }
                                            if (i12 != 0) {
                                                Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                })));
                                            } else {
                                                if (booleanRef11.element) {
                                                    list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                        public final Object invoke(Object obj12) {
                                                            return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                        }
                                                    }));
                                                }
                                                if (booleanRef12.element) {
                                                    list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                        public final Object invoke(Object obj12) {
                                                            return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                        }
                                                    }));
                                                }
                                                Unit unit5 = Unit.INSTANCE;
                                            }
                                            i14 = i19;
                                            list18 = list24;
                                            str33 = str53;
                                            str32 = str32;
                                            i13 = i13;
                                            str29 = str56;
                                            str30 = str54;
                                        } else {
                                            str53 = str33;
                                        }
                                        metaEpisode = null;
                                        if (metaEpisode != null) {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        } else {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        }
                                        if (metaEpisode2 != null) {
                                            overview = metaEpisode2.getOverview();
                                        } else {
                                            overview = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            image = metaEpisode2.getImage();
                                        } else {
                                            image = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            scoreFrom10 = null;
                                        } else {
                                            scoreFrom10 = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            runtime = metaEpisode2.getRuntime();
                                        } else {
                                            runtime = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            airDateUtc = metaEpisode2.getAirDateUtc();
                                        } else {
                                            airDateUtc = null;
                                        }
                                        if (i12 != 0) {
                                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            })));
                                        } else {
                                            if (booleanRef11.element) {
                                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            if (booleanRef12.element) {
                                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            Unit unit6 = Unit.INSTANCE;
                                        }
                                        i14 = i19;
                                        list18 = list24;
                                        str33 = str53;
                                        str32 = str32;
                                        i13 = i13;
                                        str29 = str56;
                                        str30 = str54;
                                    }
                                    String str67 = str33;
                                    String str68 = str32;
                                    if (i12 != 0) {
                                        tvType = TvType.AnimeMovie;
                                    } else {
                                        tvType = TvType.Anime;
                                    }
                                    TvType tvType3 = tvType;
                                    elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                                    if (elementSelectFirst9 != null) {
                                        strAttr4 = elementSelectFirst9.attr(str31);
                                    } else {
                                        strAttr4 = null;
                                    }
                                    elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                                    if (elementSelectFirst10 != null) {
                                        strText4 = elementSelectFirst10.text();
                                    } else {
                                        strText4 = null;
                                    }
                                    if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                        showStatus = ShowStatus.Completed;
                                    } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                        showStatus = ShowStatus.Ongoing;
                                    } else {
                                        showStatus = null;
                                    }
                                    it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                                    while (true) {
                                        document5 = document2;
                                        list19 = list8;
                                        if (it6.hasNext()) {
                                            next2 = it6.next();
                                            element3 = (Element) next2;
                                            str49 = str5;
                                            list20 = list7;
                                            booleanRef18 = booleanRef12;
                                            booleanRef19 = booleanRef11;
                                            str50 = strText4;
                                            i15 = 2;
                                            z6 = false;
                                            str51 = null;
                                            if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                                z8 = true;
                                            } else {
                                                z8 = true;
                                            }
                                            if (z8) {
                                                document2 = document5;
                                                booleanRef12 = booleanRef18;
                                                str5 = str49;
                                                booleanRef11 = booleanRef19;
                                                strText4 = str50;
                                                list7 = list20;
                                                list8 = list19;
                                            }
                                        } else {
                                            str49 = str5;
                                            list20 = list7;
                                            booleanRef18 = booleanRef12;
                                            booleanRef19 = booleanRef11;
                                            str50 = strText4;
                                            i15 = 2;
                                            z6 = false;
                                            str51 = null;
                                            next2 = null;
                                        }
                                    }
                                    element2 = (Element) next2;
                                    if (element2 != null) {
                                        strText5 = element2.text();
                                    } else {
                                        strText5 = str51;
                                    }
                                    str52 = strText5;
                                    if (str52 != null) {
                                        if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                            if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                                intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                                if (intOrNull5 != null) {
                                                    iIntValue = intOrNull5.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                            } else {
                                                intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                            }
                                        } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                            if (intOrNull5 != null) {
                                                iIntValue = intOrNull5.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                        } else {
                                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                        }
                                        r60 = intOrNull4;
                                    } else {
                                        r60 = str51;
                                    }
                                    AniDb aniDb2 = this;
                                    if (i12 != 0) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    C00025 c00026 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(str68);
                                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(str67);
                                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                                    c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                                    c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType3);
                                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                                    c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                                    c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                                    c00013.I$0 = i7;
                                    c00013.I$1 = i12;
                                    c00013.label = 6;
                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb2, str67, str68, tvType3, false, c00026, c00013, 8, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        return obj8;
                                    }
                                    return objNewAnimeLoadResponse$default;
                                }
                                str28 = str25;
                                r1 = str27;
                                if (r1 != 0) {
                                    Requests app3 = MainActivityKt.getApp();
                                    String str69 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                    c00012.L$0 = str4;
                                    c00012.L$1 = str5;
                                    c00012.L$2 = document2;
                                    c00012.L$3 = strText;
                                    c00012.L$4 = strAttr;
                                    c00012.L$5 = str17;
                                    c00012.L$6 = arrayList2;
                                    c00012.L$7 = num2;
                                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00012.L$9 = d2;
                                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    List<EpisodeItem> list25 = list3;
                                    c00012.L$12 = list25;
                                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    booleanRef13 = booleanRef8;
                                    c00012.L$14 = booleanRef13;
                                    List list26 = arrayList2;
                                    c00012.L$15 = booleanRef7;
                                    arrayList7 = arrayList5;
                                    c00012.L$16 = arrayList7;
                                    c00012.L$17 = arrayList4;
                                    c00012.L$18 = intOrNull2;
                                    c00012.L$19 = r1;
                                    c00012.I$0 = i5;
                                    c00012.label = 4;
                                    d7 = d2;
                                    list11 = arrayList4;
                                    r71 = r1;
                                    booleanRef14 = booleanRef7;
                                    i8 = i5;
                                    list5 = list25;
                                    num7 = num2;
                                    str31 = str28;
                                    str29 = str15;
                                    str30 = str24;
                                    obj9 = intOrNull2;
                                    C00011 c00015 = c00012;
                                    obj8 = obj7;
                                    list12 = list26;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app3, str69, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00015, 4094, (Object) null);
                                    c00013 = c00015;
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    str41 = str5;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    d8 = d7;
                                    booleanRef15 = booleanRef13;
                                    booleanRef16 = booleanRef14;
                                    r5 = r71;
                                    str42 = strText;
                                    str43 = str17;
                                    obj10 = obj9;
                                    list13 = arrayList7;
                                    str44 = strAttr;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num7;
                                    r63 = r5;
                                    list6 = list12;
                                    r62 = obj10;
                                    list7 = list13;
                                    booleanRef12 = booleanRef16;
                                    booleanRef11 = booleanRef15;
                                    d5 = d8;
                                    str34 = str43;
                                    str35 = str44;
                                    str33 = str42;
                                    str5 = str41;
                                    list8 = list11;
                                    str32 = str4;
                                    i7 = i8;
                                } else {
                                    r70 = r1;
                                    c00013 = c00012;
                                    list4 = arrayList2;
                                    num4 = num2;
                                    d4 = d2;
                                    arrayList6 = arrayList5;
                                    str29 = str15;
                                    str30 = str24;
                                    booleanRef9 = booleanRef7;
                                    booleanRef10 = booleanRef8;
                                    list5 = list3;
                                    i6 = i5;
                                    str31 = str28;
                                    r30 = intOrNull2;
                                    obj8 = obj7;
                                    if (r30 != 0) {
                                        Requests app4 = MainActivityKt.getApp();
                                        String str610 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                        c00013.L$0 = str4;
                                        c00013.L$1 = str5;
                                        c00013.L$2 = document2;
                                        c00013.L$3 = strText;
                                        c00013.L$4 = strAttr;
                                        c00013.L$5 = str17;
                                        c00013.L$6 = list4;
                                        c00013.L$7 = num4;
                                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                        c00013.L$9 = d4;
                                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                        c00013.L$12 = list5;
                                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                        c00013.L$14 = booleanRef10;
                                        c00013.L$15 = booleanRef9;
                                        c00013.L$16 = arrayList6;
                                        c00013.L$17 = arrayList4;
                                        c00013.L$18 = r30;
                                        c00013.L$19 = r70;
                                        c00013.I$0 = i6;
                                        document4 = document2;
                                        c00013.label = 5;
                                        objNewAnimeLoadResponse$default = Requests.get$default(app4, str610, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                        if (objNewAnimeLoadResponse$default == obj8) {
                                            r1 = intOrNull3;
                                            list9 = arrayList6;
                                            c00013 = c00013;
                                            return obj8;
                                        }
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        r11 = r30;
                                        d6 = d4;
                                        list10 = arrayList4;
                                        str37 = strText;
                                        str38 = str17;
                                        str39 = strAttr;
                                        booleanRef11 = booleanRef10;
                                        booleanRef12 = booleanRef9;
                                        str40 = str5;
                                        r4 = r70;
                                        document2 = document4;
                                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                        num5 = num4;
                                        r63 = r4;
                                        list6 = list4;
                                        r62 = r11;
                                        list8 = list10;
                                        d5 = d6;
                                        str34 = str38;
                                        str35 = str39;
                                        str33 = str37;
                                        str5 = str40;
                                        list7 = list9;
                                        str32 = str4;
                                        i7 = i6;
                                    } else {
                                        r63 = r70;
                                        num5 = num4;
                                        str32 = str4;
                                        list6 = list4;
                                        str33 = strText;
                                        str34 = str17;
                                        str35 = strAttr;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        r62 = r30;
                                        d5 = d4;
                                        document2 = document2;
                                        booleanRef11 = booleanRef10;
                                        list7 = arrayList6;
                                        i7 = i6;
                                        booleanRef12 = booleanRef9;
                                        text = null;
                                    }
                                }
                                if (text != null) {
                                    r1 = intOrNull3;
                                    list8 = arrayList4;
                                    animeData = AniDbUtilsKt.parseAnimeData(text);
                                } else {
                                    r1 = intOrNull3;
                                    list8 = arrayList4;
                                    animeData = null;
                                }
                                metaAnimeData = animeData;
                                if (metaAnimeData == null) {
                                    str48 = text;
                                } else {
                                    str48 = text;
                                }
                                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                    i12 = 1;
                                } else {
                                    i12 = 0;
                                }
                                list18 = list5;
                                i13 = 0;
                                i14 = 0;
                                while (r14.hasNext()) {
                                    int i110 = i14 + 1;
                                    if (i14 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    episodeItem2 = (EpisodeItem) obj11;
                                    List<EpisodeItem> list27 = list18;
                                    i16 = i14 + 1;
                                    if (metaAnimeData != null) {
                                        str53 = str33;
                                        episodes = metaAnimeData.getEpisodes();
                                        if (episodes != null) {
                                            str32 = str32;
                                            metaEpisode = episodes.get(String.valueOf(i16));
                                        }
                                        if (metaEpisode != null) {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        } else {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        }
                                        if (metaEpisode2 != null) {
                                            overview = metaEpisode2.getOverview();
                                        } else {
                                            overview = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            image = metaEpisode2.getImage();
                                        } else {
                                            image = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            scoreFrom10 = null;
                                        } else {
                                            scoreFrom10 = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            runtime = metaEpisode2.getRuntime();
                                        } else {
                                            runtime = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            airDateUtc = metaEpisode2.getAirDateUtc();
                                        } else {
                                            airDateUtc = null;
                                        }
                                        if (i12 != 0) {
                                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            })));
                                        } else {
                                            if (booleanRef11.element) {
                                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            if (booleanRef12.element) {
                                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            Unit unit7 = Unit.INSTANCE;
                                        }
                                        i14 = i110;
                                        list18 = list27;
                                        str33 = str53;
                                        str32 = str32;
                                        i13 = i13;
                                        str29 = str56;
                                        str30 = str54;
                                    } else {
                                        str53 = str33;
                                    }
                                    metaEpisode = null;
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit8 = Unit.INSTANCE;
                                    }
                                    i14 = i110;
                                    list18 = list27;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                }
                                String str611 = str33;
                                String str612 = str32;
                                if (i12 != 0) {
                                    tvType = TvType.AnimeMovie;
                                } else {
                                    tvType = TvType.Anime;
                                }
                                TvType tvType4 = tvType;
                                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                                if (elementSelectFirst9 != null) {
                                    strAttr4 = elementSelectFirst9.attr(str31);
                                } else {
                                    strAttr4 = null;
                                }
                                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                                if (elementSelectFirst10 != null) {
                                    strText4 = elementSelectFirst10.text();
                                } else {
                                    strText4 = null;
                                }
                                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                    showStatus = ShowStatus.Completed;
                                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                    showStatus = ShowStatus.Ongoing;
                                } else {
                                    showStatus = null;
                                }
                                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                                while (true) {
                                    document5 = document2;
                                    list19 = list8;
                                    if (it6.hasNext()) {
                                        next2 = it6.next();
                                        element3 = (Element) next2;
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                            z8 = true;
                                        } else {
                                            z8 = true;
                                        }
                                        if (z8) {
                                            document2 = document5;
                                            booleanRef12 = booleanRef18;
                                            str5 = str49;
                                            booleanRef11 = booleanRef19;
                                            strText4 = str50;
                                            list7 = list20;
                                            list8 = list19;
                                        }
                                    } else {
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        next2 = null;
                                    }
                                }
                                element2 = (Element) next2;
                                if (element2 != null) {
                                    strText5 = element2.text();
                                } else {
                                    strText5 = str51;
                                }
                                str52 = strText5;
                                if (str52 != null) {
                                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                            if (intOrNull5 != null) {
                                                iIntValue = intOrNull5.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                        } else {
                                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                        }
                                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                    r60 = intOrNull4;
                                } else {
                                    r60 = str51;
                                }
                                AniDb aniDb3 = this;
                                if (i12 != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                C00025 c00027 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str612);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str611);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType4);
                                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                                c00013.I$0 = i7;
                                c00013.I$1 = i12;
                                c00013.label = 6;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb3, str611, str612, tvType4, false, c00027, c00013, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    return obj8;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            list3 = list;
                            str26 = str2;
                        } else {
                            list3 = list;
                            booleanRef7 = booleanRef3;
                            booleanRef8 = booleanRef4;
                            str26 = str2;
                            str27 = null;
                        }
                    } else {
                        arrayList5 = arrayList3;
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str25 = str3;
                        str26 = str2;
                        str27 = null;
                    }
                    intOrNull2 = str27;
                    elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                    if (elementSelectFirst8 == null) {
                        str28 = str25;
                    } else {
                        str28 = str25;
                    }
                    r1 = str27;
                    if (r1 != 0) {
                        Requests app5 = MainActivityKt.getApp();
                        String str613 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                        c00012.L$0 = str4;
                        c00012.L$1 = str5;
                        c00012.L$2 = document2;
                        c00012.L$3 = strText;
                        c00012.L$4 = strAttr;
                        c00012.L$5 = str17;
                        c00012.L$6 = arrayList2;
                        c00012.L$7 = num2;
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00012.L$9 = d2;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        List<EpisodeItem> list28 = list3;
                        c00012.L$12 = list28;
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        booleanRef13 = booleanRef8;
                        c00012.L$14 = booleanRef13;
                        List list29 = arrayList2;
                        c00012.L$15 = booleanRef7;
                        arrayList7 = arrayList5;
                        c00012.L$16 = arrayList7;
                        c00012.L$17 = arrayList4;
                        c00012.L$18 = intOrNull2;
                        c00012.L$19 = r1;
                        c00012.I$0 = i5;
                        c00012.label = 4;
                        d7 = d2;
                        list11 = arrayList4;
                        r71 = r1;
                        booleanRef14 = booleanRef7;
                        i8 = i5;
                        list5 = list28;
                        num7 = num2;
                        str31 = str28;
                        str29 = str15;
                        str30 = str24;
                        obj9 = intOrNull2;
                        C00011 c00016 = c00012;
                        obj8 = obj7;
                        list12 = list29;
                        objNewAnimeLoadResponse$default = Requests.get$default(app5, str613, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00016, 4094, (Object) null);
                        c00013 = c00016;
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        str41 = str5;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        d8 = d7;
                        booleanRef15 = booleanRef13;
                        booleanRef16 = booleanRef14;
                        r5 = r71;
                        str42 = strText;
                        str43 = str17;
                        obj10 = obj9;
                        list13 = arrayList7;
                        str44 = strAttr;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num7;
                        r63 = r5;
                        list6 = list12;
                        r62 = obj10;
                        list7 = list13;
                        booleanRef12 = booleanRef16;
                        booleanRef11 = booleanRef15;
                        d5 = d8;
                        str34 = str43;
                        str35 = str44;
                        str33 = str42;
                        str5 = str41;
                        list8 = list11;
                        str32 = str4;
                        i7 = i8;
                    } else {
                        r70 = r1;
                        c00013 = c00012;
                        list4 = arrayList2;
                        num4 = num2;
                        d4 = d2;
                        arrayList6 = arrayList5;
                        str29 = str15;
                        str30 = str24;
                        booleanRef9 = booleanRef7;
                        booleanRef10 = booleanRef8;
                        list5 = list3;
                        i6 = i5;
                        str31 = str28;
                        r30 = intOrNull2;
                        obj8 = obj7;
                        if (r30 != 0) {
                            Requests app6 = MainActivityKt.getApp();
                            String str614 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                            c00013.L$0 = str4;
                            c00013.L$1 = str5;
                            c00013.L$2 = document2;
                            c00013.L$3 = strText;
                            c00013.L$4 = strAttr;
                            c00013.L$5 = str17;
                            c00013.L$6 = list4;
                            c00013.L$7 = num4;
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = d4;
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                            c00013.L$12 = list5;
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                            c00013.L$14 = booleanRef10;
                            c00013.L$15 = booleanRef9;
                            c00013.L$16 = arrayList6;
                            c00013.L$17 = arrayList4;
                            c00013.L$18 = r30;
                            c00013.L$19 = r70;
                            c00013.I$0 = i6;
                            document4 = document2;
                            c00013.label = 5;
                            objNewAnimeLoadResponse$default = Requests.get$default(app6, str614, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                r1 = intOrNull3;
                                list9 = arrayList6;
                                c00013 = c00013;
                                return obj8;
                            }
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            str36 = str18;
                            episodesResponse4 = episodesResponse3;
                            num6 = num3;
                            r11 = r30;
                            d6 = d4;
                            list10 = arrayList4;
                            str37 = strText;
                            str38 = str17;
                            str39 = strAttr;
                            booleanRef11 = booleanRef10;
                            booleanRef12 = booleanRef9;
                            str40 = str5;
                            r4 = r70;
                            document2 = document4;
                            text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                            num5 = num4;
                            r63 = r4;
                            list6 = list4;
                            r62 = r11;
                            list8 = list10;
                            d5 = d6;
                            str34 = str38;
                            str35 = str39;
                            str33 = str37;
                            str5 = str40;
                            list7 = list9;
                            str32 = str4;
                            i7 = i6;
                        } else {
                            r63 = r70;
                            num5 = num4;
                            str32 = str4;
                            list6 = list4;
                            str33 = strText;
                            str34 = str17;
                            str35 = strAttr;
                            str36 = str18;
                            episodesResponse4 = episodesResponse3;
                            num6 = num3;
                            r62 = r30;
                            d5 = d4;
                            document2 = document2;
                            booleanRef11 = booleanRef10;
                            list7 = arrayList6;
                            i7 = i6;
                            booleanRef12 = booleanRef9;
                            text = null;
                        }
                    }
                    if (text != null) {
                        r1 = intOrNull3;
                        list8 = arrayList4;
                        animeData = AniDbUtilsKt.parseAnimeData(text);
                    } else {
                        r1 = intOrNull3;
                        list8 = arrayList4;
                        animeData = null;
                    }
                    metaAnimeData = animeData;
                    if (metaAnimeData == null) {
                        str48 = text;
                    } else {
                        str48 = text;
                    }
                    if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                        i12 = 1;
                    } else {
                        i12 = 0;
                    }
                    list18 = list5;
                    i13 = 0;
                    i14 = 0;
                    while (r14.hasNext()) {
                        int i111 = i14 + 1;
                        if (i14 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        episodeItem2 = (EpisodeItem) obj11;
                        List<EpisodeItem> list210 = list18;
                        i16 = i14 + 1;
                        if (metaAnimeData != null) {
                            str53 = str33;
                            episodes = metaAnimeData.getEpisodes();
                            if (episodes != null) {
                                str32 = str32;
                                metaEpisode = episodes.get(String.valueOf(i16));
                            }
                            if (metaEpisode != null) {
                                metaEpisode2 = metaEpisode;
                                str54 = str30;
                                if (metaEpisode2 != null) {
                                    str55 = null;
                                } else {
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    if (metaEpisode2 != null) {
                                        str58 = str29;
                                        str55 = null;
                                    } else {
                                        str58 = str29;
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        str56 = str58;
                                        str57 = "Episode " + i16;
                                    } else {
                                        str56 = str58;
                                    }
                                } else {
                                    str56 = str29;
                                }
                                str57 = str55;
                            } else {
                                metaEpisode2 = metaEpisode;
                                str54 = str30;
                                if (metaEpisode2 != null) {
                                    str55 = null;
                                } else {
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    if (metaEpisode2 != null) {
                                        str58 = str29;
                                        str55 = null;
                                    } else {
                                        str58 = str29;
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        str56 = str58;
                                        str57 = "Episode " + i16;
                                    } else {
                                        str56 = str58;
                                    }
                                } else {
                                    str56 = str29;
                                }
                                str57 = str55;
                            }
                            if (metaEpisode2 != null) {
                                overview = metaEpisode2.getOverview();
                            } else {
                                overview = null;
                            }
                            if (metaEpisode2 != null) {
                                image = metaEpisode2.getImage();
                            } else {
                                image = null;
                            }
                            if (metaEpisode2 != null) {
                                scoreFrom10 = null;
                            } else {
                                scoreFrom10 = null;
                            }
                            if (metaEpisode2 != null) {
                                runtime = metaEpisode2.getRuntime();
                            } else {
                                runtime = null;
                            }
                            if (metaEpisode2 != null) {
                                airDateUtc = metaEpisode2.getAirDateUtc();
                            } else {
                                airDateUtc = null;
                            }
                            if (i12 != 0) {
                                Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                })));
                            } else {
                                if (booleanRef11.element) {
                                    list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    }));
                                }
                                if (booleanRef12.element) {
                                    list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    }));
                                }
                                Unit unit9 = Unit.INSTANCE;
                            }
                            i14 = i111;
                            list18 = list210;
                            str33 = str53;
                            str32 = str32;
                            i13 = i13;
                            str29 = str56;
                            str30 = str54;
                        } else {
                            str53 = str33;
                        }
                        metaEpisode = null;
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit10 = Unit.INSTANCE;
                        }
                        i14 = i111;
                        list18 = list210;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    }
                    String str615 = str33;
                    String str616 = str32;
                    if (i12 != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    TvType tvType5 = tvType;
                    elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                    if (elementSelectFirst9 != null) {
                        strAttr4 = elementSelectFirst9.attr(str31);
                    } else {
                        strAttr4 = null;
                    }
                    elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                    if (elementSelectFirst10 != null) {
                        strText4 = elementSelectFirst10.text();
                    } else {
                        strText4 = null;
                    }
                    if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                        showStatus = ShowStatus.Completed;
                    } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                        showStatus = ShowStatus.Ongoing;
                    } else {
                        showStatus = null;
                    }
                    it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                    element2 = (Element) next2;
                    if (element2 != null) {
                        strText5 = element2.text();
                    } else {
                        strText5 = str51;
                    }
                    str52 = strText5;
                    if (str52 != null) {
                        if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                if (intOrNull5 != null) {
                                    iIntValue = intOrNull5.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                intOrNull4 = Boxing.boxInt(iIntValue * 60);
                            } else {
                                intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                            }
                        } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                        r60 = intOrNull4;
                    } else {
                        r60 = str51;
                    }
                    AniDb aniDb4 = this;
                    if (i12 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    C00025 c00028 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(str616);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(str615);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType5);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                    c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                    c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                    c00013.I$0 = i7;
                    c00013.I$1 = i12;
                    c00013.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb4, str615, str616, tvType5, false, c00028, c00013, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj8) {
                        return obj8;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                str7 = string;
                str8 = getMainUrl() + "/api/frontend/anime/" + i + "/episodes";
                Companion companion4 = INSTANCE;
                Map<String, String> mapMapOf3 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                c00012.L$0 = str4;
                c00012.L$1 = str5;
                c00012.L$2 = document;
                c00012.L$3 = strText;
                c00012.L$4 = strAttr;
                c00012.L$5 = strText2;
                c00012.L$6 = arrayList2;
                c00012.L$7 = intOrNull;
                str9 = strText2;
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                c00012.L$9 = doubleOrNull;
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(str8);
                c00012.I$0 = i;
                c00012.label = 2;
                objAppGet = companion4.appGet(str8, mapMapOf3, c00012);
                obj3 = obj2;
                if (objAppGet == obj3) {
                    return obj3;
                }
                str10 = str8;
                d = doubleOrNull;
                i2 = i;
                obj4 = objAppGet;
                str11 = str9;
                NiceResponse niceResponse3 = (NiceResponse) obj4;
                ResponseParser parser3 = niceResponse3.getParser();
                Intrinsics.checkNotNull(parser3);
                str13 = str10;
                obj5 = obj3;
                safe = parser3.parseSafe(niceResponse3.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                episodesResponse = (EpisodesResponse) safe;
                if (episodesResponse != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                episodeItem = (EpisodeItem) CollectionsKt.firstOrNull(listEmptyList);
                if (episodeItem != null) {
                    id = episodeItem.getId();
                } else {
                    id = null;
                }
                booleanRef = new Ref.BooleanRef();
                episodesResponse2 = episodesResponse;
                num = id;
                booleanRef.element = true;
                booleanRef2 = new Ref.BooleanRef();
                if (num != null) {
                    int i112 = i2;
                    str19 = getMainUrl() + "/api/frontend/episode/" + num.intValue() + "/languages";
                    Companion companion5 = INSTANCE;
                    Map<String, String> mapMapOf4 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str11;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = intOrNull;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                    c00012.L$9 = d;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str13);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse2);
                    c00012.L$12 = listEmptyList;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num);
                    c00012.L$14 = booleanRef;
                    c00012.L$15 = booleanRef2;
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(str19);
                    str20 = str11;
                    i4 = i112;
                    c00012.I$0 = i4;
                    c00012.label = 3;
                    objAppGet2 = companion5.appGet(str19, mapMapOf4, c00012);
                    obj6 = obj5;
                    if (objAppGet2 == obj6) {
                        return obj6;
                    }
                    str21 = str7;
                    document3 = document;
                    str22 = str5;
                    str23 = strText;
                    booleanRef5 = booleanRef2;
                    list2 = listEmptyList;
                    booleanRef6 = booleanRef;
                    d3 = d;
                    NiceResponse niceResponse4 = (NiceResponse) objAppGet2;
                    ResponseParser parser4 = niceResponse4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    safe2 = parser4.parseSafe(niceResponse4.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                    languagesResponse = (LanguagesResponse) safe2;
                    if (languagesResponse != null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    if (listEmptyList2.isEmpty()) {
                        list17 = listEmptyList2;
                        if (list17 instanceof Collection) {
                            it4 = list17.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    language2 = (Language) it4.next();
                                    it5 = it4;
                                    i9 = i4;
                                    str45 = str4;
                                    str46 = str6;
                                    list14 = listEmptyList2;
                                    listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    str47 = str19;
                                    code2 = language2.getCode();
                                    if (code2 != null) {
                                        lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    } else {
                                        lowerCase3 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                        listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        name2 = language2.getName();
                                        if (name2 != null) {
                                            lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                        } else {
                                            lowerCase4 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    } else {
                                        str19 = str47;
                                        it4 = it5;
                                        i4 = i9;
                                        listEmptyList2 = list14;
                                        strAttr = strAttr;
                                        str6 = str46;
                                        str4 = str45;
                                    }
                                } else {
                                    i9 = i4;
                                    str45 = str4;
                                    list14 = listEmptyList2;
                                    strAttr = strAttr;
                                    str46 = str6;
                                    z4 = false;
                                }
                            }
                        } else {
                            it4 = list17.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    language2 = (Language) it4.next();
                                    it5 = it4;
                                    i9 = i4;
                                    str45 = str4;
                                    str46 = str6;
                                    list14 = listEmptyList2;
                                    listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    str47 = str19;
                                    code2 = language2.getCode();
                                    if (code2 != null) {
                                        lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    } else {
                                        lowerCase3 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                        listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        name2 = language2.getName();
                                        if (name2 != null) {
                                            lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                        } else {
                                            lowerCase4 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    } else {
                                        str19 = str47;
                                        it4 = it5;
                                        i4 = i9;
                                        listEmptyList2 = list14;
                                        strAttr = strAttr;
                                        str6 = str46;
                                        str4 = str45;
                                    }
                                } else {
                                    i9 = i4;
                                    str45 = str4;
                                    list14 = listEmptyList2;
                                    strAttr = strAttr;
                                    str46 = str6;
                                    z4 = false;
                                }
                            }
                        }
                        if (z4) {
                            z = false;
                        }
                        booleanRef6.element = z;
                        list15 = list14;
                        i10 = 0;
                        if (list15 instanceof Collection) {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        } else {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        }
                        booleanRef5.element = z2;
                        booleanRef3 = booleanRef5;
                        num2 = intOrNull;
                        str16 = str21;
                        strText = str23;
                        document2 = document3;
                        str5 = str22;
                        booleanRef4 = booleanRef17;
                        i3 = i9;
                        str4 = str45;
                        strAttr = strAttr;
                        list = list2;
                        d2 = d3;
                        episodesResponse3 = episodesResponse2;
                        str17 = str20;
                        num3 = num;
                        str18 = str13;
                    } else {
                        i9 = i4;
                        str45 = str4;
                        list14 = listEmptyList2;
                        strAttr = strAttr;
                        str46 = str6;
                    }
                    z = true;
                    booleanRef6.element = z;
                    list15 = list14;
                    i10 = 0;
                    if (list15 instanceof Collection) {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    } else {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    }
                    booleanRef5.element = z2;
                    booleanRef3 = booleanRef5;
                    num2 = intOrNull;
                    str16 = str21;
                    strText = str23;
                    document2 = document3;
                    str5 = str22;
                    booleanRef4 = booleanRef17;
                    i3 = i9;
                    str4 = str45;
                    strAttr = strAttr;
                    list = list2;
                    d2 = d3;
                    episodesResponse3 = episodesResponse2;
                    str17 = str20;
                    num3 = num;
                    str18 = str13;
                } else {
                    String str617 = str11;
                    str14 = str59;
                    str15 = str6;
                    obj6 = obj5;
                    d2 = d;
                    num2 = intOrNull;
                    list = listEmptyList;
                    booleanRef3 = booleanRef2;
                    str16 = str7;
                    document2 = document;
                    booleanRef4 = booleanRef;
                    i3 = i2;
                    episodesResponse3 = episodesResponse2;
                    num3 = num;
                    str17 = str617;
                    str18 = str13;
                }
                obj7 = obj6;
                arrayList3 = new ArrayList();
                str24 = str14;
                arrayList4 = new ArrayList();
                i5 = i3;
                elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                if (elementSelectFirst7 != null) {
                    arrayList5 = arrayList3;
                    str25 = str3;
                    strAttr3 = elementSelectFirst7.attr(str25);
                    if (strAttr3 != null) {
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str27 = null;
                        strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default != null) {
                            list3 = list;
                            str26 = str2;
                            strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                            if (strSubstringBefore$default2 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                            }
                            elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                            if (elementSelectFirst8 == null) {
                                str28 = str25;
                            } else {
                                str28 = str25;
                            }
                            r1 = str27;
                            if (r1 != 0) {
                                Requests app7 = MainActivityKt.getApp();
                                String str618 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                c00012.L$0 = str4;
                                c00012.L$1 = str5;
                                c00012.L$2 = document2;
                                c00012.L$3 = strText;
                                c00012.L$4 = strAttr;
                                c00012.L$5 = str17;
                                c00012.L$6 = arrayList2;
                                c00012.L$7 = num2;
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00012.L$9 = d2;
                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                List<EpisodeItem> list211 = list3;
                                c00012.L$12 = list211;
                                c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                booleanRef13 = booleanRef8;
                                c00012.L$14 = booleanRef13;
                                List list212 = arrayList2;
                                c00012.L$15 = booleanRef7;
                                arrayList7 = arrayList5;
                                c00012.L$16 = arrayList7;
                                c00012.L$17 = arrayList4;
                                c00012.L$18 = intOrNull2;
                                c00012.L$19 = r1;
                                c00012.I$0 = i5;
                                c00012.label = 4;
                                d7 = d2;
                                list11 = arrayList4;
                                r71 = r1;
                                booleanRef14 = booleanRef7;
                                i8 = i5;
                                list5 = list211;
                                num7 = num2;
                                str31 = str28;
                                str29 = str15;
                                str30 = str24;
                                obj9 = intOrNull2;
                                C00011 c00017 = c00012;
                                obj8 = obj7;
                                list12 = list212;
                                objNewAnimeLoadResponse$default = Requests.get$default(app7, str618, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00017, 4094, (Object) null);
                                c00013 = c00017;
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    r1 = intOrNull3;
                                    return obj8;
                                }
                                r1 = intOrNull3;
                                str41 = str5;
                                str36 = str18;
                                episodesResponse4 = episodesResponse3;
                                num6 = num3;
                                d8 = d7;
                                booleanRef15 = booleanRef13;
                                booleanRef16 = booleanRef14;
                                r5 = r71;
                                str42 = strText;
                                str43 = str17;
                                obj10 = obj9;
                                list13 = arrayList7;
                                str44 = strAttr;
                                text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                num5 = num7;
                                r63 = r5;
                                list6 = list12;
                                r62 = obj10;
                                list7 = list13;
                                booleanRef12 = booleanRef16;
                                booleanRef11 = booleanRef15;
                                d5 = d8;
                                str34 = str43;
                                str35 = str44;
                                str33 = str42;
                                str5 = str41;
                                list8 = list11;
                                str32 = str4;
                                i7 = i8;
                            } else {
                                r70 = r1;
                                c00013 = c00012;
                                list4 = arrayList2;
                                num4 = num2;
                                d4 = d2;
                                arrayList6 = arrayList5;
                                str29 = str15;
                                str30 = str24;
                                booleanRef9 = booleanRef7;
                                booleanRef10 = booleanRef8;
                                list5 = list3;
                                i6 = i5;
                                str31 = str28;
                                r30 = intOrNull2;
                                obj8 = obj7;
                                if (r30 != 0) {
                                    Requests app8 = MainActivityKt.getApp();
                                    String str619 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                    c00013.L$0 = str4;
                                    c00013.L$1 = str5;
                                    c00013.L$2 = document2;
                                    c00013.L$3 = strText;
                                    c00013.L$4 = strAttr;
                                    c00013.L$5 = str17;
                                    c00013.L$6 = list4;
                                    c00013.L$7 = num4;
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00013.L$9 = d4;
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    c00013.L$12 = list5;
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    c00013.L$14 = booleanRef10;
                                    c00013.L$15 = booleanRef9;
                                    c00013.L$16 = arrayList6;
                                    c00013.L$17 = arrayList4;
                                    c00013.L$18 = r30;
                                    c00013.L$19 = r70;
                                    c00013.I$0 = i6;
                                    document4 = document2;
                                    c00013.label = 5;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app8, str619, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    list9 = arrayList6;
                                    c00013 = c00013;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r11 = r30;
                                    d6 = d4;
                                    list10 = arrayList4;
                                    str37 = strText;
                                    str38 = str17;
                                    str39 = strAttr;
                                    booleanRef11 = booleanRef10;
                                    booleanRef12 = booleanRef9;
                                    str40 = str5;
                                    r4 = r70;
                                    document2 = document4;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num4;
                                    r63 = r4;
                                    list6 = list4;
                                    r62 = r11;
                                    list8 = list10;
                                    d5 = d6;
                                    str34 = str38;
                                    str35 = str39;
                                    str33 = str37;
                                    str5 = str40;
                                    list7 = list9;
                                    str32 = str4;
                                    i7 = i6;
                                } else {
                                    r63 = r70;
                                    num5 = num4;
                                    str32 = str4;
                                    list6 = list4;
                                    str33 = strText;
                                    str34 = str17;
                                    str35 = strAttr;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r62 = r30;
                                    d5 = d4;
                                    document2 = document2;
                                    booleanRef11 = booleanRef10;
                                    list7 = arrayList6;
                                    i7 = i6;
                                    booleanRef12 = booleanRef9;
                                    text = null;
                                }
                            }
                            if (text != null) {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = AniDbUtilsKt.parseAnimeData(text);
                            } else {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = null;
                            }
                            metaAnimeData = animeData;
                            if (metaAnimeData == null) {
                                str48 = text;
                            } else {
                                str48 = text;
                            }
                            if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                i12 = 1;
                            } else {
                                i12 = 0;
                            }
                            list18 = list5;
                            i13 = 0;
                            i14 = 0;
                            while (r14.hasNext()) {
                                int i113 = i14 + 1;
                                if (i14 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                episodeItem2 = (EpisodeItem) obj11;
                                List<EpisodeItem> list213 = list18;
                                i16 = i14 + 1;
                                if (metaAnimeData != null) {
                                    str53 = str33;
                                    episodes = metaAnimeData.getEpisodes();
                                    if (episodes != null) {
                                        str32 = str32;
                                        metaEpisode = episodes.get(String.valueOf(i16));
                                    }
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit11 = Unit.INSTANCE;
                                    }
                                    i14 = i113;
                                    list18 = list213;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                } else {
                                    str53 = str33;
                                }
                                metaEpisode = null;
                                if (metaEpisode != null) {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                } else {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                }
                                if (metaEpisode2 != null) {
                                    overview = metaEpisode2.getOverview();
                                } else {
                                    overview = null;
                                }
                                if (metaEpisode2 != null) {
                                    image = metaEpisode2.getImage();
                                } else {
                                    image = null;
                                }
                                if (metaEpisode2 != null) {
                                    scoreFrom10 = null;
                                } else {
                                    scoreFrom10 = null;
                                }
                                if (metaEpisode2 != null) {
                                    runtime = metaEpisode2.getRuntime();
                                } else {
                                    runtime = null;
                                }
                                if (metaEpisode2 != null) {
                                    airDateUtc = metaEpisode2.getAirDateUtc();
                                } else {
                                    airDateUtc = null;
                                }
                                if (i12 != 0) {
                                    Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    })));
                                } else {
                                    if (booleanRef11.element) {
                                        list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    if (booleanRef12.element) {
                                        list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    Unit unit12 = Unit.INSTANCE;
                                }
                                i14 = i113;
                                list18 = list213;
                                str33 = str53;
                                str32 = str32;
                                i13 = i13;
                                str29 = str56;
                                str30 = str54;
                            }
                            String str6110 = str33;
                            String str6111 = str32;
                            if (i12 != 0) {
                                tvType = TvType.AnimeMovie;
                            } else {
                                tvType = TvType.Anime;
                            }
                            TvType tvType6 = tvType;
                            elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                            if (elementSelectFirst9 != null) {
                                strAttr4 = elementSelectFirst9.attr(str31);
                            } else {
                                strAttr4 = null;
                            }
                            elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                            if (elementSelectFirst10 != null) {
                                strText4 = elementSelectFirst10.text();
                            } else {
                                strText4 = null;
                            }
                            if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                showStatus = ShowStatus.Completed;
                            } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                showStatus = ShowStatus.Ongoing;
                            } else {
                                showStatus = null;
                            }
                            it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                            while (true) {
                                document5 = document2;
                                list19 = list8;
                                if (it6.hasNext()) {
                                    next2 = it6.next();
                                    element3 = (Element) next2;
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                        z8 = true;
                                    } else {
                                        z8 = true;
                                    }
                                    if (z8) {
                                        document2 = document5;
                                        booleanRef12 = booleanRef18;
                                        str5 = str49;
                                        booleanRef11 = booleanRef19;
                                        strText4 = str50;
                                        list7 = list20;
                                        list8 = list19;
                                    }
                                } else {
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    next2 = null;
                                }
                            }
                            element2 = (Element) next2;
                            if (element2 != null) {
                                strText5 = element2.text();
                            } else {
                                strText5 = str51;
                            }
                            str52 = strText5;
                            if (str52 != null) {
                                if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                    if (intOrNull5 != null) {
                                        iIntValue = intOrNull5.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                    intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                } else {
                                    intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                }
                                r60 = intOrNull4;
                            } else {
                                r60 = str51;
                            }
                            AniDb aniDb5 = this;
                            if (i12 != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            C00025 c00029 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(str6111);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(str6110);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType6);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                            c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                            c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                            c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                            c00013.I$0 = i7;
                            c00013.I$1 = i12;
                            c00013.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb5, str6110, str6111, tvType6, false, c00029, c00013, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                return obj8;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        list3 = list;
                        str26 = str2;
                    } else {
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str26 = str2;
                        str27 = null;
                    }
                } else {
                    arrayList5 = arrayList3;
                    list3 = list;
                    booleanRef7 = booleanRef3;
                    booleanRef8 = booleanRef4;
                    str25 = str3;
                    str26 = str2;
                    str27 = null;
                }
                intOrNull2 = str27;
                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                if (elementSelectFirst8 == null) {
                    str28 = str25;
                } else {
                    str28 = str25;
                }
                r1 = str27;
                if (r1 != 0) {
                    Requests app9 = MainActivityKt.getApp();
                    String str6112 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document2;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str17;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = num2;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00012.L$9 = d2;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                    List<EpisodeItem> list214 = list3;
                    c00012.L$12 = list214;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                    booleanRef13 = booleanRef8;
                    c00012.L$14 = booleanRef13;
                    List list215 = arrayList2;
                    c00012.L$15 = booleanRef7;
                    arrayList7 = arrayList5;
                    c00012.L$16 = arrayList7;
                    c00012.L$17 = arrayList4;
                    c00012.L$18 = intOrNull2;
                    c00012.L$19 = r1;
                    c00012.I$0 = i5;
                    c00012.label = 4;
                    d7 = d2;
                    list11 = arrayList4;
                    r71 = r1;
                    booleanRef14 = booleanRef7;
                    i8 = i5;
                    list5 = list214;
                    num7 = num2;
                    str31 = str28;
                    str29 = str15;
                    str30 = str24;
                    obj9 = intOrNull2;
                    C00011 c00018 = c00012;
                    obj8 = obj7;
                    list12 = list215;
                    objNewAnimeLoadResponse$default = Requests.get$default(app9, str6112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00018, 4094, (Object) null);
                    c00013 = c00018;
                    if (objNewAnimeLoadResponse$default == obj8) {
                        r1 = intOrNull3;
                        return obj8;
                    }
                    r1 = intOrNull3;
                    str41 = str5;
                    str36 = str18;
                    episodesResponse4 = episodesResponse3;
                    num6 = num3;
                    d8 = d7;
                    booleanRef15 = booleanRef13;
                    booleanRef16 = booleanRef14;
                    r5 = r71;
                    str42 = strText;
                    str43 = str17;
                    obj10 = obj9;
                    list13 = arrayList7;
                    str44 = strAttr;
                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                    num5 = num7;
                    r63 = r5;
                    list6 = list12;
                    r62 = obj10;
                    list7 = list13;
                    booleanRef12 = booleanRef16;
                    booleanRef11 = booleanRef15;
                    d5 = d8;
                    str34 = str43;
                    str35 = str44;
                    str33 = str42;
                    str5 = str41;
                    list8 = list11;
                    str32 = str4;
                    i7 = i8;
                } else {
                    r70 = r1;
                    c00013 = c00012;
                    list4 = arrayList2;
                    num4 = num2;
                    d4 = d2;
                    arrayList6 = arrayList5;
                    str29 = str15;
                    str30 = str24;
                    booleanRef9 = booleanRef7;
                    booleanRef10 = booleanRef8;
                    list5 = list3;
                    i6 = i5;
                    str31 = str28;
                    r30 = intOrNull2;
                    obj8 = obj7;
                    if (r30 != 0) {
                        Requests app10 = MainActivityKt.getApp();
                        String str6113 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                        c00013.L$0 = str4;
                        c00013.L$1 = str5;
                        c00013.L$2 = document2;
                        c00013.L$3 = strText;
                        c00013.L$4 = strAttr;
                        c00013.L$5 = str17;
                        c00013.L$6 = list4;
                        c00013.L$7 = num4;
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00013.L$9 = d4;
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        c00013.L$12 = list5;
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        c00013.L$14 = booleanRef10;
                        c00013.L$15 = booleanRef9;
                        c00013.L$16 = arrayList6;
                        c00013.L$17 = arrayList4;
                        c00013.L$18 = r30;
                        c00013.L$19 = r70;
                        c00013.I$0 = i6;
                        document4 = document2;
                        c00013.label = 5;
                        objNewAnimeLoadResponse$default = Requests.get$default(app10, str6113, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        list9 = arrayList6;
                        c00013 = c00013;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r11 = r30;
                        d6 = d4;
                        list10 = arrayList4;
                        str37 = strText;
                        str38 = str17;
                        str39 = strAttr;
                        booleanRef11 = booleanRef10;
                        booleanRef12 = booleanRef9;
                        str40 = str5;
                        r4 = r70;
                        document2 = document4;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num4;
                        r63 = r4;
                        list6 = list4;
                        r62 = r11;
                        list8 = list10;
                        d5 = d6;
                        str34 = str38;
                        str35 = str39;
                        str33 = str37;
                        str5 = str40;
                        list7 = list9;
                        str32 = str4;
                        i7 = i6;
                    } else {
                        r63 = r70;
                        num5 = num4;
                        str32 = str4;
                        list6 = list4;
                        str33 = strText;
                        str34 = str17;
                        str35 = strAttr;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r62 = r30;
                        d5 = d4;
                        document2 = document2;
                        booleanRef11 = booleanRef10;
                        list7 = arrayList6;
                        i7 = i6;
                        booleanRef12 = booleanRef9;
                        text = null;
                    }
                }
                if (text != null) {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = AniDbUtilsKt.parseAnimeData(text);
                } else {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = null;
                }
                metaAnimeData = animeData;
                if (metaAnimeData == null) {
                    str48 = text;
                } else {
                    str48 = text;
                }
                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                list18 = list5;
                i13 = 0;
                i14 = 0;
                while (r14.hasNext()) {
                    int i114 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    episodeItem2 = (EpisodeItem) obj11;
                    List<EpisodeItem> list216 = list18;
                    i16 = i14 + 1;
                    if (metaAnimeData != null) {
                        str53 = str33;
                        episodes = metaAnimeData.getEpisodes();
                        if (episodes != null) {
                            str32 = str32;
                            metaEpisode = episodes.get(String.valueOf(i16));
                        }
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit13 = Unit.INSTANCE;
                        }
                        i14 = i114;
                        list18 = list216;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    } else {
                        str53 = str33;
                    }
                    metaEpisode = null;
                    if (metaEpisode != null) {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    } else {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    }
                    if (metaEpisode2 != null) {
                        overview = metaEpisode2.getOverview();
                    } else {
                        overview = null;
                    }
                    if (metaEpisode2 != null) {
                        image = metaEpisode2.getImage();
                    } else {
                        image = null;
                    }
                    if (metaEpisode2 != null) {
                        scoreFrom10 = null;
                    } else {
                        scoreFrom10 = null;
                    }
                    if (metaEpisode2 != null) {
                        runtime = metaEpisode2.getRuntime();
                    } else {
                        runtime = null;
                    }
                    if (metaEpisode2 != null) {
                        airDateUtc = metaEpisode2.getAirDateUtc();
                    } else {
                        airDateUtc = null;
                    }
                    if (i12 != 0) {
                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj12) {
                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                            }
                        })));
                    } else {
                        if (booleanRef11.element) {
                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        if (booleanRef12.element) {
                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        Unit unit14 = Unit.INSTANCE;
                    }
                    i14 = i114;
                    list18 = list216;
                    str33 = str53;
                    str32 = str32;
                    i13 = i13;
                    str29 = str56;
                    str30 = str54;
                }
                String str6114 = str33;
                String str6115 = str32;
                if (i12 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType7 = tvType;
                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                if (elementSelectFirst9 != null) {
                    strAttr4 = elementSelectFirst9.attr(str31);
                } else {
                    strAttr4 = null;
                }
                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                if (elementSelectFirst10 != null) {
                    strText4 = elementSelectFirst10.text();
                } else {
                    strText4 = null;
                }
                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                    showStatus = ShowStatus.Completed;
                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                    showStatus = ShowStatus.Ongoing;
                } else {
                    showStatus = null;
                }
                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                while (true) {
                    document5 = document2;
                    list19 = list8;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                        element3 = (Element) next2;
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            document2 = document5;
                            booleanRef12 = booleanRef18;
                            str5 = str49;
                            booleanRef11 = booleanRef19;
                            strText4 = str50;
                            list7 = list20;
                            list8 = list19;
                        }
                    } else {
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        next2 = null;
                    }
                }
                element2 = (Element) next2;
                if (element2 != null) {
                    strText5 = element2.text();
                } else {
                    strText5 = str51;
                }
                str52 = strText5;
                if (str52 != null) {
                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                        if (intOrNull5 != null) {
                            iIntValue = intOrNull5.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                    } else {
                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                    }
                    r60 = intOrNull4;
                } else {
                    r60 = str51;
                }
                AniDb aniDb6 = this;
                if (i12 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                C00025 c000210 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str6115);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str6114);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType7);
                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                c00013.I$0 = i7;
                c00013.I$1 = i12;
                c00013.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb6, str6114, str6115, tvType7, false, c000210, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                i = c00013.I$0;
                String str70 = (String) c00013.L$1;
                str4 = (String) c00013.L$0;
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                str3 = "href";
                str2 = "/";
                str5 = str70;
                objAppGet$default = objNewAnimeLoadResponse$default;
                c00012 = c00013;
                document = ((NiceResponse) objAppGet$default).getDocument();
                elementSelectFirst = document.selectFirst("h1");
                if (elementSelectFirst != null) {
                    strText = "";
                } else {
                    strText = "";
                }
                elementSelectFirst2 = document.selectFirst("div.flex-shrink-0 img");
                if (elementSelectFirst2 != null) {
                    elementSelectFirst3 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("content");
                    } else {
                        strAttr = null;
                    }
                } else {
                    elementSelectFirst3 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                elementSelectFirst4 = document.selectFirst("meta[name=description]");
                if (elementSelectFirst4 != null) {
                    elementSelectFirst5 = document.selectFirst(".description");
                    if (elementSelectFirst5 != null) {
                        strText2 = elementSelectFirst5.text();
                    } else {
                        strText2 = null;
                    }
                } else {
                    elementSelectFirst5 = document.selectFirst(".description");
                    if (elementSelectFirst5 != null) {
                        strText2 = elementSelectFirst5.text();
                    } else {
                        strText2 = null;
                    }
                }
                Iterable iterableSelect3 = document.select("a.filter-chip");
                obj = objNewAnimeLoadResponse$default;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableSelect3, 10));
                iterable = iterableSelect3;
                it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Element) it.next()).text());
                    iterable = iterable;
                }
                arrayList2 = arrayList;
                elementSelectFirst6 = document.selectFirst("a[href*=&year=]");
                if (elementSelectFirst6 != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
                iterableSelect = document.select("span.badge-gray");
                it2 = iterableSelect.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next = it2.next();
                        iterable2 = iterableSelect;
                        str6 = str60;
                        obj2 = coroutine_suspended;
                        if (new Regex("[0-9]").containsMatchIn(((Element) next).text())) {
                            iterableSelect = iterable2;
                            str60 = str6;
                            coroutine_suspended = obj2;
                        }
                    } else {
                        obj2 = coroutine_suspended;
                        str6 = str60;
                        next = null;
                    }
                }
                element = (Element) next;
                if (element != null) {
                    string = null;
                } else {
                    string = null;
                }
                if (string != null) {
                    str7 = string;
                    String strReplace2 = new Regex("[^0-9.]").replace(string, "");
                    if (strReplace2 != null) {
                    }
                    str8 = getMainUrl() + "/api/frontend/anime/" + i + "/episodes";
                    Companion companion6 = INSTANCE;
                    Map<String, String> mapMapOf5 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = strText2;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = intOrNull;
                    str9 = strText2;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                    c00012.L$9 = doubleOrNull;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str8);
                    c00012.I$0 = i;
                    c00012.label = 2;
                    objAppGet = companion6.appGet(str8, mapMapOf5, c00012);
                    obj3 = obj2;
                    if (objAppGet == obj3) {
                        return obj3;
                    }
                    str10 = str8;
                    d = doubleOrNull;
                    i2 = i;
                    obj4 = objAppGet;
                    str11 = str9;
                    NiceResponse niceResponse5 = (NiceResponse) obj4;
                    ResponseParser parser5 = niceResponse5.getParser();
                    Intrinsics.checkNotNull(parser5);
                    str13 = str10;
                    obj5 = obj3;
                    safe = parser5.parseSafe(niceResponse5.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                    episodesResponse = (EpisodesResponse) safe;
                    if (episodesResponse != null) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    episodeItem = (EpisodeItem) CollectionsKt.firstOrNull(listEmptyList);
                    if (episodeItem != null) {
                        id = episodeItem.getId();
                    } else {
                        id = null;
                    }
                    booleanRef = new Ref.BooleanRef();
                    episodesResponse2 = episodesResponse;
                    num = id;
                    booleanRef.element = true;
                    booleanRef2 = new Ref.BooleanRef();
                    if (num != null) {
                        int i115 = i2;
                        str19 = getMainUrl() + "/api/frontend/episode/" + num.intValue() + "/languages";
                        Companion companion7 = INSTANCE;
                        Map<String, String> mapMapOf6 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                        c00012.L$0 = str4;
                        c00012.L$1 = str5;
                        c00012.L$2 = document;
                        c00012.L$3 = strText;
                        c00012.L$4 = strAttr;
                        c00012.L$5 = str11;
                        c00012.L$6 = arrayList2;
                        c00012.L$7 = intOrNull;
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                        c00012.L$9 = d;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(str13);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse2);
                        c00012.L$12 = listEmptyList;
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(num);
                        c00012.L$14 = booleanRef;
                        c00012.L$15 = booleanRef2;
                        c00012.L$16 = SpillingKt.nullOutSpilledVariable(str19);
                        str20 = str11;
                        i4 = i115;
                        c00012.I$0 = i4;
                        c00012.label = 3;
                        objAppGet2 = companion7.appGet(str19, mapMapOf6, c00012);
                        obj6 = obj5;
                        if (objAppGet2 == obj6) {
                            return obj6;
                        }
                        str21 = str7;
                        document3 = document;
                        str22 = str5;
                        str23 = strText;
                        booleanRef5 = booleanRef2;
                        list2 = listEmptyList;
                        booleanRef6 = booleanRef;
                        d3 = d;
                        NiceResponse niceResponse6 = (NiceResponse) objAppGet2;
                        ResponseParser parser6 = niceResponse6.getParser();
                        Intrinsics.checkNotNull(parser6);
                        safe2 = parser6.parseSafe(niceResponse6.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                        languagesResponse = (LanguagesResponse) safe2;
                        if (languagesResponse != null) {
                            listEmptyList2 = CollectionsKt.emptyList();
                        } else {
                            listEmptyList2 = CollectionsKt.emptyList();
                        }
                        if (listEmptyList2.isEmpty()) {
                            list17 = listEmptyList2;
                            if (list17 instanceof Collection) {
                                it4 = list17.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        language2 = (Language) it4.next();
                                        it5 = it4;
                                        i9 = i4;
                                        str45 = str4;
                                        str46 = str6;
                                        list14 = listEmptyList2;
                                        listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        str47 = str19;
                                        code2 = language2.getCode();
                                        if (code2 != null) {
                                            lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                        } else {
                                            lowerCase3 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                            listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                            name2 = language2.getName();
                                            if (name2 != null) {
                                                lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                            } else {
                                                lowerCase4 = null;
                                            }
                                            if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                        } else {
                                            z5 = true;
                                        }
                                        if (z5) {
                                            z4 = true;
                                        } else {
                                            str19 = str47;
                                            it4 = it5;
                                            i4 = i9;
                                            listEmptyList2 = list14;
                                            strAttr = strAttr;
                                            str6 = str46;
                                            str4 = str45;
                                        }
                                    } else {
                                        i9 = i4;
                                        str45 = str4;
                                        list14 = listEmptyList2;
                                        strAttr = strAttr;
                                        str46 = str6;
                                        z4 = false;
                                    }
                                }
                            } else {
                                it4 = list17.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        language2 = (Language) it4.next();
                                        it5 = it4;
                                        i9 = i4;
                                        str45 = str4;
                                        str46 = str6;
                                        list14 = listEmptyList2;
                                        listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        str47 = str19;
                                        code2 = language2.getCode();
                                        if (code2 != null) {
                                            lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                        } else {
                                            lowerCase3 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                            listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                            name2 = language2.getName();
                                            if (name2 != null) {
                                                lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                            } else {
                                                lowerCase4 = null;
                                            }
                                            if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                                z5 = true;
                                            } else {
                                                z5 = false;
                                            }
                                        } else {
                                            z5 = true;
                                        }
                                        if (z5) {
                                            z4 = true;
                                        } else {
                                            str19 = str47;
                                            it4 = it5;
                                            i4 = i9;
                                            listEmptyList2 = list14;
                                            strAttr = strAttr;
                                            str6 = str46;
                                            str4 = str45;
                                        }
                                    } else {
                                        i9 = i4;
                                        str45 = str4;
                                        list14 = listEmptyList2;
                                        strAttr = strAttr;
                                        str46 = str6;
                                        z4 = false;
                                    }
                                }
                            }
                            if (z4) {
                                z = false;
                            }
                            booleanRef6.element = z;
                            list15 = list14;
                            i10 = 0;
                            if (list15 instanceof Collection) {
                                it3 = list15.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        language = (Language) it3.next();
                                        list16 = list15;
                                        i11 = i10;
                                        str14 = str59;
                                        booleanRef17 = booleanRef6;
                                        listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        str15 = str46;
                                        code = language.getCode();
                                        if (code != null) {
                                            lowerCase = code.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        } else {
                                            lowerCase = null;
                                        }
                                        if (CollectionsKt.contains(listListOf, lowerCase)) {
                                            listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                            name = language.getName();
                                            if (name != null) {
                                                lowerCase2 = name.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                            } else {
                                                lowerCase2 = null;
                                            }
                                            if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        } else {
                                            z3 = true;
                                        }
                                        if (z3) {
                                            z2 = true;
                                        } else {
                                            str46 = str15;
                                            list15 = list16;
                                            booleanRef6 = booleanRef17;
                                            it3 = it3;
                                            str59 = str14;
                                            i10 = i11;
                                        }
                                    } else {
                                        booleanRef17 = booleanRef6;
                                        str14 = str59;
                                        str15 = str46;
                                        z2 = false;
                                    }
                                }
                            } else {
                                it3 = list15.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        language = (Language) it3.next();
                                        list16 = list15;
                                        i11 = i10;
                                        str14 = str59;
                                        booleanRef17 = booleanRef6;
                                        listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        str15 = str46;
                                        code = language.getCode();
                                        if (code != null) {
                                            lowerCase = code.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                        } else {
                                            lowerCase = null;
                                        }
                                        if (CollectionsKt.contains(listListOf, lowerCase)) {
                                            listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                            name = language.getName();
                                            if (name != null) {
                                                lowerCase2 = name.toLowerCase(Locale.ROOT);
                                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                            } else {
                                                lowerCase2 = null;
                                            }
                                            if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        } else {
                                            z3 = true;
                                        }
                                        if (z3) {
                                            z2 = true;
                                        } else {
                                            str46 = str15;
                                            list15 = list16;
                                            booleanRef6 = booleanRef17;
                                            it3 = it3;
                                            str59 = str14;
                                            i10 = i11;
                                        }
                                    } else {
                                        booleanRef17 = booleanRef6;
                                        str14 = str59;
                                        str15 = str46;
                                        z2 = false;
                                    }
                                }
                            }
                            booleanRef5.element = z2;
                            booleanRef3 = booleanRef5;
                            num2 = intOrNull;
                            str16 = str21;
                            strText = str23;
                            document2 = document3;
                            str5 = str22;
                            booleanRef4 = booleanRef17;
                            i3 = i9;
                            str4 = str45;
                            strAttr = strAttr;
                            list = list2;
                            d2 = d3;
                            episodesResponse3 = episodesResponse2;
                            str17 = str20;
                            num3 = num;
                            str18 = str13;
                        } else {
                            i9 = i4;
                            str45 = str4;
                            list14 = listEmptyList2;
                            strAttr = strAttr;
                            str46 = str6;
                        }
                        z = true;
                        booleanRef6.element = z;
                        list15 = list14;
                        i10 = 0;
                        if (list15 instanceof Collection) {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        } else {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        }
                        booleanRef5.element = z2;
                        booleanRef3 = booleanRef5;
                        num2 = intOrNull;
                        str16 = str21;
                        strText = str23;
                        document2 = document3;
                        str5 = str22;
                        booleanRef4 = booleanRef17;
                        i3 = i9;
                        str4 = str45;
                        strAttr = strAttr;
                        list = list2;
                        d2 = d3;
                        episodesResponse3 = episodesResponse2;
                        str17 = str20;
                        num3 = num;
                        str18 = str13;
                    } else {
                        String str6116 = str11;
                        str14 = str59;
                        str15 = str6;
                        obj6 = obj5;
                        d2 = d;
                        num2 = intOrNull;
                        list = listEmptyList;
                        booleanRef3 = booleanRef2;
                        str16 = str7;
                        document2 = document;
                        booleanRef4 = booleanRef;
                        i3 = i2;
                        episodesResponse3 = episodesResponse2;
                        num3 = num;
                        str17 = str6116;
                        str18 = str13;
                    }
                    obj7 = obj6;
                    arrayList3 = new ArrayList();
                    str24 = str14;
                    arrayList4 = new ArrayList();
                    i5 = i3;
                    elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                    if (elementSelectFirst7 != null) {
                        arrayList5 = arrayList3;
                        str25 = str3;
                        strAttr3 = elementSelectFirst7.attr(str25);
                        if (strAttr3 != null) {
                            booleanRef7 = booleanRef3;
                            booleanRef8 = booleanRef4;
                            str27 = null;
                            strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                            if (strSubstringAfter$default != null) {
                                list3 = list;
                                str26 = str2;
                                strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                                if (strSubstringBefore$default2 != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                                }
                                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                                if (elementSelectFirst8 == null) {
                                    str28 = str25;
                                } else {
                                    str28 = str25;
                                }
                                r1 = str27;
                                if (r1 != 0) {
                                    Requests app11 = MainActivityKt.getApp();
                                    String str6117 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                    c00012.L$0 = str4;
                                    c00012.L$1 = str5;
                                    c00012.L$2 = document2;
                                    c00012.L$3 = strText;
                                    c00012.L$4 = strAttr;
                                    c00012.L$5 = str17;
                                    c00012.L$6 = arrayList2;
                                    c00012.L$7 = num2;
                                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00012.L$9 = d2;
                                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    List<EpisodeItem> list217 = list3;
                                    c00012.L$12 = list217;
                                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    booleanRef13 = booleanRef8;
                                    c00012.L$14 = booleanRef13;
                                    List list218 = arrayList2;
                                    c00012.L$15 = booleanRef7;
                                    arrayList7 = arrayList5;
                                    c00012.L$16 = arrayList7;
                                    c00012.L$17 = arrayList4;
                                    c00012.L$18 = intOrNull2;
                                    c00012.L$19 = r1;
                                    c00012.I$0 = i5;
                                    c00012.label = 4;
                                    d7 = d2;
                                    list11 = arrayList4;
                                    r71 = r1;
                                    booleanRef14 = booleanRef7;
                                    i8 = i5;
                                    list5 = list217;
                                    num7 = num2;
                                    str31 = str28;
                                    str29 = str15;
                                    str30 = str24;
                                    obj9 = intOrNull2;
                                    C00011 c00019 = c00012;
                                    obj8 = obj7;
                                    list12 = list218;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app11, str6117, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00019, 4094, (Object) null);
                                    c00013 = c00019;
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    str41 = str5;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    d8 = d7;
                                    booleanRef15 = booleanRef13;
                                    booleanRef16 = booleanRef14;
                                    r5 = r71;
                                    str42 = strText;
                                    str43 = str17;
                                    obj10 = obj9;
                                    list13 = arrayList7;
                                    str44 = strAttr;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num7;
                                    r63 = r5;
                                    list6 = list12;
                                    r62 = obj10;
                                    list7 = list13;
                                    booleanRef12 = booleanRef16;
                                    booleanRef11 = booleanRef15;
                                    d5 = d8;
                                    str34 = str43;
                                    str35 = str44;
                                    str33 = str42;
                                    str5 = str41;
                                    list8 = list11;
                                    str32 = str4;
                                    i7 = i8;
                                } else {
                                    r70 = r1;
                                    c00013 = c00012;
                                    list4 = arrayList2;
                                    num4 = num2;
                                    d4 = d2;
                                    arrayList6 = arrayList5;
                                    str29 = str15;
                                    str30 = str24;
                                    booleanRef9 = booleanRef7;
                                    booleanRef10 = booleanRef8;
                                    list5 = list3;
                                    i6 = i5;
                                    str31 = str28;
                                    r30 = intOrNull2;
                                    obj8 = obj7;
                                    if (r30 != 0) {
                                        Requests app12 = MainActivityKt.getApp();
                                        String str6118 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                        c00013.L$0 = str4;
                                        c00013.L$1 = str5;
                                        c00013.L$2 = document2;
                                        c00013.L$3 = strText;
                                        c00013.L$4 = strAttr;
                                        c00013.L$5 = str17;
                                        c00013.L$6 = list4;
                                        c00013.L$7 = num4;
                                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                        c00013.L$9 = d4;
                                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                        c00013.L$12 = list5;
                                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                        c00013.L$14 = booleanRef10;
                                        c00013.L$15 = booleanRef9;
                                        c00013.L$16 = arrayList6;
                                        c00013.L$17 = arrayList4;
                                        c00013.L$18 = r30;
                                        c00013.L$19 = r70;
                                        c00013.I$0 = i6;
                                        document4 = document2;
                                        c00013.label = 5;
                                        objNewAnimeLoadResponse$default = Requests.get$default(app12, str6118, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                        if (objNewAnimeLoadResponse$default == obj8) {
                                            r1 = intOrNull3;
                                            list9 = arrayList6;
                                            c00013 = c00013;
                                            return obj8;
                                        }
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        r11 = r30;
                                        d6 = d4;
                                        list10 = arrayList4;
                                        str37 = strText;
                                        str38 = str17;
                                        str39 = strAttr;
                                        booleanRef11 = booleanRef10;
                                        booleanRef12 = booleanRef9;
                                        str40 = str5;
                                        r4 = r70;
                                        document2 = document4;
                                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                        num5 = num4;
                                        r63 = r4;
                                        list6 = list4;
                                        r62 = r11;
                                        list8 = list10;
                                        d5 = d6;
                                        str34 = str38;
                                        str35 = str39;
                                        str33 = str37;
                                        str5 = str40;
                                        list7 = list9;
                                        str32 = str4;
                                        i7 = i6;
                                    } else {
                                        r63 = r70;
                                        num5 = num4;
                                        str32 = str4;
                                        list6 = list4;
                                        str33 = strText;
                                        str34 = str17;
                                        str35 = strAttr;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        r62 = r30;
                                        d5 = d4;
                                        document2 = document2;
                                        booleanRef11 = booleanRef10;
                                        list7 = arrayList6;
                                        i7 = i6;
                                        booleanRef12 = booleanRef9;
                                        text = null;
                                    }
                                }
                                if (text != null) {
                                    r1 = intOrNull3;
                                    list8 = arrayList4;
                                    animeData = AniDbUtilsKt.parseAnimeData(text);
                                } else {
                                    r1 = intOrNull3;
                                    list8 = arrayList4;
                                    animeData = null;
                                }
                                metaAnimeData = animeData;
                                if (metaAnimeData == null) {
                                    str48 = text;
                                } else {
                                    str48 = text;
                                }
                                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                    i12 = 1;
                                } else {
                                    i12 = 0;
                                }
                                list18 = list5;
                                i13 = 0;
                                i14 = 0;
                                while (r14.hasNext()) {
                                    int i116 = i14 + 1;
                                    if (i14 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    episodeItem2 = (EpisodeItem) obj11;
                                    List<EpisodeItem> list219 = list18;
                                    i16 = i14 + 1;
                                    if (metaAnimeData != null) {
                                        str53 = str33;
                                        episodes = metaAnimeData.getEpisodes();
                                        if (episodes != null) {
                                            str32 = str32;
                                            metaEpisode = episodes.get(String.valueOf(i16));
                                        }
                                        if (metaEpisode != null) {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        } else {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        }
                                        if (metaEpisode2 != null) {
                                            overview = metaEpisode2.getOverview();
                                        } else {
                                            overview = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            image = metaEpisode2.getImage();
                                        } else {
                                            image = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            scoreFrom10 = null;
                                        } else {
                                            scoreFrom10 = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            runtime = metaEpisode2.getRuntime();
                                        } else {
                                            runtime = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            airDateUtc = metaEpisode2.getAirDateUtc();
                                        } else {
                                            airDateUtc = null;
                                        }
                                        if (i12 != 0) {
                                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            })));
                                        } else {
                                            if (booleanRef11.element) {
                                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            if (booleanRef12.element) {
                                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            Unit unit15 = Unit.INSTANCE;
                                        }
                                        i14 = i116;
                                        list18 = list219;
                                        str33 = str53;
                                        str32 = str32;
                                        i13 = i13;
                                        str29 = str56;
                                        str30 = str54;
                                    } else {
                                        str53 = str33;
                                    }
                                    metaEpisode = null;
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit16 = Unit.INSTANCE;
                                    }
                                    i14 = i116;
                                    list18 = list219;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                }
                                String str6119 = str33;
                                String str61110 = str32;
                                if (i12 != 0) {
                                    tvType = TvType.AnimeMovie;
                                } else {
                                    tvType = TvType.Anime;
                                }
                                TvType tvType8 = tvType;
                                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                                if (elementSelectFirst9 != null) {
                                    strAttr4 = elementSelectFirst9.attr(str31);
                                } else {
                                    strAttr4 = null;
                                }
                                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                                if (elementSelectFirst10 != null) {
                                    strText4 = elementSelectFirst10.text();
                                } else {
                                    strText4 = null;
                                }
                                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                    showStatus = ShowStatus.Completed;
                                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                    showStatus = ShowStatus.Ongoing;
                                } else {
                                    showStatus = null;
                                }
                                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                                while (true) {
                                    document5 = document2;
                                    list19 = list8;
                                    if (it6.hasNext()) {
                                        next2 = it6.next();
                                        element3 = (Element) next2;
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                            z8 = true;
                                        } else {
                                            z8 = true;
                                        }
                                        if (z8) {
                                            document2 = document5;
                                            booleanRef12 = booleanRef18;
                                            str5 = str49;
                                            booleanRef11 = booleanRef19;
                                            strText4 = str50;
                                            list7 = list20;
                                            list8 = list19;
                                        }
                                    } else {
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        next2 = null;
                                    }
                                }
                                element2 = (Element) next2;
                                if (element2 != null) {
                                    strText5 = element2.text();
                                } else {
                                    strText5 = str51;
                                }
                                str52 = strText5;
                                if (str52 != null) {
                                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                            if (intOrNull5 != null) {
                                                iIntValue = intOrNull5.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                        } else {
                                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                        }
                                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                    r60 = intOrNull4;
                                } else {
                                    r60 = str51;
                                }
                                AniDb aniDb7 = this;
                                if (i12 != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                C00025 c000211 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str61110);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str6119);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType8);
                                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                                c00013.I$0 = i7;
                                c00013.I$1 = i12;
                                c00013.label = 6;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb7, str6119, str61110, tvType8, false, c000211, c00013, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    return obj8;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            list3 = list;
                            str26 = str2;
                        } else {
                            list3 = list;
                            booleanRef7 = booleanRef3;
                            booleanRef8 = booleanRef4;
                            str26 = str2;
                            str27 = null;
                        }
                    } else {
                        arrayList5 = arrayList3;
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str25 = str3;
                        str26 = str2;
                        str27 = null;
                    }
                    intOrNull2 = str27;
                    elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                    if (elementSelectFirst8 == null) {
                        str28 = str25;
                    } else {
                        str28 = str25;
                    }
                    r1 = str27;
                    if (r1 != 0) {
                        Requests app13 = MainActivityKt.getApp();
                        String str61111 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                        c00012.L$0 = str4;
                        c00012.L$1 = str5;
                        c00012.L$2 = document2;
                        c00012.L$3 = strText;
                        c00012.L$4 = strAttr;
                        c00012.L$5 = str17;
                        c00012.L$6 = arrayList2;
                        c00012.L$7 = num2;
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00012.L$9 = d2;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        List<EpisodeItem> list2110 = list3;
                        c00012.L$12 = list2110;
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        booleanRef13 = booleanRef8;
                        c00012.L$14 = booleanRef13;
                        List list2111 = arrayList2;
                        c00012.L$15 = booleanRef7;
                        arrayList7 = arrayList5;
                        c00012.L$16 = arrayList7;
                        c00012.L$17 = arrayList4;
                        c00012.L$18 = intOrNull2;
                        c00012.L$19 = r1;
                        c00012.I$0 = i5;
                        c00012.label = 4;
                        d7 = d2;
                        list11 = arrayList4;
                        r71 = r1;
                        booleanRef14 = booleanRef7;
                        i8 = i5;
                        list5 = list2110;
                        num7 = num2;
                        str31 = str28;
                        str29 = str15;
                        str30 = str24;
                        obj9 = intOrNull2;
                        C00011 c000110 = c00012;
                        obj8 = obj7;
                        list12 = list2111;
                        objNewAnimeLoadResponse$default = Requests.get$default(app13, str61111, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000110, 4094, (Object) null);
                        c00013 = c000110;
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        str41 = str5;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        d8 = d7;
                        booleanRef15 = booleanRef13;
                        booleanRef16 = booleanRef14;
                        r5 = r71;
                        str42 = strText;
                        str43 = str17;
                        obj10 = obj9;
                        list13 = arrayList7;
                        str44 = strAttr;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num7;
                        r63 = r5;
                        list6 = list12;
                        r62 = obj10;
                        list7 = list13;
                        booleanRef12 = booleanRef16;
                        booleanRef11 = booleanRef15;
                        d5 = d8;
                        str34 = str43;
                        str35 = str44;
                        str33 = str42;
                        str5 = str41;
                        list8 = list11;
                        str32 = str4;
                        i7 = i8;
                    } else {
                        r70 = r1;
                        c00013 = c00012;
                        list4 = arrayList2;
                        num4 = num2;
                        d4 = d2;
                        arrayList6 = arrayList5;
                        str29 = str15;
                        str30 = str24;
                        booleanRef9 = booleanRef7;
                        booleanRef10 = booleanRef8;
                        list5 = list3;
                        i6 = i5;
                        str31 = str28;
                        r30 = intOrNull2;
                        obj8 = obj7;
                        if (r30 != 0) {
                            Requests app14 = MainActivityKt.getApp();
                            String str61112 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                            c00013.L$0 = str4;
                            c00013.L$1 = str5;
                            c00013.L$2 = document2;
                            c00013.L$3 = strText;
                            c00013.L$4 = strAttr;
                            c00013.L$5 = str17;
                            c00013.L$6 = list4;
                            c00013.L$7 = num4;
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = d4;
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                            c00013.L$12 = list5;
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                            c00013.L$14 = booleanRef10;
                            c00013.L$15 = booleanRef9;
                            c00013.L$16 = arrayList6;
                            c00013.L$17 = arrayList4;
                            c00013.L$18 = r30;
                            c00013.L$19 = r70;
                            c00013.I$0 = i6;
                            document4 = document2;
                            c00013.label = 5;
                            objNewAnimeLoadResponse$default = Requests.get$default(app14, str61112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                r1 = intOrNull3;
                                list9 = arrayList6;
                                c00013 = c00013;
                                return obj8;
                            }
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            str36 = str18;
                            episodesResponse4 = episodesResponse3;
                            num6 = num3;
                            r11 = r30;
                            d6 = d4;
                            list10 = arrayList4;
                            str37 = strText;
                            str38 = str17;
                            str39 = strAttr;
                            booleanRef11 = booleanRef10;
                            booleanRef12 = booleanRef9;
                            str40 = str5;
                            r4 = r70;
                            document2 = document4;
                            text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                            num5 = num4;
                            r63 = r4;
                            list6 = list4;
                            r62 = r11;
                            list8 = list10;
                            d5 = d6;
                            str34 = str38;
                            str35 = str39;
                            str33 = str37;
                            str5 = str40;
                            list7 = list9;
                            str32 = str4;
                            i7 = i6;
                        } else {
                            r63 = r70;
                            num5 = num4;
                            str32 = str4;
                            list6 = list4;
                            str33 = strText;
                            str34 = str17;
                            str35 = strAttr;
                            str36 = str18;
                            episodesResponse4 = episodesResponse3;
                            num6 = num3;
                            r62 = r30;
                            d5 = d4;
                            document2 = document2;
                            booleanRef11 = booleanRef10;
                            list7 = arrayList6;
                            i7 = i6;
                            booleanRef12 = booleanRef9;
                            text = null;
                        }
                    }
                    if (text != null) {
                        r1 = intOrNull3;
                        list8 = arrayList4;
                        animeData = AniDbUtilsKt.parseAnimeData(text);
                    } else {
                        r1 = intOrNull3;
                        list8 = arrayList4;
                        animeData = null;
                    }
                    metaAnimeData = animeData;
                    if (metaAnimeData == null) {
                        str48 = text;
                    } else {
                        str48 = text;
                    }
                    if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                        i12 = 1;
                    } else {
                        i12 = 0;
                    }
                    list18 = list5;
                    i13 = 0;
                    i14 = 0;
                    while (r14.hasNext()) {
                        int i117 = i14 + 1;
                        if (i14 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        episodeItem2 = (EpisodeItem) obj11;
                        List<EpisodeItem> list2112 = list18;
                        i16 = i14 + 1;
                        if (metaAnimeData != null) {
                            str53 = str33;
                            episodes = metaAnimeData.getEpisodes();
                            if (episodes != null) {
                                str32 = str32;
                                metaEpisode = episodes.get(String.valueOf(i16));
                            }
                            if (metaEpisode != null) {
                                metaEpisode2 = metaEpisode;
                                str54 = str30;
                                if (metaEpisode2 != null) {
                                    str55 = null;
                                } else {
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    if (metaEpisode2 != null) {
                                        str58 = str29;
                                        str55 = null;
                                    } else {
                                        str58 = str29;
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        str56 = str58;
                                        str57 = "Episode " + i16;
                                    } else {
                                        str56 = str58;
                                    }
                                } else {
                                    str56 = str29;
                                }
                                str57 = str55;
                            } else {
                                metaEpisode2 = metaEpisode;
                                str54 = str30;
                                if (metaEpisode2 != null) {
                                    str55 = null;
                                } else {
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    if (metaEpisode2 != null) {
                                        str58 = str29;
                                        str55 = null;
                                    } else {
                                        str58 = str29;
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        str56 = str58;
                                        str57 = "Episode " + i16;
                                    } else {
                                        str56 = str58;
                                    }
                                } else {
                                    str56 = str29;
                                }
                                str57 = str55;
                            }
                            if (metaEpisode2 != null) {
                                overview = metaEpisode2.getOverview();
                            } else {
                                overview = null;
                            }
                            if (metaEpisode2 != null) {
                                image = metaEpisode2.getImage();
                            } else {
                                image = null;
                            }
                            if (metaEpisode2 != null) {
                                scoreFrom10 = null;
                            } else {
                                scoreFrom10 = null;
                            }
                            if (metaEpisode2 != null) {
                                runtime = metaEpisode2.getRuntime();
                            } else {
                                runtime = null;
                            }
                            if (metaEpisode2 != null) {
                                airDateUtc = metaEpisode2.getAirDateUtc();
                            } else {
                                airDateUtc = null;
                            }
                            if (i12 != 0) {
                                Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                })));
                            } else {
                                if (booleanRef11.element) {
                                    list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    }));
                                }
                                if (booleanRef12.element) {
                                    list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    }));
                                }
                                Unit unit17 = Unit.INSTANCE;
                            }
                            i14 = i117;
                            list18 = list2112;
                            str33 = str53;
                            str32 = str32;
                            i13 = i13;
                            str29 = str56;
                            str30 = str54;
                        } else {
                            str53 = str33;
                        }
                        metaEpisode = null;
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit18 = Unit.INSTANCE;
                        }
                        i14 = i117;
                        list18 = list2112;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    }
                    String str61113 = str33;
                    String str61114 = str32;
                    if (i12 != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    TvType tvType9 = tvType;
                    elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                    if (elementSelectFirst9 != null) {
                        strAttr4 = elementSelectFirst9.attr(str31);
                    } else {
                        strAttr4 = null;
                    }
                    elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                    if (elementSelectFirst10 != null) {
                        strText4 = elementSelectFirst10.text();
                    } else {
                        strText4 = null;
                    }
                    if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                        showStatus = ShowStatus.Completed;
                    } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                        showStatus = ShowStatus.Ongoing;
                    } else {
                        showStatus = null;
                    }
                    it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                    while (true) {
                        document5 = document2;
                        list19 = list8;
                        if (it6.hasNext()) {
                            next2 = it6.next();
                            element3 = (Element) next2;
                            str49 = str5;
                            list20 = list7;
                            booleanRef18 = booleanRef12;
                            booleanRef19 = booleanRef11;
                            str50 = strText4;
                            i15 = 2;
                            z6 = false;
                            str51 = null;
                            if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                z8 = true;
                            } else {
                                z8 = true;
                            }
                            if (z8) {
                                document2 = document5;
                                booleanRef12 = booleanRef18;
                                str5 = str49;
                                booleanRef11 = booleanRef19;
                                strText4 = str50;
                                list7 = list20;
                                list8 = list19;
                            }
                        } else {
                            str49 = str5;
                            list20 = list7;
                            booleanRef18 = booleanRef12;
                            booleanRef19 = booleanRef11;
                            str50 = strText4;
                            i15 = 2;
                            z6 = false;
                            str51 = null;
                            next2 = null;
                        }
                    }
                    element2 = (Element) next2;
                    if (element2 != null) {
                        strText5 = element2.text();
                    } else {
                        strText5 = str51;
                    }
                    str52 = strText5;
                    if (str52 != null) {
                        if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                if (intOrNull5 != null) {
                                    iIntValue = intOrNull5.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                intOrNull4 = Boxing.boxInt(iIntValue * 60);
                            } else {
                                intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                            }
                        } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                        r60 = intOrNull4;
                    } else {
                        r60 = str51;
                    }
                    AniDb aniDb8 = this;
                    if (i12 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    C00025 c000212 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(str61114);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(str61113);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType9);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                    c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                    c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                    c00013.I$0 = i7;
                    c00013.I$1 = i12;
                    c00013.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb8, str61113, str61114, tvType9, false, c000212, c00013, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj8) {
                        return obj8;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                str7 = string;
                str8 = getMainUrl() + "/api/frontend/anime/" + i + "/episodes";
                Companion companion8 = INSTANCE;
                Map<String, String> mapMapOf7 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                c00012.L$0 = str4;
                c00012.L$1 = str5;
                c00012.L$2 = document;
                c00012.L$3 = strText;
                c00012.L$4 = strAttr;
                c00012.L$5 = strText2;
                c00012.L$6 = arrayList2;
                c00012.L$7 = intOrNull;
                str9 = strText2;
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                c00012.L$9 = doubleOrNull;
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(str8);
                c00012.I$0 = i;
                c00012.label = 2;
                objAppGet = companion8.appGet(str8, mapMapOf7, c00012);
                obj3 = obj2;
                if (objAppGet == obj3) {
                    return obj3;
                }
                str10 = str8;
                d = doubleOrNull;
                i2 = i;
                obj4 = objAppGet;
                str11 = str9;
                NiceResponse niceResponse7 = (NiceResponse) obj4;
                ResponseParser parser7 = niceResponse7.getParser();
                Intrinsics.checkNotNull(parser7);
                str13 = str10;
                obj5 = obj3;
                safe = parser7.parseSafe(niceResponse7.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                episodesResponse = (EpisodesResponse) safe;
                if (episodesResponse != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                episodeItem = (EpisodeItem) CollectionsKt.firstOrNull(listEmptyList);
                if (episodeItem != null) {
                    id = episodeItem.getId();
                } else {
                    id = null;
                }
                booleanRef = new Ref.BooleanRef();
                episodesResponse2 = episodesResponse;
                num = id;
                booleanRef.element = true;
                booleanRef2 = new Ref.BooleanRef();
                if (num != null) {
                    int i118 = i2;
                    str19 = getMainUrl() + "/api/frontend/episode/" + num.intValue() + "/languages";
                    Companion companion9 = INSTANCE;
                    Map<String, String> mapMapOf8 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str11;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = intOrNull;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                    c00012.L$9 = d;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str13);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse2);
                    c00012.L$12 = listEmptyList;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num);
                    c00012.L$14 = booleanRef;
                    c00012.L$15 = booleanRef2;
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(str19);
                    str20 = str11;
                    i4 = i118;
                    c00012.I$0 = i4;
                    c00012.label = 3;
                    objAppGet2 = companion9.appGet(str19, mapMapOf8, c00012);
                    obj6 = obj5;
                    if (objAppGet2 == obj6) {
                        return obj6;
                    }
                    str21 = str7;
                    document3 = document;
                    str22 = str5;
                    str23 = strText;
                    booleanRef5 = booleanRef2;
                    list2 = listEmptyList;
                    booleanRef6 = booleanRef;
                    d3 = d;
                    NiceResponse niceResponse8 = (NiceResponse) objAppGet2;
                    ResponseParser parser8 = niceResponse8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    safe2 = parser8.parseSafe(niceResponse8.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                    languagesResponse = (LanguagesResponse) safe2;
                    if (languagesResponse != null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    if (listEmptyList2.isEmpty()) {
                        list17 = listEmptyList2;
                        if (list17 instanceof Collection) {
                            it4 = list17.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    language2 = (Language) it4.next();
                                    it5 = it4;
                                    i9 = i4;
                                    str45 = str4;
                                    str46 = str6;
                                    list14 = listEmptyList2;
                                    listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    str47 = str19;
                                    code2 = language2.getCode();
                                    if (code2 != null) {
                                        lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    } else {
                                        lowerCase3 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                        listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        name2 = language2.getName();
                                        if (name2 != null) {
                                            lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                        } else {
                                            lowerCase4 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    } else {
                                        str19 = str47;
                                        it4 = it5;
                                        i4 = i9;
                                        listEmptyList2 = list14;
                                        strAttr = strAttr;
                                        str6 = str46;
                                        str4 = str45;
                                    }
                                } else {
                                    i9 = i4;
                                    str45 = str4;
                                    list14 = listEmptyList2;
                                    strAttr = strAttr;
                                    str46 = str6;
                                    z4 = false;
                                }
                            }
                        } else {
                            it4 = list17.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    language2 = (Language) it4.next();
                                    it5 = it4;
                                    i9 = i4;
                                    str45 = str4;
                                    str46 = str6;
                                    list14 = listEmptyList2;
                                    listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    str47 = str19;
                                    code2 = language2.getCode();
                                    if (code2 != null) {
                                        lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    } else {
                                        lowerCase3 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                        listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        name2 = language2.getName();
                                        if (name2 != null) {
                                            lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                        } else {
                                            lowerCase4 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    } else {
                                        str19 = str47;
                                        it4 = it5;
                                        i4 = i9;
                                        listEmptyList2 = list14;
                                        strAttr = strAttr;
                                        str6 = str46;
                                        str4 = str45;
                                    }
                                } else {
                                    i9 = i4;
                                    str45 = str4;
                                    list14 = listEmptyList2;
                                    strAttr = strAttr;
                                    str46 = str6;
                                    z4 = false;
                                }
                            }
                        }
                        if (z4) {
                            z = false;
                        }
                        booleanRef6.element = z;
                        list15 = list14;
                        i10 = 0;
                        if (list15 instanceof Collection) {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        } else {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        }
                        booleanRef5.element = z2;
                        booleanRef3 = booleanRef5;
                        num2 = intOrNull;
                        str16 = str21;
                        strText = str23;
                        document2 = document3;
                        str5 = str22;
                        booleanRef4 = booleanRef17;
                        i3 = i9;
                        str4 = str45;
                        strAttr = strAttr;
                        list = list2;
                        d2 = d3;
                        episodesResponse3 = episodesResponse2;
                        str17 = str20;
                        num3 = num;
                        str18 = str13;
                    } else {
                        i9 = i4;
                        str45 = str4;
                        list14 = listEmptyList2;
                        strAttr = strAttr;
                        str46 = str6;
                    }
                    z = true;
                    booleanRef6.element = z;
                    list15 = list14;
                    i10 = 0;
                    if (list15 instanceof Collection) {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    } else {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    }
                    booleanRef5.element = z2;
                    booleanRef3 = booleanRef5;
                    num2 = intOrNull;
                    str16 = str21;
                    strText = str23;
                    document2 = document3;
                    str5 = str22;
                    booleanRef4 = booleanRef17;
                    i3 = i9;
                    str4 = str45;
                    strAttr = strAttr;
                    list = list2;
                    d2 = d3;
                    episodesResponse3 = episodesResponse2;
                    str17 = str20;
                    num3 = num;
                    str18 = str13;
                } else {
                    String str61115 = str11;
                    str14 = str59;
                    str15 = str6;
                    obj6 = obj5;
                    d2 = d;
                    num2 = intOrNull;
                    list = listEmptyList;
                    booleanRef3 = booleanRef2;
                    str16 = str7;
                    document2 = document;
                    booleanRef4 = booleanRef;
                    i3 = i2;
                    episodesResponse3 = episodesResponse2;
                    num3 = num;
                    str17 = str61115;
                    str18 = str13;
                }
                obj7 = obj6;
                arrayList3 = new ArrayList();
                str24 = str14;
                arrayList4 = new ArrayList();
                i5 = i3;
                elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                if (elementSelectFirst7 != null) {
                    arrayList5 = arrayList3;
                    str25 = str3;
                    strAttr3 = elementSelectFirst7.attr(str25);
                    if (strAttr3 != null) {
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str27 = null;
                        strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default != null) {
                            list3 = list;
                            str26 = str2;
                            strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                            if (strSubstringBefore$default2 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                            }
                            elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                            if (elementSelectFirst8 == null) {
                                str28 = str25;
                            } else {
                                str28 = str25;
                            }
                            r1 = str27;
                            if (r1 != 0) {
                                Requests app15 = MainActivityKt.getApp();
                                String str61116 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                c00012.L$0 = str4;
                                c00012.L$1 = str5;
                                c00012.L$2 = document2;
                                c00012.L$3 = strText;
                                c00012.L$4 = strAttr;
                                c00012.L$5 = str17;
                                c00012.L$6 = arrayList2;
                                c00012.L$7 = num2;
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00012.L$9 = d2;
                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                List<EpisodeItem> list2113 = list3;
                                c00012.L$12 = list2113;
                                c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                booleanRef13 = booleanRef8;
                                c00012.L$14 = booleanRef13;
                                List list2114 = arrayList2;
                                c00012.L$15 = booleanRef7;
                                arrayList7 = arrayList5;
                                c00012.L$16 = arrayList7;
                                c00012.L$17 = arrayList4;
                                c00012.L$18 = intOrNull2;
                                c00012.L$19 = r1;
                                c00012.I$0 = i5;
                                c00012.label = 4;
                                d7 = d2;
                                list11 = arrayList4;
                                r71 = r1;
                                booleanRef14 = booleanRef7;
                                i8 = i5;
                                list5 = list2113;
                                num7 = num2;
                                str31 = str28;
                                str29 = str15;
                                str30 = str24;
                                obj9 = intOrNull2;
                                C00011 c000111 = c00012;
                                obj8 = obj7;
                                list12 = list2114;
                                objNewAnimeLoadResponse$default = Requests.get$default(app15, str61116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000111, 4094, (Object) null);
                                c00013 = c000111;
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    r1 = intOrNull3;
                                    return obj8;
                                }
                                r1 = intOrNull3;
                                str41 = str5;
                                str36 = str18;
                                episodesResponse4 = episodesResponse3;
                                num6 = num3;
                                d8 = d7;
                                booleanRef15 = booleanRef13;
                                booleanRef16 = booleanRef14;
                                r5 = r71;
                                str42 = strText;
                                str43 = str17;
                                obj10 = obj9;
                                list13 = arrayList7;
                                str44 = strAttr;
                                text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                num5 = num7;
                                r63 = r5;
                                list6 = list12;
                                r62 = obj10;
                                list7 = list13;
                                booleanRef12 = booleanRef16;
                                booleanRef11 = booleanRef15;
                                d5 = d8;
                                str34 = str43;
                                str35 = str44;
                                str33 = str42;
                                str5 = str41;
                                list8 = list11;
                                str32 = str4;
                                i7 = i8;
                            } else {
                                r70 = r1;
                                c00013 = c00012;
                                list4 = arrayList2;
                                num4 = num2;
                                d4 = d2;
                                arrayList6 = arrayList5;
                                str29 = str15;
                                str30 = str24;
                                booleanRef9 = booleanRef7;
                                booleanRef10 = booleanRef8;
                                list5 = list3;
                                i6 = i5;
                                str31 = str28;
                                r30 = intOrNull2;
                                obj8 = obj7;
                                if (r30 != 0) {
                                    Requests app16 = MainActivityKt.getApp();
                                    String str61117 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                    c00013.L$0 = str4;
                                    c00013.L$1 = str5;
                                    c00013.L$2 = document2;
                                    c00013.L$3 = strText;
                                    c00013.L$4 = strAttr;
                                    c00013.L$5 = str17;
                                    c00013.L$6 = list4;
                                    c00013.L$7 = num4;
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00013.L$9 = d4;
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    c00013.L$12 = list5;
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    c00013.L$14 = booleanRef10;
                                    c00013.L$15 = booleanRef9;
                                    c00013.L$16 = arrayList6;
                                    c00013.L$17 = arrayList4;
                                    c00013.L$18 = r30;
                                    c00013.L$19 = r70;
                                    c00013.I$0 = i6;
                                    document4 = document2;
                                    c00013.label = 5;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app16, str61117, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    list9 = arrayList6;
                                    c00013 = c00013;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r11 = r30;
                                    d6 = d4;
                                    list10 = arrayList4;
                                    str37 = strText;
                                    str38 = str17;
                                    str39 = strAttr;
                                    booleanRef11 = booleanRef10;
                                    booleanRef12 = booleanRef9;
                                    str40 = str5;
                                    r4 = r70;
                                    document2 = document4;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num4;
                                    r63 = r4;
                                    list6 = list4;
                                    r62 = r11;
                                    list8 = list10;
                                    d5 = d6;
                                    str34 = str38;
                                    str35 = str39;
                                    str33 = str37;
                                    str5 = str40;
                                    list7 = list9;
                                    str32 = str4;
                                    i7 = i6;
                                } else {
                                    r63 = r70;
                                    num5 = num4;
                                    str32 = str4;
                                    list6 = list4;
                                    str33 = strText;
                                    str34 = str17;
                                    str35 = strAttr;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r62 = r30;
                                    d5 = d4;
                                    document2 = document2;
                                    booleanRef11 = booleanRef10;
                                    list7 = arrayList6;
                                    i7 = i6;
                                    booleanRef12 = booleanRef9;
                                    text = null;
                                }
                            }
                            if (text != null) {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = AniDbUtilsKt.parseAnimeData(text);
                            } else {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = null;
                            }
                            metaAnimeData = animeData;
                            if (metaAnimeData == null) {
                                str48 = text;
                            } else {
                                str48 = text;
                            }
                            if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                i12 = 1;
                            } else {
                                i12 = 0;
                            }
                            list18 = list5;
                            i13 = 0;
                            i14 = 0;
                            while (r14.hasNext()) {
                                int i119 = i14 + 1;
                                if (i14 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                episodeItem2 = (EpisodeItem) obj11;
                                List<EpisodeItem> list2115 = list18;
                                i16 = i14 + 1;
                                if (metaAnimeData != null) {
                                    str53 = str33;
                                    episodes = metaAnimeData.getEpisodes();
                                    if (episodes != null) {
                                        str32 = str32;
                                        metaEpisode = episodes.get(String.valueOf(i16));
                                    }
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit19 = Unit.INSTANCE;
                                    }
                                    i14 = i119;
                                    list18 = list2115;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                } else {
                                    str53 = str33;
                                }
                                metaEpisode = null;
                                if (metaEpisode != null) {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                } else {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                }
                                if (metaEpisode2 != null) {
                                    overview = metaEpisode2.getOverview();
                                } else {
                                    overview = null;
                                }
                                if (metaEpisode2 != null) {
                                    image = metaEpisode2.getImage();
                                } else {
                                    image = null;
                                }
                                if (metaEpisode2 != null) {
                                    scoreFrom10 = null;
                                } else {
                                    scoreFrom10 = null;
                                }
                                if (metaEpisode2 != null) {
                                    runtime = metaEpisode2.getRuntime();
                                } else {
                                    runtime = null;
                                }
                                if (metaEpisode2 != null) {
                                    airDateUtc = metaEpisode2.getAirDateUtc();
                                } else {
                                    airDateUtc = null;
                                }
                                if (i12 != 0) {
                                    Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    })));
                                } else {
                                    if (booleanRef11.element) {
                                        list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    if (booleanRef12.element) {
                                        list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    Unit unit110 = Unit.INSTANCE;
                                }
                                i14 = i119;
                                list18 = list2115;
                                str33 = str53;
                                str32 = str32;
                                i13 = i13;
                                str29 = str56;
                                str30 = str54;
                            }
                            String str61118 = str33;
                            String str61119 = str32;
                            if (i12 != 0) {
                                tvType = TvType.AnimeMovie;
                            } else {
                                tvType = TvType.Anime;
                            }
                            TvType tvType10 = tvType;
                            elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                            if (elementSelectFirst9 != null) {
                                strAttr4 = elementSelectFirst9.attr(str31);
                            } else {
                                strAttr4 = null;
                            }
                            elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                            if (elementSelectFirst10 != null) {
                                strText4 = elementSelectFirst10.text();
                            } else {
                                strText4 = null;
                            }
                            if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                showStatus = ShowStatus.Completed;
                            } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                showStatus = ShowStatus.Ongoing;
                            } else {
                                showStatus = null;
                            }
                            it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                            while (true) {
                                document5 = document2;
                                list19 = list8;
                                if (it6.hasNext()) {
                                    next2 = it6.next();
                                    element3 = (Element) next2;
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                        z8 = true;
                                    } else {
                                        z8 = true;
                                    }
                                    if (z8) {
                                        document2 = document5;
                                        booleanRef12 = booleanRef18;
                                        str5 = str49;
                                        booleanRef11 = booleanRef19;
                                        strText4 = str50;
                                        list7 = list20;
                                        list8 = list19;
                                    }
                                } else {
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    next2 = null;
                                }
                            }
                            element2 = (Element) next2;
                            if (element2 != null) {
                                strText5 = element2.text();
                            } else {
                                strText5 = str51;
                            }
                            str52 = strText5;
                            if (str52 != null) {
                                if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                    if (intOrNull5 != null) {
                                        iIntValue = intOrNull5.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                    intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                } else {
                                    intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                }
                                r60 = intOrNull4;
                            } else {
                                r60 = str51;
                            }
                            AniDb aniDb9 = this;
                            if (i12 != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            C00025 c000213 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(str61119);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(str61118);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType10);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                            c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                            c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                            c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                            c00013.I$0 = i7;
                            c00013.I$1 = i12;
                            c00013.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb9, str61118, str61119, tvType10, false, c000213, c00013, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                return obj8;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        list3 = list;
                        str26 = str2;
                    } else {
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str26 = str2;
                        str27 = null;
                    }
                } else {
                    arrayList5 = arrayList3;
                    list3 = list;
                    booleanRef7 = booleanRef3;
                    booleanRef8 = booleanRef4;
                    str25 = str3;
                    str26 = str2;
                    str27 = null;
                }
                intOrNull2 = str27;
                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                if (elementSelectFirst8 == null) {
                    str28 = str25;
                } else {
                    str28 = str25;
                }
                r1 = str27;
                if (r1 != 0) {
                    Requests app17 = MainActivityKt.getApp();
                    String str611110 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document2;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str17;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = num2;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00012.L$9 = d2;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                    List<EpisodeItem> list2116 = list3;
                    c00012.L$12 = list2116;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                    booleanRef13 = booleanRef8;
                    c00012.L$14 = booleanRef13;
                    List list2117 = arrayList2;
                    c00012.L$15 = booleanRef7;
                    arrayList7 = arrayList5;
                    c00012.L$16 = arrayList7;
                    c00012.L$17 = arrayList4;
                    c00012.L$18 = intOrNull2;
                    c00012.L$19 = r1;
                    c00012.I$0 = i5;
                    c00012.label = 4;
                    d7 = d2;
                    list11 = arrayList4;
                    r71 = r1;
                    booleanRef14 = booleanRef7;
                    i8 = i5;
                    list5 = list2116;
                    num7 = num2;
                    str31 = str28;
                    str29 = str15;
                    str30 = str24;
                    obj9 = intOrNull2;
                    C00011 c000112 = c00012;
                    obj8 = obj7;
                    list12 = list2117;
                    objNewAnimeLoadResponse$default = Requests.get$default(app17, str611110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000112, 4094, (Object) null);
                    c00013 = c000112;
                    if (objNewAnimeLoadResponse$default == obj8) {
                        r1 = intOrNull3;
                        return obj8;
                    }
                    r1 = intOrNull3;
                    str41 = str5;
                    str36 = str18;
                    episodesResponse4 = episodesResponse3;
                    num6 = num3;
                    d8 = d7;
                    booleanRef15 = booleanRef13;
                    booleanRef16 = booleanRef14;
                    r5 = r71;
                    str42 = strText;
                    str43 = str17;
                    obj10 = obj9;
                    list13 = arrayList7;
                    str44 = strAttr;
                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                    num5 = num7;
                    r63 = r5;
                    list6 = list12;
                    r62 = obj10;
                    list7 = list13;
                    booleanRef12 = booleanRef16;
                    booleanRef11 = booleanRef15;
                    d5 = d8;
                    str34 = str43;
                    str35 = str44;
                    str33 = str42;
                    str5 = str41;
                    list8 = list11;
                    str32 = str4;
                    i7 = i8;
                } else {
                    r70 = r1;
                    c00013 = c00012;
                    list4 = arrayList2;
                    num4 = num2;
                    d4 = d2;
                    arrayList6 = arrayList5;
                    str29 = str15;
                    str30 = str24;
                    booleanRef9 = booleanRef7;
                    booleanRef10 = booleanRef8;
                    list5 = list3;
                    i6 = i5;
                    str31 = str28;
                    r30 = intOrNull2;
                    obj8 = obj7;
                    if (r30 != 0) {
                        Requests app18 = MainActivityKt.getApp();
                        String str611111 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                        c00013.L$0 = str4;
                        c00013.L$1 = str5;
                        c00013.L$2 = document2;
                        c00013.L$3 = strText;
                        c00013.L$4 = strAttr;
                        c00013.L$5 = str17;
                        c00013.L$6 = list4;
                        c00013.L$7 = num4;
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00013.L$9 = d4;
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        c00013.L$12 = list5;
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        c00013.L$14 = booleanRef10;
                        c00013.L$15 = booleanRef9;
                        c00013.L$16 = arrayList6;
                        c00013.L$17 = arrayList4;
                        c00013.L$18 = r30;
                        c00013.L$19 = r70;
                        c00013.I$0 = i6;
                        document4 = document2;
                        c00013.label = 5;
                        objNewAnimeLoadResponse$default = Requests.get$default(app18, str611111, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        list9 = arrayList6;
                        c00013 = c00013;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r11 = r30;
                        d6 = d4;
                        list10 = arrayList4;
                        str37 = strText;
                        str38 = str17;
                        str39 = strAttr;
                        booleanRef11 = booleanRef10;
                        booleanRef12 = booleanRef9;
                        str40 = str5;
                        r4 = r70;
                        document2 = document4;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num4;
                        r63 = r4;
                        list6 = list4;
                        r62 = r11;
                        list8 = list10;
                        d5 = d6;
                        str34 = str38;
                        str35 = str39;
                        str33 = str37;
                        str5 = str40;
                        list7 = list9;
                        str32 = str4;
                        i7 = i6;
                    } else {
                        r63 = r70;
                        num5 = num4;
                        str32 = str4;
                        list6 = list4;
                        str33 = strText;
                        str34 = str17;
                        str35 = strAttr;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r62 = r30;
                        d5 = d4;
                        document2 = document2;
                        booleanRef11 = booleanRef10;
                        list7 = arrayList6;
                        i7 = i6;
                        booleanRef12 = booleanRef9;
                        text = null;
                    }
                }
                if (text != null) {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = AniDbUtilsKt.parseAnimeData(text);
                } else {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = null;
                }
                metaAnimeData = animeData;
                if (metaAnimeData == null) {
                    str48 = text;
                } else {
                    str48 = text;
                }
                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                list18 = list5;
                i13 = 0;
                i14 = 0;
                while (r14.hasNext()) {
                    int i1110 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    episodeItem2 = (EpisodeItem) obj11;
                    List<EpisodeItem> list2118 = list18;
                    i16 = i14 + 1;
                    if (metaAnimeData != null) {
                        str53 = str33;
                        episodes = metaAnimeData.getEpisodes();
                        if (episodes != null) {
                            str32 = str32;
                            metaEpisode = episodes.get(String.valueOf(i16));
                        }
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit111 = Unit.INSTANCE;
                        }
                        i14 = i1110;
                        list18 = list2118;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    } else {
                        str53 = str33;
                    }
                    metaEpisode = null;
                    if (metaEpisode != null) {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    } else {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    }
                    if (metaEpisode2 != null) {
                        overview = metaEpisode2.getOverview();
                    } else {
                        overview = null;
                    }
                    if (metaEpisode2 != null) {
                        image = metaEpisode2.getImage();
                    } else {
                        image = null;
                    }
                    if (metaEpisode2 != null) {
                        scoreFrom10 = null;
                    } else {
                        scoreFrom10 = null;
                    }
                    if (metaEpisode2 != null) {
                        runtime = metaEpisode2.getRuntime();
                    } else {
                        runtime = null;
                    }
                    if (metaEpisode2 != null) {
                        airDateUtc = metaEpisode2.getAirDateUtc();
                    } else {
                        airDateUtc = null;
                    }
                    if (i12 != 0) {
                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj12) {
                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                            }
                        })));
                    } else {
                        if (booleanRef11.element) {
                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        if (booleanRef12.element) {
                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        Unit unit112 = Unit.INSTANCE;
                    }
                    i14 = i1110;
                    list18 = list2118;
                    str33 = str53;
                    str32 = str32;
                    i13 = i13;
                    str29 = str56;
                    str30 = str54;
                }
                String str611112 = str33;
                String str611113 = str32;
                if (i12 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType11 = tvType;
                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                if (elementSelectFirst9 != null) {
                    strAttr4 = elementSelectFirst9.attr(str31);
                } else {
                    strAttr4 = null;
                }
                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                if (elementSelectFirst10 != null) {
                    strText4 = elementSelectFirst10.text();
                } else {
                    strText4 = null;
                }
                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                    showStatus = ShowStatus.Completed;
                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                    showStatus = ShowStatus.Ongoing;
                } else {
                    showStatus = null;
                }
                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                while (true) {
                    document5 = document2;
                    list19 = list8;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                        element3 = (Element) next2;
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            document2 = document5;
                            booleanRef12 = booleanRef18;
                            str5 = str49;
                            booleanRef11 = booleanRef19;
                            strText4 = str50;
                            list7 = list20;
                            list8 = list19;
                        }
                    } else {
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        next2 = null;
                    }
                }
                element2 = (Element) next2;
                if (element2 != null) {
                    strText5 = element2.text();
                } else {
                    strText5 = str51;
                }
                str52 = strText5;
                if (str52 != null) {
                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                        if (intOrNull5 != null) {
                            iIntValue = intOrNull5.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                    } else {
                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                    }
                    r60 = intOrNull4;
                } else {
                    r60 = str51;
                }
                AniDb aniDb10 = this;
                if (i12 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                C00025 c000214 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str611113);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str611112);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType11);
                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                c00013.I$0 = i7;
                c00013.I$1 = i12;
                c00013.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb10, str611112, str611113, tvType11, false, c000214, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 2:
                int i20 = c00013.I$0;
                String str71 = (String) c00013.L$10;
                Double d9 = (Double) c00013.L$9;
                String str72 = (String) c00013.L$8;
                Integer num8 = (Integer) c00013.L$7;
                List list30 = (List) c00013.L$6;
                String str73 = (String) c00013.L$5;
                String str74 = (String) c00013.L$4;
                String str75 = (String) c00013.L$3;
                Document document6 = (Document) c00013.L$2;
                String str76 = (String) c00013.L$1;
                String str77 = (String) c00013.L$0;
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                str10 = str71;
                c00012 = c00013;
                d = d9;
                strText = str75;
                str6 = "ja";
                obj3 = coroutine_suspended;
                str4 = str77;
                str3 = "href";
                str2 = "/";
                str7 = str72;
                obj4 = objNewAnimeLoadResponse$default;
                obj = obj4;
                i2 = i20;
                arrayList2 = list30;
                str11 = str73;
                strAttr = str74;
                document = document6;
                str5 = str76;
                intOrNull = num8;
                NiceResponse niceResponse9 = (NiceResponse) obj4;
                ResponseParser parser9 = niceResponse9.getParser();
                Intrinsics.checkNotNull(parser9);
                str13 = str10;
                obj5 = obj3;
                safe = parser9.parseSafe(niceResponse9.getText(), Reflection.getOrCreateKotlinClass(EpisodesResponse.class));
                episodesResponse = (EpisodesResponse) safe;
                if (episodesResponse != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                episodeItem = (EpisodeItem) CollectionsKt.firstOrNull(listEmptyList);
                if (episodeItem != null) {
                    id = episodeItem.getId();
                } else {
                    id = null;
                }
                booleanRef = new Ref.BooleanRef();
                episodesResponse2 = episodesResponse;
                num = id;
                booleanRef.element = true;
                booleanRef2 = new Ref.BooleanRef();
                if (num != null) {
                    int i1111 = i2;
                    str19 = getMainUrl() + "/api/frontend/episode/" + num.intValue() + "/languages";
                    Companion companion10 = INSTANCE;
                    Map<String, String> mapMapOf9 = MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest"));
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str11;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = intOrNull;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str7);
                    c00012.L$9 = d;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str13);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse2);
                    c00012.L$12 = listEmptyList;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num);
                    c00012.L$14 = booleanRef;
                    c00012.L$15 = booleanRef2;
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(str19);
                    str20 = str11;
                    i4 = i1111;
                    c00012.I$0 = i4;
                    c00012.label = 3;
                    objAppGet2 = companion10.appGet(str19, mapMapOf9, c00012);
                    obj6 = obj5;
                    if (objAppGet2 == obj6) {
                        return obj6;
                    }
                    str21 = str7;
                    document3 = document;
                    str22 = str5;
                    str23 = strText;
                    booleanRef5 = booleanRef2;
                    list2 = listEmptyList;
                    booleanRef6 = booleanRef;
                    d3 = d;
                    NiceResponse niceResponse10 = (NiceResponse) objAppGet2;
                    ResponseParser parser10 = niceResponse10.getParser();
                    Intrinsics.checkNotNull(parser10);
                    safe2 = parser10.parseSafe(niceResponse10.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                    languagesResponse = (LanguagesResponse) safe2;
                    if (languagesResponse != null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        listEmptyList2 = CollectionsKt.emptyList();
                    }
                    if (listEmptyList2.isEmpty()) {
                        list17 = listEmptyList2;
                        if (list17 instanceof Collection) {
                            it4 = list17.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    language2 = (Language) it4.next();
                                    it5 = it4;
                                    i9 = i4;
                                    str45 = str4;
                                    str46 = str6;
                                    list14 = listEmptyList2;
                                    listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    str47 = str19;
                                    code2 = language2.getCode();
                                    if (code2 != null) {
                                        lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    } else {
                                        lowerCase3 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                        listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        name2 = language2.getName();
                                        if (name2 != null) {
                                            lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                        } else {
                                            lowerCase4 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    } else {
                                        str19 = str47;
                                        it4 = it5;
                                        i4 = i9;
                                        listEmptyList2 = list14;
                                        strAttr = strAttr;
                                        str6 = str46;
                                        str4 = str45;
                                    }
                                } else {
                                    i9 = i4;
                                    str45 = str4;
                                    list14 = listEmptyList2;
                                    strAttr = strAttr;
                                    str46 = str6;
                                    z4 = false;
                                }
                            }
                        } else {
                            it4 = list17.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    language2 = (Language) it4.next();
                                    it5 = it4;
                                    i9 = i4;
                                    str45 = str4;
                                    str46 = str6;
                                    list14 = listEmptyList2;
                                    listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    str47 = str19;
                                    code2 = language2.getCode();
                                    if (code2 != null) {
                                        lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    } else {
                                        lowerCase3 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                        listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                        name2 = language2.getName();
                                        if (name2 != null) {
                                            lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                        } else {
                                            lowerCase4 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        z4 = true;
                                    } else {
                                        str19 = str47;
                                        it4 = it5;
                                        i4 = i9;
                                        listEmptyList2 = list14;
                                        strAttr = strAttr;
                                        str6 = str46;
                                        str4 = str45;
                                    }
                                } else {
                                    i9 = i4;
                                    str45 = str4;
                                    list14 = listEmptyList2;
                                    strAttr = strAttr;
                                    str46 = str6;
                                    z4 = false;
                                }
                            }
                        }
                        if (z4) {
                            z = false;
                        }
                        booleanRef6.element = z;
                        list15 = list14;
                        i10 = 0;
                        if (list15 instanceof Collection) {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        } else {
                            it3 = list15.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    language = (Language) it3.next();
                                    list16 = list15;
                                    i11 = i10;
                                    str14 = str59;
                                    booleanRef17 = booleanRef6;
                                    listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    str15 = str46;
                                    code = language.getCode();
                                    if (code != null) {
                                        lowerCase = code.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                    } else {
                                        lowerCase = null;
                                    }
                                    if (CollectionsKt.contains(listListOf, lowerCase)) {
                                        listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                        name = language.getName();
                                        if (name != null) {
                                            lowerCase2 = name.toLowerCase(Locale.ROOT);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                        } else {
                                            lowerCase2 = null;
                                        }
                                        if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        z2 = true;
                                    } else {
                                        str46 = str15;
                                        list15 = list16;
                                        booleanRef6 = booleanRef17;
                                        it3 = it3;
                                        str59 = str14;
                                        i10 = i11;
                                    }
                                } else {
                                    booleanRef17 = booleanRef6;
                                    str14 = str59;
                                    str15 = str46;
                                    z2 = false;
                                }
                            }
                        }
                        booleanRef5.element = z2;
                        booleanRef3 = booleanRef5;
                        num2 = intOrNull;
                        str16 = str21;
                        strText = str23;
                        document2 = document3;
                        str5 = str22;
                        booleanRef4 = booleanRef17;
                        i3 = i9;
                        str4 = str45;
                        strAttr = strAttr;
                        list = list2;
                        d2 = d3;
                        episodesResponse3 = episodesResponse2;
                        str17 = str20;
                        num3 = num;
                        str18 = str13;
                    } else {
                        i9 = i4;
                        str45 = str4;
                        list14 = listEmptyList2;
                        strAttr = strAttr;
                        str46 = str6;
                    }
                    z = true;
                    booleanRef6.element = z;
                    list15 = list14;
                    i10 = 0;
                    if (list15 instanceof Collection) {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    } else {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    }
                    booleanRef5.element = z2;
                    booleanRef3 = booleanRef5;
                    num2 = intOrNull;
                    str16 = str21;
                    strText = str23;
                    document2 = document3;
                    str5 = str22;
                    booleanRef4 = booleanRef17;
                    i3 = i9;
                    str4 = str45;
                    strAttr = strAttr;
                    list = list2;
                    d2 = d3;
                    episodesResponse3 = episodesResponse2;
                    str17 = str20;
                    num3 = num;
                    str18 = str13;
                } else {
                    String str611114 = str11;
                    str14 = str59;
                    str15 = str6;
                    obj6 = obj5;
                    d2 = d;
                    num2 = intOrNull;
                    list = listEmptyList;
                    booleanRef3 = booleanRef2;
                    str16 = str7;
                    document2 = document;
                    booleanRef4 = booleanRef;
                    i3 = i2;
                    episodesResponse3 = episodesResponse2;
                    num3 = num;
                    str17 = str611114;
                    str18 = str13;
                }
                obj7 = obj6;
                arrayList3 = new ArrayList();
                str24 = str14;
                arrayList4 = new ArrayList();
                i5 = i3;
                elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                if (elementSelectFirst7 != null) {
                    arrayList5 = arrayList3;
                    str25 = str3;
                    strAttr3 = elementSelectFirst7.attr(str25);
                    if (strAttr3 != null) {
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str27 = null;
                        strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default != null) {
                            list3 = list;
                            str26 = str2;
                            strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                            if (strSubstringBefore$default2 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                            }
                            elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                            if (elementSelectFirst8 == null) {
                                str28 = str25;
                            } else {
                                str28 = str25;
                            }
                            r1 = str27;
                            if (r1 != 0) {
                                Requests app19 = MainActivityKt.getApp();
                                String str611115 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                c00012.L$0 = str4;
                                c00012.L$1 = str5;
                                c00012.L$2 = document2;
                                c00012.L$3 = strText;
                                c00012.L$4 = strAttr;
                                c00012.L$5 = str17;
                                c00012.L$6 = arrayList2;
                                c00012.L$7 = num2;
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00012.L$9 = d2;
                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                List<EpisodeItem> list2119 = list3;
                                c00012.L$12 = list2119;
                                c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                booleanRef13 = booleanRef8;
                                c00012.L$14 = booleanRef13;
                                List list21110 = arrayList2;
                                c00012.L$15 = booleanRef7;
                                arrayList7 = arrayList5;
                                c00012.L$16 = arrayList7;
                                c00012.L$17 = arrayList4;
                                c00012.L$18 = intOrNull2;
                                c00012.L$19 = r1;
                                c00012.I$0 = i5;
                                c00012.label = 4;
                                d7 = d2;
                                list11 = arrayList4;
                                r71 = r1;
                                booleanRef14 = booleanRef7;
                                i8 = i5;
                                list5 = list2119;
                                num7 = num2;
                                str31 = str28;
                                str29 = str15;
                                str30 = str24;
                                obj9 = intOrNull2;
                                C00011 c000113 = c00012;
                                obj8 = obj7;
                                list12 = list21110;
                                objNewAnimeLoadResponse$default = Requests.get$default(app19, str611115, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000113, 4094, (Object) null);
                                c00013 = c000113;
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    r1 = intOrNull3;
                                    return obj8;
                                }
                                r1 = intOrNull3;
                                str41 = str5;
                                str36 = str18;
                                episodesResponse4 = episodesResponse3;
                                num6 = num3;
                                d8 = d7;
                                booleanRef15 = booleanRef13;
                                booleanRef16 = booleanRef14;
                                r5 = r71;
                                str42 = strText;
                                str43 = str17;
                                obj10 = obj9;
                                list13 = arrayList7;
                                str44 = strAttr;
                                text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                num5 = num7;
                                r63 = r5;
                                list6 = list12;
                                r62 = obj10;
                                list7 = list13;
                                booleanRef12 = booleanRef16;
                                booleanRef11 = booleanRef15;
                                d5 = d8;
                                str34 = str43;
                                str35 = str44;
                                str33 = str42;
                                str5 = str41;
                                list8 = list11;
                                str32 = str4;
                                i7 = i8;
                            } else {
                                r70 = r1;
                                c00013 = c00012;
                                list4 = arrayList2;
                                num4 = num2;
                                d4 = d2;
                                arrayList6 = arrayList5;
                                str29 = str15;
                                str30 = str24;
                                booleanRef9 = booleanRef7;
                                booleanRef10 = booleanRef8;
                                list5 = list3;
                                i6 = i5;
                                str31 = str28;
                                r30 = intOrNull2;
                                obj8 = obj7;
                                if (r30 != 0) {
                                    Requests app110 = MainActivityKt.getApp();
                                    String str611116 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                    c00013.L$0 = str4;
                                    c00013.L$1 = str5;
                                    c00013.L$2 = document2;
                                    c00013.L$3 = strText;
                                    c00013.L$4 = strAttr;
                                    c00013.L$5 = str17;
                                    c00013.L$6 = list4;
                                    c00013.L$7 = num4;
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00013.L$9 = d4;
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    c00013.L$12 = list5;
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    c00013.L$14 = booleanRef10;
                                    c00013.L$15 = booleanRef9;
                                    c00013.L$16 = arrayList6;
                                    c00013.L$17 = arrayList4;
                                    c00013.L$18 = r30;
                                    c00013.L$19 = r70;
                                    c00013.I$0 = i6;
                                    document4 = document2;
                                    c00013.label = 5;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app110, str611116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    list9 = arrayList6;
                                    c00013 = c00013;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r11 = r30;
                                    d6 = d4;
                                    list10 = arrayList4;
                                    str37 = strText;
                                    str38 = str17;
                                    str39 = strAttr;
                                    booleanRef11 = booleanRef10;
                                    booleanRef12 = booleanRef9;
                                    str40 = str5;
                                    r4 = r70;
                                    document2 = document4;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num4;
                                    r63 = r4;
                                    list6 = list4;
                                    r62 = r11;
                                    list8 = list10;
                                    d5 = d6;
                                    str34 = str38;
                                    str35 = str39;
                                    str33 = str37;
                                    str5 = str40;
                                    list7 = list9;
                                    str32 = str4;
                                    i7 = i6;
                                } else {
                                    r63 = r70;
                                    num5 = num4;
                                    str32 = str4;
                                    list6 = list4;
                                    str33 = strText;
                                    str34 = str17;
                                    str35 = strAttr;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r62 = r30;
                                    d5 = d4;
                                    document2 = document2;
                                    booleanRef11 = booleanRef10;
                                    list7 = arrayList6;
                                    i7 = i6;
                                    booleanRef12 = booleanRef9;
                                    text = null;
                                }
                            }
                            if (text != null) {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = AniDbUtilsKt.parseAnimeData(text);
                            } else {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = null;
                            }
                            metaAnimeData = animeData;
                            if (metaAnimeData == null) {
                                str48 = text;
                            } else {
                                str48 = text;
                            }
                            if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                i12 = 1;
                            } else {
                                i12 = 0;
                            }
                            list18 = list5;
                            i13 = 0;
                            i14 = 0;
                            while (r14.hasNext()) {
                                int i1112 = i14 + 1;
                                if (i14 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                episodeItem2 = (EpisodeItem) obj11;
                                List<EpisodeItem> list21111 = list18;
                                i16 = i14 + 1;
                                if (metaAnimeData != null) {
                                    str53 = str33;
                                    episodes = metaAnimeData.getEpisodes();
                                    if (episodes != null) {
                                        str32 = str32;
                                        metaEpisode = episodes.get(String.valueOf(i16));
                                    }
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit113 = Unit.INSTANCE;
                                    }
                                    i14 = i1112;
                                    list18 = list21111;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                } else {
                                    str53 = str33;
                                }
                                metaEpisode = null;
                                if (metaEpisode != null) {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                } else {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                }
                                if (metaEpisode2 != null) {
                                    overview = metaEpisode2.getOverview();
                                } else {
                                    overview = null;
                                }
                                if (metaEpisode2 != null) {
                                    image = metaEpisode2.getImage();
                                } else {
                                    image = null;
                                }
                                if (metaEpisode2 != null) {
                                    scoreFrom10 = null;
                                } else {
                                    scoreFrom10 = null;
                                }
                                if (metaEpisode2 != null) {
                                    runtime = metaEpisode2.getRuntime();
                                } else {
                                    runtime = null;
                                }
                                if (metaEpisode2 != null) {
                                    airDateUtc = metaEpisode2.getAirDateUtc();
                                } else {
                                    airDateUtc = null;
                                }
                                if (i12 != 0) {
                                    Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    })));
                                } else {
                                    if (booleanRef11.element) {
                                        list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    if (booleanRef12.element) {
                                        list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    Unit unit114 = Unit.INSTANCE;
                                }
                                i14 = i1112;
                                list18 = list21111;
                                str33 = str53;
                                str32 = str32;
                                i13 = i13;
                                str29 = str56;
                                str30 = str54;
                            }
                            String str611117 = str33;
                            String str611118 = str32;
                            if (i12 != 0) {
                                tvType = TvType.AnimeMovie;
                            } else {
                                tvType = TvType.Anime;
                            }
                            TvType tvType12 = tvType;
                            elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                            if (elementSelectFirst9 != null) {
                                strAttr4 = elementSelectFirst9.attr(str31);
                            } else {
                                strAttr4 = null;
                            }
                            elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                            if (elementSelectFirst10 != null) {
                                strText4 = elementSelectFirst10.text();
                            } else {
                                strText4 = null;
                            }
                            if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                showStatus = ShowStatus.Completed;
                            } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                showStatus = ShowStatus.Ongoing;
                            } else {
                                showStatus = null;
                            }
                            it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                            while (true) {
                                document5 = document2;
                                list19 = list8;
                                if (it6.hasNext()) {
                                    next2 = it6.next();
                                    element3 = (Element) next2;
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                        z8 = true;
                                    } else {
                                        z8 = true;
                                    }
                                    if (z8) {
                                        document2 = document5;
                                        booleanRef12 = booleanRef18;
                                        str5 = str49;
                                        booleanRef11 = booleanRef19;
                                        strText4 = str50;
                                        list7 = list20;
                                        list8 = list19;
                                    }
                                } else {
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    next2 = null;
                                }
                            }
                            element2 = (Element) next2;
                            if (element2 != null) {
                                strText5 = element2.text();
                            } else {
                                strText5 = str51;
                            }
                            str52 = strText5;
                            if (str52 != null) {
                                if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                    if (intOrNull5 != null) {
                                        iIntValue = intOrNull5.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                    intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                } else {
                                    intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                }
                                r60 = intOrNull4;
                            } else {
                                r60 = str51;
                            }
                            AniDb aniDb11 = this;
                            if (i12 != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            C00025 c000215 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(str611118);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(str611117);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType12);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                            c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                            c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                            c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                            c00013.I$0 = i7;
                            c00013.I$1 = i12;
                            c00013.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb11, str611117, str611118, tvType12, false, c000215, c00013, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                return obj8;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        list3 = list;
                        str26 = str2;
                    } else {
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str26 = str2;
                        str27 = null;
                    }
                } else {
                    arrayList5 = arrayList3;
                    list3 = list;
                    booleanRef7 = booleanRef3;
                    booleanRef8 = booleanRef4;
                    str25 = str3;
                    str26 = str2;
                    str27 = null;
                }
                intOrNull2 = str27;
                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                if (elementSelectFirst8 == null) {
                    str28 = str25;
                } else {
                    str28 = str25;
                }
                r1 = str27;
                if (r1 != 0) {
                    Requests app111 = MainActivityKt.getApp();
                    String str611119 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document2;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str17;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = num2;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00012.L$9 = d2;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                    List<EpisodeItem> list21112 = list3;
                    c00012.L$12 = list21112;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                    booleanRef13 = booleanRef8;
                    c00012.L$14 = booleanRef13;
                    List list21113 = arrayList2;
                    c00012.L$15 = booleanRef7;
                    arrayList7 = arrayList5;
                    c00012.L$16 = arrayList7;
                    c00012.L$17 = arrayList4;
                    c00012.L$18 = intOrNull2;
                    c00012.L$19 = r1;
                    c00012.I$0 = i5;
                    c00012.label = 4;
                    d7 = d2;
                    list11 = arrayList4;
                    r71 = r1;
                    booleanRef14 = booleanRef7;
                    i8 = i5;
                    list5 = list21112;
                    num7 = num2;
                    str31 = str28;
                    str29 = str15;
                    str30 = str24;
                    obj9 = intOrNull2;
                    C00011 c000114 = c00012;
                    obj8 = obj7;
                    list12 = list21113;
                    objNewAnimeLoadResponse$default = Requests.get$default(app111, str611119, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000114, 4094, (Object) null);
                    c00013 = c000114;
                    if (objNewAnimeLoadResponse$default == obj8) {
                        r1 = intOrNull3;
                        return obj8;
                    }
                    r1 = intOrNull3;
                    str41 = str5;
                    str36 = str18;
                    episodesResponse4 = episodesResponse3;
                    num6 = num3;
                    d8 = d7;
                    booleanRef15 = booleanRef13;
                    booleanRef16 = booleanRef14;
                    r5 = r71;
                    str42 = strText;
                    str43 = str17;
                    obj10 = obj9;
                    list13 = arrayList7;
                    str44 = strAttr;
                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                    num5 = num7;
                    r63 = r5;
                    list6 = list12;
                    r62 = obj10;
                    list7 = list13;
                    booleanRef12 = booleanRef16;
                    booleanRef11 = booleanRef15;
                    d5 = d8;
                    str34 = str43;
                    str35 = str44;
                    str33 = str42;
                    str5 = str41;
                    list8 = list11;
                    str32 = str4;
                    i7 = i8;
                } else {
                    r70 = r1;
                    c00013 = c00012;
                    list4 = arrayList2;
                    num4 = num2;
                    d4 = d2;
                    arrayList6 = arrayList5;
                    str29 = str15;
                    str30 = str24;
                    booleanRef9 = booleanRef7;
                    booleanRef10 = booleanRef8;
                    list5 = list3;
                    i6 = i5;
                    str31 = str28;
                    r30 = intOrNull2;
                    obj8 = obj7;
                    if (r30 != 0) {
                        Requests app112 = MainActivityKt.getApp();
                        String str6111110 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                        c00013.L$0 = str4;
                        c00013.L$1 = str5;
                        c00013.L$2 = document2;
                        c00013.L$3 = strText;
                        c00013.L$4 = strAttr;
                        c00013.L$5 = str17;
                        c00013.L$6 = list4;
                        c00013.L$7 = num4;
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00013.L$9 = d4;
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        c00013.L$12 = list5;
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        c00013.L$14 = booleanRef10;
                        c00013.L$15 = booleanRef9;
                        c00013.L$16 = arrayList6;
                        c00013.L$17 = arrayList4;
                        c00013.L$18 = r30;
                        c00013.L$19 = r70;
                        c00013.I$0 = i6;
                        document4 = document2;
                        c00013.label = 5;
                        objNewAnimeLoadResponse$default = Requests.get$default(app112, str6111110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        list9 = arrayList6;
                        c00013 = c00013;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r11 = r30;
                        d6 = d4;
                        list10 = arrayList4;
                        str37 = strText;
                        str38 = str17;
                        str39 = strAttr;
                        booleanRef11 = booleanRef10;
                        booleanRef12 = booleanRef9;
                        str40 = str5;
                        r4 = r70;
                        document2 = document4;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num4;
                        r63 = r4;
                        list6 = list4;
                        r62 = r11;
                        list8 = list10;
                        d5 = d6;
                        str34 = str38;
                        str35 = str39;
                        str33 = str37;
                        str5 = str40;
                        list7 = list9;
                        str32 = str4;
                        i7 = i6;
                    } else {
                        r63 = r70;
                        num5 = num4;
                        str32 = str4;
                        list6 = list4;
                        str33 = strText;
                        str34 = str17;
                        str35 = strAttr;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r62 = r30;
                        d5 = d4;
                        document2 = document2;
                        booleanRef11 = booleanRef10;
                        list7 = arrayList6;
                        i7 = i6;
                        booleanRef12 = booleanRef9;
                        text = null;
                    }
                }
                if (text != null) {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = AniDbUtilsKt.parseAnimeData(text);
                } else {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = null;
                }
                metaAnimeData = animeData;
                if (metaAnimeData == null) {
                    str48 = text;
                } else {
                    str48 = text;
                }
                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                list18 = list5;
                i13 = 0;
                i14 = 0;
                while (r14.hasNext()) {
                    int i1113 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    episodeItem2 = (EpisodeItem) obj11;
                    List<EpisodeItem> list21114 = list18;
                    i16 = i14 + 1;
                    if (metaAnimeData != null) {
                        str53 = str33;
                        episodes = metaAnimeData.getEpisodes();
                        if (episodes != null) {
                            str32 = str32;
                            metaEpisode = episodes.get(String.valueOf(i16));
                        }
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit115 = Unit.INSTANCE;
                        }
                        i14 = i1113;
                        list18 = list21114;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    } else {
                        str53 = str33;
                    }
                    metaEpisode = null;
                    if (metaEpisode != null) {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    } else {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    }
                    if (metaEpisode2 != null) {
                        overview = metaEpisode2.getOverview();
                    } else {
                        overview = null;
                    }
                    if (metaEpisode2 != null) {
                        image = metaEpisode2.getImage();
                    } else {
                        image = null;
                    }
                    if (metaEpisode2 != null) {
                        scoreFrom10 = null;
                    } else {
                        scoreFrom10 = null;
                    }
                    if (metaEpisode2 != null) {
                        runtime = metaEpisode2.getRuntime();
                    } else {
                        runtime = null;
                    }
                    if (metaEpisode2 != null) {
                        airDateUtc = metaEpisode2.getAirDateUtc();
                    } else {
                        airDateUtc = null;
                    }
                    if (i12 != 0) {
                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj12) {
                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                            }
                        })));
                    } else {
                        if (booleanRef11.element) {
                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        if (booleanRef12.element) {
                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        Unit unit116 = Unit.INSTANCE;
                    }
                    i14 = i1113;
                    list18 = list21114;
                    str33 = str53;
                    str32 = str32;
                    i13 = i13;
                    str29 = str56;
                    str30 = str54;
                }
                String str6111111 = str33;
                String str6111112 = str32;
                if (i12 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType13 = tvType;
                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                if (elementSelectFirst9 != null) {
                    strAttr4 = elementSelectFirst9.attr(str31);
                } else {
                    strAttr4 = null;
                }
                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                if (elementSelectFirst10 != null) {
                    strText4 = elementSelectFirst10.text();
                } else {
                    strText4 = null;
                }
                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                    showStatus = ShowStatus.Completed;
                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                    showStatus = ShowStatus.Ongoing;
                } else {
                    showStatus = null;
                }
                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                while (true) {
                    document5 = document2;
                    list19 = list8;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                        element3 = (Element) next2;
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            document2 = document5;
                            booleanRef12 = booleanRef18;
                            str5 = str49;
                            booleanRef11 = booleanRef19;
                            strText4 = str50;
                            list7 = list20;
                            list8 = list19;
                        }
                    } else {
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        next2 = null;
                    }
                }
                element2 = (Element) next2;
                if (element2 != null) {
                    strText5 = element2.text();
                } else {
                    strText5 = str51;
                }
                str52 = strText5;
                if (str52 != null) {
                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                        if (intOrNull5 != null) {
                            iIntValue = intOrNull5.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                    } else {
                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                    }
                    r60 = intOrNull4;
                } else {
                    r60 = str51;
                }
                AniDb aniDb12 = this;
                if (i12 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                C00025 c000216 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str6111112);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str6111111);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType13);
                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                c00013.I$0 = i7;
                c00013.I$1 = i12;
                c00013.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb12, str6111111, str6111112, tvType13, false, c000216, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                int i21 = c00013.I$0;
                String str78 = (String) c00013.L$16;
                booleanRef5 = (Ref.BooleanRef) c00013.L$15;
                Ref.BooleanRef booleanRef20 = (Ref.BooleanRef) c00013.L$14;
                Integer num9 = (Integer) c00013.L$13;
                list2 = (List) c00013.L$12;
                EpisodesResponse episodesResponse5 = (EpisodesResponse) c00013.L$11;
                str13 = (String) c00013.L$10;
                d3 = (Double) c00013.L$9;
                str21 = (String) c00013.L$8;
                Integer num10 = (Integer) c00013.L$7;
                List list31 = (List) c00013.L$6;
                str20 = (String) c00013.L$5;
                String str79 = (String) c00013.L$4;
                str23 = (String) c00013.L$3;
                document3 = (Document) c00013.L$2;
                str22 = (String) c00013.L$1;
                String str80 = (String) c00013.L$0;
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                str4 = str80;
                str3 = "href";
                str2 = "/";
                booleanRef6 = booleanRef20;
                objAppGet2 = objNewAnimeLoadResponse$default;
                obj = objAppGet2;
                num = num9;
                i4 = i21;
                episodesResponse2 = episodesResponse5;
                arrayList2 = list31;
                strAttr = str79;
                str19 = str78;
                obj6 = coroutine_suspended;
                str59 = "en";
                c00012 = c00013;
                intOrNull = num10;
                str6 = "ja";
                NiceResponse niceResponse11 = (NiceResponse) objAppGet2;
                ResponseParser parser11 = niceResponse11.getParser();
                Intrinsics.checkNotNull(parser11);
                safe2 = parser11.parseSafe(niceResponse11.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                languagesResponse = (LanguagesResponse) safe2;
                if (languagesResponse != null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                } else {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                if (listEmptyList2.isEmpty()) {
                    list17 = listEmptyList2;
                    if (list17 instanceof Collection) {
                        it4 = list17.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                language2 = (Language) it4.next();
                                it5 = it4;
                                i9 = i4;
                                str45 = str4;
                                str46 = str6;
                                list14 = listEmptyList2;
                                listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                str47 = str19;
                                code2 = language2.getCode();
                                if (code2 != null) {
                                    lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                } else {
                                    lowerCase3 = null;
                                }
                                if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                    listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    name2 = language2.getName();
                                    if (name2 != null) {
                                        lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                    } else {
                                        lowerCase4 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                } else {
                                    z5 = true;
                                }
                                if (z5) {
                                    z4 = true;
                                } else {
                                    str19 = str47;
                                    it4 = it5;
                                    i4 = i9;
                                    listEmptyList2 = list14;
                                    strAttr = strAttr;
                                    str6 = str46;
                                    str4 = str45;
                                }
                            } else {
                                i9 = i4;
                                str45 = str4;
                                list14 = listEmptyList2;
                                strAttr = strAttr;
                                str46 = str6;
                                z4 = false;
                            }
                        }
                    } else {
                        it4 = list17.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                language2 = (Language) it4.next();
                                it5 = it4;
                                i9 = i4;
                                str45 = str4;
                                str46 = str6;
                                list14 = listEmptyList2;
                                listListOf3 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                str47 = str19;
                                code2 = language2.getCode();
                                if (code2 != null) {
                                    lowerCase3 = code2.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                } else {
                                    lowerCase3 = null;
                                }
                                if (CollectionsKt.contains(listListOf3, lowerCase3)) {
                                    listListOf4 = CollectionsKt.listOf(new String[]{"jpn", str46, "japanese"});
                                    name2 = language2.getName();
                                    if (name2 != null) {
                                        lowerCase4 = name2.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                    } else {
                                        lowerCase4 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf4, lowerCase4)) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                } else {
                                    z5 = true;
                                }
                                if (z5) {
                                    z4 = true;
                                } else {
                                    str19 = str47;
                                    it4 = it5;
                                    i4 = i9;
                                    listEmptyList2 = list14;
                                    strAttr = strAttr;
                                    str6 = str46;
                                    str4 = str45;
                                }
                            } else {
                                i9 = i4;
                                str45 = str4;
                                list14 = listEmptyList2;
                                strAttr = strAttr;
                                str46 = str6;
                                z4 = false;
                            }
                        }
                    }
                    if (z4) {
                        z = false;
                    }
                    booleanRef6.element = z;
                    list15 = list14;
                    i10 = 0;
                    if (list15 instanceof Collection) {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    } else {
                        it3 = list15.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                language = (Language) it3.next();
                                list16 = list15;
                                i11 = i10;
                                str14 = str59;
                                booleanRef17 = booleanRef6;
                                listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                str15 = str46;
                                code = language.getCode();
                                if (code != null) {
                                    lowerCase = code.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(listListOf, lowerCase)) {
                                    listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                    name = language.getName();
                                    if (name != null) {
                                        lowerCase2 = name.toLowerCase(Locale.ROOT);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    } else {
                                        lowerCase2 = null;
                                    }
                                    if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                } else {
                                    z3 = true;
                                }
                                if (z3) {
                                    z2 = true;
                                } else {
                                    str46 = str15;
                                    list15 = list16;
                                    booleanRef6 = booleanRef17;
                                    it3 = it3;
                                    str59 = str14;
                                    i10 = i11;
                                }
                            } else {
                                booleanRef17 = booleanRef6;
                                str14 = str59;
                                str15 = str46;
                                z2 = false;
                            }
                        }
                    }
                    booleanRef5.element = z2;
                    booleanRef3 = booleanRef5;
                    num2 = intOrNull;
                    str16 = str21;
                    strText = str23;
                    document2 = document3;
                    str5 = str22;
                    booleanRef4 = booleanRef17;
                    i3 = i9;
                    str4 = str45;
                    strAttr = strAttr;
                    list = list2;
                    d2 = d3;
                    episodesResponse3 = episodesResponse2;
                    str17 = str20;
                    num3 = num;
                    str18 = str13;
                    obj7 = obj6;
                    arrayList3 = new ArrayList();
                    str24 = str14;
                    arrayList4 = new ArrayList();
                    i5 = i3;
                    elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                    if (elementSelectFirst7 != null) {
                        arrayList5 = arrayList3;
                        str25 = str3;
                        strAttr3 = elementSelectFirst7.attr(str25);
                        if (strAttr3 != null) {
                            booleanRef7 = booleanRef3;
                            booleanRef8 = booleanRef4;
                            str27 = null;
                            strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                            if (strSubstringAfter$default != null) {
                                list3 = list;
                                str26 = str2;
                                strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                                if (strSubstringBefore$default2 != null) {
                                    intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                                }
                                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                                if (elementSelectFirst8 == null) {
                                    str28 = str25;
                                } else {
                                    str28 = str25;
                                }
                                r1 = str27;
                                if (r1 != 0) {
                                    Requests app113 = MainActivityKt.getApp();
                                    String str6111113 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                    c00012.L$0 = str4;
                                    c00012.L$1 = str5;
                                    c00012.L$2 = document2;
                                    c00012.L$3 = strText;
                                    c00012.L$4 = strAttr;
                                    c00012.L$5 = str17;
                                    c00012.L$6 = arrayList2;
                                    c00012.L$7 = num2;
                                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00012.L$9 = d2;
                                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    List<EpisodeItem> list21115 = list3;
                                    c00012.L$12 = list21115;
                                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    booleanRef13 = booleanRef8;
                                    c00012.L$14 = booleanRef13;
                                    List list21116 = arrayList2;
                                    c00012.L$15 = booleanRef7;
                                    arrayList7 = arrayList5;
                                    c00012.L$16 = arrayList7;
                                    c00012.L$17 = arrayList4;
                                    c00012.L$18 = intOrNull2;
                                    c00012.L$19 = r1;
                                    c00012.I$0 = i5;
                                    c00012.label = 4;
                                    d7 = d2;
                                    list11 = arrayList4;
                                    r71 = r1;
                                    booleanRef14 = booleanRef7;
                                    i8 = i5;
                                    list5 = list21115;
                                    num7 = num2;
                                    str31 = str28;
                                    str29 = str15;
                                    str30 = str24;
                                    obj9 = intOrNull2;
                                    C00011 c000115 = c00012;
                                    obj8 = obj7;
                                    list12 = list21116;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app113, str6111113, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000115, 4094, (Object) null);
                                    c00013 = c000115;
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    str41 = str5;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    d8 = d7;
                                    booleanRef15 = booleanRef13;
                                    booleanRef16 = booleanRef14;
                                    r5 = r71;
                                    str42 = strText;
                                    str43 = str17;
                                    obj10 = obj9;
                                    list13 = arrayList7;
                                    str44 = strAttr;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num7;
                                    r63 = r5;
                                    list6 = list12;
                                    r62 = obj10;
                                    list7 = list13;
                                    booleanRef12 = booleanRef16;
                                    booleanRef11 = booleanRef15;
                                    d5 = d8;
                                    str34 = str43;
                                    str35 = str44;
                                    str33 = str42;
                                    str5 = str41;
                                    list8 = list11;
                                    str32 = str4;
                                    i7 = i8;
                                } else {
                                    r70 = r1;
                                    c00013 = c00012;
                                    list4 = arrayList2;
                                    num4 = num2;
                                    d4 = d2;
                                    arrayList6 = arrayList5;
                                    str29 = str15;
                                    str30 = str24;
                                    booleanRef9 = booleanRef7;
                                    booleanRef10 = booleanRef8;
                                    list5 = list3;
                                    i6 = i5;
                                    str31 = str28;
                                    r30 = intOrNull2;
                                    obj8 = obj7;
                                    if (r30 != 0) {
                                        Requests app114 = MainActivityKt.getApp();
                                        String str6111114 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                        c00013.L$0 = str4;
                                        c00013.L$1 = str5;
                                        c00013.L$2 = document2;
                                        c00013.L$3 = strText;
                                        c00013.L$4 = strAttr;
                                        c00013.L$5 = str17;
                                        c00013.L$6 = list4;
                                        c00013.L$7 = num4;
                                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                        c00013.L$9 = d4;
                                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                        c00013.L$12 = list5;
                                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                        c00013.L$14 = booleanRef10;
                                        c00013.L$15 = booleanRef9;
                                        c00013.L$16 = arrayList6;
                                        c00013.L$17 = arrayList4;
                                        c00013.L$18 = r30;
                                        c00013.L$19 = r70;
                                        c00013.I$0 = i6;
                                        document4 = document2;
                                        c00013.label = 5;
                                        objNewAnimeLoadResponse$default = Requests.get$default(app114, str6111114, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                        if (objNewAnimeLoadResponse$default == obj8) {
                                            r1 = intOrNull3;
                                            list9 = arrayList6;
                                            c00013 = c00013;
                                            return obj8;
                                        }
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        r11 = r30;
                                        d6 = d4;
                                        list10 = arrayList4;
                                        str37 = strText;
                                        str38 = str17;
                                        str39 = strAttr;
                                        booleanRef11 = booleanRef10;
                                        booleanRef12 = booleanRef9;
                                        str40 = str5;
                                        r4 = r70;
                                        document2 = document4;
                                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                        num5 = num4;
                                        r63 = r4;
                                        list6 = list4;
                                        r62 = r11;
                                        list8 = list10;
                                        d5 = d6;
                                        str34 = str38;
                                        str35 = str39;
                                        str33 = str37;
                                        str5 = str40;
                                        list7 = list9;
                                        str32 = str4;
                                        i7 = i6;
                                    } else {
                                        r63 = r70;
                                        num5 = num4;
                                        str32 = str4;
                                        list6 = list4;
                                        str33 = strText;
                                        str34 = str17;
                                        str35 = strAttr;
                                        str36 = str18;
                                        episodesResponse4 = episodesResponse3;
                                        num6 = num3;
                                        r62 = r30;
                                        d5 = d4;
                                        document2 = document2;
                                        booleanRef11 = booleanRef10;
                                        list7 = arrayList6;
                                        i7 = i6;
                                        booleanRef12 = booleanRef9;
                                        text = null;
                                    }
                                }
                                if (text != null) {
                                    r1 = intOrNull3;
                                    list8 = arrayList4;
                                    animeData = AniDbUtilsKt.parseAnimeData(text);
                                } else {
                                    r1 = intOrNull3;
                                    list8 = arrayList4;
                                    animeData = null;
                                }
                                metaAnimeData = animeData;
                                if (metaAnimeData == null) {
                                    str48 = text;
                                } else {
                                    str48 = text;
                                }
                                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                    i12 = 1;
                                } else {
                                    i12 = 0;
                                }
                                list18 = list5;
                                i13 = 0;
                                i14 = 0;
                                while (r14.hasNext()) {
                                    int i1114 = i14 + 1;
                                    if (i14 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    episodeItem2 = (EpisodeItem) obj11;
                                    List<EpisodeItem> list21117 = list18;
                                    i16 = i14 + 1;
                                    if (metaAnimeData != null) {
                                        str53 = str33;
                                        episodes = metaAnimeData.getEpisodes();
                                        if (episodes != null) {
                                            str32 = str32;
                                            metaEpisode = episodes.get(String.valueOf(i16));
                                        }
                                        if (metaEpisode != null) {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        } else {
                                            metaEpisode2 = metaEpisode;
                                            str54 = str30;
                                            if (metaEpisode2 != null) {
                                                str55 = null;
                                            } else {
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                if (metaEpisode2 != null) {
                                                    str58 = str29;
                                                    str55 = null;
                                                } else {
                                                    str58 = str29;
                                                    str55 = null;
                                                }
                                                if (str55 == null) {
                                                    str56 = str58;
                                                    str57 = "Episode " + i16;
                                                } else {
                                                    str56 = str58;
                                                }
                                            } else {
                                                str56 = str29;
                                            }
                                            str57 = str55;
                                        }
                                        if (metaEpisode2 != null) {
                                            overview = metaEpisode2.getOverview();
                                        } else {
                                            overview = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            image = metaEpisode2.getImage();
                                        } else {
                                            image = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            scoreFrom10 = null;
                                        } else {
                                            scoreFrom10 = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            runtime = metaEpisode2.getRuntime();
                                        } else {
                                            runtime = null;
                                        }
                                        if (metaEpisode2 != null) {
                                            airDateUtc = metaEpisode2.getAirDateUtc();
                                        } else {
                                            airDateUtc = null;
                                        }
                                        if (i12 != 0) {
                                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            })));
                                        } else {
                                            if (booleanRef11.element) {
                                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            if (booleanRef12.element) {
                                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj12) {
                                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                    }
                                                }));
                                            }
                                            Unit unit117 = Unit.INSTANCE;
                                        }
                                        i14 = i1114;
                                        list18 = list21117;
                                        str33 = str53;
                                        str32 = str32;
                                        i13 = i13;
                                        str29 = str56;
                                        str30 = str54;
                                    } else {
                                        str53 = str33;
                                    }
                                    metaEpisode = null;
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit118 = Unit.INSTANCE;
                                    }
                                    i14 = i1114;
                                    list18 = list21117;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                }
                                String str6111115 = str33;
                                String str6111116 = str32;
                                if (i12 != 0) {
                                    tvType = TvType.AnimeMovie;
                                } else {
                                    tvType = TvType.Anime;
                                }
                                TvType tvType14 = tvType;
                                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                                if (elementSelectFirst9 != null) {
                                    strAttr4 = elementSelectFirst9.attr(str31);
                                } else {
                                    strAttr4 = null;
                                }
                                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                                if (elementSelectFirst10 != null) {
                                    strText4 = elementSelectFirst10.text();
                                } else {
                                    strText4 = null;
                                }
                                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                    showStatus = ShowStatus.Completed;
                                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                    showStatus = ShowStatus.Ongoing;
                                } else {
                                    showStatus = null;
                                }
                                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                                while (true) {
                                    document5 = document2;
                                    list19 = list8;
                                    if (it6.hasNext()) {
                                        next2 = it6.next();
                                        element3 = (Element) next2;
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                            z8 = true;
                                        } else {
                                            z8 = true;
                                        }
                                        if (z8) {
                                            document2 = document5;
                                            booleanRef12 = booleanRef18;
                                            str5 = str49;
                                            booleanRef11 = booleanRef19;
                                            strText4 = str50;
                                            list7 = list20;
                                            list8 = list19;
                                        }
                                    } else {
                                        str49 = str5;
                                        list20 = list7;
                                        booleanRef18 = booleanRef12;
                                        booleanRef19 = booleanRef11;
                                        str50 = strText4;
                                        i15 = 2;
                                        z6 = false;
                                        str51 = null;
                                        next2 = null;
                                    }
                                }
                                element2 = (Element) next2;
                                if (element2 != null) {
                                    strText5 = element2.text();
                                } else {
                                    strText5 = str51;
                                }
                                str52 = strText5;
                                if (str52 != null) {
                                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                            if (intOrNull5 != null) {
                                                iIntValue = intOrNull5.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                        } else {
                                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                        }
                                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                    r60 = intOrNull4;
                                } else {
                                    r60 = str51;
                                }
                                AniDb aniDb13 = this;
                                if (i12 != 0) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                C00025 c000217 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str6111116);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str6111115);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType14);
                                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                                c00013.I$0 = i7;
                                c00013.I$1 = i12;
                                c00013.label = 6;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb13, str6111115, str6111116, tvType14, false, c000217, c00013, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    return obj8;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            list3 = list;
                            str26 = str2;
                        } else {
                            list3 = list;
                            booleanRef7 = booleanRef3;
                            booleanRef8 = booleanRef4;
                            str26 = str2;
                            str27 = null;
                        }
                    } else {
                        arrayList5 = arrayList3;
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str25 = str3;
                        str26 = str2;
                        str27 = null;
                    }
                    intOrNull2 = str27;
                    elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                    if (elementSelectFirst8 == null) {
                        str28 = str25;
                    } else {
                        str28 = str25;
                    }
                    r1 = str27;
                    if (r1 != 0) {
                        Requests app115 = MainActivityKt.getApp();
                        String str6111117 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                        c00012.L$0 = str4;
                        c00012.L$1 = str5;
                        c00012.L$2 = document2;
                        c00012.L$3 = strText;
                        c00012.L$4 = strAttr;
                        c00012.L$5 = str17;
                        c00012.L$6 = arrayList2;
                        c00012.L$7 = num2;
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00012.L$9 = d2;
                        c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        List<EpisodeItem> list21118 = list3;
                        c00012.L$12 = list21118;
                        c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        booleanRef13 = booleanRef8;
                        c00012.L$14 = booleanRef13;
                        List list21119 = arrayList2;
                        c00012.L$15 = booleanRef7;
                        arrayList7 = arrayList5;
                        c00012.L$16 = arrayList7;
                        c00012.L$17 = arrayList4;
                        c00012.L$18 = intOrNull2;
                        c00012.L$19 = r1;
                        c00012.I$0 = i5;
                        c00012.label = 4;
                        d7 = d2;
                        list11 = arrayList4;
                        r71 = r1;
                        booleanRef14 = booleanRef7;
                        i8 = i5;
                        list5 = list21118;
                        num7 = num2;
                        str31 = str28;
                        str29 = str15;
                        str30 = str24;
                        obj9 = intOrNull2;
                        C00011 c000116 = c00012;
                        obj8 = obj7;
                        list12 = list21119;
                        objNewAnimeLoadResponse$default = Requests.get$default(app115, str6111117, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000116, 4094, (Object) null);
                        c00013 = c000116;
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        str41 = str5;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        d8 = d7;
                        booleanRef15 = booleanRef13;
                        booleanRef16 = booleanRef14;
                        r5 = r71;
                        str42 = strText;
                        str43 = str17;
                        obj10 = obj9;
                        list13 = arrayList7;
                        str44 = strAttr;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num7;
                        r63 = r5;
                        list6 = list12;
                        r62 = obj10;
                        list7 = list13;
                        booleanRef12 = booleanRef16;
                        booleanRef11 = booleanRef15;
                        d5 = d8;
                        str34 = str43;
                        str35 = str44;
                        str33 = str42;
                        str5 = str41;
                        list8 = list11;
                        str32 = str4;
                        i7 = i8;
                    } else {
                        r70 = r1;
                        c00013 = c00012;
                        list4 = arrayList2;
                        num4 = num2;
                        d4 = d2;
                        arrayList6 = arrayList5;
                        str29 = str15;
                        str30 = str24;
                        booleanRef9 = booleanRef7;
                        booleanRef10 = booleanRef8;
                        list5 = list3;
                        i6 = i5;
                        str31 = str28;
                        r30 = intOrNull2;
                        obj8 = obj7;
                        if (r30 != 0) {
                            Requests app116 = MainActivityKt.getApp();
                            String str6111118 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                            c00013.L$0 = str4;
                            c00013.L$1 = str5;
                            c00013.L$2 = document2;
                            c00013.L$3 = strText;
                            c00013.L$4 = strAttr;
                            c00013.L$5 = str17;
                            c00013.L$6 = list4;
                            c00013.L$7 = num4;
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = d4;
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                            c00013.L$12 = list5;
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                            c00013.L$14 = booleanRef10;
                            c00013.L$15 = booleanRef9;
                            c00013.L$16 = arrayList6;
                            c00013.L$17 = arrayList4;
                            c00013.L$18 = r30;
                            c00013.L$19 = r70;
                            c00013.I$0 = i6;
                            document4 = document2;
                            c00013.label = 5;
                            objNewAnimeLoadResponse$default = Requests.get$default(app116, str6111118, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                r1 = intOrNull3;
                                list9 = arrayList6;
                                c00013 = c00013;
                                return obj8;
                            }
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            str36 = str18;
                            episodesResponse4 = episodesResponse3;
                            num6 = num3;
                            r11 = r30;
                            d6 = d4;
                            list10 = arrayList4;
                            str37 = strText;
                            str38 = str17;
                            str39 = strAttr;
                            booleanRef11 = booleanRef10;
                            booleanRef12 = booleanRef9;
                            str40 = str5;
                            r4 = r70;
                            document2 = document4;
                            text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                            num5 = num4;
                            r63 = r4;
                            list6 = list4;
                            r62 = r11;
                            list8 = list10;
                            d5 = d6;
                            str34 = str38;
                            str35 = str39;
                            str33 = str37;
                            str5 = str40;
                            list7 = list9;
                            str32 = str4;
                            i7 = i6;
                        } else {
                            r63 = r70;
                            num5 = num4;
                            str32 = str4;
                            list6 = list4;
                            str33 = strText;
                            str34 = str17;
                            str35 = strAttr;
                            str36 = str18;
                            episodesResponse4 = episodesResponse3;
                            num6 = num3;
                            r62 = r30;
                            d5 = d4;
                            document2 = document2;
                            booleanRef11 = booleanRef10;
                            list7 = arrayList6;
                            i7 = i6;
                            booleanRef12 = booleanRef9;
                            text = null;
                        }
                    }
                    if (text != null) {
                        r1 = intOrNull3;
                        list8 = arrayList4;
                        animeData = AniDbUtilsKt.parseAnimeData(text);
                    } else {
                        r1 = intOrNull3;
                        list8 = arrayList4;
                        animeData = null;
                    }
                    metaAnimeData = animeData;
                    if (metaAnimeData == null) {
                        str48 = text;
                    } else {
                        str48 = text;
                    }
                    if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                        i12 = 1;
                    } else {
                        i12 = 0;
                    }
                    list18 = list5;
                    i13 = 0;
                    i14 = 0;
                    while (r14.hasNext()) {
                        int i1115 = i14 + 1;
                        if (i14 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        episodeItem2 = (EpisodeItem) obj11;
                        List<EpisodeItem> list211110 = list18;
                        i16 = i14 + 1;
                        if (metaAnimeData != null) {
                            str53 = str33;
                            episodes = metaAnimeData.getEpisodes();
                            if (episodes != null) {
                                str32 = str32;
                                metaEpisode = episodes.get(String.valueOf(i16));
                            }
                            if (metaEpisode != null) {
                                metaEpisode2 = metaEpisode;
                                str54 = str30;
                                if (metaEpisode2 != null) {
                                    str55 = null;
                                } else {
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    if (metaEpisode2 != null) {
                                        str58 = str29;
                                        str55 = null;
                                    } else {
                                        str58 = str29;
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        str56 = str58;
                                        str57 = "Episode " + i16;
                                    } else {
                                        str56 = str58;
                                    }
                                } else {
                                    str56 = str29;
                                }
                                str57 = str55;
                            } else {
                                metaEpisode2 = metaEpisode;
                                str54 = str30;
                                if (metaEpisode2 != null) {
                                    str55 = null;
                                } else {
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    if (metaEpisode2 != null) {
                                        str58 = str29;
                                        str55 = null;
                                    } else {
                                        str58 = str29;
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        str56 = str58;
                                        str57 = "Episode " + i16;
                                    } else {
                                        str56 = str58;
                                    }
                                } else {
                                    str56 = str29;
                                }
                                str57 = str55;
                            }
                            if (metaEpisode2 != null) {
                                overview = metaEpisode2.getOverview();
                            } else {
                                overview = null;
                            }
                            if (metaEpisode2 != null) {
                                image = metaEpisode2.getImage();
                            } else {
                                image = null;
                            }
                            if (metaEpisode2 != null) {
                                scoreFrom10 = null;
                            } else {
                                scoreFrom10 = null;
                            }
                            if (metaEpisode2 != null) {
                                runtime = metaEpisode2.getRuntime();
                            } else {
                                runtime = null;
                            }
                            if (metaEpisode2 != null) {
                                airDateUtc = metaEpisode2.getAirDateUtc();
                            } else {
                                airDateUtc = null;
                            }
                            if (i12 != 0) {
                                Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                })));
                            } else {
                                if (booleanRef11.element) {
                                    list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    }));
                                }
                                if (booleanRef12.element) {
                                    list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    }));
                                }
                                Unit unit119 = Unit.INSTANCE;
                            }
                            i14 = i1115;
                            list18 = list211110;
                            str33 = str53;
                            str32 = str32;
                            i13 = i13;
                            str29 = str56;
                            str30 = str54;
                        } else {
                            str53 = str33;
                        }
                        metaEpisode = null;
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit1110 = Unit.INSTANCE;
                        }
                        i14 = i1115;
                        list18 = list211110;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    }
                    String str6111119 = str33;
                    String str61111110 = str32;
                    if (i12 != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    TvType tvType15 = tvType;
                    elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                    if (elementSelectFirst9 != null) {
                        strAttr4 = elementSelectFirst9.attr(str31);
                    } else {
                        strAttr4 = null;
                    }
                    elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                    if (elementSelectFirst10 != null) {
                        strText4 = elementSelectFirst10.text();
                    } else {
                        strText4 = null;
                    }
                    if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                        showStatus = ShowStatus.Completed;
                    } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                        showStatus = ShowStatus.Ongoing;
                    } else {
                        showStatus = null;
                    }
                    it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                    while (true) {
                        document5 = document2;
                        list19 = list8;
                        if (it6.hasNext()) {
                            next2 = it6.next();
                            element3 = (Element) next2;
                            str49 = str5;
                            list20 = list7;
                            booleanRef18 = booleanRef12;
                            booleanRef19 = booleanRef11;
                            str50 = strText4;
                            i15 = 2;
                            z6 = false;
                            str51 = null;
                            if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                z8 = true;
                            } else {
                                z8 = true;
                            }
                            if (z8) {
                                document2 = document5;
                                booleanRef12 = booleanRef18;
                                str5 = str49;
                                booleanRef11 = booleanRef19;
                                strText4 = str50;
                                list7 = list20;
                                list8 = list19;
                            }
                        } else {
                            str49 = str5;
                            list20 = list7;
                            booleanRef18 = booleanRef12;
                            booleanRef19 = booleanRef11;
                            str50 = strText4;
                            i15 = 2;
                            z6 = false;
                            str51 = null;
                            next2 = null;
                        }
                    }
                    element2 = (Element) next2;
                    if (element2 != null) {
                        strText5 = element2.text();
                    } else {
                        strText5 = str51;
                    }
                    str52 = strText5;
                    if (str52 != null) {
                        if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                if (intOrNull5 != null) {
                                    iIntValue = intOrNull5.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                intOrNull4 = Boxing.boxInt(iIntValue * 60);
                            } else {
                                intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                            }
                        } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                        r60 = intOrNull4;
                    } else {
                        r60 = str51;
                    }
                    AniDb aniDb14 = this;
                    if (i12 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    C00025 c000218 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(str61111110);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(str6111119);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                    c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                    c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                    c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                    c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                    c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                    c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                    c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                    c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                    c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType15);
                    c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                    c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                    c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                    c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                    c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                    c00013.I$0 = i7;
                    c00013.I$1 = i12;
                    c00013.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb14, str6111119, str61111110, tvType15, false, c000218, c00013, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj8) {
                        return obj8;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                i9 = i4;
                str45 = str4;
                list14 = listEmptyList2;
                strAttr = strAttr;
                str46 = str6;
                z = true;
                booleanRef6.element = z;
                list15 = list14;
                i10 = 0;
                if (list15 instanceof Collection) {
                    it3 = list15.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            language = (Language) it3.next();
                            list16 = list15;
                            i11 = i10;
                            str14 = str59;
                            booleanRef17 = booleanRef6;
                            listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                            str15 = str46;
                            code = language.getCode();
                            if (code != null) {
                                lowerCase = code.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            } else {
                                lowerCase = null;
                            }
                            if (CollectionsKt.contains(listListOf, lowerCase)) {
                                listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                name = language.getName();
                                if (name != null) {
                                    lowerCase2 = name.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                } else {
                                    lowerCase2 = null;
                                }
                                if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                z2 = true;
                            } else {
                                str46 = str15;
                                list15 = list16;
                                booleanRef6 = booleanRef17;
                                it3 = it3;
                                str59 = str14;
                                i10 = i11;
                            }
                        } else {
                            booleanRef17 = booleanRef6;
                            str14 = str59;
                            str15 = str46;
                            z2 = false;
                        }
                    }
                } else {
                    it3 = list15.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            language = (Language) it3.next();
                            list16 = list15;
                            i11 = i10;
                            str14 = str59;
                            booleanRef17 = booleanRef6;
                            listListOf = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                            str15 = str46;
                            code = language.getCode();
                            if (code != null) {
                                lowerCase = code.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            } else {
                                lowerCase = null;
                            }
                            if (CollectionsKt.contains(listListOf, lowerCase)) {
                                listListOf2 = CollectionsKt.listOf(new String[]{"eng", str14, "english"});
                                name = language.getName();
                                if (name != null) {
                                    lowerCase2 = name.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                } else {
                                    lowerCase2 = null;
                                }
                                if (CollectionsKt.contains(listListOf2, lowerCase2)) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                z2 = true;
                            } else {
                                str46 = str15;
                                list15 = list16;
                                booleanRef6 = booleanRef17;
                                it3 = it3;
                                str59 = str14;
                                i10 = i11;
                            }
                        } else {
                            booleanRef17 = booleanRef6;
                            str14 = str59;
                            str15 = str46;
                            z2 = false;
                        }
                    }
                }
                booleanRef5.element = z2;
                booleanRef3 = booleanRef5;
                num2 = intOrNull;
                str16 = str21;
                strText = str23;
                document2 = document3;
                str5 = str22;
                booleanRef4 = booleanRef17;
                i3 = i9;
                str4 = str45;
                strAttr = strAttr;
                list = list2;
                d2 = d3;
                episodesResponse3 = episodesResponse2;
                str17 = str20;
                num3 = num;
                str18 = str13;
                obj7 = obj6;
                arrayList3 = new ArrayList();
                str24 = str14;
                arrayList4 = new ArrayList();
                i5 = i3;
                elementSelectFirst7 = document2.selectFirst("a[href*=myanimelist.net/anime/]");
                if (elementSelectFirst7 != null) {
                    arrayList5 = arrayList3;
                    str25 = str3;
                    strAttr3 = elementSelectFirst7.attr(str25);
                    if (strAttr3 != null) {
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str27 = null;
                        strSubstringAfter$default = StringsKt.substringAfter$default(strAttr3, "anime/", (String) null, 2, (Object) null);
                        if (strSubstringAfter$default != null) {
                            list3 = list;
                            str26 = str2;
                            strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringAfter$default, str26, (String) null, 2, (Object) null);
                            if (strSubstringBefore$default2 != null) {
                                intOrNull2 = StringsKt.toIntOrNull(strSubstringBefore$default2);
                            }
                            elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                            if (elementSelectFirst8 == null) {
                                str28 = str25;
                            } else {
                                str28 = str25;
                            }
                            r1 = str27;
                            if (r1 != 0) {
                                Requests app117 = MainActivityKt.getApp();
                                String str61111111 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                                c00012.L$0 = str4;
                                c00012.L$1 = str5;
                                c00012.L$2 = document2;
                                c00012.L$3 = strText;
                                c00012.L$4 = strAttr;
                                c00012.L$5 = str17;
                                c00012.L$6 = arrayList2;
                                c00012.L$7 = num2;
                                c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                c00012.L$9 = d2;
                                c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                List<EpisodeItem> list211111 = list3;
                                c00012.L$12 = list211111;
                                c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                booleanRef13 = booleanRef8;
                                c00012.L$14 = booleanRef13;
                                List list211112 = arrayList2;
                                c00012.L$15 = booleanRef7;
                                arrayList7 = arrayList5;
                                c00012.L$16 = arrayList7;
                                c00012.L$17 = arrayList4;
                                c00012.L$18 = intOrNull2;
                                c00012.L$19 = r1;
                                c00012.I$0 = i5;
                                c00012.label = 4;
                                d7 = d2;
                                list11 = arrayList4;
                                r71 = r1;
                                booleanRef14 = booleanRef7;
                                i8 = i5;
                                list5 = list211111;
                                num7 = num2;
                                str31 = str28;
                                str29 = str15;
                                str30 = str24;
                                obj9 = intOrNull2;
                                C00011 c000117 = c00012;
                                obj8 = obj7;
                                list12 = list211112;
                                objNewAnimeLoadResponse$default = Requests.get$default(app117, str61111111, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000117, 4094, (Object) null);
                                c00013 = c000117;
                                if (objNewAnimeLoadResponse$default == obj8) {
                                    r1 = intOrNull3;
                                    return obj8;
                                }
                                r1 = intOrNull3;
                                str41 = str5;
                                str36 = str18;
                                episodesResponse4 = episodesResponse3;
                                num6 = num3;
                                d8 = d7;
                                booleanRef15 = booleanRef13;
                                booleanRef16 = booleanRef14;
                                r5 = r71;
                                str42 = strText;
                                str43 = str17;
                                obj10 = obj9;
                                list13 = arrayList7;
                                str44 = strAttr;
                                text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                num5 = num7;
                                r63 = r5;
                                list6 = list12;
                                r62 = obj10;
                                list7 = list13;
                                booleanRef12 = booleanRef16;
                                booleanRef11 = booleanRef15;
                                d5 = d8;
                                str34 = str43;
                                str35 = str44;
                                str33 = str42;
                                str5 = str41;
                                list8 = list11;
                                str32 = str4;
                                i7 = i8;
                            } else {
                                r70 = r1;
                                c00013 = c00012;
                                list4 = arrayList2;
                                num4 = num2;
                                d4 = d2;
                                arrayList6 = arrayList5;
                                str29 = str15;
                                str30 = str24;
                                booleanRef9 = booleanRef7;
                                booleanRef10 = booleanRef8;
                                list5 = list3;
                                i6 = i5;
                                str31 = str28;
                                r30 = intOrNull2;
                                obj8 = obj7;
                                if (r30 != 0) {
                                    Requests app118 = MainActivityKt.getApp();
                                    String str61111112 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                                    c00013.L$0 = str4;
                                    c00013.L$1 = str5;
                                    c00013.L$2 = document2;
                                    c00013.L$3 = strText;
                                    c00013.L$4 = strAttr;
                                    c00013.L$5 = str17;
                                    c00013.L$6 = list4;
                                    c00013.L$7 = num4;
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                                    c00013.L$9 = d4;
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                                    c00013.L$12 = list5;
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                                    c00013.L$14 = booleanRef10;
                                    c00013.L$15 = booleanRef9;
                                    c00013.L$16 = arrayList6;
                                    c00013.L$17 = arrayList4;
                                    c00013.L$18 = r30;
                                    c00013.L$19 = r70;
                                    c00013.I$0 = i6;
                                    document4 = document2;
                                    c00013.label = 5;
                                    objNewAnimeLoadResponse$default = Requests.get$default(app118, str61111112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj8) {
                                        r1 = intOrNull3;
                                        list9 = arrayList6;
                                        c00013 = c00013;
                                        return obj8;
                                    }
                                    r1 = intOrNull3;
                                    list9 = arrayList6;
                                    c00013 = c00013;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r11 = r30;
                                    d6 = d4;
                                    list10 = arrayList4;
                                    str37 = strText;
                                    str38 = str17;
                                    str39 = strAttr;
                                    booleanRef11 = booleanRef10;
                                    booleanRef12 = booleanRef9;
                                    str40 = str5;
                                    r4 = r70;
                                    document2 = document4;
                                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                                    num5 = num4;
                                    r63 = r4;
                                    list6 = list4;
                                    r62 = r11;
                                    list8 = list10;
                                    d5 = d6;
                                    str34 = str38;
                                    str35 = str39;
                                    str33 = str37;
                                    str5 = str40;
                                    list7 = list9;
                                    str32 = str4;
                                    i7 = i6;
                                } else {
                                    r63 = r70;
                                    num5 = num4;
                                    str32 = str4;
                                    list6 = list4;
                                    str33 = strText;
                                    str34 = str17;
                                    str35 = strAttr;
                                    str36 = str18;
                                    episodesResponse4 = episodesResponse3;
                                    num6 = num3;
                                    r62 = r30;
                                    d5 = d4;
                                    document2 = document2;
                                    booleanRef11 = booleanRef10;
                                    list7 = arrayList6;
                                    i7 = i6;
                                    booleanRef12 = booleanRef9;
                                    text = null;
                                }
                            }
                            if (text != null) {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = AniDbUtilsKt.parseAnimeData(text);
                            } else {
                                r1 = intOrNull3;
                                list8 = arrayList4;
                                animeData = null;
                            }
                            metaAnimeData = animeData;
                            if (metaAnimeData == null) {
                                str48 = text;
                            } else {
                                str48 = text;
                            }
                            if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                                i12 = 1;
                            } else {
                                i12 = 0;
                            }
                            list18 = list5;
                            i13 = 0;
                            i14 = 0;
                            while (r14.hasNext()) {
                                int i1116 = i14 + 1;
                                if (i14 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                episodeItem2 = (EpisodeItem) obj11;
                                List<EpisodeItem> list211113 = list18;
                                i16 = i14 + 1;
                                if (metaAnimeData != null) {
                                    str53 = str33;
                                    episodes = metaAnimeData.getEpisodes();
                                    if (episodes != null) {
                                        str32 = str32;
                                        metaEpisode = episodes.get(String.valueOf(i16));
                                    }
                                    if (metaEpisode != null) {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    } else {
                                        metaEpisode2 = metaEpisode;
                                        str54 = str30;
                                        if (metaEpisode2 != null) {
                                            str55 = null;
                                        } else {
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            if (metaEpisode2 != null) {
                                                str58 = str29;
                                                str55 = null;
                                            } else {
                                                str58 = str29;
                                                str55 = null;
                                            }
                                            if (str55 == null) {
                                                str56 = str58;
                                                str57 = "Episode " + i16;
                                            } else {
                                                str56 = str58;
                                            }
                                        } else {
                                            str56 = str29;
                                        }
                                        str57 = str55;
                                    }
                                    if (metaEpisode2 != null) {
                                        overview = metaEpisode2.getOverview();
                                    } else {
                                        overview = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        image = metaEpisode2.getImage();
                                    } else {
                                        image = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        scoreFrom10 = null;
                                    } else {
                                        scoreFrom10 = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        runtime = metaEpisode2.getRuntime();
                                    } else {
                                        runtime = null;
                                    }
                                    if (metaEpisode2 != null) {
                                        airDateUtc = metaEpisode2.getAirDateUtc();
                                    } else {
                                        airDateUtc = null;
                                    }
                                    if (i12 != 0) {
                                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        })));
                                    } else {
                                        if (booleanRef11.element) {
                                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        if (booleanRef12.element) {
                                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj12) {
                                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                                }
                                            }));
                                        }
                                        Unit unit1111 = Unit.INSTANCE;
                                    }
                                    i14 = i1116;
                                    list18 = list211113;
                                    str33 = str53;
                                    str32 = str32;
                                    i13 = i13;
                                    str29 = str56;
                                    str30 = str54;
                                } else {
                                    str53 = str33;
                                }
                                metaEpisode = null;
                                if (metaEpisode != null) {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                } else {
                                    metaEpisode2 = metaEpisode;
                                    str54 = str30;
                                    if (metaEpisode2 != null) {
                                        str55 = null;
                                    } else {
                                        str55 = null;
                                    }
                                    if (str55 == null) {
                                        if (metaEpisode2 != null) {
                                            str58 = str29;
                                            str55 = null;
                                        } else {
                                            str58 = str29;
                                            str55 = null;
                                        }
                                        if (str55 == null) {
                                            str56 = str58;
                                            str57 = "Episode " + i16;
                                        } else {
                                            str56 = str58;
                                        }
                                    } else {
                                        str56 = str29;
                                    }
                                    str57 = str55;
                                }
                                if (metaEpisode2 != null) {
                                    overview = metaEpisode2.getOverview();
                                } else {
                                    overview = null;
                                }
                                if (metaEpisode2 != null) {
                                    image = metaEpisode2.getImage();
                                } else {
                                    image = null;
                                }
                                if (metaEpisode2 != null) {
                                    scoreFrom10 = null;
                                } else {
                                    scoreFrom10 = null;
                                }
                                if (metaEpisode2 != null) {
                                    runtime = metaEpisode2.getRuntime();
                                } else {
                                    runtime = null;
                                }
                                if (metaEpisode2 != null) {
                                    airDateUtc = metaEpisode2.getAirDateUtc();
                                } else {
                                    airDateUtc = null;
                                }
                                if (i12 != 0) {
                                    Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj12) {
                                            return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                        }
                                    })));
                                } else {
                                    if (booleanRef11.element) {
                                        list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    if (booleanRef12.element) {
                                        list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj12) {
                                                return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                            }
                                        }));
                                    }
                                    Unit unit1112 = Unit.INSTANCE;
                                }
                                i14 = i1116;
                                list18 = list211113;
                                str33 = str53;
                                str32 = str32;
                                i13 = i13;
                                str29 = str56;
                                str30 = str54;
                            }
                            String str61111113 = str33;
                            String str61111114 = str32;
                            if (i12 != 0) {
                                tvType = TvType.AnimeMovie;
                            } else {
                                tvType = TvType.Anime;
                            }
                            TvType tvType16 = tvType;
                            elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                            if (elementSelectFirst9 != null) {
                                strAttr4 = elementSelectFirst9.attr(str31);
                            } else {
                                strAttr4 = null;
                            }
                            elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                            if (elementSelectFirst10 != null) {
                                strText4 = elementSelectFirst10.text();
                            } else {
                                strText4 = null;
                            }
                            if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                                showStatus = ShowStatus.Completed;
                            } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                                showStatus = ShowStatus.Ongoing;
                            } else {
                                showStatus = null;
                            }
                            it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                            while (true) {
                                document5 = document2;
                                list19 = list8;
                                if (it6.hasNext()) {
                                    next2 = it6.next();
                                    element3 = (Element) next2;
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                                        z8 = true;
                                    } else {
                                        z8 = true;
                                    }
                                    if (z8) {
                                        document2 = document5;
                                        booleanRef12 = booleanRef18;
                                        str5 = str49;
                                        booleanRef11 = booleanRef19;
                                        strText4 = str50;
                                        list7 = list20;
                                        list8 = list19;
                                    }
                                } else {
                                    str49 = str5;
                                    list20 = list7;
                                    booleanRef18 = booleanRef12;
                                    booleanRef19 = booleanRef11;
                                    str50 = strText4;
                                    i15 = 2;
                                    z6 = false;
                                    str51 = null;
                                    next2 = null;
                                }
                            }
                            element2 = (Element) next2;
                            if (element2 != null) {
                                strText5 = element2.text();
                            } else {
                                strText5 = str51;
                            }
                            str52 = strText5;
                            if (str52 != null) {
                                if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                        if (intOrNull5 != null) {
                                            iIntValue = intOrNull5.intValue();
                                        } else {
                                            iIntValue = 0;
                                        }
                                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                    } else {
                                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                    }
                                } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                                    intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                                    if (intOrNull5 != null) {
                                        iIntValue = intOrNull5.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                    intOrNull4 = Boxing.boxInt(iIntValue * 60);
                                } else {
                                    intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                                }
                                r60 = intOrNull4;
                            } else {
                                r60 = str51;
                            }
                            AniDb aniDb15 = this;
                            if (i12 != 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            C00025 c000219 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(str61111114);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(str61111113);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                            c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                            c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                            c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                            c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                            c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                            c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                            c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                            c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                            c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                            c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                            c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                            c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType16);
                            c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                            c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                            c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                            c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                            c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                            c00013.I$0 = i7;
                            c00013.I$1 = i12;
                            c00013.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb15, str61111113, str61111114, tvType16, false, c000219, c00013, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj8) {
                                return obj8;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        list3 = list;
                        str26 = str2;
                    } else {
                        list3 = list;
                        booleanRef7 = booleanRef3;
                        booleanRef8 = booleanRef4;
                        str26 = str2;
                        str27 = null;
                    }
                } else {
                    arrayList5 = arrayList3;
                    list3 = list;
                    booleanRef7 = booleanRef3;
                    booleanRef8 = booleanRef4;
                    str25 = str3;
                    str26 = str2;
                    str27 = null;
                }
                intOrNull2 = str27;
                elementSelectFirst8 = document2.selectFirst("a[href*=anilist.co/anime/]");
                if (elementSelectFirst8 == null) {
                    str28 = str25;
                } else {
                    str28 = str25;
                }
                r1 = str27;
                if (r1 != 0) {
                    Requests app119 = MainActivityKt.getApp();
                    String str61111115 = "https://api.ani.zip/mappings?anilist_id=" + r1.intValue();
                    c00012.L$0 = str4;
                    c00012.L$1 = str5;
                    c00012.L$2 = document2;
                    c00012.L$3 = strText;
                    c00012.L$4 = strAttr;
                    c00012.L$5 = str17;
                    c00012.L$6 = arrayList2;
                    c00012.L$7 = num2;
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                    c00012.L$9 = d2;
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                    List<EpisodeItem> list211114 = list3;
                    c00012.L$12 = list211114;
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                    booleanRef13 = booleanRef8;
                    c00012.L$14 = booleanRef13;
                    List list211115 = arrayList2;
                    c00012.L$15 = booleanRef7;
                    arrayList7 = arrayList5;
                    c00012.L$16 = arrayList7;
                    c00012.L$17 = arrayList4;
                    c00012.L$18 = intOrNull2;
                    c00012.L$19 = r1;
                    c00012.I$0 = i5;
                    c00012.label = 4;
                    d7 = d2;
                    list11 = arrayList4;
                    r71 = r1;
                    booleanRef14 = booleanRef7;
                    i8 = i5;
                    list5 = list211114;
                    num7 = num2;
                    str31 = str28;
                    str29 = str15;
                    str30 = str24;
                    obj9 = intOrNull2;
                    C00011 c000118 = c00012;
                    obj8 = obj7;
                    list12 = list211115;
                    objNewAnimeLoadResponse$default = Requests.get$default(app119, str61111115, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000118, 4094, (Object) null);
                    c00013 = c000118;
                    if (objNewAnimeLoadResponse$default == obj8) {
                        r1 = intOrNull3;
                        return obj8;
                    }
                    r1 = intOrNull3;
                    str41 = str5;
                    str36 = str18;
                    episodesResponse4 = episodesResponse3;
                    num6 = num3;
                    d8 = d7;
                    booleanRef15 = booleanRef13;
                    booleanRef16 = booleanRef14;
                    r5 = r71;
                    str42 = strText;
                    str43 = str17;
                    obj10 = obj9;
                    list13 = arrayList7;
                    str44 = strAttr;
                    text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                    num5 = num7;
                    r63 = r5;
                    list6 = list12;
                    r62 = obj10;
                    list7 = list13;
                    booleanRef12 = booleanRef16;
                    booleanRef11 = booleanRef15;
                    d5 = d8;
                    str34 = str43;
                    str35 = str44;
                    str33 = str42;
                    str5 = str41;
                    list8 = list11;
                    str32 = str4;
                    i7 = i8;
                } else {
                    r70 = r1;
                    c00013 = c00012;
                    list4 = arrayList2;
                    num4 = num2;
                    d4 = d2;
                    arrayList6 = arrayList5;
                    str29 = str15;
                    str30 = str24;
                    booleanRef9 = booleanRef7;
                    booleanRef10 = booleanRef8;
                    list5 = list3;
                    i6 = i5;
                    str31 = str28;
                    r30 = intOrNull2;
                    obj8 = obj7;
                    if (r30 != 0) {
                        Requests app1110 = MainActivityKt.getApp();
                        String str61111116 = "https://api.ani.zip/mappings?mal_id=" + r30.intValue();
                        c00013.L$0 = str4;
                        c00013.L$1 = str5;
                        c00013.L$2 = document2;
                        c00013.L$3 = strText;
                        c00013.L$4 = strAttr;
                        c00013.L$5 = str17;
                        c00013.L$6 = list4;
                        c00013.L$7 = num4;
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                        c00013.L$9 = d4;
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(str18);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse3);
                        c00013.L$12 = list5;
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(num3);
                        c00013.L$14 = booleanRef10;
                        c00013.L$15 = booleanRef9;
                        c00013.L$16 = arrayList6;
                        c00013.L$17 = arrayList4;
                        c00013.L$18 = r30;
                        c00013.L$19 = r70;
                        c00013.I$0 = i6;
                        document4 = document2;
                        c00013.label = 5;
                        objNewAnimeLoadResponse$default = Requests.get$default(app1110, str61111116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj8) {
                            r1 = intOrNull3;
                            list9 = arrayList6;
                            c00013 = c00013;
                            return obj8;
                        }
                        r1 = intOrNull3;
                        list9 = arrayList6;
                        c00013 = c00013;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r11 = r30;
                        d6 = d4;
                        list10 = arrayList4;
                        str37 = strText;
                        str38 = str17;
                        str39 = strAttr;
                        booleanRef11 = booleanRef10;
                        booleanRef12 = booleanRef9;
                        str40 = str5;
                        r4 = r70;
                        document2 = document4;
                        text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                        num5 = num4;
                        r63 = r4;
                        list6 = list4;
                        r62 = r11;
                        list8 = list10;
                        d5 = d6;
                        str34 = str38;
                        str35 = str39;
                        str33 = str37;
                        str5 = str40;
                        list7 = list9;
                        str32 = str4;
                        i7 = i6;
                    } else {
                        r63 = r70;
                        num5 = num4;
                        str32 = str4;
                        list6 = list4;
                        str33 = strText;
                        str34 = str17;
                        str35 = strAttr;
                        str36 = str18;
                        episodesResponse4 = episodesResponse3;
                        num6 = num3;
                        r62 = r30;
                        d5 = d4;
                        document2 = document2;
                        booleanRef11 = booleanRef10;
                        list7 = arrayList6;
                        i7 = i6;
                        booleanRef12 = booleanRef9;
                        text = null;
                    }
                }
                if (text != null) {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = AniDbUtilsKt.parseAnimeData(text);
                } else {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = null;
                }
                metaAnimeData = animeData;
                if (metaAnimeData == null) {
                    str48 = text;
                } else {
                    str48 = text;
                }
                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                list18 = list5;
                i13 = 0;
                i14 = 0;
                while (r14.hasNext()) {
                    int i1117 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    episodeItem2 = (EpisodeItem) obj11;
                    List<EpisodeItem> list211116 = list18;
                    i16 = i14 + 1;
                    if (metaAnimeData != null) {
                        str53 = str33;
                        episodes = metaAnimeData.getEpisodes();
                        if (episodes != null) {
                            str32 = str32;
                            metaEpisode = episodes.get(String.valueOf(i16));
                        }
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit1113 = Unit.INSTANCE;
                        }
                        i14 = i1117;
                        list18 = list211116;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    } else {
                        str53 = str33;
                    }
                    metaEpisode = null;
                    if (metaEpisode != null) {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    } else {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    }
                    if (metaEpisode2 != null) {
                        overview = metaEpisode2.getOverview();
                    } else {
                        overview = null;
                    }
                    if (metaEpisode2 != null) {
                        image = metaEpisode2.getImage();
                    } else {
                        image = null;
                    }
                    if (metaEpisode2 != null) {
                        scoreFrom10 = null;
                    } else {
                        scoreFrom10 = null;
                    }
                    if (metaEpisode2 != null) {
                        runtime = metaEpisode2.getRuntime();
                    } else {
                        runtime = null;
                    }
                    if (metaEpisode2 != null) {
                        airDateUtc = metaEpisode2.getAirDateUtc();
                    } else {
                        airDateUtc = null;
                    }
                    if (i12 != 0) {
                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj12) {
                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                            }
                        })));
                    } else {
                        if (booleanRef11.element) {
                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        if (booleanRef12.element) {
                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        Unit unit1114 = Unit.INSTANCE;
                    }
                    i14 = i1117;
                    list18 = list211116;
                    str33 = str53;
                    str32 = str32;
                    i13 = i13;
                    str29 = str56;
                    str30 = str54;
                }
                String str61111117 = str33;
                String str61111118 = str32;
                if (i12 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType17 = tvType;
                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                if (elementSelectFirst9 != null) {
                    strAttr4 = elementSelectFirst9.attr(str31);
                } else {
                    strAttr4 = null;
                }
                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                if (elementSelectFirst10 != null) {
                    strText4 = elementSelectFirst10.text();
                } else {
                    strText4 = null;
                }
                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                    showStatus = ShowStatus.Completed;
                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                    showStatus = ShowStatus.Ongoing;
                } else {
                    showStatus = null;
                }
                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                while (true) {
                    document5 = document2;
                    list19 = list8;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                        element3 = (Element) next2;
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            document2 = document5;
                            booleanRef12 = booleanRef18;
                            str5 = str49;
                            booleanRef11 = booleanRef19;
                            strText4 = str50;
                            list7 = list20;
                            list8 = list19;
                        }
                    } else {
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        next2 = null;
                    }
                }
                element2 = (Element) next2;
                if (element2 != null) {
                    strText5 = element2.text();
                } else {
                    strText5 = str51;
                }
                str52 = strText5;
                if (str52 != null) {
                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                        if (intOrNull5 != null) {
                            iIntValue = intOrNull5.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                    } else {
                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                    }
                    r60 = intOrNull4;
                } else {
                    r60 = str51;
                }
                AniDb aniDb16 = this;
                if (i12 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                C00025 c0002110 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str61111118);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str61111117);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType17);
                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                c00013.I$0 = i7;
                c00013.I$1 = i12;
                c00013.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb16, str61111117, str61111118, tvType17, false, c0002110, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                int i22 = c00013.I$0;
                Integer num11 = (Integer) c00013.L$19;
                Integer num12 = (Integer) c00013.L$18;
                List list32 = (List) c00013.L$17;
                list13 = (List) c00013.L$16;
                booleanRef16 = (Ref.BooleanRef) c00013.L$15;
                booleanRef15 = (Ref.BooleanRef) c00013.L$14;
                num6 = (Integer) c00013.L$13;
                List<EpisodeItem> list33 = (List) c00013.L$12;
                episodesResponse4 = (EpisodesResponse) c00013.L$11;
                str36 = (String) c00013.L$10;
                d8 = (Double) c00013.L$9;
                str16 = (String) c00013.L$8;
                Integer num13 = (Integer) c00013.L$7;
                List list34 = (List) c00013.L$6;
                str43 = (String) c00013.L$5;
                str44 = (String) c00013.L$4;
                str42 = (String) c00013.L$3;
                Document document7 = (Document) c00013.L$2;
                str41 = (String) c00013.L$1;
                String str81 = (String) c00013.L$0;
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                str4 = str81;
                str31 = "href";
                list11 = list32;
                obj8 = coroutine_suspended;
                str30 = "en";
                str29 = "ja";
                i8 = i22;
                list5 = list33;
                num7 = num13;
                document2 = document7;
                obj10 = num12;
                list12 = list34;
                r5 = num11;
                text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                num5 = num7;
                r63 = r5;
                list6 = list12;
                r62 = obj10;
                list7 = list13;
                booleanRef12 = booleanRef16;
                booleanRef11 = booleanRef15;
                d5 = d8;
                str34 = str43;
                str35 = str44;
                str33 = str42;
                str5 = str41;
                list8 = list11;
                str32 = str4;
                i7 = i8;
                if (text != null) {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = AniDbUtilsKt.parseAnimeData(text);
                } else {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = null;
                }
                metaAnimeData = animeData;
                if (metaAnimeData == null) {
                    str48 = text;
                } else {
                    str48 = text;
                }
                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                list18 = list5;
                i13 = 0;
                i14 = 0;
                while (r14.hasNext()) {
                    int i1118 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    episodeItem2 = (EpisodeItem) obj11;
                    List<EpisodeItem> list211117 = list18;
                    i16 = i14 + 1;
                    if (metaAnimeData != null) {
                        str53 = str33;
                        episodes = metaAnimeData.getEpisodes();
                        if (episodes != null) {
                            str32 = str32;
                            metaEpisode = episodes.get(String.valueOf(i16));
                        }
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit1115 = Unit.INSTANCE;
                        }
                        i14 = i1118;
                        list18 = list211117;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    } else {
                        str53 = str33;
                    }
                    metaEpisode = null;
                    if (metaEpisode != null) {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    } else {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    }
                    if (metaEpisode2 != null) {
                        overview = metaEpisode2.getOverview();
                    } else {
                        overview = null;
                    }
                    if (metaEpisode2 != null) {
                        image = metaEpisode2.getImage();
                    } else {
                        image = null;
                    }
                    if (metaEpisode2 != null) {
                        scoreFrom10 = null;
                    } else {
                        scoreFrom10 = null;
                    }
                    if (metaEpisode2 != null) {
                        runtime = metaEpisode2.getRuntime();
                    } else {
                        runtime = null;
                    }
                    if (metaEpisode2 != null) {
                        airDateUtc = metaEpisode2.getAirDateUtc();
                    } else {
                        airDateUtc = null;
                    }
                    if (i12 != 0) {
                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj12) {
                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                            }
                        })));
                    } else {
                        if (booleanRef11.element) {
                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        if (booleanRef12.element) {
                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        Unit unit1116 = Unit.INSTANCE;
                    }
                    i14 = i1118;
                    list18 = list211117;
                    str33 = str53;
                    str32 = str32;
                    i13 = i13;
                    str29 = str56;
                    str30 = str54;
                }
                String str61111119 = str33;
                String str611111110 = str32;
                if (i12 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType18 = tvType;
                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                if (elementSelectFirst9 != null) {
                    strAttr4 = elementSelectFirst9.attr(str31);
                } else {
                    strAttr4 = null;
                }
                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                if (elementSelectFirst10 != null) {
                    strText4 = elementSelectFirst10.text();
                } else {
                    strText4 = null;
                }
                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                    showStatus = ShowStatus.Completed;
                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                    showStatus = ShowStatus.Ongoing;
                } else {
                    showStatus = null;
                }
                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                while (true) {
                    document5 = document2;
                    list19 = list8;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                        element3 = (Element) next2;
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            document2 = document5;
                            booleanRef12 = booleanRef18;
                            str5 = str49;
                            booleanRef11 = booleanRef19;
                            strText4 = str50;
                            list7 = list20;
                            list8 = list19;
                        }
                    } else {
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        next2 = null;
                    }
                }
                element2 = (Element) next2;
                if (element2 != null) {
                    strText5 = element2.text();
                } else {
                    strText5 = str51;
                }
                str52 = strText5;
                if (str52 != null) {
                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                        if (intOrNull5 != null) {
                            iIntValue = intOrNull5.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                    } else {
                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                    }
                    r60 = intOrNull4;
                } else {
                    r60 = str51;
                }
                AniDb aniDb17 = this;
                if (i12 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                C00025 c0002111 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str611111110);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str61111119);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType18);
                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                c00013.I$0 = i7;
                c00013.I$1 = i12;
                c00013.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb17, str61111119, str611111110, tvType18, false, c0002111, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 5:
                int i23 = c00013.I$0;
                Integer num14 = (Integer) c00013.L$19;
                Integer num15 = (Integer) c00013.L$18;
                list10 = (List) c00013.L$17;
                List list35 = (List) c00013.L$16;
                booleanRef12 = (Ref.BooleanRef) c00013.L$15;
                booleanRef11 = (Ref.BooleanRef) c00013.L$14;
                num6 = (Integer) c00013.L$13;
                List<EpisodeItem> list36 = (List) c00013.L$12;
                episodesResponse4 = (EpisodesResponse) c00013.L$11;
                str36 = (String) c00013.L$10;
                d6 = (Double) c00013.L$9;
                str16 = (String) c00013.L$8;
                Integer num16 = (Integer) c00013.L$7;
                List list37 = (List) c00013.L$6;
                str38 = (String) c00013.L$5;
                str39 = (String) c00013.L$4;
                str37 = (String) c00013.L$3;
                Document document8 = (Document) c00013.L$2;
                str40 = (String) c00013.L$1;
                String str82 = (String) c00013.L$0;
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                str4 = str82;
                str31 = "href";
                list9 = list35;
                obj8 = coroutine_suspended;
                str30 = "en";
                str29 = "ja";
                i6 = i23;
                list5 = list36;
                num4 = num16;
                list4 = list37;
                document2 = document8;
                r4 = num14;
                r11 = num15;
                text = ((NiceResponse) objNewAnimeLoadResponse$default).getText();
                num5 = num4;
                r63 = r4;
                list6 = list4;
                r62 = r11;
                list8 = list10;
                d5 = d6;
                str34 = str38;
                str35 = str39;
                str33 = str37;
                str5 = str40;
                list7 = list9;
                str32 = str4;
                i7 = i6;
                if (text != null) {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = AniDbUtilsKt.parseAnimeData(text);
                } else {
                    r1 = intOrNull3;
                    list8 = arrayList4;
                    animeData = null;
                }
                metaAnimeData = animeData;
                if (metaAnimeData == null) {
                    str48 = text;
                } else {
                    str48 = text;
                }
                if (document2.selectFirst("a[class*=badge-orange][href*=/browse?type=Movie]") != null) {
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                list18 = list5;
                i13 = 0;
                i14 = 0;
                while (r14.hasNext()) {
                    int i1119 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    episodeItem2 = (EpisodeItem) obj11;
                    List<EpisodeItem> list211118 = list18;
                    i16 = i14 + 1;
                    if (metaAnimeData != null) {
                        str53 = str33;
                        episodes = metaAnimeData.getEpisodes();
                        if (episodes != null) {
                            str32 = str32;
                            metaEpisode = episodes.get(String.valueOf(i16));
                        }
                        if (metaEpisode != null) {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        } else {
                            metaEpisode2 = metaEpisode;
                            str54 = str30;
                            if (metaEpisode2 != null) {
                                str55 = null;
                            } else {
                                str55 = null;
                            }
                            if (str55 == null) {
                                if (metaEpisode2 != null) {
                                    str58 = str29;
                                    str55 = null;
                                } else {
                                    str58 = str29;
                                    str55 = null;
                                }
                                if (str55 == null) {
                                    str56 = str58;
                                    str57 = "Episode " + i16;
                                } else {
                                    str56 = str58;
                                }
                            } else {
                                str56 = str29;
                            }
                            str57 = str55;
                        }
                        if (metaEpisode2 != null) {
                            overview = metaEpisode2.getOverview();
                        } else {
                            overview = null;
                        }
                        if (metaEpisode2 != null) {
                            image = metaEpisode2.getImage();
                        } else {
                            image = null;
                        }
                        if (metaEpisode2 != null) {
                            scoreFrom10 = null;
                        } else {
                            scoreFrom10 = null;
                        }
                        if (metaEpisode2 != null) {
                            runtime = metaEpisode2.getRuntime();
                        } else {
                            runtime = null;
                        }
                        if (metaEpisode2 != null) {
                            airDateUtc = metaEpisode2.getAirDateUtc();
                        } else {
                            airDateUtc = null;
                        }
                        if (i12 != 0) {
                            Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            })));
                        } else {
                            if (booleanRef11.element) {
                                list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            if (booleanRef12.element) {
                                list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj12) {
                                        return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                    }
                                }));
                            }
                            Unit unit1117 = Unit.INSTANCE;
                        }
                        i14 = i1119;
                        list18 = list211118;
                        str33 = str53;
                        str32 = str32;
                        i13 = i13;
                        str29 = str56;
                        str30 = str54;
                    } else {
                        str53 = str33;
                    }
                    metaEpisode = null;
                    if (metaEpisode != null) {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    } else {
                        metaEpisode2 = metaEpisode;
                        str54 = str30;
                        if (metaEpisode2 != null) {
                            str55 = null;
                        } else {
                            str55 = null;
                        }
                        if (str55 == null) {
                            if (metaEpisode2 != null) {
                                str58 = str29;
                                str55 = null;
                            } else {
                                str58 = str29;
                                str55 = null;
                            }
                            if (str55 == null) {
                                str56 = str58;
                                str57 = "Episode " + i16;
                            } else {
                                str56 = str58;
                            }
                        } else {
                            str56 = str29;
                        }
                        str57 = str55;
                    }
                    if (metaEpisode2 != null) {
                        overview = metaEpisode2.getOverview();
                    } else {
                        overview = null;
                    }
                    if (metaEpisode2 != null) {
                        image = metaEpisode2.getImage();
                    } else {
                        image = null;
                    }
                    if (metaEpisode2 != null) {
                        scoreFrom10 = null;
                    } else {
                        scoreFrom10 = null;
                    }
                    if (metaEpisode2 != null) {
                        runtime = metaEpisode2.getRuntime();
                    } else {
                        runtime = null;
                    }
                    if (metaEpisode2 != null) {
                        airDateUtc = metaEpisode2.getAirDateUtc();
                    } else {
                        airDateUtc = null;
                    }
                    if (i12 != 0) {
                        Boxing.boxBoolean(list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|movie", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj12) {
                                return AniDb.load$lambda$6$1(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                            }
                        })));
                    } else {
                        if (booleanRef11.element) {
                            list7.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|sub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$2(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        if (booleanRef12.element) {
                            list8.add(MainAPIKt.newEpisode(this, episodeItem2.getId() + '|' + str5 + "|dub", new Function1() { // from class: com.anidb.AniDb$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj12) {
                                    return AniDb.load$lambda$6$3(i16, str57, overview, image, scoreFrom10, runtime, airDateUtc, (Episode) obj12);
                                }
                            }));
                        }
                        Unit unit1118 = Unit.INSTANCE;
                    }
                    i14 = i1119;
                    list18 = list211118;
                    str33 = str53;
                    str32 = str32;
                    i13 = i13;
                    str29 = str56;
                    str30 = str54;
                }
                String str611111111 = str33;
                String str611111112 = str32;
                if (i12 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType19 = tvType;
                elementSelectFirst9 = document2.selectFirst("a[href*=youtube.com/watch]");
                if (elementSelectFirst9 != null) {
                    strAttr4 = elementSelectFirst9.attr(str31);
                } else {
                    strAttr4 = null;
                }
                elementSelectFirst10 = document2.selectFirst("a[class*=badge][href*=/browse?status=]");
                if (elementSelectFirst10 != null) {
                    strText4 = elementSelectFirst10.text();
                } else {
                    strText4 = null;
                }
                if (Intrinsics.areEqual(strText4, "Finished Airing")) {
                    showStatus = ShowStatus.Completed;
                } else if (Intrinsics.areEqual(strText4, "Currently Airing")) {
                    showStatus = ShowStatus.Ongoing;
                } else {
                    showStatus = null;
                }
                it6 = document2.select("div.flex.flex-wrap.gap-x-6 span").iterator();
                while (true) {
                    document5 = document2;
                    list19 = list8;
                    if (it6.hasNext()) {
                        next2 = it6.next();
                        element3 = (Element) next2;
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        if (StringsKt.contains$default(element3.text(), "m", false, 2, (Object) null)) {
                            z8 = true;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            document2 = document5;
                            booleanRef12 = booleanRef18;
                            str5 = str49;
                            booleanRef11 = booleanRef19;
                            strText4 = str50;
                            list7 = list20;
                            list8 = list19;
                        }
                    } else {
                        str49 = str5;
                        list20 = list7;
                        booleanRef18 = booleanRef12;
                        booleanRef19 = booleanRef11;
                        str50 = strText4;
                        i15 = 2;
                        z6 = false;
                        str51 = null;
                        next2 = null;
                    }
                }
                element2 = (Element) next2;
                if (element2 != null) {
                    strText5 = element2.text();
                } else {
                    strText5 = str51;
                }
                str52 = strText5;
                if (str52 != null) {
                    if (!StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                            intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                            if (intOrNull5 != null) {
                                iIntValue = intOrNull5.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            intOrNull4 = Boxing.boxInt(iIntValue * 60);
                        } else {
                            intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                        }
                    } else if (StringsKt.contains$default(str52, "h", z6, i15, str51)) {
                        intOrNull5 = StringsKt.toIntOrNull(StringsKt.substringBefore$default(str52, "h", str51, i15, str51));
                        if (intOrNull5 != null) {
                            iIntValue = intOrNull5.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        intOrNull4 = Boxing.boxInt(iIntValue * 60);
                    } else {
                        intOrNull4 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(str52, "m", str51, i15, str51)).toString());
                    }
                    r60 = intOrNull4;
                } else {
                    r60 = str51;
                }
                AniDb aniDb18 = this;
                if (i12 != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                C00025 c0002112 = new C00025(str35, url, str34, num5, list6, showStatus, r60, d5, r62, r63, strAttr4, z7, list20, list19, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(str611111112);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(str49);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(str611111111);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(str35);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(str34);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(list6);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(num5);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(str16);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(d5);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(str36);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodesResponse4);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(list5);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(num6);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(booleanRef19);
                c00013.L$15 = SpillingKt.nullOutSpilledVariable(booleanRef18);
                c00013.L$16 = SpillingKt.nullOutSpilledVariable(list20);
                c00013.L$17 = SpillingKt.nullOutSpilledVariable(list19);
                c00013.L$18 = SpillingKt.nullOutSpilledVariable((Object) r62);
                c00013.L$19 = SpillingKt.nullOutSpilledVariable((Object) r63);
                c00013.L$20 = SpillingKt.nullOutSpilledVariable(str48);
                c00013.L$21 = SpillingKt.nullOutSpilledVariable(metaAnimeData);
                c00013.L$22 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$23 = SpillingKt.nullOutSpilledVariable(tvType19);
                c00013.L$24 = SpillingKt.nullOutSpilledVariable(strAttr4);
                c00013.L$25 = SpillingKt.nullOutSpilledVariable(str50);
                c00013.L$26 = SpillingKt.nullOutSpilledVariable(showStatus);
                c00013.L$27 = SpillingKt.nullOutSpilledVariable(str52);
                c00013.L$28 = SpillingKt.nullOutSpilledVariable((Object) r60);
                c00013.I$0 = i7;
                c00013.I$1 = i12;
                c00013.label = 6;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(aniDb18, str611111111, str611111112, tvType19, false, c0002112, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj8) {
                    return obj8;
                }
                return objNewAnimeLoadResponse$default;
            case 6:
                int i24 = c00013.I$1;
                int i25 = c00013.I$0;
                ResultKt.throwOnFailure(objNewAnimeLoadResponse$default);
                return objNewAnimeLoadResponse$default;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$1(int $num, String $epName, String $epDesc, String $epPoster, Score $epRating, Integer $epRuntime, String $epAirDate, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($num));
        $this$newEpisode.setName($epName);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setPosterUrl($epPoster);
        if ($epRating != null) {
            $this$newEpisode.setScore($epRating);
        }
        $this$newEpisode.setRunTime($epRuntime);
        MainAPIKt.addDate$default($this$newEpisode, $epAirDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$2(int $num, String $epName, String $epDesc, String $epPoster, Score $epRating, Integer $epRuntime, String $epAirDate, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($num));
        $this$newEpisode.setName($epName);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setPosterUrl($epPoster);
        if ($epRating != null) {
            $this$newEpisode.setScore($epRating);
        }
        $this$newEpisode.setRunTime($epRuntime);
        MainAPIKt.addDate$default($this$newEpisode, $epAirDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$3(int $num, String $epName, String $epDesc, String $epPoster, Score $epRating, Integer $epRuntime, String $epAirDate, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($num));
        $this$newEpisode.setName($epName);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setPosterUrl($epPoster);
        if ($epRating != null) {
            $this$newEpisode.setScore($epRating);
        }
        $this$newEpisode.setRunTime($epRuntime);
        MainAPIKt.addDate$default($this$newEpisode, $epAirDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.anidb.AniDb$load$5 */
    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anidb.AniDb$load$5", f = "AniDb.kt", i = {0}, l = {336}, m = "invokeSuspend", n = {"$this$newAnimeLoadResponse"}, nl = {337}, s = {"L$0"}, v = 2)
    static final class C00025 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $anilistId;
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ Integer $duration;
        final /* synthetic */ boolean $isMovie;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ String $poster;
        final /* synthetic */ Double $rating;
        final /* synthetic */ ShowStatus $showStatus;
        final /* synthetic */ List<Episode> $subEpisodes;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailerUrl;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00025(String str, String str2, String str3, Integer num, List<String> list, ShowStatus showStatus, Integer num2, Double d, Integer num3, Integer num4, String str4, boolean z, List<Episode> list2, List<Episode> list3, Continuation<? super C00025> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundposter = str2;
            this.$description = str3;
            this.$year = num;
            this.$tags = list;
            this.$showStatus = showStatus;
            this.$duration = num2;
            this.$rating = d;
            this.$malId = num3;
            this.$anilistId = num4;
            this.$trailerUrl = str4;
            this.$isMovie = z;
            this.$subEpisodes = list2;
            this.$dubEpisodes = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00025 = new C00025(this.$poster, this.$backgroundposter, this.$description, this.$year, this.$tags, this.$showStatus, this.$duration, this.$rating, this.$malId, this.$anilistId, this.$trailerUrl, this.$isMovie, this.$subEpisodes, this.$dubEpisodes, continuation);
            c00025.L$0 = obj;
            return c00025;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    String str = this.$backgroundposter;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setShowStatus(this.$showStatus);
                    loadResponse.setDuration(this.$duration);
                    if (this.$rating != null) {
                        loadResponse.setScore(Score.Companion.from10(String.valueOf(this.$rating.doubleValue())));
                    }
                    LoadResponse.Companion.addMalId(loadResponse, this.$malId);
                    LoadResponse.Companion.addAniListId(loadResponse, this.$anilistId);
                    this.L$0 = loadResponse;
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailerUrl, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (this.$isMovie) {
                MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
            } else {
                MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEpisodes);
                MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEpisodes);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x01df  */
    /* JADX WARN: Code duplicated, block: B:46:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:49:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:50:0x0208  */
    /* JADX WARN: Code duplicated, block: B:54:0x0226  */
    /* JADX WARN: Code duplicated, block: B:56:0x023d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0249  */
    /* JADX WARN: Code duplicated, block: B:61:0x0253 A[LOOP:0: B:52:0x021e->B:61:0x0253, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:65:0x0265  */
    /* JADX WARN: Code duplicated, block: B:68:0x0273  */
    /* JADX WARN: Code duplicated, block: B:70:0x0287  */
    /* JADX WARN: Code duplicated, block: B:71:0x0293  */
    /* JADX WARN: Code duplicated, block: B:75:0x029f A[LOOP:1: B:66:0x026d->B:75:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x034d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x034e  */
    /* JADX WARN: Code duplicated, block: B:89:0x025a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x029c A[SYNTHETIC] */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00031 c00031;
        AniDb aniDb;
        String langUrl;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List parts;
        String episodeId;
        String episodeIdRaw;
        String audio;
        String episodeIdRaw2;
        boolean isCasting2;
        Object obj;
        String data2;
        String data3;
        Object safe;
        LanguagesResponse langResponse;
        List<Language> listEmptyList;
        List preferredCodes;
        Iterator<T> it;
        LanguagesResponse langResponse2;
        List<Language> list;
        Object next;
        Language language;
        List<Language> listListOfNotNull;
        Iterator it2;
        Object obj2;
        Object next2;
        List list2;
        Iterator it3;
        String name;
        String lowerCase;
        List list3;
        String code;
        String lowerCase2;
        C00042 c00042;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
                aniDb = this;
            } else {
                aniDb = this;
                c00031 = aniDb.new C00031(continuation);
            }
        } else {
            aniDb = this;
            c00031 = aniDb.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List parts2 = StringsKt.split$default(data, new String[]{"|"}, false, 0, 6, (Object) null);
                String episodeIdRaw3 = (String) CollectionsKt.getOrNull(parts2, 0);
                if (episodeIdRaw3 == null) {
                    return Boxing.boxBoolean(false);
                }
                String episodeId2 = StringsKt.substringAfterLast$default(episodeIdRaw3, "/", (String) null, 2, (Object) null);
                String slug = (String) CollectionsKt.getOrNull(parts2, 1);
                if (slug == null) {
                    return Boxing.boxBoolean(false);
                }
                String audio2 = (String) CollectionsKt.getOrNull(parts2, 2);
                if (audio2 == null) {
                    audio2 = "sub";
                }
                String langUrl2 = aniDb.getMainUrl() + "/api/frontend/episode/" + episodeId2 + "/languages";
                Companion companion = INSTANCE;
                Map<String, String> mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Referer", aniDb.getMainUrl() + "/anime/" + slug)});
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = function1;
                c00032.L$2 = function2;
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(episodeIdRaw3);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(episodeId2);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(slug);
                c00032.L$7 = audio2;
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(langUrl2);
                c00032.Z$0 = isCasting;
                c00032.label = 1;
                Object objAppGet = companion.appGet(langUrl2, mapMapOf, c00032);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                langUrl = langUrl2;
                function3 = function1;
                function4 = function2;
                parts = parts2;
                episodeId = episodeId2;
                episodeIdRaw = episodeIdRaw3;
                audio = audio2;
                episodeIdRaw2 = slug;
                isCasting2 = isCasting;
                obj = objAppGet;
                data2 = data;
                NiceResponse this_$iv = (NiceResponse) obj;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    data3 = data2;
                    try {
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                    } catch (Exception e) {
                        e$iv = e;
                        e$iv.printStackTrace();
                        safe = null;
                    }
                    break;
                } catch (Exception e2) {
                    e$iv = e2;
                    data3 = data2;
                }
                langResponse = (LanguagesResponse) safe;
                if (langResponse != null || (listEmptyList = langResponse.getLanguages()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                if (Intrinsics.areEqual(audio, "movie")) {
                    langResponse2 = langResponse;
                    list = listEmptyList;
                    listListOfNotNull = list;
                } else {
                    if (Intrinsics.areEqual(audio, "sub")) {
                        preferredCodes = CollectionsKt.listOf(new String[]{"jpn", "ja", "japanese"});
                    } else {
                        preferredCodes = CollectionsKt.listOf(new String[]{"eng", "en", "english"});
                    }
                    it = listEmptyList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            Language it4 = (Language) next;
                            langResponse2 = langResponse;
                            list3 = preferredCodes;
                            list = listEmptyList;
                            code = it4.getCode();
                            if (code != null) {
                                lowerCase2 = code.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            } else {
                                lowerCase2 = null;
                            }
                            if (CollectionsKt.contains(list3, lowerCase2)) {
                                langResponse = langResponse2;
                                listEmptyList = list;
                                preferredCodes = preferredCodes;
                            }
                        } else {
                            langResponse2 = langResponse;
                            list = listEmptyList;
                            preferredCodes = preferredCodes;
                            next = null;
                        }
                    }
                    language = (Language) next;
                    if (language == null) {
                        it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next2 = it2.next();
                                Language it5 = (Language) next2;
                                list2 = preferredCodes;
                                it3 = it2;
                                name = it5.getName();
                                if (name != null) {
                                    lowerCase = name.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(list2, lowerCase)) {
                                    obj2 = next2;
                                } else {
                                    it2 = it3;
                                }
                            } else {
                                obj2 = null;
                            }
                        }
                        language = (Language) obj2;
                    }
                    listListOfNotNull = CollectionsKt.listOfNotNull(language);
                }
                List hlsRegex = CollectionsKt.listOf(new Regex[]{new Regex("file\\s*:\\s*[\"'](https?://[^\"']+\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE), new Regex("sources\\s*:\\s*\\[\\s*\\{[^}]*file\\s*:\\s*[\"'](https?://[^\"']+\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE), new Regex("[\"'](https?://[^\"']+/master\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE), new Regex("[\"'](https?://[^\"']+\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE)});
                c00042 = new C00042(hlsRegex, audio, function4, function3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(episodeIdRaw);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(episodeId);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(episodeIdRaw2);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(audio);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(langUrl);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(langResponse2);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(list);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(listListOfNotNull);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(hlsRegex);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(listListOfNotNull, c00042, c00032) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting3 = c00032.Z$0;
                String langUrl3 = (String) c00032.L$8;
                String audio3 = (String) c00032.L$7;
                String slug2 = (String) c00032.L$6;
                String episodeId3 = (String) c00032.L$5;
                String episodeIdRaw4 = (String) c00032.L$4;
                List parts3 = (List) c00032.L$3;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00032.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00032.L$1;
                String data4 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function5;
                audio = audio3;
                function3 = function6;
                langUrl = langUrl3;
                data2 = data4;
                episodeIdRaw = episodeIdRaw4;
                parts = parts3;
                episodeIdRaw2 = slug2;
                episodeId = episodeId3;
                isCasting2 = isCasting3;
                obj = $result;
                NiceResponse this_$iv2 = (NiceResponse) obj;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data3 = data2;
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(LanguagesResponse.class));
                langResponse = (LanguagesResponse) safe;
                if (langResponse != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                if (Intrinsics.areEqual(audio, "movie")) {
                    langResponse2 = langResponse;
                    list = listEmptyList;
                    listListOfNotNull = list;
                } else {
                    if (Intrinsics.areEqual(audio, "sub")) {
                        preferredCodes = CollectionsKt.listOf(new String[]{"jpn", "ja", "japanese"});
                    } else {
                        preferredCodes = CollectionsKt.listOf(new String[]{"eng", "en", "english"});
                    }
                    it = listEmptyList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            Language it6 = (Language) next;
                            langResponse2 = langResponse;
                            list3 = preferredCodes;
                            list = listEmptyList;
                            code = it6.getCode();
                            if (code != null) {
                                lowerCase2 = code.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            } else {
                                lowerCase2 = null;
                            }
                            if (CollectionsKt.contains(list3, lowerCase2)) {
                                langResponse = langResponse2;
                                listEmptyList = list;
                                preferredCodes = preferredCodes;
                            }
                        } else {
                            langResponse2 = langResponse;
                            list = listEmptyList;
                            preferredCodes = preferredCodes;
                            next = null;
                        }
                    }
                    language = (Language) next;
                    if (language == null) {
                        it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next2 = it2.next();
                                Language it7 = (Language) next2;
                                list2 = preferredCodes;
                                it3 = it2;
                                name = it7.getName();
                                if (name != null) {
                                    lowerCase = name.toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                } else {
                                    lowerCase = null;
                                }
                                if (CollectionsKt.contains(list2, lowerCase)) {
                                    obj2 = next2;
                                } else {
                                    it2 = it3;
                                }
                            } else {
                                obj2 = null;
                            }
                        }
                        language = (Language) obj2;
                    }
                    listListOfNotNull = CollectionsKt.listOfNotNull(language);
                }
                List hlsRegex2 = CollectionsKt.listOf(new Regex[]{new Regex("file\\s*:\\s*[\"'](https?://[^\"']+\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE), new Regex("sources\\s*:\\s*\\[\\s*\\{[^}]*file\\s*:\\s*[\"'](https?://[^\"']+\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE), new Regex("[\"'](https?://[^\"']+/master\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE), new Regex("[\"'](https?://[^\"']+\\.m3u8[^\"']*)[\"']", RegexOption.IGNORE_CASE)});
                c00042 = new C00042(hlsRegex2, audio, function4, function3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(episodeIdRaw);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(episodeId);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(episodeIdRaw2);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(audio);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(langUrl);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(langResponse2);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(list);
                c00032.L$11 = SpillingKt.nullOutSpilledVariable(listListOfNotNull);
                c00032.L$12 = SpillingKt.nullOutSpilledVariable(hlsRegex2);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(listListOfNotNull, c00042, c00032) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean z = c00032.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.anidb.AniDb$loadLinks$2 */
    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "language", "Lcom/anidb/AniDb$Language;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anidb.AniDb$loadLinks$2", f = "AniDb.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {390, 403, 409}, m = "invokeSuspend", n = {"language", "embedUrl", "language", "embedUrl", "embedDoc", "hlsUrl", "sourceName", "language", "embedUrl", "embedDoc", "hlsUrl"}, nl = {392, 407, 411}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniDb.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniDb.kt\ncom/anidb/AniDb$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,437:1\n2068#2,2:438\n*S KotlinDebug\n*F\n+ 1 AniDb.kt\ncom/anidb/AniDb$loadLinks$2\n*L\n407#1:438,2\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function2<Language, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $audio;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ List<Regex> $hlsRegex;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(List<Regex> list, String str, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$hlsRegex = list;
            this.$audio = str;
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = AniDb.this.new C00042(this.$hlsRegex, this.$audio, this.$callback, this.$subtitleCallback, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(Language language, Continuation<? super Unit> continuation) {
            return create(language, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:24:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:26:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:28:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:30:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:33:0x0148 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0149  */
        /* JADX WARN: Code duplicated, block: B:38:0x015b A[LOOP:0: B:36:0x0155->B:38:0x015b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:40:0x0169  */
        /* JADX WARN: Code duplicated, block: B:42:0x01a8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:43:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:47:0x00bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x00b2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:49:? A[LOOP:1: B:17:0x009a->B:49:?, LOOP_END, SYNTHETIC] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            String embedUrl;
            Object objAppGet;
            String embedDoc;
            Iterator<Regex> it;
            String hlsUrl;
            String name;
            Object objGenerateM3u8$default;
            String embedUrl2;
            String name2;
            MatchResult match;
            Function1<ExtractorLink, Unit> function1;
            Language language = (Language) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    embedUrl = language.getEmbed_url();
                    if (embedUrl == null) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = language;
                    this.L$1 = embedUrl;
                    this.label = 1;
                    objAppGet = AniDb.INSTANCE.appGet(embedUrl, MapsKt.mapOf(TuplesKt.to("Referer", AniDb.this.getMainUrl() + '/')), (Continuation) this);
                    if (objAppGet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    embedDoc = ((NiceResponse) objAppGet).getText();
                    it = this.$hlsRegex.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Regex regex = it.next();
                            match = Regex.find$default(regex, embedDoc, 0, 2, (Object) null);
                            if (match != null) {
                                String hlsUrl2 = (String) match.getGroupValues().get(1);
                                hlsUrl = hlsUrl2;
                            }
                        } else {
                            hlsUrl = null;
                        }
                    }
                    if (hlsUrl != null) {
                        if (Intrinsics.areEqual(this.$audio, "movie")) {
                            StringBuilder sbAppend = new StringBuilder().append(AniDb.this.getName()).append(" - ");
                            name2 = language.getName();
                            if (name2 == null) {
                                name2 = "Unknown";
                            }
                            name = sbAppend.append(name2).toString();
                        } else {
                            name = AniDb.this.getName();
                        }
                        String sourceName = name;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(language);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedUrl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(embedDoc);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(hlsUrl);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(sourceName);
                        this.label = 2;
                        objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, sourceName, hlsUrl, AniDb.this.getMainUrl() + '/', (Integer) null, (Map) null, (String) null, (Continuation) this, 56, (Object) null);
                        if (objGenerateM3u8$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        embedUrl2 = embedUrl;
                        Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                        function1 = this.$callback;
                        for (Object element$iv : $this$forEach$iv) {
                            function1.invoke(element$iv);
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(language);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedUrl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(embedDoc);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(hlsUrl);
                        this.label = 3;
                        if (ExtractorApiKt.loadExtractor(embedUrl, AniDb.this.getMainUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    embedUrl = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objAppGet = $result;
                    embedDoc = ((NiceResponse) objAppGet).getText();
                    it = this.$hlsRegex.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Regex regex2 = it.next();
                            match = Regex.find$default(regex2, embedDoc, 0, 2, (Object) null);
                            if (match != null) {
                                String hlsUrl3 = (String) match.getGroupValues().get(1);
                                hlsUrl = hlsUrl3;
                            }
                        } else {
                            hlsUrl = null;
                        }
                    }
                    if (hlsUrl != null) {
                        if (Intrinsics.areEqual(this.$audio, "movie")) {
                            StringBuilder sbAppend2 = new StringBuilder().append(AniDb.this.getName()).append(" - ");
                            name2 = language.getName();
                            if (name2 == null) {
                                name2 = "Unknown";
                            }
                            name = sbAppend2.append(name2).toString();
                        } else {
                            name = AniDb.this.getName();
                        }
                        String sourceName2 = name;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(language);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedUrl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(embedDoc);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(hlsUrl);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(sourceName2);
                        this.label = 2;
                        objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, sourceName2, hlsUrl, AniDb.this.getMainUrl() + '/', (Integer) null, (Map) null, (String) null, (Continuation) this, 56, (Object) null);
                        if (objGenerateM3u8$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        embedUrl2 = embedUrl;
                        Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                        function1 = this.$callback;
                        while (r8.hasNext()) {
                            function1.invoke(element$iv);
                        }
                        Unit unit2 = Unit.INSTANCE;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(language);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedUrl);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(embedDoc);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(hlsUrl);
                        this.label = 3;
                        if (ExtractorApiKt.loadExtractor(embedUrl, AniDb.this.getMainUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    String hlsUrl4 = (String) this.L$3;
                    embedUrl2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    hlsUrl = hlsUrl4;
                    objGenerateM3u8$default = $result;
                    Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                    function1 = this.$callback;
                    while (r8.hasNext()) {
                        function1.invoke(element$iv);
                    }
                    Unit unit3 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/anidb/AniDb$EpisodeItem;", "", "id", "", "number", "filler", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumber", "getFiller", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/anidb/AniDb$EpisodeItem;", "equals", "other", "hashCode", "toString", "", "AniDb"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodeItem {

        @Nullable
        private final Boolean filler;

        @Nullable
        private final Integer id;

        @Nullable
        private final Integer number;

        public EpisodeItem() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ EpisodeItem copy$default(EpisodeItem episodeItem, Integer num, Integer num2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                num = episodeItem.id;
            }
            if ((i & 2) != 0) {
                num2 = episodeItem.number;
            }
            if ((i & 4) != 0) {
                bool = episodeItem.filler;
            }
            return episodeItem.copy(num, num2, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getFiller() {
            return this.filler;
        }

        @NotNull
        public final EpisodeItem copy(@Nullable Integer id, @Nullable Integer number, @Nullable Boolean filler) {
            return new EpisodeItem(id, number, filler);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeItem)) {
                return false;
            }
            EpisodeItem episodeItem = (EpisodeItem) other;
            return Intrinsics.areEqual(this.id, episodeItem.id) && Intrinsics.areEqual(this.number, episodeItem.number) && Intrinsics.areEqual(this.filler, episodeItem.filler);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.number == null ? 0 : this.number.hashCode())) * 31) + (this.filler != null ? this.filler.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "EpisodeItem(id=" + this.id + ", number=" + this.number + ", filler=" + this.filler + ')';
        }

        public EpisodeItem(@Nullable Integer id, @Nullable Integer number, @Nullable Boolean filler) {
            this.id = id;
            this.number = number;
            this.filler = filler;
        }

        public /* synthetic */ EpisodeItem(Integer num, Integer num2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : bool);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        public final Boolean getFiller() {
            return this.filler;
        }
    }

    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/anidb/AniDb$EpisodesResponse;", "", "episodes", "", "Lcom/anidb/AniDb$EpisodeItem;", "<init>", "(Ljava/util/List;)V", "getEpisodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AniDb"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodesResponse {

        @Nullable
        private final List<EpisodeItem> episodes;

        /* JADX WARN: Illegal instructions before constructor call */
        public EpisodesResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodesResponse copy$default(EpisodesResponse episodesResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = episodesResponse.episodes;
            }
            return episodesResponse.copy(list);
        }

        @Nullable
        public final List<EpisodeItem> component1() {
            return this.episodes;
        }

        @NotNull
        public final EpisodesResponse copy(@Nullable List<EpisodeItem> episodes) {
            return new EpisodesResponse(episodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EpisodesResponse) && Intrinsics.areEqual(this.episodes, ((EpisodesResponse) other).episodes);
        }

        public int hashCode() {
            if (this.episodes == null) {
                return 0;
            }
            return this.episodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "EpisodesResponse(episodes=" + this.episodes + ')';
        }

        public EpisodesResponse(@Nullable List<EpisodeItem> list) {
            this.episodes = list;
        }

        public /* synthetic */ EpisodesResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @Nullable
        public final List<EpisodeItem> getEpisodes() {
            return this.episodes;
        }
    }

    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/anidb/AniDb$Language;", "", "id", "", "code", "", "name", "embed_url", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/String;", "getName", "getEmbed_url", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/anidb/AniDb$Language;", "equals", "", "other", "hashCode", "toString", "AniDb"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Language {

        @Nullable
        private final String code;

        @Nullable
        private final String embed_url;

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        public Language() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Language copy$default(Language language, Integer num, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = language.id;
            }
            if ((i & 2) != 0) {
                str = language.code;
            }
            if ((i & 4) != 0) {
                str2 = language.name;
            }
            if ((i & 8) != 0) {
                str3 = language.embed_url;
            }
            return language.copy(num, str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getEmbed_url() {
            return this.embed_url;
        }

        @NotNull
        public final Language copy(@Nullable Integer id, @Nullable String code, @Nullable String name, @Nullable String embed_url) {
            return new Language(id, code, name, embed_url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Language)) {
                return false;
            }
            Language language = (Language) other;
            return Intrinsics.areEqual(this.id, language.id) && Intrinsics.areEqual(this.code, language.code) && Intrinsics.areEqual(this.name, language.name) && Intrinsics.areEqual(this.embed_url, language.embed_url);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.code == null ? 0 : this.code.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.embed_url != null ? this.embed_url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Language(id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", embed_url=" + this.embed_url + ')';
        }

        public Language(@Nullable Integer id, @Nullable String code, @Nullable String name, @Nullable String embed_url) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.embed_url = embed_url;
        }

        public /* synthetic */ Language(Integer num, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getCode() {
            return this.code;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getEmbed_url() {
            return this.embed_url;
        }
    }

    /* JADX INFO: compiled from: AniDb.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/anidb/AniDb$LanguagesResponse;", "", "languages", "", "Lcom/anidb/AniDb$Language;", "<init>", "(Ljava/util/List;)V", "getLanguages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AniDb"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LanguagesResponse {

        @Nullable
        private final List<Language> languages;

        /* JADX WARN: Illegal instructions before constructor call */
        public LanguagesResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LanguagesResponse copy$default(LanguagesResponse languagesResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = languagesResponse.languages;
            }
            return languagesResponse.copy(list);
        }

        @Nullable
        public final List<Language> component1() {
            return this.languages;
        }

        @NotNull
        public final LanguagesResponse copy(@Nullable List<Language> languages) {
            return new LanguagesResponse(languages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LanguagesResponse) && Intrinsics.areEqual(this.languages, ((LanguagesResponse) other).languages);
        }

        public int hashCode() {
            if (this.languages == null) {
                return 0;
            }
            return this.languages.hashCode();
        }

        @NotNull
        public String toString() {
            return "LanguagesResponse(languages=" + this.languages + ')';
        }

        public LanguagesResponse(@Nullable List<Language> list) {
            this.languages = list;
        }

        public /* synthetic */ LanguagesResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @Nullable
        public final List<Language> getLanguages() {
            return this.languages;
        }
    }
}
