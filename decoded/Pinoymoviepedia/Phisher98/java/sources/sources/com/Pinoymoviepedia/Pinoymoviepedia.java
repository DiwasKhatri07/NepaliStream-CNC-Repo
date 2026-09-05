package com.Pinoymoviepedia;

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
import com.lagradost.cloudstream3.SearchQuality;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Pinoymoviepedia.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Pinoymoviepedia/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J\u000e\u0010(\u001a\u0004\u0018\u00010)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001c2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u0004\u0018\u00010\u0005*\u00020*H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"Lcom/Pinoymoviepedia/Pinoymoviepedia;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProperLink", "uri", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageAttr", "Pinoymoviepedia"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPinoymoviepedia.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pinoymoviepedia.kt\ncom/Pinoymoviepedia/Pinoymoviepedia\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1795#2,10:159\n2068#2:169\n2069#2:171\n1805#2:172\n1739#2:173\n1814#2,3:174\n1#3:170\n*S KotlinDebug\n*F\n+ 1 Pinoymoviepedia.kt\ncom/Pinoymoviepedia/Pinoymoviepedia\n*L\n37#1:159,10\n37#1:169\n37#1:171\n37#1:172\n82#1:173\n82#1:174,3\n37#1:170\n*E\n"})
public class Pinoymoviepedia extends MainAPI {

    @NotNull
    private String mainUrl = "https://pinoymoviepedia.ru";

    @NotNull
    private String name = "Pinoymoviepedia";
    private final boolean hasMainPage = true;

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(TvType.Movie);

