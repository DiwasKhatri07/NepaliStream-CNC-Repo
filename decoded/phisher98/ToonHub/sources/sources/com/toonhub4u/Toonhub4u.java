package com.toonhub4u;

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
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Toonhub4u.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/ToonHub/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/toonhub4u/Toonhub4u;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ToonHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nToonhub4u.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Toonhub4u.kt\ncom/toonhub4u/Toonhub4u\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1795#2,10:137\n2068#2:147\n2069#2:149\n1805#2:150\n1795#2,10:152\n2068#2:162\n2069#2:164\n1805#2:165\n1739#2:166\n1814#2,3:167\n2068#2:170\n2068#2:171\n2068#2,2:172\n2069#2:174\n2069#2:175\n1#3:148\n1#3:151\n1#3:163\n1#3:176\n*S KotlinDebug\n*F\n+ 1 Toonhub4u.kt\ncom/toonhub4u/Toonhub4u\n*L\n39#1:137,10\n39#1:147\n39#1:149\n39#1:150\n62#1:152,10\n62#1:162\n62#1:164\n62#1:165\n73#1:166\n73#1:167,3\n76#1:170\n77#1:171\n85#1:172,2\n77#1:174\n76#1:175\n39#1:148\n62#1:163\n*E\n"})
public final class Toonhub4u extends MainAPI {

    @NotNull
    private String mainUrl = "https://toonhub4u.co";

