package com.Coflix;

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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
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

/* JADX INFO: compiled from: Coflix.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Coflix/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00100R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"Lcom/Coflix/Coflix;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "Coflix"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCoflix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Coflix.kt\ncom/Coflix/Coflix\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1739#2:192\n1814#2,3:193\n1739#2:196\n1814#2,3:197\n1739#2:201\n1814#2,3:202\n1739#2:205\n1814#2,3:206\n1795#2,10:209\n2068#2:219\n2069#2:221\n1805#2:222\n1749#2:223\n1782#2,4:224\n1#3:200\n1#3:220\n*S KotlinDebug\n*F\n+ 1 Coflix.kt\ncom/Coflix/Coflix\n*L\n50#1:192\n50#1:193,3\n75#1:196\n75#1:197,3\n99#1:201\n99#1:202,3\n102#1:205\n102#1:206,3\n104#1:209,10\n104#1:219\n104#1:221\n104#1:222\n124#1:223\n124#1:224,4\n104#1:220\n*E\n"})
public final class Coflix extends MainAPI {

    @NotNull
    private String mainUrl = "https://coflix.esq";

    @NotNull
    private String name = "Coflix";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "fr";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("films", "Films"), TuplesKt.to("series", "Series"), TuplesKt.to("doramas", "Doramas"), TuplesKt.to("animes", "Animes")});

    /* JADX INFO: renamed from: com.Coflix.Coflix$getBaseUrl$1 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix", f = "Coflix.kt", i = {0}, l = {187}, m = "getBaseUrl", n = {"url"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
            return Coflix.this.getBaseUrl(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$getMainPage$1 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix", f = "Coflix.kt", i = {0, 0, 0}, l = {49}, m = "getMainPage", n = {"request", "getrequest", "page"}, nl = {50}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return Coflix.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$load$1 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix", f = "Coflix.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {80, 140, 151}, m = "load", n = {"url", "url", "document", "title", "poster", "style", "bannerUrl", "description", "type", "cast", "rating", "year", "tags", "recommendations", "episodes", "url", "document", "title", "poster", "style", "bannerUrl", "description", "type", "cast", "rating", "year", "tags", "recommendations"}, nl = {81, 151, 122}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
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
            return Coflix.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$loadLinks$1 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix", f = "Coflix.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {164, 165, 166, 168}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "referer", "isCasting", "data", "subtitleCallback", "callback", "referer", "iframe", "isCasting", "data", "subtitleCallback", "callback", "referer", "iframe", "doc", "lis", "isCasting"}, nl = {165, 166, 167, 183}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
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
            return Coflix.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$search$1 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix", f = "Coflix.kt", i = {0, 0}, l = {75}, m = "search", n = {"query", "page"}, nl = {192}, s = {"L$0", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
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
            return Coflix.this.search(null, 0, (Continuation) this);
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
        C00011 c00011;
        boolean z;
        MainPageRequest request2;
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
                String getrequest = page == 1 ? request.getData() : request.getData() + "/page/" + page + '/';
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + getrequest;
                c00011.L$0 = request;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(getrequest);
                c00011.I$0 = page;
                c00011.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document res = ((NiceResponse) $result).getDocument();
        Iterable $this$map$iv = res.select("div.md-manga-card");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("p.md-manga-card-name").text();
        String href = $this$toSearchResult.select("a").attr("href");
        final SearchQuality quality = MainAPIKt.getQualityFromString($this$toSearchResult.select("span.md-card-badge.quality").text());
        final String posterUrl = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a > img").attr("src"));
        Score.Companion companion = Score.Companion;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("span.md-card-overlay-rating");
        final Score score = companion.from10(elementSelectFirst != null ? elementSelectFirst.ownText() : null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Coflix.Coflix$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Coflix.toSearchResult$lambda$0(posterUrl, quality, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, SearchQuality $quality, Score $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality($quality);
        $this$newMovieSearchResponse.setScore($score);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00071 c00071;
        int page2;
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
                String str = getMainUrl() + "/recherche/?s=" + query + "&paged=" + page;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.I$0 = page;
                c00071.label = 1;
                page2 = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00071.I$0;
                ResultKt.throwOnFailure($result);
                page2 = 1;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$map$iv = ((NiceResponse) $result).getDocument().select("div.md-manga-card");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        List response = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(response, (Boolean) null, page2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0381  */
    /* JADX WARN: Code duplicated, block: B:120:0x0460  */
    /* JADX WARN: Code duplicated, block: B:122:0x0468  */
    /* JADX WARN: Code duplicated, block: B:129:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:132:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:133:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:142:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:143:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:146:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:147:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:155:0x050e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0518  */
    /* JADX WARN: Code duplicated, block: B:159:0x051b  */
    /* JADX WARN: Code duplicated, block: B:169:0x053f  */
    /* JADX WARN: Code duplicated, block: B:174:0x05ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:175:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:179:0x0254 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x025d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0391 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0385 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x010d  */
    /* JADX WARN: Code duplicated, block: B:26:0x012d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0134  */
    /* JADX WARN: Code duplicated, block: B:30:0x0139  */
    /* JADX WARN: Code duplicated, block: B:33:0x015d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0173  */
    /* JADX WARN: Code duplicated, block: B:37:0x017e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0185  */
    /* JADX WARN: Code duplicated, block: B:41:0x019f  */
    /* JADX WARN: Code duplicated, block: B:42:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:45:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:49:0x01d8 A[LOOP:0: B:47:0x01d2->B:49:0x01d8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:53:0x0202  */
    /* JADX WARN: Code duplicated, block: B:57:0x0219  */
    /* JADX WARN: Code duplicated, block: B:59:0x0240  */
    /* JADX WARN: Code duplicated, block: B:60:0x0245  */
    /* JADX WARN: Code duplicated, block: B:63:0x0249 A[LOOP:1: B:55:0x0213->B:63:0x0249, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x025f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0266  */
    /* JADX WARN: Code duplicated, block: B:71:0x028a A[LOOP:2: B:69:0x0284->B:71:0x028a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00021 c00021;
        Object obj;
        boolean z;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String strText;
        String title;
        String poster;
        Element elementSelectFirst2;
        String strAttr;
        String str;
        String style;
        String it;
        String bannerUrl;
        Element elementSelectFirst3;
        String description;
        String str2;
        TvType tvType;
        TvType type;
        Collection destination$iv$iv;
        List cast;
        Element elementSelectFirst4;
        String strText2;
        Score rating;
        Iterator it2;
        Score rating2;
        String title2;
        String url3;
        String value;
        Integer year;
        Iterable $this$map$iv;
        Collection destination$iv$iv2;
        List tags;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv3;
        Iterable $this$mapNotNullTo$iv$iv;
        Iterator it3;
        List tags2;
        String str3;
        List recommendations;
        Iterable $this$mapIndexed$iv;
        int $i$f$mapIndexed;
        Collection destination$iv$iv4;
        Iterable $this$mapIndexedTo$iv$iv;
        int $i$f$mapIndexedTo;
        int index$iv$iv;
        Object objNewTvSeriesLoadResponse;
        MatchResult matchResultFind$default;
        String href;
        Element elementSelectFirst5;
        final String title3;
        Element elementSelectFirst6;
        Integer number;
        Element elementSelectFirst7;
        String strAttr2;
        String str4;
        String str5;
        MatchResult matchResultFind$default2;
        final Integer season;
        String str6;
        MatchResult matchResultFind$default3;
        List groupValues;
        List groupValues2;
        String str7;
        String strText3;
        List groupValues3;
        Object objNewMovieLoadResponse;
        Element elementSelectFirst8;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        String recTitle;
        String strText4;
        Object $result;
        Iterator it4;
        MatchResult matchResultFind$default4;
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
        Object $result2 = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00022.L$0 = url;
                c00022.label = 1;
                z = true;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h1.cf-movie-title");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = "Unknown";
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, document.select("div.cf-movie-cover-wrap a").attr("href"));
                elementSelectFirst2 = document.selectFirst("div.cf-movie-banner");
                if (elementSelectFirst2 != null) {
                    strAttr = elementSelectFirst2.attr("style");
                } else {
                    strAttr = null;
                }
                str = "";
                if (strAttr == null) {
                    strAttr = "";
                }
                style = strAttr;
                it = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(style, "url(", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null), new char[]{'\"', '\''});
                if (StringsKt.startsWith$default(it, "//", false, 2, (Object) null)) {
                    bannerUrl = "https:" + it;
                } else {
                    bannerUrl = it;
                }
                elementSelectFirst3 = document.selectFirst("div.cf-synopsis-text p");
                if (elementSelectFirst3 != null) {
                    description = elementSelectFirst3.text();
                } else {
                    description = null;
                }
                Log.INSTANCE.d("Phisher", url2);
                str2 = "/anime/";
                if (StringsKt.contains(url2, "/anime/", z)) {
                    tvType = TvType.Anime;
                } else if (StringsKt.contains(url2, "/film/", z)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                type = tvType;
                Iterable $this$map$iv2 = document.select("div.cf-cast-row span");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                cast = (List) destination$iv$iv;
                Score.Companion companion = Score.Companion;
                elementSelectFirst4 = document.selectFirst(".cf-stat-rating .cf-stat-primary");
                if (elementSelectFirst4 != null) {
                    strText2 = elementSelectFirst4.text();
                } else {
                    strText2 = null;
                }
                rating = companion.from10(strText2);
                it2 = document.select(".cf-stat-item").iterator();
                while (true) {
                    if (it2.hasNext()) {
                        rating2 = rating;
                        $result = $result2;
                        it4 = it2;
                        title2 = title;
                        url3 = url2;
                        matchResultFind$default4 = Regex.find$default(new Regex("\\b(19|20)\\d{2}\\b"), ((Element) it2.next()).text(), 0, 2, (Object) null);
                        if (matchResultFind$default4 != null) {
                            value = matchResultFind$default4.getValue();
                        } else {
                            value = null;
                        }
                        if (value != null) {
                            rating = rating2;
                            it2 = it4;
                            $result2 = $result;
                            title = title2;
                            url2 = url3;
                        }
                    } else {
                        rating2 = rating;
                        title2 = title;
                        url3 = url2;
                        value = null;
                    }
                }
                if (value != null) {
                    year = StringsKt.toIntOrNull(value);
                } else {
                    year = null;
                }
                $this$map$iv = document.select("div.cf-movie-tags-row a");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv2 : $this$map$iv) {
                    destination$iv$iv2.add(((Element) item$iv$iv2).text());
                    $this$map$iv = $this$map$iv;
                }
                tags = (List) destination$iv$iv2;
                $this$mapNotNull$iv = document.select("div.cf-related-grid-full a.cf-related-item");
                $i$f$mapNotNull = 0;
                destination$iv$iv3 = new ArrayList();
                $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                it3 = $this$mapNotNullTo$iv$iv.iterator();
                while (true) {
                    tags2 = tags;
                    str3 = "src";
                    if (it3.hasNext()) {
                        recommendations = (List) destination$iv$iv3;
                        if (type == TvType.TvSeries && type != TvType.Anime) {
                            TvType tvType2 = TvType.Movie;
                            Score rating3 = rating2;
                            C00043 c00043 = new C00043(poster, bannerUrl, description, tags2, rating3, year, recommendations, cast, null);
                            c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(style);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(bannerUrl);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(description);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(type);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(cast);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(rating3);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(year);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(tags2);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(recommendations);
                            c00022.label = 3;
                            objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url3, tvType2, url3, c00043, c00022);
                            return objNewMovieLoadResponse == obj ? obj : (LoadResponse) objNewMovieLoadResponse;
                        }
                        $this$mapIndexed$iv = document.select(".cf-episode-item");
                        $i$f$mapIndexed = 0;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                        $i$f$mapIndexedTo = 0;
                        index$iv$iv = 0;
                        for (Object item$iv$iv3 : $this$mapIndexedTo$iv$iv) {
                            int index$iv$iv2 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Element ep = (Element) item$iv$iv3;
                            Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                            int $i$f$mapIndexed2 = $i$f$mapIndexed;
                            String title4 = title2;
                            String url4 = url3;
                            Iterable $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv;
                            matchResultFind$default = Regex.find$default(new Regex("window\\.location\\.href='([^']+)'"), ep.attr("onclick"), 0, 2, (Object) null);
                            if (matchResultFind$default != null || (groupValues3 = matchResultFind$default.getGroupValues()) == null || (href = (String) groupValues3.get(1)) == null) {
                                href = str;
                            }
                            elementSelectFirst5 = ep.selectFirst(".cf-episode-title");
                            if (elementSelectFirst5 != null) {
                                title3 = elementSelectFirst5.text();
                            } else {
                                title3 = null;
                            }
                            elementSelectFirst6 = ep.selectFirst(".cf-episode-num-badge");
                            if (elementSelectFirst6 != null || (strText3 = elementSelectFirst6.text()) == null) {
                                number = null;
                            } else {
                                number = StringsKt.toIntOrNull(strText3);
                            }
                            Coflix coflix = this;
                            elementSelectFirst7 = ep.selectFirst(".cf-episode-thumb img");
                            if (elementSelectFirst7 != null) {
                                strAttr2 = elementSelectFirst7.attr(str3);
                            } else {
                                strAttr2 = null;
                            }
                            final String poster2 = MainAPIKt.fixUrlNull(coflix, strAttr2);
                            String str8 = str3;
                            Regex regex = new Regex("(\\d+)x\\d+");
                            if (title3 == null) {
                                str4 = str;
                            } else {
                                str4 = title3;
                            }
                            Integer number2 = number;
                            str5 = str;
                            int $i$f$mapIndexedTo2 = $i$f$mapIndexedTo;
                            matchResultFind$default2 = Regex.find$default(regex, str4, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null || (str7 = (String) groupValues2.get(1)) == null) {
                                season = null;
                            } else {
                                season = StringsKt.toIntOrNull(str7);
                            }
                            Regex regex2 = new Regex("\\d+x(\\d+)");
                            if (title3 == null) {
                                str6 = str5;
                            } else {
                                str6 = title3;
                            }
                            matchResultFind$default3 = Regex.find$default(regex2, str6, 0, 2, (Object) null);
                            if (matchResultFind$default3 == null && (groupValues = matchResultFind$default3.getGroupValues()) != null) {
                                String str9 = (String) groupValues.get(1);
                                if (str9 == null || (episode = StringsKt.toIntOrNull(str9)) == null) {
                                }
                                destination$iv$iv4.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.Coflix.Coflix$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj3) {
                                        return Coflix.load$lambda$5$0(title3, season, episode, poster2, (Episode) obj3);
                                    }
                                }));
                                index$iv$iv = index$iv$iv2;
                                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                                $i$f$mapIndexed = $i$f$mapIndexed2;
                                title2 = title4;
                                url3 = url4;
                                $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv2;
                                str3 = str8;
                                str = str5;
                                $i$f$mapIndexedTo = $i$f$mapIndexedTo2;
                            }
                            destination$iv$iv4.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.Coflix.Coflix$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj3) {
                                    return Coflix.load$lambda$5$0(title3, season, episode, poster2, (Episode) obj3);
                                }
                            }));
                            index$iv$iv = index$iv$iv2;
                            $this$mapIndexed$iv = $this$mapIndexed$iv2;
                            $i$f$mapIndexed = $i$f$mapIndexed2;
                            title2 = title4;
                            url3 = url4;
                            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv2;
                            str3 = str8;
                            str = str5;
                            $i$f$mapIndexedTo = $i$f$mapIndexedTo2;
                        }
                        String title5 = title2;
                        List episodes = (List) destination$iv$iv4;
                        Score rating4 = rating2;
                        C00032 c00032 = new C00032(poster, bannerUrl, description, tags2, rating4, year, recommendations, cast, null);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(title5);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(style);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(bannerUrl);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(description);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(type);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(cast);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(rating4);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(year);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(tags2);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00022.label = 2;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title5, url3, type, episodes, c00032, c00022);
                        if (objNewTvSeriesLoadResponse == obj) {
                            return obj;
                        }
                        return (LoadResponse) objNewTvSeriesLoadResponse;
                    }
                    Object element$iv$iv$iv = it3.next();
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Element it5 = (Element) element$iv$iv$iv;
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    elementSelectFirst8 = it5.selectFirst("span.cf-related-name");
                    if (elementSelectFirst8 != null || (recTitle = elementSelectFirst8.text()) == null) {
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                        String href2 = MainAPIKt.fixUrlNull(this, it5.attr("href"));
                        if (href2 == null) {
                            str2 = str2;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            Coflix coflix2 = this;
                            Element elementSelectFirst9 = it5.selectFirst("img.cf-related-cover");
                            final String recPoster = MainAPIKt.fixUrlNull(coflix2, elementSelectFirst9 != null ? elementSelectFirst9.attr("src") : null);
                            Element elementSelectFirst10 = it5.selectFirst("span.cf-related-year");
                            final Integer recYear = (elementSelectFirst10 == null || (strText4 = elementSelectFirst10.text()) == null) ? null : StringsKt.toIntOrNull(strText4);
                            str2 = str2;
                            TvType recType = StringsKt.contains(href2, str2, true) ? TvType.Anime : StringsKt.contains(href2, "/film/", true) ? TvType.Movie : TvType.TvSeries;
                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, recTitle, href2, recType, false, new Function1() { // from class: com.Coflix.Coflix$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj3) {
                                    return Coflix.load$lambda$4$0(recPoster, recYear, (MovieSearchResponse) obj3);
                                }
                            }, 8, (Object) null);
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        destination$iv$iv3.add(movieSearchResponseNewMovieSearchResponse$default);
                    }
                    tags = tags2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    str2 = str2;
                }
                break;
            case 1:
                String url5 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url5;
                obj = coroutine_suspended;
                z = true;
                obj2 = $result2;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h1.cf-movie-title");
                if (elementSelectFirst != null) {
                    strText = "Unknown";
                } else {
                    strText = "Unknown";
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, document.select("div.cf-movie-cover-wrap a").attr("href"));
                elementSelectFirst2 = document.selectFirst("div.cf-movie-banner");
                if (elementSelectFirst2 != null) {
                    strAttr = elementSelectFirst2.attr("style");
                } else {
                    strAttr = null;
                }
                str = "";
                if (strAttr == null) {
                    strAttr = "";
                }
                style = strAttr;
                it = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(style, "url(", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null), new char[]{'\"', '\''});
                if (StringsKt.startsWith$default(it, "//", false, 2, (Object) null)) {
                    bannerUrl = "https:" + it;
                } else {
                    bannerUrl = it;
                }
                elementSelectFirst3 = document.selectFirst("div.cf-synopsis-text p");
                if (elementSelectFirst3 != null) {
                    description = elementSelectFirst3.text();
                } else {
                    description = null;
                }
                Log.INSTANCE.d("Phisher", url2);
                str2 = "/anime/";
                if (StringsKt.contains(url2, "/anime/", z)) {
                    tvType = TvType.Anime;
                } else if (StringsKt.contains(url2, "/film/", z)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                type = tvType;
                Iterable $this$map$iv3 = document.select("div.cf-cast-row span");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r23.hasNext()) {
                    destination$iv$iv.add(((Element) item$iv$iv).text());
                }
                cast = (List) destination$iv$iv;
                Score.Companion companion2 = Score.Companion;
                elementSelectFirst4 = document.selectFirst(".cf-stat-rating .cf-stat-primary");
                if (elementSelectFirst4 != null) {
                    strText2 = elementSelectFirst4.text();
                } else {
                    strText2 = null;
                }
                rating = companion2.from10(strText2);
                it2 = document.select(".cf-stat-item").iterator();
                while (true) {
                    if (it2.hasNext()) {
                        rating2 = rating;
                        $result = $result2;
                        it4 = it2;
                        title2 = title;
                        url3 = url2;
                        matchResultFind$default4 = Regex.find$default(new Regex("\\b(19|20)\\d{2}\\b"), ((Element) it2.next()).text(), 0, 2, (Object) null);
                        if (matchResultFind$default4 != null) {
                            value = matchResultFind$default4.getValue();
                        } else {
                            value = null;
                        }
                        if (value != null) {
                            rating = rating2;
                            it2 = it4;
                            $result2 = $result;
                            title = title2;
                            url2 = url3;
                        }
                    } else {
                        rating2 = rating;
                        title2 = title;
                        url3 = url2;
                        value = null;
                    }
                }
                if (value != null) {
                    year = StringsKt.toIntOrNull(value);
                } else {
                    year = null;
                }
                $this$map$iv = document.select("div.cf-movie-tags-row a");
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r10.hasNext()) {
                    destination$iv$iv2.add(((Element) item$iv$iv2).text());
                    $this$map$iv = $this$map$iv;
                }
                tags = (List) destination$iv$iv2;
                $this$mapNotNull$iv = document.select("div.cf-related-grid-full a.cf-related-item");
                $i$f$mapNotNull = 0;
                destination$iv$iv3 = new ArrayList();
                $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                it3 = $this$mapNotNullTo$iv$iv.iterator();
                while (true) {
                    tags2 = tags;
                    str3 = "src";
                    if (it3.hasNext()) {
                        recommendations = (List) destination$iv$iv3;
                        if (type == TvType.TvSeries) {
                        }
                        $this$mapIndexed$iv = document.select(".cf-episode-item");
                        $i$f$mapIndexed = 0;
                        destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                        $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                        $i$f$mapIndexedTo = 0;
                        index$iv$iv = 0;
                        while (r14.hasNext()) {
                            int index$iv$iv3 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            Element ep2 = (Element) item$iv$iv3;
                            Iterable $this$mapIndexed$iv3 = $this$mapIndexed$iv;
                            int $i$f$mapIndexed3 = $i$f$mapIndexed;
                            String title6 = title2;
                            String url6 = url3;
                            Iterable $this$mapIndexedTo$iv$iv3 = $this$mapIndexedTo$iv$iv;
                            matchResultFind$default = Regex.find$default(new Regex("window\\.location\\.href='([^']+)'"), ep2.attr("onclick"), 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                href = str;
                            } else {
                                href = str;
                            }
                            elementSelectFirst5 = ep2.selectFirst(".cf-episode-title");
                            if (elementSelectFirst5 != null) {
                                title3 = elementSelectFirst5.text();
                            } else {
                                title3 = null;
                            }
                            elementSelectFirst6 = ep2.selectFirst(".cf-episode-num-badge");
                            if (elementSelectFirst6 != null) {
                                number = null;
                            } else {
                                number = null;
                            }
                            Coflix coflix3 = this;
                            elementSelectFirst7 = ep2.selectFirst(".cf-episode-thumb img");
                            if (elementSelectFirst7 != null) {
                                strAttr2 = elementSelectFirst7.attr(str3);
                            } else {
                                strAttr2 = null;
                            }
                            final String poster3 = MainAPIKt.fixUrlNull(coflix3, strAttr2);
                            String str10 = str3;
                            Regex regex3 = new Regex("(\\d+)x\\d+");
                            if (title3 == null) {
                                str4 = str;
                            } else {
                                str4 = title3;
                            }
                            Integer number3 = number;
                            str5 = str;
                            int $i$f$mapIndexedTo3 = $i$f$mapIndexedTo;
                            matchResultFind$default2 = Regex.find$default(regex3, str4, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                season = null;
                            } else {
                                season = null;
                            }
                            Regex regex4 = new Regex("\\d+x(\\d+)");
                            if (title3 == null) {
                                str6 = str5;
                            } else {
                                str6 = title3;
                            }
                            matchResultFind$default3 = Regex.find$default(regex4, str6, 0, 2, (Object) null);
                            final Integer episode = matchResultFind$default3 == null ? number3 : number3;
                            destination$iv$iv4.add(MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.Coflix.Coflix$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj3) {
                                    return Coflix.load$lambda$5$0(title3, season, episode, poster3, (Episode) obj3);
                                }
                            }));
                            index$iv$iv = index$iv$iv3;
                            $this$mapIndexed$iv = $this$mapIndexed$iv3;
                            $i$f$mapIndexed = $i$f$mapIndexed3;
                            title2 = title6;
                            url3 = url6;
                            $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv3;
                            str3 = str10;
                            str = str5;
                            $i$f$mapIndexedTo = $i$f$mapIndexedTo3;
                        }
                        String title7 = title2;
                        List episodes2 = (List) destination$iv$iv4;
                        Score rating5 = rating2;
                        C00032 c00033 = new C00032(poster, bannerUrl, description, tags2, rating5, year, recommendations, cast, null);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(title7);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(style);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(bannerUrl);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(description);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(type);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(cast);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(rating5);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(year);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(tags2);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(recommendations);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(episodes2);
                        c00022.label = 2;
                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title7, url3, type, episodes2, c00033, c00022);
                        if (objNewTvSeriesLoadResponse == obj) {
                            return obj;
                        }
                        return (LoadResponse) objNewTvSeriesLoadResponse;
                    }
                    Object element$iv$iv$iv2 = it3.next();
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it6 = (Element) element$iv$iv$iv2;
                    int $i$f$mapNotNull3 = $i$f$mapNotNull;
                    elementSelectFirst8 = it6.selectFirst("span.cf-related-name");
                    if (elementSelectFirst8 != null) {
                    }
                    movieSearchResponseNewMovieSearchResponse$default = null;
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        destination$iv$iv3.add(movieSearchResponseNewMovieSearchResponse$default);
                    }
                    tags = tags2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    $i$f$mapNotNull = $i$f$mapNotNull3;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                    str2 = str2;
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result2);
                objNewTvSeriesLoadResponse = $result2;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result2);
                objNewMovieLoadResponse = $result2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(String $recPoster, Integer $recYear, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($recPoster);
        if ($recYear != null) {
            $this$newMovieSearchResponse.setYear($recYear);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$0(String $title, Integer $season, Integer $episode, String $poster, Episode $this$newEpisode) {
        $this$newEpisode.setName($title);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode($episode);
        $this$newEpisode.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$load$2 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix$load$2", f = "Coflix.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bannerUrl;
        final /* synthetic */ List<String> $cast;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $rating;
        final /* synthetic */ List<MovieSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, String str2, String str3, List<String> list, Score score, Integer num, List<MovieSearchResponse> list2, List<String> list3, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bannerUrl = str2;
            this.$description = str3;
            this.$tags = list;
            this.$rating = score;
            this.$year = num;
            this.$recommendations = list2;
            this.$cast = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$poster, this.$bannerUrl, this.$description, this.$tags, this.$rating, this.$year, this.$recommendations, this.$cast, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$bannerUrl);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(this.$rating);
                    loadResponse.setYear(this.$year);
                    loadResponse.setRecommendations(this.$recommendations);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$cast);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$load$3 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix$load$3", f = "Coflix.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bannerUrl;
        final /* synthetic */ List<String> $cast;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $rating;
        final /* synthetic */ List<MovieSearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, String str2, String str3, List<String> list, Score score, Integer num, List<MovieSearchResponse> list2, List<String> list3, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bannerUrl = str2;
            this.$description = str3;
            this.$tags = list;
            this.$rating = score;
            this.$year = num;
            this.$recommendations = list2;
            this.$cast = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$poster, this.$bannerUrl, this.$description, this.$tags, this.$rating, this.$year, this.$recommendations, this.$cast, continuation);
            c00043.L$0 = obj;
            return c00043;
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
                    loadResponse.setBackgroundPosterUrl(this.$bannerUrl);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setScore(this.$rating);
                    loadResponse.setYear(this.$year);
                    loadResponse.setRecommendations(this.$recommendations);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$cast);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0136 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0137  */
    /* JADX WARN: Code duplicated, block: B:26:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0191  */
    /* JADX WARN: Code duplicated, block: B:30:0x01e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj;
        boolean isCasting2;
        String referer;
        boolean isCasting3;
        String data3;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Object obj2;
        boolean z;
        C00051 c00052;
        String referer2;
        Function1<? super SubtitleFile, Unit> function7;
        Function1<? super ExtractorLink, Unit> function8;
        String referer3;
        boolean isCasting4;
        String iframe;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super SubtitleFile, Unit> function10;
        boolean isCasting5;
        C00051 c00053;
        String referer4;
        String referer5;
        String data4;
        Function1<? super SubtitleFile, Unit> function11;
        Function1<? super ExtractorLink, Unit> function12;
        boolean isCasting6;
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
                String mainUrl = getMainUrl();
                data2 = data;
                c00051.L$0 = data2;
                function3 = function1;
                c00051.L$1 = function3;
                function4 = function2;
                c00051.L$2 = function4;
                c00051.Z$0 = isCasting;
                c00051.label = 1;
                Object baseUrl = getBaseUrl(mainUrl, c00051);
                if (baseUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = baseUrl;
                isCasting2 = isCasting;
                referer = (String) obj;
                Requests app = MainActivityKt.getApp();
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00051.L$1 = function3;
                c00051.L$2 = function4;
                c00051.L$3 = referer;
                c00051.Z$0 = isCasting2;
                c00051.label = 2;
                isCasting3 = isCasting2;
                data3 = data2;
                function5 = function3;
                function6 = function4;
                C00051 c00054 = c00051;
                obj2 = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00054, 4094, (Object) null);
                c00052 = c00054;
                if ($result == obj2) {
                    return obj2;
                }
                referer2 = referer;
                function7 = function5;
                function8 = function6;
                referer3 = data3;
                isCasting4 = isCasting3;
                iframe = ((NiceResponse) $result).getDocument().select("#cfPlayerFrame").attr("src");
                Requests app2 = MainActivityKt.getApp();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(referer3);
                c00052.L$1 = function7;
                c00052.L$2 = function8;
                c00052.L$3 = referer2;
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframe);
                c00052.Z$0 = isCasting4;
                c00052.label = 3;
                C00051 c00055 = c00052;
                function9 = function8;
                function10 = function7;
                isCasting5 = isCasting4;
                $result = Requests.get$default(app2, iframe, (Map) null, referer2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00055, 4090, (Object) null);
                c00053 = c00055;
                if ($result == obj2) {
                    return obj2;
                }
                referer4 = iframe;
                referer5 = referer2;
                data4 = referer3;
                function11 = function10;
                function12 = function9;
                isCasting6 = isCasting5;
                Document doc = ((NiceResponse) $result).getDocument();
                listSelect = doc.select("li[onclick]");
                c00062 = new C00062(referer5, function11, function12, null);
                c00053.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00053.L$1 = SpillingKt.nullOutSpilledVariable(function11);
                c00053.L$2 = SpillingKt.nullOutSpilledVariable(function12);
                c00053.L$3 = SpillingKt.nullOutSpilledVariable(referer5);
                c00053.L$4 = SpillingKt.nullOutSpilledVariable(referer4);
                c00053.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                c00053.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00053.Z$0 = isCasting6;
                c00053.label = 4;
                if (ParCollectionsKt.amap(listSelect, c00062, c00053) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00051.Z$0;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00051.L$2;
                function3 = (Function1) c00051.L$1;
                String data5 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function13;
                data2 = data5;
                obj = $result;
                referer = (String) obj;
                Requests app3 = MainActivityKt.getApp();
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00051.L$1 = function3;
                c00051.L$2 = function4;
                c00051.L$3 = referer;
                c00051.Z$0 = isCasting2;
                c00051.label = 2;
                isCasting3 = isCasting2;
                data3 = data2;
                function5 = function3;
                function6 = function4;
                C00051 c00056 = c00051;
                obj2 = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app3, data3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00056, 4094, (Object) null);
                c00052 = c00056;
                if ($result == obj2) {
                    return obj2;
                }
                referer2 = referer;
                function7 = function5;
                function8 = function6;
                referer3 = data3;
                isCasting4 = isCasting3;
                iframe = ((NiceResponse) $result).getDocument().select("#cfPlayerFrame").attr("src");
                Requests app4 = MainActivityKt.getApp();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(referer3);
                c00052.L$1 = function7;
                c00052.L$2 = function8;
                c00052.L$3 = referer2;
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframe);
                c00052.Z$0 = isCasting4;
                c00052.label = 3;
                C00051 c00057 = c00052;
                function9 = function8;
                function10 = function7;
                isCasting5 = isCasting4;
                $result = Requests.get$default(app4, iframe, (Map) null, referer2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00057, 4090, (Object) null);
                c00053 = c00057;
                if ($result == obj2) {
                    return obj2;
                }
                referer4 = iframe;
                referer5 = referer2;
                data4 = referer3;
                function11 = function10;
                function12 = function9;
                isCasting6 = isCasting5;
                Document doc2 = ((NiceResponse) $result).getDocument();
                listSelect = doc2.select("li[onclick]");
                c00062 = new C00062(referer5, function11, function12, null);
                c00053.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00053.L$1 = SpillingKt.nullOutSpilledVariable(function11);
                c00053.L$2 = SpillingKt.nullOutSpilledVariable(function12);
                c00053.L$3 = SpillingKt.nullOutSpilledVariable(referer5);
                c00053.L$4 = SpillingKt.nullOutSpilledVariable(referer4);
                c00053.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                c00053.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00053.Z$0 = isCasting6;
                c00053.label = 4;
                if (ParCollectionsKt.amap(listSelect, c00062, c00053) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting7 = c00051.Z$0;
                String referer6 = (String) c00051.L$3;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00051.L$2;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00051.L$1;
                String data6 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                c00052 = c00051;
                obj2 = coroutine_suspended;
                isCasting4 = isCasting7;
                referer2 = referer6;
                function8 = function14;
                function7 = function15;
                referer3 = data6;
                z = true;
                iframe = ((NiceResponse) $result).getDocument().select("#cfPlayerFrame").attr("src");
                Requests app5 = MainActivityKt.getApp();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(referer3);
                c00052.L$1 = function7;
                c00052.L$2 = function8;
                c00052.L$3 = referer2;
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframe);
                c00052.Z$0 = isCasting4;
                c00052.label = 3;
                C00051 c00058 = c00052;
                function9 = function8;
                function10 = function7;
                isCasting5 = isCasting4;
                $result = Requests.get$default(app5, iframe, (Map) null, referer2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00058, 4090, (Object) null);
                c00053 = c00058;
                if ($result == obj2) {
                    return obj2;
                }
                referer4 = iframe;
                referer5 = referer2;
                data4 = referer3;
                function11 = function10;
                function12 = function9;
                isCasting6 = isCasting5;
                Document doc3 = ((NiceResponse) $result).getDocument();
                listSelect = doc3.select("li[onclick]");
                c00062 = new C00062(referer5, function11, function12, null);
                c00053.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00053.L$1 = SpillingKt.nullOutSpilledVariable(function11);
                c00053.L$2 = SpillingKt.nullOutSpilledVariable(function12);
                c00053.L$3 = SpillingKt.nullOutSpilledVariable(referer5);
                c00053.L$4 = SpillingKt.nullOutSpilledVariable(referer4);
                c00053.L$5 = SpillingKt.nullOutSpilledVariable(doc3);
                c00053.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00053.Z$0 = isCasting6;
                c00053.label = 4;
                if (ParCollectionsKt.amap(listSelect, c00062, c00053) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(z);
            case 3:
                boolean isCasting8 = c00051.Z$0;
                String iframe2 = (String) c00051.L$4;
                String referer7 = (String) c00051.L$3;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00051.L$2;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00051.L$1;
                String data7 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                c00053 = c00051;
                obj2 = coroutine_suspended;
                isCasting6 = isCasting8;
                data4 = data7;
                z = true;
                function11 = function17;
                function12 = function16;
                referer5 = referer7;
                referer4 = iframe2;
                Document doc4 = ((NiceResponse) $result).getDocument();
                listSelect = doc4.select("li[onclick]");
                c00062 = new C00062(referer5, function11, function12, null);
                c00053.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                c00053.L$1 = SpillingKt.nullOutSpilledVariable(function11);
                c00053.L$2 = SpillingKt.nullOutSpilledVariable(function12);
                c00053.L$3 = SpillingKt.nullOutSpilledVariable(referer5);
                c00053.L$4 = SpillingKt.nullOutSpilledVariable(referer4);
                c00053.L$5 = SpillingKt.nullOutSpilledVariable(doc4);
                c00053.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00053.Z$0 = isCasting6;
                c00053.label = 4;
                if (ParCollectionsKt.amap(listSelect, c00062, c00053) == obj2) {
                    return obj2;
                }
                return Boxing.boxBoolean(z);
            case 4:
                boolean z2 = c00051.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Coflix.Coflix$loadLinks$2 */
    /* JADX INFO: compiled from: Coflix.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "li", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Coflix$loadLinks$2", f = "Coflix.kt", i = {0, 0, 0, 0}, l = {178}, m = "invokeSuspend", n = {"li", "onclick", "base64encoded", "url"}, nl = {179}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $referer;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$referer = str;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = new C00062(this.$referer, this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element li = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String onclick = li.attr("onclick");
                        String base64encoded = StringsKt.trim(StringsKt.substringBefore$default(StringsKt.substringAfter$default(onclick, "showVideo('", (String) null, 2, (Object) null), "',", (String) null, 2, (Object) null)).toString();
                        if (base64encoded.length() > 0) {
                            String url = MainAPIKt.base64Decode(base64encoded);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(onclick);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(base64encoded);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(url);
                            this.label = 1;
                            if (ExtractorApiKt.loadExtractor(url, this.$referer, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getBaseUrl(String url, Continuation<? super String> continuation) {
        C00001 c00001;
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
                c00001.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00001.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((NiceResponse) $result).getUrl();
    }
}
