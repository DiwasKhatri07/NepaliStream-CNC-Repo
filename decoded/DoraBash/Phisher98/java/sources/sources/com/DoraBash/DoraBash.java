package com.DoraBash;

import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
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
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: DoraBash.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DoraBash/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ,\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eH\u0082@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u001e\u0010/\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u0012\u00107\u001a\u000208*\u00020\u0006H\u0082@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010<JF\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\n2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00160A2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00160AH\u0096@¢\u0006\u0002\u0010EJb\u0010F\u001a\u00020\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00160A2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00160A2\n\b\u0002\u0010H\u001a\u0004\u0018\u000103H\u0086@¢\u0006\u0002\u0010IR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u0014\u0010%\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006J"}, d2 = {"Lcom/DoraBash/DoraBash;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "getImageUrl", "", "Lorg/jsoup/nodes/Element;", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "cfHeaders", "", "getCfHeaders", "()Ljava/util/Map;", "appGet", "url", "extraHeaders", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectCookiesToApp", "", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "(Lorg/jsoup/nodes/Element;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCustomExtractor", "referer", "quality", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDoraBash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBash\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,342:1\n1#2:343\n1#2:367\n117#3,10:344\n2068#4,2:354\n1795#4,10:356\n2068#4:366\n2069#4:368\n1805#4:369\n1739#4:371\n1814#4,3:372\n68#5:370\n*S KotlinDebug\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBash\n*L\n197#1:367\n144#1:344,10\n163#1:354,2\n197#1:356,10\n197#1:366\n197#1:368\n197#1:369\n238#1:371\n238#1:372,3\n238#1:370\n*E\n"})
public final class DoraBash extends MainAPI {

    @NotNull
    private final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private String mainUrl = "https://dorabash.in";

