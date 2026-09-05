package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleeksoft.ksoup.Ksoup;
import com.fleeksoft.ksoup.nodes.Document;
import com.fleeksoft.ksoup.nodes.Element;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
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
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimePahe.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0007=>?@ABCB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001b\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00192\u0006\u0010%\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010&J<\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010+\u001a\u00020\u00052\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0082@¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010&JF\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000e2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0096@¢\u0006\u0002\u0010<R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006D"}, d2 = {"Lcom/phisher98/AnimePahe;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasQuickSearch", "", "getHasQuickSearch", "()Z", "hasMainPage", "getHasMainPage", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateListOfEpisodes", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/Episode;", "Lkotlin/collections/ArrayList;", "session", "metaEpisodes", "", "Lcom/phisher98/MetaEpisode;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "AnimePaheSearchData", "AnimePaheSearch", "AnimeData", "AnimePaheAnimeData", "LinkLoadData", "LoadData", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,581:1\n93#2,2:582\n63#2:584\n64#2,15:586\n95#2,2:603\n93#2,2:609\n63#2:611\n64#2,15:613\n95#2,2:630\n93#2,2:636\n63#2:638\n64#2,15:640\n95#2,2:657\n93#2,2:665\n63#2:667\n64#2,15:669\n95#2,2:686\n1#3:585\n1#3:612\n1#3:639\n1#3:668\n1#3:688\n50#4:601\n43#4:602\n50#4:628\n43#4:629\n50#4:655\n43#4:656\n50#4:684\n43#4:685\n1739#5:605\n1814#5,3:606\n1739#5:632\n1814#5,3:633\n2068#5,2:659\n1739#5:661\n1814#5,3:662\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe\n*L\n199#1:582,2\n199#1:584\n199#1:586,15\n199#1:603,2\n245#1:609,2\n245#1:611\n245#1:613,15\n245#1:630,2\n316#1:636,2\n316#1:638\n316#1:640,15\n316#1:657,2\n512#1:665,2\n512#1:667\n512#1:669,15\n512#1:686,2\n199#1:585\n245#1:612\n316#1:639\n512#1:668\n199#1:601\n199#1:602\n245#1:628\n245#1:629\n316#1:655\n316#1:656\n512#1:684\n512#1:685\n199#1:605\n199#1:606,3\n247#1:632\n247#1:633,3\n328#1:659,2\n353#1:661\n353#1:662,3\n*E\n"})
public final class AnimePahe extends MainAPI {
    private final boolean hasQuickSearch;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Cookie", "__ddg2_=1234567890"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 10; K; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/124.0.0.0 Mobile Safari/537.36"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9")});

    @NotNull
    private static final List<String> CF_BLOCKER_PHRASES = CollectionsKt.listOf(new String[]{"just a moment", "checking your browser", "ddos-guard", "attention required", "verify you are human", "cloudflare"});

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private String mainUrl = AnimePaheProviderPlugin.INSTANCE.getCurrentAnimepaheServer();

    @NotNull
    private String name = "AnimePahe";
    private final boolean hasMainPage = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.AnimeMovie, TvType.Anime, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = CollectionsKt.listOf(new MainPageData("Latest Releases", getMainUrl() + "/api?m=airing&page=", true));

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$generateListOfEpisodes$1 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe", f = "AnimePahe.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {315, 390}, m = "generateListOfEpisodes", n = {"session", "metaEpisodes", "episodes", "semaphore", "uri", "session", "metaEpisodes", "episodes", "semaphore", "uri", "req", "data", "currentEpisode", "deferredResults", "last_page", "per_page", "total"}, nl = {316, 393}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimePahe.this.generateListOfEpisodes(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$getMainPage$1 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe", f = "AnimePahe.kt", i = {0, 0}, l = {198}, m = "getMainPage", n = {"request", "page"}, nl = {199}, s = {"L$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimePahe.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$loadLinks$1 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe", f = "AnimePahe.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {513, 514, 515, 548}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parsed", "isCasting", "data", "subtitleCallback", "callback", "parsed", "episodeUrl", "isCasting", "data", "subtitleCallback", "callback", "parsed", "episodeUrl", "document", "isCasting", "data", "subtitleCallback", "callback", "parsed", "episodeUrl", "document", "isCasting"}, nl = {514, 515, 548, 574}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return AnimePahe.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$search$1 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe", f = "AnimePahe.kt", i = {0, 0, 0}, l = {244}, m = "search", n = {"query", "url", "searchHeaders"}, nl = {245}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimePahe.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J,\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00062\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0002\u0010\u0019R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/phisher98/AnimePahe$Companion;", "", "<init>", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "cfHeaders", "getCfHeaders", "CF_BLOCKER_PHRASES", "", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "getType", "Lcom/lagradost/cloudstream3/TvType;", "t", "appGet", "url", "customHeaders", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,581:1\n1960#2,3:582\n117#3,10:585\n1#4:595\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$Companion\n*L\n142#1:582,3\n156#1:585,10\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return AnimePahe.headers;
        }

        @NotNull
        public final Map<String, String> getCfHeaders() {
            String savedCookies = AnimePaheProviderPlugin.INSTANCE.getCfCookies();
            String savedUa = AnimePaheProviderPlugin.INSTANCE.getCfUserAgent();
            Map<String, String> mutableMap = MapsKt.toMutableMap(getHeaders());
            mutableMap.put("referer", AnimePaheProviderPlugin.INSTANCE.getCurrentAnimepaheServer() + '/');
            if (savedUa.length() > 0) {
                mutableMap.put("User-Agent", savedUa);
            }
            if (savedCookies.length() > 0) {
                mutableMap.put("Cookie", "__ddg2_=1234567890; " + savedCookies);
            }
            return mutableMap;
        }

