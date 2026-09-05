package com.pmsm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.extractors.VidStack;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Pmsm.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Pmsm/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108J\u000e\u00109\u001a\u0004\u0018\u00010:*\u00020(H\u0002J\u0019\u0010;\u001a\u0004\u0018\u00010\"2\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010=R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006?"}, d2 = {"Lcom/pmsm/Pmsm;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toEpisode", "Lcom/lagradost/cloudstream3/Episode;", "extractYear", "text", "(Ljava/lang/String;)Ljava/lang/Integer;", "ZetaPlayerResponse", "Pmsm"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPmsm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pmsm.kt\ncom/pmsm/Pmsm\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,214:1\n1795#2,10:215\n2068#2:225\n2069#2:227\n1805#2:228\n1849#2,8:229\n1795#2,10:237\n2068#2:247\n2069#2:249\n1805#2:250\n1849#2,8:251\n1739#2:260\n1814#2,3:261\n777#2:264\n873#2,2:265\n1739#2:267\n1814#2,3:268\n777#2:271\n873#2,2:272\n1795#2,10:274\n2068#2:284\n2069#2:286\n1805#2:287\n777#2:288\n873#2,2:289\n1849#2,8:291\n1795#2,10:299\n2068#2:309\n2069#2:311\n1805#2:312\n1849#2,8:313\n1#3:226\n1#3:248\n1#3:259\n1#3:285\n1#3:310\n1#3:321\n*S KotlinDebug\n*F\n+ 1 Pmsm.kt\ncom/pmsm/Pmsm\n*L\n55#1:215,10\n55#1:225\n55#1:227\n55#1:228\n57#1:229,8\n73#1:237,10\n73#1:247\n73#1:249\n73#1:250\n74#1:251,8\n86#1:260\n86#1:261,3\n86#1:264\n86#1:265,2\n87#1:267\n87#1:268,3\n87#1:271\n87#1:272,2\n97#1:274,10\n97#1:284\n97#1:286\n97#1:287\n98#1:288\n98#1:289,2\n99#1:291,8\n103#1:299,10\n103#1:309\n103#1:311\n103#1:312\n104#1:313,8\n55#1:226\n73#1:248\n97#1:285\n103#1:310\n*E\n"})
public final class Pmsm extends MainAPI {

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Pmsm$mainUrl$1(null));

    @NotNull
    private String name = "PMSM";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "id";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("trending", "Trending"), TuplesKt.to("movies", "Movies"), TuplesKt.to("tvshows", "TV Shows"), TuplesKt.to("group_movie/indonesia", "Indonesia")});

    /* JADX INFO: renamed from: com.pmsm.Pmsm$getMainPage$1 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm", f = "Pmsm.kt", i = {0, 0}, l = {54}, m = "getMainPage", n = {"request", "page"}, nl = {55}, s = {"L$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pmsm.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Pmsm$load$1 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm", f = "Pmsm.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {78, 107, 120}, m = "load", n = {"url", "url", "document", "rawTitle", "title", "poster", "bgposter", "description", "tags", "actors", "year", "duration", "rating", "trailerId", "trailerUrl", "recommendations", "episodes", "isSeries", "url", "document", "rawTitle", "title", "poster", "bgposter", "description", "tags", "actors", "year", "duration", "rating", "trailerId", "trailerUrl", "recommendations", "isSeries"}, nl = {79, 120, 101}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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
            return Pmsm.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Pmsm$loadLinks$1 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm", f = "Pmsm.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {141, 142}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {142, 170}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pmsm.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Pmsm$search$1 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm", f = "Pmsm.kt", i = {0}, l = {72}, m = "search", n = {"query"}, nl = {73}, s = {"L$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pmsm.this.search(null, (Continuation) this);
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
        C00031 c00031;
        MainPageRequest request2;
        int page2 = page;
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
                String str = getMainUrl() + '/' + request.getData() + "/page/" + page2;
                c00031.L$0 = request;
                c00031.I$0 = page2;
                c00031.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00031, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00031.I$0;
                request2 = (MainPageRequest) c00031.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.item-box");
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
        Iterable $this$distinctBy$iv = (List) destination$iv$iv;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            SearchResponse it2 = (SearchResponse) e$iv;
            if (set$iv.add(it2.getUrl())) {
                list$iv.add(e$iv);
            }
        }
        ArrayList items = list$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), items, (Boolean) null, 4, (Object) null);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        String title = StringsKt.substringBeforeLast$default($this$toSearchResult.select("h3").text(), "(", (String) null, 2, (Object) null);
        Element elementSelectFirst = $this$toSearchResult.selectFirst("img");
        final String posterUrl = elementSelectFirst != null ? elementSelectFirst.attr("src") : null;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.pmsm.Pmsm$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Pmsm.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00091.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 60L, (Interceptor) null, false, (ResponseParser) null, c00091, 3838, (Object) null);
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
        Iterable $this$mapNotNull$iv = document.select("div.item-box");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        Iterable list = (List) destination$iv$iv;
        Iterable $this$distinctBy$iv = list;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            SearchResponse it2 = (SearchResponse) e$iv;
            if (set$iv.add(it2.getUrl())) {
                list$iv.add(e$iv);
            }
        }
        ArrayList $this$distinctBy$iv2 = list$iv;
        return $this$distinctBy$iv2;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0367  */
    /* JADX WARN: Code duplicated, block: B:108:0x036b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0376  */
    /* JADX WARN: Code duplicated, block: B:111:0x0378  */
    /* JADX WARN: Code duplicated, block: B:113:0x037b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0392  */
    /* JADX WARN: Code duplicated, block: B:118:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:120:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:125:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:127:0x0404  */
    /* JADX WARN: Code duplicated, block: B:132:0x0428  */
    /* JADX WARN: Code duplicated, block: B:137:0x0447  */
    /* JADX WARN: Code duplicated, block: B:140:0x0466  */
    /* JADX WARN: Code duplicated, block: B:142:0x047c  */
    /* JADX WARN: Code duplicated, block: B:147:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:152:0x0556 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:153:0x0557  */
    /* JADX WARN: Code duplicated, block: B:155:0x0576  */
    /* JADX WARN: Code duplicated, block: B:157:0x05ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:158:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:164:0x0245 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x02c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x02a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x03ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x0407 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x043b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0422 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x0481 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x04b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x049d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0150  */
    /* JADX WARN: Code duplicated, block: B:27:0x0155  */
    /* JADX WARN: Code duplicated, block: B:30:0x0159  */
    /* JADX WARN: Code duplicated, block: B:31:0x015b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0173  */
    /* JADX WARN: Code duplicated, block: B:37:0x0182  */
    /* JADX WARN: Code duplicated, block: B:38:0x0189  */
    /* JADX WARN: Code duplicated, block: B:44:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:50:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:54:0x01f6 A[LOOP:0: B:52:0x01f0->B:54:0x01f6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x022e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0242  */
    /* JADX WARN: Code duplicated, block: B:65:0x0271 A[LOOP:2: B:63:0x026b->B:65:0x0271, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:76:0x02db  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x0307  */
    /* JADX WARN: Code duplicated, block: B:87:0x031a  */
    /* JADX WARN: Code duplicated, block: B:88:0x031f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0323  */
    /* JADX WARN: Code duplicated, block: B:99:0x0347  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00041 c00041;
        Object obj;
        char c;
        Object obj2;
        String url2;
        Document document;
        boolean isSeries;
        Element elementSelectFirst;
        String string;
        String rawTitle;
        String string2;
        String title;
        Element elementSelectFirst2;
        String strAttr;
        String poster;
        Element elementSelectFirst3;
        String strReplace$default;
        String bgposter;
        Element elementSelectFirst4;
        String description;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        List tags;
        Collection destination$iv$iv3;
        Collection destination$iv$iv4;
        List actors;
        Element elementSelectFirst5;
        String strText;
        Integer year;
        Element elementSelectFirst6;
        Integer duration;
        Element elementSelectFirst7;
        String strText2;
        MatchResult matchResultFind$default;
        Double rating;
        Element elementSelectFirst8;
        String trailerId;
        String trailerUrl;
        Collection destination$iv$iv5;
        String trailerId2;
        Iterable $this$filter$iv;
        Collection destination$iv$iv6;
        HashSet set$iv;
        ArrayList list$iv;
        ArrayList recommendations;
        Document document2;
        boolean isSeries2;
        String rawTitle2;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv7;
        HashSet set$iv2;
        ArrayList list$iv2;
        Episode it;
        Episode episode;
        SearchResponse it2;
        SearchResponse it3;
        SearchResponse searchResult;
        String it4;
        String it5;
        String strAttr2;
        List groupValues;
        String str;
        String strText3;
        String it6;
        String it7;
        String strText4;
        String strAttr3;
        String strText5;
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
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00042.L$0 = url;
                c00042.label = 1;
                c = 1;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00042, 4094, (Object) null);
                c00042 = c00042;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                isSeries = StringsKt.contains$default(url2, "/tvshows/", false, 2, (Object) null);
                elementSelectFirst = document.selectFirst("div.details-title h3");
                if (elementSelectFirst != null || (strText5 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText5).toString();
                }
                if (string == null) {
                    string = "";
                }
                rawTitle = string;
                if (isSeries) {
                    title = rawTitle;
                } else {
                    string2 = StringsKt.trim(StringsKt.substringBeforeLast$default(rawTitle, "(", (String) null, 2, (Object) null)).toString();
                    if (StringsKt.isBlank(string2)) {
                        string2 = rawTitle;
                    }
                    title = string2;
                }
                Pmsm pmsm = this;
                elementSelectFirst2 = document.selectFirst("div.content-poster img");
                if (elementSelectFirst2 != null) {
                    strAttr = elementSelectFirst2.attr("src");
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(pmsm, strAttr);
                Pmsm pmsm2 = this;
                elementSelectFirst3 = document.selectFirst("meta[property=og:image]");
                if (elementSelectFirst3 != null || (strAttr3 = elementSelectFirst3.attr("content")) == null) {
                    strReplace$default = null;
                } else {
                    strReplace$default = StringsKt.replace$default(strAttr3, "w780", "original", false, 4, (Object) null);
                }
                bgposter = MainAPIKt.fixUrlNull(pmsm2, strReplace$default);
                elementSelectFirst4 = document.selectFirst("div.details-desc p");
                if (elementSelectFirst4 != null || (strText4 = elementSelectFirst4.text()) == null) {
                    description = null;
                } else {
                    description = StringsKt.trim(strText4).toString();
                }
                Iterable $this$map$iv = document.select("div.details-genre a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it8 = (Element) item$iv$iv;
                    destination$iv$iv.add(StringsKt.trim(it8.text()).toString());
                }
                Iterable $this$filter$iv2 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv2) {
                    it7 = (String) element$iv$iv;
                    if (!StringsKt.isBlank(it7)) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                tags = (List) destination$iv$iv2;
                Iterable $this$map$iv2 = document.select("div.details-info p:contains(Stars) a");
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    Element it9 = (Element) item$iv$iv2;
                    destination$iv$iv3.add(StringsKt.trim(it9.text()).toString());
                    $result = $result;
                }
                Iterable $this$filter$iv3 = (List) destination$iv$iv3;
                destination$iv$iv4 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv3) {
                    it6 = (String) element$iv$iv2;
                    if (!StringsKt.isBlank(it6)) {
                        destination$iv$iv4.add(element$iv$iv2);
                    }
                }
                actors = (List) destination$iv$iv4;
                elementSelectFirst5 = document.selectFirst("div.details-info p:contains(Year)");
                if (elementSelectFirst5 != null || (strText = elementSelectFirst5.text()) == null) {
                    strText = rawTitle;
                }
                year = extractYear(strText);
                elementSelectFirst6 = document.selectFirst("span[itemprop=duration]");
                if (elementSelectFirst6 != null || (strText3 = elementSelectFirst6.text()) == null) {
                    duration = null;
                } else {
                    String strReplace = new Regex("\\D").replace(strText3, "");
                    if (strReplace != null) {
                        duration = StringsKt.toIntOrNull(strReplace);
                    } else {
                        duration = null;
                    }
                }
                Regex regex = new Regex("(\\d+(\\.\\d+)?)");
                elementSelectFirst7 = document.selectFirst("span.data-imdb");
                if (elementSelectFirst7 != null) {
                    strText2 = elementSelectFirst7.text();
                } else {
                    strText2 = null;
                }
                matchResultFind$default = Regex.find$default(regex, strText2 != null ? strText2 : "", 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.firstOrNull(groupValues)) == null) {
                    rating = null;
                } else {
                    rating = StringsKt.toDoubleOrNull(str);
                }
                elementSelectFirst8 = document.selectFirst("span.data-trailer[data-tid], a.btn-trailer[data-tid]");
                if (elementSelectFirst8 != null || (strAttr2 = elementSelectFirst8.attr("data-tid")) == null) {
                    trailerId = null;
                } else {
                    trailerId = StringsKt.trim(strAttr2).toString();
                }
                if (trailerId != null) {
                    it4 = trailerId;
                    if (StringsKt.isBlank(it4)) {
                        it5 = null;
                    } else {
                        it5 = trailerId;
                    }
                    if (it5 != null) {
                        trailerUrl = "https://www.youtube.com/watch?v=" + it5;
                    } else {
                        trailerUrl = null;
                    }
                } else {
                    trailerUrl = null;
                }
                Iterable $this$mapNotNull$iv2 = document.select("div.module-item");
                destination$iv$iv5 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                    String trailerId3 = trailerId;
                    Element it10 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it10);
                    if (searchResult != null) {
                        destination$iv$iv5.add(searchResult);
                    }
                    trailerId = trailerId3;
                }
                trailerId2 = trailerId;
                $this$filter$iv = (List) destination$iv$iv5;
                destination$iv$iv6 = new ArrayList();
                for (Object element$iv$iv3 : $this$filter$iv) {
                    it3 = (SearchResponse) element$iv$iv3;
                    Iterable $this$filter$iv4 = $this$filter$iv;
                    if (!Intrinsics.areEqual(it3.getUrl(), url2)) {
                        destination$iv$iv6.add(element$iv$iv3);
                    }
                    $this$filter$iv = $this$filter$iv4;
                }
                Iterable $this$distinctBy$iv = (List) destination$iv$iv6;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                for (Object e$iv : $this$distinctBy$iv) {
                    it2 = (SearchResponse) e$iv;
                    if (set$iv.add(it2.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                recommendations = list$iv;
                if (isSeries) {
                    String title2 = title;
                    TvType tvType = TvType.Movie;
                    C00063 c00063 = new C00063(poster, bgposter, description, tags, year, recommendations, duration, rating, actors, trailerUrl, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(bgposter);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(tags);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(actors);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(duration);
                    c00042.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                    c00042.L$12 = SpillingKt.nullOutSpilledVariable(trailerId2);
                    c00042.L$13 = SpillingKt.nullOutSpilledVariable(trailerUrl);
                    c00042.L$14 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00042.Z$0 = isSeries;
                    c00042.label = 3;
                    $result = MainAPIKt.newMovieLoadResponse(this, title2, url2, tvType, url2, c00063, c00042);
                    if ($result == obj) {
                        return obj;
                    }
                    document2 = document;
                    isSeries2 = isSeries;
                    rawTitle2 = rawTitle;
                    return (LoadResponse) $result;
                }
                $this$mapNotNull$iv = document.select("div.content-episodes ul.episodes-list li");
                destination$iv$iv7 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it11 = (Element) element$iv$iv$iv2;
                    episode = toEpisode(it11);
                    if (episode != null) {
                        destination$iv$iv7.add(episode);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                }
                Iterable $this$distinctBy$iv2 = (List) destination$iv$iv7;
                set$iv2 = new HashSet();
                list$iv2 = new ArrayList();
                for (Object e$iv2 : $this$distinctBy$iv2) {
                    it = (Episode) e$iv2;
                    if (set$iv2.add(it.getData())) {
                        list$iv2.add(e$iv2);
                    }
                }
                ArrayList $this$distinctBy$iv3 = list$iv2;
                Function1[] function1Arr = new Function1[2];
                function1Arr[0] = new Function1() { // from class: com.pmsm.Pmsm$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        return Pmsm.load$lambda$12((Episode) obj3);
                    }
                };
                function1Arr[c] = new Function1() { // from class: com.pmsm.Pmsm$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj3) {
                        return Pmsm.load$lambda$13((Episode) obj3);
                    }
                };
                List episodes = CollectionsKt.sortedWith($this$distinctBy$iv3, ComparisonsKt.compareBy(function1Arr));
                String title3 = title;
                TvType tvType2 = TvType.TvSeries;
                C00052 c00052 = new C00052(poster, bgposter, description, tags, year, recommendations, duration, rating, actors, trailerUrl, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(title3);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(bgposter);
                c00042.L$6 = SpillingKt.nullOutSpilledVariable(description);
                c00042.L$7 = SpillingKt.nullOutSpilledVariable(tags);
                c00042.L$8 = SpillingKt.nullOutSpilledVariable(actors);
                c00042.L$9 = SpillingKt.nullOutSpilledVariable(year);
                c00042.L$10 = SpillingKt.nullOutSpilledVariable(duration);
                c00042.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                c00042.L$12 = SpillingKt.nullOutSpilledVariable(trailerId2);
                c00042.L$13 = SpillingKt.nullOutSpilledVariable(trailerUrl);
                c00042.L$14 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00042.L$15 = SpillingKt.nullOutSpilledVariable(episodes);
                c00042.Z$0 = isSeries;
                c00042.label = 2;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title3, url2, tvType2, episodes, c00052, c00042);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 1:
                String url3 = (String) c00042.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url3;
                obj = coroutine_suspended;
                c = 1;
                obj2 = $result;
                document = ((NiceResponse) obj2).getDocument();
                isSeries = StringsKt.contains$default(url2, "/tvshows/", false, 2, (Object) null);
                elementSelectFirst = document.selectFirst("div.details-title h3");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                if (string == null) {
                    string = "";
                }
                rawTitle = string;
                if (isSeries) {
                    title = rawTitle;
                } else {
                    string2 = StringsKt.trim(StringsKt.substringBeforeLast$default(rawTitle, "(", (String) null, 2, (Object) null)).toString();
                    if (StringsKt.isBlank(string2)) {
                        string2 = rawTitle;
                    }
                    title = string2;
                }
                Pmsm pmsm3 = this;
                elementSelectFirst2 = document.selectFirst("div.content-poster img");
                if (elementSelectFirst2 != null) {
                    strAttr = elementSelectFirst2.attr("src");
                } else {
                    strAttr = null;
                }
                poster = MainAPIKt.fixUrlNull(pmsm3, strAttr);
                Pmsm pmsm4 = this;
                elementSelectFirst3 = document.selectFirst("meta[property=og:image]");
                if (elementSelectFirst3 != null) {
                    strReplace$default = null;
                } else {
                    strReplace$default = null;
                }
                bgposter = MainAPIKt.fixUrlNull(pmsm4, strReplace$default);
                elementSelectFirst4 = document.selectFirst("div.details-desc p");
                if (elementSelectFirst4 != null) {
                    description = null;
                } else {
                    description = null;
                }
                Iterable $this$map$iv3 = document.select("div.details-genre a");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r18.hasNext()) {
                    Element it12 = (Element) item$iv$iv;
                    destination$iv$iv.add(StringsKt.trim(it12.text()).toString());
                }
                Iterable $this$filter$iv5 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                while (r17.hasNext()) {
                    it7 = (String) element$iv$iv;
                    if (!StringsKt.isBlank(it7)) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                tags = (List) destination$iv$iv2;
                Iterable $this$map$iv4 = document.select("div.details-info p:contains(Stars) a");
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r15.hasNext()) {
                    Element it13 = (Element) item$iv$iv2;
                    destination$iv$iv3.add(StringsKt.trim(it13.text()).toString());
                    $result = $result;
                }
                Iterable $this$filter$iv6 = (List) destination$iv$iv3;
                destination$iv$iv4 = new ArrayList();
                while (r14.hasNext()) {
                    it6 = (String) element$iv$iv2;
                    if (!StringsKt.isBlank(it6)) {
                        destination$iv$iv4.add(element$iv$iv2);
                    }
                }
                actors = (List) destination$iv$iv4;
                elementSelectFirst5 = document.selectFirst("div.details-info p:contains(Year)");
                if (elementSelectFirst5 != null) {
                    strText = rawTitle;
                } else {
                    strText = rawTitle;
                }
                year = extractYear(strText);
                elementSelectFirst6 = document.selectFirst("span[itemprop=duration]");
                if (elementSelectFirst6 != null) {
                    duration = null;
                } else {
                    duration = null;
                }
                Regex regex2 = new Regex("(\\d+(\\.\\d+)?)");
                elementSelectFirst7 = document.selectFirst("span.data-imdb");
                if (elementSelectFirst7 != null) {
                    strText2 = elementSelectFirst7.text();
                } else {
                    strText2 = null;
                }
                matchResultFind$default = Regex.find$default(regex2, strText2 != null ? strText2 : "", 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    rating = null;
                } else {
                    rating = null;
                }
                elementSelectFirst8 = document.selectFirst("span.data-trailer[data-tid], a.btn-trailer[data-tid]");
                if (elementSelectFirst8 != null) {
                    trailerId = null;
                } else {
                    trailerId = null;
                }
                if (trailerId != null) {
                    it4 = trailerId;
                    if (StringsKt.isBlank(it4)) {
                        it5 = trailerId;
                    } else {
                        it5 = null;
                    }
                    if (it5 != null) {
                        trailerUrl = "https://www.youtube.com/watch?v=" + it5;
                    } else {
                        trailerUrl = null;
                    }
                } else {
                    trailerUrl = null;
                }
                Iterable $this$mapNotNull$iv4 = document.select("div.module-item");
                destination$iv$iv5 = new ArrayList();
                while (r17.hasNext()) {
                    String trailerId4 = trailerId;
                    Element it14 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it14);
                    if (searchResult != null) {
                        destination$iv$iv5.add(searchResult);
                    }
                    trailerId = trailerId4;
                }
                trailerId2 = trailerId;
                $this$filter$iv = (List) destination$iv$iv5;
                destination$iv$iv6 = new ArrayList();
                while (r13.hasNext()) {
                    it3 = (SearchResponse) element$iv$iv3;
                    Iterable $this$filter$iv7 = $this$filter$iv;
                    if (!Intrinsics.areEqual(it3.getUrl(), url2)) {
                        destination$iv$iv6.add(element$iv$iv3);
                    }
                    $this$filter$iv = $this$filter$iv7;
                }
                Iterable $this$distinctBy$iv4 = (List) destination$iv$iv6;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r8.hasNext()) {
                    it2 = (SearchResponse) e$iv;
                    if (set$iv.add(it2.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                recommendations = list$iv;
                if (isSeries) {
                    String title4 = title;
                    TvType tvType3 = TvType.Movie;
                    C00063 c00064 = new C00063(poster, bgposter, description, tags, year, recommendations, duration, rating, actors, trailerUrl, null);
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(bgposter);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00042.L$7 = SpillingKt.nullOutSpilledVariable(tags);
                    c00042.L$8 = SpillingKt.nullOutSpilledVariable(actors);
                    c00042.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00042.L$10 = SpillingKt.nullOutSpilledVariable(duration);
                    c00042.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                    c00042.L$12 = SpillingKt.nullOutSpilledVariable(trailerId2);
                    c00042.L$13 = SpillingKt.nullOutSpilledVariable(trailerUrl);
                    c00042.L$14 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00042.Z$0 = isSeries;
                    c00042.label = 3;
                    $result = MainAPIKt.newMovieLoadResponse(this, title4, url2, tvType3, url2, c00064, c00042);
                    if ($result == obj) {
                        return obj;
                    }
                    document2 = document;
                    isSeries2 = isSeries;
                    rawTitle2 = rawTitle;
                    return (LoadResponse) $result;
                }
                $this$mapNotNull$iv = document.select("div.content-episodes ul.episodes-list li");
                destination$iv$iv7 = new ArrayList();
                while (r15.hasNext()) {
                    Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                    Element it15 = (Element) element$iv$iv$iv2;
                    episode = toEpisode(it15);
                    if (episode != null) {
                        destination$iv$iv7.add(episode);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv5;
                }
                Iterable $this$distinctBy$iv5 = (List) destination$iv$iv7;
                set$iv2 = new HashSet();
                list$iv2 = new ArrayList();
                while (r8.hasNext()) {
                    it = (Episode) e$iv2;
                    if (set$iv2.add(it.getData())) {
                        list$iv2.add(e$iv2);
                    }
                }
                ArrayList $this$distinctBy$iv6 = list$iv2;
                Function1[] function1Arr2 = new Function1[2];
                function1Arr2[0] = new Function1() { // from class: com.pmsm.Pmsm$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj3) {
                        return Pmsm.load$lambda$12((Episode) obj3);
                    }
                };
                function1Arr2[c] = new Function1() { // from class: com.pmsm.Pmsm$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj3) {
                        return Pmsm.load$lambda$13((Episode) obj3);
                    }
                };
                List episodes2 = CollectionsKt.sortedWith($this$distinctBy$iv6, ComparisonsKt.compareBy(function1Arr2));
                String title5 = title;
                TvType tvType4 = TvType.TvSeries;
                C00052 c00053 = new C00052(poster, bgposter, description, tags, year, recommendations, duration, rating, actors, trailerUrl, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(title5);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(poster);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(bgposter);
                c00042.L$6 = SpillingKt.nullOutSpilledVariable(description);
                c00042.L$7 = SpillingKt.nullOutSpilledVariable(tags);
                c00042.L$8 = SpillingKt.nullOutSpilledVariable(actors);
                c00042.L$9 = SpillingKt.nullOutSpilledVariable(year);
                c00042.L$10 = SpillingKt.nullOutSpilledVariable(duration);
                c00042.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                c00042.L$12 = SpillingKt.nullOutSpilledVariable(trailerId2);
                c00042.L$13 = SpillingKt.nullOutSpilledVariable(trailerUrl);
                c00042.L$14 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00042.L$15 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00042.Z$0 = isSeries;
                c00042.label = 2;
                $result = MainAPIKt.newTvSeriesLoadResponse(this, title5, url2, tvType4, episodes2, c00053, c00042);
                if ($result == obj) {
                    return obj;
                }
                return (LoadResponse) $result;
            case 2:
                boolean z = c00042.Z$0;
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            case 3:
                isSeries2 = c00042.Z$0;
                rawTitle2 = (String) c00042.L$2;
                document2 = (Document) c00042.L$1;
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Comparable load$lambda$12(Episode it) {
        int season = it.getSeason();
        if (season == null) {
            season = 0;
        }
        return season;
    }

    static final Comparable load$lambda$13(Episode it) {
        int episode = it.getEpisode();
        if (episode == null) {
            episode = 0;
        }
        return episode;
    }

    /* JADX INFO: renamed from: com.pmsm.Pmsm$load$2 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm$load$2", f = "Pmsm.kt", i = {0}, l = {117}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {118}, s = {"L$0"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $bgposter;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $duration;
        final /* synthetic */ String $poster;
        final /* synthetic */ Double $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailerUrl;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(String str, String str2, String str3, List<String> list, Integer num, List<? extends SearchResponse> list2, Integer num2, Double d, List<String> list3, String str4, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgposter = str2;
            this.$description = str3;
            this.$tags = list;
            this.$year = num;
            this.$recommendations = list2;
            this.$duration = num2;
            this.$rating = d;
            this.$actors = list3;
            this.$trailerUrl = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$poster, this.$bgposter, this.$description, this.$tags, this.$year, this.$recommendations, this.$duration, this.$rating, this.$actors, this.$trailerUrl, continuation);
            c00052.L$0 = obj;
            return c00052;
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
                    loadResponse.setBackgroundPosterUrl(this.$bgposter);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setYear(this.$year);
                    loadResponse.setRecommendations(this.$recommendations);
                    if (this.$duration != null) {
                        loadResponse.setDuration(this.$duration);
                    }
                    if (this.$rating != null) {
                        LoadResponse.Companion.addScore(loadResponse, String.valueOf(this.$rating.doubleValue()), 10);
                    }
                    LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailerUrl, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Pmsm$load$3 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm$load$3", f = "Pmsm.kt", i = {0}, l = {130}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {131}, s = {"L$0"}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $bgposter;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $duration;
        final /* synthetic */ String $poster;
        final /* synthetic */ Double $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailerUrl;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00063(String str, String str2, String str3, List<String> list, Integer num, List<? extends SearchResponse> list2, Integer num2, Double d, List<String> list3, String str4, Continuation<? super C00063> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgposter = str2;
            this.$description = str3;
            this.$tags = list;
            this.$year = num;
            this.$recommendations = list2;
            this.$duration = num2;
            this.$rating = d;
            this.$actors = list3;
            this.$trailerUrl = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = new C00063(this.$poster, this.$bgposter, this.$description, this.$tags, this.$year, this.$recommendations, this.$duration, this.$rating, this.$actors, this.$trailerUrl, continuation);
            c00063.L$0 = obj;
            return c00063;
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
                    loadResponse.setBackgroundPosterUrl(this.$bgposter);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setYear(this.$year);
                    loadResponse.setRecommendations(this.$recommendations);
                    if (this.$duration != null) {
                        loadResponse.setDuration(this.$duration);
                    }
                    if (this.$rating != null) {
                        LoadResponse.Companion.addScore(loadResponse, String.valueOf(this.$rating.doubleValue()), 10);
                    }
                    LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailerUrl, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00071 c00071;
        Pmsm pmsm;
        Object obj;
        boolean z;
        C00071 c00072;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        String data2;
        List listSelect;
        C00082 c00082;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
                pmsm = this;
            } else {
                pmsm = this;
                c00071 = pmsm.new C00071(continuation);
            }
        } else {
            pmsm = this;
            c00071 = pmsm.new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00071.L$0 = data;
                c00071.L$1 = function1;
                c00071.L$2 = function2;
                c00071.Z$0 = isCasting;
                c00071.label = 1;
                C00071 c00073 = c00071;
                obj = coroutine_suspended;
                z = true;
                Object obj3 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00073, 4094, (Object) null);
                c00072 = c00073;
                if (obj3 == obj) {
                    return obj;
                }
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                obj2 = obj3;
                data2 = data;
                Document document = ((NiceResponse) obj2).getDocument();
                listSelect = document.select("#playeroptionsul > li");
                c00082 = pmsm.new C00082(data2, function3, function4, null);
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00072.Z$0 = isCasting2;
                c00072.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00082, c00072) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00071.Z$0;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00071.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00071.L$1;
                String data3 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                c00072 = c00071;
                obj = coroutine_suspended;
                data2 = data3;
                isCasting2 = isCasting3;
                function3 = function6;
                function4 = function5;
                z = true;
                obj2 = $result;
                Document document2 = ((NiceResponse) obj2).getDocument();
                listSelect = document2.select("#playeroptionsul > li");
                c00082 = pmsm.new C00082(data2, function3, function4, null);
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00072.Z$0 = isCasting2;
                c00072.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00082, c00072) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00071.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.pmsm.Pmsm$loadLinks$2 */
    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "li", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.pmsm.Pmsm$loadLinks$2", f = "Pmsm.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {147, 162, 166}, m = "invokeSuspend", n = {"li", "post", "nume", "type", "li", "post", "nume", "type", "res", "link", "li", "post", "nume", "type", "res", "link"}, nl = {157, 166, 168}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nPmsm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pmsm.kt\ncom/pmsm/Pmsm$loadLinks$2\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,214:1\n73#2,5:215\n*S KotlinDebug\n*F\n+ 1 Pmsm.kt\ncom/pmsm/Pmsm$loadLinks$2\n*L\n157#1:215,5\n*E\n"})
    static final class C00082 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = Pmsm.this.new C00082(this.$data, this.$subtitleCallback, this.$callback, continuation);
            c00082.L$0 = obj;
            return c00082;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String nume;
            String post;
            String post2;
            Object obj;
            Object safe;
            ZetaPlayerResponse zetaPlayerResponse;
            String res;
            String link;
            Element li = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String post3 = StringsKt.trim(li.attr("data-post")).toString();
                    nume = StringsKt.trim(li.attr("data-nume")).toString();
                    post = StringsKt.trim(li.attr("data-type")).toString();
                    Requests app = MainActivityKt.getApp();
                    String str = Pmsm.this.getMainUrl() + "/wp-admin/admin-ajax.php";
                    Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("action", "zeta_player_ajax"), TuplesKt.to("post", post3), TuplesKt.to("nume", nume), TuplesKt.to("type", post)});
                    this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(post3);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(nume);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(post);
                    this.label = 1;
                    Object objPost$default = Requests.post$default(app, str, MapsKt.mapOf(TuplesKt.to("X-Requested-With", "XMLHttpRequest")), this.$data, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65496, (Object) null);
                    if (objPost$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    post2 = post3;
                    obj = objPost$default;
                    NiceResponse this_$iv = (NiceResponse) obj;
                    try {
                        ResponseParser parser = this_$iv.getParser();
                        Intrinsics.checkNotNull(parser);
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ZetaPlayerResponse.class));
                        break;
                    } catch (Exception e$iv) {
                        e$iv.printStackTrace();
                        safe = null;
                    }
                    zetaPlayerResponse = (ZetaPlayerResponse) safe;
                    if (zetaPlayerResponse != null || (res = zetaPlayerResponse.getEmbedUrl()) == null) {
                        return Unit.INSTANCE;
                    }
                    Element elementSelectFirst = Jsoup.parse(res).selectFirst("iframe");
                    if (elementSelectFirst == null || (link = elementSelectFirst.attr("src")) == null) {
                        return Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(link, "/#", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(post2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(nume);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(post);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(res);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(link);
                        this.label = 2;
                        if (new VidStack().getUrl(link, "", this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(li);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(post2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(nume);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(post);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(res);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(link);
                        this.label = 3;
                        if (ExtractorApiKt.loadExtractor(link, Pmsm.this.getMainUrl(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    String type = (String) this.L$3;
                    nume = (String) this.L$2;
                    String post4 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    post2 = post4;
                    post = type;
                    obj = $result;
                    NiceResponse this_$iv2 = (NiceResponse) obj;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ZetaPlayerResponse.class));
                    zetaPlayerResponse = (ZetaPlayerResponse) safe;
                    if (zetaPlayerResponse != null) {
                        break;
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final Episode toEpisode(Element $this$toEpisode) {
        final Date date;
        String str;
        String strId;
        String strSubstringAfter;
        List groupValues;
        String it;
        Object obj;
        String it2;
        String strText;
        String strText2;
        String string;
        Element anchor = $this$toEpisode.selectFirst("a[href]");
        Integer parentSeason = null;
        if (anchor == null) {
            return null;
        }
        String href = MainAPIKt.fixUrl(this, anchor.attr("href"));
        Element elementSelectFirst = $this$toEpisode.selectFirst("span.ep-num");
        final Integer epNum = (elementSelectFirst == null || (strText2 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText2).toString()) == null) ? null : StringsKt.toIntOrNull(string);
        Element elementSelectFirst2 = $this$toEpisode.selectFirst("span.ep-title");
        final String title = (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null) ? null : StringsKt.trim(strText).toString();
        Element elementSelectFirst3 = $this$toEpisode.selectFirst("span.ep-thumb img");
        final String poster = (elementSelectFirst3 == null || (it2 = elementSelectFirst3.attr("src")) == null) ? null : MainAPIKt.fixUrlNull(this, it2);
        Element elementSelectFirst4 = $this$toEpisode.selectFirst("span.ep-date");
        String rawDate = elementSelectFirst4 != null ? elementSelectFirst4.text() : null;
        if (rawDate == null || (it = StringsKt.replace$default(rawDate, ".", "", false, 4, (Object) null)) == null) {
            date = null;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).parse(it));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            date = (Date) obj;
        }
        Iterator it3 = $this$toEpisode.classNames().iterator();
        do {
            if (!it3.hasNext()) {
                str = null;
                break;
            }
            String it4 = (String) it3.next();
            MatchResult matchResultFind$default = Regex.find$default(new Regex("ep-(\\d+)-\\d+"), it4, 0, 2, (Object) null);
            str = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
        } while (str == null);
        Integer classSeason = str != null ? StringsKt.toIntOrNull(str) : null;
        Element elementParent = $this$toEpisode.parent();
        if (elementParent != null && (strId = elementParent.id()) != null && (strSubstringAfter = StringsKt.substringAfter(strId, "season-listep-", "")) != null) {
            parentSeason = StringsKt.toIntOrNull(strSubstringAfter);
        }
        final Integer season = classSeason == null ? parentSeason : classSeason;
        return MainAPIKt.newEpisode(this, href, new Function1() { // from class: com.pmsm.Pmsm$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                return Pmsm.toEpisode$lambda$3(title, poster, epNum, season, date, (Episode) obj2);
            }
        });
    }

    static final Unit toEpisode$lambda$3(String $title, String $poster, Integer $epNum, Integer $season, Date $date, Episode $this$newEpisode) {
        $this$newEpisode.setName($title);
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setEpisode($epNum);
        $this$newEpisode.setSeason($season);
        MainAPIKt.addDate($this$newEpisode, $date);
        return Unit.INSTANCE;
    }

    private final Integer extractYear(String text) {
        String value;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(19|20)\\d{2}"), text == null ? "" : text, 0, 2, (Object) null);
        if (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) {
            return null;
        }
        return StringsKt.toIntOrNull(value);
    }

    /* JADX INFO: compiled from: Pmsm.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/pmsm/Pmsm$ZetaPlayerResponse;", "", "embedUrl", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "embed_url", "type", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmbedUrl", "()Ljava/lang/String;", "getType", "getMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Pmsm"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class ZetaPlayerResponse {

        @Nullable
        private final String embedUrl;

        @Nullable
        private final String msg;

        @Nullable
        private final String type;

        public ZetaPlayerResponse() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ZetaPlayerResponse copy$default(ZetaPlayerResponse zetaPlayerResponse, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = zetaPlayerResponse.embedUrl;
            }
            if ((i & 2) != 0) {
                str2 = zetaPlayerResponse.type;
            }
            if ((i & 4) != 0) {
                str3 = zetaPlayerResponse.msg;
            }
            return zetaPlayerResponse.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmbedUrl() {
            return this.embedUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final ZetaPlayerResponse copy(@JsonProperty("embed_url") @Nullable String embedUrl, @JsonProperty("type") @Nullable String type, @JsonProperty("msg") @Nullable String msg) {
            return new ZetaPlayerResponse(embedUrl, type, msg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZetaPlayerResponse)) {
                return false;
            }
            ZetaPlayerResponse zetaPlayerResponse = (ZetaPlayerResponse) other;
            return Intrinsics.areEqual(this.embedUrl, zetaPlayerResponse.embedUrl) && Intrinsics.areEqual(this.type, zetaPlayerResponse.type) && Intrinsics.areEqual(this.msg, zetaPlayerResponse.msg);
        }

        public int hashCode() {
            return ((((this.embedUrl == null ? 0 : this.embedUrl.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.msg != null ? this.msg.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ZetaPlayerResponse(embedUrl=" + this.embedUrl + ", type=" + this.type + ", msg=" + this.msg + ')';
        }

        public ZetaPlayerResponse(@JsonProperty("embed_url") @Nullable String embedUrl, @JsonProperty("type") @Nullable String type, @JsonProperty("msg") @Nullable String msg) {
            this.embedUrl = embedUrl;
            this.type = type;
            this.msg = msg;
        }

        public /* synthetic */ ZetaPlayerResponse(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getEmbedUrl() {
            return this.embedUrl;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }
    }
}