    @NotNull
    private String name = "ToonHub4u";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("category/anime/anime-series", "Anime Series"), TuplesKt.to("category/anime/anime-movies", "Anime Movies"), TuplesKt.to("category/animated/animation-movies", "Animated Movies"), TuplesKt.to("category/animated/animated-series", "Animated Series"), TuplesKt.to("category/channel-list/cartoon-network", "Cartoon Network"), TuplesKt.to("category/channel-list/disney-xd-india", "Disney XD India"), TuplesKt.to("category/channel-list/disney", "Disney"), TuplesKt.to("category/ott-network/crunchyroll", "Crunchyroll"), TuplesKt.to("category/ott-network/amazon-prime-video", "Amazon Prime Video"), TuplesKt.to("category/ott-network/netflix", "Netflix"), TuplesKt.to("category/ott-network/jio-cinema", "Jio Cinema"), TuplesKt.to("category/language/hindi", "Hindi Language")});

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$getMainPage$1 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u", f = "Toonhub4u.kt", i = {0, 0}, l = {38}, m = "getMainPage", n = {"request", "page"}, nl = {39}, s = {"L$0", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Toonhub4u.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$load$1 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u", f = "Toonhub4u.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {67, 98, 105}, m = "load", n = {"url", "url", "document", "title", "backgroundposter", "poster", "description", "tvtag", "hrefs", "episodes", "url", "document", "title", "backgroundposter", "poster", "description", "tvtag", "hrefs"}, nl = {68, 105, 74}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Toonhub4u.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$loadLinks$1 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u", f = "Toonhub4u.kt", i = {0, 0, 0, 0, 0, 0}, l = {121}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "jsonArray", "links", "isCasting"}, nl = {133}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return Toonhub4u.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$search$1 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u", f = "Toonhub4u.kt", i = {0}, l = {61}, m = "search", n = {"query"}, nl = {62}, s = {"L$0"}, v = 2)
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
            return Toonhub4u.this.search(null, (Continuation) this);
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "/page/" + page + '/';
                c00011.L$0 = request;
                c00011.I$0 = page;
                c00011.label = 1;
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
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("li.post-item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, true), Boxing.boxBoolean(true));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = StringsKt.substringBefore$default(StringsKt.trim($this$toSearchResult.select("a").text()).toString(), "[", (String) null, 2, (Object) null);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        String strAttr = $this$toSearchResult.select("a img").attr("data-src");
        if (strAttr.length() == 0) {
            strAttr = $this$toSearchResult.select("a img").attr("src");
        }
        final String posterUrl = strAttr;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.toonhub4u.Toonhub4u$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Toonhub4u.toSearchResult$lambda$1(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
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
                String str = getMainUrl() + "/?s=" + query;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("li.post-item");
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

    /* JADX WARN: Code duplicated, block: B:28:0x0104  */
    /* JADX WARN: Code duplicated, block: B:34:0x0138  */
    /* JADX WARN: Code duplicated, block: B:37:0x0151  */
    /* JADX WARN: Code duplicated, block: B:38:0x0154  */
    /* JADX WARN: Code duplicated, block: B:42:0x017f A[LOOP:0: B:40:0x0177->B:42:0x017f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:48:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:51:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:53:0x0213  */
    /* JADX WARN: Code duplicated, block: B:55:0x0231  */
    /* JADX WARN: Code duplicated, block: B:57:0x023f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0249  */
    /* JADX WARN: Code duplicated, block: B:62:0x025c A[LOOP:4: B:60:0x0256->B:62:0x025c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:72:0x0332 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0333  */
    /* JADX WARN: Code duplicated, block: B:75:0x0340  */
    /* JADX WARN: Code duplicated, block: B:77:0x038f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x0390  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:87:0x028f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0285 A[SYNTHETIC] */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00021 c00021;
        Object obj;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String string;
        String title;
        String backgroundposter;
        String poster;
        Element elementSelectFirst2;
        String string2;
        String description;
        TvType tvType;
        TvType tvtag;
        Collection destination$iv$iv;
        String hrefs;
        Object objNewMovieLoadResponse;
        String title2;
        String backgroundposter2;
        String poster2;
        TvType tvtag2;
        String hrefs2;
        String backgroundposter3;
        String url3;
        List episodes;
        Iterable $this$forEach$iv;
        Object objNewTvSeriesLoadResponse;
        Element content;
        Object $result;
        Element pTag;
        List episodes2;
        MatchResult episodeMatch;
        List episodeLinks;
        Element nextSibling;
        MatchResult episodeMatch2;
        Iterable $this$forEach$iv2;
        String strAttr;
        String strAttr2;
        String strSubstringBefore$default;
        String strSubstringBefore$default2;
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
                Requests app = MainActivityKt.getApp();
                c00022.L$0 = url;
                c00022.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("meta[property=og:title]");
                if (elementSelectFirst != null || (strAttr2 = elementSelectFirst.attr("content")) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strAttr2, "[", (String) null, 2, (Object) null)) == null || (strSubstringBefore$default2 = StringsKt.substringBefore$default(strSubstringBefore$default, "1080", (String) null, 2, (Object) null)) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strSubstringBefore$default2).toString();
                }
                title = String.valueOf(string);
                backgroundposter = document.select("meta[property=og:image]").attr("content");
                poster = document.select("p:nth-child(3) > img").attr("src");
                elementSelectFirst2 = document.selectFirst("meta[property=og:description]");
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("content")) == null) {
                    string2 = null;
                } else {
                    string2 = StringsKt.trim(strAttr).toString();
                }
                description = string2;
                if (StringsKt.contains$default(document.select("div.entry-content p strong").text(), "TV Series", false, 2, (Object) null)) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvtag = tvType;
                AppUtils appUtils = AppUtils.INSTANCE;
                Iterable $this$map$iv = document.select("div.mks_toggle_content a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(StringsKt.replace$default(it.attr("href"), "/file/", "/embed/", false, 4, (Object) null));
                }
                hrefs = appUtils.toJson((List) destination$iv$iv);
                if (tvtag == TvType.TvSeries) {
                    TvType tvType2 = TvType.Movie;
                    C00044 c00044 = new C00044(poster, backgroundposter, description, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(description);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(hrefs);
                    c00022.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType2, hrefs, c00044, c00022);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title2 = title;
                    backgroundposter2 = backgroundposter;
                    poster2 = poster;
                    tvtag2 = tvtag;
                    hrefs2 = hrefs;
                    backgroundposter3 = url2;
                    url3 = description;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$forEach$iv = document.select(".entry-content.entry.clearfix");
                for (Object element$iv : $this$forEach$iv) {
                    String hrefs3 = hrefs;
                    content = (Element) element$iv;
                    Object $result3 = $result2;
                    $result = "p";
                    for (Object element$iv2 : content.select("p")) {
                        pTag = (Element) element$iv2;
                        Element content2 = content;
                        String title3 = title;
                        episodes2 = episodes;
                        String url4 = url2;
                        Iterable $this$forEach$iv3 = $this$forEach$iv;
                        episodeMatch = Regex.find$default(new Regex("Episode\\s*(\\d+)"), pTag.text(), 0, 2, (Object) null);
                        if (episodeMatch != null) {
                            final Integer episodeNumber = StringsKt.toIntOrNull((String) episodeMatch.getGroupValues().get(1));
                            episodeLinks = new ArrayList();
                            nextSibling = pTag.nextElementSibling();
                            while (nextSibling != null) {
                                episodeMatch2 = episodeMatch;
                                if (Intrinsics.areEqual(nextSibling.tagName(), "hr")) {
                                    episodes2.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(episodeLinks), new Function1() { // from class: com.toonhub4u.Toonhub4u$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj3) {
                                            return Toonhub4u.load$lambda$1$0$1(episodeNumber, (Episode) obj3);
                                        }
                                    }));
                                } else {
                                    if (Intrinsics.areEqual(nextSibling.tagName(), $result)) {
                                        $this$forEach$iv2 = nextSibling.select("a[href]");
                                        for (Object element$iv3 : $this$forEach$iv2) {
                                            Iterable $this$forEach$iv4 = $this$forEach$iv2;
                                            Element aTag = (Element) element$iv3;
                                            episodeLinks.add(StringsKt.replace$default(aTag.attr("href"), "/file/", "/embed/", false, 4, (Object) null));
                                            $this$forEach$iv2 = $this$forEach$iv4;
                                        }
                                    }
                                    nextSibling = nextSibling.nextElementSibling();
                                    episodeMatch = episodeMatch2;
                                }
                            }
                            episodes2.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(episodeLinks), new Function1() { // from class: com.toonhub4u.Toonhub4u$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj3) {
                                    return Toonhub4u.load$lambda$1$0$1(episodeNumber, (Episode) obj3);
                                }
                            }));
                        }
                        url2 = url4;
                        content = content2;
                        title = title3;
                        episodes = episodes2;
                        $this$forEach$iv = $this$forEach$iv3;
                        $result = $result;
                    }
                    hrefs = hrefs3;
                    $result2 = $result3;
                }
                String title4 = title;
                List episodes3 = episodes;
                String url5 = url2;
                TvType tvType3 = TvType.Anime;
                C00033 c00033 = new C00033(poster, backgroundposter, description, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(title4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(hrefs);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(episodes3);
                c00022.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title4, url5, tvType3, episodes3, c00033, c00022);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url6 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                url2 = url6;
                obj2 = $result2;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("meta[property=og:title]");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                backgroundposter = document.select("meta[property=og:image]").attr("content");
                poster = document.select("p:nth-child(3) > img").attr("src");
                elementSelectFirst2 = document.selectFirst("meta[property=og:description]");
                if (elementSelectFirst2 != null) {
                    string2 = null;
                } else {
                    string2 = null;
                }
                description = string2;
                if (StringsKt.contains$default(document.select("div.entry-content p strong").text(), "TV Series", false, 2, (Object) null)) {
                    tvType = TvType.TvSeries;
                } else {
                    tvType = TvType.Movie;
                }
                tvtag = tvType;
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Iterable $this$map$iv2 = document.select("div.mks_toggle_content a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r19.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(StringsKt.replace$default(it2.attr("href"), "/file/", "/embed/", false, 4, (Object) null));
                }
                hrefs = appUtils2.toJson((List) destination$iv$iv);
                if (tvtag == TvType.TvSeries) {
                    TvType tvType4 = TvType.Movie;
                    C00044 c00045 = new C00044(poster, backgroundposter, description, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(description);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(hrefs);
                    c00022.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType4, hrefs, c00045, c00022);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    title2 = title;
                    backgroundposter2 = backgroundposter;
                    poster2 = poster;
                    tvtag2 = tvtag;
                    hrefs2 = hrefs;
                    backgroundposter3 = url2;
                    url3 = description;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$forEach$iv = document.select(".entry-content.entry.clearfix");
                while (r14.hasNext()) {
                    String hrefs4 = hrefs;
                    content = (Element) element$iv;
                    Object $result4 = $result2;
                    $result = "p";
                    while (r24.hasNext()) {
                        pTag = (Element) element$iv2;
                        Element content3 = content;
                        String title5 = title;
                        episodes2 = episodes;
                        String url7 = url2;
                        Iterable $this$forEach$iv5 = $this$forEach$iv;
                        episodeMatch = Regex.find$default(new Regex("Episode\\s*(\\d+)"), pTag.text(), 0, 2, (Object) null);
                        if (episodeMatch != null) {
                            final Integer episodeNumber2 = StringsKt.toIntOrNull((String) episodeMatch.getGroupValues().get(1));
                            episodeLinks = new ArrayList();
                            nextSibling = pTag.nextElementSibling();
                            while (nextSibling != null) {
                                episodeMatch2 = episodeMatch;
                                if (Intrinsics.areEqual(nextSibling.tagName(), "hr")) {
                                    if (Intrinsics.areEqual(nextSibling.tagName(), $result)) {
                                        $this$forEach$iv2 = nextSibling.select("a[href]");
                                        while (r33.hasNext()) {
                                            Iterable $this$forEach$iv6 = $this$forEach$iv2;
                                            Element aTag2 = (Element) element$iv3;
                                            episodeLinks.add(StringsKt.replace$default(aTag2.attr("href"), "/file/", "/embed/", false, 4, (Object) null));
                                            $this$forEach$iv2 = $this$forEach$iv6;
                                        }
                                    }
                                    nextSibling = nextSibling.nextElementSibling();
                                    episodeMatch = episodeMatch2;
                                } else {
                                    episodes2.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(episodeLinks), new Function1() { // from class: com.toonhub4u.Toonhub4u$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj3) {
                                            return Toonhub4u.load$lambda$1$0$1(episodeNumber2, (Episode) obj3);
                                        }
                                    }));
                                }
                            }
                            episodes2.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(episodeLinks), new Function1() { // from class: com.toonhub4u.Toonhub4u$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj3) {
                                    return Toonhub4u.load$lambda$1$0$1(episodeNumber2, (Episode) obj3);
                                }
                            }));
                        }
                        url2 = url7;
                        content = content3;
                        title = title5;
                        episodes = episodes2;
                        $this$forEach$iv = $this$forEach$iv5;
                        $result = $result;
                    }
                    hrefs = hrefs4;
                    $result2 = $result4;
                }
                String title6 = title;
                List episodes4 = episodes;
                String url8 = url2;
                TvType tvType5 = TvType.Anime;
                C00033 c00034 = new C00033(poster, backgroundposter, description, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(title6);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(backgroundposter);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(hrefs);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(episodes4);
                c00022.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title6, url8, tvType5, episodes4, c00034, c00022);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                ResultKt.throwOnFailure($result2);
                objNewTvSeriesLoadResponse = $result2;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                hrefs2 = (String) c00022.L$7;
                tvtag2 = (TvType) c00022.L$6;
                url3 = (String) c00022.L$5;
                poster2 = (String) c00022.L$4;
                backgroundposter2 = (String) c00022.L$3;
                title2 = (String) c00022.L$2;
                document = (Document) c00022.L$1;
                backgroundposter3 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result2);
                objNewMovieLoadResponse = $result2;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0$1(Integer $episodeNumber, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $episodeNumber);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$load$3 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u$load$3", f = "Toonhub4u.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, String str2, String str3, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundposter = str2;
            this.$description = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$backgroundposter, this.$description, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$backgroundposter);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$load$4 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u$load$4", f = "Toonhub4u.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(String str, String str2, String str3, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundposter = str2;
            this.$description = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = new C00044(this.$poster, this.$backgroundposter, this.$description, continuation);
            c00044.L$0 = obj;
            return c00044;
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
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(this.$backgroundposter);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
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
                JSONArray jsonArray = new JSONArray(data);
                int length = jsonArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    int it = i;
                    arrayList.add(jsonArray.getString(it));
                }
                ArrayList links = arrayList;
                C00062 c00062 = new C00062(links, function1, function2, null);
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00051.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00051.L$3 = SpillingKt.nullOutSpilledVariable(jsonArray);
                c00051.L$4 = SpillingKt.nullOutSpilledVariable(links);
                c00051.Z$0 = isCasting;
                c00051.label = 1;
                if (CoroutineScopeKt.coroutineScope(c00062, c00051) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean isCasting2 = c00051.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$loadLinks$2 */
    /* JADX INFO: compiled from: Toonhub4u.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.Toonhub4u$loadLinks$2", f = "Toonhub4u.kt", i = {0, 1}, l = {122, 130}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope"}, nl = {130, 131}, s = {"L$0", "L$0"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ List<String> $links;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(List<String> list, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$links = list;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = new C00062(this.$links, this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Toonhub4u.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "link", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.toonhub4u.Toonhub4u$loadLinks$2$1", f = "Toonhub4u.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Job>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CoroutineScope coroutineScope, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$subtitleCallback = function1;
                this.$callback = function2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$subtitleCallback, this.$callback, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(String str, Continuation<? super Job> continuation) {
                return create(str, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.toonhub4u.Toonhub4u$loadLinks$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Toonhub4u.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.toonhub4u.Toonhub4u$loadLinks$2$1$1", f = "Toonhub4u.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, nl = {126}, s = {}, v = 2)
            static final class C00081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                final /* synthetic */ String $link;
                final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00081(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00081> continuation) {
                    super(2, continuation);
                    this.$link = str;
                    this.$subtitleCallback = function1;
                    this.$callback = function2;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00081(this.$link, this.$subtitleCallback, this.$callback, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    try {
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                this.label = 1;
                                if (ExtractorApiKt.loadExtractor(this.$link, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                break;
                            case 1:
                                ResultKt.throwOnFailure($result);
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Exception e) {
                        Log.INSTANCE.e("ToonHub", "Error loading " + this.$link + ": " + e.getMessage());
                    }
                    return Unit.INSTANCE;
                }
            }

            public final Object invokeSuspend(Object $result) {
                String link = (String) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        return BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00081(link, this.$subtitleCallback, this.$callback, null), 3, (Object) null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0057 A[RETURN] */
        public final Object invokeSuspend(Object $result) {
            Object objAmap;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 1;
                    objAmap = ParCollectionsKt.amap(this.$links, new AnonymousClass1($this$coroutineScope, this.$subtitleCallback, this.$callback, null), (Continuation) this);
                    if (objAmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 2;
                    if (AwaitKt.joinAll((Collection) objAmap, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAmap = $result;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 2;
                    if (AwaitKt.joinAll((Collection) objAmap, (Continuation) this) == coroutine_suspended) {
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
