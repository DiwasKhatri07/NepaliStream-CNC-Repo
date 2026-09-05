package com.Desicinemas;

import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: DesicinemasProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Desicinemas/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001e\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020'*\u00020(2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010**\u00020(H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001c2\u0006\u0010,\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010-JF\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00162\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006;"}, d2 = {"Lcom/Desicinemas/DesicinemasProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "proxy", "getProxy", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toHomePageResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Desicinemas"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDesicinemasProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesicinemasProvider.kt\ncom/Desicinemas/DesicinemasProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n1#2:84\n1#2:96\n1#2:110\n1795#3,10:85\n2068#3:95\n2069#3:97\n1805#3:98\n1795#3,10:99\n2068#3:109\n2069#3:111\n1805#3:112\n*S KotlinDebug\n*F\n+ 1 DesicinemasProvider.kt\ncom/Desicinemas/DesicinemasProvider\n*L\n35#1:96\n47#1:110\n35#1:85,10\n35#1:95\n35#1:97\n35#1:98\n47#1:99,10\n47#1:109\n47#1:111\n47#1:112\n*E\n"})
public class DesicinemasProvider extends MainAPI {

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Movie);

    @NotNull
    private String lang = "hi";

    @NotNull
    private String mainUrl = "https://desicinemas.to";

    @NotNull
    private String name = "Desicinemas";
    private final boolean hasMainPage = true;

    @NotNull
    private final String proxy = "https://desicinemas.phisherdesicinema.workers.dev/";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(this.proxy + "?url=https://desicinemas.to/", "Home"), TuplesKt.to(this.proxy + "?url=https://desicinemas.to/category/punjabi/", "Punjabi"), TuplesKt.to(this.proxy + "?url=https://desicinemas.to/category/bollywood/", "Bollywood"), TuplesKt.to(this.proxy + "?url=https://desicinemas.to/category/hindi-dubbed/", "Hindi Dubbed")});

    /* JADX INFO: renamed from: com.Desicinemas.DesicinemasProvider$getMainPage$1 */
    /* JADX INFO: compiled from: DesicinemasProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.DesicinemasProvider", f = "DesicinemasProvider.kt", i = {0, 0, 0, 0}, l = {23}, m = "getMainPage$suspendImpl", n = {"$this", "request", "url", "page"}, nl = {26}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
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
            return DesicinemasProvider.getMainPage$suspendImpl(DesicinemasProvider.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.DesicinemasProvider$load$1 */
    /* JADX INFO: compiled from: DesicinemasProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.DesicinemasProvider", f = "DesicinemasProvider.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {50, 54}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "doc", "title", "posterUrl"}, nl = {51, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DesicinemasProvider.load$suspendImpl(DesicinemasProvider.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.DesicinemasProvider$loadLinks$1 */
    /* JADX INFO: compiled from: DesicinemasProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.DesicinemasProvider", f = "DesicinemasProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {67, 67}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "isCasting", "$this", "data", "subtitleCallback", "callback", "isCasting"}, nl = {67, 80}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DesicinemasProvider.loadLinks$suspendImpl(DesicinemasProvider.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.DesicinemasProvider$search$1 */
    /* JADX INFO: compiled from: DesicinemasProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.DesicinemasProvider", f = "DesicinemasProvider.kt", i = {0, 0}, l = {46}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {47}, s = {"L$0", "L$1"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DesicinemasProvider.search$suspendImpl(DesicinemasProvider.this, null, (Continuation) this);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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
    public final String getProxy() {
        return this.proxy;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object getMainPage$suspendImpl(DesicinemasProvider desicinemasProvider, int i, MainPageRequest mainPageRequest, Continuation<? super HomePageResponse> continuation) {
        C00071 c00071;
        boolean z;
        Object obj;
        MainPageRequest mainPageRequest2;
        DesicinemasProvider desicinemasProvider2;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = desicinemasProvider.new C00071(continuation);
            }
        } else {
            c00071 = desicinemasProvider.new C00071(continuation);
        }
        Object obj2 = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure(obj2);
                String data = (i == 1 || Intrinsics.areEqual(mainPageRequest.getName(), "Home")) ? mainPageRequest.getData() : mainPageRequest.getData() + "page/" + i + '/';
                Requests app = UtilsKt.getApp();
                String mainUrl = desicinemasProvider.getMainUrl();
                c00071.L$0 = desicinemasProvider;
                c00071.L$1 = mainPageRequest;
                c00071.L$2 = SpillingKt.nullOutSpilledVariable(data);
                c00071.I$0 = i;
                c00071.label = 1;
                z = true;
                obj = "Home";
                obj2 = Requests.get$default(app, data, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c00071, 3834, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mainPageRequest2 = mainPageRequest;
                desicinemasProvider2 = desicinemasProvider;
                break;
            case 1:
                int i2 = c00071.I$0;
                mainPageRequest2 = (MainPageRequest) c00071.L$1;
                DesicinemasProvider desicinemasProvider3 = (DesicinemasProvider) c00071.L$0;
                ResultKt.throwOnFailure(obj2);
                z = true;
                desicinemasProvider2 = desicinemasProvider3;
                obj = "Home";
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) obj2).getDocument();
        HomePageList[] homePageListArr = new HomePageList[3];
        Element elementSelectFirst = document.selectFirst(".MovieListTop");
        HomePageList homePageList = elementSelectFirst != null ? desicinemasProvider2.toHomePageList(elementSelectFirst, "Most popular") : null;
        if (!Intrinsics.areEqual(mainPageRequest2.getName(), obj)) {
            homePageList = null;
        }
        homePageListArr[0] = homePageList;
        Element elementSelectFirst2 = document.selectFirst("#home-movies-post");
        HomePageList homePageList2 = elementSelectFirst2 != null ? desicinemasProvider2.toHomePageList(elementSelectFirst2, "Latest Movies") : null;
        if (!Intrinsics.areEqual(mainPageRequest2.getName(), obj)) {
            homePageList2 = null;
        }
        homePageListArr[z ? 1 : 0] = homePageList2;
        Element elementSelectFirst3 = document.selectFirst(".MovieList");
        homePageListArr[2] = Intrinsics.areEqual(mainPageRequest2.getName(), obj) ? null : elementSelectFirst3 != null ? desicinemasProvider2.toHomePageList(elementSelectFirst3, mainPageRequest2.getName()) : null;
        List listListOfNotNull = CollectionsKt.listOfNotNull(homePageListArr);
        if (Intrinsics.areEqual(mainPageRequest2.getName(), obj) || listListOfNotNull.isEmpty()) {
            z = false;
        }
        return MainAPIKt.newHomePageResponse(listListOfNotNull, Boxing.boxBoolean(z));
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList, String name) {
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("li, .TPostMv");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse homePageResult = toHomePageResult(it);
            if (homePageResult != null) {
                destination$iv$iv.add(homePageResult);
            }
        }
        return new HomePageList(name, (List) destination$iv$iv, false, 4, (DefaultConstructorMarker) null);
    }

    private final SearchResponse toHomePageResult(Element $this$toHomePageResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toHomePageResult.selectFirst("h2");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        DesicinemasProvider desicinemasProvider = this;
        Element elementSelectFirst2 = $this$toHomePageResult.selectFirst("a");
        String href = MainAPIKt.fixUrlNull(desicinemasProvider, elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null);
        if (href == null) {
            return null;
        }
        DesicinemasProvider desicinemasProvider2 = this;
        Element elementSelectFirst3 = $this$toHomePageResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(desicinemasProvider2, elementSelectFirst3 != null ? elementSelectFirst3.attr("data-src") : null);
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, (TvType) null, false, new Function1() { // from class: com.Desicinemas.DesicinemasProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return DesicinemasProvider.toHomePageResult$lambda$0(posterUrl, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toHomePageResult$lambda$0(String $posterUrl, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object search$suspendImpl(DesicinemasProvider $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        C00121 c00121;
        DesicinemasProvider $this2 = $this;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = $this2.new C00121(continuation);
            }
        } else {
            c00121 = $this2.new C00121(continuation);
        }
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = UtilsKt.getApp();
                String str = $this2.proxy + "?url=" + $this2.getMainUrl() + "/?s=" + query;
                String mainUrl = $this2.getMainUrl();
                c00121.L$0 = $this2;
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00121.label = 1;
                $result = Requests.get$default(app, str, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00121, 4090, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                $this2 = (DesicinemasProvider) c00121.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select(".MovieList li");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse homePageResult = $this2.toHomePageResult(it);
            if (homePageResult != null) {
                destination$iv$iv.add(homePageResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object load$suspendImpl(DesicinemasProvider $this, String url, Continuation<? super LoadResponse> continuation) {
        C00081 c00081;
        Object obj;
        Object obj2;
        String url2;
        DesicinemasProvider $this2;
        String strText;
        final String title;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = $this.new C00081(continuation);
            }
        } else {
            c00081 = $this.new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = UtilsKt.getApp();
                String str = $this.proxy + "?url=" + url;
                String mainUrl = $this.getMainUrl();
                c00082.L$0 = $this;
                c00082.L$1 = url;
                c00082.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, str, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c00082, 3834, (Object) null);
                c00082 = c00082;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                $this2 = $this;
                break;
                break;
            case 1:
                String url3 = (String) c00082.L$1;
                DesicinemasProvider $this3 = (DesicinemasProvider) c00082.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url3;
                $this2 = $this3;
                obj = coroutine_suspended;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) obj2).getDocument();
        Element elementSelectFirst = doc.selectFirst("h1");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        String posterUrl = MainAPIKt.fixUrlNull($this2, doc.select(".Image img").attr("src"));
        TvType tvType = TvType.Movie;
        List listListOf = CollectionsKt.listOf(MainAPIKt.newEpisode($this2, url2, new Function1() { // from class: com.Desicinemas.DesicinemasProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj3) {
                return DesicinemasProvider.load$lambda$0(title, (Episode) obj3);
            }
        }));
        C00093 c00093 = new C00093(posterUrl, doc, null);
        c00082.L$0 = SpillingKt.nullOutSpilledVariable($this2);
        c00082.L$1 = SpillingKt.nullOutSpilledVariable(url2);
        c00082.L$2 = SpillingKt.nullOutSpilledVariable(doc);
        c00082.L$3 = SpillingKt.nullOutSpilledVariable(title);
        c00082.L$4 = SpillingKt.nullOutSpilledVariable(posterUrl);
        c00082.label = 2;
        Object objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this2, title, url2, tvType, listListOf, c00093, c00082);
        return objNewTvSeriesLoadResponse == obj ? obj : objNewTvSeriesLoadResponse;
    }

    /* JADX INFO: renamed from: com.Desicinemas.DesicinemasProvider$load$3 */
    /* JADX INFO: compiled from: DesicinemasProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.DesicinemasProvider$load$3", f = "DesicinemasProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nDesicinemasProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesicinemasProvider.kt\ncom/Desicinemas/DesicinemasProvider$load$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n1739#2:84\n1814#2,3:85\n*S KotlinDebug\n*F\n+ 1 DesicinemasProvider.kt\ncom/Desicinemas/DesicinemasProvider$load$3\n*L\n57#1:84\n57#1:85,3\n*E\n"})
    static final class C00093 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Document $doc;
        final /* synthetic */ String $posterUrl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00093(String str, Document document, Continuation<? super C00093> continuation) {
            super(2, continuation);
            this.$posterUrl = str;
            this.$doc = document;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00093 = new C00093(this.$posterUrl, this.$doc, continuation);
            c00093.L$0 = obj;
            return c00093;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$posterUrl);
                    Element elementSelectFirst = this.$doc.selectFirst(".Description p");
                    $this$newTvSeriesLoadResponse.setPlot(elementSelectFirst != null ? elementSelectFirst.text() : null);
                    Iterable $this$map$iv = this.$doc.select(".Genre a");
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element it = (Element) item$iv$iv;
                        destination$iv$iv.add(it.text());
                    }
                    $this$newTvSeriesLoadResponse.setTags((List) destination$iv$iv);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    static final Unit load$lambda$0(String $title, Episode $this$newEpisode) {
        $this$newEpisode.setName($title);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object loadLinks$suspendImpl(DesicinemasProvider $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00101 c00101;
        boolean z;
        Object obj;
        C00101 c00102;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00112 c00112;
        DesicinemasProvider $this2 = $this;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = $this2.new C00101(continuation);
            }
        } else {
            c00101 = $this2.new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = UtilsKt.getApp();
                String str = $this2.proxy + "?url=" + data;
                String mainUrl = $this2.getMainUrl();
                c00101.L$0 = $this2;
                c00101.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00101.L$2 = function1;
                c00101.L$3 = function2;
                c00101.Z$0 = isCasting;
                c00101.label = 1;
                z = true;
                C00101 c00103 = c00101;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, str, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00103, 4090, (Object) null);
                c00102 = c00103;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                listSelect = ((NiceResponse) $result).getDocument().select(".MovieList .OptionBx");
                c00112 = $this2.new C00112(function3, function4, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00102.Z$0 = isCasting2;
                c00102.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00112, c00102) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00101.Z$0;
                function4 = (Function1) c00101.L$3;
                function3 = (Function1) c00101.L$2;
                data2 = (String) c00101.L$1;
                $this2 = (DesicinemasProvider) c00101.L$0;
                ResultKt.throwOnFailure($result);
                c00102 = c00101;
                obj = coroutine_suspended;
                z = true;
                listSelect = ((NiceResponse) $result).getDocument().select(".MovieList .OptionBx");
                c00112 = $this2.new C00112(function3, function4, null);
                c00102.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00102.Z$0 = isCasting2;
                c00102.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00112, c00102) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00101.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Desicinemas.DesicinemasProvider$loadLinks$2 */
    /* JADX INFO: compiled from: DesicinemasProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Desicinemas.DesicinemasProvider$loadLinks$2", f = "DesicinemasProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {76, 78}, m = "invokeSuspend", n = {"it", "name", "link", "headers", "it", "name", "link", "headers", "src", "iframe"}, nl = {77, 79}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = DesicinemasProvider.this.new C00112(this.$subtitleCallback, this.$callback, continuation);
            c00112.L$0 = obj;
            return c00112;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0121 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:15:0x0122  */
        public final Object invokeSuspend(Object $result) {
            Map headers;
            Object obj;
            String link;
            String name;
            String iframe;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String name2 = it.select("p.AAIco-dns").text();
                    String link2 = it.select("a").attr("href");
                    headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"), TuplesKt.to("Accept-Language", "en-US,en;q=0.5"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Cache-Control", "no-cache")});
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = name2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.label = 1;
                    obj = Requests.get$default(UtilsKt.getApp(), link2, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4092, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    link = link2;
                    name = name2;
                    Document src = ((NiceResponse) obj).getDocument();
                    iframe = src.select("iframe").attr("src");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(name);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(iframe);
                    this.label = 2;
                    if (UtilsKt.loadSourceNameExtractor$default(name, iframe, DesicinemasProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    Map headers2 = (Map) this.L$3;
                    link = (String) this.L$2;
                    String name3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    headers = headers2;
                    obj = $result;
                    name = name3;
                    Document src2 = ((NiceResponse) obj).getDocument();
                    iframe = src2.select("iframe").attr("src");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(name);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(src2);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(iframe);
                    this.label = 2;
                    if (UtilsKt.loadSourceNameExtractor$default(name, iframe, DesicinemasProvider.this.getMainUrl(), this.$subtitleCallback, this.$callback, null, null, (Continuation) this, 96, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
