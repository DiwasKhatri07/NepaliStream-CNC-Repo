package com.Animexin;

import com.fleeksoft.ksoup.Ksoup;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Animexin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Animexin/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\"\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\f\u0010*\u001a\u00020+*\u00020,H\u0002J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u00100J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00104JF\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u000e2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006?"}, d2 = {"Lcom/Animexin/Animexin;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "cfHeaders", "", "getCfHeaders", "()Ljava/util/Map;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animexin"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimexin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animexin.kt\ncom/Animexin/Animexin\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,223:1\n1795#2,10:224\n2068#2:234\n2069#2:236\n1805#2:237\n1795#2,10:238\n2068#2:248\n2069#2:250\n1805#2:251\n1739#2:253\n1814#2,3:254\n1#3:235\n1#3:249\n1#3:252\n*S KotlinDebug\n*F\n+ 1 Animexin.kt\ncom/Animexin/Animexin\n*L\n138#1:224,10\n138#1:234\n138#1:236\n138#1:237\n162#1:238,10\n162#1:248\n162#1:250\n162#1:251\n178#1:253\n178#1:254,3\n138#1:235\n162#1:249\n*E\n"})
public final class Animexin extends MainAPI {

    @NotNull
    private String mainUrl = "https://animexin.dev";

    @NotNull
    private String name = "Animexin";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("anime/?status=ongoing&order=update", "Recently Updated"), TuplesKt.to("anime/?status=ongoing&order&order=popular", "Popular"), TuplesKt.to("anime/?", "Donghua"), TuplesKt.to("anime/?status=&type=movie&page=", "Movies"), TuplesKt.to("anime/?sub=raw", "Anime (RAW)")});

    /* JADX INFO: renamed from: com.Animexin.Animexin$getMainPage$1 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin", f = "Animexin.kt", i = {0, 0}, l = {137}, m = "getMainPage", n = {"request", "page"}, nl = {138}, s = {"L$0", "I$0"}, v = 2)
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
            return Animexin.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animexin.Animexin$load$1 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin", f = "Animexin.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {167, 191, 197}, m = "load", n = {"url", "url", "document", "title", "href", "poster", "description", "type", "tvtag", "episodeRegex", "episodes", "url", "document", "title", "href", "poster", "description", "type", "tvtag"}, nl = {168, 197, 176}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
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
            return Animexin.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animexin.Animexin$loadLinks$1 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin", f = "Animexin.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {211, 212}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {212, 220}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return Animexin.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Animexin.Animexin$search$1 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin", f = "Animexin.kt", i = {0, 0}, l = {161}, m = "search", n = {"query", "page"}, nl = {162}, s = {"L$0", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
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
            return Animexin.this.search(null, 0, (Continuation) this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getCfHeaders() {
        Map<String, String> mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("referer", getMainUrl() + '/')});
        String savedUa = AnimexinPlugin.INSTANCE.getCfUserAgent();
        String savedCookies = AnimexinPlugin.INSTANCE.getCfCookies();
        if (savedUa.length() > 0) {
            mapMutableMapOf.put("User-Agent", savedUa);
        }
        if (savedCookies.length() > 0) {
            mapMutableMapOf.put("Cookie", savedCookies);
        }
        return mapMutableMapOf;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        Object objAppGet$default;
        MainPageRequest request2;
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
                String str = getMainUrl() + '/' + request.getData() + "&page=" + page;
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                objAppGet$default = AnimexinKt.appGet$default(str, null, c00001, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) objAppGet$default).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.listupd > article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(true));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("div.bsx > a").attr("title");
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("div.bsx > a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("div.bsx > a img").attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Animexin.Animexin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Animexin.toSearchResult$lambda$0(posterUrl, this, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, Animexin this$0, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders(this$0.getCfHeaders());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00061 c00061;
        Object objAppGet$default;
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
                String str = getMainUrl() + "/page/" + page + "/?s=" + query;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.I$0 = page;
                c00061.label = 1;
                objAppGet$default = AnimexinKt.appGet$default(str, null, c00061, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00061.I$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) objAppGet$default).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.listupd > article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:28:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:34:0x0100  */
    /* JADX WARN: Code duplicated, block: B:39:0x011c  */
    /* JADX WARN: Code duplicated, block: B:46:0x013d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0146  */
    /* JADX WARN: Code duplicated, block: B:50:0x014b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0166  */
    /* JADX WARN: Code duplicated, block: B:54:0x0169  */
    /* JADX WARN: Code duplicated, block: B:57:0x016f  */
    /* JADX WARN: Code duplicated, block: B:60:0x019c  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x0200  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0290 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x0291  */
    /* JADX WARN: Code duplicated, block: B:86:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:88:0x02f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x02f2  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object objAppGet$default;
        Document document;
        Element elementSelectFirst;
        String string;
        String title;
        Element elementSelectFirst2;
        String str;
        String str2;
        String strAttr;
        String href;
        String strAttr2;
        boolean z;
        String poster;
        Element elementSelectFirst3;
        String description;
        Element elementSelectFirst4;
        String strText;
        String type;
        String url2;
        TvType tvtag;
        TvType tvtag2;
        String description2;
        String description3;
        String href2;
        Object objNewMovieLoadResponse;
        Document document2;
        String poster2;
        String title2;
        String title3;
        TvType tvtag3;
        Regex episodeRegex;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        Object objNewTvSeriesLoadResponse;
        Element elementSelectFirst5;
        final String posterr;
        Element elementSelectFirst6;
        final String epText;
        MatchResult matchResultFind$default;
        List groupValues;
        String strText2;
        Element elementSelectFirst7;
        String string2;
        String strAttr3;
        String strText3;
        String url3 = url;
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
                c00012.L$0 = url3;
                c00012.label = 1;
                objAppGet$default = AnimexinKt.appGet$default(url3, null, c00012, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                document = ((NiceResponse) objAppGet$default).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText3).toString();
                }
                title = String.valueOf(string);
                elementSelectFirst2 = document.selectFirst("div.eplister > ul > li a");
                str = "href";
                str2 = "";
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("href")) == null) {
                    strAttr = "";
                }
                href = strAttr;
                strAttr2 = document.select("div.thumb img").attr("src");
                if (strAttr2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    elementSelectFirst7 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst7 != null || (strAttr3 = elementSelectFirst7.attr("content")) == null) {
                        string2 = null;
                    } else {
                        string2 = StringsKt.trim(strAttr3).toString();
                    }
                    strAttr2 = String.valueOf(string2);
                }
                poster = strAttr2;
                elementSelectFirst3 = document.selectFirst("div.entry-content");
                if (elementSelectFirst3 != null || (strText2 = elementSelectFirst3.text()) == null) {
                    description = null;
                } else {
                    description = StringsKt.trim(strText2).toString();
                }
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                } else {
                    strText = null;
                }
                type = String.valueOf(strText);
                url2 = url3;
                if (StringsKt.contains$default(type, "Movie", false, 2, (Object) null)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    tvtag2 = tvtag;
                    description2 = description;
                    description3 = url2;
                    TvType tvType = TvType.Movie;
                    C00033 c00033 = new C00033(poster, this, description2, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(description3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(description2);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 3;
                    href2 = href;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, description3, tvType, href2, c00033, c00012);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    document2 = document;
                    poster2 = poster;
                    title2 = title;
                    title3 = type;
                    tvtag3 = tvtag2;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodeRegex = new Regex("(\\d+)");
                $this$map$iv = document.select("div.eplister > ul > li");
                $i$f$map = 0;
                TvType tvtag4 = tvtag;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Iterable $this$map$iv2 = $this$map$iv;
                    Element info = (Element) item$iv$iv;
                    String title4 = title;
                    String href1 = info.select("a").attr(str);
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    elementSelectFirst5 = info.selectFirst("a img");
                    if (elementSelectFirst5 != null || (posterr = elementSelectFirst5.attr("src")) == null) {
                        posterr = str2;
                    }
                    int $i$f$map2 = $i$f$map;
                    elementSelectFirst6 = info.selectFirst("div.epl-num");
                    if (elementSelectFirst6 != null) {
                        epText = elementSelectFirst6.text();
                    } else {
                        epText = null;
                    }
                    if (epText == null) {
                        epText = str2;
                    }
                    String str3 = str;
                    Document document3 = document;
                    String str4 = str2;
                    matchResultFind$default = Regex.find$default(episodeRegex, epText, 0, 2, (Object) null);
                    if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                        String str5 = (String) groupValues.get(1);
                        final Integer epnum = str5 != null ? StringsKt.toIntOrNull(str5) : null;
                        destination$iv$iv.add(MainAPIKt.newEpisode(this, href1, new Function1() { // from class: com.Animexin.Animexin$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return Animexin.load$lambda$1$0(epnum, epText, posterr, (Episode) obj);
                            }
                        }));
                        document = document3;
                        $this$map$iv = $this$map$iv2;
                        title = title4;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        $i$f$map = $i$f$map2;
                        str = str3;
                        str2 = str4;
                    }
                    destination$iv$iv.add(MainAPIKt.newEpisode(this, href1, new Function1() { // from class: com.Animexin.Animexin$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return Animexin.load$lambda$1$0(epnum, epText, posterr, (Episode) obj);
                        }
                    }));
                    document = document3;
                    $this$map$iv = $this$map$iv2;
                    title = title4;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $i$f$map = $i$f$map2;
                    str = str3;
                    str2 = str4;
                }
                String title5 = title;
                List episodes = (List) destination$iv$iv;
                TvType tvType2 = TvType.Anime;
                List listReversed = CollectionsKt.reversed(episodes);
                C00022 c00022 = new C00022(poster, this, description, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title5);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag4);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(episodeRegex);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title5, url2, tvType2, listReversed, c00022, c00012);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                document = ((NiceResponse) objAppGet$default).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                elementSelectFirst2 = document.selectFirst("div.eplister > ul > li a");
                str = "href";
                str2 = "";
                if (elementSelectFirst2 != null) {
                    strAttr = "";
                } else {
                    strAttr = "";
                }
                href = strAttr;
                strAttr2 = document.select("div.thumb img").attr("src");
                if (strAttr2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    elementSelectFirst7 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst7 != null) {
                        string2 = null;
                    } else {
                        string2 = null;
                    }
                    strAttr2 = String.valueOf(string2);
                }
                poster = strAttr2;
                elementSelectFirst3 = document.selectFirst("div.entry-content");
                if (elementSelectFirst3 != null) {
                    description = null;
                } else {
                    description = null;
                }
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                } else {
                    strText = null;
                }
                type = String.valueOf(strText);
                url2 = url3;
                if (StringsKt.contains$default(type, "Movie", false, 2, (Object) null)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    tvtag2 = tvtag;
                    description2 = description;
                    description3 = url2;
                    TvType tvType3 = TvType.Movie;
                    C00033 c00034 = new C00033(poster, this, description2, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(description3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(description2);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 3;
                    href2 = href;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, description3, tvType3, href2, c00034, c00012);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    document2 = document;
                    poster2 = poster;
                    title2 = title;
                    title3 = type;
                    tvtag3 = tvtag2;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodeRegex = new Regex("(\\d+)");
                $this$map$iv = document.select("div.eplister > ul > li");
                $i$f$map = 0;
                TvType tvtag5 = tvtag;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r22.hasNext()) {
                    Iterable $this$map$iv3 = $this$map$iv;
                    Element info2 = (Element) item$iv$iv;
                    String title6 = title;
                    String href3 = info2.select("a").attr(str);
                    Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                    elementSelectFirst5 = info2.selectFirst("a img");
                    if (elementSelectFirst5 != null) {
                        posterr = str2;
                    } else {
                        posterr = str2;
                    }
                    int $i$f$map3 = $i$f$map;
                    elementSelectFirst6 = info2.selectFirst("div.epl-num");
                    if (elementSelectFirst6 != null) {
                        epText = elementSelectFirst6.text();
                    } else {
                        epText = null;
                    }
                    if (epText == null) {
                        epText = str2;
                    }
                    String str6 = str;
                    Document document4 = document;
                    String str7 = str2;
                    matchResultFind$default = Regex.find$default(episodeRegex, epText, 0, 2, (Object) null);
                    if (matchResultFind$default == null) {
                    }
                    destination$iv$iv.add(MainAPIKt.newEpisode(this, href3, new Function1() { // from class: com.Animexin.Animexin$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return Animexin.load$lambda$1$0(epnum, epText, posterr, (Episode) obj);
                        }
                    }));
                    document = document4;
                    $this$map$iv = $this$map$iv3;
                    title = title6;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                    $i$f$map = $i$f$map3;
                    str = str6;
                    str2 = str7;
                }
                String title7 = title;
                List episodes2 = (List) destination$iv$iv;
                TvType tvType4 = TvType.Anime;
                List listReversed2 = CollectionsKt.reversed(episodes2);
                C00022 c00023 = new C00022(poster, this, description, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title7);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(href);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(description);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(type);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(tvtag5);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(episodeRegex);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title7, url2, tvType4, listReversed2, c00023, c00012);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                tvtag3 = (TvType) c00012.L$7;
                title3 = (String) c00012.L$6;
                String description4 = (String) c00012.L$5;
                poster2 = (String) c00012.L$4;
                href2 = (String) c00012.L$3;
                title2 = (String) c00012.L$2;
                document2 = (Document) c00012.L$1;
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                description2 = description4;
                description3 = url4;
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:6:0x0023  */
    public static final Unit load$lambda$1$0(Integer $epnum, String $epText, String $posterr, Episode $this$newEpisode) {
        String str;
        $this$newEpisode.setEpisode($epnum);
        if ($epnum != null) {
            int it = $epnum.intValue();
            str = "Episode " + it;
            if (str == null) {
                str = $epText;
            }
        } else {
            str = $epText;
        }
        $this$newEpisode.setName(str);
        $this$newEpisode.setPosterUrl($posterr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Animexin.Animexin$load$2 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin$load$2", f = "Animexin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Animexin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, Animexin animexin, String str2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.this$0 = animexin;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.this$0, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
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
                    $this$newTvSeriesLoadResponse.setPosterHeaders(this.this$0.getCfHeaders());
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Animexin.Animexin$load$3 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin$load$3", f = "Animexin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ Animexin this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, Animexin animexin, String str2, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.this$0 = animexin;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.this$0, this.$description, continuation);
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
                    $this$newMovieLoadResponse.setPosterHeaders(this.this$0.getCfHeaders());
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object objAppGet$default;
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
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                objAppGet$default = AnimexinKt.appGet$default(data, null, c00041, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document document = ((NiceResponse) objAppGet$default).getDocument();
                listSelect = document.select(".mobius option");
                c00052 = new C00052(function1, function2, null);
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00041.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00041.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00041.Z$0 = isCasting;
                c00041.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00041) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 1:
                isCasting = c00041.Z$0;
                function2 = (Function1) c00041.L$2;
                function1 = (Function1) c00041.L$1;
                data = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                Document document2 = ((NiceResponse) objAppGet$default).getDocument();
                listSelect = document2.select(".mobius option");
                c00052 = new C00052(function1, function2, null);
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00041.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00041.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00041.Z$0 = isCasting;
                c00041.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00041) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting2 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Animexin.Animexin$loadLinks$2 */
    /* JADX INFO: compiled from: Animexin.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "server", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animexin.Animexin$loadLinks$2", f = "Animexin.kt", i = {0, 0, 0, 0, 0, 0}, l = {218}, m = "invokeSuspend", n = {"server", "base64", "decoded", "doc", "href", "url"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
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
            Element server = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String base64 = server.attr("value");
                    String decoded = MainAPIKt.base64Decode(base64);
                    com.fleeksoft.ksoup.nodes.Document doc = Ksoup.parse$default(Ksoup.INSTANCE, decoded, (String) null, 2, (Object) null);
                    String href = doc.select("iframe").attr("src");
                    String url = ExtractorKt.Http(href);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(server);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(base64);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(decoded);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(href);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(url, this.$subtitleCallback, this.$callback, (Continuation) this);
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
