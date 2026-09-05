package com.idlix;

import com.lagradost.cloudstream3.Actor;
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
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IdlixProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IdlixProvider/classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)J \u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010)JF\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020604H\u0096@¢\u0006\u0002\u00109R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/idlix/IdlixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quickSearch", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "IdlixProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIdlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IdlixProvider.kt\ncom/idlix/IdlixProvider\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,450:1\n73#2,5:451\n73#2,5:461\n73#2,5:480\n73#2,5:503\n73#2,5:525\n73#2,5:552\n73#2,5:557\n73#2,5:562\n1739#3:456\n1814#3,2:457\n1816#3:460\n1795#3,10:466\n2068#3:476\n2069#3:478\n1805#3:479\n1795#3,10:485\n2068#3:495\n2069#3:497\n1805#3:498\n1739#3:499\n1814#3,3:500\n1795#3,10:508\n2068#3:518\n2069#3:520\n1805#3:521\n2068#3,2:522\n2068#3:524\n2068#3,2:530\n2069#3:532\n2068#3,2:567\n1#4:459\n1#4:477\n1#4:496\n1#4:519\n1#4:534\n63#5:533\n64#5,15:535\n50#6:550\n43#6:551\n*S KotlinDebug\n*F\n+ 1 IdlixProvider.kt\ncom/idlix/IdlixProvider\n*L\n72#1:451,5\n102#1:461,5\n139#1:480,5\n173#1:503,5\n234#1:525,5\n322#1:552,5\n346#1:557,5\n357#1:562,5\n73#1:456\n73#1:457,2\n73#1:460\n104#1:466,10\n104#1:476\n104#1:478\n104#1:479\n150#1:485,10\n150#1:495\n150#1:497\n150#1:498\n152#1:499\n152#1:500,3\n173#1:508,10\n173#1:518\n173#1:520\n173#1:521\n209#1:522,2\n227#1:524\n239#1:530,2\n227#1:532\n367#1:567,2\n104#1:477\n150#1:496\n173#1:519\n301#1:534\n301#1:533\n301#1:535,15\n301#1:550\n301#1:551\n*E\n"})
public final class IdlixProvider extends MainAPI {

    @NotNull
    private String mainUrl = MainAPIKt.base64Decode("aHR0cHM6Ly96Mi5pZGxpeGt1LmNvbQ==");