        public final boolean isCloudflareBlocked(@NotNull NiceResponse response) {
            if (response.getCode() != 403 && response.getCode() != 503) {
                return false;
            }
            String body = response.getText().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(body, "toLowerCase(...)");
            Iterable $this$any$iv = AnimePahe.CF_BLOCKER_PHRASES;
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

        /* JADX INFO: Access modifiers changed from: private */
        public final TvType getType(String t) {
            if (StringsKt.contains$default(t, "OVA", false, 2, (Object) null) || StringsKt.contains$default(t, "Special", false, 2, (Object) null)) {
                return TvType.OVA;
            }
            return StringsKt.contains$default(t, "Movie", false, 2, (Object) null) ? TvType.AnimeMovie : TvType.Anime;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object appGet$default(Companion companion, String str, Map map, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                map = companion.getHeaders();
            }
            return companion.appGet(str, map, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x011a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x011b  */
        /* JADX WARN: Code duplicated, block: B:32:0x013d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x013e  */
        /* JADX WARN: Code duplicated, block: B:40:0x018f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x0190  */
        /* JADX WARN: Code duplicated, block: B:44:0x01a8 A[Catch: all -> 0x01ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ab, blocks: (B:44:0x01a8, B:50:0x01d8), top: B:84:0x01a6 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x01b0 A[Catch: all -> 0x0270, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0270, blocks: (B:42:0x019d, B:48:0x01b0), top: B:75:0x019d }] */
        /* JADX WARN: Code duplicated, block: B:50:0x01d8 A[Catch: all -> 0x01ab, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ab, blocks: (B:44:0x01a8, B:50:0x01d8), top: B:84:0x01a6 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01f5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:58:0x020d  */
        /* JADX WARN: Code duplicated, block: B:60:0x020f  */
        /* JADX WARN: Code duplicated, block: B:62:0x025c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:63:0x025d  */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        @Nullable
        public final Object appGet(@NotNull String url, @NotNull Map<String, String> map, @NotNull Continuation<? super NiceResponse> continuation) throws Throwable {
            AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$1;
            Mutex $this$withLock_u24default$iv;
            Object owner$iv;
            Object obj;
            AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$2;
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
            AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$3;
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
            if (continuation instanceof AnimePahe$Companion$appGet$1) {
                animePahe$Companion$appGet$1 = (AnimePahe$Companion$appGet$1) continuation;
                if ((animePahe$Companion$appGet$1.label & Integer.MIN_VALUE) != 0) {
                    animePahe$Companion$appGet$1.label -= Integer.MIN_VALUE;
                } else {
                    animePahe$Companion$appGet$1 = new AnimePahe$Companion$appGet$1(this, continuation);
                }
            } else {
                animePahe$Companion$appGet$1 = new AnimePahe$Companion$appGet$1(this, continuation);
            }
            AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$4 = animePahe$Companion$appGet$1;
            Object $result = animePahe$Companion$appGet$4.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (animePahe$Companion$appGet$4.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Requests app = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$4.L$0 = url;
                        animePahe$Companion$appGet$4.L$1 = map;
                        animePahe$Companion$appGet$4.label = 1;
                        obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor, false, (ResponseParser) null, animePahe$Companion$appGet$4, 3580, (Object) null);
                        animePahe$Companion$appGet$2 = animePahe$Companion$appGet$4;
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
                        $this$withLock_u24default$iv2 = AnimePahe.cfBypassMutex;
                        animePahe$Companion$appGet$2.L$0 = url2;
                        animePahe$Companion$appGet$2.L$1 = map2;
                        animePahe$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        animePahe$Companion$appGet$2.L$3 = recheckPassed;
                        animePahe$Companion$appGet$2.L$4 = $this$withLock_u24default$iv2;
                        animePahe$Companion$appGet$2.label = 2;
                        if ($this$withLock_u24default$iv2.lock((Object) null, animePahe$Companion$appGet$2) == coroutine_suspended) {
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
                            CFBypassInterceptor cFBypassInterceptor2 = CFBypassInterceptor.INSTANCE;
                            animePahe$Companion$appGet$2.L$0 = url3;
                            animePahe$Companion$appGet$2.L$1 = map2;
                            animePahe$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                            animePahe$Companion$appGet$2.L$3 = recheckPassed2;
                            animePahe$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                            animePahe$Companion$appGet$2.label = 3;
                            recheckPassed3 = recheckPassed2;
                            $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                            AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$5 = animePahe$Companion$appGet$2;
                            url4 = url3;
                            try {
                                obj2 = Requests.get$default(app2, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor2, false, (ResponseParser) null, animePahe$Companion$appGet$5, 3580, (Object) null);
                                animePahe$Companion$appGet$3 = animePahe$Companion$appGet$5;
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
                                            if (!AnimePahe.INSTANCE.isCloudflareBlocked(recheck)) {
                                                Log.INSTANCE.d("AnimePahe", "CF challenge detected on " + url5 + " – showing WebView dialog for user");
                                                if (AnimePaheProviderPlugin.INSTANCE.getCfWebviewEnabled()) {
                                                    animePahe$Companion$appGet$3.L$0 = url5;
                                                    animePahe$Companion$appGet$3.L$1 = map3;
                                                    animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                    animePahe$Companion$appGet$3.L$3 = recheckPassed4;
                                                    animePahe$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                                    animePahe$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                                    animePahe$Companion$appGet$3.label = 4;
                                                    if (AnimePaheKt.showCFBypassDialogAndWait(url5, animePahe$Companion$appGet$3) == coroutine_suspended) {
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
                                                CFBypassInterceptor cFBypassInterceptor3 = CFBypassInterceptor.INSTANCE;
                                                animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                                animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                                animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                                animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed6);
                                                animePahe$Companion$appGet$3.L$4 = null;
                                                animePahe$Companion$appGet$3.L$5 = null;
                                                animePahe$Companion$appGet$3.label = 5;
                                                obj3 = Requests.get$default(app3, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor3, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
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
                                            CFBypassInterceptor cFBypassInterceptor4 = CFBypassInterceptor.INSTANCE;
                                            animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                            animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                            animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                            animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed7);
                                            animePahe$Companion$appGet$3.L$4 = null;
                                            animePahe$Companion$appGet$3.L$5 = null;
                                            animePahe$Companion$appGet$3.label = 5;
                                            obj3 = Requests.get$default(app4, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor4, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
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
                        map2 = (Map) animePahe$Companion$appGet$4.L$1;
                        url2 = (String) animePahe$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        animePahe$Companion$appGet$2 = animePahe$Companion$appGet$4;
                        obj = $result;
                        rawResponse = (NiceResponse) obj;
                        if (!isCloudflareBlocked(rawResponse)) {
                            return rawResponse;
                        }
                        recheckPassed = new Ref.ObjectRef();
                        $this$withLock_u24default$iv2 = AnimePahe.cfBypassMutex;
                        animePahe$Companion$appGet$2.L$0 = url2;
                        animePahe$Companion$appGet$2.L$1 = map2;
                        animePahe$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        animePahe$Companion$appGet$2.L$3 = recheckPassed;
                        animePahe$Companion$appGet$2.L$4 = $this$withLock_u24default$iv2;
                        animePahe$Companion$appGet$2.label = 2;
                        if ($this$withLock_u24default$iv2.lock((Object) null, animePahe$Companion$appGet$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawResponse2 = rawResponse;
                        url3 = url2;
                        recheckPassed2 = recheckPassed;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        owner$iv2 = null;
                        $i$f$withLock = 0;
                        Requests app5 = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor5 = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$2.L$0 = url3;
                        animePahe$Companion$appGet$2.L$1 = map2;
                        animePahe$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        animePahe$Companion$appGet$2.L$3 = recheckPassed2;
                        animePahe$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                        animePahe$Companion$appGet$2.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$6 = animePahe$Companion$appGet$2;
                        url4 = url3;
                        obj2 = Requests.get$default(app5, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor5, false, (ResponseParser) null, animePahe$Companion$appGet$6, 3580, (Object) null);
                        animePahe$Companion$appGet$3 = animePahe$Companion$appGet$6;
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
                        if (!AnimePahe.INSTANCE.isCloudflareBlocked(recheck)) {
                            Log.INSTANCE.d("AnimePahe", "CF challenge detected on " + url5 + " – showing WebView dialog for user");
                            if (AnimePaheProviderPlugin.INSTANCE.getCfWebviewEnabled()) {
                                animePahe$Companion$appGet$3.L$0 = url5;
                                animePahe$Companion$appGet$3.L$1 = map3;
                                animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                animePahe$Companion$appGet$3.L$3 = recheckPassed4;
                                animePahe$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                animePahe$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                animePahe$Companion$appGet$3.label = 4;
                                if (AnimePaheKt.showCFBypassDialogAndWait(url5, animePahe$Companion$appGet$3) == coroutine_suspended) {
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
                            CFBypassInterceptor cFBypassInterceptor6 = CFBypassInterceptor.INSTANCE;
                            animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed8);
                            animePahe$Companion$appGet$3.L$4 = null;
                            animePahe$Companion$appGet$3.L$5 = null;
                            animePahe$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app6, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor6, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
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
                        CFBypassInterceptor cFBypassInterceptor7 = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed9);
                        animePahe$Companion$appGet$3.L$4 = null;
                        animePahe$Companion$appGet$3.L$5 = null;
                        animePahe$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app7, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor7, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 2:
                        Mutex $this$withLock_u24default$iv5 = (Mutex) animePahe$Companion$appGet$4.L$4;
                        Ref.ObjectRef recheckPassed10 = (Ref.ObjectRef) animePahe$Companion$appGet$4.L$3;
                        NiceResponse rawResponse5 = (NiceResponse) animePahe$Companion$appGet$4.L$2;
                        Map<String, String> map4 = (Map) animePahe$Companion$appGet$4.L$1;
                        url3 = (String) animePahe$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withLock = 0;
                        owner$iv2 = null;
                        recheckPassed2 = recheckPassed10;
                        rawResponse2 = rawResponse5;
                        map2 = map4;
                        animePahe$Companion$appGet$2 = animePahe$Companion$appGet$4;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                        Requests app8 = MainActivityKt.getApp();
                        CFBypassInterceptor cFBypassInterceptor8 = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$2.L$0 = url3;
                        animePahe$Companion$appGet$2.L$1 = map2;
                        animePahe$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        animePahe$Companion$appGet$2.L$3 = recheckPassed2;
                        animePahe$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                        animePahe$Companion$appGet$2.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        AnimePahe$Companion$appGet$1 animePahe$Companion$appGet$7 = animePahe$Companion$appGet$2;
                        url4 = url3;
                        obj2 = Requests.get$default(app8, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor8, false, (ResponseParser) null, animePahe$Companion$appGet$7, 3580, (Object) null);
                        animePahe$Companion$appGet$3 = animePahe$Companion$appGet$7;
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
                        if (!AnimePahe.INSTANCE.isCloudflareBlocked(recheck)) {
                            Log.INSTANCE.d("AnimePahe", "CF challenge detected on " + url5 + " – showing WebView dialog for user");
                            if (AnimePaheProviderPlugin.INSTANCE.getCfWebviewEnabled()) {
                                animePahe$Companion$appGet$3.L$0 = url5;
                                animePahe$Companion$appGet$3.L$1 = map3;
                                animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                animePahe$Companion$appGet$3.L$3 = recheckPassed4;
                                animePahe$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                animePahe$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                animePahe$Companion$appGet$3.label = 4;
                                if (AnimePaheKt.showCFBypassDialogAndWait(url5, animePahe$Companion$appGet$3) == coroutine_suspended) {
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
                            CFBypassInterceptor cFBypassInterceptor9 = CFBypassInterceptor.INSTANCE;
                            animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed11);
                            animePahe$Companion$appGet$3.L$4 = null;
                            animePahe$Companion$appGet$3.L$5 = null;
                            animePahe$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app9, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor9, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
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
                        CFBypassInterceptor cFBypassInterceptor10 = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed12);
                        animePahe$Companion$appGet$3.L$4 = null;
                        animePahe$Companion$appGet$3.L$5 = null;
                        animePahe$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app10, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor10, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 3:
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) animePahe$Companion$appGet$4.L$4;
                        recheckPassed4 = (Ref.ObjectRef) animePahe$Companion$appGet$4.L$3;
                        rawResponse3 = (NiceResponse) animePahe$Companion$appGet$4.L$2;
                        map3 = (Map) animePahe$Companion$appGet$4.L$1;
                        url5 = (String) animePahe$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        animePahe$Companion$appGet$3 = animePahe$Companion$appGet$4;
                        recheck = (NiceResponse) $result;
                        if (!AnimePahe.INSTANCE.isCloudflareBlocked(recheck)) {
                            Log.INSTANCE.d("AnimePahe", "CF challenge detected on " + url5 + " – showing WebView dialog for user");
                            if (AnimePaheProviderPlugin.INSTANCE.getCfWebviewEnabled()) {
                                animePahe$Companion$appGet$3.L$0 = url5;
                                animePahe$Companion$appGet$3.L$1 = map3;
                                animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                animePahe$Companion$appGet$3.L$3 = recheckPassed4;
                                animePahe$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                animePahe$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                animePahe$Companion$appGet$3.label = 4;
                                if (AnimePaheKt.showCFBypassDialogAndWait(url5, animePahe$Companion$appGet$3) == coroutine_suspended) {
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
                            CFBypassInterceptor cFBypassInterceptor11 = CFBypassInterceptor.INSTANCE;
                            animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                            animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed13);
                            animePahe$Companion$appGet$3.L$4 = null;
                            animePahe$Companion$appGet$3.L$5 = null;
                            animePahe$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app11, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor11, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
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
                        CFBypassInterceptor cFBypassInterceptor12 = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed14);
                        animePahe$Companion$appGet$3.L$4 = null;
                        animePahe$Companion$appGet$3.L$5 = null;
                        animePahe$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app12, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor12, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 4:
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) animePahe$Companion$appGet$4.L$4;
                        recheckPassed4 = (Ref.ObjectRef) animePahe$Companion$appGet$4.L$3;
                        rawResponse3 = (NiceResponse) animePahe$Companion$appGet$4.L$2;
                        map3 = (Map) animePahe$Companion$appGet$4.L$1;
                        url5 = (String) animePahe$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        animePahe$Companion$appGet$3 = animePahe$Companion$appGet$4;
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
                        CFBypassInterceptor cFBypassInterceptor13 = CFBypassInterceptor.INSTANCE;
                        animePahe$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        animePahe$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        animePahe$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        animePahe$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed15);
                        animePahe$Companion$appGet$3.L$4 = null;
                        animePahe$Companion$appGet$3.L$5 = null;
                        animePahe$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app13, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cFBypassInterceptor13, false, (ResponseParser) null, animePahe$Companion$appGet$3, 3580, (Object) null);
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

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"com/phisher98/AnimePahe$getMainPage$Data", "", "anime_title", "", "episode", "", "snapshot", "created_at", "anime_session", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnime_title", "()Ljava/lang/String;", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSnapshot", "getCreated_at", "getAnime_session", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/AnimePahe$getMainPage$Data;", "equals", "", "other", "hashCode", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Data {
        private final String anime_session;
        private final String anime_title;
        private final String created_at;
        private final Integer episode;
        private final String snapshot;

        public static /* synthetic */ Data copy$default(Data data, String str, Integer num, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data.anime_title;
            }
            if ((i & 2) != 0) {
                num = data.episode;
            }
            if ((i & 4) != 0) {
                str2 = data.snapshot;
            }
            if ((i & 8) != 0) {
                str3 = data.created_at;
            }
            if ((i & 16) != 0) {
                str4 = data.anime_session;
            }
            String str5 = str4;
            String str6 = str2;
            return data.copy(str, num, str6, str3, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnime_title() {
            return this.anime_title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSnapshot() {
            return this.snapshot;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCreated_at() {
            return this.created_at;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAnime_session() {
            return this.anime_session;
        }

        public final Data copy(String anime_title, Integer episode, String snapshot, String created_at, String anime_session) {
            return new Data(anime_title, episode, snapshot, created_at, anime_session);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.anime_title, data.anime_title) && Intrinsics.areEqual(this.episode, data.episode) && Intrinsics.areEqual(this.snapshot, data.snapshot) && Intrinsics.areEqual(this.created_at, data.created_at) && Intrinsics.areEqual(this.anime_session, data.anime_session);
        }

        public int hashCode() {
            return (((((((this.anime_title.hashCode() * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.snapshot == null ? 0 : this.snapshot.hashCode())) * 31) + (this.created_at != null ? this.created_at.hashCode() : 0)) * 31) + this.anime_session.hashCode();
        }

        public String toString() {
            return "Data(anime_title=" + this.anime_title + ", episode=" + this.episode + ", snapshot=" + this.snapshot + ", created_at=" + this.created_at + ", anime_session=" + this.anime_session + ')';
        }

        public Data(String anime_title, Integer episode, String snapshot, String created_at, String anime_session) {
            this.anime_title = anime_title;
            this.episode = episode;
            this.snapshot = snapshot;
            this.created_at = created_at;
            this.anime_session = anime_session;
        }

        public final String getAnime_title() {
            return this.anime_title;
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final String getSnapshot() {
            return this.snapshot;
        }

        public final String getCreated_at() {
            return this.created_at;
        }

        public final String getAnime_session() {
            return this.anime_session;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Throwable {
        C00031 c00031;
        MainPageRequest request2;
        Object objAppGet;
        Object objDecodeFromString;
        Object obj;
        Object obj2;
        List episodes;
        Iterable data;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Companion companion = INSTANCE;
                String str = request.getData() + page;
                Map<String, String> map = headers;
                request2 = request;
                c00031.L$0 = request2;
                c00031.I$0 = page;
                c00031.label = 1;
                objAppGet = companion.appGet(str, map, c00031);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00031.I$0;
                MainPageRequest request3 = (MainPageRequest) c00031.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet = $result;
                request2 = request3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String response = ((NiceResponse) objAppGet).getText();
        AppUtils appUtils = AppUtils.INSTANCE;
        if (response == null) {
            objDecodeFromString = null;
        } else {
            try {
                try {
                    Result.Companion companion2 = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(AnimePaheLatestReleases.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    obj2 = null;
                } else {
                    try {
                        Result.Companion companion4 = Result.Companion;
                        obj2 = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePaheLatestReleases.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion5 = Result.Companion;
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
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, response);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(response, new TypeReference<AnimePaheLatestReleases>() { // from class: com.phisher98.AnimePahe$getMainPage$$inlined$tryParseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(response, new TypeReference<AnimePaheLatestReleases>() { // from class: com.phisher98.AnimePahe$getMainPage$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(response, new TypeReference<AnimePaheLatestReleases>() { // from class: com.phisher98.AnimePahe$getMainPage$$inlined$tryParseJson$1
                    });
                }
            } catch (Exception e2) {
                objDecodeFromString = null;
            }
        }
        AnimePaheLatestReleases animePaheLatestReleases = (AnimePaheLatestReleases) objDecodeFromString;
        if (animePaheLatestReleases == null || (data = animePaheLatestReleases.getData()) == null) {
            episodes = null;
        } else {
            Iterable $this$map$iv = data;
            int $i$f$map = 0;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                final Data it = (Data) item$iv$iv;
                destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getAnime_title(), AppUtils.INSTANCE.toJson(new LoadData(it.getAnime_session(), APIHolder.INSTANCE.getUnixTime(), it.getAnime_title())), (TvType) null, false, new Function1() { // from class: com.phisher98.AnimePahe$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        return AnimePahe.getMainPage$lambda$0$0(it, (AnimeSearchResponse) obj3);
                    }
                }, 4, (Object) null));
                $this$map$iv = $this$map$iv;
                $i$f$map = $i$f$map;
                $result = $result;
                c00031 = c00031;
            }
            episodes = (List) destination$iv$iv;
        }
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), episodes == null ? CollectionsKt.emptyList() : episodes, true), Boxing.boxBoolean(true));
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0002\u0000\u0006\b\u008a\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J(\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"com/phisher98/AnimePahe$getMainPage$AnimePaheLatestReleases", "", "total", "", "data", "", "com/phisher98/AnimePahe$getMainPage$Data", "<init>", "(ILjava/util/List;)V", "getTotal", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "(ILjava/util/List;)Lcom/phisher98/AnimePahe$getMainPage$AnimePaheLatestReleases;", "equals", "", "other", "hashCode", "toString", "", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimePaheLatestReleases {
        private final List<Data> data;
        private final int total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimePaheLatestReleases copy$default(AnimePaheLatestReleases animePaheLatestReleases, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = animePaheLatestReleases.total;
            }
            if ((i2 & 2) != 0) {
                list = animePaheLatestReleases.data;
            }
            return animePaheLatestReleases.copy(i, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final List<Data> component2() {
            return this.data;
        }

        public final AnimePaheLatestReleases copy(int total, List<Data> data) {
            return new AnimePaheLatestReleases(total, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimePaheLatestReleases)) {
                return false;
            }
            AnimePaheLatestReleases animePaheLatestReleases = (AnimePaheLatestReleases) other;
            return this.total == animePaheLatestReleases.total && Intrinsics.areEqual(this.data, animePaheLatestReleases.data);
        }

        public int hashCode() {
            return (this.total * 31) + this.data.hashCode();
        }

        public String toString() {
            return "AnimePaheLatestReleases(total=" + this.total + ", data=" + this.data + ')';
        }

        public AnimePaheLatestReleases(int total, List<Data> list) {
            this.total = total;
            this.data = list;
        }

        public final int getTotal() {
            return this.total;
        }

        public final List<Data> getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(Data $it, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($it.getSnapshot());
        $this$newAnimeSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, DubStatus.Subbed, $it.getEpisode());
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009a\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00101J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00106\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00067"}, d2 = {"Lcom/phisher98/AnimePahe$AnimePaheSearchData;", "", "id", "", "slug", "", "title", "type", "episodes", "status", "season", "year", "score", "", "poster", "session", "relevance", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlug", "()Ljava/lang/String;", "getTitle", "getType", "getEpisodes", "getStatus", "getSeason", "getYear", "getScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPoster", "getSession", "getRelevance", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/AnimePahe$AnimePaheSearchData;", "equals", "", "other", "hashCode", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimePaheSearchData {

        @Nullable
        private final Integer episodes;

        @Nullable
        private final Integer id;

        @Nullable
        private final String poster;

        @Nullable
        private final String relevance;

        @Nullable
        private final Double score;

        @Nullable
        private final String season;

        @NotNull
        private final String session;

        @Nullable
        private final String slug;

        @Nullable
        private final String status;

        @NotNull
        private final String title;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public static /* synthetic */ AnimePaheSearchData copy$default(AnimePaheSearchData animePaheSearchData, Integer num, String str, String str2, String str3, Integer num2, String str4, String str5, Integer num3, Double d, String str6, String str7, String str8, int i, Object obj) {
            if ((i & 1) != 0) {
                num = animePaheSearchData.id;
            }
            if ((i & 2) != 0) {
                str = animePaheSearchData.slug;
            }
            if ((i & 4) != 0) {
                str2 = animePaheSearchData.title;
            }
            if ((i & 8) != 0) {
                str3 = animePaheSearchData.type;
            }
            if ((i & 16) != 0) {
                num2 = animePaheSearchData.episodes;
            }
            if ((i & 32) != 0) {
                str4 = animePaheSearchData.status;
            }
            if ((i & 64) != 0) {
                str5 = animePaheSearchData.season;
            }
            if ((i & 128) != 0) {
                num3 = animePaheSearchData.year;
            }
            if ((i & 256) != 0) {
                d = animePaheSearchData.score;
            }
            if ((i & 512) != 0) {
                str6 = animePaheSearchData.poster;
            }
            if ((i & 1024) != 0) {
                str7 = animePaheSearchData.session;
            }
            if ((i & 2048) != 0) {
                str8 = animePaheSearchData.relevance;
            }
            String str9 = str7;
            String str10 = str8;
            Double d2 = d;
            String str11 = str6;
            String str12 = str5;
            Integer num4 = num3;
            Integer num5 = num2;
            String str13 = str4;
            return animePaheSearchData.copy(num, str, str2, str3, num5, str13, str12, num4, d2, str11, str9, str10);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getSession() {
            return this.session;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getRelevance() {
            return this.relevance;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getEpisodes() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Double getScore() {
            return this.score;
        }

        @NotNull
        public final AnimePaheSearchData copy(@Nullable Integer id, @Nullable String slug, @NotNull String title, @Nullable String type, @Nullable Integer episodes, @Nullable String status, @Nullable String season, @Nullable Integer year, @Nullable Double score, @Nullable String poster, @NotNull String session, @Nullable String relevance) {
            return new AnimePaheSearchData(id, slug, title, type, episodes, status, season, year, score, poster, session, relevance);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimePaheSearchData)) {
                return false;
            }
            AnimePaheSearchData animePaheSearchData = (AnimePaheSearchData) other;
            return Intrinsics.areEqual(this.id, animePaheSearchData.id) && Intrinsics.areEqual(this.slug, animePaheSearchData.slug) && Intrinsics.areEqual(this.title, animePaheSearchData.title) && Intrinsics.areEqual(this.type, animePaheSearchData.type) && Intrinsics.areEqual(this.episodes, animePaheSearchData.episodes) && Intrinsics.areEqual(this.status, animePaheSearchData.status) && Intrinsics.areEqual(this.season, animePaheSearchData.season) && Intrinsics.areEqual(this.year, animePaheSearchData.year) && Intrinsics.areEqual(this.score, animePaheSearchData.score) && Intrinsics.areEqual(this.poster, animePaheSearchData.poster) && Intrinsics.areEqual(this.session, animePaheSearchData.session) && Intrinsics.areEqual(this.relevance, animePaheSearchData.relevance);
        }

        public int hashCode() {
            return ((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + this.title.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.score == null ? 0 : this.score.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + this.session.hashCode()) * 31) + (this.relevance != null ? this.relevance.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnimePaheSearchData(id=").append(this.id).append(", slug=").append(this.slug).append(", title=").append(this.title).append(", type=").append(this.type).append(", episodes=").append(this.episodes).append(", status=").append(this.status).append(", season=").append(this.season).append(", year=").append(this.year).append(", score=").append(this.score).append(", poster=").append(this.poster).append(", session=").append(this.session).append(", relevance=");
            sb.append(this.relevance).append(')');
            return sb.toString();
        }

        public AnimePaheSearchData(@Nullable Integer id, @Nullable String slug, @NotNull String title, @Nullable String type, @Nullable Integer episodes, @Nullable String status, @Nullable String season, @Nullable Integer year, @Nullable Double score, @Nullable String poster, @NotNull String session, @Nullable String relevance) {
            this.id = id;
            this.slug = slug;
            this.title = title;
            this.type = type;
            this.episodes = episodes;
            this.status = status;
            this.season = season;
            this.year = year;
            this.score = score;
            this.poster = poster;
            this.session = session;
            this.relevance = relevance;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Integer getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final Double getScore() {
            return this.score;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getSession() {
            return this.session;
        }

        @Nullable
        public final String getRelevance() {
            return this.relevance;
        }
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AnimePahe$AnimePaheSearch;", "", "total", "", "data", "", "Lcom/phisher98/AnimePahe$AnimePaheSearchData;", "<init>", "(ILjava/util/List;)V", "getTotal", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimePaheSearch {

        @NotNull
        private final List<AnimePaheSearchData> data;
        private final int total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimePaheSearch copy$default(AnimePaheSearch animePaheSearch, int i, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = animePaheSearch.total;
            }
            if ((i2 & 2) != 0) {
                list = animePaheSearch.data;
            }
            return animePaheSearch.copy(i, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        @NotNull
        public final List<AnimePaheSearchData> component2() {
            return this.data;
        }

        @NotNull
        public final AnimePaheSearch copy(int total, @NotNull List<AnimePaheSearchData> data) {
            return new AnimePaheSearch(total, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimePaheSearch)) {
                return false;
            }
            AnimePaheSearch animePaheSearch = (AnimePaheSearch) other;
            return this.total == animePaheSearch.total && Intrinsics.areEqual(this.data, animePaheSearch.data);
        }

        public int hashCode() {
            return (this.total * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnimePaheSearch(total=" + this.total + ", data=" + this.data + ')';
        }

        public AnimePaheSearch(int total, @NotNull List<AnimePaheSearchData> list) {
            this.total = total;
            this.data = list;
        }

        public final int getTotal() {
            return this.total;
        }

        @NotNull
        public final List<AnimePaheSearchData> getData() {
            return this.data;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Throwable {
        C00081 c00081;
        String url;
        Object objAppGet;
        Object obj;
        Object obj2;
        Object obj3;
        Object objDecodeFromString;
        Iterable data;
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
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url = getMainUrl() + "/api?m=search&l=8&q=" + query;
                Map<String, String> mapPlus = MapsKt.plus(headers, MapsKt.mapOf(TuplesKt.to("referer", getMainUrl() + '/')));
                Companion companion = INSTANCE;
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(mapPlus);
                c00082.label = 1;
                objAppGet = companion.appGet(url, mapPlus, c00082);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                url = (String) c00082.L$1;
                ResultKt.throwOnFailure($result);
                objAppGet = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String req = ((NiceResponse) objAppGet).getText();
        AppUtils appUtils = AppUtils.INSTANCE;
        if (req == null) {
            obj2 = null;
        } else {
            try {
                try {
                    Result.Companion companion2 = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(AnimePaheSearch.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    obj3 = null;
                } else {
                    try {
                        Result.Companion companion4 = Result.Companion;
                        obj3 = null;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePaheSearch.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion5 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj3 = null;
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = obj3;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, req);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(req, new TypeReference<AnimePaheSearch>() { // from class: com.phisher98.AnimePahe$search$$inlined$tryParseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(req, new TypeReference<AnimePaheSearch>() { // from class: com.phisher98.AnimePahe$search$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(req, new TypeReference<AnimePaheSearch>() { // from class: com.phisher98.AnimePahe$search$$inlined$tryParseJson$1
                    });
                }
                obj2 = objDecodeFromString;
            } catch (Exception e2) {
                obj2 = null;
            }
        }
        AnimePaheSearch data2 = (AnimePaheSearch) obj2;
        if (data2 == null || (data = data2.getData()) == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = data;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final AnimePaheSearchData it = (AnimePaheSearchData) item$iv$iv;
            destination$iv$iv.add(MainAPIKt.newAnimeSearchResponse$default(this, it.getTitle(), AppUtils.INSTANCE.toJson(new LoadData(it.getSession(), APIHolder.INSTANCE.getUnixTime(), it.getTitle())), (TvType) null, false, new Function1() { // from class: com.phisher98.AnimePahe$$ExternalSyntheticLambda1
                public final Object invoke(Object obj4) {
                    return AnimePahe.search$lambda$0$0(it, (AnimeSearchResponse) obj4);
                }
            }, 4, (Object) null));
            data2 = data2;
            $this$map$iv = $this$map$iv;
            $i$f$map = $i$f$map;
            c00082 = c00082;
            $result = $result;
            url = url;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(AnimePaheSearchData $it, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($it.getPoster());
        $this$newAnimeSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, DubStatus.Subbed, $it.getEpisodes());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006&"}, d2 = {"Lcom/phisher98/AnimePahe$AnimeData;", "", "id", "", "anime_id", "episode", "title", "", "snapshot", "session", "filler", "created_at", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()I", "getAnime_id", "getEpisode", "getTitle", "()Ljava/lang/String;", "getSnapshot", "getSession", "getFiller", "getCreated_at", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class AnimeData {
        private final int anime_id;

        @NotNull
        private final String created_at;
        private final int episode;
        private final int filler;
        private final int id;

        @NotNull
        private final String session;

        @NotNull
        private final String snapshot;

        @NotNull
        private final String title;

        public static /* synthetic */ AnimeData copy$default(AnimeData animeData, int i, int i2, int i3, String str, String str2, String str3, int i4, String str4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = animeData.id;
            }
            if ((i5 & 2) != 0) {
                i2 = animeData.anime_id;
            }
            if ((i5 & 4) != 0) {
                i3 = animeData.episode;
            }
            if ((i5 & 8) != 0) {
                str = animeData.title;
            }
            if ((i5 & 16) != 0) {
                str2 = animeData.snapshot;
            }
            if ((i5 & 32) != 0) {
                str3 = animeData.session;
            }
            if ((i5 & 64) != 0) {
                i4 = animeData.filler;
            }
            if ((i5 & 128) != 0) {
                str4 = animeData.created_at;
            }
            int i6 = i4;
            String str5 = str4;
            String str6 = str2;
            String str7 = str3;
            return animeData.copy(i, i2, i3, str, str6, str7, i6, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAnime_id() {
            return this.anime_id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEpisode() {
            return this.episode;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSnapshot() {
            return this.snapshot;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSession() {
            return this.session;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getFiller() {
            return this.filler;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getCreated_at() {
            return this.created_at;
        }

        @NotNull
        public final AnimeData copy(int id, int anime_id, int episode, @NotNull String title, @NotNull String snapshot, @NotNull String session, int filler, @NotNull String created_at) {
            return new AnimeData(id, anime_id, episode, title, snapshot, session, filler, created_at);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimeData)) {
                return false;
            }
            AnimeData animeData = (AnimeData) other;
            return this.id == animeData.id && this.anime_id == animeData.anime_id && this.episode == animeData.episode && Intrinsics.areEqual(this.title, animeData.title) && Intrinsics.areEqual(this.snapshot, animeData.snapshot) && Intrinsics.areEqual(this.session, animeData.session) && this.filler == animeData.filler && Intrinsics.areEqual(this.created_at, animeData.created_at);
        }

        public int hashCode() {
            return (((((((((((((this.id * 31) + this.anime_id) * 31) + this.episode) * 31) + this.title.hashCode()) * 31) + this.snapshot.hashCode()) * 31) + this.session.hashCode()) * 31) + this.filler) * 31) + this.created_at.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnimeData(id=" + this.id + ", anime_id=" + this.anime_id + ", episode=" + this.episode + ", title=" + this.title + ", snapshot=" + this.snapshot + ", session=" + this.session + ", filler=" + this.filler + ", created_at=" + this.created_at + ')';
        }

        public AnimeData(int id, int anime_id, int episode, @NotNull String title, @NotNull String snapshot, @NotNull String session, int filler, @NotNull String created_at) {
            this.id = id;
            this.anime_id = anime_id;
            this.episode = episode;
            this.title = title;
            this.snapshot = snapshot;
            this.session = session;
            this.filler = filler;
            this.created_at = created_at;
        }

        public final int getId() {
            return this.id;
        }

        public final int getAnime_id() {
            return this.anime_id;
        }

        public final int getEpisode() {
            return this.episode;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getSnapshot() {
            return this.snapshot;
        }

        @NotNull
        public final String getSession() {
            return this.session;
        }

        public final int getFiller() {
            return this.filler;
        }

        @NotNull
        public final String getCreated_at() {
            return this.created_at;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010+\u001a\u00020\bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/phisher98/AnimePahe$AnimePaheAnimeData;", "", "total", "", "per_page", "current_page", "last_page", "next_page_url", "", "prev_page_url", "from", "to", "data", "", "Lcom/phisher98/AnimePahe$AnimeData;", "<init>", "(IIIILjava/lang/String;Ljava/lang/String;IILjava/util/List;)V", "getTotal", "()I", "getPer_page", "getCurrent_page", "getLast_page", "getNext_page_url", "()Ljava/lang/String;", "getPrev_page_url", "getFrom", "getTo", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class AnimePaheAnimeData {
        private final int current_page;

        @NotNull
        private final List<AnimeData> data;
        private final int from;
        private final int last_page;

        @Nullable
        private final String next_page_url;
        private final int per_page;

        @Nullable
        private final String prev_page_url;
        private final int to;
        private final int total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimePaheAnimeData copy$default(AnimePaheAnimeData animePaheAnimeData, int i, int i2, int i3, int i4, String str, String str2, int i5, int i6, List list, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i = animePaheAnimeData.total;
            }
            if ((i7 & 2) != 0) {
                i2 = animePaheAnimeData.per_page;
            }
            if ((i7 & 4) != 0) {
                i3 = animePaheAnimeData.current_page;
            }
            if ((i7 & 8) != 0) {
                i4 = animePaheAnimeData.last_page;
            }
            if ((i7 & 16) != 0) {
                str = animePaheAnimeData.next_page_url;
            }
            if ((i7 & 32) != 0) {
                str2 = animePaheAnimeData.prev_page_url;
            }
            if ((i7 & 64) != 0) {
                i5 = animePaheAnimeData.from;
            }
            if ((i7 & 128) != 0) {
                i6 = animePaheAnimeData.to;
            }
            if ((i7 & 256) != 0) {
                list = animePaheAnimeData.data;
            }
            int i8 = i6;
            List list2 = list;
            String str3 = str2;
            int i9 = i5;
            String str4 = str;
            int i10 = i3;
            return animePaheAnimeData.copy(i, i2, i10, i4, str4, str3, i9, i8, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPer_page() {
            return this.per_page;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCurrent_page() {
            return this.current_page;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getLast_page() {
            return this.last_page;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNext_page_url() {
            return this.next_page_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPrev_page_url() {
            return this.prev_page_url;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getTo() {
            return this.to;
        }

        @NotNull
        public final List<AnimeData> component9() {
            return this.data;
        }

        @NotNull
        public final AnimePaheAnimeData copy(int total, int per_page, int current_page, int last_page, @Nullable String next_page_url, @Nullable String prev_page_url, int from, int to, @NotNull List<AnimeData> data) {
            return new AnimePaheAnimeData(total, per_page, current_page, last_page, next_page_url, prev_page_url, from, to, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimePaheAnimeData)) {
                return false;
            }
            AnimePaheAnimeData animePaheAnimeData = (AnimePaheAnimeData) other;
            return this.total == animePaheAnimeData.total && this.per_page == animePaheAnimeData.per_page && this.current_page == animePaheAnimeData.current_page && this.last_page == animePaheAnimeData.last_page && Intrinsics.areEqual(this.next_page_url, animePaheAnimeData.next_page_url) && Intrinsics.areEqual(this.prev_page_url, animePaheAnimeData.prev_page_url) && this.from == animePaheAnimeData.from && this.to == animePaheAnimeData.to && Intrinsics.areEqual(this.data, animePaheAnimeData.data);
        }

        public int hashCode() {
            return (((((((((((((((this.total * 31) + this.per_page) * 31) + this.current_page) * 31) + this.last_page) * 31) + (this.next_page_url == null ? 0 : this.next_page_url.hashCode())) * 31) + (this.prev_page_url != null ? this.prev_page_url.hashCode() : 0)) * 31) + this.from) * 31) + this.to) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnimePaheAnimeData(total=" + this.total + ", per_page=" + this.per_page + ", current_page=" + this.current_page + ", last_page=" + this.last_page + ", next_page_url=" + this.next_page_url + ", prev_page_url=" + this.prev_page_url + ", from=" + this.from + ", to=" + this.to + ", data=" + this.data + ')';
        }

        public AnimePaheAnimeData(int total, int per_page, int current_page, int last_page, @Nullable String next_page_url, @Nullable String prev_page_url, int from, int to, @NotNull List<AnimeData> list) {
            this.total = total;
            this.per_page = per_page;
            this.current_page = current_page;
            this.last_page = last_page;
            this.next_page_url = next_page_url;
            this.prev_page_url = prev_page_url;
            this.from = from;
            this.to = to;
            this.data = list;
        }

        public final int getTotal() {
            return this.total;
        }

        public final int getPer_page() {
            return this.per_page;
        }

        public final int getCurrent_page() {
            return this.current_page;
        }

        public final int getLast_page() {
            return this.last_page;
        }

        @Nullable
        public final String getNext_page_url() {
            return this.next_page_url;
        }

        @Nullable
        public final String getPrev_page_url() {
            return this.prev_page_url;
        }

        public final int getFrom() {
            return this.from;
        }

        public final int getTo() {
            return this.to;
        }

        @NotNull
        public final List<AnimeData> getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0014\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/phisher98/AnimePahe$LinkLoadData;", "", "mainUrl", "", "is_play_page", "", "episode_num", "", "page", "session", "episode_session", "<init>", "(Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;)V", "getMainUrl", "()Ljava/lang/String;", "()Z", "getEpisode_num", "()I", "getPage", "getSession", "getEpisode_session", "headers", "", "getUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$LinkLoadData\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,581:1\n73#2,5:582\n296#3,2:587\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$LinkLoadData\n*L\n297#1:582,5\n298#1:587,2\n*E\n"})
    public static final /* data */ class LinkLoadData {
        private final int episode_num;

        @NotNull
        private final String episode_session;

        @NotNull
        private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("Cookie", "__ddg2_=1234567890"));
        private final boolean is_play_page;

        @NotNull
        private final String mainUrl;
        private final int page;

        @NotNull
        private final String session;

        public static /* synthetic */ LinkLoadData copy$default(LinkLoadData linkLoadData, String str, boolean z, int i, int i2, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = linkLoadData.mainUrl;
            }
            if ((i3 & 2) != 0) {
                z = linkLoadData.is_play_page;
            }
            if ((i3 & 4) != 0) {
                i = linkLoadData.episode_num;
            }
            if ((i3 & 8) != 0) {
                i2 = linkLoadData.page;
            }
            if ((i3 & 16) != 0) {
                str2 = linkLoadData.session;
            }
            if ((i3 & 32) != 0) {
                str3 = linkLoadData.episode_session;
            }
            String str4 = str2;
            String str5 = str3;
            return linkLoadData.copy(str, z, i, i2, str4, str5);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMainUrl() {
            return this.mainUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIs_play_page() {
            return this.is_play_page;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEpisode_num() {
            return this.episode_num;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getPage() {
            return this.page;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSession() {
            return this.session;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getEpisode_session() {
            return this.episode_session;
        }

        @NotNull
        public final LinkLoadData copy(@NotNull String mainUrl, boolean is_play_page, int episode_num, int page, @NotNull String session, @NotNull String episode_session) {
            return new LinkLoadData(mainUrl, is_play_page, episode_num, page, session, episode_session);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkLoadData)) {
                return false;
            }
            LinkLoadData linkLoadData = (LinkLoadData) other;
            return Intrinsics.areEqual(this.mainUrl, linkLoadData.mainUrl) && this.is_play_page == linkLoadData.is_play_page && this.episode_num == linkLoadData.episode_num && this.page == linkLoadData.page && Intrinsics.areEqual(this.session, linkLoadData.session) && Intrinsics.areEqual(this.episode_session, linkLoadData.episode_session);
        }

        public int hashCode() {
            return (((((((((this.mainUrl.hashCode() * 31) + AnimePahe$LinkLoadData$$ExternalSyntheticBackport0.m0m(this.is_play_page)) * 31) + this.episode_num) * 31) + this.page) * 31) + this.session.hashCode()) * 31) + this.episode_session.hashCode();
        }

        @NotNull
        public String toString() {
            return "LinkLoadData(mainUrl=" + this.mainUrl + ", is_play_page=" + this.is_play_page + ", episode_num=" + this.episode_num + ", page=" + this.page + ", session=" + this.session + ", episode_session=" + this.episode_session + ')';
        }

        public LinkLoadData(@NotNull String mainUrl, boolean is_play_page, int episode_num, int page, @NotNull String session, @NotNull String episode_session) {
            this.mainUrl = mainUrl;
            this.is_play_page = is_play_page;
            this.episode_num = episode_num;
            this.page = page;
            this.session = session;
            this.episode_session = episode_session;
        }

        @NotNull
        public final String getMainUrl() {
            return this.mainUrl;
        }

        public final boolean is_play_page() {
            return this.is_play_page;
        }

        public final int getEpisode_num() {
            return this.episode_num;
        }

        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final String getSession() {
            return this.session;
        }

        @NotNull
        public final String getEpisode_session() {
            return this.episode_session;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        @Nullable
        public final Object getUrl(@NotNull Continuation<? super String> continuation) throws Throwable {
            AnimePahe$LinkLoadData$getUrl$1 animePahe$LinkLoadData$getUrl$1;
            Object objAppGet;
            Object safe;
            Object obj;
            Object element$iv;
            String episode;
            if (continuation instanceof AnimePahe$LinkLoadData$getUrl$1) {
                animePahe$LinkLoadData$getUrl$1 = (AnimePahe$LinkLoadData$getUrl$1) continuation;
                if ((animePahe$LinkLoadData$getUrl$1.label & Integer.MIN_VALUE) != 0) {
                    animePahe$LinkLoadData$getUrl$1.label -= Integer.MIN_VALUE;
                } else {
                    animePahe$LinkLoadData$getUrl$1 = new AnimePahe$LinkLoadData$getUrl$1(this, continuation);
                }
            } else {
                animePahe$LinkLoadData$getUrl$1 = new AnimePahe$LinkLoadData$getUrl$1(this, continuation);
            }
            AnimePahe$LinkLoadData$getUrl$1 animePahe$LinkLoadData$getUrl$2 = animePahe$LinkLoadData$getUrl$1;
            Object $result = animePahe$LinkLoadData$getUrl$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (animePahe$LinkLoadData$getUrl$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.is_play_page) {
                        return this.mainUrl + "/play/" + this.session + '/' + this.episode_session;
                    }
                    String url = this.mainUrl + "/api?m=release&id=" + this.session + "&sort=episode_asc&page=" + (this.page + 1);
                    Companion companion = AnimePahe.INSTANCE;
                    Map<String, String> map = this.headers;
                    animePahe$LinkLoadData$getUrl$2.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    animePahe$LinkLoadData$getUrl$2.label = 1;
                    objAppGet = companion.appGet(url, map, animePahe$LinkLoadData$getUrl$2);
                    if (objAppGet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAppGet = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) objAppGet;
            Object obj2 = null;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AnimePaheAnimeData.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                safe = null;
            }
            AnimePaheAnimeData jsonResponse = (AnimePaheAnimeData) safe;
            if (jsonResponse != null) {
                Iterable $this$firstOrNull$iv = jsonResponse.getData();
                Iterator it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        AnimeData it2 = (AnimeData) element$iv;
                        obj = obj2;
                        if (!(it2.getEpisode() == this.episode_num)) {
                            obj2 = obj;
                        }
                    } else {
                        obj = obj2;
                        element$iv = obj;
                    }
                }
                AnimeData animeData = (AnimeData) element$iv;
                if (animeData == null || (episode = animeData.getSession()) == null) {
                    return obj;
                }
                return this.mainUrl + "/play/" + this.session + '/' + episode;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:112:0x0298  */
    /* JADX WARN: Code duplicated, block: B:116:0x02c3 A[Catch: Exception -> 0x03ab, TRY_LEAVE, TryCatch #2 {Exception -> 0x03ab, blocks: (B:113:0x029e, B:114:0x02bd, B:116:0x02c3), top: B:146:0x029e }] */
    /* JADX WARN: Code duplicated, block: B:121:0x037e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x037f  */
    /* JADX WARN: Code duplicated, block: B:142:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0105  */
    /* JADX WARN: Code duplicated, block: B:33:0x010a  */
    /* JADX WARN: Code duplicated, block: B:40:0x013b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0177  */
    /* JADX WARN: Code duplicated, block: B:72:0x019e  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x01c5 A[Catch: Exception -> 0x01cb, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x01cb, blocks: (B:84:0x01c5, B:99:0x021c), top: B:148:0x01c3 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:91:0x01eb A[ADDED_TO_REGION] */
    public final Object generateListOfEpisodes(String session, Map<String, MetaEpisode> map, Continuation<? super ArrayList<Episode>> continuation) throws Throwable {
        C00001 c00001;
        ArrayList episodes;
        Semaphore semaphore;
        Map<String, MetaEpisode> map2;
        String session2;
        String uri;
        Object obj;
        Map<String, MetaEpisode> map3;
        String session3;
        Semaphore semaphore2;
        String req;
        Semaphore semaphore3;
        Object obj2;
        Object objDecodeFromString;
        Semaphore semaphore4;
        DeserializationStrategy deserializationStrategy;
        String value$iv$iv;
        AnimePaheAnimeData animePaheAnimeData;
        AnimePaheAnimeData data;
        int last_page;
        int per_page;
        int total;
        Ref.IntRef currentEpisode;
        int per_page2;
        int total2;
        Map<String, MetaEpisode> map4;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        IntIterator it;
        Map<String, MetaEpisode> map5;
        Semaphore semaphore5;
        Object objAwaitAll;
        Map<String, MetaEpisode> map6;
        ArrayList arrayList;
        String session4;
        String epNum;
        MetaEpisode metaEpisode;
        AnimePahe animePahe = this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = animePahe.new C00001(continuation);
            }
        } else {
            c00001 = animePahe.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                episodes = new ArrayList();
                semaphore = SemaphoreKt.Semaphore$default(5, 0, 2, (Object) null);
                try {
                    String uri2 = animePahe.getMainUrl() + "/api?m=release&id=" + session + "&sort=episode_asc&page=1";
                    Companion companion = INSTANCE;
                    Map<String, String> map7 = headers;
                    c00002.L$0 = session;
                    map2 = map;
                    try {
                        c00002.L$1 = map2;
                        c00002.L$2 = episodes;
                        c00002.L$3 = semaphore;
                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(uri2);
                        c00002.label = 1;
                        Object objAppGet = companion.appGet(uri2, map7, c00002);
                        if (objAppGet == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        uri = uri2;
                        obj = objAppGet;
                        map3 = map2;
                        session3 = session;
                        semaphore2 = semaphore;
                        try {
                            req = ((NiceResponse) obj).getText();
                            AppUtils appUtils = AppUtils.INSTANCE;
                            if (req != null) {
                                semaphore3 = semaphore2;
                                objDecodeFromString = null;
                            } else {
                                try {
                                    try {
                                        Result.Companion companion2 = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(AnimePaheAnimeData.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    } catch (Throwable th) {
                                        Result.Companion companion3 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (Result.exceptionOrNull-impl(obj2) != null) {
                                        semaphore3 = semaphore2;
                                        semaphore4 = null;
                                    } else {
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            try {
                                                semaphore3 = semaphore2;
                                                semaphore4 = null;
                                                try {
                                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePaheAnimeData.class), (List) null, 2, (Object) null));
                                                    break;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    try {
                                                        Result.Companion companion5 = Result.Companion;
                                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Exception e) {
                                                        objDecodeFromString = null;
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                semaphore3 = semaphore2;
                                                semaphore4 = null;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            semaphore3 = semaphore2;
                                            semaphore4 = null;
                                        }
                                    }
                                    if (Result.isFailure-impl(obj2)) {
                                        obj2 = semaphore4;
                                    }
                                    deserializationStrategy = (KSerializer) obj2;
                                    if (deserializationStrategy != null) {
                                        try {
                                            value$iv$iv = req;
                                            try {
                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                            } catch (SerializationException e2) {
                                                e$iv$iv = e2;
                                                ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                String content$iv$iv$iv = value$iv$iv;
                                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$$inlined$tryParseJson$1
                                                });
                                            } catch (Throwable th5) {
                                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                String content$iv$iv$iv2 = value$iv$iv;
                                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$$inlined$tryParseJson$1
                                                });
                                            }
                                        } catch (SerializationException e3) {
                                            e$iv$iv = e3;
                                            value$iv$iv = req;
                                        } catch (Throwable th6) {
                                            value$iv$iv = req;
                                        }
                                    } else {
                                        value$iv$iv = req;
                                    }
                                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                    String content$iv$iv$iv3 = value$iv$iv;
                                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$$inlined$tryParseJson$1
                                    });
                                } catch (Exception e4) {
                                    semaphore3 = semaphore2;
                                    objDecodeFromString = null;
                                    animePaheAnimeData = (AnimePaheAnimeData) objDecodeFromString;
                                    try {
                                        if (animePaheAnimeData == null) {
                                            return new ArrayList();
                                        }
                                        data = animePaheAnimeData;
                                        last_page = data.getLast_page();
                                        per_page = data.getPer_page();
                                        total = data.getTotal();
                                        currentEpisode = new Ref.IntRef();
                                        currentEpisode.element = 1;
                                        if (last_page != 1) {
                                            per_page2 = per_page;
                                            total2 = total;
                                            map4 = map3;
                                            try {
                                                $this$map$iv = new IntRange(1, last_page);
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                it = $this$map$iv.iterator();
                                                while (it.hasNext()) {
                                                    int item$iv$iv = it.nextInt();
                                                    int last_page2 = last_page;
                                                    Map<String, MetaEpisode> map8 = map4;
                                                    AnimePaheAnimeData data2 = data;
                                                    int total3 = total2;
                                                    session2 = session3;
                                                    Iterable $this$map$iv2 = $this$map$iv;
                                                    Object $result2 = $result;
                                                    int per_page3 = per_page2;
                                                    semaphore5 = semaphore3;
                                                    String uri3 = uri;
                                                    Collection destination$iv$iv2 = destination$iv$iv;
                                                    try {
                                                        destination$iv$iv2.add(BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnimePahe$generateListOfEpisodes$deferredResults$1$1(semaphore5, this, session2, item$iv$iv, map8, currentEpisode, null), 3, (Object) null));
                                                        last_page = last_page2;
                                                        per_page2 = per_page3;
                                                        destination$iv$iv = destination$iv$iv2;
                                                        $result = $result2;
                                                        uri = uri3;
                                                        semaphore3 = semaphore5;
                                                        total2 = total3;
                                                        $this$map$iv = $this$map$iv2;
                                                        data = data2;
                                                        session3 = session2;
                                                        map4 = map8;
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        semaphore = semaphore5;
                                                    }
                                                }
                                                map5 = map4;
                                                int last_page3 = last_page;
                                                session2 = session3;
                                                semaphore5 = semaphore3;
                                                List deferredResults = (List) destination$iv$iv;
                                                c00002.L$0 = SpillingKt.nullOutSpilledVariable(session2);
                                                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                                                c00002.L$2 = episodes;
                                                c00002.L$3 = SpillingKt.nullOutSpilledVariable(semaphore5);
                                                c00002.L$4 = SpillingKt.nullOutSpilledVariable(uri);
                                                c00002.L$5 = SpillingKt.nullOutSpilledVariable(req);
                                                c00002.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                                c00002.L$7 = SpillingKt.nullOutSpilledVariable(currentEpisode);
                                                c00002.L$8 = SpillingKt.nullOutSpilledVariable(deferredResults);
                                                c00002.L$9 = episodes;
                                                c00002.I$0 = last_page3;
                                                c00002.I$1 = per_page2;
                                                c00002.I$2 = total2;
                                                c00002.label = 2;
                                                objAwaitAll = AwaitKt.awaitAll(deferredResults, c00002);
                                                if (objAwaitAll == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                map6 = map5;
                                                arrayList = episodes;
                                                semaphore = semaphore5;
                                                session4 = session2;
                                                try {
                                                    Boxing.boxBoolean(arrayList.addAll(CollectionsKt.flatten((Iterable) objAwaitAll)));
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    session2 = session4;
                                                    Log.INSTANCE.e("generateListOfEpisodes", "Error generating episodes: " + e.getMessage());
                                                }
                                            } catch (Exception e7) {
                                                e = e7;
                                                session2 = session3;
                                                semaphore = semaphore3;
                                            }
                                        } else {
                                            per_page2 = per_page;
                                            total2 = total;
                                            map4 = map3;
                                            $this$map$iv = new IntRange(1, last_page);
                                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                            it = $this$map$iv.iterator();
                                            while (it.hasNext()) {
                                                int item$iv$iv2 = it.nextInt();
                                                int last_page4 = last_page;
                                                Map<String, MetaEpisode> map9 = map4;
                                                AnimePaheAnimeData data3 = data;
                                                int total4 = total2;
                                                session2 = session3;
                                                Iterable $this$map$iv3 = $this$map$iv;
                                                Object $result3 = $result;
                                                int per_page4 = per_page2;
                                                semaphore5 = semaphore3;
                                                String uri4 = uri;
                                                Collection destination$iv$iv3 = destination$iv$iv;
                                                destination$iv$iv3.add(BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnimePahe$generateListOfEpisodes$deferredResults$1$1(semaphore5, this, session2, item$iv$iv2, map9, currentEpisode, null), 3, (Object) null));
                                                last_page = last_page4;
                                                per_page2 = per_page4;
                                                destination$iv$iv = destination$iv$iv3;
                                                $result = $result3;
                                                uri = uri4;
                                                semaphore3 = semaphore5;
                                                total2 = total4;
                                                $this$map$iv = $this$map$iv3;
                                                data = data3;
                                                session3 = session2;
                                                map4 = map9;
                                            }
                                            map5 = map4;
                                            int last_page5 = last_page;
                                            session2 = session3;
                                            semaphore5 = semaphore3;
                                            List deferredResults2 = (List) destination$iv$iv;
                                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(session2);
                                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                                            c00002.L$2 = episodes;
                                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(semaphore5);
                                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(uri);
                                            c00002.L$5 = SpillingKt.nullOutSpilledVariable(req);
                                            c00002.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                            c00002.L$7 = SpillingKt.nullOutSpilledVariable(currentEpisode);
                                            c00002.L$8 = SpillingKt.nullOutSpilledVariable(deferredResults2);
                                            c00002.L$9 = episodes;
                                            c00002.I$0 = last_page5;
                                            c00002.I$1 = per_page2;
                                            c00002.I$2 = total2;
                                            c00002.label = 2;
                                            objAwaitAll = AwaitKt.awaitAll(deferredResults2, c00002);
                                            if (objAwaitAll == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            map6 = map5;
                                            arrayList = episodes;
                                            semaphore = semaphore5;
                                            session4 = session2;
                                            Boxing.boxBoolean(arrayList.addAll(CollectionsKt.flatten((Iterable) objAwaitAll)));
                                        }
                                        return episodes;
                                    } catch (Exception e8) {
                                        e = e8;
                                        semaphore = semaphore3;
                                        session2 = session3;
                                    }
                                    Log.INSTANCE.e("generateListOfEpisodes", "Error generating episodes: " + e.getMessage());
                                    return episodes;
                                }
                            }
                            try {
                                animePaheAnimeData = (AnimePaheAnimeData) objDecodeFromString;
                                if (animePaheAnimeData == null) {
                                    return new ArrayList();
                                }
                                data = animePaheAnimeData;
                                last_page = data.getLast_page();
                                per_page = data.getPer_page();
                                total = data.getTotal();
                                currentEpisode = new Ref.IntRef();
                                currentEpisode.element = 1;
                                if (last_page != 1 && per_page > total) {
                                    try {
                                        Iterable $this$forEach$iv = data.getData();
                                        for (Object element$iv : $this$forEach$iv) {
                                            final AnimeData episodeData = (AnimeData) element$iv;
                                            String epNum2 = String.valueOf(episodeData.getEpisode());
                                            if (map3 != null) {
                                                epNum = epNum2;
                                                metaEpisode = map3.get(epNum);
                                            } else {
                                                epNum = epNum2;
                                                metaEpisode = null;
                                            }
                                            final MetaEpisode meta = metaEpisode;
                                            AnimePahe animePahe2 = animePahe;
                                            AppUtils appUtils2 = AppUtils.INSTANCE;
                                            LinkLoadData linkLoadData = new LinkLoadData(getMainUrl(), true, 0, 0, session3, episodeData.getSession());
                                            int total5 = total;
                                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                                            Map<String, MetaEpisode> map10 = map3;
                                            try {
                                                episodes.add(MainAPIKt.newEpisode(animePahe2, appUtils2.toJson(linkLoadData), new Function1() { // from class: com.phisher98.AnimePahe$$ExternalSyntheticLambda0
                                                    public final Object invoke(Object obj3) {
                                                        return AnimePahe.generateListOfEpisodes$lambda$1$0(episodeData, meta, (Episode) obj3);
                                                    }
                                                }));
                                                animePahe = this;
                                                map3 = map10;
                                                total = total5;
                                                $this$forEach$iv = $this$forEach$iv2;
                                                per_page = per_page;
                                            } catch (Exception e9) {
                                                e = e9;
                                                semaphore = semaphore3;
                                                session2 = session3;
                                            }
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                        semaphore = semaphore3;
                                        session2 = session3;
                                    }
                                    return episodes;
                                }
                                per_page2 = per_page;
                                total2 = total;
                                map4 = map3;
                                $this$map$iv = new IntRange(1, last_page);
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                it = $this$map$iv.iterator();
                                while (it.hasNext()) {
                                    int item$iv$iv3 = it.nextInt();
                                    int last_page6 = last_page;
                                    Map<String, MetaEpisode> map11 = map4;
                                    AnimePaheAnimeData data4 = data;
                                    int total6 = total2;
                                    session2 = session3;
                                    Iterable $this$map$iv4 = $this$map$iv;
                                    Object $result4 = $result;
                                    int per_page5 = per_page2;
                                    semaphore5 = semaphore3;
                                    String uri5 = uri;
                                    Collection destination$iv$iv4 = destination$iv$iv;
                                    destination$iv$iv4.add(BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnimePahe$generateListOfEpisodes$deferredResults$1$1(semaphore5, this, session2, item$iv$iv3, map11, currentEpisode, null), 3, (Object) null));
                                    last_page = last_page6;
                                    per_page2 = per_page5;
                                    destination$iv$iv = destination$iv$iv4;
                                    $result = $result4;
                                    uri = uri5;
                                    semaphore3 = semaphore5;
                                    total2 = total6;
                                    $this$map$iv = $this$map$iv4;
                                    data = data4;
                                    session3 = session2;
                                    map4 = map11;
                                }
                                map5 = map4;
                                int last_page7 = last_page;
                                session2 = session3;
                                semaphore5 = semaphore3;
                                List deferredResults3 = (List) destination$iv$iv;
                                c00002.L$0 = SpillingKt.nullOutSpilledVariable(session2);
                                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                                c00002.L$2 = episodes;
                                c00002.L$3 = SpillingKt.nullOutSpilledVariable(semaphore5);
                                c00002.L$4 = SpillingKt.nullOutSpilledVariable(uri);
                                c00002.L$5 = SpillingKt.nullOutSpilledVariable(req);
                                c00002.L$6 = SpillingKt.nullOutSpilledVariable(data);
                                c00002.L$7 = SpillingKt.nullOutSpilledVariable(currentEpisode);
                                c00002.L$8 = SpillingKt.nullOutSpilledVariable(deferredResults3);
                                c00002.L$9 = episodes;
                                c00002.I$0 = last_page7;
                                c00002.I$1 = per_page2;
                                c00002.I$2 = total2;
                                c00002.label = 2;
                                objAwaitAll = AwaitKt.awaitAll(deferredResults3, c00002);
                                if (objAwaitAll == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                map6 = map5;
                                arrayList = episodes;
                                semaphore = semaphore5;
                                session4 = session2;
                                Boxing.boxBoolean(arrayList.addAll(CollectionsKt.flatten((Iterable) objAwaitAll)));
                                return episodes;
                            } catch (Exception e11) {
                                e = e11;
                                session2 = session3;
                                semaphore = semaphore3;
                            }
                            break;
                        } catch (Exception e12) {
                            e = e12;
                            session2 = session3;
                            semaphore = semaphore2;
                        }
                        Log.INSTANCE.e("generateListOfEpisodes", "Error generating episodes: " + e.getMessage());
                        return episodes;
                    } catch (Exception e13) {
                        e = e13;
                        session2 = session;
                    }
                } catch (Exception e14) {
                    e = e14;
                    map2 = map;
                }
                break;
            case 1:
                String uri6 = (String) c00002.L$4;
                semaphore = (Semaphore) c00002.L$3;
                episodes = (ArrayList) c00002.L$2;
                map3 = (Map) c00002.L$1;
                String session5 = (String) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    uri = uri6;
                    obj = $result;
                    session3 = session5;
                    semaphore2 = semaphore;
                    req = ((NiceResponse) obj).getText();
                    AppUtils appUtils3 = AppUtils.INSTANCE;
                    if (req != null) {
                        Result.Companion companion6 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(AnimePaheAnimeData.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            Result.Companion companion7 = Result.Companion;
                            semaphore3 = semaphore2;
                            semaphore4 = null;
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimePaheAnimeData.class), (List) null, 2, (Object) null));
                        } else {
                            semaphore3 = semaphore2;
                            semaphore4 = null;
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = semaphore4;
                        }
                        deserializationStrategy = (KSerializer) obj2;
                        if (deserializationStrategy != null) {
                            value$iv$iv = req;
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                        } else {
                            value$iv$iv = req;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        String content$iv$iv$iv4 = value$iv$iv;
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv4, new TypeReference<AnimePaheAnimeData>() { // from class: com.phisher98.AnimePahe$generateListOfEpisodes$$inlined$tryParseJson$1
                        });
                        break;
                    } else {
                        semaphore3 = semaphore2;
                        objDecodeFromString = null;
                    }
                    animePaheAnimeData = (AnimePaheAnimeData) objDecodeFromString;
                    if (animePaheAnimeData == null) {
                        return new ArrayList();
                    }
                    data = animePaheAnimeData;
                    last_page = data.getLast_page();
                    per_page = data.getPer_page();
                    total = data.getTotal();
                    currentEpisode = new Ref.IntRef();
                    currentEpisode.element = 1;
                    if (last_page != 1) {
                        per_page2 = per_page;
                        total2 = total;
                        map4 = map3;
                        $this$map$iv = new IntRange(1, last_page);
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        it = $this$map$iv.iterator();
                        while (it.hasNext()) {
                            int item$iv$iv4 = it.nextInt();
                            int last_page8 = last_page;
                            Map<String, MetaEpisode> map12 = map4;
                            AnimePaheAnimeData data5 = data;
                            int total7 = total2;
                            session2 = session3;
                            Iterable $this$map$iv5 = $this$map$iv;
                            Object $result5 = $result;
                            int per_page6 = per_page2;
                            semaphore5 = semaphore3;
                            String uri7 = uri;
                            Collection destination$iv$iv5 = destination$iv$iv;
                            destination$iv$iv5.add(BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnimePahe$generateListOfEpisodes$deferredResults$1$1(semaphore5, this, session2, item$iv$iv4, map12, currentEpisode, null), 3, (Object) null));
                            last_page = last_page8;
                            per_page2 = per_page6;
                            destination$iv$iv = destination$iv$iv5;
                            $result = $result5;
                            uri = uri7;
                            semaphore3 = semaphore5;
                            total2 = total7;
                            $this$map$iv = $this$map$iv5;
                            data = data5;
                            session3 = session2;
                            map4 = map12;
                        }
                        map5 = map4;
                        int last_page9 = last_page;
                        session2 = session3;
                        semaphore5 = semaphore3;
                        List deferredResults4 = (List) destination$iv$iv;
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable(session2);
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                        c00002.L$2 = episodes;
                        c00002.L$3 = SpillingKt.nullOutSpilledVariable(semaphore5);
                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(uri);
                        c00002.L$5 = SpillingKt.nullOutSpilledVariable(req);
                        c00002.L$6 = SpillingKt.nullOutSpilledVariable(data);
                        c00002.L$7 = SpillingKt.nullOutSpilledVariable(currentEpisode);
                        c00002.L$8 = SpillingKt.nullOutSpilledVariable(deferredResults4);
                        c00002.L$9 = episodes;
                        c00002.I$0 = last_page9;
                        c00002.I$1 = per_page2;
                        c00002.I$2 = total2;
                        c00002.label = 2;
                        objAwaitAll = AwaitKt.awaitAll(deferredResults4, c00002);
                        if (objAwaitAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map6 = map5;
                        arrayList = episodes;
                        semaphore = semaphore5;
                        session4 = session2;
                        Boxing.boxBoolean(arrayList.addAll(CollectionsKt.flatten((Iterable) objAwaitAll)));
                    } else {
                        per_page2 = per_page;
                        total2 = total;
                        map4 = map3;
                        $this$map$iv = new IntRange(1, last_page);
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        it = $this$map$iv.iterator();
                        while (it.hasNext()) {
                            int item$iv$iv5 = it.nextInt();
                            int last_page10 = last_page;
                            Map<String, MetaEpisode> map13 = map4;
                            AnimePaheAnimeData data6 = data;
                            int total8 = total2;
                            session2 = session3;
                            Iterable $this$map$iv6 = $this$map$iv;
                            Object $result6 = $result;
                            int per_page7 = per_page2;
                            semaphore5 = semaphore3;
                            String uri8 = uri;
                            Collection destination$iv$iv6 = destination$iv$iv;
                            destination$iv$iv6.add(BuildersKt.async$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnimePahe$generateListOfEpisodes$deferredResults$1$1(semaphore5, this, session2, item$iv$iv5, map13, currentEpisode, null), 3, (Object) null));
                            last_page = last_page10;
                            per_page2 = per_page7;
                            destination$iv$iv = destination$iv$iv6;
                            $result = $result6;
                            uri = uri8;
                            semaphore3 = semaphore5;
                            total2 = total8;
                            $this$map$iv = $this$map$iv6;
                            data = data6;
                            session3 = session2;
                            map4 = map13;
                        }
                        map5 = map4;
                        int last_page11 = last_page;
                        session2 = session3;
                        semaphore5 = semaphore3;
                        List deferredResults5 = (List) destination$iv$iv;
                        c00002.L$0 = SpillingKt.nullOutSpilledVariable(session2);
                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                        c00002.L$2 = episodes;
                        c00002.L$3 = SpillingKt.nullOutSpilledVariable(semaphore5);
                        c00002.L$4 = SpillingKt.nullOutSpilledVariable(uri);
                        c00002.L$5 = SpillingKt.nullOutSpilledVariable(req);
                        c00002.L$6 = SpillingKt.nullOutSpilledVariable(data);
                        c00002.L$7 = SpillingKt.nullOutSpilledVariable(currentEpisode);
                        c00002.L$8 = SpillingKt.nullOutSpilledVariable(deferredResults5);
                        c00002.L$9 = episodes;
                        c00002.I$0 = last_page11;
                        c00002.I$1 = per_page2;
                        c00002.I$2 = total2;
                        c00002.label = 2;
                        objAwaitAll = AwaitKt.awaitAll(deferredResults5, c00002);
                        if (objAwaitAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map6 = map5;
                        arrayList = episodes;
                        semaphore = semaphore5;
                        session4 = session2;
                        Boxing.boxBoolean(arrayList.addAll(CollectionsKt.flatten((Iterable) objAwaitAll)));
                    }
                    return episodes;
                } catch (Exception e15) {
                    e = e15;
                    session2 = session5;
                }
                Log.INSTANCE.e("generateListOfEpisodes", "Error generating episodes: " + e.getMessage());
                return episodes;
            case 2:
                int i = c00002.I$2;
                int i2 = c00002.I$1;
                int i3 = c00002.I$0;
                arrayList = (ArrayList) c00002.L$9;
                semaphore = (Semaphore) c00002.L$3;
                episodes = (ArrayList) c00002.L$2;
                map6 = (Map) c00002.L$1;
                session4 = (String) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAwaitAll = $result;
                    Boxing.boxBoolean(arrayList.addAll(CollectionsKt.flatten((Iterable) objAwaitAll)));
                } catch (Exception e16) {
                    e = e16;
                    session2 = session4;
                    break;
                }
                return episodes;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateListOfEpisodes$getEpisodeTitle(AnimeData episodeData) {
        String title = episodeData.getTitle();
        if (title.length() == 0) {
            title = "Episode " + episodeData.getEpisode();
        }
        return title;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateListOfEpisodes$lambda$1$0(AnimeData $episodeData, MetaEpisode $meta, Episode $this$newEpisode) {
        String strGenerateListOfEpisodes$getEpisodeTitle;
        Map<String, String> title;
        Map<String, String> title2;
        String snapshot;
        Map<String, String> title3;
        MainAPIKt.addDate$default($this$newEpisode, $episodeData.getCreated_at(), (String) null, 2, (Object) null);
        if ($meta == null || (title3 = $meta.getTitle()) == null || (strGenerateListOfEpisodes$getEpisodeTitle = title3.get("en")) == null) {
            strGenerateListOfEpisodes$getEpisodeTitle = ($meta == null || (title2 = $meta.getTitle()) == null) ? null : title2.get("x-jat");
            if (strGenerateListOfEpisodes$getEpisodeTitle == null) {
                strGenerateListOfEpisodes$getEpisodeTitle = ($meta == null || (title = $meta.getTitle()) == null) ? null : title.get("ja");
                if (strGenerateListOfEpisodes$getEpisodeTitle == null) {
                    strGenerateListOfEpisodes$getEpisodeTitle = generateListOfEpisodes$getEpisodeTitle($episodeData);
                }
            }
        }
        $this$newEpisode.setName(strGenerateListOfEpisodes$getEpisodeTitle);
        if ($meta == null || (snapshot = $meta.getImage()) == null) {
            snapshot = $episodeData.getSnapshot();
        }
        $this$newEpisode.setPosterUrl(snapshot);
        $this$newEpisode.setDescription($meta != null ? $meta.getOverview() : null);
        $this$newEpisode.setScore(Score.Companion.from10($meta != null ? $meta.getRating() : null));
        $this$newEpisode.setRunTime($meta != null ? $meta.getRuntime() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/phisher98/AnimePahe$LoadData;", "", "session", "", "sessionDate", "", "name", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getSession", "()Ljava/lang/String;", "getSessionDate", "()J", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String name;

        @NotNull
        private final String session;
        private final long sessionDate;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, long j, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.session;
            }
            if ((i & 2) != 0) {
                j = loadData.sessionDate;
            }
            if ((i & 4) != 0) {
                str2 = loadData.name;
            }
            return loadData.copy(str, j, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSession() {
            return this.session;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getSessionDate() {
            return this.sessionDate;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final LoadData copy(@NotNull String session, long sessionDate, @NotNull String name) {
            return new LoadData(session, sessionDate, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.session, loadData.session) && this.sessionDate == loadData.sessionDate && Intrinsics.areEqual(this.name, loadData.name);
        }

        public int hashCode() {
            return (((this.session.hashCode() * 31) + AnimePahe$LoadData$$ExternalSyntheticBackport0.m1m(this.sessionDate)) * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(session=" + this.session + ", sessionDate=" + this.sessionDate + ", name=" + this.name + ')';
        }

        public LoadData(@NotNull String session, long sessionDate, @NotNull String name) {
            this.session = session;
            this.sessionDate = sessionDate;
            this.name = name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getSession() {
            return this.session;
        }

        public final long getSessionDate() {
            return this.sessionDate;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$load$2 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe$load$2", f = "AnimePahe.kt", i = {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {409, 415, 473, 475, 482, 484}, m = "invokeSuspend", n = {"data", "session", "session", "html", "doc", "japTitle", "anime_title", "poster", "tvType", "recommendations", "year", "status", "synopsis", "anilistId", "malId", "session", "html", "doc", "japTitle", "anime_title", "poster", "tvType", "recommendations", "year", "status", "synopsis", "anilistId", "malId", "session", "html", "doc", "japTitle", "anime_title", "poster", "tvType", "recommendations", "year", "status", "synopsis", "anilistId", "malId", "syncMetaData", "animeMetaData", "metaposter", "backgroundposter", "session", "html", "doc", "japTitle", "anime_title", "poster", "tvType", "recommendations", "year", "status", "synopsis", "anilistId", "malId", "syncMetaData", "animeMetaData", "metaposter", "backgroundposter", "episodes"}, nl = {408, 416, 474, 476, 484, 502}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17"}, v = 2)
    @SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$load$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,581:1\n93#2,2:582\n63#2:584\n64#2,15:586\n95#2,2:603\n93#2,2:605\n63#2:607\n64#2,15:609\n95#2,2:626\n1#3:585\n1#3:608\n1#3:639\n1#3:640\n1#3:645\n50#4:601\n43#4:602\n50#4:624\n43#4:625\n1795#5,10:628\n2068#5:638\n2069#5:641\n1805#5:642\n2068#5,2:643\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$load$2\n*L\n405#1:582,2\n405#1:584\n405#1:586,15\n405#1:603,2\n408#1:605,2\n408#1:607\n408#1:609,15\n408#1:626,2\n405#1:585\n408#1:608\n423#1:640\n405#1:601\n405#1:602\n408#1:624\n408#1:625\n423#1:628,10\n423#1:638\n423#1:641\n423#1:642\n462#1:643,2\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function1<Continuation<? super AnimeLoadResponse>, Object> {
        final /* synthetic */ String $url;
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
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ AnimePahe this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, AnimePahe animePahe, Continuation<? super C00042> continuation) {
            super(1, continuation);
            this.$url = str;
            this.this$0 = animePahe;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00042(this.$url, this.this$0, continuation);
        }

        public final Object invoke(Continuation<? super AnimeLoadResponse> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:104:0x032a  */
        /* JADX WARN: Code duplicated, block: B:105:0x0332  */
        /* JADX WARN: Code duplicated, block: B:106:0x0336 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:108:0x033a  */
        /* JADX WARN: Code duplicated, block: B:112:0x0343  */
        /* JADX WARN: Code duplicated, block: B:114:0x0377 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:115:0x0378  */
        /* JADX WARN: Code duplicated, block: B:118:0x038f  */
        /* JADX WARN: Code duplicated, block: B:119:0x0394  */
        /* JADX WARN: Code duplicated, block: B:122:0x039e  */
        /* JADX WARN: Code duplicated, block: B:123:0x03a3  */
        /* JADX WARN: Code duplicated, block: B:126:0x03af  */
        /* JADX WARN: Code duplicated, block: B:127:0x03b4  */
        /* JADX WARN: Code duplicated, block: B:130:0x03be  */
        /* JADX WARN: Code duplicated, block: B:131:0x03c3  */
        /* JADX WARN: Code duplicated, block: B:135:0x03eb  */
        /* JADX WARN: Code duplicated, block: B:138:0x0426  */
        /* JADX WARN: Code duplicated, block: B:140:0x0429  */
        /* JADX WARN: Code duplicated, block: B:141:0x0431  */
        /* JADX WARN: Code duplicated, block: B:143:0x0462  */
        /* JADX WARN: Code duplicated, block: B:144:0x0465  */
        /* JADX WARN: Code duplicated, block: B:146:0x0469  */
        /* JADX WARN: Code duplicated, block: B:149:0x0494  */
        /* JADX WARN: Code duplicated, block: B:153:0x04ce  */
        /* JADX WARN: Code duplicated, block: B:158:0x04ec  */
        /* JADX WARN: Code duplicated, block: B:161:0x04f6  */
        /* JADX WARN: Code duplicated, block: B:162:0x04f9  */
        /* JADX WARN: Code duplicated, block: B:164:0x0501  */
        /* JADX WARN: Code duplicated, block: B:165:0x0504  */
        /* JADX WARN: Code duplicated, block: B:168:0x050f  */
        /* JADX WARN: Code duplicated, block: B:169:0x0514  */
        /* JADX WARN: Code duplicated, block: B:173:0x0533  */
        /* JADX WARN: Code duplicated, block: B:175:0x057c  */
        /* JADX WARN: Code duplicated, block: B:176:0x0595  */
        /* JADX WARN: Code duplicated, block: B:178:0x05a8  */
        /* JADX WARN: Code duplicated, block: B:179:0x05bd  */
        /* JADX WARN: Code duplicated, block: B:183:0x05e2  */
        /* JADX WARN: Code duplicated, block: B:185:0x0652 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:186:0x0653  */
        /* JADX WARN: Code duplicated, block: B:188:0x0672  */
        /* JADX WARN: Code duplicated, block: B:190:0x0682  */
        /* JADX WARN: Code duplicated, block: B:192:0x06e6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:193:0x06e7  */
        /* JADX WARN: Code duplicated, block: B:195:0x0706  */
        /* JADX WARN: Code duplicated, block: B:198:0x0716  */
        /* JADX WARN: Code duplicated, block: B:199:0x071f  */
        /* JADX WARN: Code duplicated, block: B:201:0x0723  */
        /* JADX WARN: Code duplicated, block: B:214:0x0765  */
        /* JADX WARN: Code duplicated, block: B:217:0x076c  */
        /* JADX WARN: Code duplicated, block: B:230:0x07ab  */
        /* JADX WARN: Code duplicated, block: B:234:0x07b2  */
        /* JADX WARN: Code duplicated, block: B:235:0x07b9  */
        /* JADX WARN: Code duplicated, block: B:238:0x0809 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:239:0x080a  */
        /* JADX WARN: Code duplicated, block: B:242:0x082c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:243:0x082e  */
        /* JADX WARN: Code duplicated, block: B:244:0x0831  */
        /* JADX WARN: Code duplicated, block: B:245:0x0834  */
        /* JADX WARN: Code duplicated, block: B:248:0x08d2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:249:0x08d3  */
        /* JADX WARN: Code duplicated, block: B:251:0x08ec A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Code duplicated, block: B:277:0x04a8 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:279:0x0498 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:285:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:55:0x0237  */
        /* JADX WARN: Code duplicated, block: B:57:0x024d  */
        /* JADX WARN: Code duplicated, block: B:59:0x0264 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x0265  */
        /* JADX WARN: Code duplicated, block: B:63:0x0274  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object obj;
            Object obj2;
            Object objDecodeFromString;
            LoadData data;
            AnimePahe animePahe;
            String session;
            AppUtils this_$iv;
            Object objSearch;
            int i;
            Object obj3;
            Object objAppGet;
            String session2;
            SearchResponse searchResponse;
            String value$iv$iv;
            Object obj4;
            int i2;
            Object objDecodeFromString2;
            LoadData loadData;
            String html;
            Document doc;
            Element elementSelectFirst;
            String strText;
            String japTitle;
            Element elementSelectFirst2;
            String strText2;
            String anime_title;
            Element elementSelectFirst3;
            String strAttr;
            String poster;
            Element elementSelectFirst4;
            String strText3;
            String tvType;
            Iterable $this$mapNotNull$iv;
            AnimePahe animePahe2;
            int $i$f$mapNotNull;
            Collection destination$iv$iv;
            Iterator it;
            Iterable $this$mapNotNull$iv2;
            Object obj5;
            String str;
            String html2;
            List recommendations;
            MatchResult matchResultFind$default;
            Integer intOrNull;
            Integer year;
            ShowStatus showStatus;
            ShowStatus status;
            Element elementSelectFirst5;
            String strText4;
            String synopsis;
            Ref.ObjectRef anilistId;
            Ref.ObjectRef malId;
            Iterable $this$forEach$iv;
            int $i$f$forEach;
            String synopsis2;
            ShowStatus status2;
            Integer year2;
            List recommendations2;
            String tvType2;
            ShowStatus status3;
            Object obj6;
            List recommendations3;
            String synopsis3;
            String synopsis4;
            String html3;
            Ref.ObjectRef malId2;
            Ref.ObjectRef anilistId2;
            Document doc2;
            String poster2;
            Integer year3;
            String tvType3;
            String syncMetaData;
            Object obj7;
            Ref.ObjectRef anilistId3;
            Ref.ObjectRef anilistId4;
            List recommendations4;
            String synopsis5;
            Integer year4;
            Object obj8;
            Ref.ObjectRef anilistId5;
            Ref.ObjectRef anilistId6;
            String tvType4;
            String session3;
            List recommendations5;
            String synopsis6;
            Integer year5;
            Element aTag;
            List split;
            MatchResult.Destructured destructured;
            String str2;
            Element it2;
            AnimePahe animePahe3;
            String title;
            String session4;
            String strAttr2;
            boolean z;
            MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
            MetaAnimeData animeMetaData;
            String syncMetaData2;
            String html4;
            String metaposter;
            Object obj9;
            String backgroundposter;
            Map<String, MetaEpisode> episodes;
            Ref.ObjectRef anilistId7;
            String session5;
            Document doc3;
            Object objGenerateListOfEpisodes;
            Object obj10;
            Integer year6;
            List recommendations6;
            String japTitle2;
            String metaposter2;
            String tvType5;
            String metaposter3;
            String anime_title2;
            MetaAnimeData animeMetaData2;
            ShowStatus status4;
            String syncMetaData3;
            String tvType6;
            Ref.ObjectRef anilistId8;
            Ref.ObjectRef malId3;
            Document doc4;
            String synopsis7;
            List<MetaImage> images;
            Object next;
            List<MetaImage> images2;
            Object obj11;
            String str3;
            Object objNewAnimeLoadResponse$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str4 = "/anime/";
            String str5 = "";
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    AppUtils appUtils = AppUtils.INSTANCE;
                    String value$iv = this.$url;
                    if (value$iv == null) {
                        obj2 = "kotlinx.serialization.serializer.simple";
                        objDecodeFromString = null;
                    } else {
                        try {
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Exception e) {
                                obj2 = "kotlinx.serialization.serializer.simple";
                                objDecodeFromString = null;
                                data = (LoadData) objDecodeFromString;
                                if (data != null) {
                                    return null;
                                }
                                animePahe = this.this$0;
                                if (data.getSessionDate() + 600 < APIHolder.INSTANCE.getUnixTime()) {
                                    this_$iv = AppUtils.INSTANCE;
                                    String name = data.getName();
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(data);
                                    this.L$1 = this_$iv;
                                    this.label = 1;
                                    objSearch = animePahe.search(name, this);
                                    if (objSearch == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i = 0;
                                    obj3 = objSearch;
                                    searchResponse = (SearchResponse) CollectionsKt.firstOrNull((List) obj3);
                                    if (searchResponse != null) {
                                    }
                                    session = null;
                                } else {
                                    session = data.getSession();
                                }
                                if (session == null) {
                                    return null;
                                }
                                this.L$0 = session;
                                this.L$1 = null;
                                this.label = 2;
                                objAppGet = AnimePahe.INSTANCE.appGet(this.this$0.getMainUrl() + "/anime/" + session, AnimePahe.INSTANCE.getHeaders(), (Continuation) this);
                                if (objAppGet == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                session2 = session;
                                html = ((NiceResponse) objAppGet).getText();
                                doc = Ksoup.parse$default(Ksoup.INSTANCE, html, (String) null, 2, (Object) null);
                                elementSelectFirst = doc.selectFirst("h2.japanese");
                                if (elementSelectFirst != null) {
                                    strText = elementSelectFirst.text();
                                } else {
                                    strText = null;
                                }
                                japTitle = strText;
                                elementSelectFirst2 = doc.selectFirst("span.sr-only.unselectable");
                                if (elementSelectFirst2 != null) {
                                    strText2 = elementSelectFirst2.text();
                                } else {
                                    strText2 = null;
                                }
                                anime_title = strText2;
                                elementSelectFirst3 = doc.selectFirst(".anime-poster a");
                                if (elementSelectFirst3 != null) {
                                    strAttr = elementSelectFirst3.attr("href");
                                } else {
                                    strAttr = null;
                                }
                                poster = strAttr;
                                elementSelectFirst4 = doc.selectFirst("a[href*=\"/anime/type/\"]");
                                if (elementSelectFirst4 != null) {
                                    strText3 = elementSelectFirst4.text();
                                } else {
                                    strText3 = null;
                                }
                                tvType = strText3;
                                $this$mapNotNull$iv = doc.select("div.anime-recommendation div.row");
                                animePahe2 = this.this$0;
                                $i$f$mapNotNull = 0;
                                destination$iv$iv = new ArrayList();
                                it = $this$mapNotNull$iv.iterator();
                                while (true) {
                                    $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                    if (!it.hasNext()) {
                                        obj5 = coroutine_suspended;
                                        str = str5;
                                        html2 = html;
                                        recommendations = (List) destination$iv$iv;
                                        matchResultFind$default = Regex.find$default(new Regex("<strong>Aired:</strong>[^,]*, (\\d+)"), html2, 0, 2, (Object) null);
                                        if (matchResultFind$default != null) {
                                            intOrNull = null;
                                        } else {
                                            intOrNull = null;
                                        }
                                        year = intOrNull;
                                        if (doc.selectFirst("a[href='/anime/airing']") != null) {
                                            showStatus = ShowStatus.Ongoing;
                                        } else if (doc.selectFirst("a[href='/anime/completed']") != null) {
                                            showStatus = ShowStatus.Completed;
                                        } else {
                                            showStatus = null;
                                        }
                                        status = showStatus;
                                        elementSelectFirst5 = doc.selectFirst(".anime-synopsis");
                                        if (elementSelectFirst5 != null) {
                                            strText4 = elementSelectFirst5.text();
                                        } else {
                                            strText4 = null;
                                        }
                                        synopsis = strText4;
                                        anilistId = new Ref.ObjectRef();
                                        malId = new Ref.ObjectRef();
                                        $this$forEach$iv = doc.select(".external-links > a");
                                        $i$f$forEach = 0;
                                        for (Object element$iv : $this$forEach$iv) {
                                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                                            aTag = (Element) element$iv;
                                            int $i$f$forEach2 = $i$f$forEach;
                                            split = StringsKt.split$default(aTag.attr("href"), new String[]{"/"}, false, 0, 6, (Object) null);
                                            String synopsis8 = synopsis;
                                            ShowStatus status5 = status;
                                            Integer year7 = year;
                                            List recommendations7 = recommendations;
                                            String tvType7 = tvType;
                                            if (StringsKt.contains$default(aTag.attr("href"), "anilist.co", false, 2, (Object) null)) {
                                                anilistId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                            } else if (StringsKt.contains$default(aTag.attr("href"), "myanimelist.net", false, 2, (Object) null)) {
                                                malId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                            }
                                            $this$forEach$iv = $this$forEach$iv2;
                                            $i$f$forEach = $i$f$forEach2;
                                            year = year7;
                                            synopsis = synopsis8;
                                            status = status5;
                                            recommendations = recommendations7;
                                            tvType = tvType7;
                                        }
                                        synopsis2 = synopsis;
                                        status2 = status;
                                        year2 = year;
                                        recommendations2 = recommendations;
                                        tvType2 = tvType;
                                        if (anilistId.element != null) {
                                            this.L$0 = session2;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                            this.L$2 = doc;
                                            this.L$3 = japTitle;
                                            this.L$4 = anime_title;
                                            this.L$5 = poster;
                                            this.L$6 = tvType2;
                                            this.L$7 = recommendations2;
                                            this.L$8 = year2;
                                            status3 = status2;
                                            this.L$9 = status3;
                                            this.L$10 = synopsis2;
                                            this.L$11 = anilistId;
                                            this.L$12 = malId;
                                            this.label = 3;
                                            obj8 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + ((Number) anilistId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                            obj6 = obj5;
                                            if (obj8 == obj6) {
                                                return obj6;
                                            }
                                            anilistId5 = anilistId;
                                            anilistId6 = malId;
                                            tvType4 = tvType2;
                                            session3 = session2;
                                            recommendations5 = recommendations2;
                                            synopsis6 = synopsis2;
                                            year5 = year2;
                                            String text = ((NiceResponse) obj8).getText();
                                            Integer num = year5;
                                            malId2 = anilistId6;
                                            doc2 = doc;
                                            poster2 = poster;
                                            year3 = num;
                                            tvType3 = tvType4;
                                            anilistId2 = anilistId5;
                                            syncMetaData = text;
                                            synopsis4 = synopsis6;
                                            synopsis3 = anime_title;
                                            recommendations3 = recommendations5;
                                            session2 = session3;
                                            html3 = html2;
                                        } else {
                                            status3 = status2;
                                            obj6 = obj5;
                                            if (malId.element != null) {
                                                this.L$0 = session2;
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                                this.L$2 = doc;
                                                this.L$3 = japTitle;
                                                this.L$4 = anime_title;
                                                this.L$5 = poster;
                                                this.L$6 = tvType2;
                                                this.L$7 = recommendations2;
                                                this.L$8 = year2;
                                                this.L$9 = status3;
                                                this.L$10 = synopsis2;
                                                this.L$11 = anilistId;
                                                this.L$12 = malId;
                                                this.label = 4;
                                                obj7 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + ((Number) malId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                                if (obj7 == obj6) {
                                                    return obj6;
                                                }
                                                anilistId3 = anilistId;
                                                anilistId4 = malId;
                                                recommendations4 = recommendations2;
                                                synopsis5 = synopsis2;
                                                year4 = year2;
                                                tvType3 = tvType2;
                                                html3 = html2;
                                                Integer num2 = year4;
                                                malId2 = anilistId4;
                                                doc2 = doc;
                                                poster2 = poster;
                                                year3 = num2;
                                                String str6 = anime_title;
                                                recommendations3 = recommendations4;
                                                anilistId2 = anilistId3;
                                                syncMetaData = ((NiceResponse) obj7).getText();
                                                synopsis4 = synopsis5;
                                                synopsis3 = str6;
                                            } else {
                                                recommendations3 = recommendations2;
                                                synopsis3 = anime_title;
                                                synopsis4 = synopsis2;
                                                html3 = html2;
                                                malId2 = malId;
                                                anilistId2 = anilistId;
                                                doc2 = doc;
                                                poster2 = poster;
                                                year3 = year2;
                                                tvType3 = tvType2;
                                                syncMetaData = null;
                                            }
                                        }
                                        if (syncMetaData != null) {
                                            animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                                        } else {
                                            animeMetaData = null;
                                        }
                                        if (animeMetaData == null) {
                                            syncMetaData2 = syncMetaData;
                                            html4 = html3;
                                        } else {
                                            syncMetaData2 = syncMetaData;
                                            html4 = html3;
                                        }
                                        if (animeMetaData == null) {
                                            obj9 = obj6;
                                        } else {
                                            obj9 = obj6;
                                        }
                                        AnimePahe animePahe4 = this.this$0;
                                        if (animeMetaData != null) {
                                            episodes = animeMetaData.getEpisodes();
                                        } else {
                                            episodes = null;
                                        }
                                        String session6 = session2;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(session6);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                                        this.L$2 = doc2;
                                        this.L$3 = japTitle;
                                        this.L$4 = synopsis3;
                                        this.L$5 = poster2;
                                        this.L$6 = tvType3;
                                        this.L$7 = recommendations3;
                                        this.L$8 = year3;
                                        this.L$9 = status3;
                                        this.L$10 = synopsis4;
                                        this.L$11 = anilistId2;
                                        this.L$12 = malId2;
                                        this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                                        this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                                        this.L$15 = metaposter;
                                        this.L$16 = backgroundposter;
                                        this.label = 5;
                                        anilistId7 = anilistId2;
                                        session5 = session6;
                                        doc3 = doc2;
                                        objGenerateListOfEpisodes = animePahe4.generateListOfEpisodes(session5, episodes, (Continuation) this);
                                        obj10 = obj9;
                                        if (objGenerateListOfEpisodes == obj10) {
                                            return obj10;
                                        }
                                        year6 = year3;
                                        recommendations6 = recommendations3;
                                        japTitle2 = japTitle;
                                        metaposter2 = metaposter;
                                        tvType5 = backgroundposter;
                                        metaposter3 = html4;
                                        anime_title2 = synopsis3;
                                        animeMetaData2 = animeMetaData;
                                        status4 = status3;
                                        syncMetaData3 = tvType3;
                                        tvType6 = syncMetaData2;
                                        anilistId8 = anilistId7;
                                        malId3 = malId2;
                                        doc4 = doc3;
                                        synopsis7 = synopsis4;
                                        ArrayList episodes2 = (ArrayList) objGenerateListOfEpisodes;
                                        AnimePahe animePahe5 = this.this$0;
                                        if (anime_title2 == null) {
                                            str3 = anime_title2;
                                        } else if (japTitle2 == null) {
                                            str3 = str;
                                        } else {
                                            str3 = japTitle2;
                                        }
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                                        this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                                        this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                                        this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                                        this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                                        this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                                        this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                                        this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                                        this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                                        this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                                        this.L$17 = SpillingKt.nullOutSpilledVariable(episodes2);
                                        this.label = 6;
                                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe5, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes2, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                                        if (objNewAnimeLoadResponse$default == obj10) {
                                            return obj10;
                                        }
                                        return objNewAnimeLoadResponse$default;
                                    }
                                    Object element$iv$iv$iv = it.next();
                                    it2 = (Element) element$iv$iv$iv;
                                    animePahe3 = animePahe2;
                                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    String html5 = html;
                                    title = it2.select("a").attr("title");
                                    String rawHref = it2.select("a").attr("href");
                                    session4 = StringsKt.substringAfter(rawHref, str4, str5);
                                    if (StringsKt.isBlank(session4)) {
                                        session4 = null;
                                    }
                                    if (session4 == null) {
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        String json = AppUtils.INSTANCE.toJson(new LoadData(session4, APIHolder.INSTANCE.getUnixTime(), title));
                                        strAttr2 = it2.select("img").attr("data-src");
                                        if (strAttr2.length() == 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            strAttr2 = it2.select("img").attr("src");
                                        }
                                        final String posterurl = strAttr2;
                                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(animePahe3, title, json, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.AnimePahe$load$2$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj12) {
                                                return AnimePahe.C00042.invokeSuspend$lambda$1$2(posterurl, (MovieSearchResponse) obj12);
                                            }
                                        }, 8, (Object) null);
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                                    }
                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                    animePahe2 = animePahe3;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                    html = html5;
                                    str4 = str4;
                                    str5 = str5;
                                    coroutine_suspended = coroutine_suspended;
                                }
                            }
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            obj2 = "kotlinx.serialization.serializer.simple";
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj2 = "kotlinx.serialization.serializer.simple";
                                try {
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e2) {
                                        objDecodeFromString = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj2 = "kotlinx.serialization.serializer.simple";
                            }
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } catch (SerializationException e3) {
                                ArchComponentExtKt.logError(e3);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<LoadData>() { // from class: com.phisher98.AnimePahe$load$2$invokeSuspend$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<LoadData>() { // from class: com.phisher98.AnimePahe$load$2$invokeSuspend$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<LoadData>() { // from class: com.phisher98.AnimePahe$load$2$invokeSuspend$$inlined$tryParseJson$1
                            });
                        }
                    }
                    data = (LoadData) objDecodeFromString;
                    if (data != null) {
                        return null;
                    }
                    animePahe = this.this$0;
                    if (data.getSessionDate() + 600 < APIHolder.INSTANCE.getUnixTime()) {
                        this_$iv = AppUtils.INSTANCE;
                        String name2 = data.getName();
                        this.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        this.L$1 = this_$iv;
                        this.label = 1;
                        objSearch = animePahe.search(name2, this);
                        if (objSearch == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                        obj3 = objSearch;
                        searchResponse = (SearchResponse) CollectionsKt.firstOrNull((List) obj3);
                        if (searchResponse != null || (value$iv$iv = searchResponse.getUrl()) == null) {
                            session = null;
                        } else {
                            try {
                                try {
                                    Result.Companion companion5 = Result.Companion;
                                    KType kTypeTypeOf2 = Reflection.typeOf(LoadData.class);
                                    MagicApiIntrinsics.voidMagicApiCall(obj2);
                                    obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                } catch (Exception e4) {
                                    i2 = i;
                                    objDecodeFromString2 = null;
                                    loadData = (LoadData) objDecodeFromString2;
                                    if (loadData != null) {
                                        session = loadData.getSession();
                                    } else {
                                        session = null;
                                    }
                                    if (session == null) {
                                        return null;
                                    }
                                    this.L$0 = session;
                                    this.L$1 = null;
                                    this.label = 2;
                                    objAppGet = AnimePahe.INSTANCE.appGet(this.this$0.getMainUrl() + "/anime/" + session, AnimePahe.INSTANCE.getHeaders(), (Continuation) this);
                                    if (objAppGet == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    session2 = session;
                                    html = ((NiceResponse) objAppGet).getText();
                                    doc = Ksoup.parse$default(Ksoup.INSTANCE, html, (String) null, 2, (Object) null);
                                    elementSelectFirst = doc.selectFirst("h2.japanese");
                                    if (elementSelectFirst != null) {
                                        strText = elementSelectFirst.text();
                                    } else {
                                        strText = null;
                                    }
                                    japTitle = strText;
                                    elementSelectFirst2 = doc.selectFirst("span.sr-only.unselectable");
                                    if (elementSelectFirst2 != null) {
                                        strText2 = elementSelectFirst2.text();
                                    } else {
                                        strText2 = null;
                                    }
                                    anime_title = strText2;
                                    elementSelectFirst3 = doc.selectFirst(".anime-poster a");
                                    if (elementSelectFirst3 != null) {
                                        strAttr = elementSelectFirst3.attr("href");
                                    } else {
                                        strAttr = null;
                                    }
                                    poster = strAttr;
                                    elementSelectFirst4 = doc.selectFirst("a[href*=\"/anime/type/\"]");
                                    if (elementSelectFirst4 != null) {
                                        strText3 = elementSelectFirst4.text();
                                    } else {
                                        strText3 = null;
                                    }
                                    tvType = strText3;
                                    $this$mapNotNull$iv = doc.select("div.anime-recommendation div.row");
                                    animePahe2 = this.this$0;
                                    $i$f$mapNotNull = 0;
                                    destination$iv$iv = new ArrayList();
                                    it = $this$mapNotNull$iv.iterator();
                                    while (true) {
                                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                        if (!it.hasNext()) {
                                            obj5 = coroutine_suspended;
                                            str = str5;
                                            html2 = html;
                                            recommendations = (List) destination$iv$iv;
                                            matchResultFind$default = Regex.find$default(new Regex("<strong>Aired:</strong>[^,]*, (\\d+)"), html2, 0, 2, (Object) null);
                                            if (matchResultFind$default != null) {
                                                intOrNull = null;
                                            } else {
                                                intOrNull = null;
                                            }
                                            year = intOrNull;
                                            if (doc.selectFirst("a[href='/anime/airing']") != null) {
                                                showStatus = ShowStatus.Ongoing;
                                            } else if (doc.selectFirst("a[href='/anime/completed']") != null) {
                                                showStatus = ShowStatus.Completed;
                                            } else {
                                                showStatus = null;
                                            }
                                            status = showStatus;
                                            elementSelectFirst5 = doc.selectFirst(".anime-synopsis");
                                            if (elementSelectFirst5 != null) {
                                                strText4 = elementSelectFirst5.text();
                                            } else {
                                                strText4 = null;
                                            }
                                            synopsis = strText4;
                                            anilistId = new Ref.ObjectRef();
                                            malId = new Ref.ObjectRef();
                                            $this$forEach$iv = doc.select(".external-links > a");
                                            $i$f$forEach = 0;
                                            while (r17.hasNext()) {
                                                Iterable $this$forEach$iv3 = $this$forEach$iv;
                                                aTag = (Element) element$iv;
                                                int $i$f$forEach3 = $i$f$forEach;
                                                split = StringsKt.split$default(aTag.attr("href"), new String[]{"/"}, false, 0, 6, (Object) null);
                                                String synopsis9 = synopsis;
                                                ShowStatus status6 = status;
                                                Integer year8 = year;
                                                List recommendations8 = recommendations;
                                                String tvType8 = tvType;
                                                if (StringsKt.contains$default(aTag.attr("href"), "anilist.co", false, 2, (Object) null)) {
                                                    anilistId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                                } else if (StringsKt.contains$default(aTag.attr("href"), "myanimelist.net", false, 2, (Object) null)) {
                                                    malId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                                }
                                                $this$forEach$iv = $this$forEach$iv3;
                                                $i$f$forEach = $i$f$forEach3;
                                                year = year8;
                                                synopsis = synopsis9;
                                                status = status6;
                                                recommendations = recommendations8;
                                                tvType = tvType8;
                                            }
                                            synopsis2 = synopsis;
                                            status2 = status;
                                            year2 = year;
                                            recommendations2 = recommendations;
                                            tvType2 = tvType;
                                            if (anilistId.element != null) {
                                                this.L$0 = session2;
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                                this.L$2 = doc;
                                                this.L$3 = japTitle;
                                                this.L$4 = anime_title;
                                                this.L$5 = poster;
                                                this.L$6 = tvType2;
                                                this.L$7 = recommendations2;
                                                this.L$8 = year2;
                                                status3 = status2;
                                                this.L$9 = status3;
                                                this.L$10 = synopsis2;
                                                this.L$11 = anilistId;
                                                this.L$12 = malId;
                                                this.label = 3;
                                                obj8 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + ((Number) anilistId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                                obj6 = obj5;
                                                if (obj8 == obj6) {
                                                    return obj6;
                                                }
                                                anilistId5 = anilistId;
                                                anilistId6 = malId;
                                                tvType4 = tvType2;
                                                session3 = session2;
                                                recommendations5 = recommendations2;
                                                synopsis6 = synopsis2;
                                                year5 = year2;
                                                String text2 = ((NiceResponse) obj8).getText();
                                                Integer num3 = year5;
                                                malId2 = anilistId6;
                                                doc2 = doc;
                                                poster2 = poster;
                                                year3 = num3;
                                                tvType3 = tvType4;
                                                anilistId2 = anilistId5;
                                                syncMetaData = text2;
                                                synopsis4 = synopsis6;
                                                synopsis3 = anime_title;
                                                recommendations3 = recommendations5;
                                                session2 = session3;
                                                html3 = html2;
                                            } else {
                                                status3 = status2;
                                                obj6 = obj5;
                                                if (malId.element != null) {
                                                    this.L$0 = session2;
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                                    this.L$2 = doc;
                                                    this.L$3 = japTitle;
                                                    this.L$4 = anime_title;
                                                    this.L$5 = poster;
                                                    this.L$6 = tvType2;
                                                    this.L$7 = recommendations2;
                                                    this.L$8 = year2;
                                                    this.L$9 = status3;
                                                    this.L$10 = synopsis2;
                                                    this.L$11 = anilistId;
                                                    this.L$12 = malId;
                                                    this.label = 4;
                                                    obj7 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + ((Number) malId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                                    if (obj7 == obj6) {
                                                        return obj6;
                                                    }
                                                    anilistId3 = anilistId;
                                                    anilistId4 = malId;
                                                    recommendations4 = recommendations2;
                                                    synopsis5 = synopsis2;
                                                    year4 = year2;
                                                    tvType3 = tvType2;
                                                    html3 = html2;
                                                    Integer num4 = year4;
                                                    malId2 = anilistId4;
                                                    doc2 = doc;
                                                    poster2 = poster;
                                                    year3 = num4;
                                                    String str7 = anime_title;
                                                    recommendations3 = recommendations4;
                                                    anilistId2 = anilistId3;
                                                    syncMetaData = ((NiceResponse) obj7).getText();
                                                    synopsis4 = synopsis5;
                                                    synopsis3 = str7;
                                                } else {
                                                    recommendations3 = recommendations2;
                                                    synopsis3 = anime_title;
                                                    synopsis4 = synopsis2;
                                                    html3 = html2;
                                                    malId2 = malId;
                                                    anilistId2 = anilistId;
                                                    doc2 = doc;
                                                    poster2 = poster;
                                                    year3 = year2;
                                                    tvType3 = tvType2;
                                                    syncMetaData = null;
                                                }
                                            }
                                            if (syncMetaData != null) {
                                                animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                                            } else {
                                                animeMetaData = null;
                                            }
                                            if (animeMetaData == null) {
                                                syncMetaData2 = syncMetaData;
                                                html4 = html3;
                                            } else {
                                                syncMetaData2 = syncMetaData;
                                                html4 = html3;
                                            }
                                            if (animeMetaData == null) {
                                                obj9 = obj6;
                                            } else {
                                                obj9 = obj6;
                                            }
                                            AnimePahe animePahe6 = this.this$0;
                                            if (animeMetaData != null) {
                                                episodes = animeMetaData.getEpisodes();
                                            } else {
                                                episodes = null;
                                            }
                                            String session7 = session2;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(session7);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                                            this.L$2 = doc2;
                                            this.L$3 = japTitle;
                                            this.L$4 = synopsis3;
                                            this.L$5 = poster2;
                                            this.L$6 = tvType3;
                                            this.L$7 = recommendations3;
                                            this.L$8 = year3;
                                            this.L$9 = status3;
                                            this.L$10 = synopsis4;
                                            this.L$11 = anilistId2;
                                            this.L$12 = malId2;
                                            this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                                            this.L$15 = metaposter;
                                            this.L$16 = backgroundposter;
                                            this.label = 5;
                                            anilistId7 = anilistId2;
                                            session5 = session7;
                                            doc3 = doc2;
                                            objGenerateListOfEpisodes = animePahe6.generateListOfEpisodes(session5, episodes, (Continuation) this);
                                            obj10 = obj9;
                                            if (objGenerateListOfEpisodes == obj10) {
                                                return obj10;
                                            }
                                            year6 = year3;
                                            recommendations6 = recommendations3;
                                            japTitle2 = japTitle;
                                            metaposter2 = metaposter;
                                            tvType5 = backgroundposter;
                                            metaposter3 = html4;
                                            anime_title2 = synopsis3;
                                            animeMetaData2 = animeMetaData;
                                            status4 = status3;
                                            syncMetaData3 = tvType3;
                                            tvType6 = syncMetaData2;
                                            anilistId8 = anilistId7;
                                            malId3 = malId2;
                                            doc4 = doc3;
                                            synopsis7 = synopsis4;
                                            ArrayList episodes3 = (ArrayList) objGenerateListOfEpisodes;
                                            AnimePahe animePahe7 = this.this$0;
                                            if (anime_title2 == null) {
                                                str3 = anime_title2;
                                            } else if (japTitle2 == null) {
                                                str3 = str;
                                            } else {
                                                str3 = japTitle2;
                                            }
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                                            this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                                            this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                                            this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                                            this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                                            this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                                            this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                                            this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                                            this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                                            this.L$17 = SpillingKt.nullOutSpilledVariable(episodes3);
                                            this.label = 6;
                                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe7, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes3, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                                            if (objNewAnimeLoadResponse$default == obj10) {
                                                return obj10;
                                            }
                                            return objNewAnimeLoadResponse$default;
                                        }
                                        Object element$iv$iv$iv2 = it.next();
                                        it2 = (Element) element$iv$iv$iv2;
                                        animePahe3 = animePahe2;
                                        int $i$f$mapNotNull3 = $i$f$mapNotNull;
                                        String html6 = html;
                                        title = it2.select("a").attr("title");
                                        String rawHref2 = it2.select("a").attr("href");
                                        session4 = StringsKt.substringAfter(rawHref2, str4, str5);
                                        if (StringsKt.isBlank(session4)) {
                                            session4 = null;
                                        }
                                        if (session4 == null) {
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        } else {
                                            String json2 = AppUtils.INSTANCE.toJson(new LoadData(session4, APIHolder.INSTANCE.getUnixTime(), title));
                                            strAttr2 = it2.select("img").attr("data-src");
                                            if (strAttr2.length() == 0) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (z) {
                                                strAttr2 = it2.select("img").attr("src");
                                            }
                                            final String posterurl2 = strAttr2;
                                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(animePahe3, title, json2, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.AnimePahe$load$2$$ExternalSyntheticLambda0
                                                public final Object invoke(Object obj12) {
                                                    return AnimePahe.C00042.invokeSuspend$lambda$1$2(posterurl2, (MovieSearchResponse) obj12);
                                                }
                                            }, 8, (Object) null);
                                        }
                                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                            destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                                        }
                                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                        animePahe2 = animePahe3;
                                        $i$f$mapNotNull = $i$f$mapNotNull3;
                                        html = html6;
                                        str4 = str4;
                                        str5 = str5;
                                        coroutine_suspended = coroutine_suspended;
                                    }
                                }
                            } catch (Throwable th5) {
                                Result.Companion companion6 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th5));
                            }
                            if (Result.exceptionOrNull-impl(obj4) == null) {
                                i2 = i;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    i2 = i;
                                    try {
                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                                        break;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        try {
                                            Result.Companion companion8 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e5) {
                                            objDecodeFromString2 = null;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    i2 = i;
                                }
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = null;
                            }
                            DeserializationStrategy deserializationStrategy2 = (KSerializer) obj4;
                            if (deserializationStrategy2 != null) {
                                try {
                                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv$iv);
                                } catch (SerializationException e6) {
                                    ArchComponentExtKt.logError(e6);
                                    ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv4.readValue(value$iv$iv, new TypeReference<LoadData>() { // from class: com.phisher98.AnimePahe$load$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                    });
                                } catch (Throwable th8) {
                                    ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                    objDecodeFromString2 = $this$readValue$iv$iv$iv5.readValue(value$iv$iv, new TypeReference<LoadData>() { // from class: com.phisher98.AnimePahe$load$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv6.readValue(value$iv$iv, new TypeReference<LoadData>() { // from class: com.phisher98.AnimePahe$load$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                });
                            }
                            loadData = (LoadData) objDecodeFromString2;
                            if (loadData != null) {
                                session = loadData.getSession();
                            } else {
                                session = null;
                            }
                        }
                    } else {
                        session = data.getSession();
                    }
                    if (session == null) {
                        return null;
                    }
                    this.L$0 = session;
                    this.L$1 = null;
                    this.label = 2;
                    objAppGet = AnimePahe.INSTANCE.appGet(this.this$0.getMainUrl() + "/anime/" + session, AnimePahe.INSTANCE.getHeaders(), (Continuation) this);
                    if (objAppGet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    session2 = session;
                    html = ((NiceResponse) objAppGet).getText();
                    doc = Ksoup.parse$default(Ksoup.INSTANCE, html, (String) null, 2, (Object) null);
                    elementSelectFirst = doc.selectFirst("h2.japanese");
                    if (elementSelectFirst != null) {
                        strText = elementSelectFirst.text();
                    } else {
                        strText = null;
                    }
                    japTitle = strText;
                    elementSelectFirst2 = doc.selectFirst("span.sr-only.unselectable");
                    if (elementSelectFirst2 != null) {
                        strText2 = elementSelectFirst2.text();
                    } else {
                        strText2 = null;
                    }
                    anime_title = strText2;
                    elementSelectFirst3 = doc.selectFirst(".anime-poster a");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("href");
                    } else {
                        strAttr = null;
                    }
                    poster = strAttr;
                    elementSelectFirst4 = doc.selectFirst("a[href*=\"/anime/type/\"]");
                    if (elementSelectFirst4 != null) {
                        strText3 = elementSelectFirst4.text();
                    } else {
                        strText3 = null;
                    }
                    tvType = strText3;
                    $this$mapNotNull$iv = doc.select("div.anime-recommendation div.row");
                    animePahe2 = this.this$0;
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    it = $this$mapNotNull$iv.iterator();
                    while (true) {
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                        if (!it.hasNext()) {
                            obj5 = coroutine_suspended;
                            str = str5;
                            html2 = html;
                            recommendations = (List) destination$iv$iv;
                            matchResultFind$default = Regex.find$default(new Regex("<strong>Aired:</strong>[^,]*, (\\d+)"), html2, 0, 2, (Object) null);
                            if (matchResultFind$default != null || (destructured = matchResultFind$default.getDestructured()) == null || (str2 = (String) destructured.getMatch().getGroupValues().get(1)) == null) {
                                intOrNull = null;
                            } else {
                                intOrNull = StringsKt.toIntOrNull(str2);
                            }
                            year = intOrNull;
                            if (doc.selectFirst("a[href='/anime/airing']") != null) {
                                showStatus = ShowStatus.Ongoing;
                            } else if (doc.selectFirst("a[href='/anime/completed']") != null) {
                                showStatus = ShowStatus.Completed;
                            } else {
                                showStatus = null;
                            }
                            status = showStatus;
                            elementSelectFirst5 = doc.selectFirst(".anime-synopsis");
                            if (elementSelectFirst5 != null) {
                                strText4 = elementSelectFirst5.text();
                            } else {
                                strText4 = null;
                            }
                            synopsis = strText4;
                            anilistId = new Ref.ObjectRef();
                            malId = new Ref.ObjectRef();
                            $this$forEach$iv = doc.select(".external-links > a");
                            $i$f$forEach = 0;
                            while (r17.hasNext()) {
                                Iterable $this$forEach$iv4 = $this$forEach$iv;
                                aTag = (Element) element$iv;
                                int $i$f$forEach4 = $i$f$forEach;
                                split = StringsKt.split$default(aTag.attr("href"), new String[]{"/"}, false, 0, 6, (Object) null);
                                String synopsis10 = synopsis;
                                ShowStatus status7 = status;
                                Integer year9 = year;
                                List recommendations9 = recommendations;
                                String tvType9 = tvType;
                                if (StringsKt.contains$default(aTag.attr("href"), "anilist.co", false, 2, (Object) null)) {
                                    anilistId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                } else if (StringsKt.contains$default(aTag.attr("href"), "myanimelist.net", false, 2, (Object) null)) {
                                    malId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                }
                                $this$forEach$iv = $this$forEach$iv4;
                                $i$f$forEach = $i$f$forEach4;
                                year = year9;
                                synopsis = synopsis10;
                                status = status7;
                                recommendations = recommendations9;
                                tvType = tvType9;
                            }
                            synopsis2 = synopsis;
                            status2 = status;
                            year2 = year;
                            recommendations2 = recommendations;
                            tvType2 = tvType;
                            if (anilistId.element != null) {
                                this.L$0 = session2;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                this.L$2 = doc;
                                this.L$3 = japTitle;
                                this.L$4 = anime_title;
                                this.L$5 = poster;
                                this.L$6 = tvType2;
                                this.L$7 = recommendations2;
                                this.L$8 = year2;
                                status3 = status2;
                                this.L$9 = status3;
                                this.L$10 = synopsis2;
                                this.L$11 = anilistId;
                                this.L$12 = malId;
                                this.label = 3;
                                obj8 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + ((Number) anilistId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                obj6 = obj5;
                                if (obj8 == obj6) {
                                    return obj6;
                                }
                                anilistId5 = anilistId;
                                anilistId6 = malId;
                                tvType4 = tvType2;
                                session3 = session2;
                                recommendations5 = recommendations2;
                                synopsis6 = synopsis2;
                                year5 = year2;
                                String text3 = ((NiceResponse) obj8).getText();
                                Integer num5 = year5;
                                malId2 = anilistId6;
                                doc2 = doc;
                                poster2 = poster;
                                year3 = num5;
                                tvType3 = tvType4;
                                anilistId2 = anilistId5;
                                syncMetaData = text3;
                                synopsis4 = synopsis6;
                                synopsis3 = anime_title;
                                recommendations3 = recommendations5;
                                session2 = session3;
                                html3 = html2;
                            } else {
                                status3 = status2;
                                obj6 = obj5;
                                if (malId.element != null) {
                                    this.L$0 = session2;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                    this.L$2 = doc;
                                    this.L$3 = japTitle;
                                    this.L$4 = anime_title;
                                    this.L$5 = poster;
                                    this.L$6 = tvType2;
                                    this.L$7 = recommendations2;
                                    this.L$8 = year2;
                                    this.L$9 = status3;
                                    this.L$10 = synopsis2;
                                    this.L$11 = anilistId;
                                    this.L$12 = malId;
                                    this.label = 4;
                                    obj7 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + ((Number) malId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                    if (obj7 == obj6) {
                                        return obj6;
                                    }
                                    anilistId3 = anilistId;
                                    anilistId4 = malId;
                                    recommendations4 = recommendations2;
                                    synopsis5 = synopsis2;
                                    year4 = year2;
                                    tvType3 = tvType2;
                                    html3 = html2;
                                    Integer num6 = year4;
                                    malId2 = anilistId4;
                                    doc2 = doc;
                                    poster2 = poster;
                                    year3 = num6;
                                    String str8 = anime_title;
                                    recommendations3 = recommendations4;
                                    anilistId2 = anilistId3;
                                    syncMetaData = ((NiceResponse) obj7).getText();
                                    synopsis4 = synopsis5;
                                    synopsis3 = str8;
                                } else {
                                    recommendations3 = recommendations2;
                                    synopsis3 = anime_title;
                                    synopsis4 = synopsis2;
                                    html3 = html2;
                                    malId2 = malId;
                                    anilistId2 = anilistId;
                                    doc2 = doc;
                                    poster2 = poster;
                                    year3 = year2;
                                    tvType3 = tvType2;
                                    syncMetaData = null;
                                }
                            }
                            if (syncMetaData != null) {
                                animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                            } else {
                                animeMetaData = null;
                            }
                            if (animeMetaData == null && (images2 = animeMetaData.getImages()) != null) {
                                Iterator<T> it3 = images2.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        Object next2 = it3.next();
                                        syncMetaData2 = syncMetaData;
                                        String syncMetaData4 = ((MetaImage) next2).getCoverType();
                                        html4 = html3;
                                        if (Intrinsics.areEqual(syncMetaData4, "Poster")) {
                                            obj11 = next2;
                                        } else {
                                            syncMetaData = syncMetaData2;
                                            html3 = html4;
                                        }
                                    } else {
                                        syncMetaData2 = syncMetaData;
                                        html4 = html3;
                                        obj11 = null;
                                    }
                                }
                                MetaImage metaImage = (MetaImage) obj11;
                                metaposter = metaImage != null ? metaImage.getUrl() : null;
                                if (animeMetaData == null && (images = animeMetaData.getImages()) != null) {
                                    Iterator it4 = images.iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            next = it4.next();
                                            Iterator it5 = it4;
                                            obj9 = obj6;
                                            if (!Intrinsics.areEqual(((MetaImage) next).getCoverType(), "Fanart")) {
                                                it4 = it5;
                                                obj6 = obj9;
                                            }
                                        } else {
                                            obj9 = obj6;
                                            next = null;
                                        }
                                    }
                                    MetaImage metaImage2 = (MetaImage) next;
                                    backgroundposter = metaImage2 != null ? metaImage2.getUrl() : null;
                                    AnimePahe animePahe8 = this.this$0;
                                    if (animeMetaData != null) {
                                        episodes = animeMetaData.getEpisodes();
                                    } else {
                                        episodes = null;
                                    }
                                    String session8 = session2;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(session8);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                                    this.L$2 = doc2;
                                    this.L$3 = japTitle;
                                    this.L$4 = synopsis3;
                                    this.L$5 = poster2;
                                    this.L$6 = tvType3;
                                    this.L$7 = recommendations3;
                                    this.L$8 = year3;
                                    this.L$9 = status3;
                                    this.L$10 = synopsis4;
                                    this.L$11 = anilistId2;
                                    this.L$12 = malId2;
                                    this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                                    this.L$15 = metaposter;
                                    this.L$16 = backgroundposter;
                                    this.label = 5;
                                    anilistId7 = anilistId2;
                                    session5 = session8;
                                    doc3 = doc2;
                                    objGenerateListOfEpisodes = animePahe8.generateListOfEpisodes(session5, episodes, (Continuation) this);
                                    obj10 = obj9;
                                    if (objGenerateListOfEpisodes == obj10) {
                                        return obj10;
                                    }
                                    year6 = year3;
                                    recommendations6 = recommendations3;
                                    japTitle2 = japTitle;
                                    metaposter2 = metaposter;
                                    tvType5 = backgroundposter;
                                    metaposter3 = html4;
                                    anime_title2 = synopsis3;
                                    animeMetaData2 = animeMetaData;
                                    status4 = status3;
                                    syncMetaData3 = tvType3;
                                    tvType6 = syncMetaData2;
                                    anilistId8 = anilistId7;
                                    malId3 = malId2;
                                    doc4 = doc3;
                                    synopsis7 = synopsis4;
                                    ArrayList episodes4 = (ArrayList) objGenerateListOfEpisodes;
                                    AnimePahe animePahe9 = this.this$0;
                                    if (anime_title2 == null) {
                                        str3 = anime_title2;
                                    } else if (japTitle2 == null) {
                                        str3 = str;
                                    } else {
                                        str3 = japTitle2;
                                    }
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                                    this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                                    this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                                    this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                                    this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                                    this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                                    this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                                    this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                                    this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                                    this.L$17 = SpillingKt.nullOutSpilledVariable(episodes4);
                                    this.label = 6;
                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe9, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes4, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                                    if (objNewAnimeLoadResponse$default == obj10) {
                                        return obj10;
                                    }
                                    return objNewAnimeLoadResponse$default;
                                }
                                obj9 = obj6;
                                AnimePahe animePahe10 = this.this$0;
                                if (animeMetaData != null) {
                                    episodes = animeMetaData.getEpisodes();
                                } else {
                                    episodes = null;
                                }
                                String session9 = session2;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(session9);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                                this.L$2 = doc2;
                                this.L$3 = japTitle;
                                this.L$4 = synopsis3;
                                this.L$5 = poster2;
                                this.L$6 = tvType3;
                                this.L$7 = recommendations3;
                                this.L$8 = year3;
                                this.L$9 = status3;
                                this.L$10 = synopsis4;
                                this.L$11 = anilistId2;
                                this.L$12 = malId2;
                                this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                                this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                                this.L$15 = metaposter;
                                this.L$16 = backgroundposter;
                                this.label = 5;
                                anilistId7 = anilistId2;
                                session5 = session9;
                                doc3 = doc2;
                                objGenerateListOfEpisodes = animePahe10.generateListOfEpisodes(session5, episodes, (Continuation) this);
                                obj10 = obj9;
                                if (objGenerateListOfEpisodes == obj10) {
                                    return obj10;
                                }
                                year6 = year3;
                                recommendations6 = recommendations3;
                                japTitle2 = japTitle;
                                metaposter2 = metaposter;
                                tvType5 = backgroundposter;
                                metaposter3 = html4;
                                anime_title2 = synopsis3;
                                animeMetaData2 = animeMetaData;
                                status4 = status3;
                                syncMetaData3 = tvType3;
                                tvType6 = syncMetaData2;
                                anilistId8 = anilistId7;
                                malId3 = malId2;
                                doc4 = doc3;
                                synopsis7 = synopsis4;
                                ArrayList episodes5 = (ArrayList) objGenerateListOfEpisodes;
                                AnimePahe animePahe11 = this.this$0;
                                if (anime_title2 == null) {
                                    str3 = anime_title2;
                                } else if (japTitle2 == null) {
                                    str3 = str;
                                } else {
                                    str3 = japTitle2;
                                }
                                this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                                this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                                this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                                this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                                this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                                this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                                this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                                this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                                this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                                this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                                this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                                this.L$17 = SpillingKt.nullOutSpilledVariable(episodes5);
                                this.label = 6;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe11, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes5, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj10) {
                                    return obj10;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            syncMetaData2 = syncMetaData;
                            html4 = html3;
                            if (animeMetaData == null) {
                                obj9 = obj6;
                            } else {
                                obj9 = obj6;
                            }
                            AnimePahe animePahe12 = this.this$0;
                            if (animeMetaData != null) {
                                episodes = animeMetaData.getEpisodes();
                            } else {
                                episodes = null;
                            }
                            String session10 = session2;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(session10);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                            this.L$2 = doc2;
                            this.L$3 = japTitle;
                            this.L$4 = synopsis3;
                            this.L$5 = poster2;
                            this.L$6 = tvType3;
                            this.L$7 = recommendations3;
                            this.L$8 = year3;
                            this.L$9 = status3;
                            this.L$10 = synopsis4;
                            this.L$11 = anilistId2;
                            this.L$12 = malId2;
                            this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                            this.L$15 = metaposter;
                            this.L$16 = backgroundposter;
                            this.label = 5;
                            anilistId7 = anilistId2;
                            session5 = session10;
                            doc3 = doc2;
                            objGenerateListOfEpisodes = animePahe12.generateListOfEpisodes(session5, episodes, (Continuation) this);
                            obj10 = obj9;
                            if (objGenerateListOfEpisodes == obj10) {
                                return obj10;
                            }
                            year6 = year3;
                            recommendations6 = recommendations3;
                            japTitle2 = japTitle;
                            metaposter2 = metaposter;
                            tvType5 = backgroundposter;
                            metaposter3 = html4;
                            anime_title2 = synopsis3;
                            animeMetaData2 = animeMetaData;
                            status4 = status3;
                            syncMetaData3 = tvType3;
                            tvType6 = syncMetaData2;
                            anilistId8 = anilistId7;
                            malId3 = malId2;
                            doc4 = doc3;
                            synopsis7 = synopsis4;
                            ArrayList episodes6 = (ArrayList) objGenerateListOfEpisodes;
                            AnimePahe animePahe13 = this.this$0;
                            if (anime_title2 == null) {
                                str3 = anime_title2;
                            } else if (japTitle2 == null) {
                                str3 = str;
                            } else {
                                str3 = japTitle2;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                            this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                            this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                            this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                            this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                            this.L$17 = SpillingKt.nullOutSpilledVariable(episodes6);
                            this.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe13, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes6, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj10) {
                                return obj10;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        Object element$iv$iv$iv3 = it.next();
                        it2 = (Element) element$iv$iv$iv3;
                        animePahe3 = animePahe2;
                        int $i$f$mapNotNull4 = $i$f$mapNotNull;
                        String html7 = html;
                        title = it2.select("a").attr("title");
                        String rawHref3 = it2.select("a").attr("href");
                        session4 = StringsKt.substringAfter(rawHref3, str4, str5);
                        if (StringsKt.isBlank(session4)) {
                            session4 = null;
                        }
                        if (session4 == null) {
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            String json3 = AppUtils.INSTANCE.toJson(new LoadData(session4, APIHolder.INSTANCE.getUnixTime(), title));
                            strAttr2 = it2.select("img").attr("data-src");
                            if (strAttr2.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                strAttr2 = it2.select("img").attr("src");
                            }
                            final String posterurl3 = strAttr2;
                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(animePahe3, title, json3, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.AnimePahe$load$2$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj12) {
                                    return AnimePahe.C00042.invokeSuspend$lambda$1$2(posterurl3, (MovieSearchResponse) obj12);
                                }
                            }, 8, (Object) null);
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        animePahe2 = animePahe3;
                        $i$f$mapNotNull = $i$f$mapNotNull4;
                        html = html7;
                        str4 = str4;
                        str5 = str5;
                        coroutine_suspended = coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    this_$iv = (AppUtils) this.L$1;
                    ResultKt.throwOnFailure($result);
                    obj2 = "kotlinx.serialization.serializer.simple";
                    i = 0;
                    obj3 = $result;
                    searchResponse = (SearchResponse) CollectionsKt.firstOrNull((List) obj3);
                    if (searchResponse != null) {
                    }
                    session = null;
                    if (session == null) {
                        return null;
                    }
                    this.L$0 = session;
                    this.L$1 = null;
                    this.label = 2;
                    objAppGet = AnimePahe.INSTANCE.appGet(this.this$0.getMainUrl() + "/anime/" + session, AnimePahe.INSTANCE.getHeaders(), (Continuation) this);
                    if (objAppGet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    session2 = session;
                    html = ((NiceResponse) objAppGet).getText();
                    doc = Ksoup.parse$default(Ksoup.INSTANCE, html, (String) null, 2, (Object) null);
                    elementSelectFirst = doc.selectFirst("h2.japanese");
                    if (elementSelectFirst != null) {
                        strText = elementSelectFirst.text();
                    } else {
                        strText = null;
                    }
                    japTitle = strText;
                    elementSelectFirst2 = doc.selectFirst("span.sr-only.unselectable");
                    if (elementSelectFirst2 != null) {
                        strText2 = elementSelectFirst2.text();
                    } else {
                        strText2 = null;
                    }
                    anime_title = strText2;
                    elementSelectFirst3 = doc.selectFirst(".anime-poster a");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("href");
                    } else {
                        strAttr = null;
                    }
                    poster = strAttr;
                    elementSelectFirst4 = doc.selectFirst("a[href*=\"/anime/type/\"]");
                    if (elementSelectFirst4 != null) {
                        strText3 = elementSelectFirst4.text();
                    } else {
                        strText3 = null;
                    }
                    tvType = strText3;
                    $this$mapNotNull$iv = doc.select("div.anime-recommendation div.row");
                    animePahe2 = this.this$0;
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    it = $this$mapNotNull$iv.iterator();
                    while (true) {
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                        if (!it.hasNext()) {
                            obj5 = coroutine_suspended;
                            str = str5;
                            html2 = html;
                            recommendations = (List) destination$iv$iv;
                            matchResultFind$default = Regex.find$default(new Regex("<strong>Aired:</strong>[^,]*, (\\d+)"), html2, 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                intOrNull = null;
                            } else {
                                intOrNull = null;
                            }
                            year = intOrNull;
                            if (doc.selectFirst("a[href='/anime/airing']") != null) {
                                showStatus = ShowStatus.Ongoing;
                            } else if (doc.selectFirst("a[href='/anime/completed']") != null) {
                                showStatus = ShowStatus.Completed;
                            } else {
                                showStatus = null;
                            }
                            status = showStatus;
                            elementSelectFirst5 = doc.selectFirst(".anime-synopsis");
                            if (elementSelectFirst5 != null) {
                                strText4 = elementSelectFirst5.text();
                            } else {
                                strText4 = null;
                            }
                            synopsis = strText4;
                            anilistId = new Ref.ObjectRef();
                            malId = new Ref.ObjectRef();
                            $this$forEach$iv = doc.select(".external-links > a");
                            $i$f$forEach = 0;
                            while (r17.hasNext()) {
                                Iterable $this$forEach$iv5 = $this$forEach$iv;
                                aTag = (Element) element$iv;
                                int $i$f$forEach5 = $i$f$forEach;
                                split = StringsKt.split$default(aTag.attr("href"), new String[]{"/"}, false, 0, 6, (Object) null);
                                String synopsis11 = synopsis;
                                ShowStatus status8 = status;
                                Integer year10 = year;
                                List recommendations10 = recommendations;
                                String tvType10 = tvType;
                                if (StringsKt.contains$default(aTag.attr("href"), "anilist.co", false, 2, (Object) null)) {
                                    anilistId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                } else if (StringsKt.contains$default(aTag.attr("href"), "myanimelist.net", false, 2, (Object) null)) {
                                    malId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                }
                                $this$forEach$iv = $this$forEach$iv5;
                                $i$f$forEach = $i$f$forEach5;
                                year = year10;
                                synopsis = synopsis11;
                                status = status8;
                                recommendations = recommendations10;
                                tvType = tvType10;
                            }
                            synopsis2 = synopsis;
                            status2 = status;
                            year2 = year;
                            recommendations2 = recommendations;
                            tvType2 = tvType;
                            if (anilistId.element != null) {
                                this.L$0 = session2;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                this.L$2 = doc;
                                this.L$3 = japTitle;
                                this.L$4 = anime_title;
                                this.L$5 = poster;
                                this.L$6 = tvType2;
                                this.L$7 = recommendations2;
                                this.L$8 = year2;
                                status3 = status2;
                                this.L$9 = status3;
                                this.L$10 = synopsis2;
                                this.L$11 = anilistId;
                                this.L$12 = malId;
                                this.label = 3;
                                obj8 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + ((Number) anilistId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                obj6 = obj5;
                                if (obj8 == obj6) {
                                    return obj6;
                                }
                                anilistId5 = anilistId;
                                anilistId6 = malId;
                                tvType4 = tvType2;
                                session3 = session2;
                                recommendations5 = recommendations2;
                                synopsis6 = synopsis2;
                                year5 = year2;
                                String text4 = ((NiceResponse) obj8).getText();
                                Integer num7 = year5;
                                malId2 = anilistId6;
                                doc2 = doc;
                                poster2 = poster;
                                year3 = num7;
                                tvType3 = tvType4;
                                anilistId2 = anilistId5;
                                syncMetaData = text4;
                                synopsis4 = synopsis6;
                                synopsis3 = anime_title;
                                recommendations3 = recommendations5;
                                session2 = session3;
                                html3 = html2;
                            } else {
                                status3 = status2;
                                obj6 = obj5;
                                if (malId.element != null) {
                                    this.L$0 = session2;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                    this.L$2 = doc;
                                    this.L$3 = japTitle;
                                    this.L$4 = anime_title;
                                    this.L$5 = poster;
                                    this.L$6 = tvType2;
                                    this.L$7 = recommendations2;
                                    this.L$8 = year2;
                                    this.L$9 = status3;
                                    this.L$10 = synopsis2;
                                    this.L$11 = anilistId;
                                    this.L$12 = malId;
                                    this.label = 4;
                                    obj7 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + ((Number) malId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                    if (obj7 == obj6) {
                                        return obj6;
                                    }
                                    anilistId3 = anilistId;
                                    anilistId4 = malId;
                                    recommendations4 = recommendations2;
                                    synopsis5 = synopsis2;
                                    year4 = year2;
                                    tvType3 = tvType2;
                                    html3 = html2;
                                    Integer num8 = year4;
                                    malId2 = anilistId4;
                                    doc2 = doc;
                                    poster2 = poster;
                                    year3 = num8;
                                    String str9 = anime_title;
                                    recommendations3 = recommendations4;
                                    anilistId2 = anilistId3;
                                    syncMetaData = ((NiceResponse) obj7).getText();
                                    synopsis4 = synopsis5;
                                    synopsis3 = str9;
                                } else {
                                    recommendations3 = recommendations2;
                                    synopsis3 = anime_title;
                                    synopsis4 = synopsis2;
                                    html3 = html2;
                                    malId2 = malId;
                                    anilistId2 = anilistId;
                                    doc2 = doc;
                                    poster2 = poster;
                                    year3 = year2;
                                    tvType3 = tvType2;
                                    syncMetaData = null;
                                }
                            }
                            if (syncMetaData != null) {
                                animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                            } else {
                                animeMetaData = null;
                            }
                            if (animeMetaData == null) {
                                syncMetaData2 = syncMetaData;
                                html4 = html3;
                            } else {
                                syncMetaData2 = syncMetaData;
                                html4 = html3;
                            }
                            if (animeMetaData == null) {
                                obj9 = obj6;
                            } else {
                                obj9 = obj6;
                            }
                            AnimePahe animePahe14 = this.this$0;
                            if (animeMetaData != null) {
                                episodes = animeMetaData.getEpisodes();
                            } else {
                                episodes = null;
                            }
                            String session11 = session2;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(session11);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                            this.L$2 = doc2;
                            this.L$3 = japTitle;
                            this.L$4 = synopsis3;
                            this.L$5 = poster2;
                            this.L$6 = tvType3;
                            this.L$7 = recommendations3;
                            this.L$8 = year3;
                            this.L$9 = status3;
                            this.L$10 = synopsis4;
                            this.L$11 = anilistId2;
                            this.L$12 = malId2;
                            this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                            this.L$15 = metaposter;
                            this.L$16 = backgroundposter;
                            this.label = 5;
                            anilistId7 = anilistId2;
                            session5 = session11;
                            doc3 = doc2;
                            objGenerateListOfEpisodes = animePahe14.generateListOfEpisodes(session5, episodes, (Continuation) this);
                            obj10 = obj9;
                            if (objGenerateListOfEpisodes == obj10) {
                                return obj10;
                            }
                            year6 = year3;
                            recommendations6 = recommendations3;
                            japTitle2 = japTitle;
                            metaposter2 = metaposter;
                            tvType5 = backgroundposter;
                            metaposter3 = html4;
                            anime_title2 = synopsis3;
                            animeMetaData2 = animeMetaData;
                            status4 = status3;
                            syncMetaData3 = tvType3;
                            tvType6 = syncMetaData2;
                            anilistId8 = anilistId7;
                            malId3 = malId2;
                            doc4 = doc3;
                            synopsis7 = synopsis4;
                            ArrayList episodes7 = (ArrayList) objGenerateListOfEpisodes;
                            AnimePahe animePahe15 = this.this$0;
                            if (anime_title2 == null) {
                                str3 = anime_title2;
                            } else if (japTitle2 == null) {
                                str3 = str;
                            } else {
                                str3 = japTitle2;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                            this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                            this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                            this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                            this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                            this.L$17 = SpillingKt.nullOutSpilledVariable(episodes7);
                            this.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe15, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes7, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj10) {
                                return obj10;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        Object element$iv$iv$iv4 = it.next();
                        it2 = (Element) element$iv$iv$iv4;
                        animePahe3 = animePahe2;
                        int $i$f$mapNotNull5 = $i$f$mapNotNull;
                        String html8 = html;
                        title = it2.select("a").attr("title");
                        String rawHref4 = it2.select("a").attr("href");
                        session4 = StringsKt.substringAfter(rawHref4, str4, str5);
                        if (StringsKt.isBlank(session4)) {
                            session4 = null;
                        }
                        if (session4 == null) {
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            String json4 = AppUtils.INSTANCE.toJson(new LoadData(session4, APIHolder.INSTANCE.getUnixTime(), title));
                            strAttr2 = it2.select("img").attr("data-src");
                            if (strAttr2.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                strAttr2 = it2.select("img").attr("src");
                            }
                            final String posterurl4 = strAttr2;
                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(animePahe3, title, json4, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.AnimePahe$load$2$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj12) {
                                    return AnimePahe.C00042.invokeSuspend$lambda$1$2(posterurl4, (MovieSearchResponse) obj12);
                                }
                            }, 8, (Object) null);
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        animePahe2 = animePahe3;
                        $i$f$mapNotNull = $i$f$mapNotNull5;
                        html = html8;
                        str4 = str4;
                        str5 = str5;
                        coroutine_suspended = coroutine_suspended;
                    }
                    break;
                case 2:
                    String session12 = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    session2 = session12;
                    objAppGet = $result;
                    html = ((NiceResponse) objAppGet).getText();
                    doc = Ksoup.parse$default(Ksoup.INSTANCE, html, (String) null, 2, (Object) null);
                    elementSelectFirst = doc.selectFirst("h2.japanese");
                    if (elementSelectFirst != null) {
                        strText = elementSelectFirst.text();
                    } else {
                        strText = null;
                    }
                    japTitle = strText;
                    elementSelectFirst2 = doc.selectFirst("span.sr-only.unselectable");
                    if (elementSelectFirst2 != null) {
                        strText2 = elementSelectFirst2.text();
                    } else {
                        strText2 = null;
                    }
                    anime_title = strText2;
                    elementSelectFirst3 = doc.selectFirst(".anime-poster a");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("href");
                    } else {
                        strAttr = null;
                    }
                    poster = strAttr;
                    elementSelectFirst4 = doc.selectFirst("a[href*=\"/anime/type/\"]");
                    if (elementSelectFirst4 != null) {
                        strText3 = elementSelectFirst4.text();
                    } else {
                        strText3 = null;
                    }
                    tvType = strText3;
                    $this$mapNotNull$iv = doc.select("div.anime-recommendation div.row");
                    animePahe2 = this.this$0;
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    it = $this$mapNotNull$iv.iterator();
                    while (true) {
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                        if (!it.hasNext()) {
                            obj5 = coroutine_suspended;
                            str = str5;
                            html2 = html;
                            recommendations = (List) destination$iv$iv;
                            matchResultFind$default = Regex.find$default(new Regex("<strong>Aired:</strong>[^,]*, (\\d+)"), html2, 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                intOrNull = null;
                            } else {
                                intOrNull = null;
                            }
                            year = intOrNull;
                            if (doc.selectFirst("a[href='/anime/airing']") != null) {
                                showStatus = ShowStatus.Ongoing;
                            } else if (doc.selectFirst("a[href='/anime/completed']") != null) {
                                showStatus = ShowStatus.Completed;
                            } else {
                                showStatus = null;
                            }
                            status = showStatus;
                            elementSelectFirst5 = doc.selectFirst(".anime-synopsis");
                            if (elementSelectFirst5 != null) {
                                strText4 = elementSelectFirst5.text();
                            } else {
                                strText4 = null;
                            }
                            synopsis = strText4;
                            anilistId = new Ref.ObjectRef();
                            malId = new Ref.ObjectRef();
                            $this$forEach$iv = doc.select(".external-links > a");
                            $i$f$forEach = 0;
                            while (r17.hasNext()) {
                                Iterable $this$forEach$iv6 = $this$forEach$iv;
                                aTag = (Element) element$iv;
                                int $i$f$forEach6 = $i$f$forEach;
                                split = StringsKt.split$default(aTag.attr("href"), new String[]{"/"}, false, 0, 6, (Object) null);
                                String synopsis12 = synopsis;
                                ShowStatus status9 = status;
                                Integer year11 = year;
                                List recommendations11 = recommendations;
                                String tvType11 = tvType;
                                if (StringsKt.contains$default(aTag.attr("href"), "anilist.co", false, 2, (Object) null)) {
                                    anilistId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                } else if (StringsKt.contains$default(aTag.attr("href"), "myanimelist.net", false, 2, (Object) null)) {
                                    malId.element = StringsKt.toIntOrNull((String) split.get(split.size() - 1));
                                }
                                $this$forEach$iv = $this$forEach$iv6;
                                $i$f$forEach = $i$f$forEach6;
                                year = year11;
                                synopsis = synopsis12;
                                status = status9;
                                recommendations = recommendations11;
                                tvType = tvType11;
                            }
                            synopsis2 = synopsis;
                            status2 = status;
                            year2 = year;
                            recommendations2 = recommendations;
                            tvType2 = tvType;
                            if (anilistId.element != null) {
                                this.L$0 = session2;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                this.L$2 = doc;
                                this.L$3 = japTitle;
                                this.L$4 = anime_title;
                                this.L$5 = poster;
                                this.L$6 = tvType2;
                                this.L$7 = recommendations2;
                                this.L$8 = year2;
                                status3 = status2;
                                this.L$9 = status3;
                                this.L$10 = synopsis2;
                                this.L$11 = anilistId;
                                this.L$12 = malId;
                                this.label = 3;
                                obj8 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?anilist_id=" + ((Number) anilistId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                obj6 = obj5;
                                if (obj8 == obj6) {
                                    return obj6;
                                }
                                anilistId5 = anilistId;
                                anilistId6 = malId;
                                tvType4 = tvType2;
                                session3 = session2;
                                recommendations5 = recommendations2;
                                synopsis6 = synopsis2;
                                year5 = year2;
                                String text5 = ((NiceResponse) obj8).getText();
                                Integer num9 = year5;
                                malId2 = anilistId6;
                                doc2 = doc;
                                poster2 = poster;
                                year3 = num9;
                                tvType3 = tvType4;
                                anilistId2 = anilistId5;
                                syncMetaData = text5;
                                synopsis4 = synopsis6;
                                synopsis3 = anime_title;
                                recommendations3 = recommendations5;
                                session2 = session3;
                                html3 = html2;
                            } else {
                                status3 = status2;
                                obj6 = obj5;
                                if (malId.element != null) {
                                    this.L$0 = session2;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(html2);
                                    this.L$2 = doc;
                                    this.L$3 = japTitle;
                                    this.L$4 = anime_title;
                                    this.L$5 = poster;
                                    this.L$6 = tvType2;
                                    this.L$7 = recommendations2;
                                    this.L$8 = year2;
                                    this.L$9 = status3;
                                    this.L$10 = synopsis2;
                                    this.L$11 = anilistId;
                                    this.L$12 = malId;
                                    this.label = 4;
                                    obj7 = Requests.get$default(MainActivityKt.getApp(), "https://api.ani.zip/mappings?mal_id=" + ((Number) malId.element).intValue(), (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                                    if (obj7 == obj6) {
                                        return obj6;
                                    }
                                    anilistId3 = anilistId;
                                    anilistId4 = malId;
                                    recommendations4 = recommendations2;
                                    synopsis5 = synopsis2;
                                    year4 = year2;
                                    tvType3 = tvType2;
                                    html3 = html2;
                                    Integer num10 = year4;
                                    malId2 = anilistId4;
                                    doc2 = doc;
                                    poster2 = poster;
                                    year3 = num10;
                                    String str10 = anime_title;
                                    recommendations3 = recommendations4;
                                    anilistId2 = anilistId3;
                                    syncMetaData = ((NiceResponse) obj7).getText();
                                    synopsis4 = synopsis5;
                                    synopsis3 = str10;
                                } else {
                                    recommendations3 = recommendations2;
                                    synopsis3 = anime_title;
                                    synopsis4 = synopsis2;
                                    html3 = html2;
                                    malId2 = malId;
                                    anilistId2 = anilistId;
                                    doc2 = doc;
                                    poster2 = poster;
                                    year3 = year2;
                                    tvType3 = tvType2;
                                    syncMetaData = null;
                                }
                            }
                            if (syncMetaData != null) {
                                animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                            } else {
                                animeMetaData = null;
                            }
                            if (animeMetaData == null) {
                                syncMetaData2 = syncMetaData;
                                html4 = html3;
                            } else {
                                syncMetaData2 = syncMetaData;
                                html4 = html3;
                            }
                            if (animeMetaData == null) {
                                obj9 = obj6;
                            } else {
                                obj9 = obj6;
                            }
                            AnimePahe animePahe16 = this.this$0;
                            if (animeMetaData != null) {
                                episodes = animeMetaData.getEpisodes();
                            } else {
                                episodes = null;
                            }
                            String session13 = session2;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(session13);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                            this.L$2 = doc2;
                            this.L$3 = japTitle;
                            this.L$4 = synopsis3;
                            this.L$5 = poster2;
                            this.L$6 = tvType3;
                            this.L$7 = recommendations3;
                            this.L$8 = year3;
                            this.L$9 = status3;
                            this.L$10 = synopsis4;
                            this.L$11 = anilistId2;
                            this.L$12 = malId2;
                            this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                            this.L$15 = metaposter;
                            this.L$16 = backgroundposter;
                            this.label = 5;
                            anilistId7 = anilistId2;
                            session5 = session13;
                            doc3 = doc2;
                            objGenerateListOfEpisodes = animePahe16.generateListOfEpisodes(session5, episodes, (Continuation) this);
                            obj10 = obj9;
                            if (objGenerateListOfEpisodes == obj10) {
                                return obj10;
                            }
                            year6 = year3;
                            recommendations6 = recommendations3;
                            japTitle2 = japTitle;
                            metaposter2 = metaposter;
                            tvType5 = backgroundposter;
                            metaposter3 = html4;
                            anime_title2 = synopsis3;
                            animeMetaData2 = animeMetaData;
                            status4 = status3;
                            syncMetaData3 = tvType3;
                            tvType6 = syncMetaData2;
                            anilistId8 = anilistId7;
                            malId3 = malId2;
                            doc4 = doc3;
                            synopsis7 = synopsis4;
                            ArrayList episodes8 = (ArrayList) objGenerateListOfEpisodes;
                            AnimePahe animePahe17 = this.this$0;
                            if (anime_title2 == null) {
                                str3 = anime_title2;
                            } else if (japTitle2 == null) {
                                str3 = str;
                            } else {
                                str3 = japTitle2;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                            this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                            this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                            this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                            this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                            this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                            this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                            this.L$17 = SpillingKt.nullOutSpilledVariable(episodes8);
                            this.label = 6;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe17, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes8, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj10) {
                                return obj10;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                        Object element$iv$iv$iv5 = it.next();
                        it2 = (Element) element$iv$iv$iv5;
                        animePahe3 = animePahe2;
                        int $i$f$mapNotNull6 = $i$f$mapNotNull;
                        String html9 = html;
                        title = it2.select("a").attr("title");
                        String rawHref5 = it2.select("a").attr("href");
                        session4 = StringsKt.substringAfter(rawHref5, str4, str5);
                        if (StringsKt.isBlank(session4)) {
                            session4 = null;
                        }
                        if (session4 == null) {
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            String json5 = AppUtils.INSTANCE.toJson(new LoadData(session4, APIHolder.INSTANCE.getUnixTime(), title));
                            strAttr2 = it2.select("img").attr("data-src");
                            if (strAttr2.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                strAttr2 = it2.select("img").attr("src");
                            }
                            final String posterurl5 = strAttr2;
                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(animePahe3, title, json5, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.AnimePahe$load$2$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj12) {
                                    return AnimePahe.C00042.invokeSuspend$lambda$1$2(posterurl5, (MovieSearchResponse) obj12);
                                }
                            }, 8, (Object) null);
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        animePahe2 = animePahe3;
                        $i$f$mapNotNull = $i$f$mapNotNull6;
                        html = html9;
                        str4 = str4;
                        str5 = str5;
                        coroutine_suspended = coroutine_suspended;
                    }
                    break;
                case 3:
                    anilistId6 = (Ref.ObjectRef) this.L$12;
                    anilistId5 = (Ref.ObjectRef) this.L$11;
                    synopsis6 = (String) this.L$10;
                    status3 = (ShowStatus) this.L$9;
                    year5 = (Integer) this.L$8;
                    recommendations5 = (List) this.L$7;
                    String tvType12 = (String) this.L$6;
                    String poster3 = (String) this.L$5;
                    String anime_title3 = (String) this.L$4;
                    String japTitle3 = (String) this.L$3;
                    Document doc5 = (Document) this.L$2;
                    String html10 = (String) this.L$1;
                    session3 = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    str = "";
                    html2 = html10;
                    doc = doc5;
                    japTitle = japTitle3;
                    anime_title = anime_title3;
                    poster = poster3;
                    obj6 = coroutine_suspended;
                    tvType4 = tvType12;
                    obj8 = $result;
                    String text6 = ((NiceResponse) obj8).getText();
                    Integer num11 = year5;
                    malId2 = anilistId6;
                    doc2 = doc;
                    poster2 = poster;
                    year3 = num11;
                    tvType3 = tvType4;
                    anilistId2 = anilistId5;
                    syncMetaData = text6;
                    synopsis4 = synopsis6;
                    synopsis3 = anime_title;
                    recommendations3 = recommendations5;
                    session2 = session3;
                    html3 = html2;
                    if (syncMetaData != null) {
                        animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                    } else {
                        animeMetaData = null;
                    }
                    if (animeMetaData == null) {
                        syncMetaData2 = syncMetaData;
                        html4 = html3;
                    } else {
                        syncMetaData2 = syncMetaData;
                        html4 = html3;
                    }
                    if (animeMetaData == null) {
                        obj9 = obj6;
                    } else {
                        obj9 = obj6;
                    }
                    AnimePahe animePahe18 = this.this$0;
                    if (animeMetaData != null) {
                        episodes = animeMetaData.getEpisodes();
                    } else {
                        episodes = null;
                    }
                    String session14 = session2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(session14);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                    this.L$2 = doc2;
                    this.L$3 = japTitle;
                    this.L$4 = synopsis3;
                    this.L$5 = poster2;
                    this.L$6 = tvType3;
                    this.L$7 = recommendations3;
                    this.L$8 = year3;
                    this.L$9 = status3;
                    this.L$10 = synopsis4;
                    this.L$11 = anilistId2;
                    this.L$12 = malId2;
                    this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    this.L$15 = metaposter;
                    this.L$16 = backgroundposter;
                    this.label = 5;
                    anilistId7 = anilistId2;
                    session5 = session14;
                    doc3 = doc2;
                    objGenerateListOfEpisodes = animePahe18.generateListOfEpisodes(session5, episodes, (Continuation) this);
                    obj10 = obj9;
                    if (objGenerateListOfEpisodes == obj10) {
                        return obj10;
                    }
                    year6 = year3;
                    recommendations6 = recommendations3;
                    japTitle2 = japTitle;
                    metaposter2 = metaposter;
                    tvType5 = backgroundposter;
                    metaposter3 = html4;
                    anime_title2 = synopsis3;
                    animeMetaData2 = animeMetaData;
                    status4 = status3;
                    syncMetaData3 = tvType3;
                    tvType6 = syncMetaData2;
                    anilistId8 = anilistId7;
                    malId3 = malId2;
                    doc4 = doc3;
                    synopsis7 = synopsis4;
                    ArrayList episodes9 = (ArrayList) objGenerateListOfEpisodes;
                    AnimePahe animePahe19 = this.this$0;
                    if (anime_title2 == null) {
                        str3 = anime_title2;
                    } else if (japTitle2 == null) {
                        str3 = str;
                    } else {
                        str3 = japTitle2;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                    this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                    this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                    this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                    this.L$17 = SpillingKt.nullOutSpilledVariable(episodes9);
                    this.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe19, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes9, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj10) {
                        return obj10;
                    }
                    return objNewAnimeLoadResponse$default;
                case 4:
                    anilistId4 = (Ref.ObjectRef) this.L$12;
                    anilistId3 = (Ref.ObjectRef) this.L$11;
                    synopsis5 = (String) this.L$10;
                    status3 = (ShowStatus) this.L$9;
                    year4 = (Integer) this.L$8;
                    List recommendations12 = (List) this.L$7;
                    String tvType13 = (String) this.L$6;
                    poster = (String) this.L$5;
                    anime_title = (String) this.L$4;
                    japTitle = (String) this.L$3;
                    doc = (Document) this.L$2;
                    html3 = (String) this.L$1;
                    session2 = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    str = "";
                    tvType3 = tvType13;
                    obj6 = coroutine_suspended;
                    recommendations4 = recommendations12;
                    obj7 = $result;
                    Integer num12 = year4;
                    malId2 = anilistId4;
                    doc2 = doc;
                    poster2 = poster;
                    year3 = num12;
                    String str11 = anime_title;
                    recommendations3 = recommendations4;
                    anilistId2 = anilistId3;
                    syncMetaData = ((NiceResponse) obj7).getText();
                    synopsis4 = synopsis5;
                    synopsis3 = str11;
                    if (syncMetaData != null) {
                        animeMetaData = UtilsKt.parseAnimeData(syncMetaData);
                    } else {
                        animeMetaData = null;
                    }
                    if (animeMetaData == null) {
                        syncMetaData2 = syncMetaData;
                        html4 = html3;
                    } else {
                        syncMetaData2 = syncMetaData;
                        html4 = html3;
                    }
                    if (animeMetaData == null) {
                        obj9 = obj6;
                    } else {
                        obj9 = obj6;
                    }
                    AnimePahe animePahe110 = this.this$0;
                    if (animeMetaData != null) {
                        episodes = animeMetaData.getEpisodes();
                    } else {
                        episodes = null;
                    }
                    String session15 = session2;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(session15);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(html4);
                    this.L$2 = doc2;
                    this.L$3 = japTitle;
                    this.L$4 = synopsis3;
                    this.L$5 = poster2;
                    this.L$6 = tvType3;
                    this.L$7 = recommendations3;
                    this.L$8 = year3;
                    this.L$9 = status3;
                    this.L$10 = synopsis4;
                    this.L$11 = anilistId2;
                    this.L$12 = malId2;
                    this.L$13 = SpillingKt.nullOutSpilledVariable(syncMetaData2);
                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData);
                    this.L$15 = metaposter;
                    this.L$16 = backgroundposter;
                    this.label = 5;
                    anilistId7 = anilistId2;
                    session5 = session15;
                    doc3 = doc2;
                    objGenerateListOfEpisodes = animePahe110.generateListOfEpisodes(session5, episodes, (Continuation) this);
                    obj10 = obj9;
                    if (objGenerateListOfEpisodes == obj10) {
                        return obj10;
                    }
                    year6 = year3;
                    recommendations6 = recommendations3;
                    japTitle2 = japTitle;
                    metaposter2 = metaposter;
                    tvType5 = backgroundposter;
                    metaposter3 = html4;
                    anime_title2 = synopsis3;
                    animeMetaData2 = animeMetaData;
                    status4 = status3;
                    syncMetaData3 = tvType3;
                    tvType6 = syncMetaData2;
                    anilistId8 = anilistId7;
                    malId3 = malId2;
                    doc4 = doc3;
                    synopsis7 = synopsis4;
                    ArrayList episodes10 = (ArrayList) objGenerateListOfEpisodes;
                    AnimePahe animePahe111 = this.this$0;
                    if (anime_title2 == null) {
                        str3 = anime_title2;
                    } else if (japTitle2 == null) {
                        str3 = str;
                    } else {
                        str3 = japTitle2;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                    this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                    this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                    this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                    this.L$17 = SpillingKt.nullOutSpilledVariable(episodes10);
                    this.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe111, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes10, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj10) {
                        return obj10;
                    }
                    return objNewAnimeLoadResponse$default;
                case 5:
                    String backgroundposter2 = (String) this.L$16;
                    String metaposter4 = (String) this.L$15;
                    animeMetaData2 = (MetaAnimeData) this.L$14;
                    String syncMetaData5 = (String) this.L$13;
                    Ref.ObjectRef malId4 = (Ref.ObjectRef) this.L$12;
                    Ref.ObjectRef anilistId9 = (Ref.ObjectRef) this.L$11;
                    String synopsis13 = (String) this.L$10;
                    ShowStatus status10 = (ShowStatus) this.L$9;
                    Integer year12 = (Integer) this.L$8;
                    List recommendations13 = (List) this.L$7;
                    String tvType14 = (String) this.L$6;
                    poster2 = (String) this.L$5;
                    String anime_title4 = (String) this.L$4;
                    String japTitle4 = (String) this.L$3;
                    Document doc6 = (Document) this.L$2;
                    String html11 = (String) this.L$1;
                    String session16 = (String) this.L$0;
                    ResultKt.throwOnFailure($result);
                    status4 = status10;
                    anime_title2 = anime_title4;
                    year6 = year12;
                    japTitle2 = japTitle4;
                    str = "";
                    tvType6 = syncMetaData5;
                    anilistId8 = anilistId9;
                    recommendations6 = recommendations13;
                    syncMetaData3 = tvType14;
                    tvType5 = backgroundposter2;
                    obj10 = coroutine_suspended;
                    metaposter2 = metaposter4;
                    metaposter3 = html11;
                    session5 = session16;
                    objGenerateListOfEpisodes = $result;
                    malId3 = malId4;
                    doc4 = doc6;
                    synopsis7 = synopsis13;
                    ArrayList episodes11 = (ArrayList) objGenerateListOfEpisodes;
                    AnimePahe animePahe112 = this.this$0;
                    if (anime_title2 == null) {
                        str3 = anime_title2;
                    } else if (japTitle2 == null) {
                        str3 = str;
                    } else {
                        str3 = japTitle2;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(session5);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(metaposter3);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(japTitle2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(anime_title2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(syncMetaData3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(recommendations6);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(year6);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(status4);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(synopsis7);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(anilistId8);
                    this.L$12 = SpillingKt.nullOutSpilledVariable(malId3);
                    this.L$13 = SpillingKt.nullOutSpilledVariable(tvType6);
                    this.L$14 = SpillingKt.nullOutSpilledVariable(animeMetaData2);
                    this.L$15 = SpillingKt.nullOutSpilledVariable(metaposter2);
                    this.L$16 = SpillingKt.nullOutSpilledVariable(tvType5);
                    this.L$17 = SpillingKt.nullOutSpilledVariable(episodes11);
                    this.label = 6;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(animePahe112, str3, this.$url, AnimePahe.INSTANCE.getType(String.valueOf(syncMetaData3)), false, new AnonymousClass2(anime_title2, japTitle2, metaposter2, tvType5, poster2, year6, episodes11, status4, synopsis7, doc4, recommendations6, malId3, anilistId8, null), (Continuation) this, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj10) {
                        return obj10;
                    }
                    return objNewAnimeLoadResponse$default;
                case 6:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$2(String $posterurl, MovieSearchResponse $this$newMovieSearchResponse) {
            $this$newMovieSearchResponse.setPosterUrl($posterurl);
            $this$newMovieSearchResponse.setPosterHeaders(AnimePahe.INSTANCE.getCfHeaders());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.phisher98.AnimePahe$load$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: AnimePahe.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.AnimePahe$load$2$2", f = "AnimePahe.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        @SourceDebugExtension({"SMAP\nAnimePahe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$load$2$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,581:1\n1739#2:582\n1814#2,3:583\n*S KotlinDebug\n*F\n+ 1 AnimePahe.kt\ncom/phisher98/AnimePahe$load$2$2\n*L\n495#1:582\n495#1:583,3\n*E\n"})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<Integer> $anilistId;
            final /* synthetic */ String $anime_title;
            final /* synthetic */ String $backgroundposter;
            final /* synthetic */ Document $doc;
            final /* synthetic */ ArrayList<Episode> $episodes;
            final /* synthetic */ String $japTitle;
            final /* synthetic */ Ref.ObjectRef<Integer> $malId;
            final /* synthetic */ String $metaposter;
            final /* synthetic */ String $poster;
            final /* synthetic */ List<MovieSearchResponse> $recommendations;
            final /* synthetic */ ShowStatus $status;
            final /* synthetic */ String $synopsis;
            final /* synthetic */ Integer $year;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(String str, String str2, String str3, String str4, String str5, Integer num, ArrayList<Episode> arrayList, ShowStatus showStatus, String str6, Document document, List<MovieSearchResponse> list, Ref.ObjectRef<Integer> objectRef, Ref.ObjectRef<Integer> objectRef2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$anime_title = str;
                this.$japTitle = str2;
                this.$metaposter = str3;
                this.$backgroundposter = str4;
                this.$poster = str5;
                this.$year = num;
                this.$episodes = arrayList;
                this.$status = showStatus;
                this.$synopsis = str6;
                this.$doc = document;
                this.$recommendations = list;
                this.$malId = objectRef;
                this.$anilistId = objectRef2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass2 = new AnonymousClass2(this.$anime_title, this.$japTitle, this.$metaposter, this.$backgroundposter, this.$poster, this.$year, this.$episodes, this.$status, this.$synopsis, this.$doc, this.$recommendations, this.$malId, this.$anilistId, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
                return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ArrayList arrayList;
                LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loadResponse.setEngName(this.$anime_title);
                        loadResponse.setJapName(this.$japTitle);
                        loadResponse.setPosterUrl(this.$metaposter);
                        loadResponse.setPosterHeaders(AnimePahe.INSTANCE.getCfHeaders());
                        String str = this.$backgroundposter;
                        if (str == null) {
                            str = this.$poster;
                        }
                        loadResponse.setBackgroundPosterUrl(str);
                        loadResponse.setYear(this.$year);
                        MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                        loadResponse.setShowStatus(this.$status);
                        loadResponse.setPlot(this.$synopsis);
                        if (!this.$doc.select(".anime-genre > ul a").isEmpty()) {
                            Iterable $this$map$iv = this.$doc.select(".anime-genre > ul a");
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Element it = (Element) item$iv$iv;
                                destination$iv$iv.add(it.text());
                            }
                            arrayList = new ArrayList((List) destination$iv$iv);
                        } else {
                            arrayList = null;
                        }
                        loadResponse.setTags(arrayList);
                        loadResponse.setRecommendations(this.$recommendations);
                        LoadResponse.Companion.addMalId(loadResponse, (Integer) this.$malId.element);
                        LoadResponse.Companion.addAniListId(loadResponse, (Integer) this.$anilistId.element);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        return ArchComponentExtKt.safeAsync(new C00042(url, this, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0119  */
    /* JADX WARN: Code duplicated, block: B:43:0x0135 A[Catch: Exception -> 0x014d, TRY_LEAVE, TryCatch #1 {Exception -> 0x014d, blocks: (B:24:0x00e5, B:31:0x0113, B:34:0x011a, B:43:0x0135, B:42:0x012f, B:30:0x0108, B:23:0x00db, B:27:0x00ec, B:20:0x00c2, B:37:0x0120), top: B:73:0x00c2, inners: #2, #3, #5 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0186  */
    /* JADX WARN: Code duplicated, block: B:62:0x01ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x01e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:69:0x022c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x022d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        C00051 c00051;
        Object obj;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        Object url;
        String data2;
        LinkLoadData parsed;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        boolean isCasting2;
        String str;
        String episodeUrl;
        Object objAppGet;
        org.jsoup.nodes.Document document;
        List listSelect;
        C00062 c00062;
        LinkLoadData parsed2;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        String data3;
        List listSelect2;
        C00073 c00073;
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
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data != null) {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(LinkLoadData.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<LinkLoadData>() { // from class: com.phisher98.AnimePahe$loadLinks$$inlined$tryParseJson$1
                                    });
                                } catch (Throwable th2) {
                                    ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<LinkLoadData>() { // from class: com.phisher98.AnimePahe$loadLinks$$inlined$tryParseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<LinkLoadData>() { // from class: com.phisher98.AnimePahe$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkLoadData.class), (List) null, 2, (Object) null));
                            } catch (Throwable th3) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th3));
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(data, new TypeReference<LinkLoadData>() { // from class: com.phisher98.AnimePahe$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        }
                    } catch (Exception e2) {
                        objDecodeFromString = null;
                    }
                    break;
                } else {
                    objDecodeFromString = null;
                }
                LinkLoadData parsed3 = (LinkLoadData) objDecodeFromString;
                if (parsed3 == null) {
                    return Boxing.boxBoolean(false);
                }
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = function1;
                c00052.L$2 = function2;
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed3);
                c00052.Z$0 = isCasting;
                c00052.label = 1;
                url = parsed3.getUrl(c00052);
                if (url == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data2 = data;
                parsed = parsed3;
                function3 = function1;
                function4 = function2;
                isCasting2 = isCasting;
                str = (String) url;
                if (str == null) {
                    str = "";
                }
                episodeUrl = str;
                Companion companion5 = INSTANCE;
                Map<String, String> map = headers;
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = function3;
                c00052.L$2 = function4;
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.Z$0 = isCasting2;
                c00052.label = 2;
                objAppGet = companion5.appGet(episodeUrl, map, c00052);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                document = ((NiceResponse) objAppGet).getDocument();
                listSelect = document.select("#resolutionMenu button");
                c00062 = new C00062(function3, function4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = function3;
                c00052.L$2 = function4;
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = document;
                c00052.Z$0 = isCasting2;
                c00052.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00062, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                parsed2 = parsed;
                function5 = function4;
                function6 = function3;
                data3 = data2;
                listSelect2 = document.select("div#pickDownload > a");
                c00073 = new C00073(function6, function5, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed2);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00052.Z$0 = isCasting2;
                c00052.label = 4;
                if (ParCollectionsKt.amap(listSelect2, c00073, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 1:
                isCasting2 = c00052.Z$0;
                parsed = (LinkLoadData) c00052.L$3;
                function4 = (Function1) c00052.L$2;
                function3 = (Function1) c00052.L$1;
                data2 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                url = $result;
                str = (String) url;
                if (str == null) {
                    str = "";
                }
                episodeUrl = str;
                Companion companion6 = INSTANCE;
                Map<String, String> map2 = headers;
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = function3;
                c00052.L$2 = function4;
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.Z$0 = isCasting2;
                c00052.label = 2;
                objAppGet = companion6.appGet(episodeUrl, map2, c00052);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                document = ((NiceResponse) objAppGet).getDocument();
                listSelect = document.select("#resolutionMenu button");
                c00062 = new C00062(function3, function4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = function3;
                c00052.L$2 = function4;
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = document;
                c00052.Z$0 = isCasting2;
                c00052.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00062, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                parsed2 = parsed;
                function5 = function4;
                function6 = function3;
                data3 = data2;
                listSelect2 = document.select("div#pickDownload > a");
                c00073 = new C00073(function6, function5, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed2);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00052.Z$0 = isCasting2;
                c00052.label = 4;
                if (ParCollectionsKt.amap(listSelect2, c00073, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 2:
                isCasting2 = c00052.Z$0;
                episodeUrl = (String) c00052.L$4;
                parsed = (LinkLoadData) c00052.L$3;
                function4 = (Function1) c00052.L$2;
                function3 = (Function1) c00052.L$1;
                data2 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet = $result;
                document = ((NiceResponse) objAppGet).getDocument();
                listSelect = document.select("#resolutionMenu button");
                c00062 = new C00062(function3, function4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = function3;
                c00052.L$2 = function4;
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = document;
                c00052.Z$0 = isCasting2;
                c00052.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00062, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                parsed2 = parsed;
                function5 = function4;
                function6 = function3;
                data3 = data2;
                listSelect2 = document.select("div#pickDownload > a");
                c00073 = new C00073(function6, function5, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed2);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00052.Z$0 = isCasting2;
                c00052.label = 4;
                if (ParCollectionsKt.amap(listSelect2, c00073, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 3:
                isCasting2 = c00052.Z$0;
                org.jsoup.nodes.Document document2 = (org.jsoup.nodes.Document) c00052.L$5;
                String episodeUrl2 = (String) c00052.L$4;
                LinkLoadData parsed4 = (LinkLoadData) c00052.L$3;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00052.L$2;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c00052.L$1;
                String data4 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                document = document2;
                episodeUrl = episodeUrl2;
                parsed2 = parsed4;
                function5 = function7;
                function6 = function8;
                data3 = data4;
                listSelect2 = document.select("div#pickDownload > a");
                c00073 = new C00073(function6, function5, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(parsed2);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00052.Z$0 = isCasting2;
                c00052.label = 4;
                if (ParCollectionsKt.amap(listSelect2, c00073, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 4:
                boolean z = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$loadLinks$2 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe$loadLinks$2", f = "AnimePahe.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {537}, m = "invokeSuspend", n = {"it", "audio", "badgeLang", "fullText", "type", "qualityRegex", "text", "match", "href", "quality"}, nl = {546}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<org.jsoup.nodes.Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = AnimePahe.this.new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(org.jsoup.nodes.Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String type;
            Regex qualityRegex;
            String text;
            String type2;
            MatchResult match;
            int quality;
            String href;
            List groupValues;
            String str;
            String strSubstringBefore$default;
            Integer intOrNull;
            org.jsoup.nodes.Element it = (org.jsoup.nodes.Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String audio = it.attr("data-audio").toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(audio, "toLowerCase(...)");
                    String badgeLang = it.select("span.badge-warning").text().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(badgeLang, "toLowerCase(...)");
                    String fullText = it.text().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(fullText, "toLowerCase(...)");
                    if (Intrinsics.areEqual(audio, "eng") || StringsKt.contains$default(badgeLang, "eng", false, 2, (Object) null) || StringsKt.contains$default(fullText, "eng", false, 2, (Object) null) || StringsKt.contains$default(fullText, "dub", false, 2, (Object) null)) {
                        type = "DUB";
                    } else {
                        type = "SUB";
                        if (!Intrinsics.areEqual(audio, "jpn") && !StringsKt.contains$default(badgeLang, "jpn", false, 2, (Object) null)) {
                            if (audio.length() > 0) {
                                type = audio.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(type, "toUpperCase(...)");
                            } else {
                                if (badgeLang.length() > 0) {
                                    type = badgeLang.toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(type, "toUpperCase(...)");
                                }
                            }
                        }
                    }
                    Regex qualityRegex2 = new Regex("(.+?)\\s+·\\s+(\\d{3,4}p)");
                    String text2 = it.text();
                    MatchResult match2 = Regex.find$default(qualityRegex2, text2, 0, 2, (Object) null);
                    int quality2 = (match2 == null || (groupValues = match2.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 2)) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(str, "p", (String) null, 2, (Object) null)) == null || (intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
                    String href2 = it.attr("data-src");
                    if (StringsKt.contains$default(href2, "kwik", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(audio);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(badgeLang);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(fullText);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(type);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(qualityRegex2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(text2);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(match2);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(href2);
                        this.I$0 = quality2;
                        this.label = 1;
                        if (UtilsKt.loadCustomExtractor("Kwik [" + type + ']', href2, AnimePahe.this.getMainUrl(), this.$subtitleCallback, this.$callback, Boxing.boxInt(quality2), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        qualityRegex = qualityRegex2;
                        text = text2;
                        type2 = type;
                        match = match2;
                        quality = quality2;
                        href = href2;
                    }
                    return Unit.INSTANCE;
                case 1:
                    quality = this.I$0;
                    href = (String) this.L$8;
                    match = (MatchResult) this.L$7;
                    text = (String) this.L$6;
                    qualityRegex = (Regex) this.L$5;
                    type2 = (String) this.L$4;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AnimePahe$loadLinks$3 */
    /* JADX INFO: compiled from: AnimePahe.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AnimePahe$loadLinks$3", f = "AnimePahe.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {565}, m = "invokeSuspend", n = {"it", "qualityRegex", "href", "badgeLang", "anchorText", "type", "text", "match", "quality"}, nl = {573}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00073 extends SuspendLambda implements Function2<org.jsoup.nodes.Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00073(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00073> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00073 = AnimePahe.this.new C00073(this.$subtitleCallback, this.$callback, continuation);
            c00073.L$0 = obj;
            return c00073;
        }

        public final Object invoke(org.jsoup.nodes.Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String type;
            String strSubstringBefore$default;
            List groupValues;
            String str;
            org.jsoup.nodes.Element it = (org.jsoup.nodes.Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Regex qualityRegex = new Regex("(.+?)\\s+·\\s+(\\d{3,4}p)");
                    String href = it.attr("href");
                    String badgeLang = it.select("span.badge-warning").text().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(badgeLang, "toLowerCase(...)");
                    String anchorText = it.text().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(anchorText, "toLowerCase(...)");
                    if (StringsKt.contains$default(badgeLang, "eng", false, 2, (Object) null) || StringsKt.contains$default(anchorText, "eng", false, 2, (Object) null) || StringsKt.contains$default(anchorText, "dub", false, 2, (Object) null)) {
                        type = "DUB";
                    } else {
                        type = "SUB";
                        if (!StringsKt.contains$default(badgeLang, "jpn", false, 2, (Object) null)) {
                            if (badgeLang.length() > 0) {
                                type = badgeLang.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(type, "toUpperCase(...)");
                            }
                        }
                    }
                    String text = it.text();
                    MatchResult match = Regex.find$default(qualityRegex, text, 0, 2, (Object) null);
                    if (match == null || (groupValues = match.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 2)) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(str, "p", (String) null, 2, (Object) null)) == null) {
                        strSubstringBefore$default = "Unknown";
                    }
                    String quality = strSubstringBefore$default;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(qualityRegex);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(href);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(badgeLang);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(anchorText);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(text);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(match);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(quality);
                    this.label = 1;
                    if (UtilsKt.loadCustomExtractor("Kwik [Download] [" + type + ']', href, AnimePahe.this.getMainUrl(), this.$subtitleCallback, this.$callback, StringsKt.toIntOrNull(quality), (Continuation) this) == coroutine_suspended) {
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
}