    @NotNull
    private String lang = "fil";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("trending", "Trending"), TuplesKt.to("movies", "Movies"), TuplesKt.to("genre/comedy", "Comedy"), TuplesKt.to("genre/romance", "Romance"), TuplesKt.to("genre/action", "Action"), TuplesKt.to("genre/digitally-restored", "Digitally Restored")});

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Pinoymoviepedia$getMainPage$1 */
    /* JADX INFO: compiled from: Pinoymoviepedia.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Pinoymoviepedia", f = "Pinoymoviepedia.kt", i = {0, 0, 0, 0}, l = {35}, m = "getMainPage$suspendImpl", n = {"$this", "request", "url", "page"}, nl = {37}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pinoymoviepedia.getMainPage$suspendImpl(Pinoymoviepedia.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Pinoymoviepedia$load$1 */
    /* JADX INFO: compiled from: Pinoymoviepedia.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Pinoymoviepedia", f = "Pinoymoviepedia.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {94, 122}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "request", "document", "title", "posterUrl", "description"}, nl = {95, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pinoymoviepedia.load$suspendImpl(Pinoymoviepedia.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Pinoymoviepedia$loadLinks$1 */
    /* JADX INFO: compiled from: Pinoymoviepedia.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Pinoymoviepedia", f = "Pinoymoviepedia.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {136, 136}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "isCasting", "$this", "data", "subtitleCallback", "callback", "isCasting"}, nl = {136, 146}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return Pinoymoviepedia.loadLinks$suspendImpl(Pinoymoviepedia.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Pinoymoviepedia$search$1 */
    /* JADX INFO: compiled from: Pinoymoviepedia.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Pinoymoviepedia", f = "Pinoymoviepedia.kt", i = {0, 0}, l = {81}, m = "search$suspendImpl", n = {"$this", "query"}, nl = {82}, s = {"L$0", "L$1"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pinoymoviepedia.search$suspendImpl(Pinoymoviepedia.this, null, (Continuation) this);
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
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public void setSupportedTypes(@NotNull Set<? extends TvType> set) {
        this.supportedTypes = set;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object getMainPage$suspendImpl(Pinoymoviepedia $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00051 c00051;
        StringBuilder sb;
        StringBuilder sbAppend;
        MainPageRequest request2;
        Pinoymoviepedia $this2 = $this;
        int page2 = page;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = $this2.new C00051(continuation);
            }
        } else {
            c00051 = $this2.new C00051(continuation);
        }
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (page2 == 1) {
                    sb = new StringBuilder();
                    sbAppend = sb.append($this2.getMainUrl()).append('/').append(request.getData());
                } else {
                    sb = new StringBuilder();
                    sbAppend = sb.append($this2.getMainUrl()).append('/').append(request.getData()).append("/page/").append(page2);
                }
                String url = sbAppend.append('/').toString();
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = $this2;
                c00051.L$1 = request;
                c00051.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00051.I$0 = page2;
                c00051.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00051, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00051.I$0;
                request2 = (MainPageRequest) c00051.L$1;
                $this2 = (Pinoymoviepedia) c00051.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.items.normal article, div#archive-content article, div.items.full article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    private final String getProperLink(String uri) {
        List groupValues;
        List groupValues2;
        String str = null;
        if (StringsKt.contains$default(uri, "/episodes/", false, 2, (Object) null)) {
            String title = StringsKt.substringAfter$default(uri, getMainUrl() + "/episodes/", (String) null, 2, (Object) null);
            MatchResult matchResultFind$default = Regex.find$default(new Regex("(.+?)-season"), title, 0, 2, (Object) null);
            if (matchResultFind$default != null && (groupValues2 = matchResultFind$default.getGroupValues()) != null) {
                str = (String) groupValues2.get(1);
            }
            String title2 = String.valueOf(str);
            return getMainUrl() + "/tvshows/" + title2;
        }
        if (StringsKt.contains$default(uri, "/seasons/", false, 2, (Object) null)) {
            String title3 = StringsKt.substringAfter$default(uri, getMainUrl() + "/seasons/", (String) null, 2, (Object) null);
            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("(.+?)-season"), title3, 0, 2, (Object) null);
            if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null) {
                str = (String) groupValues.get(1);
            }
            String title4 = String.valueOf(str);
            return getMainUrl() + "/tvshows/" + title4;
        }
        return uri;
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h3 > a");
        if (elementSelectFirst == null || (title = elementSelectFirst.text()) == null) {
            return null;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("h3 > a");
        Intrinsics.checkNotNull(elementSelectFirst2);
        String href = getProperLink(MainAPIKt.fixUrl(this, elementSelectFirst2.attr("href")));
        final Ref.ObjectRef posterUrl = new Ref.ObjectRef();
        Element elementLast = $this$toSearchResult.select("div.poster img").last();
        posterUrl.element = elementLast != null ? getImageAttr(elementLast) : null;
        if (posterUrl.element != null && StringsKt.contains$default((CharSequence) posterUrl.element, ".gif", false, 2, (Object) null)) {
            posterUrl.element = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("div.poster img").attr("data-wpfc-original-src"));
        }
        final SearchQuality quality = MainAPIKt.getQualityFromString($this$toSearchResult.select("span.quality").text());
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Pinoymoviepedia.Pinoymoviepedia$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Pinoymoviepedia.toSearchResult$lambda$0(posterUrl, quality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(Ref.ObjectRef $posterUrl, SearchQuality $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl((String) $posterUrl.element);
        $this$newMovieSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object search$suspendImpl(Pinoymoviepedia $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        C00101 c00101;
        Pinoymoviepedia $this2 = $this;
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
                Requests app = MainActivityKt.getApp();
                String str = $this2.getMainUrl() + "/search/" + query;
                c00101.L$0 = $this2;
                c00101.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00101.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                $this2 = (Pinoymoviepedia) c00101.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$map$iv = document.select("div.result-item");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            Element elementSelectFirst = it.selectFirst("div.title > a");
            Intrinsics.checkNotNull(elementSelectFirst);
            String title = StringsKt.trim(new Regex("\\(\\d{4}\\)").replace(elementSelectFirst.text(), "")).toString();
            Element elementSelectFirst2 = it.selectFirst("div.title > a");
            Intrinsics.checkNotNull(elementSelectFirst2);
            String href = $this2.getProperLink(elementSelectFirst2.attr("href"));
            Element elementSelectFirst3 = it.selectFirst("img");
            Intrinsics.checkNotNull(elementSelectFirst3);
            final String posterUrl = elementSelectFirst3.attr("src");
            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default($this2, title, href, TvType.TvSeries, false, new Function1() { // from class: com.Pinoymoviepedia.Pinoymoviepedia$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return Pinoymoviepedia.search$lambda$0$0(posterUrl, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object load$suspendImpl(Pinoymoviepedia $this, String url, Continuation<? super LoadResponse> continuation) {
        C00061 c00061;
        boolean z;
        Object obj;
        Object obj2;
        Pinoymoviepedia $this2;
        String url2;
        String strText;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = $this.new C00061(continuation);
            }
        } else {
            c00061 = $this.new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00062.L$0 = $this;
                c00062.L$1 = url;
                c00062.label = 1;
                z = true;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4094, (Object) null);
                c00062 = c00062;
                if (obj2 == obj) {
                    return obj;
                }
                $this2 = $this;
                url2 = url;
                break;
            case 1:
                String url3 = (String) c00062.L$1;
                Pinoymoviepedia $this3 = (Pinoymoviepedia) c00062.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                obj = coroutine_suspended;
                url2 = url3;
                z = true;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse request = (NiceResponse) obj2;
        Document document = request.getDocument();
        Element elementSelectFirst = document.selectFirst("div.data > h1");
        String title = String.valueOf((elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? null : StringsKt.trim(strText).toString());
        Ref.ObjectRef posterUrl = new Ref.ObjectRef();
        Pinoymoviepedia pinoymoviepedia = $this2;
        Element elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
        posterUrl.element = MainAPIKt.fixUrlNull(pinoymoviepedia, elementSelectFirst2 != null ? elementSelectFirst2.attr("content") : null);
        CharSequence charSequence = (CharSequence) posterUrl.element;
        if (charSequence != null && charSequence.length() != 0) {
            z = false;
        }
        if (z) {
            posterUrl.element = MainAPIKt.fixUrlNull($this2, document.select("div.poster img").attr("src"));
        }
        String description = StringsKt.trim(document.select("div.wp-content > p").text()).toString();
        TvType tvType = TvType.Movie;
        C00072 c00072 = new C00072(posterUrl, description, null);
        c00062.L$0 = SpillingKt.nullOutSpilledVariable($this2);
        c00062.L$1 = SpillingKt.nullOutSpilledVariable(url2);
        c00062.L$2 = SpillingKt.nullOutSpilledVariable(request);
        c00062.L$3 = SpillingKt.nullOutSpilledVariable(document);
        c00062.L$4 = SpillingKt.nullOutSpilledVariable(title);
        c00062.L$5 = SpillingKt.nullOutSpilledVariable(posterUrl);
        c00062.L$6 = SpillingKt.nullOutSpilledVariable(description);
        c00062.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse($this2, title, url2, tvType, url2, c00072, c00062);
        return objNewMovieLoadResponse == obj ? obj : objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Pinoymoviepedia$load$2 */
    /* JADX INFO: compiled from: Pinoymoviepedia.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Pinoymoviepedia$load$2", f = "Pinoymoviepedia.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ Ref.ObjectRef<String> $posterUrl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(Ref.ObjectRef<String> objectRef, String str, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$posterUrl = objectRef;
            this.$description = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$posterUrl, this.$description, continuation);
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
                    $this$newMovieLoadResponse.setPosterUrl((String) this.$posterUrl.element);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0114 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object loadLinks$suspendImpl(Pinoymoviepedia $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00081 c00081;
        Pinoymoviepedia $this2;
        Object obj;
        boolean z;
        C00081 c00082;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00092 c00092;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
                $this2 = $this;
            } else {
                $this2 = $this;
                c00081 = $this2.new C00081(continuation);
            }
        } else {
            $this2 = $this;
            c00081 = $this2.new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Log.INSTANCE.d("Phisher", data);
                Requests app = MainActivityKt.getApp();
                c00081.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00081.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00081.L$2 = function1;
                c00081.L$3 = function2;
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
                listSelect = ((NiceResponse) $result).getDocument().select("div.pframe iframe");
                c00092 = new C00092(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00081.Z$0;
                function4 = (Function1) c00081.L$3;
                function3 = (Function1) c00081.L$2;
                data2 = (String) c00081.L$1;
                $this2 = (Pinoymoviepedia) c00081.L$0;
                ResultKt.throwOnFailure($result);
                c00082 = c00081;
                obj = coroutine_suspended;
                z = true;
                listSelect = ((NiceResponse) $result).getDocument().select("div.pframe iframe");
                c00092 = new C00092(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00081.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Pinoymoviepedia.Pinoymoviepedia$loadLinks$2 */
    /* JADX INFO: compiled from: Pinoymoviepedia.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pinoymoviepedia.Pinoymoviepedia$loadLinks$2", f = "Pinoymoviepedia.kt", i = {0, 0}, l = {139}, m = "invokeSuspend", n = {"it", "href"}, nl = {144}, s = {"L$0", "L$1"}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$subtitleCallback, this.$callback, continuation);
            c00092.L$0 = obj;
            return c00092;
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
                    String href = it.attr("src");
                    Log.INSTANCE.d("Phisher", href);
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
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("abs:data-src");
        }
        if ($this$getImageAttr.hasAttr("data-lazy-src")) {
            return $this$getImageAttr.attr("abs:data-lazy-src");
        }
        return $this$getImageAttr.hasAttr("srcset") ? StringsKt.substringBefore$default($this$getImageAttr.attr("abs:srcset"), " ", (String) null, 2, (Object) null) : $this$getImageAttr.attr("abs:src");
    }
}
