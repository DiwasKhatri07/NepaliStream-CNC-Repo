package com.BanglaPlex;

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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
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
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: BanglaPlex.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/BanglaPlex/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001c\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020%*\u00020&H\u0002J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010.JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00069"}, d2 = {"Lcom/BanglaPlex/Banglaplex;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BanglaPlex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBanglaPlex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BanglaPlex.kt\ncom/BanglaPlex/Banglaplex\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n1795#2,10:126\n2068#2:136\n2069#2:138\n1805#2:139\n1795#2,10:140\n2068#2:150\n2069#2:152\n1805#2:153\n1795#2,10:154\n2068#2:164\n2069#2:166\n1805#2:167\n1#3:137\n1#3:151\n1#3:165\n*S KotlinDebug\n*F\n+ 1 BanglaPlex.kt\ncom/BanglaPlex/Banglaplex\n*L\n34#1:126,10\n34#1:136\n34#1:138\n34#1:139\n48#1:140,10\n48#1:150\n48#1:152\n48#1:153\n87#1:154,10\n87#1:164\n87#1:166\n87#1:167\n34#1:137\n48#1:151\n87#1:165\n*E\n"})
public final class Banglaplex extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Banglaplex$mainUrl$1(null));

    @NotNull
    private String name = "Banglaplex";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "bn";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("#hot", "Trending"), TuplesKt.to("genre/bollywood-movies", "Bollywood"), TuplesKt.to("genre/hollywood-movies", "Hollywood"), TuplesKt.to("genre/south-indian-movies", "South Indian Movies"), TuplesKt.to("genre/bollywood-series", "Bollywood Series"), TuplesKt.to("genre/dual-audio-movies", "Dual Audio Movies"), TuplesKt.to("genre/korean-web-series", "Korean Web Series")});

    /* JADX INFO: renamed from: com.BanglaPlex.Banglaplex$getMainPage$1 */
    /* JADX INFO: compiled from: BanglaPlex.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.BanglaPlex.Banglaplex", f = "BanglaPlex.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {29, 32, 46}, m = "getMainPage", n = {"request", "page", "request", "res", "page", "request", "res", "page", "newpagenumber"}, nl = {30, 33, 47}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return Banglaplex.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.BanglaPlex.Banglaplex$load$1 */
    /* JADX INFO: compiled from: BanglaPlex.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.BanglaPlex.Banglaplex", f = "BanglaPlex.kt", i = {0, 1, 1, 1, 1, 1}, l = {93, 98}, m = "load", n = {"url", "url", "document", "title", "poster", "description"}, nl = {94, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Banglaplex.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.BanglaPlex.Banglaplex$loadLinks$1 */
    /* JADX INFO: compiled from: BanglaPlex.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.BanglaPlex.Banglaplex", f = "BanglaPlex.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {105, 107, 111, 114, 114}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "it", "isCasting", "data", "subtitleCallback", "callback", "document", "downloadURLs", "isCasting", "data", "subtitleCallback", "callback", "document", "downloadURLs", "tokenres", "csrftoken", "csrftokenvakue", "isCasting", "data", "subtitleCallback", "callback", "document", "downloadURLs", "tokenres", "csrftoken", "csrftokenvakue", "isCasting"}, nl = {106, 106, 112, 114, 123}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
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
            return Banglaplex.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.BanglaPlex.Banglaplex$search$1 */
    /* JADX INFO: compiled from: BanglaPlex.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.BanglaPlex.Banglaplex", f = "BanglaPlex.kt", i = {0, 0, 0}, l = {85}, m = "search", n = {"query", "url", "page"}, nl = {86}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Banglaplex.this.search(null, 0, (Continuation) this);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:24:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0166  */
    /* JADX WARN: Code duplicated, block: B:29:0x018f  */
    /* JADX WARN: Code duplicated, block: B:31:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:35:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:37:0x024a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x024b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0276  */
    /* JADX WARN: Code duplicated, block: B:44:0x028a  */
    /* JADX WARN: Code duplicated, block: B:48:0x02b0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x028f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        String str;
        String str2;
        int i;
        Object obj;
        C00001 c00002;
        MainPageRequest request2;
        Object obj2;
        int page2;
        NiceResponse res;
        boolean z;
        MainPageRequest request3;
        String str3;
        MainPageRequest request4;
        MainPageRequest request5;
        NiceResponse res2;
        MainPageRequest request6;
        Collection destination$iv$iv;
        SearchResponse searchResult;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv2;
        SearchResponse searchResult2;
        Banglaplex banglaplex = this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = banglaplex.new C00001(continuation);
            }
        } else {
            c00001 = banglaplex.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str4 = banglaplex.getMainUrl() + '/' + request.getData() + ".html";
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                str = "div.movie-container > div.col-md-2";
                str2 = ".html";
                i = 1;
                C00001 c00003 = c00001;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4094, (Object) null);
                c00002 = c00003;
                if (obj3 == obj) {
                    return obj;
                }
                request2 = request;
                obj2 = obj3;
                page2 = page;
                res = (NiceResponse) obj2;
                if (res.getCode() == 200) {
                    return null;
                }
                if (page2 == i) {
                    Requests app2 = MainActivityKt.getApp();
                    String str5 = getMainUrl() + '/' + request2.getData() + str2;
                    c00002.L$0 = request2;
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(res);
                    c00002.I$0 = page2;
                    c00002.label = 2;
                    request5 = request2;
                    $result = Requests.get$default(app2, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    res2 = res;
                    request6 = request5;
                    Document document = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv2 = document.select(str);
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                        Element it = (Element) element$iv$iv$iv;
                        NiceResponse res3 = res2;
                        searchResult = toSearchResult(it);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                        res2 = res3;
                    }
                    List home = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(new HomePageList(request6.getName(), home, false), Boxing.boxBoolean(true));
                }
                z = true;
                int page3 = page2;
                request3 = request2;
                int newpagenumber = page3 * 12;
                Requests app3 = MainActivityKt.getApp();
                String str6 = getMainUrl() + '/' + request3.getData() + '/' + newpagenumber + str2;
                c00002.L$0 = request3;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00002.I$0 = page3;
                c00002.I$1 = newpagenumber;
                c00002.label = 3;
                str3 = str;
                banglaplex = this;
                $result = Requests.get$default(app3, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                request4 = request3;
                Document document2 = ((NiceResponse) $result).getDocument();
                $this$mapNotNull$iv = document2.select(str3);
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it2 = (Element) element$iv$iv$iv2;
                    searchResult2 = banglaplex.toSearchResult(it2);
                    if (searchResult2 != null) {
                        destination$iv$iv2.add(searchResult2);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                }
                List home2 = (List) destination$iv$iv2;
                return MainAPIKt.newHomePageResponse(new HomePageList(request4.getName(), home2, false), Boxing.boxBoolean(z));
            case 1:
                int page4 = c00001.I$0;
                MainPageRequest request7 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00001;
                obj = coroutine_suspended;
                obj2 = $result;
                page2 = page4;
                str = "div.movie-container > div.col-md-2";
                str2 = ".html";
                request2 = request7;
                i = 1;
                res = (NiceResponse) obj2;
                if (res.getCode() == 200) {
                    return null;
                }
                if (page2 == i) {
                    Requests app4 = MainActivityKt.getApp();
                    String str7 = getMainUrl() + '/' + request2.getData() + str2;
                    c00002.L$0 = request2;
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(res);
                    c00002.I$0 = page2;
                    c00002.label = 2;
                    request5 = request2;
                    $result = Requests.get$default(app4, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    res2 = res;
                    request6 = request5;
                    Document document3 = ((NiceResponse) $result).getDocument();
                    Iterable $this$mapNotNull$iv4 = document3.select(str);
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        Element it3 = (Element) element$iv$iv$iv;
                        NiceResponse res4 = res2;
                        searchResult = toSearchResult(it3);
                        if (searchResult != null) {
                            destination$iv$iv.add(searchResult);
                        }
                        res2 = res4;
                    }
                    List home3 = (List) destination$iv$iv;
                    return MainAPIKt.newHomePageResponse(new HomePageList(request6.getName(), home3, false), Boxing.boxBoolean(true));
                }
                z = true;
                int page5 = page2;
                request3 = request2;
                int newpagenumber2 = page5 * 12;
                Requests app5 = MainActivityKt.getApp();
                String str8 = getMainUrl() + '/' + request3.getData() + '/' + newpagenumber2 + str2;
                c00002.L$0 = request3;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00002.I$0 = page5;
                c00002.I$1 = newpagenumber2;
                c00002.label = 3;
                str3 = str;
                banglaplex = this;
                $result = Requests.get$default(app5, str8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                request4 = request3;
                Document document4 = ((NiceResponse) $result).getDocument();
                $this$mapNotNull$iv = document4.select(str3);
                destination$iv$iv2 = new ArrayList();
                while (r13.hasNext()) {
                    Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                    Element it4 = (Element) element$iv$iv$iv2;
                    searchResult2 = banglaplex.toSearchResult(it4);
                    if (searchResult2 != null) {
                        destination$iv$iv2.add(searchResult2);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv5;
                }
                List home4 = (List) destination$iv$iv2;
                return MainAPIKt.newHomePageResponse(new HomePageList(request4.getName(), home4, false), Boxing.boxBoolean(z));
            case 2:
                int newpagenumber3 = c00001.I$0;
                res2 = (NiceResponse) c00001.L$1;
                request6 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                str = "div.movie-container > div.col-md-2";
                Document document5 = ((NiceResponse) $result).getDocument();
                Iterable $this$mapNotNull$iv6 = document5.select(str);
                destination$iv$iv = new ArrayList();
                while (r13.hasNext()) {
                    Element it5 = (Element) element$iv$iv$iv;
                    NiceResponse res5 = res2;
                    searchResult = toSearchResult(it5);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    res2 = res5;
                }
                List home5 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(new HomePageList(request6.getName(), home5, false), Boxing.boxBoolean(true));
            case 3:
                int i2 = c00001.I$1;
                int i3 = c00001.I$0;
                request4 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                str3 = "div.movie-container > div.col-md-2";
                z = true;
                Document document6 = ((NiceResponse) $result).getDocument();
                $this$mapNotNull$iv = document6.select(str3);
                destination$iv$iv2 = new ArrayList();
                while (r13.hasNext()) {
                    Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                    Element it6 = (Element) element$iv$iv$iv2;
                    searchResult2 = banglaplex.toSearchResult(it6);
                    if (searchResult2 != null) {
                        destination$iv$iv2.add(searchResult2);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv7;
                }
                List home6 = (List) destination$iv$iv2;
                return MainAPIKt.newHomePageResponse(new HomePageList(request4.getName(), home6, false), Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strOwnText;
        String strSubstringAfter$default;
        String title = StringsKt.trim(MainAPIKt.fixTitle($this$toSearchResult.select("div.movie-img > div.movie-title > h3 >a").text())).toString();
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("div.movie-img > div.movie-title > h3 >a").attr("href"));
        String string = null;
        final String posterUrl = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("div > div.latest-movie-img-container").attr("style"))), "url('", (String) null, 2, (Object) null), "')", (String) null, 2, (Object) null);
        final String quality = $this$toSearchResult.select("span.label.label-primary").text();
        Element elementSelectFirst = $this$toSearchResult.selectFirst("span.label.label-imdb");
        if (elementSelectFirst != null && (strOwnText = elementSelectFirst.ownText()) != null && (strSubstringAfter$default = StringsKt.substringAfter$default(strOwnText, "IMDB", (String) null, 2, (Object) null)) != null) {
            string = StringsKt.trim(strSubstringAfter$default).toString();
        }
        final String score = string;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.BanglaPlex.Banglaplex$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Banglaplex.toSearchResult$lambda$0(posterUrl, quality, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, String $quality, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString($quality));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00051 c00051;
        String url;
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
                if (page == 1) {
                    url = getMainUrl() + "/search?q=" + query;
                } else {
                    int newPageNumber = page * 12;
                    url = getMainUrl() + "/search?q=" + query + "&per_page=" + newPageNumber;
                }
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00051.I$0 = page;
                c00051.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00051.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.movie-container > div.col-md-2");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List results = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(results, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        String strAttr;
        String strAttr2;
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
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url3;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) obj2).getDocument();
        Element elementSelectFirst = document.selectFirst("meta[property=og:title]");
        String title = StringsKt.substringBefore$default(String.valueOf((elementSelectFirst == null || (strAttr2 = elementSelectFirst.attr("content")) == null) ? null : StringsKt.trim(strAttr2).toString()), " | Watch Online", (String) null, 2, (Object) null);
        String poster = document.select("#info > div > div > img").attr("src");
        Element elementSelectFirst2 = document.selectFirst("meta[property=og:description]");
        String description = (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("content")) == null) ? null : StringsKt.trim(strAttr).toString();
        TvType tvType = TvType.Movie;
        C00022 c00022 = new C00022(poster, description, null);
        c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
        c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
        c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
        c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
        c00012.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, url2, c00022, c00012);
        if (objNewMovieLoadResponse == obj) {
            return obj;
        }
        return objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.BanglaPlex.Banglaplex$load$2 */
    /* JADX INFO: compiled from: BanglaPlex.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.BanglaPlex.Banglaplex$load$2", f = "BanglaPlex.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, String str2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
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
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0196 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0197  */
    /* JADX WARN: Code duplicated, block: B:27:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:28:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:30:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:32:0x020b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x020c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0227  */
    /* JADX WARN: Code duplicated, block: B:37:0x022c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0235  */
    /* JADX WARN: Code duplicated, block: B:41:0x023a  */
    /* JADX WARN: Code duplicated, block: B:44:0x02bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x02be  */
    /* JADX WARN: Code duplicated, block: B:48:0x031e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0327  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        Banglaplex banglaplex;
        boolean z;
        Object obj;
        C00031 c00032;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Document document;
        Object objLoadExtractor;
        String data3;
        Function1<? super SubtitleFile, Unit> function5;
        boolean isCasting3;
        Document document2;
        String downloadURLs;
        boolean z2;
        boolean isCasting4;
        Document document3;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super SubtitleFile, Unit> function7;
        C00031 c00033;
        String downloadURLs2;
        String data4;
        boolean isCasting5;
        Function1<? super ExtractorLink, Unit> function8;
        Function1<? super SubtitleFile, Unit> function9;
        Document document4;
        Document tokenres;
        Element elementSelectFirst;
        String strAttr;
        String csrftoken;
        Element elementSelectFirst2;
        String strAttr2;
        String csrftokenvakue;
        Function1<? super ExtractorLink, Unit> function10;
        Function1<? super SubtitleFile, Unit> function11;
        boolean isCasting6;
        String downloadURLs3;
        C00031 c00034;
        String downloadURLs4;
        Document document5;
        String data5;
        String csrftoken2;
        Document tokenres2;
        Function1<? super SubtitleFile, Unit> function12;
        boolean isCasting7;
        Function1<? super ExtractorLink, Unit> function13;
        List listSelect;
        C00043 c00043;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
                banglaplex = this;
            } else {
                banglaplex = this;
                c00031 = banglaplex.new C00031(continuation);
            }
        } else {
            banglaplex = this;
            c00031 = banglaplex.new C00031(continuation);
        }
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00031.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00031.L$1 = function1;
                c00031.L$2 = function2;
                c00031.Z$0 = isCasting;
                c00031.label = 1;
                z = true;
                C00031 c00035 = c00031;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4094, (Object) null);
                c00032 = c00035;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                document = ((NiceResponse) $result).getDocument();
                String it = document.select("div.video-embed-container > iframe").attr("src");
                String mainUrl = banglaplex.getMainUrl();
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = function3;
                c00032.L$2 = function4;
                c00032.L$3 = document;
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(it);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                objLoadExtractor = ExtractorApiKt.loadExtractor(it, mainUrl, function3, function4, c00032);
                if (objLoadExtractor == obj) {
                    return obj;
                }
                data3 = data2;
                function5 = function3;
                isCasting3 = isCasting2;
                document2 = document;
                $result = objLoadExtractor;
                ((Boolean) $result).booleanValue();
                downloadURLs = document2.select("#download a ").attr("href");
                if (downloadURLs.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Requests app2 = MainActivityKt.getApp();
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$1 = function5;
                    c00032.L$2 = function4;
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00032.L$4 = downloadURLs;
                    c00032.Z$0 = isCasting3;
                    c00032.label = 3;
                    C00031 c00036 = c00032;
                    isCasting4 = isCasting3;
                    document3 = document2;
                    function6 = function4;
                    function7 = function5;
                    $result = Requests.get$default(app2, downloadURLs, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00036, 4094, (Object) null);
                    c00033 = c00036;
                    if ($result == obj) {
                        return obj;
                    }
                    downloadURLs2 = downloadURLs;
                    data4 = data3;
                    isCasting5 = isCasting4;
                    function8 = function6;
                    function9 = function7;
                    document4 = document3;
                    tokenres = ((NiceResponse) $result).getDocument();
                    elementSelectFirst = tokenres.selectFirst("form input");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("name");
                    } else {
                        strAttr = null;
                    }
                    csrftoken = strAttr;
                    elementSelectFirst2 = tokenres.selectFirst("form input");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("name");
                    } else {
                        strAttr2 = null;
                    }
                    csrftokenvakue = strAttr2;
                    Requests app3 = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(TuplesKt.to(String.valueOf(csrftoken), String.valueOf(csrftokenvakue)));
                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00033.L$1 = function9;
                    c00033.L$2 = function8;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(document4);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs2);
                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(tokenres);
                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken);
                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                    c00033.Z$0 = isCasting5;
                    c00033.label = 4;
                    C00031 c00037 = c00033;
                    function10 = function8;
                    function11 = function9;
                    isCasting6 = isCasting5;
                    downloadURLs3 = downloadURLs2;
                    $result = Requests.post$default(app3, downloadURLs3, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00037, 65502, (Object) null);
                    c00034 = c00037;
                    if ($result == obj) {
                        return obj;
                    }
                    downloadURLs4 = downloadURLs3;
                    document5 = document4;
                    data5 = data4;
                    csrftoken2 = csrftoken;
                    tokenres2 = tokenres;
                    function12 = function11;
                    isCasting7 = isCasting6;
                    function13 = function10;
                    listSelect = ((NiceResponse) $result).getDocument().select("div.row > div.col-sm-8 > a");
                    c00043 = new C00043(function12, function13, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(document5);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs4);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(tokenres2);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken2);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                    c00034.Z$0 = isCasting7;
                    c00034.label = 5;
                    if (ParCollectionsKt.amap(listSelect, c00043, c00034) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00031.Z$0;
                function4 = (Function1) c00031.L$2;
                function3 = (Function1) c00031.L$1;
                data2 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00032 = c00031;
                obj = coroutine_suspended;
                z = true;
                document = ((NiceResponse) $result).getDocument();
                String it2 = document.select("div.video-embed-container > iframe").attr("src");
                String mainUrl2 = banglaplex.getMainUrl();
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = function3;
                c00032.L$2 = function4;
                c00032.L$3 = document;
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(it2);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                objLoadExtractor = ExtractorApiKt.loadExtractor(it2, mainUrl2, function3, function4, c00032);
                if (objLoadExtractor == obj) {
                    return obj;
                }
                data3 = data2;
                function5 = function3;
                isCasting3 = isCasting2;
                document2 = document;
                $result = objLoadExtractor;
                ((Boolean) $result).booleanValue();
                downloadURLs = document2.select("#download a ").attr("href");
                if (downloadURLs.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Requests app4 = MainActivityKt.getApp();
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$1 = function5;
                    c00032.L$2 = function4;
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00032.L$4 = downloadURLs;
                    c00032.Z$0 = isCasting3;
                    c00032.label = 3;
                    C00031 c00038 = c00032;
                    isCasting4 = isCasting3;
                    document3 = document2;
                    function6 = function4;
                    function7 = function5;
                    $result = Requests.get$default(app4, downloadURLs, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00038, 4094, (Object) null);
                    c00033 = c00038;
                    if ($result == obj) {
                        return obj;
                    }
                    downloadURLs2 = downloadURLs;
                    data4 = data3;
                    isCasting5 = isCasting4;
                    function8 = function6;
                    function9 = function7;
                    document4 = document3;
                    tokenres = ((NiceResponse) $result).getDocument();
                    elementSelectFirst = tokenres.selectFirst("form input");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("name");
                    } else {
                        strAttr = null;
                    }
                    csrftoken = strAttr;
                    elementSelectFirst2 = tokenres.selectFirst("form input");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("name");
                    } else {
                        strAttr2 = null;
                    }
                    csrftokenvakue = strAttr2;
                    Requests app5 = MainActivityKt.getApp();
                    Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(String.valueOf(csrftoken), String.valueOf(csrftokenvakue)));
                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00033.L$1 = function9;
                    c00033.L$2 = function8;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(document4);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs2);
                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(tokenres);
                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken);
                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                    c00033.Z$0 = isCasting5;
                    c00033.label = 4;
                    C00031 c00039 = c00033;
                    function10 = function8;
                    function11 = function9;
                    isCasting6 = isCasting5;
                    downloadURLs3 = downloadURLs2;
                    $result = Requests.post$default(app5, downloadURLs3, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00039, 65502, (Object) null);
                    c00034 = c00039;
                    if ($result == obj) {
                        return obj;
                    }
                    downloadURLs4 = downloadURLs3;
                    document5 = document4;
                    data5 = data4;
                    csrftoken2 = csrftoken;
                    tokenres2 = tokenres;
                    function12 = function11;
                    isCasting7 = isCasting6;
                    function13 = function10;
                    listSelect = ((NiceResponse) $result).getDocument().select("div.row > div.col-sm-8 > a");
                    c00043 = new C00043(function12, function13, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(document5);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs4);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(tokenres2);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken2);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                    c00034.Z$0 = isCasting7;
                    c00034.label = 5;
                    if (ParCollectionsKt.amap(listSelect, c00043, c00034) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting8 = c00031.Z$0;
                Document document6 = (Document) c00031.L$3;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00031.L$2;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00031.L$1;
                String data6 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00032 = c00031;
                obj = coroutine_suspended;
                isCasting3 = isCasting8;
                document2 = document6;
                function4 = function14;
                function5 = function15;
                data3 = data6;
                z = true;
                ((Boolean) $result).booleanValue();
                downloadURLs = document2.select("#download a ").attr("href");
                if (downloadURLs.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Requests app6 = MainActivityKt.getApp();
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00032.L$1 = function5;
                    c00032.L$2 = function4;
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00032.L$4 = downloadURLs;
                    c00032.Z$0 = isCasting3;
                    c00032.label = 3;
                    C00031 c000310 = c00032;
                    isCasting4 = isCasting3;
                    document3 = document2;
                    function6 = function4;
                    function7 = function5;
                    $result = Requests.get$default(app6, downloadURLs, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000310, 4094, (Object) null);
                    c00033 = c000310;
                    if ($result == obj) {
                        return obj;
                    }
                    downloadURLs2 = downloadURLs;
                    data4 = data3;
                    isCasting5 = isCasting4;
                    function8 = function6;
                    function9 = function7;
                    document4 = document3;
                    tokenres = ((NiceResponse) $result).getDocument();
                    elementSelectFirst = tokenres.selectFirst("form input");
                    if (elementSelectFirst != null) {
                        strAttr = elementSelectFirst.attr("name");
                    } else {
                        strAttr = null;
                    }
                    csrftoken = strAttr;
                    elementSelectFirst2 = tokenres.selectFirst("form input");
                    if (elementSelectFirst2 != null) {
                        strAttr2 = elementSelectFirst2.attr("name");
                    } else {
                        strAttr2 = null;
                    }
                    csrftokenvakue = strAttr2;
                    Requests app7 = MainActivityKt.getApp();
                    Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to(String.valueOf(csrftoken), String.valueOf(csrftokenvakue)));
                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00033.L$1 = function9;
                    c00033.L$2 = function8;
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(document4);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs2);
                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(tokenres);
                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken);
                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                    c00033.Z$0 = isCasting5;
                    c00033.label = 4;
                    C00031 c000311 = c00033;
                    function10 = function8;
                    function11 = function9;
                    isCasting6 = isCasting5;
                    downloadURLs3 = downloadURLs2;
                    $result = Requests.post$default(app7, downloadURLs3, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000311, 65502, (Object) null);
                    c00034 = c000311;
                    if ($result == obj) {
                        return obj;
                    }
                    downloadURLs4 = downloadURLs3;
                    document5 = document4;
                    data5 = data4;
                    csrftoken2 = csrftoken;
                    tokenres2 = tokenres;
                    function12 = function11;
                    isCasting7 = isCasting6;
                    function13 = function10;
                    listSelect = ((NiceResponse) $result).getDocument().select("div.row > div.col-sm-8 > a");
                    c00043 = new C00043(function12, function13, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(document5);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs4);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(tokenres2);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken2);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                    c00034.Z$0 = isCasting7;
                    c00034.label = 5;
                    if (ParCollectionsKt.amap(listSelect, c00043, c00034) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 3:
                boolean isCasting9 = c00031.Z$0;
                downloadURLs2 = (String) c00031.L$4;
                Document document7 = (Document) c00031.L$3;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00031.L$2;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00031.L$1;
                String data7 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00033 = c00031;
                obj = coroutine_suspended;
                isCasting5 = isCasting9;
                document4 = document7;
                function8 = function16;
                function9 = function17;
                data4 = data7;
                z = true;
                tokenres = ((NiceResponse) $result).getDocument();
                elementSelectFirst = tokenres.selectFirst("form input");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("name");
                } else {
                    strAttr = null;
                }
                csrftoken = strAttr;
                elementSelectFirst2 = tokenres.selectFirst("form input");
                if (elementSelectFirst2 != null) {
                    strAttr2 = elementSelectFirst2.attr("name");
                } else {
                    strAttr2 = null;
                }
                csrftokenvakue = strAttr2;
                Requests app8 = MainActivityKt.getApp();
                Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to(String.valueOf(csrftoken), String.valueOf(csrftokenvakue)));
                c00033.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00033.L$1 = function9;
                c00033.L$2 = function8;
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(document4);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs2);
                c00033.L$5 = SpillingKt.nullOutSpilledVariable(tokenres);
                c00033.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken);
                c00033.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                c00033.Z$0 = isCasting5;
                c00033.label = 4;
                C00031 c000312 = c00033;
                function10 = function8;
                function11 = function9;
                isCasting6 = isCasting5;
                downloadURLs3 = downloadURLs2;
                $result = Requests.post$default(app8, downloadURLs3, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf4, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000312, 65502, (Object) null);
                c00034 = c000312;
                if ($result == obj) {
                    return obj;
                }
                downloadURLs4 = downloadURLs3;
                document5 = document4;
                data5 = data4;
                csrftoken2 = csrftoken;
                tokenres2 = tokenres;
                function12 = function11;
                isCasting7 = isCasting6;
                function13 = function10;
                listSelect = ((NiceResponse) $result).getDocument().select("div.row > div.col-sm-8 > a");
                c00043 = new C00043(function12, function13, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(document5);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs4);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(tokenres2);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken2);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                c00034.Z$0 = isCasting7;
                c00034.label = 5;
                if (ParCollectionsKt.amap(listSelect, c00043, c00034) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 4:
                boolean isCasting10 = c00031.Z$0;
                String csrftokenvakue2 = (String) c00031.L$7;
                String csrftoken3 = (String) c00031.L$6;
                Document tokenres3 = (Document) c00031.L$5;
                String downloadURLs5 = (String) c00031.L$4;
                Document document8 = (Document) c00031.L$3;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00031.L$2;
                Function1<? super SubtitleFile, Unit> function19 = (Function1) c00031.L$1;
                String data8 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00034 = c00031;
                obj = coroutine_suspended;
                isCasting7 = isCasting10;
                csrftokenvakue = csrftokenvakue2;
                csrftoken2 = csrftoken3;
                tokenres2 = tokenres3;
                downloadURLs4 = downloadURLs5;
                document5 = document8;
                function13 = function18;
                function12 = function19;
                data5 = data8;
                z = true;
                listSelect = ((NiceResponse) $result).getDocument().select("div.row > div.col-sm-8 > a");
                c00043 = new C00043(function12, function13, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(function12);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(document5);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(downloadURLs4);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(tokenres2);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(csrftoken2);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(csrftokenvakue);
                c00034.Z$0 = isCasting7;
                c00034.label = 5;
                if (ParCollectionsKt.amap(listSelect, c00043, c00034) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 5:
                isCasting7 = c00031.Z$0;
                downloadURLs4 = (String) c00031.L$4;
                document5 = (Document) c00031.L$3;
                function13 = (Function1) c00031.L$2;
                function12 = (Function1) c00031.L$1;
                data5 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.BanglaPlex.Banglaplex$loadLinks$3 */
    /* JADX INFO: compiled from: BanglaPlex.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.BanglaPlex.Banglaplex$loadLinks$3", f = "BanglaPlex.kt", i = {0, 0, 1, 1}, l = {118, 120}, m = "invokeSuspend", n = {"it", "href", "it", "href"}, nl = {120, -1}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$subtitleCallback, this.$callback, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String href;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String href2 = it.attr("href");
                    if (!StringsKt.contains(href2, "xcloud", true)) {
                        href = href2;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                        this.L$1 = href2;
                        this.label = 1;
                        if (new Xcloud().getUrl(href2, "", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        href = href2;
                    }
                    break;
                case 1:
                    href = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(it);
            this.L$1 = SpillingKt.nullOutSpilledVariable(href);
            this.label = 2;
            Object objLoadExtractor = ExtractorApiKt.loadExtractor(href, this.$subtitleCallback, this.$callback, (Continuation) this);
            return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
        }
    }
}
