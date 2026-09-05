package com.kickassanime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Kickassanime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kickassanime/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 S2\u00020\u0001:\u0013STUVWXYZ[\\]^_`abcdeB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010$\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\f\u0010.\u001a\u00020/*\u000200H\u0002J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020/0\"2\u0006\u00102\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00103J\u001e\u00104\u001a\u0002052\u0006\u00102\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u00106J\f\u0010.\u001a\u00020/*\u000207H\u0002J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00103JF\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u000f2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0?2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020A0?H\u0096@¢\u0006\u0002\u0010DJ<\u0010E\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010F2\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0005H\u0002J\b\u0010M\u001a\u00020\u0005H\u0002J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0005H\u0002J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\"2\u0006\u0010P\u001a\u00020\u0005H\u0002R\u001c\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u0010\n\u0002\b\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u0014\u0010\u0015\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006f"}, d2 = {"Lcom/kickassanime/Kickassanime;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "mainUrl$1", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasQuickSearch", "getHasQuickSearch", "hasDownloadSupport", "getHasDownloadSupport", "supportedSyncNames", "", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "()Ljava/util/Set;", "supportedTypes", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperAnimeLink", "uri", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/kickassanime/Kickassanime$Result;", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/kickassanime/Kickassanime$SearchResult;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignature", "Lkotlin/Triple;", "html", "server", "key", "", "sha1sum", "value", "generateFilterWithCurrentYear", "parseEpisodePage", "Lcom/kickassanime/Kickassanime$EpisodePage;", "json", "parseJsonToEpisodes", "Lcom/kickassanime/Kickassanime$Episoderesponse;", "Companion", "Search", "SearchResult", "SearchPoster", "ResponseHome", "Result", "Poster", "Episoderesponse", "Thumbnail", "loadres", "LoadPoster", "Banner", "ServersRes", "Server", "m3u8", "Subtitle", "Encrypted", "EpisodePage", "PageInfo", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKickassanime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kickassanime.kt\ncom/kickassanime/Kickassanime\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,664:1\n73#2,5:665\n73#2,5:702\n73#2,5:713\n1739#3:670\n1814#3,3:671\n1739#3:698\n1814#3,3:699\n2068#3:707\n2068#3,2:708\n2068#3,2:710\n2069#3:712\n2068#3,2:718\n1960#3,3:743\n1960#3,3:746\n1#4:674\n1#4:678\n1#4:723\n93#5,2:675\n63#5:677\n64#5,15:679\n95#5,2:696\n93#5,2:720\n63#5:722\n64#5,15:724\n95#5,2:741\n50#6:694\n43#6:695\n50#6:739\n43#6:740\n*S KotlinDebug\n*F\n+ 1 Kickassanime.kt\ncom/kickassanime/Kickassanime\n*L\n67#1:665,5\n143#1:702,5\n225#1:713,5\n67#1:670\n67#1:671,3\n115#1:698\n115#1:699,3\n160#1:707\n184#1:708,2\n192#1:710,2\n160#1:712\n454#1:718,2\n91#1:743,3\n135#1:746,3\n115#1:678\n657#1:723\n115#1:675,2\n115#1:677\n115#1:679,15\n115#1:696,2\n657#1:720,2\n657#1:722\n657#1:724,15\n657#1:741,2\n115#1:694\n115#1:695\n657#1:739\n657#1:740\n*E\n"})
public final class Kickassanime extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String mainUrl = "https://kaa.lt";

    /* JADX INFO: renamed from: mainUrl$1, reason: from kotlin metadata */
    @NotNull
    private String mainUrl = "https://kaa.lt";

    @NotNull
    private String name = "KickassAnime";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasQuickSearch = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(new SyncIdName[]{SyncIdName.MyAnimeList, SyncIdName.Anilist});

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("filters=" + generateFilterWithCurrentYear(), "Airing"), TuplesKt.to(getMainUrl() + "/api/show/trending", "Trending"), TuplesKt.to(getMainUrl() + "/api/show/popular", "Popular Animes")});

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$getMainPage$1 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime", f = "Kickassanime.kt", i = {0, 0, 0}, l = {67}, m = "getMainPage", n = {"request", "url", "page"}, nl = {665}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kickassanime.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$load$1 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime", f = "Kickassanime.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {143, 179, 185, 205}, m = "load", n = {"url", "showName", "url", "showName", "loadJson", "title", "poster", "description", "tags", "status", "tvType", "locales", "subEpisodes", "dubEpisodes", "$this$forEach$iv", "element$iv", "locale", "langSuffix", "isSub", "url", "showName", "loadJson", "title", "poster", "description", "tags", "status", "tvType", "locales", "subEpisodes", "dubEpisodes", "$this$forEach$iv", "element$iv", "locale", "langSuffix", "firstPageJson", "firstPageData", "allEpisodeResponses", "$this$forEach$iv", "element$iv", "page", "isSub", "url", "showName", "loadJson", "title", "poster", "description", "tags", "status", "tvType", "locales", "subEpisodes", "dubEpisodes"}, nl = {665, 180, 186, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$22", "L$23", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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
            return Kickassanime.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$1 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime", f = "Kickassanime.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {225, 225}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parsedData", "lang", "isCasting", "data", "subtitleCallback", "callback", "parsedData", "lang", "isCasting"}, nl = {666, 423}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return Kickassanime.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$quickSearch$1 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime", f = "Kickassanime.kt", i = {0}, l = {97}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kickassanime.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$search$1 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime", f = "Kickassanime.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {105, 114}, m = "search", n = {"query", "json", "page", "query", "json", "host", "mediaType", "requestBody", "headers", "page"}, nl = {106, 115}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kickassanime.this.search(null, 0, (Continuation) this);
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

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public Set<SyncIdName> getSupportedSyncNames() {
        return this.supportedSyncNames;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/kickassanime/Kickassanime$Companion;", "", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "t", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getMainUrl() {
            return Kickassanime.mainUrl;
        }

        public final void setMainUrl(@NotNull String str) {
            Kickassanime.mainUrl = str;
        }

        @NotNull
        public final ShowStatus getStatus(@NotNull String t) {
            if (Intrinsics.areEqual(t, "finished_airing")) {
                return ShowStatus.Completed;
            }
            return Intrinsics.areEqual(t, "currently_airing") ? ShowStatus.Ongoing : ShowStatus.Completed;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        MainPageRequest request2;
        Object safe;
        List home;
        Iterable result;
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
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = StringsKt.startsWith$default(request.getData(), "filter", false, 2, (Object) null) ? getMainUrl() + "/api/anime?page=" + page + '&' + request.getData() : request.getData() + "?page=" + page;
                Requests app = MainActivityKt.getApp();
                c00021.L$0 = request;
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00021.I$0 = page;
                c00021.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ResponseHome.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        ResponseHome responseHome = (ResponseHome) safe;
        if (responseHome == null || (result = responseHome.getResult()) == null) {
            home = null;
        } else {
            Iterable $this$map$iv = result;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Result media = (Result) item$iv$iv;
                destination$iv$iv.add(toSearchResponse(media));
            }
            home = (List) destination$iv$iv;
        }
        if (home == null) {
            return null;
        }
        List it = home;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), it, (Boolean) null, 4, (Object) null);
    }

    private final String getProperAnimeLink(String uri) {
        return StringsKt.contains$default(uri, "/episode", false, 2, (Object) null) ? MainAPIKt.fixUrl(this, StringsKt.substringBeforeLast$default(uri, "/", (String) null, 2, (Object) null)) : MainAPIKt.fixUrl(this, uri);
    }

    private final SearchResponse toSearchResponse(final Result $this$toSearchResponse) {
        TvType tvType;
        String href = getProperAnimeLink($this$toSearchResponse.getSlug());
        String titleEn = $this$toSearchResponse.getTitleEn();
        if (titleEn == null) {
            titleEn = $this$toSearchResponse.getTitle();
        }
        String title = StringsKt.replace$default(titleEn, "\"", "", false, 4, (Object) null);
        final String posterUrl = KickassanimeUtilsKt.getImageUrl($this$toSearchResponse.getPoster().getHq());
        String type = $this$toSearchResponse.getType();
        if (Intrinsics.areEqual(type, "movie")) {
            tvType = TvType.AnimeMovie;
        } else {
            tvType = Intrinsics.areEqual(type, "ova") ? TvType.OVA : TvType.Anime;
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, tvType, false, new Function1() { // from class: com.kickassanime.Kickassanime$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Kickassanime.toSearchResponse$lambda$0(posterUrl, $this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    static final Unit toSearchResponse$lambda$0(String $posterUrl, Result $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        boolean z;
        boolean z2;
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        Iterable locales = $this_toSearchResponse.getLocales();
        if (locales != null) {
            Iterable $this$any$iv = locales;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it = $this$any$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        String it2 = (String) element$iv;
                        if (!Intrinsics.areEqual(it2, "ja-JP")) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = false;
            }
            if (z2) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        boolean hasDub = z;
        List<String> locales2 = $this_toSearchResponse.getLocales();
        boolean hasSub = locales2 != null && locales2.contains("ja-JP");
        MainAPIKt.addDubStatus$default($this$newAnimeSearchResponse, hasDub, hasSub, (Integer) null, (Integer) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws ErrorLoadingException {
        C00071 c00071;
        Object objSearch;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                objSearch = search(query, 1, c00071);
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
        return ((SearchResponseList) objSearch).getItems();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:20:0x0109  */
    /* JADX WARN: Code duplicated, block: B:23:0x01e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:27:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:28:0x0202  */
    /* JADX WARN: Code duplicated, block: B:35:0x0232  */
    /* JADX WARN: Code duplicated, block: B:47:0x026e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0270  */
    /* JADX WARN: Code duplicated, block: B:57:0x028c A[Catch: Exception -> 0x02a7, TRY_LEAVE, TryCatch #5 {Exception -> 0x02a7, blocks: (B:45:0x0268, B:49:0x0271, B:57:0x028c, B:56:0x0286, B:44:0x025e, B:51:0x0277), top: B:86:0x025e, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:73:0x02d6 A[LOOP:0: B:71:0x02d0->B:73:0x02d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x02f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0277 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) throws ErrorLoadingException {
        C00081 c00081;
        Object obj;
        Object $result;
        char c;
        char c2;
        C00081 c00082;
        String query2;
        Object obj2;
        String json;
        int page2;
        String host;
        String res;
        Object obj3;
        Object obj4;
        Object obj5;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        Search search;
        Iterable result;
        Collection destination$iv$iv;
        SearchResponseList newSearchResponseList$default;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        Object $result2 = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String json2 = StringsKt.trimIndent("\n{   \"page\": \"" + page + "\",\n    \"query\": \"" + query + "\"\n}\n");
                Requests app = MainActivityKt.getApp();
                String mainUrl2 = getMainUrl();
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00081.L$1 = json2;
                c00081.I$0 = page;
                c00081.label = 1;
                C00081 c00083 = c00081;
                obj = coroutine_suspended;
                $result = $result2;
                c = 1;
                c2 = 2;
                Object obj6 = Requests.get$default(app, mainUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00083, 4062, (Object) null);
                c00082 = c00083;
                if (obj6 == obj) {
                    return obj;
                }
                query2 = query;
                obj2 = obj6;
                json = json2;
                page2 = page;
                host = ((NiceResponse) obj2).getHeaders().get("location");
                if (host == null) {
                    host = getMainUrl() + '/';
                }
                MediaType mediaType = MediaType.Companion.get("application/json");
                RequestBody requestBody = RequestBody.Companion.create(json, mediaType);
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("Accept", "*/*");
                pairArr[c] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36");
                pairArr[c2] = TuplesKt.to("Content-Type", "application/json");
                pairArr[3] = TuplesKt.to("x-origin", "kickass-anime.ru");
                Map headers = MapsKt.mapOf(pairArr);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(json);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(host);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(mediaType);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(requestBody);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                c00082.I$0 = page2;
                c00082.label = 2;
                $result2 = Requests.post$default(MainActivityKt.getApp(), host + "api/fsearch", headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                res = ((NiceResponse) $result2).toString();
                AppUtils appUtils = AppUtils.INSTANCE;
                if (res != null) {
                    try {
                        try {
                            kotlin.Result.Companion companion = kotlin.Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(Search.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = kotlin.Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                            obj3 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (kotlin.Result.exceptionOrNull-impl(obj3) != null) {
                            try {
                                kotlin.Result.Companion companion3 = kotlin.Result.Companion;
                                try {
                                    obj3 = kotlin.Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Search.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        kotlin.Result.Companion companion4 = kotlin.Result.Companion;
                                        obj3 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e) {
                                        obj4 = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        if (kotlin.Result.isFailure-impl(obj3)) {
                            obj5 = null;
                        } else {
                            obj5 = obj3;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, res);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(res, new TypeReference<Search>() { // from class: com.kickassanime.Kickassanime$search$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(res, new TypeReference<Search>() { // from class: com.kickassanime.Kickassanime$search$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(res, new TypeReference<Search>() { // from class: com.kickassanime.Kickassanime$search$$inlined$tryParseJson$1
                            });
                        }
                        obj4 = objDecodeFromString;
                    } catch (Exception e3) {
                        obj4 = null;
                        search = (Search) obj4;
                        if (search != null) {
                            Iterable $this$map$iv = result;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                SearchResult it = (SearchResult) item$iv$iv;
                                destination$iv$iv.add(toSearchResponse(it));
                            }
                            newSearchResponseList$default = MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                            if (newSearchResponseList$default != null) {
                                return newSearchResponseList$default;
                            }
                        }
                        throw new ErrorLoadingException("Invalid Json reponse");
                    }
                    break;
                } else {
                    obj4 = null;
                }
                search = (Search) obj4;
                if (search != null && (result = search.getResult()) != null) {
                    Iterable $this$map$iv2 = result;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    while (r8.hasNext()) {
                        SearchResult it2 = (SearchResult) item$iv$iv;
                        destination$iv$iv.add(toSearchResponse(it2));
                    }
                    newSearchResponseList$default = MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                    if (newSearchResponseList$default != null) {
                        return newSearchResponseList$default;
                    }
                }
                throw new ErrorLoadingException("Invalid Json reponse");
            case 1:
                int page3 = c00081.I$0;
                String json3 = (String) c00081.L$1;
                String query3 = (String) c00081.L$0;
                ResultKt.throwOnFailure($result2);
                json = json3;
                query2 = query3;
                c = 1;
                c2 = 2;
                obj2 = $result2;
                page2 = page3;
                obj = coroutine_suspended;
                c00082 = c00081;
                $result = obj2;
                host = ((NiceResponse) obj2).getHeaders().get("location");
                if (host == null) {
                    host = getMainUrl() + '/';
                }
                MediaType mediaType2 = MediaType.Companion.get("application/json");
                RequestBody requestBody2 = RequestBody.Companion.create(json, mediaType2);
                Pair[] pairArr2 = new Pair[4];
                pairArr2[0] = TuplesKt.to("Accept", "*/*");
                pairArr2[c] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36");
                pairArr2[c2] = TuplesKt.to("Content-Type", "application/json");
                pairArr2[3] = TuplesKt.to("x-origin", "kickass-anime.ru");
                Map headers2 = MapsKt.mapOf(pairArr2);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(json);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(host);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(mediaType2);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(requestBody2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                c00082.I$0 = page2;
                c00082.label = 2;
                $result2 = Requests.post$default(MainActivityKt.getApp(), host + "api/fsearch", headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                res = ((NiceResponse) $result2).toString();
                AppUtils appUtils2 = AppUtils.INSTANCE;
                if (res != null) {
                    kotlin.Result.Companion companion5 = kotlin.Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(Search.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = kotlin.Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    if (kotlin.Result.exceptionOrNull-impl(obj3) != null) {
                        kotlin.Result.Companion companion6 = kotlin.Result.Companion;
                        obj3 = kotlin.Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Search.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (kotlin.Result.isFailure-impl(obj3)) {
                        obj5 = null;
                    } else {
                        obj5 = obj3;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, res);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(res, new TypeReference<Search>() { // from class: com.kickassanime.Kickassanime$search$$inlined$tryParseJson$1
                        });
                    }
                    obj4 = objDecodeFromString;
                    break;
                } else {
                    obj4 = null;
                }
                search = (Search) obj4;
                if (search != null) {
                    Iterable $this$map$iv3 = result;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    while (r8.hasNext()) {
                        SearchResult it3 = (SearchResult) item$iv$iv;
                        destination$iv$iv.add(toSearchResponse(it3));
                    }
                    newSearchResponseList$default = MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                    if (newSearchResponseList$default != null) {
                        return newSearchResponseList$default;
                    }
                }
                throw new ErrorLoadingException("Invalid Json reponse");
            case 2:
                int i = c00081.I$0;
                ResultKt.throwOnFailure($result2);
                $result = $result2;
                res = ((NiceResponse) $result2).toString();
                AppUtils appUtils3 = AppUtils.INSTANCE;
                if (res != null) {
                    kotlin.Result.Companion companion7 = kotlin.Result.Companion;
                    KType kTypeTypeOf3 = Reflection.typeOf(Search.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = kotlin.Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                    if (kotlin.Result.exceptionOrNull-impl(obj3) != null) {
                        kotlin.Result.Companion companion8 = kotlin.Result.Companion;
                        obj3 = kotlin.Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Search.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (kotlin.Result.isFailure-impl(obj3)) {
                        obj5 = null;
                    } else {
                        obj5 = obj3;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, res);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(res, new TypeReference<Search>() { // from class: com.kickassanime.Kickassanime$search$$inlined$tryParseJson$1
                        });
                    }
                    obj4 = objDecodeFromString;
                    break;
                } else {
                    obj4 = null;
                }
                search = (Search) obj4;
                if (search != null) {
                    Iterable $this$map$iv4 = result;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    while (r8.hasNext()) {
                        SearchResult it4 = (SearchResult) item$iv$iv;
                        destination$iv$iv.add(toSearchResponse(it4));
                    }
                    newSearchResponseList$default = MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
                    if (newSearchResponseList$default != null) {
                        return newSearchResponseList$default;
                    }
                }
                throw new ErrorLoadingException("Invalid Json reponse");
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResponse(final SearchResult $this$toSearchResponse) {
        TvType tvType;
        String titleEn = $this$toSearchResponse.getTitleEn();
        if (titleEn == null) {
            titleEn = $this$toSearchResponse.getTitle();
        }
        String title = titleEn;
        final String poster = KickassanimeUtilsKt.getImageUrl($this$toSearchResponse.getPoster().getHq());
        String href = getMainUrl() + '/' + $this$toSearchResponse.getSlug();
        String type = $this$toSearchResponse.getType();
        if (Intrinsics.areEqual(type, "movie")) {
            tvType = TvType.AnimeMovie;
        } else {
            tvType = Intrinsics.areEqual(type, "ova") ? TvType.OVA : TvType.Anime;
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, tvType, false, new Function1() { // from class: com.kickassanime.Kickassanime$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Kickassanime.toSearchResponse$lambda$1(poster, $this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$1(String $poster, SearchResult $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($poster);
        Iterable $this$any$iv = $this_toSearchResponse.getLocales();
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            for (Object element$iv : $this$any$iv) {
                String it = (String) element$iv;
                if (!Intrinsics.areEqual(it, "ja-JP")) {
                    z = true;
                    break;
                }
            }
        }
        boolean hasDub = z;
        boolean hasSub = $this_toSearchResponse.getLocales().contains("ja-JP");
        MainAPIKt.addDubStatus$default($this$newAnimeSearchResponse, hasDub, hasSub, (Integer) null, (Integer) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x038f  */
    /* JADX WARN: Code duplicated, block: B:101:0x039d  */
    /* JADX WARN: Code duplicated, block: B:103:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:104:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:105:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:108:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:109:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:112:0x03da  */
    /* JADX WARN: Code duplicated, block: B:115:0x03e5 A[PHI: r24
      0x03e5: PHI (r24v20 java.util.List) = (r24v19 java.util.List), (r24v21 java.util.List) binds: [B:113:0x03e2, B:110:0x03d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:116:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:118:0x03f8 A[PHI: r24
      0x03f8: PHI (r24v22 java.util.List) = (r24v18 java.util.List), (r24v19 java.util.List), (r24v21 java.util.List), (r24v23 java.util.List) binds: [B:117:0x03f6, B:113:0x03e2, B:110:0x03d7, B:106:0x03c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:120:0x0409  */
    /* JADX WARN: Code duplicated, block: B:122:0x0413  */
    /* JADX WARN: Code duplicated, block: B:123:0x0417  */
    /* JADX WARN: Code duplicated, block: B:124:0x0421  */
    /* JADX WARN: Code duplicated, block: B:127:0x0431  */
    /* JADX WARN: Code duplicated, block: B:128:0x0435  */
    /* JADX WARN: Code duplicated, block: B:131:0x0444  */
    /* JADX WARN: Code duplicated, block: B:132:0x0448  */
    /* JADX WARN: Code duplicated, block: B:135:0x0457  */
    /* JADX WARN: Code duplicated, block: B:138:0x0466  */
    /* JADX WARN: Code duplicated, block: B:139:0x0469  */
    /* JADX WARN: Code duplicated, block: B:142:0x0478  */
    /* JADX WARN: Code duplicated, block: B:143:0x047b  */
    /* JADX WARN: Code duplicated, block: B:146:0x048a  */
    /* JADX WARN: Code duplicated, block: B:147:0x048d  */
    /* JADX WARN: Code duplicated, block: B:150:0x049c A[PHI: r12 r24 r27
      0x049c: PHI (r12v19 java.lang.String) = (r12v15 java.lang.String), (r12v20 java.lang.String) binds: [B:148:0x0499, B:133:0x0454] A[DONT_GENERATE, DONT_INLINE]
      0x049c: PHI (r24v13 java.util.List) = (r24v9 java.util.List), (r24v14 java.util.List) binds: [B:148:0x0499, B:133:0x0454] A[DONT_GENERATE, DONT_INLINE]
      0x049c: PHI (r27v12 java.util.List<java.lang.String>) = (r27v8 java.util.List<java.lang.String>), (r27v13 java.util.List<java.lang.String>) binds: [B:148:0x0499, B:133:0x0454] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:151:0x049f A[PHI: r12 r24 r27
      0x049f: PHI (r12v42 java.lang.String) = 
      (r12v15 java.lang.String)
      (r12v16 java.lang.String)
      (r12v17 java.lang.String)
      (r12v18 java.lang.String)
      (r12v20 java.lang.String)
      (r12v21 java.lang.String)
      (r12v22 java.lang.String)
      (r12v23 java.lang.String)
      (r12v33 java.lang.String)
      (r12v39 java.lang.String)
      (r12v43 java.lang.String)
     binds: [B:148:0x0499, B:144:0x0487, B:140:0x0475, B:136:0x0463, B:133:0x0454, B:129:0x0441, B:125:0x042d, B:122:0x0413, B:118:0x03f8, B:103:0x03a3, B:96:0x0380] A[DONT_GENERATE, DONT_INLINE]
      0x049f: PHI (r24v34 java.util.List) = 
      (r24v9 java.util.List)
      (r24v10 java.util.List)
      (r24v11 java.util.List)
      (r24v12 java.util.List)
      (r24v14 java.util.List)
      (r24v15 java.util.List)
      (r24v16 java.util.List)
      (r24v17 java.util.List)
      (r24v22 java.util.List)
      (r24v27 java.util.List)
      (r24v35 java.util.List)
     binds: [B:148:0x0499, B:144:0x0487, B:140:0x0475, B:136:0x0463, B:133:0x0454, B:129:0x0441, B:125:0x042d, B:122:0x0413, B:118:0x03f8, B:103:0x03a3, B:96:0x0380] A[DONT_GENERATE, DONT_INLINE]
      0x049f: PHI (r27v31 java.util.List<java.lang.String>) = 
      (r27v8 java.util.List<java.lang.String>)
      (r27v9 java.util.List<java.lang.String>)
      (r27v10 java.util.List<java.lang.String>)
      (r27v11 java.util.List<java.lang.String>)
      (r27v13 java.util.List<java.lang.String>)
      (r27v14 java.util.List<java.lang.String>)
      (r27v15 java.util.List<java.lang.String>)
      (r27v19 java.util.List<java.lang.String>)
      (r27v22 java.util.List<java.lang.String>)
      (r27v25 java.util.List<java.lang.String>)
      (r27v32 java.util.List<java.lang.String>)
     binds: [B:148:0x0499, B:144:0x0487, B:140:0x0475, B:136:0x0463, B:133:0x0454, B:129:0x0441, B:125:0x042d, B:122:0x0413, B:118:0x03f8, B:103:0x03a3, B:96:0x0380] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:154:0x0547 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:155:0x0548  */
    /* JADX WARN: Code duplicated, block: B:158:0x058a  */
    /* JADX WARN: Code duplicated, block: B:167:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:169:0x071e  */
    /* JADX WARN: Code duplicated, block: B:170:0x0721  */
    /* JADX WARN: Code duplicated, block: B:174:0x0735  */
    /* JADX WARN: Code duplicated, block: B:176:0x075f  */
    /* JADX WARN: Code duplicated, block: B:178:0x076b  */
    /* JADX WARN: Code duplicated, block: B:182:0x0774  */
    /* JADX WARN: Code duplicated, block: B:184:0x0777  */
    /* JADX WARN: Code duplicated, block: B:185:0x078b  */
    /* JADX WARN: Code duplicated, block: B:188:0x0796  */
    /* JADX WARN: Code duplicated, block: B:189:0x07b4  */
    /* JADX WARN: Code duplicated, block: B:191:0x0807  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0323  */
    /* JADX WARN: Code duplicated, block: B:94:0x0361  */
    /* JADX WARN: Code duplicated, block: B:96:0x0380  */
    /* JADX WARN: Code duplicated, block: B:97:0x0388  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 23661. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:79)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x058a -> B:159:0x05cc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x069b -> B:165:0x06b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:167:0x06ff -> B:168:0x071c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r59, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r60) {
        /*
            Method dump skipped, instruction units count: 2366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kickassanime.Kickassanime.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$1$0(String $finalName, int $epNumber, Episoderesponse $epJson, Episode $this$newEpisode) {
        String it;
        $this$newEpisode.setName($finalName);
        $this$newEpisode.setEpisode(Integer.valueOf($epNumber));
        Thumbnail thumbnail = $epJson.getThumbnail();
        if (thumbnail != null && (it = thumbnail.getHq()) != null) {
            $this$newEpisode.setPosterUrl(KickassanimeUtilsKt.getThumbnailUrl(it));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$load$3 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime$load$3", f = "Kickassanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ String $poster;
        final /* synthetic */ ShowStatus $status;
        final /* synthetic */ List<Episode> $subEpisodes;
        final /* synthetic */ List<String> $tags;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, String str2, List<String> list, ShowStatus showStatus, List<Episode> list2, List<Episode> list3, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$tags = list;
            this.$status = showStatus;
            this.$subEpisodes = list2;
            this.$dubEpisodes = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$poster, this.$description, this.$tags, this.$status, this.$subEpisodes, this.$dubEpisodes, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnimeLoadResponse $this$newAnimeLoadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newAnimeLoadResponse.setPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setBackgroundPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setPlot(this.$description);
                    $this$newAnimeLoadResponse.setTags(this.$tags);
                    $this$newAnimeLoadResponse.setShowStatus(this.$status);
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, this.$subEpisodes);
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Dubbed, this.$dubEpisodes);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        Kickassanime kickassanime;
        Object obj;
        boolean z;
        Object obj2;
        int i;
        C00051 c00052;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        String lang;
        Object obj3;
        String parsedData;
        String lang2;
        Function1<? super ExtractorLink, Unit> function4;
        Object safe;
        ServersRes serversRes;
        List<Server> servers;
        Function1<? super ExtractorLink, Unit> function5;
        String data2;
        boolean isCasting3;
        Function1<? super SubtitleFile, Unit> function6;
        String parsedData2;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
                kickassanime = this;
            } else {
                kickassanime = this;
                c00051 = kickassanime.new C00051(continuation);
            }
        } else {
            kickassanime = this;
            c00051 = kickassanime.new C00051(continuation);
        }
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String parsedData3 = StringsKt.substringBefore$default(data, "?lang=", (String) null, 2, (Object) null);
                String it = StringsKt.substringAfter(data, "?lang=", "");
                String it2 = it.length() > 0 ? " [" + it + ']' : "";
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00051.L$1 = function1;
                c00051.L$2 = function2;
                c00051.L$3 = SpillingKt.nullOutSpilledVariable(parsedData3);
                c00051.L$4 = it2;
                c00051.Z$0 = isCasting;
                c00051.label = 1;
                obj = null;
                z = true;
                C00051 c00053 = c00051;
                obj2 = coroutine_suspended;
                i = 2;
                Object obj4 = Requests.get$default(app, parsedData3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 4094, (Object) null);
                c00052 = c00053;
                if (obj4 == obj2) {
                    return obj2;
                }
                isCasting2 = isCasting;
                function3 = function1;
                lang = data;
                obj3 = obj4;
                parsedData = parsedData3;
                lang2 = it2;
                function4 = function2;
                NiceResponse this_$iv = (NiceResponse) obj3;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ServersRes.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = obj;
                }
                serversRes = (ServersRes) safe;
                if (serversRes == null && (servers = serversRes.getServers()) != null) {
                    C00062 c00062 = kickassanime.new C00062(function4, lang2, function3, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(lang);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsedData);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(lang2);
                    c00052.Z$0 = isCasting2;
                    c00052.label = i;
                    $result = ParCollectionsKt.amap(servers, c00062, c00052);
                    if ($result == obj2) {
                        return obj2;
                    }
                    function5 = function4;
                    data2 = lang;
                    isCasting3 = isCasting2;
                    function6 = function3;
                    parsedData2 = parsedData;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting4 = c00051.Z$0;
                String lang3 = (String) c00051.L$4;
                String parsedData4 = (String) c00051.L$3;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00051.L$2;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00051.L$1;
                String data3 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                obj = null;
                function3 = function8;
                i = 2;
                z = true;
                c00052 = c00051;
                obj2 = coroutine_suspended;
                function4 = function7;
                parsedData = parsedData4;
                isCasting2 = isCasting4;
                lang2 = lang3;
                lang = data3;
                obj3 = $result;
                NiceResponse this_$iv2 = (NiceResponse) obj3;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ServersRes.class));
                serversRes = (ServersRes) safe;
                if (serversRes == null) {
                    break;
                }
                return Boxing.boxBoolean(z);
            case 2:
                isCasting3 = c00051.Z$0;
                parsedData2 = (String) c00051.L$3;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00051.L$2;
                function6 = (Function1) c00051.L$1;
                data2 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                function5 = function9;
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2 */
    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/kickassanime/Kickassanime$Server;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2", f = "Kickassanime.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {231, 250, 266, 288, 300, 319, 331, 352, 374, 386, 407}, m = "invokeSuspend", n = {"it", "host", "headers", "key", "query", "it", "host", "headers", "key", "query", "html", "match", "videoheaders", "url", "m3u8Url", "it", "host", "headers", "key", "query", "html", "sig", "timeStamp", "route", "sourceurl", "it", "host", "headers", "key", "query", "html", "sig", "timeStamp", "route", "sourceurl", "encjson", "encryptedData", "ivhex", "iv", "decrypted", "m3u8", "videoheaders", "it", "host", "headers", "key", "query", "html", "sig", "timeStamp", "route", "sourceurl", "encjson", "encryptedData", "ivhex", "iv", "decrypted", "m3u8", "videoheaders", "it", "baseurl", "headers", "it", "baseurl", "headers", "res", "regex", "match", "encodedJson", "unescapedJson", "json", "videoUrl", "it", "baseurl", "headers", "res", "regex", "match", "encodedJson", "unescapedJson", "json", "videoUrl", "subtitleArray", "sub", "src", "name", "i", "it", "baseurl", "headers", "it", "baseurl", "headers", "res", "regex", "match", "encodedJson", "unescapedJson", "json", "videoUrl", "it", "baseurl", "headers", "res", "regex", "match", "encodedJson", "unescapedJson", "json", "videoUrl", "subtitleArray", "sub", "src", "name", "i"}, nl = {234, 249, 665, 287, 310, 321, 330, 351, 376, 385, 406}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nKickassanime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kickassanime.kt\ncom/kickassanime/Kickassanime$loadLinks$2\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,664:1\n73#2,5:665\n93#3,2:670\n63#3:672\n64#3,15:674\n95#3,2:691\n1#4:673\n50#5:689\n43#5:690\n*S KotlinDebug\n*F\n+ 1 Kickassanime.kt\ncom/kickassanime/Kickassanime$loadLinks$2\n*L\n266#1:665,5\n275#1:670,2\n275#1:672\n275#1:674,15\n275#1:691,2\n275#1:673\n275#1:689\n275#1:690\n*E\n"})
    static final class C00062 extends SuspendLambda implements Function2<Server, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $lang;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        int I$1;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super ExtractorLink, Unit> function1, String str, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$lang = str;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = Kickassanime.this.new C00062(this.$callback, this.$lang, this.$subtitleCallback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(Server server, Continuation<? super Unit> continuation) {
            return create(server, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:150:0x0a03  */
        /* JADX WARN: Code duplicated, block: B:152:0x0a97 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:153:0x0a98  */
        /* JADX WARN: Type inference failed for: r0v88, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r0v92, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v24, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v40, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r7v42 */
        /* JADX WARN: Type inference failed for: r7v48 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x0a98 -> B:154:0x0a9f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x0cb1 -> B:180:0x0cc2). Please report as a decompilation issue!!! */
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
        public final java.lang.Object invokeSuspend(java.lang.Object r67) {
            /*
                Method dump skipped, instruction units count: 3346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kickassanime.Kickassanime.C00062.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: Kickassanime.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2$2", f = "Kickassanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ Map<String, String> $videoheaders;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Map<String, String> map, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$videoheaders = map;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$videoheaders, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                        $this$newExtractorLink.setHeaders(this.$videoheaders);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: Kickassanime.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/kickassanime/Kickassanime$Subtitle;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2$3", f = "Kickassanime.kt", i = {0}, l = {302}, m = "invokeSuspend", n = {"it"}, nl = {301}, s = {"L$0"}, v = 2)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<Subtitle, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Function1<? super SubtitleFile, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$subtitleCallback = function1;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.$subtitleCallback, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            public final Object invoke(Subtitle subtitle, Continuation<? super Unit> continuation) {
                return create(subtitle, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object objNewSubtitleFile$default;
                Function1<SubtitleFile, Unit> function1;
                Subtitle it = (Subtitle) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Function1<SubtitleFile, Unit> function2 = this.$subtitleCallback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = function2;
                        this.label = 1;
                        objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(it.getName(), it.getSrc(), (Function2) null, (Continuation) this, 4, (Object) null);
                        if (objNewSubtitleFile$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function2;
                        break;
                        break;
                    case 1:
                        function1 = (Function1) this.L$1;
                        ResultKt.throwOnFailure($result);
                        objNewSubtitleFile$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1.invoke(objNewSubtitleFile$default);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: Kickassanime.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2$4", f = "Kickassanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $baseurl;
            final /* synthetic */ Map<String, String> $headers;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(String str, Map<String, String> map, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$baseurl = str;
                this.$headers = map;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass4 = new AnonymousClass4(this.$baseurl, this.$headers, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer(this.$baseurl);
                        $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                        $this$newExtractorLink.setHeaders(this.$headers);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: Kickassanime.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SubtitleFile;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2$5", f = "Kickassanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass5 extends SuspendLambda implements Function2<SubtitleFile, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $baseurl;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(String str, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$baseurl = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass5 = new AnonymousClass5(this.$baseurl, continuation);
                anonymousClass5.L$0 = obj;
                return anonymousClass5;
            }

            public final Object invoke(SubtitleFile subtitleFile, Continuation<? super Unit> continuation) {
                return create(subtitleFile, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                SubtitleFile $this$newSubtitleFile = (SubtitleFile) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newSubtitleFile.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.$baseurl)));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: Kickassanime.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2$6", f = "Kickassanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass6 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $baseurl;
            final /* synthetic */ Map<String, String> $headers;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(String str, Map<String, String> map, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$baseurl = str;
                this.$headers = map;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass6 = new AnonymousClass6(this.$baseurl, this.$headers, continuation);
                anonymousClass6.L$0 = obj;
                return anonymousClass6;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer(this.$baseurl);
                        $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                        $this$newExtractorLink.setHeaders(this.$headers);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX INFO: renamed from: com.kickassanime.Kickassanime$loadLinks$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: Kickassanime.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SubtitleFile;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.kickassanime.Kickassanime$loadLinks$2$7", f = "Kickassanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass7 extends SuspendLambda implements Function2<SubtitleFile, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $baseurl;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(String str, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$baseurl = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass7 = new AnonymousClass7(this.$baseurl, continuation);
                anonymousClass7.L$0 = obj;
                return anonymousClass7;
            }

            public final Object invoke(SubtitleFile subtitleFile, Continuation<? super Unit> continuation) {
                return create(subtitleFile, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                SubtitleFile $this$newSubtitleFile = (SubtitleFile) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newSubtitleFile.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.$baseurl)));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x01b1 A[PHI: r0 r18 r24 r26 r27
      0x01b1: PHI (r0v6 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder) = 
      (r0v5 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v7 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
     binds: [B:46:0x01af, B:42:0x0190] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r18v10 'order' java.util.List) = (r18v9 'order' java.util.List), (r18v11 'order' java.util.List) binds: [B:46:0x01af, B:42:0x0190] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r24v6 'document' org.jsoup.nodes.Document) = (r24v5 'document' org.jsoup.nodes.Document), (r24v7 'document' org.jsoup.nodes.Document) binds: [B:46:0x01af, B:42:0x0190] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r26v5 java.lang.String) = (r26v4 java.lang.String), (r26v6 java.lang.String) binds: [B:46:0x01af, B:42:0x0190] A[DONT_GENERATE, DONT_INLINE]
      0x01b1: PHI (r27v4 'cidRaw' byte[]) = (r27v3 'cidRaw' byte[]), (r27v5 'cidRaw' byte[]) binds: [B:46:0x01af, B:42:0x0190] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0221 A[PHI: r0 r18 r24 r26 r27
      0x0221: PHI (r0v13 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder) = 
      (r0v2 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v3 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v4 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v6 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v8 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v10 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v14 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
     binds: [B:61:0x021a, B:54:0x01f5, B:50:0x01d5, B:47:0x01b1, B:39:0x0158, B:35:0x0129, B:32:0x0113] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r18v17 'order' java.util.List) = 
      (r18v6 'order' java.util.List)
      (r18v7 'order' java.util.List)
      (r18v8 'order' java.util.List)
      (r18v10 'order' java.util.List)
      (r18v12 'order' java.util.List)
      (r18v14 'order' java.util.List)
      (r18v18 'order' java.util.List)
     binds: [B:61:0x021a, B:54:0x01f5, B:50:0x01d5, B:47:0x01b1, B:39:0x0158, B:35:0x0129, B:32:0x0113] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r24v13 'document' org.jsoup.nodes.Document) = 
      (r24v2 'document' org.jsoup.nodes.Document)
      (r24v3 'document' org.jsoup.nodes.Document)
      (r24v4 'document' org.jsoup.nodes.Document)
      (r24v6 'document' org.jsoup.nodes.Document)
      (r24v9 'document' org.jsoup.nodes.Document)
      (r24v11 'document' org.jsoup.nodes.Document)
      (r24v14 'document' org.jsoup.nodes.Document)
     binds: [B:61:0x021a, B:54:0x01f5, B:50:0x01d5, B:47:0x01b1, B:39:0x0158, B:35:0x0129, B:32:0x0113] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r26v13 java.lang.String) = 
      (r26v1 java.lang.String)
      (r26v2 java.lang.String)
      (r26v3 java.lang.String)
      (r26v5 java.lang.String)
      (r26v8 java.lang.String)
      (r26v11 java.lang.String)
      (r26v14 java.lang.String)
     binds: [B:61:0x021a, B:54:0x01f5, B:50:0x01d5, B:47:0x01b1, B:39:0x0158, B:35:0x0129, B:32:0x0113] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r27v11 'cidRaw' byte[]) = 
      (r27v0 'cidRaw' byte[])
      (r27v1 'cidRaw' byte[])
      (r27v2 'cidRaw' byte[])
      (r27v4 'cidRaw' byte[])
      (r27v7 'cidRaw' byte[])
      (r27v9 'cidRaw' byte[])
      (r27v12 'cidRaw' byte[])
     binds: [B:61:0x021a, B:54:0x01f5, B:50:0x01d5, B:47:0x01b1, B:39:0x0158, B:35:0x0129, B:32:0x0113] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        if (r30.equals("DuckStream") == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        r3 = kotlin.collections.CollectionsKt.listOf(new java.lang.String[]{"IP", "USERAGENT", "ROUTE", "MID", "TIMESTAMP", "KEY"});
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
    
        if (r30.equals("VidStreaming") != false) goto L16;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Triple<String, String, String> getSignature(String html, String server, String query, byte[] key) {
        String strHtml;
        String strSubstringAfter$default;
        String strSubstringBefore$default;
        String str;
        Document document;
        byte[] cidRaw;
        StringBuilder $this$getSignature_u24lambda_u240;
        List order;
        Map headers = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"));
        String str2 = "ROUTE";
        switch (server.hashCode()) {
            case -2091769415:
                break;
            case 1265634745:
                if (server.equals("BirdStream")) {
                    List order2 = CollectionsKt.listOf(new String[]{"IP", "USERAGENT", "ROUTE", "MID", "KEY"});
                    Document document2 = Jsoup.parse(html);
                    Element element = (Element) CollectionsKt.firstOrNull(document2.select("script:containsData(cid:)"));
                    if (element == null || (strHtml = element.html()) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(strHtml, "cid: '", (String) null, 2, (Object) null)) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringAfter$default, "'", (String) null, 2, (Object) null)) == null) {
                        return null;
                    }
                    byte[] cidRaw2 = CryptoAES.INSTANCE.decodeHex(strSubstringBefore$default);
                    if (cidRaw2 == null) {
                        return null;
                    }
                    List cid = StringsKt.split$default(new String(cidRaw2, Charsets.UTF_8), new String[]{"|"}, false, 0, 6, (Object) null);
                    String timeStamp = String.valueOf((System.currentTimeMillis() / 1000) + 60);
                    String route = StringsKt.replace$default((String) cid.get(1), "player.php", "source.php", false, 4, (Object) null);
                    StringBuilder sb = new StringBuilder();
                    StringBuilder $this$getSignature_u24lambda_u241 = sb;
                    List $this$forEach$iv = order2;
                    for (Object element$iv : $this$forEach$iv) {
                        String it = (String) element$iv;
                        switch (it.hashCode()) {
                            case -1453246218:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("TIMESTAMP")) {
                                    $this$getSignature_u24lambda_u240.append(timeStamp);
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                }
                                break;
                            case -1167389190:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("USERAGENT")) {
                                    String str3 = (String) headers.get("User-Agent");
                                    if (str3 == null) {
                                        str3 = "";
                                    }
                                    $this$getSignature_u24lambda_u240.append(str3);
                                } else {
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                break;
                            case 2343:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("IP")) {
                                    $this$getSignature_u24lambda_u240.append((String) cid.get(0));
                                } else {
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                break;
                            case 74303:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("KEY")) {
                                    $this$getSignature_u24lambda_u240.append(new String(key, Charsets.UTF_8));
                                } else {
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                break;
                            case 76328:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("MID")) {
                                    $this$getSignature_u24lambda_u240.append(query);
                                } else {
                                    Unit unit5 = Unit.INSTANCE;
                                }
                                break;
                            case 82097:
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("SIG")) {
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                    $this$getSignature_u24lambda_u240.append(StringsKt.substringBefore$default(StringsKt.substringAfter$default(html, "signature: '", (String) null, 2, (Object) null), "'", (String) null, 2, (Object) null));
                                } else {
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                    Unit unit6 = Unit.INSTANCE;
                                }
                                break;
                            case 78166569:
                                if (it.equals(str2)) {
                                    $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                    $this$getSignature_u24lambda_u240.append(route);
                                    order = order2;
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                } else {
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                    $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                    order = order2;
                                    Unit unit7 = Unit.INSTANCE;
                                }
                                break;
                            default:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                Unit unit8 = Unit.INSTANCE;
                                break;
                        }
                        order2 = order;
                        document2 = document;
                        str2 = str;
                        cidRaw2 = cidRaw;
                        $this$getSignature_u24lambda_u241 = $this$getSignature_u24lambda_u240;
                    }
                    return new Triple<>(sha1sum(sb.toString()), timeStamp, route);
                }
                return null;
            case 2026719089:
                break;
            default:
                return null;
        }
    }

    private final String sha1sum(String value) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = value.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = md.digest(bytes);
            return ArraysKt.joinToString$default(bytes2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.kickassanime.Kickassanime$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return Kickassanime.sha1sum$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (Exception e) {
            throw new Exception("Attempt to create the signature failed miserably.");
        }
    }

    static final CharSequence sha1sum$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/kickassanime/Kickassanime$Search;", "", "result", "", "Lcom/kickassanime/Kickassanime$SearchResult;", "maxPage", "", "<init>", "(Ljava/util/List;J)V", "getResult", "()Ljava/util/List;", "getMaxPage", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Search {
        private final long maxPage;

        @NotNull
        private final List<SearchResult> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Search copy$default(Search search, List list, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                list = search.result;
            }
            if ((i & 2) != 0) {
                j = search.maxPage;
            }
            return search.copy(list, j);
        }

        @NotNull
        public final List<SearchResult> component1() {
            return this.result;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getMaxPage() {
            return this.maxPage;
        }

        @NotNull
        public final Search copy(@NotNull List<SearchResult> result, long maxPage) {
            return new Search(result, maxPage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Search)) {
                return false;
            }
            Search search = (Search) other;
            return Intrinsics.areEqual(this.result, search.result) && this.maxPage == search.maxPage;
        }

        public int hashCode() {
            return (this.result.hashCode() * 31) + Kickassanime$Search$$ExternalSyntheticBackport0.m4m(this.maxPage);
        }

        @NotNull
        public String toString() {
            return "Search(result=" + this.result + ", maxPage=" + this.maxPage + ')';
        }

        public Search(@NotNull List<SearchResult> list, long maxPage) {
            this.result = list;
            this.maxPage = maxPage;
        }

        @NotNull
        public final List<SearchResult> getResult() {
            return this.result;
        }

        public final long getMaxPage() {
            return this.maxPage;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bó\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0016\b\u0001\u0010\u0015\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0018\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0014HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003J\u008c\u0002\u0010C\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0003\u0010\u0015\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001cHÆ\u0001¢\u0006\u0002\u0010DJ\u0014\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010H\u001a\u00020IHÖ\u0081\u0004J\n\u0010J\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%¨\u0006K"}, d2 = {"Lcom/kickassanime/Kickassanime$SearchResult;", "", "episodeCount", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "episode_count", "genres", "", "", "locales", "slug", "status", "synopsis", "title", "titleEn", "title_en", "type", "year", "poster", "Lcom/kickassanime/Kickassanime$SearchPoster;", "episodeDuration", "episode_duration", "watchUri", "watch_uri", "episodeNumber", "episode_number", "episodeString", "episode_string", "<init>", "(JLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/kickassanime/Kickassanime$SearchPoster;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getEpisodeCount", "()J", "getGenres", "()Ljava/util/List;", "getLocales", "getSlug", "()Ljava/lang/String;", "getStatus", "getSynopsis", "getTitle", "getTitleEn", "getType", "getYear", "getPoster", "()Lcom/kickassanime/Kickassanime$SearchPoster;", "getEpisodeDuration", "getWatchUri", "getEpisodeNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEpisodeString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(JLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/kickassanime/Kickassanime$SearchPoster;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/kickassanime/Kickassanime$SearchResult;", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SearchResult {
        private final long episodeCount;
        private final long episodeDuration;

        @Nullable
        private final Long episodeNumber;

        @Nullable
        private final String episodeString;

        @NotNull
        private final List<String> genres;

        @NotNull
        private final List<String> locales;

        @NotNull
        private final SearchPoster poster;

        @NotNull
        private final String slug;

        @NotNull
        private final String status;

        @NotNull
        private final String synopsis;

        @NotNull
        private final String title;

        @Nullable
        private final String titleEn;

        @NotNull
        private final String type;

        @Nullable
        private final String watchUri;
        private final long year;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getEpisodeCount() {
            return this.episodeCount;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final long getYear() {
            return this.year;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final SearchPoster getPoster() {
            return this.poster;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final long getEpisodeDuration() {
            return this.episodeDuration;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getWatchUri() {
            return this.watchUri;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Long getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getEpisodeString() {
            return this.episodeString;
        }

        @NotNull
        public final List<String> component2() {
            return this.genres;
        }

        @NotNull
        public final List<String> component3() {
            return this.locales;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSynopsis() {
            return this.synopsis;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTitleEn() {
            return this.titleEn;
        }

        @NotNull
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final SearchResult copy(@JsonProperty("episode_count") long episodeCount, @NotNull List<String> genres, @NotNull List<String> locales, @NotNull String slug, @NotNull String status, @NotNull String synopsis, @NotNull String title, @JsonProperty("title_en") @Nullable String titleEn, @NotNull String type, long year, @NotNull SearchPoster poster, @JsonProperty("episode_duration") long episodeDuration, @JsonProperty("watch_uri") @Nullable String watchUri, @JsonProperty("episode_number") @Nullable Long episodeNumber, @JsonProperty("episode_string") @Nullable String episodeString) {
            return new SearchResult(episodeCount, genres, locales, slug, status, synopsis, title, titleEn, type, year, poster, episodeDuration, watchUri, episodeNumber, episodeString);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchResult)) {
                return false;
            }
            SearchResult searchResult = (SearchResult) other;
            return this.episodeCount == searchResult.episodeCount && Intrinsics.areEqual(this.genres, searchResult.genres) && Intrinsics.areEqual(this.locales, searchResult.locales) && Intrinsics.areEqual(this.slug, searchResult.slug) && Intrinsics.areEqual(this.status, searchResult.status) && Intrinsics.areEqual(this.synopsis, searchResult.synopsis) && Intrinsics.areEqual(this.title, searchResult.title) && Intrinsics.areEqual(this.titleEn, searchResult.titleEn) && Intrinsics.areEqual(this.type, searchResult.type) && this.year == searchResult.year && Intrinsics.areEqual(this.poster, searchResult.poster) && this.episodeDuration == searchResult.episodeDuration && Intrinsics.areEqual(this.watchUri, searchResult.watchUri) && Intrinsics.areEqual(this.episodeNumber, searchResult.episodeNumber) && Intrinsics.areEqual(this.episodeString, searchResult.episodeString);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((Kickassanime$SearchResult$$ExternalSyntheticBackport0.m6m(this.episodeCount) * 31) + this.genres.hashCode()) * 31) + this.locales.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.status.hashCode()) * 31) + this.synopsis.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.titleEn == null ? 0 : this.titleEn.hashCode())) * 31) + this.type.hashCode()) * 31) + Kickassanime$SearchResult$$ExternalSyntheticBackport0.m6m(this.year)) * 31) + this.poster.hashCode()) * 31) + Kickassanime$SearchResult$$ExternalSyntheticBackport0.m6m(this.episodeDuration)) * 31) + (this.watchUri == null ? 0 : this.watchUri.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.episodeString != null ? this.episodeString.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchResult(episodeCount=").append(this.episodeCount).append(", genres=").append(this.genres).append(", locales=").append(this.locales).append(", slug=").append(this.slug).append(", status=").append(this.status).append(", synopsis=").append(this.synopsis).append(", title=").append(this.title).append(", titleEn=").append(this.titleEn).append(", type=").append(this.type).append(", year=").append(this.year).append(", poster=").append(this.poster).append(", episodeDuration=");
            sb.append(this.episodeDuration).append(", watchUri=").append(this.watchUri).append(", episodeNumber=").append(this.episodeNumber).append(", episodeString=").append(this.episodeString).append(')');
            return sb.toString();
        }

        public SearchResult(@JsonProperty("episode_count") long episodeCount, @NotNull List<String> list, @NotNull List<String> list2, @NotNull String slug, @NotNull String status, @NotNull String synopsis, @NotNull String title, @JsonProperty("title_en") @Nullable String titleEn, @NotNull String type, long year, @NotNull SearchPoster poster, @JsonProperty("episode_duration") long episodeDuration, @JsonProperty("watch_uri") @Nullable String watchUri, @JsonProperty("episode_number") @Nullable Long episodeNumber, @JsonProperty("episode_string") @Nullable String episodeString) {
            this.episodeCount = episodeCount;
            this.genres = list;
            this.locales = list2;
            this.slug = slug;
            this.status = status;
            this.synopsis = synopsis;
            this.title = title;
            this.titleEn = titleEn;
            this.type = type;
            this.year = year;
            this.poster = poster;
            this.episodeDuration = episodeDuration;
            this.watchUri = watchUri;
            this.episodeNumber = episodeNumber;
            this.episodeString = episodeString;
        }

        public final long getEpisodeCount() {
            return this.episodeCount;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        @NotNull
        public final List<String> getLocales() {
            return this.locales;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final String getSynopsis() {
            return this.synopsis;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitleEn() {
            return this.titleEn;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public final long getYear() {
            return this.year;
        }

        @NotNull
        public final SearchPoster getPoster() {
            return this.poster;
        }

        public final long getEpisodeDuration() {
            return this.episodeDuration;
        }

        @Nullable
        public final String getWatchUri() {
            return this.watchUri;
        }

        @Nullable
        public final Long getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        public final String getEpisodeString() {
            return this.episodeString;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/kickassanime/Kickassanime$SearchPoster;", "", "formats", "", "", "sm", "aspectRatio", "", "hq", "<init>", "(Ljava/util/List;Ljava/lang/String;DLjava/lang/String;)V", "getFormats", "()Ljava/util/List;", "getSm", "()Ljava/lang/String;", "getAspectRatio", "()D", "getHq", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SearchPoster {
        private final double aspectRatio;

        @NotNull
        private final List<String> formats;

        @NotNull
        private final String hq;

        @NotNull
        private final String sm;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchPoster copy$default(SearchPoster searchPoster, List list, String str, double d, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchPoster.formats;
            }
            if ((i & 2) != 0) {
                str = searchPoster.sm;
            }
            if ((i & 4) != 0) {
                d = searchPoster.aspectRatio;
            }
            if ((i & 8) != 0) {
                str2 = searchPoster.hq;
            }
            String str3 = str2;
            return searchPoster.copy(list, str, d, str3);
        }

        @NotNull
        public final List<String> component1() {
            return this.formats;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSm() {
            return this.sm;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getHq() {
            return this.hq;
        }

        @NotNull
        public final SearchPoster copy(@NotNull List<String> formats, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            return new SearchPoster(formats, sm, aspectRatio, hq);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchPoster)) {
                return false;
            }
            SearchPoster searchPoster = (SearchPoster) other;
            return Intrinsics.areEqual(this.formats, searchPoster.formats) && Intrinsics.areEqual(this.sm, searchPoster.sm) && Double.compare(this.aspectRatio, searchPoster.aspectRatio) == 0 && Intrinsics.areEqual(this.hq, searchPoster.hq);
        }

        public int hashCode() {
            return (((((this.formats.hashCode() * 31) + this.sm.hashCode()) * 31) + Kickassanime$SearchPoster$$ExternalSyntheticBackport0.m5m(this.aspectRatio)) * 31) + this.hq.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchPoster(formats=" + this.formats + ", sm=" + this.sm + ", aspectRatio=" + this.aspectRatio + ", hq=" + this.hq + ')';
        }

        public SearchPoster(@NotNull List<String> list, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            this.formats = list;
            this.sm = sm;
            this.aspectRatio = aspectRatio;
            this.hq = hq;
        }

        @NotNull
        public final List<String> getFormats() {
            return this.formats;
        }

        @NotNull
        public final String getSm() {
            return this.sm;
        }

        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        public final String getHq() {
            return this.hq;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/kickassanime/Kickassanime$ResponseHome;", "", "pageCount", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "page_count", "result", "", "Lcom/kickassanime/Kickassanime$Result;", "<init>", "(JLjava/util/List;)V", "getPageCount", "()J", "getResult", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResponseHome {
        private final long pageCount;

        @NotNull
        private final List<Result> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResponseHome copy$default(ResponseHome responseHome, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = responseHome.pageCount;
            }
            if ((i & 2) != 0) {
                list = responseHome.result;
            }
            return responseHome.copy(j, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPageCount() {
            return this.pageCount;
        }

        @NotNull
        public final List<Result> component2() {
            return this.result;
        }

        @NotNull
        public final ResponseHome copy(@JsonProperty("page_count") long pageCount, @NotNull List<Result> result) {
            return new ResponseHome(pageCount, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseHome)) {
                return false;
            }
            ResponseHome responseHome = (ResponseHome) other;
            return this.pageCount == responseHome.pageCount && Intrinsics.areEqual(this.result, responseHome.result);
        }

        public int hashCode() {
            return (Kickassanime$ResponseHome$$ExternalSyntheticBackport0.m3m(this.pageCount) * 31) + this.result.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResponseHome(pageCount=" + this.pageCount + ", result=" + this.result + ')';
        }

        public ResponseHome(@JsonProperty("page_count") long pageCount, @NotNull List<Result> list) {
            this.pageCount = pageCount;
            this.result = list;
        }

        public final long getPageCount() {
            return this.pageCount;
        }

        @NotNull
        public final List<Result> getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u0010.\u001a\u00020\u0010HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0003J\u009e\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00102J\u0014\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u000207HÖ\u0081\u0004J\n\u00108\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$¨\u00069"}, d2 = {"Lcom/kickassanime/Kickassanime$Result;", "", "title", "", "titleEn", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title_en", "synopsis", "status", "type", "slug", "rating", "year", "", "poster", "Lcom/kickassanime/Kickassanime$Poster;", "genres", "", "locales", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/kickassanime/Kickassanime$Poster;Ljava/util/List;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getTitleEn", "getSynopsis", "getStatus", "getType", "getSlug", "getRating", "getYear", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPoster", "()Lcom/kickassanime/Kickassanime$Poster;", "getGenres", "()Ljava/util/List;", "getLocales", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/kickassanime/Kickassanime$Poster;Ljava/util/List;Ljava/util/List;)Lcom/kickassanime/Kickassanime$Result;", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Result {

        @NotNull
        private final List<String> genres;

        @Nullable
        private final List<String> locales;

        @NotNull
        private final Poster poster;

        @Nullable
        private final String rating;

        @NotNull
        private final String slug;

        @NotNull
        private final String status;

        @NotNull
        private final String synopsis;

        @NotNull
        private final String title;

        @Nullable
        private final String titleEn;

        @NotNull
        private final String type;

        @Nullable
        private final Long year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l, Poster poster, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.title;
            }
            if ((i & 2) != 0) {
                str2 = result.titleEn;
            }
            if ((i & 4) != 0) {
                str3 = result.synopsis;
            }
            if ((i & 8) != 0) {
                str4 = result.status;
            }
            if ((i & 16) != 0) {
                str5 = result.type;
            }
            if ((i & 32) != 0) {
                str6 = result.slug;
            }
            if ((i & 64) != 0) {
                str7 = result.rating;
            }
            if ((i & 128) != 0) {
                l = result.year;
            }
            if ((i & 256) != 0) {
                poster = result.poster;
            }
            if ((i & 512) != 0) {
                list = result.genres;
            }
            if ((i & 1024) != 0) {
                list2 = result.locales;
            }
            List list3 = list;
            List list4 = list2;
            Long l2 = l;
            Poster poster2 = poster;
            String str8 = str6;
            String str9 = str7;
            String str10 = str5;
            String str11 = str3;
            return result.copy(str, str2, str11, str4, str10, str8, str9, l2, poster2, list3, list4);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final List<String> component10() {
            return this.genres;
        }

        @Nullable
        public final List<String> component11() {
            return this.locales;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitleEn() {
            return this.titleEn;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSynopsis() {
            return this.synopsis;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getYear() {
            return this.year;
        }

        @NotNull
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Poster getPoster() {
            return this.poster;
        }

        @NotNull
        public final Result copy(@NotNull String title, @JsonProperty("title_en") @Nullable String titleEn, @NotNull String synopsis, @NotNull String status, @NotNull String type, @NotNull String slug, @Nullable String rating, @Nullable Long year, @NotNull Poster poster, @NotNull List<String> genres, @Nullable List<String> locales) {
            return new Result(title, titleEn, synopsis, status, type, slug, rating, year, poster, genres, locales);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.title, result.title) && Intrinsics.areEqual(this.titleEn, result.titleEn) && Intrinsics.areEqual(this.synopsis, result.synopsis) && Intrinsics.areEqual(this.status, result.status) && Intrinsics.areEqual(this.type, result.type) && Intrinsics.areEqual(this.slug, result.slug) && Intrinsics.areEqual(this.rating, result.rating) && Intrinsics.areEqual(this.year, result.year) && Intrinsics.areEqual(this.poster, result.poster) && Intrinsics.areEqual(this.genres, result.genres) && Intrinsics.areEqual(this.locales, result.locales);
        }

        public int hashCode() {
            return (((((((((((((((((((this.title.hashCode() * 31) + (this.titleEn == null ? 0 : this.titleEn.hashCode())) * 31) + this.synopsis.hashCode()) * 31) + this.status.hashCode()) * 31) + this.type.hashCode()) * 31) + this.slug.hashCode()) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + this.poster.hashCode()) * 31) + this.genres.hashCode()) * 31) + (this.locales != null ? this.locales.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Result(title=").append(this.title).append(", titleEn=").append(this.titleEn).append(", synopsis=").append(this.synopsis).append(", status=").append(this.status).append(", type=").append(this.type).append(", slug=").append(this.slug).append(", rating=").append(this.rating).append(", year=").append(this.year).append(", poster=").append(this.poster).append(", genres=").append(this.genres).append(", locales=").append(this.locales).append(')');
            return sb.toString();
        }

        public Result(@NotNull String title, @JsonProperty("title_en") @Nullable String titleEn, @NotNull String synopsis, @NotNull String status, @NotNull String type, @NotNull String slug, @Nullable String rating, @Nullable Long year, @NotNull Poster poster, @NotNull List<String> list, @Nullable List<String> list2) {
            this.title = title;
            this.titleEn = titleEn;
            this.synopsis = synopsis;
            this.status = status;
            this.type = type;
            this.slug = slug;
            this.rating = rating;
            this.year = year;
            this.poster = poster;
            this.genres = list;
            this.locales = list2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Result(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l, Poster poster, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            List list3;
            if ((i & 1024) == 0) {
                list3 = list2;
            } else {
                list3 = null;
            }
            this(str, str2, str3, str4, str5, str6, str7, l, poster, list, list3);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitleEn() {
            return this.titleEn;
        }

        @NotNull
        public final String getSynopsis() {
            return this.synopsis;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        public final Long getYear() {
            return this.year;
        }

        @NotNull
        public final Poster getPoster() {
            return this.poster;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final List<String> getLocales() {
            return this.locales;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/kickassanime/Kickassanime$Poster;", "", "formats", "", "", "sm", "aspectRatio", "", "hq", "<init>", "(Ljava/util/List;Ljava/lang/String;DLjava/lang/String;)V", "getFormats", "()Ljava/util/List;", "getSm", "()Ljava/lang/String;", "getAspectRatio", "()D", "getHq", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Poster {
        private final double aspectRatio;

        @NotNull
        private final List<String> formats;

        @NotNull
        private final String hq;

        @NotNull
        private final String sm;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Poster copy$default(Poster poster, List list, String str, double d, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = poster.formats;
            }
            if ((i & 2) != 0) {
                str = poster.sm;
            }
            if ((i & 4) != 0) {
                d = poster.aspectRatio;
            }
            if ((i & 8) != 0) {
                str2 = poster.hq;
            }
            String str3 = str2;
            return poster.copy(list, str, d, str3);
        }

        @NotNull
        public final List<String> component1() {
            return this.formats;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSm() {
            return this.sm;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getHq() {
            return this.hq;
        }

        @NotNull
        public final Poster copy(@NotNull List<String> formats, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            return new Poster(formats, sm, aspectRatio, hq);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Poster)) {
                return false;
            }
            Poster poster = (Poster) other;
            return Intrinsics.areEqual(this.formats, poster.formats) && Intrinsics.areEqual(this.sm, poster.sm) && Double.compare(this.aspectRatio, poster.aspectRatio) == 0 && Intrinsics.areEqual(this.hq, poster.hq);
        }

        public int hashCode() {
            return (((((this.formats.hashCode() * 31) + this.sm.hashCode()) * 31) + Kickassanime$Poster$$ExternalSyntheticBackport0.m2m(this.aspectRatio)) * 31) + this.hq.hashCode();
        }

        @NotNull
        public String toString() {
            return "Poster(formats=" + this.formats + ", sm=" + this.sm + ", aspectRatio=" + this.aspectRatio + ", hq=" + this.hq + ')';
        }

        public Poster(@NotNull List<String> list, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            this.formats = list;
            this.sm = sm;
            this.aspectRatio = aspectRatio;
            this.hq = hq;
        }

        @NotNull
        public final List<String> getFormats() {
            return this.formats;
        }

        @NotNull
        public final String getSm() {
            return this.sm;
        }

        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        public final String getHq() {
            return this.hq;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/kickassanime/Kickassanime$Episoderesponse;", "", "slug", "", "title", "duration_ms", "", "episode_number", "", "episode_string", "thumbnail", "Lcom/kickassanime/Kickassanime$Thumbnail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Number;Ljava/lang/String;Lcom/kickassanime/Kickassanime$Thumbnail;)V", "getSlug", "()Ljava/lang/String;", "getTitle", "getDuration_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEpisode_number", "()Ljava/lang/Number;", "getEpisode_string", "getThumbnail", "()Lcom/kickassanime/Kickassanime$Thumbnail;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Number;Ljava/lang/String;Lcom/kickassanime/Kickassanime$Thumbnail;)Lcom/kickassanime/Kickassanime$Episoderesponse;", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Episoderesponse {

        @Nullable
        private final Long duration_ms;

        @Nullable
        private final Number episode_number;

        @Nullable
        private final String episode_string;

        @Nullable
        private final String slug;

        @Nullable
        private final Thumbnail thumbnail;

        @Nullable
        private final String title;

        public static /* synthetic */ Episoderesponse copy$default(Episoderesponse episoderesponse, String str, String str2, Long l, Number number, String str3, Thumbnail thumbnail, int i, Object obj) {
            if ((i & 1) != 0) {
                str = episoderesponse.slug;
            }
            if ((i & 2) != 0) {
                str2 = episoderesponse.title;
            }
            if ((i & 4) != 0) {
                l = episoderesponse.duration_ms;
            }
            if ((i & 8) != 0) {
                number = episoderesponse.episode_number;
            }
            if ((i & 16) != 0) {
                str3 = episoderesponse.episode_string;
            }
            if ((i & 32) != 0) {
                thumbnail = episoderesponse.thumbnail;
            }
            String str4 = str3;
            Thumbnail thumbnail2 = thumbnail;
            return episoderesponse.copy(str, str2, l, number, str4, thumbnail2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getDuration_ms() {
            return this.duration_ms;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Number getEpisode_number() {
            return this.episode_number;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEpisode_string() {
            return this.episode_string;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Thumbnail getThumbnail() {
            return this.thumbnail;
        }

        @NotNull
        public final Episoderesponse copy(@Nullable String slug, @Nullable String title, @Nullable Long duration_ms, @Nullable Number episode_number, @Nullable String episode_string, @Nullable Thumbnail thumbnail) {
            return new Episoderesponse(slug, title, duration_ms, episode_number, episode_string, thumbnail);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episoderesponse)) {
                return false;
            }
            Episoderesponse episoderesponse = (Episoderesponse) other;
            return Intrinsics.areEqual(this.slug, episoderesponse.slug) && Intrinsics.areEqual(this.title, episoderesponse.title) && Intrinsics.areEqual(this.duration_ms, episoderesponse.duration_ms) && Intrinsics.areEqual(this.episode_number, episoderesponse.episode_number) && Intrinsics.areEqual(this.episode_string, episoderesponse.episode_string) && Intrinsics.areEqual(this.thumbnail, episoderesponse.thumbnail);
        }

        public int hashCode() {
            return ((((((((((this.slug == null ? 0 : this.slug.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.duration_ms == null ? 0 : this.duration_ms.hashCode())) * 31) + (this.episode_number == null ? 0 : this.episode_number.hashCode())) * 31) + (this.episode_string == null ? 0 : this.episode_string.hashCode())) * 31) + (this.thumbnail != null ? this.thumbnail.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Episoderesponse(slug=" + this.slug + ", title=" + this.title + ", duration_ms=" + this.duration_ms + ", episode_number=" + this.episode_number + ", episode_string=" + this.episode_string + ", thumbnail=" + this.thumbnail + ')';
        }

        public Episoderesponse(@Nullable String slug, @Nullable String title, @Nullable Long duration_ms, @Nullable Number episode_number, @Nullable String episode_string, @Nullable Thumbnail thumbnail) {
            this.slug = slug;
            this.title = title;
            this.duration_ms = duration_ms;
            this.episode_number = episode_number;
            this.episode_string = episode_string;
            this.thumbnail = thumbnail;
        }

        @Nullable
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Long getDuration_ms() {
            return this.duration_ms;
        }

        @Nullable
        public final Number getEpisode_number() {
            return this.episode_number;
        }

        @Nullable
        public final String getEpisode_string() {
            return this.episode_string;
        }

        @Nullable
        public final Thumbnail getThumbnail() {
            return this.thumbnail;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003JD\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0004HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/kickassanime/Kickassanime$Thumbnail;", "", "formats", "", "", "sm", "aspectRatio", "", "hq", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getFormats", "()Ljava/util/List;", "getSm", "()Ljava/lang/String;", "getAspectRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHq", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/kickassanime/Kickassanime$Thumbnail;", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Thumbnail {

        @Nullable
        private final Double aspectRatio;

        @Nullable
        private final List<String> formats;

        @Nullable
        private final String hq;

        @Nullable
        private final String sm;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Thumbnail copy$default(Thumbnail thumbnail, List list, String str, Double d, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = thumbnail.formats;
            }
            if ((i & 2) != 0) {
                str = thumbnail.sm;
            }
            if ((i & 4) != 0) {
                d = thumbnail.aspectRatio;
            }
            if ((i & 8) != 0) {
                str2 = thumbnail.hq;
            }
            return thumbnail.copy(list, str, d, str2);
        }

        @Nullable
        public final List<String> component1() {
            return this.formats;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSm() {
            return this.sm;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getAspectRatio() {
            return this.aspectRatio;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getHq() {
            return this.hq;
        }

        @NotNull
        public final Thumbnail copy(@Nullable List<String> formats, @Nullable String sm, @Nullable Double aspectRatio, @Nullable String hq) {
            return new Thumbnail(formats, sm, aspectRatio, hq);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Thumbnail)) {
                return false;
            }
            Thumbnail thumbnail = (Thumbnail) other;
            return Intrinsics.areEqual(this.formats, thumbnail.formats) && Intrinsics.areEqual(this.sm, thumbnail.sm) && Intrinsics.areEqual(this.aspectRatio, thumbnail.aspectRatio) && Intrinsics.areEqual(this.hq, thumbnail.hq);
        }

        public int hashCode() {
            return ((((((this.formats == null ? 0 : this.formats.hashCode()) * 31) + (this.sm == null ? 0 : this.sm.hashCode())) * 31) + (this.aspectRatio == null ? 0 : this.aspectRatio.hashCode())) * 31) + (this.hq != null ? this.hq.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Thumbnail(formats=" + this.formats + ", sm=" + this.sm + ", aspectRatio=" + this.aspectRatio + ", hq=" + this.hq + ')';
        }

        public Thumbnail(@Nullable List<String> list, @Nullable String sm, @Nullable Double aspectRatio, @Nullable String hq) {
            this.formats = list;
            this.sm = sm;
            this.aspectRatio = aspectRatio;
            this.hq = hq;
        }

        @Nullable
        public final List<String> getFormats() {
            return this.formats;
        }

        @Nullable
        public final String getSm() {
            return this.sm;
        }

        @Nullable
        public final Double getAspectRatio() {
            return this.aspectRatio;
        }

        @Nullable
        public final String getHq() {
            return this.hq;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jò\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010FJ\u0014\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010J\u001a\u00020KHÖ\u0081\u0004J\n\u0010L\u001a\u00020\u0006HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"¨\u0006M"}, d2 = {"Lcom/kickassanime/Kickassanime$loadres;", "", "episodeDuration", "", "genres", "", "", "locales", "season", "slug", "startDate", "status", "synopsis", "title", "titleEn", "titleOriginal", "type", "year", "poster", "Lcom/kickassanime/Kickassanime$LoadPoster;", "banner", "Lcom/kickassanime/Kickassanime$Banner;", "endDate", "rating", "watchUri", "<init>", "(Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/kickassanime/Kickassanime$LoadPoster;Lcom/kickassanime/Kickassanime$Banner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEpisodeDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGenres", "()Ljava/util/List;", "getLocales", "getSeason", "()Ljava/lang/String;", "getSlug", "getStartDate", "getStatus", "getSynopsis", "getTitle", "getTitleEn", "getTitleOriginal", "getType", "getYear", "getPoster", "()Lcom/kickassanime/Kickassanime$LoadPoster;", "getBanner", "()Lcom/kickassanime/Kickassanime$Banner;", "getEndDate", "getRating", "getWatchUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/kickassanime/Kickassanime$LoadPoster;Lcom/kickassanime/Kickassanime$Banner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/kickassanime/Kickassanime$loadres;", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class loadres {

        @Nullable
        private final Banner banner;

        @Nullable
        private final String endDate;

        @Nullable
        private final Long episodeDuration;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final List<String> locales;

        @Nullable
        private final LoadPoster poster;

        @Nullable
        private final String rating;

        @Nullable
        private final String season;

        @Nullable
        private final String slug;

        @Nullable
        private final String startDate;

        @Nullable
        private final String status;

        @Nullable
        private final String synopsis;

        @Nullable
        private final String title;

        @Nullable
        private final String titleEn;

        @Nullable
        private final String titleOriginal;

        @Nullable
        private final String type;

        @Nullable
        private final String watchUri;

        @Nullable
        private final Long year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ loadres copy$default(loadres loadresVar, Long l, List list, List list2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l2, LoadPoster loadPoster, Banner banner, String str10, String str11, String str12, int i, Object obj) {
            String str13;
            String str14;
            Long l3 = (i & 1) != 0 ? loadresVar.episodeDuration : l;
            List list3 = (i & 2) != 0 ? loadresVar.genres : list;
            List list4 = (i & 4) != 0 ? loadresVar.locales : list2;
            String str15 = (i & 8) != 0 ? loadresVar.season : str;
            String str16 = (i & 16) != 0 ? loadresVar.slug : str2;
            String str17 = (i & 32) != 0 ? loadresVar.startDate : str3;
            String str18 = (i & 64) != 0 ? loadresVar.status : str4;
            String str19 = (i & 128) != 0 ? loadresVar.synopsis : str5;
            String str20 = (i & 256) != 0 ? loadresVar.title : str6;
            String str21 = (i & 512) != 0 ? loadresVar.titleEn : str7;
            String str22 = (i & 1024) != 0 ? loadresVar.titleOriginal : str8;
            String str23 = (i & 2048) != 0 ? loadresVar.type : str9;
            Long l4 = (i & 4096) != 0 ? loadresVar.year : l2;
            LoadPoster loadPoster2 = (i & 8192) != 0 ? loadresVar.poster : loadPoster;
            Long l5 = l3;
            Banner banner2 = (i & 16384) != 0 ? loadresVar.banner : banner;
            String str24 = (i & 32768) != 0 ? loadresVar.endDate : str10;
            String str25 = (i & 65536) != 0 ? loadresVar.rating : str11;
            if ((i & 131072) != 0) {
                str14 = str25;
                str13 = loadresVar.watchUri;
            } else {
                str13 = str12;
                str14 = str25;
            }
            return loadresVar.copy(l5, list3, list4, str15, str16, str17, str18, str19, str20, str21, str22, str23, l4, loadPoster2, banner2, str24, str14, str13);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getEpisodeDuration() {
            return this.episodeDuration;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getTitleEn() {
            return this.titleEn;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getTitleOriginal() {
            return this.titleOriginal;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Long getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final LoadPoster getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Banner getBanner() {
            return this.banner;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getEndDate() {
            return this.endDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getWatchUri() {
            return this.watchUri;
        }

        @Nullable
        public final List<String> component2() {
            return this.genres;
        }

        @Nullable
        public final List<String> component3() {
            return this.locales;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getStartDate() {
            return this.startDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getSynopsis() {
            return this.synopsis;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final loadres copy(@Nullable Long episodeDuration, @Nullable List<String> genres, @Nullable List<String> locales, @Nullable String season, @Nullable String slug, @Nullable String startDate, @Nullable String status, @Nullable String synopsis, @Nullable String title, @Nullable String titleEn, @Nullable String titleOriginal, @Nullable String type, @Nullable Long year, @Nullable LoadPoster poster, @Nullable Banner banner, @Nullable String endDate, @Nullable String rating, @Nullable String watchUri) {
            return new loadres(episodeDuration, genres, locales, season, slug, startDate, status, synopsis, title, titleEn, titleOriginal, type, year, poster, banner, endDate, rating, watchUri);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof loadres)) {
                return false;
            }
            loadres loadresVar = (loadres) other;
            return Intrinsics.areEqual(this.episodeDuration, loadresVar.episodeDuration) && Intrinsics.areEqual(this.genres, loadresVar.genres) && Intrinsics.areEqual(this.locales, loadresVar.locales) && Intrinsics.areEqual(this.season, loadresVar.season) && Intrinsics.areEqual(this.slug, loadresVar.slug) && Intrinsics.areEqual(this.startDate, loadresVar.startDate) && Intrinsics.areEqual(this.status, loadresVar.status) && Intrinsics.areEqual(this.synopsis, loadresVar.synopsis) && Intrinsics.areEqual(this.title, loadresVar.title) && Intrinsics.areEqual(this.titleEn, loadresVar.titleEn) && Intrinsics.areEqual(this.titleOriginal, loadresVar.titleOriginal) && Intrinsics.areEqual(this.type, loadresVar.type) && Intrinsics.areEqual(this.year, loadresVar.year) && Intrinsics.areEqual(this.poster, loadresVar.poster) && Intrinsics.areEqual(this.banner, loadresVar.banner) && Intrinsics.areEqual(this.endDate, loadresVar.endDate) && Intrinsics.areEqual(this.rating, loadresVar.rating) && Intrinsics.areEqual(this.watchUri, loadresVar.watchUri);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((this.episodeDuration == null ? 0 : this.episodeDuration.hashCode()) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.locales == null ? 0 : this.locales.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.startDate == null ? 0 : this.startDate.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.synopsis == null ? 0 : this.synopsis.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.titleEn == null ? 0 : this.titleEn.hashCode())) * 31) + (this.titleOriginal == null ? 0 : this.titleOriginal.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.banner == null ? 0 : this.banner.hashCode())) * 31) + (this.endDate == null ? 0 : this.endDate.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.watchUri != null ? this.watchUri.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("loadres(episodeDuration=").append(this.episodeDuration).append(", genres=").append(this.genres).append(", locales=").append(this.locales).append(", season=").append(this.season).append(", slug=").append(this.slug).append(", startDate=").append(this.startDate).append(", status=").append(this.status).append(", synopsis=").append(this.synopsis).append(", title=").append(this.title).append(", titleEn=").append(this.titleEn).append(", titleOriginal=").append(this.titleOriginal).append(", type=");
            sb.append(this.type).append(", year=").append(this.year).append(", poster=").append(this.poster).append(", banner=").append(this.banner).append(", endDate=").append(this.endDate).append(", rating=").append(this.rating).append(", watchUri=").append(this.watchUri).append(')');
            return sb.toString();
        }

        public loadres(@Nullable Long episodeDuration, @Nullable List<String> list, @Nullable List<String> list2, @Nullable String season, @Nullable String slug, @Nullable String startDate, @Nullable String status, @Nullable String synopsis, @Nullable String title, @Nullable String titleEn, @Nullable String titleOriginal, @Nullable String type, @Nullable Long year, @Nullable LoadPoster poster, @Nullable Banner banner, @Nullable String endDate, @Nullable String rating, @Nullable String watchUri) {
            this.episodeDuration = episodeDuration;
            this.genres = list;
            this.locales = list2;
            this.season = season;
            this.slug = slug;
            this.startDate = startDate;
            this.status = status;
            this.synopsis = synopsis;
            this.title = title;
            this.titleEn = titleEn;
            this.titleOriginal = titleOriginal;
            this.type = type;
            this.year = year;
            this.poster = poster;
            this.banner = banner;
            this.endDate = endDate;
            this.rating = rating;
            this.watchUri = watchUri;
        }

        @Nullable
        public final Long getEpisodeDuration() {
            return this.episodeDuration;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final List<String> getLocales() {
            return this.locales;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final String getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getSynopsis() {
            return this.synopsis;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTitleEn() {
            return this.titleEn;
        }

        @Nullable
        public final String getTitleOriginal() {
            return this.titleOriginal;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Long getYear() {
            return this.year;
        }

        @Nullable
        public final LoadPoster getPoster() {
            return this.poster;
        }

        @Nullable
        public final Banner getBanner() {
            return this.banner;
        }

        @Nullable
        public final String getEndDate() {
            return this.endDate;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        public final String getWatchUri() {
            return this.watchUri;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/kickassanime/Kickassanime$LoadPoster;", "", "formats", "", "", "sm", "aspectRatio", "", "hq", "<init>", "(Ljava/util/List;Ljava/lang/String;DLjava/lang/String;)V", "getFormats", "()Ljava/util/List;", "getSm", "()Ljava/lang/String;", "getAspectRatio", "()D", "getHq", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadPoster {
        private final double aspectRatio;

        @NotNull
        private final List<String> formats;

        @NotNull
        private final String hq;

        @NotNull
        private final String sm;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoadPoster copy$default(LoadPoster loadPoster, List list, String str, double d, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = loadPoster.formats;
            }
            if ((i & 2) != 0) {
                str = loadPoster.sm;
            }
            if ((i & 4) != 0) {
                d = loadPoster.aspectRatio;
            }
            if ((i & 8) != 0) {
                str2 = loadPoster.hq;
            }
            String str3 = str2;
            return loadPoster.copy(list, str, d, str3);
        }

        @NotNull
        public final List<String> component1() {
            return this.formats;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSm() {
            return this.sm;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getHq() {
            return this.hq;
        }

        @NotNull
        public final LoadPoster copy(@NotNull List<String> formats, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            return new LoadPoster(formats, sm, aspectRatio, hq);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadPoster)) {
                return false;
            }
            LoadPoster loadPoster = (LoadPoster) other;
            return Intrinsics.areEqual(this.formats, loadPoster.formats) && Intrinsics.areEqual(this.sm, loadPoster.sm) && Double.compare(this.aspectRatio, loadPoster.aspectRatio) == 0 && Intrinsics.areEqual(this.hq, loadPoster.hq);
        }

        public int hashCode() {
            return (((((this.formats.hashCode() * 31) + this.sm.hashCode()) * 31) + Kickassanime$LoadPoster$$ExternalSyntheticBackport0.m1m(this.aspectRatio)) * 31) + this.hq.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadPoster(formats=" + this.formats + ", sm=" + this.sm + ", aspectRatio=" + this.aspectRatio + ", hq=" + this.hq + ')';
        }

        public LoadPoster(@NotNull List<String> list, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            this.formats = list;
            this.sm = sm;
            this.aspectRatio = aspectRatio;
            this.hq = hq;
        }

        @NotNull
        public final List<String> getFormats() {
            return this.formats;
        }

        @NotNull
        public final String getSm() {
            return this.sm;
        }

        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        public final String getHq() {
            return this.hq;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/kickassanime/Kickassanime$Banner;", "", "formats", "", "", "sm", "aspectRatio", "", "hq", "<init>", "(Ljava/util/List;Ljava/lang/String;DLjava/lang/String;)V", "getFormats", "()Ljava/util/List;", "getSm", "()Ljava/lang/String;", "getAspectRatio", "()D", "getHq", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Banner {
        private final double aspectRatio;

        @NotNull
        private final List<String> formats;

        @NotNull
        private final String hq;

        @NotNull
        private final String sm;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Banner copy$default(Banner banner, List list, String str, double d, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = banner.formats;
            }
            if ((i & 2) != 0) {
                str = banner.sm;
            }
            if ((i & 4) != 0) {
                d = banner.aspectRatio;
            }
            if ((i & 8) != 0) {
                str2 = banner.hq;
            }
            String str3 = str2;
            return banner.copy(list, str, d, str3);
        }

        @NotNull
        public final List<String> component1() {
            return this.formats;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSm() {
            return this.sm;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getHq() {
            return this.hq;
        }

        @NotNull
        public final Banner copy(@NotNull List<String> formats, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            return new Banner(formats, sm, aspectRatio, hq);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Banner)) {
                return false;
            }
            Banner banner = (Banner) other;
            return Intrinsics.areEqual(this.formats, banner.formats) && Intrinsics.areEqual(this.sm, banner.sm) && Double.compare(this.aspectRatio, banner.aspectRatio) == 0 && Intrinsics.areEqual(this.hq, banner.hq);
        }

        public int hashCode() {
            return (((((this.formats.hashCode() * 31) + this.sm.hashCode()) * 31) + Kickassanime$Banner$$ExternalSyntheticBackport0.m0m(this.aspectRatio)) * 31) + this.hq.hashCode();
        }

        @NotNull
        public String toString() {
            return "Banner(formats=" + this.formats + ", sm=" + this.sm + ", aspectRatio=" + this.aspectRatio + ", hq=" + this.hq + ')';
        }

        public Banner(@NotNull List<String> list, @NotNull String sm, double aspectRatio, @NotNull String hq) {
            this.formats = list;
            this.sm = sm;
            this.aspectRatio = aspectRatio;
            this.hq = hq;
        }

        @NotNull
        public final List<String> getFormats() {
            return this.formats;
        }

        @NotNull
        public final String getSm() {
            return this.sm;
        }

        public final double getAspectRatio() {
            return this.aspectRatio;
        }

        @NotNull
        public final String getHq() {
            return this.hq;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/kickassanime/Kickassanime$ServersRes;", "", "servers", "", "Lcom/kickassanime/Kickassanime$Server;", "<init>", "(Ljava/util/List;)V", "getServers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ServersRes {

        @NotNull
        private final List<Server> servers;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ServersRes copy$default(ServersRes serversRes, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = serversRes.servers;
            }
            return serversRes.copy(list);
        }

        @NotNull
        public final List<Server> component1() {
            return this.servers;
        }

        @NotNull
        public final ServersRes copy(@NotNull List<Server> servers) {
            return new ServersRes(servers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ServersRes) && Intrinsics.areEqual(this.servers, ((ServersRes) other).servers);
        }

        public int hashCode() {
            return this.servers.hashCode();
        }

        @NotNull
        public String toString() {
            return "ServersRes(servers=" + this.servers + ')';
        }

        public ServersRes(@NotNull List<Server> list) {
            this.servers = list;
        }

        @NotNull
        public final List<Server> getServers() {
            return this.servers;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/kickassanime/Kickassanime$Server;", "", "name", "", "shortName", "src", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getShortName", "getSrc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Server {

        @NotNull
        private final String name;

        @NotNull
        private final String shortName;

        @NotNull
        private final String src;

        public static /* synthetic */ Server copy$default(Server server, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = server.name;
            }
            if ((i & 2) != 0) {
                str2 = server.shortName;
            }
            if ((i & 4) != 0) {
                str3 = server.src;
            }
            return server.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getShortName() {
            return this.shortName;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSrc() {
            return this.src;
        }

        @NotNull
        public final Server copy(@NotNull String name, @NotNull String shortName, @NotNull String src) {
            return new Server(name, shortName, src);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Server)) {
                return false;
            }
            Server server = (Server) other;
            return Intrinsics.areEqual(this.name, server.name) && Intrinsics.areEqual(this.shortName, server.shortName) && Intrinsics.areEqual(this.src, server.src);
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + this.shortName.hashCode()) * 31) + this.src.hashCode();
        }

        @NotNull
        public String toString() {
            return "Server(name=" + this.name + ", shortName=" + this.shortName + ", src=" + this.src + ')';
        }

        public Server(@NotNull String name, @NotNull String shortName, @NotNull String src) {
            this.name = name;
            this.shortName = shortName;
            this.src = src;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getShortName() {
            return this.shortName;
        }

        @NotNull
        public final String getSrc() {
            return this.src;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/kickassanime/Kickassanime$m3u8;", "", "hls", "", "subtitles", "", "Lcom/kickassanime/Kickassanime$Subtitle;", "key", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getHls", "()Ljava/lang/String;", "getSubtitles", "()Ljava/util/List;", "getKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class m3u8 {

        @NotNull
        private final String hls;

        @NotNull
        private final String key;

        @NotNull
        private final List<Subtitle> subtitles;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ m3u8 copy$default(m3u8 m3u8Var, String str, List list, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = m3u8Var.hls;
            }
            if ((i & 2) != 0) {
                list = m3u8Var.subtitles;
            }
            if ((i & 4) != 0) {
                str2 = m3u8Var.key;
            }
            return m3u8Var.copy(str, list, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHls() {
            return this.hls;
        }

        @NotNull
        public final List<Subtitle> component2() {
            return this.subtitles;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final m3u8 copy(@NotNull String hls, @NotNull List<Subtitle> subtitles, @NotNull String key) {
            return new m3u8(hls, subtitles, key);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof m3u8)) {
                return false;
            }
            m3u8 m3u8Var = (m3u8) other;
            return Intrinsics.areEqual(this.hls, m3u8Var.hls) && Intrinsics.areEqual(this.subtitles, m3u8Var.subtitles) && Intrinsics.areEqual(this.key, m3u8Var.key);
        }

        public int hashCode() {
            return (((this.hls.hashCode() * 31) + this.subtitles.hashCode()) * 31) + this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "m3u8(hls=" + this.hls + ", subtitles=" + this.subtitles + ", key=" + this.key + ')';
        }

        public m3u8(@NotNull String hls, @NotNull List<Subtitle> list, @NotNull String key) {
            this.hls = hls;
            this.subtitles = list;
            this.key = key;
        }

        @NotNull
        public final String getHls() {
            return this.hls;
        }

        @NotNull
        public final List<Subtitle> getSubtitles() {
            return this.subtitles;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/kickassanime/Kickassanime$Subtitle;", "", "language", "", "name", "src", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguage", "()Ljava/lang/String;", "getName", "getSrc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Subtitle {

        @NotNull
        private final String language;

        @NotNull
        private final String name;

        @NotNull
        private final String src;

        public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitle.language;
            }
            if ((i & 2) != 0) {
                str2 = subtitle.name;
            }
            if ((i & 4) != 0) {
                str3 = subtitle.src;
            }
            return subtitle.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSrc() {
            return this.src;
        }

        @NotNull
        public final Subtitle copy(@NotNull String language, @NotNull String name, @NotNull String src) {
            return new Subtitle(language, name, src);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) other;
            return Intrinsics.areEqual(this.language, subtitle.language) && Intrinsics.areEqual(this.name, subtitle.name) && Intrinsics.areEqual(this.src, subtitle.src);
        }

        public int hashCode() {
            return (((this.language.hashCode() * 31) + this.name.hashCode()) * 31) + this.src.hashCode();
        }

        @NotNull
        public String toString() {
            return "Subtitle(language=" + this.language + ", name=" + this.name + ", src=" + this.src + ')';
        }

        public Subtitle(@NotNull String language, @NotNull String name, @NotNull String src) {
            this.language = language;
            this.name = name;
            this.src = src;
        }

        @NotNull
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getSrc() {
            return this.src;
        }
    }

    private final String generateFilterWithCurrentYear() {
        int currentYear = Calendar.getInstance().get(1);
        String jsonObject = "{\"year\":" + currentYear + ",\"status\":\"airing\"}";
        byte[] bytes = jsonObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String base64Encoded = StringsKt.trim(MainAPIKt.base64Encode(bytes)).toString();
        return URLEncoder.encode(base64Encoded, "UTF-8");
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/kickassanime/Kickassanime$Encrypted;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Encrypted {

        @NotNull
        private final String data;

        public static /* synthetic */ Encrypted copy$default(Encrypted encrypted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = encrypted.data;
            }
            return encrypted.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final Encrypted copy(@NotNull String data) {
            return new Encrypted(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Encrypted) && Intrinsics.areEqual(this.data, ((Encrypted) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "Encrypted(data=" + this.data + ')';
        }

        public Encrypted(@NotNull String data) {
            this.data = data;
        }

        @NotNull
        public final String getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/kickassanime/Kickassanime$EpisodePage;", "", "pages", "", "Lcom/kickassanime/Kickassanime$PageInfo;", "result", "Lcom/kickassanime/Kickassanime$Episoderesponse;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getPages", "()Ljava/util/List;", "getResult", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodePage {

        @NotNull
        private final List<PageInfo> pages;

        @NotNull
        private final List<Episoderesponse> result;

        /* JADX WARN: Illegal instructions before constructor call */
        public EpisodePage() {
            List list = null;
            this(list, list, 3, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodePage copy$default(EpisodePage episodePage, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = episodePage.pages;
            }
            if ((i & 2) != 0) {
                list2 = episodePage.result;
            }
            return episodePage.copy(list, list2);
        }

        @NotNull
        public final List<PageInfo> component1() {
            return this.pages;
        }

        @NotNull
        public final List<Episoderesponse> component2() {
            return this.result;
        }

        @NotNull
        public final EpisodePage copy(@NotNull List<PageInfo> pages, @NotNull List<Episoderesponse> result) {
            return new EpisodePage(pages, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodePage)) {
                return false;
            }
            EpisodePage episodePage = (EpisodePage) other;
            return Intrinsics.areEqual(this.pages, episodePage.pages) && Intrinsics.areEqual(this.result, episodePage.result);
        }

        public int hashCode() {
            return (this.pages.hashCode() * 31) + this.result.hashCode();
        }

        @NotNull
        public String toString() {
            return "EpisodePage(pages=" + this.pages + ", result=" + this.result + ')';
        }

        public EpisodePage(@NotNull List<PageInfo> list, @NotNull List<Episoderesponse> list2) {
            this.pages = list;
            this.result = list2;
        }

        public /* synthetic */ EpisodePage(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }

        @NotNull
        public final List<PageInfo> getPages() {
            return this.pages;
        }

        @NotNull
        public final List<Episoderesponse> getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: Kickassanime.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/kickassanime/Kickassanime$PageInfo;", "", "number", "", "from", "", "to", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getNumber", "()I", "getFrom", "()Ljava/lang/String;", "getTo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Kickassanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PageInfo {

        @NotNull
        private final String from;
        private final int number;

        @NotNull
        private final String to;

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pageInfo.number;
            }
            if ((i2 & 2) != 0) {
                str = pageInfo.from;
            }
            if ((i2 & 4) != 0) {
                str2 = pageInfo.to;
            }
            return pageInfo.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getNumber() {
            return this.number;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFrom() {
            return this.from;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTo() {
            return this.to;
        }

        @NotNull
        public final PageInfo copy(int number, @NotNull String from, @NotNull String to) {
            return new PageInfo(number, from, to);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageInfo)) {
                return false;
            }
            PageInfo pageInfo = (PageInfo) other;
            return this.number == pageInfo.number && Intrinsics.areEqual(this.from, pageInfo.from) && Intrinsics.areEqual(this.to, pageInfo.to);
        }

        public int hashCode() {
            return (((this.number * 31) + this.from.hashCode()) * 31) + this.to.hashCode();
        }

        @NotNull
        public String toString() {
            return "PageInfo(number=" + this.number + ", from=" + this.from + ", to=" + this.to + ')';
        }

        public PageInfo(int number, @NotNull String from, @NotNull String to) {
            this.number = number;
            this.from = from;
            this.to = to;
        }

        public final int getNumber() {
            return this.number;
        }

        @NotNull
        public final String getFrom() {
            return this.from;
        }

        @NotNull
        public final String getTo() {
            return this.to;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0065  */
    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[Catch: Exception -> 0x0097, TRY_LEAVE, TryCatch #4 {Exception -> 0x0097, blocks: (B:10:0x0031, B:17:0x005f, B:20:0x0066, B:28:0x0081, B:27:0x007b, B:16:0x0054, B:9:0x0027, B:13:0x0038, B:6:0x000e, B:22:0x006c), top: B:40:0x000e, inners: #0, #2, #5 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final EpisodePage parseEpisodePage(String json) {
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        AppUtils appUtils = AppUtils.INSTANCE;
        List list = null;
        if (json == null) {
            objDecodeFromString = null;
        } else {
            try {
                try {
                    kotlin.Result.Companion companion = kotlin.Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(EpisodePage.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = kotlin.Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                    obj = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (kotlin.Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        kotlin.Result.Companion companion3 = kotlin.Result.Companion;
                        obj = kotlin.Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(EpisodePage.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        kotlin.Result.Companion companion4 = kotlin.Result.Companion;
                        obj = kotlin.Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    if (kotlin.Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(json, new TypeReference<EpisodePage>() { // from class: com.kickassanime.Kickassanime$parseEpisodePage$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    if (kotlin.Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    deserializationStrategy = (KSerializer) obj;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(json, new TypeReference<EpisodePage>() { // from class: com.kickassanime.Kickassanime$parseEpisodePage$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(json, new TypeReference<EpisodePage>() { // from class: com.kickassanime.Kickassanime$parseEpisodePage$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(json, new TypeReference<EpisodePage>() { // from class: com.kickassanime.Kickassanime$parseEpisodePage$$inlined$tryParseJson$1
                        });
                    }
                }
            } catch (Exception e2) {
                objDecodeFromString = null;
            }
        }
        EpisodePage episodePage = (EpisodePage) objDecodeFromString;
        return episodePage == null ? new EpisodePage(list, list, 3, list) : episodePage;
    }

    private final List<Episoderesponse> parseJsonToEpisodes(String json) {
        return parseEpisodePage(json).getResult();
    }
}
