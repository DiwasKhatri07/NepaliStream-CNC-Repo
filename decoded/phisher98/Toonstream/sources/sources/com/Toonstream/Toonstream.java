package com.Toonstream;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Toonstream.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Toonstream/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\f\u0010)\u001a\u00020'*\u00020(H\u0002J\u001e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101JF\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000e2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020806H\u0096@¢\u0006\u0002\u0010;R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"Lcom/Toonstream/Toonstream;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "toSearch", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Toonstream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nToonstream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Toonstream.kt\ncom/Toonstream/Toonstream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,249:1\n1795#2,10:250\n2068#2:260\n2069#2:262\n1805#2:263\n1795#2,10:264\n2068#2:274\n2069#2:276\n1805#2:277\n1739#2:278\n1814#2,3:279\n2068#2:282\n2068#2:283\n2069#2:285\n2069#2:286\n1#3:261\n1#3:275\n1#3:284\n*S KotlinDebug\n*F\n+ 1 Toonstream.kt\ncom/Toonstream/Toonstream\n*L\n31#1:250,10\n31#1:260\n31#1:262\n31#1:263\n68#1:264,10\n68#1:274\n68#1:276\n68#1:277\n79#1:278\n79#1:279,3\n89#1:282\n94#1:283\n94#1:285\n89#1:286\n31#1:261\n68#1:275\n*E\n"})
public final class Toonstream extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Toonstream$mainUrl$1(null));

    @NotNull
    private String name = "Toonstream";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("series", "Series"), TuplesKt.to("category/movies", "Movies"), TuplesKt.to("category/cartoon", "Cartoon"), TuplesKt.to("category/anime", "Animes")});

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$getMainPage$1 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream", f = "Toonstream.kt", i = {0, 0}, l = {30}, m = "getMainPage", n = {"request", "page"}, nl = {31}, s = {"L$0", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Toonstream.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$load$1 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream", f = "Toonstream.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {73, 92, 127, 136}, m = "load", n = {"url", "url", "document", "title", "posterraw", "poster", "bgposter", "description", "cast", "duration", "tvtag", "episodes", "$this$forEach$iv", "element$iv", "seasonItem", "seasonUrl", "url", "document", "title", "posterraw", "poster", "bgposter", "description", "cast", "duration", "tvtag", "episodes", "url", "document", "title", "posterraw", "poster", "bgposter", "description", "cast", "duration", "tvtag"}, nl = {74, 94, 136, 85}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Toonstream.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$loadLinks$1 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream", f = "Toonstream.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {152, 153}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {153, 181}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return Toonstream.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$search$1 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream", f = "Toonstream.kt", i = {0, 0}, l = {67}, m = "search", n = {"query", "page"}, nl = {68}, s = {"L$0", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
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
            return Toonstream.this.search(null, 0, (Continuation) this);
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
        C00041 c00041;
        boolean z;
        MainPageRequest request2;
        int page2 = page;
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
                String str = getMainUrl() + '/' + request.getData() + "?type=all&page=" + page2;
                c00041.L$0 = request;
                c00041.I$0 = page2;
                c00041.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00041.I$0;
                request2 = (MainPageRequest) c00041.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("#movies-a > ul > li");
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
        String title = StringsKt.replace$default(StringsKt.trim($this$toSearchResult.select("article  > header > h2").text()).toString(), "Watch Online", "", false, 4, (Object) null);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("article  > a").attr("href"));
        String posterUrlRaw = $this$toSearchResult.select("article  > div.post-thumbnail > figure > img").attr("src");
        final String poster = StringsKt.startsWith$default(posterUrlRaw, "http", false, 2, (Object) null) ? posterUrlRaw : "https:" + posterUrlRaw;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("span.vote");
        final String score = elementSelectFirst != null ? elementSelectFirst.ownText() : null;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Toonstream.Toonstream$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Toonstream.toSearchResult$lambda$0(poster, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $poster, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    private final SearchResponse toSearch(Element $this$toSearch) {
        String title = StringsKt.replace$default(StringsKt.trim($this$toSearch.select("article  > header > h2").text()).toString(), "Watch Online", "", false, 4, (Object) null);
        String href = MainAPIKt.fixUrl(this, $this$toSearch.select("article  > a").attr("href"));
        String posterUrlRaw = $this$toSearch.select("article figure img").attr("src");
        final String poster = StringsKt.startsWith$default(posterUrlRaw, "http", false, 2, (Object) null) ? posterUrlRaw : "https:" + posterUrlRaw;
        Element elementSelectFirst = $this$toSearch.selectFirst("span.vote");
        final String score = elementSelectFirst != null ? elementSelectFirst.ownText() : null;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Toonstream.Toonstream$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Toonstream.toSearch$lambda$0(poster, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearch$lambda$0(String $poster, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
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
                String str = getMainUrl() + "/s?q=" + query + "&type=all&page=" + page;
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00101.I$0 = page;
                c00101.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00101.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("#movies-a > ul > li");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse search = toSearch(it);
            if (search != null) {
                destination$iv$iv.add(search);
            }
        }
        List results = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(results, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0415  */
    /* JADX WARN: Code duplicated, block: B:103:0x0429  */
    /* JADX WARN: Code duplicated, block: B:104:0x0436  */
    /* JADX WARN: Code duplicated, block: B:105:0x0443  */
    /* JADX WARN: Code duplicated, block: B:49:0x0274  */
    /* JADX WARN: Code duplicated, block: B:51:0x02f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:56:0x033a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0353  */
    /* JADX WARN: Code duplicated, block: B:60:0x035f  */
    /* JADX WARN: Code duplicated, block: B:62:0x036e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0377  */
    /* JADX WARN: Code duplicated, block: B:68:0x038f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:72:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:77:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:81:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:84:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:87:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:92:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:95:0x0401  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x02fa -> B:53:0x031e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r45, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r46) {
        /*
            Method dump skipped, instruction units count: 1456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Toonstream.Toonstream.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0$1(String $episodeTitle, String $poster, Integer $season, Integer $episode, Episode $this$newEpisode) {
        $this$newEpisode.setName($episodeTitle);
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode($episode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$load$3 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream$load$3", f = "Toonstream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bgposter;
        final /* synthetic */ List<String> $cast;
        final /* synthetic */ String $description;
        final /* synthetic */ String $duration;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00063(String str, String str2, String str3, List<String> list, String str4, Continuation<? super C00063> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgposter = str2;
            this.$description = str3;
            this.$cast = list;
            this.$duration = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = new C00063(this.$poster, this.$bgposter, this.$description, this.$cast, this.$duration, continuation);
            c00063.L$0 = obj;
            return c00063;
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
                    loadResponse.setBackgroundPosterUrl(this.$bgposter);
                    loadResponse.setPlot(this.$description);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$cast);
                    LoadResponse.Companion.addDuration(loadResponse, this.$duration);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$load$4 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream$load$4", f = "Toonstream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00074 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bgposter;
        final /* synthetic */ List<String> $cast;
        final /* synthetic */ String $description;
        final /* synthetic */ String $duration;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00074(String str, String str2, String str3, List<String> list, String str4, Continuation<? super C00074> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgposter = str2;
            this.$description = str3;
            this.$cast = list;
            this.$duration = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00074 = new C00074(this.$poster, this.$bgposter, this.$description, this.$cast, this.$duration, continuation);
            c00074.L$0 = obj;
            return c00074;
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
                    loadResponse.setBackgroundPosterUrl(this.$bgposter);
                    loadResponse.setPlot(this.$description);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$cast);
                    LoadResponse.Companion.addDuration(loadResponse, this.$duration);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fb A[RETURN] */
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
        List listSelect;
        C00092 c00092;
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
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(data);
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
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select("#aa-options iframe");
                c00092 = new C00092(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00092, c00082) == obj) {
                    return obj;
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
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select("#aa-options iframe");
                c00092 = new C00092(function3, function4, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(document2);
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

    /* JADX INFO: renamed from: com.Toonstream.Toonstream$loadLinks$2 */
    /* JADX INFO: compiled from: Toonstream.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "iframe", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Toonstream.Toonstream$loadLinks$2", f = "Toonstream.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {160, 175}, m = "invokeSuspend", n = {"iframe", "embedPath", "embedUrl", "iframe", "embedPath", "embedUrl", "embedDoc", "innerIframe", "finalUrl"}, nl = {161, 176}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
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
        C00092(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = Toonstream.this.new C00092(this.$subtitleCallback, this.$callback, continuation);
            c00092.L$0 = obj;
            return c00092;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00b9 A[Catch: Exception -> 0x0117, TryCatch #0 {Exception -> 0x0117, blocks: (B:27:0x00ab, B:29:0x00b9, B:31:0x00c5, B:32:0x00cb, B:34:0x00d6, B:38:0x00e3, B:24:0x0078), top: B:48:0x0078 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00c5 A[Catch: Exception -> 0x0117, TryCatch #0 {Exception -> 0x0117, blocks: (B:27:0x00ab, B:29:0x00b9, B:31:0x00c5, B:32:0x00cb, B:34:0x00d6, B:38:0x00e3, B:24:0x0078), top: B:48:0x0078 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00d6 A[Catch: Exception -> 0x0117, TryCatch #0 {Exception -> 0x0117, blocks: (B:27:0x00ab, B:29:0x00b9, B:31:0x00c5, B:32:0x00cb, B:34:0x00d6, B:38:0x00e3, B:24:0x0078), top: B:48:0x0078 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00df  */
        /* JADX WARN: Code duplicated, block: B:37:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:40:0x0114 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x0115  */
        public final Object invokeSuspend(Object $result) {
            String embedPath;
            String embedUrl;
            Object obj;
            String embedUrl2;
            Element innerIframe;
            String finalUrl;
            String strAttr;
            String src;
            Element iframe = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String strAttr2 = iframe.attr("src");
                    if (StringsKt.isBlank(strAttr2)) {
                        strAttr2 = iframe.attr("data-src");
                    }
                    embedPath = strAttr2;
                    if (StringsKt.isBlank(embedPath)) {
                        return Unit.INSTANCE;
                    }
                    embedUrl = MainAPIKt.fixUrl(Toonstream.this, embedPath);
                    try {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedPath);
                        this.L$2 = embedUrl;
                        this.label = 1;
                        obj = Requests.get$default(MainActivityKt.getApp(), embedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Document embedDoc = ((NiceResponse) obj).getDocument();
                        innerIframe = embedDoc.selectFirst("iframe");
                        if (innerIframe != null) {
                            strAttr = innerIframe.attr("src");
                            if (StringsKt.isBlank(strAttr)) {
                                strAttr = innerIframe.attr("data-src");
                            }
                            src = strAttr;
                            if (StringsKt.isBlank(src)) {
                                finalUrl = embedUrl;
                            } else {
                                finalUrl = MainAPIKt.fixUrl(Toonstream.this, src);
                            }
                        } else {
                            finalUrl = embedUrl;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedPath);
                        this.L$2 = embedUrl;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(embedDoc);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(innerIframe);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(finalUrl);
                        this.label = 2;
                        if (ExtractorApiKt.loadExtractor(finalUrl, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e) {
                        embedUrl2 = embedUrl;
                        Log.INSTANCE.e("ToonStream", "Failed to load " + embedUrl2);
                    }
                    break;
                case 1:
                    String embedUrl3 = (String) this.L$2;
                    embedPath = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        embedUrl = embedUrl3;
                        obj = $result;
                        Document embedDoc2 = ((NiceResponse) obj).getDocument();
                        innerIframe = embedDoc2.selectFirst("iframe");
                        if (innerIframe != null) {
                            strAttr = innerIframe.attr("src");
                            if (StringsKt.isBlank(strAttr)) {
                                strAttr = innerIframe.attr("data-src");
                            }
                            src = strAttr;
                            if (StringsKt.isBlank(src)) {
                                finalUrl = MainAPIKt.fixUrl(Toonstream.this, src);
                            } else {
                                finalUrl = embedUrl;
                            }
                        } else {
                            finalUrl = embedUrl;
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(iframe);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(embedPath);
                        this.L$2 = embedUrl;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(embedDoc2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(innerIframe);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(finalUrl);
                        this.label = 2;
                        if (ExtractorApiKt.loadExtractor(finalUrl, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e2) {
                        embedUrl2 = embedUrl3;
                        Log.INSTANCE.e("ToonStream", "Failed to load " + embedUrl2);
                    }
                    break;
                case 2:
                    embedUrl2 = (String) this.L$2;
                    try {
                        ResultKt.throwOnFailure($result);
                        break;
                    } catch (Exception e3) {
                        Log.INSTANCE.e("ToonStream", "Failed to load " + embedUrl2);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
