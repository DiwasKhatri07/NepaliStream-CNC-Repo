package com.ohli24;

import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
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
import com.lagradost.cloudstream3.Score;
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
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: OHLI24.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OHLI24/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0004\u0018\u00010)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/ohli24/OHLI24;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasChromecastSupport", "getHasChromecastSupport", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OHLI24"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOHLI24.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OHLI24.kt\ncom/ohli24/OHLI24\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n1795#2,10:166\n2068#2:176\n2069#2:178\n1805#2:179\n1795#2,10:180\n2068#2:190\n2069#2:192\n1805#2:193\n1739#2:194\n1814#2,3:195\n1739#2:198\n1814#2,3:199\n777#2:202\n873#2,2:203\n1960#2,3:205\n1739#2:208\n1814#2,3:209\n1#3:177\n1#3:191\n*S KotlinDebug\n*F\n+ 1 OHLI24.kt\ncom/ohli24/OHLI24\n*L\n46#1:166,10\n46#1:176\n46#1:178\n46#1:179\n84#1:180,10\n84#1:190\n84#1:192\n84#1:193\n92#1:194\n92#1:195,3\n94#1:198\n94#1:199,3\n94#1:202\n94#1:203,2\n98#1:205,3\n115#1:208\n115#1:209,3\n46#1:177\n84#1:191\n*E\n"})
public final class OHLI24 extends MainAPI {

    @NotNull
    private String mainUrl = "https://ani.ohli24.com";