    @NotNull
    private String name = "DoraBash";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("anime-type/tv", "Seasons"), TuplesKt.to("anime-type/movie", "Movies"), TuplesKt.to("anime-type/short-movie", "Short Movies"), TuplesKt.to("anime-type/specials", "Specials")});

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$appGet$1 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash", f = "DoraBash.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {140, 347, 145, 149, 154}, m = "appGet", n = {"url", "extraHeaders", "url", "extraHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "extraHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "extraHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "url", "extraHeaders", "rawResponse", "recheckPassed"}, nl = {141, 348, 146, 151, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoraBash.this.appGet(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$getMainPage$1 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash", f = "DoraBash.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {196, 196, 197}, m = "getMainPage", n = {"request", "page", "request", "page", "request", "document", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "it", "page"}, nl = {196, 197, 352}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoraBash.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$load$1 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash", f = "DoraBash.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {223, 238, 246, 258}, m = "load", n = {"url", "url", "doc", "title", "backgroundposter", "description", "poster", "rating", "year", "contentRating", "duration", "type", "tvtag", "seasonId", "url", "doc", "title", "backgroundposter", "description", "poster", "rating", "year", "contentRating", "duration", "type", "tvtag", "seasonId", "episodes", "url", "doc", "title", "backgroundposter", "description", "poster", "rating", "year", "contentRating", "duration", "type", "tvtag"}, nl = {224, 343, 258, 235}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    static final class C00091 extends ContinuationImpl {
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

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoraBash.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$loadCustomExtractor$1 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash", f = "DoraBash.kt", i = {0, 0, 0, 0, 0, 0}, l = {319}, m = "loadCustomExtractor", n = {"name", "url", "referer", "subtitleCallback", "callback", "quality"}, nl = {338}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoraBash.this.loadCustomExtractor(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$loadLinks$1 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash", f = "DoraBash.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {277, 279}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {279, 309}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoraBash.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$toSearchResult$1 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash", f = "DoraBash.kt", i = {0, 0, 0}, l = {212}, m = "toSearchResult", n = {"$this$toSearchResult", "title", "href"}, nl = {213}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoraBash.this.toSearchResult(null, (Continuation) this);
        }
    }

    private final String getImageUrl(Element $this$getImageUrl) {
        String it = $this$getImageUrl.attr("data-src");
        if (StringsKt.isBlank(it)) {
            it = null;
        }
        if (it == null) {
            it = $this$getImageUrl.attr("data-lazy-src");
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                it = StringsKt.substringBefore$default($this$getImageUrl.attr("srcset"), " ", (String) null, 2, (Object) null);
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                if (it == null) {
                    it = $this$getImageUrl.attr("src");
                }
            }
        }
        if (StringsKt.startsWith$default(it, "data:image", false, 2, (Object) null)) {
            return null;
        }
        return it;
    }

    public final boolean isCloudflareBlocked(@NotNull NiceResponse response) {
        if (response.getCode() != 403 && response.getCode() != 503) {
            return false;
        }
        String body = response.getText();
        String lower = body.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        return StringsKt.contains$default(lower, "<title>just a moment", false, 2, (Object) null) || StringsKt.contains$default(lower, "id=\"challenge-form\"", false, 2, (Object) null) || StringsKt.contains$default(lower, "cf-browser-verification", false, 2, (Object) null) || StringsKt.contains$default(lower, "checking your browser before accessing", false, 2, (Object) null);
    }

    @NotNull
    public final Map<String, String> getCfHeaders() {
        String str;
        Map map = new LinkedHashMap();
        map.put("referer", getMainUrl() + '/');
        String savedUa = DoraBashProvider.INSTANCE.getCfUserAgent();
        if (savedUa.length() > 0) {
            map.put("User-Agent", savedUa);
        }
        String combinedCookies = DoraBashProvider.INSTANCE.getCfCookies();
        try {
            HttpUrl httpUrl = HttpUrl.Companion.parse(getMainUrl());
            if (httpUrl != null) {
                List jarCookies = MainActivityKt.getApp().getBaseClient().cookieJar().loadForRequest(httpUrl);
                if (!jarCookies.isEmpty()) {
                    String jarCookieString = CollectionsKt.joinToString$default(jarCookies, "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.DoraBash.DoraBash$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return DoraBash._get_cfHeaders_$lambda$0((Cookie) obj);
                        }
                    }, 30, (Object) null);
                    if (!(combinedCookies.length() == 0)) {
                        str = combinedCookies + "; " + jarCookieString;
                    } else {
                        str = jarCookieString;
                    }
                    combinedCookies = str;
                }
            }
        } catch (Exception e) {
        }
        if (combinedCookies.length() > 0) {
            map.put("Cookie", combinedCookies);
        }
        return map;
    }

    static final CharSequence _get_cfHeaders_$lambda$0(Cookie it) {
        return it.name() + '=' + it.value();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x011a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x011b  */
    /* JADX WARN: Code duplicated, block: B:32:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x013c  */
    /* JADX WARN: Code duplicated, block: B:40:0x018d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x018e  */
    /* JADX WARN: Code duplicated, block: B:44:0x01a4 A[Catch: all -> 0x01a7, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01a7, blocks: (B:44:0x01a4, B:50:0x01b4), top: B:79:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01ac A[Catch: all -> 0x024c, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x024c, blocks: (B:42:0x019b, B:48:0x01ac), top: B:81:0x019b }] */
    /* JADX WARN: Code duplicated, block: B:50:0x01b4 A[Catch: all -> 0x01a7, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x01a7, blocks: (B:44:0x01a4, B:50:0x01b4), top: B:79:0x01a2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:60:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:62:0x0238 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0239  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object appGet(String url, Map<String, String> map, Continuation<? super NiceResponse> continuation) throws Throwable {
        C00071 c00071;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Object obj;
        C00071 c00072;
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
        C00071 c00073;
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
        C00071 c00074 = c00071;
        Object $result = c00074.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00074.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor = DoraBashCFBypassInterceptor.INSTANCE;
                    c00074.L$0 = url;
                    c00074.L$1 = map;
                    c00074.label = 1;
                    obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor, false, (ResponseParser) null, c00074, 3580, (Object) null);
                    c00072 = c00074;
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
                    $this$withLock_u24default$iv2 = this.cfBypassMutex;
                    c00072.L$0 = url2;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                    c00072.L$3 = recheckPassed;
                    c00072.L$4 = $this$withLock_u24default$iv2;
                    c00072.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00072) == coroutine_suspended) {
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
                        DoraBashCFBypassInterceptor doraBashCFBypassInterceptor2 = DoraBashCFBypassInterceptor.INSTANCE;
                        c00072.L$0 = url3;
                        c00072.L$1 = map2;
                        c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        c00072.L$3 = recheckPassed2;
                        c00072.L$4 = $this$withLock_u24default$iv3;
                        c00072.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        C00071 c00075 = c00072;
                        url4 = url3;
                        try {
                            obj2 = Requests.get$default(app2, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor2, false, (ResponseParser) null, c00075, 3580, (Object) null);
                            c00073 = c00075;
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
                                        if (!isCloudflareBlocked(recheck)) {
                                            if (DoraBashProvider.INSTANCE.getCfWebviewEnabled()) {
                                                c00073.L$0 = url5;
                                                c00073.L$1 = map3;
                                                c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                c00073.L$3 = recheckPassed4;
                                                c00073.L$4 = $this$withLock_u24default$iv;
                                                c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                                c00073.label = 4;
                                                if (DoraBashKt.showDoraBashCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
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
                                            DoraBashCFBypassInterceptor doraBashCFBypassInterceptor3 = DoraBashCFBypassInterceptor.INSTANCE;
                                            c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                            c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                            c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed6);
                                            c00073.L$4 = null;
                                            c00073.L$5 = null;
                                            c00073.label = 5;
                                            obj3 = Requests.get$default(app3, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor3, false, (ResponseParser) null, c00073, 3580, (Object) null);
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
                                        DoraBashCFBypassInterceptor doraBashCFBypassInterceptor4 = DoraBashCFBypassInterceptor.INSTANCE;
                                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed7);
                                        c00073.L$4 = null;
                                        c00073.L$5 = null;
                                        c00073.label = 5;
                                        obj3 = Requests.get$default(app4, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor4, false, (ResponseParser) null, c00073, 3580, (Object) null);
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
                    map2 = (Map) c00074.L$1;
                    url2 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    c00072 = c00074;
                    obj = $result;
                    rawResponse = (NiceResponse) obj;
                    if (!isCloudflareBlocked(rawResponse)) {
                        return rawResponse;
                    }
                    recheckPassed = new Ref.ObjectRef();
                    $this$withLock_u24default$iv2 = this.cfBypassMutex;
                    c00072.L$0 = url2;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                    c00072.L$3 = recheckPassed;
                    c00072.L$4 = $this$withLock_u24default$iv2;
                    c00072.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00072) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rawResponse2 = rawResponse;
                    url3 = url2;
                    recheckPassed2 = recheckPassed;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv2 = null;
                    $i$f$withLock = 0;
                    Requests app5 = MainActivityKt.getApp();
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor5 = DoraBashCFBypassInterceptor.INSTANCE;
                    c00072.L$0 = url3;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00072.L$3 = recheckPassed2;
                    c00072.L$4 = $this$withLock_u24default$iv3;
                    c00072.label = 3;
                    recheckPassed3 = recheckPassed2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                    C00071 c00076 = c00072;
                    url4 = url3;
                    obj2 = Requests.get$default(app5, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor5, false, (ResponseParser) null, c00076, 3580, (Object) null);
                    c00073 = c00076;
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
                    if (!isCloudflareBlocked(recheck)) {
                        if (DoraBashProvider.INSTANCE.getCfWebviewEnabled()) {
                            c00073.L$0 = url5;
                            c00073.L$1 = map3;
                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00073.L$3 = recheckPassed4;
                            c00073.L$4 = $this$withLock_u24default$iv;
                            c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00073.label = 4;
                            if (DoraBashKt.showDoraBashCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
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
                        DoraBashCFBypassInterceptor doraBashCFBypassInterceptor6 = DoraBashCFBypassInterceptor.INSTANCE;
                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed8);
                        c00073.L$4 = null;
                        c00073.L$5 = null;
                        c00073.label = 5;
                        obj3 = Requests.get$default(app6, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor6, false, (ResponseParser) null, c00073, 3580, (Object) null);
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
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor7 = DoraBashCFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed9);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app7, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor7, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 2:
                    Mutex $this$withLock_u24default$iv5 = (Mutex) c00074.L$4;
                    Ref.ObjectRef recheckPassed10 = (Ref.ObjectRef) c00074.L$3;
                    NiceResponse rawResponse5 = (NiceResponse) c00074.L$2;
                    Map<String, String> map4 = (Map) c00074.L$1;
                    url3 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withLock = 0;
                    owner$iv2 = null;
                    recheckPassed2 = recheckPassed10;
                    rawResponse2 = rawResponse5;
                    map2 = map4;
                    c00072 = c00074;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                    Requests app8 = MainActivityKt.getApp();
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor8 = DoraBashCFBypassInterceptor.INSTANCE;
                    c00072.L$0 = url3;
                    c00072.L$1 = map2;
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00072.L$3 = recheckPassed2;
                    c00072.L$4 = $this$withLock_u24default$iv3;
                    c00072.label = 3;
                    recheckPassed3 = recheckPassed2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                    C00071 c00077 = c00072;
                    url4 = url3;
                    obj2 = Requests.get$default(app8, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor8, false, (ResponseParser) null, c00077, 3580, (Object) null);
                    c00073 = c00077;
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
                    if (!isCloudflareBlocked(recheck)) {
                        if (DoraBashProvider.INSTANCE.getCfWebviewEnabled()) {
                            c00073.L$0 = url5;
                            c00073.L$1 = map3;
                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00073.L$3 = recheckPassed4;
                            c00073.L$4 = $this$withLock_u24default$iv;
                            c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00073.label = 4;
                            if (DoraBashKt.showDoraBashCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
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
                        DoraBashCFBypassInterceptor doraBashCFBypassInterceptor9 = DoraBashCFBypassInterceptor.INSTANCE;
                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed11);
                        c00073.L$4 = null;
                        c00073.L$5 = null;
                        c00073.label = 5;
                        obj3 = Requests.get$default(app9, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor9, false, (ResponseParser) null, c00073, 3580, (Object) null);
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
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor10 = DoraBashCFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed12);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app10, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor10, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 3:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00074.L$4;
                    recheckPassed4 = (Ref.ObjectRef) c00074.L$3;
                    rawResponse3 = (NiceResponse) c00074.L$2;
                    map3 = (Map) c00074.L$1;
                    url5 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    c00073 = c00074;
                    recheck = (NiceResponse) $result;
                    if (!isCloudflareBlocked(recheck)) {
                        if (DoraBashProvider.INSTANCE.getCfWebviewEnabled()) {
                            c00073.L$0 = url5;
                            c00073.L$1 = map3;
                            c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00073.L$3 = recheckPassed4;
                            c00073.L$4 = $this$withLock_u24default$iv;
                            c00073.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00073.label = 4;
                            if (DoraBashKt.showDoraBashCFBypassDialogAndWait(url5, c00073) == coroutine_suspended) {
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
                        DoraBashCFBypassInterceptor doraBashCFBypassInterceptor11 = DoraBashCFBypassInterceptor.INSTANCE;
                        c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed13);
                        c00073.L$4 = null;
                        c00073.L$5 = null;
                        c00073.label = 5;
                        obj3 = Requests.get$default(app11, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor11, false, (ResponseParser) null, c00073, 3580, (Object) null);
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
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor12 = DoraBashCFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed14);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app12, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor12, false, (ResponseParser) null, c00073, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 4:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00074.L$4;
                    recheckPassed4 = (Ref.ObjectRef) c00074.L$3;
                    rawResponse3 = (NiceResponse) c00074.L$2;
                    map3 = (Map) c00074.L$1;
                    url5 = (String) c00074.L$0;
                    ResultKt.throwOnFailure($result);
                    c00073 = c00074;
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
                    DoraBashCFBypassInterceptor doraBashCFBypassInterceptor13 = DoraBashCFBypassInterceptor.INSTANCE;
                    c00073.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00073.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00073.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00073.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed15);
                    c00073.L$4 = null;
                    c00073.L$5 = null;
                    c00073.label = 5;
                    obj3 = Requests.get$default(app13, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, doraBashCFBypassInterceptor13, false, (ResponseParser) null, c00073, 3580, (Object) null);
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

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object appGet$default(DoraBash doraBash, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return doraBash.appGet(str, map, continuation);
    }

    private final void injectCookiesToApp(String url) {
        Cookie cookie;
        try {
            HttpUrl httpUrl = HttpUrl.Companion.parse(url);
            if (httpUrl == null) {
                return;
            }
            String savedCookies = DoraBashProvider.INSTANCE.getCfCookies();
            if (savedCookies.length() > 0) {
                List cookiesList = new ArrayList();
                Iterable $this$forEach$iv = StringsKt.split$default(savedCookies, new String[]{";"}, false, 0, 6, (Object) null);
                for (Object element$iv : $this$forEach$iv) {
                    String it = (String) element$iv;
                    String cookieStr = StringsKt.trim(it).toString();
                    if ((cookieStr.length() > 0) && (cookie = Cookie.Companion.parse(httpUrl, cookieStr)) != null) {
                        cookiesList.add(cookie);
                    }
                }
                if (!cookiesList.isEmpty()) {
                    MainActivityKt.getApp().getBaseClient().cookieJar().saveFromResponse(httpUrl, cookiesList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0143  */
    /* JADX WARN: Code duplicated, block: B:29:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0191  */
    /* JADX WARN: Code duplicated, block: B:33:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0191 -> B:31:0x01a6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMainPage(int r24, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.MainPageRequest r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r26) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.DoraBash.DoraBash.getMainPage(int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object toSearchResult(Element $this$toSearchResult, Continuation<? super SearchResponse> continuation) {
        C00161 c00161;
        String title;
        Object objAppGet$default;
        Element $this$toSearchResult2;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        C00161 c00162 = c00161;
        Object $result = c00162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00162.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                title = $this$toSearchResult.select("h3 a").attr("title");
                String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("h3 > a").attr("href"));
                c00162.L$0 = $this$toSearchResult;
                c00162.L$1 = title;
                c00162.L$2 = SpillingKt.nullOutSpilledVariable(href);
                c00162.label = 1;
                objAppGet$default = appGet$default(this, href, null, c00162, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$toSearchResult2 = $this$toSearchResult;
                break;
                break;
            case 1:
                String title2 = (String) c00162.L$1;
                $this$toSearchResult2 = (Element) c00162.L$0;
                ResultKt.throwOnFailure($result);
                title = title2;
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String sourceURL = ((NiceResponse) objAppGet$default).getDocument().select("div.anime-data h4 a").attr("href");
        DoraBash doraBash = this;
        Element elementSelectFirst = $this$toSearchResult2.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(doraBash, elementSelectFirst != null ? getImageUrl(elementSelectFirst) : null);
        return MainAPIKt.newMovieSearchResponse$default(this, APIHolder.INSTANCE.capitalize(title), sourceURL, TvType.Movie, false, new Function1() { // from class: com.DoraBash.DoraBash$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return DoraBash.toSearchResult$lambda$0(posterUrl, this, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, DoraBash this$0, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders(this$0.getCfHeaders());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x014e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0153  */
    /* JADX WARN: Code duplicated, block: B:29:0x0171  */
    /* JADX WARN: Code duplicated, block: B:32:0x017e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0183  */
    /* JADX WARN: Code duplicated, block: B:36:0x018a  */
    /* JADX WARN: Code duplicated, block: B:39:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:40:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:43:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:45:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:46:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:49:0x0264 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0265  */
    /* JADX WARN: Code duplicated, block: B:54:0x02be A[LOOP:0: B:52:0x02b8->B:54:0x02be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x0381 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0382  */
    /* JADX WARN: Code duplicated, block: B:60:0x0397  */
    /* JADX WARN: Code duplicated, block: B:62:0x0431 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x0432  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00091 c00091;
        DoraBash doraBash;
        Object objAppGet$default;
        String backgroundposter;
        Document doc;
        String title;
        Element elementSelectFirst;
        String imageUrl;
        String backgroundposter2;
        Element elementSelectFirst2;
        String string;
        String description;
        Element elementSelectFirst3;
        String imageUrl2;
        String poster;
        String rating;
        String year;
        String contentRating;
        String duration;
        String type;
        TvType tvType;
        TvType tvtag;
        String poster2;
        String description2;
        Object objNewMovieLoadResponse;
        String duration2;
        String poster3;
        TvType tvtag2;
        String url2;
        Document doc2;
        String backgroundposter3;
        String rating2;
        String year2;
        String contentRating2;
        Element elementSelectFirst4;
        String strAttr;
        String seasonId;
        String rating3;
        final DoraBash doraBash2;
        Object objAppGet$default2;
        String seasonId2;
        String year3;
        String backgroundposter4;
        String duration3;
        String contentRating3;
        String duration4;
        String backgroundposter5;
        String title2;
        String rating4;
        Document doc3;
        String strText;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        String poster4;
        String title3;
        Object objNewTvSeriesLoadResponse;
        C00091 c00092;
        String description3;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00093 = c00091;
        Object $result = c00093.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00093.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                injectCookiesToApp(url);
                c00093.L$0 = url;
                c00093.label = 1;
                doraBash = this;
                objAppGet$default = appGet$default(doraBash, url, null, c00093, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                backgroundposter = url;
                doc = ((NiceResponse) objAppGet$default).getDocument();
                title = StringsKt.trim(StringsKt.substringBeforeLast$default(doc.select("meta[property=og:title]").attr("content"), "-", (String) null, 2, (Object) null)).toString();
                DoraBash doraBash3 = doraBash;
                elementSelectFirst = doc.selectFirst("main div.absolute img");
                if (elementSelectFirst != null) {
                    imageUrl = doraBash.getImageUrl(elementSelectFirst);
                } else {
                    imageUrl = null;
                }
                backgroundposter2 = MainAPIKt.fixUrlNull(doraBash3, imageUrl);
                elementSelectFirst2 = doc.selectFirst("div.mb-6 > section > p:nth-child(1)");
                if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText).toString();
                }
                description = string;
                DoraBash doraBash4 = doraBash;
                elementSelectFirst3 = doc.selectFirst("div.relative img");
                if (elementSelectFirst3 != null) {
                    imageUrl2 = doraBash.getImageUrl(elementSelectFirst3);
                } else {
                    imageUrl2 = null;
                }
                poster = MainAPIKt.fixUrlNull(doraBash4, imageUrl2);
                if (poster == null) {
                    poster = StringsKt.trim(doc.select("meta[property=og:image]").attr("content")).toString();
                }
                rating = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(1)").text();
                year = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(4)").text();
                contentRating = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(7)").text();
                duration = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(8)").text();
                type = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(2)").text();
                if (StringsKt.contains(type, "Movie", true)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                tvtag = tvType;
                if (tvtag == TvType.TvSeries) {
                    poster2 = poster;
                    TvType tvType2 = TvType.Movie;
                    String strReplace$default = StringsKt.replace$default(backgroundposter, "series", "watch", false, 4, (Object) null);
                    description2 = description;
                    C00113 c00113 = new C00113(poster2, this, backgroundposter2, rating, year, duration, contentRating, description, null);
                    c00093.L$0 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                    c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                    c00093.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00093.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                    c00093.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                    c00093.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                    c00093.L$6 = SpillingKt.nullOutSpilledVariable(rating);
                    c00093.L$7 = SpillingKt.nullOutSpilledVariable(year);
                    c00093.L$8 = SpillingKt.nullOutSpilledVariable(contentRating);
                    c00093.L$9 = SpillingKt.nullOutSpilledVariable(duration);
                    c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                    c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00093.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, backgroundposter, tvType2, strReplace$default, c00113, c00093);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    duration2 = duration;
                    poster3 = poster2;
                    tvtag2 = tvtag;
                    url2 = backgroundposter;
                    doc2 = doc;
                    backgroundposter3 = backgroundposter2;
                    rating2 = rating;
                    year2 = year;
                    contentRating2 = contentRating;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst4 = doc.selectFirst("#seasonContent");
                if (elementSelectFirst4 != null) {
                    strAttr = elementSelectFirst4.attr("data-season");
                } else {
                    strAttr = null;
                }
                seasonId = strAttr;
                String poster5 = getMainUrl() + "/wp-admin/admin-ajax.php?action=get_episodes&anime_id=" + seasonId + "&page=1&order=desc";
                c00093.L$0 = backgroundposter;
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00093.L$2 = title;
                c00093.L$3 = backgroundposter2;
                c00093.L$4 = description;
                c00093.L$5 = poster;
                c00093.L$6 = rating;
                c00093.L$7 = year;
                c00093.L$8 = contentRating;
                c00093.L$9 = duration;
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00093.L$12 = SpillingKt.nullOutSpilledVariable(seasonId);
                c00093.label = 2;
                rating3 = poster;
                doraBash2 = this;
                objAppGet$default2 = appGet$default(doraBash2, poster5, null, c00093, 2, null);
                if (objAppGet$default2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                seasonId2 = seasonId;
                year3 = duration;
                backgroundposter4 = backgroundposter2;
                duration3 = rating;
                contentRating3 = year;
                duration4 = rating3;
                backgroundposter5 = title;
                title2 = description;
                rating4 = contentRating;
                doc3 = doc;
                NiceResponse this_$iv = (NiceResponse) objAppGet$default2;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                String backgroundposter6 = backgroundposter4;
                $this$map$iv = ((EpJson) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(EpJson.class))).getData().getEpisodes();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Iterable $this$map$iv2 = $this$map$iv;
                    final Episode ep = (Episode) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newEpisode(doraBash2, ep.getUrl(), new Function1() { // from class: com.DoraBash.DoraBash$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return DoraBash.load$lambda$0$0(ep, doraBash2, (com.lagradost.cloudstream3.Episode) obj);
                        }
                    }));
                    $this$map$iv = $this$map$iv2;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    duration3 = duration3;
                    contentRating3 = contentRating3;
                }
                List episodes = (List) destination$iv$iv;
                DoraBash doraBash5 = doraBash2;
                TvType tvType3 = TvType.Anime;
                String poster6 = duration4;
                poster4 = title2;
                C00102 c00102 = new C00102(poster6, this, backgroundposter6, duration3, contentRating3, year3, rating4, poster4, null);
                c00093.L$0 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00093.L$2 = SpillingKt.nullOutSpilledVariable(backgroundposter5);
                c00093.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter6);
                c00093.L$4 = SpillingKt.nullOutSpilledVariable(poster4);
                c00093.L$5 = SpillingKt.nullOutSpilledVariable(poster6);
                c00093.L$6 = SpillingKt.nullOutSpilledVariable(duration3);
                c00093.L$7 = SpillingKt.nullOutSpilledVariable(contentRating3);
                c00093.L$8 = SpillingKt.nullOutSpilledVariable(rating4);
                c00093.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00093.L$12 = SpillingKt.nullOutSpilledVariable(seasonId2);
                c00093.L$13 = SpillingKt.nullOutSpilledVariable(episodes);
                c00093.label = 3;
                title3 = backgroundposter5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(doraBash5, title3, backgroundposter, tvType3, episodes, c00102, c00093);
                c00092 = c00093;
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                description3 = poster4;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url3 = (String) c00093.L$0;
                ResultKt.throwOnFailure($result);
                backgroundposter = url3;
                objAppGet$default = $result;
                doraBash = this;
                doc = ((NiceResponse) objAppGet$default).getDocument();
                title = StringsKt.trim(StringsKt.substringBeforeLast$default(doc.select("meta[property=og:title]").attr("content"), "-", (String) null, 2, (Object) null)).toString();
                DoraBash doraBash6 = doraBash;
                elementSelectFirst = doc.selectFirst("main div.absolute img");
                if (elementSelectFirst != null) {
                    imageUrl = doraBash.getImageUrl(elementSelectFirst);
                } else {
                    imageUrl = null;
                }
                backgroundposter2 = MainAPIKt.fixUrlNull(doraBash6, imageUrl);
                elementSelectFirst2 = doc.selectFirst("div.mb-6 > section > p:nth-child(1)");
                if (elementSelectFirst2 != null) {
                    string = null;
                } else {
                    string = null;
                }
                description = string;
                DoraBash doraBash7 = doraBash;
                elementSelectFirst3 = doc.selectFirst("div.relative img");
                if (elementSelectFirst3 != null) {
                    imageUrl2 = doraBash.getImageUrl(elementSelectFirst3);
                } else {
                    imageUrl2 = null;
                }
                poster = MainAPIKt.fixUrlNull(doraBash7, imageUrl2);
                if (poster == null) {
                    poster = StringsKt.trim(doc.select("meta[property=og:image]").attr("content")).toString();
                }
                rating = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(1)").text();
                year = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(4)").text();
                contentRating = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(7)").text();
                duration = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(8)").text();
                type = doc.select("div.flex.flex-wrap.justify-center.lg\\:justify-start.gap-1.lg\\:gap-2.mb-4.text-sm.font-semibold span:nth-child(2)").text();
                if (StringsKt.contains(type, "Movie", true)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                tvtag = tvType;
                if (tvtag == TvType.TvSeries) {
                    poster2 = poster;
                    TvType tvType4 = TvType.Movie;
                    String strReplace$default2 = StringsKt.replace$default(backgroundposter, "series", "watch", false, 4, (Object) null);
                    description2 = description;
                    C00113 c00114 = new C00113(poster2, this, backgroundposter2, rating, year, duration, contentRating, description, null);
                    c00093.L$0 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                    c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                    c00093.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00093.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter2);
                    c00093.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                    c00093.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                    c00093.L$6 = SpillingKt.nullOutSpilledVariable(rating);
                    c00093.L$7 = SpillingKt.nullOutSpilledVariable(year);
                    c00093.L$8 = SpillingKt.nullOutSpilledVariable(contentRating);
                    c00093.L$9 = SpillingKt.nullOutSpilledVariable(duration);
                    c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                    c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00093.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, backgroundposter, tvType4, strReplace$default2, c00114, c00093);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    duration2 = duration;
                    poster3 = poster2;
                    tvtag2 = tvtag;
                    url2 = backgroundposter;
                    doc2 = doc;
                    backgroundposter3 = backgroundposter2;
                    rating2 = rating;
                    year2 = year;
                    contentRating2 = contentRating;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                elementSelectFirst4 = doc.selectFirst("#seasonContent");
                if (elementSelectFirst4 != null) {
                    strAttr = elementSelectFirst4.attr("data-season");
                } else {
                    strAttr = null;
                }
                seasonId = strAttr;
                String poster7 = getMainUrl() + "/wp-admin/admin-ajax.php?action=get_episodes&anime_id=" + seasonId + "&page=1&order=desc";
                c00093.L$0 = backgroundposter;
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00093.L$2 = title;
                c00093.L$3 = backgroundposter2;
                c00093.L$4 = description;
                c00093.L$5 = poster;
                c00093.L$6 = rating;
                c00093.L$7 = year;
                c00093.L$8 = contentRating;
                c00093.L$9 = duration;
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00093.L$12 = SpillingKt.nullOutSpilledVariable(seasonId);
                c00093.label = 2;
                rating3 = poster;
                doraBash2 = this;
                objAppGet$default2 = appGet$default(doraBash2, poster7, null, c00093, 2, null);
                if (objAppGet$default2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                seasonId2 = seasonId;
                year3 = duration;
                backgroundposter4 = backgroundposter2;
                duration3 = rating;
                contentRating3 = year;
                duration4 = rating3;
                backgroundposter5 = title;
                title2 = description;
                rating4 = contentRating;
                doc3 = doc;
                NiceResponse this_$iv2 = (NiceResponse) objAppGet$default2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                String backgroundposter7 = backgroundposter4;
                $this$map$iv = ((EpJson) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(EpJson.class))).getData().getEpisodes();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r20.hasNext()) {
                    Iterable $this$map$iv3 = $this$map$iv;
                    final Episode ep2 = (Episode) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newEpisode(doraBash2, ep2.getUrl(), new Function1() { // from class: com.DoraBash.DoraBash$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return DoraBash.load$lambda$0$0(ep2, doraBash2, (com.lagradost.cloudstream3.Episode) obj);
                        }
                    }));
                    $this$map$iv = $this$map$iv3;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    duration3 = duration3;
                    contentRating3 = contentRating3;
                }
                List episodes2 = (List) destination$iv$iv;
                DoraBash doraBash8 = doraBash2;
                TvType tvType5 = TvType.Anime;
                String poster8 = duration4;
                poster4 = title2;
                C00102 c00103 = new C00102(poster8, this, backgroundposter7, duration3, contentRating3, year3, rating4, poster4, null);
                c00093.L$0 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00093.L$2 = SpillingKt.nullOutSpilledVariable(backgroundposter5);
                c00093.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter7);
                c00093.L$4 = SpillingKt.nullOutSpilledVariable(poster4);
                c00093.L$5 = SpillingKt.nullOutSpilledVariable(poster8);
                c00093.L$6 = SpillingKt.nullOutSpilledVariable(duration3);
                c00093.L$7 = SpillingKt.nullOutSpilledVariable(contentRating3);
                c00093.L$8 = SpillingKt.nullOutSpilledVariable(rating4);
                c00093.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00093.L$12 = SpillingKt.nullOutSpilledVariable(seasonId2);
                c00093.L$13 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00093.label = 3;
                title3 = backgroundposter5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(doraBash8, title3, backgroundposter, tvType5, episodes2, c00103, c00093);
                c00092 = c00093;
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                description3 = poster4;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                String seasonId3 = (String) c00093.L$12;
                TvType tvtag3 = (TvType) c00093.L$11;
                String type2 = (String) c00093.L$10;
                String duration5 = (String) c00093.L$9;
                String contentRating4 = (String) c00093.L$8;
                String year4 = (String) c00093.L$7;
                String rating5 = (String) c00093.L$6;
                duration4 = (String) c00093.L$5;
                title2 = (String) c00093.L$4;
                String backgroundposter8 = (String) c00093.L$3;
                backgroundposter5 = (String) c00093.L$2;
                doc3 = (Document) c00093.L$1;
                seasonId2 = seasonId3;
                String url4 = (String) c00093.L$0;
                ResultKt.throwOnFailure($result);
                year3 = duration5;
                duration3 = rating5;
                rating4 = contentRating4;
                contentRating3 = year4;
                tvtag = tvtag3;
                type = type2;
                objAppGet$default2 = $result;
                backgroundposter4 = backgroundposter8;
                backgroundposter = url4;
                doraBash2 = this;
                NiceResponse this_$iv3 = (NiceResponse) objAppGet$default2;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                String backgroundposter9 = backgroundposter4;
                $this$map$iv = ((EpJson) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(EpJson.class))).getData().getEpisodes();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r20.hasNext()) {
                    Iterable $this$map$iv4 = $this$map$iv;
                    final Episode ep3 = (Episode) item$iv$iv;
                    destination$iv$iv.add(MainAPIKt.newEpisode(doraBash2, ep3.getUrl(), new Function1() { // from class: com.DoraBash.DoraBash$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return DoraBash.load$lambda$0$0(ep3, doraBash2, (com.lagradost.cloudstream3.Episode) obj);
                        }
                    }));
                    $this$map$iv = $this$map$iv4;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    duration3 = duration3;
                    contentRating3 = contentRating3;
                }
                List episodes3 = (List) destination$iv$iv;
                DoraBash doraBash9 = doraBash2;
                TvType tvType6 = TvType.Anime;
                String poster9 = duration4;
                poster4 = title2;
                C00102 c00104 = new C00102(poster9, this, backgroundposter9, duration3, contentRating3, year3, rating4, poster4, null);
                c00093.L$0 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                c00093.L$1 = SpillingKt.nullOutSpilledVariable(doc3);
                c00093.L$2 = SpillingKt.nullOutSpilledVariable(backgroundposter5);
                c00093.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter9);
                c00093.L$4 = SpillingKt.nullOutSpilledVariable(poster4);
                c00093.L$5 = SpillingKt.nullOutSpilledVariable(poster9);
                c00093.L$6 = SpillingKt.nullOutSpilledVariable(duration3);
                c00093.L$7 = SpillingKt.nullOutSpilledVariable(contentRating3);
                c00093.L$8 = SpillingKt.nullOutSpilledVariable(rating4);
                c00093.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00093.L$10 = SpillingKt.nullOutSpilledVariable(type);
                c00093.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00093.L$12 = SpillingKt.nullOutSpilledVariable(seasonId2);
                c00093.L$13 = SpillingKt.nullOutSpilledVariable(episodes3);
                c00093.label = 3;
                title3 = backgroundposter5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(doraBash9, title3, backgroundposter, tvType6, episodes3, c00104, c00093);
                c00092 = c00093;
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                description3 = poster4;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                description3 = (String) c00093.L$4;
                String title4 = (String) c00093.L$2;
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                c00092 = c00093;
                title3 = title4;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                tvtag2 = (TvType) c00093.L$11;
                duration2 = (String) c00093.L$9;
                contentRating2 = (String) c00093.L$8;
                year2 = (String) c00093.L$7;
                rating2 = (String) c00093.L$6;
                poster3 = (String) c00093.L$5;
                description2 = (String) c00093.L$4;
                backgroundposter3 = (String) c00093.L$3;
                doc2 = (Document) c00093.L$1;
                url2 = (String) c00093.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(Episode $ep, DoraBash this$0, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        String meta_number = $ep.getMeta_number();
        $this$newEpisode.setEpisode(meta_number != null ? StringsKt.toIntOrNull(meta_number) : null);
        $this$newEpisode.setName($ep.getNumber());
        $this$newEpisode.setPosterUrl(MainAPIKt.fixUrlNull(this$0, $ep.getThumbnail()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$load$2 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash$load$2", f = "DoraBash.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00102 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $contentRating;
        final /* synthetic */ String $description;
        final /* synthetic */ String $duration;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ String $year;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraBash this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(String str, DoraBash doraBash, String str2, String str3, String str4, String str5, String str6, String str7, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.this$0 = doraBash;
            this.$backgroundposter = str2;
            this.$rating = str3;
            this.$year = str4;
            this.$duration = str5;
            this.$contentRating = str6;
            this.$description = str7;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = new C00102(this.$poster, this.this$0, this.$backgroundposter, this.$rating, this.$year, this.$duration, this.$contentRating, this.$description, continuation);
            c00102.L$0 = obj;
            return c00102;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setPosterHeaders(this.this$0.getCfHeaders());
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$backgroundposter);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(this.$year));
                    $this$newTvSeriesLoadResponse.setDuration(StringsKt.toIntOrNull(this.$duration));
                    $this$newTvSeriesLoadResponse.setContentRating(this.$contentRating);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$load$3 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash$load$3", f = "DoraBash.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00113 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $contentRating;
        final /* synthetic */ String $description;
        final /* synthetic */ String $duration;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ String $year;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraBash this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00113(String str, DoraBash doraBash, String str2, String str3, String str4, String str5, String str6, String str7, Continuation<? super C00113> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.this$0 = doraBash;
            this.$backgroundposter = str2;
            this.$rating = str3;
            this.$year = str4;
            this.$duration = str5;
            this.$contentRating = str6;
            this.$description = str7;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00113 = new C00113(this.$poster, this.this$0, this.$backgroundposter, this.$rating, this.$year, this.$duration, this.$contentRating, this.$description, continuation);
            c00113.L$0 = obj;
            return c00113;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPosterHeaders(this.this$0.getCfHeaders());
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(this.$backgroundposter);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newMovieLoadResponse.setYear(StringsKt.toIntOrNull(this.$year));
                    $this$newMovieLoadResponse.setDuration(StringsKt.toIntOrNull(this.$duration));
                    $this$newMovieLoadResponse.setContentRating(this.$contentRating);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00141 c00141;
        boolean isCasting2;
        Object objAppGet$default;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String data2;
        C00152 c00152;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        C00141 c00142 = c00141;
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00142.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00142.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00142.L$1 = function1;
                c00142.L$2 = function2;
                isCasting2 = isCasting;
                c00142.Z$0 = isCasting2;
                c00142.label = 1;
                objAppGet$default = appGet$default(this, data, null, c00142, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function1;
                function4 = function2;
                data2 = data;
                Document document = ((NiceResponse) objAppGet$default).getDocument();
                c00152 = new C00152(document, this, function3, function4, null);
                c00142.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00142.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00142.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00142.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00142.Z$0 = isCasting2;
                c00142.label = 2;
                if (CoroutineScopeKt.coroutineScope(c00152, c00142) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting3 = c00142.Z$0;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00142.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00142.L$1;
                String data3 = (String) c00142.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting3;
                function3 = function6;
                data2 = data3;
                function4 = function5;
                objAppGet$default = $result;
                Document document2 = ((NiceResponse) objAppGet$default).getDocument();
                c00152 = new C00152(document2, this, function3, function4, null);
                c00142.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00142.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00142.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00142.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00142.Z$0 = isCasting2;
                c00142.label = 2;
                if (CoroutineScopeKt.coroutineScope(c00152, c00142) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean z = c00142.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.DoraBash.DoraBash$loadLinks$2 */
    /* JADX INFO: compiled from: DoraBash.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.DoraBash.DoraBash$loadLinks$2", f = "DoraBash.kt", i = {0}, l = {306}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {-1}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nDoraBash.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBash$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,342:1\n1739#2:343\n1814#2,3:344\n*S KotlinDebug\n*F\n+ 1 DoraBash.kt\ncom/DoraBash/DoraBash$loadLinks$2\n*L\n280#1:343\n280#1:344,3\n*E\n"})
    static final class C00152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Document $document;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraBash this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00152(Document document, DoraBash doraBash, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00152> continuation) {
            super(2, continuation);
            this.$document = document;
            this.this$0 = doraBash;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00152 = new C00152(this.$document, this.this$0, this.$subtitleCallback, this.$callback, continuation);
            c00152.L$0 = obj;
            return c00152;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$map$iv = this.$document.select("div.player-selection");
                    DoraBash doraBash = this.this$0;
                    Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element container = (Element) item$iv$iv;
                        Collection destination$iv$iv2 = destination$iv$iv;
                        destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DoraBash$loadLinks$2$1$1(container, doraBash, function1, function2, null), 3, (Object) null));
                        destination$iv$iv = destination$iv$iv2;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 1;
                    Object objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objAwaitAll;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ Object loadCustomExtractor$default(DoraBash doraBash, String str, String str2, String str3, Function1 function1, Function1 function2, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        return doraBash.loadCustomExtractor(str, str2, str3, function1, function2, num, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object loadCustomExtractor(@Nullable final String name, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull Continuation<? super Unit> continuation) {
        C00121 c00121;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1 function3 = new Function1() { // from class: com.DoraBash.DoraBash$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return DoraBash.loadCustomExtractor$lambda$0(function2, name, quality, (ExtractorLink) obj);
                    }
                };
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(name);
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00121.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00121.L$5 = SpillingKt.nullOutSpilledVariable(quality);
                c00121.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00121) == coroutine_suspended) {
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

    static final Unit loadCustomExtractor$lambda$0(Function1 $callback, String $name, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new DoraBash$loadCustomExtractor$2$1($callback, $name, link, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
