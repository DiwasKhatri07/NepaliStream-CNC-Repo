package com.Topstreamfilm;

import com.lagradost.cloudstream3.Episode;
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

/* JADX INFO: compiled from: Topstreamfilm.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Topstreamfilm/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u001c2\u0006\u0010:\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006;"}, d2 = {"Lcom/Topstreamfilm/TopStreamFilm;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractUrlsWithMapNotNull", "text", "Topstreamfilm"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTopstreamfilm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Topstreamfilm.kt\ncom/Topstreamfilm/TopStreamFilm\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1795#2,10:142\n2068#2:152\n2069#2:154\n1805#2:155\n1795#2,10:156\n2068#2:166\n2069#2:168\n1805#2:169\n1739#2:170\n1814#2,3:171\n1795#2,10:174\n2068#2:184\n2069#2:186\n1805#2:187\n1#3:153\n1#3:167\n1#3:185\n*S KotlinDebug\n*F\n+ 1 Topstreamfilm.kt\ncom/Topstreamfilm/TopStreamFilm\n*L\n33#1:142,10\n33#1:152\n33#1:154\n33#1:155\n54#1:156,10\n54#1:166\n54#1:168\n54#1:169\n65#1:170\n65#1:171,3\n135#1:174,10\n135#1:184\n135#1:186\n135#1:187\n33#1:153\n54#1:167\n135#1:185\n*E\n"})
public final class TopStreamFilm extends MainAPI {

    @NotNull
    private String mainUrl = "https://www.topstreamfilm.live";

    @NotNull
    private String name = "TopStreamFilm";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "de";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Home"), TuplesKt.to("serien", "Series"), TuplesKt.to("filme-online-sehen", "Movies/Series")});

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$getMainPage$1 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm", f = "Topstreamfilm.kt", i = {0, 0, 0}, l = {32}, m = "getMainPage", n = {"request", "url", "page"}, nl = {33}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return TopStreamFilm.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$load$1 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm", f = "Topstreamfilm.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {60, 72, 88, 96}, m = "load", n = {"url", "url", "document", "title", "plot", "poster", "year", "tags", "rating", "checkSeason", "type", "episodes", "url", "document", "title", "plot", "poster", "year", "tags", "rating", "checkSeason", "type", "episodes", "url", "document", "title", "plot", "poster", "year", "tags", "rating", "checkSeason", "type"}, nl = {61, 88, 96, 69}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TopStreamFilm.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$loadLinks$1 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm", f = "Topstreamfilm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {115, 121, 122, 122}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "urls", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "iframe", "isCasting", "data", "subtitleCallback", "callback", "iframe", "isCasting"}, nl = {121, 122, 122, 127}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TopStreamFilm.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$search$1 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm", f = "Topstreamfilm.kt", i = {0}, l = {53}, m = "search", n = {"query"}, nl = {54}, s = {"L$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TopStreamFilm.this.search(null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        MainPageRequest request2;
        int page2 = page;
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
                String url = getMainUrl() + '/' + request.getData() + "/page/" + page2;
                Requests app = MainActivityKt.getApp();
                c00021.L$0 = request;
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00021.I$0 = page2;
                c00021.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00021.I$0;
                request2 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
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
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        Element elementSelectFirst;
        String href;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("h3");
        if (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null || (title = StringsKt.trim(strText).toString()) == null || (elementSelectFirst = $this$toSearchResult.selectFirst("a")) == null || (href = elementSelectFirst.attr("href")) == null) {
            return null;
        }
        TopStreamFilm topStreamFilm = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("a img");
        final String posterUrl = MainAPIKt.fixUrlNull(topStreamFilm, elementSelectFirst3 != null ? elementSelectFirst3.attr("data-src") : null);
        final SearchQuality quality = MainAPIKt.getQualityFromString($this$toSearchResult.select("span.Qlty").text());
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Topstreamfilm.TopStreamFilm$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return TopStreamFilm.toSearchResult$lambda$0(posterUrl, quality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, SearchQuality $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00101 c00101;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?story=" + query + "&do=search&subaction=search";
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00101.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4094, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("article");
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

    /* JADX WARN: Code duplicated, block: B:51:0x0263 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0264  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00031 c00031;
        Object obj;
        Object obj2;
        String url2;
        Element elementSelectFirst;
        String title;
        String plot;
        String checkSeason;
        Document document;
        List tags;
        String url3;
        List episodes;
        String title2;
        Integer year;
        TvType type;
        String plot2;
        String strText;
        Object objNewTvSeriesLoadResponse;
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
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00032.L$0 = url;
                c00032.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                c00032 = c00032;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                Document document2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document2.selectFirst("h1.Title");
                if (elementSelectFirst == null && (title = elementSelectFirst.text()) != null) {
                    plot = document2.select("div.Description p:nth-child(2)").text();
                    String poster = MainAPIKt.fixUrlNull(this, document2.select("article div.TPostBg img.TPostBg").attr("data-src"));
                    Element elementSelectFirst2 = document2.selectFirst("span.Date.AAIco-date_range");
                    Integer year2 = (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null) ? null : StringsKt.toIntOrNull(strText);
                    Iterable $this$map$iv = document2.select("ul li.AAIco-adjust:contains(Genre) a");
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element it = (Element) item$iv$iv;
                        destination$iv$iv.add(it.text());
                    }
                    List tags2 = (List) destination$iv$iv;
                    String rating = document2.select("ul li.AAIco-adjust:contains(Rating) span").text();
                    Element elementSelectFirst3 = document2.selectFirst("div.tt_season");
                    checkSeason = elementSelectFirst3 != null ? elementSelectFirst3.text() : null;
                    TvType type2 = checkSeason != null ? TvType.TvSeries : TvType.Movie;
                    if (type2 != TvType.TvSeries) {
                        TvType tvType = TvType.Movie;
                        C00064 c00064 = new C00064(tags2, year2, rating, poster, plot, null);
                        c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00032.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(title);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(plot);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(year2);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags2);
                        c00032.L$7 = SpillingKt.nullOutSpilledVariable(rating);
                        c00032.L$8 = SpillingKt.nullOutSpilledVariable(checkSeason);
                        c00032.L$9 = SpillingKt.nullOutSpilledVariable(type2);
                        c00032.label = 4;
                        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, url2, c00064, c00032);
                        return objNewMovieLoadResponse == obj ? obj : objNewMovieLoadResponse;
                    }
                    List episodes2 = new ArrayList();
                    List listSelect = document2.select("div.su-accordion div.cu-ss");
                    C00042 c00042 = new C00042(episodes2, this, null);
                    c00032.L$0 = url2;
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00032.L$2 = title;
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(plot);
                    c00032.L$4 = poster;
                    c00032.L$5 = year2;
                    c00032.L$6 = tags2;
                    c00032.L$7 = rating;
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(checkSeason);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(type2);
                    c00032.L$10 = episodes2;
                    c00032.label = 2;
                    if (ParCollectionsKt.amap(listSelect, c00042, c00032) == obj) {
                        return obj;
                    }
                    document = document2;
                    tags = tags2;
                    url3 = rating;
                    episodes = episodes2;
                    title2 = title;
                    year = year2;
                    type = type2;
                    plot2 = poster;
                    TvType tvType2 = TvType.TvSeries;
                    C00053 c00053 = new C00053(plot2, year, tags, url3, null);
                    c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00032.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00032.L$3 = SpillingKt.nullOutSpilledVariable(plot);
                    c00032.L$4 = SpillingKt.nullOutSpilledVariable(plot2);
                    c00032.L$5 = SpillingKt.nullOutSpilledVariable(year);
                    c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                    c00032.L$7 = SpillingKt.nullOutSpilledVariable(url3);
                    c00032.L$8 = SpillingKt.nullOutSpilledVariable(checkSeason);
                    c00032.L$9 = SpillingKt.nullOutSpilledVariable(type);
                    c00032.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00032.label = 3;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url2, tvType2, episodes, c00053, c00032);
                    if (objNewTvSeriesLoadResponse == obj) {
                        return obj;
                    }
                    return (LoadResponse) objNewTvSeriesLoadResponse;
                }
            case 1:
                String url4 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url4;
                obj2 = $result;
                Document document3 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document3.selectFirst("h1.Title");
                return elementSelectFirst == null ? null : null;
            case 2:
                List episodes3 = (List) c00032.L$10;
                TvType type3 = (TvType) c00032.L$9;
                String checkSeason2 = (String) c00032.L$8;
                String rating2 = (String) c00032.L$7;
                List tags3 = (List) c00032.L$6;
                Integer year3 = (Integer) c00032.L$5;
                String poster2 = (String) c00032.L$4;
                String plot3 = (String) c00032.L$3;
                String title3 = (String) c00032.L$2;
                Document document4 = (Document) c00032.L$1;
                String url5 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                episodes = episodes3;
                title2 = title3;
                year = year3;
                type = type3;
                url2 = url5;
                url3 = rating2;
                obj = coroutine_suspended;
                checkSeason = checkSeason2;
                plot = plot3;
                document = document4;
                tags = tags3;
                plot2 = poster2;
                TvType tvType3 = TvType.TvSeries;
                C00053 c00054 = new C00053(plot2, year, tags, url3, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(plot);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(plot2);
                c00032.L$5 = SpillingKt.nullOutSpilledVariable(year);
                c00032.L$6 = SpillingKt.nullOutSpilledVariable(tags);
                c00032.L$7 = SpillingKt.nullOutSpilledVariable(url3);
                c00032.L$8 = SpillingKt.nullOutSpilledVariable(checkSeason);
                c00032.L$9 = SpillingKt.nullOutSpilledVariable(type);
                c00032.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                c00032.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url2, tvType3, episodes, c00054, c00032);
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
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$load$2 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm$load$2", f = "Topstreamfilm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nTopstreamfilm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Topstreamfilm.kt\ncom/Topstreamfilm/TopStreamFilm$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,141:1\n1739#2:142\n1814#2,3:143\n*S KotlinDebug\n*F\n+ 1 Topstreamfilm.kt\ncom/Topstreamfilm/TopStreamFilm$load$2\n*L\n74#1:142\n74#1:143,3\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function2<Element, Continuation<? super String>, Object> {
        final /* synthetic */ List<Episode> $episodes;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TopStreamFilm this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(List<Episode> list, TopStreamFilm topStreamFilm, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.this$0 = topStreamFilm;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$episodes, this.this$0, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(Element element, Continuation<? super String> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element it = (Element) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final String name = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(it.text(), " ", (String) null, 2, (Object) null), " – ", (String) null, 2, (Object) null)).toString();
                    Iterable $this$map$iv = it.select("a");
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        destination$iv$iv.add(((Element) item$iv$iv).attr("href"));
                    }
                    String href = ((List) destination$iv$iv).toString();
                    final Integer ep = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfter$default(name, "Episode", (String) null, 2, (Object) null)).toString());
                    final Integer season = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(it.text(), "x", (String) null, 2, (Object) null)).toString());
                    return AppUtils.INSTANCE.toJson(Boxing.boxBoolean(this.$episodes.add(MainAPIKt.newEpisode(this.this$0, href, new Function1() { // from class: com.Topstreamfilm.TopStreamFilm$load$2$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return TopStreamFilm.C00042.invokeSuspend$lambda$1(ep, name, season, (Episode) obj);
                        }
                    }))));
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final Unit invokeSuspend$lambda$1(Integer $ep, String $name, Integer $season, Episode $this$newEpisode) {
            $this$newEpisode.setEpisode($ep);
            $this$newEpisode.setName($name);
            $this$newEpisode.setSeason($season);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$load$3 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm$load$3", f = "Topstreamfilm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, Integer num, List<String> list, String str2, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$tags = list;
            this.$rating = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$poster, this.$year, this.$tags, this.$rating, continuation);
            c00053.L$0 = obj;
            return c00053;
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
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$load$4 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm$load$4", f = "Topstreamfilm.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00064 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(List<String> list, Integer num, String str, String str2, String str3, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$tags = list;
            this.$year = num;
            this.$rating = str;
            this.$poster = str2;
            this.$plot = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = new C00064(this.$tags, this.$year, this.$rating, this.$poster, this.$plot, continuation);
            c00064.L$0 = obj;
            return c00064;
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
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$plot);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x01b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:32:0x01f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00071 c00071;
        boolean z;
        Continuation continuation2;
        Object obj;
        C00071 c00072;
        Function1<? super ExtractorLink, Unit> function3;
        Object obj2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function4;
        String data2;
        Object objAmap;
        String iframe;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        Object obj3;
        C00071 c00073;
        String data3;
        String iframe2;
        Function1<? super SubtitleFile, Unit> function7;
        Object obj4;
        Function1<? super ExtractorLink, Unit> function8;
        Object objAmap2;
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
                if (StringsKt.startsWith$default(data, "[", false, 2, (Object) null)) {
                    List<String> listExtractUrlsWithMapNotNull = extractUrlsWithMapNotNull(data);
                    C00082 c00082 = new C00082(function1, function2, null);
                    c00071.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00071.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00071.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00071.L$3 = SpillingKt.nullOutSpilledVariable(listExtractUrlsWithMapNotNull);
                    c00071.Z$0 = isCasting;
                    c00071.label = 1;
                    objAmap = ParCollectionsKt.amap(listExtractUrlsWithMapNotNull, c00082, c00071);
                    if (objAmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = true;
                    return Boxing.boxBoolean(z);
                }
                Requests app = MainActivityKt.getApp();
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00071.L$1 = function1;
                c00071.L$2 = function2;
                c00071.Z$0 = isCasting;
                c00071.label = 2;
                z = true;
                continuation2 = null;
                C00071 c00074 = c00071;
                obj = coroutine_suspended;
                Object obj5 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00074, 4094, (Object) null);
                c00072 = c00074;
                if (obj5 == obj) {
                    return obj;
                }
                function3 = function2;
                obj2 = obj5;
                isCasting2 = isCasting;
                function4 = function1;
                data2 = data;
                iframe = ((NiceResponse) obj2).getDocument().select("div.TPlayer iframe").attr("src");
                Requests app2 = MainActivityKt.getApp();
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00072.L$1 = function4;
                c00072.L$2 = function3;
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(iframe);
                c00072.Z$0 = isCasting2;
                c00072.label = 3;
                function5 = function3;
                C00071 c00075 = c00072;
                function6 = function4;
                obj3 = Requests.get$default(app2, iframe, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00075, 4094, (Object) null);
                c00073 = c00075;
                if (obj3 == obj) {
                    return obj;
                }
                data3 = data2;
                iframe2 = iframe;
                function7 = function6;
                obj4 = obj3;
                function8 = function5;
                List listSelect = ((NiceResponse) obj4).getDocument().select("ul li");
                C00093 c00093 = new C00093(function7, function8, continuation2);
                c00073.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00073.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                c00073.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00073.L$3 = SpillingKt.nullOutSpilledVariable(iframe2);
                c00073.Z$0 = isCasting2;
                c00073.label = 4;
                objAmap2 = ParCollectionsKt.amap(listSelect, c00093, c00073);
                if (objAmap2 == obj) {
                    return obj;
                }
                $result = objAmap2;
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00071.Z$0;
                ResultKt.throwOnFailure($result);
                objAmap = $result;
                z = true;
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting4 = c00071.Z$0;
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00071.L$2;
                Function1<? super SubtitleFile, Unit> function10 = (Function1) c00071.L$1;
                String data4 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                c00072 = c00071;
                obj = coroutine_suspended;
                obj2 = $result;
                z = true;
                function4 = function10;
                data2 = data4;
                function3 = function9;
                isCasting2 = isCasting4;
                continuation2 = null;
                iframe = ((NiceResponse) obj2).getDocument().select("div.TPlayer iframe").attr("src");
                Requests app3 = MainActivityKt.getApp();
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00072.L$1 = function4;
                c00072.L$2 = function3;
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(iframe);
                c00072.Z$0 = isCasting2;
                c00072.label = 3;
                function5 = function3;
                C00071 c00076 = c00072;
                function6 = function4;
                obj3 = Requests.get$default(app3, iframe, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00076, 4094, (Object) null);
                c00073 = c00076;
                if (obj3 == obj) {
                    return obj;
                }
                data3 = data2;
                iframe2 = iframe;
                function7 = function6;
                obj4 = obj3;
                function8 = function5;
                List listSelect2 = ((NiceResponse) obj4).getDocument().select("ul li");
                C00093 c00094 = new C00093(function7, function8, continuation2);
                c00073.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00073.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                c00073.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00073.L$3 = SpillingKt.nullOutSpilledVariable(iframe2);
                c00073.Z$0 = isCasting2;
                c00073.label = 4;
                objAmap2 = ParCollectionsKt.amap(listSelect2, c00094, c00073);
                if (objAmap2 == obj) {
                    return obj;
                }
                $result = objAmap2;
                return Boxing.boxBoolean(z);
            case 3:
                boolean isCasting5 = c00071.Z$0;
                String iframe3 = (String) c00071.L$3;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00071.L$2;
                function7 = (Function1) c00071.L$1;
                data3 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                iframe2 = iframe3;
                z = true;
                function8 = function11;
                c00073 = c00071;
                obj = coroutine_suspended;
                isCasting2 = isCasting5;
                obj4 = $result;
                continuation2 = null;
                List listSelect3 = ((NiceResponse) obj4).getDocument().select("ul li");
                C00093 c00095 = new C00093(function7, function8, continuation2);
                c00073.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00073.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                c00073.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00073.L$3 = SpillingKt.nullOutSpilledVariable(iframe2);
                c00073.Z$0 = isCasting2;
                c00073.label = 4;
                objAmap2 = ParCollectionsKt.amap(listSelect3, c00095, c00073);
                if (objAmap2 == obj) {
                    return obj;
                }
                $result = objAmap2;
                return Boxing.boxBoolean(z);
            case 4:
                boolean z2 = c00071.Z$0;
                String data5 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                data3 = data5;
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$loadLinks$2 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm$loadLinks$2", f = "Topstreamfilm.kt", i = {0}, l = {116}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00082 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = new C00082(this.$subtitleCallback, this.$callback, continuation);
            c00082.L$0 = obj;
            return c00082;
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

    /* JADX INFO: renamed from: com.Topstreamfilm.TopStreamFilm$loadLinks$3 */
    /* JADX INFO: compiled from: Topstreamfilm.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Topstreamfilm.TopStreamFilm$loadLinks$3", f = "Topstreamfilm.kt", i = {0, 0}, l = {124}, m = "invokeSuspend", n = {"it", "href"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
    static final class C00093 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00093(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00093> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00093 = new C00093(this.$subtitleCallback, this.$callback, continuation);
            c00093.L$0 = obj;
            return c00093;
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
                    String href = ExtractorApiKt.httpsify(it.attr("data-link"));
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(href, this.$subtitleCallback, this.$callback, (Continuation) this);
                    return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @NotNull
    public final List<String> extractUrlsWithMapNotNull(@NotNull String text) {
        Iterable $this$mapNotNull$iv = StringsKt.split$default(StringsKt.removeSurrounding(text, "[", "]"), new String[]{","}, false, 0, 6, (Object) null);
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String part = (String) element$iv$iv$iv;
            String url = StringsKt.trim(part).toString();
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            int $i$f$mapNotNull2 = $i$f$mapNotNull;
            if (!StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "https://", false, 2, (Object) null)) {
                url = null;
            }
            if (url != null) {
                destination$iv$iv.add(url);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
            $i$f$mapNotNull = $i$f$mapNotNull2;
        }
        return (List) destination$iv$iv;
    }
}
