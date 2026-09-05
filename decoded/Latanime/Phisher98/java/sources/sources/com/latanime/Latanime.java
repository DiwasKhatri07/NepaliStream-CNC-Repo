package com.latanime;

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
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: Latanime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Latanime/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u0004\u0018\u00010\u0005*\u00020*H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006<"}, d2 = {"Lcom/latanime/Latanime;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageAttr", "Latanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLatanime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Latanime.kt\ncom/latanime/Latanime\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1795#2,10:134\n2068#2:144\n2069#2:146\n1805#2:147\n1795#2,10:148\n2068#2:158\n2069#2:160\n1805#2:161\n1739#2:162\n1814#2,3:163\n1739#2:166\n1814#2,3:167\n1#3:145\n1#3:159\n1#3:170\n*S KotlinDebug\n*F\n+ 1 Latanime.kt\ncom/latanime/Latanime\n*L\n47#1:134,10\n47#1:144\n47#1:146\n47#1:147\n71#1:148,10\n71#1:158\n71#1:160\n71#1:161\n79#1:162\n79#1:163,3\n84#1:166\n84#1:167,3\n47#1:145\n71#1:159\n*E\n"})
public final class Latanime extends MainAPI {

    @NotNull
    private String mainUrl = "https://latanime.org";

    @NotNull
    private String name = "Latanime";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "es-mx";
    private final boolean hasDownloadSupport = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("animes?fecha=false&genero=false&letra=false&categoria=anime", "Anime"), TuplesKt.to("animes?fecha=false&genero=false&letra=false&categoria=Película", "Película"), TuplesKt.to("animes?fecha=false&genero=false&letra=false&categoria=especial", "Especial"), TuplesKt.to("animes?fecha=false&genero=false&letra=false&categoria=donghua", "Donghua")});

    /* JADX INFO: renamed from: com.latanime.Latanime$getMainPage$1 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime", f = "Latanime.kt", i = {0, 0}, l = {46}, m = "getMainPage", n = {"request", "page"}, nl = {47}, s = {"L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Latanime.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.latanime.Latanime$load$1 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime", f = "Latanime.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {75, 93, 100}, m = "load", n = {"url", "url", "document", "title", "poster", "description", "tags", "year", "epsAnchor", "episodes", "url", "document", "title", "poster", "description", "tags", "year", "epsAnchor"}, nl = {76, 100, 83}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Latanime.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.latanime.Latanime$loadLinks$1 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime", f = "Latanime.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {115, 116}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {116, 125}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return Latanime.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.latanime.Latanime$search$1 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime", f = "Latanime.kt", i = {0}, l = {70}, m = "search", n = {"query"}, nl = {71}, s = {"L$0"}, v = 2)
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
            return Latanime.this.search(null, (Continuation) this);
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

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
        int page2 = page;
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
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "&p=" + page2;
                c00001.L$0 = request;
                c00001.I$0 = page2;
                c00001.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.row a");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("h3").text();
        String href = $this$toSearchResult.attr("href");
        Latanime latanime = this;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(latanime, elementSelectFirst != null ? getImageAttr(elementSelectFirst) : null);
        final boolean isDub = StringsKt.contains$default(title, "Latino", false, 2, (Object) null) || StringsKt.contains$default(title, "Castellano", false, 2, (Object) null);
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, TvType.Anime, false, new Function1() { // from class: com.latanime.Latanime$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Latanime.toSearchResult$lambda$0(posterUrl, isDub, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, boolean $isDub, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        MainAPIKt.addDubStatus$default($this$newAnimeSearchResponse, $isDub, (Integer) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/buscar?q=" + query;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.row a");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:29:0x0104  */
    /* JADX WARN: Code duplicated, block: B:32:0x010e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0114  */
    /* JADX WARN: Code duplicated, block: B:37:0x0137 A[LOOP:0: B:35:0x0131->B:37:0x0137, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x0175  */
    /* JADX WARN: Code duplicated, block: B:43:0x0192 A[LOOP:1: B:41:0x018c->B:43:0x0192, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:46:0x0240 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0241  */
    /* JADX WARN: Code duplicated, block: B:49:0x024f  */
    /* JADX WARN: Code duplicated, block: B:51:0x029f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        int i;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String strText;
        String title;
        Element elementSelectFirst2;
        String string;
        String poster;
        Element elementSelectFirst3;
        String description;
        Collection destination$iv$iv;
        List tags;
        Integer year;
        Elements epsAnchor;
        Object objNewMovieLoadResponse;
        Elements epsAnchor2;
        String title2;
        String url3;
        Document document2;
        String poster2;
        String description2;
        List tags2;
        Integer year2;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        Object objNewAnimeLoadResponse$default;
        String strAttr;
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
                i = 1;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h2");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = "Desconocido";
                }
                title = strText;
                elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("content")) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strAttr).toString();
                }
                poster = string;
                elementSelectFirst3 = document.selectFirst("h2 ~ p.my-2");
                if (elementSelectFirst3 != null) {
                    description = elementSelectFirst3.text();
                } else {
                    description = null;
                }
                Iterable $this$map$iv2 = document.select("a div.btn");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                year = StringsKt.toIntOrNull(StringsKt.substringAfterLast$default(document.select(".span-tiempo").text(), " de ", (String) null, 2, (Object) null));
                epsAnchor = document.select("div.row a[href*='/ver/']");
                if (epsAnchor.size() > i) {
                    TvType tvType = TvType.AnimeMovie;
                    String strAttr2 = epsAnchor.attr("href");
                    C00033 c00033 = new C00033(poster, description, tags, year, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(tags);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(epsAnchor);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, strAttr2, c00033, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    epsAnchor2 = epsAnchor;
                    title2 = title;
                    url3 = url2;
                    document2 = document;
                    poster2 = poster;
                    description2 = description;
                    tags2 = tags;
                    year2 = year;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                $this$map$iv = (Iterable) epsAnchor;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv2 : $this$map$iv) {
                    Element it = (Element) item$iv$iv2;
                    Iterable $this$map$iv3 = $this$map$iv;
                    Object $result2 = $result;
                    final String epPoster = it.select("img").attr("data-src");
                    String epHref = it.attr("href");
                    destination$iv$iv2.add(MainAPIKt.newEpisode(this, epHref, new Function1() { // from class: com.latanime.Latanime$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Latanime.load$lambda$1$0(epPoster, (Episode) obj3);
                        }
                    }));
                    $this$map$iv = $this$map$iv3;
                    $result = $result2;
                    epsAnchor = epsAnchor;
                    title = title;
                }
                List episodes = (List) destination$iv$iv2;
                TvType tvType2 = TvType.Anime;
                String description3 = description;
                C00022 c00022 = new C00022(episodes, poster, description3, tags, year, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description3);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tags);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(year);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(epsAnchor);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 2;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title, url2, tvType2, false, c00022, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 1:
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url4;
                i = 1;
                obj2 = $result;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h2");
                if (elementSelectFirst != null) {
                    strText = "Desconocido";
                } else {
                    strText = "Desconocido";
                }
                title = strText;
                elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
                if (elementSelectFirst2 != null) {
                    string = null;
                } else {
                    string = null;
                }
                poster = string;
                elementSelectFirst3 = document.selectFirst("h2 ~ p.my-2");
                if (elementSelectFirst3 != null) {
                    description = elementSelectFirst3.text();
                } else {
                    description = null;
                }
                Iterable $this$map$iv4 = document.select("a div.btn");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r16.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                tags = (List) destination$iv$iv;
                year = StringsKt.toIntOrNull(StringsKt.substringAfterLast$default(document.select(".span-tiempo").text(), " de ", (String) null, 2, (Object) null));
                epsAnchor = document.select("div.row a[href*='/ver/']");
                if (epsAnchor.size() > i) {
                    TvType tvType3 = TvType.AnimeMovie;
                    String strAttr3 = epsAnchor.attr("href");
                    C00033 c00034 = new C00033(poster, description, tags, year, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(tags);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(epsAnchor);
                    c00012.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType3, strAttr3, c00034, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    epsAnchor2 = epsAnchor;
                    title2 = title;
                    url3 = url2;
                    document2 = document;
                    poster2 = poster;
                    description2 = description;
                    tags2 = tags;
                    year2 = year;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                $this$map$iv = (Iterable) epsAnchor;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r18.hasNext()) {
                    Element it2 = (Element) item$iv$iv2;
                    Iterable $this$map$iv5 = $this$map$iv;
                    Object $result3 = $result;
                    final String epPoster2 = it2.select("img").attr("data-src");
                    String epHref2 = it2.attr("href");
                    destination$iv$iv2.add(MainAPIKt.newEpisode(this, epHref2, new Function1() { // from class: com.latanime.Latanime$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Latanime.load$lambda$1$0(epPoster2, (Episode) obj3);
                        }
                    }));
                    $this$map$iv = $this$map$iv5;
                    $result = $result3;
                    epsAnchor = epsAnchor;
                    title = title;
                }
                List episodes2 = (List) destination$iv$iv2;
                TvType tvType4 = TvType.Anime;
                String description4 = description;
                C00022 c00023 = new C00022(episodes2, poster, description4, tags, year, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tags);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(year);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(epsAnchor);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00012.label = 2;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title, url2, tvType4, false, c00023, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj) {
                    return obj;
                }
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewAnimeLoadResponse$default = $result;
                return (LoadResponse) objNewAnimeLoadResponse$default;
            case 3:
                epsAnchor2 = (Elements) c00012.L$7;
                year2 = (Integer) c00012.L$6;
                tags2 = (List) c00012.L$5;
                description2 = (String) c00012.L$4;
                poster2 = (String) c00012.L$3;
                title2 = (String) c00012.L$2;
                document2 = (Document) c00012.L$1;
                url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0(String $epPoster, Episode $this$newEpisode) {
        $this$newEpisode.setPosterUrl($epPoster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.latanime.Latanime$load$2 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime$load$2", f = "Latanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(List<Episode> list, String str, String str2, List<String> list2, Integer num, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.$poster = str;
            this.$description = str2;
            this.$tags = list2;
            this.$year = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$episodes, this.$poster, this.$description, this.$tags, this.$year, continuation);
            c00022.L$0 = obj;
            return c00022;
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
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, this.$episodes);
                    $this$newAnimeLoadResponse.setPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setPlot(this.$description);
                    $this$newAnimeLoadResponse.setTags(this.$tags);
                    $this$newAnimeLoadResponse.setYear(this.$year);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.latanime.Latanime$load$3 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime$load$3", f = "Latanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, String str2, List<String> list, Integer num, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$tags = list;
            this.$year = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$description, this.$tags, this.$year, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object obj;
        boolean z;
        C00041 c00042;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00052 c00052;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                C00041 c00043 = c00041;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4094, (Object) null);
                c00042 = c00043;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select("#play-video a");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00041.Z$0;
                function4 = (Function1) c00041.L$2;
                function3 = (Function1) c00041.L$1;
                data2 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00042 = c00041;
                obj = coroutine_suspended;
                z = true;
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select("#play-video a");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.latanime.Latanime$loadLinks$2 */
    /* JADX INFO: compiled from: Latanime.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.latanime.Latanime$loadLinks$2", f = "Latanime.kt", i = {0, 0}, l = {118}, m = "invokeSuspend", n = {"it", "href"}, nl = {123}, s = {"L$0", "L$1"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String href = StringsKt.substringAfter$default(MainAPIKt.base64Decode(it.attr("data-player")), "=", (String) null, 2, (Object) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(href, "", this.$subtitleCallback, this.$callback, (Continuation) this);
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

    private final String getImageAttr(Element $this$getImageAttr) {
        String it = $this$getImageAttr.attr("data-src");
        if (!(!StringsKt.isBlank(it) && StringsKt.startsWith$default(it, "http", false, 2, (Object) null))) {
            it = null;
        }
        if (it != null) {
            return it;
        }
        String it2 = $this$getImageAttr.attr("src");
        if (!StringsKt.isBlank(it2) && StringsKt.startsWith$default(it2, "http", false, 2, (Object) null)) {
            return it2;
        }
        return null;
    }
}
