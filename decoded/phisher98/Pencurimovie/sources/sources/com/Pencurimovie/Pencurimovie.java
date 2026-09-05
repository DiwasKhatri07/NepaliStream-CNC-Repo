package com.Pencurimovie;

import com.lagradost.api.Log;
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

/* JADX INFO: compiled from: Pencurimovie.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Pencurimovie/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/Pencurimovie/Pencurimovie;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Pencurimovie"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPencurimovie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pencurimovie.kt\ncom/Pencurimovie/Pencurimovie\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,138:1\n1795#2,10:139\n2068#2:149\n2069#2:151\n1805#2:152\n1795#2,10:153\n2068#2:163\n2069#2:165\n1805#2:166\n1739#2:167\n1814#2,3:168\n1739#2:171\n1814#2,3:172\n1795#2,10:175\n2068#2:185\n2069#2:187\n1805#2:188\n1#3:150\n1#3:164\n1#3:186\n*S KotlinDebug\n*F\n+ 1 Pencurimovie.kt\ncom/Pencurimovie/Pencurimovie\n*L\n33#1:139,10\n33#1:149\n33#1:151\n33#1:152\n59#1:153,10\n59#1:163\n59#1:165\n59#1:166\n71#1:167\n71#1:168,3\n73#1:171\n73#1:172,3\n76#1:175,10\n76#1:185\n76#1:187\n76#1:188\n33#1:150\n59#1:164\n76#1:186\n*E\n"})
public final class Pencurimovie extends MainAPI {

    @NotNull
    private String mainUrl = "https://ww21.pencurimovie.sbs";

    @NotNull
    private String name = "Pencurimovie";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "id";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("movies", "Latest Movies"), TuplesKt.to("series", "TV Series"), TuplesKt.to("most-rating", "Most Rating Movies"), TuplesKt.to("top-imdb", "Top IMDB Movies"), TuplesKt.to("country/malaysia", "Malaysia Movies"), TuplesKt.to("country/indonesia", "Indonesia Movies"), TuplesKt.to("country/india", "India Movies"), TuplesKt.to("country/japan", "Japan Movies"), TuplesKt.to("country/thailand", "Thailand Movies"), TuplesKt.to("country/china", "China Movies")});

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$getMainPage$1 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie", f = "Pencurimovie.kt", i = {0, 0}, l = {32}, m = "getMainPage", n = {"request", "page"}, nl = {33}, s = {"L$0", "I$0"}, v = 2)
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
            return Pencurimovie.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$load$1 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie", f = "Pencurimovie.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {64, 81, 101, 111}, m = "load", n = {"url", "url", "document", "title", "poster", "description", "tvtag", "trailer", "genre", "actors", "year", "recommendation", "episodes", "url", "document", "title", "poster", "description", "tvtag", "trailer", "genre", "actors", "year", "recommendation", "episodes", "url", "document", "title", "poster", "description", "tvtag", "trailer", "genre", "actors", "year", "recommendation"}, nl = {66, 101, 111, 79}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pencurimovie.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$loadLinks$1 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie", f = "Pencurimovie.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {129, 130}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {130, 134}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return Pencurimovie.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$search$1 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie", f = "Pencurimovie.kt", i = {0}, l = {58}, m = "search", n = {"query"}, nl = {59}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pencurimovie.this.search(null, (Continuation) this);
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
                String str = getMainUrl() + '/' + request.getData() + "/page/" + page2;
                c00001.L$0 = request;
                c00001.I$0 = page2;
                c00001.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 50L, (Interceptor) null, false, (ResponseParser) null, c00001, 3838, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("div.ml-item");
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
        String title = StringsKt.substringBefore$default($this$toSearchResult.select("a").attr("oldtitle"), "(", (String) null, 2, (Object) null);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("a img").attr("src"));
        final SearchQuality quality = MainAPIKt.getQualityFromString($this$toSearchResult.select("span.mli-quality").text());
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Pencurimovie.Pencurimovie$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Pencurimovie.toSearchResult$lambda$0(posterUrl, quality, (MovieSearchResponse) obj);
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
        C00071 c00071;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "?s=" + query;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 50L, (Interceptor) null, false, (ResponseParser) null, c00071, 3838, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("div.ml-item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List results = (List) destination$iv$iv;
        return results;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x013c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0170  */
    /* JADX WARN: Code duplicated, block: B:34:0x0182  */
    /* JADX WARN: Code duplicated, block: B:35:0x0185  */
    /* JADX WARN: Code duplicated, block: B:39:0x01be A[LOOP:0: B:37:0x01b8->B:39:0x01be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0201 A[LOOP:1: B:41:0x01fb->B:43:0x0201, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x0257  */
    /* JADX WARN: Code duplicated, block: B:49:0x026d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0283  */
    /* JADX WARN: Code duplicated, block: B:55:0x02c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:59:0x0332 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x0333  */
    /* JADX WARN: Code duplicated, block: B:62:0x0347  */
    /* JADX WARN: Code duplicated, block: B:64:0x03b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:72:0x0272 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String string;
        String title;
        String poster;
        Element elementSelectFirst2;
        String string2;
        String description;
        TvType tvType;
        TvType tvtag;
        String trailer;
        Collection destination$iv$iv;
        List genre;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        List actors;
        Integer year;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv3;
        List recommendation;
        String title2;
        String url3;
        String poster2;
        String description2;
        List genre2;
        Integer year2;
        String trailer2;
        List actors2;
        List recommendation2;
        TvType tvtag2;
        Document document2;
        List episodes;
        List listSelect;
        TvType tvtag3;
        Document document3;
        C00022 c00022;
        List recommendation3;
        String trailer3;
        List actors3;
        List actors4;
        String title3;
        Integer year3;
        String poster3;
        List genre3;
        SearchResponse searchResult;
        String strText;
        String strText2;
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
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 50L, (Interceptor) null, false, (ResponseParser) null, c00012, 3838, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.mvic-desc h3");
                if (elementSelectFirst != null || (strText2 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText2).toString();
                }
                title = StringsKt.substringBefore$default(String.valueOf(string), "(", (String) null, 2, (Object) null);
                poster = document.select("meta[property=og:image]").attr("content");
                elementSelectFirst2 = document.selectFirst("div.desc p.f-desc");
                if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null) {
                    string2 = null;
                } else {
                    string2 = StringsKt.trim(strText).toString();
                }
                description = string2;
                if (StringsKt.contains$default(url2, "series", false, 2, (Object) null)) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvtag = tvType;
                trailer = document.select("meta[itemprop=embedUrl]").attr("content");
                Iterable $this$map$iv2 = document.select("div.mvic-info p:contains(Genre)").select("a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(it.text());
                }
                genre = (List) destination$iv$iv;
                $this$map$iv = document.select("div.mvic-info p:contains(Actors)").select("a");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv2 : $this$map$iv) {
                    Element it2 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(it2.text());
                    $this$map$iv = $this$map$iv;
                }
                actors = (List) destination$iv$iv2;
                year = StringsKt.toIntOrNull(document.select("div.mvic-info p:contains(Release)").select("a").text());
                $this$mapNotNull$iv = document.select("div.ml-item");
                destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Element it3 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it3);
                    if (searchResult != null) {
                        destination$iv$iv3.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                }
                recommendation = (List) destination$iv$iv3;
                if (tvtag == TvType.TvSeries) {
                    TvType tvType2 = TvType.Movie;
                    C00044 c00044 = new C00044(poster, description, genre, year, trailer, actors, recommendation, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(recommendation);
                    c00012.label = 4;
                    $result = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType2, url2, c00044, c00012);
                    if ($result == obj) {
                        return obj;
                    }
                    title2 = title;
                    url3 = url2;
                    poster2 = poster;
                    description2 = description;
                    genre2 = genre;
                    year2 = year;
                    trailer2 = trailer;
                    actors2 = actors;
                    recommendation2 = recommendation;
                    tvtag2 = tvtag;
                    document2 = document;
                    return (LoadResponse) $result;
                }
                episodes = new ArrayList();
                listSelect = document.select("div.tvseason");
                tvtag3 = tvtag;
                document3 = document;
                c00022 = new C00022(episodes, this, null);
                c00012.L$0 = url2;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document3);
                c00012.L$2 = title;
                c00012.L$3 = poster;
                c00012.L$4 = description;
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00012.L$6 = trailer;
                c00012.L$7 = genre;
                c00012.L$8 = actors;
                c00012.L$9 = year;
                c00012.L$10 = recommendation;
                c00012.L$11 = episodes;
                c00012.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00022, c00012) == obj) {
                    return obj;
                }
                recommendation3 = recommendation;
                trailer3 = trailer;
                actors3 = actors;
                actors4 = episodes;
                title3 = title;
                year3 = year;
                poster3 = poster;
                genre3 = genre;
                TvType tvType3 = TvType.TvSeries;
                C00033 c00033 = new C00033(poster3, description, genre3, year3, trailer3, actors3, recommendation3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(trailer3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(genre3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(recommendation3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(actors4);
                c00012.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url2, tvType3, actors4, c00033, c00012);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 1:
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url4;
                obj = coroutine_suspended;
                obj2 = $result;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.mvic-desc h3");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = StringsKt.substringBefore$default(String.valueOf(string), "(", (String) null, 2, (Object) null);
                poster = document.select("meta[property=og:image]").attr("content");
                elementSelectFirst2 = document.selectFirst("div.desc p.f-desc");
                if (elementSelectFirst2 != null) {
                    string2 = null;
                } else {
                    string2 = null;
                }
                description = string2;
                if (StringsKt.contains$default(url2, "series", false, 2, (Object) null)) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvtag = tvType;
                trailer = document.select("meta[itemprop=embedUrl]").attr("content");
                Iterable $this$map$iv3 = document.select("div.mvic-info p:contains(Genre)").select("a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r18.hasNext()) {
                    Element it4 = (Element) item$iv$iv;
                    destination$iv$iv.add(it4.text());
                }
                genre = (List) destination$iv$iv;
                $this$map$iv = document.select("div.mvic-info p:contains(Actors)").select("a");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r18.hasNext()) {
                    Element it5 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(it5.text());
                    $this$map$iv = $this$map$iv;
                }
                actors = (List) destination$iv$iv2;
                year = StringsKt.toIntOrNull(document.select("div.mvic-info p:contains(Release)").select("a").text());
                $this$mapNotNull$iv = document.select("div.ml-item");
                destination$iv$iv3 = new ArrayList();
                while (r21.hasNext()) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it6 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it6);
                    if (searchResult != null) {
                        destination$iv$iv3.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                }
                recommendation = (List) destination$iv$iv3;
                if (tvtag == TvType.TvSeries) {
                    TvType tvType4 = TvType.Movie;
                    C00044 c00045 = new C00044(poster, description, genre, year, trailer, actors, recommendation, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(trailer);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(recommendation);
                    c00012.label = 4;
                    $result = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType4, url2, c00045, c00012);
                    if ($result == obj) {
                        return obj;
                    }
                    title2 = title;
                    url3 = url2;
                    poster2 = poster;
                    description2 = description;
                    genre2 = genre;
                    year2 = year;
                    trailer2 = trailer;
                    actors2 = actors;
                    recommendation2 = recommendation;
                    tvtag2 = tvtag;
                    document2 = document;
                    return (LoadResponse) $result;
                }
                episodes = new ArrayList();
                listSelect = document.select("div.tvseason");
                tvtag3 = tvtag;
                document3 = document;
                c00022 = new C00022(episodes, this, null);
                c00012.L$0 = url2;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document3);
                c00012.L$2 = title;
                c00012.L$3 = poster;
                c00012.L$4 = description;
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00012.L$6 = trailer;
                c00012.L$7 = genre;
                c00012.L$8 = actors;
                c00012.L$9 = year;
                c00012.L$10 = recommendation;
                c00012.L$11 = episodes;
                c00012.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00022, c00012) == obj) {
                    return obj;
                }
                recommendation3 = recommendation;
                trailer3 = trailer;
                actors3 = actors;
                actors4 = episodes;
                title3 = title;
                year3 = year;
                poster3 = poster;
                genre3 = genre;
                TvType tvType5 = TvType.TvSeries;
                C00033 c00034 = new C00033(poster3, description, genre3, year3, trailer3, actors3, recommendation3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(trailer3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(genre3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(recommendation3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(actors4);
                c00012.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url2, tvType5, actors4, c00034, c00012);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 2:
                List episodes2 = (List) c00012.L$11;
                List recommendation4 = (List) c00012.L$10;
                Integer year4 = (Integer) c00012.L$9;
                List actors5 = (List) c00012.L$8;
                List genre4 = (List) c00012.L$7;
                String trailer4 = (String) c00012.L$6;
                TvType tvtag4 = (TvType) c00012.L$5;
                description = (String) c00012.L$4;
                String poster4 = (String) c00012.L$3;
                String title4 = (String) c00012.L$2;
                Document document4 = (Document) c00012.L$1;
                String url5 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                recommendation3 = recommendation4;
                actors3 = actors5;
                tvtag3 = tvtag4;
                poster3 = poster4;
                document3 = document4;
                url2 = url5;
                obj = coroutine_suspended;
                actors4 = episodes2;
                trailer3 = trailer4;
                title3 = title4;
                year3 = year4;
                genre3 = genre4;
                TvType tvType6 = TvType.TvSeries;
                C00033 c00035 = new C00033(poster3, description, genre3, year3, trailer3, actors3, recommendation3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document3);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(trailer3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(genre3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(actors3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(year3);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(recommendation3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(actors4);
                c00012.label = 3;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url2, tvType6, actors4, c00035, c00012);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 3:
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            case 4:
                recommendation2 = (List) c00012.L$10;
                year2 = (Integer) c00012.L$9;
                actors2 = (List) c00012.L$8;
                genre2 = (List) c00012.L$7;
                trailer2 = (String) c00012.L$6;
                tvtag2 = (TvType) c00012.L$5;
                description2 = (String) c00012.L$4;
                poster2 = (String) c00012.L$3;
                title2 = (String) c00012.L$2;
                document2 = (Document) c00012.L$1;
                url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$load$2 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "info", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie$load$2", f = "Pencurimovie.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nPencurimovie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pencurimovie.kt\ncom/Pencurimovie/Pencurimovie$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n2068#2,2:139\n*S KotlinDebug\n*F\n+ 1 Pencurimovie.kt\ncom/Pencurimovie/Pencurimovie$load$2\n*L\n83#1:139,2\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Episode> $episodes;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Pencurimovie this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(List<Episode> list, Pencurimovie pencurimovie, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.this$0 = pencurimovie;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$episodes, this.this$0, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element info = (Element) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = null;
                    int i = 2;
                    final Integer season = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfter$default(info.select("strong").text(), "Season", (String) null, 2, (Object) null)).toString());
                    Iterable $this$forEach$iv = info.select("div.les-content a");
                    List<Episode> list = this.$episodes;
                    Pencurimovie pencurimovie = this.this$0;
                    for (Object element$iv : $this$forEach$iv) {
                        Element it = (Element) element$iv;
                        Log.INSTANCE.d("Phis", String.valueOf(it));
                        final String name = StringsKt.trim(StringsKt.substringAfter$default(it.select("a").text(), "-", str, i, str)).toString();
                        String href = it.select("a").attr("href");
                        final Integer Rawepisode = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(it.select("a").text(), "Episode", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null)).toString());
                        list.add(MainAPIKt.newEpisode(pencurimovie, href, new Function1() { // from class: com.Pencurimovie.Pencurimovie$load$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return Pencurimovie.C00022.invokeSuspend$lambda$0$0(Rawepisode, name, season, (Episode) obj);
                            }
                        }));
                        str = null;
                        info = info;
                        i = 2;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(Integer $Rawepisode, String $name, Integer $season, Episode $this$newEpisode) {
            $this$newEpisode.setEpisode($Rawepisode);
            $this$newEpisode.setName($name);
            $this$newEpisode.setSeason($season);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$load$3 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie$load$3", f = "Pencurimovie.kt", i = {0}, l = {106}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {107}, s = {"L$0"}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendation;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, String str2, List<String> list, Integer num, String str3, List<String> list2, List<? extends SearchResponse> list3, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = list;
            this.$year = num;
            this.$trailer = str3;
            this.$actors = list2;
            this.$recommendation = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$description, this.$genre, this.$year, this.$trailer, this.$actors, this.$recommendation, continuation);
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
                    loadResponse.setTags(this.$genre);
                    loadResponse.setYear(this.$year);
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
            LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
            loadResponse.setRecommendations(this.$recommendation);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$load$4 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie$load$4", f = "Pencurimovie.kt", i = {0}, l = {116}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {117}, s = {"L$0"}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendation;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(String str, String str2, List<String> list, Integer num, String str3, List<String> list2, List<? extends SearchResponse> list3, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = list;
            this.$year = num;
            this.$trailer = str3;
            this.$actors = list2;
            this.$recommendation = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = new C00044(this.$poster, this.$description, this.$genre, this.$year, this.$trailer, this.$actors, this.$recommendation, continuation);
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
                    loadResponse.setTags(this.$genre);
                    loadResponse.setYear(this.$year);
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
            LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
            loadResponse.setRecommendations(this.$recommendation);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        Object obj;
        boolean z;
        C00051 c00052;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00062 c00062;
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
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00051.L$1 = function1;
                c00051.L$2 = function2;
                c00051.Z$0 = isCasting;
                c00051.label = 1;
                C00051 c00053 = c00051;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 4094, (Object) null);
                c00052 = c00053;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select("div.movieplay iframe");
                c00062 = new C00062(function3, function4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00052.Z$0 = isCasting2;
                c00052.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00062, c00052) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00051.Z$0;
                function4 = (Function1) c00051.L$2;
                function3 = (Function1) c00051.L$1;
                data2 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                c00052 = c00051;
                obj = coroutine_suspended;
                z = true;
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select("div.movieplay iframe");
                c00062 = new C00062(function3, function4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00052.Z$0 = isCasting2;
                c00052.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00062, c00052) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00051.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Pencurimovie.Pencurimovie$loadLinks$2 */
    /* JADX INFO: compiled from: Pencurimovie.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Pencurimovie.Pencurimovie$loadLinks$2", f = "Pencurimovie.kt", i = {0, 0}, l = {132}, m = "invokeSuspend", n = {"it", "href"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
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

        public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String href = it.attr("data-src");
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
}
