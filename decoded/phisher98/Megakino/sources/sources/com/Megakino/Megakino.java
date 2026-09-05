package com.Megakino;

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
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Megakino.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Megakino/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\f\u0010)\u001a\u00020'*\u00020(H\u0002J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010+\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010,JF\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020604H\u0096@¢\u0006\u0002\u00109R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006;"}, d2 = {"Lcom/Megakino/Megakino;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "toSearchResult1", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Megakino"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMegakino.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Megakino.kt\ncom/Megakino/Megakino\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1795#2,10:159\n2068#2:169\n2069#2:171\n1805#2:172\n1739#2:173\n1814#2,3:174\n1739#2:177\n1814#2,2:178\n1816#2:181\n1739#2:182\n1814#2,3:183\n1739#2:186\n1814#2,3:187\n1#3:170\n1#3:180\n*S KotlinDebug\n*F\n+ 1 Megakino.kt\ncom/Megakino/Megakino\n*L\n52#1:159,10\n52#1:169\n52#1:171\n52#1:172\n92#1:173\n92#1:174,3\n107#1:177\n107#1:178,2\n107#1:181\n111#1:182\n111#1:183,3\n117#1:186\n117#1:187,3\n52#1:170\n*E\n"})
public final class Megakino extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TOKEN_URL = "https://megakino5.org/index.php?yg=token";

    @NotNull
    private String mainUrl = "https://megakino5.org";

    @NotNull
    private String name = "Megakino";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "de";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.TvSeries, TvType.Documentary});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Trending"), TuplesKt.to("kinofilme", "Movies"), TuplesKt.to("serials", "Serials"), TuplesKt.to("multfilm", "Multfilm"), TuplesKt.to("documentary", "Documentary")});

    /* JADX INFO: renamed from: com.Megakino.Megakino$getMainPage$1 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino", f = "Megakino.kt", i = {0, 0, 1, 1, 1}, l = {44, 46}, m = "getMainPage", n = {"request", "page", "request", "cookie", "page"}, nl = {46, 50}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Megakino.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Megakino.Megakino$load$1 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino", f = "Megakino.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {99, 101, 128, 136}, m = "load", n = {"url", "url", "cookie", "url", "cookie", "document", "title", "poster", "year", "hreflist", "description", "trailer", "genresText", "genresList", "typetag", "type", "episodes", "url", "cookie", "document", "title", "poster", "year", "hreflist", "description", "trailer", "genresText", "genresList", "typetag", "type"}, nl = {101, 103, 136, 114}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Megakino.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Megakino.Megakino$loadLinks$1 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino", f = "Megakino.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {149, 154}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "isCasting"}, nl = {154, 155}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return Megakino.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Megakino.Megakino$search$1 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino", f = "Megakino.kt", i = {0, 1, 1, 1}, l = {87, 89}, m = "search", n = {"query", "query", "cookie", "data"}, nl = {88, 91}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Megakino.this.search(null, (Continuation) this);
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

    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/Megakino/Megakino$Companion;", "", "<init>", "()V", "TOKEN_URL", "", "getTokenCookie", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Megakino"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMegakino.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Megakino.kt\ncom/Megakino/Megakino$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n296#2,2:159\n*S KotlinDebug\n*F\n+ 1 Megakino.kt\ncom/Megakino/Megakino$Companion\n*L\n25#1:159,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        @Nullable
        public final Object getTokenCookie(@NotNull Continuation<? super String> continuation) {
            Megakino$Companion$getTokenCookie$1 megakino$Companion$getTokenCookie$1;
            boolean z;
            Object element$iv;
            Pair pair;
            String str;
            Pair it;
            if (continuation instanceof Megakino$Companion$getTokenCookie$1) {
                megakino$Companion$getTokenCookie$1 = (Megakino$Companion$getTokenCookie$1) continuation;
                if ((megakino$Companion$getTokenCookie$1.label & Integer.MIN_VALUE) != 0) {
                    megakino$Companion$getTokenCookie$1.label -= Integer.MIN_VALUE;
                } else {
                    megakino$Companion$getTokenCookie$1 = new Megakino$Companion$getTokenCookie$1(this, continuation);
                }
            } else {
                megakino$Companion$getTokenCookie$1 = new Megakino$Companion$getTokenCookie$1(this, continuation);
            }
            Object $result = megakino$Companion$getTokenCookie$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (megakino$Companion$getTokenCookie$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    megakino$Companion$getTokenCookie$1.label = 1;
                    Megakino$Companion$getTokenCookie$1 megakino$Companion$getTokenCookie$2 = megakino$Companion$getTokenCookie$1;
                    z = true;
                    $result = Requests.get$default(app, Megakino.TOKEN_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, megakino$Companion$getTokenCookie$2, 4094, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    z = true;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable $this$firstOrNull$iv = ((NiceResponse) $result).getHeaders();
            Iterator it2 = $this$firstOrNull$iv.iterator();
            do {
                if (it2.hasNext()) {
                    element$iv = it2.next();
                    it = (Pair) element$iv;
                } else {
                    element$iv = null;
                }
                pair = (Pair) element$iv;
                if (pair == null && (str = (String) pair.getSecond()) != null) {
                    return StringsKt.substringBefore$default(str, ";", (String) null, 2, (Object) null);
                }
            } while (!StringsKt.equals((String) it.getFirst(), "set-cookie", z));
            pair = (Pair) element$iv;
            return pair == null ? null : null;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0072  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:28:0x011b  */
    /* JADX WARN: Code duplicated, block: B:30:0x012d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        MainPageRequest request2;
        Object obj;
        int page2;
        String cookie;
        MainPageRequest request3;
        boolean z;
        MainPageRequest request4;
        Collection destination$iv$iv;
        SearchResponse searchResult;
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
                Companion companion = INSTANCE;
                request2 = request;
                c00011.L$0 = request2;
                c00011.I$0 = page;
                c00011.label = 1;
                Object tokenCookie = companion.getTokenCookie(c00011);
                if (tokenCookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = tokenCookie;
                page2 = page;
                cookie = (String) obj;
                if (cookie == null) {
                    cookie = "";
                }
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request2.getData() + "/page/" + page2;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", cookie));
                c00011.L$0 = request2;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(cookie);
                c00011.I$0 = page2;
                c00011.label = 2;
                request3 = request2;
                z = true;
                $result = Requests.get$default(app, str, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request4 = request3;
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv = document.select("#dle-content > a");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element it = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request4.getName(), home, false), Boxing.boxBoolean(z));
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                cookie = (String) obj;
                if (cookie == null) {
                    cookie = "";
                }
                Requests app2 = MainActivityKt.getApp();
                String str2 = getMainUrl() + '/' + request2.getData() + "/page/" + page2;
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("Cookie", cookie));
                c00011.L$0 = request2;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(cookie);
                c00011.I$0 = page2;
                c00011.label = 2;
                request3 = request2;
                z = true;
                $result = Requests.get$default(app2, str2, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request4 = request3;
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv2 = document2.select("#dle-content > a");
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    Element it2 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it2);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request4.getName(), home2, false), Boxing.boxBoolean(z));
            case 2:
                int i = c00011.I$0;
                request4 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                Document document3 = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv3 = document3.select("#dle-content > a");
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    Element it3 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it3);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request4.getName(), home3, false), Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("h3").text();
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, getMainUrl() + $this$toSearchResult.select("img").attr("data-src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Megakino.Megakino$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Megakino.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    private final SearchResponse toSearchResult1(Element $this$toSearchResult1) {
        String title = $this$toSearchResult1.select("h3").text();
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult1.attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, getMainUrl() + $this$toSearchResult1.select("img").attr("data-src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Megakino.Megakino$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Megakino.toSearchResult1$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult1$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(SearchQuality.HD);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0101  */
    /* JADX WARN: Code duplicated, block: B:27:0x012f A[LOOP:0: B:25:0x0129->B:27:0x012f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
        String query2;
        Object tokenCookie;
        String cookie;
        Collection destination$iv$iv;
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
                Companion companion = INSTANCE;
                query2 = query;
                c00071.L$0 = query2;
                c00071.label = 1;
                tokenCookie = companion.getTokenCookie(c00071);
                if (tokenCookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cookie = (String) tokenCookie;
                if (cookie == null) {
                    cookie = "";
                }
                Map data = MapsKt.mapOf(new Pair[]{TuplesKt.to("do", "search"), TuplesKt.to("subaction", "search"), TuplesKt.to("story", StringsKt.replace$default(query2, " ", "+", false, 4, (Object) null))});
                Requests app = MainActivityKt.getApp();
                String mainUrl = getMainUrl();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", cookie));
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(cookie);
                c00071.L$2 = SpillingKt.nullOutSpilledVariable(data);
                c00071.label = 2;
                $result = Requests.post$default(app, mainUrl, mapMapOf, (String) null, (Map) null, (Map) null, data, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 65500, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv = document.select("a.poster.grid-item");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(toSearchResult1(it));
                }
                List response = (List) destination$iv$iv;
                return response;
            case 1:
                String query3 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                query2 = query3;
                tokenCookie = $result;
                cookie = (String) tokenCookie;
                if (cookie == null) {
                    cookie = "";
                }
                Map data2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("do", "search"), TuplesKt.to("subaction", "search"), TuplesKt.to("story", StringsKt.replace$default(query2, " ", "+", false, 4, (Object) null))});
                Requests app2 = MainActivityKt.getApp();
                String mainUrl2 = getMainUrl();
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("Cookie", cookie));
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(cookie);
                c00071.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                c00071.label = 2;
                $result = Requests.post$default(app2, mainUrl2, mapMapOf2, (String) null, (Map) null, (Map) null, data2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 65500, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv2 = document2.select("a.poster.grid-item");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(toSearchResult1(it2));
                }
                List response2 = (List) destination$iv$iv;
                return response2;
            case 2:
                ResultKt.throwOnFailure($result);
                Document document3 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv3 = document3.select("a.poster.grid-item");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                    Element it3 = (Element) item$iv$iv;
                    destination$iv$iv.add(toSearchResult1(it3));
                }
                List response3 = (List) destination$iv$iv;
                return response3;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:24:0x0132 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0133  */
    /* JADX WARN: Code duplicated, block: B:28:0x0145  */
    /* JADX WARN: Code duplicated, block: B:30:0x014b  */
    /* JADX WARN: Code duplicated, block: B:34:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:36:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:37:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:39:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:43:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:44:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:47:0x0205  */
    /* JADX WARN: Code duplicated, block: B:48:0x020a  */
    /* JADX WARN: Code duplicated, block: B:51:0x020e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0268  */
    /* JADX WARN: Code duplicated, block: B:61:0x0288  */
    /* JADX WARN: Code duplicated, block: B:62:0x028b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0291  */
    /* JADX WARN: Code duplicated, block: B:68:0x02bc A[LOOP:2: B:66:0x02b6->B:68:0x02bc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x0399 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x039a  */
    /* JADX WARN: Code duplicated, block: B:74:0x03af  */
    /* JADX WARN: Code duplicated, block: B:76:0x041e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x041f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ce A[SYNTHETIC] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00021 c00021;
        String url2;
        Object tokenCookie;
        String cookie;
        String cookie2;
        Object obj;
        Object obj2;
        String cookie3;
        String url3;
        Document document;
        Element elementSelectFirst;
        String strText;
        String title;
        final String poster;
        Integer year;
        Collection destination$iv$iv;
        String hreflist;
        Element elementSelectFirst2;
        String description;
        String trailer;
        Element elementSelectFirst3;
        String strText2;
        String genresText;
        List listEmptyList;
        List genresList;
        String typetag;
        TvType type;
        Object objNewMovieLoadResponse;
        List episodes;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        Object objNewTvSeriesLoadResponse;
        Iterable iterableSplit$default;
        Element it;
        String strAttr;
        boolean z;
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
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Companion companion = INSTANCE;
                url2 = url;
                c00022.L$0 = url2;
                c00022.label = 1;
                tokenCookie = companion.getTokenCookie(c00022);
                if (tokenCookie == coroutine_suspended) {
                    return coroutine_suspended;
                }
                cookie = (String) tokenCookie;
                if (cookie == null) {
                    cookie = "";
                }
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", cookie));
                c00022.L$0 = url2;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie);
                c00022.label = 2;
                cookie2 = cookie;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url2, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                cookie3 = cookie2;
                url3 = url2;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.page__subcols.d-flex h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = "Unknown";
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, getMainUrl() + document.select("div.pmovie__poster.img-fit-cover img").attr("data-src"));
                year = StringsKt.toIntOrNull(document.select("div.pmovie__year > span:nth-child(2)").text());
                AppUtils appUtils = AppUtils.INSTANCE;
                Iterable $this$map$iv2 = document.select("div.pmovie__player iframe");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    it = (Element) item$iv$iv;
                    strAttr = it.attr("src");
                    if (strAttr.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        strAttr = it.attr("data-src");
                    }
                    destination$iv$iv.add(strAttr);
                }
                hreflist = appUtils.toJson((List) destination$iv$iv);
                elementSelectFirst2 = document.selectFirst("div.page__cols.d-flex p");
                if (elementSelectFirst2 != null) {
                    description = elementSelectFirst2.text();
                } else {
                    description = null;
                }
                trailer = document.select("link[itemprop=embedUrl]").attr("href");
                elementSelectFirst3 = document.selectFirst("div.pmovie__genres");
                if (elementSelectFirst3 != null) {
                    strText2 = elementSelectFirst3.text();
                } else {
                    strText2 = null;
                }
                genresText = strText2;
                if (genresText != null || (iterableSplit$default = StringsKt.split$default(genresText, new String[]{" / "}, false, 0, 6, (Object) null)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv2 : $this$map$iv3) {
                        destination$iv$iv3.add(StringsKt.trim((String) item$iv$iv2).toString());
                        $result = $result;
                    }
                    listEmptyList = (List) destination$iv$iv3;
                }
                genresList = listEmptyList;
                typetag = document.select("div.pmovie__genres").text();
                if (StringsKt.contains$default(typetag, "Filme", false, 2, (Object) null)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                if (type != TvType.TvSeries) {
                    TvType tvType = TvType.Movie;
                    C00044 c00044 = new C00044(poster, description, genresList, year, trailer, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(hreflist);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(description);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genresText);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(genresList);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(typetag);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url3, tvType, hreflist, c00044, c00022);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$map$iv = document.select("select.flex-grow-1.mr-select option");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv3 : $this$map$iv) {
                    String typetag2 = typetag;
                    Element it2 = (Element) item$iv$iv3;
                    TvType type2 = type;
                    final String epnumber = "Episode " + it2.attr("data-season");
                    String ephref = it2.select("option").attr("value");
                    episodes.add(MainAPIKt.newEpisode(this, ephref, new Function1() { // from class: com.Megakino.Megakino$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return Megakino.load$lambda$2$0(epnumber, poster, (Episode) obj3);
                        }
                    }));
                    destination$iv$iv2.add(Unit.INSTANCE);
                    typetag = typetag2;
                    type = type2;
                    $this$map$iv = $this$map$iv;
                    title = title;
                    url3 = url3;
                }
                String typetag3 = typetag;
                TvType tvType2 = TvType.TvSeries;
                C00033 c00033 = new C00033(poster, description, genresList, year, trailer, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie3);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(hreflist);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(description);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(trailer);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genresText);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(genresList);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(typetag3);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(type);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(episodes);
                c00022.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title, url3, tvType2, episodes, c00033, c00022);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url4 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url4;
                tokenCookie = $result;
                cookie = (String) tokenCookie;
                if (cookie == null) {
                    cookie = "";
                }
                Requests app2 = MainActivityKt.getApp();
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("Cookie", cookie));
                c00022.L$0 = url2;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie);
                c00022.label = 2;
                cookie2 = cookie;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app2, url2, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                cookie3 = cookie2;
                url3 = url2;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.page__subcols.d-flex h1");
                if (elementSelectFirst != null) {
                    strText = "Unknown";
                } else {
                    strText = "Unknown";
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, getMainUrl() + document.select("div.pmovie__poster.img-fit-cover img").attr("data-src"));
                year = StringsKt.toIntOrNull(document.select("div.pmovie__year > span:nth-child(2)").text());
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Iterable $this$map$iv4 = document.select("div.pmovie__player iframe");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r17.hasNext()) {
                    it = (Element) item$iv$iv;
                    strAttr = it.attr("src");
                    if (strAttr.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        strAttr = it.attr("data-src");
                    }
                    destination$iv$iv.add(strAttr);
                }
                hreflist = appUtils2.toJson((List) destination$iv$iv);
                elementSelectFirst2 = document.selectFirst("div.page__cols.d-flex p");
                if (elementSelectFirst2 != null) {
                    description = elementSelectFirst2.text();
                } else {
                    description = null;
                }
                trailer = document.select("link[itemprop=embedUrl]").attr("href");
                elementSelectFirst3 = document.selectFirst("div.pmovie__genres");
                if (elementSelectFirst3 != null) {
                    strText2 = elementSelectFirst3.text();
                } else {
                    strText2 = null;
                }
                genresText = strText2;
                if (genresText != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                genresList = listEmptyList;
                typetag = document.select("div.pmovie__genres").text();
                if (StringsKt.contains$default(typetag, "Filme", false, 2, (Object) null)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                if (type != TvType.TvSeries) {
                    TvType tvType3 = TvType.Movie;
                    C00044 c00045 = new C00044(poster, description, genresList, year, trailer, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(hreflist);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(description);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genresText);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(genresList);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(typetag);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url3, tvType3, hreflist, c00045, c00022);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$map$iv = document.select("select.flex-grow-1.mr-select option");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    String typetag4 = typetag;
                    Element it3 = (Element) item$iv$iv3;
                    TvType type3 = type;
                    final String epnumber2 = "Episode " + it3.attr("data-season");
                    String ephref2 = it3.select("option").attr("value");
                    episodes.add(MainAPIKt.newEpisode(this, ephref2, new Function1() { // from class: com.Megakino.Megakino$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return Megakino.load$lambda$2$0(epnumber2, poster, (Episode) obj3);
                        }
                    }));
                    destination$iv$iv2.add(Unit.INSTANCE);
                    typetag = typetag4;
                    type = type3;
                    $this$map$iv = $this$map$iv;
                    title = title;
                    url3 = url3;
                }
                String typetag5 = typetag;
                TvType tvType4 = TvType.TvSeries;
                C00033 c00034 = new C00033(poster, description, genresList, year, trailer, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie3);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(hreflist);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(description);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(trailer);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genresText);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(genresList);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(typetag5);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(type);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(episodes);
                c00022.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title, url3, tvType4, episodes, c00034, c00022);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                String cookie4 = (String) c00022.L$1;
                String url5 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                cookie3 = cookie4;
                obj = coroutine_suspended;
                obj2 = $result;
                url3 = url5;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.page__subcols.d-flex h1");
                if (elementSelectFirst != null) {
                    strText = "Unknown";
                } else {
                    strText = "Unknown";
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, getMainUrl() + document.select("div.pmovie__poster.img-fit-cover img").attr("data-src"));
                year = StringsKt.toIntOrNull(document.select("div.pmovie__year > span:nth-child(2)").text());
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Iterable $this$map$iv5 = document.select("div.pmovie__player iframe");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                while (r17.hasNext()) {
                    it = (Element) item$iv$iv;
                    strAttr = it.attr("src");
                    if (strAttr.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        strAttr = it.attr("data-src");
                    }
                    destination$iv$iv.add(strAttr);
                }
                hreflist = appUtils3.toJson((List) destination$iv$iv);
                elementSelectFirst2 = document.selectFirst("div.page__cols.d-flex p");
                if (elementSelectFirst2 != null) {
                    description = elementSelectFirst2.text();
                } else {
                    description = null;
                }
                trailer = document.select("link[itemprop=embedUrl]").attr("href");
                elementSelectFirst3 = document.selectFirst("div.pmovie__genres");
                if (elementSelectFirst3 != null) {
                    strText2 = elementSelectFirst3.text();
                } else {
                    strText2 = null;
                }
                genresText = strText2;
                if (genresText != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                genresList = listEmptyList;
                typetag = document.select("div.pmovie__genres").text();
                if (StringsKt.contains$default(typetag, "Filme", false, 2, (Object) null)) {
                    type = TvType.Movie;
                } else {
                    type = TvType.TvSeries;
                }
                if (type != TvType.TvSeries) {
                    TvType tvType5 = TvType.Movie;
                    C00044 c00046 = new C00044(poster, description, genresList, year, trailer, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(hreflist);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(description);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genresText);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(genresList);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(typetag);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url3, tvType5, hreflist, c00046, c00022);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$map$iv = document.select("select.flex-grow-1.mr-select option");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    String typetag6 = typetag;
                    Element it4 = (Element) item$iv$iv3;
                    TvType type4 = type;
                    final String epnumber3 = "Episode " + it4.attr("data-season");
                    String ephref3 = it4.select("option").attr("value");
                    episodes.add(MainAPIKt.newEpisode(this, ephref3, new Function1() { // from class: com.Megakino.Megakino$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return Megakino.load$lambda$2$0(epnumber3, poster, (Episode) obj3);
                        }
                    }));
                    destination$iv$iv2.add(Unit.INSTANCE);
                    typetag = typetag6;
                    type = type4;
                    $this$map$iv = $this$map$iv;
                    title = title;
                    url3 = url3;
                }
                String typetag7 = typetag;
                TvType tvType6 = TvType.TvSeries;
                C00033 c00035 = new C00033(poster, description, genresList, year, trailer, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(cookie3);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(document);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(title);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(hreflist);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(description);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(trailer);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genresText);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(genresList);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(typetag7);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(type);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(episodes);
                c00022.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title, url3, tvType6, episodes, c00035, c00022);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0(String $epnumber, String $poster, Episode $this$newEpisode) {
        $this$newEpisode.setName($epnumber);
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull($epnumber));
        $this$newEpisode.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Megakino.Megakino$load$3 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino$load$3", f = "Megakino.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {134}, s = {"L$0"}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genresList;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, String str2, List<String> list, Integer num, String str3, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genresList = list;
            this.$year = num;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$description, this.$genresList, this.$year, this.$trailer, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$genresList);
                    loadResponse.setYear(this.$year);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
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
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.Megakino.Megakino$load$4 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino$load$4", f = "Megakino.kt", i = {0}, l = {141}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {142}, s = {"L$0"}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genresList;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(String str, String str2, List<String> list, Integer num, String str3, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genresList = list;
            this.$year = num;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = new C00044(this.$poster, this.$description, this.$genresList, this.$year, this.$trailer, continuation);
            c00044.L$0 = obj;
            return c00044;
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
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$genresList);
                    loadResponse.setYear(this.$year);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
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
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
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
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.startsWith$default(data, "[", false, 2, (Object) null)) {
                    List listSplit$default = StringsKt.split$default(StringsKt.removeSurrounding(data, "[\"", "\"]"), new String[]{"\",\""}, false, 0, 6, (Object) null);
                    C00062 c00062 = new C00062(function1, function2, null);
                    c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00051.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00051.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00051.Z$0 = isCasting;
                    c00051.label = 1;
                    if (ParCollectionsKt.amap(listSplit$default, c00062, c00051) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00051.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00051.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00051.Z$0 = isCasting;
                    c00051.label = 2;
                    if (ExtractorApiKt.loadExtractor(data, function1, function2, c00051) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            case 1:
                boolean isCasting2 = c00051.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                boolean z = c00051.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.Megakino.Megakino$loadLinks$2 */
    /* JADX INFO: compiled from: Megakino.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Megakino.Megakino$loadLinks$2", f = "Megakino.kt", i = {0}, l = {150}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(String str, Continuation<? super Boolean> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(it, this.$subtitleCallback, this.$callback, (Continuation) this);
                    if (objLoadExtractor == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