    @NotNull
    private String name = "Idlix";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "id";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/api/movies?page=%d&limit=36&sort=createdAt", "Movie Terbaru"), TuplesKt.to(getMainUrl() + "/api/series?page=%d&limit=36&sort=createdAt", "TV Series Terbaru"), TuplesKt.to(getMainUrl() + "/api/browse?page=%d&limit=36&sort=latest&network=prime-video", "Amazon Prime"), TuplesKt.to(getMainUrl() + "/api/browse?page=%d&limit=36&sort=latest&network=apple-tv-plus", "Apple TV+"), TuplesKt.to(getMainUrl() + "/api/browse?page=%d&limit=36&sort=latest&network=disney-plus", "Disney+"), TuplesKt.to(getMainUrl() + "/api/browse?page=%d&limit=36&sort=latest&network=hbo", "HBO"), TuplesKt.to(getMainUrl() + "/api/browse?page=%d&limit=36&sort=latest&network=netflix", "Netflix")});

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$getMainPage$1 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider", f = "IdlixProvider.kt", i = {0, 0, 0}, l = {72}, m = "getMainPage", n = {"request", "url", "page"}, nl = {451}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return IdlixProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$load$1 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider", f = "IdlixProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {137, 172, 233, 258, 273}, m = "load", n = {"url", "url", "response", "data", "title", "poster", "backdrop", "year", "tags", "logourl", "actors", "trailer", "rating", "relatedUrl", "weburl", "url", "response", "data", "title", "poster", "backdrop", "year", "tags", "logourl", "actors", "trailer", "rating", "relatedUrl", "weburl", "recommendations", "episodes", "$this$forEach$iv", "element$iv", "season", "seasonUrl", "seasonNum", "url", "response", "data", "title", "poster", "backdrop", "year", "tags", "logourl", "actors", "trailer", "rating", "relatedUrl", "weburl", "recommendations", "episodes", "url", "response", "data", "title", "poster", "backdrop", "year", "tags", "logourl", "actors", "trailer", "rating", "relatedUrl", "weburl", "recommendations"}, nl = {139, 173, 234, 273, 206}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
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
            return IdlixProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$loadLinks$1 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider", f = "IdlixProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {316, 333, 341, 352, 363, 370}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parsed", "contentId", "contentType", "headers", "isCasting", "data", "subtitleCallback", "callback", "parsed", "contentId", "contentType", "headers", "playResponse", "cookies", "playInfo", "isCasting", "waitTime", "totalWait", "elapsed", "data", "subtitleCallback", "callback", "parsed", "contentId", "contentType", "headers", "playResponse", "cookies", "playInfo", "claimJson", "isCasting", "waitTime", "totalWait", "elapsed", "data", "subtitleCallback", "callback", "parsed", "contentId", "contentType", "headers", "playResponse", "cookies", "playInfo", "claimJson", "claimApi", "redeemJson", "isCasting", "waitTime", "totalWait", "elapsed", "data", "subtitleCallback", "callback", "parsed", "contentId", "contentType", "headers", "playResponse", "cookies", "playInfo", "claimJson", "claimApi", "redeemJson", "iframeResponse", "streamUrl", "isCasting", "waitTime", "totalWait", "elapsed", "data", "subtitleCallback", "callback", "parsed", "contentId", "contentType", "headers", "playResponse", "cookies", "playInfo", "claimJson", "claimApi", "redeemJson", "iframeResponse", "isCasting", "waitTime", "totalWait", "elapsed"}, nl = {321, 334, 346, 357, 367, 379}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "J$0", "J$1", "J$2"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        long J$0;
        long J$1;
        long J$2;
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

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdlixProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$quickSearch$1 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider", f = "IdlixProvider.kt", i = {0}, l = {98}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdlixProvider.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$search$1 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider", f = "IdlixProvider.kt", i = {0, 0, 0}, l = {102}, m = "search", n = {"query", "url", "page"}, nl = {451}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return IdlixProvider.this.search(null, 0, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        String url;
        Boolean bool;
        MainPageRequest request2;
        Object safe;
        MovieSearchResponse movieSearchResponseNewTvSeriesSearchResponse$default;
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
                if (StringsKt.contains$default(request.getData(), "%d", false, 2, (Object) null)) {
                    url = String.format(request.getData(), Arrays.copyOf(new Object[]{Boxing.boxInt(page)}, 1));
                    Intrinsics.checkNotNullExpressionValue(url, "format(...)");
                } else {
                    url = request.getData();
                }
                Requests app = MainActivityKt.getApp();
                c00002.L$0 = request;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.I$0 = page;
                c00002.label = 1;
                bool = null;
                Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c00002, 3838, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                $result = obj;
                break;
                break;
            case 1:
                int i = c00002.I$0;
                request2 = (MainPageRequest) c00002.L$0;
                ResultKt.throwOnFailure($result);
                bool = null;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ApiResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = bool;
        }
        ApiResponse res = (ApiResponse) safe;
        if (res == null) {
            return MainAPIKt.newHomePageResponse$default(request2.getName(), CollectionsKt.emptyList(), bool, 4, bool);
        }
        Iterable $this$map$iv = res.getData();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final ApiItem item = (ApiItem) item$iv$iv;
            String title = item.getTitle();
            if (title == null) {
                title = "UnKnown";
            }
            String title2 = title;
            String it = item.getPosterPath();
            final String poster = it != null ? "https://image.tmdb.org/t/p/w342" + it : null;
            if (Intrinsics.areEqual(item.getContentType(), "movie")) {
                String movieurl = getMainUrl() + "/api/movies/" + item.getSlug();
                movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title2, movieurl, TvType.Movie, false, new Function1() { // from class: com.idlix.IdlixProvider$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj2) {
                        return IdlixProvider.getMainPage$lambda$0$1(poster, item, (MovieSearchResponse) obj2);
                    }
                }, 8, (Object) null);
            } else {
                String seriesurl = getMainUrl() + "/api/series/" + item.getSlug();
                movieSearchResponseNewTvSeriesSearchResponse$default = MainAPIKt.newTvSeriesSearchResponse$default(this, title2, seriesurl, TvType.TvSeries, false, new Function1() { // from class: com.idlix.IdlixProvider$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj2) {
                        return IdlixProvider.getMainPage$lambda$0$2(poster, item, (TvSeriesSearchResponse) obj2);
                    }
                }, 8, (Object) null);
            }
            destination$iv$iv.add((SearchResponse) movieSearchResponseNewTvSeriesSearchResponse$default);
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$1(String $poster, ApiItem $item, MovieSearchResponse $this$newMovieSearchResponse) {
        String strSubstringBefore$default;
        $this$newMovieSearchResponse.setPosterUrl($poster);
        String releaseDate = $item.getReleaseDate();
        Integer intOrNull = null;
        if (releaseDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        $this$newMovieSearchResponse.setYear(intOrNull);
        $this$newMovieSearchResponse.setQuality(IdlixProviderKt.getSearchQuality($item.getQuality()));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($item.getVoteAverage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$2(String $poster, ApiItem $item, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String strSubstringBefore$default;
        $this$newTvSeriesSearchResponse.setPosterUrl($poster);
        String releaseDate = $item.getReleaseDate();
        Integer intOrNull = null;
        if (releaseDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        $this$newTvSeriesSearchResponse.setYear(intOrNull);
        $this$newTvSeriesSearchResponse.setScore(Score.Companion.from10($item.getVoteAverage()));
        $this$newTvSeriesSearchResponse.setQuality(IdlixProviderKt.getSearchQuality($item.getQuality()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        Object objSearch;
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
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.label = 1;
                objSearch = search(query, 1, c00061);
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

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v6 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:488)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r38, int r39, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.SearchResponseList> r40) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.idlix.IdlixProvider.search(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1(String $poster, Integer $year, SearchApiResult $item, double $rating, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        $this$newMovieSearchResponse.setYear($year);
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString($item.getQuality()));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10(Double.valueOf($rating)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$2(String $poster, Integer $year, double $rating, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($poster);
        $this$newTvSeriesSearchResponse.setYear($year);
        $this$newTvSeriesSearchResponse.setScore(Score.Companion.from10(Double.valueOf($rating)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:172:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:174:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:176:0x07d1  */
    /* JADX WARN: Code duplicated, block: B:182:0x07e9 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:184:0x07ef  */
    /* JADX WARN: Code duplicated, block: B:196:0x089a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:197:0x089b  */
    /* JADX WARN: Code duplicated, block: B:215:0x0900 A[Catch: Exception -> 0x0926, TRY_LEAVE, TryCatch #14 {Exception -> 0x0926, blocks: (B:213:0x08fc, B:215:0x0900, B:212:0x08f7), top: B:296:0x08fc }] */
    /* JADX WARN: Code duplicated, block: B:217:0x0905  */
    /* JADX WARN: Code duplicated, block: B:236:0x0a64  */
    /* JADX WARN: Code duplicated, block: B:247:0x0adb  */
    /* JADX WARN: Code duplicated, block: B:249:0x0b15  */
    /* JADX WARN: Code duplicated, block: B:250:0x0b22  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:197:0x089b -> B:275:0x08cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:233:0x0a45 -> B:235:0x0a62). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r52, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r53) {
        /*
            Method dump skipped, instruction units count: 3316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.idlix.IdlixProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$1(String $poster, ApiItem $item, MovieSearchResponse $this$newMovieSearchResponse) {
        String strSubstringBefore$default;
        $this$newMovieSearchResponse.setPosterUrl($poster);
        String releaseDate = $item.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = $item.getFirstAirDate();
        }
        Integer intOrNull = null;
        if (releaseDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        $this$newMovieSearchResponse.setYear(intOrNull);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$2(String $poster, ApiItem $item, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String strSubstringBefore$default;
        $this$newTvSeriesSearchResponse.setPosterUrl($poster);
        String releaseDate = $item.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = $item.getFirstAirDate();
        }
        Integer intOrNull = null;
        if (releaseDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        $this$newTvSeriesSearchResponse.setYear(intOrNull);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$0(Episode $ep, DetailResponse $data, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        $this$newEpisode.setName($ep.getName());
        $this$newEpisode.setSeason($data.getFirstSeason().getSeasonNumber());
        $this$newEpisode.setEpisode($ep.getEpisodeNumber());
        $this$newEpisode.setDescription($ep.getOverview());
        $this$newEpisode.setRunTime($ep.getRuntime());
        Score.Companion companion = Score.Companion;
        Object voteAverage = $ep.getVoteAverage();
        $this$newEpisode.setScore(companion.from10(voteAverage != null ? voteAverage.toString() : null));
        MainAPIKt.addDate$default($this$newEpisode, $ep.getAirDate(), (String) null, 2, (Object) null);
        String it = $ep.getStillPath();
        $this$newEpisode.setPosterUrl(it != null ? "https://image.tmdb.org/t/p/w300" + it : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0$0(Episode $ep, int $seasonNum, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        $this$newEpisode.setName($ep.getName());
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode($ep.getEpisodeNumber());
        $this$newEpisode.setDescription($ep.getOverview());
        $this$newEpisode.setRunTime($ep.getRuntime());
        Score.Companion companion = Score.Companion;
        Object voteAverage = $ep.getVoteAverage();
        $this$newEpisode.setScore(companion.from10(voteAverage != null ? voteAverage.toString() : null));
        MainAPIKt.addDate$default($this$newEpisode, $ep.getAirDate(), (String) null, 2, (Object) null);
        String it = $ep.getStillPath();
        $this$newEpisode.setPosterUrl(it != null ? "https://image.tmdb.org/t/p/w300" + it : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$load$4 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider$load$4", f = "IdlixProvider.kt", i = {0}, l = {267}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {268}, s = {"L$0"}, v = 2)
    static final class C00024 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Actor> $actors;
        final /* synthetic */ String $backdrop;
        final /* synthetic */ DetailResponse $data;
        final /* synthetic */ String $logourl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Object $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00024(String str, String str2, String str3, Integer num, DetailResponse detailResponse, List<String> list, Object obj, List<Actor> list2, String str4, List<? extends SearchResponse> list3, Continuation<? super C00024> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backdrop = str2;
            this.$logourl = str3;
            this.$year = num;
            this.$data = detailResponse;
            this.$tags = list;
            this.$rating = obj;
            this.$actors = list2;
            this.$trailer = str4;
            this.$recommendations = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00024 = new C00024(this.$poster, this.$backdrop, this.$logourl, this.$year, this.$data, this.$tags, this.$rating, this.$actors, this.$trailer, this.$recommendations, continuation);
            c00024.L$0 = obj;
            return c00024;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$backdrop);
                    loadResponse.setLogoUrl(this.$logourl);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$data.getOverview());
                    loadResponse.setTags(this.$tags);
                    Score.Companion companion = Score.Companion;
                    Object obj = this.$rating;
                    loadResponse.setScore(companion.from10(obj != null ? obj.toString() : null));
                    LoadResponse.Companion.addActorsOnly(loadResponse, this.$actors);
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
            LoadResponse.Companion.addTMDbId(loadResponse, this.$data.getTmdbId());
            LoadResponse.Companion.addImdbId(loadResponse, this.$data.getImdbId());
            loadResponse.setRecommendations(this.$recommendations);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$load$5 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider$load$5", f = "IdlixProvider.kt", i = {0}, l = {285}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {286}, s = {"L$0"}, v = 2)
    static final class C00035 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Actor> $actors;
        final /* synthetic */ String $backdrop;
        final /* synthetic */ DetailResponse $data;
        final /* synthetic */ String $logourl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Object $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00035(String str, String str2, String str3, Integer num, DetailResponse detailResponse, List<String> list, Object obj, List<Actor> list2, String str4, List<? extends SearchResponse> list3, Continuation<? super C00035> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backdrop = str2;
            this.$logourl = str3;
            this.$year = num;
            this.$data = detailResponse;
            this.$tags = list;
            this.$rating = obj;
            this.$actors = list2;
            this.$trailer = str4;
            this.$recommendations = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00035 = new C00035(this.$poster, this.$backdrop, this.$logourl, this.$year, this.$data, this.$tags, this.$rating, this.$actors, this.$trailer, this.$recommendations, continuation);
            c00035.L$0 = obj;
            return c00035;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$backdrop);
                    loadResponse.setLogoUrl(this.$logourl);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$data.getOverview());
                    loadResponse.setTags(this.$tags);
                    Score.Companion companion = Score.Companion;
                    Object obj = this.$rating;
                    loadResponse.setScore(companion.from10(obj != null ? obj.toString() : null));
                    LoadResponse.Companion.addActorsOnly(loadResponse, this.$actors);
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
            LoadResponse.Companion.addTMDbId(loadResponse, this.$data.getTmdbId());
            LoadResponse.Companion.addImdbId(loadResponse, this.$data.getImdbId());
            loadResponse.setRecommendations(this.$recommendations);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0487  */
    /* JADX WARN: Code duplicated, block: B:78:0x0502 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x0503  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Path cross not found for [B:174:0x0303, B:49:0x0318], limit reached: 165 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0503 -> B:80:0x051d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r56, boolean r57, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r58, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r59, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r60) {
        /*
            Method dump skipped, instruction units count: 2226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.idlix.IdlixProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.idlix.IdlixProvider$loadLinks$4 */
    /* JADX INFO: compiled from: IdlixProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "subtitle", "Lcom/idlix/Subtitle;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.idlix.IdlixProvider$loadLinks$4", f = "IdlixProvider.kt", i = {0}, l = {372}, m = "invokeSuspend", n = {"subtitle"}, nl = {371}, s = {"L$0"}, v = 2)
    static final class C00054 extends SuspendLambda implements Function2<Subtitle, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00054(Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(this.$subtitleCallback, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(Subtitle subtitle, Continuation<? super Unit> continuation) {
            return create(subtitle, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objNewSubtitleFile$default;
            Function1<SubtitleFile, Unit> function1;
            Subtitle subtitle = (Subtitle) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Function1<SubtitleFile, Unit> function2 = this.$subtitleCallback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(subtitle);
                    this.L$1 = function2;
                    this.label = 1;
                    objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(subtitle.getLabel(), subtitle.getPath(), (Function2) null, (Continuation) this, 4, (Object) null);
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
}
