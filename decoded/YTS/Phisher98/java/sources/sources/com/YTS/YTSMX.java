package com.YTS;

import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
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

/* JADX INFO: compiled from: YTS MAX.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/YTS/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010.J\u0012\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/YTS/YTSMX;", "Lcom/YTS/YTS;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasQuickSearch", "getHasQuickSearch", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndexQuality", "str", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "YTS"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYTS MAX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YTS MAX.kt\ncom/YTS/YTSMX\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1795#2,10:122\n2068#2:132\n2069#2:134\n1805#2:135\n1739#2:136\n1814#2,3:137\n1#3:133\n*S KotlinDebug\n*F\n+ 1 YTS MAX.kt\ncom/YTS/YTSMX\n*L\n52#1:122,10\n52#1:132\n52#1:134\n52#1:135\n84#1:136\n84#1:137,3\n52#1:133\n*E\n"})
public final class YTSMX extends YTS {

    @NotNull
    private String mainUrl = "https://yts.bz";

    @NotNull
    private String name = "YTS MX";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasQuickSearch = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Torrent});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("browse-movies", "Latest"), TuplesKt.to("browse-movies/0/all/all/0/featured/0/all", "Featured Movies"), TuplesKt.to("browse-movies/0/1080p.x265/all/0/latest/0/all", "1080p Movies"), TuplesKt.to("browse-movies/0/2160p/all/0/latest/0/all", "4K Movies"), TuplesKt.to("browse-movies/0/all/all/0/seeds/0/all", "Best Seeds Movies")});

    /* JADX INFO: renamed from: com.YTS.YTSMX$getMainPage$1 */
    /* JADX INFO: compiled from: YTS MAX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.YTS.YTSMX", f = "YTS MAX.kt", i = {0, 0, 0}, l = {51}, m = "getMainPage", n = {"request", "url", "page"}, nl = {52}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YTSMX.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.YTS.YTSMX$load$1 */
    /* JADX INFO: compiled from: YTS MAX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.YTS.YTSMX", f = "YTS MAX.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {78, 87}, m = "load", n = {"url", "url", "document", "title", "poster", "year", "tags", "description", "rating"}, nl = {79, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YTSMX.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.YTS.YTSMX$loadLinks$1 */
    /* JADX INFO: compiled from: YTS MAX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.YTS.YTSMX", f = "YTS MAX.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {102, 103}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {103, 119}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YTSMX.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    @Override // com.YTS.YTS
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.YTS.YTS
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.YTS.YTS
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.YTS.YTS
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.YTS.YTS
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.YTS.YTS
    @NotNull
    public String getLang() {
        return this.lang;
    }

    @Override // com.YTS.YTS
    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Override // com.YTS.YTS
    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @Override // com.YTS.YTS
    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @Override // com.YTS.YTS
    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // com.YTS.YTS
    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.YTS.YTS
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00061 c00061;
        boolean z;
        int page2;
        MainPageRequest request2;
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
                String url = page == 1 ? getMainUrl() + '/' + request.getData() : getMainUrl() + '/' + request.getData() + "?page=" + page;
                Requests app = MainActivityKt.getApp();
                c00061.L$0 = request;
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00061.I$0 = page;
                c00061.label = 1;
                z = true;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c00061, 3838, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00061.I$0;
                request2 = (MainPageRequest) c00061.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.row div.browse-movie-wrap");
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
        String strText;
        String title = StringsKt.trim($this$toSearchResult.select("div.browse-movie-bottom a").text()).toString();
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("img").attr("src"));
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a div.browse-movie-year");
        final Integer year = (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? null : StringsKt.toIntOrNull(strText);
        final String rating = StringsKt.substringBefore$default($this$toSearchResult.select("h4.rating").text(), StringsKt.trim("/").toString(), (String) null, 2, (Object) null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.YTS.YTSMX$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return YTSMX.toSearchResult$lambda$0(posterUrl, year, rating, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, Integer $year, String $rating, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setYear($year);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($rating));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.YTS.YTS
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00071 c00071;
        Object obj;
        Object obj2;
        String url2;
        String string;
        List tags;
        String strText;
        String strText2;
        String string2;
        Iterable iterableSplit$default;
        String strText3;
        String string3;
        String strText4;
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
        C00071 c00072 = c00071;
        Object $result = c00072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00072.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00072.L$0 = url;
                c00072.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 4094, (Object) null);
                c00072 = c00072;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00072.L$0;
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
        Element elementSelectFirst = document.selectFirst("#mobile-movie-info h1");
        if (elementSelectFirst == null || (strText4 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText4).toString()) == null) {
            string = "No Title";
        }
        String title = string;
        String poster = document.select("#movie-poster img").attr("src");
        Element elementSelectFirst2 = document.selectFirst("#mobile-movie-info h2");
        Integer year = (elementSelectFirst2 == null || (strText3 = elementSelectFirst2.text()) == null || (string3 = StringsKt.trim(strText3).toString()) == null) ? null : StringsKt.toIntOrNull(string3);
        Element elementSelectFirst3 = document.selectFirst("#mobile-movie-info > h2:nth-child(3)");
        if (elementSelectFirst3 == null || (strText2 = elementSelectFirst3.text()) == null || (string2 = StringsKt.trim(strText2).toString()) == null || (iterableSplit$default = StringsKt.split$default(string2, new String[]{" / "}, false, 0, 6, (Object) null)) == null) {
            tags = null;
        } else {
            Iterable $this$map$iv = iterableSplit$default;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(StringsKt.trim(it).toString());
            }
            tags = (List) destination$iv$iv;
        }
        Element elementSelectFirst4 = document.selectFirst("#synopsis p");
        String description = (elementSelectFirst4 == null || (strText = elementSelectFirst4.text()) == null) ? null : StringsKt.trim(strText).toString();
        String rating = document.select("#movie-info > div.bottom-info > div:nth-child(2) > span:nth-child(2)").text();
        TvType tvType = TvType.Movie;
        C00082 c00082 = new C00082(poster, description, year, rating, tags, null);
        c00072.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00072.L$1 = SpillingKt.nullOutSpilledVariable(document);
        c00072.L$2 = SpillingKt.nullOutSpilledVariable(title);
        c00072.L$3 = SpillingKt.nullOutSpilledVariable(poster);
        c00072.L$4 = SpillingKt.nullOutSpilledVariable(year);
        c00072.L$5 = SpillingKt.nullOutSpilledVariable(tags);
        c00072.L$6 = SpillingKt.nullOutSpilledVariable(description);
        c00072.L$7 = SpillingKt.nullOutSpilledVariable(rating);
        c00072.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, url2, c00082, c00072);
        return objNewMovieLoadResponse == obj ? obj : objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.YTS.YTSMX$load$2 */
    /* JADX INFO: compiled from: YTS MAX.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.YTS.YTSMX$load$2", f = "YTS MAX.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00082 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(String str, String str2, Integer num, String str3, List<String> list, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$year = num;
            this.$rating = str3;
            this.$tags = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = new C00082(this.$poster, this.$description, this.$year, this.$rating, this.$tags, continuation);
            c00082.L$0 = obj;
            return c00082;
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
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getIndexQuality(String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.YTS.YTS
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00091 c00091;
        Object obj;
        boolean z;
        C00091 c00092;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00102 c00102;
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
                Requests app = MainActivityKt.getApp();
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00091.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00091.L$2 = function2;
                c00091.Z$0 = isCasting;
                c00091.label = 1;
                C00091 c00093 = c00091;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00093, 4094, (Object) null);
                c00092 = c00093;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select("a.magnet-download.download-torrent.magnet");
                c00102 = new C00102(function4, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00092.Z$0 = isCasting2;
                c00092.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00102, c00092) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00091.Z$0;
                function4 = (Function1) c00091.L$2;
                function3 = (Function1) c00091.L$1;
                data2 = (String) c00091.L$0;
                ResultKt.throwOnFailure($result);
                c00092 = c00091;
                obj = coroutine_suspended;
                z = true;
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select("a.magnet-download.download-torrent.magnet");
                c00102 = new C00102(function4, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00092.Z$0 = isCasting2;
                c00092.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00102, c00092) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00091.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.YTS.YTSMX$loadLinks$2 */
    /* JADX INFO: compiled from: YTS MAX.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.YTS.YTSMX$loadLinks$2", f = "YTS MAX.kt", i = {0, 0, 0}, l = {108}, m = "invokeSuspend", n = {"it", "magnet", "quality"}, nl = {107}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00102 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = YTSMX.this.new C00102(this.$callback, continuation);
            c00102.L$0 = obj;
            return c00102;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String magnet = it.attr("href");
                    int quality = YTSMX.this.getIndexQuality(it.attr("title"));
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(magnet);
                    this.L$2 = function2;
                    this.I$0 = quality;
                    this.label = 1;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(YTSMX.this.getName(), YTSMX.this.getName(), magnet, ExtractorLinkType.MAGNET, new AnonymousClass1(quality, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function2;
                    break;
                case 1:
                    int i = this.I$0;
                    function1 = (Function1) this.L$2;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(objNewExtractorLink);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.YTS.YTSMX$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: YTS MAX.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.YTS.YTSMX$loadLinks$2$1", f = "YTS MAX.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$quality, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer("");
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
