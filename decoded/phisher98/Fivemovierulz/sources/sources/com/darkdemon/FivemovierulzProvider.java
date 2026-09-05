package com.darkdemon;

import com.lagradost.api.Log;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: FivemovierulzProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Fivemovierulz/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001b\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u0004\u0018\u00010$*\u00020%H\u0002J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\u00192\u0006\u0010'\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010(JF\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000e2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020200H\u0096@¢\u0006\u0002\u00105R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00066"}, d2 = {"Lcom/darkdemon/FivemovierulzProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Fivemovierulz"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFivemovierulzProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FivemovierulzProvider.kt\ncom/darkdemon/FivemovierulzProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1795#2,10:112\n2068#2:122\n2069#2:124\n1805#2:125\n1795#2,10:126\n2068#2:136\n2069#2:138\n1805#2:139\n1739#2:140\n1814#2,3:141\n1739#2:144\n1814#2,3:145\n777#2:148\n873#2,2:149\n1795#2,10:151\n2068#2:161\n2069#2:163\n1805#2:164\n777#2:165\n873#2,2:166\n1#3:123\n1#3:137\n1#3:162\n*S KotlinDebug\n*F\n+ 1 FivemovierulzProvider.kt\ncom/darkdemon/FivemovierulzProvider\n*L\n32#1:112,10\n32#1:122\n32#1:124\n32#1:125\n52#1:126,10\n52#1:136\n52#1:138\n52#1:139\n65#1:140\n65#1:141,3\n74#1:144\n74#1:145,3\n94#1:148\n94#1:149,2\n95#1:151,10\n95#1:161\n95#1:163\n95#1:164\n96#1:165\n96#1:166,2\n32#1:123\n52#1:137\n95#1:162\n*E\n"})
public final class FivemovierulzProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://5movierulz.gripe";

    @NotNull
    private String name = "5movierulz";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Movie);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/category/featured/page/", "Latest"), TuplesKt.to(getMainUrl() + "/category/bollywood-featured/page/", "Bollywood"), TuplesKt.to(getMainUrl() + "/language/hindi-dubbed/page/", "Hindi Dubbed"), TuplesKt.to(getMainUrl() + "/category/hollywood-featured/page/", "Hollywood")});

    /* JADX INFO: renamed from: com.darkdemon.FivemovierulzProvider$getMainPage$1 */
    /* JADX INFO: compiled from: FivemovierulzProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.darkdemon.FivemovierulzProvider", f = "FivemovierulzProvider.kt", i = {0, 0}, l = {31}, m = "getMainPage", n = {"request", "page"}, nl = {32}, s = {"L$0", "I$0"}, v = 2)
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
            return FivemovierulzProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.darkdemon.FivemovierulzProvider$load$1 */
    /* JADX INFO: compiled from: FivemovierulzProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.darkdemon.FivemovierulzProvider", f = "FivemovierulzProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {58, 76}, m = "load", n = {"url", "url", "document", "title", "poster", "tags", "yearRegex", "year", "description", "actors"}, nl = {60, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
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
            return FivemovierulzProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.darkdemon.FivemovierulzProvider$loadLinks$1 */
    /* JADX INFO: compiled from: FivemovierulzProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.darkdemon.FivemovierulzProvider", f = "FivemovierulzProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {91, 98}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "links", "isCasting"}, nl = {93, 108}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return FivemovierulzProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.darkdemon.FivemovierulzProvider$search$1 */
    /* JADX INFO: compiled from: FivemovierulzProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.darkdemon.FivemovierulzProvider", f = "FivemovierulzProvider.kt", i = {0}, l = {50}, m = "search", n = {"query"}, nl = {52}, s = {"L$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FivemovierulzProvider.this.search(null, (Continuation) this);
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
        C00001 c00001;
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
                String str = request.getData() + page2;
                c00001.L$0 = request;
                c00001.I$0 = page2;
                c00001.label = 1;
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
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("#main .cont_display");
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
        String strAttr;
        String string;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a");
        if (elementSelectFirst == null || (strAttr = elementSelectFirst.attr("title")) == null || (string = StringsKt.trim(strAttr).toString()) == null || (title = StringsKt.substringBefore$default(string, "(", (String) null, 2, (Object) null)) == null) {
            return null;
        }
        FivemovierulzProvider fivemovierulzProvider = this;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("a");
        String href = MainAPIKt.fixUrl(fivemovierulzProvider, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null));
        FivemovierulzProvider fivemovierulzProvider2 = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(fivemovierulzProvider2, elementSelectFirst3 != null ? elementSelectFirst3.attr("src") : null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.darkdemon.FivemovierulzProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return FivemovierulzProvider.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00051.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("#main .cont_display");
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        String strText;
        String string;
        String title;
        List groupValues;
        String str;
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
        Element elementSelectFirst = document.selectFirst("h2.entry-title");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText).toString()) == null || (title = StringsKt.substringBefore$default(string, "(", (String) null, 2, (Object) null)) == null) {
            return null;
        }
        FivemovierulzProvider fivemovierulzProvider = this;
        Element elementSelectFirst2 = document.selectFirst(".entry-content img");
        String poster = MainAPIKt.fixUrlNull(fivemovierulzProvider, elementSelectFirst2 != null ? elementSelectFirst2.attr("src") : null);
        Iterable $this$map$iv = StringsKt.split$default(StringsKt.substringBefore$default(StringsKt.substringAfter$default(document.select("div.entry-content > p:nth-child(5)").text(), "Genres:", (String) null, 2, (Object) null), "Country:", (String) null, 2, (Object) null), new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(it);
        }
        List tags = (List) destination$iv$iv;
        Regex yearRegex = new Regex("\\d{4}");
        MatchResult matchResultFind$default = Regex.find$default(yearRegex, document.select("h2.entry-title").text(), 0, 2, (Object) null);
        Integer year = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 0)) == null) ? null : StringsKt.toIntOrNull(str);
        String description = StringsKt.trim(document.select("div.entry-content > p:nth-child(6)").text()).toString();
        Iterable $this$map$iv2 = StringsKt.split$default(StringsKt.substringBefore$default(StringsKt.substringAfter$default(document.select("div.entry-content > p:nth-child(5)").text(), "Starring by:", (String) null, 2, (Object) null), "Genres:", (String) null, 2, (Object) null), new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            Regex yearRegex2 = yearRegex;
            String it2 = (String) item$iv$iv2;
            destination$iv$iv2.add(it2);
            yearRegex = yearRegex2;
        }
        List actors = (List) destination$iv$iv2;
        TvType tvType = TvType.Movie;
        C00022 c00022 = new C00022(poster, year, description, tags, actors, null);
        c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
        c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
        c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
        c00012.L$4 = SpillingKt.nullOutSpilledVariable(tags);
        c00012.L$5 = SpillingKt.nullOutSpilledVariable(yearRegex);
        c00012.L$6 = SpillingKt.nullOutSpilledVariable(year);
        c00012.L$7 = SpillingKt.nullOutSpilledVariable(description);
        c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors);
        c00012.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, url2, c00022, c00012);
        return objNewMovieLoadResponse == obj ? obj : objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.darkdemon.FivemovierulzProvider$load$2 */
    /* JADX INFO: compiled from: FivemovierulzProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.darkdemon.FivemovierulzProvider$load$2", f = "FivemovierulzProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Integer num, String str2, List<String> list, List<String> list2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$description = str2;
            this.$tags = list;
            this.$actors = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$year, this.$description, this.$tags, this.$actors, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:23:0x0104  */
    /* JADX WARN: Code duplicated, block: B:28:0x012e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0148  */
    /* JADX WARN: Code duplicated, block: B:35:0x0171  */
    /* JADX WARN: Code duplicated, block: B:40:0x01ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        Object obj;
        C00031 c00032;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Document document;
        Iterable $this$filter$iv;
        Collection destination$iv$iv;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv2;
        Collection destination$iv$iv3;
        List links;
        C00042 c00042;
        String it;
        String strAttr;
        Element it2;
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
                Requests app = MainActivityKt.getApp();
                c00031.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00031.L$1 = function1;
                c00031.L$2 = function2;
                c00031.Z$0 = isCasting;
                c00031.label = 1;
                C00031 c00033 = c00031;
                obj = coroutine_suspended;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                c00032 = c00033;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                document = ((NiceResponse) $result).getDocument();
                $this$filter$iv = document.select("p a");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    it2 = (Element) element$iv$iv;
                    Document document2 = document;
                    Iterable $this$filter$iv2 = $this$filter$iv;
                    if (StringsKt.contains(it2.text(), "watch online", true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    document = document2;
                    $this$filter$iv = $this$filter$iv2;
                }
                Document document3 = document;
                $this$mapNotNull$iv = (List) destination$iv$iv;
                $i$f$mapNotNull = 0;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Element it3 = (Element) element$iv$iv$iv;
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    strAttr = it3.attr("href");
                    if (strAttr != null) {
                        destination$iv$iv2.add(strAttr);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                }
                Iterable $this$filter$iv3 = (List) destination$iv$iv2;
                destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv3) {
                    it = (String) element$iv$iv2;
                    if (!StringsKt.isBlank(it)) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                }
                links = (List) destination$iv$iv3;
                c00042 = new C00042(function3, function4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(document3);
                c00032.L$4 = links;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(links, c00042, c00032) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(!links.isEmpty());
            case 1:
                isCasting2 = c00031.Z$0;
                function4 = (Function1) c00031.L$2;
                function3 = (Function1) c00031.L$1;
                data2 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00032 = c00031;
                obj = coroutine_suspended;
                document = ((NiceResponse) $result).getDocument();
                $this$filter$iv = document.select("p a");
                destination$iv$iv = new ArrayList();
                while (r14.hasNext()) {
                    it2 = (Element) element$iv$iv;
                    Document document4 = document;
                    Iterable $this$filter$iv4 = $this$filter$iv;
                    if (StringsKt.contains(it2.text(), "watch online", true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    document = document4;
                    $this$filter$iv = $this$filter$iv4;
                }
                Document document5 = document;
                $this$mapNotNull$iv = (List) destination$iv$iv;
                $i$f$mapNotNull = 0;
                destination$iv$iv2 = new ArrayList();
                while (r14.hasNext()) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it4 = (Element) element$iv$iv$iv;
                    int $i$f$mapNotNull3 = $i$f$mapNotNull;
                    strAttr = it4.attr("href");
                    if (strAttr != null) {
                        destination$iv$iv2.add(strAttr);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    $i$f$mapNotNull = $i$f$mapNotNull3;
                }
                Iterable $this$filter$iv5 = (List) destination$iv$iv2;
                destination$iv$iv3 = new ArrayList();
                while (r12.hasNext()) {
                    it = (String) element$iv$iv2;
                    if (!StringsKt.isBlank(it)) {
                        destination$iv$iv3.add(element$iv$iv2);
                    }
                }
                links = (List) destination$iv$iv3;
                c00042 = new C00042(function3, function4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(document5);
                c00032.L$4 = links;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(links, c00042, c00032) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(!links.isEmpty());
            case 2:
                boolean z = c00031.Z$0;
                List links2 = (List) c00031.L$4;
                ResultKt.throwOnFailure($result);
                links = links2;
                return Boxing.boxBoolean(!links.isEmpty());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.darkdemon.FivemovierulzProvider$loadLinks$2 */
    /* JADX INFO: compiled from: FivemovierulzProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "link", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.darkdemon.FivemovierulzProvider$loadLinks$2", f = "FivemovierulzProvider.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {"link"}, nl = {105}, s = {"L$0"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = FivemovierulzProvider.this.new C00042(this.$subtitleCallback, this.$callback, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(String str, Continuation<? super Boolean> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String link = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Log.INSTANCE.d("Phisher", link);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(link, FivemovierulzProvider.this.getMainUrl() + '/', this.$subtitleCallback, this.$callback, (Continuation) this);
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
