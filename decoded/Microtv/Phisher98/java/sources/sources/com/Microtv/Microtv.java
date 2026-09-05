package com.Microtv;

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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URLEncoder;
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

/* JADX INFO: compiled from: Microtv.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Microtv/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\f\u0010;\u001a\u00020\u0005*\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"Lcom/Microtv/Microtv;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encodeUri", "Microtv"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMicrotv.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Microtv.kt\ncom/Microtv/Microtv\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1795#2,10:104\n2068#2:114\n2069#2:116\n1805#2:117\n1960#2,3:118\n1795#2,10:121\n2068#2:131\n2069#2:133\n1805#2:134\n1#3:115\n1#3:132\n*S KotlinDebug\n*F\n+ 1 Microtv.kt\ncom/Microtv/Microtv\n*L\n27#1:104,10\n27#1:114\n27#1:116\n27#1:117\n29#1:118,3\n62#1:121,10\n62#1:131\n62#1:133\n62#1:134\n27#1:115\n62#1:132\n*E\n"})
public final class Microtv extends MainAPI {

    @NotNull
    private String mainUrl = "https://new.microtv.st";

    @NotNull
    private String name = "Microtv";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Latest Dramas")});

    /* JADX INFO: renamed from: com.Microtv.Microtv$getMainPage$1 */
    /* JADX INFO: compiled from: Microtv.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Microtv", f = "Microtv.kt", i = {0, 0, 0}, l = {25}, m = "getMainPage", n = {"request", "url", "page"}, nl = {26}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return Microtv.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Microtv.Microtv$load$1 */
    /* JADX INFO: compiled from: Microtv.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Microtv", f = "Microtv.kt", i = {0, 1, 1, 1, 1}, l = {68, 75}, m = "load", n = {"url", "url", "document", "title", "poster"}, nl = {69, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Microtv.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Microtv.Microtv$loadLinks$1 */
    /* JADX INFO: compiled from: Microtv.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Microtv", f = "Microtv.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {86, 90, 95}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "iframeSrc", "isCasting", "data", "subtitleCallback", "callback", "document", "iframeSrc", "downloadHref", "isCasting"}, nl = {88, 93, 98}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Microtv.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Microtv.Microtv$search$1 */
    /* JADX INFO: compiled from: Microtv.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Microtv", f = "Microtv.kt", i = {0, 0, 0}, l = {60}, m = "search", n = {"query", "url", "page"}, nl = {61}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Microtv.this.search(null, 0, (Continuation) this);
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
        C00051 c00051;
        MainPageRequest request2;
        boolean hasNext;
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
                String url = page == 1 ? StringsKt.trimEnd(getMainUrl() + '/' + request.getData(), new char[]{'/'}) : StringsKt.trimEnd(getMainUrl() + '/' + request.getData() + "?page=" + page, new char[]{'?'});
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = request;
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00051.I$0 = page;
                c00051.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00051.I$0;
                request2 = (MainPageRequest) c00051.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.post-grid div.post-card");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            SearchResponse searchResult = toSearchResult((Element) element$iv$iv$iv);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        Iterable $this$any$iv = document.select("div.pagination a");
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            hasNext = false;
        } else {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    Element it2 = (Element) element$iv;
                    if (StringsKt.contains(it2.text(), "Next", true) || StringsKt.contains$default(it2.text(), "»", false, 2, (Object) null)) {
                        hasNext = true;
                    }
                } else {
                    hasNext = false;
                }
            }
        }
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(hasNext));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Element elementSelectFirst;
        String strText;
        String title;
        Element anchor = $this$toSearchResult.selectFirst("a");
        if (anchor == null || (elementSelectFirst = $this$toSearchResult.selectFirst("h3")) == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        String href = MainAPIKt.fixUrl(this, anchor.attr("href"));
        Microtv microtv = this;
        Element elementSelectFirst2 = anchor.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(microtv, elementSelectFirst2 != null ? elementSelectFirst2.attr("src") : null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Microtv.Microtv$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Microtv.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00091 c00091;
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
        Object $result = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = page == 1 ? getMainUrl() + "/?search=" + encodeUri(query) : getMainUrl() + "/?search=" + encodeUri(query) + "&page=" + page;
                Requests app = MainActivityKt.getApp();
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00091.I$0 = page;
                c00091.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00091, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00091.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.post-grid div.post-card");
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
        C00061 c00061;
        Object obj;
        Object obj2;
        String url2;
        String title;
        String strAttr;
        String strAttr2;
        String strText;
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
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00062.L$0 = url;
                c00062.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4094, (Object) null);
                c00062 = c00062;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00062.L$0;
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
        Element elementSelectFirst = document.selectFirst("h1");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            Element elementSelectFirst2 = document.selectFirst("meta[property=og:title]");
            title = (elementSelectFirst2 == null || (strAttr = elementSelectFirst2.attr("content")) == null) ? "Unknown" : StringsKt.trim(strAttr).toString();
        }
        Element elementSelectFirst3 = document.selectFirst("img.featured-poster");
        if (elementSelectFirst3 == null || (strAttr2 = elementSelectFirst3.attr("src")) == null) {
            Element elementSelectFirst4 = document.selectFirst("meta[property=og:image]");
            strAttr2 = elementSelectFirst4 != null ? elementSelectFirst4.attr("content") : null;
        }
        String poster = strAttr2;
        String title2 = title;
        TvType tvType = TvType.Movie;
        C00072 c00072 = new C00072(poster, null);
        c00062.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00062.L$1 = SpillingKt.nullOutSpilledVariable(document);
        c00062.L$2 = SpillingKt.nullOutSpilledVariable(title2);
        c00062.L$3 = SpillingKt.nullOutSpilledVariable(poster);
        c00062.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url2, tvType, url2, c00072, c00062);
        if (objNewMovieLoadResponse == obj) {
            return obj;
        }
        return objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.Microtv.Microtv$load$2 */
    /* JADX INFO: compiled from: Microtv.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Microtv.Microtv$load$2", f = "Microtv.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$poster = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$poster, continuation);
            c00072.L$0 = obj;
            return c00072;
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
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0112  */
    /* JADX WARN: Code duplicated, block: B:31:0x0122  */
    /* JADX WARN: Code duplicated, block: B:33:0x0125  */
    /* JADX WARN: Code duplicated, block: B:35:0x013e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x013f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0145  */
    /* JADX WARN: Code duplicated, block: B:41:0x0152  */
    /* JADX WARN: Code duplicated, block: B:46:0x016b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0171  */
    /* JADX WARN: Code duplicated, block: B:50:0x0175  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00081 c00081;
        Object obj;
        boolean z;
        C00081 c00082;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Document document;
        Element elementSelectFirst;
        String iframeSrc;
        String str;
        boolean z2;
        Function1<? super SubtitleFile, Unit> function5;
        String data3;
        Document document2;
        Function1<? super ExtractorLink, Unit> function6;
        String iframeSrc2;
        String strAttr;
        Element elementSelectFirst2;
        String downloadHref;
        String str2;
        String strAttr2;
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
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String string = null;
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00081.L$0 = data;
                c00081.L$1 = function1;
                c00081.L$2 = function2;
                c00081.Z$0 = isCasting;
                c00081.label = 1;
                C00081 c00083 = c00081;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00083, 4094, (Object) null);
                c00082 = c00083;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                document = ((NiceResponse) $result).getDocument();
                elementSelectFirst = document.selectFirst("div.embed-player iframe");
                if (elementSelectFirst != null || (strAttr = elementSelectFirst.attr("src")) == null) {
                    iframeSrc = null;
                } else {
                    iframeSrc = StringsKt.trim(strAttr).toString();
                }
                str = iframeSrc;
                if (str != null || str.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    function5 = function3;
                    data3 = data2;
                    document2 = document;
                    function6 = function4;
                    iframeSrc2 = iframeSrc;
                } else {
                    c00082.L$0 = data2;
                    c00082.L$1 = function3;
                    c00082.L$2 = function4;
                    c00082.L$3 = document;
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc);
                    c00082.Z$0 = isCasting2;
                    c00082.label = 2;
                    if (ExtractorApiKt.loadExtractor(iframeSrc, data2, function3, function4, c00082) == obj) {
                        return obj;
                    }
                    function5 = function3;
                    data3 = data2;
                    document2 = document;
                    function6 = function4;
                    iframeSrc2 = iframeSrc;
                }
                elementSelectFirst2 = document2.selectFirst("a.download-btn");
                if (elementSelectFirst2 != null && (strAttr2 = elementSelectFirst2.attr("href")) != null) {
                    string = StringsKt.trim(strAttr2).toString();
                }
                downloadHref = string;
                str2 = downloadHref;
                if (!(str2 != null || str2.length() == 0)) {
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc2);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(downloadHref);
                    c00082.Z$0 = isCasting2;
                    c00082.label = 3;
                    if (ExtractorApiKt.loadExtractor(downloadHref, data3, function5, function6, c00082) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00081.Z$0;
                function4 = (Function1) c00081.L$2;
                function3 = (Function1) c00081.L$1;
                data2 = (String) c00081.L$0;
                ResultKt.throwOnFailure($result);
                c00082 = c00081;
                obj = coroutine_suspended;
                z = true;
                document = ((NiceResponse) $result).getDocument();
                elementSelectFirst = document.selectFirst("div.embed-player iframe");
                if (elementSelectFirst != null) {
                    iframeSrc = null;
                } else {
                    iframeSrc = null;
                }
                str = iframeSrc;
                if (str != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    c00082.L$0 = data2;
                    c00082.L$1 = function3;
                    c00082.L$2 = function4;
                    c00082.L$3 = document;
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc);
                    c00082.Z$0 = isCasting2;
                    c00082.label = 2;
                    if (ExtractorApiKt.loadExtractor(iframeSrc, data2, function3, function4, c00082) == obj) {
                        return obj;
                    }
                    function5 = function3;
                    data3 = data2;
                    document2 = document;
                    function6 = function4;
                    iframeSrc2 = iframeSrc;
                } else {
                    function5 = function3;
                    data3 = data2;
                    document2 = document;
                    function6 = function4;
                    iframeSrc2 = iframeSrc;
                }
                elementSelectFirst2 = document2.selectFirst("a.download-btn");
                if (elementSelectFirst2 != null) {
                    string = StringsKt.trim(strAttr2).toString();
                }
                downloadHref = string;
                str2 = downloadHref;
                if (!(str2 != null || str2.length() == 0)) {
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc2);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(downloadHref);
                    c00082.Z$0 = isCasting2;
                    c00082.label = 3;
                    if (ExtractorApiKt.loadExtractor(downloadHref, data3, function5, function6, c00082) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 2:
                isCasting2 = c00081.Z$0;
                iframeSrc2 = (String) c00081.L$4;
                document2 = (Document) c00081.L$3;
                function6 = (Function1) c00081.L$2;
                function5 = (Function1) c00081.L$1;
                data3 = (String) c00081.L$0;
                ResultKt.throwOnFailure($result);
                c00082 = c00081;
                obj = coroutine_suspended;
                z = true;
                elementSelectFirst2 = document2.selectFirst("a.download-btn");
                if (elementSelectFirst2 != null) {
                    string = StringsKt.trim(strAttr2).toString();
                }
                downloadHref = string;
                str2 = downloadHref;
                if (!(str2 != null || str2.length() == 0)) {
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(function5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc2);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(downloadHref);
                    c00082.Z$0 = isCasting2;
                    c00082.label = 3;
                    if (ExtractorApiKt.loadExtractor(downloadHref, data3, function5, function6, c00082) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 3:
                boolean z3 = c00081.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String encodeUri(String $this$encodeUri) {
        return URLEncoder.encode($this$encodeUri, "UTF-8");
    }
}