    @NotNull
    private String name = "OHLI24";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ko";
    private final boolean hasChromecastSupport = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("bbs/board.php?bo_table=ing", "방영중"), TuplesKt.to("bbs/board.php?bo_table=fin", "종영"), TuplesKt.to("bbs/board.php?bo_table=theater", "극장판")});

    /* JADX INFO: renamed from: com.ohli24.OHLI24$getMainPage$1 */
    /* JADX INFO: compiled from: OHLI24.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.OHLI24", f = "OHLI24.kt", i = {0, 0}, l = {44}, m = "getMainPage", n = {"request", "page"}, nl = {46}, s = {"L$0", "I$0"}, v = 2)
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
            return OHLI24.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ohli24.OHLI24$load$1 */
    /* JADX INFO: compiled from: OHLI24.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.OHLI24", f = "OHLI24.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {88, 126, 137}, m = "load", n = {"url", "url", "doc", "title", "poster", "genres", "year", "descript", "items", "type", "href", "episodes", "hasEpisodeText", "url", "doc", "title", "poster", "genres", "year", "descript", "items", "type", "href", "hasEpisodeText"}, nl = {89, 137, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OHLI24.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ohli24.OHLI24$loadLinks$1 */
    /* JADX INFO: compiled from: OHLI24.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.OHLI24", f = "OHLI24.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {153, 159, 161}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "doc", "iframeSrc", "vurl", "iframe", "isCasting", "data", "subtitleCallback", "callback", "doc", "iframeSrc", "vurl", "iframe", "isCasting"}, nl = {154, 161, 162}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
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
            return OHLI24.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ohli24.OHLI24$search$1 */
    /* JADX INFO: compiled from: OHLI24.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.OHLI24", f = "OHLI24.kt", i = {0}, l = {83}, m = "search", n = {"query"}, nl = {84}, s = {"L$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
            return OHLI24.this.search(null, (Continuation) this);
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

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
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
        int page2;
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
                String str = getMainUrl() + '/' + request.getData() + "&page=" + page;
                c00011.L$0 = request;
                c00011.I$0 = page;
                c00011.label = 1;
                z = true;
                $result = Requests.post$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, c00011, 61438, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.list-row");
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
        String title;
        String str;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.post-title");
        if (elementSelectFirst == null || (title = elementSelectFirst.text()) == null) {
            return null;
        }
        String rawHref = $this$toSearchResult.select("div.list-desc a").attr("href");
        OHLI24 ohli24 = this;
        if (StringsKt.startsWith$default(rawHref, "./", false, 2, (Object) null) || StringsKt.startsWith$default(rawHref, "board.php", false, 2, (Object) null)) {
            str = getMainUrl() + "/bbs/" + StringsKt.removePrefix(rawHref, "./");
        } else {
            str = rawHref;
        }
        String href = MainAPIKt.fixUrl(ohli24, str);
        final String posterUrl = MainAPIKt.fixUrl(this, $this$toSearchResult.select("img").attr("src"));
        final String score = $this$toSearchResult.select("div.rating").text();
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.ohli24.OHLI24$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return OHLI24.toSearchResult$lambda$0(posterUrl, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/bbs/search.php?srows=24&gr_id=&sfl=wr_subject&stx=" + query;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00061.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, c00061, 3838, (Object) null);
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
        Iterable $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select("div.list-row");
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

    /* JADX WARN: Code duplicated, block: B:100:0x0348  */
    /* JADX WARN: Code duplicated, block: B:102:0x036c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0371  */
    /* JADX WARN: Code duplicated, block: B:105:0x0374  */
    /* JADX WARN: Code duplicated, block: B:109:0x040a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x040b  */
    /* JADX WARN: Code duplicated, block: B:112:0x041e  */
    /* JADX WARN: Code duplicated, block: B:114:0x047f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:115:0x0480  */
    /* JADX WARN: Code duplicated, block: B:121:0x0240 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0375 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x02e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:28:0x0110  */
    /* JADX WARN: Code duplicated, block: B:30:0x0118  */
    /* JADX WARN: Code duplicated, block: B:31:0x011f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0194  */
    /* JADX WARN: Code duplicated, block: B:49:0x01e7 A[LOOP:1: B:47:0x01e1->B:49:0x01e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x0224  */
    /* JADX WARN: Code duplicated, block: B:55:0x0238  */
    /* JADX WARN: Code duplicated, block: B:56:0x023a  */
    /* JADX WARN: Code duplicated, block: B:58:0x023d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0283  */
    /* JADX WARN: Code duplicated, block: B:68:0x028d  */
    /* JADX WARN: Code duplicated, block: B:70:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:72:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:76:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02e2 A[LOOP:4: B:66:0x0287->B:80:0x02e2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x0313  */
    /* JADX WARN: Code duplicated, block: B:91:0x0318  */
    /* JADX WARN: Code duplicated, block: B:94:0x031d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0326  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00021 c00021;
        Object obj;
        Object obj2;
        String url2;
        Document doc;
        Element elementSelectFirst;
        String strText;
        String title;
        Element elementSelectFirst2;
        Element elementSelectFirst3;
        String strAttr;
        String poster;
        Element elementFirst;
        List listEmptyList;
        List genres;
        Integer year;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        String descript;
        Iterable iterableSelect;
        Iterable $this$any$iv;
        Iterator it;
        String title2;
        String url3;
        int i;
        String url4;
        Element it2;
        Object $result;
        boolean z;
        int i2;
        TvType type;
        Element elementSelectFirst4;
        String strAbsUrl;
        String href;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv3;
        Element elementSelectFirst5;
        String href2;
        boolean z2;
        Elements elementsSelect;
        String strText2;
        Iterable iterableSplit$default;
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
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 100L, (Interceptor) null, false, (ResponseParser) null, c00022, 3838, (Object) null);
                c00022 = c00022;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                doc = ((NiceResponse) obj2).getDocument();
                doc.setBaseUri(url2);
                elementSelectFirst = doc.selectFirst("div.view-title h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = "UnKnown";
                }
                title = strText;
                OHLI24 ohli24 = this;
                elementSelectFirst2 = doc.selectFirst("div.image img");
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("src")) == null) {
                    elementSelectFirst3 = doc.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                poster = MainAPIKt.fixUrlNull(ohli24, strAttr);
                elementFirst = doc.select("p:contains(장르)").first();
                if (elementFirst != null || (elementsSelect = elementFirst.select("span:nth-of-type(2)")) == null || (strText2 = elementsSelect.text()) == null || (iterableSplit$default = StringsKt.split$default(strText2, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv2 = iterableSplit$default;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        destination$iv$iv4.add(StringsKt.trim((String) item$iv$iv).toString());
                    }
                    listEmptyList = (List) destination$iv$iv4;
                }
                genres = listEmptyList;
                year = StringsKt.toIntOrNull(StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(title, "(", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null));
                Iterable $this$map$iv3 = StringsKt.split$default(doc.select("div.view-stocon,div.view-cont").html(), new String[]{"<br>"}, false, 0, 6, (Object) null);
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                for (Object item$iv$iv2 : $this$map$iv3) {
                    destination$iv$iv.add(StringsKt.trim(Jsoup.parse((String) item$iv$iv2).text()).toString());
                }
                Iterable $this$filter$iv = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    if (((String) element$iv$iv).length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                descript = CollectionsKt.joinToString$default((List) destination$iv$iv2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                iterableSelect = doc.select("li.list-item a");
                $this$any$iv = iterableSelect;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            it2 = (Element) element$iv;
                            $result = $result2;
                            if (StringsKt.contains(it2.text(), "episode", true)) {
                                title2 = title;
                                url3 = url2;
                                url4 = null;
                            } else {
                                title2 = title;
                                url3 = url2;
                                url4 = null;
                                if (StringsKt.contains$default(it2.text(), "회", false, 2, (Object) null) && !StringsKt.contains$default(it2.text(), "화", false, 2, (Object) null)) {
                                    z = false;
                                }
                                if (z) {
                                    i = 1;
                                } else {
                                    title = title2;
                                    $result2 = $result;
                                    url2 = url3;
                                }
                            }
                            z = true;
                            if (z) {
                                i = 1;
                            } else {
                                title = title2;
                                $result2 = $result;
                                url2 = url3;
                            }
                        } else {
                            title2 = title;
                            url3 = url2;
                            i = 0;
                            url4 = null;
                        }
                    }
                } else {
                    title2 = title;
                    url3 = url2;
                    i = 0;
                    url4 = null;
                }
                i2 = i;
                type = (iterableSelect.size() > 1 && i2 == 0) ? TvType.Movie : TvType.TvSeries;
                OHLI24 ohli25 = this;
                elementSelectFirst4 = doc.selectFirst("li.list-item a");
                if (elementSelectFirst4 != null) {
                    strAbsUrl = elementSelectFirst4.absUrl("href");
                } else {
                    strAbsUrl = url4;
                }
                if (strAbsUrl == null) {
                    strAbsUrl = "";
                }
                href = MainAPIKt.fixUrl(ohli25, strAbsUrl);
                if (type == TvType.TvSeries) {
                    String title3 = title2;
                    String url5 = url3;
                    TvType tvType = TvType.AnimeMovie;
                    C00043 c00043 = new C00043(year, genres, poster, descript, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(title3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(genres);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(descript);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(href);
                    c00022.I$0 = i2;
                    c00022.label = 3;
                    $result2 = MainAPIKt.newMovieLoadResponse(this, title3, url5, tvType, href, c00043, c00022);
                    if ($result2 == obj) {
                        return obj;
                    }
                    return $result2;
                }
                $this$map$iv = doc.select("li.list-item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv3 : $this$map$iv) {
                    Element it3 = (Element) item$iv$iv3;
                    TvType type2 = type;
                    final Integer epno = StringsKt.toIntOrNull(it3.select("div.wr-num").text());
                    Iterable $this$map$iv4 = $this$map$iv;
                    elementSelectFirst5 = it3.selectFirst("a");
                    if (elementSelectFirst5 != null) {
                        href2 = elementSelectFirst5.absUrl("href");
                    } else {
                        href2 = null;
                    }
                    if (href2 == null) {
                        href2 = "";
                    }
                    destination$iv$iv3.add(MainAPIKt.newEpisode(this, href2, new Function1() { // from class: com.ohli24.OHLI24$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return OHLI24.load$lambda$4$0(epno, (Episode) obj3);
                        }
                    }));
                    type = type2;
                    $this$map$iv = $this$map$iv4;
                    $i$f$map = $i$f$map;
                }
                List episodes = (List) destination$iv$iv3;
                TvType tvType2 = TvType.Anime;
                C00032 c00032 = new C00032(episodes, year, genres, poster, descript, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(genres);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(descript);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(type);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(href);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                c00022.I$0 = i2;
                c00022.label = 2;
                $result2 = MainAPIKt.newAnimeLoadResponse$default(this, title2, url3, tvType2, false, c00032, c00022, 8, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return $result2;
            case 1:
                String url6 = (String) c00022.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                url2 = url6;
                obj2 = $result2;
                doc = ((NiceResponse) obj2).getDocument();
                doc.setBaseUri(url2);
                elementSelectFirst = doc.selectFirst("div.view-title h1");
                if (elementSelectFirst != null) {
                    strText = "UnKnown";
                } else {
                    strText = "UnKnown";
                }
                title = strText;
                OHLI24 ohli26 = this;
                elementSelectFirst2 = doc.selectFirst("div.image img");
                if (elementSelectFirst2 != null) {
                    elementSelectFirst3 = doc.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("content");
                    } else {
                        strAttr = null;
                    }
                } else {
                    elementSelectFirst3 = doc.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst3 != null) {
                        strAttr = elementSelectFirst3.attr("content");
                    } else {
                        strAttr = null;
                    }
                }
                poster = MainAPIKt.fixUrlNull(ohli26, strAttr);
                elementFirst = doc.select("p:contains(장르)").first();
                if (elementFirst != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                genres = listEmptyList;
                year = StringsKt.toIntOrNull(StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(title, "(", (String) null, 2, (Object) null), ")", (String) null, 2, (Object) null));
                Iterable $this$map$iv5 = StringsKt.split$default(doc.select("div.view-stocon,div.view-cont").html(), new String[]{"<br>"}, false, 0, 6, (Object) null);
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                while (r14.hasNext()) {
                    destination$iv$iv.add(StringsKt.trim(Jsoup.parse((String) item$iv$iv2).text()).toString());
                }
                Iterable $this$filter$iv2 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                while (r12.hasNext()) {
                    if (((String) element$iv$iv).length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                descript = CollectionsKt.joinToString$default((List) destination$iv$iv2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                iterableSelect = doc.select("li.list-item a");
                $this$any$iv = iterableSelect;
                if (!($this$any$iv instanceof Collection)) {
                    it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv2 = it.next();
                            it2 = (Element) element$iv2;
                            $result = $result2;
                            if (StringsKt.contains(it2.text(), "episode", true)) {
                                title2 = title;
                                url3 = url2;
                                url4 = null;
                                if (StringsKt.contains$default(it2.text(), "회", false, 2, (Object) null)) {
                                }
                                if (z) {
                                    i = 1;
                                } else {
                                    title = title2;
                                    $result2 = $result;
                                    url2 = url3;
                                }
                            } else {
                                title2 = title;
                                url3 = url2;
                                url4 = null;
                            }
                            z = true;
                            if (z) {
                                i = 1;
                            } else {
                                title = title2;
                                $result2 = $result;
                                url2 = url3;
                            }
                        } else {
                            title2 = title;
                            url3 = url2;
                            i = 0;
                            url4 = null;
                        }
                        break;
                    }
                } else {
                    it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv3 = it.next();
                            it2 = (Element) element$iv3;
                            $result = $result2;
                            if (StringsKt.contains(it2.text(), "episode", true)) {
                                title2 = title;
                                url3 = url2;
                                url4 = null;
                                if (StringsKt.contains$default(it2.text(), "회", false, 2, (Object) null)) {
                                }
                                if (z) {
                                    i = 1;
                                } else {
                                    title = title2;
                                    $result2 = $result;
                                    url2 = url3;
                                }
                            } else {
                                title2 = title;
                                url3 = url2;
                                url4 = null;
                            }
                            z = true;
                            if (z) {
                                i = 1;
                            } else {
                                title = title2;
                                $result2 = $result;
                                url2 = url3;
                            }
                        } else {
                            title2 = title;
                            url3 = url2;
                            i = 0;
                            url4 = null;
                        }
                        break;
                    }
                }
                i2 = i;
                if (iterableSelect.size() > 1) {
                    type = TvType.TvSeries;
                }
                OHLI24 ohli27 = this;
                elementSelectFirst4 = doc.selectFirst("li.list-item a");
                if (elementSelectFirst4 != null) {
                    strAbsUrl = elementSelectFirst4.absUrl("href");
                } else {
                    strAbsUrl = url4;
                }
                if (strAbsUrl == null) {
                    strAbsUrl = "";
                }
                href = MainAPIKt.fixUrl(ohli27, strAbsUrl);
                if (type == TvType.TvSeries) {
                    String title4 = title2;
                    String url7 = url3;
                    TvType tvType3 = TvType.AnimeMovie;
                    C00043 c00044 = new C00043(year, genres, poster, descript, null);
                    c00022.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(title4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(genres);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(descript);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(type);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(href);
                    c00022.I$0 = i2;
                    c00022.label = 3;
                    $result2 = MainAPIKt.newMovieLoadResponse(this, title4, url7, tvType3, href, c00044, c00022);
                    if ($result2 == obj) {
                        return obj;
                    }
                    return $result2;
                }
                $this$map$iv = doc.select("li.list-item");
                $i$f$map = 0;
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r14.hasNext()) {
                    Element it4 = (Element) item$iv$iv3;
                    TvType type3 = type;
                    final Integer epno2 = StringsKt.toIntOrNull(it4.select("div.wr-num").text());
                    Iterable $this$map$iv6 = $this$map$iv;
                    elementSelectFirst5 = it4.selectFirst("a");
                    if (elementSelectFirst5 != null) {
                        href2 = elementSelectFirst5.absUrl("href");
                    } else {
                        href2 = null;
                    }
                    if (href2 == null) {
                        href2 = "";
                    }
                    destination$iv$iv3.add(MainAPIKt.newEpisode(this, href2, new Function1() { // from class: com.ohli24.OHLI24$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj3) {
                            return OHLI24.load$lambda$4$0(epno2, (Episode) obj3);
                        }
                    }));
                    type = type3;
                    $this$map$iv = $this$map$iv6;
                    $i$f$map = $i$f$map;
                }
                List episodes2 = (List) destination$iv$iv3;
                TvType tvType4 = TvType.Anime;
                C00032 c00033 = new C00032(episodes2, year, genres, poster, descript, null);
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(genres);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(year);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(descript);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(type);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(href);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00022.I$0 = i2;
                c00022.label = 2;
                $result2 = MainAPIKt.newAnimeLoadResponse$default(this, title2, url3, tvType4, false, c00033, c00022, 8, (Object) null);
                if ($result2 == obj) {
                    return obj;
                }
                return $result2;
            case 2:
                int i3 = c00022.I$0;
                ResultKt.throwOnFailure($result2);
                return $result2;
            case 3:
                int i4 = c00022.I$0;
                ResultKt.throwOnFailure($result2);
                return $result2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Integer $epno, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $epno);
        $this$newEpisode.setEpisode($epno);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.ohli24.OHLI24$load$2 */
    /* JADX INFO: compiled from: OHLI24.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.OHLI24$load$2", f = "OHLI24.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $descript;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(List<Episode> list, Integer num, List<String> list2, String str, String str2, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$episodes = list;
            this.$year = num;
            this.$genres = list2;
            this.$poster = str;
            this.$descript = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$episodes, this.$year, this.$genres, this.$poster, this.$descript, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnimeLoadResponse $this$newAnimeLoadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, CollectionsKt.reversed(this.$episodes));
                    $this$newAnimeLoadResponse.setYear(this.$year);
                    $this$newAnimeLoadResponse.setTags(this.$genres);
                    $this$newAnimeLoadResponse.setPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setPlot(this.$descript);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.ohli24.OHLI24$load$3 */
    /* JADX INFO: compiled from: OHLI24.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ohli24.OHLI24$load$3", f = "OHLI24.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00043 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $descript;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(Integer num, List<String> list, String str, String str2, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$year = num;
            this.$genres = list;
            this.$poster = str;
            this.$descript = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$year, this.$genres, this.$poster, this.$descript, continuation);
            c00043.L$0 = obj;
            return c00043;
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
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setTags(this.$genres);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$descript);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:22:0x0104  */
    /* JADX WARN: Code duplicated, block: B:25:0x010e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0115  */
    /* JADX WARN: Code duplicated, block: B:29:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x011b  */
    /* JADX WARN: Code duplicated, block: B:31:0x011e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0120  */
    /* JADX WARN: Code duplicated, block: B:35:0x0132  */
    /* JADX WARN: Code duplicated, block: B:37:0x0170 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0171  */
    /* JADX WARN: Code duplicated, block: B:40:0x0179  */
    /* JADX WARN: Code duplicated, block: B:42:0x01b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        OHLI24 ohli24;
        boolean z;
        Object obj;
        Object obj2;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Document doc;
        Element elementSelectFirst;
        String strAttr;
        String iframeSrc;
        Element elementSelectFirst2;
        String strAttr2;
        String vurl;
        String iframe;
        String iframe2;
        String mainUrl;
        String iframe3;
        Cdndania cdndania;
        String mainUrl2;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
                ohli24 = this;
            } else {
                ohli24 = this;
                c00051 = ohli24.new C00051(continuation);
            }
        } else {
            ohli24 = this;
            c00051 = ohli24.new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = function1;
                c00052.L$2 = function2;
                c00052.Z$0 = isCasting;
                c00052.label = 1;
                z = true;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 20L, (Interceptor) null, false, (ResponseParser) null, c00052, 3838, (Object) null);
                c00052 = c00052;
                if (obj2 == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                doc = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc.selectFirst("iframe");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("src");
                } else {
                    strAttr = null;
                }
                iframeSrc = strAttr;
                elementSelectFirst2 = doc.selectFirst("form.tt input[name=vurl]");
                if (elementSelectFirst2 != null) {
                    strAttr2 = elementSelectFirst2.attr("value");
                } else {
                    strAttr2 = null;
                }
                vurl = strAttr2;
                if (iframeSrc == null) {
                    iframe = iframeSrc;
                } else if (vurl == null) {
                    iframe = "";
                } else {
                    iframe = vurl;
                }
                if (StringsKt.contains$default(iframe, "/video/", false, 2, (Object) null)) {
                    iframe3 = iframe;
                    cdndania = new Cdndania();
                    mainUrl2 = ohli24.getMainUrl();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(vurl);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(iframe3);
                    c00052.Z$0 = isCasting2;
                    c00052.label = 2;
                    if (cdndania.getUrl(iframe3, mainUrl2, function3, function4, c00052) == obj) {
                        return obj;
                    }
                } else {
                    iframe2 = iframe;
                    mainUrl = ohli24.getMainUrl();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(vurl);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                    c00052.Z$0 = isCasting2;
                    c00052.label = 3;
                    if (ExtractorApiKt.loadExtractor(iframe2, mainUrl, function3, function4, c00052) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00052.Z$0;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00052.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00052.L$1;
                data2 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                function4 = function5;
                function3 = function6;
                obj = coroutine_suspended;
                isCasting2 = isCasting3;
                z = true;
                obj2 = $result;
                doc = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc.selectFirst("iframe");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("src");
                } else {
                    strAttr = null;
                }
                iframeSrc = strAttr;
                elementSelectFirst2 = doc.selectFirst("form.tt input[name=vurl]");
                if (elementSelectFirst2 != null) {
                    strAttr2 = elementSelectFirst2.attr("value");
                } else {
                    strAttr2 = null;
                }
                vurl = strAttr2;
                if (iframeSrc == null) {
                    iframe = iframeSrc;
                } else if (vurl == null) {
                    iframe = "";
                } else {
                    iframe = vurl;
                }
                if (StringsKt.contains$default(iframe, "/video/", false, 2, (Object) null)) {
                    iframe3 = iframe;
                    cdndania = new Cdndania();
                    mainUrl2 = ohli24.getMainUrl();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(vurl);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(iframe3);
                    c00052.Z$0 = isCasting2;
                    c00052.label = 2;
                    if (cdndania.getUrl(iframe3, mainUrl2, function3, function4, c00052) == obj) {
                        return obj;
                    }
                } else {
                    iframe2 = iframe;
                    mainUrl = ohli24.getMainUrl();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(iframeSrc);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(vurl);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(iframe2);
                    c00052.Z$0 = isCasting2;
                    c00052.label = 3;
                    if (ExtractorApiKt.loadExtractor(iframe2, mainUrl, function3, function4, c00052) == obj) {
                        return obj;
                    }
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean isCasting4 = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            case 3:
                boolean z2 = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
